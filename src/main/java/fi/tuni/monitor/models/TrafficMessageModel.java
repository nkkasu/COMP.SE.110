package fi.tuni.monitor.models;

import fi.tuni.monitor.data.AsyncDataFetch;
import fi.tuni.monitor.data.BoundingCoordinates;
import fi.tuni.monitor.data.TrafficMessage;
import fi.tuni.monitor.roadapi.ApiException;
import fi.tuni.monitor.roadapi.TrafficMessageFetcher;
import fi.tuni.monitor.saveddata.MonitorConfig;
import fi.tuni.monitor.saveddata.SerializationUtil;
import fi.tuni.monitor.saveddata.TrafficMessageDataset;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.StringConverter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Model for handling traffic message related visualization data and operations<br>
 * Apart of the MVC pattern
 */
public class TrafficMessageModel implements AsyncDataFetch
{
    private static final String saveFolder = MonitorConfig.getTrafficMessageDatasetsFolder();
    private List<TrafficMessage> trafficMessages = new ArrayList<>();
    private int inactiveHours;
    private LocalDateTime lastFetchTime;
    private final TrafficMessageTreeView trafficMessageTreeView;
    private CompletableFuture<Void> isDataFetchComplete = null;

    /**
     * Constructor for TrafficMessageModel
     * @param treeView TreeView for displaying traffic messages
     */
    public TrafficMessageModel(TreeView<?> treeView)
    {
        this.trafficMessageTreeView = new TrafficMessageTreeView(treeView);
    }

    /**
     * Fetches traffic messages from the API and updates the TreeView
     * @param extent Bounding coordinates for the area to fetch data from
     * @param inactiveHours How many hours of inactivity to allow before a traffic message is considered inactive
     */
    public void setTrafficMessages(BoundingCoordinates extent, int inactiveHours)
    {
        this.isDataFetchComplete = CompletableFuture.runAsync(() -> {
            try {
                trafficMessages = new TrafficMessageFetcher().getTrafficMessages(extent, inactiveHours);
                lastFetchTime = LocalDateTime.now();
            } catch (ApiException e) {
                System.err.println(e.toString());
            }
        });

        try {
            this.isDataFetchComplete.get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e.toString());
        }

        trafficMessageTreeView.setTrafficMessages(trafficMessages);
    }

    /**
     * Creates a new TrafficMessageDataset and saves it to disk
     * @param currentDatasets List of currently saved TrafficMessageDatasets, used to dedupe
     * @return The newly created TrafficMessageDataset
     */
    public TrafficMessageDataset saveTrafficMessageDataset(ObservableList<TrafficMessageDataset> currentDatasets)
    {
        var dataset = new TrafficMessageDataset(trafficMessages, lastFetchTime, inactiveHours);
        if (currentDatasets.contains(dataset))
            return null;

        try {
            SerializationUtil.serializeToFolder(dataset, saveFolder);
        } catch (Exception e) {
            System.err.println("Error saving traffic message dataset!");
        }
        return dataset;
    }

    /**
     * Gets saved TrafficMessageDatasets from disk
     * @return List of saved TrafficMessageDatasets
     */
    public List<TrafficMessageDataset> getSavedTrafficMessageDatasets()
    {
        List<TrafficMessageDataset> datasets = null;
        try
        {
            datasets = (List<TrafficMessageDataset>) SerializationUtil.deserializeAllFromFolder(saveFolder);
        }
        catch (Exception e)
        {
            System.err.println("Error loading traffic message datasets!");
        }

        return datasets;
    }

    /**
     * Loads the specified TrafficMessageDatasets into the TreeView
     * @param datasets List of TrafficMessageDatasets to load
     */
    public void loadTrafficMessageDatasets(List<TrafficMessageDataset> datasets)
    {
        trafficMessageTreeView.setSavedDatasets(datasets);
    }

    /**
     * Removes the specified TrafficMessageDatases from the TreeView
     * @param datasets List of TrafficMessageDatasets to remove
     */
    public void removeTrafficMessageDatasets(List<TrafficMessageDataset> datasets)
    {
        trafficMessageTreeView.removeSavedDatasets(datasets);
    }

    public void setInactiveHours(int inactiveHours)
    {
        this.inactiveHours = inactiveHours;
    }

    public CompletableFuture<Void> getIsDataFetchComplete() {
        return this.isDataFetchComplete;
    }

    /**
     * Inner class for handling the TreeView for displaying traffic messages
     */
    private static class TrafficMessageTreeView
    {
        private final TreeItem rootItem;

        private final Set<TrafficMessageDataset> savedDatasets = new HashSet<>();

        /**
         * Constructor for TrafficMessageTreeView
         * @param treeView TreeView to handle
         */
        public TrafficMessageTreeView(TreeView treeView)
        {
            // hidden root item under which all other items are placed
            rootItem = new TreeItem<>();
            rootItem.setExpanded(true);
            treeView.setShowRoot(false);
            treeView.setRoot(rootItem);

            // custom cell factory for editing the name of saved datasets
            treeView.setCellFactory(x -> new TextFieldTreeCell<>(new StringConverter<>() {
                @Override
                public String toString(Object o)
                {
                    if (o instanceof TrafficMessageDataset dataset)
                        return dataset.getTreeTitle();
                    else
                        return o.toString();
                }

                @Override
                public Object fromString(String s) { return null; }
            }));
        }

        /**
         * Sets the traffic messages to display in the TreeView
         * @param trafficMessages List of traffic messages to display
         */
        private void setTrafficMessages(List<TrafficMessage> trafficMessages)
        {
            var parentItem = new TreeItem<>(String.format("Current Messages (count: %d)", trafficMessages.size()));
            parentItem.setExpanded(true);

            setTrafficMessagesToTree(trafficMessages, parentItem);
            rootItem.getChildren().removeIf(x -> ((TreeItem)x).getValue().toString().startsWith("Current")); // remove old current messages
            rootItem.getChildren().add(0, parentItem); // add to top of tree
        }

        /**
         * Sets the saved datasets to display in the TreeView
         * @param datasets List of saved datasets to display
         */
        private void setSavedDatasets(List<TrafficMessageDataset> datasets)
        {
            for (var dataset : datasets)
            {
                if (savedDatasets.contains(dataset))
                    continue;

                savedDatasets.add(dataset);
                var parentItem = new SavedDataTreeItem(dataset);
                rootItem.getChildren().add(parentItem);
            }
        }

        /**
         * Removes the specified saved datasets from the TreeView
         * @param datasets List of saved datasets to remove
         */
        public void removeSavedDatasets(List<TrafficMessageDataset> datasets)
        {
            for (var dataset : datasets)
            {
                if (!savedDatasets.contains(dataset))
                    continue;

                savedDatasets.remove(dataset);
                rootItem.getChildren().removeIf(x -> x instanceof SavedDataTreeItem item && item.getValue() == dataset);
            }
        }

        /**
         * Custom TreeItem implementation for storing saved datasets<br>
         * Extends TreeItem
         */
        private static class SavedDataTreeItem extends TreeItem
        {
            /**
             * Constructor for SavedDataTreeItem
             * @param dataset TrafficMessageDataset to display
             */
            public SavedDataTreeItem(TrafficMessageDataset dataset)
            {
                super(dataset);
                setTrafficMessagesToTree(dataset.trafficMessages(), this);
            }
        }

        /**
         * Sets the specified traffic messages to the specified TreeItem
         * @param trafficMessages List of traffic messages to display
         * @param parentItem TreeItem to display the traffic messages under
         */
        private static void setTrafficMessagesToTree(List<TrafficMessage> trafficMessages, TreeItem<String> parentItem)
        {
            //group traffic messages by situationType
            trafficMessages.stream().collect(Collectors.groupingBy(TrafficMessage::situationType)).forEach((situationType, messages) -> {
                // add situationType as a sub-category
                var situationTypeItem = new TreeItem<>(situationType);
                situationTypeItem.setExpanded(false);
                parentItem.getChildren().add(situationTypeItem);
                messages.forEach(msg -> {
                    // add all messages under the situationType
                    var trafficMessageItem = new TreeItem<>(msg.situationId());
                    var desc = new TreeItem<>("Description: " + msg.description());
                    var start = new TreeItem<>("Start Time: " + (msg.startTime() == null ? "N/A" : msg.startTime().format(TrafficMessage.DATE_TIME_FORMATTER)));
                    var end = new TreeItem<>("End Time: " + (msg.endTime() == null ? "N/A" : msg.endTime().format(TrafficMessage.DATE_TIME_FORMATTER)));
                    trafficMessageItem.getChildren().addAll(desc, start, end);
                    situationTypeItem.getChildren().add(trafficMessageItem);
                });
            });
        }
    }
}

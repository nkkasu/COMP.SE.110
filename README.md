# Desktop Client visualizing road and weather data

This is a school project made in a group of 4 for COMP.SE.110 Software Design course.

Visualize weather and road data fetched from Digitraffic and The Finnish Meteorological Institute.

![image](https://user-images.githubusercontent.com/100607632/209853034-03755159-c4a1-4b1e-92c9-b68a08caf544.png)

![image](https://user-images.githubusercontent.com/100607632/209853089-a37ae5fe-c740-40e6-a560-f825a9b78425.png)


## Using the application
The application starts up with a coordinate selection tab. You can select coordinates areas by ctrl click + dragging
the map view. Alternative you can type in your coordinates and use the "set" button. 

In the other tabs you can select data to visualize.

With road maintenance tasks you can fetch data about road maintenance tasks between the specified date range. 
You can either view a single task's proportion and count of all tasks as a pie chart, or you can check the box to fetch
data about a specific task type and you will receive a bar chart about that task's occurrences on specific days.

With road condition forecasts you can fetch desired types of road condition forcasts for 2, 4, 6, or 12 hours.
You will receive a pie chart about all the condition types for the specified time period, where you can view a certain
conditon type's proportion and count of all conditions.

You can hover over the pie charts to see the exact values!!

With traffic messages visualizations you can fetch data about traffic messages with an "inactive hours" parameter.
Inactive hours means that at most how many hours old the traffic message can be. You can save traffic message datasets
and load them later on.

With weather, wind and cloud data you can visualize the data for a specific time period.

With the combination tabs you can combine the data from the other tabs.

In the sidebar's bottom right corner is a settings icon. In settings you can clear preferences or saved traffic message datasets.

## Software used  

* Java 
* Maven 
* JavaFX 
* FXML 
* Jackson JSON library for binding JSON
* JFreeChart
* mapjfx
* OpenAPI generator
* Apache HTTP Client

## Requirements 

* JDK 17+ is required for building the application.  
* JRE 17+ is required for running the application.
* Maven configured to use JDK 17+ (if your default JDK is something else)
  * This can be set for example through `JAVA_HOME` env var or your `~/.mavenrc`.

To install project dependencies, run the following command:  
```shell
mvn dependency:resolve
```

## Run
To run the application, run the following command:  
```shell
mvn javafx:run
```

package fi.tuni.monitor.saveddata;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for handling Java object deserialization and serialization to a file
 */
public class SerializationUtil
{
    /**
     * Deserialize to Object from given file
     */
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException
    {
        try (FileInputStream fis = new FileInputStream(fileName))
        {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            ois.close();
            return obj;
        }
    }

    /**
     * Serialize the given object and save it to file
     */
    public static void serialize(Object obj, String fileName)
            throws IOException
    {
        new File(fileName).getParentFile().mkdirs();

        try (FileOutputStream fos = new FileOutputStream(fileName))
        {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        }
    }

    /**
     * Saves the given object to the given folder as a file
     * @param obj The object to save
     * @param folderName The folder to save the object to
     * @throws IOException
     */
    public static void serializeToFolder(Object obj, String folderName)
            throws IOException
    {
        new File(folderName).mkdirs();

        // filename is irrelevant here, so just use current epoch to avoid duplicates
        var fileName = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(0)) + ".ser";
        try (FileOutputStream fos = new FileOutputStream(folderName + "/" + fileName))
        {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        }
    }

    /**
     * Deserializes all files in a folder.<br>
     * @param saveFolder The folder to deserialize from.
     * @return A list of deserialized objects.
     */
    public static List<? extends Object> deserializeAllFromFolder(String saveFolder)
    {
        List<Object> datasets = new ArrayList<>();
        var folder = new File(saveFolder);
        var listOfFiles = folder.listFiles();

        if (listOfFiles != null)
        {
            for (var file : listOfFiles)
            {
                if (!file.isFile())
                    continue;

                try
                {
                    datasets.add(deserialize(file.getPath()));
                }
                catch (IOException | ClassNotFoundException e)
                {
                    System.err.println("Error deserializing traffic message dataset!");
                }
            }
        }

        return datasets;
    }
}
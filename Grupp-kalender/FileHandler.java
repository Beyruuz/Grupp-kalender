import java.io.*;
import java.util.*;

/**
 * Filehandler for EventManager
 * 
 * @author Akar 
 * @version 1.0
 */
public class FileHandler
{
    private LinkedList<Event> savedEventList;
    /*
     * A constructor for FileHandler
     */
    public FileHandler()
    {

    }

    public void writeFile(LinkedList<Event> eventList)
    {
        try {
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("events.sav"));
            save.writeObject(eventList);
            save.close();
        }

        catch(Exception e) {
            System.out.println("Unable to find the file: Events.txt");
        } 
    }

    public LinkedList<Event> readFile()
    {
        try {
            ObjectInputStream restore = new ObjectInputStream(new FileInputStream("events.sav"));
            savedEventList = (LinkedList<Event>)restore.readObject();
            restore.close();
        }
        catch(Exception e) {
            System.out.println("Unable to find the file: Events.txt");
        }
        return savedEventList;
    }

}
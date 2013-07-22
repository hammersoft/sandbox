import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class App
{

    public static void main( String[] args ) {

        Log log = new Log();
        PrintWriter writer = null;
        log.writeToFile("mylog.txt", writer);
        BufferedReader reader = null;
        TreeSet<String> filenames = new TreeSet<String>(new LogLine());
        log.readFromFile("mylog.txt", reader, filenames);
        log.printLogLines(filenames);

    }
}

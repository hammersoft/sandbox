import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Генерация имен файлов, запись в лог-файл, чтение, сортировка
 */
public class Log {
    private static String NAME = "Boobooka";

    public String getName() {
        return NAME;
    }

    public static String generate(Log a){
        return a.getName() +'_'+ (System.currentTimeMillis()-Math.round(Math.random()*10000));
    }

    /*Запись сгенерированных имен в файл*/
    public void writeToFile(String filename, PrintWriter wrtr){
        try {
            wrtr = new PrintWriter( new FileOutputStream(filename));
            for(int i=0; i<999; i++){
                Log a = new Log();
                wrtr.println(Log.generate(a));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка открытия файла");
            System.exit(0);
        }
        finally{
            wrtr.close();
        }
    }

    /*Заполняет коллекцию TreeSet строками из файла  */
    public void readFromFile(String filename, BufferedReader reader, TreeSet<String> ts){
        String line = "";
        reader = null;
        try {
            reader = new BufferedReader(new FileReader("mylog.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка открытия файла");
        }

        try {
            while ((line = reader.readLine()) != null) {
                ts.add(line);
            }
        } catch (IOException e) {
            System.out.println("Файл пуст");
        }
    }

    /* Вывод в консоль*/
    public void printLogLines(TreeSet<String> ts){
        //Iterator<String> i = ts.iterator();
        for (String filename : ts) {
            System.out.println(filename);
        }

    }
}

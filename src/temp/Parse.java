package temp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Parse {

    public static List<Record> parseFile() {

       List<Record> listOfLog = new ArrayList<Record>();
       File logFile = new File("test.log");

        try {
                Scanner sc = new Scanner(logFile);

                while (sc.hasNextLine()) {

                    Record record = new Record();

                    if(sc.hasNext()) {
                        record.setDate(sc.nextLong()) ;
                        record.setCountryCode(sc.nextLong());
                        record.setUserId(sc.nextLong());
                        record.setSiteId(sc.nextLong());
                        record.setType(sc.next());
                    } else {sc.next();}

                    listOfLog.add(record);
                }

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }

        return listOfLog;
    }
}



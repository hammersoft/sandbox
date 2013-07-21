package temp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Parser {

    public static List readFile() {

       List<Record> listOfLogs = new ArrayList<Record>();
        File logFile = new File("test.log");

        try {
                Scanner sc = new Scanner(logFile);

                while (sc.hasNextLine()) {

                    Record recordInLogsFile = new Record();

                    if(sc.hasNext()) {
                        recordInLogsFile.date = sc.nextLong();
                        recordInLogsFile.countryCode = sc.nextLong();
                        recordInLogsFile.userId = sc.nextLong();
                        recordInLogsFile.siteId = sc.nextLong();
                        recordInLogsFile.type = sc.next();
                    } else {sc.next();}

                    listOfLogs.add(recordInLogsFile);
                }

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }

        /*for (Record item : listOfLogs) {
            System.out.println(item.date + " " + item.countryCode + " " +item.userId+" "+item.siteId+" "+ item.type);
        }*/
        return listOfLogs;
    }


}



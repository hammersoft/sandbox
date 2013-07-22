package info.noip.xfynx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xfynx
 */

/**
 * @see LogObject объект, который, при вызове конструктора с путём лог-файла,
 *      автоматически парсит его в структуру List<LogLine>
 */
public class LogObject {

    public List<LogLine> logInformation = new ArrayList<>();
    private List<String> result = new ArrayList<>();

    public LogObject(String fileName) {
        this.logInformation = read(fileName);
    }

    private List<LogLine> parse(List<LogLine> logInformation) {
        String[] splitLogString;
        for (String s : this.result) {
            LogLine parsingString = new LogLine();
            parsingString.date = new Date();
            splitLogString = s.split("\t");
            parsingString.date.setTime(Long.valueOf(splitLogString[0]));

            //parsingString.calendar.setTime(parsingString.date);
            parsingString.countryCode = Long.valueOf(splitLogString[1]);
            parsingString.userId = Long.valueOf(splitLogString[2]);
            parsingString.siteId = Long.valueOf(splitLogString[3]);
            parsingString.event = splitLogString[4];
//            if (splitLogString[4].matches("click"))
//                parsingString.event.click++;
//            else
//                parsingString.event.show++;
            logInformation.add(parsingString);
        }
        return logInformation;
    }

    private List<LogLine> read(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                this.result.add(s);
            }
        } catch (IOException e) {
            System.out.printf("File %s not found.%n", fileName);
        }
        return parse(logInformation);
    }

    public void showParsed() {
        for (LogLine logLine : logInformation) {
            System.out.println(logLine.toString());
        }
        System.out.println(logInformation.size());
    }
}

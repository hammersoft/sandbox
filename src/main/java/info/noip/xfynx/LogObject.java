package info.noip.xfynx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xfynx
 */

public class LogObject {

    public List<LogString> logInformation = new LinkedList<>();
    private List<String> result = new LinkedList<>();

    public LogObject(String fileName) {
        this.logInformation = reader(fileName);
    }

    private List<LogString> parser(List<LogString> logInformation) {
        LogString parsingString = new LogString();
        String[] splitLogString;
        for (String s : this.result) {
            splitLogString = s.split("\t");
            parsingString.rawDate = Long.valueOf(splitLogString[0]);
            parsingString.countryCode = Long.valueOf(splitLogString[1]);
            parsingString.userId = Long.valueOf(splitLogString[2]);
            parsingString.siteId = Long.valueOf(splitLogString[3]);
            parsingString.event = splitLogString[4];
            LogString temp = new LogString();        //сей костыль пришлось применить из-за того, что в добавлении
            temp.copy(parsingString);                //в logInformation ссылка на каждый элемент parser менялась,
            logInformation.add(temp);                //что, в итоге, давала все элементы списка, равные последнему в файле.
        }
        return logInformation;
    }

    public List<LogString> reader(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                this.result.add(s);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.printf("File %s not found.%n", fileName);
        }
        return parser(logInformation);
    }

    public void showParsed() {
        int i = 0;
        for (LogString logString : logInformation) {
            System.out.println(logString.toString());
            i++;
        }
        System.out.println(i);
    }
}

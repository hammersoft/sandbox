package info.noip.xfynx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author xfynx
 */

/**
 * @see LogObject объект, который, при вызове конструктора с путём лог-файла,
 *      автоматически парсит его в структуру List<LogString>
 */
public class LogObject {

    public List<LogString> logInformation = new ArrayList<>();
    private List<String> result = new ArrayList<>();

    public LogObject(String fileName) {
        this.logInformation = read(fileName);
    }

    private List<LogString> parse(List<LogString> logInformation) {
        String[] splitLogString;
        for (String s : this.result) {
            LogString parsingString = new LogString();
            parsingString.gregorianCalendar = new GregorianCalendar();
            splitLogString = s.split("\t");
            Date tempDate = new Date(Long.valueOf(splitLogString[0]));    //Штуки вида Long.valueOf(splitLogString[0])-
            parsingString.gregorianCalendar.setTime(tempDate);            //преобразование из элемента String-массива
            parsingString.countryCode = Long.valueOf(splitLogString[1]);  //в Long и дальнейшее использование
            parsingString.userId = Long.valueOf(splitLogString[2]);
            parsingString.siteId = Long.valueOf(splitLogString[3]);
            parsingString.event = splitLogString[4];
            //LogString temp = new LogString();        //сей костыль пришлось применить из-за того, что в добавлении
            //temp.copy(parsingString);                //в logInformation ссылка на каждый элемент parser менялась,
            logInformation.add(parsingString);                //что, в итоге, давала все элементы списка, равные последнему в файле.
        }
        return logInformation;
    }

    private List<LogString> read(String fileName) {
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
        return parse(logInformation);
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

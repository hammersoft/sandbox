package info.noip.xfynx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xfynx
 */
//ПРОСЬБА: не пинать, я ещё делаю. закоммитил дабы сохранить код. всё компилится =)

public class LogReader {
    private List<String> result;

    protected class LogString {
        private long rawDate;
        private long countryCode;
        private long userId;
        private long siteId;
        private String type;
    }

    public LogReader(String fileName) {
        this.result = reader(fileName);
    }

    public List<String> reader(String fileName) {
        List<String> result = new LinkedList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                result.add(s);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.printf("File %s not found.%n", fileName);
        }
        //out(result);
        return result;
    }

    protected void out() {
        for (String s : result) {
            System.out.println(s);
        }
    }
}

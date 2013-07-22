package info.noip.xfynx;

/**
 * @author xfynx
 */

import java.util.Calendar;
import java.util.Date;

/**
 * @see LogLine объект, поля соответствуют значениям столбцов в лог-файле. Для полного разобранного лога следует
 *      использовать List<LogLine>
 */
public class LogLine {

    public Date date;

    public void setCalendar(Date date) {
        this.calendar.setTime(date);
    }

    public Calendar calendar;
    public long countryCode;
    public long userId;
    public long siteId;
    public String event;


    public LogLine() {
        this.date = null;
        this.calendar = null;
        this.countryCode = 0;
        this.userId = 0;
        this.siteId = 0;
        this.event = null;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LogLine{");
        //sb.append("date=").append(date);
        sb.append("calendar=").append(calendar);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", userId=").append(userId);
        sb.append(", siteId=").append(siteId);
        sb.append(", event='").append(event).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

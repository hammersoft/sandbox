package info.noip.xfynx;

/**
 * @author xfynx
 */

import java.util.GregorianCalendar;

/**
 * @see LogString объект, поля соответствуют значениям столбцов в лог-файле. Для полного разобранного лога следует
 *      использовать List<LogString>
 */
public class LogString {
    //public long rawDate;
    //public Date date;
    public GregorianCalendar gregorianCalendar;
    public long countryCode;
    public long userId;
    public long siteId;
    public String event;

    public LogString() {
        //this.rawDate = 0;
        //this.date = null;
        this.gregorianCalendar = null;
        this.countryCode = 0;
        this.userId = 0;
        this.siteId = 0;
        this.event = null;
    }

    protected LogString copy(LogString in) {
        //this.rawDate = in.rawDate;
        //this.date = in.date;
        this.gregorianCalendar = in.gregorianCalendar;
        this.countryCode = in.countryCode;
        this.userId = in.userId;
        this.siteId = in.siteId;
        this.event = in.event;
        return this;
    }

    @Override
    public String toString() {
        return "LogString{" +
                //"rawDate=" + rawDate + ",
                //"date=" + ft.format(date) +
                "date=" + gregorianCalendar.getTime() +
                ", countryCode=" + countryCode +
                ", userId=" + userId +
                ", siteId=" + siteId +
                ", event='" + event + '\'' +
                '}';
    }
}

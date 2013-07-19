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
    public GregorianCalendar gregorianCalendar;
    public long countryCode;
    public long userId;
    public long siteId;
    public String event;

    public LogString() {
        this.gregorianCalendar = null;
        this.countryCode = 0;
        this.userId = 0;
        this.siteId = 0;
        this.event = null;
    }

    @Override
    public String toString() {
        return "LogString{" +
                "date=" + gregorianCalendar.getTime() +
                ", countryCode=" + countryCode +
                ", userId=" + userId +
                ", siteId=" + siteId +
                ", event='" + event + '\'' +
                '}';
    }
}

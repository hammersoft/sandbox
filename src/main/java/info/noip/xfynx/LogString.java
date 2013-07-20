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
    public class Event {
        public int show;
        public int click;

        public Event(int show, int click) {
            this.show = show;
            this.click = click;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Event{");
            sb.append("show=").append(show);
            sb.append(", click=").append(click);
            sb.append('}');
            return sb.toString();
        }
    }

    public GregorianCalendar gregorianCalendar;
    public long countryCode;
    public long userId;
    public long siteId;
    public Event event = new Event(0, 0);


    public LogString() {
        this.gregorianCalendar = null;
        this.countryCode = 0;
        this.userId = 0;
        this.siteId = 0;
    }

    public String keyStatEvent() {
        return new StringBuilder()
                .append(this.gregorianCalendar.get(this.gregorianCalendar.DATE)).append(".")
                .append(this.gregorianCalendar.get(this.gregorianCalendar.MONTH)).append(".")
                .append(this.gregorianCalendar.get(this.gregorianCalendar.YEAR)).append(" ")
                .append(this.countryCode).append(" ").append(this.siteId).toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LogString{");
        sb.append("gregorianCalendar=").append(gregorianCalendar.getTime());
        sb.append(", countryCode=").append(countryCode);
        sb.append(", userId=").append(userId);
        sb.append(", siteId=").append(siteId);
        sb.append(", event=").append(event);
        sb.append('}');
        return sb.toString();
    }
}

package info.noip.xfynx;

/**
 * @author xfynx
 */
<<<<<<< HEAD

/**
 * @see LogString объект, поля соответствуют значениям столбцов в лог-файле. Для полного разобранного лога следует
 *      использовать List<LogString>
 */
=======
>>>>>>> origin/xfynx
public class LogString {
    public long rawDate;
    public long countryCode;
    public long userId;
    public long siteId;
    public String event;

    public LogString() {
        this.rawDate = 0;
        this.countryCode = 0;
        this.userId = 0;
        this.siteId = 0;
        this.event = null;
    }

    protected LogString copy(LogString in) {
        this.rawDate = in.rawDate;
        this.countryCode = in.countryCode;
        this.userId = in.userId;
        this.siteId = in.siteId;
        this.event = in.event;
        return this;
    }

    @Override
    public String toString() {
        return "LogString{" +
                "rawDate=" + rawDate +
                ", countryCode=" + countryCode +
                ", userId=" + userId +
                ", siteId=" + siteId +
                ", event='" + event + '\'' +
                '}';
    }
}

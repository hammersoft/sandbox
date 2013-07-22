package info.noip.xfynx;

/**
 * @author xfynx
 */
public class Event {
    public int show;
    public int click;

    public Event(int show, int click) {
        this.show = show;
        this.click = click;
    }

    public Event setShowOrClick(LogLine ls, Event event) {
        if (ls.event.equals("show"))
            event.show++;
        else
            event.click++;
        return event;
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

package by.pvt.kish.pojos;

import java.util.Date;

/**
 * @author Kish Alexey
 */
public class Event {

    private String id;
    private Date date;
    private String title;

    public Event() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ",\n date=" + date +
                ",\n title='" + title + '\'' +
                '}';
    }
}

package by.pvt.kish.pojos;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Kish Alexey
 */
public class Event implements Serializable{

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
                ", date=" + date +
                ", title='" + title + '\'' +
                '}';
    }
}

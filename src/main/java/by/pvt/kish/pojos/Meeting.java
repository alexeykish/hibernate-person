package by.pvt.kish.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kish Alexey
 */
public class Meeting {

    private Long meetingId;
    private String subject;
    private Set<Employee> employees = new HashSet<>();

    public Meeting() {
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingId=" + meetingId +
                ", subject='" + subject + '\'' +
                '}';
    }
}

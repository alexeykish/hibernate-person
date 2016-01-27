package by.pvt.kish.pojos.s1;

/**
 * @author Kish Alexey
 */
public class S1Student extends S1Person{

    private String faculty;
    private Double mark;

    public S1Student() {
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "S1Student{" +
                "faculty='" + faculty + '\'' +
                ",\n mark=" + mark +
                '}';
    }
}

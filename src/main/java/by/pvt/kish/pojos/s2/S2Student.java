package by.pvt.kish.pojos.s2;

/**
 * @author Kish Alexey
 */
public class S2Student extends S2Person{

    private String faculty;
    private Double mark;

    public S2Student() {
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
        return "S2Student{" +
                "faculty='" + faculty + '\'' +
                ",\n mark=" + mark +
                '}';
    }
}

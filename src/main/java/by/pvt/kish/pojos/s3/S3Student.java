package by.pvt.kish.pojos.s3;

/**
 * @author Kish Alexey
 */
public class S3Student extends S3Person{

    private String faculty;
    private Double mark;

    public S3Student() {
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
        return "S3Student{" +
                "faculty='" + faculty + '\'' +
                ",\n mark=" + mark +
                '}';
    }
}

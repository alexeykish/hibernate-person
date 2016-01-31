package by.pvt.kish.pojos.s3a;

/**
 * @author Kish Alexey
 */
public class S3AStudent extends S3APerson {

    private String faculty;
    private Double mark;

    public S3AStudent() {
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

package by.pvt.kish.pojos.s3;

/**
 * @author Kish Alexey
 */
public class S3Employee extends S3Person{

    private String company;
    private Double salary;

    public S3Employee() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "S3Employee{" +
                "company='" + company + '\'' +
                ",\n salary=" + salary +
                '}';
    }
}

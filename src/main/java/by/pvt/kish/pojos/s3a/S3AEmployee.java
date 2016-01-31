package by.pvt.kish.pojos.s3a;

/**
 * @author Kish Alexey
 */
public class S3AEmployee extends S3APerson {

    private String company;
    private Double salary;

    public S3AEmployee() {
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

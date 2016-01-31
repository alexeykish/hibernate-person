package by.pvt.kish.pojos.s1a;

/**
 * @author Kish Alexey
 */
public class S1AEmployee extends S1APerson {

    private String company;
    private Double salary;

    public S1AEmployee() {
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
        return "S1Employee{" +
                "company='" + company + '\'' +
                ",\n salary=" + salary +
                '}';
    }
}

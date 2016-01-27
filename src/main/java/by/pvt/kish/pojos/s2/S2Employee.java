package by.pvt.kish.pojos.s2;

/**
 * @author Kish Alexey
 */
public class S2Employee extends S2Person{

    private String company;
    private Double salary;

    public S2Employee() {
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
        return "S2Employee{" +
                "company='" + company + '\'' +
                ",\n salary=" + salary +
                '}';
    }
}

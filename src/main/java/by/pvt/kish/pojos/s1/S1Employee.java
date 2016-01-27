package by.pvt.kish.pojos.s1;

/**
 * @author Kish Alexey
 */
public class S1Employee extends S1Person{

    private String company;
    private Double salary;

    public S1Employee() {
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

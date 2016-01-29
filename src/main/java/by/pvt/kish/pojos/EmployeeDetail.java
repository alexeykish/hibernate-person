package by.pvt.kish.pojos;

/**
 * @author Kish Alexey
 */
public class EmployeeDetail {

    private Long employeeId;
    private String street;
    private String city;
    private String state;
    private String country;
    private Employee employee;

    public EmployeeDetail() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDetail that = (EmployeeDetail) o;

        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        return employee != null ? employee.equals(that.employee) : that.employee == null;

    }

//    @Override
//    public int hashCode() {
//        int result = employeeId != null ? employeeId.hashCode() : 0;
//        result = 31 * result + (street != null ? street.hashCode() : 0);
//        result = 31 * result + (city != null ? city.hashCode() : 0);
//        result = 31 * result + (state != null ? state.hashCode() : 0);
//        result = 31 * result + (country != null ? country.hashCode() : 0);
//        result = 31 * result + (employee != null ? employee.hashCode() : 0);
//        return result;
//    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}

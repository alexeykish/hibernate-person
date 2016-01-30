package by.pvt.kish.pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kish Alexey
 */
public class Employee implements Serializable{
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String cellphone;
    private EmployeeDetail employeeDetail;
    private Department department;
    private Set<Meeting> meetings = new HashSet<Meeting>();

    public Employee() {
    }

    public Employee(String firstName, String lastName, String cellphone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellphone = cellphone;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (cellphone != null ? cellphone.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != employee.employeeId) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (cellphone != null ? !cellphone.equals(employee.cellphone) : employee.cellphone != null) return false;
        return employeeDetail != null ? employeeDetail.equals(employee.employeeDetail) : employee.employeeDetail == null;

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<Meeting> meetings) {
        this.meetings = meetings;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", department=" + department +
                '}';
    }
}

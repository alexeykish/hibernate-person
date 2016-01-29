package by.pvt.kish.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kish Alexey
 */
public class Employee {

    private Long employeeId;
    private String firstname;
    private String lastname;
    private String cellphone;
    private EmployeeDetail employeeDetail;
    private Department department;
    private Set<Meeting> meetings = new HashSet<>();

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (firstname != null ? !firstname.equals(employee.firstname) : employee.firstname != null) return false;
        if (lastname != null ? !lastname.equals(employee.lastname) : employee.lastname != null) return false;
        if (cellphone != null ? !cellphone.equals(employee.cellphone) : employee.cellphone != null) return false;
        if (employeeDetail != null ? !employeeDetail.equals(employee.employeeDetail) : employee.employeeDetail != null)
            return false;
        return department != null ? department.equals(employee.department) : employee.department == null;

    }

//    @Override
//    public int hashCode() {
//        int result = employeeId != null ? employeeId.hashCode() : 0;
//        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
//        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
//        result = 31 * result + (cellphone != null ? cellphone.hashCode() : 0);
//        result = 31 * result + (employeeDetail != null ? employeeDetail.hashCode() : 0);
//        result = 31 * result + (department != null ? department.hashCode() : 0);
//        return result;
//    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", department=" + department +
                ", meetings=" + meetings +
                '}';
    }
}

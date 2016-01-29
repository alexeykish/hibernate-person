package by.pvt.kish;

import by.pvt.kish.dao.DepartmentDAO;
import by.pvt.kish.dao.EmployeeDAO;
import by.pvt.kish.pojos.Department;
import by.pvt.kish.pojos.Employee;
import by.pvt.kish.pojos.EmployeeDetail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Kish Alexey
 */
public class OneToManyTest {

    private Employee employee;
    private Employee employee2;
    private EmployeeDetail employeeDetail;
    private EmployeeDetail employeeDetail2;
    private Department department;
    private Long eid;
    private Long eid2;
    private Long did;
    private EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
    private DepartmentDAO departmentDAO = DepartmentDAO.getInstance();

    @Before
    public void setUp() throws Exception {
        department = new Department();
        department.setDepartmentName("testDepartment");
        did = (Long) departmentDAO.saveOrUpdate(department);

        employee = new Employee();
        employee.setFirstname("testFirstName");
        employee.setLastname("testLastName");
        employee.setCellphone("testCellphone");
        employee.setDepartment(department);

        employee2 = new Employee();
        employee2.setFirstname("testFirstName2");
        employee2.setLastname("testLastName2");
        employee2.setCellphone("testCellphone2");
        employee2.setDepartment(department);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        employees.add(employee2);
        department.setEmployees(employees);

        employeeDetail = new EmployeeDetail();
        employeeDetail.setStreet("testStreet");
        employeeDetail.setCity("testCity");
        employeeDetail.setState("testState");
        employeeDetail.setCountry("testCountry");

        employeeDetail2 = new EmployeeDetail();
        employeeDetail2.setStreet("testStreet2");
        employeeDetail2.setCity("testCity2");
        employeeDetail2.setState("testState2");
        employeeDetail2.setCountry("testCountry2");

        employeeDetail.setEmployee(employee);
        employeeDetail2.setEmployee(employee2);

        employee.setEmployeeDetail(employeeDetail);
        employee2.setEmployeeDetail(employeeDetail2);

        eid = (Long) employeeDAO.saveOrUpdate(employee);
        eid2 = (Long) employeeDAO.saveOrUpdate(employee2);

    }

    @Test
    public void testAdd() throws Exception {
        Employee addedEmployee = employeeDAO.get(eid);
        Employee addedEmployee2 = employeeDAO.get(eid2);
        Department addedDepartment = departmentDAO.get(did);
        employee.setEmployeeId(eid);
        employee2.setEmployeeId(eid2);
        department.setDepartmentId(did);
        assertEquals("Add method failed: wrong employee", addedEmployee, employee);
        assertEquals("Add method failed: wrong employee", addedEmployee2, employee2);
        assertEquals("Add method failed: wrong employee", addedDepartment, department);
//        employeeDAO.delete(eid);
//        employeeDAO.delete(eid2);
//        departmentDAO.delete(did);
    }

    @Test
    public void testUpdate() throws Exception {
        Department preUpdatedDepartment = departmentDAO.get(did);
        preUpdatedDepartment.setDepartmentName("updatedName");
        preUpdatedDepartment.setDepartmentId(did);
        Employee employee3 = new Employee();
        employee3.setFirstname("updatedFirstName");
        employee3.setLastname("updatedLastName");
        employee3.setCellphone("updatedCellphone");
        employee3.setDepartment(department);
        employee3.setEmployeeDetail(employeeDetail);
        Set<Employee> employees = departmentDAO.get(did).getEmployees();
        employees.add(employee3);
        department.setEmployees(employees);
        employeeDAO.saveOrUpdate(employee3);

        Department updatedDepartment = departmentDAO.get(did);
        assertEquals("Add method failed: wrong departmentname", updatedDepartment.getDepartmentName(), preUpdatedDepartment.getDepartmentName());
        assertEquals("Add method failed: wrong department", updatedDepartment.getEmployees().size(), preUpdatedDepartment.getEmployees().size());
//        employeeDAO.delete(eid);
//        employeeDAO.delete(eid2);
//        departmentDAO.delete(did);
    }

    @Test
    public void testDelete() throws Exception {
        Set<Employee> employees = departmentDAO.get(did).getEmployees();
        for (Employee e: employees) {
            e.setDepartment(null);
            employeeDAO.saveOrUpdate(e);
        }
        departmentDAO.delete(did);
        assertNull(departmentDAO.get(did));
    }

    @After
    public void tearDown() throws Exception {

    }

}

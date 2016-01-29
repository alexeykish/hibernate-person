package by.pvt.kish;

import by.pvt.kish.dao.DepartmentDAO;
import by.pvt.kish.dao.EmployeeDAO;
import by.pvt.kish.dao.EmployeeDetailDAO;
import by.pvt.kish.dao.EventDAO;
import by.pvt.kish.exception.DaoException;
import by.pvt.kish.pojos.Department;
import by.pvt.kish.pojos.Employee;
import by.pvt.kish.pojos.EmployeeDetail;
import by.pvt.kish.pojos.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Kish Alexey
 */
public class OneToOneTest {

    private Employee employee;
    private EmployeeDetail employeeDetail;
    private Long eid;
    private EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
    private EmployeeDetailDAO employeeDetailDAO = EmployeeDetailDAO.getInstance();

    @Before
    public void setUp() throws Exception {
        employee = new Employee();
        employee.setFirstname("testFirstName");
        employee.setLastname("testLastName");
        employee.setCellphone("testCellphone");
        employeeDetail = new EmployeeDetail();
        employeeDetail.setStreet("testStreet");
        employeeDetail.setCity("testCity");
        employeeDetail.setState("testState");
        employeeDetail.setCountry("testCountry");
        employee.setEmployeeDetail(employeeDetail);
        employeeDetail.setEmployee(employee);
        eid = (Long) employeeDAO.saveOrUpdate(employee);
    }

    @Test
    public void testAdd() throws Exception {
        Employee addedEmployee = employeeDAO.get(eid);
        assertEquals("Add method failed: wrong firstname", addedEmployee.getFirstname(), employee.getFirstname());
        assertEquals("Add method failed: wrong lastname", addedEmployee.getLastname(), employee.getLastname());
        assertEquals("Add method failed: wrong cellphone", addedEmployee.getCellphone(), employee.getCellphone());
        assertEquals("Add method failed: wrong street", addedEmployee.getEmployeeDetail().getStreet(), employeeDetail.getStreet());
        assertEquals("Add method failed: wrong city", addedEmployee.getEmployeeDetail().getCity(), employeeDetail.getCity());
        assertEquals("Add method failed: wrong state", addedEmployee.getEmployeeDetail().getState(), employeeDetail.getState());
        assertEquals("Add method failed: wrong country", addedEmployee.getEmployeeDetail().getCountry(), employeeDetail.getCountry());
        assertEquals("Add method failed: wrong employee", addedEmployee, employeeDetail.getEmployee());
        assertEquals("Add method failed: wrong employeeDetails", addedEmployee.getEmployeeDetail(), employeeDetail);
        employeeDAO.delete(eid);
    }

    @Test
    public void testUpdate() throws Exception {
        Employee preUpdatedEmployee = employeeDAO.get(eid);
        preUpdatedEmployee.setEmployeeId(eid);
        preUpdatedEmployee.setFirstname("updatedFirstName");
        preUpdatedEmployee.setLastname("updatedLastName");
        preUpdatedEmployee.setCellphone("updatedCellphone");
        EmployeeDetail preUpdatedEmployeeDetail = employeeDetailDAO.get(eid);
        preUpdatedEmployeeDetail.setStreet("updatedStreet");
        preUpdatedEmployeeDetail.setCity("updatedCity");
        preUpdatedEmployeeDetail.setState("updatedState");
        preUpdatedEmployeeDetail.setCountry("updatedCountry");
        preUpdatedEmployee.setEmployeeDetail(preUpdatedEmployeeDetail);
        preUpdatedEmployeeDetail.setEmployee(preUpdatedEmployee);
        employeeDAO.saveOrUpdate(preUpdatedEmployee);
        Employee updatedEmployee = employeeDAO.get(eid);
        assertEquals("Add method failed: wrong firstname", updatedEmployee.getFirstname(), employee.getFirstname());
        assertEquals("Add method failed: wrong lastname", updatedEmployee.getLastname(), employee.getLastname());
        assertEquals("Add method failed: wrong cellphone", updatedEmployee.getCellphone(), employee.getCellphone());
        assertEquals("Add method failed: wrong street", updatedEmployee.getEmployeeDetail().getStreet(), employeeDetail.getStreet());
        assertEquals("Add method failed: wrong city", updatedEmployee.getEmployeeDetail().getCity(), employeeDetail.getCity());
        assertEquals("Add method failed: wrong state", updatedEmployee.getEmployeeDetail().getState(), employeeDetail.getState());
        assertEquals("Add method failed: wrong country", updatedEmployee.getEmployeeDetail().getCountry(), employeeDetail.getCountry());
        //employeeDAO.delete(eid);
    }

    @Test
    public void testDelete() throws Exception {
        employeeDAO.delete(eid);
        assertNull(employeeDAO.get(eid));
        assertNull(employeeDetailDAO.get(eid));
    }



    @After
    public void tearDown() throws Exception {

    }

}

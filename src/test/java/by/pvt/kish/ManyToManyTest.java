package by.pvt.kish;

import by.pvt.kish.dao.DepartmentDAO;
import by.pvt.kish.dao.EmployeeDAO;
import by.pvt.kish.dao.MeetingDAO;
import by.pvt.kish.pojos.Department;
import by.pvt.kish.pojos.Employee;
import by.pvt.kish.pojos.EmployeeDetail;
import by.pvt.kish.pojos.Meeting;
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
public class ManyToManyTest {

    private Employee employee;
    private Employee employee2;
    private Employee employee3;
    private Department department;
//    private EmployeeDetail employeeDetail;
//    private EmployeeDetail employeeDetail2;
//    private EmployeeDetail employeeDetail3;
    private Meeting meeting1;
    private Meeting meeting2;
    private Long eid;
    private Long eid2;
    private Long eid3;
    private Long did;
    private EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
    private DepartmentDAO departmentDAO = DepartmentDAO.getInstance();
    private MeetingDAO meetingDAO = MeetingDAO.getInstance();

    @Before
    public void setUp() throws Exception {

        meeting1 = new Meeting();
        meeting1.setSubject("Sales meeting");
        //meetingDAO.saveOrUpdate(meeting1);

        meeting2 = new Meeting();
        meeting2.setSubject("Monthly meeting");
        //meetingDAO.saveOrUpdate(meeting2);

//        Set<Meeting> meetings = new HashSet<>();
//        meetings.add(meeting1);
//        meetings.add(meeting2);
//
//        Set<Meeting> meetings2 = new HashSet<>();
//        meetings.add(meeting1);

        department = new Department();
        department.setDepartmentName("testDepartment");
        did = (Long) departmentDAO.saveOrUpdate(department);

//        employeeDetail = new EmployeeDetail();
//        employeeDetail.setStreet("testStreet");
//        employeeDetail.setCity("testCity");
//        employeeDetail.setState("testState");
//        employeeDetail.setCountry("testCountry");
//
//        employeeDetail2 = new EmployeeDetail();
//        employeeDetail2.setStreet("testStreet");
//        employeeDetail2.setCity("testCity");
//        employeeDetail2.setState("testState");
//        employeeDetail2.setCountry("testCountry");
//
//        employeeDetail3 = new EmployeeDetail();
//        employeeDetail3.setStreet("testStreet");
//        employeeDetail3.setCity("testCity");
//        employeeDetail3.setState("testState");
//        employeeDetail3.setCountry("testCountry");

        employee = new Employee();
        employee.setFirstname("testFirstName");
        employee.setLastname("testLastName");
        employee.setCellphone("testCellphone");
        employee.setDepartment(department);
//        employee.setEmployeeDetail(employeeDetail);
        employee.getMeetings().add(meeting1);
        employee.getMeetings().add(meeting2);

        employee2 = new Employee();
        employee2.setFirstname("testFirstName2");
        employee2.setLastname("testLastName2");
        employee2.setCellphone("testCellphone2");
        employee2.setDepartment(department);
//        employee2.setEmployeeDetail(employeeDetail2);
        employee2.getMeetings().add(meeting1);

        employee3 = new Employee();
        employee3.setFirstname("testFirstName3");
        employee3.setLastname("testLastName3");
        employee3.setCellphone("testCellphone3");
        employee3.setDepartment(department);
//        employee3.setEmployeeDetail(employeeDetail3);
        employee3.getMeetings().add(meeting2);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
        department.setEmployees(employees);

//        employeeDetail.setEmployee(employee);
//        employeeDetail2.setEmployee(employee2);
//        employeeDetail3.setEmployee(employee3);

        eid = (Long) employeeDAO.saveOrUpdate(employee);
        eid2 = (Long) employeeDAO.saveOrUpdate(employee2);
        eid3 = (Long) employeeDAO.saveOrUpdate(employee3);



    }

    @Test
    public void testAdd() throws Exception {
        Employee addedEmployee = employeeDAO.get(eid);
        Employee addedEmployee2 = employeeDAO.get(eid2);
        Employee addedEmployee3 = employeeDAO.get(eid2);
//        Meeting addedMeeting = meetingDAO.get()
        Department addedDepartment = departmentDAO.get(did);
        Set<Employee> employees = addedDepartment.getEmployees();
        for (Employee e: employees) {
            Set<Meeting> meetings = e.getMeetings();
            for (Meeting m: meetings) {
                System.out.println(m);
            }
        }
        employee.setEmployeeId(eid);
        employee2.setEmployeeId(eid2);
        employee3.setEmployeeId(eid3);
//        department.setDepartmentId(did);
        System.out.println(addedEmployee.getMeetings().size());
        System.out.println(addedEmployee2.getMeetings().size());
        System.out.println(addedEmployee3.getMeetings().size());
//        assertEquals("Add method failed: wrong employee meetings", addedEmployee.getMeetings().size(), employee.getMeetings().size());
//        assertEquals("Add method failed: wrong employee2 meetings", addedEmployee2.getMeetings().size(), employee2.getMeetings().size());
//        assertEquals("Add method failed: wrong employee3 meetings", addedEmployee3.getMeetings().size(), employee3.getMeetings().size());
//        employeeDAO.delete(eid2);
//        departmentDAO.delete(did);
    }

//    @Test
//    public void testUpdate() throws Exception {
//        Department preUpdatedDepartment = departmentDAO.get(did);
//        preUpdatedDepartment.setDepartmentName("updatedName");
//        preUpdatedDepartment.setDepartmentId(did);
//        Employee employee3 = new Employee();
//        employee3.setFirstname("updatedFirstName");
//        employee3.setLastname("updatedLastName");
//        employee3.setCellphone("updatedCellphone");
//        employee3.setDepartment(department);
//        employee3.setEmployeeDetail(employeeDetail);
//        Set<Employee> employees = departmentDAO.get(did).getEmployees();
//        employees.add(employee3);
//        department.setEmployees(employees);
//        employeeDAO.saveOrUpdate(employee3);
//
//        Department updatedDepartment = departmentDAO.get(did);
//        assertEquals("Add method failed: wrong departmentname", updatedDepartment.getDepartmentName(), preUpdatedDepartment.getDepartmentName());
//        assertEquals("Add method failed: wrong department", updatedDepartment.getEmployees().size(), preUpdatedDepartment.getEmployees().size());
////        employeeDAO.delete(eid);
////        employeeDAO.delete(eid2);
////        departmentDAO.delete(did);
//    }

//    @Test
//    public void testDelete() throws Exception {
//        Set<Employee> employees = departmentDAO.get(did).getEmployees();
//        for (Employee e: employees) {
//            e.setDepartment(null);
//            employeeDAO.saveOrUpdate(e);
//        }
//        departmentDAO.delete(did);
//        assertNull(departmentDAO.get(did));
//    }

    @After
    public void tearDown() throws Exception {

    }

}

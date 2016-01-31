package by.pvt.kish;

import by.pvt.kish.dao.s1a.S1AEmployeeDAO;
import by.pvt.kish.dao.s1a.S1APersonDAO;
import by.pvt.kish.dao.s1a.S1AStudentDAO;
import by.pvt.kish.pojos.s1a.S1AEmployee;
import by.pvt.kish.pojos.s1a.S1APerson;
import by.pvt.kish.pojos.s1a.S1AStudent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Kish Alexey
 */
public class TablePerHierarhyAbstractTest {

    private S1AEmployee employee;
    private S1APerson employeeA;
    private S1AStudent student;
    private S1APerson studentA;
    private int eid;
    private int eaid;
    private int sid;
    private int said;

    @Before
    public void setUp() throws Exception {
        employee = new S1AEmployee();
        employee.setName("testEmployeeName");
        employee.setSurname("testEmployeeSurname");
        employee.setAge(50);
        employee.setCompany("testCompany");
        employee.setSalary(10000.00);
        eid = (int) S1AEmployeeDAO.getInstance().saveOrUpdate(employee);
        student = new S1AStudent();
        student.setName("testStudentName");
        student.setSurname("testStudentSurname");
        student.setAge(50);
        student.setFaculty("testFaculty");
        student.setMark(10.00);
        sid = (int) S1AStudentDAO.getInstance().saveOrUpdate(student);
        employeeA = new S1AEmployee();
        employeeA.setName("testEmployeeName");
        employeeA.setSurname("testEmployeeSurname");
        employeeA.setAge(50);
        eaid = (int) S1APersonDAO.getInstance().saveOrUpdate(employeeA);
        studentA = new S1AStudent();
        studentA.setName("testStudentName");
        studentA.setSurname("testStudentSurname");
        studentA.setAge(50);
        said = (int) S1APersonDAO.getInstance().saveOrUpdate(studentA);
    }

    @Test
    public void testAdd() throws Exception {
        employee.setId(eid);
        student.setId(sid);
        S1AEmployee addedEmployee = S1AEmployeeDAO.getInstance().get(eid);
        assertEquals("Add method failed: wrong name", addedEmployee, employee);
        S1AStudent addedStudent = S1AStudentDAO.getInstance().get(sid);
        assertEquals("Add method failed: wrong name", addedStudent, student);
        S1APerson addedEmployeeA = S1APersonDAO.getInstance().get(eaid);
        assertEquals("Add method failed: wrong name", addedEmployeeA, employeeA);
        S1APerson addedStudentA = S1APersonDAO.getInstance().get(said);
        assertEquals("Add method failed: wrong name", addedStudentA, studentA);
    }

    @After
    public void tearDown() throws Exception {
//        S1PersonDAO.getInstance().delete(pid);
//        S1EmployeeDAO.getInstance().delete(eid);
//        S1StudentDAO.getInstance().delete(sid);
    }

}

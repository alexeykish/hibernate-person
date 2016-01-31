package by.pvt.kish;

import by.pvt.kish.dao.s2a.S2AEmployeeDAO;
import by.pvt.kish.dao.s2a.S2APersonDAO;
import by.pvt.kish.dao.s2a.S2AStudentDAO;
import by.pvt.kish.pojos.s2a.S2AEmployee;
import by.pvt.kish.pojos.s2a.S2APerson;
import by.pvt.kish.pojos.s2a.S2AStudent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Kish Alexey
 */
public class TablePerSubclassAbstractTest {

    private S2AEmployee employee;
    private S2APerson employeeA;
    private S2AStudent student;
    private S2APerson studentA;
    private int eid;
    private int eaid;
    private int sid;
    private int said;

    @Before
    public void setUp() throws Exception {
        employee = new S2AEmployee();
        employee.setName("testEmployeeName");
        employee.setSurname("testEmployeeSurname");
        employee.setAge(50);
        employee.setCompany("testCompany");
        employee.setSalary(10000.00);
        eid = (int) S2AEmployeeDAO.getInstance().saveOrUpdate(employee);
        student = new S2AStudent();
        student.setName("testStudentName");
        student.setSurname("testStudentSurname");
        student.setAge(50);
        student.setFaculty("testFaculty");
        student.setMark(10.00);
        sid = (int) S2AStudentDAO.getInstance().saveOrUpdate(student);
        employeeA = new S2AEmployee();
        employeeA.setName("testEmployeeName");
        employeeA.setSurname("testEmployeeSurname");
        employeeA.setAge(50);
        eaid = (int) S2APersonDAO.getInstance().saveOrUpdate(employeeA);
        studentA = new S2AStudent();
        studentA.setName("testStudentName");
        studentA.setSurname("testStudentSurname");
        studentA.setAge(50);
        said = (int) S2APersonDAO.getInstance().saveOrUpdate(studentA);
    }

    @Test
    public void testAdd() throws Exception {
        employee.setId(eid);
        student.setId(sid);
        S2AEmployee addedEmployee = S2AEmployeeDAO.getInstance().get(eid);
        assertEquals("Add method failed: wrong name", addedEmployee, employee);
        S2AStudent addedStudent = S2AStudentDAO.getInstance().get(sid);
        assertEquals("Add method failed: wrong name", addedStudent, student);
        S2APerson addedEmployeeA = S2APersonDAO.getInstance().get(eaid);
        assertEquals("Add method failed: wrong name", addedEmployeeA, employeeA);
        S2APerson addedStudentA = S2APersonDAO.getInstance().get(said);
        assertEquals("Add method failed: wrong name", addedStudentA, studentA);
    }

    @After
    public void tearDown() throws Exception {
//        S1PersonDAO.getInstance().delete(pid);
//        S1EmployeeDAO.getInstance().delete(eid);
//        S1StudentDAO.getInstance().delete(sid);
    }
}

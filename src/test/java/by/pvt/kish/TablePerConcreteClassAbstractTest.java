package by.pvt.kish;

import by.pvt.kish.dao.s3a.S3AEmployeeDAO;
import by.pvt.kish.dao.s3a.S3APersonDAO;
import by.pvt.kish.dao.s3a.S3AStudentDAO;
import by.pvt.kish.pojos.s3a.S3AEmployee;
import by.pvt.kish.pojos.s3a.S3APerson;
import by.pvt.kish.pojos.s3a.S3AStudent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Kish Alexey
 */
public class TablePerConcreteClassAbstractTest {

    private S3AEmployee employee;
    private S3APerson employeeA;
    private S3AStudent student;
    private S3APerson studentA;
    private int eid;
    private int eaid;
    private int sid;
    private int said;

    @Before
    public void setUp() throws Exception {
        employee = new S3AEmployee();
        employee.setName("testEmployeeName");
        employee.setSurname("testEmployeeSurname");
        employee.setAge(50);
        employee.setCompany("testCompany");
        employee.setSalary(10000.00);
        eid = (int) S3AEmployeeDAO.getInstance().saveOrUpdate(employee);
        student = new S3AStudent();
        student.setName("testStudentName");
        student.setSurname("testStudentSurname");
        student.setAge(50);
        student.setFaculty("testFaculty");
        student.setMark(10.00);
        sid = (int) S3AStudentDAO.getInstance().saveOrUpdate(student);
        employeeA = new S3AEmployee();
        employeeA.setName("testEmployeeName");
        employeeA.setSurname("testEmployeeSurname");
        employeeA.setAge(50);
        eaid = (int) S3APersonDAO.getInstance().saveOrUpdate(employeeA);
        studentA = new S3AStudent();
        studentA.setName("testStudentName");
        studentA.setSurname("testStudentSurname");
        studentA.setAge(50);
        said = (int) S3APersonDAO.getInstance().saveOrUpdate(studentA);
    }

    @Test
    public void testAdd() throws Exception {
        employee.setId(eid);
        student.setId(sid);
        S3AEmployee addedEmployee = S3AEmployeeDAO.getInstance().get(eid);
        assertEquals("Add method failed: wrong name", addedEmployee, employee);
        S3AStudent addedStudent = S3AStudentDAO.getInstance().get(sid);
        assertEquals("Add method failed: wrong name", addedStudent, student);
        S3APerson addedEmployeeA = S3APersonDAO.getInstance().get(eaid);
        assertEquals("Add method failed: wrong name", addedEmployeeA, employeeA);
        S3APerson addedStudentA = S3APersonDAO.getInstance().get(said);
        assertEquals("Add method failed: wrong name", addedStudentA, studentA);
    }

    @After
    public void tearDown() throws Exception {
//        S3PersonDAO.getInstance().delete(pid);
//        S3EmployeeDAO.getInstance().delete(eid);
//        S3StudentDAO.getInstance().delete(sid);
    }

}

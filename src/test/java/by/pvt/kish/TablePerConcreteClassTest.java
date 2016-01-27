package by.pvt.kish;

import by.pvt.kish.dao.s3.S3EmployeeDAO;
import by.pvt.kish.dao.s3.S3PersonDAO;
import by.pvt.kish.dao.s3.S3StudentDAO;
import by.pvt.kish.pojos.s3.S3Employee;
import by.pvt.kish.pojos.s3.S3Person;
import by.pvt.kish.pojos.s3.S3Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Kish Alexey
 */
public class TablePerConcreteClassTest {

    private S3Person person;
    private S3Employee employee;
    private S3Student student;
    private int pid;
    private int eid;
    private int sid;

    @Before
    public void setUp() throws Exception {
        person = new S3Person();
        person.setName("testPersonName");
        person.setSurname("testPersonSurname");
        person.setAge(50);
        pid = S3PersonDAO.getInstance().saveOrUpdate(person);
        employee = new S3Employee();
        employee.setName("testEmployeeName");
        employee.setSurname("testEmployeeSurname");
        employee.setAge(50);
        employee.setCompany("testCompany");
        employee.setSalary(10000.00);
        eid = S3EmployeeDAO.getInstance().saveOrUpdate(employee);
        student = new S3Student();
        student.setName("testStudentName");
        student.setSurname("testStudentSurname");
        student.setAge(50);
        student.setFaculty("testFaculty");
        student.setMark(10.00);
        sid = S3StudentDAO.getInstance().saveOrUpdate(student);
    }

    @Test
    public void testAdd() throws Exception {
        S3Person addedPerson = S3PersonDAO.getInstance().get(pid);
        assertEquals("Add method failed: wrong name", addedPerson.getName(), person.getName());
        assertEquals("Add method failed: wrong surname", addedPerson.getSurname(), person.getSurname());
        assertEquals("Add method failed: wrong age", addedPerson.getAge(), person.getAge());
        S3Employee addedEmployee = S3EmployeeDAO.getInstance().get(eid);
        assertEquals("Add method failed: wrong name", addedEmployee.getName(), employee.getName());
        assertEquals("Add method failed: wrong surname", addedEmployee.getSurname(), employee.getSurname());
        assertEquals("Add method failed: wrong age", addedEmployee.getAge(), employee.getAge());
        assertEquals("Add method failed: wrong company", addedEmployee.getCompany(), employee.getCompany());
        assertEquals("Add method failed: wrong salary", addedEmployee.getSalary(), employee.getSalary());
        S3Student addedStudent = S3StudentDAO.getInstance().get(sid);
        assertEquals("Add method failed: wrong name", addedStudent.getName(), student.getName());
        assertEquals("Add method failed: wrong surname", addedStudent.getSurname(), student.getSurname());
        assertEquals("Add method failed: wrong age", addedStudent.getAge(), student.getAge());
        assertEquals("Add method failed: wrong faculty", addedStudent.getFaculty(), student.getFaculty());
        assertEquals("Add method failed: wrong mark", addedStudent.getMark(), student.getMark());
    }

    @After
    public void tearDown() throws Exception {
        S3PersonDAO.getInstance().delete(pid);
        S3EmployeeDAO.getInstance().delete(eid);
        S3StudentDAO.getInstance().delete(sid);
    }

}

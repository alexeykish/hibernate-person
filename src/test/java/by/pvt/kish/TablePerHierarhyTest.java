package by.pvt.kish;

import by.pvt.kish.dao.s1.S1EmployeeDAO;
import by.pvt.kish.dao.s1.S1PersonDAO;
import by.pvt.kish.dao.s1.S1StudentDAO;
import by.pvt.kish.pojos.s1.S1Employee;
import by.pvt.kish.pojos.s1.S1Person;
import by.pvt.kish.pojos.s1.S1Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Kish Alexey
 */
public class TablePerHierarhyTest {

    private S1Person person;
    private S1Employee employee;
    private S1Student student;
    private int pid;
    private int eid;
    private int sid;

    @Before
    public void setUp() throws Exception {
        person = new S1Person();
        person.setName("testPersonName");
        person.setSurname("testPersonSurname");
        person.setAge(50);
        pid = (int) S1PersonDAO.getInstance().saveOrUpdate(person);
        employee = new S1Employee();
        employee.setName("testEmployeeName");
        employee.setSurname("testEmployeeSurname");
        employee.setAge(50);
        employee.setCompany("testCompany");
        employee.setSalary(10000.00);
        eid = (int) S1EmployeeDAO.getInstance().saveOrUpdate(employee);
        student = new S1Student();
        student.setName("testStudentName");
        student.setSurname("testStudentSurname");
        student.setAge(50);
        student.setFaculty("testFaculty");
        student.setMark(10.00);
        sid = (int) S1StudentDAO.getInstance().saveOrUpdate(student);
    }

    @Test
    public void testAdd() throws Exception {
        person.setId(pid);
        employee.setId(eid);
        student.setId(sid);
        S1Person addedPerson = S1PersonDAO.getInstance().get(pid);
        assertEquals("Add method failed: wrong name", addedPerson, person);
        S1Employee addedEmployee = S1EmployeeDAO.getInstance().get(eid);
        assertEquals("Add method failed: wrong name", addedEmployee, employee);
        S1Student addedStudent = S1StudentDAO.getInstance().get(sid);
        assertEquals("Add method failed: wrong name", addedStudent, student);
    }

    @After
    public void tearDown() throws Exception {
//        S1PersonDAO.getInstance().delete(pid);
//        S1EmployeeDAO.getInstance().delete(eid);
//        S1StudentDAO.getInstance().delete(sid);
    }

}

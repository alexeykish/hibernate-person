package by.pvt.kish;

import by.pvt.kish.dao.s2.S2EmployeeDAO;
import by.pvt.kish.dao.s2.S2PersonDAO;
import by.pvt.kish.dao.s2.S2StudentDAO;
import by.pvt.kish.pojos.s2.S2Employee;
import by.pvt.kish.pojos.s2.S2Person;
import by.pvt.kish.pojos.s2.S2Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Kish Alexey
 */
public class TablePerSubclassTest {

    private S2Person person;
    private S2Employee employee;
    private S2Student student;
    private int pid;
    private int eid;
    private int sid;

    @Before
    public void setUp() throws Exception {
        person = new S2Person();
        person.setName("testPersonName");
        person.setSurname("testPersonSurname");
        person.setAge(50);
        pid = (int) S2PersonDAO.getInstance().saveOrUpdate(person);
        employee = new S2Employee();
        employee.setName("testEmployeeName");
        employee.setSurname("testEmployeeSurname");
        employee.setAge(50);
        employee.setCompany("testCompany");
        employee.setSalary(10000.00);
        eid = (int) S2EmployeeDAO.getInstance().saveOrUpdate(employee);
        student = new S2Student();
        student.setName("testStudentName");
        student.setSurname("testStudentSurname");
        student.setAge(50);
        student.setFaculty("testFaculty");
        student.setMark(10.00);
        sid = (int) S2StudentDAO.getInstance().saveOrUpdate(student);
    }

    @Test
    public void testAdd() throws Exception {
        person.setId(pid);
        employee.setId(eid);
        student.setId(sid);
        S2Person addedPerson = S2PersonDAO.getInstance().get(pid);
        assertEquals("Add method failed: wrong name", addedPerson, person);
        S2Employee addedEmployee = S2EmployeeDAO.getInstance().get(eid);
        assertEquals("Add method failed: wrong name", addedEmployee, employee);
        S2Student addedStudent = S2StudentDAO.getInstance().get(sid);
        assertEquals("Add method failed: wrong name", addedStudent, student);
    }

    @After
    public void tearDown() throws Exception {
        S2PersonDAO.getInstance().delete(pid);
        S2EmployeeDAO.getInstance().delete(eid);
        S2StudentDAO.getInstance().delete(sid);
    }

}

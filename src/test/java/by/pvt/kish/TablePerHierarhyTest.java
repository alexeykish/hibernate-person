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
    private Integer pid;
    private Integer eid;
    private Integer sid;

    @Before
    public void setUp() throws Exception {
        person = new S1Person();
        person.setName("testPersonName");
        person.setSurname("testPersonSurname");
        person.setAge(50);
        pid = (Integer) S1PersonDAO.getInstance().saveOrUpdate(person);
        employee = new S1Employee();
        employee.setName("testEmployeeName");
        employee.setSurname("testEmployeeSurname");
        employee.setAge(50);
        employee.setCompany("testCompany");
        employee.setSalary(10000.00);
        eid = (Integer) S1EmployeeDAO.getInstance().saveOrUpdate(employee);
        student = new S1Student();
        student.setName("testStudentName");
        student.setSurname("testStudentSurname");
        student.setAge(50);
        student.setFaculty("testFaculty");
        student.setMark(10.00);
        sid = (Integer) S1StudentDAO.getInstance().saveOrUpdate(student);
    }

    @Test
    public void testAdd() throws Exception {
        S1Person addedPerson = S1PersonDAO.getInstance().get(pid);
        assertEquals("Add method failed: wrong name", addedPerson.getName(), person.getName());
        assertEquals("Add method failed: wrong surname", addedPerson.getSurname(), person.getSurname());
        assertEquals("Add method failed: wrong age", addedPerson.getAge(), person.getAge());
        S1Employee addedEmployee = S1EmployeeDAO.getInstance().get(eid);
        assertEquals("Add method failed: wrong name", addedEmployee.getName(), employee.getName());
        assertEquals("Add method failed: wrong surname", addedEmployee.getSurname(), employee.getSurname());
        assertEquals("Add method failed: wrong age", addedEmployee.getAge(), employee.getAge());
        assertEquals("Add method failed: wrong company", addedEmployee.getCompany(), employee.getCompany());
        assertEquals("Add method failed: wrong salary", addedEmployee.getSalary(), employee.getSalary());
        S1Student addedStudent = S1StudentDAO.getInstance().get(sid);
        assertEquals("Add method failed: wrong name", addedStudent.getName(), student.getName());
        assertEquals("Add method failed: wrong surname", addedStudent.getSurname(), student.getSurname());
        assertEquals("Add method failed: wrong age", addedStudent.getAge(), student.getAge());
        assertEquals("Add method failed: wrong faculty", addedStudent.getFaculty(), student.getFaculty());
        assertEquals("Add method failed: wrong mark", addedStudent.getMark(), student.getMark());
    }

    @After
    public void tearDown() throws Exception {
        S1PersonDAO.getInstance().delete(pid);
        S1EmployeeDAO.getInstance().delete(eid);
        S1StudentDAO.getInstance().delete(sid);
    }

}

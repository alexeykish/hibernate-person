package by.pvt.kish;

import by.pvt.kish.dao.PersonDAO;
import by.pvt.kish.dao.s1.S1EmployeeDAO;
import by.pvt.kish.dao.s1.S1PersonDAO;
import by.pvt.kish.dao.s1.S1StudentDAO;
import by.pvt.kish.pojos.Person;
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
public class PersonDAOTest {

    private Person person;
    private Integer pid;

    @Before
    public void setUp() throws Exception {
        person = new Person();
        person.setName("testPersonName");
        person.setSurname("testPersonSurname");
        person.setAge(50);
        pid = (Integer) PersonDAO.getInstance().saveOrUpdate(person);
    }

    @Test
    public void testAdd() throws Exception {
        Person addedPerson = PersonDAO.getInstance().get(pid);
        assertEquals("Add method failed: wrong name", addedPerson.getName(), person.getName());
        assertEquals("Add method failed: wrong surname", addedPerson.getSurname(), person.getSurname());
        assertEquals("Add method failed: wrong age", addedPerson.getAge(), person.getAge());
    }

    @After
    public void tearDown() throws Exception {
        PersonDAO.getInstance().delete(pid);
    }

}

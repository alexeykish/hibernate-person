package by.pvt.kish;

import by.pvt.kish.dao.EventDAO;
import by.pvt.kish.dao.PersonDAO;
import by.pvt.kish.pojos.Event;
import by.pvt.kish.pojos.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Kish Alexey
 */
public class EventDAOTest {

    private Event event;
    private String eid;

    @Before
    public void setUp() throws Exception {
        event = new Event();
        event.setDate(new Date());
        event.setTitle("testTitle");
        eid = (String) EventDAO.getInstance().saveOrUpdate(event);
    }

    @Test
    public void testAdd() throws Exception {
        Event addedEvent = EventDAO.getInstance().get(eid);
        assertEquals("Add method failed: wrong date", addedEvent.getDate(), event.getDate());
        assertEquals("Add method failed: wrong title", addedEvent.getTitle(), event.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        EventDAO.getInstance().delete(eid);
    }

}

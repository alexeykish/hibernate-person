package by.pvt.kish.dao;

import by.pvt.kish.pojos.Event;

/**
 * @author Kish Alexey
 */
public class EventDAO extends BaseDAO<Event> {

    private static EventDAO instance;

    private EventDAO() {
        super(Event.class);
    }

    public static EventDAO getInstance() {
        if (instance == null) {
            instance = new EventDAO();
        }
        return instance;
    }
}

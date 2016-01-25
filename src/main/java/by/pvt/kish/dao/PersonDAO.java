package by.pvt.kish.dao;

import by.pvt.kish.exception.DaoException;
import by.pvt.kish.pojos.Person;
import by.pvt.kish.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Kish Alexey
 */
public class PersonDAO extends BaseDAO<Person>{

    private static PersonDAO instance;
    private HibernateUtil util = HibernateUtil.getUtil();
    private static Logger logger = Logger.getLogger(PersonDAO.class);

    private PersonDAO() {
        super(Person.class);
    }

    public static PersonDAO getInstance() {
            if (instance == null) {
                instance = new PersonDAO();
            }
            return instance;
    }

    public void flush(Integer id, Integer age) throws DaoException {
        try {
            Session session = util.getSession();
            Person person = (Person) session.get(Person.class, id);
            if (person == null) {
                throw  new DaoException("Cant find person with that ID: " + id);
            }
            logger.info(person);
            person.setAge(age);
            logger.info(person);
            session.flush();
            logger.info("Session flushed");
            logger.info(person);
        } catch (HibernateException e) {
            logger.error("Error in flush", e);
            throw new DaoException(e);
        }
    }

    public void refresh(Integer id, Integer age) throws DaoException {
        try {
            Session session = util.getSession();
            Person person = (Person) session.get(Person.class, id);
            if (person == null) {
                throw  new DaoException("Cant find person with that ID: " + id);
            }
            logger.info(person);
            person.setAge(age);
            logger.info(person);
            session.refresh(person);
            logger.info("Person refreshed");
            logger.info(person);
        } catch (HibernateException e) {
            logger.error("Error in refresh", e);
            throw new DaoException(e);
        }
    }
}

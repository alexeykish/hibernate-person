package by.pvt.kish.dao;

import by.pvt.kish.exception.DaoException;
import by.pvt.kish.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * @author Kish Alexey
 */
public class BaseDAO<T> implements DAO<T> {

    private static Logger logger = Logger.getLogger(BaseDAO.class);
    private Class className;

    private HibernateUtil util = HibernateUtil.getUtil();
    private Transaction transaction = null;

    public BaseDAO(Class<T> className) {
        this.className = className;
    }

    public T saveOrUpdate(T t) throws DaoException {
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            transaction.commit();
            Serializable iid = session.getIdentifier(t);
            logger.info("ID: " + iid);
            logger.info(t);
        } catch (HibernateException e) {
            logger.error("Error in save or update DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return t;
    }

    public T get(Integer id) throws  DaoException {
        T t = null;
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();
            t = (T) session.get(className, id);
            if (t == null) {
                throw  new DaoException("Cant find person with that ID: " + id);
            }
            logger.info(t);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Error in save or update DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return t;
    }

    public T load(Integer id) throws  DaoException {
        T t = null;
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();
            t = (T) session.load(className, id);
            logger.info(t);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Error in save or update DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return t;
    }

    public void delete(Integer id) throws DaoException {
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();
            T t = (T) session.get(className, id);
            Serializable iid = session.getIdentifier(t);
            logger.info("ID: " + iid);
            if (t == null) {
                throw  new DaoException("Cant find person with that ID: " + id);
            }
            session.delete(t);
            transaction.commit();
            logger.info("Deleted object: " + t);
        } catch (HibernateException e) {
            logger.error("Error in delete DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
    }

    public Serializable getIdentifier(T t) throws  DaoException {
        Serializable id = null;
        try {
            Session session = util.getSession();
            id = session.getIdentifier(t);
            logger.info("ID: " + id);
        } catch (HibernateException e) {
            logger.error("Error in getIdentifier DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return id;
    }
}

package by.pvt.kish.dao;

import by.pvt.kish.exception.DaoException;

/**
 * @author Kish Alexey
 */
public interface DAO<T> {

    T saveOrUpdate(T t) throws DaoException;

    void delete(Integer id) throws DaoException;

    T get(Integer id) throws  DaoException;

    T load(Integer id) throws  DaoException;
}

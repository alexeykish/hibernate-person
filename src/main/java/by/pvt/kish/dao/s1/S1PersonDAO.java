package by.pvt.kish.dao.s1;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s1.S1Person;

/**
 * @author Kish Alexey
 */
public class S1PersonDAO extends BaseDAO<S1Person> {

    private static S1PersonDAO instance;

    private S1PersonDAO() {
        super(S1Person.class);
    }

    public static S1PersonDAO getInstance() {
        if (instance == null) {
            instance = new S1PersonDAO();
        }
        return instance;
    }
}

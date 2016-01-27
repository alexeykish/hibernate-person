package by.pvt.kish.dao.s2;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s2.S2Person;

/**
 * @author Kish Alexey
 */
public class S2PersonDAO extends BaseDAO<S2Person> {

    private static S2PersonDAO instance;

    private S2PersonDAO() {
        super(S2Person.class);
    }

    public static S2PersonDAO getInstance() {
        if (instance == null) {
            instance = new S2PersonDAO();
        }
        return instance;
    }
}

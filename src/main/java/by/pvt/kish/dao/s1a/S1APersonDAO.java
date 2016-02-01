package by.pvt.kish.dao.s1a;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s1a.S1AEmployee;
import by.pvt.kish.pojos.s1a.S1APerson;

/**
 * @author Kish Alexey
 */
public class S1APersonDAO extends BaseDAO<S1APerson> {

    private static S1APersonDAO instance;

    private S1APersonDAO() {
        super(S1APerson.class);
    }

    public static S1APersonDAO getInstance() {
        if (instance == null) {
            instance = new S1APersonDAO();
        }
        return instance;
    }
}

package by.pvt.kish.dao.s2a;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s2a.S2APerson;

/**
 * @author Kish Alexey
 */
public class S2APersonDAO extends BaseDAO<S2APerson> {

    private static S2APersonDAO instance;

    private S2APersonDAO() {
        super(S2APerson.class);
    }

    public static S2APersonDAO getInstance() {
        if (instance == null) {
            instance = new S2APersonDAO();
        }
        return instance;
    }
}

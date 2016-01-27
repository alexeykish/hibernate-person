package by.pvt.kish.dao.s2;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s2.S2Student;

/**
 * @author Kish Alexey
 */
public class S2StudentDAO extends BaseDAO<S2Student> {

    private static S2StudentDAO instance;

    private S2StudentDAO() {
        super(S2Student.class);
    }

    public static S2StudentDAO getInstance() {
        if (instance == null) {
            instance = new S2StudentDAO();
        }
        return instance;
    }
}

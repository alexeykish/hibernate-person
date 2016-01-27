package by.pvt.kish.dao.s1;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s1.S1Student;

/**
 * @author Kish Alexey
 */
public class S1StudentDAO extends BaseDAO<S1Student> {

    private static S1StudentDAO instance;

    private S1StudentDAO() {
        super(S1Student.class);
    }

    public static S1StudentDAO getInstance() {
        if (instance == null) {
            instance = new S1StudentDAO();
        }
        return instance;
    }
}

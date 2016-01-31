package by.pvt.kish.dao.s2a;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s2a.S2AStudent;

/**
 * @author Kish Alexey
 */
public class S2AStudentDAO extends BaseDAO<S2AStudent> {

    private static S2AStudentDAO instance;

    private S2AStudentDAO() {
        super(S2AStudent.class);
    }

    public static S2AStudentDAO getInstance() {
        if (instance == null) {
            instance = new S2AStudentDAO();
        }
        return instance;
    }
}

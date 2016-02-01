package by.pvt.kish.dao.s1a;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s1a.S1AEmployee;
import by.pvt.kish.pojos.s1a.S1AStudent;

/**
 * @author Kish Alexey
 */
public class S1AStudentDAO extends BaseDAO<S1AStudent> {

    private static S1AStudentDAO instance;

    private S1AStudentDAO() {
        super(S1AStudent.class);
    }

    public static S1AStudentDAO getInstance() {
        if (instance == null) {
            instance = new S1AStudentDAO();
        }
        return instance;
    }
}

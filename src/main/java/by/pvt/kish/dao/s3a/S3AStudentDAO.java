package by.pvt.kish.dao.s3a;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s3a.S3AStudent;

/**
 * @author Kish Alexey
 */
public class S3AStudentDAO extends BaseDAO<S3AStudent> {

    private static S3AStudentDAO instance;

    private S3AStudentDAO() {
        super(S3AStudent.class);
    }

    public static S3AStudentDAO getInstance() {
        if (instance == null) {
            instance = new S3AStudentDAO();
        }
        return instance;
    }
}

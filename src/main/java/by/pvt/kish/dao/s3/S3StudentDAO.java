package by.pvt.kish.dao.s3;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s3.S3Student;

/**
 * @author Kish Alexey
 */
public class S3StudentDAO extends BaseDAO<S3Student> {

    private static S3StudentDAO instance;

    private S3StudentDAO() {
        super(S3Student.class);
    }

    public static S3StudentDAO getInstance() {
        if (instance == null) {
            instance = new S3StudentDAO();
        }
        return instance;
    }
}

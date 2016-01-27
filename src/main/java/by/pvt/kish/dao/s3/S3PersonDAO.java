package by.pvt.kish.dao.s3;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s3.S3Person;

/**
 * @author Kish Alexey
 */
public class S3PersonDAO extends BaseDAO<S3Person> {

    private static S3PersonDAO instance;

    private S3PersonDAO() {
        super(S3Person.class);
    }

    public static S3PersonDAO getInstance() {
        if (instance == null) {
            instance = new S3PersonDAO();
        }
        return instance;
    }
}

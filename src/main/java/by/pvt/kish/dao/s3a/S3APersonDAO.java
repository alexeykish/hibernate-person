package by.pvt.kish.dao.s3a;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s3a.S3APerson;

/**
 * @author Kish Alexey
 */
public class S3APersonDAO extends BaseDAO<S3APerson> {

    private static S3APersonDAO instance;

    private S3APersonDAO() {
        super(S3APerson.class);
    }

    public static S3APersonDAO getInstance() {
        if (instance == null) {
            instance = new S3APersonDAO();
        }
        return instance;
    }
}

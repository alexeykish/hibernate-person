package by.pvt.kish.dao.s3a;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s3a.S3AEmployee;

/**
 * @author Kish Alexey
 */
public class S3AEmployeeDAO extends BaseDAO<S3AEmployee> {

    private static S3AEmployeeDAO instance;

    private S3AEmployeeDAO() {
        super(S3AEmployee.class);
    }

    public static S3AEmployeeDAO getInstance() {
        if (instance == null) {
            instance = new S3AEmployeeDAO();
        }
        return instance;
    }
}

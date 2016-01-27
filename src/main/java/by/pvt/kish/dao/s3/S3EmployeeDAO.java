package by.pvt.kish.dao.s3;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s3.S3Employee;

/**
 * @author Kish Alexey
 */
public class S3EmployeeDAO extends BaseDAO<S3Employee> {

    private static S3EmployeeDAO instance;

    private S3EmployeeDAO() {
        super(S3Employee.class);
    }

    public static S3EmployeeDAO getInstance() {
        if (instance == null) {
            instance = new S3EmployeeDAO();
        }
        return instance;
    }
}

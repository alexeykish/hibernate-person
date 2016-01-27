package by.pvt.kish.dao.s2;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s2.S2Employee;

/**
 * @author Kish Alexey
 */
public class S2EmployeeDAO extends BaseDAO<S2Employee> {

    private static S2EmployeeDAO instance;

    private S2EmployeeDAO() {
        super(S2Employee.class);
    }

    public static S2EmployeeDAO getInstance() {
        if (instance == null) {
            instance = new S2EmployeeDAO();
        }
        return instance;
    }
}

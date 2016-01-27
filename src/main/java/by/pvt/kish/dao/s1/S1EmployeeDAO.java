package by.pvt.kish.dao.s1;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s1.S1Employee;

/**
 * @author Kish Alexey
 */
public class S1EmployeeDAO extends BaseDAO<S1Employee> {

    private static S1EmployeeDAO instance;

    private S1EmployeeDAO() {
        super(S1Employee.class);
    }

    public static S1EmployeeDAO getInstance() {
        if (instance == null) {
            instance = new S1EmployeeDAO();
        }
        return instance;
    }
}

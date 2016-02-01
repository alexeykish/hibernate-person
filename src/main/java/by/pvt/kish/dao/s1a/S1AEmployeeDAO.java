package by.pvt.kish.dao.s1a;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s1a.S1AEmployee;

/**
 * @author Kish Alexey
 */
public class S1AEmployeeDAO extends BaseDAO<S1AEmployee> {

    private static S1AEmployeeDAO instance;

    private S1AEmployeeDAO() {
        super(S1AEmployee.class);
    }

    public static S1AEmployeeDAO getInstance() {
        if (instance == null) {
            instance = new S1AEmployeeDAO();
        }
        return instance;
    }
}

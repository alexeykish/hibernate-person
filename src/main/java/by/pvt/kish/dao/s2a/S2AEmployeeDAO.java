package by.pvt.kish.dao.s2a;

import by.pvt.kish.dao.BaseDAO;
import by.pvt.kish.pojos.s2a.S2AEmployee;

/**
 * @author Kish Alexey
 */
public class S2AEmployeeDAO extends BaseDAO<S2AEmployee> {

    private static S2AEmployeeDAO instance;

    private S2AEmployeeDAO() {
        super(S2AEmployee.class);
    }

    public static S2AEmployeeDAO getInstance() {
        if (instance == null) {
            instance = new S2AEmployeeDAO();
        }
        return instance;
    }
}

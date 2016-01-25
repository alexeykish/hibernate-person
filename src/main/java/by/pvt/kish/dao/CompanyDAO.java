package by.pvt.kish.dao;

import by.pvt.kish.pojos.Company;

/**
 * @author Kish Alexey
 */
public class CompanyDAO extends BaseDAO<Company>{

    private static CompanyDAO instance;

    private CompanyDAO() {
        super(Company.class);
    }

    public static CompanyDAO getInstance() {
        if (instance == null) {
            instance = new CompanyDAO();
        }
        return instance;
    }
}

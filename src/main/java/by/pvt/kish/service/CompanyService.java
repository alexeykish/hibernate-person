package by.pvt.kish.service;

import by.pvt.kish.dao.CompanyDAO;
import by.pvt.kish.exception.DaoException;
import by.pvt.kish.pojos.Address;
import by.pvt.kish.pojos.Company;
import by.pvt.kish.util.ScannerUtil;
import org.apache.log4j.Logger;

import java.util.Scanner;

import static by.pvt.kish.util.ScannerUtil.*;

/**
 * @author Kish Alexey
 */
public class CompanyService {

    private static Logger logger = Logger.getLogger(CompanyService.class.getName());

    public static void updateCompany() {
        Company company = new Company();
        Scanner scanner = new Scanner(System.in);
        company.setId(readId(scanner));
        company.setName(readName(scanner));
        company.setOwner(readOwner(scanner));
        company.setHomeAddress(readAddress(scanner));
        company.setBillingAddress(readAddress(scanner));
        try {
            CompanyDAO.getInstance().saveOrUpdate(company);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    public static Company getCompany() {
        Company company = new Company();
        Scanner scanner = new Scanner(System.in);
        try {
            company = CompanyDAO.getInstance().get(readId(scanner));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        } catch (NullPointerException e2) {
            logger.error("No person with that ID");
        }
        return company;
    }

    public static void saveCompany() {
        Company company = new Company();
        Scanner scanner = new Scanner(System.in);
        company.setName(readName(scanner));
        company.setOwner(readOwner(scanner));
        company.setHomeAddress(readAddress(scanner));
        company.setBillingAddress(readAddress(scanner));
        try {
            CompanyDAO.getInstance().saveOrUpdate(company);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    private static Address readAddress(Scanner scanner) {
        Address address = new Address();
        System.out.println("Enter street:");
        address.setStreet(scanner.nextLine());
        System.out.println("Enter city:");
        address.setCity(scanner.nextLine());
        System.out.println("Enter zip code:");
        address.setZipCode(scanner.nextLine());
        return address;
    }
}

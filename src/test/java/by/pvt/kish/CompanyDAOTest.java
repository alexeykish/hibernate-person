package by.pvt.kish;

import by.pvt.kish.dao.CompanyDAO;
import by.pvt.kish.dao.PersonDAO;
import by.pvt.kish.pojos.Address;
import by.pvt.kish.pojos.Company;
import by.pvt.kish.pojos.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Kish Alexey
 */
public class CompanyDAOTest {

    private Company company;
    private Integer cid;
    private Address homeAddress;
    private Address billingAddress;

    @Before
    public void setUp() throws Exception {
        company = new Company();
        company.setName("testCompanyName");
        company.setOwner("testCompanyOwner");
        homeAddress = new Address();
        homeAddress.setStreet("testHStreet");
        homeAddress.setCity("testHCity");
        homeAddress.setZipCode("testHZipcode");
        billingAddress = new Address();
        billingAddress.setStreet("testBStreet");
        billingAddress.setCity("testBCity");
        billingAddress.setZipCode("testBZipcode");
        company.setHomeAddress(homeAddress);
        company.setBillingAddress(billingAddress);
        cid = (Integer) CompanyDAO.getInstance().saveOrUpdate(company);
    }

    @Test
    public void testAdd() throws Exception {
        Company addedCompany = CompanyDAO.getInstance().get(cid);
        assertEquals("Add method failed: wrong name", addedCompany.getName(), company.getName());
        assertEquals("Add method failed: wrong owner", addedCompany.getOwner(), company.getOwner());
        assertEquals("Add method failed: wrong homeAddress", addedCompany.getHomeAddress(), company.getHomeAddress());
        assertEquals("Add method failed: wrong billingAddress", addedCompany.getBillingAddress(), company.getBillingAddress());
    }

    @After
    public void tearDown() throws Exception {
        CompanyDAO.getInstance().delete(cid);
    }

}

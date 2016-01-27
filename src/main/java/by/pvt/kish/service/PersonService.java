package by.pvt.kish.service;

import by.pvt.kish.dao.PersonDAO;
import by.pvt.kish.exception.DaoException;
import by.pvt.kish.pojos.Person;
import by.pvt.kish.util.ScannerUtil;
import org.apache.log4j.Logger;

import java.util.Scanner;

import static by.pvt.kish.util.ScannerUtil.*;

/**
 * @author Kish Alexey
 */
public class PersonService {

    private static Logger logger = Logger.getLogger(PersonService.class.getName());

    public static void getPersonId() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        person.setId(readId(scanner));
        person.setName(readName(scanner));
        person.setSurname(readSurname(scanner));
        person.setAge(readAge(scanner));
        try {
            PersonDAO.getInstance().getIdentifier(person);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    public static void deletePerson() {
        Scanner scanner = new Scanner(System.in);
        try {
            PersonDAO.getInstance().delete(readId(scanner));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    public static void refreshPerson() {
        Scanner scanner = new Scanner(System.in);
        try {
            PersonDAO.getInstance().refresh(readId(scanner), readAge(scanner));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    public static void flushPerson() {
        Scanner scanner = new Scanner(System.in);
        try {
            PersonDAO.getInstance().flush(readId(scanner), readAge(scanner));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    public static Person getPerson() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        try {
            person = PersonDAO.getInstance().get(readId(scanner));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        } catch (NullPointerException e2) {
            logger.error("No person with that ID");
        }
        return person;
    }

    public static Person loadPerson() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        try {
            person = PersonDAO.getInstance().load(readId(scanner));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        } catch (NullPointerException e2) {
            logger.error("No person with that ID");
        }
        return person;
    }

    public static void saveOrUpdatePerson() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        person.setName(readName(scanner));
        person.setSurname(readSurname(scanner));
        person.setAge(readAge(scanner));
        try {
            PersonDAO.getInstance().saveOrUpdate(person);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }
}

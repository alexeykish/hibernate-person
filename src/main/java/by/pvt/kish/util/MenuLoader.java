package by.pvt.kish.util;

import by.pvt.kish.dao.CompanyDAO;
import by.pvt.kish.dao.EventDAO;
import by.pvt.kish.dao.PersonDAO;
import by.pvt.kish.exception.DaoException;
import by.pvt.kish.pojos.Company;
import by.pvt.kish.pojos.Event;
import by.pvt.kish.pojos.Person;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Kish Alexey
 */
public class MenuLoader {

    private static Logger logger = Logger.getLogger(MenuLoader.class.getName());

    public static void createMenu() {
        while (true) {
            showMenuLevel1();
            Scanner scanner = new Scanner(System.in);
            int command;
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input, parameter must be number, please try again");
                continue;
            }
            switch (command) {
                case 1:
                    boolean level2 = true;
                    while (level2) {
                        showMenuPersonLevel2();
                        try {
                            command = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect input, parameter must be number, please try again");
                            break;
                        }
                        switch (command) {
                            case 1:
                                saveOrUpdatePerson();
                                break;
                            case 2:
                                loadPerson();
                                break;
                            case 3:
                                getPerson();
                                break;
                            case 4:
                                flushPerson();
                                break;
                            case 5:
                                refreshPerson();
                                break;
                            case 6:
                                deletePerson();
                                break;
                            case 7:
                                getPersonId();
                                break;
                            case 0:
                                level2 = false;
                                System.out.println("---------------------------");
                                break;
                            default:
                                System.out.println("Incorrect input, please try again");
                                break;
                        }
                    }
                    break;
                case 2:
                    level2 = true;
                    while (level2) {
                        showMenuCompanyLevel2();
                        try {
                            command = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect input, parameter must be number, please try again");
                            break;
                        }
                        switch (command) {
                            case 1:
                                saveCompany();
                                break;
                            case 2:
                                getCompany();
                                break;
                            case 3:
                                updateCompany();
                                break;
                            case 0:
                                level2 = false;
                                System.out.println("---------------------------");
                                break;
                            default:
                                System.out.println("Incorrect input, please try again");
                                break;
                        }
                    }
                    break;
                case 3:

                    level2 = true;
                    while (level2) {
                        showMenuEventLevel2();
                        try {
                            command = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect input, parameter must be number, please try again");
                            break;
                        }
                        switch (command) {
                            case 1:
                                saveEvent();
                                break;
                            case 0:
                                level2 = false;
                                System.out.println("---------------------------");
                                break;
                            default:
                                System.out.println("Incorrect input, please try again");
                                break;
                        }
                    }
                    break;
                case 0:
                    try {
                        scanner.close();
                    } catch (Exception e) {
                        System.err.println("Failed to close stream");
                        logger.error("Failed to close stream", e);
                    }
                    System.exit(0);
                default:
                    System.out.println("Incorrect input, please try again");
                    System.out.println("---------------------------------");
                    break;
            }
        }
    }


    private static void saveEvent() {
        Event event = new Event();
        event.setDate(new Date());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title:");
        String parameter = scanner.nextLine();
        event.setTitle(parameter);
        try {
            EventDAO.getInstance().saveOrUpdate(event);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    private static void getPersonId() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String parameter = scanner.nextLine();
        person.setId(Integer.parseInt(parameter));
        System.out.println("Enter Name:");
        parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.println("Enter surname:");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.println("Enter age:");
        parameter = scanner.nextLine();
        person.setAge(Integer.parseInt(parameter));
        try {
            PersonDAO.getInstance().getIdentifier(person);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    private static void updateCompany() {
        Company company = new Company();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String parameter = scanner.nextLine();
        company.setId(Integer.parseInt(parameter));
        System.out.println("Enter name:");
        parameter = scanner.nextLine();
        company.setName(parameter);
        System.out.println("Enter owner:");
        parameter = scanner.nextLine();
        company.setOwner(parameter);
        try {
            CompanyDAO.getInstance().saveOrUpdate(company);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    private static Company getCompany() {
        Company company = new Company();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String parameter = scanner.nextLine();
        try {
            company = CompanyDAO.getInstance().get(Integer.parseInt(parameter));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        } catch (NullPointerException e2) {
            logger.error("No person with that ID");
        }
        return company;
    }

    private static void saveCompany() {
        Company company = new Company();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String parameter = scanner.nextLine();
        company.setName(parameter);
        System.out.println("Enter owner:");
        parameter = scanner.nextLine();
        company.setOwner(parameter);
        try {
            CompanyDAO.getInstance().saveOrUpdate(company);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }


    private static void deletePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String parameter = scanner.nextLine();
        try {
            PersonDAO.getInstance().delete(Integer.parseInt(parameter));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    private static void refreshPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String parameter = scanner.nextLine();
        System.out.println("Enter age:");
        String age = scanner.nextLine();
        try {
            PersonDAO.getInstance().refresh(Integer.parseInt(parameter), Integer.parseInt(age));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    private static void flushPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String parameter = scanner.nextLine();
        System.out.println("Enter age:");
        String age = scanner.nextLine();
        try {
            PersonDAO.getInstance().flush(Integer.parseInt(parameter), Integer.parseInt(age));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    private static Person getPerson() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String parameter = scanner.nextLine();
        try {
            person = PersonDAO.getInstance().get(Integer.parseInt(parameter));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        } catch (NullPointerException e2) {
            logger.error("No person with that ID");
        }
        return person;
    }

    private static Person loadPerson() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String parameter = scanner.nextLine();
        try {
            person = PersonDAO.getInstance().load(Integer.parseInt(parameter));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        } catch (NullPointerException e2) {
            logger.error("No person with that ID");
        }
        return person;
    }

    private static void saveOrUpdatePerson() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.println("Enter surname:");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.println("Enter age:");
        parameter = scanner.nextLine();
        person.setAge(Integer.parseInt(parameter));
        try {
            PersonDAO.getInstance().saveOrUpdate(person);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }

    private static void showMenuLevel1() {
        System.out.println("Please enter command:");
        System.out.println("1. Person methods");
        System.out.println("2. Company methods");
        System.out.println("3. Events methods");
        System.out.println("0. Exit");
    }

    private static void showMenuPersonLevel2() {
        System.out.println("1. Save or update Person");
        System.out.println("2. Load Person");
        System.out.println("3. Get Person");
        System.out.println("4. Flush Person");
        System.out.println("5. Refresh Person");
        System.out.println("6. Delete Person");
//        System.out.println("7. Get Person ID");
        System.out.println("0. Back");
    }

    private static void showMenuCompanyLevel2() {
        System.out.println("1. Save Company");
        System.out.println("2. Get Company");
        System.out.println("3. Update Company");
        System.out.println("0. Back");
    }

    private static void showMenuEventLevel2() {
        System.out.println("1. Save event");
        System.out.println("0. Back");
    }
}

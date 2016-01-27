package by.pvt.kish.util;

import by.pvt.kish.dao.PersonDAO;
import by.pvt.kish.exception.DaoException;
import by.pvt.kish.pojos.Person;
import by.pvt.kish.service.CompanyService;
import by.pvt.kish.service.EventService;
import by.pvt.kish.service.PersonService;
import org.apache.log4j.Logger;

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
                                PersonService.saveOrUpdatePerson();
                                break;
                            case 2:
                                PersonService.loadPerson();
                                break;
                            case 3:
                                PersonService.getPerson();
                                break;
                            case 4:
                                PersonService.flushPerson();
                                break;
                            case 5:
                                PersonService.refreshPerson();
                                break;
                            case 6:
                                PersonService.deletePerson();
                                break;
                            case 7:
                                PersonService.getPersonId();
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
                                CompanyService.saveCompany();
                                break;
                            case 2:
                                CompanyService.getCompany();
                                break;
                            case 3:
                                CompanyService.updateCompany();
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
                                EventService.saveEvent();
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
                case 4:
                    threadTest();
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


    private static void threadTest() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("thread1 run");
                try {
                    PersonDAO.getInstance().flush(1, 15);
                    Thread.sleep(5000);
                    PersonDAO.getInstance().refresh(1, 25);
                } catch (DaoException | InterruptedException e) {
                    logger.error(e.getMessage());
                }
                logger.info("thread1 finished");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("thread2 run");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
                Person person = new Person();
                person.setId(1);
                person.setName("Alex");
                person.setSurname("Kish");
                person.setAge(555);
                try {
                    PersonDAO.getInstance().saveOrUpdate(person);
                } catch (DaoException e) {
                    logger.error(e.getMessage());
                }
                logger.info("thread2 finished");
            }
        });
        thread1.start();
        thread2.start();
    }

    private static void showMenuLevel1() {
        System.out.println("Please enter command:");
        System.out.println("1. Person methods");
        System.out.println("2. Company methods");
        System.out.println("3. Events methods");
        System.out.println("4. Threads test");
        System.out.println("0. Exit");
    }

    private static void showMenuPersonLevel2() {
        System.out.println("1. Save Person");
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

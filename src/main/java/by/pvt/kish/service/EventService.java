package by.pvt.kish.service;

import by.pvt.kish.dao.EventDAO;
import by.pvt.kish.exception.DaoException;
import by.pvt.kish.pojos.Event;
import by.pvt.kish.util.ScannerUtil;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Scanner;

import static by.pvt.kish.util.ScannerUtil.*;

/**
 * @author Kish Alexey
 */
public class EventService {

    private static Logger logger = Logger.getLogger(EventService.class.getName());

    public static void saveEvent() {
        Event event = new Event();
        event.setDate(new Date());
        Scanner scanner = new Scanner(System.in);
        event.setTitle(readTitle(scanner));
        try {
            EventDAO.getInstance().saveOrUpdate(event);
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
    }
}

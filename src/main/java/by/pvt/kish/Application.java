package by.pvt.kish;

import by.pvt.kish.util.MenuLoader;
import org.apache.log4j.Logger;

/**
 * @author Kish Alexey
 */
public class Application {

    private static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        MenuLoader.createMenu();
    }
}

package by.pvt.predkel.logger;

import org.apache.log4j.Logger;

/**
 * Created by Admin on 10.05.2016.
 */
public enum MyLogger {
    INSTANCE;
    private Logger logger;

    @SuppressWarnings("rawtypes")
    public void logError(Class sender, String message) {
        logger = Logger.getLogger(sender);
        logger.error(message);
    }
}

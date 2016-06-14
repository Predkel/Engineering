package by.pvt.predkel.utils;

import org.apache.log4j.Logger;

public class PaymentSystemLogger {
    private Logger logger;
    private static PaymentSystemLogger instance;

    private PaymentSystemLogger() {
    }

    public static synchronized PaymentSystemLogger getInstance() {
        if (instance == null) {
            instance = new PaymentSystemLogger();
        }
        return instance;
    }

    public void logError(Class sender, String message) {
        logger = Logger.getLogger(sender);
        logger.error(message);
    }


}
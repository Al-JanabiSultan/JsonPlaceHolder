package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jLogger{

    public static Logger ClassLogger() {
        StackTraceElement myCaller = Thread.currentThread().getStackTrace()[2];
        return LogManager.getLogger(myCaller.getClassName());
    }
}

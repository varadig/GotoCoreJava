package core.logger;

import core.base.CoreBaseClass;
import core.logger.base.CoreBaseLogger;

import java.util.ArrayList;
import java.util.HashMap;

public class CoreLogger extends CoreBaseClass {
    public static final String LOGGER_LOG = "logger.log";

    private ArrayList<CoreBaseLogger> loggers;
    private static CoreLogger instance;


    public static CoreLogger getInstance(ArrayList<CoreBaseLogger> loggers) {
        if (instance == null)
            instance = new CoreLogger(loggers);
        return instance;

    }

    public CoreLogger(ArrayList<CoreBaseLogger> loggers) {

        this.loggers = loggers;
        this.sc.registerService(LOGGER_LOG, this);
    }

    @Override
    public Object execute(HashMap<String, Object> params) {
        if (params.get("message") instanceof String[])
            for (String message : (String[]) params.get("message")) {
                for (CoreBaseLogger logger : this.loggers)
                    logger.addLog(message);

            }
        else if (params.get("message") instanceof String) {
            for (CoreBaseLogger logger : this.loggers)
                logger.addLog((String) params.get("message"));


        }
        return null;
    }
}

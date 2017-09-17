package core.logger;

import core.logger.base.CoreBaseLogger;

/**
 * Created by varadig on 1/25/14.
 */
public class CoreLoggerDebug extends CoreBaseLogger {

    public CoreLoggerDebug()
    {
        this.init();
    }
    private void init()
    {
        this.addLog("LOGGER INITIALIZED");
    }

    @Override
    protected void addLogEntry (String message)
    {
        System.out.println("[CORE] "+message);
    }
}

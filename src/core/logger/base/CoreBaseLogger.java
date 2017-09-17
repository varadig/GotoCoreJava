package core.logger.base;

import core.base.CoreBaseClass;
import core.utils.CoreUtils;

public class CoreBaseLogger extends CoreBaseClass {
    private final String newline = System.getProperty("line.separator");

    public void addLog(String message) {
        this.addLogEntry(message);
    }

    protected void addLogEntry(String message) {
    }

    protected String createEntryFrom(String message) {
        return (CoreUtils.timeStamp() + " ----> " + message + this.newline);
    }

}

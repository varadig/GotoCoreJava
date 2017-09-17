package app;

import app.controller.DataController;
import core.base.CoreBaseApplet;
import core.filesystem.CoreFileSystem;
import core.filesystem.test.FileSystemTest;
import core.filesystem.version.CoreFileSystemJava7;
import core.logger.CoreLogger;
import core.logger.CoreLoggerDebug;
import core.logger.CoreLoggerFile;
import core.logger.base.CoreBaseLogger;
import core.notification.CoreNotificationContainer;

import java.awt.*;
import java.util.ArrayList;

public class Main extends CoreBaseApplet {

    private void startApplication() {
        FileSystemTest fst = new FileSystemTest();
        fst.setPreferredSize(this.getSize());
        fst.setBackground(new Color(0xCCCCCC));
        this.add(fst);
    }

    private void initCoreModules() {
        ArrayList<CoreBaseLogger> loggers = new ArrayList<CoreBaseLogger>();
        loggers.add(new CoreLoggerFile());
        loggers.add(new CoreLoggerDebug());

        CoreLogger.getInstance(loggers);

        CoreFileSystem.getInstance(new CoreFileSystemJava7());
        CoreNotificationContainer.getInstance();
    }

    private void initModules() {
        DataController.getInstance();
    }

    @Override
    public void start() {
        setSize(640, 480);
        this.initContext();
        this.initModules();
        this.initCoreModules();
        this.startApplication();
    }

    private void initContext() {
        this.context.setParam("log.file.path", "/Users/varadig/java_debug.log");
    }
}
package core.logger;

import core.filesystem.CoreFileSystem;
import core.filesystem.version.CoreFileSystemJava7;
import core.logger.base.CoreBaseLogger;

import java.util.ArrayList;

public class CoreLoggerFile extends CoreBaseLogger {
    public static final String PATHS = "log.file.paths";
    public static final String ARCHIVE = "archive.log.file";
    public static final String READ = "read.log.file";

    private ArrayList<String> paths;

    public CoreLoggerFile() {
        this.init();
    }

    private void init() {
        this.paths = (ArrayList<String>) this.context.getParam(PATHS);
        CoreFileSystem.getInstance(new CoreFileSystemJava7());
    }

    @Override
    protected void addLogEntry(String message) {
        for (String path : this.paths) {
            this.sc.getService(CoreFileSystem.APPEND_TEXT_FILE)
                    .addParam(CoreFileSystem.PATH, path)
                    .addParam(CoreFileSystem.CONTENT, this.createEntryFrom(message))
                    .execute();
        }
    }
}

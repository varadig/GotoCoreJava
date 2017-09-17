package core.logger;

import core.logger.base.CoreBaseLogger;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by varadig on 1/25/14.
 */
public class CoreLoggerServer extends CoreBaseLogger {
    public static final String URLS = "server.log.url";
    public static final String FILENAME = "server.log.filename";
    private ArrayList<URL> urls;

    public CoreLoggerServer() {
        this.init();
    }

    private void init() {
        this.urls = (ArrayList<URL>) this.context.getParam(URLS);
    }

    @Override
    protected void addLogEntry(String message) {

        for (URL url : this.urls) {
            try {

                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);

                PrintStream printStream = new PrintStream(connection.getOutputStream());
                printStream.print("log=" + this.createEntryFrom(message));

                if (this.context.hasParam(FILENAME))
                    printStream.print("&filename=" + this.context.getParam(FILENAME));
                else
                    printStream.print("&filename=default");

                connection.getInputStream();

                printStream.close();
            } catch (MalformedURLException exception) {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }

}

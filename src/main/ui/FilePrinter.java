package ui;

import model.Event;
import model.EventLog;
import model.exception.LogException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Represents a file printer for printing the log to file.
 */
public class FilePrinter implements LogPrinter {
    private static final String SEP = System.getProperty("file.separator");
    private static final int LOG_INIT = 1;
    private static int log_num = LOG_INIT;
    private FileWriter fw;

    /**
     * Constructor creates file.  Each log file has a sequential log number
     * starting at LOG_INIT for each run of the application.
     * @throws LogException when any kind of input/output error occurs
     */
    public FilePrinter() throws LogException {
        try {
            File logFile = new File(System.getProperty("user.dir") + SEP
                    + "log" + SEP + "log_" + log_num + ".txt");
            fw = new FileWriter(logFile);
            log_num++;
        } catch (IOException e) {
            throw new LogException("Cannot open file");
        }
    }

    @Override
    public void printLog(EventLog el) throws LogException {
        try {
            for (Event next : el) {
                fw.write(next.toString());
                fw.write("\n\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new LogException("Cannot write to file");
        }
    }
}


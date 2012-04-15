package usefulllogging.server;

import java.util.logging.Level;
import java.util.logging.LogRecord;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.logging.server.StackTraceDeobfuscator;
import com.google.gwt.logging.shared.RemoteLoggingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Alternative implementation that uses slf4j<br>
 * To declare in yout web.xml
 * 
 * @author francois wauquier
 */
public class UsefullRemoteLoggingServiceImpl extends RemoteServiceServlet implements RemoteLoggingService {

    private static StackTraceDeobfuscator deobfuscator;

    private static String loggerNameOverride;

    private enum LogRecordLevelEnum {

	SEVERE(Level.SEVERE), WARNING(Level.WARNING), INFO(Level.INFO), CONFIG(Level.CONFIG), FINE(Level.FINE), FINER(Level.FINER), FINEST(Level.FINEST);

	java.util.logging.Level level;

	private LogRecordLevelEnum(Level javaUtilLoggingLevel) {
	    this.level = javaUtilLoggingLevel;
	}

	static LogRecordLevelEnum getLogRecordLevelEnum(Level javaUtilLoggingLevel) {
	    for (LogRecordLevelEnum logRecordLevelEnum : values()) {
		if (logRecordLevelEnum.level.equals(javaUtilLoggingLevel)) {
		    return logRecordLevelEnum;
		}
	    }
	    return null;
	}

    }

    @Override
    public void init() throws ServletException {
	super.init();
    }

    @Override
    public String logOnServer(LogRecord record) {
	try {
	    Logger logger = LoggerFactory.getLogger(loggerNameOverride == null ? record.getLoggerName() : loggerNameOverride);
	    String permutationStrongName = getPermutationStrongName();
	    if (deobfuscator != null) {
		record = deobfuscator.deobfuscateLogRecord(record, permutationStrongName);
	    }

	    switch (LogRecordLevelEnum.getLogRecordLevelEnum(record.getLevel())) {
	    case FINEST:
	    case FINER:
	    case FINE:
		logger.debug(record.getMessage());
		break;
	    case CONFIG:
	    case INFO:
		logger.info(record.getMessage());
		break;
	    case WARNING:
		logger.warn(record.getMessage());
		break;
	    case SEVERE:
		logger.error(record.getMessage(), record.getThrown());
		break;
	    default:

	    }
	    return null;
	} catch (Exception e) {
	    LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME).error("Error during logOnServer " + record, e);
	    return "Remote logging failed, check stack trace for details.";
	}
    }

    /**
     * By default, messages are logged to a logger that has the same name as the
     * logger that created them on the client. If you want to log all messages
     * from the client to a logger with another name, you can set the override
     * using this method.
     * 
     * @param override
     */
    public void setLoggerNameOverride(String override) {
	loggerNameOverride = override;
    }

    /**
     * By default, this service does not do any deobfuscation. In order to do
     * server side deobfuscation, you must copy the symbolMaps files to a
     * directory visible to the server and set the directory using this method.
     * 
     * @param symbolMapsDir
     */
    public void setSymbolMapsDirectory(String symbolMapsDir) {
	if (deobfuscator == null) {
	    deobfuscator = new StackTraceDeobfuscator(symbolMapsDir);
	} else {
	    deobfuscator.setSymbolMapsDirectory(symbolMapsDir);
	}
    }
}

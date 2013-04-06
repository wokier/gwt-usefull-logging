package usefulllogging.api;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import usefulllogging.format.LogMessageFormat;

/**
 * Usefull Log wraps a {@link Logger} to make it easier to use<br>
 * Allows to use a message or a pattern with arguments
 * 
 * @author francois wauquier
 */
public class Log {

    java.util.logging.Logger logger;

    /**
     * Constructor
     * 
     * @param logger
     */
    protected Log(java.util.logging.Logger logger) {
	super();
	this.logger = logger;
    }

    /**
     * @see Logger#entering(String, String, Object[])
     * @param source
     * @param sourceMethod
     * @param params
     */
    public void entering(Object source, String sourceMethod) {
	finer("{} {}() ...", source.getClass().getName(), sourceMethod);
    }

    /**
     * @see Logger#entering(String, String, Object[])
     * @param source
     * @param sourceMethod
     * @param params
     */
    public void entering(Object source, String sourceMethod, Object... params) {
	String pattern = "{} {} (";
	for (int i = 0; i < params.length; i++) {
	    pattern = pattern + " {" + i + "}";
	}
	pattern = pattern + ") ...";
	finer(pattern, source.getClass().getName(), sourceMethod, params);
    }

    /**
     * @see Logger#finest(String)
     * @param message
     */
    public void finest(Object message) {
	logger.finest(String.valueOf(message));
    }

    /**
     * @see Logger#finest(String)
     * @param pattern
     * @param arguments
     */
    public void finest(String pattern, Object... arguments) {
	if (logger.isLoggable(Level.FINEST)) {
	    logger.finest(LogMessageFormat.format(pattern, arguments));
	}
    }

    /**
     * @see Logger#finer(String)
     * @param message
     */
    public void finer(Object message) {
	logger.finer(String.valueOf(message));
    }

    /**
     * @see Logger#finer(String)
     * @param pattern
     * @param arguments
     */
    public void finer(String pattern, Object... arguments) {
	if (logger.isLoggable(Level.FINER)) {
	    logger.finer(LogMessageFormat.format(pattern, arguments));
	}
    }

    /**
     * Log a FINER message
     * 
     * @see Logger#finer(String)
     * @param message
     */
    public void debug(Object message) {
	finer(message);
    }

    /**
     * Log a FINER message
     * 
     * @see Logger#finer(String)
     * @param pattern
     * @param arguments
     * 
     */
    public void debug(String pattern, Object... arguments) {
	finer(pattern, arguments);
    }

    /**
     * @see Logger#fine(String)
     * @param message
     */
    public void fine(Object message) {
	logger.fine(String.valueOf(message));
    }

    /**
     * @see Logger#fine(String)
     * @param pattern
     * @param arguments
     */
    public void fine(String pattern, Object... arguments) {
	if (logger.isLoggable(Level.FINE)) {
	    logger.fine(LogMessageFormat.format(pattern, arguments));
	}
    }

    /**
     * @see Logger#config(String)
     * @param message
     */
    public void config(Object message) {
	logger.config(String.valueOf(message));
    }

    /**
     * @see Logger#config(String)
     * @param pattern
     * @param arguments
     */
    public void config(String pattern, Object... arguments) {
	if (logger.isLoggable(Level.CONFIG)) {
	    logger.config(LogMessageFormat.format(pattern, arguments));
	}
    }

    /**
     * @see Logger#info(String)
     * @param message
     */
    public void info(Object message) {
	logger.info(String.valueOf(message));
    }

    /**
     * @see Logger#info(String)
     * @param pattern
     * @param arguments
     */
    public void info(String pattern, Object... arguments) {
	if (logger.isLoggable(Level.INFO)) {
	    logger.info(LogMessageFormat.format(pattern, arguments));
	}
    }

    /**
     * @see Logger#warning(String)
     * @param message
     */
    public void warning(Object message) {
	logger.warning(String.valueOf(message));
    }

    /**
     * @see Logger#warning(String)
     * @param pattern
     * @param arguments
     */
    public void warning(String pattern, Object... arguments) {
	if (logger.isLoggable(Level.WARNING))
	    logger.warning(LogMessageFormat.format(pattern, arguments));
    }

    /**
     * @see Logger#severe(String)
     * @param message
     */
    public void severe(Object message) {
	logger.severe(String.valueOf(message));
    }

    /**
     * @see Logger#severe(String)
     * @param pattern
     * @param arguments
     */
    protected void severe(String pattern, Object... arguments) {
	if (logger.isLoggable(Level.SEVERE)) {
	    logger.severe(LogMessageFormat.format(pattern, arguments));
	}
    }

    /**
     * @see Logger#severe(String)
     * @param message
     * @param error
     */
    public void severe(Object message, Throwable error) {
	if (logger.isLoggable(Level.SEVERE)) {
	    LogRecord logRecord = new LogRecord(Level.SEVERE, String.valueOf(message));
	    logRecord.setThrown(error);
	    logger.log(logRecord);
	}
    }

    /**
     * @see Logger#severe(String)
     * @param pattern
     * @param error
     * @param arguments
     */
    public void severe(String pattern, Throwable error, Object... arguments) {
	if (logger.isLoggable(Level.SEVERE)) {
	    LogRecord logRecord = new LogRecord(Level.SEVERE, LogMessageFormat.format(pattern, arguments));
	    logRecord.setLoggerName(logger.getName());
	    logRecord.setThrown(error);
	    logger.log(logRecord);
	}
    }

    /**
     * Log a SEVERE message
     * 
     * @see Logger#severe(String)
     * @param message
     */
    public void error(Object message) {
	severe(message);
    }

    /**
     * Log a SEVERE message
     * 
     * @see Logger#severe(String)
     * @param pattern
     * @param arguments
     */
    protected void error(String pattern, Object... arguments) {
	severe(pattern, arguments);
    }

    /**
     * Log a SEVERE message
     * 
     * @see Logger#severe(String)
     * @param message
     * @param error
     */
    public void error(Object message, Throwable error) {
	severe(message, error);
    }

    /**
     * Log a SEVERE message
     * 
     * @see Logger#severe(String)
     * @param pattern
     * @param error
     * @param arguments
     */
    public void error(String pattern, Throwable error, Object... arguments) {
	severe(pattern, error, arguments);
    }
}

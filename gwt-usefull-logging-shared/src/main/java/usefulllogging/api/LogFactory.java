package usefulllogging.api;

import java.util.logging.Logger;

/**
 * Usefull Log factory, uses the static methods of {@link Logger}
 * 
 * @author francois wauquier
 */
public class LogFactory {

    /**
     * @see Logger#getLogger(String)
     * @param name
     * @return
     */
    public static Log getLog(String name) {
	return new Log(Logger.getLogger(name));
    }

    /**
     * @see Logger#getLogger(String)
     * @param clazz
     * @return
     */
    public static Log getLog(@SuppressWarnings("rawtypes") Class clazz) {
	return new Log(Logger.getLogger(clazz.getName()));
    }

}
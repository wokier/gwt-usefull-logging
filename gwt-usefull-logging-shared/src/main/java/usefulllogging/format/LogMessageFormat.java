package usefulllogging.format;

import java.util.Arrays;

import com.google.common.base.Joiner;

/**
 * Meaage format
 * 
 * @author francois wauquier
 */
public class LogMessageFormat {

    /**
     * Format a message
     * 
     * @param pattern
     * @param arguments
     * @return
     */
    public static String format(String pattern, Object... arguments) {
	if (arguments == null) {
	    arguments = new Object[] { null };
	}
	String formatted = pattern;
	int i = 0;
	boolean found = false;
	do {
	    String delimiter = "{" + i + "}";
	    found = false;
	    while (formatted.contains(delimiter) && i < arguments.length) {
		formatted = formatted.replace(delimiter, String.valueOf(arguments[i]));
		found = true;
	    }
	    if (found) {
		i++;
	    }
	} while (found);
	while (formatted.contains("{}") && i < arguments.length) {
	    formatted = formatted.replaceFirst("\\{\\}", String.valueOf(arguments[i]).replace("$", "\\$"));
	    i++;
	}
	if (i < arguments.length) {
	    formatted = formatted + "[" + Joiner.on(',').join(Arrays.asList(arguments).subList(i, arguments.length)) + "]";
	}
	return formatted;
    }
}

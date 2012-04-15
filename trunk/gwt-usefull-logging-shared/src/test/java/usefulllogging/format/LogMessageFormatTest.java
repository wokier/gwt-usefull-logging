package usefulllogging.format;

import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;

public class LogMessageFormatTest {

    @Test
    public void testFormat() {
	assertEquals("pattern allows 1 argument", LogMessageFormat.format("pattern allows {0} argument", 1));
	assertEquals("pattern allows multiple arguments", LogMessageFormat.format("pattern allows {0} {1}", "multiple", "arguments"));
	assertEquals("arguments can be reused here and here", LogMessageFormat.format("arguments can be reused {0} and {0}", "here"));
	assertEquals("argument index is not mandatory", LogMessageFormat.format("argument index is {} mandatory", "not"));
	assertEquals("pattern can mix arguments with index and without index", LogMessageFormat.format("pattern can mix arguments {0} and {}", "with index", "without index"));
	assertEquals("double are displayed with dot like 3.14", LogMessageFormat.format("double are displayed with dot like {}", 3.14d));
	assertEquals("null are displayed as null", LogMessageFormat.format("null are displayed as {}", new Object[] { null }));
	assertEquals("too many arguments[are added at the end]", LogMessageFormat.format("{} {} {}", "too", "many", "arguments", "are added at the end"));
	assertEquals("not enought arguments remains {}", LogMessageFormat.format("{} arguments remains {}", "not enought"));
    }

    @Test
    public void testLogOutput() throws Exception {
	LogManager.getLogManager().readConfiguration(getClass().getClassLoader().getResourceAsStream("logging.properties"));
	Logger.getLogger(this.getClass().getName()).log(Level.FINER, "testEntering");
	Logger.getLogger(this.getClass().getName()).entering(this.getClass().getName(), "testEntering");
    }
}

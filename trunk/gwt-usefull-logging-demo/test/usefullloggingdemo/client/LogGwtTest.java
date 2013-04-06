package usefullloggingdemo.client;

import usefulllogging.api.Log;
import usefulllogging.api.LogFactory;

import com.google.gwt.junit.client.GWTTestCase;

public class LogGwtTest extends GWTTestCase {

    Log log = LogFactory.getLog(LogGwtTest.class);

    @Override
    public String getModuleName() {
	return "usefullloggingdemo.UsefullLoggingDemo";
    }

    public void testDebug() throws Exception {

	log.debug("debug");

    }

    public void testSevere() throws Exception {
	log.severe("severe", new RuntimeException("severe"));
    }

}

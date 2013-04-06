package usefullloggingdemo;

import org.junit.Test;

import usefulllogging.api.Log;
import usefulllogging.api.LogFactory;

public class LogTest {

    Log log = LogFactory.getLog(LogTest.class);

    @Test
    public void testDebug() throws Exception {

	log.debug("debug");

    }

    @Test
    public void testSevere() throws Exception {
	log.severe("severe", new RuntimeException("severe"));
    }

}

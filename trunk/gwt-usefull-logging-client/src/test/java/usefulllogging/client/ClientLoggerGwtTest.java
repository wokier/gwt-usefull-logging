package usefulllogging.client;

import usefulllogging.api.Log;
import usefulllogging.api.LogFactory;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.Command;

public class ClientLoggerGwtTest extends GWTTestCase {

    Log log = LogFactory.getLog(this.getClass());

    interface Inner {
	void doSomething();
    }

    @Override
    public String getModuleName() {
	return "usefulllogging.UsefullLoggingTest";
    }

    public void testEntering() throws Exception {

	log.entering(this, "onModuleLoad");

    }

    public void testEnteringAnonymous() throws Exception {
	new Inner() {
	    @Override
	    public void doSomething() {
		log.entering(this, "onModuleLoad");
	    }
	}.doSomething();
    }

    public void testEnteringScheduleAnonymous() throws Exception {
	Scheduler.get().scheduleDeferred(new Command() {
	    @Override
	    public void execute() {
		new Inner() {
		    @Override
		    public void doSomething() {
			log.entering(this, "onModuleLoad");
		    }
		}.doSomething();
	    }
	});
    }
}

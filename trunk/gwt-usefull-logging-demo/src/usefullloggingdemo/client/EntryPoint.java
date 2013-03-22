package usefullloggingdemo.client;

import usefulllogging.api.Log;
import usefulllogging.api.LogFactory;
import usefullloggingdemo.client.view.View;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EntryPoint implements com.google.gwt.core.client.EntryPoint, UncaughtExceptionHandler {

    Log log = LogFactory.getLog("UsefullLoggingDemo");

    @Override
    public void onModuleLoad() {
	GWT.setUncaughtExceptionHandler(this);
	log.entering(this, "onModuleLoad");
	RootPanel.get("content").add(new View());
	RootPanel.get("loading").setVisible(false);
	Scheduler.get().scheduleDeferred(new Command() {

	    @Override
	    public void execute() {
		log.entering(this, "doModuleLoad");
		doModuleLoad();
	    }
	});
    }

    protected void doModuleLoad() {
	log.info("loaded");
    }

    @Override
    public void onUncaughtException(Throwable e) {
	Window.alert(e.getMessage());
    }
}

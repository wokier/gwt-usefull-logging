package usefullloggingdemo.client;

import usefulllogging.api.Log;
import usefulllogging.api.LogFactory;
import usefullloggingdemo.client.view.View;

import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

    Log log = LogFactory.getLog("UsefullLoggingDemo");

    @Override
    public void onModuleLoad() {
	log.entering(this, "onModuleLoad");
	RootPanel.get("content").add(new View());
	RootPanel.get("loading").setVisible(false);
    }
}

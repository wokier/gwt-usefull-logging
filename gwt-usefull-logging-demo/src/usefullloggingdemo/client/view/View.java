package usefullloggingdemo.client.view;

import usefulllogging.api.Log;
import usefulllogging.api.LogFactory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class View extends Composite {

    private static final Log LOG = LogFactory.getLog(View.class);

    private static ViewUiBinder uiBinder = GWT.create(ViewUiBinder.class);

    interface ViewUiBinder extends UiBinder<Widget, View> {
    }

    public View() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("finestButton")
    public void onFinestButtonClick(ClickEvent event) {
	LOG.finest("finest Message");
    }

    @UiHandler("finerButton")
    public void onFinerButtonClick(ClickEvent event) {
	LOG.finer("finer Message");
    }

    @UiHandler("fineButton")
    public void onFineButtonClick(ClickEvent event) {
	LOG.fine("fine Message");
    }

    @UiHandler("configButton")
    public void onConfigButtonClick(ClickEvent event) {
	LOG.config("config Message");
    }

    @UiHandler("infoButton")
    public void onInfoButtonClick(ClickEvent event) {
	LOG.info("info Message");
    }

    @UiHandler("warningButton")
    public void onWarningButtonClick(ClickEvent event) {
	LOG.warning("warning Message");
    }

    @UiHandler("severeButton")
    public void onSevereButtonClick(ClickEvent event) {
	LOG.severe("severe Message", new RuntimeException("ExceptionMessage"));
    }

    @UiHandler("infoMessageButton")
    public void onInfoMessageButtonClick(ClickEvent event) {
	LOG.info("Using a pattern is {}", "cool");
    }

    @UiHandler("debugNullButton")
    public void onNullButtonClick(ClickEvent event) {
	LOG.debug(null);
    }
}

package next.celebs;

import next.celebs.di.UiGinjector;
import next.celebs.di.Storage.JsStorageStrategy;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class Main implements EntryPoint {

	public void onModuleLoad() {
		init();
	}

	public void init() {
		Log.info("starting app");
		final RootPanel rootPanel = RootPanel.get("root");
		rootPanel.setVisible(false);

		final UiGinjector ginjector = UiGinjector.INSTANCE;
		ginjector.getStorage().init(new JsStorageStrategy());

		// init and make it visible
		ginjector.getUiComponents().getLeftMenu().show();
		ginjector.getUiComponents().getTopMenu().show();
		ginjector.getUiComponents().getTopMenu().getBackCommand().execute();
		ginjector.getUiComponents().getSubMenuPage();
//		ginjector.getEventBus().fireEvent(new BackButtonEvent(Type.FRONT_PAGE));

		rootPanel.setVisible(true);

		RootPanel loadingPanel = RootPanel.get("loading");
		loadingPanel.setVisible(false);

		if ("8888".equals(Window.Location.getPort())) {
			ginjector.getContext().setDevMode(true);
		}

		// // Used for debuggin only
		// Window.addResizeHandler(new ResizeHandler() {
		// @Override
		// public void onResize(ResizeEvent event) {
		// int cH = Window.getClientHeight();
		// int cW = Window.getClientWidth();
		//
		// int scH = Window.getScrollTop();
		// int scL = Window.getScrollLeft();
		// Log.info("clientHeight:" + cH + ", clientWidth:" + cW + "| scrollTop:" + scH + ", scrollLeft:" + scL);
		// }
		// });

		// listenForEventUpdates();

		// ctx.getEventBus().fireEvent(new LsShowSportsEvent(true));
		// RootPanel.get("root").setVisible(false);

		// Timer t2 = new Timer() {
		// public void run() {
		// ctx.getUiSingleton().getNotificationPage().doShow();
		// ctx.getEventBus().fireEvent(new SwimwearEvent());
		// }
		// };
		// t2.schedule(3000);
	}

}

package next.celebs.model;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public interface YahooImages {

	String getId();

	JsArray<JavaScriptObject> getPhotos();

	/**
	 * JSO_ implementation
	 */
	class JSO_ extends JavaScriptObject implements YahooImages {

		protected JSO_() {

		}

		@Override
		public final native String getId() /*-{
			return this.conversationId;
		}-*/;

		public final native JsArray<JavaScriptObject> getPhotos() /*-{
			return this.ResultSet.Result;
		}-*/;
	}

}
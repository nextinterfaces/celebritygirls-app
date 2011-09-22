package next.celebs.model;

import com.google.gwt.core.client.JavaScriptObject;

public interface YahooPhoto {

	String getUrl();
	
	String getThumbUrl();
	
	String getThumbWidth();
	
	String getThumbHeight();

	/**
	 * JSO_ implementation
	 */
	class JSO_ extends JavaScriptObject implements YahooPhoto {

		protected JSO_() {

		}

		@Override
		public final native String getUrl() /*-{
			return this.Url;
		}-*/;

		@Override
		public final native String getThumbUrl() /*-{
			return this.Thumbnail.Url;
		}-*/;

		@Override
		public final native String getThumbWidth() /*-{
			return this.Thumbnail.Width;
		}-*/;

		@Override
		public final native String getThumbHeight() /*-{
			return this.Thumbnail.Height;
		}-*/;
	}

}
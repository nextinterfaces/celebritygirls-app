package next.celebs.dao;

import next.celebs.Log;
import next.celebs.api.ResponseReader;
import next.celebs.api.API.Response;
import next.celebs.di.Context;
import next.celebs.ui.MiscUtils;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.URL;

public class WikipediaDao {

	public static void init(String wikiTitle, Context ctx, final Response<String[]> response) {

		String devUrl = "http://127.0.0.1:8888/zz_wiki.html";
		String prodUrl = "http://en.wikipedia.org/w/index.php?action=render&title=" + wikiTitle;

		String url = ctx.isDevMode() ? devUrl : prodUrl;

		getWiki(url, new ResponseReader() {
			@Override
			public void onSuccess(com.google.gwt.http.client.Response resp) {
				String fullText = resp.getText();

				int beginInx = fullText.indexOf("<p>");
				int endInx = fullText.indexOf("<table id=\"toc\"");
				// Window.alert("beginInx=" + beginInx + ", endInx=" + endInx);
				String result = fullText.substring(beginInx, endInx);
				// Window.alert("[" + result + "]");
				result = MiscUtils.filterWiki(result);
//				result = result.replace("<a ", "<span ");
//				result = result.replace("</a>", "</span>");
//				result = result.replace("[", "<!--");
//				result = result.replace("]", "-->");
				String[] data = new String[]{result, fullText};
				response.read(data);
			}

			@Override
			public String getName() {
				return null;
			}
		});
	}

	public static void getWiki(String url, ResponseReader responseReader) {

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		try {
			builder.sendRequest(null, new Callback_(responseReader));
		} catch (RequestException e) {
			Log.error("RequestException: " + e.getMessage());
			responseReader.onError(null, e);
		}
	}

	private static class Callback_ implements RequestCallback {
		ResponseReader reader;

		public Callback_(ResponseReader reader) {
			this.reader = reader;
		}

		public void onError(Request request, Throwable e) {
			Log.warn("RequestCallback::onError");
			reader.onError(null, e);
		}

		@Override
		public void onResponseReceived(Request request, com.google.gwt.http.client.Response response) {
			if (200 == response.getStatusCode()) {
				reader.onSuccess(response);
			} else {
				Log.warn("RequestCallback::onResponseReceived, not supported status '" + response.getStatusCode() + "'");
				reader.onError(response, null);
			}
		}
	}

}

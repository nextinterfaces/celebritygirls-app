package next.celebs.api;

import next.celebs.JsUtils;

import com.google.gwt.http.client.Response;

public abstract class JsonReader<T> extends ResponseReader {

	@Override
	public String getName() {
		return "JsonReader";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onSuccess(Response response) {
		String txt = response.getText();
		T t = (T) JsUtils.toJSO(txt);
		read(t);
	}

	abstract public void read(T obj);

}

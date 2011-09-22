package next.celebs.api;

import java.util.ArrayList;

import next.celebs.JsUtils;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

public abstract class JsonArrayReader<T, J extends JavaScriptObject> extends ResponseReader {

	@Override
	public String getName() {
		return "JsonArrayReader";
	}

	@Override
	public void onSuccess(Response response) {
		String txt = response.getText();
		Window.alert("1 succss '" + txt + "'");
		String escapedJSON = JsonUtils.escapeJsonForEval(txt);
		Window.alert("2 succss '" + escapedJSON + "'");
		JsArray<J> j = JsonUtils.safeEval(escapedJSON);
		Window.alert("3 succss '" + j + "'");
		ArrayList<T> msgs = JsUtils.toArray(j);
		Window.alert("4 msgs '" + msgs + "'");
		read(msgs, escapedJSON);
	}

	abstract public void read(ArrayList<T> data, String jsonData);

}

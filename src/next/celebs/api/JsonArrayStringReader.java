package next.celebs.api;

import java.util.ArrayList;

import next.celebs.JsUtils;


import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Response;

public abstract class JsonArrayStringReader extends ResponseReader {

	@Override
	public String getName() {
		return "JsonArrayStringReader";
	}

	@Override
	public void onSuccess(Response response) {
		String txt = response.getText();
		String escapedJSON = JsonUtils.escapeJsonForEval(txt);
		JsArrayString j = JsonUtils.safeEval(escapedJSON);
		ArrayList<String> msgs = JsUtils.toListString(j);
		read(msgs);
	}

	abstract public void read(ArrayList<String> data);

}

package next.celebs.api;


import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

public abstract class ResponseReader {

	public abstract void onSuccess(Response response);

	public abstract String getName();

	public void onError(Response response, Throwable e) {
		if (e != null) {
			Window.alert("ResponseReader::onError " + e.getMessage());
			throw new RuntimeException(getName() + " error:" + e);
		}

		if (response != null) {
			int status = response.getStatusCode();

			if (status > 399 && status < 500) {
				String txt = response.getText() != null ? response.getText().trim() : "";
				throw new BusinessException(status, getName() + " error: " + status + ", response \"" + txt + "\"");

			} else {
				String txt = response.getText() != null ? response.getText().trim() : "";
				throw new RuntimeException(getName() + " error: " + status + ", response \"" + txt + "\"");
			}

		} else {
			throw new RuntimeException(getName() + " error: ");
		}
	}

}

package next.celebs.ui;

import com.google.gwt.user.client.ui.HTML;

public class TextButton extends YButton {

	public TextButton(String text) {

		addStyleName("yTextButton");
//		setSize(200 + "px", 30 + "px");

		setWidget(new HTML(text));
	}
}
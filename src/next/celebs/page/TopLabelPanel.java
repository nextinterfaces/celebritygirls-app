package next.celebs.page;

import next.celebs.UiResources;
import next.celebs.ui.ImageButton;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;

public class TopLabelPanel extends SimplePanel {

	private final ImageButton hTitleImg;
	private final HTML hTitleLabel;

	final static UiResources RES = UiResources.INSTANCE;

	public TopLabelPanel() {
		setStyleName("yTitle");
		hTitleImg = new ImageButton(RES.hSwimwear());
		hTitleLabel = new HTML();
		hTitleLabel.setStyleName("yTitleLabel");
		hTitleLabel.setWidth("674px");
		hTitleLabel.setHeight("60px");

		this.setWidget(hTitleImg);
	}

	public void setResource(ImageResource res) {
		hTitleLabel.removeFromParent();
		hTitleImg.setResource(res);
		this.setWidget(hTitleImg);
	}

	public void setText(String text) {
		hTitleImg.removeFromParent();
		hTitleLabel.setHTML("<p>" + text + "</p>");
		this.setWidget(hTitleLabel);
	}

}

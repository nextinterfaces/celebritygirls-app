package next.celebs.ui;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;

public class OverlayPopup extends PopupPanel {

	private final OverlayWrapper overlayWrapper;

	public OverlayPopup() {
		this(false, false);
	}

	public OverlayPopup(boolean autoHide, boolean modal) {
		super(autoHide, modal);
		overlayWrapper = new OverlayWrapper(this);
		setAnimationEnabled(true);
	}

	public OverlayPopup(boolean autoHide) {
		this(autoHide, false);
	}

	@Override
	public void show() {
		overlayWrapper.showOverlay();
		super.show();
	}

	@Override
	public void hide() {
		super.hide();
	}

	public void doShow() {
		this.setPopupPositionAndShow(new PositionCallback() {
			@Override
			public void setPosition(int offsetWidth, int offsetHeight) {
				int winY = Window.getClientHeight();
				int y = (winY - offsetHeight) / 2;
				int x = (Window.getClientWidth() - offsetWidth) / 2;
				OverlayPopup.this.setPopupPosition(x, y);
			}
		});
	}
}

package next.celebs.page;

import next.celebs.FxUtil;
import next.celebs.Log;
import next.celebs.di.Context;

import org.adamtacy.client.ui.effects.core.NMorphStyle;


import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.PopupPanel;

public class BrandingPage extends PopupPanel {

	private boolean isHidden = true;

	public BrandingPage(Context ctx_) {
		setStyleName("yBrandingPage yPopupPage");

		this.getElement().getStyle().setOpacity(0);
		setPopupPosition(870, 560);
		Frame frame = new Frame("zz_google.html");
		frame.setSize("150px", "40px");
		setWidget(frame);
		show();
	}

	public void doHide() {
		if (isHidden) {
			return;
		}

		NMorphStyle eff = FxUtil.doHide(this, null);
		// eff.addEffectCompletedHandler(new EffectCompletedHandler() {
		// @Override
		// public void onEffectCompleted(EffectCompletedEvent event) {
		// setPopupPosition(1025, 0);
		// }
		// });
		eff.play();

		isHidden = true;
	}

	public void doShow() {
		Log.info("WallpaperPage::doShow");
		if (!isHidden) {
			return;
		}
		// this.getElement().getStyle().setOpacity(0);

		setPopupPosition(870, 560);
		NMorphStyle eff = FxUtil.doShow(this, null);
		eff.play();

		isHidden = false;
	}

}

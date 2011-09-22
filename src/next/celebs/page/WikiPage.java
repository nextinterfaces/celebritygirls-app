package next.celebs.page;

import next.celebs.FxUtil;
import next.celebs.UiResources;
import next.celebs.di.Context;

import org.adamtacy.client.ui.effects.core.NMorphStyle;


import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

public class WikiPage extends PopupPanel implements IPage {

	final static UiResources RES = UiResources.INSTANCE;
	private boolean isHidden = true;
	private HTML wikiHMTL;

	private Context ctx;

	public WikiPage(Context ctx_) {
		this.ctx = ctx_;
		setStyleName("yWikiPage");
		setWidth("680px");

		setPopupPosition(336, 88);
		wikiHMTL = new HTML();
		setWidget(wikiHMTL);
		show();
	}

	@Override
	public void doHide() {
		ctx.getUi().getBrandingPage().doHide();
		if (isHidden) {
			return;
		}

		NMorphStyle eff = FxUtil.doHide(this, null);
		eff.play();

		isHidden = true;
	}

	@Override
	public void doShow() {
		ctx.getUi().getBrandingPage().doShow();
		if (!isHidden) {
			return;
		}
		setPopupPosition(336, 88);

		NMorphStyle eff = FxUtil.doShow(this, null);
		eff.play();

		isHidden = false;
	}

	public HTML getWikiHMTL() {
		return wikiHMTL;
	}

	@Override
	public void doClear() {
		wikiHMTL.setText("");
	}

}

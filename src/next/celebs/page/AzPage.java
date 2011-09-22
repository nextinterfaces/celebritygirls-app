package next.celebs.page;

import next.celebs.FxUtil;
import next.celebs.Globals;
import next.celebs.UiResources;
import next.celebs.di.Context;
import next.celebs.event.AzNameEvent;
import next.celebs.ui.MiscUtils;
import next.celebs.ui.MiscUtils.CallBack;

import org.adamtacy.client.ui.effects.core.NMorphStyle;


import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

public class AzPage extends PopupPanel implements IPage {

	final static UiResources RES = UiResources.INSTANCE;
	private boolean isHidden = true;

	private final Context ctx;

	public AzPage(Context ctx_) {
		this.ctx = ctx_;
		setStyleName("yAzPage yPopupPage");
		setWidth("680px");

		setPopupPosition(336, 88);
		show();

		FlowPanel namesP = new FlowPanel();
		ScrollPanel scrollPanel = new ScrollPanel(namesP);
		setWidget(scrollPanel);
		init(scrollPanel, namesP);
	}

	void init(ScrollPanel scrollPanel, FlowPanel nested) {

		scrollPanel.setSize(Globals.WRAPPER_WIDTH + "px", Globals.WRAPPER_HEIGHT + "px");

		MiscUtils.populateNamesScrollPanel(new CallBack() {
			@Override
			public void onClick(String name) {
				doHide();
				ctx.getEventBus().fireEvent(new AzNameEvent(name));
			}
		}, nested, ctx);
	}

	@Override
	public void doHide() {
		if (isHidden) {
			return;
		}
		NMorphStyle eff = FxUtil.doHide(this, null);
		eff.play();

		isHidden = true;
	}

	@Override
	public void doShow() {
		if (!isHidden) {
			return;
		}
		setPopupPosition(336, 88);

		NMorphStyle eff = FxUtil.doShow(this, null);
		eff.play();

		isHidden = false;
	}

	@Override
	public void doClear() {
		// TODO Auto-generated method stub
	}

}

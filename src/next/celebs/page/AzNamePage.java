package next.celebs.page;

import next.celebs.FxUtil;
import next.celebs.Globals;
import next.celebs.UiResources;
import next.celebs.di.Context;
import next.celebs.event.SubMenuEvent;
import next.celebs.event.SubMenuHandler;
import next.celebs.event.SubMenuEvent.Type;
import next.celebs.model.Key;

import org.adamtacy.client.ui.effects.core.NMorphStyle;


import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

public class AzNamePage extends PopupPanel implements IPage {

	final static UiResources RES = UiResources.INSTANCE;
	private boolean isHidden = true;

	private SearchImageWidget searchWidget;

	private final Context ctx;
	private String searchName;

	public AzNamePage(Context ctx_) {
		this.ctx = ctx_;
		setStyleName("yAzPage yPopupPage");
		setWidth("680px");

		this.getElement().getStyle().setOpacity(0);
		setPopupPosition(336, 88);
		show();

		FlowPanel namesP = new FlowPanel();

		ScrollPanel scrollPanel = new ScrollPanel(namesP);
		scrollPanel.setSize(Globals.WRAPPER_WIDTH + "px", Globals.WRAPPER_HEIGHT + "px");

		setWidget(scrollPanel);

		listenSubMenu();
	}

	void listenSubMenu() {
		ctx.getEventBus().addHandler(SubMenuEvent.TYPE, new SubMenuHandler() {
			@Override
			public void onExecute(SubMenuEvent e) {
				if (e.getType() == Type.AZ) {
					doSubMenuSearch(getSearchName() + " " + e.getSubSearch());
				}
			}
		});
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public void doSubMenuSearch(String query) {
		doClear();
		System.out.println("::doSubMenuSearch '" + query + "' ");
		searchWidget = new SearchImageWidget(new Key(query, query), 2, 10, ctx);
		setWidget(searchWidget);
	}

	@Override
	public void doHide() {
		ctx.getUi().getBrandingPage().doHide();
		doClear();
		if (isHidden) {
			return;
		}
		NMorphStyle eff = FxUtil.doHide(this, null);
		eff.play();

		isHidden = true;
	}

	@Override
	public void doShow() {
		if (searchWidget == null) {
			String query = getSearchName();
			System.out.println("::doShow '" + query + "' ");
			searchWidget = new SearchImageWidget(new Key(query, query), 2, 10, ctx);
			setWidget(searchWidget);
		}
		if (!isHidden) {
			return;
		}
		setPopupPosition(336, 88);

		NMorphStyle eff = FxUtil.doShow(this, null);
		eff.play();

		isHidden = false;

		ctx.getUi().getBrandingPage().doShow();
	}

	@Override
	public void doClear() {
		if (searchWidget != null) {
			searchWidget.removeFromParent();
			searchWidget = null;
		}
	}

}

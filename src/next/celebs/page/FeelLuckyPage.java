package next.celebs.page;

import next.celebs.FxUtil;
import next.celebs.UiResources;
import next.celebs.di.Context;
import next.celebs.event.SubMenuEvent;
import next.celebs.event.SubMenuHandler;
import next.celebs.event.SubMenuEvent.Type;
import next.celebs.model.Key;

import org.adamtacy.client.ui.effects.core.NMorphStyle;


import com.google.gwt.user.client.ui.PopupPanel;

public class FeelLuckyPage extends PopupPanel implements IPage {

	final static UiResources RES = UiResources.INSTANCE;
	private boolean isHidden = true;
	private String searchName;

	private final Context ctx;

	private SearchImageWidget searchWidget;

	public FeelLuckyPage(Context ctx_) {
		this.ctx = ctx_;
		setStyleName("yFeelLuckyPage yPopupPage");
		setWidth("680px");

		setPopupPosition(336, 88);
		show();
		listenSubMenu();
	}

	void listenSubMenu() {
		ctx.getEventBus().addHandler(SubMenuEvent.TYPE, new SubMenuHandler() {
			@Override
			public void onExecute(SubMenuEvent e) {
				if (e.getType() == Type.FEEL_LUCKY) {
					doSubMenuSearch(e.getSubSearch() + " " + getSearchName());
				}
			}
		});
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

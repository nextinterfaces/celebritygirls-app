/*
 * Copyright 2011 Vancouver Ywebb Consulting Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
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

public class SwimwearPage extends PopupPanel implements IPage {

	final static UiResources RES = UiResources.INSTANCE;
	private boolean isHidden = true;
	private SearchImageWidget searchWidget;
	private String searchName;
	private String searchSubMenuString = "";

	private Context ctx;

	public SwimwearPage(Context ctx_) {
		this.ctx = ctx_;
		setStyleName("ySwimwearPage yPopupPage");
		setWidth("680px");

		setPopupPosition(336, 88);
		show();
		listenSubMenu();
	}

	void listenSubMenu() {
		ctx.getEventBus().addHandler(SubMenuEvent.TYPE, new SubMenuHandler() {
			@Override
			public void onExecute(SubMenuEvent e) {
				if (e.getType() == Type.SWIMWEAR) {
					doSubMenuSearch(Key.SWIMWEAR.getSearchQuery() + " " + e.getSubSearch());
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

	public String getSearchSubMenuString() {
		return searchSubMenuString;
	}

	public void setSearchSubMenuString(String searchSubMenuString) {
		this.searchSubMenuString = searchSubMenuString;
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

	public void doSubMenuSearch(String query) {
		doClear();
		System.out.println("::doSubMenuSearch '" + query + "' ");
		searchWidget = new SearchImageWidget(new Key(query, query), 2, 10, ctx);
		setWidget(searchWidget);
	}

	@Override
	public void doShow() {
		if (searchWidget == null) {
			System.out.println("::doShow '" + Key.SWIMWEAR.getSearchQuery() + "' ");
			searchWidget = new SearchImageWidget(Key.SWIMWEAR, 2, 10, ctx);
			setWidget(searchWidget);
		}

		ctx.getUi().getBrandingPage().doShow();
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
		if (searchWidget != null) {
			searchWidget.removeFromParent();
			searchWidget = null;
		}
	}

}

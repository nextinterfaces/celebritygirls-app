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

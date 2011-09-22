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

import next.celebs.UiResources;
import next.celebs.ui.ImageButton;
import next.celebs.ui.MiscUtils;
import next.celebs.ui.OverlayPopup;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;

public class WikiPopup extends OverlayPopup {

	final static UiResources RES = UiResources.INSTANCE;
	ImageButton btnArticle = new ImageButton(RES.btnArticle());
	final ScrollPanel scrollPanel = new ScrollPanel();

	public WikiPopup(String name) {
		this.addStyleName("yDialog");
		
		scrollPanel.setStyleName("scroll");
		
		Image loadingImg = new Image("images/loading.gif");
		loadingImg.setStyleName("loading");
		scrollPanel.setWidget(loadingImg);
		scrollPanel.setSize("500px", "300px");

		FlowPanel allPanel = new FlowPanel();
		allPanel.add(scrollPanel);
		String filteredName = name.replace(" ", "_");
		HTML smallTxt = new HTML("All text is available under the terms of the GNU Free Documentation License. "
				+ "<p class='small'>Original content available at <u>en.wikipedia.org/wiki/" + filteredName + "</u></p>");
		smallTxt.setStyleName("ySmallTxt");
		allPanel.add(smallTxt);

		HorizontalPanel hp = new HorizontalPanel();
		ImageButton wikiBtn = new ImageButton(RES.wikiTxt());

		ImageButton btnClose = new ImageButton(RES.btnClose());
		btnClose.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				WikiPopup.this.hide();
			}
		});

		hp.add(wikiBtn);
		hp.add(btnArticle);
		hp.add(btnClose);
		
		hp.setWidth("500px");

		hp.setCellHorizontalAlignment(btnArticle, HasHorizontalAlignment.ALIGN_CENTER);
		hp.setCellHorizontalAlignment(btnClose, HasHorizontalAlignment.ALIGN_RIGHT);

		allPanel.add(hp);

		this.setWidget(allPanel);
	}

	public void loadContent(final String[] wikiTexts) {

		final HTML wikiHTML = new HTML(wikiTexts[0]);
		scrollPanel.setWidget(wikiHTML);
		btnArticle.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				scrollPanel.setSize("700px", "450px");
				String filteredTxt = MiscUtils.filterWiki(wikiTexts[1]);

				int endInx = filteredTxt.indexOf("id=\"References\"");
				String result = filteredTxt.substring(0, endInx);

				wikiHTML.setHTML(result);
				center();
				btnArticle.setVisible(false);
			}
		});
	}
}

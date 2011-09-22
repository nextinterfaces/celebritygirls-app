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
import next.celebs.di.Context;
import next.celebs.event.SubMenuEvent;
import next.celebs.event.SubMenuHandler;
import next.celebs.event.SubMenuEvent.Type;
import next.celebs.model.Key;

public class RedcarpetOptionPage extends ImagesPage {

	final static UiResources RES = UiResources.INSTANCE;

	private SearchImageWidget searchWidget;

	private final Context ctx;

	public RedcarpetOptionPage(final Type type, Context ctx_) {
		super(ctx_);
		this.ctx = ctx_;

		ctx.getEventBus().addHandler(SubMenuEvent.TYPE, new SubMenuHandler() {
			@Override
			public void onExecute(SubMenuEvent e) {
				if (e.getType() == type) {
					doSubMenuSearch(getSearchKey().getSearchQuery() + " " + e.getSubSearch());
				}
			}
		});
	}

	public void doSubMenuSearch(String query) {
		doClear();
		System.out.println("::doSubMenuSearch '" + query + "' ");
		searchWidget = new SearchImageWidget(new Key(query, query), 2, 10, ctx);
		setWidget(searchWidget);
	}

}

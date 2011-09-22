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

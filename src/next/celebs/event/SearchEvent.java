package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class SearchEvent extends GwtEvent<SearchHandler> {

	public static final GwtEvent.Type<SearchHandler> TYPE = new GwtEvent.Type<SearchHandler>();

	private String name;

	public SearchEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	protected void dispatch(SearchHandler handler) {
		handler.onExecute(this);
	}

	@Override
	public GwtEvent.Type<SearchHandler> getAssociatedType() {
		return TYPE;
	}

}

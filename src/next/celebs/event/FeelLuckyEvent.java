package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class FeelLuckyEvent extends GwtEvent<FeelLuckyHandler> {

	public static final GwtEvent.Type<FeelLuckyHandler> TYPE = new GwtEvent.Type<FeelLuckyHandler>();

	private String name;

	public FeelLuckyEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	protected void dispatch(FeelLuckyHandler handler) {
		handler.onExecute(this);
	}

	@Override
	public GwtEvent.Type<FeelLuckyHandler> getAssociatedType() {
		return TYPE;
	}

}

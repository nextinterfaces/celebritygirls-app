package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class AzNameEvent extends GwtEvent<AzNameHandler> {

	public static final GwtEvent.Type<AzNameHandler> TYPE = new GwtEvent.Type<AzNameHandler>();

	private String name;

	public AzNameEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	protected void dispatch(AzNameHandler handler) {
		handler.onExecute(this);
	}

	@Override
	public GwtEvent.Type<AzNameHandler> getAssociatedType() {
		return TYPE;
	}

}

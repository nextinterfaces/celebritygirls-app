package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class SubMenuEvent extends GwtEvent<SubMenuHandler> {

	public static final GwtEvent.Type<SubMenuHandler> TYPE = new GwtEvent.Type<SubMenuHandler>();

	public static enum Type {
		FEEL_LUCKY, AZ, SWIMWEAR, REDCARPET_OSCARS, REDCARPET_GOLDEN, REDCARPET_GRAMMY, REDCARPET_CANNES, WALLPAPER
	}

	private Type type;
	private String selection;

	public SubMenuEvent(Type type, String selection) {
		this.type = type;
		this.selection = selection;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getSubSearch() {
		return selection;
	}

	@Override
	protected void dispatch(SubMenuHandler handler) {
		handler.onExecute(this);
	}

	@Override
	public GwtEvent.Type<SubMenuHandler> getAssociatedType() {
		return TYPE;
	}

}

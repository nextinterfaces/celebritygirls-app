package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class MenuOptionEvent extends GwtEvent<MenuOptionHandler> {

  public static final GwtEvent.Type<MenuOptionHandler> TYPE = new GwtEvent.Type<MenuOptionHandler>();

  public static enum Type {
    AZ, SWIMWEAR, RED_CARPET, FEEL_LUCKY, WALLPAPER, SEARCH, SETTINGS
  }

  private Type type;

  public MenuOptionEvent(Type type) {
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @Override
  protected void dispatch(MenuOptionHandler handler) {
    handler.onExecute(this);
  }

  @Override
  public GwtEvent.Type<MenuOptionHandler> getAssociatedType() {
    return TYPE;
  }

}

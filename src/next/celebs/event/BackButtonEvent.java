package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class BackButtonEvent extends GwtEvent<BackButtonHandler> {

  public static final GwtEvent.Type<BackButtonHandler> TYPE = new GwtEvent.Type<BackButtonHandler>();

  public enum Type {
    FRONT_PAGE, RED_CARPET, SWIMWEAR, AZ, ANIME, FEELLUCKY, SEARCH, SETTINGS;
  }

  private Type type;

  public BackButtonEvent(Type type) {
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @Override
  protected void dispatch(BackButtonHandler handler) {
    handler.onExecute(this);
  }

  @Override
  public GwtEvent.Type<BackButtonHandler> getAssociatedType() {
    return TYPE;
  }

}

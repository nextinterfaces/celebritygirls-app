package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class RedcarpetOptionEvent extends GwtEvent<RedcarpetOptionHandler> {

  public static final GwtEvent.Type<RedcarpetOptionHandler> TYPE = new GwtEvent.Type<RedcarpetOptionHandler>();

  public static enum Type {
    OSCARS, GOLDENGLOBE, GRAMMY, CANNES
  }

  private Type type;

  public RedcarpetOptionEvent(Type type) {
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @Override
  protected void dispatch(RedcarpetOptionHandler handler) {
    handler.onExecute(this);
  }

  @Override
  public GwtEvent.Type<RedcarpetOptionHandler> getAssociatedType() {
    return TYPE;
  }

}

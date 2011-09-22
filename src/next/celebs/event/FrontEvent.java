package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class FrontEvent extends GwtEvent<FrontHandler> {

  public static final GwtEvent.Type<FrontHandler> TYPE = new GwtEvent.Type<FrontHandler>();

  public static enum Type {
    MOVIES, MODELS, GIRL_DAY
  }

  private Type type;

  public FrontEvent(Type type) {
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @Override
  protected void dispatch(FrontHandler handler) {
    handler.onExecute(this);
  }

  @Override
  public GwtEvent.Type<FrontHandler> getAssociatedType() {
    return TYPE;
  }

}

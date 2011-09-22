package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class SwimwearEvent extends GwtEvent<SwimwearHandler> {

  public static final GwtEvent.Type<SwimwearHandler> TYPE = new GwtEvent.Type<SwimwearHandler>();

  public SwimwearEvent() {
  }

  @Override
  protected void dispatch(SwimwearHandler handler) {
    handler.onExecute(this);
  }

  @Override
  public GwtEvent.Type<SwimwearHandler> getAssociatedType() {
    return TYPE;
  }

}

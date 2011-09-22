package next.celebs.event;

import com.google.gwt.event.shared.GwtEvent;

public class WallpaperEvent extends GwtEvent<WallpaperHandler> {

  public static final GwtEvent.Type<WallpaperHandler> TYPE = new GwtEvent.Type<WallpaperHandler>();

  public WallpaperEvent() {
  }

  @Override
  protected void dispatch(WallpaperHandler handler) {
    handler.onExecute(this);
  }

  @Override
  public GwtEvent.Type<WallpaperHandler> getAssociatedType() {
    return TYPE;
  }

}

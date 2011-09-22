package next.celebs.ui;

import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * A overlay popup used to gray out the screen. Any popup which requires grey
 * out feauter on popup should derive from this class.
 */
public class OverlayPopupOLD extends PopupPanel {

  private final OverlayWrapperOLD overlayWrapperOLD;

  public OverlayPopupOLD() {
    this(false, false);
  }

  public OverlayPopupOLD(boolean autoHide, boolean modal) {
    super(autoHide, modal);
    overlayWrapperOLD = new OverlayWrapperOLD(this);
    // setAnimationEnabled(true);

    DOM.setStyleAttribute(this.getElement(), "position", "absolute");
  }

  // private OverlayPopupOLD(boolean autoHide) {
  // this(autoHide, false);
  // }

  // @Override
  public void showOverlay() {
    overlayWrapperOLD.showOverlay();
    // super.show();
  }

  public void hideOverlay() {
    overlayWrapperOLD.hideOverlay();
  }

  public void addOverlayMouseDownHandler(MouseDownHandler handler) {
    overlayWrapperOLD.addMouseDownHandler(handler);
  }

  // @Override
  // public void hide() {
  // super.hide();
  // // if (navigatable != null) {
  // // navigatable.onHide();
  // // }
  // }
}

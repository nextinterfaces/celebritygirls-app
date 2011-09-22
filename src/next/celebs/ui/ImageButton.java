package next.celebs.ui;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

/**
 * This is a button class with two states MouseUp and MouseDown. Bear in mind tablets don't necessarily have two sates,
 * but one - MouseDown only.
 */
public class ImageButton extends YButton {

  private final Image defaultImage;

  public ImageButton(ImageResource resource) {
    this(new Image(resource));
  }

  public ImageButton(Image imgDefault) {

    addStyleName("yImageButton");
    setSize(imgDefault.getWidth() + "px", imgDefault.getHeight() + "px");

    this.defaultImage = imgDefault;
    // this.overImage = imgOver;

    // this.defaultImage.unsinkEvents(Event.ONCLICK | Event.MOUSEEVENTS);
    // this.overImage.unsinkEvents(Event.ONCLICK | Event.MOUSEEVENTS);

    setWidget(defaultImage);
    // sinkEvents(Event.ONCLICK | Event.MOUSEEVENTS);

    // ImageSwapper imgSwapper = new ImageSwapper();
    // addMouseDownHandler(new MouseDownHandler() {
    // @Override
    // public void onMouseDown(MouseDownEvent event) {
    // setWidget(overImage);
    // }
    // });
    //
    // addMouseUpHandler(new MouseUpHandler() {
    // @Override
    // public void onMouseUp(MouseUpEvent event) {
    // setWidget(defaultImage);
    // }
    // });

    // addMouseOutHandler(imgSwapper);
    // // addMouseOverHandler(imgSwapper);
    // addClickHandler(imgSwapper);
  }

  public int getWidth() {
    return defaultImage.getOffsetWidth();
  }

  public void setResource(ImageResource resource) {
    defaultImage.setResource(resource);
  }

}
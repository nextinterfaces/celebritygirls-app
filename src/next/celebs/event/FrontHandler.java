package next.celebs.event;

import com.google.gwt.event.shared.EventHandler;

public interface FrontHandler extends EventHandler {

  void onExecute(FrontEvent event);

}

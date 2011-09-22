package next.celebs.event;

import com.google.gwt.event.shared.EventHandler;

public interface MenuOptionHandler extends EventHandler {

  void onExecute(MenuOptionEvent event);

}

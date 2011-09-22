package next.celebs.event;

import com.google.gwt.event.shared.EventHandler;

public interface SearchHandler extends EventHandler {

  void onExecute(SearchEvent event);

}

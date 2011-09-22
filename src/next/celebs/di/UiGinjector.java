package next.celebs.di;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(UiGinModule.class)
public interface UiGinjector extends Ginjector {

	public final static UiGinjector INSTANCE = GWT.create(UiGinjector.class);

	UiComponents getUiComponents();

	UiEventBus getEventBus();

	Storage getStorage();

	Context getContext();

}

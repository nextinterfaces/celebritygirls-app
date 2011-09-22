package next.celebs.di;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class UiGinModule extends AbstractGinModule {

	protected void configure() {
		bind(UiEventBus.class).in(Singleton.class);
		bind(UiComponents.class).in(Singleton.class);
		bind(Storage.class).in(Singleton.class);
		bind(Context.class).in(Singleton.class);
	}

}
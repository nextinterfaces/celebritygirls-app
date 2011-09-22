package next.celebs.di;

import next.celebs.api.API;
import next.celebs.dao.GirlOfDayNamesDao;
import next.celebs.dao.NamesDao;
import next.celebs.dao.PhotoDao;

import com.google.gwt.search.client.SafeSearchValue;
import com.google.inject.Inject;

@SuppressWarnings("unchecked")
public class Context {

	private API api;
	private Storage storage;
	private UiEventBus eventBus;
	private UiComponents ui;
	private PhotoDao photoDao;
	private NamesDao namesDao;
	private GirlOfDayNamesDao girlDayDao;
	private boolean isDevMode = false;
	private SafeSearchValue safeSearcrh = SafeSearchValue.STRICT;

	@Inject
	public Context(UiEventBus eventBus_, Storage storage_, API api_, PhotoDao photoDao_, NamesDao namesDao_,
			GirlOfDayNamesDao girlDayDao_) {
		this.eventBus = eventBus_;
		this.api = api_;
		this.storage = storage_;
		this.photoDao = photoDao_;
		this.namesDao = namesDao_;
		this.girlDayDao = girlDayDao_;
		//
		this.api.init(this);
		this.photoDao.init(this);
		this.namesDao.init(this);
		this.girlDayDao.init(this);
	}

	public boolean isDevMode() {
		return isDevMode;
	}

	public void setDevMode(boolean isDevMode) {
		this.isDevMode = isDevMode;
	}

	public API getApi() {
		return api;
	}

	public Storage getStorage() {
		return storage;
	}

	public UiEventBus getEventBus() {
		return eventBus;
	}

	public PhotoDao getPhotoDao() {
		return photoDao;
	}

	public NamesDao getNamseDao() {
		return namesDao;
	}

	public UiComponents getUi() {
		return ui;
	}

	public void initUi(UiComponents ui) {
		this.ui = ui;
	}

	public SafeSearchValue getSafeSearcrh() {
		return safeSearcrh;
	}

	public void setSafeSearcrh(SafeSearchValue safeSearcrh) {
		this.safeSearcrh = safeSearcrh;
	}

	public GirlOfDayNamesDao getGirlDayDao() {
		return girlDayDao;
	}

}

package next.celebs.di;

import next.celebs.model.Key;

public class Storage<T> {

//	public static enum Key {
//		Swimwear("Swimwear", "celebs swimwear victoria secret"), Anime("Anime", "anime girl"), ;
////swimwear model female
//		private final String name;
//		private final String searchQuery;
//
//		Key(String name, String searchQuery) {
//			this.name = name;
//			this.searchQuery = searchQuery;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public String getSearchQuery() {
//			return searchQuery;
//		}
//	}

	interface Strategy {

		void _setItem(String key, String val);

		String _getItem(String key);

		boolean _contains(String key);

		void _removeItem(String key);

		void _clear();

		int _length();
	}

	private Strategy strategy;

	public void init(Strategy strategy) {
		this.strategy = strategy;
	}

	public int length() {
		return strategy._length();
	}

	public void clear() {
		strategy._clear();
	}

	public void removeItem(Key key) {
		strategy._removeItem(key.getName());
	}

	public String getItem(Key key) {
		return strategy._getItem(key.getName());
	}

	public boolean hasKey(Key key) {
		return strategy._contains(key.getName());
	}

	public void setItem(Key key, String val) {
		strategy._setItem(key.getName(), val);
	}

	// ===============================================================
	// implementations
	// ===============================================================

	/**
	 * JavaScript implementation
	 */
	public static class JsStorageStrategy implements Strategy {

		public native void _setItem(String key, String val) /*-{
			var _store = $wnd.localStorage;
			_store.setItem(key, val);
		}-*/;

		public native String _getItem(String key) /*-{
			var _store = $wnd.localStorage;
			return _store.getItem(key);
		}-*/;

		public native boolean _contains(String key) /*-{
			var _store = $wnd.localStorage;
			return (_store.getItem(key) != null);
		}-*/;

		public native void _removeItem(String key) /*-{
			var _store = $wnd.localStorage;
			_store.removeItem(key);
		}-*/;

		public native void _clear() /*-{
			var _store = $wnd.localStorage;
			_store.clear();
		}-*/;

		public native int _length() /*-{
			var _store = $wnd.localStorage;
			return _store.length;
		}-*/;
	}

}

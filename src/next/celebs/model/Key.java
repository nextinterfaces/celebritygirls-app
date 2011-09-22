package next.celebs.model;

public class Key {

	public final static Key SWIMWEAR = new Key("Swimwear", "celeb swimwear victoria secret");
	public final static Key WALLPAPER = new Key("Wallpaper", "wallpaper celebs");
	public final static Key OSCARS = new Key("Oscars", "oscars red carpet dress");
	public final static Key GOLDEN_GLOBE = new Key("Golden", "golden globe red carpet dress");
	public final static Key GRAMMY = new Key("Grammy", "grammy red carpet dress");
	public final static Key CANNES = new Key("Cannes", "cannes red carpet dress");

	private final String name;
	private final String searchQuery;

	public Key(String name, String searchQuery) {
		this.name = name;
		this.searchQuery = searchQuery;
	}

	public String getName() {
		return name;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	@Override
	public String toString() {
		return getName() + ":" + getSearchQuery();
	}

}

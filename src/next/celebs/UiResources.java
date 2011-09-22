package next.celebs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface UiResources extends ClientBundle {

	public static final UiResources INSTANCE = GWT.create(UiResources.class);

	@Source("resources/btnClear.png")
	public ImageResource btnClear();

	@Source("resources/btnClearCache.png")
	public ImageResource btnClearCache();

	@Source("resources/hBack.png")
	public ImageResource btnBack();

	@Source("resources/wiki.png")
	public ImageResource wiki();

	@Source("resources/wikiTxt.png")
	public ImageResource wikiTxt();

	@Source("resources/btnArticle.png")
	public ImageResource btnArticle();

	@Source("resources/btnClose.png")
	public ImageResource btnClose();

	@Source("resources/btnDone.png")
	public ImageResource btnDone();

	@Source("resources/hBlank.png")
	public ImageResource hBlank();

	@Source("resources/mAZ.png")
	public ImageResource mAZ();

	@Source("resources/mSwimwear.png")
	public ImageResource mSwimwear();

	@Source("resources/mRedcarpet.png")
	public ImageResource mRedcarpet();

	@Source("resources/mFeellucky.png")
	public ImageResource mFeellucky();

	@Source("resources/mWallpaper.png")
	public ImageResource mWallpaper();

	@Source("resources/mSearch.png")
	public ImageResource mSearch();

	@Source("resources/mSettings.png")
	public ImageResource mSettings();

	@Source("resources/hSwimwear.png")
	public ImageResource hSwimwear();

	@Source("resources/hOscar.png")
	public ImageResource hOscar();

	@Source("resources/hRedcarpet.png")
	public ImageResource hRedcarpet();

	@Source("resources/hFeellucky.png")
	public ImageResource hFeellucky();

	@Source("resources/hGolden.png")
	public ImageResource hGoldenglobe();

	@Source("resources/hGrammy.png")
	public ImageResource hGrammy();

	@Source("resources/hWallpaper.png")
	public ImageResource hWallpaper();

	@Source("resources/hSearch.png")
	public ImageResource hSearch();

	@Source("resources/hSettings.png")
	public ImageResource hSettings();

	@Source("resources/hAz.png")
	public ImageResource hAz();

	@Source("resources/hCannes.png")
	public ImageResource hCannes();

	@Source("resources/hBack.png")
	public ImageResource hBackImg();

	@Source("resources/hBackSearch.png")
	public ImageResource hBackSearch();

	@Source("resources/hBackCelebs.png")
	public ImageResource hBackMain();

	@Source("resources/hBackRedcarpet.png")
	public ImageResource hBackRedcarpet();

	@Source("resources/hBackSwimwear.png")
	public ImageResource hBackSwimwear();

	@Source("resources/hBackAz.png")
	public ImageResource hBackAz();

	@Source("resources/aOscar.png")
	public ImageResource aOscar();

	@Source("resources/aGolden.png")
	public ImageResource aGolden();

	@Source("resources/aGrammy.png")
	public ImageResource aGrammy();

	@Source("resources/aCannes.png")
	public ImageResource aCannes();

	@Source("resources/hMovies.png")
	public ImageResource hMovies();

	@Source("resources/hModels.png")
	public ImageResource hModels();

	@Source("resources/hGirlDay.png")
	public ImageResource hGirlDay();

	@Source("resources/game0.png")
	public ImageResource game0();

	@Source("resources/game1.png")
	public ImageResource game1();

	@Source("resources/game2.png")
	public ImageResource game2();

	@Source("resources/game3.png")
	public ImageResource game3();

	@Source("resources/game4.png")
	public ImageResource game4();

	@Source("resources/frontModel0.png")
	public ImageResource frontModel0();

	@Source("resources/frontModel1.png")
	public ImageResource frontModel1();

	@Source("resources/frontModel2.png")
	public ImageResource frontModel2();

	@Source("resources/frontModel3.png")
	public ImageResource frontModel3();

	//
	@Source("resources/frontModel4.png")
	public ImageResource frontModel4();

	@Source("resources/gameCover.jpg")
	public ImageResource gameCover();

}

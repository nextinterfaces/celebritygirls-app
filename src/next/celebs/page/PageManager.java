package next.celebs.page;

import java.util.ArrayList;

public class PageManager {

  private ArrayList<IPage> pages = new ArrayList<IPage>();

  public void bind(IPage p) {
    pages.add(p);
  }

  public void hidePages() {
    for (IPage s : pages) {
      s.doHide();
    }
  }

  public void showPages() {
    for (IPage s : pages) {
      s.doShow();
    }
  }

  public void clearPages() {
    for (IPage s : pages) {
      s.doClear();
    }
  }

}

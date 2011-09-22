package next.celebs.page;

import next.celebs.UiResources;
import next.celebs.di.Context;
import next.celebs.di.UiComponents;
import next.celebs.di.UiGinjector;
import next.celebs.event.BackButtonEvent;
import next.celebs.event.BackButtonHandler;
import next.celebs.event.MenuOptionEvent.Type;
import next.celebs.ui.ImageButton;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.FlowPanel;

public class LeftMenuImpl extends LeftMenu {

  final static UiResources RES = UiResources.INSTANCE;
  private final static UiComponents UI = UiGinjector.INSTANCE.getUiComponents();

  final ImageButton btnAZ;
  final ImageButton btnSwimwear;
  final ImageButton btnRedcarpet;
  final ImageButton btnFeellucky;
  final ImageButton btnWallpaper;
  final ImageButton btnSearch;
  final ImageButton btnSettings;

	private Context ctx;

	public LeftMenuImpl(Context ctx_) {
    super(ctx_);
		this.ctx = ctx_;

    btnAZ = new ImageButton(RES.mAZ());
    btnWallpaper = new ImageButton(RES.mWallpaper());
    btnSwimwear = new ImageButton(RES.mSwimwear());
    btnRedcarpet = new ImageButton(RES.mRedcarpet());
    btnFeellucky = new ImageButton(RES.mFeellucky());
    btnSearch = new ImageButton(RES.mSearch());
    btnSettings = new ImageButton(RES.mSettings());

    FlowPanel panel = new FlowPanel();
    addButton(btnAZ);
    addButton(btnWallpaper);
    addButton(btnSwimwear);
    addButton(btnRedcarpet);
    addButton(btnFeellucky);
    addButton(btnSearch);
    addButton(btnSettings);

    panel.add(btnAZ);
    panel.add(btnWallpaper);
    panel.add(btnSwimwear);
    panel.add(btnRedcarpet);
    panel.add(btnFeellucky);
    panel.add(btnSearch);
    panel.add(btnSettings);

    setWidget(panel);

    listenEvents();

    slideOutButton(btnAZ, new Command() {
      @Override
      public void execute() {
        resetButtons(btnAZ);
      }
    }, null, Type.AZ);

    slideOutButton(btnSwimwear, new Command() {
      @Override
      public void execute() {
        resetButtons(btnSwimwear);
      }
    }, null, Type.SWIMWEAR);

    slideOutButton(btnRedcarpet, new Command() {
      @Override
      public void execute() {
        resetButtons(btnRedcarpet);
      }
    }, null, Type.RED_CARPET);

    slideOutButton(btnFeellucky, new Command() {
      @Override
      public void execute() {
        resetButtons(btnFeellucky);
      }
    }, null, Type.FEEL_LUCKY);

    slideOutButton(btnWallpaper, new Command() {
      @Override
      public void execute() {
        resetButtons(btnWallpaper);
      }
    }, null, Type.WALLPAPER);
    
    slideOutButton(btnSearch, new Command() {
      @Override
      public void execute() {
        resetButtons(btnSearch);
      }
    }, null, Type.SEARCH);
    
    slideOutButton(btnSettings, new Command() {
      @Override
      public void execute() {
        resetButtons(btnSettings);
      }
    }, null, Type.SETTINGS);

  }

  @Override
  Type getType() {
    return Type.AZ;
  }

  private void listenEvents() {
    ctx.getEventBus().addHandler(BackButtonEvent.TYPE, new BackButtonHandler() {
      @Override
      public void onExecute(final BackButtonEvent e) {
        if (e.getType() == BackButtonEvent.Type.RED_CARPET) {
          resetButtons(btnRedcarpet);

        } else if (e.getType() == BackButtonEvent.Type.SWIMWEAR) {
          resetButtons(btnSwimwear);

        } else if (e.getType() == BackButtonEvent.Type.AZ) {
          resetButtons(btnAZ);

        } else if (e.getType() == BackButtonEvent.Type.ANIME) {
          resetButtons(btnWallpaper);

        } else if (e.getType() == BackButtonEvent.Type.FEELLUCKY) {
          resetButtons(btnFeellucky);

        } else if (e.getType() == BackButtonEvent.Type.SEARCH) {
          resetButtons(btnSearch);
          
        } else if (e.getType() == BackButtonEvent.Type.SETTINGS) {
          resetButtons(btnSettings);

        } else if (e.getType() == BackButtonEvent.Type.FRONT_PAGE) {
          resetButtons(null); // all buttons
          UI.getFrontPage().doShow();
          UI.getFrontTopMenu().doShow();

        } else {
          resetButtons(null); // all buttons
        }

      }
    });
  }

}

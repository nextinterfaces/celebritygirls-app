package next.celebs.page;

import next.celebs.FxUtil;
import next.celebs.UiResources;
import next.celebs.di.Context;
import next.celebs.event.AzNameEvent;
import next.celebs.event.AzNameHandler;
import next.celebs.event.FrontEvent;
import next.celebs.event.FrontHandler;

import org.adamtacy.client.ui.effects.core.NMorphStyle;
import org.adamtacy.client.ui.effects.events.EffectCompletedEvent;
import org.adamtacy.client.ui.effects.events.EffectCompletedHandler;


import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;

public class FrontPage extends PopupPanel implements IPage {

	final static UiResources RES = UiResources.INSTANCE;
	private boolean isHidden = true;

	final Image imgGame0;
	final Image imgGame1;
	final Image imgGame2;
	final Image imgGame3;
	final Image imgGame4;
	private Context ctx;
	private FrontEvent.Type type;

	public FrontPage(Context ctx_) {
		this.ctx = ctx_;
		setStyleName("yGamesPage yPopupPage");
		setWidth("680px");

		setPopupPosition(336, 88);
		show();
		setType(FrontEvent.Type.MOVIES);

		Image imgBg = new Image(RES.hBlank());
		imgGame0 = new Image(RES.game0());
		imgGame1 = new Image(RES.game1());
		imgGame2 = new Image(RES.game2());
		imgGame3 = new Image(RES.game3());
		imgGame4 = new Image(RES.game4());
		Image imgCover = new Image(RES.gameCover());

		imgBg.setStyleName("gameBg");
		imgGame0.setStyleName("game0");
		imgGame1.setStyleName("game1");
		imgGame2.setStyleName("game2");
		imgGame3.setStyleName("game3");
		imgGame4.setStyleName("game4");
		imgCover.setStyleName("gameCover");

		imgGame0.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				if (FrontPage.this.getType() == FrontEvent.Type.MOVIES) {
					ctx.getEventBus().fireEvent(new AzNameEvent("Megan Fox"));
				} else {
					ctx.getEventBus().fireEvent(new AzNameEvent("Marisa Miller"));
				}
			}
		});

		imgGame1.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				if (FrontPage.this.getType() == FrontEvent.Type.MOVIES) {
					ctx.getEventBus().fireEvent(new AzNameEvent("Shakira"));
				} else {
					ctx.getEventBus().fireEvent(new AzNameEvent("Adriana Lima"));
				}
			}
		});

		imgGame2.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				if (FrontPage.this.getType() == FrontEvent.Type.MOVIES) {
					ctx.getEventBus().fireEvent(new AzNameEvent("Kate Beckinsale"));
				} else {
					ctx.getEventBus().fireEvent(new AzNameEvent("Alessandra Ambrosio"));
				}
			}
		});

		imgGame3.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				if (FrontPage.this.getType() == FrontEvent.Type.MOVIES) {
					ctx.getEventBus().fireEvent(new AzNameEvent("Jessica Alba"));
				} else {
					ctx.getEventBus().fireEvent(new AzNameEvent("Heidi Klum"));
				}
			}
		});

		imgGame4.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				if (FrontPage.this.getType() == FrontEvent.Type.MOVIES) {
					ctx.getEventBus().fireEvent(new AzNameEvent("Charlize Theron"));
				} else {
					ctx.getEventBus().fireEvent(new AzNameEvent("Bar Rafaeli"));
				}
			}
		});

		HorizontalPanel imgHolder = new HorizontalPanel();
		imgHolder.add(imgBg);
		imgHolder.add(imgGame0);
		imgHolder.add(imgGame1);
		imgHolder.add(imgGame2);
		imgHolder.add(imgGame3);
		imgHolder.add(imgGame4);
		imgHolder.add(imgCover);

		imgGame0.getElement().getStyle().setOpacity(0);
		imgGame1.getElement().getStyle().setOpacity(0);
		imgGame2.getElement().getStyle().setOpacity(0);
		imgGame3.getElement().getStyle().setOpacity(0);
		imgGame4.getElement().getStyle().setOpacity(0);

		setWidget(imgHolder);

		NMorphStyle eff = FxUtil.moveHorizEffectAbs(-336, -336, imgCover.getElement(), null, 100, 100, 0.1);
		eff.play();

		ctx.getEventBus().addHandler(FrontEvent.TYPE, new FrontHandler() {
			@Override
			public void onExecute(FrontEvent e) {

				if (e.getType() == FrontEvent.Type.MOVIES) {
					setType(FrontEvent.Type.MOVIES);
					slideOutImages(new Command() {
						@Override
						public void execute() {
							imgGame0.setResource(RES.game0());
							imgGame1.setResource(RES.game1());
							imgGame2.setResource(RES.game2());
							imgGame3.setResource(RES.game3());
							imgGame4.setResource(RES.game4());
							slideInImages(0);
						}
					}, 0);

				} else if (e.getType() == FrontEvent.Type.MODELS) {
					setType(FrontEvent.Type.MODELS);
					slideOutImages(new Command() {
						@Override
						public void execute() {
							imgGame0.setResource(RES.frontModel0());
							imgGame1.setResource(RES.frontModel1());
							imgGame2.setResource(RES.frontModel2());
							imgGame3.setResource(RES.frontModel3());
							imgGame4.setResource(RES.frontModel4());
							slideInImages(0);
						}
					}, 0);

				}

				// else if (e.getType() == FrontEvent.Type.GIRL_DAY) {
				// slideOutImages(slideInCmd, 0);
				// }
			}
		});

		ctx.getEventBus().addHandler(AzNameEvent.TYPE, new AzNameHandler() {
			@Override
			public void onExecute(AzNameEvent event) {
				doHide();
			}
		});
	}

	public FrontEvent.Type getType() {
		return type;
	}

	public void setType(FrontEvent.Type type) {
		this.type = type;
	}

	@Override
	public void doHide() {
		if (isHidden) {
			return;
		}

		NMorphStyle eff = FxUtil.doHide(this, null);
		eff.addEffectCompletedHandler(new EffectCompletedHandler() {
			@Override
			public void onEffectCompleted(EffectCompletedEvent event) {
				slideOutImages(null, 0);
			}
		});
		eff.play();

		isHidden = true;
	}

	@Override
	public void doShow() {
		if (!isHidden) {
			return;
		}
		setPopupPosition(336, 88);

		NMorphStyle eff = FxUtil.doShow(this, new Command() {
			@Override
			public void execute() {
				slideInImages(300);
			}
		});
		eff.play();

		isHidden = false;
	}

	private void slideInImages(int timeout) {

		new Timer() {
			public void run() {
				slideInButton(imgGame0, 5, null);
			}
		}.schedule(timeout + 1);

		new Timer() {
			public void run() {
				slideInButton(imgGame1, 172, null);
			}
		}.schedule(timeout + 50);

		new Timer() {
			public void run() {
				slideInButton(imgGame2, 325, null);
			}
		}.schedule(timeout + 100);

		new Timer() {
			public void run() {
				slideInButton(imgGame3, 445, null);
			}
		}.schedule(timeout + 170);

		new Timer() {
			public void run() {
				slideInButton(imgGame4, 545, null);
			}
		}.schedule(timeout + 240);
	}

	public void slideOutImages(final Command afterCmd, int initialLatency) {

		new Timer() {
			public void run() {
				slideOutButton(imgGame0, 5, null);
			}
		}.schedule(initialLatency + 1);

		new Timer() {
			public void run() {
				slideOutButton(imgGame1, 182, null);
			}
		}.schedule(initialLatency + 150);

		new Timer() {
			public void run() {
				slideOutButton(imgGame2, 335, null);
			}
		}.schedule(initialLatency + 200);

		new Timer() {
			public void run() {
				slideOutButton(imgGame3, 465, null);
			}
		}.schedule(initialLatency + 250);

		new Timer() {
			public void run() {
				slideOutButton(imgGame4, 565, afterCmd);
			}
		}.schedule(initialLatency + 320);
	}

	public void slideInButton(final Image img, int toX, final Command afterCmd) {

		NMorphStyle eff = FxUtil.moveHorizEffectAbs(690, toX, img.getElement(), afterCmd, 30, 100, 0.3);
		eff.play();
	}

	public void slideOutButton(final Image img, int fromX, final Command afterCmd) {

		NMorphStyle eff = FxUtil.moveHorizEffectAbs(fromX, -450, img.getElement(), afterCmd, 30, 100, 0.3);
		eff.play();
	}

	@Override
	public void doClear() {
		// TODO Auto-generated method stub
	}

}

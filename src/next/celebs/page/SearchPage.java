package next.celebs.page;

import next.celebs.FxUtil;
import next.celebs.UiResources;
import next.celebs.di.Context;
import next.celebs.event.SearchEvent;
import next.celebs.ui.ImageButton;
import next.celebs.ui.MiscUtils;
import next.celebs.ui.MiscUtils.CallBack;

import org.adamtacy.client.ui.effects.core.NMorphStyle;


import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class SearchPage extends PopupPanel implements IPage {

	final static UiResources RES = UiResources.INSTANCE;
	private boolean isHidden = true;

	private final static int WIDTH = 660;

	private final Context ctx;

	public SearchPage(Context ctx_) {
		this.ctx = ctx_;
		setStyleName("ySearchPage yPopupPage");
		setWidth(WIDTH + "px");

		setPopupPosition(336, 88);
		show();

		FlowPanel content = new FlowPanel();
		setWidget(content);

		FlexTable ft = new FlexTable();
		ft.setWidth(WIDTH + "px");

		final TextBox box = new TextBox();
		ImageButton btnDone = new ImageButton(RES.btnDone());
		final Label celebField = new Label();
		celebField.setStyleName("ySearchName");

		btnDone.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				String celebName = MiscUtils.noNull(celebField.getText());
				if (!MiscUtils.isEmpty(box.getText()) || celebName.length() > 1) {
					doHide();
					ctx.getEventBus().fireEvent(new SearchEvent(box.getText() + " " + celebName));
				}
			}
		});

		FlowPanel scrNested = new FlowPanel();
		ScrollPanel scrollPanel = new ScrollPanel(scrNested);
		init(scrollPanel, scrNested, celebField);

		ImageButton btnClear = new ImageButton(RES.btnClear());
		btnClear.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				box.setText("");
				celebField.setText("");
			}
		});

		celebField.setWidth("240px");

		ft.setWidget(0, 0, box);
		ft.setWidget(0, 1, celebField);
		ft.setWidget(0, 2, btnClear);
		ft.setWidget(1, 0, btnDone);
		ft.setWidget(1, 1, scrollPanel);

		ft.getRowFormatter().setStyleName(0, "ySearchRow");

		FlexCellFormatter fcf = ft.getFlexCellFormatter();
		fcf.setColSpan(1, 1, 2);

		fcf.setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);

		content.add(ft);
	}

	void init(ScrollPanel scrollPanel, FlowPanel nested, final Label celebField) {

		scrollPanel.setSize("100%", "400px");
		MiscUtils.populateNamesScrollPanel(new CallBack() {
			@Override
			public void onClick(String name) {
				celebField.setText(name);
			}
		}, nested, ctx);
	}

	@Override
	public void doHide() {
		if (isHidden) {
			return;
		}

		NMorphStyle eff = FxUtil.doHide(this, null);
		eff.play();

		isHidden = true;
	}

	@Override
	public void doShow() {
		if (!isHidden) {
			return;
		}
		setPopupPosition(336, 88);

		NMorphStyle eff = FxUtil.doShow(this, null);
		eff.play();

		isHidden = false;
	}

	@Override
	public void doClear() {
		// TODO Auto-generated method stub
	}

}

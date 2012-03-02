package biz.xlean.client;

import com.google.gwt.user.client.ui.VerticalPanel;

public class Home extends VerticalPanel {

	public static VerticalPanel vpHeader = new VerticalPanel();

	public static VerticalPanel vpMain = new VerticalPanel();

	public Home() {

		this.add(vpHeader);

		this.add(vpMain);
	}
}

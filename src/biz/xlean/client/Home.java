package biz.xlean.client;

import biz.xlean.client.header.Header;

import com.google.gwt.user.client.ui.VerticalPanel;

public class Home extends VerticalPanel {

	public static VerticalPanel vpMain = new VerticalPanel();

	public Home() {

		this.add(new Header());
		
		this.add(vpMain);
	}
}

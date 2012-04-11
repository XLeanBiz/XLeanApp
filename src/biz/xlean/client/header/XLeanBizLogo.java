package biz.xlean.client.header;

import biz.xlean.client.Home;
import biz.xlean.client.about.AboutXLean;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

public class XLeanBizLogo extends HTML {

	public XLeanBizLogo() {

		this.setHTML("<a href=#><img src='images/XLeanBiz.jpg' border=0 height=35></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Home.vpHeader.clear();

				Home.vpMain.clear();
				Home.vpMain.add(new AboutXLean());
			}
		});
	}
}

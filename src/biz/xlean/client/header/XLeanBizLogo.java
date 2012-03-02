package biz.xlean.client.header;

import biz.xlean.client.Home;
import biz.xlean.client.about.AboutXLean;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

public class XLeanBizLogo extends Image {

	public XLeanBizLogo() {

		this.setUrl("images/XLeanBiz.jpg");

		this.setHeight("35px");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Home.vpMain.clear();
				Home.vpMain.add(new AboutXLean());
			}
		});
	}
}

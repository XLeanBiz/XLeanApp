package biz.xlean.client.about;

import biz.xlean.client.InitializeXLeanBiz;
import biz.xlean.client.utilities.UseTracking;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

public class ButtonTryItNow extends HTML {

	public ButtonTryItNow() {

		this.setHTML("<a href=#><img src='images/StartHere.jpg' width='150px' border=0></a>");
		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(
						"biz.xlean.client.about.AboutXLean#TryItNowButton");

				InitializeXLeanBiz.openBlog(null, null, null);
			}
		});

	}
}

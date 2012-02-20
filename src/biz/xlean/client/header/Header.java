package biz.xlean.client.header;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class Header extends HorizontalPanel {

	public Header() {
		
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.add(new XLeanBizLogo());

		Label space = new Label(" ");
		space.setWidth("600px");
		this.add(space);

	//	this.add(new Label());

		this.add(new FacebookFeedbackButton());
	}
}

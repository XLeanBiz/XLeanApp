package biz.xlean.client.header;

import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;

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

		this.add(FacebookLoginPanel.hpFacebookLogin);
		FacebookLoginPanel.setPanel();

		Label space2 = new Label(" ");
		space2.setWidth("200px");
		this.add(space2);

		this.add(new BlogIcon());
		
		Label space3 = new Label(" ");
		space3.setWidth("10px");
		this.add(space3);

		this.add(new FacebookFeedbackButton());
	}

}

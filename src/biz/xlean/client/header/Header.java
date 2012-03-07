package biz.xlean.client.header;

import me.unoid.client.UnoIDGlobalVariables;
import me.unoid.client.login.AnchorLogout;
import me.unoid.client.login.facebook.LoginWithFacebookButton;
import me.unoid.client.me.MyPhoto;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class Header extends HorizontalPanel {

	public static HorizontalPanel hpLoginButton = new HorizontalPanel();

	public Header() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.add(new XLeanBizLogo());

		Label space = new Label(" ");
		space.setWidth("600px");
		this.add(space);

		hpLoginButton.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hpLoginButton.clear();
		this.add(hpLoginButton);

		if (UnoIDGlobalVariables.unoUser == null) {

			hpLoginButton.add(new LoginWithFacebookButton());
		} else {

			hpLoginButton.add(new MyPhoto(UnoIDGlobalVariables.unoUser));
		}

		Label space2 = new Label(" ");
		space2.setWidth("250px");
		this.add(space2);

		this.add(new FacebookFeedbackButton());

		if (UnoIDGlobalVariables.unoUser != null) {

			Label space3 = new Label(" ");
			space3.setWidth("50px");
			hpLoginButton.add(space3);

			hpLoginButton.add(new AnchorLogout());
		}
	}

}

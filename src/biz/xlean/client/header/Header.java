package biz.xlean.client.header;

import me.unoid.client.UnoIDGlobalVariables;
import me.unoid.client.login.AnchorLogout;
import me.unoid.client.login.facebook.LoginWithFacebookButton;
import me.unoid.client.me.MyPhoto;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
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

			hpLoginButton.add(getUserPhoto(UnoIDGlobalVariables.unoUser));
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

	private HorizontalPanel getUserPhoto(final JSONObject unoUserJson) {

		MyPhoto myPhoto = new MyPhoto(unoUserJson);
		myPhoto.addDomHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// GWTEntryPoint.vpMain.clear();
				// GWTEntryPoint.vpMain.add(new EditEntity(unoUserJson));
			}
		}, ClickEvent.getType());

		return myPhoto;
	}
}

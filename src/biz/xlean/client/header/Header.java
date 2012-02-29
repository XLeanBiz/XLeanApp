package biz.xlean.client.header;

import me.unoid.client.login.AnchorLogout;
import me.unoid.client.login.facebook.LoginWithFacebookButton;
import me.unoid.client.me.MyPhoto;
import biz.xlean.client.XLeanBizGlobalVariables;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class Header extends HorizontalPanel {

	public Header() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.add(new XLeanBizLogo());

		Label space = new Label(" ");
		space.setWidth("500px");
		this.add(space);

		if (XLeanBizGlobalVariables.unoUser == null) {

			this.add(new LoginWithFacebookButton());
		} else {

			this.add(getUserPhoto(XLeanBizGlobalVariables.unoUser));
		}

		Label space2 = new Label(" ");
		space2.setWidth("50px");
		this.add(space2);

		this.add(new FacebookFeedbackButton());

		if (XLeanBizGlobalVariables.unoUser != null) {
			
			Label space3 = new Label(" ");
			space3.setWidth("50px");
			this.add(space3);

			this.add(new AnchorLogout());
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

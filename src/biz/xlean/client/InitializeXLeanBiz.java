package biz.xlean.client;

import biz.xlean.client.about.AboutXLean;
import biz.xlean.client.header.Header;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginVerifyer;

import com.google.gwt.user.client.ui.RootPanel;
import com.startupstages.client.InitializeBlog;

public class InitializeXLeanBiz {

	private static final String livesourceFacebookID = "194243253971053";
	private static final String REDIRECT_URL = "http://www.xlean.biz/";
	private static final String xleanbizFacebookID = "326884367376395";

	public InitializeXLeanBiz(final boolean openIntroduction, final String topic) {

		RootPanel.get().clear();
		RootPanel.get().add(new Home());

		if (openIntroduction && topic == null) {

			Home.vpMain.clear();
			Home.vpMain.add(new AboutXLean());
		} else {

			openBlog(topic);
		}
	}

	public static void openBlog(String topic) {

		Home.vpHeader.clear();
		Home.vpHeader.add(new Header());

		Home.vpMain.clear();
		Home.vpMain.add(new InitializeBlog(topic));
	}

	public static void InitializeFacebookLogin() {

		FacebookLoginPanel.setPanel(xleanbizFacebookID, REDIRECT_URL);
	}

	public static void VerifyFacebookLogin(final String authenticationCode) {

		FacebookLoginVerifyer.authenticate(xleanbizFacebookID,
				authenticationCode, REDIRECT_URL);
	}
}

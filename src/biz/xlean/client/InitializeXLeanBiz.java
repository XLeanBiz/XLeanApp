package biz.xlean.client;

import biz.xlean.client.about.AboutXLean;
import biz.xlean.client.header.Header;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginVerifyer;
import co.uniqueid.authentication.client.login.facebook.InitializeFacebookLogin;

import com.google.gwt.user.client.ui.RootPanel;
import com.startupstages.client.InitializeBlog;

public class InitializeXLeanBiz {

	private static final String livesourceFacebookID = "194243253971053";
	private static final String REDIRECT_URL = "http://www.xlean.biz/";
	private static final String xleanbizFacebookID = "326884367376395";

	public InitializeXLeanBiz(final String uniqueID,
			final boolean openIntroduction, final String topic,
			final String companyID) {

		RootPanel.get().clear();
		RootPanel.get().add(new Home(), 0, 0);

		if (openIntroduction && topic == null && companyID == null) {

			Home.vpMain.clear();
			Home.vpMain.add(new AboutXLean());
		} else {

			openBlog(uniqueID, topic, companyID);
		}
	}

	public static void openBlog(final String uniqueID, String topic,
			final String companyID) {

		Home.vpHeader.clear();
		Home.vpHeader.add(new Header());

		new InitializeFacebookLogin(uniqueID, xleanbizFacebookID, REDIRECT_URL,
				companyID);

		Home.vpMain.clear();
		Home.vpMain.add(new InitializeBlog(topic));
	}

	public static void VerifyFacebookLogin(final String authenticationCode) {

		FacebookLoginVerifyer.authenticate(xleanbizFacebookID,
				authenticationCode, REDIRECT_URL, null, true);
	}
}

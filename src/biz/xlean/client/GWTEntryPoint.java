package biz.xlean.client;

import java.util.logging.Logger;

import me.unoid.client.Utilities.EncryptText;
import me.unoid.client.login.facebook.FacebookLoginVerifyer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;
import com.startupstages.client.StartupStagesGlobalVariables;
import com.startupstages.client.blog.BlogPanel;
import com.startupstages.client.blog.steps.Ideation;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTEntryPoint implements EntryPoint {

	private static Logger logger = Logger.getLogger("UnoIDMe");

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// Cookies.setCookie("UnoUser",
		// EncryptText.encrypt(UnoUserTest.unoUserJsonString()));

		String unoUser = EncryptText.decrypt(Cookies.getCookie("UnoUser"));

		if (unoUser == null || unoUser.equals("null")) {

			final String authenticationCode = Location.getParameter("code");

			final String error = Location.getParameter("error_reason");

			if (!((null != error && error.equals("user_denied")) || (authenticationCode == null || ""
					.equals(authenticationCode)))) {

				FacebookLoginVerifyer.authenticate(authenticationCode);
			}

		} else {

			JSONObject obj = (JSONObject) JSONParser.parseStrict(unoUser);
			XLeanBizGlobalVariables.unoUser = obj;

			// GetUnoUser.get(unoUser);
		}

		RootPanel.get().add(new Home());

		StartupStagesGlobalVariables.startTopics();

		Home.vpMain.clear();
		Home.vpMain.add(new BlogPanel());

		Ideation.initializeIdeationPanel();

		if (unoUser == null || unoUser.equals("null")) {
			// aboutXlean.center();
			XLeanBizGlobalVariables.aboutXlean.show();
		}

	}
}

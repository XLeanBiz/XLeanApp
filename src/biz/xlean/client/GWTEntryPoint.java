package biz.xlean.client;

import java.util.logging.Logger;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginVerifyer;
import co.uniqueid.authentication.client.utilities.EncryptText;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTEntryPoint implements EntryPoint {

	private static Logger logger = Logger.getLogger("UnoIDMe");

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		String unoUser = EncryptText.decrypt(Cookies.getCookie("UnoUser"));

		if (unoUser == null || unoUser.equals("null")) {

			final String authenticationCode = Location.getParameter("code");

			final String error = Location.getParameter("error_reason");

			if (!((null != error && error.equals("user_denied")) || (authenticationCode == null || ""
					.equals(authenticationCode)))) {

				new InitializeXLeanBiz(false);

				FacebookLoginVerifyer.authenticate(authenticationCode);
			} else {

				new InitializeXLeanBiz(true);
			}
		} else {

			JSONObject obj = (JSONObject) JSONParser.parseStrict(unoUser);

			UniqueIDGlobalVariables.uniqueID = obj;

			new InitializeXLeanBiz(false);
		}

	}
}

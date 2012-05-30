package biz.xlean.client;

import biz.xlean.client.utilities.UseTracking;
import co.uniqueid.authentication.client.utilities.EncryptText;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTEntryPoint implements EntryPoint {

	// private static Logger logger = Logger.getLogger("XLeanBiz");

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		new UseTracking(this.getClass().getName());

		String uniqueID = EncryptText.decrypt(Cookies.getCookie("UniqueID"));

		// uniqueIDJsonString = UserTest.get();
		// logger.log(Level.INFO, "uniqueIDJsonString=" + uniqueIDJsonString);

		final String topic = Location.getParameter("topic");
		final String company = Location.getParameter("company");

		if (uniqueID == null || uniqueID.equals("null")) {

			String authenticationCode = Location.getParameter("code");
			// authenticationCode = "test";

			final String error = Location.getParameter("error_reason");

			if (!((null != error && error.equals("user_denied")) || (authenticationCode == null || ""
					.equals(authenticationCode)))) {

				new InitializeXLeanBiz(null, false, topic, company);

				InitializeXLeanBiz.VerifyFacebookLogin(authenticationCode);
			} else {

				new InitializeXLeanBiz(null, true, topic, company);
			}
		} else {

			new InitializeXLeanBiz(uniqueID, false, topic, company);
		}
	}
}

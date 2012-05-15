package biz.xlean.client;

import biz.xlean.client.companies.ListCompanies;
import biz.xlean.client.utilities.UseTracking;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
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

	// private static Logger logger = Logger.getLogger("XLeanBiz");

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		new UseTracking(this.getClass().getName());

		String uniqueIDJsonString = EncryptText.decrypt(Cookies
				.getCookie("UniqueID"));

		//uniqueIDJsonString = userTest();
		// logger.log(Level.INFO, "uniqueIDJsonString=" + uniqueIDJsonString);

		final String topic = Location.getParameter("topic");

		if (uniqueIDJsonString == null || uniqueIDJsonString.equals("null")) {

			final String authenticationCode = Location.getParameter("code");

			final String error = Location.getParameter("error_reason");

			if (!((null != error && error.equals("user_denied")) || (authenticationCode == null || ""
					.equals(authenticationCode)))) {

				new InitializeXLeanBiz(false, topic);

				InitializeXLeanBiz.VerifyFacebookLogin(authenticationCode);
			} else {

				new InitializeXLeanBiz(true, topic);
			}
		} else {

			JSONObject obj = (JSONObject) JSONParser
					.parseStrict(uniqueIDJsonString);

			UniqueIDGlobalVariables.uniqueID = obj;

			new InitializeXLeanBiz(false, topic);

			ListCompanies.list(obj);
		}

	}

	private String userTest() {

		return "{\"ID\":\"AllineWatkins_1332886062783\","
				+ "\"image\":\"http://m3.licdn.com/mpr/mpr/shrink_100_100/p/3/000/047/3d0/26e9188.jpg\","
				+ "\"entityName\":\"Alline Watkins\","
				+ "\"first_name\":\"Alline\","
				+ "\"email\":\"alline.oliveira@gmail.com\","
				+ "\"gender\":\"female\"," + "\"facebook_id\":\"537675235\","
				+ "\"githubLogin\":\"allineo\"}";

	}
}

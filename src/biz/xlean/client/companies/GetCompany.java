package biz.xlean.client.companies;

import biz.xlean.client.Home;
import biz.xlean.client.header.Header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.startupdata.client.StartupData;
import com.startupstages.client.InitializeBlog;

public class GetCompany {

	public static void get(final String uniqueID, final boolean restartBlog) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.getUniqueID(uniqueID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				if (jsonResults != null) {

					JSONObject obj = (JSONObject) JSONParser
							.parseStrict(jsonResults);

					if (obj != null) {

						StartupData.init(obj);

						Header.vpCompanies.clear();
						Header.vpCompanies.add(new CompanyIcon(obj));

						if (restartBlog) {

							Home.vpMain.clear();
							Home.vpMain.add(new InitializeBlog(null));
						}
					}

				}
			}
		});
	}

}

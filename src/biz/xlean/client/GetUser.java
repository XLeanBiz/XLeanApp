package biz.xlean.client;

import biz.xlean.client.companies.ListCompanies;
import biz.xlean.client.companies.UniqueIDService;
import biz.xlean.client.companies.UniqueIDServiceAsync;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetUser {

	public static void get(final String uniqueID, final String topic) {

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

						UniqueIDGlobalVariables.uniqueID = obj;

						new InitializeXLeanBiz(false, topic);

						ListCompanies.list();

					} else {

						new InitializeXLeanBiz(true, topic);
					}
				}
			}
		});
	}

}

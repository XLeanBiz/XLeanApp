package biz.xlean.client.companies;

import biz.xlean.client.header.Header;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.startupdata.client.StartupDataGlobalVariables;

public class ListCompanies {

	public static JSONArray companiesList = null;

	public static void list(final JSONObject uniqueIDJson) {

		String ID = ConvertJson.getStringValue(uniqueIDJson, "ID");

		list(ID);
	}

	public static void list(final String uniqueID) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.listFounded(uniqueID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONArray jsonArray = (JSONArray) JSONParser
						.parseStrict(jsonResults);

				companiesList = jsonArray;

				JSONObject companyJson = (JSONObject) jsonArray.get(0);

				StartupDataGlobalVariables.companyID = ConvertJson
						.getStringValue(companyJson, "ID");

				Header.vpCompanies.clear();
				Header.vpCompanies.add(new CompanyIcon(companyJson));

			}
		});
	}

}

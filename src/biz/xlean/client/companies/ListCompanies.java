package biz.xlean.client.companies;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class ListCompanies {

	public static JSONArray companiesList = null;

	public static JSONArray permissionsList = null;

	public static void list() {

		companiesList = UniqueIDGlobalVariables.uniqueID.get("FoundedInfo")
				.isArray();

		permissionsList = UniqueIDGlobalVariables.uniqueID.get(
				"PermissionsInfo").isArray();

		JSONObject companyJson = (JSONObject) companiesList.get(0);

		String ID = ConvertJson.getStringValue(companyJson, "ID");

		GetCompany.get(ID, false);
	}
}

package biz.xlean.client.companies;

import biz.xlean.client.header.Header;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.startupdata.client.StartupData;

public class ListCompanies {

	public static JSONArray companiesList = null;
	
	public static JSONArray permissionsList = null;

	public static void list() {

		companiesList = UniqueIDGlobalVariables.uniqueID.get("FoundedInfo")
				.isArray();
		
		permissionsList = UniqueIDGlobalVariables.uniqueID.get("PermissionsInfo")
				.isArray();

		JSONObject companyJson = (JSONObject) companiesList.get(0);

		StartupData.company = companyJson;

		Header.vpCompanies.clear();
		Header.vpCompanies.add(new CompanyIcon(companyJson));
	}
}

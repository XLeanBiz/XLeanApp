package biz.xlean.client.companies;

import biz.xlean.client.companies.change.ChangeCompanyPanel;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class CompanyIcon extends HTML {

	public CompanyIcon(final JSONObject companyJson) {

		String entityName = ConvertJson.getStringValue(companyJson,
				"entityName");

		String imageURL = ConvertJson.getStringValue(companyJson, "image");

		this.setHTML("<a href='#'><img src='" + imageURL
				+ "' border=0 width='30px' height='30px' title='" + entityName
				+ "'></a>");
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ChangeCompanyPanel popup = new ChangeCompanyPanel();

				popup.show();
			}
		});

	}
}

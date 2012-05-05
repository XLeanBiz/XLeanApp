package biz.xlean.client.companies.change;

import biz.xlean.client.companies.CompanyIcon;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;

public class CompanyLogo extends HorizontalPanel {

	public CompanyLogo(final JSONObject companyJson, final PopupPanel popup) {

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				CompanyIcon.chooseCompany(companyJson);

				popup.hide();
			}
		};

		String entityName = ConvertJson.getStringValue(companyJson,
				"entityName");

		String imageURL = ConvertJson.getStringValue(companyJson, "image");
		if (imageURL != null) {

			HTML image = new HTML("<a href='#'><img src='" + imageURL
					+ "' border=0 width='70px' height='70px' title='"
					+ entityName + "'></a>");
			image.addClickHandler(clickHandler);
			this.add(image);
		}

		HTML name = new HTML("<font size=2 color=blue><a href='#'>"
				+ entityName + "</a></font>");
		name.addClickHandler(clickHandler);
		this.add(name);
	}
}

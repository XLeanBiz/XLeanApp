package biz.xlean.client.companies.change;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeCompanyPanel extends PopupPanel {

	public ChangeCompanyPanel(final JSONArray companiesList) {

		// this.center();
		this.setAutoHideEnabled(true);

		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("300px");

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		vp.add(new CloseButton(this));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		vp.add(new Label("Choose your company:"));

		vp.setSpacing(10);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(showCompanies(companiesList, this));

		this.setWidget(vp);

	}

	private VerticalPanel showCompanies(final JSONArray companiesList,
			final PopupPanel popup) {

		VerticalPanel vp = new VerticalPanel();

		for (int i = 0; i < companiesList.size(); i++) {

			JSONObject companyJson = (JSONObject) companiesList.get(i);

			vp.add(new CompanyLogo(companyJson, popup));
		}

		return vp;
	}
}

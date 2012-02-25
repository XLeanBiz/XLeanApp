package biz.xlean.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;

public class AboutXLean extends PopupPanel {

	public AboutXLean() {

		this.setAutoHideEnabled(true);

		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("726px", "689px");

		Image image = new Image("images/eXtremeLeanBusiness.jpg");
		absolutePanel.add(image, 229, 0);

		Image image_1 = new Image("images/InteractiveBlog.jpg");
		absolutePanel.add(image_1, 44, 299);
		image_1.setSize("146px", "139px");

		HTML htmlLearnEverythingAbout = new HTML(
				"Learn everything about <br>Customer Development <br>and Lean Startups in our <br> interactive Blog.",
				true);
		absolutePanel.add(htmlLearnEverythingAbout, 54, 449);

		Image image_2 = new Image("images/feedbackOrganizer.jpg");
		absolutePanel.add(image_2, 306, 299);

		HTML htmlFeedbackIsKey = new HTML(
				"Feedback is key for <br>Customer Development.<br> We help you extremely <br>collect and organize it!",
				true);
		absolutePanel.add(htmlFeedbackIsKey, 327, 449);

		Image image_3 = new Image("images/metrics.jpg");
		absolutePanel.add(image_3, 555, 262);

		HTML htmlStartupMetricsAnd = new HTML(
				"Metrics Matter!<br> We compare you to<br> others. You look better <br>than you think!",
				true);
		absolutePanel.add(htmlStartupMetricsAnd, 567, 449);

		Image image_4 = new Image("images/tryItNow.jpg");
		image_4.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				GWTEntryPoint.aboutXlean.hide();
			}
		});
		absolutePanel.add(image_4, 264, 611);

	}
}

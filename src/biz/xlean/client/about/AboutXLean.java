package biz.xlean.client.about;

import biz.xlean.client.Home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.startupstages.client.about.BlogIntroduction;

public class AboutXLean extends AbsolutePanel {

	public AboutXLean() {

		this.setSize("900px", "750px");

		Image image = new Image("images/eXtremeLeanBusiness.jpg");
		this.add(image, 229, 0);

		Image image_1 = new Image("images/InteractiveBlog.jpg");
		this.add(image_1, 44, 265);
		image_1.setSize("146px", "139px");

		HTML htmlLearnEverythingAbout = new HTML(
				"Learn everything about <br>Customer Development <br>and Lean Startups in our <br> interactive Blog.",
				true);
		this.add(htmlLearnEverythingAbout, 54, 415);

		Image image_2 = new Image("images/feedbackOrganizer.jpg");
		this.add(image_2, 306, 265);

		HTML htmlFeedbackIsKey = new HTML(
				"Feedback is key for <br>Customer Development.<br> We help you extremely <br>collect and organize it!",
				true);
		this.add(htmlFeedbackIsKey, 327, 415);

		Image image_3 = new Image("images/metrics.jpg");
		this.add(image_3, 555, 228);

		HTML htmlStartupMetricsAnd = new HTML(
				"Metrics Matter!<br> We compare you to<br> others. You look better <br>than you think!",
				true);
		this.add(htmlStartupMetricsAnd, 567, 415);

		Image image_4 = new Image("images/tryItNow.jpg");
		image_4.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				Home.vpMain.clear();
				Home.vpMain.add(new BlogIntroduction(new ButtonStartBlog()));
			}
		});
		this.add(image_4, 293, 549);

	}
}
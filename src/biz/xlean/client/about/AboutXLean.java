package biz.xlean.client.about;

import biz.xlean.client.Home;
import biz.xlean.client.utilities.UseTracking;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.startupstages.client.about.BlogIntroduction;

public class AboutXLean extends AbsolutePanel {

	public AboutXLean() {

		new UseTracking("biz.xlean.client.about.AboutXLean");

		this.setSize("900px", "750px");

		Image image = new Image("images/eXtremeLeanBusiness.jpg");
		this.add(image, 229, 0);

		HTML image_1 = new HTML(
				"<a href=#><img src='images/InteractiveGuide.jpg' width=146 height=139 border=0></a>");
		image_1.addClickHandler(getBlogClickHandler("BlogImage"));
		this.add(image_1, 44, 265);

		HTML htmlLearnEverythingAbout = new HTML("<a href=#>"
				+ "Follow all the information  <br> about Customer Development "
				+ "<br>and Lean Startups in our <br> interactive Guide.</a>",
				true);
		htmlLearnEverythingAbout
				.addClickHandler(getBlogClickHandler("BlogText"));
		this.add(htmlLearnEverythingAbout, 54, 415);

		Image image_2 = new Image("images/feedbackOrganizer.jpg");
		image_2.addClickHandler(getFeedbackClickHandler());
		this.add(image_2, 306, 265);

		HTML htmlFeedbackIsKey = new HTML(
				"Feedback is key for <br>Customer Development.<br> " +
				"We will tell you all the thuth" +
				" <br>about your product <br> and your company.",
				true);
		htmlFeedbackIsKey.addClickHandler(getFeedbackClickHandler());
		this.add(htmlFeedbackIsKey, 327, 415);

		Image image_3 = new Image("images/metrics.jpg");
		image_3.addClickHandler(getMetricsClickHandler());
		this.add(image_3, 555, 228);

		HTML htmlStartupMetricsAnd = new HTML(
				"Metrics Matter!<br> We compare you to<br> others. You look better <br>than you think!",
				true);
		htmlStartupMetricsAnd.addClickHandler(getMetricsClickHandler());
		this.add(htmlStartupMetricsAnd, 567, 415);

		HTML image_4 = new HTML("<a href=#><img src='images/tryItNow.jpg' border=0></a>");
		image_4.addClickHandler(getBlogClickHandler("TryItNowButton"));
		this.add(image_4, 293, 549);

	}

	private ClickHandler getBlogClickHandler(final String clickOriginator) {

		ClickHandler clickHandler = new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking("biz.xlean.client.about.AboutXLean#"
						+ clickOriginator);

				Home.vpMain.clear();
				Home.vpMain.add(new BlogIntroduction(new ButtonStartBlog()));
			}
		};

		return clickHandler;
	}

	private ClickHandler getFeedbackClickHandler() {

		ClickHandler clickHandler = new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(
						"biz.xlean.client.about.AboutXLean#FeedbackImage");
			}
		};

		return clickHandler;
	}

	private ClickHandler getMetricsClickHandler() {

		ClickHandler clickHandler = new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(
						"biz.xlean.client.about.AboutXLean#MetricsImage");
			}
		};

		return clickHandler;
	}
}

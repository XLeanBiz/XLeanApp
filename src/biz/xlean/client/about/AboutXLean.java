package biz.xlean.client.about;

import biz.xlean.client.Home;
import biz.xlean.client.utilities.UseTracking;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.startupstages.client.InitializeBlog;
import com.startupstages.client.StartupStagesGlobalVariables;

public class AboutXLean extends AbsolutePanel {

	public AboutXLean() {

		new UseTracking("biz.xlean.client.about.AboutXLean");

		this.setSize("900px", "750px");

		Image image = new Image("images/eXtremeLeanBusiness.jpg");
		this.add(image, 229, 0);

		HTML image_1 = new HTML(
				"<a href='http://xleanbiz.wordpress.com/2012/03/23/what-stage-are-you/' target='_blank'>"
						+ "<img src='images/InteractiveGuide.jpg' width=146 height=139 border=0></a>");
		this.add(image_1, 44, 265);

		HTML htmlLearnEverythingAbout = new HTML(
				"<a href='http://xleanbiz.wordpress.com/2012/03/23/what-stage-are-you/' target='_blank'>"
						+ " &nbsp;<b><font color=red>INTERACTIVE GUIDE</font></b>"
						+ "<br>Follow all the information  <br> about Customer Development "
						+ "<br>and Lean Startups.</a>", true);
		this.add(htmlLearnEverythingAbout, 54, 415);

		Image image_2 = new Image("images/feedbackOrganizer.jpg");
		image_2.addClickHandler(getFeedbackClickHandler());
		this.add(image_2, 306, 265);

		HTML htmlFeedbackIsKey = new HTML(
				"Feedback is key for <br>Customer Development.<br> "
						+ "We will tell you all the thuth"
						+ " <br>about your product <br> and your company.",
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

		this.add(new ButtonTryItNow(), 293, 549);
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

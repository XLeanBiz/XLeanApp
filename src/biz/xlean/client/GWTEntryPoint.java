package biz.xlean.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.startupstages.client.blog.BlogPanel;
import com.startupstages.client.blog.steps.Ideation;
import com.startupstages.client.model.TopicsMockup;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTEntryPoint implements EntryPoint {

	public static AboutXLean aboutXlean = new AboutXLean();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		RootPanel.get().add(new Home());

		BlogPanel.topics = TopicsMockup.getTopics();

		Home.vpMain.clear();
		Home.vpMain.add(new BlogPanel());

		Ideation.initializeIdeationPanel();

		aboutXlean.center();
		aboutXlean.show();
	}
}

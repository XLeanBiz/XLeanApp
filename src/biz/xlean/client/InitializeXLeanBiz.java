package biz.xlean.client;

import biz.xlean.client.about.AboutXLean;
import biz.xlean.client.header.Header;

import com.google.gwt.user.client.ui.RootPanel;
import com.startupstages.client.InitializeBlog;

public class InitializeXLeanBiz {

	public InitializeXLeanBiz(boolean openIntroduction) {

		RootPanel.get().add(new Home());

		if (openIntroduction) {

			Home.vpMain.clear();
			Home.vpMain.add(new AboutXLean());
		} else {

			openBlog();
		}
	}

	public static void openBlog() {

		Home.vpHeader.clear();
		Home.vpHeader.add(new Header());

		Home.vpMain.clear();
		Home.vpMain.add(new InitializeBlog());
	}
}

package biz.xlean.client.about;

import biz.xlean.client.InitializeXLeanBiz;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

public class ButtonStartBlog extends Image {

    public ButtonStartBlog() {

        this.setUrl("images/tryItNow.jpg");
        this.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

                InitializeXLeanBiz.openBlog();
            }
        });

    }
}

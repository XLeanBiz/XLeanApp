package biz.xlean.client.companies;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UniqueIDServiceAsync {
	
	void getUniqueID(String unoUserID, AsyncCallback<String> callback);

}

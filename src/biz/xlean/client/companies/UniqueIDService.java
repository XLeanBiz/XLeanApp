package biz.xlean.client.companies;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("uniqueID_API")
public interface UniqueIDService extends RemoteService {

	String listFounded(final String uniqueID);

}

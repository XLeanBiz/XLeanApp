package biz.xlean.server;

import biz.xlean.client.companies.UniqueIDService;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UniqueIDServiceImpl extends RemoteServiceServlet implements
		UniqueIDService {

	private static final long serialVersionUID = -8355612980477933670L;

	private static String listFoundedUrl = "https://api.unoidme.appspot.com/ListFoundedService";

	public String listFounded(final String uniqueID) {

		String parameters = "UniqueID=" + uniqueID;

		final String jsonString = URLUtilities.fetchURLPost(listFoundedUrl,
				parameters);

		return jsonString;
	}

}

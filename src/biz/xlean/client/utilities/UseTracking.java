package biz.xlean.client.utilities;


public class UseTracking {

	public UseTracking(String trackingString) {

		useTrack(trackingString);
	}

	public static native void useTrack(String trackingString)/*-{
		
		$wnd._gaq.push(['_trackEvent', 'xlean', trackingString])
		$wnd.mpq.track(trackingString);
	}-*/;
}

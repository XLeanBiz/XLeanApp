package biz.xlean.client.utilities;


public class MixPanelTracking {

	public MixPanelTracking(String trackingString) {

		mixPanelTrack(trackingString);
	}

	public static native void mixPanelTrack(String trackingString)/*-{
		
		$wnd._gaq.push(['_trackEvent', 'xlean', trackingString])
		$wnd.mpq.track(trackingString);
	}-*/;
}

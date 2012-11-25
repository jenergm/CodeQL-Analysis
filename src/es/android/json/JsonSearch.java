package es.android.json;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

public class JsonSearch {

	private final static String OK = "OK";
	private final static String RESULTS = "results";
	private final static String STATUS = "status";
	private final static String GEOMETRY = "geometry";
	private final static String LOCATION = "location";
	private final static String LAT = "lat";
	private final static String LNG = "lng";

	public Location getSearch(String search) {

		HttpClient httpClient = new DefaultHttpClient();

		HttpGet get = new HttpGet(
				"http://maps.googleapis.com/maps/api/geocode/json?address="
						+ search + "&sensor=true");

		get.setHeader("content-type", "application/json");

		Location location = null;

		try {
			HttpResponse resp = httpClient.execute(get);
			String respStr = EntityUtils.toString(resp.getEntity());

			JSONObject jObject = new JSONObject(respStr);

			String status = (String) jObject.get(STATUS);

			if (status.equalsIgnoreCase(OK)) {

				JSONArray respJSON = (JSONArray) jObject.get(RESULTS);

				jObject = respJSON.getJSONObject(0);

				jObject = (JSONObject) jObject.get(GEOMETRY);

				jObject = (JSONObject) jObject.get(LOCATION);

				Double latitud = (Double) jObject.get(LAT);

				Double longitud = (Double) jObject.get(LNG);

				location = new Location(longitud, latitud);
			}

		} catch (Exception excp) {
			Log.e("JsonSearch", "Error json", excp);
		}

		return location;

	}

}

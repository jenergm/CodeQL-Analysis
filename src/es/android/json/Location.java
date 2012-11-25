package es.android.json;

public class Location {

	private Double longitud;
	private Double latitud;

	public Location(Double logitud, Double latitud) {
		this.longitud = logitud;
		this.latitud = latitud;

	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

}

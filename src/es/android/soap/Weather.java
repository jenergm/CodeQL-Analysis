package es.android.soap;

public class Weather {

	String _id;
	String description;
	String PictureURL;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPictureURL() {
		return PictureURL;
	}
	public void setPictureURL(String pictureURL) {
		PictureURL = pictureURL;
	}
	
	
	
}

package main.java.app.location;

public class Location {
	private double latitude;
	private double longitude;

	
	public Location() {
		this.latitude = 0;
		this.longitude = 0;
	}
	
	public Location(double latitude, double longitude){
		this.setLocation(latitude, longitude);
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public void setLocation(double latitude, double longitude){
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Location))return false;
	    Location otherLocation = (Location)other;
	    if (this.latitude == otherLocation.getLatitude() && this.longitude == otherLocation.getLongitude()) return true;
	    return false;
	}

}

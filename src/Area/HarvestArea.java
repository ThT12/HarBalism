package Area;

import Location.Location;

public class HarvestArea {
	private Location location;
	private AreaSize size;
	private double disponibility;
	
	
	public HarvestArea(){
		this.location = new Location();
		this.size = AreaSize.SMALL;
		this.disponibility = 1;	
	}
	
	public HarvestArea(double latitude,double longitude, AreaSize size, double disponibility) throws Exception{
		
		if (disponibility < 0 || disponibility > 1){
			Exception e = new Exception("The disponibility must be between 0 and 1");
			throw e;
		}
		this.location = new Location(latitude, longitude);
		this.size = size;
		this.disponibility = disponibility;	
	}
	
	public void updateDisponibility(double percentHarvest, AreaSize newSize){
		double percentRest = 1 - percentHarvest;
		if (this.size == newSize) {
			this.disponibility *= percentRest;
		}
		else {
			this.size = newSize;
			this.disponibility = percentRest;
		}	
	}
	
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public AreaSize getSize() {
		return size;
	}

	public void setSize(AreaSize size) {
		this.size = size;
	}

	public double getDisponibility() {
		return disponibility;
	}

	public void setDisponibility(double disponibility) {
		this.disponibility = disponibility;
	}

}

package Area;

import maths.Percent;
import Location.Location;

public class HarvestArea {
	private Location location;
	private AreaSize size;
	private Percent disponibility;
	
	
	public HarvestArea() throws Exception{
		this.setLocation(new Location());
		this.setSize(AreaSize.SMALL);
		this.setDisponibility(1);	
	}
	
	public HarvestArea(double latitude,double longitude, AreaSize size, double disponibility) throws Exception {
		this.setDisponibility(disponibility);	
		this.setLocation(new Location(latitude, longitude));
		this.setSize(size);;
	}
	
	public void updateDisponibility(double percentHarvest, AreaSize newSize) throws Exception{
		double percentRest = 1 - percentHarvest;
		if (this.size == newSize) {
			this.setDisponibility(this.disponibility.getPercent() * percentRest);
		}
		else {
			this.setSize(newSize); 
			this.setDisponibility(percentRest);
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

	public Percent getDisponibility() {
		return disponibility;
	}

	public void setDisponibility(double disponibility) throws Exception {
		this.disponibility = new Percent(disponibility);
	}

}

package main.java.app.area;

import org.codehaus.jackson.annotate.JsonIgnore;

import main.java.app.hiking.Hiking;
import main.java.app.location.Location;
import main.java.app.maths.Percent;
import main.java.app.plant.Plant;


public class HarvestArea {
	private String name;
	private Location location;
	private AreaSize size;
	private Percent disponibility;
	private Plant plant;
	private Hiking hiking;
	

	public HarvestArea() throws Exception{
		this.setName("Myspot");
		this.setLocation(new Location());
		this.setSize(AreaSize.SMALL);
		this.setDisponibility(1);
		this.setPlant(new Plant());
		this.setHiking(new Hiking());
	}
	


	public HarvestArea(String name, double latitude,double longitude, AreaSize size, double disponibility, Plant plant, Hiking hiking) throws Exception {
		this.setName(name);
		this.setDisponibility(disponibility);	
		this.setLocation(new Location(latitude, longitude));
		this.setSize(size);
		this.setPlant(plant);
		this.setHiking(hiking);
	}
	
	public void updateDisponibility(double percentHarvest, AreaSize newSize) throws Exception{
		double percentRest = 1 - percentHarvest;
		if (newSize == AreaSize.NULL ||this.size == newSize) {
			this.setDisponibility(this.disponibility.getPercent() * percentRest);
		}
		else {
			this.setSize(newSize); 
			this.setDisponibility(percentRest);
		}	
	}
	
	public boolean isHarvestable() {
		if (this.getPlant().isHarvestable() && 
				this.getDisponibility().getPercent() > this.getSize().getLimitHarvest()) return true;
		return false;
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
	
	public String getSizeString() {
		return size.toString();
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
	
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
	@JsonIgnore
	public Hiking getHiking() {
		return hiking;
	}
	public void setHiking(Hiking hiking) {
		this.hiking = hiking;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getHikingName() {
		return this.hiking.getName();
	}

}

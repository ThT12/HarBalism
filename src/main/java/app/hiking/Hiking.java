package main.java.app.hiking;

import main.java.app.area.HarvestArea;
import main.java.app.area.HarvestAreas;

public class Hiking implements Comparable<Hiking> {
	
	private String name;
	private HarvestAreas harvestAreas;
	private int numberOfHarvestableArea;

	public Hiking() throws Exception{
		this.setName("Default Hiking");
		this.setHarvestAreas(new HarvestAreas());
	}
	
	public Hiking(String name) throws Exception{
		this.setName(name);
		this.setHarvestAreas(new HarvestAreas());
	}
	
	public void addHarvestArea(HarvestArea ha){
		this.harvestAreas.addHarvestArea(ha);
	}
	
	public void updateNumberOfHarvestableArea() throws Exception{
		HarvestAreas hasArvestable = this.getHarvestAreas().getAreaHarvestable();
		this.setNumberOfHarvestableArea(hasArvestable.getNumberOfHarvestArea());
	}
	

	public int getNumberOfHarvestableArea() {
		return numberOfHarvestableArea;
	}

	public void setNumberOfHarvestableArea(int numberOfHarvestableArea) {
		this.numberOfHarvestableArea = numberOfHarvestableArea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public HarvestAreas getHarvestAreas() {
		return harvestAreas;
	}


	public void setHarvestAreas(HarvestAreas harvestAreas) {
		this.harvestAreas = harvestAreas;
	}
	
	@Override
	public int compareTo(Hiking hiking) {
		int compareage=((Hiking)hiking).getNumberOfHarvestableArea();
        /* For Ascending order*/
        return this.getNumberOfHarvestableArea()-compareage;
	}

}

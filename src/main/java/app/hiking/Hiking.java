package main.java.app.hiking;

import main.java.app.area.HarvestArea;
import main.java.app.area.HarvestAreas;

public class Hiking {
	
	private String name;
	private HarvestAreas harvestAreas;

	public Hiking() throws Exception{
		this.setName("Default Hiking");
		this.setHarvestAreas(new HarvestAreas());
	}
	
	public void addHarvestArea(HarvestArea ha){
		this.harvestAreas.addHarvestArea(ha);
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

}

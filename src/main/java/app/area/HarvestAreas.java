package main.java.app.area;

import java.util.ArrayList;
import java.util.List;

import main.java.app.plant.Plant;

public class HarvestAreas {
	
	private List<HarvestArea> areas;

	public HarvestAreas() throws Exception{
		HarvestArea ha1 = new HarvestArea();
		HarvestArea ha2 = new HarvestArea();
		HarvestArea ha3 = new HarvestArea();
		ha1.setPlant(new Plant("Second Plant","01/01","01/10"));
		this.areas = new ArrayList<HarvestArea>();
		this.areas.add(ha1);
		this.areas.add(ha2);
		this.areas.add(ha3);
	}
	
	
	public List<HarvestArea> getAreas() {
		return areas;
	}

	public void setAreas(List<HarvestArea> areas) {
		this.areas = areas;
	}

}

package main.java.app.area;

import java.util.ArrayList;
import java.util.List;

import main.java.app.plant.Plant;

public class HarvestAreas {
	
	private List<HarvestArea> areas;

	public HarvestAreas() throws Exception{
		this.areas = new ArrayList<HarvestArea>();
	}
	
	public HarvestAreas(String s) throws Exception{
		HarvestArea ha1 = new HarvestArea();
		HarvestArea ha2 = new HarvestArea();
		HarvestArea ha3 = new HarvestArea();
		ha1.setPlant(new Plant("Second Plant","01/01","01/10"));
		this.areas = new ArrayList<HarvestArea>();
		this.areas.add(ha1);
		this.areas.add(ha2);
		this.areas.add(ha3);
	}
	
	public void addHarvestArea(HarvestArea ha) {
		this.areas.add(ha);		
	}
	
	public HarvestAreas getAreaHarvestable() throws Exception{
		HarvestAreas out = new HarvestAreas();
		for (HarvestArea ha : this.getAreas()) {
			if (ha.isHarvestable()) out.addHarvestArea(ha);
		}
		return out;
	}
	
	public int getNumberOfHarvestArea(){
		return this.getAreas().size();
	}
	
	public List<HarvestArea> getAreas() {
		return areas;
	}

	public void setAreas(List<HarvestArea> areas) {
		this.areas = areas;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof HarvestAreas))return false;
	    HarvestAreas otherHarvestAreas = (HarvestAreas)other;
	    if (this.getAreas().equals(otherHarvestAreas.getAreas())) return true;
	    return false;
	}

}

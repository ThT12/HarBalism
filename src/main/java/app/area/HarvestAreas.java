package main.java.app.area;

import java.util.ArrayList;
import java.util.List;

public class HarvestAreas {
	
	private List<HarvestArea> areas;

	public HarvestAreas() throws Exception{
		HarvestArea ha1 = new HarvestArea();
		HarvestArea ha2 = new HarvestArea();
		this.areas = new ArrayList<HarvestArea>();
		this.areas.add(ha1);
		this.areas.add(ha2);
	}
	
	
	public List<HarvestArea> getAreas() {
		return areas;
	}

	public void setAreas(List<HarvestArea> areas) {
		this.areas = areas;
	}

}

package main.java.app.hiking;

import java.util.ArrayList;
import java.util.List;

import main.java.app.area.HarvestArea;
import main.java.app.plant.Plant;

public class Hikings {
	
	private List<Hiking> hikings;

	public Hikings() throws Exception {
		Hiking h1 = new Hiking();
		Hiking h2 = new Hiking();
		Hiking h3 = new Hiking();
		HarvestArea ha1 = new HarvestArea();
		ha1.setPlant(new Plant("Third Plant","01/01","01/10"));
		HarvestArea ha12 = new HarvestArea();
		ha12.setPlant(new Plant("Third Plant","01/01","01/10"));
		HarvestArea ha13 = new HarvestArea();
		ha13.setPlant(new Plant("Common","01/01","01/10"));
		HarvestArea ha14 = new HarvestArea();
		ha14.setPlant(new Plant("Common","01/01","01/10"));
		HarvestArea ha15 = new HarvestArea();
		ha15.setPlant(new Plant("Other","01/01","01/10"));
		h1.addHarvestArea(ha1);
		h1.addHarvestArea(ha12);
		h1.addHarvestArea(ha13);
		h1.addHarvestArea(ha14);
		h1.addHarvestArea(ha15);
		HarvestArea ha2 = new HarvestArea();
		h2.addHarvestArea(ha2);
		HarvestArea ha3 = new HarvestArea();
		ha3.setPlant(new Plant("Other Plant","01/01","01/10"));
		h3.addHarvestArea(ha3);
		
		this.hikings = new ArrayList<Hiking>();
		this.hikings.add(h1);
		this.hikings.add(h2);
		this.hikings.add(h3);
	}
	
	public List<Hiking> getHikings() {
		return hikings;
	}

	public void setHikings(List<Hiking> hikings) {
		this.hikings = hikings;
	}
}

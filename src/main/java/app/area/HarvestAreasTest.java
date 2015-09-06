package main.java.app.area;

import static org.junit.Assert.*;
import main.java.app.plant.Plant;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class HarvestAreasTest {


	@Test
	public void getAreaHarvestableReturnTheGoodOut() throws Exception {
		
		HarvestArea ha1 = new HarvestArea();
		ha1.setDisponibility(0.3);
		
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd");
		DateTime now = new DateTime();
		DateTime start = now.minusDays(20);
		DateTime end = now.plusDays(20);
		
		Plant plant1 = new Plant("test",start.toString(dtf),end.toString(dtf));
		ha1.setPlant(plant1);
			
		HarvestArea ha2 = new HarvestArea();
		ha2.setDisponibility(1);
		
		Plant plant2 = new Plant("test",start.toString(dtf),end.toString(dtf));
		ha2.setPlant(plant2);
		
		HarvestAreas has = new HarvestAreas();
		has.addHarvestArea(ha1);
		has.addHarvestArea(ha2);
		
		HarvestAreas hasExpect = new HarvestAreas();
		hasExpect.addHarvestArea(ha2);
		
		assertEquals(hasExpect,has.getAreaHarvestable());
	}
	
	@Test
	public void testGetNumberOfHarvestArea() throws Exception {
		HarvestAreas has = new HarvestAreas("exemple");
		assertEquals(3, has.getNumberOfHarvestArea());		
	}

}

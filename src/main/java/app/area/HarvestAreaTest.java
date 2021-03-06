package main.java.app.area;

import main.java.app.hiking.Hiking;
import main.java.app.plant.Plant;

import org.junit.Test;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class HarvestAreaTest {

	@Test(expected=java.lang.Exception.class)
	public void testExceptionHarvestAreaIfDisponibilitySupOne() throws Exception {
		new HarvestArea("MySpot",0.0,0.0,AreaSize.SMALL,1.1,new Plant(),new Hiking());
	}
	
	@Test(expected=java.lang.Exception.class)
	public void testExceptionHarvestAreaIfDisponibilityInfZero() throws Exception {
		new HarvestArea("MySpot",0.0,0.0,AreaSize.SMALL,-0.1,new Plant(),new Hiking());
	}
	
	@Test
	public void testUpdateDipsponibilityIfSameSize() throws Exception {
		HarvestArea ha = new HarvestArea();
		ha.setDisponibility(0.8);
		ha.updateDisponibility(0.1, ha.getSize());
		assertEquals(0.8*0.9, ha.getDisponibility().getPercent(),1e-15);	
	}
	
	@Test
	public void testUpdateDipsponibilityIfDifferentSize() throws Exception {
		HarvestArea ha = new HarvestArea();
		ha.updateDisponibility(0.3, AreaSize.LARGE);
		assertEquals(0.7, ha.getDisponibility().getPercent(),1e-15);	
		assertEquals(AreaSize.LARGE, ha.getSize());
	}
	
	@Test
	public void testUpdateDipsponibilityIfSizeNull() throws Exception {
		HarvestArea ha = new HarvestArea();
		ha.updateDisponibility(0.3, AreaSize.NULL);
		assertEquals(0.7, ha.getDisponibility().getPercent(),1e-15);	
		assertEquals(AreaSize.SMALL, ha.getSize());
	}
	
	@Test
	public void testIsHarvestableFalseIfNoDispo() throws Exception {
		
		HarvestArea ha = new HarvestArea();
		ha.setDisponibility(0.3);
		
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd");
		DateTime now = new DateTime();
		DateTime start = now.minusDays(20);
		DateTime end = now.plusDays(20);
		
		Plant plant = new Plant("test",start.toString(dtf),end.toString(dtf));
		ha.setPlant(plant);
		assertFalse(ha.isHarvestable());;
	}
	
	@Test
	public void testIsHarvestableFalseIfPlantNotHarvestable() throws Exception {
		
		HarvestArea ha = new HarvestArea();
		ha.setDisponibility(1);
		
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd");
		DateTime now = new DateTime();
		DateTime start = now.plusDays(20);
		DateTime end = now.plusDays(60);
		
		Plant plant = new Plant("test",start.toString(dtf),end.toString(dtf));
		ha.setPlant(plant);
		assertFalse(ha.isHarvestable());;
	}
	
	@Test
	public void testIsHarvestableTrue() throws Exception {
		
		HarvestArea ha = new HarvestArea();
		ha.setDisponibility(1);
		
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd");
		DateTime now = new DateTime();
		DateTime start = now.minusDays(20);
		DateTime end = now.plusDays(20);
		
		Plant plant = new Plant("test",start.toString(dtf),end.toString(dtf));
		ha.setPlant(plant);
		assertTrue(ha.isHarvestable());;
	}

}

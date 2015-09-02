package main.java.app.plant;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class PlantTest {

	@Test
	public void testReturnTrueIfIsHarvestable() {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd");
		DateTime now = new DateTime();
		DateTime start = now.minusDays(20);
		DateTime end = now.plusDays(20);
		Plant plant = new Plant("test",start.toString(dtf),end.toString(dtf));
		assertTrue(plant.isHarvestable());
	}
	
	@Test
	public void testReturnFalseIfIsNotHarvestable() {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd");
		DateTime now = new DateTime();
		DateTime start = now.plusDays(20);
		DateTime end = now.plusDays(60);
		Plant plant = new Plant("test",start.toString(dtf),end.toString(dtf));
		assertFalse(plant.isHarvestable());
	}

}

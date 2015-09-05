package main.java.app.area;

import main.java.app.hiking.Hiking;

import org.junit.Test;

import static org.junit.Assert.*;

public class HarvestAreaTest {

	@Test(expected=java.lang.Exception.class)
	public void testExceptionHarvestAreaIfDisponibilitySupOne() throws Exception {
		new HarvestArea(0.0,0.0,AreaSize.SMALL,1.1,new Hiking());
	}
	
	@Test(expected=java.lang.Exception.class)
	public void testExceptionHarvestAreaIfDisponibilityInfZero() throws Exception {
		new HarvestArea(0.0,0.0,AreaSize.SMALL,-0.1,new Hiking());
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

}

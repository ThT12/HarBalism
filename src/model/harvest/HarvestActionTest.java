package harvest;

import static org.junit.Assert.*;

import org.junit.Test;

import area.AreaSize;
import area.HarvestArea;

public class HarvestActionTest {

	@Test
	public void testApplyHarvestWithSize() throws Exception {
		HarvestArea ha = new HarvestArea();
		HarvestAction haction = new HarvestAction(ha, 0.2, AreaSize.MEDIUM);
		haction.applyHarvest();
		
		assertEquals(0.8, ha.getDisponibility().getPercent(),1e-15);
		assertEquals(AreaSize.MEDIUM, ha.getSize());
	}
	
	@Test
	public void testApplyHarvestWithoutSize() throws Exception {
		HarvestArea ha = new HarvestArea();
		HarvestAction haction = new HarvestAction(ha, 0.2);
		haction.applyHarvest();
		
		assertEquals(0.8, ha.getDisponibility().getPercent(),1e-15);
		assertEquals(AreaSize.SMALL, ha.getSize());
	}

}

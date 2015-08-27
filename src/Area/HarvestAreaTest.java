package Area;

import org.junit.Test;

public class HarvestAreaTest {

	@Test(expected=java.lang.Exception.class)
	public void testExceptionHarvestAreaIfDisponibilitySupOne() throws Exception {
		new HarvestArea(0.0,0.0,AreaSize.SMALL,1.1);
	}
	
	@Test(expected=java.lang.Exception.class)
	public void testExceptionHarvestAreaIfDisponibilityInfZero() throws Exception {
		new HarvestArea(0.0,0.0,AreaSize.SMALL,-0.1);
	}

}

package main.java.app.maths;

import org.junit.Test;


public class PercentTest {

	@Test(expected=java.lang.Exception.class)
	public void testExceptionPercentSupOne() throws Exception {
		new Percent(1.1);
	}
	
	@Test(expected=java.lang.Exception.class)
	public void testExceptionPercentInfZero() throws Exception {
		new Percent(-0.1);
	}
	
	@Test
	public void testPercentNoException() throws Exception {
		new Percent(0.1);
	}

}

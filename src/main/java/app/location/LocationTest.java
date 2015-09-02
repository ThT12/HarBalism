package main.java.app.location;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	@Test
	public void testSetLocation() {
		double latitude = 30.1;
		double longitude = 39.2;
		Location locExpect = new Location();
		locExpect.setLatitude(latitude);
		locExpect.setLongitude(longitude);
		Location loc = new Location(latitude, longitude);
		assertEquals(locExpect, loc);
	}

}

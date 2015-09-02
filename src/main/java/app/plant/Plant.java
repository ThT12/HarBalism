package main.java.app.plant;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Plant {
	private String name;
	private DateTime startHarvestDate;
	private DateTime endHarvestDate;
	
	public Plant(){
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd");
		this.name = "";
		this.startHarvestDate = dtf.parseDateTime("01/01");
		this.endHarvestDate = dtf.parseDateTime("12/31");
	}
	
	public Plant(String name, String startHarvestDate, String endHarvestDate){
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd");
		this.name = name;
		this.startHarvestDate = dtf.parseDateTime(startHarvestDate);
		this.endHarvestDate = dtf.parseDateTime(endHarvestDate);
	}

	public boolean isHarvestable() {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd");
		DateTime now = new DateTime();
		DateTime nowFormat = dtf.parseDateTime(now.toString(dtf));
		
		Days period1 = Days.daysBetween(this.startHarvestDate,nowFormat);
		Days period2 = Days.daysBetween(this.endHarvestDate,nowFormat);

		if (period1.getDays() > 0 && period2.getDays() < 0) {	
			return true;	
		}
		else {
			return false;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTime getStartHarvestDate() {
		return startHarvestDate;
	}

	public void setStartHarvestDate(DateTime startHarvestDate) {
		this.startHarvestDate = startHarvestDate;
	}

	public DateTime getEndHarvestDate() {
		return endHarvestDate;
	}

	public void setEndHarvestDate(DateTime endHarvestDate) {
		this.endHarvestDate = endHarvestDate;
	}
	

}

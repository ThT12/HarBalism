package main.java.app.area;

public enum AreaSize {
	NULL("No Size Defined",1),
	SMALL("Small",0.8),
	MEDIUM("Medium",0.7),
	LARGE("Large",0.6);
	
	private String name = "";
	private double limitHarvest;
	
	AreaSize(String name, double limiteHarvest){
	    this.name = name;
	    this.limitHarvest = limiteHarvest;
	  }

	  public double getLimitHarvest() {
		return limitHarvest;
	}

	public String toString(){
	    return name;
	  }
}

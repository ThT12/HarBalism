package main.java.app.area;

public enum AreaSize {
	NULL("No Size Defined"),
	SMALL("Small"),
	MEDIUM("Medium"),
	LARGE("Large");
	
	private String name = "";
	
	AreaSize(String name){
	    this.name = name;
	  }

	  public String toString(){
	    return name;
	  }
}

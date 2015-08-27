package area;

public enum AreaSize {
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

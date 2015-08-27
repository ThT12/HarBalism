package maths;

public class Percent {
	
	private double percent;

	
	public Percent(double percent) throws Exception {
		this.setPercent(percent);
	}
	
	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) throws Exception {
		if (percent < 0 || percent > 1){
			throw new Exception("A percent must be between 0 and 1");
		}
		this.percent = percent;
	}
}

package fr.dawan.solid.openclose.bad;

public class Rectangle {
	
	private double width;
	private double legth;
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLegth() {
		return legth;
	}
	public void setLegth(double legth) {
		this.legth = legth;
	}
	public Rectangle(double width, double legth) {
		super();
		this.width = width;
		this.legth = legth;
	}
	
	

}

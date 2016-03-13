package org.javabrains.mike.restfulWebservice.vehicle;

public class Truck {

	private String vin;
	private String color;
	private int miles;
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMiles() {
		return miles;
	}
	public void setMiles(int miles) {
		this.miles = miles;
	}
	@Override
	public String toString() {
		return "Truck [vin=" + vin + ", color=" + color + ", miles=" + miles
				+ "]";
	}
}

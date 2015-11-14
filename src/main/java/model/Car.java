package model;

import org.springframework.hateoas.ResourceSupport;

public class Car extends ResourceSupport {
	
	String plateNumber;
	boolean rented;

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;

	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

}

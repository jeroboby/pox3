package io.robusta.homebook.implementation;

import java.util.List;

public class CityImplementation {
	int zipCode;
	String name;
	List<HomeImplementation> homes;


	public CityImplementation(int zipCode, String name, List<HomeImplementation> homes) {
		this.zipCode = zipCode;
		this.name = name;
		this.homes = homes;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HomeImplementation> getHomes() {
		return homes;
	}

	public void setHomes(List<HomeImplementation> homes) {
		this.homes = homes;
	}

}

package io.robusta.homebook.implementation;

public class CityImplementation {
	int zipCode;
	String name;
	//List<HomeImplementation> homes;


	public CityImplementation(int zipCode, String name) {
		this.zipCode = zipCode;
		this.name = name;
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

/*	public List<HomeImplementation> getHomes() {
		return homes;
	}

	public void setHomes(List<HomeImplementation> homes) {
		this.homes = homes;
	}*/

}

package io.robusta.homebook.implementation;


import java.util.List;

import io.robusta.homebook.domain.City;
import io.robusta.homebook.domain.Home;

public class CityImplementation implements City {
	int zipCode;
	String name;
	List<Home> homes;


	public CityImplementation(int zipCode, String name) {
		this.zipCode = zipCode;
		this.name = name;

	}
	
	public CityImplementation(int zipCode, String name, List<Home> homes) {
		this(zipCode,name);
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


/*	public List<HomeImplementation> getHomes() {

	public List<Home> getHomes() {

		return homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;

	}*/

	
	public void addHomes(Home home) {
		this.homes.add(home);
	}



	@Override
	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}


}

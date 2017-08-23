package io.robusta.homebook.implementation;

public class HomeImplementation {

	String id;
	CityImplementation city;
	int surface;
	int price;
	
	

	public HomeImplementation(String id, String adress, CityImplementation city, int surface, int price) {
		this.id = id;
		this.city = city;
		this.surface = surface;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CityImplementation getCity() {
		return city;
	}

	public void setCity(CityImplementation city) {
		this.city = city;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

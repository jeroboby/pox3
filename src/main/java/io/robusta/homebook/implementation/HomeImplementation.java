package io.robusta.homebook.implementation;

import io.robusta.homebook.domain.Home;

public class HomeImplementation implements Home {

	int id;
	CityImplementation city;
	int surface;
	int price;

	public HomeImplementation(CityImplementation city, int surface, int price) {
		this.city = city;
		this.surface = surface;
		this.price = price;
	}

	public HomeImplementation(int id, CityImplementation city, int surface, int price) {
		this(city, surface, price);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	/*@Override
	public String toString() {
		return "HomeImplementation [id=" + id + ", city=" + city + ", surface=" + surface + ", price=" + price + "]";
	}*/
	

}

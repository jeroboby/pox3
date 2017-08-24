package io.robusta.homebook.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.robusta.homebook.domain.City;
import io.robusta.homebook.implementation.CityImplementation;

public class CityBusinessTest {

	CityBusiness cityConn;
	
	// NOTE : reset DB before running tests.
	
	@Before
	public void setUp() {

		cityConn = new CityBusiness();

	}
	
	@After
	public void after(){
		cityConn.close();
	}

	@Test
	public void testFindAll() {
		assertTrue(cityConn.findAll().size() > 0);
	}

	@Test
	public void testFindByZipCode() {
		assertEquals("CityExample", cityConn.findByZipCode(66666).getName());
	}

	@Test
	public void testAddCity() {
		City city = new CityImplementation(31000, "Toulouse");
		cityConn.addCity(city);

		assertEquals(2, cityConn.findAll().size());
	}

	@Test
	public void testUpdateCity() {
		City city = new CityImplementation(42000, "Saint Etienne");
		cityConn.addCity(city);
		assertEquals("Saint Etienne", cityConn.findByZipCode(42000).getName());
		city = new CityImplementation(42000, "Qui c'est les plus forts évidement c'est les verts");
		cityConn.updateCity(city);
		assertEquals("Qui c'est les plus forts évidement c'est les verts", cityConn.findByZipCode(42000).getName());
	}

	@Test
	public void testDeleteCity() {
		int initSize = cityConn.findAll().size();
		City city = new CityImplementation(01234, "test");
		cityConn.addCity(new CityImplementation(01234, "test"));
		assertEquals(initSize+1, cityConn.findAll().size());
		cityConn.deleteCity(city);
		assertEquals(initSize, cityConn.findAll().size());	
	}

}

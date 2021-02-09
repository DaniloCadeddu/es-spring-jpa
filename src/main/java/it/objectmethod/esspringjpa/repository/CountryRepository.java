package it.objectmethod.esspringjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.objectmethod.esspringjpa.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	public Country findByNameAndContinent(String name, String continent);

	@Query(value = "select c from Country c where c.population > 1000000")
	public List<Country> findPopulatedCountries();
	
	public Country findByCode(String code);

	@Query(value = "SELECT country.Name FROM country INNER JOIN city ON country.Capital = city.ID WHERE city.Population > 1000000;", nativeQuery = true)
	public List<String> findCapitals();

}

package it.objectmethod.esspringjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.objectmethod.esspringjpa.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	public City findByName(String name);

	public City findByNameAndCountryCode(String name, String countryCode);

	@Query(value = "select a.name from City a inner join Country c on a.countryCode = c.code where c.continent='Asia' and a.population > 10000000")
	public List<String> findAsianCities();
}

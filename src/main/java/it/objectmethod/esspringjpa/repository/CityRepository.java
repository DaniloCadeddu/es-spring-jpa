package it.objectmethod.esspringjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.objectmethod.esspringjpa.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	public City findByName(String name);
	public City findByNameAndCountryCode(String name, String countryCode);
}

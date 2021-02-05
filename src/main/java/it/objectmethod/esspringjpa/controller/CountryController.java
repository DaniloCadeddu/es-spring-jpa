package it.objectmethod.esspringjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import it.objectmethod.esspringjpa.entity.Country;
import it.objectmethod.esspringjpa.repository.CountryRepository;

@RestController
public class CountryController {

	@Autowired
	private CountryRepository countryRepo;

	@GetMapping("/{name}/{continent}/find")
	public Country findCountryByNameAndContinent(@PathVariable("name") String name, @PathVariable("continent") String continent) {
		Country country = countryRepo.findByNameAndContinent(name, continent);

		return country;
	}

	@GetMapping("/find-populated-countries")
	public List<Country> findPopulatedCountries() {
		List<Country> countries = countryRepo.findPopulatedCountries();
		
		return countries;
	}
	
	@GetMapping("/find-capitals")
	public List<String> findCapitals() {
		List<String> countries = countryRepo.findCapitals();
		
		return countries;
	}
	
}

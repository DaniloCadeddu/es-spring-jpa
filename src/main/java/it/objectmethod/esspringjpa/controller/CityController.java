package it.objectmethod.esspringjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.objectmethod.esspringjpa.entity.City;
import it.objectmethod.esspringjpa.repository.CityRepository;

@RestController
public class CityController {

	@Autowired
	private CityRepository cityRepo;

	@GetMapping("/{name}/find")
	public City findCityByName(@PathVariable("name") String name) {
		City city = cityRepo.findByName(name);

		return city;
	}

	@GetMapping("/find-by-name-countrycode")
	public City findCityByNameAndCountryCode(@RequestParam("name") String name,
			@RequestParam("countryCode") String countryCode) {
		City city = cityRepo.findByNameAndCountryCode(name, countryCode);
		return city;
	}

	@PostMapping("/city-post")
	public City postCity(@RequestBody City city) {
		cityRepo.save(city);
		return city;
	}

	@GetMapping("/find-asian-cities")
	public List<String> findAsianCities() {
		List<String> asianCities = cityRepo.findAsianCities();
		return asianCities;
	}
}

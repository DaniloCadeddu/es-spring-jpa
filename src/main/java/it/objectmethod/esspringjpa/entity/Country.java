package it.objectmethod.esspringjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	
	@Id
	@Column(name="Code")
	private String code;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Continent")
	private String continent;
	
	@Column(name="Population")
	private Integer population;
	
	@Column(name="SurfaceArea")
	private Float surface;
	
	
	@Column(name="Capital")
	private Long capital;

	public Long getCapital() {
		return capital;
	}

	public void setCapital(Long capital) {
		this.capital = capital;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(Float surface) {
		this.surface = surface;
	}
}

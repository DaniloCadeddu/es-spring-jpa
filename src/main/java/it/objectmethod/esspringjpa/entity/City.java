package it.objectmethod.esspringjpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city")
public class City {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Population")
	private Integer population;

	private String countryCode;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;

	public Country getCountry() {
		return country;
	}
	
	@ManyToMany
	@JoinTable(name = "city_tp", joinColumns = @JoinColumn(name = "id_city", referencedColumnName = "ID")
	, inverseJoinColumns = @JoinColumn(name = "id_trasporti", referencedColumnName = "serviziId"))
	private List<TrasportiPubblici> trasportiPubblici;

	public List<TrasportiPubblici> getTrasportiPubblici() {
		return trasportiPubblici;
	}

	public void setTrasportiPubblici(List<TrasportiPubblici> trasportiPubblici) {
		this.trasportiPubblici = trasportiPubblici;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}

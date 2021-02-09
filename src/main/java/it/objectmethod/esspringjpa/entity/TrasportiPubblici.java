package it.objectmethod.esspringjpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trasportiPubblici")
public class TrasportiPubblici {
	
	@Id
	private Long serviziId;
	private String name;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "city_tp", joinColumns = @JoinColumn(name = "id_trasporti", referencedColumnName = "ServiziId")
	, inverseJoinColumns = @JoinColumn(name = "id_city", referencedColumnName = "ID"))
	private List<City> cities;

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Long getServiziId() {
		return serviziId;
	}

	public void setServiziId(Long serviziId) {
		this.serviziId = serviziId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package com.eya.jeux.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Platforme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlat;
	private String nomPlat;
	private String descriptionPlat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "platforme")
	private List<Jeu> jeux;
	
	
	public Long getIdPlat() {
		return idPlat;
	}
	public void setIdPlat(Long idPlat) {
		this.idPlat = idPlat;
	}
	public String getNomPlat() {
		return nomPlat;
	}
	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}
	public String getDescriptionPlat() {
		return descriptionPlat;
	}
	public void setDescriptionPlat(String descriptionPlat) {
		this.descriptionPlat = descriptionPlat;
	}
	
	public List<Jeu> getJeux() {
		return jeux;
	}
	public void setJeux(List<Jeu> jeux) {
		this.jeux = jeux;
	}
	
	
}

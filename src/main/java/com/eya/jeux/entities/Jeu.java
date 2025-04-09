package com.eya.jeux.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Jeu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJeu;
	private String nomJeu;
	private Double prixJeu;
	private Date dateSortieJeu;

	@ManyToOne
	private Platforme platforme;
	
	

	public Jeu() {
		super();
	}

	public Jeu(String nomJeu, Double prixJeu, Date dateSortieJeu) {
		super();
		this.nomJeu = nomJeu;
		this.prixJeu = prixJeu;
		this.dateSortieJeu = dateSortieJeu;
	}

	public Long getIdJeu() {
		return idJeu;
	}

	public void setIdJeu(Long idJeu) {
		this.idJeu = idJeu;
	}

	public String getNomJeu() {
		return nomJeu;
	}

	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}

	public Double getPrixJeu() {
		return prixJeu;
	}

	public void setPrixJeu(Double prixJeu) {
		this.prixJeu = prixJeu;
	}

	public Date getDateSortieJeu() {
		return dateSortieJeu;
	}

	public void setDateSortieJeu(Date dateSortieJeu) {
		this.dateSortieJeu = dateSortieJeu;
	}

	public Platforme getPlatforme() {
		return platforme;
	}

	public void setPlatforme(Platforme platforme) {
		this.platforme = platforme;
	}
	
	@Override
	public String toString() {
		return "Jeu [idJeu=" + idJeu + ", nomJeu=" + nomJeu + ", prixJeu=" + prixJeu + ", dateSortieJeu="
				+ dateSortieJeu + "]";
	}

}

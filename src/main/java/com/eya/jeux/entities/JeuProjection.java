package com.eya.jeux.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomGame", types = { Jeu.class })
public interface JeuProjection {
	public String getNomJeu();
}

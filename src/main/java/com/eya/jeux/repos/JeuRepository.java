package com.eya.jeux.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eya.jeux.entities.Jeu;

public interface JeuRepository extends JpaRepository<Jeu, Long> {

}

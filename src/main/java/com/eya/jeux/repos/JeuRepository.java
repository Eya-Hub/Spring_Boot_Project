package com.eya.jeux.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eya.jeux.entities.Jeu;
import com.eya.jeux.entities.Platforme;
@RepositoryRestResource(path = "rest")
public interface JeuRepository extends JpaRepository<Jeu, Long> {
	List<Jeu> findByNomJeu(String nom);
	List<Jeu> findByNomJeuContains(String nom);
	
	/*@Query("select j from Jeu j where j.nomJeu like %?1 and j.prixJeu > ?2") 
	List<Jeu> findByNomPrix (String nom, Double prix);*/
	
	@Query("select j from Jeu j where j.nomJeu like %:nom and j.prixJeu > :prix")
	List<Jeu> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select j from Jeu j where j.platforme = ?1") 
	List<Jeu> findByPlatforme (Platforme platforme);
	
	List<Jeu> findByPlatformeIdPlat(Long id);
	
	List<Jeu> findByOrderByNomJeuAsc();
	
	@Query("select j from Jeu j order by j.nomJeu ASC, j.prixJeu DESC")
	List<Jeu> trierJeuxNomsPrix ();
}

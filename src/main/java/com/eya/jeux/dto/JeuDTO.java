package com.eya.jeux.dto;

import java.util.Date;

import com.eya.jeux.entities.Platforme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JeuDTO {
	private Long idJeu;
	private String nomJeu;
	private Double prixJeu;
	private Date dateSortieJeu; 
	private Platforme platforme;
	private String nomPlat;
}

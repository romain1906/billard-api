package com.unipool.billard_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Joueur 1
    @ManyToOne
    @JoinColumn(name = "player_1_id", referencedColumnName = "id")
    private Player player1;

    // Joueur 2
    @ManyToOne
    @JoinColumn(name = "player_2_id", referencedColumnName = "id")
    private Player player2;

    // Gagnant
    @ManyToOne
    @JoinColumn(name = "winner_id", referencedColumnName = "id")
    private Player winner;

    // Créé par
    @ManyToOne
    @JoinColumn(name = "created_by_id", referencedColumnName = "id")
    private Player createdBy;

    // Date du match
    @Column(name = "date_match")
    private String dateMatch;
}

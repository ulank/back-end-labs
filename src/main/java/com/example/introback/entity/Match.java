package com.example.introback.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Ulan on 2/25/2023
 */

@Entity
@Getter
@Setter
@Table(name = "matches", schema = "university")
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "home_team_id", referencedColumnName = "id")
    private Team homeTeam;

    @OneToOne
    @JoinColumn(name = "away_team_id", referencedColumnName = "id")
    private Team awayTeam;


    private int homeTeamGoal;

    private int awayTeamGoal;

}

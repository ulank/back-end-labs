package com.example.introback.dto;

import com.example.introback.entity.Team;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Ulan on 2/25/2023
 */
@Data
public class MatchDto implements Serializable {
    private final Team homeTeam;
    private final Team awayTeam;
    private final int homeTeamGoal;
    private final int awayTeamGoal;
}

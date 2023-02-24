package com.example.introback.model;

import com.example.introback.entity.Team;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Ulan on 2/25/2023
 */

@Data
public class Standing implements Comparable<Standing> {
    private Integer place;
    private Team team;
    private Integer played;
    private Integer won;
    private Integer draw;
    private Integer lost;
    private Integer scored;
    private Integer missed;
    private Integer points;

    public Standing(Team team) {
        this.team = team;
        this.played = 0;
        this.won = 0;
        this.draw = 0;
        this.lost = 0;
        this.scored = 0;
        this.missed = 0;
        this.points = 0;
    }

    @Override
    public int compareTo(Standing o) {
        return o.points.compareTo(this.points);
    }

    public int compareToScored(Standing o) {
        return o.scored.compareTo(this.scored);
    }
}

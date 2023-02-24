package com.example.introback.service;

import com.example.introback.entity.Match;
import com.example.introback.entity.Team;
import com.example.introback.model.Standing;
import com.example.introback.repository.MatchRepository;
import com.example.introback.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Ulan on 2/25/2023
 */
@Service
@RequiredArgsConstructor
public class StandingService {

    private final MatchRepository matchRepository;

    private final TeamRepository teamRepository;

    public void createMatch(Match match) {
        matchRepository.save(match);
    }

    public List<Team> findTeams(){
        return teamRepository.findAll();
    }


    public List<Standing> collectMatches() {

        List<Match> matches = matchRepository.findAll();

        List<Standing> standings = new ArrayList<>();

        matches.forEach(match -> {
            Predicate<Standing> isHomePlayed = standing -> standing.getTeam().equals(match.getHomeTeam());
            Predicate<Standing> isAwayPlayed = standing -> standing.getTeam().equals(match.getAwayTeam());

            Standing home = standings.stream().filter(standing -> standing.getTeam().equals(match.getHomeTeam())).findAny().orElse(new Standing(match.getHomeTeam()));
            Standing away = standings.stream().filter(standing -> standing.getTeam().equals(match.getAwayTeam())).findAny().orElse(new Standing(match.getAwayTeam()));


            home.setPlayed(home.getPlayed() + 1);
            away.setPlayed(away.getPlayed() + 1);

            home.setScored(home.getScored() + match.getHomeTeamGoal());
            home.setMissed(home.getMissed() + match.getAwayTeamGoal());

            away.setScored(away.getScored() + match.getAwayTeamGoal());
            away.setMissed(away.getMissed() + match.getHomeTeamGoal());

            /* Home win */
            if (match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                home.setPoints(home.getPoints() + 3);
                home.setWon(home.getWon() + 1);

                away.setLost(away.getLost() + 1);
                /* Away win */
            } else if (match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                home.setLost(home.getLost() + 1);

                away.setPoints(away.getPoints() + 3);
                away.setWon(away.getWon() + 1);
                /* Draw */
            } else {
                home.setPoints(home.getPoints() + 1);
                home.setDraw(home.getDraw() + 1);
                away.setPoints(away.getPoints() + 1);
                away.setDraw(away.getDraw() + 1);
            }

            if (standings.stream().noneMatch(isHomePlayed) && standings.stream().noneMatch(isAwayPlayed)){
                standings.add(home);
                standings.add(away);
            }

            if (standings.stream().noneMatch(isHomePlayed)) {
                standings.add(home);
            }

            if (standings.stream().noneMatch(isAwayPlayed)) {
                standings.add(away);
            }

        });

        standings.sort(Standing::compareTo);
        standings.sort(Standing::compareToScored);

        int place = 1;

        for (Standing standing : standings) {
            standing.setPlace(place);
            if (standings.size() != place) {
                place++;
            }
        }

        return standings;
    }

}

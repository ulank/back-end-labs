CREATE TABLE university.teams
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name    VARCHAR(255),
    country VARCHAR(255),
    city    VARCHAR(255),
    CONSTRAINT pk_teams PRIMARY KEY (id)
);

insert into university.teams
values (0, 'FC Barcelona', 'Spain', 'Barcelona');

insert into university.teams
values (1, 'Real Madrid', 'Spain', 'Madrid');

insert into university.teams
values (2, 'Liverpool', 'England', 'Liverpool');

insert into university.teams
values (3, 'Arsenal', 'England', 'London');

CREATE TABLE university.matches
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    home_team_id   BIGINT,
    away_team_id   BIGINT,
    home_team_goal INTEGER                                 NOT NULL,
    away_team_goal INTEGER                                 NOT NULL,
    CONSTRAINT pk_matches PRIMARY KEY (id)
);

ALTER TABLE university.matches
    ADD CONSTRAINT FK_MATCHES_ON_AWAY_TEAM FOREIGN KEY (away_team_id) REFERENCES university.teams (id);

ALTER TABLE university.matches
    ADD CONSTRAINT FK_MATCHES_ON_HOME_TEAM FOREIGN KEY (home_team_id) REFERENCES university.teams (id);
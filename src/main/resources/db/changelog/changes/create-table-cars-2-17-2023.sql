CREATE TABLE university.cars
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    car_name   VARCHAR(255)                            NOT NULL,
    car_model  VARCHAR(255)                            NOT NULL,
    car_year   INTEGER                                 NOT NULL,
    car_volume DOUBLE PRECISION                        NOT NULL,
    CONSTRAINT pk_cars PRIMARY KEY (id)
);
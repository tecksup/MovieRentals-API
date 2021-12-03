package com.theater.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "NAME", length = 50)
    @NotNull(message = "Movie must be named")
    private String name;
    @Column(name= "DURATION")
    @NotNull(message = "Movie must have duration")
    private float duration;

    public Movie() {}

    public Movie(long id, String name, float length) {
        this.id = id;
        this.name = name;
        this.duration = length;
    }

    public Movie(String name, float length) {
        this.name = name;
        this.duration = length;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getDuration() {
        return duration;
    }
}

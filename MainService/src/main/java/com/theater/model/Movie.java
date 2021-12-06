package com.theater.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME", nullable = false, length = 50)
    @NotNull(message = "Movie must be named")
    private String name;
    @Column(name= "DURATION")
    @NotNull(message = "Movie must have duration")
    private float duration;
    @Column(name= "RESERVED")
    private boolean reserved;

    public Movie() {}

    public Movie(String name, float length) {
        this.name = name;
        this.duration = length;
    }

    public Movie(String name, float length, boolean reserved) {
        this.name = name;
        this.duration = length;
        this.reserved = reserved;
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

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}

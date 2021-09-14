package com.theater;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float length;

    public Movie() {}

    public Movie(long id, String name, float length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getLength() {
        return length;
    }
}

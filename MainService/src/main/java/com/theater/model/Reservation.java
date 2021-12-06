package com.theater.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "OWNER", nullable = false, length = 50)
    @NotNull(message = "Owner must be given")
    private String owner;
    @Column(name = "RESERVEDMOVIEID", nullable = false)
    private int reservedMovieId;
    @Column(name= "TIMECHECKEDOUT")
    private Date timeCheckedOut;
    @Column(name = "DURATION", nullable = false)
    private float duration;

    public Reservation() {}

    public Reservation(String owner, int reservedMovieId, Date timeCheckedOut, float duration) {
        this.owner = owner;
        this.reservedMovieId = reservedMovieId;
        this.timeCheckedOut = timeCheckedOut;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public int getReservedMovieId() {
        return reservedMovieId;
    }

    public Date getTimeCheckedOut() {
        return timeCheckedOut;
    }

    public float getDuration() {
        return duration;
    }
}

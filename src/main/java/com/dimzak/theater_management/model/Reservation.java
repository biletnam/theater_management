package com.dimzak.theater_management.model;

import java.util.Date;

/**
 * @author Dimitris Zakas
 */
public class Reservation {

    private int reserved_seats;

    private int reservation_id;

    private int movies_id;

    private int theater_id;

    private Date view_time;

    public int getMovies_id() {
        return movies_id;
    }

    public void setMovies_id(int movies_id) {
        this.movies_id = movies_id;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public Date getView_time() {
        return view_time;
    }

    public void setView_time(Date view_time) {
        this.view_time = view_time;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getReserved_seats() {
        return reserved_seats;
    }

    public void setReserved_seats(int reserved_seats) {
        this.reserved_seats = reserved_seats;
    }
}

package com.dimzak.theater_management.model;

import java.util.Date;

public class Projection {

    private int projectionId;

    private String theater;

    private String movie;

    private Date view_time;

    private int max_seats;

    private int reserved_seats;

    public int getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(int projectionId) {
        this.projectionId = projectionId;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Date getView_time() {
        return view_time;
    }

    public void setView_time(Date view_time) {
        this.view_time = view_time;
    }

    public int getMax_seats() {
        return max_seats;
    }

    public void setMax_seats(int max_seats) {
        this.max_seats = max_seats;
    }

    public int getReserved_seats() {
        return reserved_seats;
    }

    public void setReserved_seats(int reserved_seats) {
        this.reserved_seats = reserved_seats;
    }
}

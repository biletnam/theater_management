package com.dimzak.theater_management.controller;

import com.dimzak.theater_management.model.Movie;
import com.dimzak.theater_management.model.Reservation;
import com.dimzak.theater_management.model.Theater;
import com.dimzak.theater_management.service.MovieService;
import com.dimzak.theater_management.service.ReservationService;
import com.dimzak.theater_management.util.DataAccess;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Dimitris Zakas
 */
@RequestScoped
@Named
public class ManagerController {

    @Inject
    @DataAccess
    private MovieService movieService;

    @Inject
    @DataAccess
    private ReservationService reservationService;

    //@Inject
    //@DataAccess
    //private ProjectionService projectionService;

    @Inject
    private transient Logger logger;

    private List<Reservation> reservations;

    private List<Movie> movies;

    private List<Theater> theaters;

    private Movie selectedMovie;

    private Movie newMovie = new Movie();

    private Reservation newReservation = new Reservation();

    private String selectedTitle;

    public void doCreateMovie() {
        logger.info("Creating movie " + newMovie.getTitle()) ;
        movieService.createMovie(newMovie);
    }

    public void doCreateReservation() {
        logger.info("Creating reservation " + newReservation.getTheater_id() + " " + newReservation.getMovies_id() + " " + newReservation.getView_time());
        reservationService.reserveTheaterForMovie(newReservation);
    }

    public void doDeleteMovies() {
        logger.info("Deleting movie " + selectedMovie.getTitle() + " " + selectedMovie.getMovies_id());
        List<Movie> toBeDeleted = new ArrayList<>();
        toBeDeleted.add(selectedMovie);
        movieService.deleteMovies(toBeDeleted);
    }

    @PostConstruct
    public void init() {
        movies = movieService.getAllMovies();
        selectedMovie = movies.get(0);
        reservations = reservationService.getAllReservations();
        theaters = reservationService.getAllTheaters();
    }

    public void loadMovie() {
        logger.info("Loading Movie: " + selectedTitle);
        selectedMovie = movieService.getMovieByTitle(selectedTitle);
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public Movie getNewMovie() {
        return newMovie;
    }

    public void setNewMovie(Movie newMovie) {
        this.newMovie = newMovie;
    }

    public String getSelectedTitle() {
        return selectedTitle;
    }

    public void setSelectedTitle(String selectedTitle) {
        this.selectedTitle = selectedTitle;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Reservation getNewReservation() {
        return newReservation;
    }

    public void setNewReservation(Reservation newReservation) {
        this.newReservation = newReservation;
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }
}

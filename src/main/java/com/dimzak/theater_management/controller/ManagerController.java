package com.dimzak.theater_management.controller;

import com.dimzak.theater_management.model.Movie;
import com.dimzak.theater_management.service.MovieService;
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

    //@Inject
    //@DataAccess
    //private ProjectionService projectionService;

    @Inject
    private transient Logger logger;

    private List<Movie> movies;

    private Movie selectedMovie;

    private Movie newMovie = new Movie();

    private String selectedTitle;

    public void doCreateMovie() {
        logger.info("Creating movie " + newMovie.getTitle()) ;
        movieService.createMovie(newMovie);
    }

    public void doDeleteMovies() {
        logger.info("Deleting movie " + selectedMovie.getTitle() + " " + selectedMovie.getMovies_id());
        List<Movie> toBeDeleted = new ArrayList<>();
        toBeDeleted.add(selectedMovie);
        movieService.deleteMovies(toBeDeleted);
    }

    @PostConstruct
    public void init() {
        movies = this.movieService.getAllMovies();
        selectedMovie = movies.get(0);
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
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
}

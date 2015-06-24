package com.dimzak.theater_management.service;

import com.dimzak.theater_management.model.Movie;

import java.util.List;

/**
 * @author Dimitris Zakas
 */
public interface MovieService {

    boolean createMovie(Movie movie);

    boolean deleteMovies(List<Movie> movie);

    List<Movie> getAllMovies();
}

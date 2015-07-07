package com.dimzak.theater_management.service;

import com.dimzak.theater_management.model.Movie;
import com.dimzak.theater_management.util.DataAccess;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitris Zakas
 */
@ApplicationScoped
@DataAccess
public class MovieServiceImpl  implements MovieService {


    @Resource(lookup = "java:jboss/datasources/theater_managementDS")
    private DataSource dataSource;



    @Override
    public boolean createMovie(Movie movie) {
        Boolean result = false;

        try (Connection connection = dataSource.getConnection()) {
            String sql = "insert into movies values (null, \"" + movie.getTitle() + "\", \"" + movie.getCategory() + "\", \"" + movie.getDescription() + "\");";
            System.out.println(sql);
            connection.createStatement().executeUpdate(sql);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteMovies(List<Movie> movies) {
        Boolean result = false;

        try (Connection connection = dataSource.getConnection()) {
            for (Movie movie: movies) {
                String sql = "delete from movies where title = \"" + movie.getTitle() + "\";";
                System.out.println(sql);
                connection.createStatement().executeUpdate(sql);

            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {

            String sql = "select * from movies ;";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovies_id(rs.getInt("movies_id"));
                movie.setTitle(rs.getString("title"));
                movie.setCategory(rs.getString("category"));
                movie.setDescription(rs.getString("description"));
                movieList.add(movie);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return movieList;
    }

    @Override
    public Movie getMovieByTitle(String title) {
        //ResultSet rs  = runQuery("select * from user where username = " + "\"" + username + "\"" + ";");

        Movie movie = new Movie();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "select * from movies where title = " + "\"" + title + "\"" + ";";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                movie.setMovies_id(rs.getInt("movies_id"));
                movie.setTitle(rs.getString("title"));
                movie.setCategory(rs.getString("category"));
                movie.setDescription(rs.getString("description"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }
}

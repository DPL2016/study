package com.kaishengit.service;

import com.kaishengit.dao.MovieDAO;
import com.kaishengit.entity.Movie;

import java.util.List;

public class MovieService {
    private MovieDAO dao = new MovieDAO();
    public List<Movie> findAllMovie(){
        List<Movie>movieList = dao.findAllMovies();
        return movieList;
    }
}

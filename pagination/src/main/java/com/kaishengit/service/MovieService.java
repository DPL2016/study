package com.kaishengit.service;

import com.kaishengit.dao.MovieDAO;
import com.kaishengit.entity.Movie;
import com.kaishengit.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MovieService {
    private Logger logger = LoggerFactory.getLogger(MovieService.class);
    private MovieDAO dao = new MovieDAO();
    public List<Movie> findAllMovie(){
        List<Movie>movieList = dao.findAllMovies();
        return movieList;
    }

    public Page<Movie> findMovieByPageNo(int pageNo) {
        int totalSize = dao.count().intValue();
        logger.debug("totalSize:",totalSize);
        Page<Movie> page = new Page<>(pageNo,10,totalSize);
        List<Movie>movieList = dao.findMoviesByPageNo(page.getStart(),10);
        logger.debug("movielist:{}",movieList);
        page.setItems(movieList);
        return page;
    }

}

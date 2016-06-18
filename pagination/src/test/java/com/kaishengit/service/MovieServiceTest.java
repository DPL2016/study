package com.kaishengit.service;

import com.kaishengit.dao.MovieDAO;
import com.kaishengit.entity.Movie;
import com.kaishengit.util.Page;
import org.junit.Assert;
import org.junit.Test;

public class MovieServiceTest {
    @Test
    public void findByPageNo(){
        MovieService movieService = new MovieService();
        Page<Movie> page = movieService.findMovieByPageNo(2);
        Assert.assertNotNull(page);
    }
    @Test
    public void countTest(){
        MovieDAO dao = new MovieDAO();
        Long a = dao.count();
        System.out.println(a);
        Assert.assertNotNull(a);
    }

}

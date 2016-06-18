package com.kaishengit.test;

import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MovieTest {
    @Test
    public void movieServiceTest(){
        MovieService movieService = new MovieService();
        List<Movie> movies = movieService.findAllMovie();
        Assert.assertNotNull(movies);
    }
}

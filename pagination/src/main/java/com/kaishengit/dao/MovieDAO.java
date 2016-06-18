package com.kaishengit.dao;

import com.kaishengit.entity.Movie;
import com.kaishengit.util.DbHelp;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class MovieDAO {
    public List<Movie> findAllMovies() {
        String sql = "select * from movie";
        return DbHelp.query(sql,new BeanListHandler<>(Movie.class));
    }
}

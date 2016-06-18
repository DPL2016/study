package com.kaishengit.web;

import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService movieService = new MovieService();
        List<Movie>lists =movieService.findAllMovie();
        req.setAttribute("list",lists);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
    }
}

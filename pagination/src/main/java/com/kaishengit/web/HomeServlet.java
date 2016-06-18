package com.kaishengit.web;

import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieService;
import com.kaishengit.util.Page;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(HomeServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService movieService = new MovieService();
        String pageNo = req.getParameter("p");
        int p = 1;
        if (StringUtils.isNumeric(pageNo)){
            p = Integer.parseInt(pageNo);
        }
        logger.debug("p:{}",p);
        Page<Movie> page =  movieService.findMovieByPageNo(p);
        logger.debug("page:{}",page);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
    }
}

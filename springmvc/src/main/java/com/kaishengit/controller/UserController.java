package com.kaishengit.controller;

import com.kaishengit.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("userName","Spring");
        logger.debug("{}","list");
        return "/users/list";
    }

//    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
//    private String showUser(@PathVariable Integer id){
//        logger.debug("ID:{}",id);
//        return "/users/show";
//    }

    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    public ModelAndView showOne(@PathVariable Integer id,
                                @RequestHeader("User-Agent") String userAgent,
                                @CookieValue("JSESSIONID") String JSESSIONID,
                                HttpSession httpSession
    ){

        logger.debug("ID:{},JSESSIONID:{}",id,JSESSIONID);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/users/show");
        modelAndView.addObject("JSESSIONID",JSESSIONID);
        return modelAndView;
    }

    @RequestMapping(value = "/{userid:\\d+}/photo/{photoid:\\d+}")
    public String showPhoto(@PathVariable Integer userid,@PathVariable Integer photoid){

        logger.debug("userId:{},photoId:{}",userid,photoid);
        return "/users/photo";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newUser(){
        logger.debug("new User");
        return "/users/new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveUser(User user){
        logger.debug("name:{},password:{},age:{}",user.getName(),user.getPassword(),user.getAge());
        return "redirect:/users";
    }

    @RequestMapping(value = "/{id}.json",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    /*public String check(@PathVariable Integer id){
        logger.debug("id:{}",id);
        return "success";
    }*/
    public User showUserJson(){
        User user = new User();
        user.setName("小明");
        user.setPassword("123456");
        user.setAge(21);
        return user;
    }

    @RequestMapping(value = "/native")
    public String nativeHttpServlet(HttpServletRequest req, HttpServletResponse resp, HttpSession session){
        ServletContext context = session.getServletContext();
        session.setAttribute("name","Tom");
        return "/users/native";
    }

   



}

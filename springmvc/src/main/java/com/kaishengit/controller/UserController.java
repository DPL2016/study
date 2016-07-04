package com.kaishengit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String list(){
        logger.debug("{}","list");
        return "/users/list";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    private String showUser(@PathVariable Integer id){
        logger.debug("ID:{}",id);
        return "/users/show";
    }

    @RequestMapping(value = "/{userid}/photo/{photoid}")
    public String showPhoto(@PathVariable Integer userid,@PathVariable Integer photoid){

        logger.debug("userId:{},photoId:{}",userid,photoid);
        return "/users/photo";
    }
}

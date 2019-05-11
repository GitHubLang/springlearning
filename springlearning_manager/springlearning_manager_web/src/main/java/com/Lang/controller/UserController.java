package com.Lang.controller;

import com.Lang.pojo.User;
import com.Lang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user/{userName}")
    @ResponseBody
    public User getUerByName(@PathVariable String userName)
    {
      User user= userService.getUserByName(userName);
      return user;
    }

}

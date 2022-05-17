package com.donghu.controller;


import com.donghu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public ModelAndView selectAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_list");
        modelAndView.addObject("ulist",userService.selectAll());
        return modelAndView;
    }

}

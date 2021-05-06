/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.controller;

import com.ivan.ols.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ivans
 */
@Controller
public class ProductController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping("/customer/product")
    public ModelAndView showProduct(ModelAndView modelAndView) {
        try {
            String userName = userService.getUserByEmailId(SecurityContextHolder.getContext().getAuthentication().getName()).getName();
            modelAndView.addObject("name", userName);
            modelAndView.setViewName("producto");
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            modelAndView.addObject("message", "User name not found!");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
    
}

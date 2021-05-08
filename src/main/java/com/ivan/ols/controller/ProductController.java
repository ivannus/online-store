/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.controller;

import com.ivan.ols.entity.ProductEntity;
import com.ivan.ols.service.ProductService;
import com.ivan.ols.service.UserService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ivans
 */
@Controller
public class ProductController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    ProductService productService;
    
    @RequestMapping("/customer/product")
    //@RequestMapping(value = "/customer/product", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showProduct(ModelAndView modelAndView, @RequestParam("producto") String category) /*throws Exception*/ {
        
        try {
            String userName = userService.getUserByEmailId(SecurityContextHolder.getContext().getAuthentication().getName()).getName();
            Iterable<ProductEntity> showProduct = productService.getProductByCategory(category);
            modelAndView.addObject("name", userName);
            modelAndView.addObject("products", showProduct);
            modelAndView.setViewName("producto");
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            modelAndView.addObject("message", "User name not found!");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
    
}

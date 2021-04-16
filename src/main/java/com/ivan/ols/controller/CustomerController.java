/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.controller;

import com.ivan.ols.common.GenericService;
import com.ivan.ols.common.GenericServiceImpl;
import com.ivan.ols.dto.UserDTO;
//import com.ivan.ols.dto.UserGenericDTO;
import com.ivan.ols.entity.Customer;
import com.ivan.ols.entity.UserEntity;
//import com.ivan.ols.entity.User;
import com.ivan.ols.repository.CustomerRepository;
import com.ivan.ols.repository.RoleRepository;
import com.ivan.ols.repository.UserRepository;
import com.ivan.ols.service.CustomerService;
import com.ivan.ols.service.UserService;
import com.ivan.ols.service.UserServiceImpl;
//import com.ivan.ols.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ivans
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    //private CustomerService customerService;
    //private CustomerRepository customerRepository;
    //private UserServiceImpl userService;
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("SUCCESSFUL LOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOGGGGGGGGGGGGGGGGGGGGIIIIIIIIIIIIIIIINNNNNNNNNNNNNN");
        return "redirect:/";
    }

    @RequestMapping("/account")
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping("/new/account")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String register(UserEntity user) throws Exception {
        System.out.println("#######################################################################################");
        //userDTO.getDetailsUserDTO();
        //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        /*Customer customer = userDTO.createUserCustomer();
        customer.getDetailsUser();*/
        //userRepository.save(user);
        userService.createUser(user);

        return "redirect:/";
    }

    /*@RequestMapping("/new/account")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDTO", new UserGenericDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(UserGenericDTO userDTO) {
        System.out.println("#######################################################################################");
        userDTO.getDetailsUserDTO();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Customer customer = userDTO.createUserCustomer();
        customer.getDetailsUser();
        customerRepository.save(customer);
        
        return "redirect:/";
    }*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.controller;

import com.ivan.ols.entity.ConfirmationToken;
import com.ivan.ols.entity.UserEntity;
import com.ivan.ols.repository.ConfirmationTokenRepository;
import com.ivan.ols.repository.UserRepository;
import com.ivan.ols.service.EmailSenderService;
import com.ivan.ols.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ivans
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    UserService userService;
    
    @RequestMapping("/account")
    public ModelAndView showLoginForm(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    //@RequestMapping("/index")
    @GetMapping("/index")
    public ModelAndView index(ModelAndView modelAndView) {
        try {
            //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            //String user = auth.getName(); //get logged in username
            String userName = userService.getUserByEmailId(SecurityContextHolder.getContext().getAuthentication().getName()).getName();
            modelAndView.addObject("name", userName);
            modelAndView.setViewName("index");
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            modelAndView.addObject("message", "User name not found!");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    @RequestMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "signup";
    }

    @PostMapping("/create/account")
    public ModelAndView createAccount(ModelAndView modelAndView, UserEntity user) /*throws Exception*/ {
        System.out.println("#######################################################################################");

        userService.createUser(modelAndView, user);
        ConfirmationToken confirmationToken = new ConfirmationToken(user);

        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmailId());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("JITech@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8880/confirm-account?token=" + confirmationToken.getConfirmationToken());
                //+ "https://isc-java.herokuapp.com/confirm-account?token=" + confirmationToken.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);

        modelAndView.addObject("email", user.getEmailId());

        modelAndView.setViewName("successfulRegisteration");

        return modelAndView;
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) throws Exception {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            UserEntity user = userService.getTokenUser(token);
            user.setEnabled(true);
            userRepository.save(user);
            modelAndView.setViewName("accountVerified");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ConfirmationTokenRepository getConfirmationTokenRepository() {
        return confirmationTokenRepository;
    }

    public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public EmailSenderService getEmailSenderService() {
        return emailSenderService;
    }

    public void setEmailSenderService(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

}

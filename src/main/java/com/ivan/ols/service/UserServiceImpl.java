/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.service;

import com.ivan.ols.dto.ChangePasswordForm;
import com.ivan.ols.entity.ConfirmationToken;
import com.ivan.ols.entity.UserEntity;
import com.ivan.ols.repository.ConfirmationTokenRepository;
import com.ivan.ols.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ivans
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /*@Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;*/

    BCryptPasswordEncoder bCryptPasswordEncoder;

    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(15);
        //El numero 4 representa que tan fuerte quieres la encriptacion.
        //Se puede en un rango entre 4 y 31. 
        //Si no pones un numero el programa utilizara uno aleatoriamente cada vez
        //que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
        return bCryptPasswordEncoder;
    }

    private boolean checkUsernameAvailable(ModelAndView modelAndView, UserEntity user) {
        UserEntity userFound = userRepository.findByEmailIdIgnoreCase(user.getEmailId());
        if (userFound != null) {
            modelAndView.addObject("message", "This email already exists!");
            modelAndView.setViewName("error");
        }
        return true;
    }

    private boolean checkPasswordValid(ModelAndView modelAndView, UserEntity user) {
        if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
            //throw new Exception("Confirm Password es obligatorio");
            modelAndView.addObject("message", "Confirm Password es obligatorio");
            modelAndView.setViewName("error");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            //throw new Exception("Password y Confirm Password no son iguales");
            modelAndView.addObject("message", "Password y Confirm Password no son iguales");
            modelAndView.setViewName("error");
        }
        return true;
    }

    @Override
    public UserEntity createUser(ModelAndView modelAndView, UserEntity user) {
        if (checkUsernameAvailable(modelAndView, user) && checkPasswordValid(modelAndView, user)) {
            String encodePassword = passwordEncoder().encode(user.getPassword());
            user.setPassword(encodePassword);
            user = userRepository.save(user);
        }
        return user;
    }
    
    @Override
    public UserEntity getTokenUser(ConfirmationToken token) {
        UserEntity user = userRepository.findByEmailIdIgnoreCase(token.getUser().getEmailId());
        return user;
    }

    @Override
    public Iterable<UserEntity> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserEntity getUserById(Long id) throws Exception {
        Optional<UserEntity> userOption = userRepository.findById(id);
        UserEntity user = userOption.get();
        return user;
    }

    @Override
    public UserEntity getUserByEmailId(String emailId) throws Exception {
        return userRepository.findByEmailIdIgnoreCase(emailId);
    }

    @Override
    public UserEntity updateUser(UserEntity user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserEntity changePassword(ChangePasswordForm form) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

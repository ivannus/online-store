/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.service;

import com.ivan.ols.dto.ChangePasswordForm;
import com.ivan.ols.entity.ConfirmationToken;
import com.ivan.ols.entity.UserEntity;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ivans
 */
public interface UserService {

    public UserEntity createUser(ModelAndView modelAndView, UserEntity user);
    
    public Iterable<UserEntity> getAllUsers();

    public UserEntity getUserById(Long id) throws Exception;
    
    public UserEntity getUserByEmailId(String emailId) throws Exception;
    
    public UserEntity getTokenUser(ConfirmationToken token) throws Exception;

    public UserEntity updateUser(UserEntity user) throws Exception;

    public void deleteUser(Long id) throws Exception;

    public UserEntity changePassword(ChangePasswordForm form) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.service;

import com.ivan.ols.dto.ChangePasswordForm;
import com.ivan.ols.entity.UserEntity;
import com.ivan.ols.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivans
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;
    
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //Crea el encriptador de contraseñas	
    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(15);
        //El numero 4 representa que tan fuerte quieres la encriptacion.
        //Se puede en un rango entre 4 y 31. 
        //Si no pones un numero el programa utilizara uno aleatoriamente cada vez
        //que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
        return bCryptPasswordEncoder;
    }

    @Override
    public Iterable<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    private boolean checkUsernameAvailable(UserEntity user) throws Exception {
        Optional<UserEntity> userFound = repository.findByUsername(user.getEmail());
        if (userFound.isPresent()) {
            throw new Exception("Username no disponible");
        }
        return true;
    }

    private boolean checkPasswordValid(UserEntity user) throws Exception {
        if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
            throw new Exception("Confirm Password es obligatorio");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new Exception("Password y Confirm Password no son iguales");
        }
        return true;
    }

    @Override
    public UserEntity createUser(UserEntity user) throws Exception {
        if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
            String encodePassword = passwordEncoder().encode(user.getPassword());
            user.setPassword(encodePassword);
            user = repository.save(user);
        }
        return user;
    }

    @Override
    public UserEntity getUserById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("El usuario no existe."));
    }

    @Override
    public UserEntity updateUser(UserEntity fromUser) throws Exception {
        UserEntity toUser = getUserById(fromUser.getId());
        mapUser(fromUser, toUser);
        return repository.save(toUser);
    }

    /**
     * Map everythin but the password.
     *
     * @param from
     * @param to
     */
    protected void mapUser(UserEntity from, UserEntity to) {
        to.setEmail(from.getEmail());
        to.setName(from.getName());
        to.setLastName(from.getLastName());
        to.setMotherLastName(from.getMotherLastName());
        to.setRoles(from.getRoles());
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteUser(Long id) throws Exception {
        UserEntity user = getUserById(id);
        repository.delete(user);
    }

    @Override
    public UserEntity changePassword(ChangePasswordForm form) throws Exception {
        UserEntity user = getUserById(form.getId());

        if (!isLoggedUserADMIN() && !user.getPassword().equals(form.getCurrentPassword())) {
            throw new Exception("Current Password invalido.");
        }

        if (user.getPassword().equals(form.getNewPassword())) {
            throw new Exception("Nuevo debe ser diferente al password actual.");
        }

        if (!form.getNewPassword().equals(form.getConfirmPassword())) {
            throw new Exception("Nuevo Password y Current Password no coinciden.");
        }
        
        String encodePassword = passwordEncoder().encode(form.getNewPassword());
        user.setPassword(encodePassword);
        return repository.save(user);
    }

    private boolean isLoggedUserADMIN() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails loggedUser = null;
        if (principal instanceof UserDetails) {
            loggedUser = (UserDetails) principal;

            loggedUser.getAuthorities().stream()
                    .filter(x -> "ADMIN".equals(x.getAuthority()))
                    .findFirst().orElse(null); //loggedUser = null;
        }
        return loggedUser != null ? true : false;
    }

}

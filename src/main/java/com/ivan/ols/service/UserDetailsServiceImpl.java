/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.service;

import com.ivan.ols.entity.RoleEntity;
import com.ivan.ols.entity.UserEntity;
import com.ivan.ols.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ivans
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //Buscar el usuario con el repositorio y si no existe lanzar una exepcion
        UserEntity appUser = userRepository.findByUsername(email).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

        Set<GrantedAuthority> grantList = new HashSet<>();
        
        for(RoleEntity role : appUser.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
            grantList.add(grantedAuthority);
        }
        UserDetails user = (UserDetails) new User(email, appUser.getPassword(), grantList);

        return user;
        //Mapear nuestra lista de Authority con la de spring security 
        /*List grantList = new ArrayList();
        for (Authority authority : appUser.getAuthority()) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
        }

        //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        UserDetails user = (UserDetails) new User(appUser.getEmail(), appUser.getPassword(), grantList);
        return user;*/
    }
}

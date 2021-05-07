/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.security;

import com.ivan.ols.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ivans
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    
    BCryptPasswordEncoder bCryptPasswordEncoder;

    String[] resources = new String[]{
        //"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
        "/include/**", "/css/**", "/jitech/**", "/icons/**", "/img/**", "/js/**", "/layer/**"
    };

    String[] userEndPoints = new String[]{
        //"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
        //"/", "/customer/new/account", "/customer/register"
        "/", "/signup", "/create/account", "/confirm-account"
    };
    
    String[] userCustomerEndPoints = new String[]{
        "/customer/product", "/profile"
    };

    /*@Autowired
    private DataSource dataSource;*/

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(userEndPoints).permitAll()
                .antMatchers(userCustomerEndPoints).hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/account").permitAll()
                //.usernameParameter("emailId")
                //.passwordParameter("password")
                .defaultSuccessUrl("/index", true)
                //.failureUrl("/login?error=true")
                //.failureUrl("/login?error")
                .usernameParameter("emailId")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");

    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(resources);
    }

    //Crea el encriptador de contraseñas	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(15);
//El numero 4 representa que tan fuerte quieres la encriptacion.
//Se puede en un rango entre 4 y 31. 
//Si no pones un numero el programa utilizara uno aleatoriamente cada vez
//que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
        return bCryptPasswordEncoder;
    }

    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}

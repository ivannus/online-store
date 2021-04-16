/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

/**
 *
 * @author ivans
 */
@Embeddable
public class Credential implements Serializable {
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(nullable = false)
    private String password;

    public Credential() {
    }

    public Credential(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void getDetailsCredential(){
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }
    
}

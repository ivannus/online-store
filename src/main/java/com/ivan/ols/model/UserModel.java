/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author ivans
 */
@MappedSuperclass
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String name;
    @Column(nullable = false)
    @NotBlank
    private String lastName;
    @Column(nullable = false)
    @NotBlank
    private String motherLastName;
    @Column(nullable = false)
    @NotBlank
    private String dateBirth;
    @Column(nullable = false)
    @NotBlank
    private String gender;
    @Column(nullable = false, unique = true)
    @NotBlank
    private String phoneNumber;
    @Column(nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String password;

    public UserModel() {
    }

    public UserModel(Long id, String name, String lastName, String motherLastName, String dateBirth, String gender, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.motherLastName = motherLastName;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    
    
    
    public void getDetailsUser(){
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + name);
        System.out.println("Apellido Paterno: " + lastName);
        System.out.println("Apellido Materno: " + motherLastName);
        System.out.println("Fecha Nacimiento: " + dateBirth);
        System.out.println("Genero: " + gender);
        System.out.println("Numero Telefono: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Contraseña: " + password);
    }
    
}

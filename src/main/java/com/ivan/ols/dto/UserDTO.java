/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.dto;

/**
 *
 * @author ivans
 */
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String motherLastName;
    private String dateBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String lastName, String motherLastName, String dateBirth, String gender, String phoneNumber, String email, String password) {
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
    
    
    
    public void getDetailsUserDTO(){
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ivans
 */
@Embeddable
public class Address implements Serializable {
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String streetNumber;
    @Column(nullable = true)
    private String apartmentNumber;
    @Column(nullable = false)
    private String locality;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String zip;

    public Address() {
    }

    public Address(String street, String streetNumber, String apartmentNumber, String locality, String city, String country, String zip) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.locality = locality;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String state) {
        this.country = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public void getDetailsAddress(){
        System.out.println("Street: " + street);
        System.out.println("Street Number: " + streetNumber);
        System.out.println("Apartment Number: " + apartmentNumber);
        System.out.println("Locality: " + locality);
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
        System.out.println("Zip: " + zip);
    }
}

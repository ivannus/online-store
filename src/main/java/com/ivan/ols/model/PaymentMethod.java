/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ivans
 */
@Embeddable
public class PaymentMethod {
    //@Column(nullable = false)
    private int idPaymentMethod;
    //@Column(nullable = false)
    private String type;
    //@Column(nullable = false)
    private String valueType;
    //@Column(nullable = false)
    private boolean active;

    public PaymentMethod() {
    }

    public PaymentMethod(int idPaymentMethod, String type, String valueType, boolean active) {
        this.idPaymentMethod = idPaymentMethod;
        this.type = type;
        this.valueType = valueType;
        this.active = active;
    }

    public int getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(int idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public void getDetailsPaymentMethod(){
        System.out.println("Id Payment Method: " + idPaymentMethod);
        System.out.println("Name: " + type);
        System.out.println("Value type: " + valueType);
        System.out.println("Is Active: " + active);
    }
}
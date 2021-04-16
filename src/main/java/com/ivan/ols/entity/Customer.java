/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.entity;

import com.ivan.ols.entity.resource.UserRoleEnum;
import com.ivan.ols.model.PaymentMethod;
//import com.ivan.ols.model.User;
import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 *
 * @author ivans
 */
//@Entity
public class Customer /*extends User*/ {
    
    /*private final UserRoleEnum userRole = UserRoleEnum.CUSTOMER_ROLE;
    @Embedded
    private PaymentMethod paymentMethod;

    public Customer() {
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    @Override
    public void getDetailsUser(){
        System.out.println("User Role: -----> " + userRole.getNumRole());
        super.getDetailsUser();
        paymentMethod.getDetailsPaymentMethod();
    }*/
}

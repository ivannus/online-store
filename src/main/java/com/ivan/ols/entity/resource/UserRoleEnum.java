/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.entity.resource;

/**
 *
 * @author ivans
 */
public enum UserRoleEnum {
ADMINISTRATOR_ROLE(0), CUSTOMER_ROLE(1);
    
    private final int numRole;
    
    private UserRoleEnum(int numRole){
        this.numRole = numRole;
    }

    public int getNumRole() {
        return numRole;
    }
    
    public void getDetailsRoleUser(){
        System.out.println("Role user: ------> " + getNumRole());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.service;

import com.ivan.ols.entity.ConfirmationToken;

/**
 *
 * @author ivans
 */
public interface ConfirmationTokenService {
    
    public ConfirmationToken createToken(ConfirmationToken token);
    
    public ConfirmationToken findByConfirmationToken(String confirmationToken);
    
}

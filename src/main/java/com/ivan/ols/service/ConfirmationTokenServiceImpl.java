/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.service;

import com.ivan.ols.entity.ConfirmationToken;
import com.ivan.ols.repository.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivans
 */
@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
    
    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public ConfirmationToken createToken(ConfirmationToken confirmationToken) {
        return confirmationTokenRepository.save(confirmationToken);
    }

    @Override
    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
        return confirmationTokenRepository.findByConfirmationToken(confirmationToken);
    }
    
}

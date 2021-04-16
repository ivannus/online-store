/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.controller;

import com.ivan.ols.common.GenericService;
//import com.ivan.ols.dto.UserGenericDTO;
import com.ivan.ols.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ivans
 */
@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    /*private GenericService genericService;

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody UserGenericDTO userDTO) {
        System.out.println("#######################################################################################");
        userDTO.getDetailsUserDTO();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Customer customer = userDTO.createUserCustomer();
        customer.getDetailsUser();
        genericService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }*/
    
}

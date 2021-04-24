/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.controller;

//import com.ivan.ols.dto.UserGenericDTO;
import com.ivan.ols.entity.Administrator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ivans
 */
@RestController
@RequestMapping("/admin")
public class AdministratorController {
    
    /*private GenericService genericService;
    
    @PostMapping("/register")
    public String save(@RequestBody UserGenericDTO userDTO) {
        System.out.println("#######################################################################################");
        userDTO.getDetailsUserDTO();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Administrator admin = userDTO.createUserAdmin();
        admin.getDetailsUser();
        genericService.save(admin);
        return "redirect:/";
    }*/

}

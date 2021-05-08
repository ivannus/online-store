/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.entity;

import com.ivan.ols.model.ProductModel;
import javax.persistence.Entity;

/**
 *
 * @author ivans
 */
@Entity(name = "product")
public class ProductEntity extends ProductModel {

    public ProductEntity() {
    }

    public ProductEntity(Long id, String category, String brand, String description, String price, String img_url) {
        super(id, category, brand, description, price, img_url);
    }
    
    @Override
    public void getDetailsProduct() {
        getDetailsProduct();
    }
}

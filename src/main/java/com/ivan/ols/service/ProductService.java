/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.service;

import com.ivan.ols.entity.ProductEntity;

/**
 *
 * @author ivans
 */
public interface ProductService {
    public ProductEntity createProduct(ProductEntity product);
    
    public Iterable<ProductEntity> getAllProducts();

    public ProductEntity getProductById(Long id) throws Exception;
    
    public Iterable<ProductEntity> getProductByCategory(String category) throws Exception;
    
    public ProductEntity getProductByBrandId(String brandId) throws Exception;

    public ProductEntity updateProduct(ProductEntity product) throws Exception;

    public void deleteProduct(Long id) throws Exception;
    
}

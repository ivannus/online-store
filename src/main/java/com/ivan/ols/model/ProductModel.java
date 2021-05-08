/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author ivans
 */
@MappedSuperclass
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id",nullable = false)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String category;
    @Column(nullable = false)
    @NotBlank
    private String brand;
    @Column(nullable = false)
    @NotBlank
    private String description;
    @Column(nullable = false)
    @NotBlank
    private String price;
    @Column(nullable = false)
    @NotBlank
    private String img_url;

    public ProductModel() {
    }

    public ProductModel(Long id, String category, String brand, String description, String price, String img_url) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.img_url = img_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
    
    public void getDetailsProduct(){
        System.out.println("Id: " + id);
        System.out.println("Categoria: " + category);
        System.out.println("Marca: " + brand);
        System.out.println("Descripcion: " + description);
        System.out.println("Precio: " + price);
        System.out.println("IMG URL: " + img_url);
    }
}

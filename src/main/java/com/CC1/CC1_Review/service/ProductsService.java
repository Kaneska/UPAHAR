package com.CC1.CC1_Review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CC1.CC1_Review.Repository.ProductsRepository;
import com.CC1.CC1_Review.model.Products;

@Service
public class ProductsService {

    @Autowired

    public ProductsRepository pRepository;

    public List<Products> geList(String productName){
        return pRepository.findByProductName(productName);
    }

    public Products SaveProduct(Products products) {
        return pRepository.save(products);
    }

    public Products getUser(int id) {
        return pRepository.findById(id).orElse(null);

    }

    public List<Products> getp() {
        return pRepository.findAll();
    }

    public void deletePro(int id)
    {
        pRepository.deleteById(id);
    }

    }


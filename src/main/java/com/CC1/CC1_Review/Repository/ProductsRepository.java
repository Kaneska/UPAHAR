package com.CC1.CC1_Review.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.CC1.CC1_Review.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

    List<Products> findByProductName(String productName);

}

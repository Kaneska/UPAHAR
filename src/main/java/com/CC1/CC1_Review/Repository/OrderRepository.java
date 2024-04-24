package com.CC1.CC1_Review.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CC1.CC1_Review.model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    
}

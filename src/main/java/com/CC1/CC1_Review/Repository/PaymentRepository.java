package com.CC1.CC1_Review.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CC1.CC1_Review.model.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    // Payment findByUsername(String transactionId); 

    @Query( 
        value = "Select p From Payment p where p.transactionId = :val ")
        List<Payment> findByTransactionId(@Param("val") int a);
}
    

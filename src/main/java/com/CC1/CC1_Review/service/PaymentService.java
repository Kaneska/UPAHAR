package com.CC1.CC1_Review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CC1.CC1_Review.Repository.PaymentRepository;
import com.CC1.CC1_Review.model.Payment;

@Service
public class PaymentService {
    
    @Autowired

    private PaymentRepository payrepository;

    public  Payment SavePay(Payment payment) {
        return payrepository.save(payment);
    }
    public  List<Payment> SavePay2(List<Payment> payment) {
        return payrepository.saveAll(payment);
    }

    public Payment getUser(int id) {
        return payrepository.findById(id).orElse(null);

    }

    public List<Payment> getp() {
        return payrepository.findAll();
    }

    public List<Payment> getquery(int transactionId){
        return payrepository.findByTransactionId(transactionId);
    }

    public void deleteid(int id){
        payrepository.deleteById(id);
    }


    
}

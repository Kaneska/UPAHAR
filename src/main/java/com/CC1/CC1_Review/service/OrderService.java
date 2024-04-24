package com.CC1.CC1_Review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CC1.CC1_Review.Repository.OrderRepository;
import com.CC1.CC1_Review.model.Orders;

@Service
public class OrderService {

    @Autowired

    public OrderRepository ORepository;

    public Orders SaveProduct(Orders orders) {
        return ORepository.save(orders);
    }

    public Orders getOder(int id) {
        return ORepository.findById(id).orElse(null);

    }

    public List<Orders> getp() {
        return ORepository.findAll();
    }

    public void deleteOrder(int id)
    {
        ORepository.deleteById(id);
    }

    }
    

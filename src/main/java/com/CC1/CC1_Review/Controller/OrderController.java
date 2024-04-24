package com.CC1.CC1_Review.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CC1.CC1_Review.model.Orders;
import com.CC1.CC1_Review.service.OrderService;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/ord")
    public ResponseEntity<String> postOrderName(@RequestBody Orders order) {
        Orders postedOrder=orderService.SaveProduct(order);
        if(postedOrder!=null){
            // order.getUserid().setID(0);
            orderService.SaveProduct(order);
        }
        else{
            return new ResponseEntity<>("data not created",HttpStatus.BAD_GATEWAY);
            // return new ResponseEntity<>("found data",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("data created",HttpStatus.CREATED);
        
        // return "Saved the user details";
    }

    @GetMapping("/orderedproduct")
    public ResponseEntity< List<Orders> >getallUsers() {
        List<Orders> got=orderService.getp();

        if(!got.isEmpty())
        {
            return new ResponseEntity<>(got,HttpStatus.OK);
            // return orderService.getp();
        }
        else{

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/order/nos/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable int id,
            @RequestBody Orders updateOrders) {
        Orders existOrder = orderService.getOder(id);
        if (existOrder != null) {
            existOrder.setUid(updateOrders.getUid());
            existOrder.setOrderPrice(updateOrders.getOrderPrice());
            orderService.SaveProduct(existOrder);
        } else {
            return new ResponseEntity<>("not found data",HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("found data",HttpStatus.ACCEPTED);
    }

}

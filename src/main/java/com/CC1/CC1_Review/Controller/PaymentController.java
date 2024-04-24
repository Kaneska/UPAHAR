package com.CC1.CC1_Review.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CC1.CC1_Review.model.Payment;
import com.CC1.CC1_Review.service.PaymentService;


@RestController
public class PaymentController {
    private PaymentService PayService;

    // @Autowired
    // private UserRepository userRepository;

    public PaymentController(PaymentService PayService) {
        this.PayService = PayService;

    }

    @PostMapping("/abc")
    public String postMethodName(@RequestBody Payment payment) {

        // MyUser user = payment.getMyUser();
        // MyUser s = userRepository.findByUsername(user.getUsername());
        // //payment.setUser(s);
        // payment.getMyUser().setId(s.getId());
        PayService.SavePay(payment);
        return "saved";



        // PayService.SavePay(payment);
        // return "Saved the user details";

    }
    @PostMapping("/gcc")
    public String saving(@RequestBody List<Payment> payment) {

        PayService.SavePay2(payment);
        return "Saved the user details";

    }
    
    @GetMapping("/path/{a}")
    public List<Payment> QueryMethod(@PathVariable("a") int a) {
        return PayService.getquery(a);
    }
    

    @GetMapping("/order3")
    public List<Payment> getallUsers() {
        return PayService.getp();
    }

    @DeleteMapping("/pay/deleting/{id}")
    public String deleteob(@PathVariable("id") int id) {
        if (PayService.getUser(id) != null) {
            PayService.deleteid(id);
        }
        return "Post Deleted Successfully.";
    }

}
    


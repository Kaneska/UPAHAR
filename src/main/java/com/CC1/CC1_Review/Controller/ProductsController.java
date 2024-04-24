package com.CC1.CC1_Review.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.CC1.CC1_Review.model.Products;
import com.CC1.CC1_Review.service.ProductsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ProductsController {

    private ProductsService pService;

    public ProductsController(ProductsService pService) {
        this.pService = pService;

    }
    @GetMapping("/getless/{productName}")
    public List<Products> getproductName(@PathVariable("productName") String productName){
        return pService.geList(productName);
    }

    @ResponseStatus (value = HttpStatus.ACCEPTED)
    @PostMapping("/pathlo")
    public String postMethodName(@RequestBody Products products) {
        // TODO: process POST request

        // TODO: process POST request
        pService.SaveProduct(products);
        return "Saved the user details";

    }

    @GetMapping("/product")
    public List<Products> getallUsers() {
        return pService.getp();
    }

    @DeleteMapping("/delete/{id}")
    public String prodel(@PathVariable("id") int id)
    {
        Products existpro = pService.getUser(id);
        if(existpro != null)
        {
            pService.deletePro(id);
            return "deleted";
        }
        return "deleted";
    } 
}

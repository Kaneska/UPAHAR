package com.CC1.CC1_Review.model;

// import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;

// import com.fasterxml.jackson.annotation.JsonManagedReference;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//PRIMARY TABLE
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    
    
    @OneToOne(mappedBy = "myuser", cascade = CascadeType.ALL)
    @JsonManagedReference // 避免出現調用無限 recursions的問題，並不是應用
    private Payment payment;




}

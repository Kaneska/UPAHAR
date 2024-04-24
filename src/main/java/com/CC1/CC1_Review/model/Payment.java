package com.CC1.CC1_Review.model;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
// import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//SECONDARY TABLE
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String status;
    // private Date transactionDate =
    // Date.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("yy-MM-dd")));
    private Time transactionTime = Time.valueOf(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

    
    // @ManyToOne
    @OneToOne
    @JsonBackReference
    private MyUser myuser;

}

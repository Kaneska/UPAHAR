package com.CC1.CC1_Review.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CC1.CC1_Review.model.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {

    // MyUser findByUsername(String username);

    // Payment findByStatus(String status);

}

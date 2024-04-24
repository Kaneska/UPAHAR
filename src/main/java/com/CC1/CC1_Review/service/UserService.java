package com.CC1.CC1_Review.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.CC1.CC1_Review.Repository.UserRepository;
import com.CC1.CC1_Review.model.MyUser;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepository;

    public List<MyUser> saveUser(List<MyUser> user) {
        return userrepository.saveAll(user);

    }
    public MyUser save2User(MyUser user) {
        return userrepository.save(user);

    }

    public MyUser getUser(int id) {
        return userrepository.findById(id).orElse(null);

    }

    public List<MyUser> getUsers() {
        // TODO Auto-generated method stub
        return userrepository.findAll();
    }

    public void deleteUser(int id) {
        userrepository.deleteById(id);
    }

    public Page<MyUser> pageN(int PageNo, int size) {
        return userrepository.findAll(PageRequest.of(PageNo, size));
    }

    public List<MyUser> pageNate(int PageNo, int size) {
        return userrepository.findAll(PageRequest.of(PageNo, size)).getContent();
    }

    public Page<MyUser> pageSort(int PageNo, int size, String sorting) {
        return userrepository.findAll(PageRequest.of(PageNo, size, Sort.by(Direction.ASC, sorting)));
    }

}

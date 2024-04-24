package com.CC1.CC1_Review.Controller;

import org.springframework.web.bind.annotation.RestController;
// import com.CC1.CC1_Review.Repository.UserRepository;
import com.CC1.CC1_Review.model.MyUser;
import com.CC1.CC1_Review.service.UserService;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

    // @Autowired
    // private UserRepository uRepository;

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/post")
    public String postMethodName(@RequestBody List<MyUser> user) {
        userService.saveUser(user);
        return "saved";
     }
    @PostMapping("/post234")
    public String post(@RequestBody MyUser user) {
        userService.save2User(user);
        return "saved";
     }

    // @GetMapping("/user/{id}")
    // public User getMethodName(@PathVariable("id") int a) {
    // return userService.getUser(a);
    // }
    @GetMapping("/user/{id}")
    public MyUser getMethodName(@PathVariable("id") int a) {
        return userService.getUser(a);
    }

    @GetMapping("/users")
    public List<MyUser> getallUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteQuery(@PathVariable("id") int id) {
        if (userService.getUser(id) != null) {
            userService.deleteUser(id);
        }
        return "Post Deleted Successfully.";
    }

    @GetMapping("/page/{PageNo}/{size}")
    public Page<MyUser> methodName(@PathVariable("PageNo") int PageNo, @PathVariable("size") int size) {
        return userService.pageN(PageNo, size);

    }

    @GetMapping("/pages/{PageNo}/{size}")
    public List<MyUser> methodName23Page(@PathVariable("PageNo") int PageNo, @PathVariable("size") int size) {
        return userService.pageNate(PageNo, size);

    }

    @GetMapping("/pages/{PageNo}/{size}/{sorting}")
    public Page<MyUser> pgsort(@PathVariable("PageNo") int PageNo, @PathVariable("size") int size,
            @PathVariable("sorting") String sorting) {
        return userService.pageSort(PageNo, size, sorting);

    }

}

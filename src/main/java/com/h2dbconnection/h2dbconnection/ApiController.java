package com.h2dbconnection.h2dbconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PostRepo postRepo;

    @PostMapping("/createUser")
    public UserBean createUser(@RequestBody UserBean userbean) {
        return userRepo.save(userbean);
    }

    @PutMapping("/UpdateUser")
    public Object UpdateUser(@RequestBody UserBean userbean) {
        Optional<UserBean> user = userRepo.findById(userbean.getId());
        if (user.isPresent()) {
            UserBean UpdateUser = userbean;
            UpdateUser.setName(userbean.getName());
            UpdateUser.setPassword(userbean.getPassword());
            userRepo.save(UpdateUser);
            return UpdateUser;
        } else {
            return "User not found";
        }
    }

    @GetMapping("/getUserAll")
    public List<UserBean> getUser() {
        return userRepo.findAll();
    }

    @GetMapping("/getUserByid/{id}")
    public Object getUser(@PathVariable int id) {
        Optional<UserBean> user = userRepo.findById(id);
        if (!user.isPresent()) {
            return "User not found";
        }
        return user;
    }

    @DeleteMapping("/deleteUserByid/{id}")
    public Object deleteUser(@PathVariable int id) {
        Optional<UserBean> user = userRepo.findById(id);
        if (user.isPresent()) {
            userRepo.deleteById(id);
            return "User deleted";
        } else {
            return "User not found";
        }
    }

    @GetMapping("/getPostAll")
    public List<PostBean> getPostAll() {
        return postRepo.findAll();
    }

    @GetMapping("/getPostByid/{id}")
    public List<PostBean> getPostByid(@PathVariable int id) {
        Optional<UserBean> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get().getPost(); // getting post array exit in user data
        }
        return null;
    }

    @PostMapping("/savePosts/{id}")
    public PostBean savePosts(@RequestBody PostBean postBean, @PathVariable int id) {
        Optional<UserBean> user = userRepo.findById(id);
        if (user.isPresent()) {
            UserBean userBean = user.get(); // getting user credential like foreign key
            postBean.setUser(userBean);
            postRepo.save(postBean);
            return postBean;
        }
        return null;
    }
}

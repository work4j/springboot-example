package com.work4j.example.controller;

import com.work4j.example.dao.UserDao;
import com.work4j.example.domain.form.UserForm;
import com.work4j.example.domain.query.UserQuery;
import com.work4j.example.domain.vo.User;
import com.work4j.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wanshipeng on 2018/6/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUsers(UserQuery query) {
        return userService.find(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") String id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public int updateUser(@PathVariable("id") String id, UserForm form) {
        form.setId(id);
        return userService.update(form);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(UserForm form) {
        userService.add(form);
        return form.getId();
    }
}

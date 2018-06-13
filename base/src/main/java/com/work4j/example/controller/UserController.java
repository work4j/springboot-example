package com.work4j.example.controller;

import com.wor4j.util.GsonUtil;
import com.work4j.example.common.ResultBean;
import com.work4j.example.domain.form.UserForm;
import com.work4j.example.domain.query.UserQuery;
import com.work4j.example.domain.vo.User;
import com.work4j.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanshipeng on 2018/6/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultBean getUsers(UserQuery query, HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        System.out.println(user.getId());
        return new ResultBean(userService.find(query));
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultBean login(UserQuery query) {
        List<User> list = userService.find(query);
        if (list.size() != 0) {
            String accessToken = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(accessToken, GsonUtil.getInstance().toJson(list.get(0)), 30, TimeUnit.SECONDS);
            return new ResultBean("0", accessToken);
        } else {
            return new ResultBean("1", "登录失败");
        }
    }
}

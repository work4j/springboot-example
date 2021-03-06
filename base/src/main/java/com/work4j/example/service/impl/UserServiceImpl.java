package com.work4j.example.service.impl;

import com.work4j.example.dao.UserDao;
import com.work4j.example.domain.form.UserForm;
import com.work4j.example.domain.query.UserQuery;
import com.work4j.example.domain.vo.User;
import com.work4j.example.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * UserService
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 查询 User
     */
    public List<User> find(final UserQuery query) {
        return userDao.find(query);
    }

    /**
     * 分页查询 User
     */
    public Page<User> findByPage(final UserQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        return (Page<User>) userDao.find(query);
    }

    /**
     * 通过id得到一个 User
     */
    public User get(final String id) {
        return userDao.get(id);
    }

    /**
     * 新增 User
     */
    public void add(final UserForm form) {
        userDao.add(form);
    }

    /**
     * 修改 User
     */
    public int update(final UserForm form) {
        return userDao.update(form);
    }

    /**
     * 删除一个 User
     */
    public int delete(final String id) {
        return userDao.delete(id);
    }

    /**
     * 修改是否可用
     */
    public int changeEnabled(final String id, final Integer enabled) {
        return userDao.changeEnabled(id, enabled);
    }
}
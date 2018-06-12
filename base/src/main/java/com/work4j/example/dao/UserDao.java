package com.work4j.example.dao;

import com.work4j.example.domain.form.UserForm;
import com.work4j.example.domain.query.UserQuery;
import com.work4j.example.domain.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserDao
 */
public interface UserDao {

    /**
     * 查询 User
     */
    List<User> find(final UserQuery query);

    /**
     * 通过id得到一个 User
     */
    User get(final String id);

    /**
     * 新增 User
     */
    void add(final UserForm form);

    /**
     * 修改 User
     */
    int update(final UserForm form);

    /**
     * 删除一个 User
     */
    int delete(final String id);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);
}
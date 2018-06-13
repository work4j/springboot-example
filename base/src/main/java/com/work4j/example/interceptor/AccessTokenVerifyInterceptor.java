package com.work4j.example.interceptor;

import com.wor4j.util.GsonUtil;
import com.work4j.example.common.ResultBean;
import com.work4j.example.domain.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;


/**
 * Created by Administrator on 2018/6/6.
 */
@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean flag = false;
        // token
        String accessToken = request.getParameter("token");
        // 验证
        if (accessToken != null && redisTemplate.hasKey(accessToken)) {
            User user = (User) GsonUtil.getInstance().fromJson(redisTemplate.opsForValue().get(accessToken), User.class);
            // 时间过期
            // 用户验证
            if (user != null) {
                request.setAttribute("user", user);
                redisTemplate.opsForValue().set(accessToken, GsonUtil.getInstance().toJson(user), 30, TimeUnit.SECONDS);
                flag = true;
            }
        }
        if (!flag) {
            response.setStatus(200);
            response.setCharacterEncoding("UTF-8");
            //response.setContentType("text/html;charset=utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.getWriter().print(GsonUtil.getInstance().toJson(new ResultBean("1001", "认证失败")));
        }

        return flag;
    }
}

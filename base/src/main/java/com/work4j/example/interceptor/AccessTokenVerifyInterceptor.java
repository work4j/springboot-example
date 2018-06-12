package com.work4j.example.interceptor;

import com.work4j.example.common.ResultBean;
import com.work4j.example.domain.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2018/6/6.
 */
@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {

    private final static Logger LOG = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        LOG.info("AccessToken executing ...");
        boolean flag = false;
        // token
        String accessToken = request.getParameter("token");
        // 验证
        // 时间过期

        // 用户验证
        if (accessToken != null) {
            User user = new User();
            request.setAttribute("user", user);
            LOG.info("AccessToken SUCCESS ...  user:" + user.getId() + " - " + accessToken);
            flag = true;
        }

        if (!flag) {
            response.setStatus(200);
            response.getWriter().print(new ResultBean());
        }

        return flag;
    }
}

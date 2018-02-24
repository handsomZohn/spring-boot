package com.sx.common.interceptor;

import com.sx.common.conf.SessionConfig;
import com.sx.common.helper.JsonHelper;
import com.sx.common.util.AjaxJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 
 * 
 * <p>
 * Title: UserLoginInterceptor
 * </p>
 * <p>
 * Description:用户权限校验
 * </p>
 * <p>
 * Company: bksx
 * </p>
 * 
 * @author 殷龙飞
 * @version 1.0
 */
@SuppressWarnings("all")
@Component
public class UserLoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserLoginInterceptor.class);
    @Autowired
    private IUserService userService;

    @Value("OPID")
    private String OPID = "";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        String uri = request.getRequestURI();
        String key = uri;
        logger.info("key:{}",key);
        logger.info("handler name :{}",handler.getClass().getName());

        boolean result = false;
        try {
            SessionConfig sessionConf = (SessionConfig) request.getSession()
                    .getAttribute("sessionConf");
            String sessionId = sessionConf.getSessionid();
            String uId = sessionConf.getCzyid();
        } catch (Exception e) {
            result = false;
        }
        //为了测试 免登陆 正式上线删掉82行 释放开77行
        result = true;
        if (!result) {
            PrintWriter pw = response.getWriter();
            AjaxJsonResult jsonResult = new AjaxJsonResult();
            jsonResult.setCodeAndMsg(401, "Unauthorized");
            pw.write(JsonHelper.object2str(jsonResult));
            pw.flush();
            pw.close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {

    }

}

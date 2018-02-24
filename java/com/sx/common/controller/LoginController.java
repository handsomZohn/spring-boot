package com.sx.common.controller;

import com.sx.bix.bixCAO;
import com.sx.common.GenerateId;
import com.sx.common.conf.SessionConfig;
import com.sx.common.conf.SxAppConfig;
import com.sx.common.dao.UserLoginDao;
import com.sx.common.entity.LoginEntity;
import com.sx.utility.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/25.
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserLoginDao userLoginDao;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登录方法
     */
    @RequestMapping("/login")
    public String login(LoginEntity loginEntity, HttpServletRequest request,
                        HttpServletResponse response) {
        long s = System.currentTimeMillis();
        String log="";
        try {


            String username = StringTools.toTrim(loginEntity.getUsername());
            String userpwd = StringTools.toTrim(loginEntity.getUserpwd());
            log="LoginAction login username="+username;
            logger.info("LoginAction,login:{}  start...",log);
            if (username.equals("") || userpwd.equals("")) { // 用户名和密码不能为空
                request.setAttribute("loginEntity", loginEntity);
                request.setAttribute("loginMsg", "用户名和密码不能为空，请重新输入！");
                logger.info("LoginAction,login:{} username.equals(\"\") || userpwd.equals(\"\")",log);
                return "login";
            }
            SessionConfig sessionConf = userLoginDao.conFirm(username, userpwd); // 执行登录验证
            if (sessionConf == null) { // 登录失败
                request.setAttribute("loginEntity", loginEntity);
                request.setAttribute("loginMsg", "用户名或密码错误，请重新输入！");
                logger.info("LoginAction,login:{} sessionConf == null",log);
                return "login";
            }
            if (userLoginDao.getReturnCode() != 1) {
                request.setAttribute("loginEntity", loginEntity);
                request.setAttribute("loginMsg", userLoginDao.getReturnMsg());
                logger.info("LoginAction,login:{} ,login.getReturnMsg():{},login.getReturnCodeRet:{}",log,userLoginDao.getReturnMsg(),userLoginDao.getReturnCode());
                return "login";
            } else { // 登录成功

                //为ca增加
                sessionConf.setServerip(loginEntity.getServerip());
                sessionConf.setClientid(loginEntity.getClientid());
                sessionConf.setVcode(loginEntity.getVcode());

                String clientip=loginEntity.getClientip();
                if(clientip==null||clientip.equals("")){
                    clientip=this.getIpAddr(request);
                }

                sessionConf.setDlip(clientip+":"+request.getServerName()+":"+request.getServerPort());
                sessionConf.setCert(loginEntity.getUserCert());
                sessionConf.setTicket(loginEntity.getTicket());
                sessionConf.setTicketSignedData(loginEntity.getTicketSignedData());
                sessionConf.setContainerName(loginEntity.getContainerName());
                sessionConf.setAppsessionid(request.getSession().getId());

                sessionConf.setJmfg(SxAppConfig.getAPPCONTEXT() + "/styles/3");

                if(sessionConf.getSessionid()==null||sessionConf.getSessionid().equals("")){
                    sessionConf.setSessionid(GenerateId.getGenerateId());
                }

                //===========================================================
                //基础库日志操作对象
                //===========================================================
                bixCAO bixCao = new bixCAO(sessionConf.getSessionid(),sessionConf.getCzyid(),sessionConf.getCzyxm(),sessionConf.getDwid(),sessionConf.getDwmc());
                sessionConf.setCao(bixCao);
                //===========================================================


                request.getSession().setAttribute("sessionConf", sessionConf);
                logger.info("LoginAction,login:{} ,succ name is [\"{}\"] use time:{}",log,sessionConf.getCzyxm(),(System.currentTimeMillis()-s));
                logger.info("LoginAction,login:{} end",log);
                return "redirect:/index.jsp";
            }
        } catch (Exception ex) {
            request.setAttribute("exceptionobj", ex);
            logger.error("LoginAction,login:{},Exception:{}",log,ex.getMessage());
            return "common/errpage/exception";
        }
    }


    /**
     * 得到真实机器ip
     * @param request http请求
     * @return ip的字符串
     */
    private String getIpAddr(HttpServletRequest request) {
        try{
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            return ip;
        }catch (Exception e){
            return "unknown";
        }
    }
}

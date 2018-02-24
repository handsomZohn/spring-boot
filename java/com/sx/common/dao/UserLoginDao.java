package com.sx.common.dao;

import com.sx.common.conf.SessionConfig;
import com.sx.rbac.RbacOperation;
import com.sx.support.rbac.po.UserDetailPO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 * <p>Title: 北京市劳动力市场信息系统，登录业务处理</p>
 * <p>Description: 北京市劳动力市场信息系统，登录业务处理</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: bksx</p>
 * @author oyxz
 * @version 1.0
 */
@Repository
public class UserLoginDao {

	  private int returnCode = 1;

	  private String returnMsg = "";

	  private Logger logger = LoggerFactory.getLogger(UserLoginDao.class);

	  public UserLoginDao() {
	  
	  }

	  /**
	   * 登录业务操作
	   * @param username 用户名
	   * @param userpwd 密码
	   * @return sessionConfig sessionConf的相关信息
	   */
	  public SessionConfig conFirm(String username, String userpwd) {
		  //com.sx.support.rbac.api.LoginImplementWebService
		    SessionConfig sessionConf = new SessionConfig();
		    UserDetailPO userpo = RbacOperation.login(username, userpwd);
		    if (userpo == null) {
		      logger.error("UserLogin,conFirm(String username,String userpwd),Login isValidUser err in {} ",username);
		      returnCode = 10;
		      returnMsg = "用户名或密码错误，请重新输入！";
		      return sessionConf;
		    }
		    sessionConf.setCzyid(userpo.getUserId());
		    sessionConf.setCzyxm(userpo.getUserName());
		    sessionConf.setCzylxdh(userpo.getUserPhone());
		
		    sessionConf.setDwid(userpo.getUserDId());
		    sessionConf.setDwmc(userpo.getUserDName());
		
		    sessionConf.setSessionid(userpo.getSessionId());
		
//		    if (!this.getLdlscXtcs(sessionConf.getDwid(),sessionConf)){
//			      logger.error("UserLogin", "conFirm(String username,String userpwd)",
//			                 "UserLogin getLdlscXtcs err in " + sessionConf.getDwid());
//			      returnCode = 20;
//			      returnMsg = "系统配置参数错误，请与系统管理员联系！";
//			      return sessionConf;
//			 }
		 
		    
		    returnCode = 1;
		    returnMsg = "登录成功！";
		    return sessionConf;
	  }

  public int getReturnCode() {
    return returnCode;
  }

  public String getReturnMsg() {
    return returnMsg;
  }

}
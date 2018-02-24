package com.sx.common.entity;

import com.sx.bean.AbsFormBean;

/**
 * <p>Title: 北京市劳动力市场信息系统，登录的formbean</p>
 * <p>Description: 北京市劳动力市场信息系统，登录的formbean</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: bksx</p>
 * @author oyxz
 * @version 1.0
 */

@SuppressWarnings("serial")
public class LoginEntity{

  private String username;
  private String userpwd;
  
  private String serverip;
  private String clientid;
  private String vcode;
  
  private String cert;
  
  //==============================
  //pfpmi  
  private String userCert;
  private String userExchCert;
  private String userSignedData;
  private String containerName;
  private String keySN;
  
  //20140209新版身份认证增加
  private String loginCode;
  private String ticket;
  private String ticketSignedData;
  
  private String ssoUrl;
  private String flag;//转出影像查看使用flag=1，数字化管理系统flag判断,1：查询本区县最新，0：市中心最新
  
  
  
  //客户端ip
  private String clientip;
  //会话id rbac
  private String sid;
  //会话id 应用系统会话id
  private String asid;
  //业务id
  private String bizid;
  


public String getBizid() {
	return bizid;
}

public void setBizid(String bizid) {
	this.bizid = bizid;
}

public String getSsoUrl() {
	return ssoUrl;
}

public void setSsoUrl(String ssoUrl) {
	this.ssoUrl = ssoUrl;
}

public String getTicketSignedData() {
	return ticketSignedData;
}

public void setTicketSignedData(String ticketSignedData) {
	this.ticketSignedData = ticketSignedData;
}

public String getTicket() {
	return ticket;
}

public void setTicket(String ticket) {
	this.ticket = ticket;
}

public String getLoginCode() {
	return loginCode;
}

public void setLoginCode(String loginCode) {
	this.loginCode = loginCode;
}

/**
 * @return Returns the asid.
 */
public String getAsid() {
	return asid;
}

/**
 * @param asid The asid to set.
 */
public void setAsid(String asid) {
	this.asid = asid;
}

/**
 * @return Returns the sid.
 */
public String getSid() {
	return sid;
}

/**
 * @param sid The sid to set.
 */
public void setSid(String sid) {
	this.sid = sid;
}

/**
 * @return Returns the clientip.
 */
public String getClientip() {
	return clientip;
}

/**
 * @param clientip The clientip to set.
 */
public void setClientip(String clientip) {
	this.clientip = clientip;
}

/**
 * @return Returns the cert.
 */
public String getCert() {
	return cert;
}

/**
 * @return Returns the containerName.
 */
public String getContainerName() {
	return containerName;
}

/**
 * @param containerName The containerName to set.
 */
public void setContainerName(String containerName) {
	this.containerName = containerName;
}

/**
 * @return Returns the keySN.
 */
public String getKeySN() {
	return keySN;
}

/**
 * @param keySN The keySN to set.
 */
public void setKeySN(String keySN) {
	this.keySN = keySN;
}

/**
 * @return Returns the userCert.
 */
public String getUserCert() {
	return userCert;
}

/**
 * @param userCert The userCert to set.
 */
public void setUserCert(String userCert) {
	this.userCert = userCert;
}

/**
 * @return Returns the userExchCert.
 */
public String getUserExchCert() {
	return userExchCert;
}

/**
 * @param userExchCert The userExchCert to set.
 */
public void setUserExchCert(String userExchCert) {
	this.userExchCert = userExchCert;
}

/**
 * @return Returns the userSignedData.
 */
public String getUserSignedData() {
	return userSignedData;
}

/**
 * @param userSignedData The userSignedData to set.
 */
public void setUserSignedData(String userSignedData) {
	this.userSignedData = userSignedData;
}

/**
 * @param cert The cert to set.
 */
public void setCert(String cert) {
	this.cert = cert;
}

public String getUsername() {
    return username;
  }

  public String getUserpwd() {
    return userpwd;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setUserpwd(String userpwd) {
    this.userpwd = userpwd;
  }

public String getClientid() {
	return clientid;
}

public void setClientid(String clientid) {
	this.clientid = clientid;
}

public String getServerip() {
	return serverip;
}

public void setServerip(String serverip) {
	this.serverip = serverip;
}

public String getVcode() {
	return vcode;
}

public void setVcode(String vcode) {
	this.vcode = vcode;
}

/**
 * @return 返回 flag。
 */
public String getFlag() {
	return flag;
}

/**
 * @param flag 要设置的 flag。
 */
public void setFlag(String flag) {
	this.flag = flag;
}

}
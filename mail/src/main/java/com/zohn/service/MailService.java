package com.zohn.service;

/**
 * Created by zohn on 2017/12/8.
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
}

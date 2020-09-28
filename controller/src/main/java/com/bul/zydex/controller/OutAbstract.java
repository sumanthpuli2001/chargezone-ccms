/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.util.SendMail;
import org.apache.log4j.Logger;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public abstract class OutAbstract extends CustomAbstract {

    protected static final Logger logger = Logger.getLogger(OutAbstract.class);
    protected SendMail sendMail;

    public SendMail getSendMail() {
        return sendMail;
    }

    public void setSendMail(SendMail sendMail) {
        this.sendMail = sendMail;
    }

}

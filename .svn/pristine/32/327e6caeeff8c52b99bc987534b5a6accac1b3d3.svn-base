/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.MailMasterDAO;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class MailMasterServiceImpl<T> extends GenericsServiceImpl<T>
        implements MailMasterService<T> {

    private MailMasterDAO<T> mailMasterDAO;

    public MailMasterDAO<T> getMailMasterDAO() {
        return mailMasterDAO;
    }

    public void setMailMasterDAO(MailMasterDAO<T> mailMasterDAO) {
        this.mailMasterDAO = mailMasterDAO;
        setGenericsDAO(mailMasterDAO);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.MailMaster;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class MailMasterDAOImpl<T> extends GenericsDAOImpl<T> implements
        MailMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return MailMaster.class;
    }

}

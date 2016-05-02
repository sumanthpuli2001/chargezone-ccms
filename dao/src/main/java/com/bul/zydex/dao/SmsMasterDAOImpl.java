/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.SmsMaster;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class SmsMasterDAOImpl<T> extends GenericsDAOImpl<T> implements
        SmsMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return SmsMaster.class;
    }

}

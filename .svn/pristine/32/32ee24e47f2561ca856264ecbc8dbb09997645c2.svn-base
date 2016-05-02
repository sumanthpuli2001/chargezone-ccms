/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.SmsMasterDAO;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class SmsMasterServiceImpl<T> extends GenericsServiceImpl<T>
        implements SmsMasterService<T> {

    private SmsMasterDAO<T> smsMasterDAO;

    public SmsMasterDAO<T> getSmsMasterDAO() {
        return smsMasterDAO;
    }

    public void setSmsMasterDAO(SmsMasterDAO<T> smsMasterDAO) {
        this.smsMasterDAO = smsMasterDAO;
        setGenericsDAO(smsMasterDAO);
    }

}

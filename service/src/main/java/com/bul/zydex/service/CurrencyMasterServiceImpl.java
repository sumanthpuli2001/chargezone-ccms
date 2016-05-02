/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.CurrencyMasterDAO;

/**
 *
 * @author AJAY
 */
public class CurrencyMasterServiceImpl<T> extends GenericsServiceImpl<T> implements CurrencyMasterService<T> {

    protected CurrencyMasterDAO<T> currencyMasterDAO;

    public CurrencyMasterDAO<T> getCurrencyMasterDAO() {
        return currencyMasterDAO;
    }

    public void setCurrencyMasterDAO(CurrencyMasterDAO<T> currencyMasterDAO) {
        this.currencyMasterDAO = currencyMasterDAO;
        setGenericsDAO(currencyMasterDAO);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CountryCode;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CountryCode;

/**
 *
 * @author bulwarks-2
 */
public class CountryCodeDaoImpl<T> extends GenericsDAOImpl<T> implements CountryCodeDao<T> {

    @Override
    protected Class getDomainClass() {
        return CountryCode.class;
    }
    
}

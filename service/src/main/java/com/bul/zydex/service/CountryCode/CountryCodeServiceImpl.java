/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CountryCode;

import com.bul.zydex.dao.CountryCode.CountryCodeDao;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author bulwarks-2
 */
public class CountryCodeServiceImpl<T> extends GenericsServiceImpl<T> implements CountryCodeService<T> {

    private CountryCodeDao<T> countryCodeDao;

    public CountryCodeDao<T> getCountryCodeDao() {
        return countryCodeDao;
    }

    public void setCountryCodeDao(CountryCodeDao<T> countryCodeDao) {
        this.countryCodeDao = countryCodeDao;
        setGenericsDAO(countryCodeDao);
    }
    
}

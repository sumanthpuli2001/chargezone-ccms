/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.MultipleAddressDao;
import com.bul.zydex.dao.PR.PRDocDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class MultipleAddressServiceImpl<T> extends GenericsServiceImpl<T> implements MultipleAddressService<T> {

    private MultipleAddressDao<T> multipleAddressDao;

    public MultipleAddressDao<T> getMultipleAddressDao() {
        return multipleAddressDao;
    }

    public void setMultipleAddressDao(MultipleAddressDao<T> multipleAddressDao) {
        this.multipleAddressDao = multipleAddressDao;
        setGenericsDAO(multipleAddressDao);

    }

    @Override
    public List readByPrNumber(String prNo) {
        return multipleAddressDao.readByPrNumber(prNo);
    }

}

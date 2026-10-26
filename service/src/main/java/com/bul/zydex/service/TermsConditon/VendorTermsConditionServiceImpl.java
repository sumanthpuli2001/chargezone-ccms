/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.TermsConditon;

import com.bul.zydex.dao.TermsCondition.VendorTermsConditionDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VendorTermsConditionServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTermsConditionService<T> {

    private VendorTermsConditionDao<T> vendorTermsConditionDao;

    public VendorTermsConditionDao<T> getVendorTermsConditionDao() {
        return vendorTermsConditionDao;
    }

    public void setVendorTermsConditionDao(VendorTermsConditionDao<T> vendorTermsConditionDao) {
        this.vendorTermsConditionDao = vendorTermsConditionDao;
        setGenericsDAO(vendorTermsConditionDao);
    }

    @Override
    public List readByRef(String ref, String username) {
        return vendorTermsConditionDao.readByRef(ref, username);
    }

}

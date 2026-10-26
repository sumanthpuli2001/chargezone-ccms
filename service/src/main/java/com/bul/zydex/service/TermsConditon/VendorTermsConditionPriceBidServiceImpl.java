/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.TermsConditon;

import com.bul.zydex.dao.TermsCondition.VendorTermsConditionPriceBidDao;
import com.bul.zydex.model.VendorTermsConditionPriceBid;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class VendorTermsConditionPriceBidServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTermsConditionPriceBidService<T> {

    private VendorTermsConditionPriceBidDao<T> vendorTermsConditionPriceBidDao;

    public VendorTermsConditionPriceBidDao<T> getVendorTermsConditionPriceBidDao() {
        return vendorTermsConditionPriceBidDao;
    }

    public void setVendorTermsConditionPriceBidDao(VendorTermsConditionPriceBidDao<T> vendorTermsConditionPriceBidDao) {
        this.vendorTermsConditionPriceBidDao = vendorTermsConditionPriceBidDao;
        setGenericsDAO(vendorTermsConditionPriceBidDao);
    }
    
    @Override
    public List readByRef(String ref, String username) {
        return vendorTermsConditionPriceBidDao.readByRef(ref, username);
    }

    @Override
    public VendorTermsConditionPriceBid readByTerms(String refNo, String username, String termsCondition) {
        return vendorTermsConditionPriceBidDao.readByTerms(refNo, username, termsCondition);
    }
    
}

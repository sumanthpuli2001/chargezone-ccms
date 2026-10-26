/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorFinancialApprovalDetails;

import com.bul.zydex.dao.VendorFinancialApprovalDetails.VendorFinancialApprovalDetailsDao;
import com.bul.zydex.model.VendorFinancialApprovalDetails;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Sumanth
 */
public class VendorFinancialApprovalDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements VendorFinancialApprovalDetailsService<T> {

    private VendorFinancialApprovalDetailsDao<T> vendorFinancialApprovalDetailsDao;

    public VendorFinancialApprovalDetailsDao<T> getVendorFinancialApprovalDetailsDao() {
        return vendorFinancialApprovalDetailsDao;
    }

    public void setVendorFinancialApprovalDetailsDao(VendorFinancialApprovalDetailsDao<T> vendorFinancialApprovalDetailsDao) {
        this.vendorFinancialApprovalDetailsDao = vendorFinancialApprovalDetailsDao;
        setGenericsDAO(vendorFinancialApprovalDetailsDao);

    }

    @Override
    public VendorFinancialApprovalDetails readByVendorInformationId(int vendorInfoId) {
        return vendorFinancialApprovalDetailsDao.readByVendorInformationId(vendorInfoId);
    }

}

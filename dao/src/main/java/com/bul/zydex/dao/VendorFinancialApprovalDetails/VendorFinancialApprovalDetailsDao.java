/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorFinancialApprovalDetails;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorFinancialApprovalDetails;

/**
 *
 * @author Sumanth
 */
public interface VendorFinancialApprovalDetailsDao<T> extends GenericsDAO<T> {

    public VendorFinancialApprovalDetails readByVendorInformationId(int vendorInfoId);

}

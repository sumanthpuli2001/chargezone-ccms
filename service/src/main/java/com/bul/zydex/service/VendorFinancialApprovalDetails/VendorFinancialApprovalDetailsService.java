/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorFinancialApprovalDetails;

import com.bul.zydex.model.VendorFinancialApprovalDetails;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Sumanth
 */
public interface VendorFinancialApprovalDetailsService<T> extends GenericsService<T> {

    public VendorFinancialApprovalDetails readByVendorInformationId(int vendorInfoId);
}

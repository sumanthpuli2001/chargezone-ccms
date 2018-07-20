/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Approval;

import com.bul.zydex.dao.Approval.DynamicApprovalSettingDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Admin
 */
public class DynamicApprovalSettingServiceImpl<T> extends GenericsServiceImpl<T> implements DynamicApprovalSettingService<T> {

    private DynamicApprovalSettingDAO<T> dynamicApprovalSettingDAO;

    public DynamicApprovalSettingDAO<T> getDynamicApprovalSettingDAO() {
        return dynamicApprovalSettingDAO;
    }

    public void setDynamicApprovalSettingDAO(DynamicApprovalSettingDAO<T> dynamicApprovalSettingDAO) {
        this.dynamicApprovalSettingDAO = dynamicApprovalSettingDAO;
        setGenericsDAO(dynamicApprovalSettingDAO);
    }

}

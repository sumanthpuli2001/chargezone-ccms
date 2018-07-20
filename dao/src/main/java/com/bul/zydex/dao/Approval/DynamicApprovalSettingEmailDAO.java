/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DynamicApprovalSettingEmailDAO<T> extends GenericsDAO<T> {

    public List<?> readByDnamicApprovalSettingId(int ApproverId);

    public List<?> readByApproverCycleId(int ApproverCycleId);

    public void deleteByApproverSettingId(int ApproverId);

    public List<?> readByModuleName(String moduleName);
    
}

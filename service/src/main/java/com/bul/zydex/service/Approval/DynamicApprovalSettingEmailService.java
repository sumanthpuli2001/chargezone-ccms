/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Approval;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DynamicApprovalSettingEmailService<T> extends GenericsService<T> {

    public List<?> readByApproverCycleId(int ApproverCycleId);

    public List<?> readByDnamicApprovalSettingId(int ApproverId);

    public void deleteByApproverSettingId(int ApproverId);

    public List<?> readByModuleName(String moduleName);

}

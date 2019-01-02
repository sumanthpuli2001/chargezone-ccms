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
public interface DynamicApprovalSettingApproverService<T> extends GenericsService<T> {

    public List<?> readByDnamicApprovalSettingId(int ApproverId);

    public void deleteByApproverSettingId(int ApproverId);

    public List<?> getByApproverId(int ApproverId);

    public List<?> readByzyLocIdCompnameAndDesId(int desId, String module);

}

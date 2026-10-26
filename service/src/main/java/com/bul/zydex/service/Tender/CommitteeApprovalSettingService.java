/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.CommitteeApprovalSetting;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public interface CommitteeApprovalSettingService<T> extends GenericsService<T> {

    public CommitteeApprovalSetting readByName(String technical_committee);

    public List getCommitteePagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalCommitteeCount();

    public int getFilteredCommitteeCount(String searchValue);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CommitteeApprovalSetting;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public interface CommitteeApprovalSettingDao<T> extends GenericsDAO<T> {

    public CommitteeApprovalSetting readByName(String technical_committee);

    public int getTotalCommitteeCount();

    public int getFilteredCommitteeCount(String search);

    public List getCommitteePagination(int start, int length, String searchValue, String orderColumn, String orderDir);
    
}

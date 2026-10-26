/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ApprovalSetting;
import java.util.List;


/**
 *
 * @author admin
 */
public interface ApprovalSettingDao<T> extends GenericsDAO<T> {
    
    public List readByrow();
    
    public ApprovalSetting read(String Code);
    
    public List readOne(String rone);
    
    public void deleteByCode(String checkedValues);
    
    public ApprovalSetting readUserId(String user);

    public List getApprovalPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getApprovalCount();

    public int getFilteredApprovalCount(String search);
}

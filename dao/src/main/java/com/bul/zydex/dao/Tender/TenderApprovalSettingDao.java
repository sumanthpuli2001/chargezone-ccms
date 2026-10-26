/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public interface TenderApprovalSettingDao<T> extends GenericsDAO<T> {

    public List getTenderPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalTenderCount();

    public int getFilteredTenderCount(String search);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public interface TenderApprovalSettingService<T> extends GenericsService<T>  {

    public List getTenderPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalTenderCount();

    public int getFilteredTenderCount(String searchValue);
    
}

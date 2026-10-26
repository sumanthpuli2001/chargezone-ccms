/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface GroupMasterService<T> extends GenericsService<T> {

    public List getGroupMasterPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalGroupMasterCount();

    public int getFilteredGroupMasterCount(String searchValue);
}

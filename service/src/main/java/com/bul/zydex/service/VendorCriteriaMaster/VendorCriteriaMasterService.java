/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorCriteriaMaster;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface VendorCriteriaMasterService<T> extends GenericsService<T> {

    public List readByAll(int vendorInvtId, String groupId, String groupCategoryId, String groupSubCategoryId, String departCategory);

    public List readByFirstTwo(int vendorInvtId, String groupId, String groupCategoryId, String departCategory);

    public List readByFirstOne(int vendorInvtId, String groupId, String departCategory);

    public List getVendorCriteriaPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalVendorCriteriaCount();

    public int getFilteredVendorCriteriaCount(String searchValue);

}

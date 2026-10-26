/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorPercentage;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface VendorPercentageDao <T> extends GenericsDAO<T> {

    public List getVendorPercentagePagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalVendorPercentageCount();

    public int getFilteredVendorPercentageCount(String searchValue);
    
}

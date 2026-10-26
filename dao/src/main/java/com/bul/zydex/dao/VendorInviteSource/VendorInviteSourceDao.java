/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorInviteSource;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface VendorInviteSourceDao <T> extends GenericsDAO<T>{

    public List getVendorInviteSourcePagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalVendorInviteSourceCount();

    public int getFilteredVendorInviteSourceCount(String searchValue);
    
}

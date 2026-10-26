/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorInviteSource;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface VendorInviteSourceService<T> extends GenericsService<T> {


    public List getVendorInviteSourcePagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalVendorInviteSourceCount();

    public int getFilteredVendorInviteSourceCount(String searchValue);

}

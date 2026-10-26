/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tenant;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface TenantService<T> extends GenericsService<T> {

    public List getTenantPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTenantCount();

    public int getFilteredTenantCount(String searchValue);

}

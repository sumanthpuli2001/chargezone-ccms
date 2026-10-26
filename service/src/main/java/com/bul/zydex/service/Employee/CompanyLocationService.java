/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Employee;

import com.bul.zydex.model.CompanyLocation;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public interface CompanyLocationService<T> extends GenericsService<T> {

    public List getCompanyLocationPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalCompanyLocationCount();

    public int getFilteredCompanyLocationCount(String searchValue);
    
}

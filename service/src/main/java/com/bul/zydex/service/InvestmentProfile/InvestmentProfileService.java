/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.InvestmentProfile;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InvestmentProfileService<T> extends  GenericsService<T> {

    public List getInvestPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalInvestCount();

    public int getFilteredInvestCount(String searchValue);
    
}

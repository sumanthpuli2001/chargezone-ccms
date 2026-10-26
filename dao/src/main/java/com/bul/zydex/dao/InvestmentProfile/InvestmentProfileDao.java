/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.InvestmentProfile;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InvestmentProfileDao<T> extends GenericsDAO<T> {

    public List getInvestPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalInvestCount();

    public int getFilteredInvestCount(String search);
    
}

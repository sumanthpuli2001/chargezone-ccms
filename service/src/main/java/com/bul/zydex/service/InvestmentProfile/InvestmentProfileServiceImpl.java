/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.InvestmentProfile;

import com.bul.zydex.dao.InvestmentProfile.InvestmentProfileDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class InvestmentProfileServiceImpl<T> extends GenericsServiceImpl<T> implements InvestmentProfileService<T> {

    private InvestmentProfileDao<T> investmentProfileDao;

    public InvestmentProfileDao<T> getInvestmentProfileDao() {
        return investmentProfileDao;
    }

    public void setInvestmentProfileDao(InvestmentProfileDao<T> investmentProfileDao) {
        this.investmentProfileDao = investmentProfileDao;
        setGenericsDAO(investmentProfileDao);
    }

    @Override
    public List getInvestPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return investmentProfileDao.getInvestPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalInvestCount() {
        return investmentProfileDao.getTotalInvestCount();
    }

    @Override
    public int getFilteredInvestCount(String search) {
        return investmentProfileDao.getFilteredInvestCount(search);
    }

}

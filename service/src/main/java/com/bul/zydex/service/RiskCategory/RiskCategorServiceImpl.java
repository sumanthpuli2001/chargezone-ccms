/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.RiskCategory;

import com.bul.zydex.dao.RiskCategory.RiskCategoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RiskCategorServiceImpl<T> extends GenericsServiceImpl<T> implements RiskCategoryService<T> {

    private RiskCategoryDao<T> riskCategoryDao;

    public RiskCategoryDao<T> getRiskCategoryDao() {
        return riskCategoryDao;
    }

    public void setRiskCategoryDao(RiskCategoryDao<T> riskCategoryDao) {
        this.riskCategoryDao = riskCategoryDao;
        setGenericsDAO(riskCategoryDao);
    }

    @Override
    public List getRiskCategoryPagination(int start, int length, String search, String orderColumn, String orderDir) {
        return riskCategoryDao.getRiskCategoryPagination(start, length, search, orderColumn, orderDir);

    }

    @Override
    public int getTotalRiskCategoryCount() {
        return riskCategoryDao.getTotalRiskCategoryCount();

    }

    @Override
    public int getFilteredRiskCategoryCount(String searchValue) {

        return riskCategoryDao.getFilteredRiskCategoryCount(searchValue);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PurchasingOrganisation;

import com.bul.zydex.dao.PurchasingOrganisation.PurchasingOrganisationDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class PurchasingOrganisationServiceImpl<T> extends GenericsServiceImpl<T> implements PurchasingOrganisationService<T> {

    private PurchasingOrganisationDao<T> purchasingOrganisationDao;

    public PurchasingOrganisationDao<T> getPurchasingOrganisationDao() {
        return purchasingOrganisationDao;
    }

    public void setPurchasingOrganisationDao(PurchasingOrganisationDao<T> purchasingOrganisationDao) {
        this.purchasingOrganisationDao = purchasingOrganisationDao;
        setGenericsDAO(purchasingOrganisationDao);

    }

    @Override
    public boolean isExist(T object) {
        return purchasingOrganisationDao.isExist(object);
    }

    @Override
    public List getPurchasingOrganisationPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return purchasingOrganisationDao.getPurchasingOrganisationPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getPurchasingOrganisationCount() {
        return purchasingOrganisationDao.getPurchasingOrganisationCount();
    }

    @Override
    public int getFilteredPurchasingOrganisationCount(String search) {
        return purchasingOrganisationDao.getFilteredPurchasingOrganisationCount(search);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tenant;

import com.bul.zydex.dao.Tenant.TenantDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class TenantServiceImpl<T> extends GenericsServiceImpl<T> implements TenantService<T> {

    private TenantDao<T> tenantDao;

    public TenantDao<T> getTenantDao() {
        return tenantDao;
    }

    public void setTenantDao(TenantDao<T> tenantDao) {
        this.tenantDao = tenantDao;
        setGenericsDAO(tenantDao);

    }

    @Override
    public List getTenantPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return tenantDao.getTenantPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTenantCount() {
        return tenantDao.getTenantCount();
    }

    @Override
    public int getFilteredTenantCount(String search) {
        return tenantDao.getFilteredTenantCount(search);
    }

}

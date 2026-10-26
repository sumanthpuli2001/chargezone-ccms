/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorRecycleMailScheduler;

import com.bul.zydex.dao.VendorRecycleMailScheduler.VendorRecycleMailSchedulerDao;
import com.bul.zydex.model.VendorRecycleMailScheduler;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Bulwark-5
 */
public class VendorRecycleMailSchedulerServiceImpl<T> extends GenericsServiceImpl<T> implements VendorRecycleMailSchedulerService<T> {

    private VendorRecycleMailSchedulerDao<T> vendorRecycleMailSchedulerDao;

    public VendorRecycleMailSchedulerDao<T> getVendorRecycleMailSchedulerDao() {
        return vendorRecycleMailSchedulerDao;
    }

    public void setVendorRecycleMailSchedulerDao(VendorRecycleMailSchedulerDao<T> vendorRecycleMailSchedulerDao) {
        this.vendorRecycleMailSchedulerDao = vendorRecycleMailSchedulerDao;
        setGenericsDAO(vendorRecycleMailSchedulerDao);
    }

    @Override
    public VendorRecycleMailScheduler readByInfoId(int vInfoId) {
        return vendorRecycleMailSchedulerDao.readByInfoId(vInfoId);
    }

    @Override
    public List readByInfoIdList(int vInfoId) {
        return vendorRecycleMailSchedulerDao.readByInfoIdList(vInfoId);
    }

}

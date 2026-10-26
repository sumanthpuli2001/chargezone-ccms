/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorRecycleMailScheduler;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorRecycleMailScheduler;
import java.util.List;

/**
 *
 * @author Bulwark-5
 */
public interface VendorRecycleMailSchedulerDao<T> extends GenericsDAO<T> {

    public VendorRecycleMailScheduler readByInfoId(int vInfoId);

    public List readByInfoIdList(int vInfoId);

}

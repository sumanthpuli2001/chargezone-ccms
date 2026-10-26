/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorRecycleMailScheduler;

import com.bul.zydex.model.VendorRecycleMailScheduler;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Bulwark-5
 */
public interface VendorRecycleMailSchedulerService<T> extends GenericsService<T> {

    public VendorRecycleMailScheduler readByInfoId(int vInfoId);

    public List readByInfoIdList(int vInfoId);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Right;

import com.bul.zydex.model.RightMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface RightService<T> extends GenericsService<T>{

    public RightMaster read(String rightName);

    public void deleteByRightName(String checkedValues);

    public List readByDrow();

    public List readByDrowDisable();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Position;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Irfan
 * @param <T>
 */
public interface PositionReferMasterService<T> extends GenericsService<T>{
    
    public boolean isExist(T object);
    
    public List<?> readPositionData();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ClosePr;

import com.bul.zydex.service.BpGroup.*;
import com.bul.zydex.model.BpGroup;
import com.bul.zydex.model.ClosePr;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author bulwarks-2
 */
public interface ClosePrService<T> extends GenericsService<T>  {

    public ClosePr readByPrID(int parseInt);

    
}

/*
 * 
 * Author Vinita
 */

package com.bul.zydex.service.emprequest;

import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Vinita
 */
public interface ItRequestTypeService<T> extends GenericsService<T>{

     public boolean isExist(T object);
}

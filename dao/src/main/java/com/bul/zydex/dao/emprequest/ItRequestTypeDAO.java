 /*
 * 
 * Author Vinita
 */

package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAO;

/**
 *
 * @author Vinita
 */
public interface ItRequestTypeDAO<T> extends GenericsDAO<T>{

     public boolean isExist(T object);
}

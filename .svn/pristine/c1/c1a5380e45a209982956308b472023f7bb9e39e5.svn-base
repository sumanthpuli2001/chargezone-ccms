/*
 * 
 * Author Vinita
 */

package com.bul.zydex.service.emprequest;

import com.bul.zydex.dao.emprequest.ItRequestTypeDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Vinita
 */
public class ItRequestTypeServiceImpl<T> extends GenericsServiceImpl<T> implements ItRequestTypeService<T>{

     private ItRequestTypeDAO itRequestTypeDAO;

    public ItRequestTypeDAO getItRequestTypeDAO() {
        return itRequestTypeDAO;
    }

    public void setItRequestTypeDAO(ItRequestTypeDAO itRequestTypeDAO) {
        this.itRequestTypeDAO = itRequestTypeDAO;
        setGenericsDAO(itRequestTypeDAO);
    }

    @Override
    public boolean isExist(T object) {
        return itRequestTypeDAO.isExist(object);
    }
     
     
}

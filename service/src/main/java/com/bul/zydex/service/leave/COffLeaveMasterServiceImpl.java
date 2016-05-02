/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.leave;

import com.bul.zydex.dao.leave.COffLeaveMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Dhaval Patel <dhaval217@gmail.com>
 */
public class COffLeaveMasterServiceImpl<T> extends GenericsServiceImpl<T> implements COffLeaveMasterService<T> {

    protected COffLeaveMasterDAO<T> cOffLeaveMasterDAO;

    public COffLeaveMasterDAO<T> getcOffLeaveMasterDAO() {
        return cOffLeaveMasterDAO;
    }

    public void setcOffLeaveMasterDAO(COffLeaveMasterDAO<T> cOffLeaveMasterDAO) {
        this.cOffLeaveMasterDAO = cOffLeaveMasterDAO;
         setGenericsDAO(cOffLeaveMasterDAO);
    }
    
    @Override
    public boolean isExist(T object) {
        return cOffLeaveMasterDAO.isExist(object);
    }

    @Override
    public List<?> readByDept(T object) {
        return cOffLeaveMasterDAO.readByDept(object);
    }

}

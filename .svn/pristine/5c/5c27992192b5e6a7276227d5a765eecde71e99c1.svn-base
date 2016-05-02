/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.zydexLocation;

import com.bul.zydex.dao.zydexLocation.ZydexLocationMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan
 */
public class ZydexLocationMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ZydexLocationMasterService<T> {

    private ZydexLocationMasterDAO<T> zydexLocationMasterDAO;

    public ZydexLocationMasterDAO<T> getZydexLocationMasterDAO() {
        return zydexLocationMasterDAO;
    }

    public void setZydexLocationMasterDAO(ZydexLocationMasterDAO<T> zydexLocationMasterDAO) {
        this.zydexLocationMasterDAO = zydexLocationMasterDAO;
        setGenericsDAO(zydexLocationMasterDAO);
    }
    

    @Override
    public boolean isExist(T object) {
        return zydexLocationMasterDAO.isExist(object);
    }
    @Override
    public List<?> readByName(String zydexLocation) {
        return zydexLocationMasterDAO.readByName(zydexLocation);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocLogMaster;

import com.bul.zydex.dao.AocLogMaster.AocLogMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocLogMasterServiceImpl<T> extends GenericsServiceImpl<T> implements AocLogMasterService<T> {
   private AocLogMasterDao<T> aocLogMasterDao;

    public AocLogMasterDao<T> getAocLogMasterDao() {
        return aocLogMasterDao;
    }

    public void setAocLogMasterDao(AocLogMasterDao<T> aocLogMasterDao) {
        this.aocLogMasterDao = aocLogMasterDao;
        setGenericsDAO(aocLogMasterDao);
        
    }

    @Override
    public List readByAocId(String id) {
        return aocLogMasterDao.readByAocId(id);
    }

    @Override
    public List readByKomid(String id) {
        return aocLogMasterDao.readByKomid(id);
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapLogMaster;

import com.bul.zydex.dao.OapLogMaster.OapLogMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapLogMasterServiceImpl<T> extends GenericsServiceImpl<T> implements OapLogMasterService<T> {

     private OapLogMasterDao<T> oapLogMasterDao;

    public OapLogMasterDao<T> getOapLogMasterDao() {
        return oapLogMasterDao;
    }

    public void setOapLogMasterDao(OapLogMasterDao<T> oapLogMasterDao) {
        this.oapLogMasterDao = oapLogMasterDao;
        setGenericsDAO(oapLogMasterDao);
        
    }

    @Override
    public List readByOapId(String id) {
        
        return oapLogMasterDao.readByOapId(id);
        
    }

    @Override
    public List readBycrcid(String id) {
         return oapLogMasterDao.readBycrcid(id);
        
        
    }
     
    
    
}

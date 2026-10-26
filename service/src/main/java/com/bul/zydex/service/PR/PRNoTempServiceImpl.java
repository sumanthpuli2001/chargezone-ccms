/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRNoTempDao;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.dao.Tender.TenderNoTempDao;
import com.bul.zydex.model.PRNoTemp;
import com.bul.zydex.model.TenderNo;
import com.bul.zydex.model.TenderNoTemp;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class PRNoTempServiceImpl<T> extends GenericsServiceImpl<T> implements PRNoTempService<T> {
    
    private PRNoTempDao<T> prNoTempDao;

    public PRNoTempDao<T> getPrNoTempDao() {
        return prNoTempDao;
    }

    public void setPrNoTempDao(PRNoTempDao<T> prNoTempDao) {
        this.prNoTempDao = prNoTempDao;
        setGenericsDAO(prNoTempDao);
    }

    @Override
    public PRNoTemp readLastRecord() {
       return prNoTempDao.readLastRecord();
    }

    @Override
    public PRNoTemp readByPRNo() {
         return prNoTempDao.readByPRNo();
    }

    
        
    

    
    
        
    

   
    
}

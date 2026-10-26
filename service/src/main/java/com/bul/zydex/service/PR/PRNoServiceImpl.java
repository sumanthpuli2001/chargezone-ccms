/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRNoDao;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.dao.Tender.TenderNoDao;
import com.bul.zydex.model.PRNo;
import com.bul.zydex.model.TenderNo;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class PRNoServiceImpl<T> extends GenericsServiceImpl<T> implements PRNoService<T> {
    
    private PRNoDao<T> prNoDao;

    public PRNoDao<T> getPrNoDao() {
        return prNoDao;
    }

    public void setPrNoDao(PRNoDao<T> prNoDao) {
        this.prNoDao = prNoDao;
        setGenericsDAO(prNoDao);
    }

    @Override
    public PRNo readByPrNo() {
        return prNoDao.readByPrNo();
    }

    
        
    
    
}

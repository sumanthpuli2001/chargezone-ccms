/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRClassificationDao;
import com.bul.zydex.model.PRClassification;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public class PRClassificationServiceImpl<T> extends GenericsServiceImpl<T> implements PRClassificationService<T> {
    
    private PRClassificationDao<T> prClassificationDao;

    public PRClassificationDao<T> getPrClassificationDao() {
        return prClassificationDao;
    }

    public void setPrClassificationDao(PRClassificationDao<T> prClassificationDao) {
        this.prClassificationDao = prClassificationDao;
        setGenericsDAO(prClassificationDao);
    }

    @Override
    public List readByGroup() {
        return prClassificationDao.readByGroup();
    }
}

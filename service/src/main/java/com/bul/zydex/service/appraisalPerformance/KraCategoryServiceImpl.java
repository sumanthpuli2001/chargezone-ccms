/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.KraCategoryDAO;
import com.bul.zydex.service.*;

/**
 *
 * @author BlackBull
 */
public class KraCategoryServiceImpl<T> extends GenericsServiceImpl<T> implements KraCategoryService<T>{
        
    private KraCategoryDAO<T> kraCategoryDAO;

    public KraCategoryDAO<T> getKraCategoryDAO() {
        return kraCategoryDAO;
    }

    public void setKraCategoryDAO(KraCategoryDAO<T> kraCategoryDAO) {
        this.kraCategoryDAO = kraCategoryDAO;
        setGenericsDAO(kraCategoryDAO);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRProjectTypeDao;
import com.bul.zydex.model.PRProjectType;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public class PRProjectTypeServiceImpl<T> extends GenericsServiceImpl<T> implements PRProjectTypeService<T> {
    
    private PRProjectTypeDao<T> prProjectTypeDao;

    public PRProjectTypeDao<T> getPrProjectTypeDao() {
        return prProjectTypeDao;
    }

    public void setPrProjectTypeDao(PRProjectTypeDao<T> prProjectTypeDao) {
        this.prProjectTypeDao = prProjectTypeDao;
        setGenericsDAO(prProjectTypeDao);
    }
}

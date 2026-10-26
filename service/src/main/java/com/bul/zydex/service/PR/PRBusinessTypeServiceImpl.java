/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRBusinessTypeDao;
import com.bul.zydex.model.PRBusinessType;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public class PRBusinessTypeServiceImpl<T> extends GenericsServiceImpl<T> implements PRBusinessTypeService<T> {
  
    private PRBusinessTypeDao<T> prBusinessTypeDao;

    public PRBusinessTypeDao<T> getPrBusinessTypeDao() {
        return prBusinessTypeDao;
    }

    public void setPrBusinessTypeDao(PRBusinessTypeDao<T> prBusinessTypeDao) {
        this.prBusinessTypeDao = prBusinessTypeDao;
        setGenericsDAO(prBusinessTypeDao);
    }
}

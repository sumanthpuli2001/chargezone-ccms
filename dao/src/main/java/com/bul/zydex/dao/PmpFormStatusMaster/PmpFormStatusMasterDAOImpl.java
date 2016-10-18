/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PmpFormStatusMaster;

import com.bul.zydex.model.PmpFormStatusMaster;
import com.bul.zydex.dao.GenericsDAOImpl;

/**
 *
 * @author BlackBull
 */
public class PmpFormStatusMasterDAOImpl<T> extends GenericsDAOImpl<T> implements PmpFormStatusMasterDAO<T>{

    @Override
    protected Class getDomainClass() {
             return PmpFormStatusMaster.class;
    }

   
}

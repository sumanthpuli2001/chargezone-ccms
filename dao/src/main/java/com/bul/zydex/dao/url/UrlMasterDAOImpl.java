/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.url;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.UrlMaster;

/**
 *
 * @author admin
 */
public class UrlMasterDAOImpl<T> extends GenericsDAOImpl<T> implements UrlMasterDAO<T>{

    @Override
    protected Class getDomainClass() {
          return UrlMaster.class;
      
    }
    
}

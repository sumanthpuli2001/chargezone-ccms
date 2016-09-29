/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.url;

import com.bul.zydex.dao.url.UrlMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author admin
 */
public class UrlMasterServiceImpl<T> extends GenericsServiceImpl<T> implements UrlMasterService<T>{
    public UrlMasterDAO<T> urlMasterDAO;

    public UrlMasterDAO<T> getUrlMasterDAO() {
        return urlMasterDAO;
    }

    public void setUrlMasterDAO(UrlMasterDAO<T> urlMasterDAO) {
        this.urlMasterDAO = urlMasterDAO;
        setGenericsDAO(urlMasterDAO);
        
    }

  
    
    
}

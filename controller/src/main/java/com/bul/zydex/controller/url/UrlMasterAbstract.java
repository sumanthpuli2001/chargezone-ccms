/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.url;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.UrlMaster;
import com.bul.zydex.service.url.UrlMasterService;

/**
 *
 * @author admin
 */
public abstract class UrlMasterAbstract extends CustomAbstract{
    public UrlMasterService<UrlMaster>urlMasterService;

    public UrlMasterService<UrlMaster> getUrlMasterService() {
        return urlMasterService;
    }

    public void setUrlMasterService(UrlMasterService<UrlMaster> urlMasterService) {
        this.urlMasterService = urlMasterService;
    }
    
    
}

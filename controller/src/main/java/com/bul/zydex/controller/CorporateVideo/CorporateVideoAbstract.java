/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.controller.CorporateVideo;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CorporateVideo;
import com.bul.zydex.service.CorporateVideo.CorporateVideoService;

/**
 *
 * @author Rishi
 */
public abstract class CorporateVideoAbstract extends CustomAbstract {
    protected CorporateVideoService<CorporateVideo> corporateVideoService;

    public CorporateVideoService<CorporateVideo> getCorporateVideoService() {
        return corporateVideoService;
    }

    public void setCorporateVideoService(CorporateVideoService<CorporateVideo> corporateVideoService) {
        this.corporateVideoService = corporateVideoService;
    }

}

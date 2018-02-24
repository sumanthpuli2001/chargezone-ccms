/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.thought;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CorporateVideo;
import com.bul.zydex.model.Gallery;
import com.bul.zydex.model.RAndR;
import com.bul.zydex.model.ThoughtMaster;
import com.bul.zydex.service.CorporateVideo.CorporateVideoService;
import com.bul.zydex.service.thought.GalleryService;
import com.bul.zydex.service.thought.RAndRService;
import com.bul.zydex.service.thought.ThoughtMasterService;

/**
 *
 * @author Rishi
 */
public abstract class ThoughtMasterAbstract extends CustomAbstract {

    protected ThoughtMasterService<ThoughtMaster> thoughtMasterService;

    protected CorporateVideoService<CorporateVideo> corporateVideoService;
    protected RAndRService<RAndR> rAndRService;
    protected GalleryService<Gallery> galleryService;

    public ThoughtMasterService<ThoughtMaster> getThoughtMasterService() {
        return thoughtMasterService;
    }

    public void setThoughtMasterService(ThoughtMasterService<ThoughtMaster> thoughtMasterService) {
        this.thoughtMasterService = thoughtMasterService;
    }

    public CorporateVideoService<CorporateVideo> getCorporateVideoService() {
        return corporateVideoService;
    }

    public void setCorporateVideoService(CorporateVideoService<CorporateVideo> corporateVideoService) {
        this.corporateVideoService = corporateVideoService;
    }

    public RAndRService<RAndR> getrAndRService() {
        return rAndRService;
    }

    public void setrAndRService(RAndRService<RAndR> rAndRService) {
        this.rAndRService = rAndRService;
    }

    public GalleryService<Gallery> getGalleryService() {
        return galleryService;
    }

    public void setGalleryService(GalleryService<Gallery> galleryService) {
        this.galleryService = galleryService;
    }

   
}

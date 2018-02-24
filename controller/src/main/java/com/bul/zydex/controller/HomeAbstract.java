/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.Gallery;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.ThoughtMaster;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.thought.GalleryService;
import com.bul.zydex.service.thought.ThoughtMasterService;

/**
 *
 * @author DELL
 */
public abstract class HomeAbstract extends CustomAbstract {

    protected LevelMasterService<LevelMaster> levelMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected ThoughtMasterService<ThoughtMaster> thoughtMasterService;
    protected GalleryService<Gallery> galleryService;

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public ThoughtMasterService<ThoughtMaster> getThoughtMasterService() {
        return thoughtMasterService;
    }

    public void setThoughtMasterService(ThoughtMasterService<ThoughtMaster> thoughtMasterService) {
        this.thoughtMasterService = thoughtMasterService;
    }

    public GalleryService<Gallery> getGalleryService() {
        return galleryService;
    }

    public void setGalleryService(GalleryService<Gallery> galleryService) {
        this.galleryService = galleryService;
    }
    
   
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.MaterialGroupMaster;

import com.bul.zydex.controller.Apprentices.*;
import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.MaterialGroupMaster;
import com.bul.zydex.service.MaterialGroupMaster.MaterialGroupMasterService;

/**
 *
 * @author Aman Bahukhandi
 */
public class MaterialGroupMasterAbstract extends CustomAbstract {

    protected MaterialGroupMasterService<MaterialGroupMaster> materialGroupMasterService;

    public MaterialGroupMasterService<MaterialGroupMaster> getMaterialGroupMasterService() {
        return materialGroupMasterService;
    }

    public void setMaterialGroupMasterService(MaterialGroupMasterService<MaterialGroupMaster> materialGroupMasterService) {
        this.materialGroupMasterService = materialGroupMasterService;
    }

}

  

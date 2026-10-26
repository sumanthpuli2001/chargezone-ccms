/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.MaterialMaster;


import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.MaterialMaster;
import com.bul.zydex.service.MaterialMaster.MaterialMasterService;

/**
 *
 * @author Aman Bahukhandi
 */
public class MaterialMasterAbstract extends CustomAbstract {

    protected MaterialMasterService<MaterialMaster> materialMasterService;
    
   // protected boolean isExist(T object);

    public MaterialMasterService<MaterialMaster> getMaterialMasterService() {
        return materialMasterService;
    }

    public void setMaterialMasterService(MaterialMasterService<MaterialMaster> materialMasterService) {
        this.materialMasterService = materialMasterService;
    }

}

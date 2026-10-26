/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.MaterialTypeMaster;

import com.bul.zydex.controller.Apprentices.*;
import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.MaterialTypeMaster;
import com.bul.zydex.service.MaterialTypeMaster.MaterialTypeMasterService;

/**
 *
 * @author Aman Bahukhandi
 */
public class MaterialTypeMasterAbstract extends CustomAbstract {
    
     protected MaterialTypeMasterService<MaterialTypeMaster> materialTypeMasterService;

    public MaterialTypeMasterService<MaterialTypeMaster> getMaterialTypeMasterService() {
        return materialTypeMasterService;
    }

    public void setMaterialTypeMasterService(MaterialTypeMasterService<MaterialTypeMaster> materialTypeMasterService) {
        this.materialTypeMasterService = materialTypeMasterService;
    }

}

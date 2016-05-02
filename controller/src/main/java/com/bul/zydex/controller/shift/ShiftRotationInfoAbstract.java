/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.service.shift.ShiftRotationInfoService;

/**
 *
 * @author AJAY
 */
public class ShiftRotationInfoAbstract extends CustomAbstract {

    protected ShiftRotationInfoService<ShiftRotationInfo> shiftRotationInfoService;

    public ShiftRotationInfoService<ShiftRotationInfo> getShiftRotationInfoService() {
        return shiftRotationInfoService;
    }

    public void setShiftRotationInfoService(ShiftRotationInfoService<ShiftRotationInfo> shiftRotationInfoService) {
        this.shiftRotationInfoService = shiftRotationInfoService;
    }

}

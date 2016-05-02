/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.service.shift.ShiftGenerateMonthlyScheduleService;
import com.bul.zydex.service.shift.ShiftRotationMasterService;

/**
 *
 * @author AJAY
 */
public abstract class ShiftGenerateMonthlyScheduleAbstract extends CustomAbstract {

    private ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService;
    protected ShiftRotationMasterService<ShiftRotationMaster> shiftRotationMasterService;

    public ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> getShiftGenerateMonthlyScheduleService() {
        return shiftGenerateMonthlyScheduleService;
    }

    public void setShiftGenerateMonthlyScheduleService(ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService) {
        this.shiftGenerateMonthlyScheduleService = shiftGenerateMonthlyScheduleService;
    }

    public ShiftRotationMasterService<ShiftRotationMaster> getShiftRotationMasterService() {
        return shiftRotationMasterService;
    }

    public void setShiftRotationMasterService(ShiftRotationMasterService<ShiftRotationMaster> shiftRotationMasterService) {
        this.shiftRotationMasterService = shiftRotationMasterService;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.RotationMaster;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.service.shift.RotationMasterService;
import com.bul.zydex.service.shift.ShiftGenerateMonthlyScheduleService;
import com.bul.zydex.service.shift.ShiftMasterService;
import com.bul.zydex.service.shift.ShiftRotationInfoService;
import com.bul.zydex.service.shift.ShiftRotationMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author AJAY
 */
public class ShiftRotationInfoAbstract extends CustomAbstract {

    protected ShiftRotationInfoService<ShiftRotationInfo> shiftRotationInfoService;
    protected ShiftRotationMasterService<ShiftRotationMaster> shiftRotationMasterService;
    protected ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService;
    protected RotationMasterService<RotationMaster> rotationMasterService;
    protected ShiftMasterService<ShiftMaster> shiftMasterService;
    
    public ShiftRotationInfoService<ShiftRotationInfo> getShiftRotationInfoService() {
        return shiftRotationInfoService;
    }

    public void setShiftRotationInfoService(ShiftRotationInfoService<ShiftRotationInfo> shiftRotationInfoService) {
        this.shiftRotationInfoService = shiftRotationInfoService;
    }
    
    public ShiftRotationMasterService<ShiftRotationMaster> getShiftRotationMasterService() {
        return shiftRotationMasterService;
    }

    public void setShiftRotationMasterService(ShiftRotationMasterService<ShiftRotationMaster> shiftRotationMasterService) {
        this.shiftRotationMasterService = shiftRotationMasterService;
    }
    
    protected void shiftRotaionList(HttpServletRequest request) {
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        List<?> shift = shiftRotationInfoService.readShiftRotationMaster();//shiftRotationMasterService.read();

        Map<Integer, String> rotationMap = new HashMap<>();
        for (Object o : shift) {
            shiftRotationMaster = (ShiftRotationMaster) o;
            rotationMap.put(shiftRotationMaster.getId(), shiftRotationMaster.getTitle());
        }
        request.setAttribute("rotationMap", rotationMap);
    }
    
    public ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> getShiftGenerateMonthlyScheduleService() {
        return shiftGenerateMonthlyScheduleService;
    }

    public void setShiftGenerateMonthlyScheduleService(ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService) {
        this.shiftGenerateMonthlyScheduleService = shiftGenerateMonthlyScheduleService;
    }
    
    public RotationMasterService<RotationMaster> getRotationMasterService() {
        return rotationMasterService;
    }

    public void setRotationMasterService(RotationMasterService<RotationMaster> rotationMasterService) {
        this.rotationMasterService = rotationMasterService;
    }
    
    public ShiftMasterService<ShiftMaster> getShiftMasterService() {
        return shiftMasterService;
    }

    public void setShiftMasterService(ShiftMasterService<ShiftMaster> shiftMasterService) {
        this.shiftMasterService = shiftMasterService;
    }
    
   
}

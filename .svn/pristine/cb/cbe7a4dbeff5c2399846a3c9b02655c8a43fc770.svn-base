/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.attendanceRegularization;

import com.bul.zydex.controller.*;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.attendanceRegularization.TimeAttandanceFlaxibleMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Dhaval Patel
 */
public class TimeAttandanceFlaxibleMasterAbstract extends CustomAbstract {

    protected TimeAttandanceFlaxibleMasterService<TimeAttandanceFlaxibleMaster> timeAttandanceFlaxibleMasterService;
    protected Validator timeAttendanceFlexibleValidator;

    public TimeAttandanceFlaxibleMasterService<TimeAttandanceFlaxibleMaster> getTimeAttandanceFlaxibleMasterService() {
        return timeAttandanceFlaxibleMasterService;
    }

    public void setTimeAttandanceFlaxibleMasterService(TimeAttandanceFlaxibleMasterService<TimeAttandanceFlaxibleMaster> timeAttandanceFlaxibleMasterService) {
        this.timeAttandanceFlaxibleMasterService = timeAttandanceFlaxibleMasterService;
    }

    public Validator getTimeAttendanceFlexibleValidator() {
        return timeAttendanceFlexibleValidator;
    }

    public void setTimeAttendanceFlexibleValidator(Validator timeAttendanceFlexibleValidator) {
        this.timeAttendanceFlexibleValidator = timeAttendanceFlexibleValidator;
    }

    protected void setZydexLocationList(HttpServletRequest request) {
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        List<?> zydexLocationList = zydexLocationMasterService.read();

        Map<Integer, String> zydexLocationMap = new HashMap<>();
        for (Object o : zydexLocationList) {
            zydexLocationMaster = (ZydexLocationMaster) o;
            zydexLocationMap.put(zydexLocationMaster.getId(), zydexLocationMaster.getZydexLocation());
        }
        request.setAttribute("zydexLocationMap", zydexLocationMap);
    }
}

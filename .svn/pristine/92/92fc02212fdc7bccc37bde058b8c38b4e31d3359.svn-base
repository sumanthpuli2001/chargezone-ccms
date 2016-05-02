/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.UserMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class ShiftRotationInfoController extends ShiftRotationInfoAbstract {

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        ShiftRotationInfo shiftRotationInfo1 = new ShiftRotationInfo();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getAttribute("employeeMaster");
        UserMaster userMaster = (UserMaster) request.getAttribute("userMaster");
        String shiftMasterId = request.getAttribute("shiftMasterId").toString();
        if (!"".equals(shiftMasterId)) {

            shiftRotationInfo.setFirstShiftId(Integer.parseInt(shiftMasterId));
            shiftRotationInfo.setUserMaster(userMaster);

            List<?> list = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
            if (!list.isEmpty()) {

                shiftRotationInfo = (ShiftRotationInfo) list.get(0);
            }
            if (shiftRotationInfo.getId() == null) {
                shiftRotationMaster.setId(employeeMaster.getShiftHoursId());
                shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
                shiftRotationInfo.setRotationDate(employeeMaster.getShiftRotationDate());

                shiftRotationInfoService.create(shiftRotationInfo);
                mv.setViewName("Employee/EmployeeRegistrationForm");
            } else {
                shiftRotationInfo.setFirstShiftId(Integer.parseInt(shiftMasterId));
                request.setAttribute("successMessage",
                        "Information : The Information is updated Successfully.");
                shiftRotationInfoService.update(shiftRotationInfo);
                mv.setViewName("Employee/EditUserProfile");
            }
        } else {
            request.setAttribute("failureMessage",
                    "Error : Please Select First Shift Name.");
            mv.setViewName("Employee/EditUserProfile");

        }

        return mv;
    }

    public ModelAndView viewRotationClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        UserMaster userMaster = new UserMaster();
        String id = request.getParameter("id");
        userMaster.setId(Integer.parseInt(id));
        shiftRotationInfo.setUserMaster(userMaster);
        List<?> list = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
        if (!list.isEmpty()) {

            shiftRotationInfo = (ShiftRotationInfo) list.get(0);
            shiftRotationInfo = shiftRotationInfoService.readById(shiftRotationInfo.getId());
        }
        mv.getModelMap().put("shiftRotationInfo", shiftRotationInfo);
        mv.setViewName("Shift/ShiftRotationInfoView");
        return mv;
    }

    public ModelAndView editRotationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();

        return mv;
    }

}

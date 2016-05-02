/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Position;

import com.bul.zydex.model.PositionReferMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan
 */
public class PositionReferMasterController extends PositionReferMasterAbstract{

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, PositionReferMaster positionReferMaster) throws Exception {
        List<?> positionList = positionReferMasterService.read();
        return new ModelAndView("Position/PositionList", "positionList", positionList);
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, PositionReferMaster positionReferMaster) throws Exception {
        return new ModelAndView("Position/PositionCreate", "positionReferMaster", positionReferMaster);

    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, PositionReferMaster positionReferMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        bind(request, positionReferMaster);
        BindException errors = new BindException(positionReferMaster, "positionReferMaster");
        positionReferMasterValidator.validate(positionReferMaster, errors);
        if (errors.hasErrors()) {
            if (errors.hasFieldErrors("location")) {
                mv.addObject("failureMessage", "Error : Information Is Not Valid.");
                mv.addAllObjects(errors.getModel());
                mv.setViewName("Position/PositionCreate");
            }
        } else {
            if (positionReferMasterService.isExist(positionReferMaster)) {
                positionReferMasterService.createOrUpdate(positionReferMaster);
                List<?> positionList = positionReferMasterService.read();
                mv.addObject("positionList", positionList);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv.setViewName("Position/PositionList");
            } else {
                mv.setViewName("Position/PositionCreate");
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
            }
        }
        mv.getModelMap().put("positionReferMaster", positionReferMaster);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, PositionReferMaster positionReferMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
//        List<String> checkIdList = Arrays.asList(checkId);
//            checkIdList.forEach((checkedValues) -> departmentMasterService.delete(Integer.parseInt(checkedValues)));
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                positionReferMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    positionReferMaster = positionReferMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += positionReferMaster.getPositionName();
                    } else {
                        checkStr += "," + positionReferMaster.getPositionName();
                    }
                    count++;
                    flag = true;
                } catch (Exception ee) {

                }
            }
        }
        if (flag) {
            mv.addObject("failureMessage", "Error : In Use, Can't Be Deleted.....  " + "<b>" + checkStr + "</b>");
        } else {
            mv.addObject("successMessage", "Information Is Deleted Successfully.");
        }
        mv.setViewName("forward:positionReferMaster.htm?act=showList");
        return mv;
    }

//    public ModelAndView hrDashboard(HttpServletRequest request, HttpServletResponse response, PositionReferMaster positionReferMaster) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List iterateEmployee = locationMasterService.readEmpByLocation();
//        StringBuilder sb = new StringBuilder();
//        sb.append("");
//        for (Object o : iterateEmployee) {
//            Object[] temparray = (Object[]) o;
//            sb.append("['").append(temparray[0]).append("', ").append(temparray[1]).append("],");
//        }
//        String locationWiseEmployeeString= sb.toString();
//        if (locationWiseEmployeeString.length()>1) {
//        mv.addObject("locationWiseEmployee", sb.toString().substring(0, sb.toString().length() - 1));
//        }
//        mv.setViewName("forward:departmentMaster.htm?act=hrDashboardResignation");
//        return mv;
//    }

}

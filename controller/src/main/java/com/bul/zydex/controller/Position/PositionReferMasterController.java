/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Position;

import com.bul.zydex.model.EmployeeReferral;
import com.bul.zydex.model.PositionReferMaster;
import com.bul.zydex.service.empreferral.EmployeeReferralService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan
 */
public class PositionReferMasterController extends PositionReferMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, PositionReferMaster positionReferMaster) throws Exception {
        List<?> positionList = positionReferMasterService.readPositionData();
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
//            if (errors.hasFieldErrors("location")) {
                mv.addObject("failureMessage", "Error : Information Is Not Valid.");
                mv.addAllObjects(errors.getModel());
                mv.setViewName("Position/PositionCreate");
//            }
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
        ModelAndView mv = new ModelAndView();
        for (String checkedValues : checkId) {
            try {
                positionReferMaster = positionReferMasterService.readById(Integer.parseInt(checkedValues));
                positionReferMaster.setStatus(true);
                positionReferMasterService.update(positionReferMaster);
            } catch (Exception e) {

            }
        }
        mv.addObject("successMessage", "Information Is Deleted Successfully.");
        mv.setViewName("forward:positionReferMaster.htm?act=showList");
        return mv;
    }

}

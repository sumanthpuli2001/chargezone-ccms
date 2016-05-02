/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emp;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.LevelMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
public class DesignationMasterController extends DesignationMasterAbstract {

    public ModelAndView createOrUpdateClick(HttpServletRequest request, HttpServletResponse response, DesignationMaster designationMaster) throws Exception {
        if (designationMaster.getId() != null) {
            designationMaster = designationMasterService.readById(designationMaster.getId());
            designationMaster.setLevelMaster(designationMaster.getLevelMaster());
        } else {
            designationMaster.setLevelMaster(new LevelMaster());
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("levelMasterMap", getLevelMasterMap(request));
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.setViewName("Designation/DesignationCreate");
        return mv;

    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, DesignationMaster designationMaster) throws Exception {
        List<?> designationList = designationMasterService.readDesignationAndLevel();
        return new ModelAndView("Designation/DesignationList", "designationList", designationList);

    }

    public ModelAndView createOrUpdateSubmit(HttpServletRequest request, HttpServletResponse response, DesignationMaster designationMaster) throws Exception {
        BindException errors = new BindException(designationMaster, "designationMaster");
        ModelAndView mv = new ModelAndView();
        bind(request, designationMaster);
        designationMasterValidator.validate(designationMaster, errors);
        mv.addObject("levelMasterMap", getLevelMasterMap(request));
        if (errors.hasErrors()) {
            mv.addObject("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Designation/DesignationCreate");
        } else {
            if (designationMaster.getId() == null && !designationMasterService.isExist(designationMaster)) {
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
                mv.setViewName("Designation/DesignationCreate");

            } else {
                designationMasterService.createOrUpdate(designationMaster);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                List<?> designationList = designationMasterService.readDesignationAndLevel();
                mv.addObject("designationList", designationList);
                mv.setViewName("Designation/DesignationList");
            }
        }
        mv.getModelMap().put("designationMaster", designationMaster);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, DesignationMaster designationMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
//        List<String> checkIdList = Arrays.asList(checkId);
//            checkIdList.forEach((checkedValues) -> departmentMasterService.delete(Integer.parseInt(checkedValues)));
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                designationMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    designationMaster = designationMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += designationMaster.getDesignationName();
                    } else {
                        checkStr += "," + designationMaster.getDesignationName();
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
        List<?> designationList = designationMasterService.readDesignationAndLevel();
        mv.addObject("designationList", designationList);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.setViewName("Designation/DesignationList");
        return mv;
    }

}

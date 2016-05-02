/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.ShortLeave;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.validator.leave.CoffMasterValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dhaval Patel <dhaval217@gmail.com>
 */
public class CoffMasterController extends CoffMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       COffLeaveMaster cOffLeaveMaster=new COffLeaveMaster();
        cOffLeaveMaster.setZydexLocationMaster(new ZydexLocationMaster());
        zydexLocationList(request);
        mv.getModelMap().put("cOffLeaveMaster", cOffLeaveMaster);
        mv.setViewName("Leave/CoffLeaveMasterCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
           COffLeaveMaster cOffLeaveMaster=new COffLeaveMaster();
        BindException errors = new BindException(cOffLeaveMaster, "cOffLeaveMaster");
        bind(request, cOffLeaveMaster);
        CoffMasterValidator.validate(cOffLeaveMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = createClick(request, response);
        } else {
            if (!cOffLeaveMasterService.isExist(cOffLeaveMaster)) {
                cOffLeaveMasterService.create(cOffLeaveMaster);
                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");
                mv.setViewName("redirect:coffMaster.htm?act=searchSubmit");
            } else {
                request.setAttribute("failureMessage",
                        "Information : The Information is Already Exist.");
                mv = createClick(request, response);
            }
        }

        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> coffLeaveList = cOffLeaveMasterService.read();
        for (Object o1 : coffLeaveList) {
            COffLeaveMaster cOffLeaveMaster=new COffLeaveMaster();
            cOffLeaveMaster = (COffLeaveMaster) o1;
            cOffLeaveMaster.setZydexLocationMaster(
                    zydexLocationMasterService.readById(Integer.parseInt("" + cOffLeaveMaster.getZydexLocationMaster().getId())));
            mv.getModelMap().put("cOffLeaveMaster", cOffLeaveMaster);
        }

        mv.getModelMap().put("list", coffLeaveList);
        mv.setViewName("Leave/CoffLeaveResult");

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       COffLeaveMaster cOffLeaveMaster=new COffLeaveMaster();
        String id = request.getParameter("id");
        cOffLeaveMaster = cOffLeaveMasterService.readById(Integer.parseInt(id));
        cOffLeaveMaster.setZydexLocationMaster(
                zydexLocationMasterService.readById(Integer.parseInt("" + cOffLeaveMaster.getZydexLocationMaster().getId())));
        mv.getModelMap().put("cOffLeaveMaster", cOffLeaveMaster);
        mv.setViewName("Leave/CoffLeaveView");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       COffLeaveMaster cOffLeaveMaster=new COffLeaveMaster();
        BindException errors = new BindException(cOffLeaveMaster, "cOffLeaveMaster");
        cOffLeaveMaster.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, cOffLeaveMaster);
    CoffMasterValidator.validate(cOffLeaveMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = viewClick(request, response);
        } else {
            cOffLeaveMasterService.update(cOffLeaveMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = searchSubmit(request, response);
        }

        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String leaveTypeId[] = request.getParameterValues("checkId");
        for (String z : leaveTypeId) {
            try {
                cOffLeaveMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

}

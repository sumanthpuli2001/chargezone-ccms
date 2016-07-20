/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.zydexLocation;

import com.bul.zydex.model.ZydexLocationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan
 */
public class ZydexLocationMasterController extends ZydexLocationMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, ZydexLocationMaster zydexLocationMaster) throws Exception {
        List<?> zydexLocationList = zydexLocationMasterService.read();
        return new ModelAndView("ZydexLocation/ZydexLocationList", "zydexLocationList", zydexLocationList);
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, ZydexLocationMaster zydexLocationMaster) throws Exception {
         if (zydexLocationMaster.getId() != null) {
            zydexLocationMaster = zydexLocationMasterService.readById(zydexLocationMaster.getId());
        }
        return new ModelAndView("ZydexLocation/ZydexLocationCreate", "zydexLocationMaster", zydexLocationMaster);

    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, ZydexLocationMaster zydexLocationMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        bind(request, zydexLocationMaster);
        BindException errors = new BindException(zydexLocationMaster, "zydexLocationMaster");
        zydexLocationMasterValidator.validate(zydexLocationMaster, errors);
        if (errors.hasErrors()) {
                mv.addObject("failureMessage", "Error : Information Is Not Valid.");
                mv.addAllObjects(errors.getModel());
                mv.setViewName("ZydexLocation/ZydexLocationCreate");
        } else {
            if (zydexLocationMasterService.isExist(zydexLocationMaster)) {
                zydexLocationMasterService.createOrUpdate(zydexLocationMaster);
                List<?> zydexLocationList = zydexLocationMasterService.read();
                mv.addObject("zydexLocationList", zydexLocationList);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv.setViewName("ZydexLocation/ZydexLocationList");
            } else {
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
                mv.setViewName("ZydexLocation/ZydexLocationCreate");
            }
        }
        mv.getModelMap().put("zydexLocationMaster", zydexLocationMaster);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, ZydexLocationMaster zydexLocationMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
//        List<String> checkIdList = Arrays.asList(checkId);
//            checkIdList.forEach((checkedValues) -> departmentMasterService.delete(Integer.parseInt(checkedValues)));
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                zydexLocationMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    zydexLocationMaster = zydexLocationMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += zydexLocationMaster.getZydexLocation();
                    } else {
                        checkStr += "," + zydexLocationMaster.getZydexLocation();
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
        mv.setViewName("forward:zydexLocationMaster.htm?act=showList");
        return mv;
    }

}

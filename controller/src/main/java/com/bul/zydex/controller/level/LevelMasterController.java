/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.level;

import com.bul.zydex.model.LevelMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class LevelMasterController extends LevelMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, LevelMaster levelMaster) throws Exception {
        ModelAndView mv = new ModelAndView("Level/LevelList", "levelMaster", levelMaster);
        List<?> levelList = levelMasterService.read();
        mv.addObject("levelList", levelList);
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, LevelMaster levelMaster) throws Exception {
         if (levelMaster.getId() != null) {
            levelMaster = levelMasterService.readById(levelMaster.getId());
        }
        return new ModelAndView("Level/LevelCreate", "levelMaster", levelMaster);
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, LevelMaster levelMaster) throws Exception {
        BindException errors = new BindException(levelMaster, "levelMaster");
        bind(request, levelMaster);
        levelMasterValidator.validate(levelMaster, errors);
        ModelAndView mv = new ModelAndView();
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Level/LevelCreate");
        } else {
            if (levelMasterService.isExist(levelMaster)) {
                levelMasterService.createOrUpdate(levelMaster);
                List<?> levelList = levelMasterService.read();
                mv.addObject("levelList", levelList);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv.setViewName("Level/LevelList");
            } else {
                mv.setViewName("Level/LevelCreate");
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
            }
        }
        mv.getModelMap().put("levelMaster", levelMaster);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, LevelMaster levelMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
//        List<String> checkIdList = Arrays.asList(checkId);
//            checkIdList.forEach((checkedValues) -> departmentMasterService.delete(Integer.parseInt(checkedValues)));
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                levelMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    levelMaster = levelMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += levelMaster.getLevel();
                    } else {
                        checkStr += "," + levelMaster.getLevel();
                    }
                    count++;
                    flag = true;
                } catch (Exception ee) {

                }
            }
        }
        if (flag) {
            request.setAttribute("failureMessage", "Error : In Use, Can't Be Deleted.....  " + "<b>" + checkStr + "</b>");
        } else {
            request.setAttribute("successMessage", "Information Is Deleted Successfully.");
        }
        mv.setViewName("forward:levelMaster.htm?act=showList");
        return mv;
    }
}

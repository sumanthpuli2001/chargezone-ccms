/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.attendanceRegularization;

import com.bul.zydex.model.ClientDetailsMaster;
import com.bul.zydex.model.LocationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Teja
 */
public class ClientDetailsMasterController extends ClientDetailsMasterAbstract
{
    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, ClientDetailsMaster clientDetailsMaster) throws Exception {
        List<?> clientList = clientDetailsMasterService.read();
        return new ModelAndView("AttendanceRegularization/ClientDetailsMasterList", "clientList", clientList);
    }
    
    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, ClientDetailsMaster clientDetailsMaster) throws Exception {
         if (clientDetailsMaster.getId() != null) {
            clientDetailsMaster = clientDetailsMasterService.readById(clientDetailsMaster.getId());
        }
        return new ModelAndView("AttendanceRegularization/ClientDetailsMasterCreate", "clientDetailsMaster", clientDetailsMaster);

    }
    
    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, ClientDetailsMaster clientDetailsMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        bind(request, clientDetailsMaster);
            if (clientDetailsMasterService.isExist(clientDetailsMaster)) {
                clientDetailsMasterService.createOrUpdate(clientDetailsMaster);
                List<?> clientList = clientDetailsMasterService.read();
                mv.addObject("clientList", clientList);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv.setViewName("AttendanceRegularization/ClientDetailsMasterList");
            } else {
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
                mv.setViewName("AttendanceRegularization/ClientDetailsMasterCreate");
            }
        
        mv.getModelMap().put("clientDetailsMaster", clientDetailsMaster);
        return mv;
    }
    
    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, ClientDetailsMaster clientDetailsMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
//        List<String> checkIdList = Arrays.asList(checkId);
//            checkIdList.forEach((checkedValues) -> departmentMasterService.delete(Integer.parseInt(checkedValues)));
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                clientDetailsMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    clientDetailsMaster = clientDetailsMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += clientDetailsMaster.getClientName();
                    } else {
                        checkStr += "," + clientDetailsMaster.getClientName();
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
        mv.setViewName("forward:clientDetailsMaster.htm?act=showList");
        return mv;
    }
}

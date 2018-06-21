/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ProjectManagement;

import com.bul.zydex.model.ClientMaster;
import com.bul.zydex.model.StateMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman
 */
public class ProjectManagementController extends ProjectManagementAbstract {

    public ModelAndView projectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ProjectManagement/projectList");
        return mv;
    }

    public ModelAndView createProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ProjectManagement/createProject");
        return mv;
    }

    public ModelAndView taskList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ProjectManagement/taskList");
        return mv;
    }

    public ModelAndView createTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ProjectManagement/createTask");
        return mv;
    }

    public ModelAndView clientList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list = clientMasterService.readClientMaster();
        mv.getModelMap().put("list", list);
        mv.setViewName("ProjectManagement/clientList");
        return mv;
    }

    public ModelAndView createClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClientMaster clientMaster = new ClientMaster();
        mv.getModelMap().put("clientMaster", clientMaster);
        mv.setViewName("ProjectManagement/createClient");
        return mv;
    }

    public ModelAndView stateList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list = stateMasterService.readStateMaster();
        request.setAttribute("list", list);
        mv.setViewName("ProjectManagement/stateList");
        return mv;
    }

    public ModelAndView createState(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        StateMaster stateMaster = new StateMaster();
        mv.getModelMap().put("stateMaster", stateMaster);
        mv.setViewName("ProjectManagement/createState");
        return mv;
    }

    public ModelAndView submitClient(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClientMaster clientMaster = new ClientMaster();
        BindException errors = new BindException(clientMaster, "clientMaster");
        bind(request, clientMaster);

        if (clientMaster.getId() == null) {
            clientMasterService.create(clientMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is updated Successfully.");
        } else {
            clientMasterService.update(clientMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is updated Successfully.");
        }

        mv = clientList(request, response);
        return mv;
    }

    public ModelAndView editClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClientMaster clientMaster = new ClientMaster();
        String id = request.getParameter("id");
        clientMaster = clientMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("clientMaster", clientMaster);
        mv.setViewName("ProjectManagement/createClient");
        return mv;

    }

    public ModelAndView deleteClientMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
                ClientMaster clientMaster = new ClientMaster();
                List<?> list = clientMasterService.deleteClientMaster(z);
                for (Object object : list) {
                    clientMaster = (ClientMaster) object;
                    clientMasterService.delete(clientMaster.getId());
                }
                clientMasterService.delete(Integer.parseInt(z));
            } catch (Exception e) {
            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv = clientList(request, response);
        return mv;
    }

    public ModelAndView submitState(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        StateMaster stateMaster = new StateMaster();
        BindException errors = new BindException(stateMaster, "stateMaster");
        bind(request, stateMaster);

        if (stateMaster.getId() == null) {
            stateMasterService.create(stateMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is updated Successfully.");
        } else {
            stateMasterService.update(stateMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is updated Successfully.");
        }

        mv = stateList(request, response);
        return mv;
    }
     public ModelAndView editState(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       StateMaster stateMaster = new StateMaster();
        String id = request.getParameter("id");
        stateMaster = stateMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("stateMaster", stateMaster);
        mv.setViewName("ProjectManagement/createState");
        return mv;

    }

}

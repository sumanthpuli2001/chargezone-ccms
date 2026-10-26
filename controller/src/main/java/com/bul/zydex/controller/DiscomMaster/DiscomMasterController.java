/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.DiscomMaster;

import com.bul.zydex.model.CompanyLocation;
import com.bul.zydex.model.DiscomMaster;
import com.bul.zydex.model.UserMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class DiscomMasterController extends DiscomMasterAbstract {

    public ModelAndView showlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }
        mv.setViewName("DiscomMaster/showlist");
        return mv;
    }

    public ModelAndView discomMasterAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "2":
                    orderColumn = "discomType";
                    break;
                case "3":
                    orderColumn = "state";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = discomMasterService.getDiscomMasterPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = discomMasterService.getTotalDiscomMasterCount();
        int filteredRecords = discomMasterService.getFilteredDiscomMasterCount(searchValue);
        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            DiscomMaster discomMaster = (DiscomMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + discomMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("discomType", discomMaster.getDiscomType());
            json.put("state", discomMaster.getState());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='discomMaster.htm?act=DiscomMasterEdit&id="
                    + discomMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + discomMaster.getId() + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );
            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }

    public ModelAndView DiscomMasterCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }

        List list = companyLocationService.read();
        mv.getModelMap().put("list", list);

        mv.setViewName("DiscomMaster/DiscomMasterCreate");
        return mv;
    }

    public ModelAndView submitDiscomMasterCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        DiscomMaster discomMaster = new DiscomMaster();
        String discomtype = request.getParameter("discomtype");
        String state = request.getParameter("state");
        discomMaster.setDiscomType(discomtype);
        discomMaster.setState(state);

        if (discomMasterService.isExist(discomMaster)) {
            discomMasterService.create(discomMaster);
            
            session.setAttribute("successMessage", "Discom Master Created Successfully.");
            mv.setViewName("redirect:discomMaster.htm?act=showlist");
            
        } else {

            session.setAttribute("failureMessage", "Discom type With this State Already Exist. Please enter new Discom");
            mv.setViewName("redirect:discomMaster.htm?act=DiscomMasterCreate");
        }

        return mv;
    }

    public ModelAndView deleteDiscomMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            discomMasterService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:discomMaster.htm?act=showlist");
        return mv;

    }

    public ModelAndView deleteDiscomById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            discomMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }
        mv.setViewName("redirect:discomMaster.htm?act=showlist");
        return mv;
    }

    public ModelAndView DiscomMasterEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(id));
        String State = discomMaster.getState();

        List list = companyLocationService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("discomMaster", discomMaster);
        mv.getModelMap().put("State", State);

        mv.setViewName("DiscomMaster/DiscomMasterEdit");
        return mv;
    }

    public ModelAndView DiscomMasterEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String discomtype = request.getParameter("discomtype");
        String state = request.getParameter("state");
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(id));
        discomMaster.setDiscomType(discomtype);
        discomMaster.setState(state);
        discomMasterService.update(discomMaster);
        session.setAttribute("successMessage", "DiscomMaster edit successfully");

        mv.setViewName("redirect:discomMaster.htm?act=showlist");
        return mv;
    }
}

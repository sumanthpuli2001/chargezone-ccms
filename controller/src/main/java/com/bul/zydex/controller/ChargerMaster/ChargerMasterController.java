/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ChargerMaster;

import com.bul.zydex.model.ChargerMaster;
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
 * @author Sumanth
 */
public class ChargerMasterController extends ChargerMasterAbstract {

    public ModelAndView ChargerMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
        mv.setViewName("ChargerMaster/ChargerMasterList");
        return mv;
    }

    public ModelAndView ChargerMasterCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("ChargerMaster/ChargerMasterCreate");
        return mv;
    }

    public ModelAndView submitChargerMasterCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        
        String chargerMaster = request.getParameter("chargerMaster");

        ChargerMaster chargerMaster1 = new ChargerMaster();

        chargerMaster1.setChargerMaster(chargerMaster);

        if (!chargerMasterService.isExist(chargerMaster1)) {
            chargerMasterService.create(chargerMaster1);

            session1.setAttribute("successMessage", "Charger Master Created Successfully");
            mv.setViewName("redirect:chargerMaster.htm?act=ChargerMasterList");

        } else {

            session1.setAttribute("failureMessage", "Charger Master Already Exist. Please Enter Charger Master");
            mv.setViewName("redirect:chargerMaster.htm?act=ChargerMasterCreate");
        }

        return mv;

    }

    public ModelAndView ChargerMasterEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        ChargerMaster chargerMaster = chargerMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("chargerMaster", chargerMaster);
        mv.getModelMap().put("id", id);
        mv.setViewName("ChargerMaster/ChargerMasterEdit");

        return mv;

    }

    public ModelAndView ChargerMasterEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String chargerMaster = request.getParameter("chargerMaster");

        ChargerMaster chargerMaster1 = chargerMasterService.readById(Integer.parseInt(id));
        chargerMaster1.setChargerMaster(chargerMaster);
        chargerMasterService.update(chargerMaster1);

        session1.setAttribute("successMessage", "Charger Master Edited successfully");
        mv.setViewName("redirect:chargerMaster.htm?act=ChargerMasterList");

        return mv;
    }

    public ModelAndView deleteChargerMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String id = request.getParameter("id");

        ChargerMaster chargerMaster1 = chargerMasterService.readById(Integer.parseInt(id));

        chargerMasterService.delete(Integer.parseInt(id));

        mv.setViewName("redirect:chargerMaster.htm?act=ChargerMasterList");

        return mv;
    }

    public ModelAndView deleteChargerMasterMulti(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            chargerMasterService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:chargerMaster.htm?act=ChargerMasterList");

        return mv;
    }

     public ModelAndView ChargerMasterPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "chargerMaster";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = chargerMasterService.getChargerMasterPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = chargerMasterService.getTotalChargerMasterCount();

        int filteredRecords = chargerMasterService.getFilteredChargerMasterCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            ChargerMaster chargerMaster = (ChargerMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + chargerMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("chargerMaster", chargerMaster.getChargerMaster());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='chargerMaster.htm?act=ChargerMasterEdit&id="
                    + chargerMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + chargerMaster.getId() + "'>"
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
    
    
    
}

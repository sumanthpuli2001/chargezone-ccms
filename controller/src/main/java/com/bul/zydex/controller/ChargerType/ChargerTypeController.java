/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ChargerType;

import com.bul.zydex.model.ChargerType;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.ChargerType.ChargerTypeService;
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
public class ChargerTypeController extends ChargerTypeAbstract {

    public ModelAndView ChargerTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {

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


        mv.setViewName("ChargerType/ChargerTypeList");
        return mv;

    }

    public ModelAndView ChargerTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("ChargerType/ChargerTypeCreate");
        return mv;
    }

    public ModelAndView submitChargerTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String chargerType = request.getParameter("chargerType");

        ChargerType chargerType1 = new ChargerType();

        chargerType1.setChargerType(chargerType);

        if (!chargerTypeService.isExist(chargerType1)) {
            chargerTypeService.create(chargerType1);

            session1.setAttribute("successMessage", "Charger Type Created Successfully");
            mv.setViewName("redirect:chargerType.htm?act=ChargerTypeList");

        } else {

            session1.setAttribute("failureMessage", "Charger Type Already Exist. Please Enter Charger Type");
            mv.setViewName("redirect:chargerType.htm?act=ChargerTypeCreate");
        }

        return mv;

    }

    public ModelAndView ChargerTypeEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        String id = request.getParameter("id");

        ChargerType chargerType = chargerTypeService.readById(Integer.parseInt(id));

        mv.getModelMap().put("chargerType", chargerType);
        mv.getModelMap().put("id", id);
        mv.setViewName("ChargerType/ChargerTypeEdit");

        return mv;

    }

    public ModelAndView ChargerTypeEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);

        String chargerType = request.getParameter("chargerType");

        ChargerType chargerType1 = chargerTypeService.readById(Integer.parseInt(id));
        chargerType1.setChargerType(chargerType);
        chargerTypeService.update(chargerType1);

        session1.setAttribute("successMessage", " Charger Type Edited successfully");
        mv.setViewName("redirect:chargerType.htm?act=ChargerTypeList");

        return mv;
    }

    public ModelAndView deleteChargerTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        ChargerType chargerType1 = chargerTypeService.readById(Integer.parseInt(id));

        chargerTypeService.delete(Integer.parseInt(id));

        mv.setViewName("redirect:chargerType.htm?act=ChargerTypeList");

        return mv;
    }

    public ModelAndView deleteChargerTypeMulti(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            chargerTypeService.delete(Integer.parseInt(checkedValues));
        }

        session1.setAttribute("successMessage", " Charger Type Deleted successfully");

        mv.setViewName("redirect:chargerType.htm?act=ChargerTypeList");

        return mv;
    }

    public ModelAndView ChargerPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "chargerType";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = chargerTypeService.getChargerPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = chargerTypeService.getTotalChargerCount();

        int filteredRecords = chargerTypeService.getFilteredChargerCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            ChargerType chargerType = (ChargerType) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + chargerType.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("chargerType", chargerType.getChargerType());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='chargerType.htm?act=ChargerTypeEdit&id="
                    + chargerType.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + chargerType.getId() + "'>"
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

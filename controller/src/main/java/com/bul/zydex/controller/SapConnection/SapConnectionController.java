/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.SapConnection;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PlantMaster;
import com.bul.zydex.model.SapConnection;
import com.bul.zydex.model.UserMaster;
import java.security.Provider.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class SapConnectionController extends SapConnectionAbstract {

    public ModelAndView sapList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        SapConnection sapConnection = new SapConnection();
        List list = sapConnectionService.read();
        request.setAttribute("list", list);
        mv.getModelMap().put("sapConnection", sapConnection);

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

        mv.setViewName("sap/SapList");
        return mv;
    }

    public ModelAndView sapCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("sap/SapCreate");
        return mv;
    }

    public ModelAndView submitSapConnection(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String serverip = request.getParameter("serverip");
        String clientid = request.getParameter("clientid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String systemid = request.getParameter("systemid");
        String name = request.getParameter("name");

        SapConnection sapConnection = new SapConnection();
        sapConnection.setServerip(serverip);
        sapConnection.setClientid(clientid);
        sapConnection.setUsername(username);
        sapConnection.setPassword(password);
        sapConnection.setSystemid(systemid);
        sapConnection.setName(name);

        if (!sapConnectionService.isExist(sapConnection)) {
            sapConnectionService.create(sapConnection);

            session.setAttribute("successMessage", "Sap  Created Successfully");
            mv.setViewName("redirect:sapConnection.htm?act=sapList");

        } else {

            session.setAttribute("failureMessage", "Sap  Already Exist. Please Enter Sap ");
            mv.setViewName("redirect:sapConnection.htm?act=sapCreate");
        }

        return mv;
    }

    public ModelAndView deleteSapDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");
        HttpSession session = request.getSession(false);

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            sapConnectionService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:sapConnection.htm?act=sapList");
        return mv;

    }

    public ModelAndView deleteSapById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            sapConnectionService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:sapConnection.htm?act=sapList");
        return mv;
    }

    public ModelAndView sapEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        SapConnection sapConnection = sapConnectionService.readById(Integer.parseInt(id));

        mv.getModelMap().put("sapConnection", sapConnection);
        mv.setViewName("sap/SapEdit");
        return mv;
    }

    public ModelAndView sapEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String serverip = request.getParameter("serverip");
        String clientid = request.getParameter("clientid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String systemid = request.getParameter("systemid");
        String name = request.getParameter("name");

        SapConnection sapConnection = sapConnectionService.readById(Integer.parseInt(id));
        sapConnection.setServerip(serverip);
        sapConnection.setClientid(clientid);
        sapConnection.setUsername(username);
        sapConnection.setPassword(password);
        sapConnection.setSystemid(systemid);
        sapConnection.setName(name);
        sapConnectionService.update(sapConnection);

        mv.getModelMap().put("sapConnection", sapConnection);
        session.setAttribute("successMessage", " Sap Edited successfully");

        mv.setViewName("redirect:sapConnection.htm?act=sapList");
        return mv;
    }

    public ModelAndView sapPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "serverip";
                    break;
                case "3":
                    orderColumn = "clientid";
                    break;
                case "4":
                    orderColumn = "username";
                    break;
                case "5":
                    orderColumn = "password";
                    break;
                case "6":
                    orderColumn = "systemid";
                    break;
                case "7":
                    orderColumn = "name";
                    break;

                default:
                    orderColumn = "id";
                    break;
            }
        }
        List list = sapConnectionService.getSapPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = sapConnectionService.getSapPlantCount();

        int filteredRecords = sapConnectionService.getFilteredPlantCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            SapConnection sapConnection = (SapConnection) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + sapConnection.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("serverip", sapConnection.getServerip() != null ? sapConnection.getServerip() : "");
            json.put("clientid", sapConnection.getClientid() != null ? sapConnection.getClientid() : "");
            json.put("username", sapConnection.getUsername() != null ? sapConnection.getUsername() : "");
            json.put("password", sapConnection.getPassword() != null ? sapConnection.getPassword() : "");
            json.put("systemid", sapConnection.getSystemid() != null ? sapConnection.getSystemid() : "");
            json.put("name", sapConnection.getName() != null ? sapConnection.getName() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='sapConnection.htm?act=sapEdit&id="
                    + sapConnection.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + sapConnection.getId() + "'>"
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

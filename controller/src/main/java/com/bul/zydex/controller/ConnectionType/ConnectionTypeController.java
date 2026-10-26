/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ConnectionType;

import com.bul.zydex.model.ConnectionType;
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
public class ConnectionTypeController extends ConnectionTypeAbstract {

    public ModelAndView ConnectionTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("ConnectionType/ConnectionTypeList");
        return mv;
    }

    public ModelAndView ConnectionTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("ConnectionType/ConnectionTypeCreate");
        return mv;
    }

    public ModelAndView submitConnectionTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        ConnectionType connectionType = new ConnectionType();
        String connectiontype1 = request.getParameter("connectiontype");
        connectionType.setConnectionType(connectiontype1);

        if (connectionTypeService.isExist(connectionType)) {
            connectionTypeService.create(connectionType);
            session.setAttribute("successMessage", "Connection Type Created Successfully.");
            mv.setViewName("redirect:connectionType.htm?act=ConnectionTypeList");
        } else {
            session.setAttribute("failureMessage", "Connection Type Already Exist. Please enter new Connection Type");
            mv.setViewName("redirect:connectionType.htm?act=ConnectionTypeCreate");
        }

        return mv;

    }

    public ModelAndView deleteConnectionById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            connectionTypeService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:connectionType.htm?act=ConnectionTypeList");
        return mv;
    }

    public ModelAndView deleteConnectionTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            connectionTypeService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:connectionType.htm?act=ConnectionTypeList");
        return mv;
    }

    public ModelAndView ConnectionTypeEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        ConnectionType connectiontype1 = connectionTypeService.readById(Integer.parseInt(id));

        mv.getModelMap().put("connectiontype1", connectiontype1);
        mv.setViewName("ConnectionType/ConnectionTypeEdit");
        return mv;
    }

    public ModelAndView ConnectionTypeEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String connectiontype = request.getParameter("connectiontype");
        ConnectionType connectiontype1 = connectionTypeService.readById(Integer.parseInt(id));
        connectiontype1.setConnectionType(connectiontype);
        connectionTypeService.update(connectiontype1);
        session.setAttribute("successMessage", "Connection Type Edited successfully");

        mv.setViewName("redirect:connectionType.htm?act=ConnectionTypeList");
        return mv;
    }

    public ModelAndView connectionTypeMasterAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "connectionType";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = connectionTypeService.getConnectionTypePagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = connectionTypeService.getConnectionTypeCount();
        int filteredRecords = connectionTypeService.getFilteredConnectionTypeCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            ConnectionType connectionType = (ConnectionType) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + connectionType.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("connectionType", connectionType.getConnectionType());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='connectionType.htm?act=ConnectionTypeEdit&id="
                    + connectionType.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + connectionType.getId() + "'>"
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

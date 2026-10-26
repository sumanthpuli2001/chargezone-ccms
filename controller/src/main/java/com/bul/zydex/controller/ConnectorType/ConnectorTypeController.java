/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ConnectorType;

import com.bul.zydex.model.ConnectorType;
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
public class ConnectorTypeController extends ConnectorTypeAbstract {

    public ModelAndView ConnectorTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("ConnectorType/ConnectorTypeList");
        return mv;

    }

    public ModelAndView connectorTypeListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "connectorType";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = connectorTypeService.getConnectorTypePagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = connectorTypeService.getTotalConnectorTypeCount();

        int filteredRecords = connectorTypeService.getFilteredConnectorTypeCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            ConnectorType connectorType = (ConnectorType) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + connectorType.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("connectorType", connectorType.getConnectorType() != null ? connectorType.getConnectorType() : "");

            json.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='connectorType.htm?act=ConnectorTypeEdit&id="
                    + connectorType.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + connectorType.getId() + "'>"
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

    public ModelAndView ConnectorTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("ConnectorType/ConnectorTypeCreate");
        return mv;
    }

    public ModelAndView submitConnectorTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String connectorType = request.getParameter("connectorType");

        ConnectorType connectorType1 = new ConnectorType();
        connectorType1.setConnectorType(connectorType);

        if (!connectorTypeService.isExist(connectorType1)) {
            connectorTypeService.create(connectorType1);

            session.setAttribute("successMessage", "Connector Type Created Successfully");
            mv.setViewName("redirect:connectorType.htm?act=ConnectorTypeList");
        } else {

            session.setAttribute("failureMessage", "Connector Type Already Exist. Please Enter New Connector Type");
            mv.setViewName("redirect:connectorType.htm?act=ConnectorTypeCreate");
        }
        return mv;

    }

    public ModelAndView ConnectorTypeEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        ConnectorType connectorType = connectorTypeService.readById(Integer.parseInt(id));
        mv.getModelMap().put("connectorType", connectorType);
        mv.getModelMap().put("id", id);

        mv.setViewName("ConnectorType/ConnectorTypeEdit");
        return mv;

    }

    public ModelAndView ConnectorTypeEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");

        String connectorType = request.getParameter("connectorType");

        ConnectorType connectorType1 = connectorTypeService.readById(Integer.parseInt(id));
        connectorType1.setConnectorType(connectorType);
        connectorTypeService.update(connectorType1);

        session.setAttribute("successMessage", "Connector Type Edited Successfully");
        mv.setViewName("redirect:connectorType.htm?act=ConnectorTypeList");
        return mv;
    }

    public ModelAndView deleteConnectorTypeById(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        connectorTypeService.delete(Integer.parseInt(id));

        mv.setViewName("redirect:connectorType.htm?act=ConnectorTypeList");

        return mv;
    }

    public ModelAndView deleteConnectorTypeMulti(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            connectorTypeService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:connectorType.htm?act=ConnectorTypeList");

        return mv;
    }

}

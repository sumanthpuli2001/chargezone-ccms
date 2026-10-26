/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.MaterialGroupMaster;

import com.bul.zydex.model.MaterialGroupMaster;
import com.bul.zydex.model.OapMasterUser;
import com.bul.zydex.model.PlantMaster;
import com.bul.zydex.model.TenderApprovalUser;
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
 * @author Aman Bahukhandi
 */
public class MaterialGroupMasterController extends MaterialGroupMasterAbstract {

    public ModelAndView showGroupList(HttpServletRequest request, HttpServletResponse response, MaterialGroupMaster materialGroupMaster) throws Exception {
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
        mv.setViewName("MaterialGroupMaster/CreateGroupMaster");
        return mv;

    }

    public ModelAndView submitGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String name = request.getParameter("name");
        MaterialGroupMaster materialGroupMaster = new MaterialGroupMaster();

        materialGroupMaster.setMaterialGroupName(name);

        if (!materialGroupMasterService.isExist(materialGroupMaster)) {

            materialGroupMasterService.create(materialGroupMaster);

            session.setAttribute("successMessage", "Material Group   Created Successfully");
            mv.setViewName("redirect:materialGroupMaster.htm?act=showList");

        } else {

            session.setAttribute("failureMessage", "Material Group   Already Exist. Please Enter Material Group  ");
            mv.setViewName("redirect:materialGroupMaster.htm?act=showGroupList");
        }

        return mv;

    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        List groupList = materialGroupMasterService.read();
        mv.getModelMap().put("groupList", groupList);
        request.setAttribute("groupList", groupList);

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

        mv.setViewName("MaterialGroupMaster/GroupMasterList");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                materialGroupMasterService.delete(Integer.parseInt(z));

            } catch (Exception e) {
            }
        }
        mv.setViewName("redirect:materialGroupMaster.htm?act=showList");
        return mv;

    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        MaterialGroupMaster materialGroupMaster = materialGroupMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        request.setAttribute("materialGroupMaster", materialGroupMaster);

        mv.getModelMap().put("id", id);
        request.setAttribute("id", id);

        mv.setViewName("MaterialGroupMaster/EditGroupMaster");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        MaterialGroupMaster materialGroupMaster = materialGroupMasterService.readById(Integer.parseInt(id));
        String materialGroupName = request.getParameter("materialGroupName");

        materialGroupMaster.setMaterialGroupName(materialGroupName);
        materialGroupMasterService.update(materialGroupMaster);

        session.setAttribute("successMessage",
                "Material Group is Edited successfully ");

        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.setViewName("redirect:materialGroupMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);

        try {
            materialGroupMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:materialGroupMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteGroupById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");
        HttpSession session = request.getSession(false);

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            materialGroupMasterService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:materialGroupMaster.htm?act=showList");
        return mv;

    }

    public ModelAndView groupPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "materialGroupName";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = materialGroupMasterService.getmaterialGroupMasterPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = materialGroupMasterService.getTotalmaterialGroupMasterCount();

        int filteredRecords = materialGroupMasterService.getFilteredmaterialGroupMasterCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            MaterialGroupMaster materialGroupMaster = (MaterialGroupMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + materialGroupMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("materialGroupName", materialGroupMaster.getMaterialGroupName() != null ? materialGroupMaster.getMaterialGroupName() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='materialGroupMaster.htm?act=viewClick&id="
                    + materialGroupMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + materialGroupMaster.getId() + "'>"
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

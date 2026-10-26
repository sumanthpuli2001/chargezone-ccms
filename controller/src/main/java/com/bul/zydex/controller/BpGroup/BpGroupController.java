/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.BpGroup;

import com.bul.zydex.model.BpGroup;
import com.bul.zydex.model.LocationMasters;
import com.bul.zydex.model.ProductGroupMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bulwarks-2
 */
public class BpGroupController extends BpGroupAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("BpGroup/ShowList");
        return mv;
    }

    public ModelAndView createBpGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("BpGroup/CreateBpGroup");
        return mv;
    }

    public ModelAndView submitBpGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String bpGroupName = request.getParameter("bpGroupName");
        String accountGroup = request.getParameter("accountGroup");
        String discription = request.getParameter("discription");
        BpGroup bpGroup = new BpGroup();
        bpGroup.setBpGroupName(bpGroupName);
        bpGroup.setAccountGroup(accountGroup);
        bpGroup.setDiscription(discription);

        if (!bpGroupService.isExist(bpGroup)) {
            bpGroupService.create(bpGroup);

            session.setAttribute("successMessage", "BP Group Created Successfully");
            mv.setViewName("redirect:bpGroupMasters.htm?act=showList");

        } else {

            session.setAttribute("failureMessage", "BP Group Already Exist. Please Enter New BP Group");
            mv.setViewName("redirect:bpGroupMasters.htm?act=createBpGroup");
        }

        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        BpGroup bpGroup = bpGroupService.readById(Integer.parseInt(id));

        mv.getModelMap().put("bpGroup", bpGroup);
        mv.setViewName("BpGroup/EditClick");
        return mv;
    }

    public ModelAndView submitEditBpGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");

        BpGroup bpGroup = bpGroupService.readById(Integer.parseInt(id));

        String bpGroupName = request.getParameter("bpGroupName");
        String accountGroup = request.getParameter("accountGroup");
        String discription = request.getParameter("discription");

        bpGroup.setBpGroupName(bpGroupName);
        bpGroup.setAccountGroup(accountGroup);
        bpGroup.setDiscription(discription);
        bpGroupService.update(bpGroup);

        session.setAttribute("successMessage", "Information: BP Group Edited Successfully");

        mv.setViewName("redirect:bpGroupMasters.htm?act=showList");

        return mv;
    }

    public ModelAndView bpGroupdelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            bpGroupService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:bpGroupMasters.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteBpMastersById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            bpGroupService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:bpGroupMasters.htm?act=showList");
        return mv;
    }

    public ModelAndView bpGroupPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "bpGroupName";
                    break;
                case "3":
                    orderColumn = "accountGroup";
                    break;
                case "4":
                    orderColumn = "discription";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = bpGroupService.getbpGroupPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = bpGroupService.getTotalbpGroupCount();

        int filteredRecords = bpGroupService.getFilteredbpGroupCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            BpGroup bpGroup = (BpGroup) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + bpGroup.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("bpGroupName", bpGroup.getBpGroupName() != null ? bpGroup.getBpGroupName() : "");
            json.put("accountGroup", bpGroup.getAccountGroup() != null ? bpGroup.getAccountGroup() : "");
            json.put("discription", bpGroup.getDiscription() != null ? bpGroup.getDiscription() : "");

            json.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='bpGroupMasters.htm?act=editClick&id="
                    + bpGroup.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + bpGroup.getId() + "'>"
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

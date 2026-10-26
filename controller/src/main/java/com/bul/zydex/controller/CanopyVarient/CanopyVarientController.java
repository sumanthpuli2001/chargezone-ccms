/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CanopyVarient;

import com.bul.zydex.model.AnchorCustomer;
import com.bul.zydex.model.CanopyVarient;
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
public class CanopyVarientController extends CanopyVarientAbstract {

    public ModelAndView canopyVarientList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        List list = canopyVarientService.read();

        mv.getModelMap().put("list", list);
        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }
        }

        mv.setViewName("CanopyVarient/canopyVarientList");
        return mv;
    }

    public ModelAndView canopyVarientCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("CanopyVarient/CanopyVarientCreate");
        return mv;
    }

    public ModelAndView submitcanopyVarientCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String name = request.getParameter("name");

        CanopyVarient canopyVarient = new CanopyVarient();

        canopyVarient.setName(name);

        if (!canopyVarientService.isExist(canopyVarient)) {
            canopyVarientService.create(canopyVarient);

            session1.setAttribute("successMessage", "Canopy Varient Created Successfully");
            mv.setViewName("redirect:canopyVarient.htm?act=canopyVarientList");

        } else {

            session1.setAttribute("failureMessage", "Canopy Varient Already Exist. Please Enter Canopy Varient");
            mv.setViewName("redirect:canopyVarient.htm?act=canopyVarientCreate");
        }

        return mv;
    }

    public ModelAndView deleteCanopyVarientList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String id = request.getParameter("id");

        CanopyVarient canopyVarient = canopyVarientService.readById(Integer.parseInt(id));

        canopyVarientService.delete(Integer.parseInt(id));

        mv.setViewName("redirect:canopyVarient.htm?act=canopyVarientList");

        return mv;
    }

    public ModelAndView deleteCanopyVarientMulti(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            canopyVarientService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:canopyVarient.htm?act=canopyVarientList");

        return mv;
    }

    public ModelAndView canopyVarientEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        CanopyVarient canopyVarient = canopyVarientService.readById(Integer.parseInt(id));

        mv.getModelMap().put("canopyVarient", canopyVarient);
        mv.getModelMap().put("id", id);
        mv.setViewName("CanopyVarient/CanopyVarientEdit");

        return mv;
    }

    public ModelAndView canopyVarientEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String name = request.getParameter("name");

        CanopyVarient canopyVarient = canopyVarientService.readById(Integer.parseInt(id));
        canopyVarient.setName(name);
        canopyVarientService.update(canopyVarient);

        session1.setAttribute("successMessage", "Canopy Varient Edited successfully");
        mv.setViewName("redirect:canopyVarient.htm?act=canopyVarientList");

        return mv;
    }

    public ModelAndView canopyVarientPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "name";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = canopyVarientService.getCanopyPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = canopyVarientService.getTotalCanopyCount();

        int filteredRecords = canopyVarientService.getFilteredCanopyCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            CanopyVarient canopyVarient = (CanopyVarient) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + canopyVarient.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("name", canopyVarient.getName());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='canopyVarient.htm?act=canopyVarientEdit&id="
                    + canopyVarient.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + canopyVarient.getId() + "'>"
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.EhMail;

import com.bul.zydex.model.EhMail;
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
public class EhMailController extends EhMailAbstract {

    public ModelAndView ehMailList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("EhMail/EhMailList");
        return mv;
    }

    public ModelAndView ehMailCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("EhMail/EhMailCreate");
        return mv;
    }

    public ModelAndView submitEhMailCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        EhMail eh = new EhMail();

        eh.setUsername(username);
        eh.setEmail(email);

        if (!ehMailService.isExist(eh)) {
            ehMailService.create(eh);

            session1.setAttribute("successMessage", "EH Mail Created Successfully");
            mv.setViewName("redirect:ehMail.htm?act=ehMailList");

        } else {

            session1.setAttribute("failureMessage", "EH Mail Already Exist. Please Enter EH Mail");
            mv.setViewName("redirect:ehMail.htm?act=ehMailCreate");
        }

        return mv;
    }

    public ModelAndView deleteEhMailList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);

        String id = request.getParameter("id");

        EhMail eh = ehMailService.readById(Integer.parseInt(id));

        ehMailService.delete(Integer.parseInt(id));

        mv.setViewName("redirect:ehMail.htm?act=ehMailList");

        return mv;
    }

    public ModelAndView deleteEhMailMulti(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            ehMailService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:ehMail.htm?act=ehMailList");

        return mv;
    }

    public ModelAndView ehMailEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        EhMail eh = ehMailService.readById(Integer.parseInt(id));

        mv.getModelMap().put("eh", eh);
        mv.getModelMap().put("id", id);
        mv.setViewName("EhMail/EhMailEdit");
        return mv;
    }

    public ModelAndView aehMailEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        EhMail eh = ehMailService.readById(Integer.parseInt(id));
        eh.setUsername(username);
        eh.setEmail(email);
        ehMailService.update(eh);

        session1.setAttribute("successMessage", "EH Edited successfully");
        mv.setViewName("redirect:ehMail.htm?act=ehMailList");

        return mv;
    }

    public ModelAndView ehMailPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "a.username";
                    break;
                case "3":
                    orderColumn = "a.email";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = ehMailService.getEhMailPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = ehMailService.getTotalEhMailCount();

        int filteredRecords = ehMailService.getFilteredEhMailCount(searchValue);

         JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }
        for (Object obj : list) {
            Object[] row = (Object[]) obj; // ← Fix: was casting to EhMail but query returns Object[]

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String username = row[1] != null ? row[1].toString() : "";
            String email = row[2] != null ? row[2].toString() : "";

            JSONObject json = new JSONObject();
            json.put("checkbox",
                    "<input type='checkbox' class='rowCheckbox' value='" + id + "'>");
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("username", username);
            json.put("email", email);
            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='ehMail.htm?act=ehMailEdit&id=" + id
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src='StorageYard/assets/images/edit-icon.svg' style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + id + "'>"
                    + "<img src='StorageYard/assets/images/delete-icon.svg' style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>");

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

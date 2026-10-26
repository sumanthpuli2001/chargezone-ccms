/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.AnchorCustomer;

import com.bul.zydex.model.AnchorCustomer;
import com.bul.zydex.model.UserMaster;
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
 * @author Sumanth
 */
public class AnchorCustomerController extends AnchorCustomerAbstract {

    public ModelAndView anchorCustomerList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        List list = anchorCustomerService.read();

        mv.getModelMap().put("list", list);
        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }
        }

        mv.setViewName("AnchorCustomer/AnchorCustomerList");
        return mv;
    }

    public ModelAndView anchorCustomerCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("AnchorCustomer/AnchorCustomerCreate");
        return mv;
    }

    public ModelAndView submitAnchorCustomerCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String name = request.getParameter("name");

        AnchorCustomer anoAnchorCustomer = new AnchorCustomer();
        anoAnchorCustomer.setName(name);
        if (!anchorCustomerService.isExist(anoAnchorCustomer)) {
            anchorCustomerService.create(anoAnchorCustomer);

            session1.setAttribute("successMessage", "Anchor Customer Created Successfully");
            mv.setViewName("redirect:anchorCustomer.htm?act=anchorCustomerList");

        } else {

            session1.setAttribute("failureMessage", "Anchor Customer Already Exist. Please Enter Anchor Customer");
            mv.setViewName("redirect:anchorCustomer.htm?act=anchorCustomerCreate");
        }

        return mv;
    }

    public ModelAndView deleteAnchorCustomerList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String id = request.getParameter("id");

        AnchorCustomer anchorCustomer = anchorCustomerService.readById(Integer.parseInt(id));

        anchorCustomerService.delete(Integer.parseInt(id));

        mv.setViewName("redirect:anchorCustomer.htm?act=anchorCustomerList");

        return mv;
    }

    public ModelAndView deleteAnchorCustomerMulti(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            anchorCustomerService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:anchorCustomer.htm?act=anchorCustomerList");

        return mv;
    }

    public ModelAndView anchorCustomerEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        AnchorCustomer anchorCustomer = anchorCustomerService.readById(Integer.parseInt(id));

        mv.getModelMap().put("anchorCustomer", anchorCustomer);
        mv.getModelMap().put("id", id);
        mv.setViewName("AnchorCustomer/AnchorCustomerEdit");
        return mv;
    }

    public ModelAndView anchorCustomerEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String name = request.getParameter("name");

        AnchorCustomer anchorCustomer = anchorCustomerService.readById(Integer.parseInt(id));
        anchorCustomer.setName(name);
        anchorCustomerService.update(anchorCustomer);

        session1.setAttribute("successMessage", "Anchor Customer Edited successfully");
        mv.setViewName("redirect:anchorCustomer.htm?act=anchorCustomerList");

        return mv;
    }

    public ModelAndView anchorPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

        List list = anchorCustomerService.getAnchorPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = anchorCustomerService.getTotalAnchorCount();

        int filteredRecords = anchorCustomerService.getFilteredAnchorCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            AnchorCustomer anchorCustomer = (AnchorCustomer) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + anchorCustomer.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("name", anchorCustomer.getName());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='anchorCustomer.htm?act=anchorCustomerEdit&id="
                    + anchorCustomer.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + anchorCustomer.getId() + "'>"
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

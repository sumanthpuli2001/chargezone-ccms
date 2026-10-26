/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.PurchasingOrganisation;

import com.bul.zydex.model.PurchasingOrganisation;
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
public class PurchasingOrganisationController extends PurchasingOrganisationAbstract {

    public ModelAndView showlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("purchase/showlist");
        return mv;
    }

    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        
        List list10 = companyMasterService.read();
        request.setAttribute("list10", list10);
        mv.setViewName("purchase/create");
        return mv;
    }

    public ModelAndView createsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        PurchasingOrganisation purchasingOrganisationMaster = new PurchasingOrganisation();

        String companyCode = request.getParameter("comapnycode");
        String purchasingOrganisation = request.getParameter("purchase");
        String description = request.getParameter("description");

        purchasingOrganisationMaster.setCompanyCode(companyCode);
        purchasingOrganisationMaster.setPurchasingOrganisation(purchasingOrganisation);
        purchasingOrganisationMaster.setDescription(description);

        if (purchasingOrganisationService.isExist(purchasingOrganisationMaster)) {
            purchasingOrganisationService.create(purchasingOrganisationMaster);
            session.setAttribute("successMessage", "Purchasing Master Created Successfully.");
            mv.setViewName("redirect:purchasingOrganisation.htm?act=showlist");
        } else {
            session.setAttribute("failureMessage", "Purchasing Master Already Exist. Please enter new Data");
            mv.setViewName("redirect:purchasingOrganisation.htm?act=create");
        }

        return mv;
    }

    public ModelAndView purchaseedit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        PurchasingOrganisation purchasingOrganisation = purchasingOrganisationService.readById(Integer.parseInt(id));

        String companymaster = purchasingOrganisation.getCompanyCode();
        List list10 = companyMasterService.read();

        request.setAttribute("list10", list10);

        mv.getModelMap().put("companymaster", companymaster);
        mv.getModelMap().put("purchasingOrganisation", purchasingOrganisation);
        mv.setViewName("purchase/edit");
        return mv;
    }

    public ModelAndView purchaseeditsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String id = request.getParameter("id");

        String comapnycode = request.getParameter("comapnycode");
        String description = request.getParameter("description");
        String purchase = request.getParameter("purchase");

        PurchasingOrganisation purchasingOrganisation = purchasingOrganisationService.readById(Integer.parseInt(id));
        purchasingOrganisation.setCompanyCode(comapnycode);
        purchasingOrganisation.setDescription(description);
        purchasingOrganisation.setPurchasingOrganisation(purchase);
        purchasingOrganisationService.update(purchasingOrganisation);

        session.setAttribute("successMessage", "Purchasing Master Updated successfully");
        mv.setViewName("redirect:purchasingOrganisation.htm?act=showlist");
        return mv;
    }

    public ModelAndView purchasedelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            purchasingOrganisationService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:purchasingOrganisation.htm?act=showlist");
        return mv;
    }

    public ModelAndView deletePurchaseById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            purchasingOrganisationService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:purchasingOrganisation.htm?act=showlist");
        return mv;
    }

    public ModelAndView purchasingOrganisationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "companyCode";
                    break;
                case "3":
                    orderColumn = "purchasingOrganisation";
                    break;
                case "4":
                    orderColumn = "description";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = purchasingOrganisationService.getPurchasingOrganisationPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = purchasingOrganisationService.getPurchasingOrganisationCount();
        int filteredRecords = purchasingOrganisationService.getFilteredPurchasingOrganisationCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            PurchasingOrganisation purchasingOrganisation = (PurchasingOrganisation) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + purchasingOrganisation.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("companyCode", purchasingOrganisation.getCompanyCode());
            json.put("purchasingOrganisation", purchasingOrganisation.getPurchasingOrganisation());
            json.put("description", purchasingOrganisation.getDescription());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='purchasingOrganisation.htm?act=purchaseedit&id="
                    + purchasingOrganisation.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + purchasingOrganisation.getId() + "'>"
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ProductTypeMaster;

import com.bul.zydex.model.PlantMaster;
import com.bul.zydex.model.ProductTypeMaster;
import com.bul.zydex.model.RightMaster;
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
public class ProductTypeMasterController extends ProductTypeMasterAbstract {

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
        mv.setViewName("ProductTypeMaster/ShowList");
        return mv;
    }

    public ModelAndView createProjectTypeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("ProductTypeMaster/CreateProjectTypeMaster");
        return mv;
    }

    public ModelAndView submitProjectTypeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        ProductTypeMaster productTypeMaster = new ProductTypeMaster();
        String productType = request.getParameter("productType");
        String description = request.getParameter("description");
        productTypeMaster.setProductType(productType);
        productTypeMaster.setDescription(description);

        if (!productTypeMasterService.isExist(productTypeMaster)) {
            productTypeMasterService.create(productTypeMaster);

            session.setAttribute("successMessage", "Product Master  Created Successfully");
            mv.setViewName("redirect:productTypeMaster.htm?act=showList");

        } else {

            session.setAttribute("failureMessage", "Product Name  Already Exist. Please Enter Product Name ");
            mv.setViewName("redirect:productTypeMaster.htm?act=createProjectTypeMaster");
        }

        return mv;
    }

    public ModelAndView deleteProjectTypeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            productTypeMasterService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:productTypeMaster.htm?act=showList");
        return mv;

    }

    public ModelAndView deleteProductTypeById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {

            productTypeMasterService.delete(Integer.parseInt(id));

        } catch (Exception e) {

        }

        mv.setViewName("redirect:productTypeMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView editProductTypeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        ProductTypeMaster productTypeMaster = productTypeMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("productTypeMaster", productTypeMaster);

        mv.setViewName("ProductTypeMaster/EditProductTypeMaster");
        return mv;
    }

    public ModelAndView submitEditProjectTypeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String productType = request.getParameter("productType");
        String description = request.getParameter("description");
        ProductTypeMaster productTypeMaster = productTypeMasterService.readById(Integer.parseInt(id));

        productTypeMaster.setProductType(productType);
        productTypeMaster.setDescription(description);
        productTypeMasterService.update(productTypeMaster);

        mv.getModelMap().put("productTypeMaster", productTypeMaster);

        session.setAttribute("successMessage", "Product Master  Edited successfully");

        mv.setViewName("redirect:productTypeMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView prodPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "productType";
                    break;
                case "3":
                    orderColumn = "description";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = productTypeMasterService.getTypePagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = productTypeMasterService.getTotalTypeCount();

        int filteredRecords = productTypeMasterService.getFilteredTypeCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            ProductTypeMaster productTypeMaster = (ProductTypeMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + productTypeMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("productType", productTypeMaster.getProductType() != null ? productTypeMaster.getProductType() : "");
            json.put("description", productTypeMaster.getDescription() != null ? productTypeMaster.getDescription() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='productTypeMaster.htm?act=editProductTypeMaster&id="
                    + productTypeMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + productTypeMaster.getId() + "'>"
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

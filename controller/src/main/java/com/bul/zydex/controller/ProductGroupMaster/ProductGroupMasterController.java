/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ProductGroupMaster;

import com.bul.zydex.model.ProductGroupMaster;
import com.bul.zydex.model.ProductTypeMaster;
import com.bul.zydex.model.ValuationClassMaster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
public class ProductGroupMasterController extends ProductGroupMasterAbstract {

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

        mv.setViewName("ProductGroupMaster/ShowList");
        return mv;
    }

    public ModelAndView createProductGroupMasterMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        List list = valuationClassMasterService.read();
        mv.getModelMap().put("list", list);

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
        mv.setViewName("ProductGroupMaster/CreateProductGroupMasterMaster");
        return mv;
    }

    public ModelAndView submitProductGroupMasterMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        ProductGroupMaster productGroupMaster = new ProductGroupMaster();

        String variationClassId = request.getParameter("variationClassId");
        String productGroup = request.getParameter("productGroup");
        String Gl = request.getParameter("Gl");
        String description = request.getParameter("description");
        productGroupMaster.setProductGroup(productGroup);
        productGroupMaster.setDescription(description);
        productGroupMaster.setVariationClassId(Integer.parseInt(variationClassId));
        productGroupMaster.setGl(Gl);

        if (!productGroupMasterService.isExist(productGroupMaster)) {
            productGroupMasterService.create(productGroupMaster);
            session.setAttribute("successMessage", "Product Group Master Created successfully");
            mv.setViewName("redirect:productGroupMaster.htm?act=showList");
        } else {
            session.setAttribute("failureMessage", "Product Group Already Exist. Please enter new Details");
            mv.setViewName("redirect:productGroupMaster.htm?act=createProductGroupMasterMaster");
        }
        return mv;
    }

    public ModelAndView deleteProductGroupMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            productGroupMasterService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:productGroupMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteGroupById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            productGroupMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }
        mv.setViewName("redirect:productGroupMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView editProductGroupMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        ProductGroupMaster productGroupMaster = productGroupMasterService.readById(Integer.parseInt(id));
        List list = valuationClassMasterService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("productGroupMaster", productGroupMaster);
        mv.setViewName("ProductGroupMaster/EditProductGroupMaster");
        return mv;
    }

    public ModelAndView submitEditProductGroupMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        ProductGroupMaster productGroupMaster = productGroupMasterService.readById(Integer.parseInt(id));
        String variationClassId = request.getParameter("variationClassId");
        String productGroup = request.getParameter("productGroup");
        String Gl = request.getParameter("Gl");
        String description = request.getParameter("description");
        productGroupMaster.setProductGroup(productGroup);
        productGroupMaster.setDescription(description);
        productGroupMaster.setVariationClassId(Integer.parseInt(variationClassId));
        productGroupMaster.setGl(Gl);
        productGroupMasterService.update(productGroupMaster);

        mv.getModelMap().put("productGroupMaster", productGroupMaster);
        session.setAttribute("successMessage", "Product Group Master Edited successfully");
        mv.setViewName("redirect:productGroupMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView productGroupPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "variationClassId";
                    break;
                case "3":
                    orderColumn = "productGroup";
                    break;
                case "4":
                    orderColumn = "Gl";
                    break;
                case "5":
                    orderColumn = "description";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = productGroupMasterService.getProGroupPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = productGroupMasterService.getTotalProGroupCount();
        int filteredRecords = productGroupMasterService.getFilteredProGroupCount(searchValue);

        List data = new ArrayList();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);
        int srNo;
        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Iterator it = list.iterator(); it.hasNext();) {
            Object[] row = (Object[]) it.next();
            Map map = new HashMap();

            map.put("checkbox",
                    "<input type='checkbox' class='rowCheckbox' value='"
                    + (row[0] != null ? row[0] : "")
                    + "'>"
            );

            if (isDesc) {
                map.put("srNo", srNo--);
            } else {
                map.put("srNo", srNo++);
            }

            map.put("valuationClass", row[4] != null ? row[4] : "");
            map.put("productGroup", row[1] != null ? row[1] : "");
            map.put("Gl", row[3] != null ? row[3] : "");
            map.put("description", row[2] != null ? row[2] : "");

            map.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='productGroupMaster.htm?act=editProductGroupMaster&id="
                    + (row[0] != null ? row[0] : "")
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + (row[0] != null ? row[0] : "") + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );

            data.add(map);
        }

        JSONObject responseJson = new JSONObject();

        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", data);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }
}

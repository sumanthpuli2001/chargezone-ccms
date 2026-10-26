/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.MaterialTypeMaster;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CanopyVarient;
import com.bul.zydex.model.MaterialTypeMaster;
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
public class MaterialTypeMasterController extends CustomAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, MaterialTypeMaster materialTypeMaster) throws Exception {
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
        mv.setViewName("MaterialTypeMaster/MaterialTypeMasterCreate");
        return mv;

    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        MaterialTypeMaster materialTypeMaster = new MaterialTypeMaster();
        String materialType = request.getParameter("materialType");
        materialTypeMaster.setMaterialType(materialType);

        if (!materialTypeMasterService.isExist(materialTypeMaster)) {

            materialTypeMasterService.create(materialTypeMaster);

            session.setAttribute("successMessage", "Material Type   Created Successfully");
            mv.setViewName("redirect:materialTypeMaster.htm?act=showMaterial");

        } else {

            session.setAttribute("failureMessage", "Material Type   Already Exist. Please Enter Material Type  ");
            mv.setViewName("redirect:materialTypeMaster.htm?act=showList");
        }

        return mv;
    }

    public ModelAndView showMaterial(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        List materialTypeMasterList = materialTypeMasterService.read();

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
        mv.getModelMap().put("materialTypeMasterList", materialTypeMasterList);
        request.setAttribute("materialTypeMasterList", materialTypeMasterList);
        mv.setViewName("MaterialTypeMaster/MaterialTypeMasterList");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);

        try {
            materialTypeMasterService.delete(Integer.parseInt(id));

        } catch (Exception e) {

        }
        mv.setViewName("redirect:materialTypeMaster.htm?act=showMaterial");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        MaterialTypeMaster materialTypeMaster = materialTypeMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);
        request.setAttribute("materialTypeMaster", materialTypeMaster);

        mv.getModelMap().put("id", id);
        request.setAttribute("id", id);

        mv.setViewName("MaterialTypeMaster/MaterialTypeMasterEdit"); //this is JSP page path
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);

        MaterialTypeMaster materialTypeMaster = materialTypeMasterService.readById(Integer.parseInt(id));
        String materialType = request.getParameter("materialType");

        materialTypeMaster.setMaterialType(materialType);
        materialTypeMasterService.update(materialTypeMaster);

        session.setAttribute("successMessage",
                "Material Type is successfully Updated");

        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);
        mv.setViewName("redirect:materialTypeMaster.htm?act=showMaterial");
        return mv;
    }

    public ModelAndView deleteAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        try {
            for (String checkedValues : idArray) {
                materialTypeMasterService.delete(Integer.parseInt(checkedValues));

            }
        } catch (Exception e) {

        }
        mv.setViewName("redirect:materialTypeMaster.htm?act=showMaterial");
        return mv;
    }

    public ModelAndView materialTypePaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "materialType";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;

                case "2":
                    orderColumn = "materialType";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = materialTypeMasterService.getmaterialTypePagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = materialTypeMasterService.getTotalmaterialTypeCount();
        int filteredRecords = materialTypeMasterService.getFilteredmaterialTypeCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            MaterialTypeMaster materialTypeMaster = (MaterialTypeMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + materialTypeMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("materialType", materialTypeMaster.getMaterialType() != null ? materialTypeMaster.getMaterialType() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='materialTypeMaster.htm?act=viewClick&id="
                    + materialTypeMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + materialTypeMaster.getId() + "'>"
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

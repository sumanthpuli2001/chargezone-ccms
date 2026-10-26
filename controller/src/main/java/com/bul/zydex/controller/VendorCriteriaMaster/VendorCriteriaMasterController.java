/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.VendorCriteriaMaster;

import com.bul.zydex.model.GroupCategory;
import com.bul.zydex.model.GroupMaster;
import com.bul.zydex.model.GroupSubCategory;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.VendorCriteriaDetailsHistory;
import com.bul.zydex.model.VendorCriteriaMaster;
import com.bul.zydex.model.VendorCriteriaMasterDetails;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaMasterController extends VendorCriteriaMasterAbstract {

    public ModelAndView showVendorCriteriaList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Vendor/ShowVendorTechnicalCriteriaList");
        return mv;
    }

    public ModelAndView createVendorTechnicalCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List list = groupMasterService.read();
        List list1 = groupCategoryService.read();

        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("list", list);

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
        mv.setViewName("Vendor/CreateVendorTechnicalCriteria");
        return mv;
    }

    public ModelAndView submitVendorCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        String groupName = request.getParameter("groupName");
        String groupCategoryName = request.getParameter("groupCategoryName");
        String SubCategoryName = request.getParameter("SubCategoryName");
        String DepartmentCategory = request.getParameter("DepartmentCategory");

        UserMaster user = (UserMaster) session1.getAttribute("user");
        String username = user.getLoginName();

        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        if (groupCategoryName == null || groupCategoryName == "") {
            groupCategoryName = "0";
        }

        if (SubCategoryName == null || SubCategoryName == "") {
            SubCategoryName = "0";
        }
        VendorCriteriaMaster vendorCriteriaMaster = new VendorCriteriaMaster();
        vendorCriteriaMaster.setGroupMasterId(Integer.parseInt(groupName));
        vendorCriteriaMaster.setGroupCategoryId(Integer.parseInt(groupCategoryName));
        vendorCriteriaMaster.setGroupSubCategoryId(Integer.parseInt(SubCategoryName));
        vendorCriteriaMaster.setDepartmentCategory(DepartmentCategory);

        if (!vendorCriteriaMasterService.isExist(vendorCriteriaMaster)) {
            vendorCriteriaMasterService.create(vendorCriteriaMaster);
            String[] criteriaName = request.getParameterValues("Criteria");
            String[] criteriaDescription = request.getParameterValues("CriteriaDescription");
            String[] mandatory = request.getParameterValues("mandatory");

            try {

                for (int i = 0; i < criteriaName.length; i++) {
                    VendorCriteriaMasterDetails vendorCriteriaMasterDetails = new VendorCriteriaMasterDetails();
                    vendorCriteriaMasterDetails.setCriteriaName(criteriaName[i]);
                    vendorCriteriaMasterDetails.setCriteriaDescription(criteriaDescription[i]);
                    vendorCriteriaMasterDetails.setMandatory(mandatory[i]);
                    vendorCriteriaMasterDetails.setCompulsaryFlag("0");
                    vendorCriteriaMasterDetails.setVendorCriteriaMasterId(vendorCriteriaMaster.getId());
                    vendorCriteriaMasterDetailsService.create(vendorCriteriaMasterDetails);

                    VendorCriteriaDetailsHistory criteriaDetailsHistory = new VendorCriteriaDetailsHistory();
                    criteriaDetailsHistory.setCriteriaName(criteriaName[i]);
                    criteriaDetailsHistory.setCriteriaDescription(criteriaDescription[i]);
                    criteriaDetailsHistory.setMandatory(mandatory[i]);
                    criteriaDetailsHistory.setCompulsary("0");
                    criteriaDetailsHistory.setActionBy("Created");
                    criteriaDetailsHistory.setAction(username);
                    criteriaDetailsHistory.setDate(formattedDate1);
                    criteriaDetailsHistory.setVendorCriteriaMasterHistoryId(0);
                    criteriaDetailsHistory.setVendorCriteriaMasterId(vendorCriteriaMaster.getId());
                    vendorCriteriaDetailsHistoryService.create(criteriaDetailsHistory);

                }

            } catch (Exception e) {

                e.printStackTrace();

            }

            session1.setAttribute("successMessage", "Vendor Criteria  Created Successfully");
            mv.setViewName("redirect:vendorCriteriaMaster.htm?act=showVendorCriteriaList");

        } else {

            session1.setAttribute("failureMessage", "Vendor Criteria  Already Exist. Please Enter Vendor Criteria ");
            mv.setViewName("redirect:vendorCriteriaMaster.htm?act=createVendorTechnicalCriteria");
        }

        return mv;

    }

    public ModelAndView editVendorCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        String id = request.getParameter("id");
        VendorCriteriaMaster vendorCriteriaMaster = vendorCriteriaMasterService.readById(Integer.parseInt(id));
        int groupSubCategoryId = vendorCriteriaMaster.getGroupSubCategoryId();
        int groupCategoryIdd = vendorCriteriaMaster.getGroupCategoryId();
        int groupMasterId = vendorCriteriaMaster.getGroupMasterId();
        String departmentCategory = vendorCriteriaMaster.getDepartmentCategory();
        List list2 = vendorCriteriaMasterDetailsService.readByCriteriaMasterId(id);

        GroupMaster groupMaster = groupMasterService.readById(groupMasterId);

        if (groupCategoryIdd != 0) {
            GroupCategory groupCategory = groupCategoryService.readById(groupCategoryIdd);
            mv.getModelMap().put("groupCategory", groupCategory);
        }

        if (groupSubCategoryId != 0) {
            GroupSubCategory groupSubCategory = groupSubCategoryService.readById(groupSubCategoryId);
            mv.getModelMap().put("groupSubCategory", groupSubCategory);

        }

        List list = groupMasterService.read();
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("departmentCategory", departmentCategory);
        mv.getModelMap().put("vendorCriteriaMaster", vendorCriteriaMaster);
        mv.getModelMap().put("groupMaster", groupMaster);
        mv.getModelMap().put("groupMasterId", groupMasterId);

        if (session1 != null) {

            String successMessage = (String) session1.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session1.removeAttribute("successMessage");
            }

            String failureMessage = (String) session1.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session1.removeAttribute("failureMessage");
            }
        }
        List list3 = vendorCriteriaDetailsHistoryService.readByCriteriaMasterId(Integer.parseInt(id));
        mv.getModelMap().put("list3", list3);
        mv.setViewName("Vendor/EditVendorTechnicalCriteria");
        return mv;
    }

    public ModelAndView criteiaDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user = (UserMaster) session1.getAttribute("user");
        String username = user.getLoginName();
        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj1.format(myFormatObj1);
        String id = request.getParameter("id");
        VendorCriteriaMasterDetails vendorCriteriaMasterDetails = vendorCriteriaMasterDetailsService.readById(Integer.parseInt(id));
        List list = vendorCriteriaMasterDetailsService.readByCriteriaMasterId(vendorCriteriaMasterDetails.getVendorCriteriaMasterId() + "");

        vendorCriteriaMasterDetailsService.delete(Integer.parseInt(id));
        VendorCriteriaDetailsHistory criteriaDetailsHistory = new VendorCriteriaDetailsHistory();
        criteriaDetailsHistory.setCriteriaName(vendorCriteriaMasterDetails.getCriteriaName());
        criteriaDetailsHistory.setCriteriaDescription(vendorCriteriaMasterDetails.getCriteriaDescription());
        criteriaDetailsHistory.setMandatory(vendorCriteriaMasterDetails.getMandatory());
        criteriaDetailsHistory.setCompulsary(vendorCriteriaMasterDetails.getCompulsaryFlag());
        criteriaDetailsHistory.setActionBy("Deleted");
        criteriaDetailsHistory.setAction(username);
        criteriaDetailsHistory.setDate(formattedDate);
        criteriaDetailsHistory.setVendorCriteriaMasterHistoryId(0);
        criteriaDetailsHistory.setVendorCriteriaMasterId(vendorCriteriaMasterDetails.getVendorCriteriaMasterId());
        vendorCriteriaDetailsHistoryService.create(criteriaDetailsHistory);

        if (list.size() > 1) {
            session1.setAttribute("successMessage", "Vendor Criteria Deleted successfully");
            mv.setViewName("redirect:vendorCriteriaMaster.htm?act=editVendorCriteria&id=" + vendorCriteriaMasterDetails.getVendorCriteriaMasterId());
        } else {
            session1.setAttribute("successMessage", "Vendor Criteria Deleted successfully");
            mv.setViewName("redirect:vendorCriteriaMaster.htm?act=showVendorCriteriaList");
        }
        return mv;
    }

    public ModelAndView editVendorTechnicalCriteriaSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user = (UserMaster) session1.getAttribute("user");

        String username = user.getLoginName();
        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        String id = request.getParameter("id");
        String groupName = request.getParameter("groupName");
        String groupCategoryName = request.getParameter("groupCategoryName");
        String subCategoryName = request.getParameter("subCategoryName");
        String[] criteriaName = request.getParameterValues("Criteria");
        String[] criteriaDescription = request.getParameterValues("CriteriaDescription");
        String[] mandatory = request.getParameterValues("mandatory");
        String DepartmentCategory = request.getParameter("DepartmentCategory");
        if (groupCategoryName == null || groupCategoryName == "") {
            groupCategoryName = "0";
        }

        if (subCategoryName == null || subCategoryName == "") {
            subCategoryName = "0";
        }
        VendorCriteriaMaster vendorCriteriaMaster = vendorCriteriaMasterService.readById(Integer.parseInt(id));
        vendorCriteriaMaster.setGroupMasterId(Integer.parseInt(groupName));
        vendorCriteriaMaster.setGroupCategoryId(Integer.parseInt(groupCategoryName));
        vendorCriteriaMaster.setGroupSubCategoryId(Integer.parseInt(subCategoryName));
        vendorCriteriaMaster.setDepartmentCategory(DepartmentCategory);
        vendorCriteriaMasterService.update(vendorCriteriaMaster);

        for (int i = 0; i < criteriaName.length; i++) {
            if (!criteriaName[i].equals("") && !criteriaDescription[i].equals("")) {

                try {

                    VendorCriteriaMasterDetails vendorCriteriaMasterDetails = new VendorCriteriaMasterDetails();
                    vendorCriteriaMasterDetails.setCriteriaName(criteriaName[i]);
                    vendorCriteriaMasterDetails.setCriteriaDescription(criteriaDescription[i]);
                    vendorCriteriaMasterDetails.setMandatory(mandatory[i].equals("") ? "No" : mandatory[i]);
                    vendorCriteriaMasterDetails.setCompulsaryFlag("0");
                    vendorCriteriaMasterDetails.setVendorCriteriaMasterId(vendorCriteriaMaster.getId());
                    vendorCriteriaMasterDetailsService.create(vendorCriteriaMasterDetails);

                    VendorCriteriaDetailsHistory criteriaDetailsHistory = new VendorCriteriaDetailsHistory();
                    criteriaDetailsHistory.setCriteriaName(criteriaName[i]);
                    criteriaDetailsHistory.setCriteriaDescription(criteriaDescription[i]);
                    criteriaDetailsHistory.setMandatory(mandatory[i]);
                    criteriaDetailsHistory.setCompulsary("0");
                    criteriaDetailsHistory.setActionBy("Created");
                    criteriaDetailsHistory.setDate(formattedDate1);
                    criteriaDetailsHistory.setVendorCriteriaMasterHistoryId(0);
                    criteriaDetailsHistory.setAction(username);
                    criteriaDetailsHistory.setVendorCriteriaMasterId(vendorCriteriaMaster.getId());
                    vendorCriteriaDetailsHistoryService.create(criteriaDetailsHistory);

                } catch (Exception e) {

                    e.printStackTrace();

                }
            }

        }
        session1.setAttribute("successMessage", "Vendor Criteria Edited successfully");
        mv.setViewName("redirect:vendorCriteriaMaster.htm?act=showVendorCriteriaList");
        return mv;
    }

    public ModelAndView editVendorTechnicalCriteriaPartTwo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        VendorCriteriaMasterDetails vendorTechnicalCriteria = vendorCriteriaMasterDetailsService.readById(Integer.parseInt(id));
        mv.getModelMap().put("vendorTechnicalCriteria", vendorTechnicalCriteria);
        mv.getModelMap().put("id", id);
        mv.setViewName("Vendor/EditVendorTechnicalCriteriaPartTwo");
        return mv;
    }

    public ModelAndView editVendorTechnicalCriteriaPartTwoSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();HttpSession session1 = request.getSession(false);
        UserMaster user = (UserMaster) session1.getAttribute("user");
        String username = user.getLoginName();
        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj1.format(myFormatObj1);
        
        String id = request.getParameter("id");

        String criteriaName = request.getParameter("criteriaName");
        String criteriaDescription = request.getParameter("criteriaDescription");
        String mandatory = request.getParameter("mandatory");

        VendorCriteriaMasterDetails vendorCriteriaMasterDetails = vendorCriteriaMasterDetailsService.readById(Integer.parseInt(id));
        vendorCriteriaMasterDetails.setCriteriaName(criteriaName);
        vendorCriteriaMasterDetails.setCriteriaDescription(criteriaDescription);
        vendorCriteriaMasterDetails.setMandatory(mandatory);
        vendorCriteriaMasterDetails.setCompulsaryFlag("0");
        vendorCriteriaMasterDetailsService.update(vendorCriteriaMasterDetails);
        
        VendorCriteriaDetailsHistory criteriaDetailsHistory = new VendorCriteriaDetailsHistory();
        criteriaDetailsHistory.setCriteriaName(vendorCriteriaMasterDetails.getCriteriaName());
        criteriaDetailsHistory.setCriteriaDescription(vendorCriteriaMasterDetails.getCriteriaDescription());
        criteriaDetailsHistory.setMandatory(vendorCriteriaMasterDetails.getMandatory());
        criteriaDetailsHistory.setCompulsary(vendorCriteriaMasterDetails.getCompulsaryFlag());
        criteriaDetailsHistory.setActionBy("Edited");
        criteriaDetailsHistory.setAction(username);
        criteriaDetailsHistory.setDate(formattedDate);
        criteriaDetailsHistory.setVendorCriteriaMasterHistoryId(0);
        criteriaDetailsHistory.setVendorCriteriaMasterId(vendorCriteriaMasterDetails.getVendorCriteriaMasterId());
        vendorCriteriaDetailsHistoryService.create(criteriaDetailsHistory);

        mv.setViewName("redirect:vendorCriteriaMaster.htm?act=editVendorCriteria&id=" + vendorCriteriaMasterDetails.getVendorCriteriaMasterId());
        return mv;
    }

    public ModelAndView deleteVendorCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");

        for (String checkedValues : idArray) {

            List criteriaMasterDetails = vendorCriteriaMasterDetailsService.readByCriteriaMasterId(checkedValues);

            try {

                for (Object o : criteriaMasterDetails) {
                    VendorCriteriaMasterDetails vendorCriteriaMasterDetails = (VendorCriteriaMasterDetails) o;
                    int id3 = vendorCriteriaMasterDetails.getId();
                    vendorCriteriaMasterDetailsService.delete(id3);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                vendorCriteriaMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mv.setViewName("redirect:vendorCriteriaMaster.htm?act=showVendorCriteriaList");
        return mv;
    }

    public ModelAndView vendorCriteriaPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "a.id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "b.group_name";
                    break;
                case "3":
                    orderColumn = "c.group_category_name";
                    break;
                case "4":
                    orderColumn = "d.sub_category_name";
                    break;
                case "5":
                    orderColumn = "a.department_category";
                    break;

                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = vendorCriteriaMasterService.getVendorCriteriaPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = vendorCriteriaMasterService.getTotalVendorCriteriaCount();

        int filteredRecords = vendorCriteriaMasterService.getFilteredVendorCriteriaCount(searchValue);

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

            if (isDesc) {
                map.put("srNo", srNo--);
            } else {
                map.put("srNo", srNo++);
            }

            map.put("groupName", row[1] != null ? row[1] : "");

            map.put("groupCatogryName", row[2] != null ? row[2] : "");

            map.put("subCategoryName", row[3] != null ? row[3] : "");

            map.put("departmentCategory", row[4] != null ? row[4] : "");

            map.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='vendorCriteriaMaster.htm?act=editVendorCriteria&id="
                    + (row[0] != null ? row[0] : "")
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
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

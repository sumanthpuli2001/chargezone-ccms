/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vendor;

import com.bul.zydex.model.GroupCategory;
import com.bul.zydex.model.GroupMaster;
import com.bul.zydex.model.GroupSubCategory;
import com.bul.zydex.model.VendorCriteriaMaster;
import com.bul.zydex.model.VendorCriteriaMasterDetails;
import com.bul.zydex.model.VendorHrCriteria;
import com.bul.zydex.model.VendorSafetyCriteria;
import com.bul.zydex.model.VendorTechnicalCriteria;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class GroupController extends GroupAbstract {

    public ModelAndView showGroupMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Vendor/ShowGroupMasterList");
        return mv;
    }

    public ModelAndView groupMasterListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "groupName";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = groupMasterService.getGroupMasterPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = groupMasterService.getTotalGroupMasterCount();

        int filteredRecords = groupMasterService.getFilteredGroupMasterCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            GroupMaster groupMaster = (GroupMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + groupMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("groupName", groupMaster.getGroupName() != null ? groupMaster.getGroupName() : "");

            json.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='group.htm?act=editGroupMaster&id="
                    + groupMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + groupMaster.getId() + "'>"
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

    public ModelAndView createGroupMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Vendor/CreateGroupMaster");
        return mv;
    }

    public ModelAndView submitGroupMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String groupName = request.getParameter("groupName");
        GroupMaster groupMaster = new GroupMaster();

        groupMaster.setGroupName(groupName);

        if (!groupMasterService.isExist(groupMaster)) {
            groupMasterService.create(groupMaster);

            session.setAttribute("successMessage", "Group Master Created Successfully");
            mv.setViewName("redirect:group.htm?act=showGroupMasterList");
        } else {

            session.setAttribute("failureMessage", "Group Master Already Exist. Please Enter New Group Name");
            mv.setViewName("redirect:group.htm?act=createGroupMaster");
        }
        return mv;
    }

    public ModelAndView editGroupMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        GroupMaster groupMaster = groupMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("groupMaster", groupMaster);

        mv.setViewName("Vendor/EditGroupMaster");
        return mv;
    }

    public ModelAndView editGroupMasterSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String groupName = request.getParameter("groupName");

        GroupMaster groupMaster = groupMasterService.readById(Integer.parseInt(id));
        groupMaster.setGroupName(groupName);
        groupMasterService.update(groupMaster);

        session.setAttribute("successMessage", "Group Master Edited Successfully");
        mv.setViewName("redirect:group.htm?act=showGroupMasterList");

        return mv;

    }

    public ModelAndView deleteAllGroupMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            groupMasterService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:group.htm?act=showGroupMasterList");
        return mv;
    }

    public ModelAndView deleteGroupMasterById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        try {
            groupMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.setViewName("redirect:group.htm?act=showGroupMasterList");
        return mv;

    }

    public ModelAndView showGroupCategoryList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Vendor/ShowGroupCategoryList");
        return mv;
    }

    public ModelAndView groupCategoryListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "b.groupName";
                    break;
                case "3":
                    orderColumn = "a.groupCatogryName";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List groupCategoryList = groupCategoryService.getGroupCategoryPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = groupCategoryService.getTotalGroupCategoryCount();

        int filteredRecords = groupCategoryService.getFilteredGroupCategoryCount(searchValue);

        List data = new ArrayList();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Iterator it = groupCategoryList.iterator(); it.hasNext();) {

            Object[] row = (Object[]) it.next();

            Map map = new HashMap();

            map.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + (row[0] != null ? row[0] : "") + "'>");

            if (isDesc) {
                map.put("srNo", srNo--);
            } else {
                map.put("srNo", srNo++);
            }

            map.put("groupName", row[1] != null ? row[1] : "");

            map.put("groupCatogryName", row[2] != null ? row[2] : "");

            map.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='group.htm?act=editGroupCategory&id="
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

    public ModelAndView createGroupCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        List list = groupMasterService.read();
        mv.getModelMap().put("list", list);

        mv.setViewName("Vendor/CreateGroupCategory");
        return mv;
    }

    public ModelAndView submitGroupCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String groupName = request.getParameter("groupName");
        String groupCategoryName = request.getParameter("groupCategoryName");

        GroupCategory groupCategory = new GroupCategory();
        groupCategory.setGroupMasterId(Integer.parseInt(groupName));
        groupCategory.setGroupCatogryName(groupCategoryName);

        if (!groupCategoryService.isExist(groupCategory)) {
            groupCategoryService.create(groupCategory);

            session.setAttribute("successMessage", "Group Category Created Successfully");
            mv.setViewName("redirect:group.htm?act=showGroupCategoryList");
        } else {

            session.setAttribute("failureMessage", "Group Category Already Exist. Please Enter New Group Category");
            mv.setViewName("redirect:group.htm?act=createGroupCategory");
        }
        return mv;
    }

    public ModelAndView editGroupCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        GroupCategory groupCategory = groupCategoryService.readByIds(Integer.parseInt(id));
        mv.getModelMap().put("groupCategory", groupCategory);

        List list = groupMasterService.read();
        mv.getModelMap().put("list", list);

        mv.setViewName("Vendor/EditGroupCategory");
        return mv;
    }

    public ModelAndView editGroupCategorySubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String groupName = request.getParameter("groupName");
        String groupCategoryName = request.getParameter("groupCategoryName");

        GroupCategory groupCategory = groupCategoryService.readByIds(Integer.parseInt(id));
        groupCategory.setGroupMasterId(Integer.parseInt(groupName));
        groupCategory.setGroupCatogryName(groupCategoryName);
        groupCategoryService.update(groupCategory);

        session.setAttribute("successMessage", "Group Category Edited Successfully");
        mv.setViewName("redirect:group.htm?act=showGroupCategoryList");
        return mv;

    }

    public ModelAndView deleteAllGroupCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            groupCategoryService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:group.htm?act=showGroupCategoryList");
        return mv;
    }

    public ModelAndView deleteGroupCategoryById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        try {
            groupCategoryService.delete(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.setViewName("redirect:group.htm?act=showGroupCategoryList");
        return mv;

    }

    public ModelAndView showGroupSubCategoryList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Vendor/ShowGroupSubCategoryList");
        return mv;
    }

    public ModelAndView groupSubCategoryListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "b.groupName";
                    break;
                case "3":
                    orderColumn = "c.groupCatogryName";
                    break;
                case "4":
                    orderColumn = "a.subCategoryName";
                    break;
                case "6":
                    orderColumn = "a.riskCategory";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List groupSubCategoryList = groupSubCategoryService.getGroupSubCategoryPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = groupSubCategoryService.getTotalGroupSubCategoryCount();

        int filteredRecords = groupSubCategoryService.getFilteredGroupSubCategoryCount(searchValue);

        List data = new ArrayList();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Iterator it = groupSubCategoryList.iterator(); it.hasNext();) {

            Object[] row = (Object[]) it.next();

            Map map = new HashMap();

            map.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + (row[0] != null ? row[0] : "") + "'>");

            if (isDesc) {
                map.put("srNo", srNo--);
            } else {
                map.put("srNo", srNo++);
            }

            map.put("groupName", row[1] != null ? row[1] : "");

            map.put("groupCatogryName", row[2] != null ? row[2] : "");

            map.put("groupSubCatogryName", row[3] != null ? row[3] : "");

            map.put("riskCategory", row[8] != null ? row[8] : "");

            StringBuilder sb = new StringBuilder();

            sb.append((row[4] != null && "1".equals(row[4].toString()))
                    ? "<i class='fa fa-check-circle text-success'></i>&nbsp;&nbsp;HR"
                    : "<i class='fa fa-times-circle text-danger'></i>&nbsp;&nbsp;HR");

            sb.append("<br>");

            sb.append((row[6] != null && "1".equals(row[6].toString()))
                    ? "<i class='fa fa-check-circle text-success'></i>&nbsp;&nbsp;IT"
                    : "<i class='fa fa-times-circle text-danger'></i>&nbsp;&nbsp;IT");

            sb.append("<br>");

            sb.append((row[5] != null && "1".equals(row[5].toString()))
                    ? "<i class='fa fa-check-circle text-success'></i>&nbsp;&nbsp;HSE"
                    : "<i class='fa fa-times-circle text-danger'></i>&nbsp;&nbsp;HSE");

            sb.append("<br>");

            sb.append((row[7] != null && "1".equals(row[7].toString()))
                    ? "<i class='fa fa-check-circle text-success'></i>&nbsp;&nbsp;TECHNICAL"
                    : "<i class='fa fa-times-circle text-danger'></i>&nbsp;&nbsp;TECHNICAL");

            map.put("criteriaName", sb);

            map.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='group.htm?act=editGroupSubCategory&id="
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

    public ModelAndView createGroupSubCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        List list = groupMasterService.read();
        List list1 = groupCategoryService.read();
        List list2 = RiskCategoryService.read();
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("list1", list1);
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
        mv.setViewName("Vendor/CreateGroupSubCategory");
        return mv;
    }

    public void selectgroupCategoryByGroupName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String groupName = request.getParameter("groupName");
        JSONObject jsonobj = new JSONObject();
        JSONArray array = new JSONArray();
        List list = groupCategoryService.readByGroupMasterId(Integer.parseInt(groupName));
        for (Object o : list) {
            GroupCategory groupCategory = (GroupCategory) o;
            Map<String, String> map = new HashMap<>();
            map.put("id", "" + groupCategory.getId());
            map.put("groupCategoryName", "" + groupCategory.getGroupCatogryName());
            array.put(map);
        }
        jsonobj.put("groupCategory", array);
        response.getWriter().println(jsonobj.toString());
    }

    public void selectgroupSubCategoryByGroupCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String groupCategoryName = request.getParameter("groupCategoryName");
        JSONObject jsonobj = new JSONObject();
        JSONArray array = new JSONArray();
        List list = groupSubCategoryService.readByGroupMasterId(Integer.parseInt(groupCategoryName));
        for (Object o : list) {
            GroupSubCategory groupSubCategory = (GroupSubCategory) o;
            Map<String, String> map = new HashMap<>();
            map.put("id", "" + groupSubCategory.getId());
            map.put("subCategoryName", "" + groupSubCategory.getSubCategoryName());
            array.put(map);
        }
        jsonobj.put("groupSubCategory", array);
        response.getWriter().println(jsonobj.toString());
    }

    public ModelAndView submitGroupSubCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String groupName = request.getParameter("groupName");
        String groupCategoryName = request.getParameter("groupCategoryName");
        String groupSubCategoryName = request.getParameter("groupSubCategoryName");
        String riskCategory = request.getParameter("riskCategory");
        String hr = request.getParameter("hr");
        String hse = request.getParameter("hse");
        String it = request.getParameter("it");
        String technical = request.getParameter("technical");
        String remark = request.getParameter("remark");
        String attachment = "";

        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("attachment");

            if (multipartFile != null && !multipartFile.isEmpty()) {

                String uploadPath = request.getServletContext().getRealPath("/")
                        + File.separator + "StorageYard"
                        + File.separator + "GroupSubCategory"
                        + File.separator;

                File dir = new File(uploadPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String newFileName = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                File newFile = new File(dir, newFileName);

                multipartFile.transferTo(newFile);

                attachment = newFileName;
            } else {
                mv.getModelMap().put("error", "No file selected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            mv.getModelMap().put("error", "Exception occurred: " + e.getMessage());
        }

        if (hr == null) {
            hr = "0";
        }
        if (hse == null) {
            hse = "0";
        }
        if (it == null) {
            it = "0";
        }
        if (technical == null) {
            technical = "0";
        }

        GroupSubCategory groupSubCategory = new GroupSubCategory();
        groupSubCategory.setGroupMasterId(Integer.parseInt(groupName));
        groupSubCategory.setGroupCategoryId(Integer.parseInt(groupCategoryName));
        groupSubCategory.setSubCategoryName(groupSubCategoryName);
        groupSubCategory.setRiskCategory(riskCategory);
        groupSubCategory.setHr(hr);
        groupSubCategory.setHsc(hse);
        groupSubCategory.setIt(it);
        groupSubCategory.setTechnical(technical);
        groupSubCategory.setAttachment(attachment);
        groupSubCategory.setRemark(remark);

        if (!groupSubCategoryService.isExist(groupSubCategory)) {
            groupSubCategoryService.create(groupSubCategory);

            session.setAttribute("successMessage", "Group Sub Category Created Successfully");
            mv.setViewName("redirect:group.htm?act=showGroupSubCategoryList");
        } else {

            session.setAttribute("failureMessage", "Group Sub Category Already Exist. Please Enter New Group Sub Category");
            mv.setViewName("redirect:group.htm?act=createGroupSubCategory");
        }
        return mv;
    }

    public ModelAndView editGroupSubCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        GroupSubCategory groupSubCategory = groupSubCategoryService.readByIds(Integer.parseInt(id));
        int groupMasterId = groupSubCategory.getGroupMasterId();
        GroupMaster groupMaster = groupMasterService.readById(groupMasterId);
        int groupCategoryId = groupSubCategory.getGroupCategoryId();
        GroupCategory groupCategory = groupCategoryService.readById(groupCategoryId);
        List list = groupMasterService.read();
        List list1 = RiskCategoryService.read();
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("groupMaster", groupMaster);
        mv.getModelMap().put("groupCategory", groupCategory);
        mv.getModelMap().put("groupSubCategory", groupSubCategory);

        mv.setViewName("Vendor/EditGroupSubCategory");
        return mv;
    }

    public ModelAndView editGroupSubCategorySubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String groupName = request.getParameter("groupName");
        String groupCategoryName = request.getParameter("groupCategoryName");
        String subCategoryName = request.getParameter("subCategoryName");
        String riskCategory = request.getParameter("riskCategory");
        String hr = request.getParameter("hr");
        String hse = request.getParameter("hse");
        String it = request.getParameter("it");
        String technical = request.getParameter("technical");
        String attachment = request.getParameter("attachment");
        String attachment1 = request.getParameter("attachment1");
        String remark = request.getParameter("remark");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("attachment");
        try {
            if (multipartFile != null && !multipartFile.isEmpty()) {
                String fileLocationURL = request.getServletContext().getRealPath("/")
                        + File.separator + "StorageYard"
                        + File.separator + "GroupSubCategory"
                        + File.separator;

                File dir = new File(fileLocationURL);
                attachment = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                File newFile = new File(fileLocationURL + attachment);
                multipartFile.transferTo(newFile);
            } else {
                attachment = attachment1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (hr == null) {
            hr = "0";
        }
        if (hse == null) {
            hse = "0";
        }
        if (it == null) {
            it = "0";
        }
        if (technical == null) {
            technical = "0";
        }
        GroupSubCategory groupSubCategory = groupSubCategoryService.readByIds(Integer.parseInt(id));
        groupSubCategory.setGroupMasterId(Integer.parseInt(groupName));
        groupSubCategory.setGroupCategoryId(Integer.parseInt(groupCategoryName));
        groupSubCategory.setSubCategoryName(subCategoryName);
        groupSubCategory.setRiskCategory(riskCategory);
        groupSubCategory.setHr(hr);
        groupSubCategory.setHsc(hse);
        groupSubCategory.setIt(it);
        groupSubCategory.setTechnical(technical);
        groupSubCategory.setAttachment(attachment);
        groupSubCategory.setRemark(remark);
        groupSubCategoryService.update(groupSubCategory);

        session.setAttribute("successMessage", "Group Sub Category Edited Successfully");
        mv.setViewName("redirect:group.htm?act=showGroupSubCategoryList");
        return mv;

    }

    public ModelAndView downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String fileName = request.getParameter("fileName");
        String id = request.getParameter("id");

        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "GroupSubCategory"
                + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        mv.setViewName("redirect:group.htm?act=showGroupSubCategoryList");
        return mv;
    }

    public ModelAndView deleteGroupSubCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            groupSubCategoryService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:group.htm?act=showGroupSubCategoryList");
        return mv;
    }

    public ModelAndView deleteGroupSubCategoryById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        try {
            groupSubCategoryService.delete(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.setViewName("redirect:group.htm?act=showGroupSubCategoryList");
        return mv;
    }

    public ModelAndView showVendorTechnicalCriteriaList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List list = vendorTechnicalCriteriaService.readAll();
        request.setAttribute("list", list);
        mv.setViewName("Vendor/ShowVendorTechnicalCriteriaList");
        return mv;
    }

   
    public ModelAndView submitVendorTechnicalCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);

        String groupName = request.getParameter("groupName");
        String groupCategoryName = request.getParameter("groupCategoryName");
        String SubCategoryName = request.getParameter("SubCategoryName");
        String[] criteriaName = request.getParameterValues("Criteria");
        String[] criteriaDescription = request.getParameterValues("CriteriaDescription");
        String[] mandatory = request.getParameterValues("mandatory");
        String[] checkbox = request.getParameterValues("checkbox");

        if (checkbox == null) {
            checkbox = new String[]{"0"};
        }

        try {

            for (int i = 0; i < criteriaName.length; i++) {

                VendorTechnicalCriteria vendorTechnicalCriteria = new VendorTechnicalCriteria();
                vendorTechnicalCriteria.setCriteriaName(criteriaName[i]);
                vendorTechnicalCriteria.setCriteriaDescription(criteriaDescription[i]);

                vendorTechnicalCriteria.setGroupMasterId(Integer.parseInt(groupName));
                vendorTechnicalCriteria.setGroupCategoryId(Integer.parseInt(groupCategoryName));
                vendorTechnicalCriteria.setGroupSubCategoryId(Integer.parseInt(SubCategoryName));
                vendorTechnicalCriteria.setMandatory(mandatory[i]);
                vendorTechnicalCriteria.setCompulsaryFlag(checkbox[i]);
                vendorTechnicalCriteriaService.create(vendorTechnicalCriteria);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        session1.setAttribute("successMessage", "Vendor Criteria  Created Successfully");

        mv.setViewName("redirect:vendorCriteriaMaster.htm?act=showVendorCriteriaList");

        return mv;
    }

    public ModelAndView deleteVendorTechnicalCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            vendorTechnicalCriteriaService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv = showVendorTechnicalCriteriaList(request, response);
        return mv;
    }

    public ModelAndView editVendorTechnicalCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        int groupSubCategoryId = Integer.parseInt(id);

        GroupSubCategory groupSubCategory = groupSubCategoryService.readById(groupSubCategoryId);
        int groupMasterId = groupSubCategory.getGroupMasterId();
        GroupMaster groupMaster = groupMasterService.readById(groupMasterId);
        int groupCategoryId = groupSubCategory.getGroupCategoryId();
        GroupCategory groupCategory = groupCategoryService.readById(groupCategoryId);
        List list2 = vendorTechnicalCriteriaService.readAllVendorTechnicalCriteria(groupSubCategoryId, groupMasterId, groupCategoryId);

        List list = groupMasterService.read();
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("groupMaster", groupMaster);
        mv.getModelMap().put("groupMasterId", groupMasterId);
        mv.getModelMap().put("groupCategory", groupCategory);
        mv.getModelMap().put("groupSubCategory", groupSubCategory);
        mv.setViewName("Vendor/EditVendorTechnicalCriteria");
        return mv;
    }

   

    public ModelAndView editVendorTechnicalCriteriaSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String groupName = request.getParameter("groupName");
        String groupCategoryName = request.getParameter("groupCategoryName");
        String subCategoryName = request.getParameter("subCategoryName");
        String[] criteriaName = request.getParameterValues("Criteria");
        String[] criteriaDescription = request.getParameterValues("CriteriaDescription");
        String[] mandatory = request.getParameterValues("mandatory");
        String[] checkbox = request.getParameterValues("checkbox");

        try {

            for (int i = 0; i < criteriaName.length; i++) {

                VendorTechnicalCriteria vendorTechnicalCriteria = new VendorTechnicalCriteria();
                vendorTechnicalCriteria.setCriteriaName(criteriaName[i]);
                vendorTechnicalCriteria.setCriteriaDescription(criteriaDescription[i]);

                vendorTechnicalCriteria.setGroupMasterId(Integer.parseInt(groupName));
                vendorTechnicalCriteria.setGroupCategoryId(Integer.parseInt(groupCategoryName));
                vendorTechnicalCriteria.setGroupSubCategoryId(Integer.parseInt(subCategoryName));
                vendorTechnicalCriteria.setMandatory(mandatory[i].equals("") ? "No" : mandatory[i]);

                vendorTechnicalCriteria.setCompulsaryFlag(checkbox[i].equals("") ? "0" : checkbox[i]);

                if (!criteriaName[i].equals("") && !criteriaDescription[i].equals("")) {
                    vendorTechnicalCriteriaService.create(vendorTechnicalCriteria);
                }
                request.setAttribute("successMessage","Vendor Criteria Edited Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        mv = showVendorTechnicalCriteriaList(request, response);
        return mv;

    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List list = vendorHrCriteriaService.readByAll();
        request.setAttribute("list", list);

        mv.setViewName("Vendor/ShowList");
        return mv;
    }

    public ModelAndView CreateHrCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List list = groupMasterService.read();
        List list1 = groupCategoryService.read();
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("list", list);
        mv.setViewName("Vendor/HrCriteriaCreate");
        return mv;
    }

    public ModelAndView submitHrCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String groupName = request.getParameter("groupName");

        String[] criteriaName = request.getParameterValues("criteriaName");
        String[] criteriaDescription = request.getParameterValues("criteriaDescription");
        String[] mandatory = request.getParameterValues("mandatory");
        String[] checkbox = request.getParameterValues("yesNo");

        try {

            for (int i = 0; i < criteriaName.length; i++) {

                VendorHrCriteria vendorHrCriteria = new VendorHrCriteria();

                vendorHrCriteria.setCriteriaName(criteriaName[i]);
                vendorHrCriteria.setCriteriaDescription(criteriaDescription[i]);

                vendorHrCriteria.setGroupId(groupName);
                vendorHrCriteria.setMandatory(mandatory[i].equals("") ? "No" : mandatory[i]);
                vendorHrCriteria.setCompulsaryFlag(checkbox[i].equals("") ? "0" : checkbox[i]);
                if (!criteriaName[i].equals("") && !criteriaDescription[i].equals("")) {
                    vendorHrCriteriaService.create(vendorHrCriteria);
                }
            }
        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        request.setAttribute("successMessage", "Information: HR Criteria Created successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView hrCriteriaEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        VendorHrCriteria vendorHrCriteria = vendorHrCriteriaService.readById(Integer.parseInt(id));
        List list = groupMasterService.read();
        List list1 = groupCategoryService.read();
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("vendorHrCriteria", vendorHrCriteria);
        mv.setViewName("Vendor/HrCriteriaEdit");
        return mv;
    }

    public ModelAndView hrCriteriaEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String criterianame = request.getParameter("criteriaName");
        String groupName = request.getParameter("groupName");
        String criteriadescription = request.getParameter("criteriaDescription");
        String mandatory = request.getParameter("mandatory");
        String checkbox = request.getParameter("checkbox");
        if (checkbox == null) {
            checkbox = "0";
        }

        VendorHrCriteria vendorHrCriteria = vendorHrCriteriaService.readById(Integer.parseInt(id));
        vendorHrCriteria.setCriteriaName(criterianame);
        vendorHrCriteria.setMandatory(mandatory);
        vendorHrCriteria.setCompulsaryFlag(checkbox);
        vendorHrCriteria.setGroupId(groupName);
        vendorHrCriteria.setCriteriaDescription(criteriadescription);
        vendorHrCriteriaService.update(vendorHrCriteria);

        request.setAttribute("successMessage", "Information: HR Criteria edit successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView deleteHrCriteriaDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            vendorHrCriteriaService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView showList1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List list = vendorSafetyCriteriaService.readByAll();
        request.setAttribute("list", list);

        mv.setViewName("Vendor/ShowList1");
        return mv;
    }

    public ModelAndView CreateSafetyCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List list = groupMasterService.read();
        List list1 = groupCategoryService.read();
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("list", list);
        mv.setViewName("Vendor/SafetyCriteriaCreate");
        return mv;
    }

    public ModelAndView submitSafetyCriteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String groupName = request.getParameter("groupName");

        String[] criteriaName = request.getParameterValues("criteriaName");
        String[] criteriaDescription = request.getParameterValues("criteriaDescription");
        String[] mandatory = request.getParameterValues("mandatory");
        String[] checkbox = request.getParameterValues("checkbox");

        if (checkbox == null) {
            checkbox = new String[]{"0"};
        }

        try {

            for (int i = 0; i < criteriaName.length; i++) {
                VendorSafetyCriteria vendorSafetyCriteria = new VendorSafetyCriteria();
                vendorSafetyCriteria.setCriteriaName(criteriaName[i]);
                vendorSafetyCriteria.setCriteriaDescription(criteriaDescription[i]);
                vendorSafetyCriteria.setCompulsaryFlag(checkbox[i].equals("") ? "0" : checkbox[i]);
                vendorSafetyCriteria.setGroupId(groupName);
                vendorSafetyCriteria.setMandatory(mandatory[i].equals("") ? "No" : mandatory[i]);

                if (!criteriaName[i].equals("") && !criteriaDescription[i].equals("")) {

                    vendorSafetyCriteriaService.create(vendorSafetyCriteria);
                }
            }
        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }
        request.setAttribute("successMessage", "Information: Safety Criteria Created successfully");
        mv = showList1(request, response);
        return mv;
    }

    public ModelAndView safetyCriteriaEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        VendorSafetyCriteria vendorSafetyCriteria = vendorSafetyCriteriaService.readById(Integer.parseInt(id));

        mv.getModelMap().put("vendorSafetyCriteria", vendorSafetyCriteria);
        mv.setViewName("Vendor/SafetyCriteriaEdit");
        return mv;
    }

    public ModelAndView safetyCriteriaEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String criterianame = request.getParameter("criteriaName");
        String criteriadecription = request.getParameter("criteriaDescription");
        String mandatory = request.getParameter("mandatory");
        String checkbox = request.getParameter("checkbox");

        if (checkbox == null) {
            checkbox = "0";
        }

        VendorSafetyCriteria vendorSafetyCriteria = vendorSafetyCriteriaService.readById(Integer.parseInt(id));
        vendorSafetyCriteria.setCriteriaName(criterianame);
        vendorSafetyCriteria.setMandatory(mandatory);
        vendorSafetyCriteria.setCompulsaryFlag(checkbox);
        vendorSafetyCriteria.setCriteriaDescription(criteriadecription);
        vendorSafetyCriteriaService.update(vendorSafetyCriteria);

        request.setAttribute("successMessage", "Information: Safety Criteria edit successfully");
        mv = showList1(request, response);
        return mv;
    }

    public ModelAndView deleteSafetyCriteriaDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            vendorSafetyCriteriaService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv = showList1(request, response);
        return mv;
    }

    public ModelAndView criteiaDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        VendorTechnicalCriteria vendorTechnicalCriteria = vendorTechnicalCriteriaService.readById(Integer.parseInt(id));
        vendorTechnicalCriteriaService.delete(Integer.parseInt(id));

        mv.setViewName("forward:group.htm?act=editVendorTechnicalCriteria&id=" + vendorTechnicalCriteria.getGroupSubCategoryId());
        return mv;
    }
}

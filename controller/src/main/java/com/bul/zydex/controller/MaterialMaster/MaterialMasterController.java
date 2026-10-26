/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.MaterialMaster;

import com.bul.zydex.model.MaterialGroupMaster;
import com.bul.zydex.model.MaterialMaster;
import com.bul.zydex.model.MaterialTypeMaster;
import com.bul.zydex.model.UserMaster;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class MaterialMasterController extends MaterialMasterAbstract {

    public ModelAndView showviewList(HttpServletRequest request, HttpServletResponse response, MaterialMaster materialMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> group = materialGroupMasterService.read();
        List type = materialTypeMasterService.read();

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

        request.setAttribute("group", group);
        mv.getModelMap().put("group", group);
        request.setAttribute("type", type);
        mv.getModelMap().put("type", type);
        mv.setViewName("MaterialMaster/CreateMaterialMaster");
        return mv;
    }

    public ModelAndView createMaterial(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        MaterialMaster materialMaster = new MaterialMaster();

        String group = request.getParameter("group");
        MaterialGroupMaster materialGroupMaster = materialGroupMasterService.readById(Integer.parseInt(group));
        String type = request.getParameter("type");

        MaterialTypeMaster materialTypeMaster = materialTypeMasterService.readById(Integer.parseInt(type));
        String materialCode = request.getParameter("materialCode");
        String materialDescription = request.getParameter("materialDescription");
        String materialLongDescription = request.getParameter("materialLongDescription");
        String umo = request.getParameter("umo");
        String hsnNo = request.getParameter("hsnNo");
        String gst = request.getParameter("gst");

        materialMaster.setMaterialCode(materialCode);
        materialMaster.setMaterialDescription(materialDescription);
        materialMaster.setMaterialLongDescription(materialLongDescription);
        materialMaster.setUom(umo);
        materialMaster.setHsnNo(hsnNo);
        materialMaster.setGst(gst);
        materialMaster.setMaterialGroupMaster(materialGroupMaster);
        materialMaster.setMaterialTypeMaster(materialTypeMaster);

        if (materialMasterService.isExist(materialMaster)) {
            materialMasterService.create(materialMaster);

            session.setAttribute("successMessage", "Information : Material  Created Successfully.");
            mv.setViewName("redirect:materialMaster.htm?act=searchPage");

        } else {
            mv.setViewName("redirect:materialMaster.htm?act=showviewList");

            session.setAttribute("failureMessage", "Error : Material Code Already Exist. Please enter new material code ");
        }

        return mv;

    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        List materialList = materialMasterService.readAll();

        mv.getModelMap().put("materialList", materialList);
        request.setAttribute("materialList", materialList);
        mv.setViewName("MaterialMaster/ListMaterialMaster");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            materialMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:materialMaster.htm?act=searchPage");
        return mv;

    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        List<?> group = materialGroupMasterService.read();
        List type = materialTypeMasterService.read();
        request.setAttribute("group", group);
        mv.getModelMap().put("group", group);
        request.setAttribute("type", type);
        mv.getModelMap().put("type", type);

        MaterialMaster materialMaster = materialMasterService.readById(Integer.parseInt(id));

        Integer materialType = materialMaster.getMaterialTypeMaster().getId();

        Integer materialGroup = materialMaster.getMaterialGroupMaster().getId();

        MaterialTypeMaster materialTypeMaster = materialTypeMasterService.readById(materialType);

        MaterialGroupMaster materialGroupMaster = materialGroupMasterService.readById(materialGroup);

        mv.getModelMap().put("materialMaster", materialMaster);
        request.setAttribute("materialMaster", materialMaster);

        mv.getModelMap().put("id", id);
        request.setAttribute("id", id);

        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        request.setAttribute("materialGroupMaster", materialGroupMaster);

        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);
        request.setAttribute("materialTypeMaster", materialTypeMaster);

        mv.setViewName("MaterialMaster/EditMaterialMaster");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");

        MaterialMaster materialMaster = materialMasterService.readById(Integer.parseInt(id));

        String group = request.getParameter("group");
        MaterialGroupMaster materialGroupMaster = materialGroupMasterService.readById(Integer.parseInt(group));
        String type = request.getParameter("type");

        MaterialTypeMaster materialTypeMaster = materialTypeMasterService.readById(Integer.parseInt(type));
        String materialCode = request.getParameter("materialCode");
        String materialDescription = request.getParameter("materialDescription");
        String materialLongDescription = request.getParameter("materialLongDescription");
        String umo = request.getParameter("umo");
        String hsnNo = request.getParameter("hsnNo");
        String gst = request.getParameter("gst");

        materialMaster.setMaterialCode(materialCode);
        materialMaster.setMaterialDescription(materialDescription);
        materialMaster.setMaterialLongDescription(materialLongDescription);
        materialMaster.setUom(umo);
        materialMaster.setHsnNo(hsnNo);
        materialMaster.setGst(gst);
        materialMaster.setMaterialGroupMaster(materialGroupMaster);
        materialMaster.setMaterialTypeMaster(materialTypeMaster);

        materialMasterService.update(materialMaster);

        session.setAttribute("successMessage",
                "Information: Material Edited successfully ");

        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);

        mv.setViewName("redirect:materialMaster.htm?act=searchPage");
        return mv;

    }

    public ModelAndView searchPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        
        MaterialMaster materialMaster = new MaterialMaster();
        List group = materialGroupMasterService.read();
        List type = materialTypeMasterService.read();

        request.setAttribute("group", group);
        mv.getModelMap().put("group", group);
        request.setAttribute("type", type);
        mv.getModelMap().put("type", type);

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
        mv.setViewName("MaterialMaster/SearchMaterialMaster");
        return mv;
    }

    public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        MaterialMaster materialMaster = new MaterialMaster();
        List group1 = materialGroupMasterService.read();
        List type1 = materialTypeMasterService.read();

        request.setAttribute("group1", group1);
        mv.getModelMap().put("group1", group1);
        request.setAttribute("type1", type1);
        mv.getModelMap().put("type1", type1);

        String group = request.getParameter("group");
        try {
            MaterialGroupMaster materialGroupMaster = materialGroupMasterService.readById(Integer.parseInt(group));
        } catch (Exception e) {

        }
        String type = request.getParameter("type");
        try {
            MaterialTypeMaster materialTypeMaster = materialTypeMasterService.readById(Integer.parseInt(type));
        } catch (Exception e) {

        }
        String materialCode = request.getParameter("materialCode");

        String materialDescription = request.getParameter("materialDescription");

        List list = materialMasterService.search1(materialCode, materialDescription, group, type);
        mv.getModelMap().put("materialMaster", materialMaster);

        mv.getModelMap().put("list", list);
        request.setAttribute("list", list);

        mv.setViewName("forward:materialMaster.htm?act=searchPage");
        return mv;
    }

    public ModelAndView uploadPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List materialMaster = materialMasterService.readAll();

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("materialMaster", materialMaster);
        mv.setViewName("MaterialMaster/UploadPage");
        return mv;
    }

    public ModelAndView uploadMaterialSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        MaterialMaster materialMaster = new MaterialMaster();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String technicalfile = request.getParameter("technicalfile");
        if (technicalfile == null) {
            technicalfile = "";
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile multipartFile = multipartRequest.getFile("technicalfile");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Material Master"
                        + File.separator;
                File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                technicalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Material Master/" + technicalfile);
            //creating a new file instance  
            FileInputStream fis = new FileInputStream(file);
            //obtaining bytes from the file  
            //creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            //creating a Sheet object to retrieve object  
            Iterator< Row> itr = sheet.iterator();
            //iterating over excel file
            System.out.println("The given file is");
            int j = 0;
            while (itr.hasNext()) {
                j++;

                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String srNo = "";
                    String material_type_id = "";
                    String material_group_id = "";
                    String material_code = "";
                    String material_description = "";
                    String material_long_description = "";
                    String uom = "";
                    String hsn_no = "";
                    String gst = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        if (i == 1) {
                            try {
                                srNo = cell.getNumericCellValue() + "";
                            } catch (Exception e1) {
                                srNo = cell.getStringCellValue();
                            }
                        }
                        if (i == 2) {
                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                material_type_id = lonVal + "";
                            } catch (Exception e1) {
                                material_type_id = cell.getStringCellValue();
                            }

                        }
                        if (i == 3) {
                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                material_group_id = lonVal + "";
                            } catch (Exception e1) {
                                material_group_id = cell.getStringCellValue();
                            }

                        }
                        if (i == 4) {

                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                material_code = lonVal + "";
                            } catch (Exception e1) {
                                material_code = cell.getStringCellValue();
                            }

                        }
                        if (i == 5) {
                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                material_description = lonVal + "";
                            } catch (Exception e1) {
                                material_description = cell.getStringCellValue();
                            }
                        }
                        if (i == 6) {
                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                material_long_description = lonVal + "";
                            } catch (Exception e1) {
                                material_long_description = cell.getStringCellValue();
                            }
                        }
                        if (i == 7) {

                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                uom = lonVal + "";
                            } catch (Exception e1) {
                                uom = cell.getStringCellValue();
                            }
                        }
                        if (i == 8) {

                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                hsn_no = lonVal + "";
                            } catch (Exception e1) {
                                hsn_no = cell.getStringCellValue();
                            }
                        }
                        if (i == 9) {

                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                gst = lonVal + "";
                            } catch (Exception e1) {
                                gst = cell.getStringCellValue();
                            }
                        }

                    }

                    List group = materialGroupMasterService.read();
                    List type = materialTypeMasterService.read();

                    List materialMaster1 = materialMasterService.readByMaterialcode(material_code);

                    if (materialMaster1.isEmpty()) {
                        MaterialMaster materialMaster2 = new MaterialMaster();

                        MaterialGroupMaster materialGroupMaster = materialGroupMasterService.readById(Integer.parseInt(material_group_id));
                        MaterialTypeMaster materialTypeMaster = materialTypeMasterService.readById(Integer.parseInt(material_type_id));

                        materialMaster2.setMaterialCode(material_code);
                        materialMaster2.setMaterialDescription(material_description);
                        materialMaster2.setMaterialLongDescription(material_long_description);
                        materialMaster2.setUom(uom);
                        materialMaster2.setHsnNo(hsn_no);
                        materialMaster2.setGst(gst);
                        materialMaster2.setMaterialTypeMaster(materialTypeMaster);
                        materialMaster2.setMaterialGroupMaster(materialGroupMaster);

                        materialMasterService.create(materialMaster2);

                        request.setAttribute("successMessage",
                                "Information: Material  File Uploaded successfully");
                        mv.setViewName("redirect:materialMaster.htm?act=uploadPage");

                    } else {
                        //         materialMasterService.updateMaterialMaster2(id, material_type_id, material_group_id, material_code, material_description, material_long_description, uom, hsn_no, gst);
                        request.setAttribute("failureMessage",
                                "Information: Material code is already Exist.");
                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //List commMaster = commMasterService.readTenderVendorComm(tender_no,username);
        mv.getModelMap().put("materialMaster", materialMaster);
        mv.setViewName("redirect:materialMaster.htm?act=uploadPage");
        return mv;
    }

    public ModelAndView materialPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String group = request.getParameter("group");
        String type = request.getParameter("type");
        String materialCode = request.getParameter("materialCode");
        String materialDescription = request.getParameter("materialDescription");

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
                    orderColumn = "b.materialType";
                    break;
                case "3":
                    orderColumn = "c.materialGroupName";
                    break;
                case "4":
                    orderColumn = "a.materialCode";
                    break;
                case "5":
                    orderColumn = "a.materialDescription";
                    break;
                case "6":
                    orderColumn = "a.materialLongDescription";
                    break;
                case "7":
                    orderColumn = "a.uom";
                    break;
                case "8":
                    orderColumn = "a.hsnNo";
                    break;
                case "9":
                    orderColumn = "a.gst";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = materialMasterService.getMaterialPagination(start, length, searchValue, group, type, materialCode, materialDescription, orderColumn, orderDir);

        int totalRecords = materialMasterService.getTotalMaterialCount();

        int filteredRecords = materialMasterService.getFilteredMaterialCount(group, type, materialCode, materialDescription, searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            JSONObject json = new JSONObject();

            Integer id = row[0] != null ? Integer.parseInt(row[0].toString()) : 0;

            json.put("checkbox",
                    "<input type='checkbox' "
                    + "class='rowCheckbox' "
                    + "value='" + id + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("materialTypeMaster", row[1] != null ? row[1].toString() : "");

            json.put("materialGroupMaster", row[2] != null ? row[2].toString() : "");

            json.put("materialCode", row[3] != null ? row[3].toString() : "");

            json.put("materialDescription", row[4] != null ? row[4].toString() : "");

            json.put("materialLongDescription", row[5] != null ? row[5].toString() : "");

            json.put("uom", row[6] != null ? row[6].toString() : "");

            json.put("hsnNo", row[7] != null ? row[7].toString() : "");

            json.put("gst", row[8] != null ? row[8].toString() : "");

            json.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='materialMaster.htm?act=viewClick&id="
                    + id
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + id + "'>"
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

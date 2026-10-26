/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Invoice;

import static com.bul.zydex.controller.CustomAbstract.dateFormat;
import static com.bul.zydex.controller.CustomAbstract.myIp;
import static com.bul.zydex.controller.CustomAbstract.timeFOrmat;
import com.bul.zydex.model.CouponMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.TenderGeneralDoc;
import com.bul.zydex.model.TenderAdditionalDoc;
import com.bul.zydex.model.TenderTechnicalDoc;
import com.bul.zydex.model.TenderPreQualification;
import com.bul.zydex.model.TenderTechnical;
import com.bul.zydex.model.TenderVendorDoc;
import com.bul.zydex.model.SapTenderMaster;
import com.bul.zydex.model.SapDeliSch;
import com.bul.zydex.model.SapTenderItem;
import com.bul.zydex.model.SapItemLongTxt;
import com.bul.zydex.model.SapPurchaseItemTxt;
import com.bul.zydex.model.SapVendorMaster;
import com.bul.zydex.model.SapVendorEmail;
import com.bul.zydex.model.SapVendorTelephone;
import com.bul.zydex.model.TenderItemAttachment;
import com.bul.zydex.model.TenderItemMaster;
import com.bul.zydex.model.AuthTenderMaster;
import com.bul.zydex.model.AuthTenderPreQualification;
import com.bul.zydex.model.AuthTenderTechnical;
import com.bul.zydex.model.AuthTenderGeneralDoc;
import com.bul.zydex.model.AuthTenderAdditionalDoc;
import com.bul.zydex.model.AuthTenderTechnicalDoc;
import com.bul.zydex.model.AuthTenderItemMaster;
import com.bul.zydex.model.AuthTenderItemAttachment;
import com.bul.zydex.model.AuthTenderVendor;
import com.bul.zydex.model.AuthTenderVendorDoc;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.model.VendorPreBid;
import com.bul.zydex.model.VendorTechnicalBid;
import com.bul.zydex.model.VendorTenderBid;
import com.bul.zydex.model.VendorTenderBidItem;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.model.TenderRegret;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorEmd;
import com.bul.zydex.model.VendorFee;
import com.bul.zydex.model.TenderNoTemp;
import com.bul.zydex.model.TenderNo;
import com.bul.zydex.model.VendorTechnicalBidTechAttachment;
import com.bul.zydex.model.FileDetail;
import com.bul.zydex.model.ServiceDetail1;
import com.bul.zydex.model.ServiceDetail2;
import com.bul.zydex.model.ServiceDetail3;
import com.bul.zydex.model.ServiceDetail4;
import com.bul.zydex.model.ServiceDetail5;
import com.bul.zydex.model.ServiceDetail6;
import com.bul.zydex.model.TenderSendEmail;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.LiveTender;
import com.bul.zydex.model.TenderFollowup;
import com.bul.zydex.model.ServiceVendorTenderBid;
import com.bul.zydex.model.ServiceVendorTenderBidItem;
import com.bul.zydex.model.ServiceVendorTenderBidItem2;
import com.bul.zydex.model.ServiceVendorTenderBidItem3;
import com.bul.zydex.model.ServiceVendorTenderBidItem4;
import com.bul.zydex.model.ServiceVendorTenderBidItem6;
import com.bul.zydex.model.ServiceRights;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.ReviseVendorTenderBid;
import com.bul.zydex.model.ReviseVendorTenderBidItem;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PlantMaster;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.bul.zydex.util.PreQualificationExcel;
import com.bul.zydex.util.BidStatus;
import com.bul.zydex.util.TenderStatus;
import com.bul.zydex.util.VendorBidItem;
import com.bul.zydex.util.LeadTime;
import com.bul.zydex.util.TechnicalSpecificationExcel;
import com.bul.zydex.util.SendMail;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.JCoTable;

import com.bul.zydex.controller.sap.rfc.helper.TableAdapterReader;
import com.bul.zydex.controller.sap.system.model.SapSystem;
import com.bul.zydex.controller.sap.rfc.core.connection.Connection;
import com.bul.zydex.model.AuctionVendor;
import com.bul.zydex.model.CompanyLocation;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.util.DownloadFile;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class PlantMasterController extends PlantMasterAbstract {

    public ModelAndView showPlantList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        PlantMaster plantMaster = new PlantMaster();
        List list = plantMasterService.read();
        request.setAttribute("list", list);
        mv.getModelMap().put("plantMaster", plantMaster);

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

        mv.setViewName("Invoice/ShowPlantList");
        return mv;
    }

    public ModelAndView createPlant(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PlantMaster plantMaster = new PlantMaster();
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
        mv.getModelMap().put("plantMaster", plantMaster);
        mv.setViewName("Invoice/CreatePlant");
        return mv;
    }

    public ModelAndView submitPlantMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String plantName = request.getParameter("plantName");
        String plantCode = request.getParameter("plantCode");
        String location = request.getParameter("location");
        String display = request.getParameter("display");
        if (display == null) {
            display = "0";
        }

        PlantMaster plantMaster = new PlantMaster();
        plantMaster.setPlantName(plantName);
        plantMaster.setPlantCode(plantCode);
        plantMaster.setLocation(location);
        plantMaster.setStatusFlag(Integer.parseInt(display));

        if (!plantMasterService.isExist(plantMaster)) {
            plantMasterService.create(plantMaster);

            session.setAttribute("successMessage", "Plant Created Successfully");
            mv.setViewName("redirect:plantMaster.htm?act=showPlantList");

        } else {

            session.setAttribute("failureMessage", "Plant Already Exist. Please Enter Plant");
            mv.setViewName("redirect:plantMaster.htm?act=createPlant");
        }

        return mv;

    }

    public ModelAndView deletePlantById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            plantMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {
        }
//        request.setAttribute("successMessage",
//                "Information: One or more data deleted successfully");
        mv.setViewName("forward:plantMaster.htm?act=showPlantList");

        return mv;
    }

    public ModelAndView deletePlantDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");
        HttpSession session = request.getSession(false);

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            plantMasterService.delete(Integer.parseInt(checkedValues));
        }
        session.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv.setViewName("redirect:plantMaster.htm?act=showPlantList");

        return mv;
    }

    public ModelAndView editPlant(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        PlantMaster plantMaster = plantMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("plantMaster", plantMaster);
        mv.setViewName("Invoice/EditPlant");
        return mv;
    }

    public ModelAndView editPlantSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String plantName = request.getParameter("plantName");
        String plantCode = request.getParameter("plantCode");
        String location = request.getParameter("location");
        String display = request.getParameter("display");
        if (display == null) {
            display = "0";
        }

        PlantMaster plantMaster = new PlantMaster();
        plantMaster.setId(Integer.parseInt(id));
        plantMaster.setPlantName(plantName);
        plantMaster.setPlantCode(plantCode);
        plantMaster.setLocation(location);
        plantMaster.setStatusFlag(Integer.parseInt(display));
        plantMasterService.update(plantMaster);

        PlantMaster plantMaster1 = plantMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("plantMaster", plantMaster1);
        session.setAttribute("successMessage",
                "Plant edit successfully");
        mv.setViewName("redirect:plantMaster.htm?act=showPlantList");
        return mv;
    }

    public ModelAndView plantPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "plantName";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }
        

        List list = plantMasterService.getCompanyPlantPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = plantMasterService.getTotalPlantCount();

        int filteredRecords = plantMasterService.getFilteredPlantCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            PlantMaster plantMaster = (PlantMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + plantMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("plantName", plantMaster.getPlantName());
            json.put("plantCode", plantMaster.getPlantCode());
            json.put("location", plantMaster.getLocation());
            json.put("statusFlag", plantMaster.getStatusFlag() == 1 ? "Active" : "In Active");
            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='plantMaster.htm?act=editPlant&id="
                    + plantMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + plantMaster.getId() + "'>"
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

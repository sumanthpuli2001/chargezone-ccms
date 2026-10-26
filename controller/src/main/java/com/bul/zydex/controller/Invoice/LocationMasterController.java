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
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.util.DownloadFile;
import java.util.Calendar;

/**
 *
 * @author admin
 */
public class LocationMasterController extends LocationMasterAbstract {
    
    
    public ModelAndView showLocationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LocationMaster locationMaster = new LocationMaster();
        List list = locationMasterService.read();
        request.setAttribute("list", list);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.setViewName("Invoice/ShowLocationList");
        return mv;
    }
    
    public ModelAndView createLocation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LocationMaster locationMaster = new LocationMaster();
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.setViewName("Invoice/CreateLocation");
        return mv;
    }
    
    public ModelAndView submitLocationMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String locationName = request.getParameter("locationName");
        String locationCode = request.getParameter("locationCode");
        String display = request.getParameter("display"); if(display == null) display="0";
        
        LocationMaster locationMaster = new LocationMaster();
        locationMaster.setLocationName(locationName);
        locationMaster.setLocationCode(locationCode);
        locationMaster.setStatusFlag(Integer.parseInt(display));
        locationMasterService.create(locationMaster);
        
        request.setAttribute("successMessage",
                "Information: Location Created successfully");
        mv = showLocationList(request, response);
        return mv;

    }
    
    public ModelAndView deleteLocationDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            locationMasterService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv = showLocationList(request, response);
        return mv;
    }
    
    public ModelAndView editLocation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String id = request.getParameter("id");
        LocationMaster locationMaster = locationMasterService.readById(Integer.parseInt(id));
    
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.setViewName("Invoice/EditLocation");
        return mv;
    }
    
    public ModelAndView editLocationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String id = request.getParameter("id");
        String locationName = request.getParameter("locationName");
        String locationCode = request.getParameter("locationCode");
        String display = request.getParameter("display"); if(display == null) display="0";
        
        LocationMaster locationMaster = new LocationMaster();
        locationMaster.setId(Integer.parseInt(id));
        locationMaster.setLocationName(locationName);
        locationMaster.setLocationCode(locationCode);
        locationMaster.setStatusFlag(Integer.parseInt(display));
        locationMasterService.update(locationMaster);
        
        
        LocationMaster locationMaster1 = locationMasterService.readById(Integer.parseInt(id));
    
        mv.getModelMap().put("locationMaster", locationMaster1);
        request.setAttribute("successMessage",
                "Information: Location edit successfully");
        mv = showLocationList(request, response);
        return mv;
    }
    
    
}

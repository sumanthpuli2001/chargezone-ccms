 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.PR;

import static com.bul.zydex.controller.CustomAbstract.dateFormat;
import static com.bul.zydex.controller.CustomAbstract.myIp;
import com.bul.zydex.controller.Invoice.*;
import static com.bul.zydex.controller.CustomAbstract.timeFOrmat;
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
import com.bul.zydex.model.AocSurveyAttachment;
import com.bul.zydex.model.AuctionVendor;
import com.bul.zydex.model.ClosePr;
import com.bul.zydex.model.ClosePrMultiAttach;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.IteamDetailsAttachments;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.LocationMasters;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.MultipleAddress;
import com.bul.zydex.model.OapSurveyAttachment;
import com.bul.zydex.model.OmsMaster;
import com.bul.zydex.model.PRApprovalComment;
import com.bul.zydex.model.PRItemMaster;
import com.bul.zydex.model.PRNo;
import com.bul.zydex.model.PRMaster;
import com.bul.zydex.model.PRNoTemp;
import com.bul.zydex.model.PRPriceApproval;
import com.bul.zydex.model.PRPriceApprovalComment;
import com.bul.zydex.model.PRPriceApprovalUser;
import com.bul.zydex.model.PRVendor;
import com.bul.zydex.model.PRDoc;
import com.bul.zydex.model.PlantMasters;
import com.bul.zydex.model.ReviseVendorTenderBid;
import com.bul.zydex.model.ServiceRights;
import com.bul.zydex.model.SiteSurvey;
import com.bul.zydex.model.TenderAdditionalDoc;
import com.bul.zydex.model.TenderFollowup;
import com.bul.zydex.model.TenderGeneralDoc;
import com.bul.zydex.model.TenderItemMaster;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.TenderNo;
import com.bul.zydex.model.TenderNoTemp;
import com.bul.zydex.model.TenderPreQualification;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.model.TenderPriceApprovalUser;
import com.bul.zydex.model.TenderTechnical;
import com.bul.zydex.model.TenderTechnicalDoc;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.model.VendorTenderBid;
import com.bul.zydex.util.DownloadFile;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class PRMasterController extends PRMasterAbstract {

    public ModelAndView createPR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();
        OmsMaster omsMaster = null;
        String omsMasterId = request.getParameter("omsMasterId");
        if (omsMasterId != null && !omsMasterId.trim().isEmpty()) {
            omsMaster = omsMasterService.readById(Integer.parseInt(omsMasterId));
        }
        String ref_no = request.getParameter("ref_no");
        String prType = request.getParameter("prType");
        if (prType.equals("contract_electrical")) {
            prType = "Contract Electrical";
        }
        if (prType.equals("contract_civil")) {
            prType = "Contract Civil";
        }

        List employeeMaster1 = employeeMasterService.readByDrow();

        mv.getModelMap().put("employeeMaster1", employeeMaster1);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String employee_name = employeeMaster.getName();
        String ph_no = employeeMaster.getPhNo();

        List committee_approval = committeeApprovalSettingService.read();
        mv.getModelMap().put("committee_approval", committee_approval);

        List pr_business_type = prBusinessTypeService.read();
        mv.getModelMap().put("pr_business_type", pr_business_type);

        List pr_project_type = prProjectTypeService.read();
        mv.getModelMap().put("pr_project_type", pr_project_type);

        List pr_classification = prClassificationService.read();
        mv.getModelMap().put("pr_classification", pr_classification);

        List pr_group_classification = prClassificationService.read();
        mv.getModelMap().put("pr_group_classification", pr_group_classification);

        List billing_location = companyLocationService.read();

        List list11 = plantMastersService.read();
        mv.getModelMap().put("list11", list11);

        List list12 = locationMastersService.read();
        mv.getModelMap().put("list12", list12);

        mv.getModelMap().put("billing_location", billing_location);
        mv.getModelMap().put("ph_no", ph_no);
        mv.getModelMap().put("employee_name", employee_name);
        mv.getModelMap().put("formattedDate", formattedDate);
        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("prType", prType);

        mv.getModelMap().put("omsMaster", omsMaster);
        mv.setViewName("PR/CreatePR");
        return mv;
    }

    public ModelAndView selectTypePR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String department = employeeMaster.getDepartment();
        String location = employeeMaster.getLocation();

        ServiceRights serviceRights = serviceRightsService.ReadDepartmentLocation(department, location);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("serviceRights", serviceRights);
        mv.setViewName("PR/SelectTypePR");
        return mv;
    }

    public ModelAndView selectPR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        String omsMasterId = request.getParameter("omsMasterId");

        //tender id
        String ref_no = "";
        PRNoTemp prNoTemp = prNoTempService.readLastRecord();
        ref_no = prNoTemp.getPrNo();
        int ref_no1 = Integer.parseInt(ref_no);
        ref_no1++;

        //ref_no1 = 1234;
        PRNoTemp prNoTemp1 = new PRNoTemp();
        prNoTemp1.setPrNo(ref_no1 + "");
        prNoTempService.create(prNoTemp1);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("ref_no", ref_no1);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("prMaster", prMaster);
        if (omsMasterId != null && !omsMasterId.isEmpty()) {
            mv.getModelMap().put("omsMasterId", omsMasterId);
        }
        mv.setViewName("PR/SelectPR");
        return mv;
    }

    public ModelAndView selectContactPR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");
        //tender id

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("ref_no", ref_no);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("prMaster", prMaster);
        mv.setViewName("PR/SelectContactPR");
        return mv;
    }

    public ModelAndView uploadExcelVendorForServicePR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");

        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/UploadExcelVendorForServicePR");
        return mv;
    }

    public ModelAndView agaxPRVendorDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        String ref_no = request.getParameter("q");

        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("prMaster", prMaster);
        mv.setViewName("PR/AgaxPRVendorDetails");
        return mv;
    }

    public ModelAndView searchVendorForServicePR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");

        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);

        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/SearchVendorForServicePR");
        return mv;
    }

    public ModelAndView uploadExcelVendorForServicePRSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");
        String RefNo = ref_no.replace("/", "");
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "PR"
                + File.separator + RefNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        String technicalfile = request.getParameter("technicalfile");
        if (technicalfile == null) {
            technicalfile = "";
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile multipartFile = multipartRequest.getFile("technicalfile");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "PR"
                        + File.separator + RefNo + File.separator;
                File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                technicalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ArrayList<PreQualificationExcel> al = new ArrayList<PreQualificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/PR/" + RefNo + "/" + technicalfile);
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
                    String desc = "";
                    String comp = "";
                    String vendor_code = "";
                    String vendor_name = "";
                    String email_id = "";
                    String mobile_no = "";
                    String address = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        if (i == 1) {
                            srNo = cell.getNumericCellValue() + "";
                        }
                        if (i == 2) {
                            vendor_code = cell.getStringCellValue();
                        }

                    }

                    //----------------------
                    VendorMaster vendorMaster = vendorMasterService.read(vendor_code);
                    vendor_code = vendorMaster.getVendorRegNo();
                    vendor_name = vendorMaster.getVendorName();
                    email_id = vendorMaster.getVendorEmailID();
                    mobile_no = vendorMaster.getVendorMobNo();
                    address = vendorMaster.getVendorAddressLine1();

                    List tenderVendor1 = tenderVendorService.readByRfqVendor(ref_no, vendor_code);

                    if (tenderVendor1.isEmpty()) {
                        PRVendor prVendor = new PRVendor();
                        prVendor.setPrNo(ref_no);
                        prVendor.setVendorCode(vendor_code);
                        prVendor.setVendorName(vendor_name);
                        prVendor.setAddress(address);
                        prVendor.setEmailId(email_id);
                        prVendor.setMobileNo(mobile_no);
                        prVendor.setChecked(1);
                        prVendorService.create(prVendor);
                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);

        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/UploadExcelVendorForServicePR");
        return mv;
    }

    public ModelAndView searchVendorForServicePRSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String vendor_code = request.getParameter("vendor_code");
        String vendor_name = request.getParameter("vendor_name");
        String work_type = request.getParameter("work_type");
        String ref_no = request.getParameter("ref_no");

        List vendorMaster = vendorMasterService.readByCodeName(vendor_code, vendor_name);

        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("vendorMaster", vendorMaster);
        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/SearchVendorForServicePR");
        return mv;
    }

    public ModelAndView addVendorForManualServicePR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");
        String vendor_code = "";
        String vendor_name = "";
        String email_id = "";
        String mobile_no = "";
        String address = "";
        int vendor_id = 0;
        String vendor_rank = "";
        String vendor_remark = "";
        //checkedId
        String[] checkId = request.getParameterValues("checkedId");
        for (String checkedValues : checkId) {

            VendorMaster vendorMaster = vendorMasterService.read(checkedValues);
            vendor_code = vendorMaster.getVendorRegNo();
            vendor_name = vendorMaster.getVendorName();
            email_id = vendorMaster.getVendorEmailID();
            mobile_no = vendorMaster.getVendorMobNo();
            address = vendorMaster.getVendorAddressLine1();
            vendor_id = vendorMaster.getId();
            vendor_rank = "";
            vendor_remark = vendorMaster.getVendorRemark();

            List tenderVendor1 = tenderVendorService.readByRfqVendor(ref_no, vendor_code);

            if (tenderVendor1.isEmpty()) {
                PRVendor prVendor = new PRVendor();
                prVendor.setPrNo(ref_no);

                prVendor.setVendorCode(vendor_code);
                prVendor.setVendorName(vendor_name);
                prVendor.setAddress(address);
                prVendor.setEmailId(email_id);
                prVendor.setMobileNo(mobile_no);
                prVendor.setChecked(0);
                prVendor.setVendorId(vendor_id);
                prVendor.setVendorRank(vendor_rank);
                prVendor.setVendorRemark(vendor_remark);
                prVendorService.create(prVendor);
            } else {
                request.setAttribute("failureMessage",
                        " Vendor already added");
            }

        }

        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/SearchVendorForServicePR");
        return mv;
    }

    public ModelAndView deleteVendorForServicePR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");
        //checkedId
        String[] checkId = request.getParameterValues("checkedIdd");
        for (String checkedValues : checkId) {

            prVendorService.delete(Integer.parseInt(checkedValues));

        }

        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/SearchVendorForServicePR");
        return mv;
    }

    public ModelAndView deleteVendorForServicePR1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");
        //checkedId
        String[] checkId = request.getParameterValues("checkedIdd");
        for (String checkedValues : checkId) {

            prVendorService.delete1(Integer.parseInt(checkedValues));

        }

        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/SearchVendorForManualServicePR1");
        return mv;
    }

    public ModelAndView agaxPRItemDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("q");

        int item_type = 0;
        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, item_type);
        int tenderItemMastercount = tenderItemMaster.size();

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("tenderItemMastercount", tenderItemMastercount);

        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("ref_no", ref_no);

        mv.setViewName("PR/AgaxPRItemDetails");
        return mv;
    }

    public ModelAndView agaxPRItemDetails1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("q");
        int item_type = 1;
        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, item_type);
        int tenderItemMastercountservice = tenderItemMaster.size();

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("tenderItemMastercountservice", tenderItemMastercountservice);

        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("ref_no", ref_no);

        mv.setViewName("PR/AgaxPRItemDetails1");
        return mv;
    }

    public ModelAndView addServicePRDocument(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 0);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String department = employeeMaster.getDepartment();
        String location = employeeMaster.getLocation();

        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        ServiceRights serviceRights = serviceRightsService.ReadDepartmentLocation(department, location);

        mv.getModelMap().put("serviceRights", serviceRights);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("ref_no", ref_no);

        mv.setViewName("PR/AjaxAddServicePRDocument");
        return mv;
    }

    public ModelAndView addServicePRSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no1");
        String RefNo = ref_no.replace("/", "");
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "PR"
                + File.separator + RefNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        String service_file = request.getParameter("service_file");
        if (service_file == null) {
            service_file = "";
        }

        String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("service_file");

        service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);

        if (fileDetail1.isEmpty()) {

            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "PR"
                            + File.separator + RefNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            prItemMasterService.deleteRefNo(ref_no, 0);

            try {
                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/PR/" + RefNo + "/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);

                Map<Integer, String> requiredColumns = new LinkedHashMap<>();
                requiredColumns.put(0, "Sr. No.");
                requiredColumns.put(2, "Item Description (40 Character)");
                requiredColumns.put(5, "Qty");
                requiredColumns.put(6, "UoM");
                requiredColumns.put(7, "Account Assigment Category");
                requiredColumns.put(8, "Account Assigment Value");
                requiredColumns.put(9, "Product Type");
                requiredColumns.put(10, "Product Group");
                requiredColumns.put(11, "TAX Code");
                requiredColumns.put(12, "VALUATION PRICE (Budget Value)");
                requiredColumns.put(13, "Delivery Date");
                requiredColumns.put(14, "Start date");
                requiredColumns.put(15, "End date");

                boolean isValidTemplate = true;
                String headerMismatchMsg = "Please upload the proper PR Excel template file.";

                try {
                    if (sheet.getPhysicalNumberOfRows() < 6) {
                        isValidTemplate = false;
                    } else {
                        Row headerRow = sheet.getRow(5);
                        if (headerRow == null) {
                            isValidTemplate = false;
                        } else {
                            for (Map.Entry<Integer, String> entry : requiredColumns.entrySet()) {
                                int colIdx = entry.getKey();
                                String expectedHeader = entry.getValue();
                                Cell headerCell = headerRow.getCell(colIdx);

                                String actualHeader = "";
                                if (headerCell != null) {
                                    int cellType = headerCell.getCellType();
                                    if (cellType == Cell.CELL_TYPE_STRING) {
                                        actualHeader = headerCell.getStringCellValue().trim();
                                    } else if (cellType == Cell.CELL_TYPE_NUMERIC) {
                                        actualHeader = String.valueOf(headerCell.getNumericCellValue()).trim();
                                    } else if (cellType == Cell.CELL_TYPE_BOOLEAN) {
                                        actualHeader = String.valueOf(headerCell.getBooleanCellValue()).trim();
                                    } else if (cellType == Cell.CELL_TYPE_FORMULA) {
                                        try {
                                            actualHeader = headerCell.getStringCellValue().trim();
                                        } catch (Exception ef) {
                                            actualHeader = String.valueOf(headerCell.getNumericCellValue()).trim();
                                        }
                                    } else {
                                        actualHeader = "";
                                    }
                                }

                                if (!actualHeader.equalsIgnoreCase(expectedHeader.trim())) {
                                    isValidTemplate = false;
                                    break;
                                }
                            }
                        }
                    }
                } catch (Exception validationEx) {
                    isValidTemplate = false;
                }

                if (!isValidTemplate) {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("{\"status\":\"error\",\"message\":\"" + headerMismatchMsg + "\"}");
                    response.getWriter().flush();
                    return null;
                }

                Iterator<Row> itr = sheet.iterator();
                System.out.println("The given file is");
                int j = 0;
                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    if (j > 6) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String accountassigmentcategory = "";
                        String accountassigmentvalue = "";
                        String producttype = "";
                        String productgroup = "";
                        String taxcode = "";
                        String valuationprice = "";
                        String deliverydate = "";
                        String startdate = "";
                        String enddate = "";
                        String remark = "";
                        String budget_amount = "";

                        int i = 0;
                        int k = 0;
                        for (int i1 = 1; i1 <= 18; i1++) {
                            i++;
                            try {
                                Cell cell = cellIterator.next();
                                int sh1 = cell.getColumnIndex();
                                i = sh1 + 1;
                                i1 = i;
                                if (i == 1) {
                                    try {
                                        srNo = cell.getNumericCellValue() + "";
                                    } catch (Exception e1) {
                                        srNo = cell.getStringCellValue();
                                    }
                                    if (srNo.equals("0.0")) {
                                        k = 1;
                                    }
                                }
                                if (i == 2) {
                                    try {
                                        item_code = cell.getNumericCellValue() + "";
                                        if (item_code.equals("0.0")) {
                                            item_code = "";
                                        }
                                    } catch (Exception e1) {
                                        item_code = cell.getStringCellValue();
                                    }
                                }
                                if (i == 3) {
                                    try {
                                        item_desc = cell.getNumericCellValue() + "";
                                    } catch (Exception e1) {
                                        item_desc = cell.getStringCellValue().replaceAll("\'", "");
                                    }
                                }
                                if (i == 4) {
                                    try {
                                        purpose = cell.getNumericCellValue() + "";
                                        if (purpose.equals("0.0")) {
                                            purpose = "";
                                        }
                                    } catch (Exception e1) {
                                        purpose = cell.getStringCellValue();
                                    }
                                }
                                if (i == 5) {
                                    try {
                                        long_text = cell.getNumericCellValue() + "";
                                        if (long_text.equals("0.0")) {
                                            long_text = "";
                                        }
                                    } catch (Exception e1) {
                                        long_text = cell.getStringCellValue();
                                    }
                                }
                                if (i == 6) {
                                    try {
                                        qty = cell.getNumericCellValue() + "";
                                        Float litersOfPetrol = Float.parseFloat(qty);
                                        DecimalFormat df = new DecimalFormat("0.00");
                                        df.setMaximumFractionDigits(2);
                                        litersOfPetrol = Float.parseFloat(df.format(litersOfPetrol));
                                        qty = litersOfPetrol + "";
                                    } catch (Exception e1) {
                                        qty = cell.getStringCellValue();
                                    }
                                }
                                if (i == 7) {
                                    try {
                                        uom = cell.getNumericCellValue() + "";
                                        if (uom.equals("0.0")) {
                                            uom = "";
                                        }
                                    } catch (Exception e1) {
                                        uom = cell.getStringCellValue();
                                    }
                                }
                                if (i == 8) {
                                    try {
                                        accountassigmentcategory = cell.getNumericCellValue() + "";
                                        if (accountassigmentcategory.equals("0.0")) {
                                            accountassigmentcategory = "";
                                        }
                                    } catch (Exception e1) {
                                        accountassigmentcategory = cell.getStringCellValue();
                                    }
                                }
                                if (i == 9) {
                                    try {
                                        accountassigmentvalue = cell.getNumericCellValue() + "";
                                        if (accountassigmentvalue.equals("0.0")) {
                                            accountassigmentvalue = "";
                                        }
                                    } catch (Exception e1) {
                                        accountassigmentvalue = cell.getStringCellValue();
                                    }
                                }
                                if (i == 10) {
                                    try {
                                        producttype = cell.getNumericCellValue() + "";
                                        if (producttype.equals("0.0")) {
                                            producttype = "";
                                        }
                                    } catch (Exception e1) {
                                        producttype = cell.getStringCellValue();
                                    }
                                }
                                if (i == 11) {
                                    try {
                                        productgroup = cell.getNumericCellValue() + "";
                                        if (productgroup.equals("0.0")) {
                                            productgroup = "";
                                        }
                                    } catch (Exception e1) {
                                        productgroup = cell.getStringCellValue();
                                    }
                                }
                                if (i == 12) {
                                    try {
                                        taxcode = cell.getNumericCellValue() + "";
                                        if (taxcode.equals("0.0")) {
                                            taxcode = "";
                                        }
                                    } catch (Exception e1) {
                                        taxcode = cell.getStringCellValue();
                                    }
                                }
                                if (i == 13) {
                                    try {
                                        valuationprice = cell.getNumericCellValue() + "";
                                        if (valuationprice.equals("0.0")) {
                                            valuationprice = "";
                                        }
                                    } catch (Exception e1) {
                                        valuationprice = cell.getStringCellValue();
                                    }
                                }
                                if (i == 14) {
                                    try {
                                        Date timeLine = cell.getDateCellValue();
                                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                        deliverydate = formatter.format(timeLine);
                                    } catch (Exception e1) {
                                        deliverydate = cell.getStringCellValue();
                                    }
                                }
                                if (i == 15) {
                                    try {
                                        Date timeLine = cell.getDateCellValue();
                                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                        startdate = formatter.format(timeLine);
                                    } catch (Exception e1) {
                                        startdate = cell.getStringCellValue();
                                    }
                                }
                                if (i == 16) {
                                    try {
                                        Date timeLine = cell.getDateCellValue();
                                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                        enddate = formatter.format(timeLine);
                                    } catch (Exception e1) {
                                        enddate = cell.getStringCellValue();
                                    }
                                }
                                if (i == 17) {
                                }
                                if (i == 18) {
                                }
                            } catch (Exception e11) {
                            }
                        }

                        if (k == 1) {
                            break;
                        }

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
                            List prItem = prItemMasterService.readByPRItemDesc(ref_no, item_desc, 0);
                            if (prItem.size() == 0) {
                                PRItemMaster prItemMaster = new PRItemMaster();
                                prItemMaster.setPrNo(ref_no);
                                prItemMaster.setItemCode(item_code.replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                                prItemMaster.setItemDescription(item_desc);
                                prItemMaster.setRemark(remark);
                                prItemMaster.setUom(uom.replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                                prItemMaster.setQty(qty.replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                                prItemMaster.setDeliveryScheduleDate(long_text);
                                prItemMaster.setDeliveryScheduleQty(purpose);
                                prItemMaster.setLocation("");
                                prItemMaster.setPurNo(budget_amount);
                                prItemMaster.setItemNo("");
                                prItemMaster.setSrNo(srNo.replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                                prItemMaster.setAccountAssigmentCategory(accountassigmentcategory);
                                prItemMaster.setAccountAssigmentValue(accountassigmentvalue);
                                prItemMaster.setProductType(producttype);
                                prItemMaster.setProductGroup(productgroup);
                                prItemMaster.setTaxCode(taxcode);
                                prItemMaster.setValuationPrice(valuationprice);
                                prItemMaster.setDeliveryDate(deliverydate);
                                prItemMaster.setStartDate(startdate);
                                prItemMaster.setEndDate(enddate);
                                prItemMasterService.create(prItemMaster);
                            }
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // ✅ Valid file processed successfully — return HTML view
            List materialGroupMaster = materialGroupMasterService.read();
            List materialTypeMaster = materialTypeMasterService.read();
            mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
            mv.getModelMap().put("materialTypeMaster", materialTypeMaster);
            List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 0);
            mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
            mv.getModelMap().put("prMaster", prMaster);
            mv.getModelMap().put("ref_no", ref_no);
            mv.setViewName("PR/AjaxAddServicePRDocument");
            return mv;

        } else {

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"status\":\"error\",\"message\":\"File already exists. Please upload a different file.\"}");
            response.getWriter().flush();
            return null;
        }

    }

    public ModelAndView submitPRMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();
        PRPriceApproval prPriceApproval = new PRPriceApproval();
        PRPriceApprovalUser prPriceApprovalUser = new PRPriceApprovalUser();
        PRPriceApprovalComment prPriceApprovalComment = new PRPriceApprovalComment();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        OmsMaster omsMaster = null;

        String omsMasterId = request.getParameter("omsMasterId");
        if (omsMasterId != null && !omsMasterId.trim().isEmpty()) {
            omsMaster = omsMasterService.readById(Integer.parseInt(omsMasterId));
        }

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String department = employeeMaster.getDepartment();

        String refNo = request.getParameter("pr_no");
        String refNo1 = refNo;

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        //get tender No.
        Date date = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yy");
        String sysdate = sdf4.format(date);
        Date date1 = new java.util.Date();
        SimpleDateFormat sdf5 = new SimpleDateFormat("MM");
        String sysdate1 = sdf5.format(date1);
        int month_frt = Integer.parseInt(sysdate1);
        int year_frt = Integer.parseInt(sysdate);

        PRNoTemp prNoTemp = prNoTempService.readByPRNo();

        String tenderno = "0";
        tenderno = prNoTemp.getPrNo();
        if (tenderno == null) {
            tenderno = "0";
        }

        PRNo tenderNo = prNoService.readByPrNo();

        // String tenderno = "0"; 
        tenderno = tenderNo.getPrNo();
        if (tenderno == null) {
            tenderno = "0";
        }

        int ten_no_int = 0;

        ten_no_int = Integer.parseInt(tenderno);

        long ten_no_final = 0;

        String final_ten_no = "";
        ten_no_int++;
        String text = String.format("%07d", ten_no_int);
        String mini = text.substring(0, 2);
        String sub_text = "";
        if (month_frt <= 3) {
            int bbb = year_frt - 1;
            sysdate = Integer.toString(bbb);
            if (mini.equals(sysdate)) {
                final_ten_no = text;

            } else {
                int bbbb = year_frt - 1;
                sysdate = Integer.toString(bbbb);
                sub_text = text.substring(2);
                final_ten_no = sysdate + sub_text;
            }
        } else {
            if (mini.equals(sysdate)) {
                final_ten_no = text;
            } else {
                sub_text = text.substring(2);
                final_ten_no = sysdate + "00001";
            }
        }

        refNo = request.getParameter("refNo");
        refNo = final_ten_no;

        PRNo prNo = new PRNo();
        prNo.setPrNo(refNo);
        prNoService.create(prNo);

        String f_year = refNo.substring(0, 2);
        String f_no = refNo.substring(2, 7);

        int f_y1 = Integer.parseInt(f_year);
        f_y1++;

        refNo = "PR" + f_year + "" + f_y1 + "/" + f_no;

        String title = request.getParameter("title");
        String projectId = request.getParameter("projectId");
        String value = request.getParameter("value");
        String categoryId = request.getParameter("categoryId");
        String deliveryLocation = request.getParameter("deliveryLocation");
        String announceDate = request.getParameter("announceDate");
        String workDesc = request.getParameter("workDesc");
        String type = request.getParameter("type");
        String contactPerson = request.getParameter("contactPerson");
        String contactPersonNumber = request.getParameter("contactPersonNumber");
        String prRemark = request.getParameter("prRemark");
        String billing_location = request.getParameter("billing_location");
        String technical_contact_name = request.getParameter("technicalContactName");
        String technical_contact_no = request.getParameter("technicalContactNo");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String pincode = request.getParameter("pincode");
        String quotes = request.getParameter("quotes");
        String business_type = request.getParameter("business_type");
        String project_type = request.getParameter("project_type");
        String delivery_period = request.getParameter("delivery_period");
        String technicalCommittee = request.getParameter("technicalCommittee");
        String plantcode = request.getParameter("plantcode");
        String plant_name = request.getParameter("plant_name");

        String gst = request.getParameter("gst");
        String purchasing = request.getParameter("purchasing");
        String address = request.getParameter("address");
        String locationcode = request.getParameter("locationcode");
        String locationaddress = request.getParameter("locationaddress");
        String remarkss = request.getParameter("remarks1");
        String nameofLocationPartner = request.getParameter("nameofLocationPartner");
        String mobileNoLocationPartner = request.getParameter("mobileNoLocationPartner");
        
        String costCurrency = request.getParameter("costCurrency");
        costCurrency = costCurrency != null ? costCurrency.trim() : "";
        
        String singleQuoteCheckbox = request.getParameter("singleQuoteCheckbox");
        int singleQuoteCheckbox1;
        if ("1".equals(singleQuoteCheckbox)) {
            singleQuoteCheckbox1 = 1;
        } else {
            singleQuoteCheckbox1 = 0;

        }
        String technicalfile1 = request.getParameter("singleQuoteAttachment");
        if (technicalfile1 == null) {
            technicalfile1 = "";
        }

        if (prRemark == null) {
            prRemark = "";
        }
        if (remarkss == null) {
            remarkss = "";
        }

        List tenderMaster1 = prMasterService.readByRefNo(refNo);

        if (singleQuoteCheckbox1 == 1) {
            String RefNo = refNo.replace("/", "");
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "PR"
                    + File.separator + RefNo;
            File f1 = new File(path);
            boolean bool = f1.mkdirs();

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("singleQuoteAttachment");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "PR"
                            + File.separator + RefNo + File.separator;
                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    technicalfile1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        if (tenderMaster1.isEmpty()) {

            prMaster.setPrNo(refNo);
            prMaster.setTitle(title);
            prMaster.setprojectId(projectId);
            prMaster.setAnnounceDate(announceDate);
            prMaster.setCategoryId(categoryId);
            prMaster.setContactPerson(contactPerson);
            prMaster.setLocation(deliveryLocation);
            prMaster.setValue(value);
            prMaster.setWorkDesc(workDesc);
            prMaster.setType(type);
            prMaster.setPrAdminContactNumber(contactPersonNumber);
            prMaster.setPrRemark(prRemark);
            prMaster.setPrAdmin(username);
            prMaster.setAuthorizeFlag(0);
            prMaster.setDepartment(department);
            prMaster.setAuthorizeDate(announceDate);
            prMaster.setBillingLocation(billing_location);
            prMaster.setTechnicalContactName(technical_contact_name);
            prMaster.setTechnicalContactNo(technical_contact_no);
            prMaster.setAddress1(address1);
            prMaster.setAddress2(address2);
            prMaster.setState(state);
            prMaster.setCity(city);
            prMaster.setPincode(pincode);

            prMaster.setQuotes(quotes);
            prMaster.setBusinessType(business_type);
            prMaster.setProjectType(project_type);
            prMaster.setDeliveryPeriod(delivery_period);
            prMaster.setTechnicalCommittee(technicalCommittee);
            prMaster.setPlant(plantcode);
            prMaster.setGst(gst);
            prMaster.setPurchaseOrganization(purchasing);
            prMaster.setAddress(address);
            prMaster.setLocationName(locationcode);
            prMaster.setLocationAddress(locationaddress);
            prMaster.setRemarks(remarkss);
            prMaster.setSingleQuoteFlag(singleQuoteCheckbox1);
            prMaster.setSingleQuoteAttachment(technicalfile1);
            prMaster.setNameofLocationPartner(nameofLocationPartner);
            prMaster.setMobileNoLocationPartner(mobileNoLocationPartner);

            prMaster.setProjectIdUpdateDate(formattedDate);
            prMaster.setBudgetAmountUpdateDate(formattedDate);
            prMaster.setCurrency(costCurrency);

            if (omsMaster != null) {
                String token = "";
                try {

                    TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }
                        }
                    };

                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                    URL url = new URL("https://oms-stage.chargecloud.net/api/v1/int/integrations/oms-token/generate");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);

                    String apiKey = "oms_4hN8sP2qW6vX1mJ9kL5tR3cF7yG0bD8";
                    JSONObject json = new JSONObject();
                    json.put("apiKey", apiKey);

                    OutputStream os = conn.getOutputStream();
                    os.write(json.toString().getBytes());
                    os.flush();
                    os.close();

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder response0 = new StringBuilder();
                    String line;

                    while ((line = br.readLine()) != null) {
                        response0.append(line);
                    }

                    br.close();

                    JSONObject responseJson = new JSONObject(response0.toString());
                    token = responseJson.getJSONObject("data").getString("token");

                    conn.disconnect();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDateTime = now.format(formatter);
                omsMaster.setPrNumber(refNo);
                omsMaster.setPrFlag(2);
                omsMasterService.update(omsMaster);

                try {
                    JSONObject json = new JSONObject();
                    json.put("ticketID", omsMaster.getTicketId());
                    json.put("omsPrId", omsMaster.getOmsPrId());
                    json.put("prId", refNo);
                    json.put("status", "PR CREATED");
                    json.put("createdAt", formattedDateTime);
                    json.put("createdBy", username);

                    TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }
                        }
                    };

                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                    URL url = new URL("https://oms.chargecloud.net/api/v1/int/integrations/e-produce/callback");
                    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

                    con.setRequestMethod("POST");

                    con.setRequestProperty("Content-Type", "application/json");
                    con.setRequestProperty("Authorization", "Bearer " + token);

                    con.setDoOutput(true);

                    try (OutputStream os = con.getOutputStream()) {
                        byte[] input = json.toString().getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    int responseCode = con.getResponseCode();
                    System.out.println("Response Code: " + responseCode);

                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {

                        StringBuilder response1 = new StringBuilder();
                        String responseLine;

                        while ((responseLine = br.readLine()) != null) {
                            response1.append(responseLine.trim());
                        }

                        System.out.println("Response: " + response1);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        prMasterService.create(prMaster);
        mv.getModelMap().put("prMaster", prMaster);

        prItemMasterService.updatePRNo(refNo1, refNo);
        prVendorService.updatePRNo(refNo1, refNo);
        prDocService.updatePRNo(refNo1, refNo);

        int policyCount = Integer.parseInt(request.getParameter("policyCount"));
        String comment = request.getParameter("comment");
        if (comment == null) {
            comment = "";
        }

        prPriceApproval.setPrNo(refNo);
        prPriceApproval.setCurrentApproval(1);
        prPriceApproval.setApprovalStatus(0);
        prPriceApproval.setTotalApproval(policyCount);

        prPriceApproval.setDateTime(formattedDate);

        String approvalRemark = request.getParameter("approvalRemark");
        if (approvalRemark == null) {
            approvalRemark = "";
        }
        prPriceApproval.setApprovalRemark(approvalRemark);

        List employeeMaster1 = employeeMasterService.readByDrow();

        UserRights userRights = userRightsService.readByUser(username);

        String employeeCode = employeeMaster.getEmployeeCode();
        prPriceApproval.setUserId(employeeCode);
        prPriceApproval.setApprovalRemark(comment);
        prPriceApprovalService.create(prPriceApproval);

        int approveId = prPriceApproval.getId();

        for (int i = 1; i <= policyCount; i++) {

            String userLists = request.getParameter("userList" + i);

            prPriceApprovalUser.setUserId(userLists);
            prPriceApprovalUser.setPrNo(refNo);

            prPriceApprovalUser.setPrApprovalId(approveId);
            prPriceApprovalUser.setLevel(i);
            prPriceApprovalUser.setApprovalStatus(0);

            prPriceApprovalComment.setApprovalStatus(0);
            prPriceApprovalComment.setDateTime(formattedDate);
            prPriceApprovalComment.setPrApprovalId(approveId);
            prPriceApprovalComment.setUserId(userLists);
            prPriceApprovalComment.setApprovalComment(comment);

            prPriceApprovalUserService.create(prPriceApprovalUser);
            prPriceApprovalCommentService.create(prPriceApprovalComment);
        }

        String Address1[] = request.getParameterValues("Address1");
        String[] Address2 = request.getParameterValues("Address2");
        String[] cityes = request.getParameterValues("cityes");
        String[] remarks = request.getParameterValues("remarkes");
        String[] states = request.getParameterValues("states");
        String[] pincodes = request.getParameterValues("pincodes");

        try {

            for (int i = 0; i < Address1.length; i++) {

                MultipleAddress multipleAddress = new MultipleAddress();

                if (Address1[i] == null || Address1[i].trim().isEmpty()) {
                    break;
                } else {

                    multipleAddress.setAddress1(Address1[i]);
                    multipleAddress.setAddress2(Address2[i]);
                    multipleAddress.setCity(cityes[i]);
                    multipleAddress.setPincode(pincodes[i]);
                    multipleAddress.setState(states[i]);
                    multipleAddress.setPrNumber(refNo);
                    multipleAddress.setRemark(remarks[i]);
                    multipleAddressService.create(multipleAddress);
                }
            }

        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        //------for Log entry---------
        LogsMaster lm = new LogsMaster();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("PR No: " + refNo + " submitted successfully").setDrow("Y");
        logService.create(lm);

        session.setAttribute("successMessage",
                " PR No: " + refNo + " submitted successfully");

        mv.getModelMap().put("employeeMaster1", employeeMaster1);
        mv.getModelMap().put("prPriceApproval", prPriceApproval);
        mv.getModelMap().put("prPriceApproval", prPriceApproval);
        mv.getModelMap().put("prPriceApprovalUser", prPriceApprovalUser);
        mv.getModelMap().put("refNo", refNo);

        mv.setViewName("redirect:prMaster.htm?act=listPRList");

        return mv;
    }

    public ModelAndView savePRMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();
        PRPriceApproval prPriceApproval = new PRPriceApproval();
        PRPriceApprovalUser prPriceApprovalUser = new PRPriceApprovalUser();
        PRPriceApprovalComment prPriceApprovalComment = new PRPriceApprovalComment();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        OmsMaster omsMaster = null;
        String omsMasterId = request.getParameter("omsMasterId");
        if (omsMasterId != null && !omsMasterId.trim().isEmpty()) {
            omsMaster = omsMasterService.readById(Integer.parseInt(omsMasterId));
        }
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String department = employeeMaster.getDepartment();

        String refNo = request.getParameter("pr_no");
        String refNo1 = refNo;

        int pr_id = 0;
        String prIdParam = request.getParameter("prId");

        if (prIdParam != null && !prIdParam.isEmpty()) {
            try {
                pr_id = Integer.parseInt(prIdParam);
            } catch (Exception e) {
                pr_id = 0;
            }
        }

        //get tender No.
        Date date = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yy");
        String sysdate = sdf4.format(date);
        Date date1 = new java.util.Date();
        SimpleDateFormat sdf5 = new SimpleDateFormat("MM");
        String sysdate1 = sdf5.format(date1);
        int month_frt = Integer.parseInt(sysdate1);
        int year_frt = Integer.parseInt(sysdate);

        String final_ten_no = "";
        if (pr_id == 0) {
            synchronized (this) {
                PRNoTemp prNoTemp = prNoTempService.readByPRNo();

                String tenderno = "0";
                tenderno = prNoTemp.getPrNo();
                if (tenderno == null) {
                    tenderno = "0";
                }

                PRNo tenderNo = prNoService.readByPrNo();

                // String tenderno = "0"; 
                tenderno = tenderNo.getPrNo();
                if (tenderno == null) {
                    tenderno = "0";
                }

                int ten_no_int = 0;

                ten_no_int = Integer.parseInt(tenderno);

                long ten_no_final = 0;

                ten_no_int++;
                String text = String.format("%07d", ten_no_int);
                String mini = text.substring(0, 2);
                String sub_text = "";
                if (month_frt <= 3) {
                    int bbb = year_frt - 1;
                    sysdate = Integer.toString(bbb);
                    if (mini.equals(sysdate)) {
                        final_ten_no = text;

                    } else {
                        int bbbb = year_frt - 1;
                        sysdate = Integer.toString(bbbb);
                        sub_text = text.substring(2);
                        final_ten_no = sysdate + sub_text;
                    }
                } else {
                    if (mini.equals(sysdate)) {
                        final_ten_no = text;
                    } else {
                        sub_text = text.substring(2);
                        final_ten_no = sysdate + "00001";
                    }
                }

            }
        }
        String title = request.getParameter("title");
        String projectId = request.getParameter("projectId");
        String value = request.getParameter("value");
        String categoryId = request.getParameter("categoryId");
        String deliveryLocation = request.getParameter("deliveryLocation");
        String announceDate = request.getParameter("announceDate");
        String workDesc = request.getParameter("workDesc");
        String type = request.getParameter("type");
        String contactPerson = request.getParameter("contactPerson");
        String contactPersonNumber = request.getParameter("contactPersonNumber");
        String prRemark = request.getParameter("prRemark");
        String billing_location = request.getParameter("billing_location");
        String technical_contact_name = request.getParameter("technicalContactName");
        String technical_contact_no = request.getParameter("technicalContactNo");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String pincode = request.getParameter("pincode");
        String quotes = request.getParameter("quotes");
        String business_type = request.getParameter("business_type");
        String project_type = request.getParameter("project_type");
        String delivery_period = request.getParameter("delivery_period");
        String technicalCommittee = request.getParameter("technicalCommittee");
        String plantcode = request.getParameter("plantcode");
        String gst = request.getParameter("gst");
        String purchasing = request.getParameter("purchasing");
        String address = request.getParameter("address");
        String locationcode = request.getParameter("locationcode");
        String locationaddress = request.getParameter("locationaddress");
        String remarkss = request.getParameter("remarks1");
        String nameofLocationPartner = request.getParameter("nameofLocationPartner");
        String mobileNoLocationPartner = request.getParameter("mobileNoLocationPartner");

        String costCurrency = request.getParameter("costCurrency");
        costCurrency = costCurrency != null ? costCurrency.trim() : "";

        String singleQuoteCheckbox = request.getParameter("singleQuoteCheckbox");
        int singleQuoteCheckbox1;
        if ("1".equals(singleQuoteCheckbox)) {
            singleQuoteCheckbox1 = 1;
        } else {
            singleQuoteCheckbox1 = 0;

        }
        String technicalfile1 = request.getParameter("singleQuoteAttachment");
        if (technicalfile1 == null) {
            technicalfile1 = "";
        }

        if (prRemark == null) {
            prRemark = "";
        }
        if (remarkss == null) {
            remarkss = "";
        }

        List tenderMaster1 = prMasterService.readByRefNo(refNo);

        if (singleQuoteCheckbox1 == 1) {
            String RefNo = refNo.replace("/", "");
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "PR"
                    + File.separator + RefNo;
            File f1 = new File(path);
            boolean bool = f1.mkdirs();

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("singleQuoteAttachment");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "PR"
                            + File.separator + RefNo + File.separator;
                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    technicalfile1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        if (pr_id == 0) {
            refNo = request.getParameter("refNo");
            refNo = final_ten_no;

            PRNo prNo = new PRNo();
            prNo.setPrNo(refNo);
            prNoService.create(prNo);

            String f_year = refNo.substring(0, 2);
            String f_no = refNo.substring(2, 7);

            int f_y1 = Integer.parseInt(f_year);
            f_y1++;

            refNo = "PR" + f_year + "" + f_y1 + "/" + f_no;

            prMaster.setPrNo(refNo);
            prMaster.setTitle(title);
            prMaster.setprojectId(projectId);
            prMaster.setAnnounceDate(announceDate);
            prMaster.setCategoryId(categoryId);
            prMaster.setContactPerson(contactPerson);
            prMaster.setLocation(deliveryLocation);
            prMaster.setValue(value);
            prMaster.setWorkDesc(workDesc);
            prMaster.setType(type);
            prMaster.setPrAdminContactNumber(contactPersonNumber);
            prMaster.setPrRemark(prRemark);
            prMaster.setPrAdmin(username);
            prMaster.setAuthorizeFlag(7);
            prMaster.setDepartment(department);
            prMaster.setAuthorizeDate(announceDate);
            prMaster.setBillingLocation(billing_location);
            prMaster.setTechnicalContactName(technical_contact_name);
            prMaster.setTechnicalContactNo(technical_contact_no);
            prMaster.setAddress1(address1);
            prMaster.setAddress2(address2);
            prMaster.setState(state);
            prMaster.setCity(city);
            prMaster.setPincode(pincode);

            prMaster.setQuotes(quotes);
            prMaster.setBusinessType(business_type);
            prMaster.setProjectType(project_type);
            prMaster.setDeliveryPeriod(delivery_period);
            prMaster.setTechnicalCommittee(technicalCommittee);
            prMaster.setPlant(plantcode);
            prMaster.setGst(gst);
            prMaster.setPurchaseOrganization(purchasing);
            prMaster.setAddress(address);
            prMaster.setLocationName(locationcode);
            prMaster.setLocationAddress(locationaddress);
            prMaster.setRemarks(remarkss);
            prMaster.setSingleQuoteFlag(singleQuoteCheckbox1);
            prMaster.setSingleQuoteAttachment(technicalfile1);
            prMaster.setNameofLocationPartner(nameofLocationPartner);
            prMaster.setMobileNoLocationPartner(mobileNoLocationPartner);

            prMaster.setProjectIdUpdateDate(formattedDate);
            prMaster.setBudgetAmountUpdateDate(formattedDate);
            prMaster.setCurrency(costCurrency);

            prMasterService.create(prMaster);
        } else {
            prMaster = prMasterService.readByPrNo(refNo);
            int prId = prMaster.getId();
            PRMaster prMaster1 = prMasterService.readById(prId);
            prMaster1.setTitle(title);
            prMaster1.setprojectId(projectId);
            prMaster1.setAnnounceDate(announceDate);
            prMaster1.setCategoryId(categoryId);
            prMaster1.setContactPerson(contactPerson);
            prMaster1.setLocation(deliveryLocation);
            prMaster1.setValue(value);
            prMaster1.setWorkDesc(workDesc);
            prMaster1.setType(type);
            prMaster1.setPrAdminContactNumber(contactPersonNumber);
            prMaster1.setPrRemark(prRemark);
            prMaster1.setPrAdmin(username);
            prMaster1.setAuthorizeFlag(7);
            prMaster1.setDepartment(department);
            prMaster1.setAuthorizeDate(announceDate);
            prMaster1.setBillingLocation(billing_location);
            prMaster1.setTechnicalContactName(technical_contact_name);
            prMaster1.setTechnicalContactNo(technical_contact_no);
            prMaster1.setAddress1(address1);
            prMaster1.setAddress2(address2);
            prMaster1.setState(state);
            prMaster1.setCity(city);
            prMaster1.setPincode(pincode);

            prMaster1.setQuotes(quotes);
            prMaster1.setBusinessType(business_type);
            prMaster1.setProjectType(project_type);
            prMaster1.setDeliveryPeriod(delivery_period);
            prMaster1.setTechnicalCommittee(technicalCommittee);
            prMaster1.setPlant(plantcode);
            prMaster1.setGst(gst);
            prMaster1.setPurchaseOrganization(purchasing);
            prMaster1.setAddress(address);
            prMaster1.setLocationName(locationcode);
            prMaster1.setLocationAddress(locationaddress);
            prMaster1.setRemarks(remarkss);
            prMaster1.setSingleQuoteFlag(singleQuoteCheckbox1);
            prMaster1.setSingleQuoteAttachment(technicalfile1);
            prMaster1.setNameofLocationPartner(nameofLocationPartner);
            prMaster1.setMobileNoLocationPartner(mobileNoLocationPartner);
            prMaster1.setCurrency(costCurrency);
            if (prMaster.getprojectId() != projectId) {
                prMaster1.setProjectIdUpdateDate(formattedDate);
            }

            if (prMaster.getValue() != value) {
                prMaster1.setBudgetAmountUpdateDate(formattedDate);
            }

            prMasterService.update(prMaster1);
        }
        if (omsMaster != null) {
            omsMaster.setPrNumber(refNo);
            omsMaster.setPrFlag(1);
            omsMasterService.update(omsMaster);
        }

        mv.getModelMap().put("prMaster", prMaster);

        if (singleQuoteCheckbox1 == 1) {
            String RefNo = refNo.replace("/", "");
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "PR"
                    + File.separator + RefNo;
            File f1 = new File(path);
            boolean bool = f1.mkdirs();

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("singleQuoteAttachment");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "PR"
                            + File.separator + RefNo + File.separator;
                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    technicalfile1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        prItemMasterService.updatePRNo(refNo1, refNo);
        prVendorService.updatePRNo(refNo1, refNo);
        prDocService.updatePRNo(refNo1, refNo);

        int policyCount = Integer.parseInt(request.getParameter("policyCount"));
        String comment = request.getParameter("comment");
        if (comment == null) {
            comment = "";
        }

        prPriceApproval.setPrNo(refNo);
        prPriceApproval.setCurrentApproval(1);
        prPriceApproval.setApprovalStatus(0);
        prPriceApproval.setTotalApproval(policyCount);

        prPriceApproval.setDateTime(formattedDate);

        String approvalRemark = request.getParameter("approvalRemark");
        if (approvalRemark == null) {
            approvalRemark = "";
        }
        prPriceApproval.setApprovalRemark(approvalRemark);

        List employeeMaster1 = employeeMasterService.readByDrow();

        UserRights userRights = userRightsService.readByUser(username);

        String employeeCode = employeeMaster.getEmployeeCode();
        prPriceApproval.setUserId(employeeCode);
        prPriceApproval.setApprovalRemark(comment);
        prPriceApprovalService.create(prPriceApproval);

        int approveId = prPriceApproval.getId();

        for (int i = 1; i <= policyCount; i++) {

            String userLists = request.getParameter("userList" + i);

            prPriceApprovalUser.setUserId(userLists);
            prPriceApprovalUser.setPrNo(refNo);

            prPriceApprovalUser.setPrApprovalId(approveId);
            prPriceApprovalUser.setLevel(i);
            prPriceApprovalUser.setApprovalStatus(0);

            prPriceApprovalComment.setApprovalStatus(0);
            prPriceApprovalComment.setDateTime(formattedDate);
            prPriceApprovalComment.setPrApprovalId(approveId);
            prPriceApprovalComment.setUserId(userLists);
            prPriceApprovalComment.setApprovalComment(comment);

            prPriceApprovalUserService.create(prPriceApprovalUser);
            prPriceApprovalCommentService.create(prPriceApprovalComment);
        }

        String Address1[] = request.getParameterValues("Address1");
        String[] Address2 = request.getParameterValues("Address2");
        String[] cityes = request.getParameterValues("cityes");
        String[] remarks = request.getParameterValues("remarkes");
        String[] states = request.getParameterValues("states");

        String[] pincodes = request.getParameterValues("pincodes");

        try {

            for (int i = 0; i < Address1.length; i++) {

                MultipleAddress multipleAddress = new MultipleAddress();

                if (Address1[i] == null || Address1[i].trim().isEmpty()) {
                    break;
                } else {

                    multipleAddress.setAddress1(Address1[i]);
                    multipleAddress.setAddress2(Address2[i]);
                    multipleAddress.setCity(cityes[i]);
                    multipleAddress.setPincode(pincodes[i]);
                    multipleAddress.setState(states[i]);
                    multipleAddress.setPrNumber(refNo);
                    multipleAddress.setRemark(remarks[i]);
                    multipleAddressService.create(multipleAddress);
                }
            }

        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        //------for Log entry---------
        LogsMaster lm = new LogsMaster();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("PR No: " + refNo + " Saved as Draft Successfully").setDrow("Y");
        logService.create(lm);

        session.setAttribute("successMessage",
                " PR No: " + refNo + " Saved as Draft Successfully");

        mv.getModelMap().put("employeeMaster1", employeeMaster1);
        mv.getModelMap().put("prPriceApproval", prPriceApproval);
        mv.getModelMap().put("prPriceApproval", prPriceApproval);
        mv.getModelMap().put("prPriceApprovalUser", prPriceApprovalUser);
        mv.getModelMap().put("refNo", refNo);
        int id = prMaster.getId();

        mv.setViewName("redirect:prMaster.htm?act=editPR&id=" + id);
        return mv;
    }

    public ModelAndView approvePRList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List tenderPriceApproval = prPriceApprovalService.approvaList(username);
        List prrecycleList = prMasterService.prRecycleList(username);
        // List tenderPriceApproval1 = prPriceApprovalService.read();

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", prrecycleList);
        //  mv.getModelMap().put("list2", tenderPriceApprovalUser);
        mv.getModelMap().put("id", id);

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

        mv.setViewName("PR/ApprovePRList");
        return mv;
    }

    public ModelAndView viewapprovePR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        //  PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));
        //  String prNo = prPriceApproval.getPrNo();
        String prNo = request.getParameter("id");
        PRPriceApproval prPriceApproval1 = prPriceApprovalService.readByPrNo(prNo);
        id = prPriceApproval1.getId() + "";

        PRMaster prMaster = prMasterService.readByPrNo(prNo);
        mv.getModelMap().put("prMaster", prMaster);

        int omsPrFlag = 2;
        OmsMaster omsMaster = omsMasterService.readByPrNo(prNo, omsPrFlag);
        if (omsMaster != null) {
            mv.getModelMap().put("omsMaster", omsMaster);
        }

        List tenderPriceApproval = prPriceApprovalService.readByIds(id);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("prDoc", prDoc);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);
        mv.setViewName("PR/ViewapprovePR");
        return mv;
    }

    public ModelAndView approvePR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        String prNo = request.getParameter("prNo");

        OmsMaster omsMaster = null;
        String omsMasterId = request.getParameter("omsMasterId");
        if (omsMasterId != null && !omsMasterId.trim().isEmpty()) {
            omsMaster = omsMasterService.readById(Integer.parseInt(omsMasterId));
        }

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        String pr_no1 = prPriceApproval.getPrNo();
        PRMaster pRMaster = prMasterService.readByPrNo(pr_no1);
        PRPriceApprovalUser prPriceApprovalUser = prPriceApprovalUserService.approvaList1(username, pr_no1);

        int approveId = prPriceApproval.getId();
        PRPriceApprovalComment prPriceApprovalComment = prPriceApprovalCommentService.readByApproveId(approveId);

        int totalApproval = prPriceApproval.getTotalApproval();
        int ca = prPriceApproval.getCurrentApproval();

        if (prPriceApproval.getApprovalStatus() == 0 || pRMaster.getAuthorizeFlag() == 10) {
            if (totalApproval == ca) {
                prPriceApproval.setApprovalStatus(1);
                prPriceApproval.setApprovalStatus(1);
                prPriceApprovalComment.setApprovalStatus(1);

                String pr_no = prPriceApproval.getPrNo();
                PRMaster prMaster = prMasterService.readByPrNo(pr_no);
                prMaster.setAuthorizeFlag(1);
                prMaster.setPrAuthorizeUser(username);
                prMaster.setPrAuthorizeDate(formattedDate);

                prMasterService.update(prMaster);
            } else {
                int level = prPriceApprovalUser.getLevel();
                level++;
                prPriceApproval.setCurrentApproval(level);
                prPriceApprovalUser.setApprovalStatus(1);
                prPriceApprovalComment.setApprovalStatus(1);
                mv.getModelMap().put("tenderPriceApprovalUser", prPriceApprovalUser);
            }

            prPriceApprovalComment.setDateTime(formattedDate);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();
            prPriceApprovalComment.setUserId(employeeCode);
            prPriceApprovalComment.setPrApprovalId(approveId);

            prPriceApprovalComment.setApprovalComment(comment);
            prPriceApprovalCommentService.create(prPriceApprovalComment);
            prPriceApprovalService.update(prPriceApproval);

            try {
                prPriceApprovalUserService.update(prPriceApprovalUser);
            } catch (Exception e11) {
            }

            if (omsMaster != null) {
                String token = "";
                try {

                    TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }
                        }
                    };

                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                    URL url = new URL("https://oms-stage.chargecloud.net/api/v1/int/integrations/oms-token/generate");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);

                    String apiKey = "oms_4hN8sP2qW6vX1mJ9kL5tR3cF7yG0bD8";
                    JSONObject json = new JSONObject();
                    json.put("apiKey", apiKey);

                    OutputStream os = conn.getOutputStream();
                    os.write(json.toString().getBytes());
                    os.flush();
                    os.close();

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder response0 = new StringBuilder();
                    String line;

                    while ((line = br.readLine()) != null) {
                        response0.append(line);
                    }

                    br.close();

                    JSONObject responseJson = new JSONObject(response0.toString());
                    token = responseJson.getJSONObject("data").getString("token");

                    conn.disconnect();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDateTime = now.format(formatter);
                omsMaster.setPrNumber(prNo);
                omsMaster.setPrFlag(3);
                omsMasterService.update(omsMaster);

                try {
                    JSONObject json = new JSONObject();
                    json.put("ticketID", omsMaster.getTicketId());
                    json.put("omsPrId", omsMaster.getOmsPrId());
                    json.put("prId", prNo);
                    json.put("status", "PR APPROVED");
                    json.put("createdAt", formattedDateTime);
                    json.put("createdBy", username);

                    TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }
                        }
                    };

                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                    URL url = new URL("https://oms.chargecloud.net/api/v1/int/integrations/e-produce/callback");
                    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

                    con.setRequestMethod("POST");

                    con.setRequestProperty("Content-Type", "application/json");
                    con.setRequestProperty("Authorization", "Bearer " + token);

                    con.setDoOutput(true);

                    try (OutputStream os = con.getOutputStream()) {
                        byte[] input = json.toString().getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    int responseCode = con.getResponseCode();
                    System.out.println("Response Code: " + responseCode);

                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {

                        StringBuilder response1 = new StringBuilder();
                        String responseLine;

                        while ((responseLine = br.readLine()) != null) {
                            response1.append(responseLine.trim());
                        }

                        System.out.println("Response: " + response1);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            PRApprovalComment prApprovalComment = new PRApprovalComment();
            prApprovalComment.setPrNo(prPriceApproval.getPrNo());
            prApprovalComment.setUserId(username);
            prApprovalComment.setComment(comment);
            prApprovalComment.setDateTime(formattedDate);
            prApprovalComment.setApprovalStatus("PR Approve");
            prApprovalCommentService.create(prApprovalComment);

            mv.getModelMap().put("tenderPriceApproval", prPriceApproval);

            //------for Log entry---------
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("PR No: " + pr_no1 + " approved successfully").setDrow("Y");
            logService.create(lm);

            session.setAttribute("successMessage",
                    " PR No: " + pr_no1 + " approved successfully");
        } else if (prPriceApproval.getApprovalStatus() == 1) {

            session.setAttribute("failureMessage",
                    "PR No: " + pr_no1 + " has already been approved.");
        } else if (prPriceApproval.getApprovalStatus() == 2) {

            session.setAttribute("failureMessage",
                    "PR No: " + pr_no1 + " has already been reworked.");
        } else if (prPriceApproval.getApprovalStatus() == 3) {

            session.setAttribute("failureMessage",
                    "PR No: " + pr_no1 + " has already been rejected.");
        }

        mv.setViewName("redirect:prMaster.htm?act=approvePRList");
        return mv;

    }

    public ModelAndView rejectPR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        OmsMaster omsMaster = null;
        String omsMasterId = request.getParameter("omsMasterId");
        if (omsMasterId != null && !omsMasterId.trim().isEmpty()) {
            omsMaster = omsMasterService.readById(Integer.parseInt(omsMasterId));
        }
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));
        String pr_no1 = prPriceApproval.getPrNo();
        PRMaster pRMaster = prMasterService.readByPrNo(pr_no1);
        PRPriceApprovalUser prPriceApprovalUser = prPriceApprovalUserService.approvaList1(username, pr_no1);

        int approveId = prPriceApproval.getId();
        PRPriceApprovalComment prPriceApprovalComment = prPriceApprovalCommentService.readByApproveId(approveId);

        int approvalStatus = prPriceApproval.getApprovalStatus();
        if (prPriceApproval.getApprovalStatus() == 0 || pRMaster.getAuthorizeFlag() == 10) {
            if (approvalStatus == 0) {
                prPriceApproval.setApprovalStatus(3);
                prPriceApprovalUser.setApprovalStatus(3);
                prPriceApprovalComment.setApprovalStatus(3);

            } else {

                prPriceApprovalUser.setApprovalStatus(3);
                prPriceApprovalComment.setApprovalStatus(3);

                mv.getModelMap().put("tenderPriceApprovalUser", prPriceApprovalUser);

            }

            String pr_no = prPriceApproval.getPrNo();
            PRMaster prMaster = prMasterService.readByPrNo(pr_no);
            prMaster.setAuthorizeFlag(3);
            prMasterService.update(prMaster);

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            prPriceApprovalComment.setDateTime(formattedDate);

            if (omsMaster != null) {
                String token = "";
                try {

                    TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }
                        }
                    };

                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                    URL url = new URL("https://oms-stage.chargecloud.net/api/v1/int/integrations/oms-token/generate");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);

                    String apiKey = "oms_4hN8sP2qW6vX1mJ9kL5tR3cF7yG0bD8";
                    JSONObject json = new JSONObject();
                    json.put("apiKey", apiKey);

                    OutputStream os = conn.getOutputStream();
                    os.write(json.toString().getBytes());
                    os.flush();
                    os.close();

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder response0 = new StringBuilder();
                    String line;

                    while ((line = br.readLine()) != null) {
                        response0.append(line);
                    }

                    br.close();

                    JSONObject responseJson = new JSONObject(response0.toString());
                    token = responseJson.getJSONObject("data").getString("token");

                    conn.disconnect();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDateTime = now.format(formatter);
                omsMaster.setPrNumber(pr_no);
                omsMaster.setPrFlag(4);
                omsMasterService.update(omsMaster);

                try {
                    JSONObject json = new JSONObject();
                    json.put("ticketID", omsMaster.getTicketId());
                    json.put("omsPrId", omsMaster.getOmsPrId());
                    json.put("prId", pr_no);
                    json.put("status", "PR REJECT");
                    json.put("createdAt", formattedDateTime);
                    json.put("createdBy", username);

                    TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }
                        }
                    };

                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                    URL url = new URL("https://oms.chargecloud.net/api/v1/int/integrations/e-produce/callback");
                    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

                    con.setRequestMethod("POST");

                    con.setRequestProperty("Content-Type", "application/json");
                    con.setRequestProperty("Authorization", "Bearer " + token);

                    con.setDoOutput(true);

                    try (OutputStream os = con.getOutputStream()) {
                        byte[] input = json.toString().getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    int responseCode = con.getResponseCode();
                    System.out.println("Response Code: " + responseCode);

                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {

                        StringBuilder response1 = new StringBuilder();
                        String responseLine;

                        while ((responseLine = br.readLine()) != null) {
                            response1.append(responseLine.trim());
                        }

                        System.out.println("Response: " + response1);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();
            prPriceApprovalComment.setUserId(employeeCode);
            prPriceApprovalComment.setPrApprovalId(approveId);

            prPriceApprovalComment.setApprovalComment(comment);
            prPriceApprovalCommentService.create(prPriceApprovalComment);
            prPriceApprovalService.update(prPriceApproval);
            try {
                prPriceApprovalUserService.update(prPriceApprovalUser);
            } catch (Exception e11) {
            }

            PRApprovalComment prApprovalComment = new PRApprovalComment();
            prApprovalComment.setPrNo(prPriceApproval.getPrNo());
            prApprovalComment.setUserId(username);
            prApprovalComment.setComment(comment);
            prApprovalComment.setDateTime(formattedDate);
            prApprovalComment.setApprovalStatus("PR Reject");
            prApprovalCommentService.create(prApprovalComment);

            mv.getModelMap().put("tenderPriceApproval", prPriceApproval);

            //------for Log entry---------
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("PR No: " + pr_no1 + " rejected successfully").setDrow("Y");
            logService.create(lm);

            session.setAttribute("successMessage",
                    " PR No: " + pr_no1 + " rejected successfully");
        } else if (prPriceApproval.getApprovalStatus() == 1) {

            session.setAttribute("failureMessage",
                    "PR No: " + pr_no1 + " has already been approved.");
        } else if (prPriceApproval.getApprovalStatus() == 2) {

            session.setAttribute("failureMessage",
                    "PR No: " + pr_no1 + " has already been reworked.");
        } else if (prPriceApproval.getApprovalStatus() == 3) {

            session.setAttribute("failureMessage",
                    "PR No: " + pr_no1 + " has already been rejected.");
        }

        mv.setViewName("redirect:prMaster.htm?act=approvePRList");
        return mv;

    }

    public ModelAndView reworkPR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        OmsMaster omsMaster = null;
        String omsMasterId = request.getParameter("omsMasterId");
        if (omsMasterId != null && !omsMasterId.trim().isEmpty()) {
            omsMaster = omsMasterService.readById(Integer.parseInt(omsMasterId));
        }

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        String pr_no1 = prPriceApproval.getPrNo();
        PRMaster pRMaster = prMasterService.readByPrNo(pr_no1);
        PRPriceApprovalUser prPriceApprovalUser = prPriceApprovalUserService.approvaList1(username, pr_no1);

        int approveId = prPriceApproval.getId();
        PRPriceApprovalComment prPriceApprovalComment = prPriceApprovalCommentService.readByApproveId(approveId);

        if (prPriceApproval.getApprovalStatus() == 0 || pRMaster.getAuthorizeFlag() == 10) {

            int level = prPriceApprovalUser.getLevel();
            level--;

            if (level < 0) {
                level = 0;
            }

            prPriceApproval.setCurrentApproval(level);
            prPriceApproval.setApprovalStatus(2);
            prPriceApprovalUser.setApprovalStatus(2);
            prPriceApprovalComment.setApprovalStatus(2);
            String pr_no = "";
            if (level == 0) {
                pr_no = prPriceApproval.getPrNo();
                PRMaster prMaster = prMasterService.readByPrNo(pr_no);
                prMaster.setAuthorizeFlag(2);
                prMasterService.update(prMaster);
            }

            if (omsMaster != null) {
                String token = "";
                try {
                    TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }
                        }
                    };

                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                    URL url = new URL("https://oms-stage.chargecloud.net/api/v1/int/integrations/oms-token/generate");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);

                    String apiKey = "oms_4hN8sP2qW6vX1mJ9kL5tR3cF7yG0bD8";
                    JSONObject json = new JSONObject();
                    json.put("apiKey", apiKey);

                    OutputStream os = conn.getOutputStream();
                    os.write(json.toString().getBytes());
                    os.flush();
                    os.close();

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder response0 = new StringBuilder();
                    String line;

                    while ((line = br.readLine()) != null) {
                        response0.append(line);
                    }

                    br.close();

                    JSONObject responseJson = new JSONObject(response0.toString());
                    token = responseJson.getJSONObject("data").getString("token");

                    conn.disconnect();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDateTime = now.format(formatter);
                omsMaster.setPrNumber(pr_no);
                omsMaster.setPrFlag(1);
                omsMasterService.update(omsMaster);

                try {
                    JSONObject json = new JSONObject();
                    json.put("ticketID", omsMaster.getTicketId());
                    json.put("omsPrId", omsMaster.getOmsPrId());
                    json.put("prId", pr_no);
                    json.put("status", "PR REWORK");
                    json.put("createdAt", formattedDateTime);
                    json.put("createdBy", username);

                    TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                            }
                        }
                    };

                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                    URL url = new URL("https://oms.chargecloud.net/api/v1/int/integrations/e-produce/callback");
                    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

                    con.setRequestMethod("POST");

                    con.setRequestProperty("Content-Type", "application/json");
                    con.setRequestProperty("Authorization", "Bearer " + token);

                    con.setDoOutput(true);

                    try (OutputStream os = con.getOutputStream()) {
                        byte[] input = json.toString().getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    int responseCode = con.getResponseCode();
                    System.out.println("Response Code: " + responseCode);

                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {

                        StringBuilder response1 = new StringBuilder();
                        String responseLine;

                        while ((responseLine = br.readLine()) != null) {
                            response1.append(responseLine.trim());
                        }

                        System.out.println("Response: " + response1);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            prPriceApprovalComment.setDateTime(formattedDate);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();
            prPriceApprovalComment.setUserId(employeeCode);
            prPriceApprovalComment.setPrApprovalId(approveId);

            prPriceApprovalComment.setApprovalComment(comment);
            prPriceApprovalCommentService.create(prPriceApprovalComment);

            prPriceApprovalService.update(prPriceApproval);

            try {
                prPriceApprovalUserService.update(prPriceApprovalUser);
            } catch (Exception e11) {
            }

            PRApprovalComment prApprovalComment = new PRApprovalComment();
            prApprovalComment.setPrNo(prPriceApproval.getPrNo());
            prApprovalComment.setUserId(username);
            prApprovalComment.setComment(comment);
            prApprovalComment.setDateTime(formattedDate);
            prApprovalComment.setApprovalStatus("PR Rework");
            prApprovalCommentService.create(prApprovalComment);

            mv.getModelMap().put("tenderPriceApprovalUser", prPriceApprovalUser);
            mv.getModelMap().put("tenderPriceApproval", prPriceApproval);

            //------for Log entry---------
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("PR No: " + pr_no1 + " sent for rework successfully").setDrow("Y");
            logService.create(lm);

            session.setAttribute("successMessage",
                    " PR No: " + pr_no1 + " sent for rework successfully");

        } else if (prPriceApproval.getApprovalStatus() == 1) {

            session.setAttribute("failureMessage",
                    "PR No: " + pr_no1 + " has already been approved.");
        } else if (prPriceApproval.getApprovalStatus() == 2) {

            session.setAttribute("failureMessage",
                    "PR No: " + pr_no1 + " has already been reworked.");
        } else if (prPriceApproval.getApprovalStatus() == 3) {

            session.setAttribute("failureMessage",
                    "PR No: " + pr_no1 + " has already been rejected.");
        }

        mv.setViewName("redirect:prMaster.htm?act=approvePRList");
        return mv;

    }

    public ModelAndView viewApproveUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        int approveId = prPriceApproval.getId();

        List li = prPriceApprovalUserService.readByRefNo(approveId);

        mv.getModelMap().put("id", id);

        mv.getModelMap().put("li", li);
        mv.setViewName("PR/ViewApproveprList");
        return mv;
    }

    public ModelAndView searchPR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();

        List DepartmentList = departmentMasterService.read();
        mv.getModelMap().put("DepartmentList", DepartmentList);

        mv.getModelMap().put("prMaster", prMaster);
        mv.setViewName("PR/SearchPR");

        return mv;
    }

    public ModelAndView searchPRList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List departmentList = departmentMasterService.read();

        mv.addObject("DepartmentList", departmentList);

        mv.setViewName("PR/SearchPR");
        return mv;
    }

    public ModelAndView searchPRPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String prNumber = request.getParameter("prNumber");
        String projectName = request.getParameter("projectName");
        String department = request.getParameter("department");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        switch (orderColumnIndex) {

            case "0":
                orderColumn = "id";
                break;

            case "1":
                orderColumn = "prNo";
                break;

            case "2":
                orderColumn = "title";
                break;

            case "3":
                orderColumn = "projectId";
                break;

            case "5":
                orderColumn = "department";
                break;

            case "8":
                orderColumn = "announceDate";
                break;

            default:
                orderColumn = "id";
                break;
        }

        List list = prMasterService.getPRPagination(start, length, searchValue, prNumber, projectName, department, fromDate, toDate, orderColumn, orderDir);

        int totalRecords = prMasterService.getTotalPRCount();

        int filteredRecords = prMasterService.getFilteredPRCount(searchValue, prNumber, projectName, department, fromDate, toDate);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            PRMaster pr = (PRMaster) obj;

            JSONObject json = new JSONObject();

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put(
                    "prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no="
                    + (pr.getPrNo() != null ? pr.getPrNo() : "")
                    + "' class='fw-600 text-break gradient-text'>"
                    + (pr.getPrNo() != null ? pr.getPrNo() : "")
                    + "</a>"
            );

            json.put("title", pr.getTitle() != null ? pr.getTitle() : "");

            json.put("projectId", pr.getprojectId() != null ? pr.getprojectId() : "");

            json.put("workDesc", pr.getWorkDesc() != null ? pr.getWorkDesc() : "");

            json.put("department", pr.getDepartment() != null ? pr.getDepartment() : "");

            json.put("billingLocation", pr.getBillingLocation() != null ? pr.getBillingLocation() : "");

            json.put("contactPerson", pr.getContactPerson() != null ? pr.getContactPerson() : "");

            json.put("announceDate", pr.getAnnounceDate() != null ? pr.getAnnounceDate().toString() : "");

            json.put("prAuthorizeUser", pr.getPrAuthorizeUser() != null ? pr.getPrAuthorizeUser() : "");

            json.put("prAuthorizeDate", pr.getPrAuthorizeDate() != null ? pr.getPrAuthorizeDate().toString() : "");

            json.put("tenderCreaterId", pr.getTenderCreaterId() != null ? pr.getTenderCreaterId() : "");

            json.put("tenderAssignUser", pr.getTenderAssignUser() != null ? pr.getTenderAssignUser() : "");

            json.put("tenderAssignDate", pr.getTenderAssignDate() != null ? pr.getTenderAssignDate().toString() : "");

            json.put("tenderCreaterUser", pr.getTenderCreaterUser() != null ? pr.getTenderCreaterUser() : "");

            json.put("tenderCreaterDate", pr.getTenderCreaterDate() != null ? pr.getTenderCreaterDate().toString() : "");

            json.put("techBidOpenUser", pr.getTechBidOpenUser() != null ? pr.getTechBidOpenUser() : "");

            json.put("techBidOpenDate", pr.getTechBidOpenDate() != null ? pr.getTechBidOpenDate().toString() : "");

            json.put("techBidApproveUser", pr.getTechBidApproveUser() != null ? pr.getTechBidApproveUser() : "");

            json.put("techBidApproveDate", pr.getTechBidApproveDate() != null ? pr.getTechBidApproveDate().toString() : "");

            json.put("priceBidStartUser", pr.getPriceBidStartUser() != null ? pr.getPriceBidStartUser() : "");

            json.put("priceBidStartDate", pr.getPriceBidStartDate() != null ? pr.getPriceBidStartDate().toString() : "");

            json.put("priceBidOpenUser", pr.getPriceBidOpenUser() != null ? pr.getPriceBidOpenUser() : "");

            json.put("priceBidOpenDate", pr.getPriceBidOpenDate() != null ? pr.getPriceBidOpenDate().toString() : "");

            json.put("tenderAwardUser", pr.getTenderAwardUser() != null ? pr.getTenderAwardUser() : "");

            json.put("tenderAwardDate", pr.getTenderAwardDate() != null ? pr.getTenderAwardDate().toString() : "");

            json.put("tenderAcceptUser", pr.getTenderAcceptUser() != null ? pr.getTenderAcceptUser() : "");

            json.put("tenderAcceptDate", pr.getTenderAcceptDate() != null ? pr.getTenderAcceptDate().toString() : "");

            json.put("finalCloseUser", pr.getFinalCloseUser() != null ? pr.getFinalCloseUser() : "");

            json.put("finalCloseDate", pr.getFinalCloseDate() != null ? pr.getFinalCloseDate().toString() : "");

            String status = "Unknown Status";

            if (pr.getFinalCloseDate() != null) {

                status = "Po Closed";

            } else if (pr.getAuthorizeFlag() == 0) {

                status = "Pending";

            } else if (pr.getAuthorizeFlag() == 1) {

                status = "Approve";

            } else if (pr.getAuthorizeFlag() == 2) {

                status = "Rework";

            } else if (pr.getAuthorizeFlag() == 3) {

                status = "Reject";

            } else if (pr.getAuthorizeFlag() == 6) {

                status = "Tender Created";
            }

            json.put("status", status);

            json.put(
                    "action",
                    "<span class='icon-slot'>"
                    + "<a href='prMaster.htm?act=searchViewPRDetails&id="
                    + pr.getId()
                    + "' class='d-flex text-info p-1 mx-1 action-link'>"
                    + "<img src='StorageYard/assets/images/eye-open.svg'>"
                    + "</a>"
                    + "</span>"
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

    public ModelAndView searchPRListExport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String prNumber = request.getParameter("prNumber");
        String projectName = request.getParameter("projectName");
        String open_from_date = request.getParameter("open_from_date");
        String open_to_date = request.getParameter("open_to_date");
        String department = request.getParameter("department");

        String searchValue = request.getParameter("searchValue");

        String orderColumnIndex = request.getParameter("orderColumn");
        String orderDir = request.getParameter("orderDir");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        switch (orderColumnIndex) {

            case "0":
                orderColumn = "id";
                break;

            case "1":
                orderColumn = "prNo";
                break;

            case "2":
                orderColumn = "title";
                break;

            case "3":
                orderColumn = "projectId";
                break;

            case "5":
                orderColumn = "department";
                break;

            case "8":
                orderColumn = "announceDate";
                break;

            default:
                orderColumn = "id";
                break;
        }

        int totalData = prMasterService.getFilteredPRCount(searchValue, prNumber, projectName, department, open_from_date, open_to_date);

        List list = prMasterService.getPRPagination(0, totalData, searchValue, prNumber, projectName, department, open_from_date, open_to_date, orderColumn, orderDir);

        mv.getModelMap().put("list", list);

        mv.setViewName("PR/SearchPRExport");

        return mv;
    }

    public ModelAndView PRHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String prNo = request.getParameter("pr_no");

        if (prNo != null && prNo.startsWith("TEN")) {
            prNo = "PR" + prNo.substring(3);
        }

        PRMaster prMaster = prMasterService.readByPrNo(prNo);

        String refNo = "TEN" + prNo.replaceAll("PR", "");

        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List tenderFollowup = tenderFollowupService.readByTender(refNo);
        mv.getModelMap().put("tenderFollowup", tenderFollowup);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("prNo", prNo);
        mv.setViewName("PR/PRHistory");
        return mv;
    }

    public ModelAndView listPRList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("PR/ListPR");

        return mv;
    }

    public ModelAndView listPRPeginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);

        UserMaster user = (UserMaster) session.getAttribute("user");

        String username = user.getUserFullName();

        int draw = Integer.parseInt(request.getParameter("draw"));

        int start = Integer.parseInt(request.getParameter("start"));

        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String orderColumnIndex = request.getParameter("order[0][column]");

        String orderDir = request.getParameter("order[0][dir]");

        String statusFilter = request.getParameter("statusFilter");

        if (orderDir == null || orderDir.equals("")) {

            orderDir = "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {

            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        switch (orderColumnIndex) {

            case "1":
                orderColumn = "prNo";
                break;

            case "2":
                orderColumn = "title";
                break;

            case "3":
                orderColumn = "projectId";
                break;

            case "4":
                orderColumn = "contactPerson";
                break;

            case "5":
                orderColumn = "announceDate";
                break;

            case "6":
                orderColumn = "authorizeFlag";
                break;

            default:
                orderColumn = "id";
                break;
        }

        List list = prMasterService.getListPRPagination(start, length, searchValue, username, orderColumn, orderDir, statusFilter);

        int totalRecords = prMasterService.getTotalListPRCount(username);

        int filteredRecords = prMasterService.getFilteredListPRCount(username, searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {

            srNo = filteredRecords - start;

        } else {

            srNo = start + 1;
        }

        for (Object obj : list) {

            PRMaster pr = (PRMaster) obj;

            JSONObject json = new JSONObject();

            if (isDesc) {

                json.put("srNo", srNo--);

            } else {

                json.put("srNo", srNo++);
            }

            json.put("prNo",
                    pr.getPrNo() != null ? pr.getPrNo() : "");

            json.put("title",
                    pr.getTitle() != null ? pr.getTitle() : "");

            json.put("projectId", pr.getprojectId() != null ? pr.getprojectId() : "");

            json.put("contactPerson", pr.getContactPerson() != null ? pr.getContactPerson() : "");

            json.put("announceDate", pr.getAnnounceDate() != null ? pr.getAnnounceDate().toString() : "");

            String status = "";

            if (pr.getAuthorizeFlag() == 0) {

                status = "Pending";

            } else if (pr.getAuthorizeFlag() == 1) {

                status = "Approve";

            } else if (pr.getAuthorizeFlag() == 2) {

                status = "Rework";

            } else if (pr.getAuthorizeFlag() == 10) {

                status = "Rework From Procurement";

            } else if (pr.getAuthorizeFlag() == 3) {

                status = "Reject";

            } else if (pr.getAuthorizeFlag() == 6) {

                status = "Tender Created";

            } else if (pr.getAuthorizeFlag() == 7) {

                status = "Save As Draft";
            }

            json.put("status", status);

            String action = "";

            action += "<div class='btn-group' style='display:flex;gap:10px;align-items:center;'>";

            action += "<a href='prMaster.htm?act=prSearchView&id="
                    + pr.getId()
                    + "' class='text-info p-1 action-link'>"
                    + "<img src='StorageYard/assets/images/eye-open.svg'>"
                    + "</a>";

            if (pr.getAuthorizeFlag() == 2) {

                action += "<a href='prMaster.htm?act=editPR&id="
                        + pr.getId()
                        + "' class='btn theme-btn light-btn ml-2'>Edit</a>";
            }

            if (pr.getAuthorizeFlag() == 7) {

                action += "<a href='prMaster.htm?act=editPR&id="
                        + pr.getId()
                        + "' class='btn theme-btn light-btn ml-2'>Save As Draft Edit</a>";
            }

            if (pr.getAuthorizeFlag() == 6) {

                action += "<a href='tenderMaster.htm?act=statusTender&id="
                        + pr.getId()
                        + "' class='btn theme-btn light-btn ml-2'>Status</a>";
            }

            action += "</div>";

            json.put("action", action);

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

    public ModelAndView searchView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNo = prMaster.getPrNo();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prVendor = prVendorService.readByRfqNo(prNo);
        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("prVendor", prVendor);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("id", id);

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);

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

        mv.setViewName("PR/SearchView");
        return mv;
    }

    public ModelAndView searchViewForOms(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readByPrNo(id);
        String prNo = prMaster.getPrNo();
        int omsPrFlag = 2;
        OmsMaster omsMaster = omsMasterService.readByPrNo(prNo, omsPrFlag);
        if (omsMaster != null) {
            mv.getModelMap().put("omsMaster", omsMaster);
        }
        PRPriceApproval prPriceApproval = prPriceApprovalService.readByPrNo(id);

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prVendor = prVendorService.readByRfqNo(prNo);
        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("prVendor", prVendor);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("id", id);

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);

        mv.setViewName("PR/SearchView");
        return mv;
    }

    public ModelAndView prSearchView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNo = prMaster.getPrNo();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prVendor = prVendorService.readByRfqNo(prNo);
        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("prVendor", prVendor);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("id", id);

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);

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

        mv.setViewName("PR/PrSearchView");
        return mv;
    }

    public ModelAndView searchViewPRDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNo = prMaster.getPrNo();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prVendor = prVendorService.readByRfqNo(prNo);
        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("prVendor", prVendor);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("id", id);

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);

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

        mv.setViewName("PR/SearchPRDetails");
        return mv;
    }

    public void downloadPrSingleQuoteAttachment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String prNo = request.getParameter("prNo");
        String id = request.getParameter("id");

        PRMaster pRMaster = prMasterService.readByPrNo(prNo);
        String fileName = pRMaster.getSingleQuoteAttachment();
        String RefNumber = prNo.replace("/", "");

        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "PR"
                + File.separator + RefNumber + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        mv.setViewName("forward:prMaster.htm?act=searchView&id=" + id);

    }

    public ModelAndView searchView1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));
        String prNo = prMaster.getPrNo();

        int omsPrFlag = 3;
        OmsMaster omsMaster = omsMasterService.readByPrNo(prNo, omsPrFlag);
        if (omsMaster != null) {
            mv.getModelMap().put("omsMaster", omsMaster);
        }

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        int pr_approval_id = 0;
        for (Object o : tenderPriceApproval) {
            PRPriceApproval prpa = (PRPriceApproval) o;
            pr_approval_id = prpa.getId();
        }

        if (pr_approval_id > 0) {
            PRPriceApprovalComment prApprovalComment = prPriceApprovalCommentService.readByApproveId(pr_approval_id);
            mv.getModelMap().put("prApprovalComment", prApprovalComment);
        }

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);
        mv.setViewName("PR/SearchView1");
        return mv;
    }

    public ModelAndView searchView2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNo = prMaster.getPrNo();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List employeeMaster = employeeMasterService.readTenderEmployee();
        mv.getModelMap().put("employeeMaster", employeeMaster);

        int pr_approval_id = 0;
        for (Object o : tenderPriceApproval) {
            PRPriceApproval prpa = (PRPriceApproval) o;
            pr_approval_id = prpa.getId();
        }

        if (pr_approval_id > 0) {
            PRPriceApprovalComment prApprovalComment = prPriceApprovalCommentService.readByApproveId(pr_approval_id);
            mv.getModelMap().put("prApprovalComment", prApprovalComment);
        }

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);
        mv.setViewName("PR/SearchView2");
        return mv;
    }

    public ModelAndView searchView3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNo = prMaster.getPrNo();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List employeeMaster = employeeMasterService.readTenderEmployee();
        mv.getModelMap().put("employeeMaster", employeeMaster);

        int pr_approval_id = 0;
        for (Object o : tenderPriceApproval) {
            PRPriceApproval prpa = (PRPriceApproval) o;
            pr_approval_id = prpa.getId();
        }

        if (pr_approval_id > 0) {
            PRPriceApprovalComment prApprovalComment = prPriceApprovalCommentService.readByApproveId(pr_approval_id);
            mv.getModelMap().put("prApprovalComment", prApprovalComment);
        }

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);
        mv.setViewName("PR/SearchView3");
        return mv;
    }

    public ModelAndView searchMaterialMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");

        String material_group = request.getParameter("material_group");
        String material_Type = request.getParameter("material_Type");
        String material_code = request.getParameter("material_code");
        String material_desc = request.getParameter("material_desc");

        List materialMaster = materialMasterService.searchMaterial(material_group, material_Type, material_code, material_desc);
        mv.getModelMap().put("materialMaster", materialMaster);

        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 0);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("ref_no", ref_no);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AddServicePRDocument");
        return mv;
    }

    public ModelAndView closePrNavbar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List DepartmentList = departmentMasterService.read();

        mv.getModelMap().put("DepartmentList", DepartmentList);

        mv.setViewName("PR/ClosePrNavbar");
        return mv;
    }

    public ModelAndView addPrItemMaterialSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String pr_no1 = request.getParameter("pr_no1");
        if (pr_no1 == null) {
            pr_no1 = "";
        }

        String[] checkId = request.getParameterValues("checkId");
        String[] material_code = request.getParameterValues("material_code1");
        String[] material_desc = request.getParameterValues("material_desc1");
        String[] material_detail = request.getParameterValues("material_detail");
        String[] material_uom = request.getParameterValues("material_uom");
        String[] material_qty = request.getParameterValues("material_qty");
        String[] material_hsn = request.getParameterValues("material_hsn");
        String[] material_gst = request.getParameterValues("material_gst");

        for (int i = 0; i < checkId.length; i++) {
            String check_value = checkId[i];

            List PrItemMaster1 = prItemMasterService.readByRefNo(ref_no, 0);
            String srNo = "";
            String s_no = "";
            for (Object o : PrItemMaster1) {
                PRItemMaster tim = (PRItemMaster) o;
                s_no = tim.getSrNo();
            }

            if (s_no.equals("")) {
                srNo = "1";
            } else {
                srNo = (Integer.parseInt(s_no) + 1) + "";
            }

            //insert data
            PRItemMaster prItemMaster = new PRItemMaster();
            prItemMaster.setPrNo(ref_no);
            prItemMaster.setItemCode(material_code[Integer.parseInt(check_value) - 1]);
            prItemMaster.setItemDescription(material_desc[Integer.parseInt(check_value) - 1]);
            prItemMaster.setRemark(material_detail[Integer.parseInt(check_value) - 1]);
            prItemMaster.setUom(material_uom[Integer.parseInt(check_value) - 1]);
            prItemMaster.setQty(material_qty[Integer.parseInt(check_value) - 1]);
            prItemMaster.setDeliveryScheduleDate(material_detail[Integer.parseInt(check_value) - 1]);
            prItemMaster.setDeliveryScheduleQty(material_detail[Integer.parseInt(check_value) - 1]);
            prItemMaster.setLocation("");
            prItemMaster.setPurNo("");
            prItemMaster.setItemNo("");
            prItemMaster.setSrNo(srNo);
            prItemMasterService.create(prItemMaster);

        }

        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 0);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AddServicePRDocument");
        return mv;
    }

    public ModelAndView deletePrItemMaterial(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");

        String ids = request.getParameter("Ids");
        String[] checkedId = ids.split(",");

        try {
            for (int i = 0; i < checkedId.length; i++) {
                String check_value = checkedId[i];

                prItemMasterService.delete(Integer.parseInt(check_value));

                request.setAttribute("successMessage",
                        " Item Deleted Successfully");
            }
        } catch (Exception e) {
        }

//        String[] checkedId = request.getParameterValues("checkedId");
//
//        for (int i = 0; i < checkedId.length; i++) {
//            String check_value = checkedId[i];
//
//            prItemMasterService.delete(Integer.parseInt(check_value));
//
//        }
        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 0);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AjaxAddServicePRDocument");
        return mv;
    }

    public ModelAndView addPrMaterialManuallySubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String RefNo = ref_no.replace("/", "");
        String service_type = request.getParameter("service_type");

        String title = request.getParameter("title");

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + RefNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        try {

            //iterating over each column  
            String srNo = "";
            String item_code = request.getParameter("item_code");
            String item_desc = request.getParameter("item_desc");
            String long_text = request.getParameter("item_detail");
            String make = request.getParameter("make");

            String uom = request.getParameter("uom");
            String qty = request.getParameter("qty");
            String hsno_no = request.getParameter("hsn_no");
            String gst = request.getParameter("gst");
            String remark = request.getParameter("item_detail");
            int i = 0;

            List PrItemMaster1 = prItemMasterService.readByRefNo(ref_no, 0);

            String s_no = "";
            for (Object o : PrItemMaster1) {
                PRItemMaster tim = (PRItemMaster) o;
                s_no = tim.getSrNo();
            }

            if (s_no.equals("")) {
                srNo = "1";
            } else {
                srNo = (Integer.parseInt(s_no) + 1) + "";
            }

            //insert data
            PRItemMaster prItemMaster = new PRItemMaster();
            prItemMaster.setPrNo(ref_no);
            prItemMaster.setItemCode(item_code);
            prItemMaster.setItemDescription(item_desc);
            prItemMaster.setRemark(remark);
            prItemMaster.setUom(uom);

            prItemMaster.setQty(qty);
            prItemMaster.setDeliveryScheduleDate(make);
            prItemMaster.setDeliveryScheduleQty(long_text);
            prItemMaster.setLocation("");
            prItemMaster.setPurNo("");
            prItemMaster.setItemNo("");
            prItemMaster.setSrNo(srNo);
            prItemMasterService.create(prItemMaster);

            System.out.println("");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // insert into file details
        request.setAttribute("successMessage",
                " File Upload successfully");

        //    mv.getModelMap().put("fileDetail", fileDetail);
        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 0);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("ref_no", ref_no);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AddServicePRDocument");
        return mv;
    }

    public ModelAndView addServicePRDocument1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 1);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String department = employeeMaster.getDepartment();
        String location = employeeMaster.getLocation();

        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        ServiceRights serviceRights = serviceRightsService.ReadDepartmentLocation(department, location);

        mv.getModelMap().put("serviceRights", serviceRights);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("ref_no", ref_no);

        mv.setViewName("PR/AjaxAddServicePRDocument1");
        return mv;
    }

    public ModelAndView addServicePRSubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no1");
        String RefNo = ref_no.replace("/", "");
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "PR"
                + File.separator + RefNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        String service_file = request.getParameter("iteamSampleFile");
        if (service_file == null) {
            service_file = "";
        }

        String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("iteamSampleFile");

        service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);

        if (fileDetail1.isEmpty()) {

            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "PR"
                            + File.separator + RefNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            prItemMasterService.deleteRefNo(ref_no, 1);

            try {
                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/PR/" + RefNo + "/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);

                // ✅ Header validation
                Map<Integer, String> requiredColumns = new LinkedHashMap<>();
                requiredColumns.put(0, "Sr. No.");
                requiredColumns.put(2, "Item Description (40 Character)");
                requiredColumns.put(5, "Qty");
                requiredColumns.put(6, "UoM");
                requiredColumns.put(7, "Account Assigment Category");
                requiredColumns.put(8, "Account Assigment Value");
                requiredColumns.put(9, "Product Type");
                requiredColumns.put(10, "Product Group");
                requiredColumns.put(11, "TAX Code");
                requiredColumns.put(12, "VALUATION PRICE (Budget Value)");
                requiredColumns.put(13, "Delivery Date");
                requiredColumns.put(14, "Start date");
                requiredColumns.put(15, "End date");

                boolean isValidTemplate = true;
                String headerMismatchMsg = "Please upload the proper PR Excel template file.";

                try {
                    if (sheet.getPhysicalNumberOfRows() < 6) {
                        isValidTemplate = false;
                    } else {
                        Row headerRow = sheet.getRow(5);
                        if (headerRow == null) {
                            isValidTemplate = false;
                        } else {
                            for (Map.Entry<Integer, String> entry : requiredColumns.entrySet()) {
                                int colIdx = entry.getKey();
                                String expectedHeader = entry.getValue();
                                Cell headerCell = headerRow.getCell(colIdx);

                                String actualHeader = "";
                                if (headerCell != null) {
                                    int cellType = headerCell.getCellType();
                                    if (cellType == Cell.CELL_TYPE_STRING) {
                                        actualHeader = headerCell.getStringCellValue().trim();
                                    } else if (cellType == Cell.CELL_TYPE_NUMERIC) {
                                        actualHeader = String.valueOf(headerCell.getNumericCellValue()).trim();
                                    } else if (cellType == Cell.CELL_TYPE_BOOLEAN) {
                                        actualHeader = String.valueOf(headerCell.getBooleanCellValue()).trim();
                                    } else if (cellType == Cell.CELL_TYPE_FORMULA) {
                                        try {
                                            actualHeader = headerCell.getStringCellValue().trim();
                                        } catch (Exception ef) {
                                            actualHeader = String.valueOf(headerCell.getNumericCellValue()).trim();
                                        }
                                    } else {
                                        actualHeader = "";
                                    }
                                }

                                if (!actualHeader.equalsIgnoreCase(expectedHeader.trim())) {
                                    isValidTemplate = false;
                                    break;
                                }
                            }
                        }
                    }
                } catch (Exception validationEx) {
                    isValidTemplate = false;
                }

                if (!isValidTemplate) {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("{\"status\":\"error\",\"message\":\"" + headerMismatchMsg + "\"}");
                    response.getWriter().flush();
                    return null;
                }

                // ✅ Process rows after validation passes
                Iterator<Row> itr = sheet.iterator();
                int j = 0;
                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    if (j > 6) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String accountassigmentcategory = "";
                        String accountassigmentvalue = "";
                        String producttype = "";
                        String productgroup = "";
                        String taxcode = "";
                        String valuationprice = "";
                        String deliverydate = "";
                        String startdate = "";
                        String enddate = "";
                        String remark = "";
                        String budget_amount = "";

                        int i = 0;
                        int k = 0;
                        for (int i1 = 1; i1 <= 16; i1++) {
                            i++;
                            try {
                                Cell cell = cellIterator.next();
                                int sh1 = cell.getColumnIndex();
                                i = sh1 + 1;
                                i1 = i;
                                if (i == 1) {
                                    try {
                                        srNo = cell.getNumericCellValue() + "";
                                    } catch (Exception e1) {
                                        srNo = cell.getStringCellValue();
                                    }
                                    if (srNo.equals("0.0")) {
                                        k = 1;
                                    }
                                }
                                if (i == 2) {
                                    try {
                                        item_code = cell.getNumericCellValue() + "";
                                        if (item_code.equals("0.0")) {
                                            item_code = "";
                                        }
                                    } catch (Exception e1) {
                                        item_code = cell.getStringCellValue();
                                    }
                                }
                                if (i == 3) {
                                    try {
                                        item_desc = cell.getNumericCellValue() + "";
                                    } catch (Exception e1) {
                                        item_desc = cell.getStringCellValue().replaceAll("\'", "");
                                    }
                                }
                                if (i == 4) {
                                    try {
                                        purpose = cell.getNumericCellValue() + "";
                                        if (long_text.equals("0.0")) {
                                            long_text = "";
                                        }
                                    } catch (Exception e1) {
                                        purpose = cell.getStringCellValue();
                                    }
                                }
                                if (i == 5) {
                                    try {
                                        long_text = cell.getNumericCellValue() + "";
                                        if (long_text.equals("0.0")) {
                                            long_text = "";
                                        }
                                    } catch (Exception e1) {
                                        long_text = cell.getStringCellValue();
                                    }
                                }
                                if (i == 6) {
                                    try {
                                        qty = cell.getNumericCellValue() + "";
                                        Float litersOfPetrol = Float.parseFloat(qty);
                                        DecimalFormat df = new DecimalFormat("0.00");
                                        df.setMaximumFractionDigits(2);
                                        litersOfPetrol = Float.parseFloat(df.format(litersOfPetrol));
                                        qty = litersOfPetrol + "";
                                    } catch (Exception e1) {
                                        qty = cell.getStringCellValue();
                                    }
                                }
                                if (i == 7) {
                                    try {
                                        uom = cell.getNumericCellValue() + "";
                                        if (uom.equals("0.0")) {
                                            uom = "";
                                        }
                                    } catch (Exception e1) {
                                        uom = cell.getStringCellValue();
                                    }
                                }
                                if (i == 8) {
                                    try {
                                        accountassigmentcategory = cell.getNumericCellValue() + "";
                                        if (accountassigmentcategory.equals("0.0")) {
                                            accountassigmentcategory = "";
                                        }
                                    } catch (Exception e1) {
                                        accountassigmentcategory = cell.getStringCellValue();
                                    }
                                }
                                if (i == 9) {
                                    try {
                                        accountassigmentvalue = cell.getNumericCellValue() + "";
                                        if (accountassigmentvalue.equals("0.0")) {
                                            accountassigmentvalue = "";
                                        }
                                    } catch (Exception e1) {
                                        accountassigmentvalue = cell.getStringCellValue();
                                    }
                                }
                                if (i == 10) {
                                    try {
                                        producttype = cell.getNumericCellValue() + "";
                                        if (producttype.equals("0.0")) {
                                            producttype = "";
                                        }
                                    } catch (Exception e1) {
                                        producttype = cell.getStringCellValue();
                                    }
                                }
                                if (i == 11) {
                                    try {
                                        productgroup = cell.getNumericCellValue() + "";
                                        if (productgroup.equals("0.0")) {
                                            productgroup = "";
                                        }
                                    } catch (Exception e1) {
                                        productgroup = cell.getStringCellValue();
                                    }
                                }
                                if (i == 12) {
                                    try {
                                        taxcode = cell.getNumericCellValue() + "";
                                        if (taxcode.equals("0.0")) {
                                            taxcode = "";
                                        }
                                    } catch (Exception e1) {
                                        taxcode = cell.getStringCellValue();
                                    }
                                }
                                if (i == 13) {
                                    try {
                                        valuationprice = cell.getNumericCellValue() + "";
                                        if (valuationprice.equals("0.0")) {
                                            valuationprice = "";
                                        }
                                    } catch (Exception e1) {
                                        valuationprice = cell.getStringCellValue();
                                    }
                                }
                                if (i == 14) {
                                    try {
                                        Date timeLine = cell.getDateCellValue();
                                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                        deliverydate = formatter.format(timeLine);
                                    } catch (Exception e1) {
                                        deliverydate = cell.getStringCellValue();
                                    }
                                }
                                if (i == 15) {
                                    try {
                                        Date timeLine = cell.getDateCellValue();
                                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                        startdate = formatter.format(timeLine);
                                    } catch (Exception e1) {
                                        startdate = cell.getStringCellValue();
                                    }
                                }
                                if (i == 16) {
                                    try {
                                        Date timeLine = cell.getDateCellValue();
                                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                        enddate = formatter.format(timeLine);
                                    } catch (Exception e1) {
                                        enddate = cell.getStringCellValue();
                                    }
                                }
                            } catch (Exception e11) {
                            }
                        }

                        if (k == 1) {
                            break;
                        }

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
                            List prItem = prItemMasterService.readByPRItemDesc(ref_no, item_desc, 1);
                            if (prItem.size() == 0) {
                                PRItemMaster prItemMaster = new PRItemMaster();
                                prItemMaster.setPrNo(ref_no);
                                prItemMaster.setItemCode(item_code.replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                                prItemMaster.setItemDescription(item_desc);
                                prItemMaster.setRemark(remark);
                                prItemMaster.setUom(uom.replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                                prItemMaster.setQty(qty.replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                                prItemMaster.setDeliveryScheduleDate(long_text);
                                prItemMaster.setDeliveryScheduleQty(purpose);
                                prItemMaster.setLocation("");
                                prItemMaster.setPurNo(budget_amount);
                                prItemMaster.setItemNo("");
                                prItemMaster.setSrNo(srNo.replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                                prItemMaster.setAccountAssigmentCategory(accountassigmentcategory);
                                prItemMaster.setAccountAssigmentValue(accountassigmentvalue);
                                prItemMaster.setProductType(producttype);
                                prItemMaster.setProductGroup(productgroup);
                                prItemMaster.setTaxCode(taxcode);
                                prItemMaster.setValuationPrice(valuationprice);
                                prItemMaster.setDeliveryDate(deliverydate);
                                prItemMaster.setStartDate(startdate);
                                prItemMaster.setEndDate(enddate);
                                prItemMaster.setItemType(1);
                                prItemMasterService.create(prItemMaster);
                            }
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // ✅ Valid file processed successfully — return HTML view
            List materialGroupMaster = materialGroupMasterService.read();
            List materialTypeMaster = materialTypeMasterService.read();
            mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
            mv.getModelMap().put("materialTypeMaster", materialTypeMaster);
            List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 1);
            mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
            mv.getModelMap().put("prMaster", prMaster);
            mv.getModelMap().put("ref_no", ref_no);
            mv.setViewName("PR/AjaxAddServicePRDocument1");
            return mv;

        } else {

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"status\":\"error\",\"message\":\"File already exists. Please upload a different file.\"}");
            response.getWriter().flush();
            return null;
        }
    }

    public ModelAndView searchMaterialMaster1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");

        String material_group = request.getParameter("material_group");
        String material_Type = request.getParameter("material_Type");
        String material_code = request.getParameter("material_code");
        String material_desc = request.getParameter("material_desc");

        List materialMaster = materialMasterService.searchMaterial(material_group, material_Type, material_code, material_desc);
        mv.getModelMap().put("materialMaster", materialMaster);

        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 1);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("ref_no", ref_no);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AjaxAddServicePRDocument1");
        return mv;
    }

    public ModelAndView addPrItemMaterialSubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String pr_no1 = request.getParameter("pr_no1");
        if (pr_no1 == null) {
            pr_no1 = "";
        }

        String[] checkId = request.getParameterValues("checkId");
        String[] material_code = request.getParameterValues("material_code1");
        String[] material_desc = request.getParameterValues("material_desc1");
        String[] material_detail = request.getParameterValues("material_detail");
        String[] material_uom = request.getParameterValues("material_uom");
        String[] material_qty = request.getParameterValues("material_qty");
        String[] material_hsn = request.getParameterValues("material_hsn");
        String[] material_gst = request.getParameterValues("material_gst");

        for (int i = 0; i < checkId.length; i++) {
            String check_value = checkId[i];

            List PrItemMaster1 = prItemMasterService.readByRefNo(ref_no, 1);
            String srNo = "";
            String s_no = "";
            for (Object o : PrItemMaster1) {
                PRItemMaster tim = (PRItemMaster) o;
                s_no = tim.getSrNo();
            }

            if (s_no.equals("")) {
                srNo = "1";
            } else {
                srNo = (Integer.parseInt(s_no) + 1) + "";
            }

            //insert data
            PRItemMaster prItemMaster = new PRItemMaster();
            prItemMaster.setPrNo(ref_no);
            prItemMaster.setItemCode(material_code[Integer.parseInt(check_value) - 1]);
            prItemMaster.setItemDescription(material_desc[Integer.parseInt(check_value) - 1]);
            prItemMaster.setRemark(material_detail[Integer.parseInt(check_value) - 1]);
            prItemMaster.setUom(material_uom[Integer.parseInt(check_value) - 1]);
            prItemMaster.setQty(material_qty[Integer.parseInt(check_value) - 1]);
            prItemMaster.setDeliveryScheduleDate(material_detail[Integer.parseInt(check_value) - 1]);
            prItemMaster.setDeliveryScheduleQty(material_detail[Integer.parseInt(check_value) - 1]);
            prItemMaster.setLocation("");
            prItemMaster.setPurNo("");
            prItemMaster.setItemNo("");
            prItemMaster.setSrNo(srNo);
            prItemMaster.setItemType(1);
            prItemMasterService.create(prItemMaster);

        }

        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 1);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("prMaster", prMaster);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AjaxAddServicePRDocument1");
        return mv;
    }

    public ModelAndView deletePrItemMaterial1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");

        String ids = request.getParameter("Ids");
        String[] checkedId = ids.split(",");

        try {
            for (int i = 0; i < checkedId.length; i++) {
                String check_value = checkedId[i];

                prItemMasterService.delete(Integer.parseInt(check_value));

                request.setAttribute("successMessage",
                        " Item Deleted Successfully");
            }
        } catch (Exception e) {
        }

//        String[] checkedId = request.getParameterValues("checkedId");
//
//        for (int i = 0; i < checkedId.length; i++) {
//            String check_value = checkedId[i];
//
//            prItemMasterService.delete(Integer.parseInt(check_value));
//
//        }
        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 1);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AjaxAddServicePRDocument1");
        return mv;
    }

    public ModelAndView addPrMaterialManuallySubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String RefNo = ref_no.replace("/", "");

        String service_type = request.getParameter("service_type");

        String title = request.getParameter("title");

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + RefNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        try {

            //iterating over each column  
            String srNo = "";
            String item_code = request.getParameter("item_code");
            String item_desc = request.getParameter("item_desc");
            String long_text = request.getParameter("item_detail");
            String uom = request.getParameter("uom");
            String qty = request.getParameter("qty");
            String hsno_no = request.getParameter("hsn_no");
            String gst = request.getParameter("gst");
            String remark = request.getParameter("item_detail");
            int i = 0;

            List PrItemMaster1 = prItemMasterService.readByRefNo(ref_no, 1);

            String s_no = "";
            for (Object o : PrItemMaster1) {
                PRItemMaster tim = (PRItemMaster) o;
                s_no = tim.getSrNo();
            }

            if (s_no.equals("")) {
                srNo = "1";
            } else {
                srNo = (Integer.parseInt(s_no) + 1) + "";
            }

            //insert data
            PRItemMaster prItemMaster = new PRItemMaster();
            prItemMaster.setPrNo(ref_no);
            prItemMaster.setItemCode(item_code);
            prItemMaster.setItemDescription(item_desc);
            prItemMaster.setRemark(remark);
            prItemMaster.setUom(uom);
            prItemMaster.setQty(qty);
            prItemMaster.setDeliveryScheduleDate(long_text);
            prItemMaster.setDeliveryScheduleQty(long_text);
            prItemMaster.setLocation("");
            prItemMaster.setPurNo("");
            prItemMaster.setItemNo("");
            prItemMaster.setSrNo(srNo);
            prItemMaster.setItemType(1);
            prItemMasterService.create(prItemMaster);

            System.out.println("");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // insert into file details
        request.setAttribute("successMessage",
                " File Upload successfully");

        //    mv.getModelMap().put("fileDetail", fileDetail);
        List materialGroupMaster = materialGroupMasterService.read();
        List materialTypeMaster = materialTypeMasterService.read();
        mv.getModelMap().put("materialGroupMaster", materialGroupMaster);
        mv.getModelMap().put("materialTypeMaster", materialTypeMaster);

        List tenderItemMaster = prItemMasterService.readByRefNo(ref_no, 1);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("ref_no", ref_no);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AjaxAddServicePRDocument1");
        return mv;
    }

    public ModelAndView pendingPRList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String pr_no = request.getParameter("pr_no");
        String item_code = request.getParameter("item_code");
        String release_date = request.getParameter("release_date");

        List prMaster = prMasterService.pendingPRList();

        mv.getModelMap().put("prMaster", prMaster);

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

        mv.setViewName("PR/PendingPRList");
        return mv;
    }

    public ModelAndView pendingPRList1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String pr_no = request.getParameter("pr_no");
        String item_code = request.getParameter("item_code");
        String release_date = request.getParameter("release_date");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List prMaster = prMasterService.pendingPRList1(username);

        mv.getModelMap().put("prMaster", prMaster);
        mv.setViewName("PR/PendingPRList1");
        return mv;
    }

    public ModelAndView editPR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNumber = prMaster.getPrNo();
        String prNumber1 = prMaster.getPrNo();

        List multipleAddress = multipleAddressService.readByPrNumber(prNumber);

        mv.getModelMap().put("list6", multipleAddress);

        List prNumberList = prPriceApprovalUserService.readByPRNumber(prNumber1);
        mv.getModelMap().put("prNumberList", prNumberList);
        String prUser = "";
        for (Object o : prNumberList) {

            PRPriceApprovalUser ppa = (PRPriceApprovalUser) o;
            prUser = ppa.getUserId();

        }
        mv.getModelMap().put("prUser", prUser);
        List prPricecommentList = prPriceApprovalService.readByprNo(prNumber);
        mv.getModelMap().put("prPricecommentList", prPricecommentList);
        String prNumbercomment = "";
        for (Object o : prPricecommentList) {

            PRPriceApproval ppa = (PRPriceApproval) o;
            prNumbercomment = ppa.getApprovalRemark();

        }

        mv.getModelMap().put("approvalComment", prNumbercomment);
        List employeeMaster1 = employeeMasterService.readByDrow();

        mv.getModelMap().put("employeeMaster1", employeeMaster1);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String employee_name = employeeMaster.getName();
        String ph_no = employeeMaster.getPhNo();

        List committee_approval = committeeApprovalSettingService.read();
        mv.getModelMap().put("committee_approval", committee_approval);

        List billing_location = companyLocationService.read();

        mv.getModelMap().put("billing_location", billing_location);
        mv.getModelMap().put("ph_no", ph_no);
        mv.getModelMap().put("employee_name", employee_name);
        mv.getModelMap().put("formattedDate", formattedDate);

        String prNo = prMaster.getPrNo();
        String prType = prMaster.getType();
        mv.getModelMap().put("prType", prType);

        int omsPrFlag = 1;
        OmsMaster omsMaster = omsMasterService.readByPrNo(prNo, omsPrFlag);
        if (omsMaster != null) {
            mv.getModelMap().put("omsMaster", omsMaster);
        }

        List tenderPriceApproval = prPriceApprovalService.readByIds(id);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);

        List pr_group_classification = prClassificationService.read();
        mv.getModelMap().put("pr_group_classification", pr_group_classification);

        List pr_business_type = prBusinessTypeService.read();
        mv.getModelMap().put("pr_business_type", pr_business_type);

        List pr_project_type = prProjectTypeService.read();
        mv.getModelMap().put("pr_project_type", pr_project_type);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List list11 = plantMastersService.read();
        mv.getModelMap().put("list11", list11);

        List list12 = locationMastersService.read();
        mv.getModelMap().put("list12", list12);

        List multiple = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("multiple", multiple);

        mv.getModelMap().put("ref_no", prNo);
        mv.getModelMap().put("id", id);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);
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
        mv.setViewName("PR/EditPR");
        return mv;
    }

    public ModelAndView editPR1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNumber = prMaster.getPrNo();
        String prNumber1 = prMaster.getPrNo();

        List multipleAddress = multipleAddressService.readByPrNumber(prNumber);

        mv.getModelMap().put("list6", multipleAddress);

        List prNumberList = prPriceApprovalUserService.readByPRNumber(prNumber1);
        mv.getModelMap().put("prNumberList", prNumberList);
        String prUser = "";
        for (Object o : prNumberList) {

            PRPriceApprovalUser ppa = (PRPriceApprovalUser) o;
            prUser = ppa.getUserId();

        }
        mv.getModelMap().put("prUser", prUser);
        List prPricecommentList = prPriceApprovalService.readByprNo(prNumber);
        mv.getModelMap().put("prPricecommentList", prPricecommentList);
        String prNumbercomment = "";
        for (Object o : prPricecommentList) {

            PRPriceApproval ppa = (PRPriceApproval) o;
            prNumbercomment = ppa.getApprovalRemark();

        }

        mv.getModelMap().put("approvalComment", prNumbercomment);
        List employeeMaster1 = employeeMasterService.readByDrow();

        mv.getModelMap().put("employeeMaster1", employeeMaster1);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String employee_name = employeeMaster.getName();
        String ph_no = employeeMaster.getPhNo();

        List committee_approval = committeeApprovalSettingService.read();
        mv.getModelMap().put("committee_approval", committee_approval);

        List billing_location = companyLocationService.read();

        mv.getModelMap().put("billing_location", billing_location);
        mv.getModelMap().put("ph_no", ph_no);
        mv.getModelMap().put("employee_name", employee_name);
        mv.getModelMap().put("formattedDate", formattedDate);

        String prNo = prMaster.getPrNo();

        List tenderPriceApproval = prPriceApprovalService.readByIds(id);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);

        List pr_group_classification = prClassificationService.read();
        mv.getModelMap().put("pr_group_classification", pr_group_classification);

        List pr_business_type = prBusinessTypeService.read();
        mv.getModelMap().put("pr_business_type", pr_business_type);

        List pr_project_type = prProjectTypeService.read();
        mv.getModelMap().put("pr_project_type", pr_project_type);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List list11 = plantMastersService.read();
        mv.getModelMap().put("list11", list11);

        List list12 = locationMastersService.read();
        mv.getModelMap().put("list12", list12);

        mv.getModelMap().put("ref_no", prNo);
        mv.getModelMap().put("id", id);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);
        mv.setViewName("PR/EditPR");
        return mv;
    }

    public ModelAndView multipleAddressDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String deleteId = request.getParameter("deleteId");
        String id = request.getParameter("id");

        if (deleteId != null && !deleteId.isEmpty()) {
            multipleAddressService.delete(Integer.parseInt(deleteId));
            session.setAttribute("successMessage", " Address details deleted successfully");
        }

        mv.setViewName("redirect:prMaster.htm?act=editPR&id=" + id);
        return mv;
    }

    public ModelAndView updatePRMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRPriceApproval prPriceApproval = new PRPriceApproval();
        PRPriceApprovalUser prPriceApprovalUser = new PRPriceApprovalUser();
        PRPriceApprovalComment prPriceApprovalComment = new PRPriceApprovalComment();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        OmsMaster omsMaster = null;
        String omsMasterId = request.getParameter("omsMasterId");
        if (omsMasterId != null && !omsMasterId.trim().isEmpty()) {
            omsMaster = omsMasterService.readById(Integer.parseInt(omsMasterId));
        }

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String department = employeeMaster.getDepartment();

        String refNo = request.getParameter("pr_no");
        String refNo1 = refNo;

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        String title = request.getParameter("title");
        String projectId = request.getParameter("projectId");

        String value = request.getParameter("value");
        if (value == null) {
            value = "";
        }
        String categoryId = request.getParameter("categoryId");
        String deliveryLocation = request.getParameter("deliveryLocation");
        String announceDate = formattedDate;
        String workDesc = request.getParameter("workDesc");
        String type = request.getParameter("type");
        String contactPerson = request.getParameter("contactPerson");
        String contactPersonNumber = request.getParameter("contactPersonNumber");
        String prRemark = request.getParameter("prRemark");
        String billing_location = request.getParameter("billingLocation");
        String technical_contact_name = request.getParameter("technicalContactName");
        String technical_contact_no = request.getParameter("technicalContactNo");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String pincode = request.getParameter("pincode");
        String plantcode = request.getParameter("plantcode");
        String gst = request.getParameter("gst");
        String purchasing = request.getParameter("purchasing");
        String address = request.getParameter("address");
        String locationcode = request.getParameter("locationcode");
        String locationaddress = request.getParameter("locationaddress");
        String quotes = request.getParameter("quotes");
        String business_type = request.getParameter("businessType");
        String project_type = request.getParameter("projectType");
        String delivery_period = request.getParameter("delivery_period");
        String technicalCommittee = request.getParameter("technicalCommittee");
        String remarkss = request.getParameter("remarkss");

        String costCurrency = request.getParameter("costCurrency");
        costCurrency = costCurrency != null ? costCurrency.trim() : "";

        String singleQuoteCheckbox = request.getParameter("singleQuoteCheckbox");
        int singleQuoteCheckbox1;
        if ("1".equals(singleQuoteCheckbox)) {
            singleQuoteCheckbox1 = 1;
        } else {
            singleQuoteCheckbox1 = 0;
        }

        String technicalfile1 = request.getParameter("singleQuoteAttachment");
        String technicalfile = request.getParameter("singleQuoteAttachment1");

        PRMaster prMaster = prMasterService.readByPrNo(refNo);
        if (technicalfile1 == null) {

            technicalfile1 = prMaster.getSingleQuoteAttachment();
        }

        if (locationcode == null) {
            locationcode = prMaster.getLocationName();
        }
        if (prRemark == null) {
            prRemark = "";
        }
        if (remarkss == null) {
            remarkss = "";
        }
        String nameofLocationPartner = request.getParameter("nameofLocationPartner");
        String mobileNoLocationPartner = request.getParameter("mobileNoLocationPartner");

        if (singleQuoteCheckbox1 == 1) {
            String RefNo = refNo.replace("/", "");
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "PR"
                    + File.separator + RefNo;
            File f1 = new File(path);
            boolean bool = f1.mkdirs();

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("singleQuoteAttachment");
            try {
                if (multipartFile != null && multipartFile.getSize() > 0) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "PR"
                            + File.separator + RefNo + File.separator;
                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    technicalfile1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                } else {
                    technicalfile1 = technicalfile;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        prMaster.setPrNo(refNo);
        prMaster.setTitle(title);
        prMaster.setprojectId(projectId);
        prMaster.setAnnounceDate(announceDate);
        prMaster.setCategoryId(categoryId);
        prMaster.setContactPerson(contactPerson);
        prMaster.setLocation(deliveryLocation);
        if (!value.equals("")) {
            prMaster.setValue(value);
        }
        prMaster.setWorkDesc(workDesc);
        prMaster.setType(type);
        prMaster.setPrAdminContactNumber(contactPersonNumber);
        prMaster.setPrRemark(prRemark);
        prMaster.setPrAdmin(username);
        prMaster.setAuthorizeFlag(0);
        prMaster.setDepartment(department);
        prMaster.setAuthorizeDate(announceDate);
        prMaster.setBillingLocation(billing_location);
        prMaster.setTechnicalContactName(technical_contact_name);
        prMaster.setTechnicalContactNo(technical_contact_no);
        prMaster.setAddress1(address1);
        prMaster.setAddress2(address2);
        prMaster.setState(state);
        prMaster.setCity(city);
        prMaster.setPincode(pincode);
        prMaster.setQuotes(quotes);
        prMaster.setBusinessType(business_type);
        prMaster.setProjectType(project_type);
        prMaster.setDeliveryPeriod(delivery_period);
        prMaster.setTechnicalCommittee(technicalCommittee);
        prMaster.setPlant(plantcode);
        prMaster.setGst(gst);
        prMaster.setPurchaseOrganization(purchasing);
        prMaster.setAddress(address);
        prMaster.setLocationName(locationcode);
        prMaster.setLocationAddress(locationaddress);
        prMaster.setRemarks(remarkss);
        prMaster.setSingleQuoteFlag(singleQuoteCheckbox1);
        prMaster.setSingleQuoteAttachment(technicalfile1);
        prMaster.setNameofLocationPartner(nameofLocationPartner);
        prMaster.setMobileNoLocationPartner(mobileNoLocationPartner);
        prMaster.setCurrency(costCurrency);

        prMasterService.update(prMaster);
        mv.getModelMap().put("prMaster", prMaster);

        if (omsMaster != null) {
            String token = "";
            try {

                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }
                    }
                };

                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                URL url = new URL("https://oms-stage.chargecloud.net/api/v1/int/integrations/oms-token/generate");
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                String apiKey = "oms_4hN8sP2qW6vX1mJ9kL5tR3cF7yG0bD8";
                JSONObject json = new JSONObject();
                json.put("apiKey", apiKey);

                OutputStream os = conn.getOutputStream();
                os.write(json.toString().getBytes());
                os.flush();
                os.close();

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder response0 = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    response0.append(line);
                }

                br.close();

                JSONObject responseJson = new JSONObject(response0.toString());
                token = responseJson.getJSONObject("data").getString("token");

                conn.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            }
            omsMaster.setPrNumber(refNo);
            omsMaster.setPrFlag(2);
            omsMasterService.update(omsMaster);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            try {
                JSONObject json = new JSONObject();
                json.put("ticketID", omsMaster.getTicketId());
                json.put("omsPrId", omsMaster.getOmsPrId());
                json.put("prId", refNo);
                json.put("status", "PR CREATED");
                json.put("createdAt", formattedDateTime);
                json.put("createdBy", username);

                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }
                    }
                };

                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier((hostname, session1) -> true);

                URL url = new URL("https://oms.chargecloud.net/api/v1/int/integrations/e-produce/callback");
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

                con.setRequestMethod("POST");

                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Authorization", "Bearer " + token);

                con.setDoOutput(true);

                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = json.toString().getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int responseCode = con.getResponseCode();
                System.out.println("Response Code: " + responseCode);

                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {

                    StringBuilder response1 = new StringBuilder();
                    String responseLine;

                    while ((responseLine = br.readLine()) != null) {
                        response1.append(responseLine.trim());
                    }

                    System.out.println("Response: " + response1);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        prItemMasterService.updatePRNo(refNo1, refNo);
        prVendorService.updatePRNo(refNo1, refNo);

        prPriceApprovalService.deletePr(refNo);
        prPriceApprovalUserService.deletePr(refNo);

        int policyCount = Integer.parseInt(request.getParameter("policyCount"));
        String comment = request.getParameter("comment");
        if (comment == null) {
            comment = "";
        }

        prPriceApproval.setPrNo(refNo);
        prPriceApproval.setCurrentApproval(1);
        prPriceApproval.setApprovalStatus(0);
        prPriceApproval.setTotalApproval(policyCount);

        prPriceApproval.setDateTime(formattedDate);

        String approvalRemark = request.getParameter("approvalRemark");
        if (approvalRemark == null) {
            approvalRemark = "";
        }
        prPriceApproval.setApprovalRemark(comment);

        List employeeMaster1 = employeeMasterService.readByDrow();

        UserRights userRights = userRightsService.readByUser(username);

        String employeeCode = employeeMaster.getEmployeeCode();
        prPriceApproval.setUserId(employeeCode);
        prPriceApproval.setApprovalRemark(comment);
        prPriceApprovalService.create(prPriceApproval);

        int approveId = prPriceApproval.getId();

        for (int i = 1; i <= policyCount; i++) {

            String userLists = request.getParameter("userList" + i);

            prPriceApprovalUser.setUserId(userLists);
            prPriceApprovalUser.setPrNo(refNo);

            prPriceApprovalUser.setPrApprovalId(approveId);
            prPriceApprovalUser.setLevel(i);
            prPriceApprovalUser.setApprovalStatus(0);

            prPriceApprovalComment.setApprovalStatus(0);
            prPriceApprovalComment.setDateTime(formattedDate);
            prPriceApprovalComment.setPrApprovalId(approveId);
            prPriceApprovalComment.setUserId(userLists);
            prPriceApprovalComment.setApprovalComment(comment);

            prPriceApprovalUserService.create(prPriceApprovalUser);
            prPriceApprovalCommentService.create(prPriceApprovalComment);
        }

        String Address1[] = request.getParameterValues("Address1");
        String[] Address2 = request.getParameterValues("Address2");
        String[] cityes = request.getParameterValues("cityes");
        String[] remarks = request.getParameterValues("remarkes");
        String[] states = request.getParameterValues("states");
        String[] pincodes = request.getParameterValues("pincodes");

        try {

            for (int i = 0; i < Address1.length; i++) {

                MultipleAddress multipleAddress = new MultipleAddress();

                if (Address1[i] == null || Address1[i].trim().isEmpty()) {
                    break;
                } else {

                    multipleAddress.setAddress1(Address1[i]);
                    multipleAddress.setAddress2(Address2[i]);
                    multipleAddress.setCity(cityes[i]);
                    multipleAddress.setPincode(pincodes[i]);
                    multipleAddress.setState(states[i]);
                    multipleAddress.setPrNumber(refNo);
                    multipleAddress.setRemark(remarks[i]);
                    multipleAddressService.create(multipleAddress);
                }
            }

        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        //------for Log entry---------
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("PR No: " + refNo + " submitted successfully").setDrow("Y");
        logService.create(lm);

        session.setAttribute("successMessage",
                " PR No: " + refNo + " submitted successfully");

        mv.getModelMap().put("employeeMaster1", employeeMaster1);
        mv.getModelMap().put("prPriceApproval", prPriceApproval);
        mv.getModelMap().put("prPriceApproval", prPriceApproval);
        mv.getModelMap().put("prPriceApprovalUser", prPriceApprovalUser);
        mv.getModelMap().put("refNo", refNo);

        mv.setViewName("redirect:prMaster.htm?act=listPRList");

        return mv;
    }

    public ModelAndView assignTenderFromPR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String department = employeeMaster.getDepartment();

        String refNo = request.getParameter("prNo");
        String employee_code = request.getParameter("employee_code");

        String refNo1 = refNo;

        String title = request.getParameter("title");
        String value = request.getParameter("value");
        String categoryId = request.getParameter("categoryId");

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        PRMaster prMaster = prMasterService.readByPrNo(refNo);

        prMaster.setPrNo(refNo);
        prMaster.setTenderCreaterId(employee_code);
        prMaster.setTenderFlag(1);
        prMaster.setTenderAssignUser(username);
        prMaster.setTenderAssignDate(formattedDate);
        //    prMaster.setValue(value);

        prMasterService.update(prMaster);

        request.setAttribute("successMessage",
                " Assign Tender To Employee successfully");

        mv.getModelMap().put("prMaster", prMaster);

        mv.setViewName("forward:prMaster.htm?act=pendingPRList");

        return mv;
    }

    public ModelAndView reworkTenderToPR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String department = employeeMaster.getDepartment();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        String refNo = request.getParameter("prNo");
        PRMaster prMaster = prMasterService.readByPrNo(refNo);

        int authorized_flag = prMaster.getAuthorizeFlag();

        if (authorized_flag == 151) {
            session.setAttribute("failureMessage",
                    " PR No: " + refNo + " is already closed.");

            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");
            return mv;
        } else if (authorized_flag == 10) {

            session.setAttribute("failureMessage",
                    " PR No: " + refNo + " is already in recycle process.");

            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");
            return mv;

        } else if (authorized_flag == 6) {

            session.setAttribute("failureMessage",
                    " Tender has already been created for PR No: " + refNo + ".");

            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");
            return mv;

        } else if (authorized_flag == 1) {

            String employee_code = request.getParameter("employee_code");
            String refNo1 = refNo;
            String title = request.getParameter("title");
            String value = request.getParameter("value");
            String remark = request.getParameter("remark");

            prMaster.setPrNo(refNo);
            prMaster.setAuthorizeFlag(10);
            prMaster.setPrReworkBy(username);
            prMaster.setPrReworkDate(formattedDate);
            prMaster.setPrComment(remark);
            prMasterService.update(prMaster);

            PRApprovalComment prApprovalComment = new PRApprovalComment();
            prApprovalComment.setPrNo(refNo);
            prApprovalComment.setUserId(username);
            prApprovalComment.setComment(remark);
            prApprovalComment.setDateTime(formattedDate);
            prApprovalComment.setApprovalStatus("Rework by Tender Admin");
            prApprovalCommentService.create(prApprovalComment);

            //------for Log entry---------
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("PR no. " + refNo + " rework completed and forwarded to the approval user successfully.").setDrow("Y");
            logService.create(lm);

            session.setAttribute("successMessage",
                    " PR rework completed and forwarded to the approval user successfully.");

            mv.getModelMap().put("prMaster", prMaster);

            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");

            return mv;
        } else {
            session.setAttribute("failureMessage",
                    " Invalid PR status. Action cannot be performed.");
            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");
            return mv;
        }
    }

    public ModelAndView agaxTechnicalFileDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("q");
        String ref_no = request.getParameter("q");
        String service = request.getParameter("service");

        List technicalDocument = prDocService.readByRefNo(ref_no);

        mv.getModelMap().put("technicalDocument", technicalDocument);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AgaxTechnicalFileDetails");
        return mv;
    }

    public void downloadPrFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");
        String RefNo = request.getParameter("RefNo");
        String RefNo1 = RefNo.replace("/", "");
        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "PR"
                + File.separator + RefNo1 + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView addTechnicalFileDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();

        List technicalDocument = prDocService.readByRefNo(ref_no);

        mv.getModelMap().put("technicalDocument", technicalDocument);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AjaxAddTechnicalFileDetails");
        return mv;
    }

    public ModelAndView addTechnicalFileDetailsSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no1");
        String attachment_required = request.getParameter("attachment_required");
        if (attachment_required == null) {
            attachment_required = "0";
        }

        String RefNo = ref_no.replace("/", "");

        String doc_title = request.getParameter("doc_title");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "PR"
                + File.separator + RefNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        String generalfile = request.getParameter("generalfile");
        if (generalfile == null) {
            generalfile = "";
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        List<MultipartFile> files = multipartRequest.getFiles("generalfile");
        for (MultipartFile multipartFile : files) {
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "PR"
                            + File.separator + RefNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "").replaceAll("&", "").replaceAll("\\'", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "").replaceAll("&", "").replaceAll("\\'", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (generalfile.equals("")) {
            } else {
                PRDoc prDoc = new PRDoc();
                prDoc.setPrNo(ref_no);
                prDoc.setDocName(generalfile);
                prDoc.setRefNo(ref_no);
                prDoc.setDocTitle(generalfile);
                prDoc.setAttachmentRequired(Integer.parseInt(attachment_required));
                prDocService.create(prDoc);
            }

        }

        List technicalDocument = prDocService.readByRefNo(ref_no);

        mv.getModelMap().put("technicalDocument", technicalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AjaxAddTechnicalFileDetails");
        return mv;
    }

    public ModelAndView technicalFileDetailsDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        try {
            prDocService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        List technicalDocument = prDocService.readByRefNo(ref_no);

        mv.getModelMap().put("technicalDocument", technicalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);

        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("PR/AjaxAddTechnicalFileDetails");
        return mv;
    }

    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List tenderPriceApproval = prPriceApprovalService.approvaList(username);
        int tenderPriceApprovalSize = tenderPriceApproval.size();

        List prMaster = prMasterService.pendingPRList();

        List prMasterDashboard = prMasterService.pendingPRListDashboard();
        int prMasterSize = prMasterDashboard.size();

        List tenderPriceApprovalUser = prPriceApprovalUserService.read();
        List tenderPriceApproval1 = prPriceApprovalService.read();

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list3", tenderPriceApproval1);
        mv.getModelMap().put("list2", tenderPriceApprovalUser);
        mv.getModelMap().put("tenderPriceApprovalSize", tenderPriceApprovalSize);
        mv.getModelMap().put("prMasterSize", prMasterSize);

        mv.setViewName("PR/Dashboard");

        return mv;

    }

    public ModelAndView tenderDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String pr_no = request.getParameter("pr_no");
        String item_code = request.getParameter("item_code");
        String release_date = request.getParameter("release_date");

        List prMaster = prMasterService.pendingPRList();
        List prMasterDashboard = prMasterService.pendingPRListDashboard();
        int prMasterSize = prMasterDashboard.size();

        List tenderPriceApproval = prPriceApprovalService.approvaList(username);
        int tenderPriceApprovalSize = tenderPriceApproval.size();

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("prMasterSize", prMasterSize);
        mv.getModelMap().put("tenderPriceApprovalSize", tenderPriceApprovalSize);

        mv.setViewName("PR/TenderDashboard");

        return mv;

    }

    public ModelAndView bidDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("PR/BidDashboard");

        return mv;

    }

    public ModelAndView assignDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List tenderPriceApproval = prPriceApprovalService.approvaList(username);
        int tenderPriceApprovalSize = tenderPriceApproval.size();

        List prMaster = prMasterService.pendingPRList1(username);
        int prMasterSize = prMaster.size();

        List tenderPriceApprovalUser = prPriceApprovalUserService.read();
        List tenderPriceApproval1 = prPriceApprovalService.read();

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list3", tenderPriceApproval1);
        mv.getModelMap().put("list2", tenderPriceApprovalUser);
        mv.getModelMap().put("tenderPriceApprovalSize", tenderPriceApprovalSize);
        mv.getModelMap().put("prMasterSize", prMasterSize);

        mv.setViewName("PR/AssignDashboard");

        return mv;

    }

    public ModelAndView assignTenderDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String pr_no = request.getParameter("pr_no");
        String item_code = request.getParameter("item_code");
        String release_date = request.getParameter("release_date");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List tenderPriceApproval = prPriceApprovalService.approvaList(username);
        int tenderPriceApprovalSize = tenderPriceApproval.size();

        List prMaster = prMasterService.pendingPRList1(username);
        int prMasterSize = prMaster.size();
        mv.getModelMap().put("prMasterSize", prMasterSize);
        mv.getModelMap().put("tenderPriceApprovalSize", tenderPriceApprovalSize);

        mv.getModelMap().put("prMaster", prMaster);
        mv.setViewName("PR/PendingPRList1");

        mv.setViewName("PR/AssignTenderDashboard");

        return mv;

    }

    public ModelAndView assignBidDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("PR/AssignBidDashboard");

        return mv;

    }

    public ModelAndView ExportToExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNo = prMaster.getPrNo();

        String plant1 = prMaster.getPlant();

        String location = prMaster.getLocationName();

        List list = prItemMasterService.readByRefNo(prNo, 0);

        int rownum = 0;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("FIRST SHEET");

        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true); // Set bold font
        XSSFCellStyle styleBold = workbook.createCellStyle();
        styleBold.setFont(boldFont);
        styleBold.setFillForegroundColor(IndexedColors.YELLOW.getIndex()); // Light blue background
        styleBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleBold.setBorderTop(BorderStyle.THIN);
        styleBold.setBorderBottom(BorderStyle.THIN);
        styleBold.setBorderLeft(BorderStyle.THIN);
        styleBold.setBorderRight(BorderStyle.THIN);
        styleBold.setAlignment(HorizontalAlignment.CENTER); // Center-align the text
        styleBold.setVerticalAlignment(VerticalAlignment.CENTER); // Vertically align the text

        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);

        // main heasding
        CellStyle styleBold1 = workbook.createCellStyle();

        Font boldFont1 = workbook.createFont();
        boldFont.setBold(true); // Set the font to bold
        styleBold1.setFont(boldFont1); // Apply the bold font to the style
        styleBold1.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex()); // Light blue background
        styleBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row mainHeadingRow = sheet.createRow(rownum++);
        mainHeadingRow.setHeightInPoints(50);

        Cell mainHeadingCell1 = mainHeadingRow.createCell(4); // Cell 5
        Cell mainHeadingCell2 = mainHeadingRow.createCell(5); // Cell 6
        Cell mainHeadingCell3 = mainHeadingRow.createCell(6); // Cell 7
        Cell mainHeadingCell16 = mainHeadingRow.createCell(16); // Cell 17
        Cell mainHeadingCell17 = mainHeadingRow.createCell(17); // Cell 18
        Cell mainHeadingCell18 = mainHeadingRow.createCell(18); // Cell 19

        mainHeadingCell1.setCellValue("MAIN LINE ITEM DATA"); // Empty value
        mainHeadingCell2.setCellValue("MAIN LINE ITEM DATA"); // Heading
        mainHeadingCell3.setCellValue("MAIN LINE ITEM DATA"); // Empty value
        mainHeadingCell16.setCellValue("LINE ITEM SUB DATA"); // Empty value
        mainHeadingCell17.setCellValue("LINE ITEM SUB DATA"); // Heading
        mainHeadingCell18.setCellValue("LINE ITEM SUB DATA"); // Empty value

// Merge cells 5, 6, and 7
        sheet.addMergedRegion(new CellRangeAddress(rownum - 1, rownum - 1, 4, 6)); // Merge cells 5-7
        sheet.addMergedRegion(new CellRangeAddress(rownum - 1, rownum - 1, 16, 18)); // Merge cells 17-19

// Apply the bold style to cell 6
        mainHeadingCell2.setCellStyle(styleBold1);
        mainHeadingCell17.setCellStyle(styleBold1); // Apply bold style to cell 18 heading

        // First Table Header Row
        Row itemHeaderRow = sheet.createRow(rownum++);
        itemHeaderRow.setHeightInPoints(40);
        String[] itemHeaders = {
            "Sr No", "A", "I", "Material Code", "Item Description", "Quantity", "Unit", "empty",
            "Delivery Date", "Material Group", "Plant", "Stor. Location", "PGr", "",
            "WBS ", "VALUATION PRICE", "TAX CODE", "COST CENTER", "G/L",
            "Product Type Group", "Start date", "End date"
        };

        for (int i = 0; i < itemHeaders.length; i++) {
            // Skip creating cells for empty headers
            if (!itemHeaders[i].isEmpty()) {
                Cell cell = itemHeaderRow.createCell(i);
                cell.setCellValue(itemHeaders[i]);
                cell.setCellStyle(styleBold);
            }
        }

// Populate First Table (Data Rows)
        for (Object o1 : list) {
            PRItemMaster pRItemMaster = (PRItemMaster) o1;

            String Item = pRItemMaster.getSrNo();
            String a = pRItemMaster.getAccountAssigmentCategory();
            String I = "";
            String Material = pRItemMaster.getItemCode();
            String Short = pRItemMaster.getItemDescription();
            String qty = pRItemMaster.getQty();
            String unit = "";
            String emptySpace = "";
            String date = pRItemMaster.getDeliveryDate();
            String Materialgroup = pRItemMaster.getProductType();
            String plant = "";
            String Stor = "";
            String pgr = "";
            String emptySpace1 = "";
            String WBSELEMENT = "";
            String VALUATIONPRICE = pRItemMaster.getValuationPrice();
            String TAXCODE = pRItemMaster.getTaxCode();
            String COSTCENTER = "";
            String GL = "";
            String ProductTypeGroup = pRItemMaster.getProductGroup();
            String Startdate = pRItemMaster.getStartDate();
            String Enddate = pRItemMaster.getEndDate();

            Row itemRow = sheet.createRow(rownum++);
            itemRow.createCell(0).setCellValue(Item);
            itemRow.getCell(0).setCellStyle(cellStyle);
            itemRow.createCell(1).setCellValue(a);
            itemRow.getCell(1).setCellStyle(cellStyle);
            itemRow.createCell(2).setCellValue(I);
            itemRow.getCell(2).setCellStyle(cellStyle);
            itemRow.createCell(3).setCellValue(Material);
            itemRow.getCell(3).setCellStyle(cellStyle);
            itemRow.createCell(4).setCellValue(Short);
            itemRow.getCell(4).setCellStyle(cellStyle);
            itemRow.createCell(5).setCellValue(qty);
            itemRow.getCell(5).setCellStyle(cellStyle);
            itemRow.createCell(6).setCellValue(unit);
            itemRow.getCell(6).setCellStyle(cellStyle);
            itemRow.createCell(7).setCellValue(emptySpace);
            itemRow.getCell(7).setCellStyle(cellStyle);
            itemRow.createCell(8).setCellValue(date);
            itemRow.getCell(8).setCellStyle(cellStyle);
            itemRow.createCell(9).setCellValue(Materialgroup);
            itemRow.getCell(9).setCellStyle(cellStyle);
            itemRow.createCell(10).setCellValue(plant1);
            itemRow.getCell(10).setCellStyle(cellStyle);
            itemRow.createCell(11).setCellValue(location);
            itemRow.getCell(11).setCellStyle(cellStyle);
            itemRow.createCell(12).setCellValue(pgr);
            itemRow.getCell(12).setCellStyle(cellStyle);

            itemRow.createCell(13).setCellValue(emptySpace1);
            itemRow.getCell(13).setCellValue(emptySpace1);

            itemRow.createCell(14).setCellValue(WBSELEMENT);
            itemRow.getCell(14).setCellStyle(cellStyle);

            itemRow.createCell(15).setCellValue(VALUATIONPRICE);
            itemRow.getCell(15).setCellStyle(cellStyle);

            itemRow.createCell(16).setCellValue(TAXCODE);
            itemRow.getCell(16).setCellStyle(cellStyle);

            itemRow.createCell(17).setCellValue(COSTCENTER);
            itemRow.getCell(17).setCellStyle(cellStyle);

            itemRow.createCell(18).setCellValue(GL);
            itemRow.getCell(18).setCellStyle(cellStyle);

            itemRow.createCell(19).setCellValue(ProductTypeGroup);
            itemRow.getCell(19).setCellStyle(cellStyle);

            itemRow.createCell(20).setCellValue(Startdate);
            itemRow.getCell(20).setCellStyle(cellStyle);

            itemRow.createCell(21).setCellValue(Enddate);
            itemRow.getCell(21).setCellStyle(cellStyle);

        }

//	// Add a gap (empty rows) between the two tables
//	rownum += 3; // You can adjust this number to control the gap (currently 3 empty rows)
//	CellStyle styleBold2 = workbook.createCellStyle();
//
//	Font boldFont2 = workbook.createFont();
//	boldFont.setBold(true); // Set the font to bold
//	styleBold2.setFont(boldFont2); // Apply the bold font to the style
//	styleBold2.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex()); // Light blue background
//	styleBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//
//	Row mainHeadingRow1 = sheet.createRow(rownum++);
//	mainHeadingRow1.setHeightInPoints(50);
//
//	Cell mainHeadingCells3 = mainHeadingRow1.createCell(3); // Cell 5
//	Cell mainHeadingCells4 = mainHeadingRow1.createCell(4); // Cell 6
//	Cell mainHeadingCells5 = mainHeadingRow1.createCell(5); // Cell 7
//
//	mainHeadingCells3.setCellValue("LINE ITEM SUB DATA"); // Empty value
//	mainHeadingCells4.setCellValue("LINE ITEM SUB DATA"); // Heading
//	mainHeadingCells5.setCellValue("LINE ITEM SUB DATA"); // Empty value
//
//// Merge cells 5, 6, and 7
//	sheet.addMergedRegion(new CellRangeAddress(rownum - 1, rownum - 1, 3, 5));
//
//// Apply the bold style to cell 6
//	mainHeadingCell2.setCellStyle(styleBold1);
//
//// Second Table Header Row (optional, if it is different from the first table)
//	Row secondTableHeaderRow = sheet.createRow(rownum++);
//	secondTableHeaderRow.setHeightInPoints(40);
//	String[] secondTableHeaders = {"WBS ELEMENT", "VALUATION PRICE", "TAX CODE", "COST CENTER", "G/L", "Product Type Group", "Start date", "End date"};
//
//	for (int i = 0; i < secondTableHeaders.length; i++) {
//	    Cell cell = secondTableHeaderRow.createCell(i);
//	    cell.setCellValue(secondTableHeaders[i]);
//	    cell.setCellStyle(styleBold);
//	}
//
//	for (Object o2 : list) {
//	    PRItemMaster pRItemMaster = (PRItemMaster) o2;
//
//	    String WBSELEMENT = "";
//	    String VALUATIONPRICE = pRItemMaster.getValuationPrice();
//	    String TAXCODE = pRItemMaster.getTaxCode();
//	    String COSTCENTER = "";
//	    String GL = "";
//	    String ProductTypeGroup = pRItemMaster.getProductGroup();
//	    String Startdate = pRItemMaster.getStartDate();
//	    String Enddate = pRItemMaster.getEndDate();
//
//	    Row secondTableRow = sheet.createRow(rownum++);
//
//	    secondTableRow.createCell(0).setCellValue(WBSELEMENT);
//	    secondTableRow.getCell(0).setCellStyle(cellStyle);
//	    secondTableRow.createCell(1).setCellValue(VALUATIONPRICE);
//	    secondTableRow.getCell(1).setCellStyle(cellStyle);
//	    secondTableRow.createCell(2).setCellValue(TAXCODE);
//	    secondTableRow.getCell(2).setCellStyle(cellStyle);
//	    secondTableRow.createCell(3).setCellValue(COSTCENTER);
//	    secondTableRow.getCell(3).setCellStyle(cellStyle);
//	    secondTableRow.createCell(4).setCellValue(GL);
//	    secondTableRow.getCell(4).setCellStyle(cellStyle);
//	    secondTableRow.createCell(5).setCellValue(ProductTypeGroup);
//	    secondTableRow.getCell(5).setCellStyle(cellStyle);
//	    secondTableRow.createCell(6).setCellValue(Startdate);
//	    secondTableRow.getCell(6).setCellStyle(cellStyle);
//	    secondTableRow.createCell(7).setCellValue(Enddate);
//	    secondTableRow.getCell(7).setCellStyle(cellStyle);
//	}
        String appPath = request.getServletContext().getRealPath("");
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "excel" + File.separator + "prexcel.xlsx";

        File file = new File(filePath);
        file.getParentFile().mkdirs();

        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("filePath", filePath);
        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        mv.setViewName("PR/SearchView");

        return mv;

    }

    public void locationOnBasePlantCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String plantCode = request.getParameter("plantCode");

        JSONObject jsonobj = new JSONObject();
        JSONArray array = new JSONArray();

        List list = locationMastersService.readByPlantCode(plantCode);

        for (Object o : list) {
            LocationMasters locationMasters = (LocationMasters) o;

            Map<String, String> map = new HashMap<>();
            map.put("locationCode", "" + locationMasters.getLoactionCode());
            map.put("locationName", "" + locationMasters.getLoactionName());

            array.put(map);
        }

        jsonobj.put("locationMasters", array);

        response.setContentType("application/json");
        response.getWriter().println(jsonobj.toString());
    }

    public ModelAndView sendToJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        // Validate ID parameter
        if (id == null || id.isEmpty()) {
            mv.addObject("error", "ID parameter is missing.");
            mv.setViewName("PR/AssignBidDashboard");
            return mv;
        }

        // Fetch PRMaster details
        PRMaster pRMaster = prMasterService.readById(Integer.parseInt(id));
        if (pRMaster == null) {
            mv.addObject("error", "No PRMaster found for ID: " + id);
            mv.setViewName("PR/AssignBidDashboard");
            return mv;
        }

        String prNo = pRMaster.getPrNo();
        List<?> pRItemMasterList = prItemMasterService.readByRefNo(prNo, 0);

        // Validate PRItemMaster list
        if (pRItemMasterList == null || pRItemMasterList.isEmpty()) {
            mv.addObject("error", "No items found for Purchase Requisition: " + prNo);
            mv.setViewName("PR/AssignBidDashboard");
            return mv;
        }

        String plant_code = pRMaster.getPlant();

        // CompanyCode - based on plant or location master
        // StorageLocation - based on Location Master
        String create_date = pRMaster.getAnnounceDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

        Date d1 = sdf.parse(create_date);

        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        String todayAsString = df.format(d1);

        // Define API credentials and URLs
        String username = "INTEGRATION_001";
        String password = "Integration@1234567890!";
        String prUrl = "https://my413184-api.s4hana.cloud.sap/sap/opu/odata4/sap/api_purchaserequisition_2/srvd_a2x/sap/purchaserequisition/0001/PurchaseReqn";
        HttpURLConnection postConnection = null;
        String csrfToken = null;
        String cookies = null;

        try {
            // Step 1: Fetch CSRF Token
            URL csrfUrl = new URL(prUrl);
            HttpURLConnection csrfConnection = (HttpURLConnection) csrfUrl.openConnection();
            csrfConnection.setRequestMethod("GET");
            csrfConnection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));
            csrfConnection.setRequestProperty("x-csrf-token", "Fetch");

            int csrfStatusCode = csrfConnection.getResponseCode();
            if (csrfStatusCode == HttpURLConnection.HTTP_OK || csrfStatusCode == HttpURLConnection.HTTP_NO_CONTENT) {
                csrfToken = csrfConnection.getHeaderField("x-csrf-token");
                cookies = csrfConnection.getHeaderField("Set-Cookie");
            } else {
                mv.addObject("error", "Failed to fetch CSRF token. HTTP Status: " + csrfStatusCode);
                mv.setViewName("PR/AssignBidDashboard");
                return mv;
            }
            csrfConnection.disconnect();

            String plan_code = pRMaster.getPlant();
            PlantMasters plantMasters = plantMastersService.readByPlant(plan_code);
            String company_code = plantMasters.getCompanyCode();

            List locationMasters = locationMastersService.readByPlantCode(plan_code);
            String location_code = "";
            for (Object o : locationMasters) {
                LocationMasters lm = (LocationMasters) o;
                location_code = lm.getLoactionCode();
            }

            String p1 = prNo.substring(0, 4);
            String p2 = prNo.substring(6);
            String p3 = p1 + "" + p2;

            // Step 2: Create JSON Payload for Purchase Requisition
            String prJsonPayload = "{\n"
                    + "   \"PurchaseRequisition\": \"" + prNo.replaceAll("PR", "PR") + "\",\n"
                    + "   \"PurchaseRequisitionType\": \"ZCON\",\n"
                    + "   \"PurReqnDescription\": \"\",\n"
                    + "   \"PurReqnHeaderNote\": \"" + pRMaster.getTitle() + "\",\n"
                    + "   \"SourceDetermination\": false,\n"
                    + "   \"PurReqnDoOnlyValidation\": false,\n"
                    + "   \"_PurchaseRequisitionItem\": [\n";

            int j1 = 0;
            for (Object o : pRItemMasterList) {
                j1++;
                PRItemMaster prim = (PRItemMaster) o;

                //MaterialGroup - PR item Master - product group
                String material_group = prim.getProductGroup();
                String DeliveryDate = prim.getDeliveryDate();

                d1 = sdf1.parse(DeliveryDate);
                df = new SimpleDateFormat(pattern);
                DeliveryDate = df.format(d1);

                String PerformancePeriodStartDate = prim.getStartDate();
                d1 = sdf1.parse(PerformancePeriodStartDate);
                df = new SimpleDateFormat(pattern);
                PerformancePeriodStartDate = df.format(d1);

                String PerformancePeriodEndDate = prim.getEndDate();
                d1 = sdf1.parse(PerformancePeriodEndDate);
                df = new SimpleDateFormat(pattern);
                PerformancePeriodEndDate = df.format(d1);

                String TaxCode = prim.getTaxCode();
                String PurchaseRequisitionPrice = prim.getValuationPrice();
                String StorageLocation = pRMaster.getLocationName();

                //PurchasingGroup
                prJsonPayload = prJsonPayload + "      {\n"
                        + "         \"PurchaseRequisition\": \"" + prNo.replaceAll("PR", "PR") + "\",\n"
                        + "         \"PurchaseRequisitionItem\": \"\",\n"
                        + "         \"PurchasingDocument\": \"ZCON\",\n"
                        + "         \"PurchaseRequisitionItemText\": \"" + prim.getItemDescription() + "\",\n"
                        + "         \"AccountAssignmentCategory\": \"A\",\n"
                        + "         \"Material\": \"\",\n"
                        + "         \"MaterialGroup\": \"CAP003\",\n"
                        + "         \"RequestedQuantity\": " + prim.getQty() + ",\n"
                        + "         \"BaseUnit\": \"" + prim.getUom() + "\",\n"
                        + "         \"BaseUnitISOCode\": \"" + prim.getUom() + "\",\n"
                        + "         \"PurchaseRequisitionPrice\": " + PurchaseRequisitionPrice + ",\n"
                        + "         \"PurchasingOrganization\": \"" + pRMaster.getPurchaseOrganization() + "\",\n"
                        + "         \"PurchasingGroup\": \"BCC\",\n"
                        + "         \"Plant\": \"" + pRMaster.getPlant() + "\",\n"
                        + "         \"CompanyCode\": \"" + company_code + "\",\n"
                        + "         \"DeliveryDate\": \"" + DeliveryDate + "\",\n"
                        + "         \"RequisitionerName\": \"" + pRMaster.getContactPerson() + "\",\n"
                        + "         \"PurReqCreationDate\": \"" + todayAsString + "\",\n"
                        + "         \"PurReqnItemCurrency\": \"INR\",\n"
                        + "         \"StorageLocation\": \"" + location_code + "\",\n"
                        + "         \"ProductTypeCode\": \"1\",\n"
                        + "         \"PerformancePeriodStartDate\": \"" + PerformancePeriodStartDate + "\",\n"
                        + "         \"PerformancePeriodEndDate\": \"" + PerformancePeriodEndDate + "\",\n"
                        + "         \"TaxCode\": \"" + TaxCode + "\",\n"
                        + "         \"GoodsReceiptIsExpected\": true,\n"
                        + "         \"InvoiceIsExpected\": true,\n"
                        + "         \"_PurchaseReqnAcctAssgmt\": [\n"
                        + "            {\n"
                        + "               \"PurchaseRequisition\": \"" + prNo.replaceAll("PR", "PR") + "\",\n"
                        + "               \"PurchaseRequisitionItem\": \"" + j1 + "\",\n"
                        + "               \"CostCenter\": \"\",\n"
                        + "               \"MasterFixedAsset\": \"10000009\",\n"
                        + "               \"GLAccount\": \"100999\",\n"
                        + "               \"CreationDate\": \"" + todayAsString + "\",\n"
                        + "               \"WBSElementExternalID\": \"\"\n"
                        + "            }\n"
                        + "         ]\n";

                if (j1 == pRItemMasterList.size()) {
                    prJsonPayload = prJsonPayload + "      }\n";
                } else {
                    prJsonPayload = prJsonPayload + "      },\n";
                }

            }
            prJsonPayload = prJsonPayload + "   ]\n"
                    + "}";

            // Step 3: Send POST Request for Purchase Requisition
            postConnection = (HttpURLConnection) new URL(prUrl).openConnection();
            postConnection.setRequestMethod("POST");
            postConnection.setDoOutput(true);
            postConnection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));
            postConnection.setRequestProperty("x-csrf-token", csrfToken);
            postConnection.setRequestProperty("Content-Type", "application/json");

            if (cookies != null) {
                postConnection.setRequestProperty("Cookie", cookies);
            }

            try (OutputStream os = postConnection.getOutputStream()) {
                byte[] input = prJsonPayload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get the response
            int postStatusCode = postConnection.getResponseCode();
            InputStream responseStream = (postStatusCode >= 200 && postStatusCode < 300)
                    ? postConnection.getInputStream()
                    : postConnection.getErrorStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            StringBuilder responseContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            System.out.println(postStatusCode + " " + responseContent);
            reader.close();

            if (postStatusCode >= 200 && postStatusCode < 300) {
                mv.addObject("success", "Purchase Requisition and Items successfully posted.");
            } else {
                mv.addObject("error", "Failed to send Purchase Requisition data. HTTP Error Code: " + postStatusCode + ". Response: " + responseContent.toString());
            }

        } catch (Exception e) {
            mv.addObject("error", "API request failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (postConnection != null) {
                postConnection.disconnect();
            }
        }

        mv.setViewName("PR/AssignBidDashboard");
        return mv;
    }

    public ModelAndView createPR1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();

        String ref_no = request.getParameter("ref_no");
        String itemId = request.getParameter("itemId");
        String prType = request.getParameter("prType");
        String OapId = request.getParameter("OapId");
        String aocId = request.getParameter("aocId");

        SiteSurvey siteSurvey = null;

        if (aocId == null || aocId.isEmpty()) {
            OapSurveyAttachment oapSurveyAttachment = oapSurveyAttachmentService.readByoapFormId(OapId);
            String surveyDocumentyNo = oapSurveyAttachment.getSurveyNo();
            siteSurvey = siteSurveyService.readBySurveyNo(surveyDocumentyNo);

        } else if (OapId == null || OapId.isEmpty()) {
            AocSurveyAttachment aocSurveyAttachment = aocSurveyAttachmentService.readByaocFormId(aocId);
            String surveyDocumentyNo = aocSurveyAttachment.getSurveyNo();
            siteSurvey = siteSurveyService.readBySurveyNo(surveyDocumentyNo);
        }

        String itemType = "";
        if (prType.equals("Goods")) {
            prType = "0";
        }
        if (prType.equals("Contract")) {
            prType = "4";
        }
        if (prType.equals("Service")) {
            prType = "3";
        }
        List prList = prItemMasterService.readByRefNo(ref_no, 0);

        List itemList = iteamDetailsAttachmentsService.readBystatus(prType, itemId);
        for (Object o : itemList) {
            IteamDetailsAttachments it = (IteamDetailsAttachments) o;
            PRItemMaster prItemMaster = new PRItemMaster();
            prItemMaster.setPrNo(ref_no);
            prItemMaster.setSrNo(it.getSno().replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
            prItemMaster.setItemCode(it.getIteamCode().replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
            prItemMaster.setItemDescription(it.getIteamDescription());
            prItemMaster.setDeliveryScheduleDate(it.getMake());
            prItemMaster.setDeliveryScheduleQty(it.getPurpose());
            prItemMaster.setUom(it.getUom().replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
            prItemMaster.setQty(it.getQty().replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
            prItemMaster.setItemType(0);
            prItemMaster.setAccountAssigmentCategory(it.getAccountCategory());
            prItemMaster.setAccountAssigmentValue(it.getAccountValue());
            prItemMaster.setProductType(it.getProductType());
            prItemMaster.setProductGroup(it.getProductType());
            prItemMaster.setTaxCode(it.getIteamCode());
            prItemMaster.setValuationPrice(it.getPrice());
            prItemMaster.setDeliveryDate(it.getDeliveryDate());
            prItemMaster.setStartDate(it.getStartDate());
            prItemMaster.setEndDate(it.getEndDate());
            prItemMasterService.create(prItemMaster);
        }
        if (prType.equals("Contract")) {
            prType = "4";
            List itemList1 = iteamDetailsAttachmentsService.readBystatus(prType, itemId);
            for (Object o : itemList1) {
                IteamDetailsAttachments it = (IteamDetailsAttachments) o;
                PRItemMaster prItemMaster = new PRItemMaster();
                prItemMaster.setPrNo(ref_no);
                prItemMaster.setSrNo(it.getSno().replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                prItemMaster.setItemCode(it.getIteamCode().replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                prItemMaster.setItemDescription(it.getIteamDescription());
                prItemMaster.setDeliveryScheduleDate(it.getMake());
                prItemMaster.setDeliveryScheduleQty(it.getPurpose());
                prItemMaster.setUom(it.getUom().replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                prItemMaster.setQty(it.getQty().replaceAll("^[\\r\\n]+|[\\r\\n]+$", ""));
                prItemMaster.setItemType(1);
                prItemMaster.setAccountAssigmentCategory(it.getAccountCategory());
                prItemMaster.setAccountAssigmentValue(it.getAccountValue());
                prItemMaster.setProductType(it.getProductType());
                prItemMaster.setProductGroup(it.getProductType());
                prItemMaster.setTaxCode(it.getIteamCode());
                prItemMaster.setValuationPrice(it.getPrice());
                prItemMaster.setDeliveryDate(it.getDeliveryDate());
                prItemMaster.setStartDate(it.getStartDate());
                prItemMaster.setEndDate(it.getEndDate());
                prItemMasterService.create(prItemMaster);
            }
        }

        List employeeMaster1 = employeeMasterService.readByDrow();

        mv.getModelMap().put("employeeMaster1", employeeMaster1);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String employee_name = employeeMaster.getName();
        String ph_no = employeeMaster.getPhNo();

        List committee_approval = committeeApprovalSettingService.read();
        mv.getModelMap().put("committee_approval", committee_approval);

        List pr_business_type = prBusinessTypeService.read();
        mv.getModelMap().put("pr_business_type", pr_business_type);

        List pr_project_type = prProjectTypeService.read();
        mv.getModelMap().put("pr_project_type", pr_project_type);

        List pr_classification = prClassificationService.read();
        mv.getModelMap().put("pr_classification", pr_classification);

        List pr_group_classification = prClassificationService.readByGroup();
        mv.getModelMap().put("pr_group_classification", pr_group_classification);

        List billing_location = companyLocationService.read();

        List list11 = plantMastersService.read();
        mv.getModelMap().put("list11", list11);

        List list12 = locationMastersService.read();
        mv.getModelMap().put("list12", list12);

        mv.getModelMap().put("billing_location", billing_location);
        mv.getModelMap().put("ph_no", ph_no);
        mv.getModelMap().put("employee_name", employee_name);
        mv.getModelMap().put("formattedDate", formattedDate);
        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("prType", prType);
        mv.getModelMap().put("siteSurvey", siteSurvey);
        mv.setViewName("PR/CreatePR");
        return mv;
    }

    public ModelAndView searchView4(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        List vendorInformation1 = vendorInformationService.readActiveVendor();
        mv.getModelMap().put("vendorInformation1", vendorInformation1);

        try {
            ClosePr closePr = closePrService.readByPrID(Integer.parseInt(id));
            mv.getModelMap().put("closePr", closePr);

        } catch (Exception e) {
        }

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("prMaster", prMaster);

        mv.setViewName("PR/ClosePR");
        return mv;
    }

    public ModelAndView closePRList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRMaster prMaster = new PRMaster();
        String prNumber = request.getParameter("prNumber");
        String open_from_date = request.getParameter("open_from_date");
        String open_to_date = request.getParameter("open_to_date");
        String department = request.getParameter("department");

        //    List list1 = prPriceApprovalService.readLog(prNumber, open_from_date, open_to_date);
        List list = prMasterService.readByClosePr(prNumber, open_from_date, open_to_date, department);

        List DepartmentList = departmentMasterService.read();

        mv.getModelMap().put("DepartmentList", DepartmentList);

        mv.getModelMap().put("prNumber", prNumber);
        mv.getModelMap().put("open_from_date", open_from_date);
        mv.getModelMap().put("open_to_date", open_to_date);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("list", list);

        mv.setViewName("PR/ClosePrNavbar");

        return mv;

    }

    public ModelAndView closePRListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String prNumber = request.getParameter("prNumber");
        String department = request.getParameter("department");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.equals("")) {

            orderDir = "desc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {

            orderColumnIndex = "0";
        }

        String orderByField = "a.id";

        switch (orderColumnIndex) {

            case "0":
                orderByField = "a.id";
                break;

            case "1":
                orderByField = "a.prNo";
                break;

            case "2":
                orderByField = "b.closedBy";
                break;

            case "3":
                orderByField = "b.dateTime";
                break;
        }

        List list = prMasterService.getClosePrListPagination(start, length, searchValue, prNumber, fromDate, toDate, department, orderByField, orderDir);

        int totalRecords = prMasterService.getTotalClosePRCount();

        int filteredRecords = prMasterService.getFilteredClosePRCount(searchValue, prNumber, fromDate, toDate, department);

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

            if (isDesc) {

                json.put("srNo", srNo--);

            } else {

                json.put("srNo", srNo++);
            }

            json.put(
                    "prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no="
                    + (row[1] != null ? row[1] : "")
                    + "' class='fw-600 text-break gradient-text'>"
                    + (row[1] != null ? row[1] : "")
                    + "</a>"
            );

            json.put("closedBy", row[3] != null ? row[3].toString() : "");

            json.put("dateTime", row[4] != null ? row[4].toString() : "");

            json.put(
                    "view",
                    "<a href='prMaster.htm?act=closeprview&id="
                    + row[0]
                    + "' class='btn btn-sm theme-btn light-btn'>View</a>"
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

    public void closePRReportExportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String searchValue = request.getParameter("searchValue");

        String prNumber = request.getParameter("prNumber");
        String department = request.getParameter("department");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumn = "a.id";
        String orderDir = "asc";

        int start = 0;
        int filteredRecords = prMasterService.getFilteredClosePRCount(searchValue, prNumber, fromDate, toDate, department);

        List closePRReportList = prMasterService.getClosePrListPagination(start, filteredRecords, searchValue, prNumber, fromDate, toDate, department, orderColumn, orderDir);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Close PR Report");

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        XSSFColor headerColor = new XSSFColor(new java.awt.Color(31, 78, 120));
        ((XSSFCellStyle) headerStyle).setFillForegroundColor(headerColor);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        CellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        wrapStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);

        String[] headers = {
            "Sr.No.", "PR Number", "Closed By", "Date Time"
        };

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        sheet.createFreezePane(0, 1);

        int rowNum = 1;
        int srNo = 1;

        for (Iterator it = closePRReportList.iterator(); it.hasNext();) {
            Object[] row = (Object[]) it.next();
            Row excelRow = sheet.createRow(rowNum++);

            excelRow.createCell(0).setCellValue(srNo++);
            excelRow.createCell(1).setCellValue(row[1] != null ? row[1].toString() : "");
            excelRow.createCell(2).setCellValue(row[3] != null ? row[3].toString() : "");
            excelRow.createCell(3).setCellValue(row[4] != null ? row[4].toString() : "");
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String currentDate = sdf.format(new Date());
        String fileName = "Close_PR_Report_" + currentDate + ".xlsx";

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream outputStream = response.getOutputStream();
        try {
            workbook.write(outputStream);
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    public ModelAndView agaxTenderVendorDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String prNo = request.getParameter("q");
        List tenderVendor1 = prVendorService.readByRfqNo(prNo);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        int vendorcount = tenderVendor1.size();
        mv.getModelMap().put("vendorcount", vendorcount);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.setViewName("PR/AgaxTenderVendorDetails");
        return mv;
    }

    public ModelAndView searchVendorToAddInPr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String ref_no = request.getParameter("ref_no");
        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/AjaxSearchVendorToAddInPr");
        return mv;
    }

    public ModelAndView addVendorForPr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String pr_no = request.getParameter("pr_no");
        String vendor_code = "";
        String vendor_name = "";
        String email_id = "";
        String cc = "";
        String mobile_no = "";
        String address = "";
        //checkedId
        try {
            String[] checkId = request.getParameterValues("checkedId");
            for (String checkedValues : checkId) {

                VendorMaster vendorMaster = vendorMasterService.read(checkedValues);
                vendor_code = vendorMaster.getVendorRegNo();
                vendor_name = vendorMaster.getVendorName();

                email_id = vendorMaster.getVendorEmailID();
                cc = vendorMaster.getVendorcc();
//            if (cc == null) {
//                cc = "";
//            }
//            if (!cc.equals("")) {
//                email_id = email_id + ", " + cc;
//            }
                mobile_no = vendorMaster.getVendorMobNo();
                address = vendorMaster.getVendorAddressLine1();

                List prVendor1 = prVendorService.readByRfqVendor(ref_no, vendor_code);

                if (prVendor1.isEmpty()) {
                    PRVendor prVendor = new PRVendor();
                    prVendor.setPrNo(ref_no);
                    prVendor.setVendorCode(vendor_code);
                    prVendor.setVendorName(vendor_name);
                    prVendor.setAddress(address);
                    prVendor.setEmailId(email_id);
                    prVendor.setMobileNo(mobile_no);
                    prVendor.setChecked(1);
                    prVendorService.create(prVendor);
                } else {
                    request.setAttribute("failureMessage", " Vendor already added");
                }

            }
        } catch (Exception e11) {
        }
        List prVendor1 = prVendorService.readByRfqNo(ref_no);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("tenderVendor1", prVendor1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/AjaxSearchVendorToAddInPr1");
        return mv;
    }

    public ModelAndView searchVendorForPrSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String vendor_code = request.getParameter("vendor_code");
        String vendor_name = request.getParameter("vendor_name");
        String ref_no = request.getParameter("ref_no");

        String vendor_remark = request.getParameter("vendor_remark");

        List vendorMaster = vendorMasterService.SearchByCode(vendor_code, vendor_name, vendor_remark);

        //    List vendorMaster = vendorMasterService.readByCodeName(vendor_code, vendor_name);
        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("vendorMaster", vendorMaster);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/AjaxSearchVendorToAddInPr");
        return mv;
    }

    public ModelAndView deleteVendorForPr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        //checkedId
        try {
            String ids = request.getParameter("Ids");
            String[] checkId = ids.split(",");
//            String[] checkId = request.getParameterValues("checkedIdd");
            for (String checkedValues : checkId) {
                prVendorService.delete(Integer.parseInt(checkedValues));
                request.setAttribute("successMessage", "Info : Vendor Remove Successfully.");
            }
        } catch (Exception e11) {
        }

        List tenderVendor1 = prVendorService.readByRfqNo(ref_no);

        //    List list = employeeMasterService.readByDrow();
        //    request.setAttribute("list", list);
        mv.getModelMap().put("tenderVendor1", tenderVendor1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("PR/AjaxSearchVendorToAddInPr");
        return mv;
    }

    public ModelAndView prSaveAsDraft(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNumber = prMaster.getPrNo();
        String prNumber1 = prMaster.getPrNo();

        List multipleAddress = multipleAddressService.readByPrNumber(prNumber);

        mv.getModelMap().put("list6", multipleAddress);

        List prNumberList = prPriceApprovalUserService.readByPRNumber(prNumber1);
        mv.getModelMap().put("prNumberList", prNumberList);
        String prUser = "";
        for (Object o : prNumberList) {

            PRPriceApprovalUser ppa = (PRPriceApprovalUser) o;
            prUser = ppa.getUserId();

        }
        mv.getModelMap().put("prUser", prUser);
        List prPricecommentList = prPriceApprovalService.readByprNo(prNumber);
        mv.getModelMap().put("prPricecommentList", prPricecommentList);
        String prNumbercomment = "";
        for (Object o : prPricecommentList) {

            PRPriceApproval ppa = (PRPriceApproval) o;
            prNumbercomment = ppa.getApprovalRemark();

        }

        mv.getModelMap().put("approvalComment", prNumbercomment);
        List employeeMaster1 = employeeMasterService.readByDrow();

        mv.getModelMap().put("employeeMaster1", employeeMaster1);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String employee_name = employeeMaster.getName();
        String ph_no = employeeMaster.getPhNo();

        List committee_approval = committeeApprovalSettingService.read();
        mv.getModelMap().put("committee_approval", committee_approval);

        List billing_location = companyLocationService.read();

        mv.getModelMap().put("billing_location", billing_location);
        mv.getModelMap().put("ph_no", ph_no);
        mv.getModelMap().put("employee_name", employee_name);
        mv.getModelMap().put("formattedDate", formattedDate);

        String prNo = prMaster.getPrNo();

        List tenderPriceApproval = prPriceApprovalService.readByIds(id);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);

        List pr_group_classification = prClassificationService.readByGroup();
        mv.getModelMap().put("pr_group_classification", pr_group_classification);

        List pr_business_type = prBusinessTypeService.read();
        mv.getModelMap().put("pr_business_type", pr_business_type);

        List pr_project_type = prProjectTypeService.read();
        mv.getModelMap().put("pr_project_type", pr_project_type);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List list11 = plantMastersService.read();
        mv.getModelMap().put("list11", list11);

        List list12 = locationMastersService.read();
        mv.getModelMap().put("list12", list12);

        mv.getModelMap().put("ref_no", prNo);
        mv.getModelMap().put("id", id);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);
        mv.setViewName("PR/prSaveAsDraft");
        return mv;
    }

    public ModelAndView prSaveAsDraftSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        PRPriceApproval prPriceApproval = new PRPriceApproval();
        PRPriceApprovalUser prPriceApprovalUser = new PRPriceApprovalUser();
        PRPriceApprovalComment prPriceApprovalComment = new PRPriceApprovalComment();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String department = employeeMaster.getDepartment();

        String refNo = request.getParameter("pr_no");
        String refNo1 = refNo;

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        String title = request.getParameter("title");
        String projectId = request.getParameter("projectId");

        String value = request.getParameter("value");
        if (value == null) {
            value = "";
        }
        String categoryId = request.getParameter("categoryId");
        String deliveryLocation = request.getParameter("deliveryLocation");
        String announceDate = formattedDate;
        String workDesc = request.getParameter("workDesc");
        String type = request.getParameter("type");
        String contactPerson = request.getParameter("contactPerson");
        String contactPersonNumber = request.getParameter("contactPersonNumber");
        String prRemark = request.getParameter("prRemark");
        String billing_location = request.getParameter("billingLocation");
        String technical_contact_name = request.getParameter("technicalContactName");
        String technical_contact_no = request.getParameter("technicalContactNo");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String pincode = request.getParameter("pincode");
        String plantcode = request.getParameter("plantcode");
        String gst = request.getParameter("gst");
        String purchasing = request.getParameter("purchasing");
        String address = request.getParameter("address");
        String locationcode = request.getParameter("locationcode");
        String locationaddress = request.getParameter("locationaddress");
        String quotes = request.getParameter("quotes");
        String business_type = request.getParameter("businessType");
        String project_type = request.getParameter("projectType");
        String delivery_period = request.getParameter("delivery_period");
        String technicalCommittee = request.getParameter("technicalCommittee");
        String remarkss = request.getParameter("remarkss");

        String costCurrency = request.getParameter("costCurrency");
        costCurrency = costCurrency != null ? costCurrency.trim() : "";

        String singleQuoteCheckbox = request.getParameter("singleQuoteCheckbox");
        int singleQuoteCheckbox1;
        if ("1".equals(singleQuoteCheckbox)) {
            singleQuoteCheckbox1 = 1;
        } else {
            singleQuoteCheckbox1 = 0;

        }

        String technicalfile1 = request.getParameter("singleQuoteAttachment");
        String technicalfile = request.getParameter("singleQuoteAttachment1");
        if (technicalfile1 == null) {
            technicalfile1 = "";
        }

        PRMaster prMaster = prMasterService.readByPrNo(refNo);
        if (technicalfile1 == null) {

            technicalfile1 = prMaster.getSingleQuoteAttachment();
        }

        if (locationcode == null) {
            locationcode = prMaster.getLocationName();
        }
        if (prRemark == null) {
            prRemark = "";
        }
        if (remarkss == null) {
            remarkss = "";
        }
        String nameofLocationPartner = request.getParameter("nameofLocationPartner");
        String mobileNoLocationPartner = request.getParameter("mobileNoLocationPartner");

        if (singleQuoteCheckbox1 == 1) {
            String RefNo = refNo.replace("/", "");
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "PR"
                    + File.separator + RefNo;
            File f1 = new File(path);
            boolean bool = f1.mkdirs();

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("singleQuoteAttachment");
            try {
                if (multipartFile != null && multipartFile.getSize() > 0) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "PR"
                            + File.separator + RefNo + File.separator;
                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    technicalfile1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                } else {
                    technicalfile1 = technicalfile;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        prMaster.setPrNo(refNo);
        prMaster.setTitle(title);
        prMaster.setprojectId(projectId);
        prMaster.setAnnounceDate(announceDate);
        prMaster.setCategoryId(categoryId);
        prMaster.setContactPerson(contactPerson);
        prMaster.setLocation(deliveryLocation);
        prMaster.setValue(value);
        prMaster.setWorkDesc(workDesc);
        prMaster.setType(type);
        prMaster.setPrAdminContactNumber(contactPersonNumber);
        prMaster.setPrRemark(prRemark);
        prMaster.setPrAdmin(username);
        prMaster.setAuthorizeFlag(7);
        prMaster.setDepartment(department);
        prMaster.setAuthorizeDate(announceDate);
        prMaster.setBillingLocation(billing_location);
        prMaster.setTechnicalContactName(technical_contact_name);
        prMaster.setTechnicalContactNo(technical_contact_no);
        prMaster.setAddress1(address1);
        prMaster.setAddress2(address2);
        prMaster.setState(state);
        prMaster.setCity(city);
        prMaster.setPincode(pincode);

        prMaster.setQuotes(quotes);
        prMaster.setBusinessType(business_type);
        prMaster.setProjectType(project_type);
        prMaster.setDeliveryPeriod(delivery_period);
        prMaster.setTechnicalCommittee(technicalCommittee);
        prMaster.setPlant(plantcode);
        prMaster.setGst(gst);
        prMaster.setPurchaseOrganization(purchasing);
        prMaster.setAddress(address);
        prMaster.setLocationName(locationcode);
        prMaster.setLocationAddress(locationaddress);
        prMaster.setRemarks(remarkss);
        prMaster.setSingleQuoteFlag(singleQuoteCheckbox1);
        prMaster.setSingleQuoteAttachment(technicalfile1);
        prMaster.setNameofLocationPartner(nameofLocationPartner);
        prMaster.setMobileNoLocationPartner(mobileNoLocationPartner);
        prMaster.setCurrency(costCurrency);

        if (prMaster.getprojectId() != projectId) {
            prMaster.setProjectIdUpdateDate(formattedDate);
        }

        if (prMaster.getValue() != value) {
            prMaster.setBudgetAmountUpdateDate(formattedDate);
        }

        prMasterService.update(prMaster);
        mv.getModelMap().put("prMaster", prMaster);

        prItemMasterService.updatePRNo(refNo1, refNo);
        prVendorService.updatePRNo(refNo1, refNo);

        prPriceApprovalService.deletePr(refNo);
        prPriceApprovalUserService.deletePr(refNo);

        int policyCount = Integer.parseInt(request.getParameter("policyCount"));
        String comment = request.getParameter("comment");
        if (comment == null) {
            comment = "";
        }

        prPriceApproval.setPrNo(refNo);
        prPriceApproval.setCurrentApproval(1);
        prPriceApproval.setApprovalStatus(0);
        prPriceApproval.setTotalApproval(policyCount);

        prPriceApproval.setDateTime(formattedDate);

        String approvalRemark = request.getParameter("approvalRemark");
        if (approvalRemark == null) {
            approvalRemark = "";
        }
        prPriceApproval.setApprovalRemark(comment);

        List employeeMaster1 = employeeMasterService.readByDrow();

        UserRights userRights = userRightsService.readByUser(username);

        String employeeCode = employeeMaster.getEmployeeCode();
        prPriceApproval.setUserId(employeeCode);
        prPriceApproval.setApprovalRemark(comment);
        prPriceApprovalService.create(prPriceApproval);

        int approveId = prPriceApproval.getId();

        for (int i = 1; i <= policyCount; i++) {

            String userLists = request.getParameter("userList" + i);

            prPriceApprovalUser.setUserId(userLists);
            prPriceApprovalUser.setPrNo(refNo);

            prPriceApprovalUser.setPrApprovalId(approveId);
            prPriceApprovalUser.setLevel(i);
            prPriceApprovalUser.setApprovalStatus(0);

            prPriceApprovalComment.setApprovalStatus(0);
            prPriceApprovalComment.setDateTime(formattedDate);
            prPriceApprovalComment.setPrApprovalId(approveId);
            prPriceApprovalComment.setUserId(userLists);
            prPriceApprovalComment.setApprovalComment(comment);

            prPriceApprovalUserService.create(prPriceApprovalUser);
            prPriceApprovalCommentService.create(prPriceApprovalComment);
        }

        String Address1[] = request.getParameterValues("Address1");
        String[] Address2 = request.getParameterValues("Address2");
        String[] cityes = request.getParameterValues("cityes");
        String[] remarks = request.getParameterValues("remarkes");
        String[] states = request.getParameterValues("states");
        String[] pincodes = request.getParameterValues("pincodes");

        try {

            for (int i = 0; i < Address1.length; i++) {

                MultipleAddress multipleAddress = new MultipleAddress();

                if (Address1[i] == null || Address1[i].trim().isEmpty()) {
                    break;
                } else {

                    multipleAddress.setAddress1(Address1[i]);
                    multipleAddress.setAddress2(Address2[i]);
                    multipleAddress.setCity(cityes[i]);
                    multipleAddress.setPincode(pincodes[i]);
                    multipleAddress.setState(states[i]);
                    multipleAddress.setPrNumber(refNo);
                    multipleAddress.setRemark(remarks[i]);
                    multipleAddressService.create(multipleAddress);
                }
            }

        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        session.setAttribute("successMessage",
                " PR No: " + refNo + " Updated Successfully");

        mv.getModelMap().put("employeeMaster1", employeeMaster1);
        mv.getModelMap().put("prPriceApproval", prPriceApproval);
        mv.getModelMap().put("prPriceApproval", prPriceApproval);
        mv.getModelMap().put("prPriceApprovalUser", prPriceApprovalUser);
        mv.getModelMap().put("refNo", refNo);

        mv.setViewName("redirect:prMaster.htm?act=editPR&id=" + prMaster.getId());
        return mv;
    }

    public ModelAndView closePrSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster pRMaster = prMasterService.readById(Integer.parseInt(id));
        String refNo = pRMaster.getPrNo();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        int authorized_flag = pRMaster.getAuthorizeFlag();

        if (authorized_flag == 151) {
            session1.setAttribute("failureMessage",
                    " PR No: " + refNo + " is already closed.");

            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");
            return mv;
        } else if (authorized_flag == 10) {

            session1.setAttribute("failureMessage",
                    " PR No: " + refNo + " is already in recycle process.");

            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");
            return mv;

        } else if (authorized_flag == 6) {

            session1.setAttribute("failureMessage",
                    " Tender has already been created for PR No: " + refNo + ".");

            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");
            return mv;

        } else if (authorized_flag == 1) {
            String tender_no = request.getParameter("tender_no");
            String vendor_details = request.getParameter("vendor_details");

            String RefNo1 = refNo.replace("/", "");

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "PR"
                    + File.separator + RefNo1;

            File f1 = new File(path);
            boolean bool = f1.mkdirs();

            List<MultipartFile> files1 = multipartRequest.getFiles("attach");
            int a = 0;
            if (files1 != null && !files1.isEmpty()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "PR"
                                + File.separator + RefNo1 + File.separator;

                        File directory = new File(fileLocationURL);
                        if (!directory.exists()) {
                            directory.mkdirs();
                        }

                        File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        try {
                            file1.transferTo(destinationFile1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        ClosePrMultiAttach closePrMultiAttach = new ClosePrMultiAttach();
                        closePrMultiAttach.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        closePrMultiAttach.setPrNo(refNo);
                        closePrMultiAttachService.create(closePrMultiAttach);

                        a++;
                    }
                }

            }

            String remark = request.getParameter("Remark");

            ClosePr closePr = new ClosePr();
            closePr.setTenderNo(tender_no);
            closePr.setVendorDetail(vendor_details);
            closePr.setAttachment("");
            closePr.setPrMasterId(Integer.parseInt(id));
            closePr.setRemark(remark);
            closePr.setDateTime(formattedDateTime);
            closePr.setClosedBy(username1);
            closePrService.create(closePr);

            pRMaster.setAuthorizeFlag(151);
            prMasterService.update(pRMaster);

            String pr_no = pRMaster.getPrNo();

            session1.setAttribute("successMessage",
                    " PR No: " + pr_no + " Closed Successfully");

            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");
            return mv;
        } else {
            session1.setAttribute("failureMessage",
                    " Invalid PR status. Action cannot be performed.");
            mv.setViewName("redirect:prMaster.htm?act=pendingPRList");
            return mv;
        }

    }

    public ModelAndView closeprview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));
        String prno = prMaster.getPrNo();

        try {
            ClosePr closePr = closePrService.readByPrID(Integer.parseInt(id));
            mv.getModelMap().put("closePr", closePr);

        } catch (Exception e) {
        }

        List closeprAttchment = closePrMultiAttachService.readByprNo(prno);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("closeprAttchment", closeprAttchment);

        mv.setViewName("PR/closeprview");

        return mv;
    }

    public ModelAndView prSummaryReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List DepartmentList = departmentMasterService.read();

        mv.getModelMap().put("DepartmentList", DepartmentList);
        mv.setViewName("PR/PRSummaryReport");

        return mv;
    }

    public ModelAndView prSummaryReportList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PRMaster prMaster = new PRMaster();
        String prNumber = request.getParameter("prNumber");
        String open_from_date = request.getParameter("open_from_date");
        String projectName = request.getParameter("projectName");
        String open_to_date = request.getParameter("open_to_date");
        String department = request.getParameter("department");

        List list = prMasterService.readLogOnlyPrMaster(prNumber, open_from_date, open_to_date, department, projectName);

        List DepartmentList = departmentMasterService.read();

        mv.getModelMap().put("DepartmentList", DepartmentList);

        mv.getModelMap().put("prNumber", prNumber);
        mv.getModelMap().put("open_from_date", open_from_date);
        mv.getModelMap().put("open_to_date", open_to_date);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("list", list);
        mv.setViewName("PR/PRSummaryReport");
        return mv;
    }

    public ModelAndView searchPRSummaryReportPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String prNumber = request.getParameter("prNumber");
        String projectName = request.getParameter("projectName");
        String department = request.getParameter("department");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        switch (orderColumnIndex) {

            case "0":
                orderColumn = "id";
                break;

            case "1":
                orderColumn = "prNo";
                break;

            case "2":
                orderColumn = "title";
                break;

            case "3":
                orderColumn = "projectId";
                break;

            case "5":
                orderColumn = "department";
                break;

            case "8":
                orderColumn = "announceDate";
                break;

            default:
                orderColumn = "id";
                break;
        }

        List list = prMasterService.getPRPagination(start, length, searchValue, prNumber, projectName, department, fromDate, toDate, orderColumn, orderDir);

        int totalRecords = prMasterService.getTotalPRCount();

        int filteredRecords = prMasterService.getFilteredPRCount(searchValue, prNumber, projectName, department, fromDate, toDate);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            PRMaster pr = (PRMaster) obj;

            JSONObject json = new JSONObject();

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put(
                    "prNo",
                    "<a href='prMaster.htm?act=prSummaryReportView&id="
                    + pr.getId()
                    + "' class='fw-600 text-break gradient-text'>"
                    + (pr.getPrNo() != null ? pr.getPrNo() : "")
                    + "</a>"
            );

            json.put("title", pr.getTitle() != null ? pr.getTitle() : "");

            json.put("projectId", pr.getprojectId() != null ? pr.getprojectId() : "");

            json.put("workDesc", pr.getWorkDesc() != null ? pr.getWorkDesc() : "");

            json.put("department", pr.getDepartment() != null ? pr.getDepartment() : "");

            json.put("billingLocation", pr.getBillingLocation() != null ? pr.getBillingLocation() : "");

            json.put("contactPerson", pr.getContactPerson() != null ? pr.getContactPerson() : "");

            json.put("announceDate", pr.getAnnounceDate() != null ? pr.getAnnounceDate().toString() : "");

            json.put("prAuthorizeUser", pr.getPrAuthorizeUser() != null ? pr.getPrAuthorizeUser() : "");

            json.put("prAuthorizeDate", pr.getPrAuthorizeDate() != null ? pr.getPrAuthorizeDate().toString() : "");

            String status = "Unknown Status";

            if (pr.getFinalCloseDate() != null) {

                status = "Po Closed";

            } else if (pr.getAuthorizeFlag() == 0) {

                status = "Pending";

            } else if (pr.getAuthorizeFlag() == 1) {

                status = "Approve";

            } else if (pr.getAuthorizeFlag() == 2) {

                status = "Rework";

            } else if (pr.getAuthorizeFlag() == 3) {

                status = "Reject";

            } else if (pr.getAuthorizeFlag() == 6) {

                status = "Tender Created";
            }

            json.put("status", status);

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

    public void prSummaryReportExportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Session expired");
            return;
        }

        String searchValue = request.getParameter("searchValue");

        String prNumber = request.getParameter("prNumber");
        String projectName = request.getParameter("projectName");
        String department = request.getParameter("department");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumn = "id";
        String orderDir = "asc";

        int start = 0;
        int filteredRecords = prMasterService.getFilteredPRCount(searchValue, prNumber, projectName, department, fromDate, toDate);

        List prSummaryReportList = prMasterService.getPRPagination(start, filteredRecords, searchValue, prNumber, projectName, department, fromDate, toDate, orderColumn, orderDir);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PR Summary Report");

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        XSSFColor headerColor = new XSSFColor(new java.awt.Color(31, 78, 120));
        ((XSSFCellStyle) headerStyle).setFillForegroundColor(headerColor);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        CellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        wrapStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);

        String[] headers = {
            "Sr.No.", "PR Number", "Project Name", "Project ID", "PR Subject Description",
            "Department", "Billing Location", "Created By", "PR Date Time",
            "PR Approval User", "PR Approval Date", "Approval Status"
        };

        int rowNum = 0;
        int srNo = 1;

        Row headerRow = sheet.createRow(rowNum++);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        sheet.createFreezePane(0, 1);

        if (prSummaryReportList != null) {

            for (Object obj : prSummaryReportList) {

                PRMaster pr = (PRMaster) obj;

                String status = "Unknown Status";

                if (pr.getFinalCloseDate() != null) {
                    status = "Po Closed";
                } else if (pr.getAuthorizeFlag() == 0) {
                    status = "Pending";
                } else if (pr.getAuthorizeFlag() == 1) {
                    status = "Approve";
                } else if (pr.getAuthorizeFlag() == 2) {
                    status = "Rework";
                } else if (pr.getAuthorizeFlag() == 3) {
                    status = "Reject";
                } else if (pr.getAuthorizeFlag() == 6) {
                    status = "Tender Created";
                }

                Row excelRow = sheet.createRow(rowNum++);
                excelRow.createCell(0).setCellValue(srNo++);
                excelRow.createCell(1).setCellValue(pr.getPrNo() != null ? pr.getPrNo() : "");
                excelRow.createCell(2).setCellValue(pr.getTitle() != null ? pr.getTitle() : "");
                excelRow.createCell(3).setCellValue(pr.getprojectId() != null ? pr.getprojectId() : "");
                excelRow.createCell(4).setCellValue(pr.getWorkDesc() != null ? pr.getWorkDesc() : "");
                excelRow.createCell(5).setCellValue(pr.getDepartment() != null ? pr.getDepartment() : "");
                excelRow.createCell(6).setCellValue(pr.getBillingLocation() != null ? pr.getBillingLocation() : "");
                excelRow.createCell(7).setCellValue(pr.getContactPerson() != null ? pr.getContactPerson() : "");
                excelRow.createCell(8).setCellValue(pr.getAnnounceDate() != null ? pr.getAnnounceDate().toString() : "");
                excelRow.createCell(9).setCellValue(pr.getPrAuthorizeUser() != null ? pr.getPrAuthorizeUser() : "");
                excelRow.createCell(10).setCellValue(pr.getPrAuthorizeDate() != null ? pr.getPrAuthorizeDate().toString() : "");
                excelRow.createCell(11).setCellValue(status);
            }
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        SimpleDateFormat fileDateFormat = new SimpleDateFormat("ddMMyyyy");
        String fileDate = fileDateFormat.format(new Date());
        String fileName = "PR_Summary_Report_" + fileDate + ".xlsx";

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream outputStream = response.getOutputStream();
        try {
            workbook.write(outputStream);
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    public ModelAndView prSummaryReportView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNo = prMaster.getPrNo();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prVendor = prVendorService.readByRfqNo(prNo);
        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("prVendor", prVendor);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("id", id);

        String refNo = "TEN" + prNo.replaceAll("PR", "");

        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);
        String tendrefNo = tenderMaster.getRefNo();
        List tenderVendor = tenderVendorService.readByRefNo(refNo);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tenderVendor", tenderVendor);

//        List techBidOpenList = vendorTechnicalBidService.techBidOpenList(refNo);
        List techBidOpenList = vendorTechnicalBidService.techBidOpenListPrSummary(refNo);
        mv.getModelMap().put("techBidOpenList", techBidOpenList);

//        List priceBidOpenList = vendorTenderBidService.priceBidOpenList(refNo);
        List priceBidOpenList = vendorTenderBidService.priceBidOpenListPrSummary(refNo);
        mv.getModelMap().put("priceBidOpenList", priceBidOpenList);

        List poDetails = poDetailsService.readByRefNo(refNo);
        mv.getModelMap().put("poDetails", poDetails);

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);

        List tenderPriceApprovals = tenderPriceApprovalService.readByTenRefNo(refNo);
        mv.getModelMap().put("list100", tenderPriceApprovals);
        int tender_price_approval_id = 0;
        TenderPriceApproval tenderPriceApproval0 = tenderPriceApprovalService.readByList(tendrefNo);
        tender_price_approval_id = tenderPriceApproval0.getId();
        List list22 = tenderPriceApprovalCommentService.readByRefNo(tender_price_approval_id);
        mv.getModelMap().put("list22", list22);

        //iteam
//        TenderPriceApproval tenderPriceApproval12 = tenderPriceApprovalService.readById(id));
//
//        String tender_no = tenderPriceApproval12.getTenderNo();
        String refNo2 = refNo;
        TenderMaster tenderMaster5 = tenderMasterService.readRefNo(refNo2);
        int tenderPhase = tenderMaster5.getTenderPhase();
        String tender_type = tenderMaster5.getTenderType();

        String pr_no = tenderMaster5.getPrNo();

        PRMaster prMaster5 = prMasterService.readByPrNo(pr_no);

        List item1 = prItemMasterService.readByRefNo(pr_no, 0);
        List item2 = prItemMasterService.readByRefNo(pr_no, 1);

        mv.getModelMap().put("tender_type", tender_type);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("tenderPhase", tenderPhase);

        mv.getModelMap().put("tenderMaster", tenderMaster5);
        mv.getModelMap().put("prMaster", prMaster5);
        mv.getModelMap().put("item1", item1);
        mv.getModelMap().put("item2", item2);

        //Report
//        String refNo = request.getParameter("refNo");
        String pageNo = request.getParameter("pageNo");
        String next = request.getParameter("next");
        if (next == null) {
            next = "";
        }

        TenderMaster tenderMaster9 = tenderMasterService.readRefNo(refNo);
        String tender_date = tenderMaster9.getAnnounceDate();
        String tender_due_date = tenderMaster9.getSubmitLastdate();

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tender_date", tender_date);
        mv.getModelMap().put("tender_due_date", tender_due_date);
        //    int tenderPhase = tenderMaster.getTenderPhase();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();

        UserRights userRights = userRightsService.readByUser(username);

        List list2 = vendorTenderBidService.vendorList(refNo);
        int total_bid = list2.size();
        mv.getModelMap().put("total_bid", total_bid);

        int total_vendor = 0;
        List list3 = tenderVendorService.readByRefNo(refNo);
        total_vendor = list3.size();
        mv.getModelMap().put("total_vendor", total_vendor);

        List list11 = vendorTenderBidService.vendorBidPrice(refNo);

        List<List<String>> finalList = new LinkedList<List<String>>();
        for (Object o : list11) {
            List templist = new LinkedList();
            Object o11[] = (Object[]) o;
            String vendor_code = o11[1].toString();

            String submit_flag = o11[8].toString();
            if (submit_flag == null) {
                submit_flag = "";
            }

            String vendor_total = "0";

            String rev_item_total = "";
            String rev_service_total = "";
            if (submit_flag.equals("1")) {

                List list12 = reviseVendorTenderBidService.vendorBidPrice(refNo, vendor_code);

                for (Object o1 : list12) {
                    Object o12[] = (Object[]) o1;
                    try {
                        vendor_total = o12[7].toString();
                    } catch (Exception e12) {
                        vendor_total = o12[4].toString();
                    }
                    rev_item_total = o12[2].toString();
                    rev_service_total = o12[3].toString();
                }
            } else {
                try {
                    vendor_total = o11[7].toString();
                } catch (Exception e11) {
                    vendor_total = o11[4].toString();
                }
            }
            String item_total = o11[2].toString();
            String service_total = o11[3].toString();
            templist.add(vendor_code);
            templist.add(vendor_total);
            templist.add(item_total);
            templist.add(service_total);
            templist.add(submit_flag);
            templist.add(rev_item_total);
            templist.add(rev_service_total);
            finalList.add(templist);
        }

        finalList.sort((l1, l2) -> {
            double amt1 = Double.parseDouble(l1.get(1));
            double amt2 = Double.parseDouble(l2.get(1));
            return Double.compare(amt1, amt2);
        });

        int i1 = 0;

        mv.getModelMap().put("vendor_code1", "");
        mv.getModelMap().put("vendor_code2", "");
        mv.getModelMap().put("vendor_code3", "");
        mv.getModelMap().put("vendor_code4", "");
        for (int i = 0; i < finalList.size(); i++) {
            i1++;
            String vendor_code = finalList.get(i).get(0) + "";
            mv.getModelMap().put("vendor_code" + i1, vendor_code);
            mv.getModelMap().put("rank" + i1, i1);

            List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, vendor_code);

            List vendorTermsConditionPriceBid1 = vendorTermsConditionPriceBidService.readByRef(refNo, vendor_code);

            if (vendorTermsConditionPriceBid1 == null) {
                mv.getModelMap().put("vendorTermsConditionPriceBid" + i1, vendorTermsCondition1);
            } else {
                mv.getModelMap().put("vendorTermsConditionPriceBid" + i1, vendorTermsConditionPriceBid1);

            }

            mv.getModelMap().put("vendorTermsCondition" + i1, vendorTermsCondition1);

            String item_total = finalList.get(i).get(2) + "";
            String service_total = finalList.get(i).get(3) + "";

            VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, vendor_code);
            List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNoAndItemType1(refNo, vendor_code, 0);

            mv.getModelMap().put("vendorTenderBidItem" + i1, vendorTenderBidItem);

            String total_value = item_total;
            String grand_total_value = vendorTenderBid.getGrandTotal();
            String select_common = vendorTenderBid.getSelectCommon();
            String terms_of_payment = vendorTenderBid.getTermsOfPayment();
            String delivery_period = vendorTenderBid.getDeliveryPeriod();

            String packingType1 = vendorTenderBid.getPackingType();
            String packingValue1 = vendorTenderBid.getPackingValue();
            String chargesValue1 = vendorTenderBid.getChargesValue();
            String insuranceValue1 = vendorTenderBid.getInsuranceValue();
            String errectionValue1 = vendorTenderBid.getErrectionValue();
            String discountType1 = vendorTenderBid.getDiscountType();
            String discountValue1 = vendorTenderBid.getDiscountValue();
            String itemTotal1 = item_total;
            String igstValue1 = vendorTenderBid.getIgstValue();
            String cgstValue1 = vendorTenderBid.getCgstValue();
            String sgstValue1 = vendorTenderBid.getSgstValue();

            String serviceDiscountType1 = vendorTenderBid.getServiceDiscountType();
            String serviceDiscountValue1 = vendorTenderBid.getServiceDiscountValue();
            String servicegst1 = vendorTenderBid.getServiceGst();
            String serviceTaxTotal1 = vendorTenderBid.getServiceTaxTotal();
            String serviceTotal1 = service_total;

            if (serviceTotal1 == null) {
                serviceTotal1 = "0.0";
            }

            mv.getModelMap().put("serviceDiscountType" + i1, serviceDiscountType1);
            mv.getModelMap().put("serviceDiscountValue" + i1, serviceDiscountValue1);
            mv.getModelMap().put("servicegst" + i1, servicegst1);
            mv.getModelMap().put("serviceTaxTotal" + i1, serviceTaxTotal1);
            mv.getModelMap().put("serviceTotal" + i1, serviceTotal1);

            mv.getModelMap().put("packingType" + i1, packingType1);
            mv.getModelMap().put("packingValue" + i1, packingValue1);
            mv.getModelMap().put("chargesValue" + i1, chargesValue1);
            mv.getModelMap().put("insuranceValue" + i1, insuranceValue1);
            mv.getModelMap().put("errectionValue" + i1, errectionValue1);
            mv.getModelMap().put("discountType" + i1, discountType1);
            mv.getModelMap().put("discountValue" + i1, discountValue1);
            mv.getModelMap().put("itemTotal" + i1, itemTotal1);

            mv.getModelMap().put("select_common" + i1, select_common);
            mv.getModelMap().put("total_value" + i1, total_value);
            mv.getModelMap().put("grand_total_value" + i1, grand_total_value);
            mv.getModelMap().put("terms_of_payment" + i1, terms_of_payment);
            mv.getModelMap().put("delivery_period" + i1, delivery_period);
            mv.getModelMap().put("igstValue" + i1, igstValue1);

            Double packingValueFinal1 = 0.0;
            Double Total1 = 0.0;
            Double chargesValueFinal1 = 0.0;
            Double insuranceValueFinal1 = 0.0;
            Double errectionValueFinal1 = 0.0;
            Double discountValueFinal1 = 0.0;
            Double itemTotalFinal1 = Double.parseDouble(itemTotal1);
            Double igstValueFinal1 = 0.0;

            Total1 = itemTotalFinal1;

            packingValueFinal1 = Double.parseDouble(packingValue1) * Total1 / 100;
            long tmp = Math.round(packingValueFinal1 * 100);
            packingValueFinal1 = (double) tmp / 100;

            chargesValueFinal1 = Double.parseDouble(chargesValue1) * Total1 / 100;
            tmp = Math.round(chargesValueFinal1 * 100);
            chargesValueFinal1 = (double) tmp / 100;

            insuranceValueFinal1 = Double.parseDouble(insuranceValue1) * Total1 / 100;
            tmp = Math.round(insuranceValueFinal1 * 100);
            insuranceValueFinal1 = (double) tmp / 100;

            errectionValueFinal1 = Double.parseDouble(errectionValue1) * Total1 / 100;
            tmp = Math.round(errectionValueFinal1 * 100);
            errectionValueFinal1 = (double) tmp / 100;

            Total1 = Total1 + packingValueFinal1;
            Total1 = Total1 + errectionValueFinal1;
            Total1 = Total1 + insuranceValueFinal1;
            Total1 = Total1 + chargesValueFinal1;

            if (discountType1.equals("0")) {
                discountValueFinal1 = Double.parseDouble(discountValue1) * Total1 / 100;
            } else {
                discountValueFinal1 = Double.parseDouble(discountValue1);
            }
            tmp = Math.round(discountValueFinal1 * 100);
            discountValueFinal1 = (double) tmp / 100;
            Total1 = Total1 - discountValueFinal1;

            igstValueFinal1 = Double.parseDouble(igstValue1) * Total1 / 100;
            tmp = Math.round(igstValueFinal1 * 100);
            igstValueFinal1 = (double) tmp / 100;
            Total1 = Total1 + igstValueFinal1;

            mv.getModelMap().put("discountValueFinal" + i1, discountValueFinal1);
            mv.getModelMap().put("packingValueFinal" + i1, packingValueFinal1);
            mv.getModelMap().put("errectionValueFinal" + i1, errectionValueFinal1);
            mv.getModelMap().put("chargesValueFinal" + i1, chargesValueFinal1);
            mv.getModelMap().put("igstValueFinal" + i1, igstValueFinal1);
            mv.getModelMap().put("insuranceValueFinal" + i1, insuranceValueFinal1);

            mv.getModelMap().put("Total" + i1, Total1);

            int item_type = 1;

            Double serviceTotalFinal1 = Double.parseDouble(serviceTotal1);
            Double serviceDiscountValueFinal1 = 0.0;
            Double servicegstFinal1 = 0.0;
            Double serviceTaxTotalFinal1 = 0.0;
            Double serviceDiscountTypeFinal1 = 0.0;
            Double serviceTotal11 = 0.0;

            List vendorTenderBidItem1 = vendorTenderBidItemService.readByVendorRefNoAndItemType1(refNo, vendor_code, item_type);

            mv.getModelMap().put("ServicevendorTenderBidItem" + i1, vendorTenderBidItem1);

            try {
                serviceTotal11 = serviceTotalFinal1;

                if (serviceDiscountType1.equals("0")) {
                    serviceDiscountValueFinal1 = Double.parseDouble(serviceDiscountValue1) * serviceTotal11 / 100;
                } else {
                    serviceDiscountValueFinal1 = Double.parseDouble(serviceDiscountValue1);
                }

                long tmp1 = Math.round(serviceDiscountValueFinal1 * 100);
                serviceDiscountValueFinal1 = (double) tmp1 / 100;
                serviceTotal11 = serviceTotalFinal1 - serviceDiscountValueFinal1;

                servicegstFinal1 = Double.parseDouble(servicegst1) * serviceTotal11 / 100;
                tmp1 = Math.round(servicegstFinal1 * 100);
                servicegstFinal1 = (double) tmp1 / 100;

                serviceTotal11 = serviceTotal11 + servicegstFinal1;
            } catch (Exception e) {

            }

            mv.getModelMap().put("serviceTotalFinal" + i1, serviceTotalFinal1);
            mv.getModelMap().put("serviceDiscountValueFinal" + i1, serviceDiscountValueFinal1);
            mv.getModelMap().put("servicegstFinal" + i1, servicegstFinal1);
            mv.getModelMap().put("serviceTaxTotal" + i1, serviceTotal11);
            mv.getModelMap().put("serviceDiscountTypeFinal" + i1, serviceDiscountTypeFinal1);
            mv.getModelMap().put("serviceTotal" + i1, serviceTotal11);

            String rev_flag = finalList.get(i).get(4) + "";
            String rev_item_total = finalList.get(i).get(5) + "";
            String rev_service_total = finalList.get(i).get(6) + "";

            String submit_flag = rev_flag;

            if (submit_flag == null) {
                submit_flag = "";
            }
            if (submit_flag.equals("1")) {

                //Revise bid check
                ReviseVendorTenderBid reviseVendorTenderBid = reviseVendorTenderBidService.readByVendorRefNo(refNo, vendor_code);

                List reviseVendorTenderBidItem = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType1(refNo, vendor_code, 0);

                mv.getModelMap().put("rev_submit_flag" + i1, submit_flag);
                mv.getModelMap().put("reviseVendorTenderBidItem" + i1, reviseVendorTenderBidItem);

                total_value = rev_item_total;
                grand_total_value = reviseVendorTenderBid.getGrandTotal();
                select_common = reviseVendorTenderBid.getSelectCommon();
                terms_of_payment = reviseVendorTenderBid.getTermsOfPayment();
                delivery_period = reviseVendorTenderBid.getDeliveryPeriod();

                String revpackingType1 = reviseVendorTenderBid.getPackingType();
                String revpackingValue1 = reviseVendorTenderBid.getPackingValue();
                String revchargesValue1 = reviseVendorTenderBid.getChargesValue();
                String revinsuranceValue1 = reviseVendorTenderBid.getInsuranceValue();
                String reverrectionValue1 = reviseVendorTenderBid.getErrectionValue();
                String revdiscountType1 = reviseVendorTenderBid.getDiscountType();
                String revdiscountValue1 = reviseVendorTenderBid.getDiscountValue();
                String revitemTotal1 = total_value;
                String revigstValue1 = reviseVendorTenderBid.getIgstValue();
                String revcgstValue1 = reviseVendorTenderBid.getCgstValue();
                String revsgstValue1 = reviseVendorTenderBid.getSgstValue();

                String revserviceDiscountType1 = reviseVendorTenderBid.getServiceDiscountType();
                String revserviceDiscountValue1 = reviseVendorTenderBid.getServiceDiscountValue();
                String revservicegst1 = reviseVendorTenderBid.getServiceGst();
                String revserviceTaxTotal1 = reviseVendorTenderBid.getServiceTaxTotal();
                String revserviceTotal1 = rev_service_total;

                if (revserviceTotal1 == null) {
                    revserviceTotal1 = "0.0";
                }

                mv.getModelMap().put("revserviceDiscountType" + i1, revserviceDiscountType1);
                mv.getModelMap().put("revserviceDiscountValue" + i1, revserviceDiscountValue1);
                mv.getModelMap().put("revservicegst" + i1, revservicegst1);
                mv.getModelMap().put("revserviceTaxTotal" + i1, revserviceTaxTotal1);
                mv.getModelMap().put("revsgstValue" + i1, revsgstValue1);

                mv.getModelMap().put("revigstValue" + i1, revigstValue1);
                mv.getModelMap().put("revcgstValue" + i1, revcgstValue1);
                mv.getModelMap().put("revserviceTotal" + i1, revserviceTotal1);

                mv.getModelMap().put("revpackingType" + i1, revpackingType1);
                mv.getModelMap().put("revpackingValue" + i1, revpackingValue1);
                mv.getModelMap().put("revchargesValue" + i1, revchargesValue1);
                mv.getModelMap().put("revinsuranceValue" + i1, revinsuranceValue1);
                mv.getModelMap().put("reverrectionValue" + i1, reverrectionValue1);
                mv.getModelMap().put("revdiscountType" + i1, revdiscountType1);
                mv.getModelMap().put("revdiscountValue" + i1, revdiscountValue1);
                mv.getModelMap().put("revitemTotal" + i1, revitemTotal1);

                mv.getModelMap().put("rev_select_common" + i1, select_common);
                mv.getModelMap().put("rev_total_value" + i1, total_value);
                mv.getModelMap().put("rev_grand_total_value" + i1, grand_total_value);
                mv.getModelMap().put("rev_terms_of_payment" + i1, terms_of_payment);
                mv.getModelMap().put("rev_delivery_period" + i1, delivery_period);

                Double revpackingValueFinal1 = 0.0;
                Double revTotal1 = 0.0;
                Double revchargesValueFinal1 = 0.0;
                Double revinsuranceValueFinal1 = 0.0;
                Double reverrectionValueFinal1 = 0.0;
                Double revdiscountValueFinal1 = 0.0;
                Double revitemTotalFinal1 = Double.parseDouble(revitemTotal1);
                Double revigstValueFinal1 = 0.0;
                Double revcgstValueFinal1 = 0.0;
                Double revsgstValueFinal1 = 0.0;

                revTotal1 = revitemTotalFinal1;

                if (revpackingType1.equals("0")) {
                    revpackingValueFinal1 = Double.parseDouble(revpackingValue1) * revTotal1 / 100;
                } else {
                    revpackingValueFinal1 = Double.parseDouble(revpackingValue1);
                }
                tmp = Math.round(revpackingValueFinal1 * 100);
                revpackingValueFinal1 = (double) tmp / 100;

                revchargesValueFinal1 = Double.parseDouble(revchargesValue1) * revTotal1 / 100;
                tmp = Math.round(revchargesValueFinal1 * 100);
                revchargesValueFinal1 = (double) tmp / 100;

                revinsuranceValueFinal1 = Double.parseDouble(revinsuranceValue1) * revTotal1 / 100;
                tmp = Math.round(revinsuranceValueFinal1 * 100);
                revinsuranceValueFinal1 = (double) tmp / 100;

                reverrectionValueFinal1 = Double.parseDouble(reverrectionValue1) * revTotal1 / 100;
                tmp = Math.round(reverrectionValueFinal1 * 100);
                reverrectionValueFinal1 = (double) tmp / 100;

                revTotal1 = revTotal1 + revpackingValueFinal1;
                revTotal1 = revTotal1 + reverrectionValueFinal1;
                revTotal1 = revTotal1 + revinsuranceValueFinal1;
                revTotal1 = revTotal1 + revchargesValueFinal1;

                if (revdiscountType1.equals("0")) {
                    revdiscountValueFinal1 = Double.parseDouble(revdiscountValue1) * revTotal1 / 100;
                } else {
                    revdiscountValueFinal1 = Double.parseDouble(revdiscountValue1);
                }
                tmp = Math.round(revdiscountValueFinal1 * 100);
                revdiscountValueFinal1 = (double) tmp / 100;
                revTotal1 = revTotal1 - revdiscountValueFinal1;
                tmp = Math.round(revTotal1 * 100);
                revTotal1 = (double) tmp / 100;

                revigstValueFinal1 = Double.parseDouble(revigstValue1) * revTotal1 / 100;
                tmp = Math.round(revigstValueFinal1 * 100);
                revigstValueFinal1 = (double) tmp / 100;
                revcgstValueFinal1 = Double.parseDouble(revcgstValue1) * revTotal1 / 100;
                tmp = Math.round(revcgstValueFinal1 * 100);
                revcgstValueFinal1 = (double) tmp / 100;
                revsgstValueFinal1 = Double.parseDouble(revsgstValue1) * revTotal1 / 100;
                tmp = Math.round(revsgstValueFinal1 * 100);
                revsgstValueFinal1 = (double) tmp / 100;
                revTotal1 = revTotal1 + revigstValueFinal1 + revcgstValueFinal1 + revsgstValueFinal1;
                tmp = Math.round(revTotal1 * 100);
                revTotal1 = (double) tmp / 100;

                mv.getModelMap().put("revdiscountValueFinal" + i1, revdiscountValueFinal1);
                mv.getModelMap().put("revpackingValueFinal" + i1, revpackingValueFinal1);
                mv.getModelMap().put("reverrectionValueFinal" + i1, reverrectionValueFinal1);
                mv.getModelMap().put("revchargesValueFinal" + i1, revchargesValueFinal1);
                mv.getModelMap().put("revigstValueFinal" + i1, revigstValueFinal1);
                mv.getModelMap().put("revcgstValueFinal" + i1, revcgstValueFinal1);
                mv.getModelMap().put("revsgstValueFinal" + i1, revsgstValueFinal1);
                mv.getModelMap().put("revinsuranceValueFinal" + i1, revinsuranceValueFinal1);

                mv.getModelMap().put("revTotal" + i1, revTotal1);

                int revitem_type = 1;

                Double revserviceTotalFinal1 = Double.parseDouble(revserviceTotal1);
                Double revserviceDiscountValueFinal1 = 0.0;
                Double revservicegstFinal1 = 0.0;
                Double revserviceTaxTotalFinal1 = 0.0;
                Double revserviceDiscountTypeFinal1 = 0.0;
                Double revserviceTotal11 = 0.0;

                List revvendorTenderBidItem1 = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType1(refNo, vendor_code, revitem_type);

                mv.getModelMap().put("revServicevendorTenderBidItem" + i1, revvendorTenderBidItem1);

                try {
                    revserviceTotal11 = revserviceTotalFinal1;

                    if (revserviceDiscountType1.equals("0")) {
                        revserviceDiscountValueFinal1 = Double.parseDouble(revserviceDiscountValue1) * revserviceTotal11 / 100;
                    } else {
                        revserviceDiscountValueFinal1 = Double.parseDouble(revserviceDiscountValue1);
                    }

                    long tmp1 = Math.round(revserviceDiscountValueFinal1 * 100);
                    revserviceDiscountValueFinal1 = (double) tmp1 / 100;
                    revserviceTotal11 = revserviceTotalFinal1 - revserviceDiscountValueFinal1;

                    revservicegstFinal1 = Double.parseDouble(revservicegst1) * revserviceTotal11 / 100;
                    tmp1 = Math.round(revservicegstFinal1 * 100);
                    revservicegstFinal1 = (double) tmp1 / 100;

                    revserviceTotal11 = revserviceTotal11 + revservicegstFinal1;

                } catch (Exception e) {

                }

                mv.getModelMap().put("revserviceTotalFinal" + i1, revserviceTotalFinal1);
                mv.getModelMap().put("revserviceDiscountValueFinal" + i1, revserviceDiscountValueFinal1);
                mv.getModelMap().put("revservicegstFinal" + i1, revservicegstFinal1);
                mv.getModelMap().put("revserviceTaxTotal" + i1, revserviceTotal11);
                mv.getModelMap().put("revserviceDiscountTypeFinal" + i1, revserviceDiscountTypeFinal1);
                mv.getModelMap().put("revserviceTotal" + i1, revserviceTotalFinal1);

            }

            VendorMaster vendorMaster = vendorMasterService.read(vendor_code);
            String vendor_name = vendorMaster.getVendorName();
            mv.getModelMap().put("vendor_name" + i1, vendor_name);

        }

        List list1 = vendorTenderBidService.priceBidOpenList1(refNo);

        String vendor_code1 = "";
        String vendor_code2 = "";
        String vendor_code3 = "";
        String vendor_code4 = "";
        int rank1 = 0;
        int rank2 = 0;
        int rank3 = 0;
        int rank4 = 0;
        String bid_open_date = "";
        String bid_open_by = "";
        String bid_open_by_id = "";
        int i = 0;
        int j = 0;
        try {
            j = Integer.parseInt(pageNo);
            if (j > 0) {
                //    j=j-1;
            }
        } catch (Exception e11) {
        }
        if (next.equals("add")) {
            j++;
        }
        if (next.equals("sub")) {
            j--;
        }
        int j1 = j * 4;
        int j2 = 0;
        for (Object o : list1) {

            j2++;
            if (j2 > j1) {

                i++;
                VendorTenderBid vtb = (VendorTenderBid) o;
                if (i == 1) {
                    vendor_code1 = vtb.getVendorCode();
                    bid_open_date = vtb.getBidOpenDate();
                    bid_open_by = vtb.getBidOpenBy();
                    bid_open_by_id = vtb.getBidOpenById();
                    rank1 = j2;
                }
                if (i == 2) {
                    vendor_code2 = vtb.getVendorCode();
                    rank2 = j2;
                }
                if (i == 3) {
                    vendor_code3 = vtb.getVendorCode();
                    rank3 = j2;
                }
                if (i == 4) {
                    vendor_code4 = vtb.getVendorCode();
                    rank4 = j2;
                }
            }

        }

        List list = vendorTenderBidService.priceBidList(refNo);

        List tenderVendorList = tenderVendorService.readByRefNo(refNo);
        mv.getModelMap().put("tenderVendorList", tenderVendorList);

        TenderPriceApproval tenderPriceApproval5 = tenderPriceApprovalService.readByList(refNo);
        List tenderPriceApproval8 = tenderPriceApprovalCommentService.readByRefNo(tenderPriceApproval5.getId());
        mv.getModelMap().put("tenderPriceApproval5", tenderPriceApproval5);
        mv.getModelMap().put("tenderPriceApproval8", tenderPriceApproval8);

        TenderPriceApproval tenderPriceApproval6 = tenderPriceApprovalService.readByRrecycleList(refNo);
        List tenderPriceApproval7 = tenderPriceApprovalCommentService.readByRefNo(tenderPriceApproval6.getId());
        mv.getModelMap().put("tenderPriceApproval6", tenderPriceApproval6);
        mv.getModelMap().put("tenderPriceApproval7", tenderPriceApproval7);

        //List list = tenderMasterService.liveTenderList(username, location, department);
        request.setAttribute("refNo", refNo);

        //    mv.getModelMap().put("id", id);
        mv.getModelMap().put("refNo", refNo);
        //   mv.getModelMap().put("pageNo", pageNo);
        //    mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster9);

        mv.setViewName("PR/PRSummaryReportView");
        return mv;
    }

    public ModelAndView prSummaryReportViewPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNo = prMaster.getPrNo();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prVendor = prVendorService.readByRfqNo(prNo);
        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("prVendor", prVendor);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("id", id);

        String refNo = "TEN" + prNo.replaceAll("PR", "");

        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);
        List tenderVendor = tenderVendorService.readByRefNo(refNo);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tenderVendor", tenderVendor);

//        List techBidOpenList = vendorTechnicalBidService.techBidOpenList(refNo);
        List techBidOpenList = vendorTechnicalBidService.techBidOpenListPrSummary(refNo);
        mv.getModelMap().put("techBidOpenList", techBidOpenList);

//        List priceBidOpenList = vendorTenderBidService.priceBidOpenList(refNo);
        List priceBidOpenList = vendorTenderBidService.priceBidOpenListPrSummary(refNo);
        mv.getModelMap().put("priceBidOpenList", priceBidOpenList);

        List poDetails = poDetailsService.readByRefNo(refNo);
        mv.getModelMap().put("poDetails", poDetails);

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);

        //Report
//        String refNo = request.getParameter("refNo");
        String pageNo = request.getParameter("pageNo");
        String next = request.getParameter("next");
        if (next == null) {
            next = "";
        }

        TenderMaster tenderMaster9 = tenderMasterService.readRefNo(refNo);
        String tender_date = tenderMaster9.getAnnounceDate();
        String tender_due_date = tenderMaster9.getSubmitLastdate();

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tender_date", tender_date);
        mv.getModelMap().put("tender_due_date", tender_due_date);
        //    int tenderPhase = tenderMaster.getTenderPhase();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();

        UserRights userRights = userRightsService.readByUser(username);

        List list2 = vendorTenderBidService.vendorList(refNo);
        int total_bid = list2.size();
        mv.getModelMap().put("total_bid", total_bid);

        int total_vendor = 0;
        List list3 = tenderVendorService.readByRefNo(refNo);
        total_vendor = list3.size();
        mv.getModelMap().put("total_vendor", total_vendor);

        List list11 = vendorTenderBidService.vendorBidPrice(refNo);

        List<List<String>> finalList = new LinkedList<List<String>>();
        for (Object o : list11) {
            List templist = new LinkedList();
            Object o11[] = (Object[]) o;
            String vendor_code = o11[1].toString();

            String submit_flag = o11[8].toString();
            if (submit_flag == null) {
                submit_flag = "";
            }

            String vendor_total = "0";

            String rev_item_total = "";
            String rev_service_total = "";
            if (submit_flag.equals("1")) {

                List list12 = reviseVendorTenderBidService.vendorBidPrice(refNo, vendor_code);

                for (Object o1 : list12) {
                    Object o12[] = (Object[]) o1;
                    try {
                        vendor_total = o12[7].toString();
                    } catch (Exception e12) {
                        vendor_total = o12[4].toString();
                    }
                    rev_item_total = o12[2].toString();
                    rev_service_total = o12[3].toString();
                }
            } else {
                try {
                    vendor_total = o11[7].toString();
                } catch (Exception e11) {
                    vendor_total = o11[4].toString();
                }
            }
            String item_total = o11[2].toString();
            String service_total = o11[3].toString();
            templist.add(vendor_code);
            templist.add(vendor_total);
            templist.add(item_total);
            templist.add(service_total);
            templist.add(submit_flag);
            templist.add(rev_item_total);
            templist.add(rev_service_total);
            finalList.add(templist);
        }

        finalList.sort((l1, l2) -> {
            double amt1 = Double.parseDouble(l1.get(1));
            double amt2 = Double.parseDouble(l2.get(1));
            return Double.compare(amt1, amt2);
        });

        int i1 = 0;

        mv.getModelMap().put("vendor_code1", "");
        mv.getModelMap().put("vendor_code2", "");
        mv.getModelMap().put("vendor_code3", "");
        mv.getModelMap().put("vendor_code4", "");
        for (int i = 0; i < finalList.size(); i++) {
            i1++;
            String vendor_code = finalList.get(i).get(0) + "";
            mv.getModelMap().put("vendor_code" + i1, vendor_code);
            mv.getModelMap().put("rank" + i1, i1);

            List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, vendor_code);

            List vendorTermsConditionPriceBid1 = vendorTermsConditionPriceBidService.readByRef(refNo, vendor_code);

            if (vendorTermsConditionPriceBid1 == null) {
                mv.getModelMap().put("vendorTermsConditionPriceBid" + i1, vendorTermsCondition1);
            } else {
                mv.getModelMap().put("vendorTermsConditionPriceBid" + i1, vendorTermsConditionPriceBid1);

            }

            mv.getModelMap().put("vendorTermsCondition" + i1, vendorTermsCondition1);

            String item_total = finalList.get(i).get(2) + "";
            String service_total = finalList.get(i).get(3) + "";

            VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, vendor_code);
            List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNoAndItemType1(refNo, vendor_code, 0);

            mv.getModelMap().put("vendorTenderBidItem" + i1, vendorTenderBidItem);

            String total_value = item_total;
            String grand_total_value = vendorTenderBid.getGrandTotal();
            String select_common = vendorTenderBid.getSelectCommon();
            String terms_of_payment = vendorTenderBid.getTermsOfPayment();
            String delivery_period = vendorTenderBid.getDeliveryPeriod();

            String packingType1 = vendorTenderBid.getPackingType();
            String packingValue1 = vendorTenderBid.getPackingValue();
            String chargesValue1 = vendorTenderBid.getChargesValue();
            String insuranceValue1 = vendorTenderBid.getInsuranceValue();
            String errectionValue1 = vendorTenderBid.getErrectionValue();
            String discountType1 = vendorTenderBid.getDiscountType();
            String discountValue1 = vendorTenderBid.getDiscountValue();
            String itemTotal1 = item_total;
            String igstValue1 = vendorTenderBid.getIgstValue();
            String cgstValue1 = vendorTenderBid.getCgstValue();
            String sgstValue1 = vendorTenderBid.getSgstValue();

            String serviceDiscountType1 = vendorTenderBid.getServiceDiscountType();
            String serviceDiscountValue1 = vendorTenderBid.getServiceDiscountValue();
            String servicegst1 = vendorTenderBid.getServiceGst();
            String serviceTaxTotal1 = vendorTenderBid.getServiceTaxTotal();
            String serviceTotal1 = service_total;

            if (serviceTotal1 == null) {
                serviceTotal1 = "0.0";
            }

            mv.getModelMap().put("serviceDiscountType" + i1, serviceDiscountType1);
            mv.getModelMap().put("serviceDiscountValue" + i1, serviceDiscountValue1);
            mv.getModelMap().put("servicegst" + i1, servicegst1);
            mv.getModelMap().put("serviceTaxTotal" + i1, serviceTaxTotal1);
            mv.getModelMap().put("serviceTotal" + i1, serviceTotal1);

            mv.getModelMap().put("packingType" + i1, packingType1);
            mv.getModelMap().put("packingValue" + i1, packingValue1);
            mv.getModelMap().put("chargesValue" + i1, chargesValue1);
            mv.getModelMap().put("insuranceValue" + i1, insuranceValue1);
            mv.getModelMap().put("errectionValue" + i1, errectionValue1);
            mv.getModelMap().put("discountType" + i1, discountType1);
            mv.getModelMap().put("discountValue" + i1, discountValue1);
            mv.getModelMap().put("itemTotal" + i1, itemTotal1);

            mv.getModelMap().put("select_common" + i1, select_common);
            mv.getModelMap().put("total_value" + i1, total_value);
            mv.getModelMap().put("grand_total_value" + i1, grand_total_value);
            mv.getModelMap().put("terms_of_payment" + i1, terms_of_payment);
            mv.getModelMap().put("delivery_period" + i1, delivery_period);
            mv.getModelMap().put("igstValue" + i1, igstValue1);

            Double packingValueFinal1 = 0.0;
            Double Total1 = 0.0;
            Double chargesValueFinal1 = 0.0;
            Double insuranceValueFinal1 = 0.0;
            Double errectionValueFinal1 = 0.0;
            Double discountValueFinal1 = 0.0;
            Double itemTotalFinal1 = Double.parseDouble(itemTotal1);
            Double igstValueFinal1 = 0.0;

            Total1 = itemTotalFinal1;

            packingValueFinal1 = Double.parseDouble(packingValue1) * Total1 / 100;
            long tmp = Math.round(packingValueFinal1 * 100);
            packingValueFinal1 = (double) tmp / 100;

            chargesValueFinal1 = Double.parseDouble(chargesValue1) * Total1 / 100;
            tmp = Math.round(chargesValueFinal1 * 100);
            chargesValueFinal1 = (double) tmp / 100;

            insuranceValueFinal1 = Double.parseDouble(insuranceValue1) * Total1 / 100;
            tmp = Math.round(insuranceValueFinal1 * 100);
            insuranceValueFinal1 = (double) tmp / 100;

            errectionValueFinal1 = Double.parseDouble(errectionValue1) * Total1 / 100;
            tmp = Math.round(errectionValueFinal1 * 100);
            errectionValueFinal1 = (double) tmp / 100;

            Total1 = Total1 + packingValueFinal1;
            Total1 = Total1 + errectionValueFinal1;
            Total1 = Total1 + insuranceValueFinal1;
            Total1 = Total1 + chargesValueFinal1;

            if (discountType1.equals("0")) {
                discountValueFinal1 = Double.parseDouble(discountValue1) * Total1 / 100;
            } else {
                discountValueFinal1 = Double.parseDouble(discountValue1);
            }
            tmp = Math.round(discountValueFinal1 * 100);
            discountValueFinal1 = (double) tmp / 100;
            Total1 = Total1 - discountValueFinal1;

            igstValueFinal1 = Double.parseDouble(igstValue1) * Total1 / 100;
            tmp = Math.round(igstValueFinal1 * 100);
            igstValueFinal1 = (double) tmp / 100;
            Total1 = Total1 + igstValueFinal1;

            mv.getModelMap().put("discountValueFinal" + i1, discountValueFinal1);
            mv.getModelMap().put("packingValueFinal" + i1, packingValueFinal1);
            mv.getModelMap().put("errectionValueFinal" + i1, errectionValueFinal1);
            mv.getModelMap().put("chargesValueFinal" + i1, chargesValueFinal1);
            mv.getModelMap().put("igstValueFinal" + i1, igstValueFinal1);
            mv.getModelMap().put("insuranceValueFinal" + i1, insuranceValueFinal1);

            mv.getModelMap().put("Total" + i1, Total1);

            int item_type = 1;

            Double serviceTotalFinal1 = Double.parseDouble(serviceTotal1);
            Double serviceDiscountValueFinal1 = 0.0;
            Double servicegstFinal1 = 0.0;
            Double serviceTaxTotalFinal1 = 0.0;
            Double serviceDiscountTypeFinal1 = 0.0;
            Double serviceTotal11 = 0.0;

            List vendorTenderBidItem1 = vendorTenderBidItemService.readByVendorRefNoAndItemType1(refNo, vendor_code, item_type);

            mv.getModelMap().put("ServicevendorTenderBidItem" + i1, vendorTenderBidItem1);

            try {
                serviceTotal11 = serviceTotalFinal1;

                if (serviceDiscountType1.equals("0")) {
                    serviceDiscountValueFinal1 = Double.parseDouble(serviceDiscountValue1) * serviceTotal11 / 100;
                } else {
                    serviceDiscountValueFinal1 = Double.parseDouble(serviceDiscountValue1);
                }

                long tmp1 = Math.round(serviceDiscountValueFinal1 * 100);
                serviceDiscountValueFinal1 = (double) tmp1 / 100;
                serviceTotal11 = serviceTotalFinal1 - serviceDiscountValueFinal1;

                servicegstFinal1 = Double.parseDouble(servicegst1) * serviceTotal11 / 100;
                tmp1 = Math.round(servicegstFinal1 * 100);
                servicegstFinal1 = (double) tmp1 / 100;

                serviceTotal11 = serviceTotal11 + servicegstFinal1;
            } catch (Exception e) {

            }

            mv.getModelMap().put("serviceTotalFinal" + i1, serviceTotalFinal1);
            mv.getModelMap().put("serviceDiscountValueFinal" + i1, serviceDiscountValueFinal1);
            mv.getModelMap().put("servicegstFinal" + i1, servicegstFinal1);
            mv.getModelMap().put("serviceTaxTotal" + i1, serviceTotal11);
            mv.getModelMap().put("serviceDiscountTypeFinal" + i1, serviceDiscountTypeFinal1);
            mv.getModelMap().put("serviceTotal" + i1, serviceTotal11);

            String rev_flag = finalList.get(i).get(4) + "";
            String rev_item_total = finalList.get(i).get(5) + "";
            String rev_service_total = finalList.get(i).get(6) + "";

            String submit_flag = rev_flag;

            if (submit_flag == null) {
                submit_flag = "";
            }
            if (submit_flag.equals("1")) {

                //Revise bid check
                ReviseVendorTenderBid reviseVendorTenderBid = reviseVendorTenderBidService.readByVendorRefNo(refNo, vendor_code);

                List reviseVendorTenderBidItem = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType1(refNo, vendor_code, 0);

                mv.getModelMap().put("rev_submit_flag" + i1, submit_flag);
                mv.getModelMap().put("reviseVendorTenderBidItem" + i1, reviseVendorTenderBidItem);

                total_value = rev_item_total;
                grand_total_value = reviseVendorTenderBid.getGrandTotal();
                select_common = reviseVendorTenderBid.getSelectCommon();
                terms_of_payment = reviseVendorTenderBid.getTermsOfPayment();
                delivery_period = reviseVendorTenderBid.getDeliveryPeriod();

                String revpackingType1 = reviseVendorTenderBid.getPackingType();
                String revpackingValue1 = reviseVendorTenderBid.getPackingValue();
                String revchargesValue1 = reviseVendorTenderBid.getChargesValue();
                String revinsuranceValue1 = reviseVendorTenderBid.getInsuranceValue();
                String reverrectionValue1 = reviseVendorTenderBid.getErrectionValue();
                String revdiscountType1 = reviseVendorTenderBid.getDiscountType();
                String revdiscountValue1 = reviseVendorTenderBid.getDiscountValue();
                String revitemTotal1 = total_value;
                String revigstValue1 = reviseVendorTenderBid.getIgstValue();
                String revcgstValue1 = reviseVendorTenderBid.getCgstValue();
                String revsgstValue1 = reviseVendorTenderBid.getSgstValue();

                String revserviceDiscountType1 = reviseVendorTenderBid.getServiceDiscountType();
                String revserviceDiscountValue1 = reviseVendorTenderBid.getServiceDiscountValue();
                String revservicegst1 = reviseVendorTenderBid.getServiceGst();
                String revserviceTaxTotal1 = reviseVendorTenderBid.getServiceTaxTotal();
                String revserviceTotal1 = rev_service_total;

                if (revserviceTotal1 == null) {
                    revserviceTotal1 = "0.0";
                }

                mv.getModelMap().put("revserviceDiscountType" + i1, revserviceDiscountType1);
                mv.getModelMap().put("revserviceDiscountValue" + i1, revserviceDiscountValue1);
                mv.getModelMap().put("revservicegst" + i1, revservicegst1);
                mv.getModelMap().put("revserviceTaxTotal" + i1, revserviceTaxTotal1);
                mv.getModelMap().put("revsgstValue" + i1, revsgstValue1);

                mv.getModelMap().put("revigstValue" + i1, revigstValue1);
                mv.getModelMap().put("revcgstValue" + i1, revcgstValue1);
                mv.getModelMap().put("revserviceTotal" + i1, revserviceTotal1);

                mv.getModelMap().put("revpackingType" + i1, revpackingType1);
                mv.getModelMap().put("revpackingValue" + i1, revpackingValue1);
                mv.getModelMap().put("revchargesValue" + i1, revchargesValue1);
                mv.getModelMap().put("revinsuranceValue" + i1, revinsuranceValue1);
                mv.getModelMap().put("reverrectionValue" + i1, reverrectionValue1);
                mv.getModelMap().put("revdiscountType" + i1, revdiscountType1);
                mv.getModelMap().put("revdiscountValue" + i1, revdiscountValue1);
                mv.getModelMap().put("revitemTotal" + i1, revitemTotal1);

                mv.getModelMap().put("rev_select_common" + i1, select_common);
                mv.getModelMap().put("rev_total_value" + i1, total_value);
                mv.getModelMap().put("rev_grand_total_value" + i1, grand_total_value);
                mv.getModelMap().put("rev_terms_of_payment" + i1, terms_of_payment);
                mv.getModelMap().put("rev_delivery_period" + i1, delivery_period);

                Double revpackingValueFinal1 = 0.0;
                Double revTotal1 = 0.0;
                Double revchargesValueFinal1 = 0.0;
                Double revinsuranceValueFinal1 = 0.0;
                Double reverrectionValueFinal1 = 0.0;
                Double revdiscountValueFinal1 = 0.0;
                Double revitemTotalFinal1 = Double.parseDouble(revitemTotal1);
                Double revigstValueFinal1 = 0.0;
                Double revcgstValueFinal1 = 0.0;
                Double revsgstValueFinal1 = 0.0;

                revTotal1 = revitemTotalFinal1;

                if (revpackingType1.equals("0")) {
                    revpackingValueFinal1 = Double.parseDouble(revpackingValue1) * revTotal1 / 100;
                } else {
                    revpackingValueFinal1 = Double.parseDouble(revpackingValue1);
                }
                tmp = Math.round(revpackingValueFinal1 * 100);
                revpackingValueFinal1 = (double) tmp / 100;

                revchargesValueFinal1 = Double.parseDouble(revchargesValue1) * revTotal1 / 100;
                tmp = Math.round(revchargesValueFinal1 * 100);
                revchargesValueFinal1 = (double) tmp / 100;

                revinsuranceValueFinal1 = Double.parseDouble(revinsuranceValue1) * revTotal1 / 100;
                tmp = Math.round(revinsuranceValueFinal1 * 100);
                revinsuranceValueFinal1 = (double) tmp / 100;

                reverrectionValueFinal1 = Double.parseDouble(reverrectionValue1) * revTotal1 / 100;
                tmp = Math.round(reverrectionValueFinal1 * 100);
                reverrectionValueFinal1 = (double) tmp / 100;

                revTotal1 = revTotal1 + revpackingValueFinal1;
                revTotal1 = revTotal1 + reverrectionValueFinal1;
                revTotal1 = revTotal1 + revinsuranceValueFinal1;
                revTotal1 = revTotal1 + revchargesValueFinal1;

                if (revdiscountType1.equals("0")) {
                    revdiscountValueFinal1 = Double.parseDouble(revdiscountValue1) * revTotal1 / 100;
                } else {
                    revdiscountValueFinal1 = Double.parseDouble(revdiscountValue1);
                }
                tmp = Math.round(revdiscountValueFinal1 * 100);
                revdiscountValueFinal1 = (double) tmp / 100;
                revTotal1 = revTotal1 - revdiscountValueFinal1;
                tmp = Math.round(revTotal1 * 100);
                revTotal1 = (double) tmp / 100;

                revigstValueFinal1 = Double.parseDouble(revigstValue1) * revTotal1 / 100;
                tmp = Math.round(revigstValueFinal1 * 100);
                revigstValueFinal1 = (double) tmp / 100;
                revcgstValueFinal1 = Double.parseDouble(revcgstValue1) * revTotal1 / 100;
                tmp = Math.round(revcgstValueFinal1 * 100);
                revcgstValueFinal1 = (double) tmp / 100;
                revsgstValueFinal1 = Double.parseDouble(revsgstValue1) * revTotal1 / 100;
                tmp = Math.round(revsgstValueFinal1 * 100);
                revsgstValueFinal1 = (double) tmp / 100;
                revTotal1 = revTotal1 + revigstValueFinal1 + revcgstValueFinal1 + revsgstValueFinal1;
                tmp = Math.round(revTotal1 * 100);
                revTotal1 = (double) tmp / 100;

                mv.getModelMap().put("revdiscountValueFinal" + i1, revdiscountValueFinal1);
                mv.getModelMap().put("revpackingValueFinal" + i1, revpackingValueFinal1);
                mv.getModelMap().put("reverrectionValueFinal" + i1, reverrectionValueFinal1);
                mv.getModelMap().put("revchargesValueFinal" + i1, revchargesValueFinal1);
                mv.getModelMap().put("revigstValueFinal" + i1, revigstValueFinal1);
                mv.getModelMap().put("revcgstValueFinal" + i1, revcgstValueFinal1);
                mv.getModelMap().put("revsgstValueFinal" + i1, revsgstValueFinal1);
                mv.getModelMap().put("revinsuranceValueFinal" + i1, revinsuranceValueFinal1);

                mv.getModelMap().put("revTotal" + i1, revTotal1);

                int revitem_type = 1;

                Double revserviceTotalFinal1 = Double.parseDouble(revserviceTotal1);
                Double revserviceDiscountValueFinal1 = 0.0;
                Double revservicegstFinal1 = 0.0;
                Double revserviceTaxTotalFinal1 = 0.0;
                Double revserviceDiscountTypeFinal1 = 0.0;
                Double revserviceTotal11 = 0.0;

                List revvendorTenderBidItem1 = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType1(refNo, vendor_code, revitem_type);

                mv.getModelMap().put("revServicevendorTenderBidItem" + i1, revvendorTenderBidItem1);

                try {
                    revserviceTotal11 = revserviceTotalFinal1;

                    if (revserviceDiscountType1.equals("0")) {
                        revserviceDiscountValueFinal1 = Double.parseDouble(revserviceDiscountValue1) * revserviceTotal11 / 100;
                    } else {
                        revserviceDiscountValueFinal1 = Double.parseDouble(revserviceDiscountValue1);
                    }

                    long tmp1 = Math.round(revserviceDiscountValueFinal1 * 100);
                    revserviceDiscountValueFinal1 = (double) tmp1 / 100;
                    revserviceTotal11 = revserviceTotalFinal1 - revserviceDiscountValueFinal1;

                    revservicegstFinal1 = Double.parseDouble(revservicegst1) * revserviceTotal11 / 100;
                    tmp1 = Math.round(revservicegstFinal1 * 100);
                    revservicegstFinal1 = (double) tmp1 / 100;

                    revserviceTotal11 = revserviceTotal11 + revservicegstFinal1;

                } catch (Exception e) {

                }

                mv.getModelMap().put("revserviceTotalFinal" + i1, revserviceTotalFinal1);
                mv.getModelMap().put("revserviceDiscountValueFinal" + i1, revserviceDiscountValueFinal1);
                mv.getModelMap().put("revservicegstFinal" + i1, revservicegstFinal1);
                mv.getModelMap().put("revserviceTaxTotal" + i1, revserviceTotal11);
                mv.getModelMap().put("revserviceDiscountTypeFinal" + i1, revserviceDiscountTypeFinal1);
                mv.getModelMap().put("revserviceTotal" + i1, revserviceTotalFinal1);

            }

            VendorMaster vendorMaster = vendorMasterService.read(vendor_code);
            String vendor_name = vendorMaster.getVendorName();
            mv.getModelMap().put("vendor_name" + i1, vendor_name);

        }

        List list1 = vendorTenderBidService.priceBidOpenList1(refNo);

        String vendor_code1 = "";
        String vendor_code2 = "";
        String vendor_code3 = "";
        String vendor_code4 = "";
        int rank1 = 0;
        int rank2 = 0;
        int rank3 = 0;
        int rank4 = 0;
        String bid_open_date = "";
        String bid_open_by = "";
        String bid_open_by_id = "";
        int i = 0;
        int j = 0;
        try {
            j = Integer.parseInt(pageNo);
            if (j > 0) {
                //    j=j-1;
            }
        } catch (Exception e11) {
        }
        if (next.equals("add")) {
            j++;
        }
        if (next.equals("sub")) {
            j--;
        }
        int j1 = j * 4;
        int j2 = 0;
        for (Object o : list1) {

            j2++;
            if (j2 > j1) {

                i++;
                VendorTenderBid vtb = (VendorTenderBid) o;
                if (i == 1) {
                    vendor_code1 = vtb.getVendorCode();
                    bid_open_date = vtb.getBidOpenDate();
                    bid_open_by = vtb.getBidOpenBy();
                    bid_open_by_id = vtb.getBidOpenById();
                    rank1 = j2;
                }
                if (i == 2) {
                    vendor_code2 = vtb.getVendorCode();
                    rank2 = j2;
                }
                if (i == 3) {
                    vendor_code3 = vtb.getVendorCode();
                    rank3 = j2;
                }
                if (i == 4) {
                    vendor_code4 = vtb.getVendorCode();
                    rank4 = j2;
                }
            }

        }

        List list = vendorTenderBidService.priceBidList(refNo);

        List tenderVendorList = tenderVendorService.readByRefNo(refNo);
        mv.getModelMap().put("tenderVendorList", tenderVendorList);

        TenderPriceApproval tenderPriceApproval5 = tenderPriceApprovalService.readByList(refNo);
        List tenderPriceApproval8 = tenderPriceApprovalCommentService.readByRefNo(tenderPriceApproval5.getId());
        mv.getModelMap().put("tenderPriceApproval5", tenderPriceApproval5);
        mv.getModelMap().put("tenderPriceApproval8", tenderPriceApproval8);

        TenderPriceApproval tenderPriceApproval6 = tenderPriceApprovalService.readByRrecycleList(refNo);
        List tenderPriceApproval7 = tenderPriceApprovalCommentService.readByRefNo(tenderPriceApproval6.getId());
        mv.getModelMap().put("tenderPriceApproval6", tenderPriceApproval6);
        mv.getModelMap().put("tenderPriceApproval7", tenderPriceApproval7);

        //List list = tenderMasterService.liveTenderList(username, location, department);
        request.setAttribute("refNo", refNo);

        //    mv.getModelMap().put("id", id);
        mv.getModelMap().put("refNo", refNo);
        //   mv.getModelMap().put("pageNo", pageNo);
        //    mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster9);

        mv.setViewName("PR/prSummaryReportViewPrint");
        return mv;
    }

    public ModelAndView prPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PRMaster prMaster = prMasterService.readById(Integer.parseInt(id));

        String prNo = prMaster.getPrNo();

        PRPriceApproval prPriceApproval = prPriceApprovalService.readById(Integer.parseInt(id));

        List tenderPriceApproval = prPriceApprovalService.readByprNo(prNo);
        List tenderPriceApproval1 = prMasterService.readByRefNo(prNo);
        List tenderPriceApproval2 = prVendorService.readByRfqNo(prNo);
        List tenderPriceApproval3 = prItemMasterService.readByRefNo(prNo, 0);
        List tenderPriceApproval4 = prItemMasterService.readByRefNo(prNo, 1);
        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        List approvalList = prApprovalCommentService.readByPrNumber(prNo);
        mv.getModelMap().put("approvalList", approvalList);

        List prVendor = prVendorService.readByRfqNo(prNo);
        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        mv.getModelMap().put("prMaster", prMaster);
        mv.getModelMap().put("prVendor", prVendor);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("id", id);

        mv.getModelMap().put("list1", tenderPriceApproval);
        mv.getModelMap().put("list2", tenderPriceApproval1);
        mv.getModelMap().put("list3", tenderPriceApproval2);
        mv.getModelMap().put("list4", tenderPriceApproval3);
        mv.getModelMap().put("list5", tenderPriceApproval4);

        mv.setViewName("PR/prPrint");
        return mv;
    }
}

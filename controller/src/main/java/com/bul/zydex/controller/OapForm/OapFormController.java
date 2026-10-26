/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.OapForm;

import com.bul.zydex.model.AocForm;
import com.bul.zydex.model.AocFormApproval;
import com.bul.zydex.model.AocFormApprovalUser;
import com.bul.zydex.model.AocFormAttachment;
import com.bul.zydex.model.AocLogMaster;
import com.bul.zydex.model.AocSurveyAttachment;
import com.bul.zydex.model.ChargerInstallationDetails;
import com.bul.zydex.model.ChargerInstallationDetailsHistory;
import com.bul.zydex.model.ConnectionType;
import com.bul.zydex.model.CrcForm;
import com.bul.zydex.model.CrcFormApproval;
import com.bul.zydex.model.CrcFormApprovalComment;
import com.bul.zydex.model.CrcFormApprovalUser;
import com.bul.zydex.model.CrcFormHistory;
import com.bul.zydex.model.Deliverable;
import com.bul.zydex.model.DeliverableMulti;
import com.bul.zydex.model.DesignCoordinatorMultiAttach;
import com.bul.zydex.model.DesignCordinatorComments;
import com.bul.zydex.model.DiscomMaster;
import com.bul.zydex.model.DocumentMasterId;
import com.bul.zydex.model.DocumentName;
import com.bul.zydex.model.EhMail;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.IteamDetailsAttachments;
import com.bul.zydex.model.KickOffForm;
import com.bul.zydex.model.KickOffFormApprovalUser;
import com.bul.zydex.model.OapDocumentAttachment;
import com.bul.zydex.model.OapForm;
import com.bul.zydex.model.OapFormApproval;
import com.bul.zydex.model.OapFormApprovalComment;
import com.bul.zydex.model.OapFormApprovalUser;
import com.bul.zydex.model.OapFormHistory;
import com.bul.zydex.model.OapLogMaster;
import com.bul.zydex.model.OapMaster;
import com.bul.zydex.model.OapMasterUser;
import com.bul.zydex.model.OapMultiAttachment;
import com.bul.zydex.model.OapMultiAttachmentHistory;
import com.bul.zydex.model.OapSurveyAttachment;
import com.bul.zydex.model.OapSurveyAttachmentHistory;
import com.bul.zydex.model.PRMaster;
import com.bul.zydex.model.PRNoTemp;
import com.bul.zydex.model.SiteSurvey;
import com.bul.zydex.model.SiteSurveyAttachment;
//import com.bul.zydex.model.SurveyCategoryMaster;
import com.bul.zydex.model.SurveyDocumentNo;
//import com.bul.zydex.model.SurveyMaster;
//import com.bul.zydex.model.SurveySubCategoryMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.util.DownloadFile;
import com.bul.zydex.util.SendMail;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sumanth
 */
public class OapFormController extends OapFormAbstract {

    public ModelAndView oapForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List list0 = tenantService.read();
//	List list1 = documentNameService.readAll();
        List list2 = stationTypeService.read();
        List list3 = currencyMasterService.read();
        List list4 = projectTypeService.read();
        List list5 = oapFormService.read();
        List list6 = investmentProfileService.read();
        List list7 = profitCenterService.read();
        List list8 = plantMastersService.read();
        List list9 = companyMasterService.read();
        List list10 = oapMasterService.read();
        List list11 = projectProfileService.read();
//	List list88 = documentNameService.read();
        List list12 = discomMasterService.read();
        List list13 = connectionTypeService.read();
        List list14 = projectNameMasterService.read();
        List list15 = anchorCustomerService.read();
        List list16 = canopyVarientService.read();

        List list17 = chargerTypeService.read();
        List list18 = chargerMasterService.read();
        List list19 = connectorTypeService.read();

        request.setAttribute("list0", list0);
//	request.setAttribute("list1", list1);
        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);
        request.setAttribute("list4", list4);
        request.setAttribute("list5", list5);
        request.setAttribute("list6", list6);
        request.setAttribute("list7", list7);
        request.setAttribute("list8", list8);
        request.setAttribute("list9", list9);
        request.setAttribute("list10", list10);
        request.setAttribute("list11", list11);
        request.setAttribute("list12", list12);
        request.setAttribute("list13", list13);
        request.setAttribute("list14", list14);
        mv.getModelMap().put("list15", list15);
        mv.getModelMap().put("list16", list16);
        mv.getModelMap().put("list17", list17);
        mv.getModelMap().put("list18", list18);
        mv.getModelMap().put("list19", list19);

        mv.setViewName("Oap/OapForm_1");
        return mv;
    }

    public ModelAndView oapFormSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

//	String documentNo = request.getParameter("documentNo");
        String pcsName = request.getParameter("pcsName");
        String date = request.getParameter("date");
        String documentRevisonNo = request.getParameter("documentRevisonNo");
        String projectName = request.getParameter("projectName");
        String city_highway = request.getParameter("city/highway");
        String pcsAddress = request.getParameter("pcsAddress");
        String pcsType1 = request.getParameter("pcsType1");
        if (pcsType1 == null) {
            pcsType1 = "0";
        } else {
            pcsType1 = "1";
        }

        String pcsType2 = request.getParameter("pcsType2");
        if (pcsType2 == null) {
            pcsType2 = "0";
        } else {
            pcsType2 = "1";
        }
        String pcsType3 = request.getParameter("pcsType3");
        if (pcsType3 == null) {
            pcsType3 = "0";
        } else {
            pcsType3 = "1";
        }
        String pcstypeother = request.getParameter("pcstypeother");
        if (pcstypeother == null) {
            pcstypeother = "";
        }
        String pcsModel = request.getParameter("pcsModel");
        if (pcsModel == null) {
            pcsModel = "0";
        } else {
            pcsModel = "1";
        }
        String pcsMode2 = request.getParameter("pcsMode2");
        if (pcsMode2 == null) {
            pcsMode2 = "0";
        } else {
            pcsMode2 = "1";
        }
        String pcsMode3 = request.getParameter("pcsMode3");
        if (pcsMode3 == null) {
            pcsMode3 = "0";
        } else {
            pcsMode3 = "1";
        }
        String pcsMode5 = request.getParameter("pcsMode5");
        if (pcsMode5 == null) {
            pcsMode5 = "0";
        } else {
            pcsMode5 = "1";
        }
        String pcsMode4 = request.getParameter("pcsMode4");
        if (pcsMode4 == null) {
            pcsMode4 = "0";
        } else {
            pcsMode4 = "1";
        }
        String pcsModelother = request.getParameter("pcsModelother");
        if (pcsModelother == null) {
            pcsModelother = "";
        }

        String pcscoordinates = request.getParameter("pcscoordinates");
        String mobileNo = request.getParameter("mobileNo");
        String email = request.getParameter("email");
        String alternatemobileNo = request.getParameter("alternatemobileNo");
        String clientDetails = request.getParameter("clientDetails");
        String clientRequiremts = request.getParameter("clientRequiremts");
        String clientscope = request.getParameter("clientscope");

        String salesName = request.getParameter("salesName");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String date1 = request.getParameter("date1");
//	String signature1 = request.getParameter("signature1");

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateTime = currentDateTime.format(formatter);
        Date date5 = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yy");
        String sysdate = sdf4.format(date5);
        Date date55 = new java.util.Date();
        SimpleDateFormat sdf5 = new SimpleDateFormat("MM");
        String sysdate1 = sdf5.format(date55);
        int month_frt = Integer.parseInt(sysdate1);
        int year_frt = Integer.parseInt(sysdate);

        DocumentMasterId documentMasterId = documentMasterIdService.readByDocumentNo();

        String meetingno = "0";
        meetingno = documentMasterId.getDocumentId();
        if (meetingno == null) {
            meetingno = "0";
        }

        int ten_no_int = 0;

        ten_no_int = Integer.parseInt(meetingno);

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

        String refNo = final_ten_no;
//	refNo = "OAP" + "-" + refNo;

        String f_year = refNo.substring(0, 2);
        String f_no = refNo.substring(2, 7);

        int f_y1 = Integer.parseInt(f_year);
        f_y1++;

        refNo = "OAP" + "-" + f_year + "" + f_y1 + "-" + f_no;

        String country = request.getParameter("country");
        String state5 = request.getParameter("state");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String houseno = request.getParameter("houseno");

//        Charger Installation Details:
        String chargeInstall1 = request.getParameter("chargeInstall1");
        if (chargeInstall1 == null) {
            chargeInstall1 = "0";
        } else {
            chargeInstall1 = "1";
        }
        String chargeInstall1qua = request.getParameter("chargeInstall1qua");
        if (chargeInstall1qua == null) {
            chargeInstall1qua = "";
        }
        String chargeInstall2 = request.getParameter("chargeInstall2");
        if (chargeInstall2 == null) {
            chargeInstall2 = "0";
        } else {
            chargeInstall2 = "1";
        }
        String chargeInstall2qua = request.getParameter("chargeInstall2qua");
        if (chargeInstall2qua == null) {
            chargeInstall2qua = "";
        }
        String chargeInstall3 = request.getParameter("chargeInstall3");
        if (chargeInstall3 == null) {
            chargeInstall3 = "0";
        } else {
            chargeInstall3 = "1";
        }
        String chargeInstall3qua = request.getParameter("chargeInstall3qua");
        if (chargeInstall3qua == null) {
            chargeInstall3qua = "";
        }
        String chargeInstall4 = request.getParameter("chargeInstall4");
        if (chargeInstall4 == null) {
            chargeInstall4 = "0";
        } else {
            chargeInstall4 = "1";
        }
        String chargeInstall4qua = request.getParameter("chargeInstall4qua");
        if (chargeInstall4qua == null) {
            chargeInstall4qua = "";
        }
        String chargeInstall5 = request.getParameter("chargeInstall5");
        if (chargeInstall5 == null) {
            chargeInstall5 = "0";
        } else {
            chargeInstall5 = "1";
        }
        String chargeInstall5qua = request.getParameter("chargeInstall5qua");
        if (chargeInstall5qua == null) {
            chargeInstall5qua = "";
        }
        String chargeInstall6 = request.getParameter("chargeInstall6");
        if (chargeInstall6 == null) {
            chargeInstall6 = "0";
        } else {
            chargeInstall6 = "1";
        }
        String chargeInstall6qua = request.getParameter("chargeInstall6qua");
        if (chargeInstall6qua == null) {
            chargeInstall6qua = "";
        }
        String chargeInstall7 = request.getParameter("chargeInstall7");
        if (chargeInstall7 == null) {
            chargeInstall7 = "0";
        } else {
            chargeInstall7 = "1";
        }
        String chargeInstall7qua = request.getParameter("chargeInstall7qua");
        if (chargeInstall7qua == null) {
            chargeInstall7qua = "";
        }

        String guns = request.getParameter("guns");
        String others = request.getParameter("others");

        String Fromdate = request.getParameter("Fromdate");
        String Todate = request.getParameter("Todate");
        String budgetallocated = request.getParameter("budgetallocated");
        String othersDetails = request.getParameter("othersDetails");

        String ProjectProfile = request.getParameter("ProjectProfile");
        String profitcenter = request.getParameter("profitcenter");
        String CompanyCode = request.getParameter("CompanyCode");
        String Plant = request.getParameter("Plant");
        String ProjectType = request.getParameter("ProjectType");
        String ProjectCurrency = request.getParameter("ProjectCurrency");
        String InvestmentProfile = request.getParameter("InvestmentProfile");
        String Discom = request.getParameter("Discom");
        String ChargePoints = request.getParameter("ChargePoints");
        String NoOfCharger = request.getParameter("NoOfCharger");
        String overallstations = request.getParameter("overallstations");
        String stationAc = request.getParameter("stationAc");
        String stationDc = request.getParameter("stationDc");
        String stationname = request.getParameter("stationname");
        String stationtype = request.getParameter("stationtype");
        String tenant = request.getParameter("tenant");
        String connectiontype = request.getParameter("connectiontype");
        String approvalName = request.getParameter("approvalName");
        String chargingrate = request.getParameter("chargingrate");
        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
        String sitesurvey = request.getParameter("sitesurvey");
        String Survey = request.getParameter("Survey");
        if ("siteSurveynotcreated".equals(Survey)) {
            Survey = "0";
        } else {
            Survey = "1";
        }

        String projectTimelineCategory = request.getParameter("projectTimelineCategory");
        String totalKwRating = request.getParameter("totalKwRating");
        String specificDateFromClient = request.getParameter("specificDateFromClient");
        if (specificDateFromClient == null) {
            specificDateFromClient = "";
        }
        String totalChargerCapacity = request.getParameter("totalChargerCapacity");
        String chargerStationAccessType = request.getParameter("chargerStationAccessType");
        String auxiliaryLoadOfStation = request.getParameter("auxiliaryLoadOfStation");
        if (auxiliaryLoadOfStation == null) {
            auxiliaryLoadOfStation = "";
        }
        String chargingRetePerUnit = request.getParameter("chargingRetePerUnit");
        String noOfEvsToBeChanged = request.getParameter("noOfEvsToBeChanged");
        String chargeInstall8qua = request.getParameter("chargeInstall8qua");
        if (chargeInstall8qua == null) {
            chargeInstall8qua = "";
        }

        String chargeInstall8 = request.getParameter("chargeInstall8");
        if (chargeInstall8 == null) {
            chargeInstall8 = "0";
        } else {
            chargeInstall8 = "1";
        }
        String chargeInstall9qua = request.getParameter("chargeInstall9qua");
        if (chargeInstall9qua == null) {
            chargeInstall9qua = "";
        }
        String chargeInstall9 = request.getParameter("chargeInstall9");
        if (chargeInstall9 == null) {
            chargeInstall9 = "0";
        } else {
            chargeInstall9 = "1";
        }

        String anchoreCustomer = request.getParameter("anchoreCustomer");
        String canopyVarient = request.getParameter("canopyVarient");
        if (canopyVarient == null) {
            canopyVarient = "";
        }
        String scopeofChargeZone = request.getParameter("scopeofChargeZone");
        String totalMW = request.getParameter("totalMW");

//        String additionOfNewChargerCapacity = request.getParameter("additionOfNewChargerCapacity");
        OapForm oapForm = new OapForm();

        oapForm.setDocumentNo(refNo);
        oapForm.setPcsName(pcsName);
        oapForm.setDate(date);
        oapForm.setDocumentRevisionNo("R0");
        oapForm.setProjectName(projectName);
        oapForm.setPcsCityHighway(city_highway);
        oapForm.setPcsAddress(pcsAddress);
        oapForm.setPcsTypeCity(pcsType1);
        oapForm.setPcsTypeHighway(pcsType2);
        oapForm.setPcsTypeOtherCheck(pcsType3);
        oapForm.setPcsTypeOther(pcstypeother);
        oapForm.setPcsModelDoco(pcsModel);
        oapForm.setPcsModelCoco(pcsMode2);
        oapForm.setPcsModelDodo(pcsMode3);
        oapForm.setPcsModelOtherCheck(pcsMode4);
        oapForm.setPcsModelOther(pcsModelother);
        oapForm.setPcsModelSaas(pcsMode5);
        oapForm.setPcsCoordinates(pcscoordinates);
        oapForm.setMobileNo(mobileNo);
        oapForm.setEmail(email);
        oapForm.setAlternateMobileNo(alternatemobileNo);
        oapForm.setClientDetails(clientDetails);
        oapForm.setSpecificRequriementsClients(clientRequiremts);
        oapForm.setClientScope(clientscope);
        oapForm.setSalesLeadName(salesName);
        oapForm.setDepartment(department);
        oapForm.setDesignation(designation);
        oapForm.setSalesDate(date1);
        oapForm.setSignature("");

        oapForm.setKwAc77(chargeInstall1);
        oapForm.setKwAcQuatity77(chargeInstall1qua);
        oapForm.setKwDc15(chargeInstall2);
        oapForm.setKwDcQuatity15(chargeInstall2qua);
        oapForm.setKwDc30(chargeInstall3);
        oapForm.setKwDcQuatity30(chargeInstall3qua);
        oapForm.setKwDc60(chargeInstall4);
        oapForm.setKwDcQuatity60(chargeInstall4qua);
        oapForm.setKwDc120(chargeInstall5);
        oapForm.setKwDcQuatity120(chargeInstall5qua);

        oapForm.setKwDc180(chargeInstall6);
        oapForm.setKwDcQuatity180(chargeInstall6qua);
        oapForm.setKw240(chargeInstall7);
        oapForm.setKwQuatity240(chargeInstall7qua);

        oapForm.setNoOfGuns(guns);
        oapForm.setOthers(others);
        oapForm.setTimeLineFromDate(Fromdate);
        oapForm.setTimeLineToDate(Todate);
        oapForm.setProjectBudgetAllocated(budgetallocated);
        oapForm.setOthersDetails(othersDetails);

        oapForm.setOapMaster(oapMaster);
        oapForm.setCreatedDate(Fromdate);
        oapForm.setUserId(username1);
        oapForm.setCreatedDate(today);
        oapForm.setFlagStatus(1);
        oapForm.setAssignedName("");

        oapForm.setState(state5);
        oapForm.setCountry(country);
        oapForm.setCity(city);
        oapForm.setDistrict(district);
        oapForm.setHouseNo(houseno);
        oapForm.setProjectProfile(ProjectProfile);
        oapForm.setProjectCenter(profitcenter);
        oapForm.setCompanyCode(CompanyCode);
        oapForm.setPlant(Plant);
        oapForm.setProjectType(ProjectType);
        oapForm.setProjectCurrency(ProjectCurrency);
        oapForm.setInverstmentProfile(InvestmentProfile);
        oapForm.setDiscom(Discom);
        oapForm.setNoOfChargePoints(ChargePoints);
        oapForm.setNoOfCharger(NoOfCharger);
        oapForm.setOverallStationCapacityKw(overallstations);
        oapForm.setStationAcCapacityKw(stationAc);
        oapForm.setStationDcCapacityKw(stationDc);
        oapForm.setStationName(stationname);
        oapForm.setStationType(stationtype);
        oapForm.setTenant(tenant);
        oapForm.setConnectionType(connectiontype);
        oapForm.setChargingRatePerUnit(chargingrate);
        oapForm.setSiteSurvey(sitesurvey);
        oapForm.setSurveyRadio(Integer.parseInt(Survey));
        documentMasterId.setDocumentId(final_ten_no);
        oapForm.setProjectTimelineCategory(projectTimelineCategory);
        oapForm.setTotalKwRating(totalKwRating);
        oapForm.setSpecificDateFromClient(specificDateFromClient);
        oapForm.setTotalChargerCapacity(totalChargerCapacity);
        oapForm.setChargerStationAccessType(chargerStationAccessType);
        oapForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
        oapForm.setChargingRetePerUnit(chargingRetePerUnit);
        oapForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
//        oapForm.setAdditionOfNewChargerCapacity(additionOfNewChargerCapacity);
        oapForm.setKw360(chargeInstall8);
        oapForm.setKwQuatity360(chargeInstall8qua);
        oapForm.setKw720(chargeInstall9);
        oapForm.setKwQuatity720(chargeInstall9qua);
        oapForm.setAnchoreCustomer(anchoreCustomer);
        oapForm.setCanopyVarient(canopyVarient);
        oapForm.setScopeOfchargeZone(scopeofChargeZone);
        oapForm.setTotalMegaWatt(totalMW);

        oapFormService.create(oapForm);
        documentMasterIdService.create(documentMasterId);

        int id = oapForm.getId();
        String[] chargerType = request.getParameterValues("chargerType");
        String[] charger = request.getParameterValues("charger");
        String[] chargerOther = request.getParameterValues("chargerOther");
        String[] chargerCapacityKW = request.getParameterValues("chargerCapacityKW");
        String[] chargermodel = request.getParameterValues("chargermodel");
        String[] connectorType = request.getParameterValues("connectorType");
        String[] connectorOther = request.getParameterValues("connectorOther");
        String[] noofconnectors = request.getParameterValues("noofconnectors");
        String[] noofchargers = request.getParameterValues("noofchargers");
        String[] chargingrateperunit = request.getParameterValues("chargingrateperunit");

        for (int ct = 0; ct < chargerType.length; ct++) {
            String c = chargerType[ct];

            if (c != null && !c.isEmpty()) {
                ChargerInstallationDetails cid = new ChargerInstallationDetails();

                cid.setOapId(id);
                cid.setChargerType(chargerType[ct]);
                cid.setCharger(charger[ct]);
                cid.setChargerOther(chargerOther[ct]);
                cid.setChargerCapacityKW(chargerCapacityKW[ct]);
                cid.setChargermodel(chargermodel[ct]);
                cid.setConnectorType(connectorType[ct]);
                cid.setConnectorTypeOther(connectorOther[ct]);
                cid.setNoofconnectors(noofconnectors[ct]);
                cid.setNoofchargers(noofchargers[ct]);
                cid.setChargingrateperunit(chargingrateperunit[ct]);

                chargerInstallationDetailsService.create(cid);

            }
        }

        String documentno = oapForm.getDocumentNo();
        String mainusername = oapForm.getUserId();
        String mailcreteddate = oapForm.getCreatedDate();

        OapForm oapForm1 = oapFormService.readById(id);

        //        Agreement/LOA
        String pcsDelivery1 = request.getParameter("pcsDelivery1");
        if (pcsDelivery1 == null) {
            pcsDelivery1 = "0";
        } else {
            pcsDelivery1 = "1";
        }
        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile attachment1File = multipartRequest1.getFile("attachment1File");

        String attachment1FileName = "";
        if (attachment1File != null && !attachment1File.isEmpty()) {
            attachment1FileName = attachment1File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm1.getId() + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment1FileName);
            attachment1File.transferTo(destinationFile);
        }

        String pcsDelivery2 = request.getParameter("pcsDelivery2");
        if (pcsDelivery2 == null) {
            pcsDelivery2 = "0";
        } else {
            pcsDelivery2 = "1";
        }

//        Ownership Document
        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile attachment2File = multipartRequest2.getFile("attachment2File");
        String attachment2FileName = "";
        if (attachment2File != null && !attachment2File.isEmpty()) {
            attachment2FileName = attachment2File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm1.getId() + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment2FileName);
            attachment2File.transferTo(destinationFile);
        }

        String pcsDelivery3 = request.getParameter("pcsDelivery3");
        if (pcsDelivery3 == null) {
            pcsDelivery3 = "0";
        } else {
            pcsDelivery3 = "1";
        }
//        Preliminary Site Survey
        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile attachment3File = multipartRequest3.getFile("attachment3File");
        String attachment3FileName = "";
        if (attachment3File != null && !attachment3File.isEmpty()) {
            attachment3FileName = attachment3File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm1.getId() + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment3FileName);
            attachment3File.transferTo(destinationFile);
        }

        String pcsDelivery4 = request.getParameter("pcsDelivery4");
        if (pcsDelivery4 == null) {
            pcsDelivery4 = "0";
        } else {
            pcsDelivery4 = "1";
        }
//        Consent Letter/NOC
        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile attachment4File = multipartRequest4.getFile("attachment4File");
        String attachment4FileName = "";
        if (attachment4File != null && !attachment4File.isEmpty()) {
            attachment4FileName = attachment4File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm1.getId() + File.separator;

            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File destinationFile = new File(fileLocationURL + attachment4FileName);
            attachment4File.transferTo(destinationFile);
        }
        oapForm1.setAgreementLoa(pcsDelivery1);
        oapForm1.setOwnerShipDocument(pcsDelivery2);
        oapForm1.setPreliminarySiteSurvey(pcsDelivery3);
        oapForm1.setConsentLetterNoc(pcsDelivery4);
        oapForm1.setAggrementAttach(attachment1FileName);
        oapForm1.setOwnershipAttach(attachment2FileName);
        oapForm1.setPreliminaryAttach(attachment3FileName);
        oapForm1.setConsentAttach(attachment4FileName);

        oapFormService.update(oapForm1);

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");

        int mailCount = 0;   // separate counter
        String surveyno = null;

        for (int i = 0; i < surveyNo.length; i++) {
            String s = surveyNo[i];

            if (s != null && !s.isEmpty()) {
                OapSurveyAttachment oapSurveyAttachment = new OapSurveyAttachment();
                oapSurveyAttachment.setSurveyNo(surveyNo[i]);
                oapSurveyAttachment.setProjectRepresentative(projectRepresentative[i]);
                oapSurveyAttachment.setOapId(id);
                oapSurveyAttachmentService.create(oapSurveyAttachment);

                surveyno = oapSurveyAttachment.getSurveyNo();

                List list420 = userRightsService.readByDesignManager();

                for (Object o : list420) {
                    String userid = null;

                    if (o instanceof UserRights) {
                        userid = ((UserRights) o).getUsername();
                    } else if (o instanceof Object[]) {
                        Object[] row = (Object[]) o;

                        if (row[0] != null) {
                            userid = row[1].toString();
                        }
                    } else if (o instanceof String) {

                        userid = (String) o;
                    }

                    if (userid != null) {
                        EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
                        String mail_to = employeeMaster2.getEmailId();

                        EmailTemplate emailTemplate = emailTemplateService.readById(199);
                        String mail_from = "";

                        String subject = emailTemplate.getSubject();
                        String msg = emailTemplate.getBodytext();

                        String Oap_form = "OAP Form";

                        msg = msg.replaceAll("\\{Oap_form\\}", surveyno);
                        msg = msg.replaceAll("\\{documentno\\}", documentno);
                        msg = msg.replaceAll("\\{username\\}", mainusername);
                        msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

                        SendMail s1 = new SendMail();
                        s1.sendMail(mail_from, mail_to, subject, msg);
                    }
                }

            }
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

// Get all uploaded files
        List<MultipartFile> files = multipartRequest.getFiles("attchment");
        String[] id1 = request.getParameterValues("id");
        String[] descriptions = request.getParameterValues("descriptiones");
        int i = 0;
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP"
                            + File.separator + id + File.separator;

                    // Create the directory if it doesn't exist
                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    DocumentName documentName = documentNameService.readById(Integer.parseInt(id1[i]));

                    File destinationFile = new File(fileLocationURL + file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));

                    file.transferTo(destinationFile);

                    // Create the attachment object and save it
                    OapDocumentAttachment oapDocumentAttachment = new OapDocumentAttachment();
                    oapDocumentAttachment.setAttachment(file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));

                    oapDocumentAttachment.setOapForm(oapForm1);
                    oapDocumentAttachment.setDescription(descriptions[i]);

                    oapDocumentAttachment.setDocumentName(documentName);

                    oapDocumentAttachmentService.create(oapDocumentAttachment);
                    i++;
                }
            }
        }

        // multi attachment
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + id;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP"
                            + File.separator + id + File.separator;

                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs(); // Create the directory if it doesn't exist
                    }

                    File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    try {
                        file1.transferTo(destinationFile1); // Ensure proper exception handling
                    } catch (Exception e) {
                        e.printStackTrace(); // Handle the error or log it
                    }

                    OapMultiAttachment oapMultiAttachment = new OapMultiAttachment();

                    oapMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    oapMultiAttachment.setDescription(description[a]);
                    oapMultiAttachment.setOapForm(oapForm1);

                    oapMultiAttachmentService.create(oapMultiAttachment);
                    a++;
                }
            }

        }

        // approval name drop down relted code
        List approval_list = oapMasterUserService.readByIdToList(approvalName);
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        OapFormApproval oapFormApproval = new OapFormApproval();
        oapFormApproval.setOapForm(oapForm1);
        oapFormApproval.setTotalApproval(approval_list.size() + "");
        oapFormApproval.setApprovalStatus("0");
        oapFormApproval.setApprovalRemark("add");
        oapFormApproval.setUserId(employeeCode);
        oapFormApproval.setCurrentApproval("1");
        oapFormApprovalService.create(oapFormApproval);

        int approveId = oapFormApproval.getId();
        OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

        int j = 0;

        List<String> list = new ArrayList<>();

        for (Object o : approval_list) {
            j++;
            OapMasterUser oap1 = (OapMasterUser) o;
            OapFormApprovalUser oap = new OapFormApprovalUser();
            oap.setOapFormApproval(approveId);
            oap.setOapForm(id);
            oap.setUserId(oap1.getUserId());
            list.add(oap1.getUserId());
            oap.setLevel("1");
            oap.setApprovalStatus("0");
            oapFormApprovalUserService.create(oap);

            String userid = oap.getUserId();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(30);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Oap_form = "OAP Form";

            msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{pcsname\\}", oapForm.getPcsName());
            msg = msg.replaceAll("\\{username\\}", mainusername);
            msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

        }
        EmployeeMaster employeeMaster5 = employeeMasterService.readUser(mainusername);
        String mail_to5 = employeeMaster5.getEmailId();

        EmailTemplate emailTemplate1 = emailTemplateService.readById(96);
        String mail_from5 = "";

        String subject5 = emailTemplate1.getSubject();
        String msg5 = emailTemplate1.getBodytext();

        String Oap_form5 = "OAP Form Created";

        msg5 = msg5.replaceAll("\\{Oap_form\\}", Oap_form5);
        msg5 = msg5.replaceAll("\\{documentno\\}", documentno);
        msg5 = msg5.replaceAll("\\{pcsname\\}", oapForm.getPcsName());
        msg5 = msg5.replaceAll("\\{username\\}", mainusername);
        msg5 = msg5.replaceAll("\\{createddate\\}", mailcreteddate);

        StringBuilder approvers = new StringBuilder();
        for (String listData : list) {
            approvers.append(listData).append(", "); // or use line breaks
        }
        if (approvers.length() > 0) {
            approvers.setLength(approvers.length() - 2);
        }
        msg5 = msg5.replaceAll("\\{approvalpersons\\}", approvers.toString());

        SendMail s1 = new SendMail();
        s1.sendMail(mail_from5, mail_to5, subject5, msg5);

        OapLogMaster oapLogMaster = new OapLogMaster();
        oapLogMaster.setActivity("OAP Created");
        oapLogMaster.setActivityBy(username1);
        oapLogMaster.setDate(currentDateTime5);
        oapLogMaster.setComments("");
        oapLogMaster.setStatus("Created");
        oapLogMaster.setOapId(id);
        oapLogMasterService.create(oapLogMaster);

        session.setAttribute("successMessage", "OAPForm Created successfully");
        mv.setViewName("redirect:oapForm.htm?act=oapFormAppovalList");
        return mv;
    }

    public ModelAndView DocumentList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

//	DocumentName documentName = new DocumentName();
        List list = documentNameService.readAll();
//	List list = documentNameService.readByall();

        request.setAttribute("list", list);
//	mv.getModelMap().put("documentName", documentName);

        mv.setViewName("Vendor/DocumentList");
        return mv;
    }

    public ModelAndView DocumentCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List list = companyLocationService.read();
        mv.getModelMap().put("list", list);
        List list2 = discomMasterService.read();
        List list3 = connectionTypeService.read();

        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("list3", list3);
        mv.setViewName("Vendor/DocumentCreate");
        return mv;
    }

    public ModelAndView DocumentCreateSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String State = request.getParameter("documentname");
        String discom = request.getParameter("discom");
        String connection = request.getParameter("connectiontype");

        String[] Documentname = request.getParameterValues("attach");
        String[] compalsuary = request.getParameterValues("descriptions");
        DocumentName documentName = new DocumentName();
        try {

            for (int i = 0; i < Documentname.length; i++) {
                documentName.setDocumentName(Documentname[i]);
                documentName.setCompalsuary(compalsuary[i]);
                documentName.setState(State);
                documentName.setDiscomId((Integer.parseInt(discom)));
                documentName.setConnectionTypeId((Integer.parseInt(connection)));

                documentNameService.create(documentName);
            }

        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        request.setAttribute("successMessage", " Document Created successfully");
        mv = DocumentList(request, response);
        return mv;
    }

    public ModelAndView DocumentEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//	List list = companyLocationService.read();
//	mv.getModelMap().put("list", list);

        List list2 = discomMasterService.read();
        List list3 = connectionTypeService.read();
//        List list = companyLocationService.read();
        String id = request.getParameter("id");
        // Retrieve the document name object based on the provided ID
        DocumentName documentName = documentNameService.readById(Integer.parseInt(id));

        int discom1 = documentName.getDiscomId();
        int connection = documentName.getConnectionTypeId();
        DiscomMaster discomMaster = discomMasterService.readById(discom1);
        String Discom = discomMaster.getDiscomType();
        ConnectionType connectionType = connectionTypeService.readById(connection);
        String connection1 = connectionType.getConnectionType();
        String state = documentName.getState();

        List list4 = documentNameService.readyBydisconn(discom1, connection);

//	String state = documentName.getState();
//	List list1 = documentNameService.readBystate(state);
//	mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("state", state);
//        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("list3", list3);
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("Discom", Discom);
        mv.getModelMap().put("connection1", connection1);
        mv.getModelMap().put("discom1", discom1);
        mv.getModelMap().put("connection", connection);
        mv.getModelMap().put("state", state);

        mv.getModelMap().put("documentName", documentName);

        mv.setViewName("Vendor/DocumentEdit");
        return mv;
    }

    public ModelAndView DocumentEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String State = request.getParameter("documentname");
        String discom = request.getParameter("discom1id");
        String connection = request.getParameter("connectionid");

        DocumentName documentName2 = documentNameService.readById(Integer.parseInt(id));
        documentName2.setState(State);
        documentName2.setDiscomId((Integer.parseInt(discom)));
        documentName2.setConnectionTypeId((Integer.parseInt(connection)));

        documentNameService.update(documentName2);

        String[] Documentname = request.getParameterValues("attach");
        String[] compalsuary = request.getParameterValues("descriptions");
        DocumentName documentName = new DocumentName();
        try {

            if (Documentname != null && compalsuary != null) {
                for (int i = 0; i < Documentname.length; i++) {
                    documentName.setDocumentName(Documentname[i]);
                    documentName.setCompalsuary(compalsuary[i]);
                    documentName.setState(State);
                    documentName.setDiscomId((Integer.parseInt(discom)));
                    documentName.setConnectionTypeId((Integer.parseInt(connection)));

                    documentNameService.create(documentName);
                }
            } else {
                System.err.println("Document names or compulsory statuses are missing.");
            }

        } catch (NumberFormatException e) {
            System.err.println("Invalid ID format: " + id);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.getModelMap().put("documentName", documentName);

        request.setAttribute("successMessage", " DocumentName edit successfully");
        mv = DocumentList(request, response);

        return mv;
    }

    public ModelAndView delete1(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");
        documentNameService.delete(Integer.parseInt(id));
        mv.setViewName("forward:oapForm.htm?act=DocumentEdit&id=" + id1);
        return mv;
    }

    public ModelAndView deleteDocument(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            documentNameService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage",
                " One or more data deleted successfully");
        mv = DocumentList(request, response);
        return mv;
    }

    public ModelAndView OapApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Oap/OapApproval");
        return mv;
    }

    public ModelAndView OapApprovalView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username = user1.getLoginName();

        String id = request.getParameter("id");
        String oapFormId = request.getParameter("oapFormId");
        String oapFormattach = request.getParameter("oapFormattach");
        String oapFormmulti = request.getParameter("oapFormmulti");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(oapFormId));
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(oapFormId);

        List list = oapDocumentAttachmentService.readByattach(oapFormattach);
        List list33 = oapMultiAttachmentService.readByMulti(oapFormmulti);
        OapFormApproval oapApproval = oapFormApprovalService.readById(Integer.parseInt(id));

        List oapApproval1 = oapFormApprovalService.readByIds(id);

        List chargeInst = chargerInstallationDetailsService.readByoapId(oapFormId);

        OapForm list55 = oapFormService.readById(Integer.parseInt(oapFormId));
        int oapid = Integer.parseInt(oapFormId);

        List oapuserapprovals = oapFormApprovalUserService.readByoapid(oapid);
        List comments = oapFormApprovalCommentService.readByIds(oapFormId);

        List Activitymile = oapLogMasterService.readByOapId(oapFormId);

        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = new DiscomMaster();
        if (discom != null && !discom.equals("")) {
            discomMaster = discomMasterService.readById(Integer.parseInt(discom));
            String Discom1 = discomMaster.getDiscomType();
            mv.getModelMap().put("Discom1", Discom1);
        }

        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = new ConnectionType();
        if (connectionType != null && !connectionType.equals("")) {
            connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
            String connection = connectionType1.getConnectionType();

            mv.getModelMap().put("connection", connection);
        }

        mv.getModelMap().put("list10", oapuserapprovals);
        mv.getModelMap().put("list11", comments);
        mv.getModelMap().put("oaplogmaster", Activitymile);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", list55);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list1", oapApproval1);
        mv.getModelMap().put("list8", oapApproval);
        mv.getModelMap().put("chargeInst", chargeInst);

        if (session1 != null) {
            String successMessage = (String) session1.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session1.removeAttribute("successMessage"); // clean up after showing
            }
        }
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.setViewName("Oap/OapApprovalView");
        return mv;
    }

    public ModelAndView OapApproveButton(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        OapFormApproval oapApproval = oapFormApprovalService.readById(Integer.parseInt(id));
        OapFormApprovalUser oapApprovalUser = oapFormApprovalUserService.readByIdAndUsername(id, username);

        String approvalStatus = oapApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {
            int oapapprovalid = oapApproval.getId();

            int oapformid = oapApproval.getOapForm().getId();

            OapForm oapForm = oapFormService.readById(oapformid);
            String documentno = oapForm.getDocumentNo();
            int oapFormid = oapApproval.getId();

            OapFormApprovalUser oapFormApprovalUser = oapFormApprovalUserService.appvals(username, id);
            int oapid = oapFormApprovalUser.getOapForm();

            int approvalid = oapApproval.getId();

            OapFormApprovalComment oapFormApprovalComment1 = oapFormApprovalCommentService.readByApproveId(approvalid);

            String totalApproval = oapApproval.getTotalApproval();

            String ca = oapApproval.getCurrentApproval();
            String totalApprovals = oapApproval.getTotalApproval();
            if (ca.equals(totalApprovals)) {
                oapForm.setApprovedBy(username);
                oapForm.setApprovedDate(today);
            }
            oapApproval.setApprovalStatus("1");
            oapApproval.setCurrentApproval("1");
            oapFormApprovalUser.setApprovalStatus("1");
            oapFormApprovalComment1.setApprovalStatus("1");
            oapApproval.setCurrentApproval("1");
            oapFormApprovalService.update(oapApproval);
            oapFormApprovalUserService.update(oapFormApprovalUser);
            List allUserList = oapFormApprovalUserService.readByDleteCode(approvalid);
            String flag = "0";
            for (Object o : allUserList) {
                OapFormApprovalUser oapFormApprovalUser1 = (OapFormApprovalUser) o;
                String approvalstatus = oapFormApprovalUser1.getApprovalStatus();
                if (approvalstatus.equals("1")) {
                    flag = "1";
                } else {
                    flag = "0";
                    break;
                }

            }
            if (flag.equals("1")) {
                oapForm.setFlagStatus(4);
                oapApproval.setApprovalStatus("1");
            }

            String level = oapFormApprovalUser.getLevel();

            EmployeeMaster employeeMaster1 = employeeMasterService.read(username);
            String employeeCode = employeeMaster1.getEmployeeCode();
            oapFormApprovalComment1.setApprovalComment(comment);
            oapFormApprovalComment1.setUserId(username);
            oapFormApprovalComment1.setOapFormApproval(oapapprovalid);
            oapFormApprovalComment1.setApprovalStatus("1");
            oapFormApprovalComment1.setOapForm(oapformid);

            oapFormApprovalCommentService.create(oapFormApprovalComment1);
            oapFormService.update(oapForm);

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(33);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            String Oap_form = "OAP Form";

            msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{pcsname\\}", oapForm.getPcsName());
            msg = msg.replaceAll("\\{username\\}", username);
            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            OapFormApprovalUser oapFormApprovalUser1 = new OapFormApprovalUser();

            List userid = oapFormApprovalUserService.readByoapid(oapid);
            for (Object pdf1 : userid) {

                oapFormApprovalUser1 = (OapFormApprovalUser) pdf1;

                if (!oapFormApprovalUser1.getUserId().equals(username)) {
                    String fgrId = oapFormApprovalUser1.getUserId();
                    EmployeeMaster employeeMaster5 = employeeMasterService.readUser(fgrId);

                    if (employeeMaster5 != null && employeeMaster5.getEmailId() != null && !employeeMaster5.getEmailId().isEmpty()) {

                        String mail_to5 = employeeMaster5.getEmailId();

                        EmailTemplate emailTemplate1 = emailTemplateService.readById(97);
                        String mail_from5 = "";

                        String subject5 = emailTemplate1.getSubject();
                        String msg5 = emailTemplate1.getBodytext();

                        String Oap_form5 = "Approval Person OAP Form Approved";

                        msg5 = msg5.replaceAll("\\{Oap_form\\}", Oap_form5);
                        msg5 = msg5.replaceAll("\\{documentno\\}", documentno);
                        msg5 = msg5.replaceAll("\\{pcsname\\}", oapForm.getPcsName());
                        msg5 = msg5.replaceAll("\\{username\\}", username);
                        msg5 = msg5.replaceAll("\\{Approveddate\\}", currentDateTime5);

                        SendMail s1 = new SendMail();
                        s1.sendMail(mail_from5, mail_to5, subject5, msg5);

                        List approvalsize = oapFormApprovalUserService.readByapprovalStatus(oapid + "");
                        if (approvalsize.size() == 0) {
                            List EHrights = userRightsService.readByexecutiveHead();
                            UserRights userRights = new UserRights();
                            for (Object pdf2 : EHrights) {
                                userRights = (UserRights) pdf2;
                                int EH = userRights.getExecutiveHead();
                                String usernemesEh = userRights.getUsername();
                                if (EH == 1) {

                                    EmployeeMaster employeeMaster7 = employeeMasterService.readUser(usernemesEh);
                                    String mail_to7 = employeeMaster7.getEmailId();

                                    EmailTemplate emailTemplate7 = emailTemplateService.readById(99);
                                    String mail_from7 = "";

                                    String subject7 = emailTemplate7.getSubject();
                                    String msg7 = emailTemplate7.getBodytext();

                                    String Oap_form7 = "All Approval are Completed";

                                    msg7 = msg7.replaceAll("\\{Oap_form\\}", Oap_form7);
                                    msg7 = msg7.replaceAll("\\{pcsname\\}", oapForm.getPcsName());
                                    msg7 = msg7.replaceAll("\\{documentno\\}", documentno);

//                                msg7 = msg7.replaceAll("\\{username\\}", mainusername);
                                    msg7 = msg7.replaceAll("\\{finalapproveddate\\}", currentDateTime5);

                                    SendMail s7 = new SendMail();
                                    s7.sendMail(mail_from7, mail_to7, subject7, msg7);
                                }
                            }
                        }

                    }
                }
            }
            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("Approval");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Approved");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(oapformid);
            oapLogMasterService.create(oapLogMaster);

            session.setAttribute("successMessage", " OAP Approval Approved successfully");

        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "OAP Approval Already Approved Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "OAP Approval Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "OAP Approval Already Rejected Successfully");
        } else {
            session.setAttribute("failureMessage", "The OAP Approval Has Already Progressed To The Next Stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=OapApproval");

        return mv;

    }

    public ModelAndView oapFormAppovalList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
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

        mv.setViewName("Oap/oapFormAppovalList");
        return mv;
    }

    public ModelAndView oapFormApprovalMatrixview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        String oapFormattach = request.getParameter("oapFormattach");
        String oapFormmulti = request.getParameter("oapFormmulti");
        List oaplogmaster = oapLogMasterService.readByOapId(id);
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);
        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);

        List chargeInst = chargerInstallationDetailsService.readByoapId(id);

        OapFormApproval oapFormApproval = oapFormApprovalService.readByoapappid(id);
        int approveid = oapFormApproval.getId();

        List list0 = oapFormApprovalUserService.readByapprovalStatus(id);
        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", oapForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("chargeInst", chargeInst);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("oaplogmaster", oaplogmaster);
        mv.setViewName("Oap/oapFormApprovalMatrixview");
        return mv;
    }

    public ModelAndView oapFormEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

//	String oapFormattach = request.getParameter("oapFormattach");
//	String oapFormmulti = request.getParameter("oapFormmulti");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        String Tenant = oapForm.getTenant();
        String StationType = oapForm.getStationType();
        String Currency = oapForm.getProjectCurrency();
        String ProjectType = oapForm.getProjectType();
        String Ivestmentprofile = oapForm.getInverstmentProfile();
        String ProjectCenter = oapForm.getProjectCenter();
        String CompanyCode = oapForm.getCompanyCode();
        String ProjectProfile = oapForm.getProjectProfile();
        String Discom = oapForm.getDiscom();
        String plant = oapForm.getPlant();
        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();

        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);
        mv.getModelMap().put("Discom", Discom);
        mv.getModelMap().put("ProjectProfile", ProjectProfile);
        mv.getModelMap().put("CompanyCode", CompanyCode);
        mv.getModelMap().put("ProjectCenter", ProjectCenter);
        mv.getModelMap().put("Ivestmentprofile", Ivestmentprofile);
        mv.getModelMap().put("ProjectType", ProjectType);
        mv.getModelMap().put("Currency", Currency);
        mv.getModelMap().put("StationType", StationType);
        mv.getModelMap().put("Tenant", Tenant);
        mv.getModelMap().put("plant", plant);

        int oapmasterId = oapForm.getOapMaster().getId();
        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);
        List list10 = oapMasterService.read();
//	List list1 = documentNameService.readAll();
        mv.getModelMap().put("oapForm", oapForm);
        String state = oapForm.getState();

        List list0 = tenantService.read();
        List list2 = stationTypeService.read();
        List list3 = currencyMasterService.read();
        List list4 = projectTypeService.read();
        List list6 = investmentProfileService.read();
        List list7 = profitCenterService.read();
        List list8 = plantMastersService.read();
        List list9 = companyMasterService.read();
        List list11 = projectProfileService.read();
        List list12 = discomMasterService.read();

        request.setAttribute("list0", list0);
        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);
        request.setAttribute("list4", list4);
        request.setAttribute("list6", list6);
        request.setAttribute("list7", list7);
        request.setAttribute("list8", list8);
        request.setAttribute("list9", list9);
        request.setAttribute("list11", list11);
        request.setAttribute("list12", list12);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("oapmasterId", oapmasterId);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list10", list10);
//	request.setAttribute("list1", list1);
        mv.getModelMap().put("state", state);
        mv.setViewName("Oap/oapFormAppovalListEdit");
        return mv;
    }

    public ModelAndView oapFormdocuDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        String id1 = request.getParameter("id1");
        String id = request.getParameter("id");

        oapDocumentAttachmentService.delete(Integer.parseInt(id1));

        session.setAttribute("successMessage",
                " One or more data deleted successfully");
        mv.getModelMap().put("id1", id1);
        mv.getModelMap().put("id", id);

        mv.setViewName("redirect:oapForm.htm?act=oaprecycleEdit&id=" + id);

        return mv;
    }

    public ModelAndView oapFormdocuDelete1(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        String id1 = request.getParameter("id1");
        String id = request.getParameter("id");

        oapMultiAttachmentService.delete(Integer.parseInt(id1));

        session.setAttribute("successMessage",
                " One or more data deleted successfully");
        mv.getModelMap().put("id1", id1);
        mv.getModelMap().put("id", id);
        mv.setViewName("redirect:oapForm.htm?act=oaprecycleEdit&id=" + id);

        return mv;
    }

    public ModelAndView oapFormEditsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        String documentNo = request.getParameter("documentNo");
        String pcsName = request.getParameter("pcsName");
        String date = request.getParameter("date");
        String documentRevisonNo = request.getParameter("documentRevisonNo");
        String projectName = request.getParameter("projectName");
        String city_highway = request.getParameter("city/highway");
        String pcsAddress = request.getParameter("pcsAddress");
        String pcsType1 = request.getParameter("pcsType1");
        if (pcsType1 == null) {
            pcsType1 = "0";
        } else {
            pcsType1 = "1";
        }
        String pcsType2 = request.getParameter("pcsType2");
        if (pcsType2 == null) {
            pcsType2 = "0";
        } else {
            pcsType2 = "1";
        }
        String pcsType3 = request.getParameter("pcsType3");
        if (pcsType3 == null) {
            pcsType3 = "0";
        } else {
            pcsType3 = "1";
        }
        String pcstypeother = request.getParameter("pcstypeother");
        if (pcstypeother == null) {
            pcstypeother = "";
        }
        String pcsModel = request.getParameter("pcsModel");
        if (pcsModel == null) {
            pcsModel = "0";
        } else {
            pcsModel = "1";
        }
        String pcsMode2 = request.getParameter("pcsMode2");
        if (pcsMode2 == null) {
            pcsMode2 = "0";
        } else {
            pcsMode2 = "1";
        }
        String pcsMode3 = request.getParameter("pcsMode3");
        if (pcsMode3 == null) {
            pcsMode3 = "0";
        } else {
            pcsMode3 = "1";
        }
        String pcsMode4 = request.getParameter("pcsMode4");
        if (pcsMode4 == null) {
            pcsMode4 = "0";
        } else {
            pcsMode4 = "1";
        }
        String pcsModelother = request.getParameter("pcsModelother");
        if (pcsModelother == null) {
            pcsModelother = "";
        }
        String pcscoordinates = request.getParameter("pcscoordinates");
        String mobileNo = request.getParameter("mobileNo");
        String email = request.getParameter("email");
        String alternatemobileNo = request.getParameter("alternatemobileNo");
        String clientDetails = request.getParameter("clientDetails");
        String clientRequiremts = request.getParameter("clientRequiremts");
        String scope = request.getParameter("scope");
        String salesName = request.getParameter("salesName");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String date1 = request.getParameter("date1");

        String pcsDelivery1 = request.getParameter("pcsDelivery1");
        if (pcsDelivery1 == null) {
            pcsDelivery1 = "0";
        }

        String attachment1File1 = request.getParameter("attachment1File1");

        if (pcsDelivery1.equals("0")) {
            attachment1File1 = "";
        }

        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile attachment1File = multipartRequest1.getFile("attachment1File");

        String attachment1FileName = "";
        if (attachment1File != null && !attachment1File.isEmpty()) {
            attachment1FileName = attachment1File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment1FileName);
            attachment1File.transferTo(destinationFile);
        }
        if (attachment1FileName.equals("") || attachment1FileName == "") {
            attachment1FileName = attachment1File1;
        }

        String pcsDelivery2 = request.getParameter("pcsDelivery2");
        if (pcsDelivery2 == null) {
            pcsDelivery2 = "0";
        }
        String attachment2File2 = request.getParameter("attachment2File2");

        if (pcsDelivery2.equals("0")) {
            attachment2File2 = "";
        }

        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile attachment2File = multipartRequest2.getFile("attachment2File");
        String attachment2FileName = "";
        if (attachment2File != null && !attachment2File.isEmpty()) {
            attachment2FileName = attachment2File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment2FileName);
            attachment2File.transferTo(destinationFile);
        }
        if (attachment2FileName.equals("") || attachment2FileName == "") {
            attachment2FileName = attachment2File2;
        }

        String pcsDelivery3 = request.getParameter("pcsDelivery3");
        if (pcsDelivery3 == null) {
            pcsDelivery3 = "0";
        }
        String attachment3File3 = request.getParameter("attachment3File3");

        if (pcsDelivery3.equals("0")) {
            attachment3File3 = "";
        }

        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile attachment3File = multipartRequest3.getFile("attachment3File");
        String attachment3FileName = "";
        if (attachment3File != null && !attachment3File.isEmpty()) {
            attachment3FileName = attachment3File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment3FileName);
            attachment3File.transferTo(destinationFile);
        }
        if (attachment3FileName.equals("") || attachment3FileName == "") {
            attachment3FileName = attachment3File3;
        }

        String pcsDelivery4 = request.getParameter("pcsDelivery4");
        if (pcsDelivery4 == null) {
            pcsDelivery4 = "0";
        }
        String attachment4File4 = request.getParameter("attachment4File4");

        if (pcsDelivery4.equals("0")) {
            attachment4File4 = "";
        }

        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile attachment4File = multipartRequest4.getFile("attachment4File");
        String attachment4FileName = "";
        if (attachment4File != null && !attachment4File.isEmpty()) {
            attachment4FileName = attachment4File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment4FileName);
            attachment4File.transferTo(destinationFile);
        }
        if (attachment4FileName.equals("") || attachment4FileName == "") {
            attachment4FileName = attachment4File4;
        }

        String chargeInstall1 = request.getParameter("chargeInstall1");
        if (chargeInstall1 == null) {
            chargeInstall1 = "0";
        } else {
            chargeInstall1 = "1";
        }
        String chargeInstall1qua = request.getParameter("chargeInstall1qua");
        if (chargeInstall1qua == null) {
            chargeInstall1qua = "";
        }
        String chargeInstall2 = request.getParameter("chargeInstall2");
        if (chargeInstall2 == null) {
            chargeInstall2 = "0";
        } else {
            chargeInstall2 = "1";
        }
        String chargeInstall2qua = request.getParameter("chargeInstall2qua");
        if (chargeInstall2qua == null) {
            chargeInstall2qua = "";
        }
        String chargeInstall3 = request.getParameter("chargeInstall3");
        if (chargeInstall3 == null) {
            chargeInstall3 = "0";
        } else {
            chargeInstall3 = "1";
        }
        String chargeInstall3qua = request.getParameter("chargeInstall3qua");
        if (chargeInstall3qua == null) {
            chargeInstall3qua = "";
        }
        String chargeInstall4 = request.getParameter("chargeInstall4");
        if (chargeInstall4 == null) {
            chargeInstall4 = "0";
        } else {
            chargeInstall4 = "1";
        }
        String chargeInstall4qua = request.getParameter("chargeInstall4qua");
        if (chargeInstall4qua == null) {
            chargeInstall4qua = "";
        }
        String chargeInstall5 = request.getParameter("chargeInstall5");
        if (chargeInstall5 == null) {
            chargeInstall5 = "0";
        } else {
            chargeInstall5 = "1";
        }
        String chargeInstall5qua = request.getParameter("chargeInstall5qua");
        if (chargeInstall5qua == null) {
            chargeInstall5qua = "";
        }
        String chargeInstall6 = request.getParameter("chargeInstall6");
        if (chargeInstall6 == null) {
            chargeInstall6 = "0";
        } else {
            chargeInstall6 = "1";
        }
        String chargeInstall6qua = request.getParameter("chargeInstall6qua");
        if (chargeInstall6qua == null) {
            chargeInstall6qua = "";
        }
        String chargeInstall7 = request.getParameter("chargeInstall7");
        if (chargeInstall7 == null) {
            chargeInstall7 = "0";
        } else {
            chargeInstall7 = "1";
        }
        String chargeInstall7qua = request.getParameter("chargeInstall7qua");
        if (chargeInstall7qua == null) {
            chargeInstall7qua = "";
        }

        String guns = request.getParameter("guns");
        String others = request.getParameter("others");
        String Fromdate = request.getParameter("Fromdate");
        String Todate = request.getParameter("Todate");
        String budgetallocated = request.getParameter("budgetallocated");
        String othersDetails = request.getParameter("othersDetails");
        String country = request.getParameter("country");
        String state5 = request.getParameter("state5");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String houseno = request.getParameter("houseno");
        String ProjectProfile = request.getParameter("ProjectProfile");
        String profitcenter = request.getParameter("profitcenter");
        String CompanyCode = request.getParameter("CompanyCode");
        String Plant = request.getParameter("plant");
        String ProjectType = request.getParameter("ProjectType");
        String ProjectCurrency = request.getParameter("ProjectCurrency");
        String InvestmentProfile = request.getParameter("InvestmentProfile");
//	String Discom = request.getParameter("Discom");
        String ChargePoints = request.getParameter("ChargePoints");
        String NoOfCharger = request.getParameter("NoOfCharger");
        String overallstations = request.getParameter("overallstations");
        String stationAc = request.getParameter("stationAc");
        String stationDc = request.getParameter("stationDc");
        String stationname = request.getParameter("stationname");
        String stationtype = request.getParameter("stationtype");
        String tenant = request.getParameter("tenant");
        String chargingrate = request.getParameter("chargingrate");
//	String approvalName = request.getParameter("approvalName");
//	OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        oapForm.setDocumentNo(documentNo);
        oapForm.setPcsName(pcsName);
        oapForm.setDate(date);
        // Assuming this is your existing line of code
        oapForm.setDocumentRevisionNo(documentRevisonNo);

// Add the following logic before this line
        if (documentRevisonNo == null || documentRevisonNo.isEmpty()) {
            documentRevisonNo = "R0"; // Default to R0 if null or empty
        } else {
            // Increment the revision number
            String numericPart = documentRevisonNo.substring(1);
            try {
                int revisionNumber = Integer.parseInt(numericPart) + 1;
                documentRevisonNo = "R" + revisionNumber; // Update to the next revision
            } catch (NumberFormatException e) {
                documentRevisonNo = "R0"; // Reset to R0 if parsing fails
            }
        }

// Then set the updated value as usual
        oapForm.setDocumentRevisionNo(documentRevisonNo);

        oapForm.setProjectName(projectName);
        oapForm.setPcsCityHighway(city_highway);
        oapForm.setPcsAddress(pcsAddress);
        oapForm.setPcsTypeCity(pcsType1);
        oapForm.setPcsTypeHighway(pcsType2);
        oapForm.setPcsTypeOtherCheck(pcsType3);
        oapForm.setPcsTypeOther(pcstypeother);
        oapForm.setPcsModelDoco(pcsModel);
        oapForm.setPcsModelCoco(pcsMode2);
        oapForm.setPcsModelDodo(pcsMode3);
        oapForm.setPcsModelOtherCheck(pcsMode4);
        oapForm.setPcsModelOther(pcsModelother);
        oapForm.setPcsCoordinates(pcscoordinates);
        oapForm.setMobileNo(mobileNo);
        oapForm.setEmail(email);
        oapForm.setAlternateMobileNo(alternatemobileNo);
        oapForm.setClientDetails(clientDetails);
        oapForm.setSpecificRequriementsClients(clientRequiremts);
        oapForm.setClientScope(scope);
        oapForm.setSalesLeadName(salesName);
        oapForm.setDepartment(department);
        oapForm.setDesignation(designation);
        oapForm.setSalesDate(date1);
        oapForm.setSignature("");
        oapForm.setAgreementLoa(pcsDelivery1);
        oapForm.setOwnerShipDocument(pcsDelivery2);
        oapForm.setPreliminarySiteSurvey(pcsDelivery3);
        oapForm.setConsentLetterNoc(pcsDelivery4);
        oapForm.setKwAc77(chargeInstall1);
        oapForm.setKwAcQuatity77(chargeInstall1qua);
        oapForm.setKwDc15(chargeInstall2);
        oapForm.setKwDcQuatity15(chargeInstall2qua);
        oapForm.setKwDc30(chargeInstall3);
        oapForm.setKwDcQuatity30(chargeInstall3qua);
        oapForm.setKwDc60(chargeInstall4);
        oapForm.setKwDcQuatity60(chargeInstall4qua);
        oapForm.setKwDc120(chargeInstall5);
        oapForm.setKwDcQuatity120(chargeInstall5qua);

        oapForm.setKwDc180(chargeInstall6);
        oapForm.setKwDcQuatity180(chargeInstall6qua);
        oapForm.setKw240(chargeInstall7);
        oapForm.setKwQuatity240(chargeInstall7qua);

        oapForm.setNoOfGuns(guns);
        oapForm.setOthers(others);
        oapForm.setTimeLineFromDate(Fromdate);
        oapForm.setTimeLineToDate(Todate);
        oapForm.setProjectBudgetAllocated(budgetallocated);
        oapForm.setOthersDetails(othersDetails);
//	oapForm.setOapMaster(oapMaster);
        oapForm.setCreatedDate(Fromdate);
        oapForm.setUserId(username1);
        oapForm.setCreatedDate(today);
        oapForm.setFlagStatus(1);
        oapForm.setAggrementAttach(attachment1FileName);
        oapForm.setOwnershipAttach(attachment2FileName);
        oapForm.setPreliminaryAttach(attachment3FileName);
        oapForm.setConsentAttach(attachment4FileName);
        oapForm.setState(state5);
        oapForm.setCountry(country);
        oapForm.setCity(city);
        oapForm.setDistrict(district);
        oapForm.setHouseNo(houseno);
        oapForm.setProjectProfile(ProjectProfile);
        oapForm.setProjectCenter(profitcenter);
        oapForm.setCompanyCode(CompanyCode);
        oapForm.setPlant(Plant);
        oapForm.setProjectType(ProjectType);
        oapForm.setProjectCurrency(ProjectCurrency);
        oapForm.setInverstmentProfile(InvestmentProfile);
//	oapForm.setDiscom(Discom);
        oapForm.setNoOfChargePoints(ChargePoints);
        oapForm.setNoOfCharger(NoOfCharger);
        oapForm.setOverallStationCapacityKw(overallstations);
        oapForm.setStationAcCapacityKw(stationAc);
        oapForm.setStationDcCapacityKw(stationDc);
        oapForm.setStationName(stationname);
        oapForm.setStationType(stationtype);
        oapForm.setTenant(tenant);
        oapForm.setChargingRatePerUnit(chargingrate);

        oapFormService.update(oapForm);

        int id1 = oapForm.getId();
        OapForm oapForm1 = oapFormService.readById(id1);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        // multi attachment
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + id1;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP"
                            + File.separator + id1 + File.separator;

                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs(); // Create the directory if it doesn't exist
                    }

                    File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    try {
                        file1.transferTo(destinationFile1); // Ensure proper exception handling
                    } catch (Exception e) {
                        e.printStackTrace(); // Handle the error or log it
                    }

                    OapMultiAttachment oapMultiAttachment = new OapMultiAttachment();

                    oapMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    oapMultiAttachment.setDescription(description[a]);
                    oapMultiAttachment.setOapForm(oapForm1);
                    oapMultiAttachmentService.create(oapMultiAttachment);
                    a++;
                }
            }

        }

//	OapFormApproval oapFormApproval5 = oapFormApprovalService.readByDeltecodes(id);
//
//	int formid = oapFormApproval5.getId();
//	List list44 = oapFormApprovalUserService.readByDleteCode(formid);
//
//	for (Object o : list44) {
//	    OapFormApprovalUser oapFormApprovalUser = (OapFormApprovalUser) o;
//	    int id3 = oapFormApprovalUser.getId();
//	    oapFormApprovalUserService.delete(id3);
//
//	}
//
//	oapFormApprovalService.delete(formid);
//
//	// approval name drop down relted code
//	List approval_list = oapMasterUserService.readByIdToList(approvalName);
//	HttpSession session = request.getSession(false);
//	UserMaster user = (UserMaster) session.getAttribute("user");
//	String username = user.getLoginName();
//	EmployeeMaster employeeMaster = employeeMasterService.read(username);
//	String employeeCode = employeeMaster.getEmployeeCode();
//
//	OapFormApproval oapFormApproval = new OapFormApproval();
//	oapFormApproval.setOapForm(oapForm1);
//	oapFormApproval.setTotalApproval(approval_list.size() + "");
//	oapFormApproval.setApprovalStatus("0");
//	oapFormApproval.setApprovalRemark("add");
//	oapFormApproval.setUserId(employeeCode);
//	oapFormApproval.setCurrentApproval("1");
//	oapFormApprovalService.create(oapFormApproval);
//
//	int approveId = oapFormApproval.getId();
//	OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);
//
//	int j = 0;
//
//	for (Object o : approval_list) {
//	    j++;
//	    OapMasterUser oap1 = (OapMasterUser) o;
//	    OapFormApprovalUser oap = new OapFormApprovalUser();
//	    oap.setOapFormApproval(approveId);
//	    oap.setOapForm(id1);
//	    oap.setUserId(oap1.getUserId());
//	    oap.setLevel(j + "");
//	    oap.setApprovalStatus("0");
//	    oapFormApprovalUserService.create(oap);
//
//	}
        mv = oapFormAppovalList(request, response);
        return mv;
    }

    public ModelAndView oapFormRecycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        OapFormApproval oapFormApproval = oapFormApprovalService.readById(Integer.parseInt(id));

        OapFormApprovalUser oapApprovalUser = oapFormApprovalUserService.readByIdAndUsername(id, username);

        String approvalStatus = oapApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {

            int oapformid = oapFormApproval.getOapForm().getId();

            OapForm oapForm = oapFormService.readById(oapformid);

            String documentno = oapForm.getDocumentNo();

            OapFormApprovalUser oapFormApprovalUser = oapFormApprovalUserService.appvals(username, id);
            int oapid = oapFormApprovalUser.getOapForm();

            int approveId = oapFormApproval.getId();
            OapFormApprovalComment oapFormApprovalComment = oapFormApprovalCommentService.readByApproveId(approveId);

            oapFormApproval.setApprovalStatus("2");
            oapFormApproval.setCurrentApproval("1");
            oapFormApprovalUser.setApprovalStatus("2");
            oapFormApprovalComment.setApprovalStatus("2");
            oapForm.setFlagStatus(2);
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            oapFormApprovalComment.setUserId(employeeCode);
            oapFormApprovalComment.setOapFormApproval(approveId);
            oapFormApprovalComment.setApprovalComment(comment);
            oapFormApprovalComment.setOapForm(oapformid);
            oapFormApprovalCommentService.create(oapFormApprovalComment);

            String userid = oapFormApprovalComment.getUserId();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(31);
            String mail_from = "";
            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            String Oap_form = "OAP Form";
            msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{pcsname\\}", oapForm.getPcsName());
            msg = msg.replaceAll("\\{username\\}", userid);
//	    msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

//        OapFormApprovalUser oapFormApprovalUser1 = new OapFormApprovalUser();
//        List userid1 = oapFormApprovalUserService.readByapprovalStatus(oapid + "");
//        for (Object pdf1 : userid1) {
//
//            oapFormApprovalUser1 = (OapFormApprovalUser) pdf1;
//
//            if ("0".equals(oapFormApprovalUser1.getApprovalStatus())) {
//                String fgrId = oapFormApprovalUser1.getUserId();
//                EmployeeMaster employeeMaster5 = employeeMasterService.readUser(fgrId);
//
//                if (employeeMaster5 != null && employeeMaster5.getEmailId() != null && !employeeMaster5.getEmailId().isEmpty()) {
//
//                    String mail_to5 = employeeMaster5.getEmailId();
//
//                    EmailTemplate emailTemplate1 = emailTemplateService.readById(97);
//                    String mail_from5 = "";
//
//                    String subject5 = emailTemplate1.getSubject();
//                    String msg5 = emailTemplate1.getBodytext();
//
//                    String Oap_form5 = "Recycle Person of OAP Form ";
//
//                    msg5 = msg5.replaceAll("\\{Oap_form\\}", Oap_form5);
//                    msg5 = msg5.replaceAll("\\{documentno\\}", documentno);
//                    msg5 = msg5.replaceAll("\\{username\\}", username);
//                    msg5 = msg5.replaceAll("\\{Recycledate\\}", currentDateTime5);
//
//                    SendMail s1 = new SendMail();
//                    s1.sendMail(mail_from5, mail_to5, subject5, msg5);
//                }
//            }
//        }
            oapFormApprovalService.update(oapFormApproval);
            oapFormApprovalUserService.update(oapFormApprovalUser);
            oapFormService.update(oapForm);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("OAP Rework");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Recycle");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(oapformid);
            oapLogMasterService.create(oapLogMaster);

            session.setAttribute("successMessage", " OAP Approval Rework Successfully");

        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "OAP Approval Already Approved Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "OAP Approval Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "OAP Approval Already Rejected Successfully");
        } else {
            session.setAttribute("failureMessage", "The OAP Approval Has Already Progressed To The Next Stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=OapApproval");

        return mv;
    }

    public ModelAndView oapRecycleView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String oapFormattach = request.getParameter("oapFormattach");
        String oapFormmulti = request.getParameter("oapFormmulti");
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);
        List oaplogmaster = oapLogMasterService.readByOapId(id);

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

        List list = oapDocumentAttachmentService.readByattach(oapFormattach);
        List list33 = oapMultiAttachmentService.readByMulti(oapFormmulti);
        OapFormApproval oapFormApproval = oapFormApprovalService.readByoapappid(id);
        int approveid = oapFormApproval.getId();

        List list0 = oapFormApprovalCommentService.readByIds(id);
        mv.getModelMap().put("id", id);

        List chargeInst = chargerInstallationDetailsService.readByoapId(id);
        mv.getModelMap().put("chargeInst", chargeInst);

        mv.getModelMap().put("oaplogmaster", oaplogmaster);

        mv.getModelMap().put("list55", oapForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.setViewName("Oap/OapRecycleView");
        return mv;
    }

    public ModelAndView oapReject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        OapFormApprovalUser oapApprovalUser = oapFormApprovalUserService.readByIdAndUsername(id, username);

        String approvalStatus = oapApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {

            OapFormApproval oapFormApproval = oapFormApprovalService.readById(Integer.parseInt(id));
            int oapapprovalid = oapFormApproval.getId();

            int oapformid = oapFormApproval.getOapForm().getId();

            OapForm oapForm = oapFormService.readById(oapformid);

            String documentno = oapForm.getDocumentNo();

            OapFormApprovalUser oapFormApprovalUser = oapFormApprovalUserService.appvals(username, id);

            int approveId = oapFormApproval.getId();
            OapFormApprovalComment oapFormApprovalComment = oapFormApprovalCommentService.readByApproveId(approveId);

            String approvalStatus1 = oapFormApproval.getApprovalStatus();

            oapFormApproval.setApprovalStatus("3");
            oapFormApprovalUser.setApprovalStatus("3");
            oapFormApprovalComment.setApprovalStatus("3");

            oapForm.setFlagStatus(3);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            oapFormApprovalComment.setUserId(employeeCode);
            oapFormApprovalComment.setOapFormApproval(oapapprovalid);
            oapFormApprovalComment.setApprovalComment(comment);
            oapFormApprovalComment.setOapForm(oapformid);
            oapFormApprovalCommentService.create(oapFormApprovalComment);

            oapFormApprovalService.update(oapFormApproval);
            oapFormApprovalUserService.update(oapFormApprovalUser);
            oapFormService.update(oapForm);

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(34);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Oap_form = "OAP Form";

            msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{pcsname\\}", oapForm.getPcsName());
            msg = msg.replaceAll("\\{username\\}", username);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("Reject");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Rejected");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(oapformid);
            oapLogMasterService.create(oapLogMaster);

            session.setAttribute("successMessage", "  OapApproval Rejected successfully");
        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "OapApproval Already Approved Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "OapApproval Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "OapApproval Already Rejected Successfully");
        } else {
            session.setAttribute("failureMessage", "The Oap approval has already progressed to the next stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=OapApproval");
        return mv;
    }

    public ModelAndView oapDocxdownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String fileName = request.getParameter("fileName");
        String id1 = request.getParameter("id1");

        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + id1 + File.separator + fileName;

        request.setAttribute("filePath", fileLocationURL);
        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
        return mv;
    }

    public ModelAndView oapDocxdownloadzip(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id1 = request.getParameter("id1");

//	List prd1 = oapDocumentAttachmentService.readByattach(id1);
        List prd = oapDocumentAttachmentService.readByattachzip(id1);
        int size = prd.size();
        List prd1 = oapMultiAttachmentService.readByattachzip(id1);
        int size1 = prd1.size();
        String[] fileNames = new String[prd.size() + prd1.size()]; // Ensure enough space
        int a = 0;
        List allAttachments = new ArrayList();
        allAttachments.addAll(prd);
        allAttachments.addAll(prd1);

        for (Object o : allAttachments) {
            if (o instanceof Object[]) {
                Object[] objArray = (Object[]) o;  // Cast to Object[]
                if (objArray[0] instanceof OapDocumentAttachment) {
                    OapDocumentAttachment pRDoc = (OapDocumentAttachment) objArray[0];
                    fileNames[a] = pRDoc.getAttachment();
                }
            } else if (o instanceof OapMultiAttachment) {
                OapMultiAttachment pRDoc = (OapMultiAttachment) o; // Direct cast without array
                fileNames[a] = pRDoc.getAttachment();
            }
            a++;
        }

        // Initialize zip output stream
        // Initialize zip output stream
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment;filename=OAPFILE.zip");
        try (ZipOutputStream zos = new ZipOutputStream(response.getOutputStream())) {
            for (String fileEntry : fileNames) {

                // Locate the file on disk
                String fileLocation = getServletContext().getRealPath("/") + File.separator + "StorageYard"
                        + File.separator + "OAP" + File.separator + id1 + File.separator + fileEntry;

                File file = new File(fileLocation);
                if (file.exists()) {
                    // Add file to zip
                    try (FileInputStream fis = new FileInputStream(file)) {
                        ZipEntry zipEntry = new ZipEntry(fileEntry);

                        // Check if the file already exists in ZIP, handle duplicate case
                        try {
                            zos.putNextEntry(zipEntry);

                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = fis.read(buffer)) > 0) {
                                zos.write(buffer, 0, length);
                            }

                            zos.closeEntry();
                        } catch (IOException duplicateFileException) {
                            // Skip the duplicate entry and continue processing
                            System.err.println("Skipping duplicate file: " + fileEntry);
                        }
                    } catch (IOException fileReadException) {
                        // Log the file read error and continue processing other files
                        System.err.println("Error reading file: " + fileEntry);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        mv.getModelMap().put("prdSize", size);
        mv.getModelMap().put("size1", size1);

        return mv;
    }

    public ModelAndView rejectview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String oapFormattach = request.getParameter("oapFormattach");
        String oapFormmulti = request.getParameter("oapFormmulti");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        List oaplogmaster = oapLogMasterService.readByOapId(id);

        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);

        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);

        List chargeInst = chargerInstallationDetailsService.readByoapId(id);
        mv.getModelMap().put("chargeInst", chargeInst);

        OapFormApproval oapFormApproval = oapFormApprovalService.readByoapappid(id);
        int approveid = oapFormApproval.getId();

        List list0 = oapFormApprovalCommentService.readByIds(id);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", oapForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("oaplogmaster", oaplogmaster);
        mv.setViewName("Oap/OapRejectView");
        return mv;
    }

    public ModelAndView oapKickOffForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String username = user.getLoginName();
//        UserRights userRights = userRightsService.readByUser(username);
//        int executive = userRights.getExecutiveHead();

//        List oapForm1 = oapFormService.rights(executive);
//        mv.getModelMap().put("list", oapForm1);
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

        mv.setViewName("Oap/oapKickOffForm");
        return mv;
    }

    public ModelAndView oapKickOffFormAssign(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        OapForm oapForm1 = oapFormService.readById(Integer.parseInt(id));
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);
        String discom = oapForm1.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = oapForm1.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();

        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);
        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);

        List chargeInst = chargerInstallationDetailsService.readByoapId(id);
        mv.getModelMap().put("chargeInst", chargeInst);

        OapFormApproval oapFormApproval = oapFormApprovalService.readByoapappid(id);
        int approveid = oapFormApproval.getId();

        List list0 = oapFormApprovalCommentService.readByIds(id);

        List list31 = userRightsService.readByCreated();

        List list30 = userRightsService.readByprojectManager();

        mv.getModelMap().put("list55", oapForm1);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list31", list31);
        mv.getModelMap().put("list30", list30);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);

        mv.setViewName("Oap/oapKickOffFormAssign");
        return mv;
    }

    public ModelAndView oapKickOffFormAssignUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String id = request.getParameter("id");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        String employee_code = request.getParameter("employee_code");
        String projectcoordinator = request.getParameter("projectcoordinator");

        if ("".equals(oapForm.getAssignedName())) {

            oapForm.setAssignedName(employee_code);
            oapForm.setProjectCoordinater(projectcoordinator);
            oapForm.setCrcAssignedBy(username);
            oapForm.setCrcAssignedDate(today);
            String oapCreatedBy = oapForm.getUserId();
            oapFormService.update(oapForm);

            String documentno = oapForm.getDocumentNo();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(employee_code);

            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(35);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            String Oap_form = "OAP Form";

            msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", employee_code);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);
            EmployeeMaster employeeMaster = employeeMasterService.readUser(projectcoordinator);
            String mail_to1 = employeeMaster.getEmailId();

            EmailTemplate emailTemplate1 = emailTemplateService.readById(36);
            String mail_from1 = "";

            String subject1 = emailTemplate1.getSubject();
            String msg1 = emailTemplate1.getBodytext();
            String Oap_form1 = "OAP Form";

            msg1 = msg1.replaceAll("\\{Oap_form\\}", Oap_form1);
            msg1 = msg1.replaceAll("\\{documentno\\}", documentno);
            msg1 = msg1.replaceAll("\\{username\\}", projectcoordinator);

            SendMail s1 = new SendMail();
            s1.sendMail(mail_from1, mail_to1, subject1, msg1);

            EmployeeMaster employeeMaster5 = employeeMasterService.readUser(username);
            String mail_to5 = employeeMaster5.getEmailId();

            EmailTemplate emailTemplate5 = emailTemplateService.readById(100);
            String mail_from5 = "";

            String subject5 = emailTemplate5.getSubject();
            String msg5 = emailTemplate5.getBodytext();
            String Oap_form5 = "Executive head Assigned the to Create CRC Form";

            msg5 = msg5.replaceAll("\\{Oap_form\\}", Oap_form5);
            msg5 = msg5.replaceAll("\\{documentno\\}", documentno);
            msg5 = msg5.replaceAll("\\{pcsName\\}", oapForm.getPcsName());
            msg5 = msg5.replaceAll("\\{username\\}", username);
            msg5 = msg5.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s5 = new SendMail();
            s5.sendMail(mail_from5, mail_to5, subject5, msg5);

            EmployeeMaster employeeMaster7 = employeeMasterService.readUser(oapCreatedBy);
            String mail_to7 = employeeMaster7.getEmailId();

            EmailTemplate emailTemplate7 = emailTemplateService.readById(101);
            String mail_from7 = "";

            String subject7 = emailTemplate7.getSubject();
            String msg7 = emailTemplate7.getBodytext();
            String Oap_form7 = "Executive head Assigned the to Create CRC Form";

            msg7 = msg7.replaceAll("\\{Oap_form\\}", Oap_form7);
            msg7 = msg7.replaceAll("\\{documentno\\}", documentno);
            msg7 = msg7.replaceAll("\\{pcsName\\}", oapForm.getPcsName());
            msg7 = msg7.replaceAll("\\{username\\}", username);
            msg7 = msg7.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s7 = new SendMail();
            s7.sendMail(mail_from7, mail_to7, subject7, msg7);

            OapFormApprovalUser oapFormApprovalUser1 = new OapFormApprovalUser();
            int intId = Integer.parseInt(id);
            List userid = oapFormApprovalUserService.readByoapid(intId);
            for (Object pdf1 : userid) {
                oapFormApprovalUser1 = (OapFormApprovalUser) pdf1;
                String usernames = oapFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(102);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String Oap_form8 = "Executive head Assigned the to Create CRC Form";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", Oap_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{pcsName\\}", oapForm.getPcsName());
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("OAP Assign");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Assigned");
            oapLogMaster.setComments("");
            oapLogMaster.setOapId(Integer.parseInt(id));
            oapLogMasterService.create(oapLogMaster);

            mv.getModelMap().put("id", id);

            //Executive Head Mail 
            List EhMail = ehMailService.read();
            EhMail ehMail = new EhMail();

            EmailTemplate emailTemplates = emailTemplateService.readById(101);
            String mail_froms = "";
            String subjects = emailTemplates.getSubject();

            for (Object ehobj : EhMail) {
                ehMail = (EhMail) ehobj;
                String email = ehMail.getEmail();

                String msgs = emailTemplates.getBodytext();

                msgs = msgs.replaceAll("\\{Oap_form\\}", Oap_form);
                msgs = msgs.replaceAll("\\{documentno\\}", documentno);
                msgs = msgs.replaceAll("\\{username\\}", username);
                msgs = msgs.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail ss = new SendMail();
                ss.sendMail(mail_froms, email, subjects, msgs);
            }

            session.setAttribute("successMessage", "OAP successfully Assigned To Project Co-ordinator and Project Manager");
        } else {
            session.setAttribute("failureMessage", "Already OAP successfully Assigned To Project Co-ordinator and Project Manager");
        }
        mv.setViewName("redirect:oapForm.htm?act=oapKickOffForm");

        return mv;
    }

    public ModelAndView CrcForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("oapId");
        List list10 = oapMasterService.read();

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        String projectmanger = oapForm.getProjectCoordinater();

        String pcsname = oapForm.getPcsName();
        String oapNo = oapForm.getDocumentNo();
        String documentId = oapForm.getDocumentNo();
        if (documentId != null) {
            documentId = documentId.replaceFirst("OAP", "CRC");
        }

        mv.getModelMap().put("projectmanger", projectmanger);
        mv.getModelMap().put("pcsname", pcsname);
        mv.getModelMap().put("oapNo", oapNo);
        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("documentid", documentId);
        mv.setViewName("Oap/CrcForm");
        return mv;
    }

    public ModelAndView crcFormSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        String oapId = request.getParameter("oapId");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(oapId));
        int id1 = oapForm.getId();
        String oapDocumentNo = oapForm.getDocumentNo();

        CrcForm crcForms = crcFormService.readByoapdDocumentNo(oapDocumentNo);

        if (crcForms.getOapNumber() == null || crcForms.getOapNumber().trim().isEmpty()) {

            String documentNo = request.getParameter("documentNo");
            String pcsName = request.getParameter("pcsName");
            String documentRevisonNo = request.getParameter("documentRevisonNo");
            String oapNumber = request.getParameter("oapNumber");
            String site = request.getParameter("site");
            if (site == null) {
                site = "0";
            } else {
                site = "1";
            }

            String agreement = request.getParameter("agreement");
            if (agreement == null) {
                agreement = "0";
            } else {
                agreement = "1";
            }
            String land = request.getParameter("land");
            if (land == null) {
                land = "0";
            } else {
                land = "1";
            }
            String noc = request.getParameter("noc");
            if (noc == null) {
                noc = "0";
            } else {
                noc = "1";
            }
            String commentUnviable = request.getParameter("commentUnviable");
            String plan = request.getParameter("plan");
            if (plan == null) {
                plan = "0";
            } else {
                plan = "1";
            }
            String projectOap = request.getParameter("projectOap");
            if (projectOap == null) {
                projectOap = "0";
            } else {
                projectOap = "1";
            }

            String timeline = request.getParameter("timeline");
            if (timeline == null) {
                timeline = "0";
            } else {
                timeline = "1";
            }
            String Comments = request.getParameter("Comments");
            String bill = request.getParameter("bill");
            String pcsdraw = request.getParameter("pcsdraw");
            String scope = request.getParameter("scope");
            String Fromdate1 = request.getParameter("Fromdate1");
            String newrevision = request.getParameter("newrevision");
            String reviewercomments = request.getParameter("reviewercomments");
            String preparedby = request.getParameter("preparedby");
            String designation = request.getParameter("designation");
            String projectengineer = request.getParameter("projectengineer");
//	String signaturedate = request.getParameter("signaturedate");

            String approvalName = request.getParameter("approvalName");
//        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));

            CrcForm crcForm = new CrcForm();

            crcForm.setDocumentNo(documentNo);
            crcForm.setPcsName(pcsName);
            crcForm.setDocumentRevisionNo("R0");
            crcForm.setOapNumber(oapNumber);
            crcForm.setSiteSurveyAcceptance(site);
            crcForm.setAggrementAcceptance(agreement);
            crcForm.setLandOwnerShipDocument(land);
            crcForm.setNocConsent(noc);
            crcForm.setComment(commentUnviable);
            crcForm.setPlanLayoutSigned(plan);
            crcForm.setProjectBudgetOap(projectOap);
            crcForm.setProjectTimelineOap(timeline);
            crcForm.setAaprovalComment(Comments);
            crcForm.setBillMaterialNo(bill);
            crcForm.setPcsDrawingNumber(pcsdraw);
            crcForm.setScopeWork(scope);
            crcForm.setDeliverableReleaseDate(Fromdate1);
            crcForm.setNewRevisionNumber(newrevision);
            crcForm.setReviewerComment(reviewercomments);
            crcForm.setPreparedBy(preparedby);
            crcForm.setDesignation(designation);
            crcForm.setProjectEngineer(projectengineer);
            crcForm.setSignatureDate("");
            crcForm.setOapForm(oapForm);
//        crcForm.setOapMaster(oapMaster);
            crcForm.setUserid(username1);

            crcFormService.create(crcForm);

            int id = crcForm.getId();
            String mainusername = crcForm.getUserid();
            String documentno = crcForm.getDocumentNo();

            CrcForm crcForm1 = crcFormService.readById(id);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());
            oapForm.setFlagStatus(6);
            oapForm.setCrcCreatedDate(today);
            String asignedname = oapForm.getAssignedName();
            String oapCreatedBy = oapForm.getUserId();
            oapFormService.update(oapForm);

            // approval name drop down relted code
            List approval_list = oapMasterUserService.readByIdToList(approvalName);
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            CrcFormApproval crcFormApproval = new CrcFormApproval();
            crcFormApproval.setCrcForm(crcForm1);
            crcFormApproval.setTotalApproval("1");
            crcFormApproval.setApprovalStatus("0");
            crcFormApproval.setApprovalRemark("add");
            crcFormApproval.setUserId(employeeCode);
            crcFormApproval.setCurrentApproval("1");
            crcFormApproval.setPartiallyApproveDate("");
            crcFormApprovalService.create(crcFormApproval);

            int approveId = crcFormApproval.getId();
            CrcFormApproval crcFormApproval1 = crcFormApprovalService.readById(approveId);

            int j = 0;
            List<String> list = new ArrayList<>();

//        for (Object o : approval_list) {
//            j++;
//            OapMasterUser oap1 = (OapMasterUser) o;
            CrcFormApprovalUser crcFormApprovalUser = new CrcFormApprovalUser();
            crcFormApprovalUser.setCrcFormApproval(approveId);
            crcFormApprovalUser.setCrcForm(id);
            crcFormApprovalUser.setUserId(approvalName + "");
            crcFormApprovalUser.setLevel("1");
            list.add(approvalName + "");
            crcFormApprovalUser.setApprovalStatus("0");
            crcFormApprovalUserService.create(crcFormApprovalUser);

            String userid1 = crcFormApprovalUser.getUserId();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid1);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(37);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            String CRC_form = "CRC Form";

            msg = msg.replaceAll("\\{CRC_form\\}", CRC_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", mainusername);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

//        }
// crc Created 
            EmployeeMaster employeeMaster5 = employeeMasterService.readUser(mainusername);
            String mail_to5 = employeeMaster5.getEmailId();

            EmailTemplate emailTemplate1 = emailTemplateService.readById(103);
            String mail_from5 = "";

            String subject5 = emailTemplate1.getSubject();
            String msg5 = emailTemplate1.getBodytext();

            String Crc_form5 = "CRC Form Created";

            msg5 = msg5.replaceAll("\\{Oap_form\\}", Crc_form5);
            msg5 = msg5.replaceAll("\\{documentno\\}", documentno);
            msg5 = msg5.replaceAll("\\{username\\}", mainusername);
            msg5 = msg5.replaceAll("\\{createddate\\}", currentDateTime5);

            StringBuilder approvers = new StringBuilder();
            for (String listData : list) {
                approvers.append(listData).append(", "); // or use line breaks
            }
            if (approvers.length() > 0) {
                approvers.setLength(approvers.length() - 2);
            }
            msg5 = msg5.replaceAll("\\{approvalpersons\\}", approvers.toString());

            SendMail s1 = new SendMail();
            s1.sendMail(mail_from5, mail_to5, subject5, msg5);

            //Executive head Assigned Person
            EmployeeMaster employeeMaster0 = employeeMasterService.readUser(asignedname);
            String mail_to0 = employeeMaster0.getEmailId();

            EmailTemplate emailTemplate0 = emailTemplateService.readById(104);
            String mail_from0 = "";

            String subject0 = emailTemplate0.getSubject();
            String msg0 = emailTemplate0.getBodytext();
            String Oap_form0 = "Created CRC Form";

            msg0 = msg0.replaceAll("\\{Oap_form\\}", Oap_form0);
            msg0 = msg0.replaceAll("\\{documentno\\}", documentno);
            msg0 = msg0.replaceAll("\\{username\\}", username);
            msg0 = msg0.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s0 = new SendMail();
            s0.sendMail(mail_from0, mail_to0, subject0, msg0);
// oapCretaed
            EmployeeMaster employeeMaster7 = employeeMasterService.readUser(oapCreatedBy);
            String mail_to7 = employeeMaster7.getEmailId();

            EmailTemplate emailTemplate7 = emailTemplateService.readById(104);
            String mail_from7 = "";

            String subject7 = emailTemplate7.getSubject();
            String msg7 = emailTemplate7.getBodytext();
            String Oap_form7 = "Created CRC Form";

            msg7 = msg7.replaceAll("\\{Oap_form\\}", Oap_form7);
            msg7 = msg7.replaceAll("\\{documentno\\}", documentno);
            msg7 = msg7.replaceAll("\\{username\\}", username);
            msg7 = msg7.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s7 = new SendMail();
            s0.sendMail(mail_from7, mail_to7, subject7, msg7);

            //oapApprovalusers
            OapFormApprovalUser oapFormApprovalUser1 = new OapFormApprovalUser();

            List userid = oapFormApprovalUserService.readByoapid(id1);

            for (Object pdf1 : userid) {
                oapFormApprovalUser1 = (OapFormApprovalUser) pdf1;
                String usernames = oapFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(105);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String Oap_form8 = "Created CRC Form";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", Oap_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("CRC Created");
            oapLogMaster.setActivityBy(username1);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Created");
            oapLogMaster.setComments("");
            oapLogMaster.setOapId(id1);
            oapLogMaster.setCrcId(id);
            oapLogMasterService.create(oapLogMaster);

            session1.setAttribute("successMessage", "CRC Form Created successfully");
        } else {
            session1.setAttribute("failureMessage", "Already CRC Form Created successfully");
        }
        mv.setViewName("redirect:oapForm.htm?act=CrcFormApproveList");

        return mv;
    }

    public ModelAndView CrcFormApproveList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Oap/CrcFormApproveList");
        return mv;
    }

    public ModelAndView OpaLastestData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

//        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        String documentNo = oapForm.getDocumentNo();

        List oaphistory = oapFormHistoryService.readBydocumentno(documentNo);
        int ophistoryid = 0;
        for (Object o : oaphistory) {
            OapFormHistory opHistory = (OapFormHistory) o;
            ophistoryid = opHistory.getId();

        }

        List oapmultiAttch = oapMultiAttachmentHistoryService.readByMulti1(ophistoryid + "");

        List OapSurveyhistory = oapSurveyAttachmentHistoryService.readByoaphistryid(ophistoryid + "");

        List list0 = oapFormApprovalCommentService.readByIds(id);
        mv.getModelMap().put("list0", list0);

        List oaplogmaster = oapLogMasterService.readByOapId(id);
        mv.getModelMap().put("oaplogmaster", oaplogmaster);

        List chargeInst = chargerInstallationDetailsHistoryService.readByoapId(Integer.parseInt(id));
        mv.getModelMap().put("chargeInst", chargeInst);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list33", oapmultiAttch);
        mv.getModelMap().put("list55", oaphistory);
        mv.getModelMap().put("oapSurveyAttch", OapSurveyhistory);
        mv.setViewName("Oap/OpaLastestData");
        return mv;
    }

    public ModelAndView CrcFormApprovalUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String username = user.getLoginName();
//        List crcFormApproval = crcFormApprovalService.approvaList(username);
//
//        mv.getModelMap().put("list1", crcFormApproval);

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

        mv.setViewName("Oap/CrcFormApprovalUser");
        return mv;
    }

    public ModelAndView CrcFormApprovalUserView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String crcFormId = request.getParameter("crcFormId");

        CrcFormApproval crcFormApproval = crcFormApprovalService.readById(Integer.parseInt(id));

        List crcApproval1 = crcFormApprovalService.readids(id);

        CrcForm list55 = crcFormService.readById(Integer.parseInt(crcFormId));

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", list55);
        mv.getModelMap().put("list1", crcApproval1);
        mv.getModelMap().put("list8", crcFormApproval);
        mv.getModelMap().put("crcFormId", crcFormId);
        mv.setViewName("Oap/CrcFormApprovalUserView");
        return mv;
    }

    public ModelAndView CrcFormApprovalUserApprove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        CrcFormApproval crcFormApproval = crcFormApprovalService.readById(Integer.parseInt(id));

        int crcFormid = crcFormApproval.getCrcForm().getId();

        CrcForm crcForm = crcFormService.readById(crcFormid);

        int oapFormid = crcForm.getOapForm().getId();

        CrcFormApprovalUser crcFormApprovalUser = crcFormApprovalUserService.appvals(username, crcFormid + "");

        String approvalStatus = crcFormApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {

            String documentno = crcForm.getDocumentNo();
            OapForm oapForm = oapFormService.readByformid(oapFormid);
            String crcuser = crcForm.getUserid();
            String oapassign = oapForm.getAssignedName();
            String oapuserid = oapForm.getUserId();

            int approvalid = crcFormApproval.getId();

            CrcFormApprovalComment crcFormApprovalComment1 = crcFormApprovalCommentService.readByApproveId(approvalid);

            String totalApproval = crcFormApproval.getTotalApproval();

            String ca = crcFormApproval.getCurrentApproval();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());
            if (totalApproval.equals(ca)) {
                crcFormApproval.setApprovalStatus("1");
                crcFormApprovalUser.setApprovalStatus("1");
                crcFormApprovalComment1.setApprovalStatus("1");
                crcForm.setFlagStatus(1);
                crcFormApproval.setPartiallyApproveDate("");
                oapForm.setFlagStatus(7);
                oapForm.setPartiallyApproveFlag(1);
                oapForm.setCrcApprovedBy(username);
                oapForm.setCrcApprovedDate(today);

            } else {
                String level = crcFormApprovalUser.getLevel();
                int a = Integer.parseInt(level);
                a++;
                crcFormApproval.setCurrentApproval(level);
                crcFormApprovalUser.setApprovalStatus("1");
                crcFormApprovalComment1.setApprovalStatus("1");
                crcFormApproval.setCurrentApproval("2");
                crcFormApproval.setPartiallyApproveDate("");
//
            }
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            crcFormApprovalComment1.setApprovalComment(comment);
            crcFormApprovalComment1.setUserId(username);
            crcFormApprovalComment1.setCrcFormApproval(crcFormApproval);
            crcFormApprovalComment1.setApprovalStatus("1");
            crcFormApprovalCommentService.create(crcFormApprovalComment1);

            crcFormApprovalService.update(crcFormApproval);
            crcFormApprovalUserService.update(crcFormApprovalUser);
            crcFormService.update(crcForm);
            oapFormService.update(oapForm);

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(40);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String CRC_form = "CRC Form";

            msg = msg.replaceAll("\\{Crc_form\\}", CRC_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", username);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            //crc creted person
            EmployeeMaster employeeMaster6 = employeeMasterService.readUser(crcuser);
            String mail_to6 = employeeMaster6.getEmailId();

            EmailTemplate emailTemplate6 = emailTemplateService.readById(106);
            String mail_from6 = "";

            String subject6 = emailTemplate6.getSubject();
            String msg6 = emailTemplate6.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String crc_form6 = "CRC Approved By approval Person";

            msg6 = msg6.replaceAll("\\{Oap_form\\}", crc_form6);
            msg6 = msg6.replaceAll("\\{documentno\\}", documentno);
            msg6 = msg6.replaceAll("\\{username\\}", username);
            msg6 = msg6.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s6 = new SendMail();
            s6.sendMail(mail_from6, mail_to6, subject6, msg6);
//EH person
            EmployeeMaster employeeMaster3 = employeeMasterService.readUser(oapassign);
            String mail_to3 = employeeMaster3.getEmailId();

            EmailTemplate emailTemplate3 = emailTemplateService.readById(107);
            String mail_from3 = "";

            String subject3 = emailTemplate3.getSubject();
            String msg3 = emailTemplate3.getBodytext();
//    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String crc_form3 = "CRC Approved By approval Person ";

            msg3 = msg3.replaceAll("\\{Oap_form\\}", crc_form3);
            msg3 = msg3.replaceAll("\\{documentno\\}", documentno);
            msg3 = msg3.replaceAll("\\{username\\}", username);
            msg3 = msg3.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s3 = new SendMail();
            s3.sendMail(mail_from3, mail_to3, subject3, msg3);
            //oapcreted person

            EmployeeMaster employeeMaster11 = employeeMasterService.readUser(oapuserid);
            String mail_to11 = employeeMaster11.getEmailId();

            EmailTemplate emailTemplate11 = emailTemplateService.readById(108);
            String mail_from11 = "";

            String subject11 = emailTemplate11.getSubject();
            String msg11 = emailTemplate11.getBodytext();
            String crc_form11 = "CRC Approved By approval Person";

            msg11 = msg11.replaceAll("\\{Oap_form\\}", crc_form11);
            msg11 = msg11.replaceAll("\\{documentno\\}", documentno);
            msg11 = msg11.replaceAll("\\{username\\}", username);
            msg11 = msg11.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s11 = new SendMail();
            s11.sendMail(mail_from11, mail_to11, subject11, msg11);
//oapaproval persons
            OapFormApprovalUser oapFormApprovalUser1 = new OapFormApprovalUser();

            List userid = oapFormApprovalUserService.readByoapid(oapFormid);
            for (Object pdf1 : userid) {
                oapFormApprovalUser1 = (OapFormApprovalUser) pdf1;
                String usernames = oapFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(109);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "CRC Approved By approval Person";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
// design manager send  main
            List crcapprovaluser = crcFormApprovalUserService.readByApprovalStatuszero(crcFormid);

            if (crcapprovaluser.size() == 0) {
                List designrights = userRightsService.readByDesignManager();

                for (Object pdf2 : designrights) {
//                String username1 = pdf2.toString();  // if it's a string or simple object
                    Object[] row = (Object[]) pdf2;
                    String username1 = (String) row[1];
                    EmployeeMaster employeeMaster7 = employeeMasterService.readUser(username1);
                    String mail_to7 = employeeMaster7.getEmailId();

                    EmailTemplate emailTemplate7 = emailTemplateService.readById(110);
                    String mail_from7 = "";

                    String subject7 = emailTemplate7.getSubject();
                    String msg7 = emailTemplate7.getBodytext();

                    String crc_form7 = "All CRC Form Approvals are Completed";

                    msg7 = msg7.replaceAll("\\{Oap_form\\}", crc_form7);
                    msg7 = msg7.replaceAll("\\{documentno\\}", documentno);
                    msg7 = msg7.replaceAll("\\{finalapproveddate\\}", currentDateTime5);

                    SendMail s7 = new SendMail();
                    s7.sendMail(mail_from7, mail_to7, subject7, msg7);
                }
            }

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("CRC Approval");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Approved");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(oapFormid);
            oapLogMaster.setCrcId(crcFormid);
            oapLogMasterService.create(oapLogMaster);

            session.setAttribute("successMessage", "CRC Approved completed successfully");

        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Approved Successfully");

        } else if ("8".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Rejected Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Partially Approved Successfully");
        } else {
            session.setAttribute("failureMessage", "The CRC approval has already progressed to the next stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=CrcFormApprovalUser");

        return mv;

    }

    public ModelAndView CrcFormreject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        CrcFormApproval crcFormApproval = crcFormApprovalService.readById(Integer.parseInt(id));

        int crcformid = crcFormApproval.getCrcForm().getId();

        CrcForm crcForm = crcFormService.readById(crcformid);

        int id1 = crcForm.getOapForm().getId();
        String documentno = crcForm.getDocumentNo();

        OapForm oapForm = oapFormService.readByformid(id1);

        CrcFormApprovalUser crcFormApprovalUser = crcFormApprovalUserService.appvals(username, crcformid + "");

        int approveId = crcFormApproval.getId();
        CrcFormApprovalComment crcFormApprovalComment = crcFormApprovalCommentService.readByApproveId(approveId);

        String approvalStatus = crcFormApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {

            crcFormApproval.setApprovalStatus("3");
            crcFormApprovalUser.setApprovalStatus("3");
            crcFormApprovalComment.setApprovalStatus("3");
            crcFormApproval.setPartiallyApproveDate("");

//        } else {
//            crcFormApprovalUser.setApprovalStatus("3");
//            crcFormApprovalComment.setApprovalStatus("3");
//            crcFormApproval.setPartiallyApproveDate("");
//
//        }
            crcForm.setFlagStatus(3);
            oapForm.setFlagStatus(5);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            crcFormApprovalComment.setUserId(employeeCode);
            crcFormApprovalComment.setCrcFormApproval(crcFormApproval);
            crcFormApprovalComment.setApprovalComment(comment);
            crcFormApprovalCommentService.create(crcFormApprovalComment);

            crcFormApprovalService.update(crcFormApproval);
            crcFormApprovalUserService.update(crcFormApprovalUser);
            crcFormService.update(crcForm);
            oapFormService.update(oapForm);

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(41);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            String CRC_form = "CRC Form";

            msg = msg.replaceAll("\\{Crc_form\\}", CRC_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", username);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("CRC Reject");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Rejected");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(Integer.parseInt(id));
            oapLogMaster.setCrcId(crcformid);
            oapLogMasterService.create(oapLogMaster);

            session.setAttribute("successMessage", " Crc Rejected Done successfully");

        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "Crc Already Approved Successfully");

        } else if ("8".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "Crc Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "Crc Already Rejected Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "Crc Already Partially Approved Successfully");
        } else {
            session.setAttribute("failureMessage", "The Crc approval has already progressed to the next stage");
        }
        mv.setViewName("redirect:oapForm.htm?act=CrcFormApprovalUser");

        return mv;
    }

    public ModelAndView CrcFormPartiallyApprove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        String partialldate = request.getParameter("partialldate");

        CrcFormApproval crcFormApproval = crcFormApprovalService.readById(Integer.parseInt(id));
        int crcformid = crcFormApproval.getCrcForm().getId();

        CrcForm crcForm = crcFormService.readById(crcformid);
        CrcFormApprovalUser crcFormApprovalUser = crcFormApprovalUserService.appvals(username, crcformid + "");
        int oapFormid = crcForm.getOapForm().getId();
        OapForm oapForm = oapFormService.readByformid(oapFormid);

        String documentno = oapForm.getDocumentNo();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();
        CrcFormApprovalComment crcFormApprovalComment = new CrcFormApprovalComment();

        String approvalStatus = crcFormApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {

            crcFormApprovalComment.setUserId(employeeCode);
            crcFormApprovalComment.setCrcFormApproval(crcFormApproval);
            crcFormApprovalComment.setApprovalComment(comment);
            crcFormApprovalComment.setApprovalStatus("4");
            crcFormApprovalCommentService.create(crcFormApprovalComment);

            crcFormApproval.setApprovalStatus("2");
            crcForm.setFlagStatus(2);
            crcFormApprovalUser.setApprovalStatus("2");
            oapForm.setFlagStatus(14);
            oapForm.setPartiallyApproveFlag(1);
            crcFormApprovalUser.setApprovalStatus("2");
            crcFormApproval.setPartiallyApproveDate(partialldate);

            crcFormApprovalUserService.update(crcFormApprovalUser);
            crcFormService.update(crcForm);
            crcFormApprovalService.update(crcFormApproval);
            oapFormService.update(oapForm);

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(39);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            String CRC_form = "CRC Form";

            msg = msg.replaceAll("\\{Crc_form\\}", CRC_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", username);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("CRC Partially");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("CRC Partially Approved");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(oapFormid);
            oapLogMaster.setCrcId(crcformid);
            oapLogMasterService.create(oapLogMaster);

            session.setAttribute("successMessage", " CRC Partially Approved Done successfully");

        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Approved Successfully");

        } else if ("8".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Rejected Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Partially Approved Successfully");
        } else {
            session.setAttribute("failureMessage", "The CRC approval has already progressed to the next stage");
        }
        mv.setViewName("redirect:oapForm.htm?act=CrcFormApprovalUser");

        return mv;
    }

    public ModelAndView CrcFormList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        List list = crcFormService.readByusername(username);

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
        mv.setViewName("Oap/CrcFormList");
        return mv;
    }

    public ModelAndView CrcFormApprovalMatrixView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        CrcForm crcForm = crcFormService.readById(Integer.parseInt(id));

        CrcFormApproval crcFormApproval = crcFormApprovalService.readBycrcid(id);

        int crcformid = crcFormApproval.getId();

        List list0 = crcFormApprovalUserService.readByApprovalStatus(id);
        List oaplogmaster = oapLogMasterService.readBycrcid(id);
        mv.getModelMap().put("oaplogmaster", oaplogmaster);

        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list", crcForm);

        mv.setViewName("Oap/CrcFormApprovalMatrixView");
        return mv;
    }

    public ModelAndView CrcFormListview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        CrcForm crcForm = crcFormService.readById(Integer.parseInt(id));

        CrcFormApproval crcFormApproval = crcFormApprovalService.readBycrcid(id);

        int crcformid = crcFormApproval.getId();

        List list0 = crcFormApprovalCommentService.readBycrcformid(crcformid);
        List oaplogmaster = oapLogMasterService.readBycrcid(id);
        mv.getModelMap().put("oaplogmaster", oaplogmaster);

        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list", crcForm);
        mv.setViewName("Oap/CrcFormListview");
        return mv;
    }

    public ModelAndView CrcFormListEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        CrcForm crcForm = crcFormService.readById(Integer.parseInt(id));

        int oapid = crcForm.getOapForm().getId();

//        int oapmasterId = crcForm.getOapMaster().getId();
        int oapmasterId = 0;
        OapMaster oapMaster = crcForm.getOapMaster();
        if (oapMaster != null && !oapMaster.equals("")) {
            oapmasterId = crcForm.getOapMaster().getId();
        }

        OapForm oapForm = oapFormService.readByformid(oapid);

        String projectmanger = oapForm.getProjectCoordinater();

//        List list10 = oapMasterService.read();
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("projectmanger", projectmanger);
        mv.getModelMap().put("crcForm", crcForm);
        mv.getModelMap().put("oapmasterId", oapmasterId);
//        mv.getModelMap().put("list10", list10);
        mv.setViewName("Oap/CrcFormListEdit");
        return mv;
    }

    public ModelAndView CrcFormListEditsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user2 = (UserMaster) session1.getAttribute("user");
        String username2 = user2.getLoginName();

        String id = request.getParameter("id");

        CrcForm crcForm = crcFormService.readById(Integer.parseInt(id));
        int crcFlagStatus = crcForm.getFlagStatus();

        if (crcFlagStatus == 800 || crcFlagStatus == 10) {

            String documentNo = request.getParameter("documentNo");
            String pcsName = request.getParameter("pcsName");
            String documentRevisonNo = request.getParameter("documentRevisonNo");
            String oapNumber = request.getParameter("oapNumber");
            String site = request.getParameter("site");
            if (site == null) {
                site = "0";
            } else {
                site = "1";
            }
            String agreement = request.getParameter("agreement");
            if (agreement == null) {
                agreement = "0";
            } else {
                agreement = "1";
            }
            String land = request.getParameter("land");
            if (land == null) {
                land = "0";
            }
            String noc = request.getParameter("noc");
            if (noc == null) {
                noc = "0";
            } else {
                noc = "1";
            }
            String commentUnviable = request.getParameter("commentUnviable");
            String plan = request.getParameter("plan");
            if (plan == null) {
                plan = "0";
            } else {
                plan = "1";
            }
            String projectOap = request.getParameter("projectOap");
            if (projectOap == null) {
                projectOap = "0";
            } else {
                projectOap = "1";
            }

            String timeline = request.getParameter("timeline");
            if (timeline == null) {
                timeline = "0";
            } else {
                timeline = "1";
            }
            String Comments = request.getParameter("Comments");
            String bill = request.getParameter("bill");
            String pcsdraw = request.getParameter("pcsdraw");
            String scope = request.getParameter("scope");
            String Fromdate1 = request.getParameter("Fromdate1");
            String newrevision = request.getParameter("newrevision");
            String reviewercomments = request.getParameter("reviewercomments");
            String preparedby = request.getParameter("preparedby");
            String designation = request.getParameter("designation");
            String projectengineer = request.getParameter("projectengineer");
            String signaturedate = request.getParameter("signaturedate");

            String approvalName = request.getParameter("approvalName");
//        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));

            crcForm.setDocumentNo(documentNo);
            crcForm.setPcsName(pcsName);
            crcForm.setDocumentRevisionNo(documentRevisonNo);
            if (documentRevisonNo == null || documentRevisonNo.isEmpty()) {
                documentRevisonNo = "R0"; // Default to R0 if null or empty
            } else {
                String numericPart = documentRevisonNo.substring(1);
                try {
                    int revisionNumber = Integer.parseInt(numericPart) + 1;
                    documentRevisonNo = "R" + revisionNumber; // Update to the next revision
                } catch (NumberFormatException e) {
                    documentRevisonNo = "R0"; // Reset to R0 if parsing fails
                }
            }
            // Then set the updated value as usual
            crcForm.setDocumentRevisionNo(documentRevisonNo);

            crcForm.setOapNumber(oapNumber);
            crcForm.setSiteSurveyAcceptance(site);
            crcForm.setAggrementAcceptance(agreement);
            crcForm.setLandOwnerShipDocument(land);
            crcForm.setNocConsent(noc);
            crcForm.setComment(commentUnviable);
            crcForm.setPlanLayoutSigned(plan);
            crcForm.setProjectBudgetOap(projectOap);
            crcForm.setProjectTimelineOap(timeline);
            crcForm.setAaprovalComment(Comments);
            crcForm.setBillMaterialNo(bill);
            crcForm.setPcsDrawingNumber(pcsdraw);
            crcForm.setScopeWork(scope);
            crcForm.setDeliverableReleaseDate(Fromdate1);
            crcForm.setNewRevisionNumber(newrevision);
            crcForm.setReviewerComment(reviewercomments);
            crcForm.setPreparedBy(preparedby);
            crcForm.setDesignation(designation);
            crcForm.setProjectEngineer(projectengineer);
            crcForm.setSignatureDate("");
//        crcForm.setOapMaster(oapMaster);
            crcFormService.update(crcForm);

            String documentno = crcForm.getDocumentNo();
            String mainusername = crcForm.getUserid();

            CrcFormApproval crcFormApproval5 = crcFormApprovalService.readByDeltecodes(id);
            int crcformapprovalid = crcFormApproval5.getId();

            int formid = crcFormApproval5.getId();

            List list44 = crcFormApprovalUserService.readByDleteCode(formid);

            for (Object o : list44) {
                CrcFormApprovalUser crcFormApprovalUser = (CrcFormApprovalUser) o;
                int id3 = crcFormApprovalUser.getId();
                crcFormApprovalUserService.delete(id3);
            }
            List list = crcFormApprovalCommentService.readBycrcFormApprovalid(crcformapprovalid);
            for (Object o : list) {
                CrcFormApprovalComment crcFormApprovalComment = (CrcFormApprovalComment) o;
                int id3 = crcFormApprovalComment.getId();
                crcFormApprovalCommentService.delete(id3);
            }
            crcFormApprovalService.delete(formid);

            int id1 = crcForm.getId();
            CrcForm crcForm1 = crcFormService.readById(id1);

            // approval name drop down relted code
//        List approval_list = oapMasterUserService.readByIdToList(approvalName);
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            CrcFormApproval crcFormApproval = new CrcFormApproval();
            crcFormApproval.setCrcForm(crcForm1);
            crcFormApproval.setTotalApproval("1");
            crcFormApproval.setApprovalStatus("0");
            crcFormApproval.setApprovalRemark("add");
            crcFormApproval.setUserId(employeeCode);
            crcFormApproval.setCurrentApproval("1");
            crcFormApproval.setPartiallyApproveDate("");
            crcFormApprovalService.create(crcFormApproval);

            int approveId = crcFormApproval.getId();
            CrcFormApproval crcFormApproval1 = crcFormApprovalService.readById(approveId);

//        int j = 0;
//        for (Object o : approval_list) {
//            j++;
//            OapMasterUser oap1 = (OapMasterUser) o;
            CrcFormApprovalUser crcFormApprovalUser = new CrcFormApprovalUser();
            crcFormApprovalUser.setCrcFormApproval(approveId);
            crcFormApprovalUser.setCrcForm(id1);
            crcFormApprovalUser.setUserId(approvalName);
            crcFormApprovalUser.setLevel("1");
            crcFormApprovalUser.setApprovalStatus("0");

            crcFormApprovalUserService.create(crcFormApprovalUser);

            String userid = crcFormApprovalUser.getUserId();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(38);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String CRC_form = "CRC Form";

            msg = msg.replaceAll("\\{Crc_form\\}", CRC_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", mainusername);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

//        }
            CrcFormHistory crcFormHistory = new CrcFormHistory();
            String currentDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

            crcFormHistory.setDocumentRevisionNo(documentRevisonNo);
            if (documentRevisonNo == null || documentRevisonNo.isEmpty()) {
                documentRevisonNo = "R0"; // Default to R0 if null or empty
            } else {
                String numericPart = documentRevisonNo.substring(1);
                try {
                    int revisionNumber = Integer.parseInt(numericPart) + 1;
                    documentRevisonNo = "R" + revisionNumber; // Update to the next revision
                } catch (NumberFormatException e) {
                    documentRevisonNo = "R0"; // Reset to R0 if parsing fails
                }
            }
            crcFormHistory.setDocumentNo(documentNo);
            crcFormHistory.setDocumentRevisionNo(documentRevisonNo);
            crcFormHistory.setSiteSurveyAcceptance(site);
            crcFormHistory.setAggrementAcceptance(agreement);
            crcFormHistory.setLandOwnerShipDocument(land);
            crcFormHistory.setNocConsent(noc);
            crcFormHistory.setComment(commentUnviable);
            crcFormHistory.setPlanLayoutSigned(plan);
            crcFormHistory.setProjectBudgetOap(projectOap);
            crcFormHistory.setProjectTimelineOap(timeline);
            crcFormHistory.setAaprovalComment(Comments);
            crcFormHistory.setBillMaterialNo(bill);
            crcFormHistory.setPcsDrawingNumber(pcsdraw);
            crcFormHistory.setScopeWork(scope);
            crcFormHistory.setDeliverableReleaseDate(Fromdate1);
            crcFormHistory.setNewRevisionNumber(newrevision);
            crcFormHistory.setReviewerComment(reviewercomments);
            crcFormHistory.setPreparedBy(preparedby);
            crcFormHistory.setDesignation(designation);
            crcFormHistory.setProjectEngineer(projectengineer);
            crcFormHistory.setSignatureDate("");
//        crcFormHistory.setOapMaster(oapMaster.getId());
            crcFormHistory.setDateTime(currentDateTime);
            crcFormHistory.setCrcId(id1);

            List lastHistory1 = crcFormHistoryService.readBylasttimestatus(id); // Implement this method in service
            int size = lastHistory1.size();

            String newHistory = "R" + size;
            crcFormHistory.setHistory(newHistory);
            crcFormHistoryService.create(crcFormHistory);

            session1.setAttribute("successMessage", "CRC Submit Edit completed successfully");

        } else {
            session1.setAttribute("failureMessage", "CRC Already  Edit Submit  completed successfully");
        }
        mv.setViewName("redirect:oapForm.htm?act=CrcFormApproveList");
        return mv;
    }

    public ModelAndView AllFormView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String oapFormattach = request.getParameter("oapFormattach");
        String oapFormmulti = request.getParameter("oapFormmulti");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        List list = oapDocumentAttachmentService.readByattach(oapFormattach);
        List list33 = oapMultiAttachmentService.readByMulti(oapFormmulti);

        OapFormApproval oapFormApproval = oapFormApprovalService.readByoapappid(id);
        int approveid = oapFormApproval.getId();

        List list0 = oapFormApprovalCommentService.readByIds(id);

        CrcForm crcForm = crcFormService.readByoapId(id);

        int crcFormid = crcForm.getId();

        CrcFormApproval crcFormApproval = crcFormApprovalService.readBycrcFormid(crcFormid);

        int crcFormApprovalid = crcFormApproval.getId();

        List list2 = crcFormApprovalCommentService.readBycrcFormApprovalid(crcFormApprovalid);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", oapForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list2", list2);

        mv.setViewName("Oap/oapAllFormView");
        return mv;
    }

    public ModelAndView CreatePrFromOap(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        CrcForm crcForm = crcFormService.readById(Integer.parseInt(id));
        int oapformid = crcForm.getOapForm().getId();

        List list = deliverableMultiService.readByoapid(oapformid);
//	List list = deliverableMultiService.readByoapidflag(oapformid);

        PRMaster prMaster = new PRMaster();

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
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("oapformid", oapformid);
        mv.getModelMap().put("crcForm", crcForm);

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
        mv.setViewName("Oap/CreatePrFromOap");
        return mv;
    }

    public ModelAndView oaprecycleEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);
        CrcForm crcForm = crcFormService.readByoapId(id);
        String crcCreator = crcForm.getUserid();

        int size = oapSurveyAttch.size();
        String plant = oapForm.getPlant();
        String Tenant = oapForm.getTenant();
        String StationType = oapForm.getStationType();
        String Currency = oapForm.getProjectCurrency();
        String ProjectType = oapForm.getProjectType();
        String Ivestmentprofile = oapForm.getInverstmentProfile();
        String ProjectCenter = oapForm.getProjectCenter();
        String CompanyCode = oapForm.getCompanyCode();
        String ProjectProfile = oapForm.getProjectProfile();
        String Discom = oapForm.getDiscom();
        String projectname = oapForm.getProjectName();
        String name = oapForm.getAnchoreCustomer();
        String names = oapForm.getCanopyVarient();

        mv.getModelMap().put("crcCreator", crcCreator);
        mv.getModelMap().put("projectname", projectname);
        mv.getModelMap().put("Discom", Discom);
        mv.getModelMap().put("ProjectProfile", ProjectProfile);
        mv.getModelMap().put("CompanyCode", CompanyCode);
        mv.getModelMap().put("ProjectCenter", ProjectCenter);
        mv.getModelMap().put("Ivestmentprofile", Ivestmentprofile);
        mv.getModelMap().put("ProjectType", ProjectType);
        mv.getModelMap().put("Currency", Currency);
        mv.getModelMap().put("StationType", StationType);
        mv.getModelMap().put("Tenant", Tenant);
        mv.getModelMap().put("plant", plant);
        int oapmasterId = oapForm.getOapMaster().getId();
        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);
        List list10 = oapMasterService.read();
        List list0 = tenantService.read();
        List list2 = stationTypeService.read();
        List list3 = currencyMasterService.read();
        List list4 = projectTypeService.read();
        List list6 = investmentProfileService.read();
        List list7 = profitCenterService.read();
        List list8 = plantMastersService.read();
        List list9 = companyMasterService.read();
        List list11 = projectProfileService.read();
        List list12 = discomMasterService.read();
        List list13 = projectNameMasterService.read();
        List list15 = anchorCustomerService.read();
        List list16 = canopyVarientService.read();
        List list17 = chargerTypeService.read();
        List list18 = chargerMasterService.read();
        List list19 = connectorTypeService.read();

        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();

        List chargeInst = chargerInstallationDetailsService.readByoapId(id);

        int chargeInstcount = chargeInst.size();

        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

        request.setAttribute("list0", list0);
        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);
        request.setAttribute("list4", list4);
        request.setAttribute("list6", list6);
        request.setAttribute("list7", list7);
        request.setAttribute("list8", list8);
        request.setAttribute("list9", list9);
        request.setAttribute("list11", list11);
        request.setAttribute("list12", list12);

        mv.getModelMap().put("oapForm", oapForm);
        mv.getModelMap().put("list15", list15);
        mv.getModelMap().put("list16", list16);
        mv.getModelMap().put("list17", list17);
        mv.getModelMap().put("list18", list18);
        mv.getModelMap().put("list19", list19);

        mv.getModelMap().put("name", name);
        mv.getModelMap().put("names", names);
        request.setAttribute("list13", list13);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("oapmasterId", oapmasterId);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("size", size);
        mv.getModelMap().put("chargeInst", chargeInst);
        mv.getModelMap().put("chargeInstcount", chargeInstcount);
        mv.setViewName("Oap/oapRecycleEdit");
        return mv;
    }

    public ModelAndView oapSurveyDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String oapSurveyid = request.getParameter("id1");

        oapSurveyAttachmentService.delete(Integer.parseInt(oapSurveyid));
        mv.getModelMap().put("oapSurveyid", oapSurveyid);
        mv.getModelMap().put("id", id);
        mv.setViewName("forward:oapForm.htm?act=oaprecycleEdit&id=" + id);
        return mv;
    }

    public ModelAndView oapFormRecycleEditsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        OapForm oapFormRecycle = oapFormService.readById(Integer.parseInt(id));

        int FlagStatus = oapFormRecycle.getFlagStatus();

        if (FlagStatus == 2) {

            String documentNo = request.getParameter("documentNo");
            String pcsName = request.getParameter("pcsName");
            String date = request.getParameter("date");
            String documentRevisonNo = request.getParameter("documentRevisonNo");
            String projectName = request.getParameter("projectName");
            String city_highway = request.getParameter("city/highway");
            String pcsAddress = request.getParameter("pcsAddress");
            String pcsType1 = request.getParameter("pcsType1");
            if (pcsType1 == null) {
                pcsType1 = "0";
            } else {
                pcsType1 = "1";
            }
            String pcsType2 = request.getParameter("pcsType2");
            if (pcsType2 == null) {
                pcsType2 = "0";
            } else {
                pcsType2 = "1";
            }
            String pcsType3 = request.getParameter("pcsType3");
            if (pcsType3 == null) {
                pcsType3 = "0";
            } else {
                pcsType3 = "1";
            }
            String pcstypeother = request.getParameter("pcstypeother");
            if (pcstypeother == null) {
                pcstypeother = "";
            }
            String pcsModel = request.getParameter("pcsModel");
            if (pcsModel == null) {
                pcsModel = "0";
            } else {
                pcsModel = "1";
            }
            String pcsMode2 = request.getParameter("pcsMode2");
            if (pcsMode2 == null) {
                pcsMode2 = "0";
            } else {
                pcsMode2 = "1";
            }
            String pcsMode3 = request.getParameter("pcsMode3");
            if (pcsMode3 == null) {
                pcsMode3 = "0";
            } else {
                pcsMode3 = "1";
            }
            String pcsMode5 = request.getParameter("pcsMode5");
            if (pcsMode5 == null) {
                pcsMode5 = "0";
            } else {
                pcsMode5 = "1";
            }
            String pcsMode4 = request.getParameter("pcsMode4");
            if (pcsMode4 == null) {
                pcsMode4 = "0";
            } else {
                pcsMode4 = "1";
            }
            String pcsModelother = request.getParameter("pcsModelother");
            if (pcsModelother == null) {
                pcsModelother = "";
            }
            String pcscoordinates = request.getParameter("pcscoordinates");
            String mobileNo = request.getParameter("mobileNo");
            String email = request.getParameter("email");
            String alternatemobileNo = request.getParameter("alternatemobileNo");
            String clientDetails = request.getParameter("clientDetails");
            String clientRequiremts = request.getParameter("clientRequiremts");
            String scope = request.getParameter("scope");
            String salesName = request.getParameter("salesName");
            String department = request.getParameter("department");
            String designation = request.getParameter("designation");
            String date1 = request.getParameter("date1");
            String signature1 = request.getParameter("signature1");

            String pcsDelivery1 = request.getParameter("pcsDelivery1");
            if (pcsDelivery1 == null) {
                pcsDelivery1 = "0";
            }

            String attachment1File1 = request.getParameter("attachment1File1");

            if (pcsDelivery1.equals("0")) {
                attachment1File1 = "";
            }

            MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
            MultipartFile attachment1File = multipartRequest1.getFile("attachment1File");

            String attachment1FileName = "";
            if (attachment1File != null && !attachment1File.isEmpty()) {
                attachment1FileName = attachment1File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapFormRecycle.getId() + File.separator;

                // Create the directory if it doesn't exist
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the file
                File destinationFile = new File(fileLocationURL + attachment1FileName);
                attachment1File.transferTo(destinationFile);
            }
            if (attachment1FileName.equals("") || attachment1FileName == "") {
                attachment1FileName = attachment1File1;
            }

            String pcsDelivery2 = request.getParameter("pcsDelivery2");
            if (pcsDelivery2 == null) {
                pcsDelivery2 = "0";
            }
            String attachment2File2 = request.getParameter("attachment2File2");

            if (pcsDelivery2.equals("0")) {
                attachment2File2 = "";
            }

            MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
            MultipartFile attachment2File = multipartRequest2.getFile("attachment2File");
            String attachment2FileName = "";
            if (attachment2File != null && !attachment2File.isEmpty()) {
                attachment2FileName = attachment2File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapFormRecycle.getId() + File.separator;;

                // Create the directory if it doesn't exist
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the file
                File destinationFile = new File(fileLocationURL + attachment2FileName);
                attachment2File.transferTo(destinationFile);
            }
            if (attachment2FileName.equals("") || attachment2FileName == "") {
                attachment2FileName = attachment2File2;
            }

            String pcsDelivery3 = request.getParameter("pcsDelivery3");
            if (pcsDelivery3 == null) {
                pcsDelivery3 = "0";
            }
            String attachment3File3 = request.getParameter("attachment3File3");

            if (pcsDelivery3.equals("0")) {
                attachment3File3 = "";
            }

            MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
            MultipartFile attachment3File = multipartRequest3.getFile("attachment3File");
            String attachment3FileName = "";
            if (attachment3File != null && !attachment3File.isEmpty()) {
                attachment3FileName = attachment3File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapFormRecycle.getId() + File.separator;;

                // Create the directory if it doesn't exist
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the file
                File destinationFile = new File(fileLocationURL + attachment3FileName);
                attachment3File.transferTo(destinationFile);
            }
            if (attachment3FileName.equals("") || attachment3FileName == "") {
                attachment3FileName = attachment3File3;
            }

            String pcsDelivery4 = request.getParameter("pcsDelivery4");
            if (pcsDelivery4 == null) {
                pcsDelivery4 = "0";
            }
            String attachment4File4 = request.getParameter("attachment4File4");

            if (pcsDelivery4.equals("0")) {
                attachment4File4 = "";
            }

            MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
            MultipartFile attachment4File = multipartRequest4.getFile("attachment4File");
            String attachment4FileName = "";
            if (attachment4File != null && !attachment4File.isEmpty()) {
                attachment4FileName = attachment4File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapFormRecycle.getId() + File.separator;

                // Create the directory if it doesn't exist
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the file
                File destinationFile = new File(fileLocationURL + attachment4FileName);
                attachment4File.transferTo(destinationFile);
            }
            if (attachment4FileName.equals("") || attachment4FileName == "") {
                attachment4FileName = attachment4File4;
            }

            String chargeInstall1 = request.getParameter("chargeInstall1");
            if (chargeInstall1 == null) {
                chargeInstall1 = "0";
            } else {
                chargeInstall1 = "1";
            }
            String chargeInstall1qua = request.getParameter("chargeInstall1qua");
            if (chargeInstall1qua == null) {
                chargeInstall1qua = "";
            }
            String chargeInstall2 = request.getParameter("chargeInstall2");
            if (chargeInstall2 == null) {
                chargeInstall2 = "0";
            } else {
                chargeInstall2 = "1";
            }
            String chargeInstall2qua = request.getParameter("chargeInstall2qua");
            if (chargeInstall2qua == null) {
                chargeInstall2qua = "";
            }
            String chargeInstall3 = request.getParameter("chargeInstall3");
            if (chargeInstall3 == null) {
                chargeInstall3 = "0";
            } else {
                chargeInstall3 = "1";
            }
            String chargeInstall3qua = request.getParameter("chargeInstall3qua");
            if (chargeInstall3qua == null) {
                chargeInstall3qua = "";
            }
            String chargeInstall4 = request.getParameter("chargeInstall4");
            if (chargeInstall4 == null) {
                chargeInstall4 = "0";
            } else {
                chargeInstall4 = "1";
            }
            String chargeInstall4qua = request.getParameter("chargeInstall4qua");
            if (chargeInstall4qua == null) {
                chargeInstall4qua = "";
            }
            String chargeInstall5 = request.getParameter("chargeInstall5");
            if (chargeInstall5 == null) {
                chargeInstall5 = "0";
            } else {
                chargeInstall5 = "1";
            }
            String chargeInstall5qua = request.getParameter("chargeInstall5qua");
            if (chargeInstall5qua == null) {
                chargeInstall5qua = "";
            }
            String chargeInstall6 = request.getParameter("chargeInstall6");
            if (chargeInstall6 == null) {
                chargeInstall6 = "0";
            } else {
                chargeInstall6 = "1";
            }
            String chargeInstall6qua = request.getParameter("chargeInstall6qua");
            if (chargeInstall6qua == null) {
                chargeInstall6qua = "";
            }
            String chargeInstall7 = request.getParameter("chargeInstall7");
            if (chargeInstall7 == null) {
                chargeInstall7 = "0";
            } else {
                chargeInstall7 = "1";
            }
            String chargeInstall7qua = request.getParameter("chargeInstall7qua");
            if (chargeInstall7qua == null) {
                chargeInstall7qua = "";
            }

            String guns = request.getParameter("guns");
            String others = request.getParameter("others");
            String Fromdate = request.getParameter("Fromdate");
            String Todate = request.getParameter("Todate");
            String budgetallocated = request.getParameter("budgetallocated");
            String othersDetails = request.getParameter("othersDetails");
            String approvalName = request.getParameter("approvalName");

            String country = request.getParameter("country");
            String state5 = request.getParameter("state5");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String houseno = request.getParameter("houseno");
            String ProjectProfile = request.getParameter("ProjectProfile");
            String profitcenter = request.getParameter("profitcenter");
            String CompanyCode = request.getParameter("CompanyCode");
            String Plant = request.getParameter("plant");
            String ProjectType = request.getParameter("ProjectType");
            String ProjectCurrency = request.getParameter("ProjectCurrency");
            String InvestmentProfile = request.getParameter("InvestmentProfile");
//	String Discom = request.getParameter("Discom");
            String ChargePoints = request.getParameter("ChargePoints");
            String NoOfCharger = request.getParameter("NoOfCharger");
            String overallstations = request.getParameter("overallstations");
            String stationAc = request.getParameter("stationAc");
            String stationDc = request.getParameter("stationDc");
            String stationname = request.getParameter("stationname");
            String stationtype = request.getParameter("stationtype");
            String tenant = request.getParameter("tenant");
            String chargingrate = request.getParameter("chargingrate");
            OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
            String sitesurvey = request.getParameter("sitesurvey");
            String Survey = request.getParameter("Survey");
            if ("siteSurveynotcreated".equals(Survey)) {
                Survey = "0";
            } else {
                Survey = "1";
            }

            String projectTimelineCategory = request.getParameter("projectTimelineCategory");
            String totalKwRating = request.getParameter("totalKwRating");
            String specificDateFromClient = request.getParameter("specificDateFromClient");
            if (specificDateFromClient == null) {
                specificDateFromClient = "";
            }
            String totalChargerCapacity = request.getParameter("totalChargerCapacity");
            String chargerStationAccessType = request.getParameter("chargerStationAccessType");
            String auxiliaryLoadOfStation = request.getParameter("auxiliaryLoadOfStation");
            if (auxiliaryLoadOfStation == null) {
                auxiliaryLoadOfStation = "";
            }
            String chargingRetePerUnit = request.getParameter("chargingRetePerUnit");
            String noOfEvsToBeChanged = request.getParameter("noOfEvsToBeChanged");
            String chargeInstall8qua = request.getParameter("chargeInstall8qua");
            if (chargeInstall8qua == null) {
                chargeInstall8qua = "";
            }

            String chargeInstall8 = request.getParameter("chargeInstall8");
            if (chargeInstall8 == null) {
                chargeInstall8 = "0";
            } else {
                chargeInstall8 = "1";
            }
            String chargeInstall9qua = request.getParameter("chargeInstall9qua");
            if (chargeInstall9qua == null) {
                chargeInstall9qua = "";
            }
            String chargeInstall9 = request.getParameter("chargeInstall9");
            if (chargeInstall9 == null) {
                chargeInstall9 = "0";
            } else {
                chargeInstall9 = "1";
            }

            String anchoreCustomer = request.getParameter("anchoreCustomer");
            String canopyVarient = request.getParameter("canopyVarient");
            if (canopyVarient == null) {
                canopyVarient = "";
            }
            String scopeofChargeZone = request.getParameter("scopeofChargeZone");
            String totalMW = request.getParameter("totalMW");

            OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

            oapForm.setDocumentNo(documentNo);
            oapForm.setPcsName(pcsName);
            oapForm.setDate(date);
            // Your existing code
            oapForm.setDocumentRevisionNo(
                    documentRevisonNo == null || documentRevisonNo.isEmpty()
                            ? "R0"
                            : "R" + (Integer.parseInt(documentRevisonNo.substring(1)) + 1)
            );

            oapForm.setProjectName(projectName);
            oapForm.setPcsCityHighway(city_highway);
            oapForm.setPcsAddress(pcsAddress);
            oapForm.setPcsTypeCity(pcsType1);
            oapForm.setPcsTypeHighway(pcsType2);
            oapForm.setPcsTypeOtherCheck(pcsType3);
            oapForm.setPcsTypeOther(pcstypeother);
            oapForm.setPcsModelDoco(pcsModel);
            oapForm.setPcsModelCoco(pcsMode2);
            oapForm.setPcsModelDodo(pcsMode3);
            oapForm.setPcsModelSaas(pcsMode5);
            oapForm.setPcsModelOtherCheck(pcsMode4);
            oapForm.setPcsModelOther(pcsModelother);
            oapForm.setPcsCoordinates(pcscoordinates);
            oapForm.setMobileNo(mobileNo);
            oapForm.setEmail(email);
            oapForm.setAlternateMobileNo(alternatemobileNo);
            oapForm.setClientDetails(clientDetails);
            oapForm.setSpecificRequriementsClients(clientRequiremts);
            oapForm.setClientScope(scope);
            oapForm.setSalesLeadName(salesName);
            oapForm.setDepartment(department);
            oapForm.setDesignation(designation);
            oapForm.setSalesDate(date1);
            oapForm.setSignature("");
            oapForm.setAgreementLoa(pcsDelivery1);
            oapForm.setOwnerShipDocument(pcsDelivery2);
            oapForm.setPreliminarySiteSurvey(pcsDelivery3);
            oapForm.setConsentLetterNoc(pcsDelivery4);
            oapForm.setKwAc77(chargeInstall1);
            oapForm.setKwAcQuatity77(chargeInstall1qua);
            oapForm.setKwDc15(chargeInstall2);
            oapForm.setKwDcQuatity15(chargeInstall2qua);
            oapForm.setKwDc30(chargeInstall3);
            oapForm.setKwDcQuatity30(chargeInstall3qua);
            oapForm.setKwDc60(chargeInstall4);
            oapForm.setKwDcQuatity60(chargeInstall4qua);
            oapForm.setKwDc120(chargeInstall5);
            oapForm.setKwDcQuatity120(chargeInstall5qua);

            oapForm.setKwDc180(chargeInstall6);
            oapForm.setKwDcQuatity180(chargeInstall6qua);
            oapForm.setKw240(chargeInstall7);
            oapForm.setKwQuatity240(chargeInstall7qua);

            oapForm.setNoOfGuns(guns);
            oapForm.setOthers(others);
            oapForm.setTimeLineFromDate(Fromdate);
            oapForm.setTimeLineToDate(Todate);
            oapForm.setProjectBudgetAllocated(budgetallocated);
            oapForm.setOthersDetails(othersDetails);
            oapForm.setOapMaster(oapMaster);
            oapForm.setCreatedDate(Fromdate);
            oapForm.setUserId(username1);
            oapForm.setCreatedDate(today);
            oapForm.setFlagStatus(1);
            oapForm.setAggrementAttach(attachment1FileName);
            oapForm.setOwnershipAttach(attachment2FileName);
            oapForm.setPreliminaryAttach(attachment3FileName);
            oapForm.setConsentAttach(attachment4FileName);
            oapForm.setState(state5);
            oapForm.setCountry(country);
            oapForm.setCity(city);
            oapForm.setDistrict(district);
            oapForm.setHouseNo(houseno);
            oapForm.setProjectProfile(ProjectProfile);
            oapForm.setProjectCenter(profitcenter);
            oapForm.setCompanyCode(CompanyCode);
            oapForm.setPlant(Plant);
            oapForm.setProjectType(ProjectType);
            oapForm.setProjectCurrency(ProjectCurrency);
            oapForm.setInverstmentProfile(InvestmentProfile);
//	oapForm.setDiscom(Discom);
            oapForm.setNoOfChargePoints(ChargePoints);
            oapForm.setNoOfCharger(NoOfCharger);
            oapForm.setOverallStationCapacityKw(overallstations);
            oapForm.setStationAcCapacityKw(stationAc);
            oapForm.setStationDcCapacityKw(stationDc);
            oapForm.setStationName(stationname);
            oapForm.setStationType(stationtype);
            oapForm.setTenant(tenant);
            oapForm.setChargingRatePerUnit(chargingrate);
            oapForm.setSiteSurvey(sitesurvey);
            oapForm.setSurveyRadio(Integer.parseInt(Survey));

            oapForm.setProjectTimelineCategory(projectTimelineCategory);
            oapForm.setTotalKwRating(totalKwRating);
            oapForm.setSpecificDateFromClient(specificDateFromClient);
            oapForm.setTotalChargerCapacity(totalChargerCapacity);
            oapForm.setChargerStationAccessType(chargerStationAccessType);
            oapForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
            oapForm.setChargingRetePerUnit(chargingRetePerUnit);
            oapForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
            oapForm.setKw360(chargeInstall8);
            oapForm.setKwQuatity360(chargeInstall8qua);
            oapForm.setKw720(chargeInstall9);
            oapForm.setKwQuatity720(chargeInstall9qua);
            oapForm.setAnchoreCustomer(anchoreCustomer);
            oapForm.setCanopyVarient(canopyVarient);
            oapForm.setScopeOfchargeZone(scopeofChargeZone);
            oapForm.setTotalMegaWatt(totalMW);

            oapFormService.update(oapForm);
            String documentno = oapForm.getDocumentNo();
            String mainusername = oapForm.getUserId();
            String mailcreteddate = oapForm.getCreatedDate();
            int id1 = oapForm.getId();

            String[] chargerType = request.getParameterValues("chargerType");
            String[] charger = request.getParameterValues("charger");
            String[] chargerOther = request.getParameterValues("chargerOther");
            String[] chargerCapacityKW = request.getParameterValues("chargerCapacityKW");
            String[] chargermodel = request.getParameterValues("chargermodel");
            String[] connectorType = request.getParameterValues("connectorType");
            String[] connectorOther = request.getParameterValues("connectorOther");
            String[] noofconnectors = request.getParameterValues("noofconnectors");
            String[] noofchargers = request.getParameterValues("noofchargers");
            String[] chargingrateperunit = request.getParameterValues("chargingrateperunit");

            for (int ct = 0; ct < chargerType.length; ct++) {
                String c = chargerType[ct];

                if (c != null && !c.isEmpty()) {
                    ChargerInstallationDetails cid = new ChargerInstallationDetails();

                    cid.setOapId(id1);
                    cid.setChargerType(chargerType[ct]);
                    cid.setCharger(charger[ct]);
                    cid.setChargerOther(chargerOther[ct]);
                    cid.setChargerCapacityKW(chargerCapacityKW[ct]);
                    cid.setChargermodel(chargermodel[ct]);
                    cid.setConnectorType(connectorType[ct]);
                    cid.setConnectorTypeOther(connectorOther[ct]);
                    cid.setNoofconnectors(noofconnectors[ct]);
                    cid.setNoofchargers(noofchargers[ct]);
                    cid.setChargingrateperunit(chargingrateperunit[ct]);

                    chargerInstallationDetailsService.create(cid);

                    ChargerInstallationDetailsHistory cidH = new ChargerInstallationDetailsHistory();

                    cidH.setOapId(id1);
                    cidH.setChargerInstalId(cid.getId());
                    cidH.setChargerType(chargerType[ct]);
                    cidH.setCharger(charger[ct]);
                    cidH.setChargerOther(chargerOther[ct]);
                    cidH.setChargerCapacityKW(chargerCapacityKW[ct]);
                    cidH.setChargermodel(chargermodel[ct]);
                    cidH.setConnectorType(connectorType[ct]);
                    cidH.setConnectorTypeOther(connectorOther[ct]);
                    cidH.setNoofconnectors(noofconnectors[ct]);
                    cidH.setNoofchargers(noofchargers[ct]);
                    cidH.setChargingrateperunit(chargingrateperunit[ct]);

                    chargerInstallationDetailsHistoryService.create(cidH);
                }
            }

            OapForm oapForm1 = oapFormService.readById(id1);

            String[] surveyNo = request.getParameterValues("surveyNo");
            String[] projectRepresentative = request.getParameterValues("projectRepresentative");

            int z = 0;
            int id8 = 0;
            for (String s : surveyNo) {
                if (s != null && !s.isEmpty()) {
                    OapSurveyAttachment oapSurveyAttachment = new OapSurveyAttachment();
                    oapSurveyAttachment.setSurveyNo(surveyNo[z]);
                    oapSurveyAttachment.setProjectRepresentative(projectRepresentative[z]);
                    oapSurveyAttachment.setOapId(id1);
                    oapSurveyAttachmentService.create(oapSurveyAttachment);

                    z++;
                    id8 = oapSurveyAttachment.getId();
                }
            }
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            // multi attachment
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP"
                    + File.separator + id1;
            File f1 = new File(path);
            boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

            List<MultipartFile> files1 = multipartRequest.getFiles("attach");
            String[] description = request.getParameterValues("descriptions");
            int a = 0;
            int id4 = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "OAP"
                                + File.separator + id1 + File.separator;

                        File directory = new File(fileLocationURL);
                        if (!directory.exists()) {
                            directory.mkdirs(); // Create the directory if it doesn't exist
                        }

                        File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        try {
                            file1.transferTo(destinationFile1); // Ensure proper exception handling
                        } catch (Exception e) {
                            e.printStackTrace(); // Handle the error or log it
                        }

                        OapMultiAttachment oapMultiAttachment = new OapMultiAttachment();

                        oapMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        oapMultiAttachment.setDescription(description[a]);
                        oapMultiAttachment.setOapForm(oapForm1);
                        oapMultiAttachmentService.create(oapMultiAttachment);
                        a++;
                        id4 = oapMultiAttachment.getId();
                    }
                }

            }

            OapFormApproval oapFormApproval5 = oapFormApprovalService.readByDeltecodes(id);

            int formid = oapFormApproval5.getId();
            List list44 = oapFormApprovalUserService.readByDleteCode(formid);

            for (Object o : list44) {
                OapFormApprovalUser oapFormApprovalUser = (OapFormApprovalUser) o;
                int id3 = oapFormApprovalUser.getId();
                oapFormApprovalUserService.delete(id3);

            }

            oapFormApprovalService.delete(formid);

            // approval name drop down relted code
            List approval_list = oapMasterUserService.readByIdToList(approvalName);
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            OapFormApproval oapFormApproval = new OapFormApproval();
            oapFormApproval.setOapForm(oapForm1);
            oapFormApproval.setTotalApproval(approval_list.size() + "");
            oapFormApproval.setApprovalStatus("0");
            oapFormApproval.setApprovalRemark("add");
            oapFormApproval.setUserId(employeeCode);
            oapFormApproval.setCurrentApproval("1");
            oapFormApprovalService.create(oapFormApproval);

            int approveId = oapFormApproval.getId();
            OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

            int j = 0;

            for (Object o : approval_list) {
                j++;
                OapMasterUser oap1 = (OapMasterUser) o;
                OapFormApprovalUser oap = new OapFormApprovalUser();
                oap.setOapFormApproval(approveId);
                oap.setOapForm(id1);
                oap.setUserId(oap1.getUserId());
                oap.setLevel("1");
                oap.setApprovalStatus("0");
                oapFormApprovalUserService.create(oap);

                String userid = oap.getUserId();
                EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
                String mail_to = employeeMaster2.getEmailId();

                EmailTemplate emailTemplate = emailTemplateService.readById(32);
                String mail_from = "";

                String subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
                String Oap_form = "OAP Form";

                msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
                msg = msg.replaceAll("\\{documentno\\}", documentno);
                msg = msg.replaceAll("\\{pcsname\\}", oapForm.getPcsName());
                msg = msg.replaceAll("\\{username\\}", mainusername);
//	    msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

                SendMail s = new SendMail();
                s.sendMail(mail_from, mail_to, subject, msg);

            }

            // reverse edit
            OapFormHistory oapFormHistory1 = oapFormHistoryService.readById(id1);
//	String lastHistory = oapFormHistory1.getHistory();
            String currentDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
            String history = "";
            OapFormHistory oapFormHistory = new OapFormHistory();

            oapFormHistory.setDocumentNo(documentNo);
            oapFormHistory.setPcsName(pcsName);
            oapFormHistory.setDate(date);
            // Your existing code
            oapFormHistory.setDocumentRevisionNo(
                    documentRevisonNo == null || documentRevisonNo.isEmpty()
                            ? "R0"
                            : "R" + (Integer.parseInt(documentRevisonNo.substring(1)) + 1)
            );

            oapFormHistory.setProjectName(projectName);
            oapFormHistory.setPcsCityHighway(city_highway);
            oapFormHistory.setPcsAddress(pcsAddress);
            oapFormHistory.setPcsTypeCity(pcsType1);
            oapFormHistory.setPcsTypeHighway(pcsType2);
            oapFormHistory.setPcsTypeOtherCheck(pcsType3);
            oapFormHistory.setPcsTypeOther(pcstypeother);
            oapFormHistory.setPcsModelDoco(pcsModel);
            oapFormHistory.setPcsModelCoco(pcsMode2);
            oapFormHistory.setPcsModelDodo(pcsMode3);
            oapFormHistory.setPcsModelSaas(pcsMode5);
            oapFormHistory.setPcsModelOtherCheck(pcsMode4);
            oapFormHistory.setPcsModelOther(pcsModelother);
            oapFormHistory.setPcsCoordinates(pcscoordinates);
            oapFormHistory.setMobileNo(mobileNo);
            oapFormHistory.setEmail(email);
            oapFormHistory.setAlternateMobileNo(alternatemobileNo);
            oapFormHistory.setClientDetails(clientDetails);
            oapFormHistory.setSpecificRequriementsClients(clientRequiremts);
            oapFormHistory.setClientScope(scope);
            oapFormHistory.setSalesLeadName(salesName);
            oapFormHistory.setDepartment(department);
            oapFormHistory.setDesignation(designation);
            oapFormHistory.setSalesDate(date1);
            oapFormHistory.setSignature("");
            oapFormHistory.setAgreementLoa(pcsDelivery1);
            oapFormHistory.setOwnerShipDocument(pcsDelivery2);
            oapFormHistory.setPreliminarySiteSurvey(pcsDelivery3);
            oapFormHistory.setConsentLetterNoc(pcsDelivery4);
            oapFormHistory.setKwAc77(chargeInstall1);
            oapFormHistory.setKwAcQuatity77(chargeInstall1qua);
            oapFormHistory.setKwDc15(chargeInstall2);
            oapFormHistory.setKwDcQuatity15(chargeInstall2qua);
            oapFormHistory.setKwDc30(chargeInstall3);
            oapFormHistory.setKwDcQuatity30(chargeInstall3qua);
            oapFormHistory.setKwDc60(chargeInstall4);
            oapFormHistory.setKwDcQuatity60(chargeInstall4qua);
            oapFormHistory.setKwDc120(chargeInstall5);
            oapFormHistory.setKwDcQuatity120(chargeInstall5qua);

            oapFormHistory.setKwDc180(chargeInstall6);
            oapFormHistory.setKwDcQuatity180(chargeInstall6qua);
            oapFormHistory.setKw240(chargeInstall7);
            oapFormHistory.setKwQuatity240(chargeInstall7qua);

            oapFormHistory.setNoOfGuns(guns);
            oapFormHistory.setOthers(others);
            oapFormHistory.setTimeLineFromDate(Fromdate);
            oapFormHistory.setTimeLineToDate(Todate);
            oapFormHistory.setProjectBudgetAllocated(budgetallocated);
            oapFormHistory.setOthersDetails(othersDetails);
            oapFormHistory.setOapMaster(oapMaster.getId());
            oapFormHistory.setCreatedDate(Fromdate);
            oapFormHistory.setUserId(username1);
            oapFormHistory.setCreatedDate(today);
            oapFormHistory.setFlagStatus(1);
            oapFormHistory.setAggrementAttach(attachment1FileName);
            oapFormHistory.setOwnershipAttach(attachment2FileName);
            oapFormHistory.setPreliminaryAttach(attachment3FileName);
            oapFormHistory.setConsentAttach(attachment4FileName);
            oapFormHistory.setState(state5);
            oapFormHistory.setCountry(country);
            oapFormHistory.setCity(city);
            oapFormHistory.setDistrict(district);
            oapFormHistory.setHouseNo(houseno);
            oapFormHistory.setProjectProfile(ProjectProfile);
            oapFormHistory.setProjectCenter(profitcenter);
            oapFormHistory.setCompanyCode(CompanyCode);
            oapFormHistory.setPlant(Plant);
            oapFormHistory.setProjectType(ProjectType);
            oapFormHistory.setProjectCurrency(ProjectCurrency);
            oapFormHistory.setInverstmentProfile(InvestmentProfile);
//	oapForm.setDiscom(Discom);
            oapFormHistory.setNoOfChargePoints(ChargePoints);
            oapFormHistory.setNoOfCharger(NoOfCharger);
            oapFormHistory.setOverallStationCapacityKw(overallstations);
            oapFormHistory.setStationAcCapacityKw(stationAc);
            oapFormHistory.setStationDcCapacityKw(stationDc);
            oapFormHistory.setStationName(stationname);
            oapFormHistory.setStationType(stationtype);
            oapFormHistory.setTenant(tenant);
            oapFormHistory.setChargingRatePerUnit(chargingrate);
            oapFormHistory.setOapId(id1);
            oapFormHistory.setDateTime(currentDateTime);
            oapFormHistory.setSiteSurvey(sitesurvey);
            oapFormHistory.setSurveyRadio(Integer.parseInt(Survey));

            oapFormHistory.setProjectTimelineCategory(projectTimelineCategory);
            oapFormHistory.setTotalKwRating(totalKwRating);
            oapFormHistory.setSpecificDateFromClient(specificDateFromClient);
            oapFormHistory.setTotalChargerCapacity(totalChargerCapacity);
            oapFormHistory.setChargerStationAccessType(chargerStationAccessType);
            oapFormHistory.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
            oapFormHistory.setChargingRetePerUnit(chargingRetePerUnit);
            oapFormHistory.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
            oapFormHistory.setKw360(chargeInstall8);
            oapFormHistory.setKwQuatity360(chargeInstall8qua);
            oapFormHistory.setKw720(chargeInstall9);
            oapFormHistory.setKwQuatity720(chargeInstall9qua);
            oapFormHistory.setAnchoreCustomer(anchoreCustomer);
            oapFormHistory.setCanopyVarient(canopyVarient);
            oapFormHistory.setScopeOfchargeZone(scopeofChargeZone);
            oapFormHistory.setTotalMegaWatt(totalMW);

//	oapFormHistory.setHistory(documentRevisonNo);
            List lastHistory1 = oapFormHistoryService.readBylasttimestatus(id1); // Implement this method in service
            int size = lastHistory1.size();

            String newHistory = "R" + size;
            oapFormHistory.setHistory(newHistory);

            oapFormHistoryService.create(oapFormHistory);

            int id2 = oapFormHistory.getId();
            String oaphistory = oapFormHistory.getHistory();

// multi attachment
            int b = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        OapMultiAttachmentHistory oapMultiAttachmentHistory = new OapMultiAttachmentHistory();

                        oapMultiAttachmentHistory.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        oapMultiAttachmentHistory.setDescription(description[b]);
                        oapMultiAttachmentHistory.setOapForm(id1);
                        oapMultiAttachmentHistory.setHistory(oaphistory);
                        oapMultiAttachmentHistory.setOapHistoryId(id2);
                        oapMultiAttachmentHistory.setOapMultiId(id4);
                        oapMultiAttachmentHistoryService.create(oapMultiAttachmentHistory);
                        a++;
                    }
                }
            }
//survey history attachment
            int x = 0;

            for (String s : surveyNo) {
                if (s != null && !s.isEmpty()) {
                    OapSurveyAttachmentHistory oapSurveyAttachmentHistory = new OapSurveyAttachmentHistory();
                    oapSurveyAttachmentHistory.setSurveyNo(surveyNo[x]);
                    oapSurveyAttachmentHistory.setOapId(id1);
                    oapSurveyAttachmentHistory.setDateTime(currentDateTime);
                    oapSurveyAttachmentHistory.setHistory(oaphistory);
                    oapSurveyAttachmentHistory.setOapSurveyAttachmentId(id8);
                    oapSurveyAttachmentHistory.setOapFormHistoryId(id2);
                    oapSurveyAttachmentHistoryService.create(oapSurveyAttachmentHistory);

                    x++;
                }
            }

//            for (int ct = 0; ct < chargerType.length; ct++) {
//                String c = chargerType[ct];
//
//                if (c != null && !c.isEmpty()) {
//                   
//
//                }
//            }
            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity(" OAP Edit");
            oapLogMaster.setActivityBy(username1);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus(" OAP Recycle Edited");
            oapLogMaster.setOapId(id1);
            oapLogMaster.setComments("");
            oapLogMasterService.create(oapLogMaster);

            session.setAttribute("successMessage", " OAP Form Recycled Successfully Completed");
        } else if (FlagStatus == 1) {
            session1.setAttribute("failureMessage", "OAP Form Already Recycled Successfully");
        } else {
            session1.setAttribute("failureMessage", "The OAP Approval Has Already Progressed To The Next Stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=oapFormAppovalList");
        return mv;
    }

    public ModelAndView oapFormReverseEditsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        int oapFlagStatus = oapForm.getFlagStatus();

        if (oapFlagStatus == 14) {

            String documentNo = request.getParameter("documentNo");
            String pcsName = request.getParameter("pcsName");
            String date = request.getParameter("date");
            String documentRevisonNo = request.getParameter("documentRevisonNo");
            String projectName = request.getParameter("projectName");
            String city_highway = request.getParameter("city/highway");
            String pcsAddress = request.getParameter("pcsAddress");
            String pcsType1 = request.getParameter("pcsType1");
            if (pcsType1 == null) {
                pcsType1 = "0";
            } else {
                pcsType1 = "1";
            }
            String pcsType2 = request.getParameter("pcsType2");
            if (pcsType2 == null) {
                pcsType2 = "0";
            } else {
                pcsType2 = "1";
            }
            String pcsType3 = request.getParameter("pcsType3");
            if (pcsType3 == null) {
                pcsType3 = "0";
            } else {
                pcsType3 = "1";
            }
            String pcstypeother = request.getParameter("pcstypeother");
            if (pcstypeother == null) {
                pcstypeother = "";
            }
            String pcsModel = request.getParameter("pcsModel");
            if (pcsModel == null) {
                pcsModel = "0";
            } else {
                pcsModel = "1";
            }
            String pcsMode2 = request.getParameter("pcsMode2");
            if (pcsMode2 == null) {
                pcsMode2 = "0";
            } else {
                pcsMode2 = "1";
            }
            String pcsMode3 = request.getParameter("pcsMode3");
            if (pcsMode3 == null) {
                pcsMode3 = "0";
            } else {
                pcsMode3 = "1";
            }
            String pcsMode5 = request.getParameter("pcsMode5");
            if (pcsMode5 == null) {
                pcsMode5 = "0";
            } else {
                pcsMode5 = "1";
            }
            String pcsMode4 = request.getParameter("pcsMode4");
            if (pcsMode4 == null) {
                pcsMode4 = "0";
            } else {
                pcsMode4 = "1";
            }
            String pcsModelother = request.getParameter("pcsModelother");
            if (pcsModelother == null) {
                pcsModelother = "";
            }
            String pcscoordinates = request.getParameter("pcscoordinates");
            String mobileNo = request.getParameter("mobileNo");
            String email = request.getParameter("email");
            String alternatemobileNo = request.getParameter("alternatemobileNo");
            String clientDetails = request.getParameter("clientDetails");
            String clientRequiremts = request.getParameter("clientRequiremts");
            String scope = request.getParameter("scope");
            String salesName = request.getParameter("salesName");
            String department = request.getParameter("department");
            String designation = request.getParameter("designation");
            String date1 = request.getParameter("date1");
            String signature1 = request.getParameter("signature1");

            String pcsDelivery1 = request.getParameter("pcsDelivery1");
            if (pcsDelivery1 == null) {
                pcsDelivery1 = "0";
            }

            String attachment1File1 = request.getParameter("attachment1File1");

            if (pcsDelivery1.equals("0")) {
                attachment1File1 = "";
            }

            MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
            MultipartFile attachment1File = multipartRequest1.getFile("attachment1File");

            String attachment1FileName = "";
            if (attachment1File != null && !attachment1File.isEmpty()) {
                attachment1FileName = attachment1File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm.getId() + File.separator;

                // Create the directory if it doesn't exist
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the file
                File destinationFile = new File(fileLocationURL + attachment1FileName);
                attachment1File.transferTo(destinationFile);
            }
            if (attachment1FileName.equals("") || attachment1FileName == "") {
                attachment1FileName = attachment1File1;
            }

            String pcsDelivery2 = request.getParameter("pcsDelivery2");
            if (pcsDelivery2 == null) {
                pcsDelivery2 = "0";
            }
            String attachment2File2 = request.getParameter("attachment2File2");

            if (pcsDelivery2.equals("0")) {
                attachment2File2 = "";
            }

            MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
            MultipartFile attachment2File = multipartRequest2.getFile("attachment2File");
            String attachment2FileName = "";
            if (attachment2File != null && !attachment2File.isEmpty()) {
                attachment2FileName = attachment2File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm.getId() + File.separator;

                // Create the directory if it doesn't exist
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the file
                File destinationFile = new File(fileLocationURL + attachment2FileName);
                attachment2File.transferTo(destinationFile);
            }
            if (attachment2FileName.equals("") || attachment2FileName == "") {
                attachment2FileName = attachment2File2;
            }

            String pcsDelivery3 = request.getParameter("pcsDelivery3");
            if (pcsDelivery3 == null) {
                pcsDelivery3 = "0";
            }
            String attachment3File3 = request.getParameter("attachment3File3");

            if (pcsDelivery3.equals("0")) {
                attachment3File3 = "";
            }

            MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
            MultipartFile attachment3File = multipartRequest3.getFile("attachment3File");
            String attachment3FileName = "";
            if (attachment3File != null && !attachment3File.isEmpty()) {
                attachment3FileName = attachment3File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm.getId() + File.separator;

                // Create the directory if it doesn't exist
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the file
                File destinationFile = new File(fileLocationURL + attachment3FileName);
                attachment3File.transferTo(destinationFile);
            }
            if (attachment3FileName.equals("") || attachment3FileName == "") {
                attachment3FileName = attachment3File3;
            }

            String pcsDelivery4 = request.getParameter("pcsDelivery4");
            if (pcsDelivery4 == null) {
                pcsDelivery4 = "0";
            }
            String attachment4File4 = request.getParameter("attachment4File4");

            if (pcsDelivery4.equals("0")) {
                attachment4File4 = "";
            }

            MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
            MultipartFile attachment4File = multipartRequest4.getFile("attachment4File");
            String attachment4FileName = "";
            if (attachment4File != null && !attachment4File.isEmpty()) {
                attachment4FileName = attachment4File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm.getId() + File.separator;

                // Create the directory if it doesn't exist
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the file
                File destinationFile = new File(fileLocationURL + attachment4FileName);
                attachment4File.transferTo(destinationFile);
            }
            if (attachment4FileName.equals("") || attachment4FileName == "") {
                attachment4FileName = attachment4File4;
            }

            String chargeInstall1 = request.getParameter("chargeInstall1");
            if (chargeInstall1 == null) {
                chargeInstall1 = "0";
            } else {
                chargeInstall1 = "1";
            }
            String chargeInstall1qua = request.getParameter("chargeInstall1qua");
            if (chargeInstall1qua == null) {
                chargeInstall1qua = "";
            }
            String chargeInstall2 = request.getParameter("chargeInstall2");
            if (chargeInstall2 == null) {
                chargeInstall2 = "0";
            } else {
                chargeInstall2 = "1";
            }
            String chargeInstall2qua = request.getParameter("chargeInstall2qua");
            if (chargeInstall2qua == null) {
                chargeInstall2qua = "";
            }
            String chargeInstall3 = request.getParameter("chargeInstall3");
            if (chargeInstall3 == null) {
                chargeInstall3 = "0";
            } else {
                chargeInstall3 = "1";
            }
            String chargeInstall3qua = request.getParameter("chargeInstall3qua");
            if (chargeInstall3qua == null) {
                chargeInstall3qua = "";
            }
            String chargeInstall4 = request.getParameter("chargeInstall4");
            if (chargeInstall4 == null) {
                chargeInstall4 = "0";
            } else {
                chargeInstall4 = "1";
            }
            String chargeInstall4qua = request.getParameter("chargeInstall4qua");
            if (chargeInstall4qua == null) {
                chargeInstall4qua = "";
            }
            String chargeInstall5 = request.getParameter("chargeInstall5");
            if (chargeInstall5 == null) {
                chargeInstall5 = "0";
            } else {
                chargeInstall5 = "1";
            }
            String chargeInstall5qua = request.getParameter("chargeInstall5qua");
            if (chargeInstall5qua == null) {
                chargeInstall5qua = "";
            }
            String chargeInstall6 = request.getParameter("chargeInstall6");
            if (chargeInstall6 == null) {
                chargeInstall6 = "0";
            } else {
                chargeInstall6 = "1";
            }
            String chargeInstall6qua = request.getParameter("chargeInstall6qua");
            if (chargeInstall6qua == null) {
                chargeInstall6qua = "";
            }
            String chargeInstall7 = request.getParameter("chargeInstall7");
            if (chargeInstall7 == null) {
                chargeInstall7 = "0";
            } else {
                chargeInstall7 = "1";
            }
            String chargeInstall7qua = request.getParameter("chargeInstall7qua");
            if (chargeInstall7qua == null) {
                chargeInstall7qua = "";
            }

            String guns = request.getParameter("guns");
            String others = request.getParameter("others");
            String Fromdate = request.getParameter("Fromdate");
            String Todate = request.getParameter("Todate");
            String budgetallocated = request.getParameter("budgetallocated");
            String othersDetails = request.getParameter("othersDetails");

//        String approvalName = request.getParameter("approvalName");
            String country = request.getParameter("country");
            String state5 = request.getParameter("state5");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String houseno = request.getParameter("houseno");
            String ProjectProfile = request.getParameter("ProjectProfile");
            String profitcenter = request.getParameter("profitcenter");
            String CompanyCode = request.getParameter("CompanyCode");
            String Plant = request.getParameter("plant");
            String ProjectType = request.getParameter("ProjectType");
            String ProjectCurrency = request.getParameter("ProjectCurrency");
            String InvestmentProfile = request.getParameter("InvestmentProfile");
//	String Discom = request.getParameter("Discom");
            String ChargePoints = request.getParameter("ChargePoints");
            String NoOfCharger = request.getParameter("NoOfCharger");
            String overallstations = request.getParameter("overallstations");
            String stationAc = request.getParameter("stationAc");
            String stationDc = request.getParameter("stationDc");
            String stationname = request.getParameter("stationname");
            String stationtype = request.getParameter("stationtype");
            String tenant = request.getParameter("tenant");
            String chargingrate = request.getParameter("chargingrate");

//        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
            String sitesurvey = request.getParameter("sitesurvey");
            String Survey = request.getParameter("Survey");
            if ("siteSurveynotcreated".equals(Survey)) {
                Survey = "0";
            } else {
                Survey = "1";
            }

            String projectTimelineCategory = request.getParameter("projectTimelineCategory");
            String totalKwRating = request.getParameter("totalKwRating");
            String specificDateFromClient = request.getParameter("specificDateFromClient");
            if (specificDateFromClient == null) {
                specificDateFromClient = "";
            }
            String totalChargerCapacity = request.getParameter("totalChargerCapacity");
            String chargerStationAccessType = request.getParameter("chargerStationAccessType");
            String auxiliaryLoadOfStation = request.getParameter("auxiliaryLoadOfStation");
            if (auxiliaryLoadOfStation == null) {
                auxiliaryLoadOfStation = "";
            }
            String chargingRetePerUnit = request.getParameter("chargingRetePerUnit");
            String noOfEvsToBeChanged = request.getParameter("noOfEvsToBeChanged");
            String chargeInstall8qua = request.getParameter("chargeInstall8qua");
            if (chargeInstall8qua == null) {
                chargeInstall8qua = "";
            }

            String chargeInstall8 = request.getParameter("chargeInstall8");
            if (chargeInstall8 == null) {
                chargeInstall8 = "0";
            } else {
                chargeInstall8 = "1";
            }
            String chargeInstall9qua = request.getParameter("chargeInstall9qua");
            if (chargeInstall9qua == null) {
                chargeInstall9qua = "";
            }
            String chargeInstall9 = request.getParameter("chargeInstall9");
            if (chargeInstall9 == null) {
                chargeInstall9 = "0";
            } else {
                chargeInstall9 = "1";
            }

            String anchoreCustomer = request.getParameter("anchoreCustomer");
            String canopyVarient = request.getParameter("canopyVarient");
            if (canopyVarient == null) {
                canopyVarient = "";
            }
            String scopeofChargeZone = request.getParameter("scopeofChargeZone");
            String totalMW = request.getParameter("totalMW");

            oapForm.setDocumentNo(documentNo);
            oapForm.setPcsName(pcsName);
            oapForm.setDate(date);
            // Your existing code
            oapForm.setDocumentRevisionNo(
                    documentRevisonNo == null || documentRevisonNo.isEmpty()
                            ? "R0"
                            : "R" + (Integer.parseInt(documentRevisonNo.substring(1)) + 1)
            );

            oapForm.setProjectName(projectName);
            oapForm.setPcsCityHighway(city_highway);
            oapForm.setPcsAddress(pcsAddress);
            oapForm.setPcsTypeCity(pcsType1);
            oapForm.setPcsTypeHighway(pcsType2);
            oapForm.setPcsTypeOtherCheck(pcsType3);
            oapForm.setPcsTypeOther(pcstypeother);
            oapForm.setPcsModelDoco(pcsModel);
            oapForm.setPcsModelCoco(pcsMode2);
            oapForm.setPcsModelDodo(pcsMode3);
            oapForm.setPcsModelSaas(pcsMode5);
            oapForm.setPcsModelOtherCheck(pcsMode4);
            oapForm.setPcsModelOther(pcsModelother);
            oapForm.setPcsCoordinates(pcscoordinates);
            oapForm.setMobileNo(mobileNo);
            oapForm.setEmail(email);
            oapForm.setAlternateMobileNo(alternatemobileNo);
            oapForm.setClientDetails(clientDetails);
            oapForm.setSpecificRequriementsClients(clientRequiremts);
            oapForm.setClientScope(scope);
            oapForm.setSalesLeadName(salesName);
            oapForm.setDepartment(department);
            oapForm.setDesignation(designation);
            oapForm.setSalesDate(date1);
            oapForm.setSignature("");
            oapForm.setAgreementLoa(pcsDelivery1);
            oapForm.setOwnerShipDocument(pcsDelivery2);
            oapForm.setPreliminarySiteSurvey(pcsDelivery3);
            oapForm.setConsentLetterNoc(pcsDelivery4);
            oapForm.setKwAc77(chargeInstall1);
            oapForm.setKwAcQuatity77(chargeInstall1qua);
            oapForm.setKwDc15(chargeInstall2);
            oapForm.setKwDcQuatity15(chargeInstall2qua);
            oapForm.setKwDc30(chargeInstall3);
            oapForm.setKwDcQuatity30(chargeInstall3qua);
            oapForm.setKwDc60(chargeInstall4);
            oapForm.setKwDcQuatity60(chargeInstall4qua);
            oapForm.setKwDc120(chargeInstall5);
            oapForm.setKwDcQuatity120(chargeInstall5qua);

            oapForm.setKwDc180(chargeInstall6);
            oapForm.setKwDcQuatity180(chargeInstall6qua);
            oapForm.setKw240(chargeInstall7);
            oapForm.setKwQuatity240(chargeInstall7qua);

            oapForm.setNoOfGuns(guns);
            oapForm.setOthers(others);
            oapForm.setTimeLineFromDate(Fromdate);
            oapForm.setTimeLineToDate(Todate);
            oapForm.setProjectBudgetAllocated(budgetallocated);
            oapForm.setOthersDetails(othersDetails);
//        oapForm.setOapMaster(oapMaster);
            oapForm.setCreatedDate(Fromdate);
            oapForm.setUserId(username1);
            oapForm.setCreatedDate(today);
            oapForm.setFlagStatus(6);
            oapForm.setAggrementAttach(attachment1FileName);
            oapForm.setOwnershipAttach(attachment2FileName);
            oapForm.setPreliminaryAttach(attachment3FileName);
            oapForm.setConsentAttach(attachment4FileName);
            oapForm.setState(state5);
            oapForm.setCountry(country);
            oapForm.setCity(city);
            oapForm.setDistrict(district);
            oapForm.setHouseNo(houseno);
            oapForm.setProjectProfile(ProjectProfile);
            oapForm.setProjectCenter(profitcenter);
            oapForm.setCompanyCode(CompanyCode);
            oapForm.setPlant(Plant);
            oapForm.setProjectType(ProjectType);
            oapForm.setProjectCurrency(ProjectCurrency);
            oapForm.setInverstmentProfile(InvestmentProfile);
//	oapForm.setDiscom(Discom);
            oapForm.setNoOfChargePoints(ChargePoints);
            oapForm.setNoOfCharger(NoOfCharger);
            oapForm.setOverallStationCapacityKw(overallstations);
            oapForm.setStationAcCapacityKw(stationAc);
            oapForm.setStationDcCapacityKw(stationDc);
            oapForm.setStationName(stationname);
            oapForm.setStationType(stationtype);
            oapForm.setTenant(tenant);
            oapForm.setChargingRatePerUnit(chargingrate);
            oapForm.setSiteSurvey(sitesurvey);
            oapForm.setSurveyRadio(Integer.parseInt(Survey));

            oapForm.setProjectTimelineCategory(projectTimelineCategory);
            oapForm.setTotalKwRating(totalKwRating);
            oapForm.setSpecificDateFromClient(specificDateFromClient);
            oapForm.setTotalChargerCapacity(totalChargerCapacity);
            oapForm.setChargerStationAccessType(chargerStationAccessType);
            oapForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
            oapForm.setChargingRetePerUnit(chargingRetePerUnit);
            oapForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
            oapForm.setKw360(chargeInstall8);
            oapForm.setKwQuatity360(chargeInstall8qua);
            oapForm.setKw720(chargeInstall9);
            oapForm.setKwQuatity720(chargeInstall9qua);
            oapForm.setAnchoreCustomer(anchoreCustomer);
            oapForm.setCanopyVarient(canopyVarient);
            oapForm.setScopeOfchargeZone(scopeofChargeZone);
            oapForm.setTotalMegaWatt(totalMW);

            oapFormService.update(oapForm);

            String documentno = oapForm.getDocumentNo();
            String mainusername = oapForm.getUserId();
            String mailcreteddate = oapForm.getCreatedDate();
            int id1 = oapForm.getId();

            String[] chargerType = request.getParameterValues("chargerType");
            String[] charger = request.getParameterValues("charger");
            String[] chargerOther = request.getParameterValues("chargerOther");
            String[] chargerCapacityKW = request.getParameterValues("chargerCapacityKW");
            String[] chargermodel = request.getParameterValues("chargermodel");
            String[] connectorType = request.getParameterValues("connectorType");
            String[] connectorOther = request.getParameterValues("connectorOther");
            String[] noofconnectors = request.getParameterValues("noofconnectors");
            String[] noofchargers = request.getParameterValues("noofchargers");
            String[] chargingrateperunit = request.getParameterValues("chargingrateperunit");

            for (int ct = 0; ct < chargerType.length; ct++) {
                String c = chargerType[ct];

                if (c != null && !c.isEmpty()) {
                    ChargerInstallationDetails cid = new ChargerInstallationDetails();

                    cid.setOapId(id1);
                    cid.setChargerType(chargerType[ct]);
                    cid.setCharger(charger[ct]);
                    cid.setChargerOther(chargerOther[ct]);
                    cid.setChargerCapacityKW(chargerCapacityKW[ct]);
                    cid.setChargermodel(chargermodel[ct]);
                    cid.setConnectorType(connectorType[ct]);
                    cid.setConnectorTypeOther(connectorOther[ct]);
                    cid.setNoofconnectors(noofconnectors[ct]);
                    cid.setNoofchargers(noofchargers[ct]);
                    cid.setChargingrateperunit(chargingrateperunit[ct]);

                    chargerInstallationDetailsService.create(cid);

                    ChargerInstallationDetailsHistory cidH = new ChargerInstallationDetailsHistory();

                    cidH.setOapId(id1);
                    cidH.setChargerInstalId(cid.getId());
                    cidH.setChargerType(chargerType[ct]);
                    cidH.setCharger(charger[ct]);
                    cidH.setChargerOther(chargerOther[ct]);
                    cidH.setChargerCapacityKW(chargerCapacityKW[ct]);
                    cidH.setChargermodel(chargermodel[ct]);
                    cidH.setConnectorType(connectorType[ct]);
                    cidH.setConnectorTypeOther(connectorOther[ct]);
                    cidH.setNoofconnectors(noofconnectors[ct]);
                    cidH.setNoofchargers(noofchargers[ct]);
                    cidH.setChargingrateperunit(chargingrateperunit[ct]);

                    chargerInstallationDetailsHistoryService.create(cidH);
                }
            }

            OapForm oapForm1 = oapFormService.readById(id1);

            CrcForm crcForm = crcFormService.readByoapId(id1 + "");
            crcForm.setFlagStatus(800);
            crcFormService.update(crcForm);

            String[] surveyNo = request.getParameterValues("surveyNo");
            int z = 0;
            int id8 = 0;
            for (String s : surveyNo) {
                if (s != null && !s.isEmpty()) {
                    OapSurveyAttachment oapSurveyAttachment = new OapSurveyAttachment();
                    oapSurveyAttachment.setSurveyNo(surveyNo[z]);
                    oapSurveyAttachment.setOapId(id1);
                    oapSurveyAttachmentService.create(oapSurveyAttachment);

                    z++;
                    id8 = oapSurveyAttachment.getId();
                }
            }
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            // multi attachment
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP"
                    + File.separator + id1;
            File f1 = new File(path);
            boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

            List<MultipartFile> files1 = multipartRequest.getFiles("attach");
            String[] description = request.getParameterValues("descriptions");
            int a = 0;
            int id4 = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "OAP"
                                + File.separator + id1 + File.separator;

                        File directory = new File(fileLocationURL);
                        if (!directory.exists()) {
                            directory.mkdirs(); // Create the directory if it doesn't exist
                        }

                        File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        try {
                            file1.transferTo(destinationFile1); // Ensure proper exception handling
                        } catch (Exception e) {
                            e.printStackTrace(); // Handle the error or log it
                        }

                        OapMultiAttachment oapMultiAttachment = new OapMultiAttachment();

                        oapMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        oapMultiAttachment.setDescription(description[a]);
                        oapMultiAttachment.setOapForm(oapForm1);
                        oapMultiAttachmentService.create(oapMultiAttachment);
                        a++;
                        id4 = oapMultiAttachment.getId();
                    }
                }

            }

//        OapFormApproval oapFormApproval5 = oapFormApprovalService.readByDeltecodes(id);
//
//        int formid = oapFormApproval5.getId();
//        List list44 = oapFormApprovalUserService.readByDleteCode(formid);
//
//        for (Object o : list44) {
//            OapFormApprovalUser oapFormApprovalUser = (OapFormApprovalUser) o;
//            int id3 = oapFormApprovalUser.getId();
//            oapFormApprovalUserService.delete(id3);
//
//        }
//
//        oapFormApprovalService.delete(formid);
//        // approval name drop down relted code
//        List approval_list = oapMasterUserService.readByIdToList(approvalName);
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String username = user.getLoginName();
//        EmployeeMaster employeeMaster = employeeMasterService.read(username);
//        String employeeCode = employeeMaster.getEmployeeCode();
//
//        OapFormApproval oapFormApproval = new OapFormApproval();
//        oapFormApproval.setOapForm(oapForm1);
//        oapFormApproval.setTotalApproval(approval_list.size() + "");
//        oapFormApproval.setApprovalStatus("0");
//        oapFormApproval.setApprovalRemark("add");
//        oapFormApproval.setUserId(employeeCode);
//        oapFormApproval.setCurrentApproval("1");
//        oapFormApprovalService.create(oapFormApproval);
//
//        int approveId = oapFormApproval.getId();
//        OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);
//
//        int j = 0;
//
//        for (Object o : approval_list) {
//            j++;
//            OapMasterUser oap1 = (OapMasterUser) o;
//            OapFormApprovalUser oap = new OapFormApprovalUser();
//            oap.setOapFormApproval(approveId);
//            oap.setOapForm(id1);
//            oap.setUserId(oap1.getUserId());
//            oap.setLevel("1");
//            oap.setApprovalStatus("0");
//            oapFormApprovalUserService.create(oap);
//
//            String userid = oap.getUserId();
//            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
//            String mail_to = employeeMaster2.getEmailId();
//
//            EmailTemplate emailTemplate = emailTemplateService.readById(32);
//            String mail_from = "";
//
//            String subject = emailTemplate.getSubject();
//            String msg = emailTemplate.getBodytext();
////	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
//            String Oap_form = "OAP Form";
//
//            msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
//            msg = msg.replaceAll("\\{documentno\\}", documentno);
//            msg = msg.replaceAll("\\{username\\}", mainusername);
////	    msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);
//
//            SendMail s = new SendMail();
//            s.sendMail(mail_from, mail_to, subject, msg);
//
//        }
            // reverse edit
            OapFormHistory oapFormHistory1 = oapFormHistoryService.readById(id1);
//	String lastHistory = oapFormHistory1.getHistory();
            String currentDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
            String history = "";
            OapFormHistory oapFormHistory = new OapFormHistory();

            oapFormHistory.setDocumentNo(documentNo);
            oapFormHistory.setPcsName(pcsName);
            oapFormHistory.setDate(date);
            // Your existing code
            oapFormHistory.setDocumentRevisionNo(
                    documentRevisonNo == null || documentRevisonNo.isEmpty()
                            ? "R0"
                            : "R" + (Integer.parseInt(documentRevisonNo.substring(1)) + 1)
            );

            oapFormHistory.setProjectName(projectName);
            oapFormHistory.setPcsCityHighway(city_highway);
            oapFormHistory.setPcsAddress(pcsAddress);
            oapFormHistory.setPcsTypeCity(pcsType1);
            oapFormHistory.setPcsTypeHighway(pcsType2);
            oapFormHistory.setPcsTypeOtherCheck(pcsType3);
            oapFormHistory.setPcsTypeOther(pcstypeother);
            oapFormHistory.setPcsModelDoco(pcsModel);
            oapFormHistory.setPcsModelCoco(pcsMode2);
            oapFormHistory.setPcsModelDodo(pcsMode3);
            oapFormHistory.setPcsModelSaas(pcsMode5);
            oapFormHistory.setPcsModelOtherCheck(pcsMode4);
            oapFormHistory.setPcsModelOther(pcsModelother);
            oapFormHistory.setPcsCoordinates(pcscoordinates);
            oapFormHistory.setMobileNo(mobileNo);
            oapFormHistory.setEmail(email);
            oapFormHistory.setAlternateMobileNo(alternatemobileNo);
            oapFormHistory.setClientDetails(clientDetails);
            oapFormHistory.setSpecificRequriementsClients(clientRequiremts);
            oapFormHistory.setClientScope(scope);
            oapFormHistory.setSalesLeadName(salesName);
            oapFormHistory.setDepartment(department);
            oapFormHistory.setDesignation(designation);
            oapFormHistory.setSalesDate(date1);
            oapFormHistory.setSignature("");
            oapFormHistory.setAgreementLoa(pcsDelivery1);
            oapFormHistory.setOwnerShipDocument(pcsDelivery2);
            oapFormHistory.setPreliminarySiteSurvey(pcsDelivery3);
            oapFormHistory.setConsentLetterNoc(pcsDelivery4);
            oapFormHistory.setKwAc77(chargeInstall1);
            oapFormHistory.setKwAcQuatity77(chargeInstall1qua);
            oapFormHistory.setKwDc15(chargeInstall2);
            oapFormHistory.setKwDcQuatity15(chargeInstall2qua);
            oapFormHistory.setKwDc30(chargeInstall3);
            oapFormHistory.setKwDcQuatity30(chargeInstall3qua);
            oapFormHistory.setKwDc60(chargeInstall4);
            oapFormHistory.setKwDcQuatity60(chargeInstall4qua);
            oapFormHistory.setKwDc120(chargeInstall5);
            oapFormHistory.setKwDcQuatity120(chargeInstall5qua);

            oapFormHistory.setKwDc180(chargeInstall6);
            oapFormHistory.setKwDcQuatity180(chargeInstall6qua);
            oapFormHistory.setKw240(chargeInstall7);
            oapFormHistory.setKwQuatity240(chargeInstall7qua);

            oapFormHistory.setNoOfGuns(guns);
            oapFormHistory.setOthers(others);
            oapFormHistory.setTimeLineFromDate(Fromdate);
            oapFormHistory.setTimeLineToDate(Todate);
            oapFormHistory.setProjectBudgetAllocated(budgetallocated);
            oapFormHistory.setOthersDetails(othersDetails);
//        oapFormHistory.setOapMaster(oapMaster.getId());
            oapFormHistory.setCreatedDate(Fromdate);
            oapFormHistory.setUserId(username1);
            oapFormHistory.setCreatedDate(today);
            oapFormHistory.setFlagStatus(1);
            oapFormHistory.setAggrementAttach(attachment1FileName);
            oapFormHistory.setOwnershipAttach(attachment2FileName);
            oapFormHistory.setPreliminaryAttach(attachment3FileName);
            oapFormHistory.setConsentAttach(attachment4FileName);
            oapFormHistory.setState(state5);
            oapFormHistory.setCountry(country);
            oapFormHistory.setCity(city);
            oapFormHistory.setDistrict(district);
            oapFormHistory.setHouseNo(houseno);
            oapFormHistory.setProjectProfile(ProjectProfile);
            oapFormHistory.setProjectCenter(profitcenter);
            oapFormHistory.setCompanyCode(CompanyCode);
            oapFormHistory.setPlant(Plant);
            oapFormHistory.setProjectType(ProjectType);
            oapFormHistory.setProjectCurrency(ProjectCurrency);
            oapFormHistory.setInverstmentProfile(InvestmentProfile);
//	oapForm.setDiscom(Discom);
            oapFormHistory.setNoOfChargePoints(ChargePoints);
            oapFormHistory.setNoOfCharger(NoOfCharger);
            oapFormHistory.setOverallStationCapacityKw(overallstations);
            oapFormHistory.setStationAcCapacityKw(stationAc);
            oapFormHistory.setStationDcCapacityKw(stationDc);
            oapFormHistory.setStationName(stationname);
            oapFormHistory.setStationType(stationtype);
            oapFormHistory.setTenant(tenant);
            oapFormHistory.setChargingRatePerUnit(chargingrate);
            oapFormHistory.setOapId(id1);
            oapFormHistory.setDateTime(currentDateTime);
            oapFormHistory.setSiteSurvey(sitesurvey);
            oapFormHistory.setSurveyRadio(Integer.parseInt(Survey));

            oapFormHistory.setProjectTimelineCategory(projectTimelineCategory);
            oapFormHistory.setTotalKwRating(totalKwRating);
            oapFormHistory.setSpecificDateFromClient(specificDateFromClient);
            oapFormHistory.setTotalChargerCapacity(totalChargerCapacity);
            oapFormHistory.setChargerStationAccessType(chargerStationAccessType);
            oapFormHistory.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
            oapFormHistory.setChargingRetePerUnit(chargingRetePerUnit);
            oapFormHistory.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
            oapFormHistory.setKw360(chargeInstall8);
            oapFormHistory.setKwQuatity360(chargeInstall8qua);
            oapFormHistory.setKw720(chargeInstall9);
            oapFormHistory.setKwQuatity720(chargeInstall9qua);
            oapFormHistory.setAnchoreCustomer(anchoreCustomer);
            oapFormHistory.setCanopyVarient(canopyVarient);
            oapFormHistory.setScopeOfchargeZone(scopeofChargeZone);
            oapFormHistory.setTotalMegaWatt(totalMW);

//	oapFormHistory.setHistory(documentRevisonNo);
            List lastHistory1 = oapFormHistoryService.readBylasttimestatus(id1); // Implement this method in service
            int size = lastHistory1.size();

            String newHistory = "R" + size;
            oapFormHistory.setHistory(newHistory);

            oapFormHistoryService.create(oapFormHistory);

            int id2 = oapFormHistory.getId();
            String oaphistory = oapFormHistory.getHistory();

// multi attachment
            int b = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        OapMultiAttachmentHistory oapMultiAttachmentHistory = new OapMultiAttachmentHistory();

                        oapMultiAttachmentHistory.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        oapMultiAttachmentHistory.setDescription(description[b]);
                        oapMultiAttachmentHistory.setOapForm(id1);
                        oapMultiAttachmentHistory.setHistory(oaphistory);
                        oapMultiAttachmentHistory.setOapHistoryId(id2);
                        oapMultiAttachmentHistory.setOapMultiId(id4);
                        oapMultiAttachmentHistoryService.create(oapMultiAttachmentHistory);
                        a++;
                    }
                }
            }
//survey history attachment
            int x = 0;

            for (String s : surveyNo) {
                if (s != null && !s.isEmpty()) {
                    OapSurveyAttachmentHistory oapSurveyAttachmentHistory = new OapSurveyAttachmentHistory();
                    oapSurveyAttachmentHistory.setSurveyNo(surveyNo[x]);
                    oapSurveyAttachmentHistory.setOapId(id1);
                    oapSurveyAttachmentHistory.setDateTime(currentDateTime);
                    oapSurveyAttachmentHistory.setHistory(oaphistory);
                    oapSurveyAttachmentHistory.setOapSurveyAttachmentId(id8);
                    oapSurveyAttachmentHistory.setOapFormHistoryId(id2);
                    oapSurveyAttachmentHistoryService.create(oapSurveyAttachmentHistory);

                    x++;
                }
            }
            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity(" OAP Edit");
            oapLogMaster.setActivityBy(username1);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("OAP Recycle Edited");
            oapLogMaster.setOapId(id1);
            oapLogMaster.setComments("");
            oapLogMasterService.create(oapLogMaster);

            session1.setAttribute("successMessage", " OAPForm Reverse Edited Done successfully");
        } else {
            session1.setAttribute("failureMessage", "The OAPForm  Already Reverse Edited Done successfully");

        }
        mv.setViewName("redirect:oapForm.htm?act=oapFormAppovalList");
        return mv;
    }

    public ModelAndView oapPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        OapFormApproval oapFormApproval = oapFormApprovalService.readByoapappid(id);
        int approveid = oapFormApproval.getId();

        List list0 = oapFormApprovalCommentService.readByIds(id);

        List chargeInst = chargerInstallationDetailsService.readByoapId(id);
        mv.getModelMap().put("chargeInst", chargeInst);

        String discomType = "";
        String connectionTypeName = "";

        String discom = oapForm.getDiscom();
        if (discom != null && !discom.isEmpty()) {
            try {
                int discomId = Integer.parseInt(discom);
                DiscomMaster discomMaster = discomMasterService.readById(discomId);

                if (discomMaster != null && discomMaster.getDiscomType() != null) {
                    discomType = discomMaster.getDiscomType();
                }
            } catch (NumberFormatException e) {

            }
        }

        String connectionType = oapForm.getConnectionType();
        if (connectionType != null && !connectionType.isEmpty()) {
            try {
                int connectionTypeId = Integer.parseInt(connectionType);
                ConnectionType connectionTypeObj = connectionTypeService.readById(connectionTypeId);

                if (connectionTypeObj != null && connectionTypeObj.getConnectionType() != null) {
                    connectionTypeName = connectionTypeObj.getConnectionType();
                }
            } catch (NumberFormatException e) {

            }
        }

        mv.getModelMap().put("Discom1", discomType);
        mv.getModelMap().put("connection", connectionTypeName);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", oapForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);

        mv.setViewName("Oap/oapPrint");
        return mv;
    }

    public ModelAndView approvedEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

//	String oapFormattach = request.getParameter("oapFormattach");
//	String oapFormmulti = request.getParameter("oapFormmulti");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

        String Tenant = oapForm.getTenant();
        String StationType = oapForm.getStationType();
        String Currency = oapForm.getProjectCurrency();
        String ProjectType = oapForm.getProjectType();
        String Ivestmentprofile = oapForm.getInverstmentProfile();
        String ProjectCenter = oapForm.getProjectCenter();
        String CompanyCode = oapForm.getCompanyCode();
        String ProjectProfile = oapForm.getProjectProfile();
        String Discom = oapForm.getDiscom();
        String plant = oapForm.getPlant();
        mv.getModelMap().put("Discom", Discom);
        mv.getModelMap().put("ProjectProfile", ProjectProfile);
        mv.getModelMap().put("CompanyCode", CompanyCode);
        mv.getModelMap().put("ProjectCenter", ProjectCenter);
        mv.getModelMap().put("Ivestmentprofile", Ivestmentprofile);
        mv.getModelMap().put("ProjectType", ProjectType);
        mv.getModelMap().put("Currency", Currency);
        mv.getModelMap().put("StationType", StationType);
        mv.getModelMap().put("Tenant", Tenant);
        mv.getModelMap().put("plant", plant);

        List list0 = tenantService.read();
        List list2 = stationTypeService.read();
        List list3 = currencyMasterService.read();
        List list4 = projectTypeService.read();
        List list6 = investmentProfileService.read();
        List list7 = profitCenterService.read();
        List list8 = plantMastersService.read();
        List list9 = companyMasterService.read();
        List list11 = projectProfileService.read();
        List list12 = discomMasterService.read();

        request.setAttribute("list0", list0);
        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);
        request.setAttribute("list4", list4);
        request.setAttribute("list6", list6);
        request.setAttribute("list7", list7);
        request.setAttribute("list8", list8);
        request.setAttribute("list9", list9);
        request.setAttribute("list11", list11);
        request.setAttribute("list12", list12);
        int oapmasterId = oapForm.getOapMaster().getId();
        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);
        List list10 = oapMasterService.read();

        mv.getModelMap().put("oapForm", oapForm);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("oapmasterId", oapmasterId);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list10", list10);

        mv.setViewName("Oap/oapFormAppovedEdit");
        return mv;
    }

    public ModelAndView approvedEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        String documentNo = request.getParameter("documentNo");
        String pcsName = request.getParameter("pcsName");
        String date = request.getParameter("date");
        String documentRevisonNo = request.getParameter("documentRevisonNo");
        String projectName = request.getParameter("projectName");
        String city_highway = request.getParameter("city/highway");
        String pcsAddress = request.getParameter("pcsAddress");
        String pcsType1 = request.getParameter("pcsType1");
        if (pcsType1 == null) {
            pcsType1 = "0";
        } else {
            pcsType1 = "1";
        }
        String pcsType2 = request.getParameter("pcsType2");
        if (pcsType2 == null) {
            pcsType2 = "0";
        } else {
            pcsType2 = "1";
        }
        String pcsType3 = request.getParameter("pcsType3");
        if (pcsType3 == null) {
            pcsType3 = "0";
        } else {
            pcsType3 = "1";
        }
        String pcstypeother = request.getParameter("pcstypeother");
        if (pcstypeother == null) {
            pcstypeother = "";
        }
        String pcsModel = request.getParameter("pcsModel");
        if (pcsModel == null) {
            pcsModel = "0";
        } else {
            pcsModel = "1";
        }
        String pcsMode2 = request.getParameter("pcsMode2");
        if (pcsMode2 == null) {
            pcsMode2 = "0";
        } else {
            pcsMode2 = "1";
        }
        String pcsMode3 = request.getParameter("pcsMode3");
        if (pcsMode3 == null) {
            pcsMode3 = "0";
        } else {
            pcsMode3 = "1";
        }
        String pcsMode4 = request.getParameter("pcsMode4");
        if (pcsMode4 == null) {
            pcsMode4 = "0";
        } else {
            pcsMode4 = "1";
        }
        String pcsModelother = request.getParameter("pcsModelother");
        if (pcsModelother == null) {
            pcsModelother = "";
        }
        String pcscoordinates = request.getParameter("pcscoordinates");
        String mobileNo = request.getParameter("mobileNo");
        String email = request.getParameter("email");
        String alternatemobileNo = request.getParameter("alternatemobileNo");
        String clientDetails = request.getParameter("clientDetails");
        String clientRequiremts = request.getParameter("clientRequiremts");
        String scope = request.getParameter("scope");
        String salesName = request.getParameter("salesName");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String date1 = request.getParameter("date1");
        String pcsDelivery1 = request.getParameter("pcsDelivery1");
        if (pcsDelivery1 == null) {
            pcsDelivery1 = "0";
        }

        String attachment1File1 = request.getParameter("attachment1File1");

        if (pcsDelivery1.equals("0")) {
            attachment1File1 = "";
        }

        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile attachment1File = multipartRequest1.getFile("attachment1File");

        String attachment1FileName = "";
        if (attachment1File != null && !attachment1File.isEmpty()) {
            attachment1FileName = attachment1File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment1FileName);
            attachment1File.transferTo(destinationFile);
        }
        if (attachment1FileName.equals("") || attachment1FileName == "") {
            attachment1FileName = attachment1File1;
        }

        String pcsDelivery2 = request.getParameter("pcsDelivery2");
        if (pcsDelivery2 == null) {
            pcsDelivery2 = "0";
        }
        String attachment2File2 = request.getParameter("attachment2File2");

        if (pcsDelivery2.equals("0")) {
            attachment2File2 = "";
        }

        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile attachment2File = multipartRequest2.getFile("attachment2File");
        String attachment2FileName = "";
        if (attachment2File != null && !attachment2File.isEmpty()) {
            attachment2FileName = attachment2File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment2FileName);
            attachment2File.transferTo(destinationFile);
        }
        if (attachment2FileName.equals("") || attachment2FileName == "") {
            attachment2FileName = attachment2File2;
        }

        String pcsDelivery3 = request.getParameter("pcsDelivery3");
        if (pcsDelivery3 == null) {
            pcsDelivery3 = "0";
        }
        String attachment3File3 = request.getParameter("attachment3File3");

        if (pcsDelivery3.equals("0")) {
            attachment3File3 = "";
        }

        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile attachment3File = multipartRequest3.getFile("attachment3File");
        String attachment3FileName = "";
        if (attachment3File != null && !attachment3File.isEmpty()) {
            attachment3FileName = attachment3File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment3FileName);
            attachment3File.transferTo(destinationFile);
        }
        if (attachment3FileName.equals("") || attachment3FileName == "") {
            attachment3FileName = attachment3File3;
        }

        String pcsDelivery4 = request.getParameter("pcsDelivery4");
        if (pcsDelivery4 == null) {
            pcsDelivery4 = "0";
        }
        String attachment4File4 = request.getParameter("attachment4File4");

        if (pcsDelivery4.equals("0")) {
            attachment4File4 = "";
        }

        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile attachment4File = multipartRequest4.getFile("attachment4File");
        String attachment4FileName = "";
        if (attachment4File != null && !attachment4File.isEmpty()) {
            attachment4FileName = attachment4File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment4FileName);
            attachment4File.transferTo(destinationFile);
        }
        if (attachment4FileName.equals("") || attachment4FileName == "") {
            attachment4FileName = attachment4File4;
        }

        String chargeInstall1 = request.getParameter("chargeInstall1");
        if (chargeInstall1 == null) {
            chargeInstall1 = "0";
        } else {
            chargeInstall1 = "1";
        }
        String chargeInstall1qua = request.getParameter("chargeInstall1qua");
        if (chargeInstall1qua == null) {
            chargeInstall1qua = "";
        }
        String chargeInstall2 = request.getParameter("chargeInstall2");
        if (chargeInstall2 == null) {
            chargeInstall2 = "0";
        } else {
            chargeInstall2 = "1";
        }
        String chargeInstall2qua = request.getParameter("chargeInstall2qua");
        if (chargeInstall2qua == null) {
            chargeInstall2qua = "";
        }
        String chargeInstall3 = request.getParameter("chargeInstall3");
        if (chargeInstall3 == null) {
            chargeInstall3 = "0";
        } else {
            chargeInstall3 = "1";
        }
        String chargeInstall3qua = request.getParameter("chargeInstall3qua");
        if (chargeInstall3qua == null) {
            chargeInstall3qua = "";
        }
        String chargeInstall4 = request.getParameter("chargeInstall4");
        if (chargeInstall4 == null) {
            chargeInstall4 = "0";
        } else {
            chargeInstall4 = "1";
        }
        String chargeInstall4qua = request.getParameter("chargeInstall4qua");
        if (chargeInstall4qua == null) {
            chargeInstall4qua = "";
        }
        String chargeInstall5 = request.getParameter("chargeInstall5");
        if (chargeInstall5 == null) {
            chargeInstall5 = "0";
        } else {
            chargeInstall5 = "1";
        }
        String chargeInstall5qua = request.getParameter("chargeInstall5qua");
        if (chargeInstall5qua == null) {
            chargeInstall5qua = "";
        }
        String chargeInstall6 = request.getParameter("chargeInstall6");
        if (chargeInstall6 == null) {
            chargeInstall6 = "0";
        } else {
            chargeInstall6 = "1";
        }
        String chargeInstall6qua = request.getParameter("chargeInstall6qua");
        if (chargeInstall6qua == null) {
            chargeInstall6qua = "";
        }
        String chargeInstall7 = request.getParameter("chargeInstall7");
        if (chargeInstall7 == null) {
            chargeInstall7 = "0";
        } else {
            chargeInstall7 = "1";
        }
        String chargeInstall7qua = request.getParameter("chargeInstall7qua");
        if (chargeInstall7qua == null) {
            chargeInstall7qua = "";
        }

        String guns = request.getParameter("guns");
        String others = request.getParameter("others");
        String Fromdate = request.getParameter("Fromdate");
        String Todate = request.getParameter("Todate");
        String budgetallocated = request.getParameter("budgetallocated");
        String othersDetails = request.getParameter("othersDetails");

        String country = request.getParameter("country");
        String state5 = request.getParameter("state5");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String houseno = request.getParameter("houseno");
        String ProjectProfile = request.getParameter("ProjectProfile");
        String profitcenter = request.getParameter("profitcenter");
        String CompanyCode = request.getParameter("CompanyCode");
        String Plant = request.getParameter("plant");
        String ProjectType = request.getParameter("ProjectType");
        String ProjectCurrency = request.getParameter("ProjectCurrency");
        String InvestmentProfile = request.getParameter("InvestmentProfile");
//	String Discom = request.getParameter("Discom");
        String ChargePoints = request.getParameter("ChargePoints");
        String NoOfCharger = request.getParameter("NoOfCharger");
        String overallstations = request.getParameter("overallstations");
        String stationAc = request.getParameter("stationAc");
        String stationDc = request.getParameter("stationDc");
        String stationname = request.getParameter("stationname");
        String stationtype = request.getParameter("stationtype");
        String tenant = request.getParameter("tenant");
        String chargingrate = request.getParameter("chargingrate");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        oapForm.setDocumentNo(documentNo);
        oapForm.setPcsName(pcsName);
        oapForm.setDate(date);
        // Your existing code
        oapForm.setDocumentRevisionNo(
                documentRevisonNo == null || documentRevisonNo.isEmpty()
                        ? "R0"
                        : "R" + (Integer.parseInt(documentRevisonNo.substring(1)) + 1)
        );

        oapForm.setProjectName(projectName);
        oapForm.setPcsCityHighway(city_highway);
        oapForm.setPcsAddress(pcsAddress);
        oapForm.setPcsTypeCity(pcsType1);
        oapForm.setPcsTypeHighway(pcsType2);
        oapForm.setPcsTypeOtherCheck(pcsType3);
        oapForm.setPcsTypeOther(pcstypeother);
        oapForm.setPcsModelDoco(pcsModel);
        oapForm.setPcsModelCoco(pcsMode2);
        oapForm.setPcsModelDodo(pcsMode3);
        oapForm.setPcsModelOtherCheck(pcsMode4);
        oapForm.setPcsModelOther(pcsModelother);
        oapForm.setPcsCoordinates(pcscoordinates);
        oapForm.setMobileNo(mobileNo);
        oapForm.setEmail(email);
        oapForm.setAlternateMobileNo(alternatemobileNo);
        oapForm.setClientDetails(clientDetails);
        oapForm.setSpecificRequriementsClients(clientRequiremts);
        oapForm.setClientScope(scope);
        oapForm.setSalesLeadName(salesName);
        oapForm.setDepartment(department);
        oapForm.setDesignation(designation);
        oapForm.setSalesDate(date1);
        oapForm.setSignature("");
        oapForm.setAgreementLoa(pcsDelivery1);
        oapForm.setOwnerShipDocument(pcsDelivery2);
        oapForm.setPreliminarySiteSurvey(pcsDelivery3);
        oapForm.setConsentLetterNoc(pcsDelivery4);
        oapForm.setKwAc77(chargeInstall1);
        oapForm.setKwAcQuatity77(chargeInstall1qua);
        oapForm.setKwDc15(chargeInstall2);
        oapForm.setKwDcQuatity15(chargeInstall2qua);
        oapForm.setKwDc30(chargeInstall3);
        oapForm.setKwDcQuatity30(chargeInstall3qua);
        oapForm.setKwDc60(chargeInstall4);
        oapForm.setKwDcQuatity60(chargeInstall4qua);
        oapForm.setKwDc120(chargeInstall5);
        oapForm.setKwDcQuatity120(chargeInstall5qua);

        oapForm.setKwDc180(chargeInstall6);
        oapForm.setKwDcQuatity180(chargeInstall6qua);
        oapForm.setKw240(chargeInstall7);
        oapForm.setKwQuatity240(chargeInstall7qua);

        oapForm.setNoOfGuns(guns);
        oapForm.setOthers(others);
        oapForm.setTimeLineFromDate(Fromdate);
        oapForm.setTimeLineToDate(Todate);
        oapForm.setProjectBudgetAllocated(budgetallocated);
        oapForm.setOthersDetails(othersDetails);
        oapForm.setCreatedDate(Fromdate);
        oapForm.setUserId(username1);
        oapForm.setCreatedDate(today);

        oapForm.setAggrementAttach(attachment1FileName);
        oapForm.setOwnershipAttach(attachment2FileName);
        oapForm.setPreliminaryAttach(attachment3FileName);
        oapForm.setConsentAttach(attachment4FileName);
        oapForm.setState(state5);
        oapForm.setCountry(country);
        oapForm.setCity(city);
        oapForm.setDistrict(district);
        oapForm.setHouseNo(houseno);
        oapForm.setProjectProfile(ProjectProfile);
        oapForm.setProjectCenter(profitcenter);
        oapForm.setCompanyCode(CompanyCode);
        oapForm.setPlant(Plant);
        oapForm.setProjectType(ProjectType);
        oapForm.setProjectCurrency(ProjectCurrency);
        oapForm.setInverstmentProfile(InvestmentProfile);
//	oapForm.setDiscom(Discom);
        oapForm.setNoOfChargePoints(ChargePoints);
        oapForm.setNoOfCharger(NoOfCharger);
        oapForm.setOverallStationCapacityKw(overallstations);
        oapForm.setStationAcCapacityKw(stationAc);
        oapForm.setStationDcCapacityKw(stationDc);
        oapForm.setStationName(stationname);
        oapForm.setStationType(stationtype);
        oapForm.setTenant(tenant);
        oapForm.setChargingRatePerUnit(chargingrate);
        oapFormService.update(oapForm);

        int id1 = oapForm.getId();
        OapForm oapForm1 = oapFormService.readById(id1);
        String username = oapForm1.getUserId();
        String documentno = oapForm1.getDocumentNo();

        EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
        String mail_to = employeeMaster2.getEmailId();

        EmailTemplate emailTemplate = emailTemplateService.readById(77);
        String mail_from = "";

        String subject = emailTemplate.getSubject();
        String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
        String Oap_form = "OAP Form";

        msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
        msg = msg.replaceAll("\\{documentno\\}", documentno);
        msg = msg.replaceAll("\\{username\\}", username);
//	msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);
//	    msg = msg.replaceAll("\\{vendor_code\\}", checkedValues);
//	    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
//	    msg = msg.replaceAll("\\{department\\}", department);

        SendMail s = new SendMail();
        s.sendMail(mail_from, mail_to, subject, msg);

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        // multi attachment
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + id1;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP"
                            + File.separator + id1 + File.separator;

                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs(); // Create the directory if it doesn't exist
                    }

                    File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    try {
                        file1.transferTo(destinationFile1); // Ensure proper exception handling
                    } catch (Exception e) {
                        e.printStackTrace(); // Handle the error or log it
                    }

                    OapMultiAttachment oapMultiAttachment = new OapMultiAttachment();

                    oapMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    oapMultiAttachment.setDescription(description[a]);
                    oapMultiAttachment.setOapForm(oapForm1);
                    oapMultiAttachmentService.create(oapMultiAttachment);
                    a++;
                }
            }

        }

        mv = oapFormAppovalList(request, response);
        return mv;
    }

    public ModelAndView crcPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        CrcForm crcForm = crcFormService.readById(Integer.parseInt(id));

        CrcFormApproval crcFormApproval = crcFormApprovalService.readBycrcid(id);

        int crcformid = crcFormApproval.getId();

        List list0 = crcFormApprovalCommentService.readBycrcformid(crcformid);

        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list", crcForm);
        mv.setViewName("Oap/crcPrint");
        return mv;
    }

    public ModelAndView AllFormsView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        OapForm oapform = oapFormService.readById(Integer.parseInt(id));
        List oaplogmaster = oapLogMasterService.readByOapId(id);

        String discomType = "";
        String connectionTypeName = "";

        String discom = oapform.getDiscom();
        if (discom != null && !discom.isEmpty()) {
            try {
                int discomId = Integer.parseInt(discom);
                DiscomMaster discomMaster = discomMasterService.readById(discomId);

                if (discomMaster != null && discomMaster.getDiscomType() != null) {
                    discomType = discomMaster.getDiscomType();
                }
            } catch (NumberFormatException e) {

            }
        }

        String connectionType = oapform.getConnectionType();
        if (connectionType != null && !connectionType.isEmpty()) {
            try {
                int connectionTypeId = Integer.parseInt(connectionType);
                ConnectionType connectionTypeObj = connectionTypeService.readById(connectionTypeId);

                if (connectionTypeObj != null && connectionTypeObj.getConnectionType() != null) {
                    connectionTypeName = connectionTypeObj.getConnectionType();
                }
            } catch (NumberFormatException e) {

            }
        }

        mv.getModelMap().put("Discom1", discomType);
        mv.getModelMap().put("connection", connectionTypeName);
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);

        List chargeInst = chargerInstallationDetailsService.readByoapId(id);
        mv.getModelMap().put("chargeInst", chargeInst);

        OapFormApproval oapFormApproval = oapFormApprovalService.readByoapappid(id);
        int approveid = oapFormApproval.getId();

        List list0 = oapFormApprovalCommentService.readByIds(id);
        mv.getModelMap().put("oaplogmaster", oaplogmaster);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", oapform);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.setViewName("Oap/AllFormsView");
        return mv;

    }

    public ModelAndView AllFormsView1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        CrcForm crcForm = crcFormService.readByoapId(id);
        int id1 = crcForm.getId();
        CrcFormApproval crcFormApproval = crcFormApprovalService.readBycrcids(id1);
        int crcformid = crcFormApproval.getId();

        List list0 = crcFormApprovalCommentService.readBycrcformid(crcformid);
        List oaplogmaster = oapLogMasterService.readBycrcid(id1 + "");
        mv.getModelMap().put("oaplogmaster", oaplogmaster);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list", crcForm);
        mv.getModelMap().put("list1", crcFormApproval);
        mv.setViewName("Oap/AllFormsView1");
        return mv;

    }

    public void selectAllDocumentByState(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String state = request.getParameter("state");
        String oapId = request.getParameter("id");
        String aocId = request.getParameter("aocIdd");
        JSONObject jsonobj = new JSONObject();
        JSONArray array2 = new JSONArray();
        JSONArray array3 = new JSONArray();

        if (oapId != null && !oapId.isEmpty()) {
            OapForm oapForm = oapFormService.readById(Integer.parseInt(oapId));
            Map<String, String> map = new HashMap<>();
            String discomId = oapForm.getDiscom();
            String discomm = "";
            if (discomId != null && !discomId.equals("")) {
                DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discomId));
                discomm = discomMaster.getDiscomType();
            }

            map.put("discommId", "" + discomId);
            map.put("discomm", "" + discomm);
            array2.put(map);
            jsonobj.put("discomm", array2);
        }
        if (aocId != null && !aocId.isEmpty()) {
            AocForm aocForm = aocFormService.readById(Integer.parseInt(aocId));
            Map<String, String> map = new HashMap<>();
            String discomId = aocForm.getDiscom();
            String discomm = "";
            if (discomId != null && !discomId.equals("")) {
                DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discomId));
                discomm = discomMaster.getDiscomType();
            }
//            String discomm = discomMaster.getDiscomType();
            map.put("discommId", "" + discomId);
            map.put("discomm", "" + discomm);
            array3.put(map);
            jsonobj.put("discomm", array3);
        }

        JSONArray array = new JSONArray();
        JSONArray array1 = new JSONArray();
        List list = documentNameService.readByStateName(state);
        List list66 = discomMasterService.readByStateName(state);
        for (Object o : list) {

            DocumentName documentName = (DocumentName) o;
            Map<String, String> map = new HashMap<>();
            map.put("documentName", "" + documentName.getDocumentName());
            map.put("id", "" + documentName.getId());
            map.put("compalsuary", "" + documentName.getCompalsuary());
            array.put(map);
        }

        for (Object o1 : list66) {

            DiscomMaster discomMaster = (DiscomMaster) o1;
            Map<String, String> map = new HashMap<>();
            map.put("discomname", "" + discomMaster.getDiscomType());
            map.put("id", "" + discomMaster.getId());
            array1.put(map);
        }

        jsonobj.put("documentCategory", array);
        jsonobj.put("discomCategory", array1);

        response.getWriter().println(jsonobj.toString());
    }

    public void selectAllDocumentByState1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String connectiontype = request.getParameter("connectiontype");
        String Discom = request.getParameter("Discom");
        JSONObject jsonobj = new JSONObject();
        JSONArray array = new JSONArray();
        List list = documentNameService.readyBydisconn(Integer.parseInt(Discom), Integer.parseInt(connectiontype));
        for (Object o : list) {

            DocumentName documentName = (DocumentName) o;
            Map<String, String> map = new HashMap<>();
            map.put("documentName", "" + documentName.getDocumentName());
            map.put("id", "" + documentName.getId());
            map.put("compalsuary", "" + documentName.getCompalsuary());

            array.put(map);
        }

        jsonobj.put("documentCategory", array);
        response.getWriter().println(jsonobj.toString());
    }

    public void selectAllDocumentByState2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String connectiontype = request.getParameter("connectiontype");
        String Discom = request.getParameter("Discom");
        String oapId = request.getParameter("oapId");
        JSONObject jsonobj = new JSONObject();
        JSONArray array = new JSONArray();
        JSONArray array1 = new JSONArray();
        List oapdocument = oapDocumentAttachmentService.readByattachzip(oapId);

        List list = documentNameService.readyBydisconn(Integer.parseInt(Discom), Integer.parseInt(connectiontype));
        for (Object o : list) {

            DocumentName documentName = (DocumentName) o;
            Map<String, String> map = new HashMap<>();
            map.put("documentName", "" + documentName.getDocumentName());
            map.put("id", "" + documentName.getId());
            map.put("compalsuary", "" + documentName.getCompalsuary());

            array.put(map);
        }
        if (!oapdocument.isEmpty()) {
            for (Object o : oapdocument) {

                if (o instanceof Object[]) {
                    Object[] objArray = (Object[]) o;  // Cast to Object[]
                    if (objArray[0] instanceof OapDocumentAttachment) {
                        OapDocumentAttachment oapDocumentAttachment = (OapDocumentAttachment) objArray[0];

                        Map<String, String> map1 = new HashMap<>();
                        map1.put("DocumentId", "" + oapDocumentAttachment.getDocumentName().getId());
                        map1.put("Description", "" + oapDocumentAttachment.getDescription());
                        map1.put("Attachment", "" + oapDocumentAttachment.getAttachment());
                        array1.put(map1);
                    }
                }
            }
//        } else {
//            List list1 = documentNameService.readyBydisconn(Integer.parseInt(Discom), Integer.parseInt(connectiontype));
//            for (Object o : list1) {
//
//                DocumentName documentName = (DocumentName) o;
//                Map<String, String> map = new HashMap<>();
//                map.put("documentName", "" + documentName.getDocumentName());
//                map.put("id", "" + documentName.getId());
//                map.put("compalsuary", "" + documentName.getCompalsuary());
//
//                array.put(map);
//            }
        }
        jsonobj.put("documentCategory", array);
        jsonobj.put("oapdocumentattachment", array1);
        response.getWriter().println(jsonobj.toString());
    }

    public void selectAllDocumentByState3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String connectiontype = request.getParameter("connectiontype");
        String Discom = request.getParameter("Discom");
        String aocId = request.getParameter("aocId");
        JSONObject jsonobj = new JSONObject();
        JSONArray array = new JSONArray();
        JSONArray array1 = new JSONArray();
        List aocdocument = AocFormAttachmentService.readByattachzip(aocId);
        List list = documentNameService.readyBydisconn(Integer.parseInt(Discom), Integer.parseInt(connectiontype));
        for (Object o : list) {

            DocumentName documentName = (DocumentName) o;
            Map<String, String> map = new HashMap<>();
            map.put("documentName", "" + documentName.getDocumentName());
            map.put("id", "" + documentName.getId());
            map.put("compalsuary", "" + documentName.getCompalsuary());

            array.put(map);
        }
        if (!aocdocument.isEmpty()) {
            for (Object o : aocdocument) {

                if (o instanceof Object[]) {
                    Object[] objArray = (Object[]) o;  // Cast to Object[]
                    if (objArray[0] instanceof AocFormAttachment) {
                        AocFormAttachment aocFormAttachment = (AocFormAttachment) objArray[0];

                        Map<String, String> map1 = new HashMap<>();
                        map1.put("DocumentId", "" + aocFormAttachment.getDocumentName().getId());
                        map1.put("Description", "" + aocFormAttachment.getDescription());
                        map1.put("Attachment", "" + aocFormAttachment.getAttachment());
                        array1.put(map1);
                    }
                }
            }
        }

        jsonobj.put("documentCategory", array);
        jsonobj.put("aocdocumentattachment", array1);
        response.getWriter().println(jsonobj.toString());
    }

    public ModelAndView oapCheckBoxAttach(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String fileName = request.getParameter("fileNames");

        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + fileName;
        request.setAttribute("filePath", fileLocationURL);
        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        return mv;
    }

    public ModelAndView projectmanager(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Oap/projectmanager");
        return mv;
    }

    public ModelAndView oapprojectmanagerApprovemulti(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Oap/projectmanagerApprove");
        return mv;
    }

    public ModelAndView projectmanagerApprovesubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        String comment = request.getParameter("comment");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        int oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();

        int DeliFlag = deliverableMulti.getFlagStatus();

        String DesignAssign = deliverableMulti.getDesignAssign();
        String Aproveddate = deliverableMulti.getDeliverableApprovedDate();
        String DesignCordinator = deliverableMulti.getDesignCoordinator();
        String delicrtedBy = deliverableMulti.getCreatedBy();

        List list10 = designCordinatorCommentsService.readybydelivid(id);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        if (oapformid == 0 && DeliFlag == 1) {
            deliverableMulti.setFlagStatus(5);
            deliverableMulti.setProjectManagerApprovedDate(today);
            deliverableMultiService.update(deliverableMulti);

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(aocformid);
            designCordinatorComments.setOapId(0);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(5);
            designCordinatorCommentsService.create(designCordinatorComments);
            String userid = designCordinatorComments.getUserId();
            AocForm aocForm = aocFormService.readById(aocformid);
            KickOffForm kickOffForm = kickOffFormService.readByaocId(aocformid + "");
            int komid = kickOffForm.getId();
            String komusername = kickOffForm.getUserId();
            String aoccreator = aocForm.getUserId();
            String documentno1 = aocForm.getDocumentNo();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(70);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Design Coordinator AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            //Design Cordinator Approved person
            EmployeeMaster employeeMaster1 = employeeMasterService.readUser(DesignAssign);
            String mail_to1 = employeeMaster1.getEmailId();

            EmailTemplate emailTemplate1 = emailTemplateService.readById(181);
            String mail_from1 = "";

            String subject1 = emailTemplate1.getSubject();
            String msg1 = emailTemplate1.getBodytext();
            String crc_form1 = "Deliverable By  AOC Project Manager Approved";

            msg1 = msg1.replaceAll("\\{Oap_form\\}", crc_form1);
            msg1 = msg1.replaceAll("\\{documentno\\}", documentno1);
            msg1 = msg1.replaceAll("\\{username\\}", username);
            msg1 = msg1.replaceAll("\\{createddate\\}", Aproveddate);

            SendMail s1 = new SendMail();
            s1.sendMail(mail_from1, mail_to1, subject1, msg1);
//Design Engineer View Created sample file data
            EmployeeMaster employeeMaster6 = employeeMasterService.readUser(DesignCordinator);
            String mail_to6 = employeeMaster6.getEmailId();

            EmailTemplate emailTemplate6 = emailTemplateService.readById(182);
            String mail_from6 = "";

            String subject6 = emailTemplate6.getSubject();
            String msg6 = emailTemplate6.getBodytext();
            String crc_form6 = "Deliverable By AOC Project Manager Approved";

            msg6 = msg6.replaceAll("\\{Oap_form\\}", crc_form6);
            msg6 = msg6.replaceAll("\\{documentno\\}", documentno1);
            msg6 = msg6.replaceAll("\\{username\\}", username);
            msg6 = msg6.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s6 = new SendMail();
            s6.sendMail(mail_from6, mail_to6, subject6, msg6);
            // Design Deliverable OAP

            EmployeeMaster employeeMaster10 = employeeMasterService.readUser(delicrtedBy);
            String mail_to10 = employeeMaster10.getEmailId();

            EmailTemplate emailTemplate10 = emailTemplateService.readById(183);
            String mail_from10 = "";

            String subject10 = emailTemplate10.getSubject();
            String msg10 = emailTemplate10.getBodytext();
            String crc_form10 = "Deliverable By AOC Project Manager Approved";

            msg10 = msg10.replaceAll("\\{Oap_form\\}", crc_form10);
            msg10 = msg10.replaceAll("\\{documentno\\}", documentno1);
            msg10 = msg10.replaceAll("\\{username\\}", username);
            msg10 = msg10.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s10 = new SendMail();
            s10.sendMail(mail_from10, mail_to10, subject10, msg10);
            //KOM Approavals persons

            KickOffFormApprovalUser kickOffFormApprovalUser = new KickOffFormApprovalUser();
            List komapprovalusers = kickOffFormApprovalUserService.readBykomid(komid);
            for (Object pdf1 : komapprovalusers) {
                kickOffFormApprovalUser = (KickOffFormApprovalUser) pdf1;
                String usernames = kickOffFormApprovalUser.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(184);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Deliverable By AOC Project Manager Approved";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno1);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            // KOM Created
            EmployeeMaster employeeMaster0 = employeeMasterService.readUser(komusername);
            String mail_to0 = employeeMaster0.getEmailId();

            EmailTemplate emailTemplate0 = emailTemplateService.readById(185);
            String mail_from0 = "";

            String subject0 = emailTemplate0.getSubject();
            String msg0 = emailTemplate0.getBodytext();
            String crc_form0 = "Deliverable By AOC Project Manager Approved";

            msg0 = msg0.replaceAll("\\{Oap_form\\}", crc_form0);
            msg0 = msg0.replaceAll("\\{documentno\\}", documentno1);
            msg0 = msg0.replaceAll("\\{username\\}", username);
            msg0 = msg0.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s0 = new SendMail();
            s0.sendMail(mail_from0, mail_to0, subject0, msg0);

            //AOC Approval Persons
            AocFormApprovalUser aocFormApprovalUser1 = new AocFormApprovalUser();
            List userid1 = aocFormApprovalUserService.readByaocId(aocformid);
            for (Object pdf1 : userid1) {
                aocFormApprovalUser1 = (AocFormApprovalUser) pdf1;
                String usernames = aocFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(186);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Deliverable By AOC Project Manager Approved";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno1);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }

            // Aocform creater
            EmployeeMaster employeeMaster11 = employeeMasterService.readUser(aoccreator);
            String mail_to11 = employeeMaster11.getEmailId();

            EmailTemplate emailTemplate11 = emailTemplateService.readById(187);
            String mail_from11 = "";

            String subject11 = emailTemplate11.getSubject();
            String msg11 = emailTemplate11.getBodytext();
            String crc_form11 = "Deliverable By AOC Project Manager Approved";

            msg11 = msg11.replaceAll("\\{Oap_form\\}", crc_form11);
            msg11 = msg11.replaceAll("\\{documentno\\}", documentno1);
            msg11 = msg11.replaceAll("\\{username\\}", username);
            msg11 = msg11.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s11 = new SendMail();
            s11.sendMail(mail_from11, mail_to11, subject11, msg11);

            session.setAttribute("successMessage", "Deliverable Approved By Manager successfully");

        }
        if (aocformid == 0 && DeliFlag == 1) {
            deliverableMulti.setFlagStatus(5);
            deliverableMulti.setProjectManagerApprovedDate(today);
            deliverableMultiService.update(deliverableMulti);

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(0);
            designCordinatorComments.setOapId(oapformid);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(5);
            designCordinatorCommentsService.create(designCordinatorComments);
            OapForm oapForm = oapFormService.readById(oapformid);
            CrcForm crcForm = crcFormService.readByoapIds(oapformid);
            int crcid = crcForm.getId();
            String crcusername = crcForm.getUserid();
            String Oapcreator = oapForm.getUserId();
            String userid = designCordinatorComments.getUserId();
            String documentno = oapForm.getDocumentNo();
            String OapAsignperson = oapForm.getAssignedName();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(49);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Design Coordinator OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);
//Design Cordinator Approved person

            EmployeeMaster employeeMaster1 = employeeMasterService.readUser(DesignAssign);
            String mail_to1 = employeeMaster1.getEmailId();

            EmailTemplate emailTemplate1 = emailTemplateService.readById(131);
            String mail_from1 = "";

            String subject1 = emailTemplate1.getSubject();
            String msg1 = emailTemplate1.getBodytext();
            String crc_form1 = "Deliverable By Project Manager Approved";

            msg1 = msg1.replaceAll("\\{Oap_form\\}", crc_form1);
            msg1 = msg1.replaceAll("\\{documentno\\}", documentno);
            msg1 = msg1.replaceAll("\\{username\\}", username);
            msg1 = msg1.replaceAll("\\{createddate\\}", Aproveddate);

            SendMail s1 = new SendMail();
            s1.sendMail(mail_from1, mail_to1, subject1, msg1);
//Design Engineer View Created sample file data
            EmployeeMaster employeeMaster6 = employeeMasterService.readUser(DesignCordinator);
            String mail_to6 = employeeMaster6.getEmailId();

            EmailTemplate emailTemplate6 = emailTemplateService.readById(132);
            String mail_from6 = "";

            String subject6 = emailTemplate6.getSubject();
            String msg6 = emailTemplate6.getBodytext();
            String crc_form6 = "Deliverable By Project Manager Approved";

            msg6 = msg6.replaceAll("\\{Oap_form\\}", crc_form6);
            msg6 = msg6.replaceAll("\\{documentno\\}", documentno);
            msg6 = msg6.replaceAll("\\{username\\}", username);
            msg6 = msg6.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s6 = new SendMail();
            s6.sendMail(mail_from6, mail_to6, subject6, msg6);
            // Design Deliverable OAP

            EmployeeMaster employeeMaster10 = employeeMasterService.readUser(delicrtedBy);
            String mail_to10 = employeeMaster10.getEmailId();

            EmailTemplate emailTemplate10 = emailTemplateService.readById(133);
            String mail_from10 = "";

            String subject10 = emailTemplate10.getSubject();
            String msg10 = emailTemplate10.getBodytext();
            String crc_form10 = "Deliverable By Project Manager Approved";

            msg10 = msg10.replaceAll("\\{Oap_form\\}", crc_form10);
            msg10 = msg10.replaceAll("\\{documentno\\}", documentno);
            msg10 = msg10.replaceAll("\\{username\\}", username);
            msg10 = msg10.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s10 = new SendMail();
            s10.sendMail(mail_from10, mail_to10, subject10, msg10);
            //crc approval persons crcid
            CrcFormApprovalUser crcFormApprovalUser1 = new CrcFormApprovalUser();
            List crcapprovalusers = crcFormApprovalUserService.readyByCrcId(crcid);
            for (Object pdf1 : crcapprovalusers) {
                crcFormApprovalUser1 = (CrcFormApprovalUser) pdf1;
                String usernames = crcFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(134);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Deliverable By Project Manager Approved";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            //crcform Created
            EmployeeMaster employeeMaster0 = employeeMasterService.readUser(crcusername);
            String mail_to0 = employeeMaster0.getEmailId();

            EmailTemplate emailTemplate0 = emailTemplateService.readById(135);
            String mail_from0 = "";

            String subject0 = emailTemplate0.getSubject();
            String msg0 = emailTemplate0.getBodytext();
            String crc_form0 = "Deliverable By Project Manager Approved";

            msg0 = msg0.replaceAll("\\{Oap_form\\}", crc_form0);
            msg0 = msg0.replaceAll("\\{documentno\\}", documentno);
            msg0 = msg0.replaceAll("\\{username\\}", username);
            msg0 = msg0.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s0 = new SendMail();
            s0.sendMail(mail_from0, mail_to0, subject0, msg0);
            //EH - Assiged
            EmployeeMaster employeeMaster3 = employeeMasterService.readUser(OapAsignperson);
            String mail_to3 = employeeMaster3.getEmailId();

            EmailTemplate emailTemplate3 = emailTemplateService.readById(136);
            String mail_from3 = "";

            String subject3 = emailTemplate3.getSubject();
            String msg3 = emailTemplate3.getBodytext();
            String crc_form3 = "Deliverable By Project Manager Approved";

            msg3 = msg3.replaceAll("\\{Oap_form\\}", crc_form3);
            msg3 = msg3.replaceAll("\\{documentno\\}", documentno);
            msg3 = msg3.replaceAll("\\{username\\}", username);
            msg3 = msg3.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s3 = new SendMail();
            s3.sendMail(mail_from3, mail_to3, subject3, msg3);
            // oap Approval persons
            OapFormApprovalUser oapFormApprovalUser1 = new OapFormApprovalUser();

//        int id8 = Integer.parseInt(id);
            List userid1 = oapFormApprovalUserService.readByoapid(oapformid);
            for (Object pdf1 : userid1) {
                oapFormApprovalUser1 = (OapFormApprovalUser) pdf1;
                String usernames = oapFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(137);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Deliverable By Project Manager Approved";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }

            // oapform creater
            EmployeeMaster employeeMaster11 = employeeMasterService.readUser(Oapcreator);
            String mail_to11 = employeeMaster11.getEmailId();

            EmailTemplate emailTemplate11 = emailTemplateService.readById(138);
            String mail_from11 = "";

            String subject11 = emailTemplate11.getSubject();
            String msg11 = emailTemplate11.getBodytext();
            String crc_form11 = "Deliverable By Project Manager Approved";

            msg11 = msg11.replaceAll("\\{Oap_form\\}", crc_form11);
            msg11 = msg11.replaceAll("\\{documentno\\}", documentno);
            msg11 = msg11.replaceAll("\\{username\\}", username);
            msg11 = msg11.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s11 = new SendMail();
            s11.sendMail(mail_from11, mail_to11, subject11, msg11);
            session.setAttribute("successMessage", "Deliverable Approved By Manager successfully");

        }

        if (DeliFlag == 5) {
            session.setAttribute("failureMessage", "Deliverable Already Approved By Manager successfully");

        } else if (DeliFlag == 2) {
            session.setAttribute("failureMessage", "Deliverable Already Reworked By Manager successfully");

        } else if (DeliFlag == 3) {
            session.setAttribute("failureMessage", "Deliverable Already Rejected By Manager successfully");

        }

        mv.setViewName("redirect:oapForm.htm?act=oapprojectmanagerApprovemulti");

        return mv;
    }

    public ModelAndView projectmanagerApprove1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        int oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();
        List list10 = designCordinatorCommentsService.readybydelivid(id);

        String designassign = deliverableMulti.getDesignAssign();
        AocForm aocForm = aocFormService.readByformid(aocformid);
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(oapformid + "");
        List aocSurveyAttch = aocSurveyAttachmentService.readByaocId(aocformid + "");

        mv.getModelMap().put("aocSurveyAttch", aocSurveyAttch);
        OapForm oapForm = oapFormService.readByformid(oapformid);
        if (aocformid == 0) {
            aocformid = -1;
        }
        if (oapformid == 0) {
            oapformid = -1;
        }
        List list50 = designCoordinatorMultiAttachService.readBydelmultiid(oapformid);
        List list40 = designCoordinatorMultiAttachService.readBydelmultiid1(aocformid);
        CrcForm crcForm = crcFormService.readByoapIds(oapformid);
        KickOffForm kickOffForm = kickOffFormService.readByaocIds(aocformid);

        int flag = 0; // Default to 0
        List<IteamDetailsAttachments> list5 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc1(id);// 1 Contract

        for (IteamDetailsAttachments ab : list5) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 1) {
                flag = 1;
                List Contract1 = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Contract1", Contract1);

                break; // Exit loop as soon as we find a 1
            }
        }
        List<IteamDetailsAttachments> list7 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc2(id);//4 GoodsContract

        for (IteamDetailsAttachments ab : list7) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 4) {
                flag = 4;
                List GoodsContract4 = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("GoodsContract4", GoodsContract4);

                break; // Exit loop as soon as we find a 1
            }
        }
        List<IteamDetailsAttachments> list0 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readBydeleteAll(id); //0 goods

        for (IteamDetailsAttachments ab : list0) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 0) {
                flag = 0;
                List Goods = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Goods", Goods);
                break; // Exit loop as soon as we find a 1
            }
        }

        List<IteamDetailsAttachments> list4 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readBydeleteAll1(id); //3 Service

        for (IteamDetailsAttachments ab : list4) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 3) {
                flag = 3;
                List Service = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Service", Service);
                break; // Exit loop as soon as we find a 1
            }
        }
        mv.getModelMap().put("oapformid", oapformid);
        mv.getModelMap().put("aocformid", aocformid);
        mv.getModelMap().put("list50", list50);
        mv.getModelMap().put("list40", list40);
        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("crcForm", crcForm);
        mv.getModelMap().put("kickOffForm", kickOffForm);
        mv.getModelMap().put("list5", list5);
        mv.getModelMap().put("list7", list7);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("flag", flag);
        mv.getModelMap().put("list2", oapForm);
        mv.getModelMap().put("list3", aocForm);

        mv.getModelMap().put("list6", deliverableMulti);
        mv.getModelMap().put("designassign", designassign);
        mv.getModelMap().put("id", id);

        mv.setViewName("Oap/projectmanagerApprove1");
        return mv;
    }

    public ModelAndView projectmanagerApprovesubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv = projectmanagerApprove1(request, response);
        return mv;
    }

    public ModelAndView projectmanagerview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);

        OapFormApproval oapFormApproval = oapFormApprovalService.readByoapappid(id);
        int approveid = oapFormApproval.getId();

        List list0 = oapFormApprovalCommentService.readByIds(id);

        List oaplogmaster = oapLogMasterService.readByOapId(id);
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("oaplogmaster", oaplogmaster);

        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list55", oapForm);
        mv.getModelMap().put("oapForm", oapForm);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/projectmanagerview");
        return mv;
    }

    public ModelAndView projectmanagerCancel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        String userid = oapForm.getProjectCoordinater();
        String documentno = oapForm.getDocumentNo();
        CrcForm crcForm = crcFormService.readByoapId(id);
        int flagStatus = oapForm.getFlagStatus();
        if (flagStatus != 8 && flagStatus != 9 && flagStatus != 10) {

            oapForm.setComment(comment);
            oapForm.setFlagStatus(8);
            crcForm.setFlagStatus(5);
            oapFormService.update(oapForm);
            crcFormService.update(crcForm);
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(72);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Cancel the  OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", " Projectmanager Cancel The OapForm successfully");

        } else if (flagStatus == 8) {
            session.setAttribute("failureMessage", "Projectmanager Already Cancel The OapForm Successfully");

        } else if (flagStatus == 9) {
            session.setAttribute("failureMessage", "Projectmanager Already Rejected The OapForm Successfully");

        } else if (flagStatus == 10) {
            session.setAttribute("failureMessage", "Projectmanager Already Closed The OapForm Successfully");

        } else {
            session.setAttribute("failureMessage", "The OAP Process has Already progressed to the next stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=projectmanager");
        return mv;
    }

    public ModelAndView projectmanagerReject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        String userid = oapForm.getProjectCoordinater();
        String documentno = oapForm.getDocumentNo();
        CrcForm crcForm = crcFormService.readByoapId(id);
        int flagStatus = oapForm.getFlagStatus();
        if (flagStatus != 8 && flagStatus != 9 && flagStatus != 10) {

            oapForm.setComment(comment);
            oapForm.setFlagStatus(9);
            crcForm.setFlagStatus(6);
            oapFormService.update(oapForm);
            crcFormService.update(crcForm);
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(73);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Rejected the  OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", " Projectmanager Rejected The OapForm successfully");

        } else if (flagStatus == 8) {
            session.setAttribute("failureMessage", "Projectmanager Already Cancel The OapForm Successfully");

        } else if (flagStatus == 9) {
            session.setAttribute("failureMessage", "Projectmanager Already Rejected The OapForm Successfully");

        } else if (flagStatus == 10) {
            session.setAttribute("failureMessage", "Projectmanager Already Closed The OapForm Successfully");

        } else {
            session.setAttribute("failureMessage", "The OAP Process has Already progressed to the next stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=projectmanager");
        return mv;
    }

    public ModelAndView projectmanagerClose(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        int flagStatus = oapForm.getFlagStatus();

        String userid = oapForm.getProjectCoordinater();
        String documentno = oapForm.getDocumentNo();

        CrcForm crcForm = crcFormService.readByoapId(id);

        if (flagStatus != 8 && flagStatus != 9 && flagStatus != 10) {

            oapForm.setComment(comment);
            oapForm.setFlagStatus(10);
            crcForm.setFlagStatus(7);
            oapFormService.update(oapForm);
            crcFormService.update(crcForm);
//42
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(71);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Closed the  OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", " Projectmanager Closed The OapForm successfully");

        } else if (flagStatus == 8) {
            session.setAttribute("failureMessage", "Projectmanager Already Cancel The OapForm Successfully");

        } else if (flagStatus == 9) {
            session.setAttribute("failureMessage", "Projectmanager Already Rejected The OapForm Successfully");

        } else if (flagStatus == 10) {
            session.setAttribute("failureMessage", "Projectmanager Already Closed The OapForm Successfully");

        } else {
            session.setAttribute("failureMessage", "The OAP Process has Already progressed to the next stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=projectmanager");

        return mv;
    }

    public ModelAndView projectmanagerview1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        String discom1 = "";
        String connection = "";
        String discom = aocForm.getDiscom();
        if (discom != null) {
            DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));

            if (discomMaster != null && discomMaster.getDiscomType() != null) {
                discom1 = discomMaster.getDiscomType();
            }
        }

        String connectionType = aocForm.getConnectionType();
        if (connectionType != null) {
            ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));

            if (connectionType1 != null && connectionType1.getConnectionType() != null) {
                connection = connectionType1.getConnectionType();
            }
        }

        mv.getModelMap().put("Discom1", discom1);
        mv.getModelMap().put("connection", connection);
        List list = AocFormAttachmentService.readByattach(id);
        List list33 = aocFormMultiAttachmentService.readByMulti(id);

        List list99 = employeeMasterService.read();

        AocFormApproval aocFormApproval = aocFormApprovalService.readByDeltecodes(id);
        int approveid = aocFormApproval.getId();

        List list0 = aocFormApprovalCommentService.readByIds(id);
        List aoclogmaster = aocLogMasterService.readByAocId(id);
        mv.getModelMap().put("aoclogmaster", aoclogmaster);

        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(id);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);

        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list99", list99);
        mv.getModelMap().put("list55", aocForm);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/projectmanagerview1");
        return mv;
    }

    public ModelAndView projectmanagerCancel1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        KickOffForm kickOffForm = kickOffFormService.readByaocId(id);

        int flagStatus = aocForm.getFlagStatus();
        if (flagStatus != 8 && flagStatus != 9 && flagStatus != 10) {
            aocForm.setComment(comment);
            aocForm.setFlagStatus(8);
            kickOffForm.setFlagStatus(5);
            aocFormService.update(aocForm);
            kickOffFormService.update(kickOffForm);

            String userid = aocForm.getProjectCoordinater();
            String documentno = aocForm.getDocumentNo();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(75);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Cancel the  AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", " Projectmanager Cancel The OapForm successfully");

        } else if (flagStatus == 8) {
            session.setAttribute("failureMessage", "Projectmanager Already Cancel The OapForm Successfully");

        } else if (flagStatus == 9) {
            session.setAttribute("failureMessage", "Projectmanager Already Rejected The OapForm Successfully");

        } else if (flagStatus == 10) {
            session.setAttribute("failureMessage", "Projectmanager Already Closed The OapForm Successfully");

        } else {
            session.setAttribute("failureMessage", "The OAP Process has Already progressed to the next stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=projectmanager");
        return mv;
    }

    public ModelAndView projectmanagerReject1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        KickOffForm kickOffForm = kickOffFormService.readByaocId(id);

        int flagStatus = aocForm.getFlagStatus();
        if (flagStatus != 8 && flagStatus != 9 && flagStatus != 10) {

            aocForm.setComment(comment);
            aocForm.setFlagStatus(9);
            kickOffForm.setFlagStatus(6);
            aocFormService.update(aocForm);
            kickOffFormService.update(kickOffForm);

            String userid = aocForm.getProjectCoordinater();
            String documentno = aocForm.getDocumentNo();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(76);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Rejected the  AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", " Projectmanager Rejected The OapForm successfully");

        } else if (flagStatus == 8) {
            session.setAttribute("failureMessage", "Projectmanager Already Cancel The OapForm Successfully");

        } else if (flagStatus == 9) {
            session.setAttribute("failureMessage", "Projectmanager Already Rejected The OapForm Successfully");

        } else if (flagStatus == 10) {
            session.setAttribute("failureMessage", "Projectmanager Already Closed The OapForm Successfully");

        } else {
            session.setAttribute("failureMessage", "The OAP Process has Already progressed to the next stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=projectmanager");
        return mv;
    }

    public ModelAndView projectmanagerClose1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        int flagStatus = aocForm.getFlagStatus();

        String userid = aocForm.getProjectCoordinater();
        String documentno = aocForm.getDocumentNo();
        KickOffForm kickOffForm = kickOffFormService.readByaocId(id);

        if (flagStatus != 8 && flagStatus != 9 && flagStatus != 10) {
            aocForm.setComment(comment);
            aocForm.setFlagStatus(10);
            kickOffForm.setFlagStatus(7);
            aocFormService.update(aocForm);
            kickOffFormService.update(kickOffForm);

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(74);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Closed the  AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", " Projectmanager Closed The OapForm successfully");

        } else if (flagStatus == 8) {
            session.setAttribute("failureMessage", "Projectmanager Already Cancel The OapForm Successfully");

        } else if (flagStatus == 9) {
            session.setAttribute("failureMessage", "Projectmanager Already Rejected The OapForm Successfully");

        } else if (flagStatus == 10) {
            session.setAttribute("failureMessage", "Projectmanager Already Closed The OapForm Successfully");

        } else {
            session.setAttribute("failureMessage", "The OAP Process has Already progressed to the next stage");
        }

        mv.setViewName("redirect:oapForm.htm?act=projectmanager");
        return mv;
    }

    public ModelAndView DesignTeam(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Oap/DesignTeam");
        return mv;
    }

    public ModelAndView Deliverable(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        List list23 = userRightsService.readByDesignCoordinator();
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id + "");
        mv.getModelMap().put("list23", list23);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/Deliverable");
        return mv;
    }

    public ModelAndView DeliverableAoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        List list23 = userRightsService.readByDesignCoordinator();
        List aocSurveyAttch = aocSurveyAttachmentService.readByaocId(id + "");
        mv.getModelMap().put("list23", list23);
        mv.getModelMap().put("aocSurveyAttch", aocSurveyAttch);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/DeliverableAoc");
        return mv;
    }

    public ModelAndView DeliverableOapSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        String id = request.getParameter("id");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        int oapformid = oapForm.getId();

        String oapcretdperson = oapForm.getUserId();
        String documentno = oapForm.getDocumentNo();
        String OapAsignperson = oapForm.getAssignedName();

        CrcForm crcForm = crcFormService.readByoapId(id);
        int crcid = crcForm.getId();
        String crcusername = crcForm.getUserid();

        List deliverables = deliverableMultiService.readByOapIdAndZeroFlag(oapformid);

        int delisize = deliverables.size();

        if (delisize == 0) {

            String date = request.getParameter("date");
            String description = request.getParameter("description");

            Deliverable deliverable = new Deliverable();
            deliverable.setDate(date);
            deliverable.setDescription(description);
            deliverable.setOapId(oapformid);
            deliverableService.create(deliverable);

            int id1 = deliverable.getId();
            String mailcreteddate = deliverable.getDate();
            String descriptions[] = request.getParameterValues("descriptions");
            String[] Designco = request.getParameterValues("attach");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());
            try {

                for (int i = 0; i < descriptions.length; i++) {
                    DeliverableMulti deliverableMulti = new DeliverableMulti();
                    deliverableMulti.setDescription(descriptions[i]);
                    deliverableMulti.setDesignCoordinator(Designco[i]);
                    deliverableMulti.setOapId(oapformid);
                    deliverableMulti.setCreatedBy(username);
                    deliverableMulti.setCreatedDate(today);
                    deliverableMulti.setDeliverableId(id1);
                    deliverableMulti.setFlagStatus(0);
                    deliverableMultiService.create(deliverableMulti);

                    String userid = deliverableMulti.getDesignCoordinator();

                    EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
                    String mail_to = employeeMaster2.getEmailId();

                    try {
                        EmailTemplate emailTemplate = emailTemplateService.readById(42);
                        String mail_from = "";

                        String subject = emailTemplate.getSubject();
                        String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

                        msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Deliverable OAP Fom");
                        msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
                        msg = msg.replaceAll("\\{documentno\\}", documentno);
                        msg = msg.replaceAll("\\{username\\}", userid);
                        msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

                        SendMail s = new SendMail();
                        s.sendMail(mail_from, mail_to, subject, msg);
                    } catch (Exception e) {

                    }
                }

            } catch (Exception e) {
                // Properly log the exception for debugging purposes
                e.printStackTrace();
                // Optionally, rethrow the exception or handle it as needed
            }

            oapForm.setPartiallyApproveFlag(11);
            oapFormService.update(oapForm);

            // Design Deliverables creted person
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(111);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Oap_form = "Design Deliverable Created";

            msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", username);
            msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            //crc approval persons
            CrcFormApprovalUser crcFormApprovalUser1 = new CrcFormApprovalUser();
            List crcapprovalusers = crcFormApprovalUserService.readyByCrcId(crcid);
            for (Object pdf1 : crcapprovalusers) {
                crcFormApprovalUser1 = (CrcFormApprovalUser) pdf1;
                String usernames = crcFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(112);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Design Deliverables are created";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
//crc cretaed person 

            EmployeeMaster employeeMaster0 = employeeMasterService.readUser(crcusername);
            String mail_to0 = employeeMaster0.getEmailId();

            EmailTemplate emailTemplate0 = emailTemplateService.readById(113);
            String mail_from0 = "";

            String subject0 = emailTemplate0.getSubject();
            String msg0 = emailTemplate0.getBodytext();
            String crc_form0 = "Design Deliverables are created";

            msg0 = msg0.replaceAll("\\{Oap_form\\}", crc_form0);
            msg0 = msg0.replaceAll("\\{documentno\\}", documentno);
            msg0 = msg0.replaceAll("\\{username\\}", username);
            msg0 = msg0.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s0 = new SendMail();
            s0.sendMail(mail_from0, mail_to0, subject0, msg0);
            // EH Asigned Person 
            EmployeeMaster employeeMaster6 = employeeMasterService.readUser(OapAsignperson);
            String mail_to6 = employeeMaster6.getEmailId();

            EmailTemplate emailTemplate6 = emailTemplateService.readById(116);
            String mail_from6 = "";

            String subject6 = emailTemplate6.getSubject();
            String msg6 = emailTemplate6.getBodytext();
            String crc_form6 = "Design Deliverables are created";

            msg6 = msg6.replaceAll("\\{Oap_form\\}", crc_form6);
            msg6 = msg6.replaceAll("\\{documentno\\}", documentno);
            msg6 = msg6.replaceAll("\\{username\\}", username);
            msg6 = msg6.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s6 = new SendMail();
            s6.sendMail(mail_from6, mail_to6, subject6, msg6);

//oap approval persons
            OapFormApprovalUser oapFormApprovalUser1 = new OapFormApprovalUser();

            int id8 = Integer.parseInt(id);

            List userid = oapFormApprovalUserService.readByoapid(id8);
            for (Object pdf1 : userid) {
                oapFormApprovalUser1 = (OapFormApprovalUser) pdf1;
                String usernames = oapFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(114);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Design Deliverables are created";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
// oap creted person
            EmployeeMaster employeeMaster10 = employeeMasterService.readUser(oapcretdperson);
            String mail_to10 = employeeMaster10.getEmailId();

            EmailTemplate emailTemplate10 = emailTemplateService.readById(115);
            String mail_from10 = "";

            String subject10 = emailTemplate10.getSubject();
            String msg10 = emailTemplate10.getBodytext();
            String crc_form10 = "Design Deliverables are created";

            msg10 = msg10.replaceAll("\\{Oap_form\\}", crc_form10);
            msg10 = msg10.replaceAll("\\{documentno\\}", documentno);
            msg10 = msg10.replaceAll("\\{username\\}", username);
            msg10 = msg10.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s10 = new SendMail();
            s10.sendMail(mail_from10, mail_to10, subject10, msg10);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("OAP Deliverable");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Created");
            oapLogMaster.setComments("");
            oapLogMaster.setOapId(oapformid);
            oapLogMasterService.create(oapLogMaster);
            mv.getModelMap().put("id", id);

            session.setAttribute("successMessage", " Deliverable OAP Created successfully");
        } else {
            session.setAttribute("failureMessage", " Already Deliverable OAP Created successfully");

        }
        mv.setViewName("redirect:oapForm.htm?act=DesignTeam");

        return mv;
    }

    public ModelAndView DeliverableAocSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        int aocFormid = aocForm.getId();
        String documentno = aocForm.getDocumentNo();
        String aoccreator = aocForm.getUserId();
        KickOffForm kickOffForm = kickOffFormService.readByaocId(aocFormid + "");
        int komid = kickOffForm.getId();

        String komusername = kickOffForm.getUserId();

        List deliverables = deliverableMultiService.readByAocIdAndZeroFlag(aocFormid);

        int delisize = deliverables.size();

        if (delisize == 0) {
            String date = request.getParameter("date");
            String description = request.getParameter("description");

            Deliverable deliverable = new Deliverable();
            deliverable.setDate(date);
            deliverable.setDescription(description);
            deliverable.setAocId(aocFormid);
            deliverableService.create(deliverable);
            int id1 = deliverable.getId();
            String mailcreteddate = deliverable.getDate();
            String descriptions[] = request.getParameterValues("descriptions");
            String[] Designco = request.getParameterValues("attach");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());
            try {

                for (int i = 0; i < descriptions.length; i++) {
                    DeliverableMulti deliverableMulti = new DeliverableMulti();
                    deliverableMulti.setDescription(descriptions[i]);
                    deliverableMulti.setDesignCoordinator(Designco[i]);
                    deliverableMulti.setAocId(aocFormid);
                    deliverableMulti.setDeliverableId(id1);
                    deliverableMulti.setFlagStatus(0);
                    deliverableMulti.setCreatedBy(username);
                    deliverableMulti.setCreatedDate(today);
                    deliverableMultiService.create(deliverableMulti);
                    String userid = deliverableMulti.getDesignCoordinator();
                    EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
                    String mail_to = employeeMaster2.getEmailId();

                    try {
                        EmailTemplate emailTemplate = emailTemplateService.readById(63);
                        String mail_from = "";

                        String subject = emailTemplate.getSubject();
                        String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

                        msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Deliverable AOC Fom");
                        msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
                        msg = msg.replaceAll("\\{documentno\\}", documentno);
                        msg = msg.replaceAll("\\{username\\}", userid);
                        msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

                        SendMail s = new SendMail();
                        s.sendMail(mail_from, mail_to, subject, msg);
                    } catch (Exception e) {

                    }

                }

            } catch (Exception e) {
                // Properly log the exception for debugging purposes
                e.printStackTrace();
                // Optionally, rethrow the exception or handle it as needed
            }
            aocForm.setFlagStatus(11);
            aocFormService.update(aocForm);
//Deliverable Aoc Created
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(164);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            String Oap_form = "Design Deliverable AOC Created";

            msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", username);
            msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);
//KOM Approavals persons

            KickOffFormApprovalUser kickOffFormApprovalUser = new KickOffFormApprovalUser();
            List komapprovalusers = kickOffFormApprovalUserService.readBykomid(komid);
            for (Object pdf1 : komapprovalusers) {
                kickOffFormApprovalUser = (KickOffFormApprovalUser) pdf1;
                String usernames = kickOffFormApprovalUser.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(165);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Design Deliverable  AOC Created";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
// KOM Created
            EmployeeMaster employeeMaster0 = employeeMasterService.readUser(komusername);
            String mail_to0 = employeeMaster0.getEmailId();

            EmailTemplate emailTemplate0 = emailTemplateService.readById(166);
            String mail_from0 = "";

            String subject0 = emailTemplate0.getSubject();
            String msg0 = emailTemplate0.getBodytext();
            String crc_form0 = "Design Deliverable AOC Created";

            msg0 = msg0.replaceAll("\\{Oap_form\\}", crc_form0);
            msg0 = msg0.replaceAll("\\{documentno\\}", documentno);
            msg0 = msg0.replaceAll("\\{username\\}", username);
            msg0 = msg0.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s0 = new SendMail();
            s0.sendMail(mail_from0, mail_to0, subject0, msg0);
            //AOC Approval Persons
            AocFormApprovalUser aocFormApprovalUser1 = new AocFormApprovalUser();
            List userid1 = aocFormApprovalUserService.readByaocId(aocFormid);
            for (Object pdf1 : userid1) {
                aocFormApprovalUser1 = (AocFormApprovalUser) pdf1;
                String usernames = aocFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(167);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Design Deliverable AOC Created";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            // Aocform creater
            EmployeeMaster employeeMaster11 = employeeMasterService.readUser(aoccreator);
            String mail_to11 = employeeMaster11.getEmailId();

            EmailTemplate emailTemplate11 = emailTemplateService.readById(168);
            String mail_from11 = "";

            String subject11 = emailTemplate11.getSubject();
            String msg11 = emailTemplate11.getBodytext();
            String crc_form11 = "Design Deliverable AOC Created";

            msg11 = msg11.replaceAll("\\{Oap_form\\}", crc_form11);
            msg11 = msg11.replaceAll("\\{documentno\\}", documentno);
            msg11 = msg11.replaceAll("\\{username\\}", username);
            msg11 = msg11.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s11 = new SendMail();
            s11.sendMail(mail_from11, mail_to11, subject11, msg11);

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity(" AOC Deliverable");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments("");
            aocLogMaster.setStatus("AOC Deliverable Created");
            aocLogMaster.setAocId(Integer.parseInt(id));
            aocLogMasterService.create(aocLogMaster);
            mv.getModelMap().put("id", id);

            session.setAttribute("successMessage", " Deliverable AOC Created successfully");
        } else {
            session.setAttribute("failureMessage", " Already Deliverable AOC Created successfully");

        }
        mv.setViewName("redirect:oapForm.htm?act=DesignTeam");

        return mv;
    }

    public ModelAndView DeliverableEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        Deliverable deliverable = deliverableService.readById(Integer.parseInt(id));
        int oapformid = deliverable.getOapId();

        mv.getModelMap().put("list25", deliverable);
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(oapformid + "");
        List list28 = deliverableMultiService.readByDeliveryId(id);

        List list23 = userRightsService.readByDesignCoordinator();

        mv.getModelMap().put("list23", list23);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("list28", list28);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("oapformid", oapformid);
        mv.setViewName("Oap/DeliverableEdit");
        return mv;
    }

    public ModelAndView DeliverableOapView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        Deliverable deliverable = deliverableService.readByoapid(id);
        int deliverableid = deliverable.getId();

        List list11 = deliverableMultiService.readByDeliveryId(deliverableid);

        mv.getModelMap().put("list11", list11);
        mv.getModelMap().put("list10", deliverable);
        mv.setViewName("Oap/DeliverableOapView");
        return mv;
    }

    public ModelAndView DeliverableAocView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        Deliverable deliverable = deliverableService.readByAOcid(id);
        int deliverableid = deliverable.getId();
//OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        int aocid = aocForm.getId();
        DesignCoordinatorMultiAttach designCoordinatorMultiAttach = designCoordinatorMultiAttachService.readBydelmultiidsaoc(aocid);
        int delivablemultiid = designCoordinatorMultiAttach.getDeliverableMultiId();

        KickOffForm kickOffForm = kickOffFormService.readByaocId(id);

        List list0 = deliverableMultiService.readByAocId(id);
        List list12 = deliverableMultiService.readByDeliveryId(deliverableid);
        List list5 = designCoordinatorMultiAttachService.readBydelmultiid1(aocid);

        mv.getModelMap().put("delivablemultiid", delivablemultiid);
        mv.getModelMap().put("list5", list5);
        mv.getModelMap().put("aocForm", aocForm);
        mv.getModelMap().put("kickOffForm", kickOffForm);
        mv.getModelMap().put("list12", list12);
        mv.getModelMap().put("list13", deliverable);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/DeliverableAocView");
        return mv;
    }

    public ModelAndView deliverymultidelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");
        deliverableMultiService.delete(Integer.parseInt(id1));

        mv.setViewName("forward:oapForm.htm?act=DeliverableEdit&id=" + id);
        return mv;
    }

    public ModelAndView DeliverableAocEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        Deliverable deliverable = deliverableService.readById(Integer.parseInt(id));
        int aocformid = deliverable.getAocId();

        mv.getModelMap().put("list25", deliverable);

        List list28 = deliverableMultiService.readByDeliveryId(id);
        List aocSurveyAttch = aocSurveyAttachmentService.readByaocId(aocformid + "");

        mv.getModelMap().put("aocSurveyAttch", aocSurveyAttch);
        List list23 = userRightsService.readByDesignCoordinator();

        mv.getModelMap().put("list23", list23);

        mv.getModelMap().put("list28", list28);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("aocformid", aocformid);

        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/DeliverableAocEdit");
        return mv;
    }

    public ModelAndView deliverymultidelete1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        deliverableMultiService.delete(Integer.parseInt(id));

        mv.setViewName("forward:oapForm.htm?act=DeliverableEdit&id=" + id);
        return mv;
    }

    public ModelAndView DeliverableEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id1));
        int oapFormid = oapForm.getId();
        String documentno = oapForm.getDocumentNo();

        String date = request.getParameter("date");
        String description = request.getParameter("description");
        Deliverable deliverable = deliverableService.readById(Integer.parseInt(id));

        deliverable.setDate(date);
        deliverable.setDescription(description);
        deliverableService.update(deliverable);
        String mailcreteddate = deliverable.getDate();

        int id2 = deliverable.getId();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());
        String descriptions[] = request.getParameterValues("descriptions");
        String[] Designco = request.getParameterValues("attach");
        try {

            for (int i = 0; i < descriptions.length; i++) {
                DeliverableMulti deliverableMulti = new DeliverableMulti();
                if (descriptions[i] == "") {

                } else {
                    deliverableMulti.setDescription(descriptions[i]);
                    deliverableMulti.setDesignCoordinator(Designco[i]);
                    deliverableMulti.setOapId(oapFormid);
                    deliverableMulti.setDeliverableId(id2);
                    deliverableMulti.setCreatedDate(today);
                    deliverableMulti.setCreatedBy(username);
                    deliverableMulti.setFlagStatus(0);
                    deliverableMultiService.create(deliverableMulti);
                    String userid = deliverableMulti.getDesignCoordinator();

                    EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
                    String mail_to = employeeMaster2.getEmailId();

                    try {
                        EmailTemplate emailTemplate = emailTemplateService.readById(43);
                        String mail_from = "";

                        String subject = emailTemplate.getSubject();
                        String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

                        msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Deliverable OAP Fom");
                        msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
                        msg = msg.replaceAll("\\{documentno\\}", documentno);
                        msg = msg.replaceAll("\\{username\\}", userid);
                        msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

                        SendMail s = new SendMail();
                        s.sendMail(mail_from, mail_to, subject, msg);
                    } catch (Exception e) {

                    }

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        OapLogMaster oapLogMaster = new OapLogMaster();
        oapLogMaster.setActivity("OAP  Edit Deliverable");
        oapLogMaster.setActivityBy(username);
        oapLogMaster.setDate(currentDateTime5);
        oapLogMaster.setStatus("Edited Deliverable");
        oapLogMaster.setComments("");
        oapLogMaster.setOapId(oapFormid);
        oapLogMasterService.create(oapLogMaster);

        mv.getModelMap().put("id", id);
        session.setAttribute("successMessage", " Oap Deliverable Edited  successfully");
        mv.setViewName("redirect:oapForm.htm?act=DesignTeam");

        return mv;
    }

    public ModelAndView DeliverableAocEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        Deliverable deliverable = deliverableService.readById(Integer.parseInt(id));
        String id1 = request.getParameter("id1");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id1));
        int aocFormid = aocForm.getId();
        String documentno = aocForm.getDocumentNo();
        String date = request.getParameter("date");
        String description = request.getParameter("description");

        deliverable.setDate(date);
        deliverable.setDescription(description);
        deliverableService.update(deliverable);
        int id2 = deliverable.getId();
        String mailcreteddate = deliverable.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        String descriptions[] = request.getParameterValues("descriptions");
        String[] Designco = request.getParameterValues("attach");
        try {

            for (int i = 0; i < descriptions.length; i++) {
                DeliverableMulti deliverableMulti = new DeliverableMulti();
                if (descriptions[i] == "") {

                } else {

                    deliverableMulti.setDescription(descriptions[i]);
                    deliverableMulti.setDesignCoordinator(Designco[i]);
                    deliverableMulti.setAocId(aocFormid);
                    deliverableMulti.setDeliverableId(id2);
                    deliverableMulti.setCreatedDate(today);
                    deliverableMulti.setCreatedBy(username);
                    deliverableMulti.setFlagStatus(0);
                    deliverableMultiService.create(deliverableMulti);
                    String userid = deliverableMulti.getDesignCoordinator();

                    EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
                    String mail_to = employeeMaster2.getEmailId();

                    try {
                        EmailTemplate emailTemplate = emailTemplateService.readById(64);
                        String mail_from = "";

                        String subject = emailTemplate.getSubject();
                        String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

                        msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Deliverable AOC Fom");
                        msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
                        msg = msg.replaceAll("\\{documentno\\}", documentno);
                        msg = msg.replaceAll("\\{username\\}", userid);
                        msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

                        SendMail s = new SendMail();
                        s.sendMail(mail_from, mail_to, subject, msg);
                    } catch (Exception e) {

                    }

                }

            }

        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        AocLogMaster aocLogMaster = new AocLogMaster();
        aocLogMaster.setActivity("AOC Deliverable Edit");
        aocLogMaster.setActivityBy(username);
        aocLogMaster.setDate(currentDateTime5);
        aocLogMaster.setComments("");
        aocLogMaster.setStatus("AOC Deliverable Edited");
        aocLogMaster.setAocId(aocFormid);
        aocLogMasterService.create(aocLogMaster);

        mv.getModelMap().put("id", id);
        mv = DesignTeam(request, response);
        return mv;
    }

    public ModelAndView Designcordinator(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Oap/Designcordinator");
        return mv;
    }

    public ModelAndView DesigncordinatorApprovedView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));

//	List list = deliverableMultiService.readBy
        int oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();
        List list10 = designCordinatorCommentsService.readybydelivid(id);
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(oapformid + "");

        String designassign = deliverableMulti.getDesignAssign();
        AocForm aocForm = aocFormService.readByformid(aocformid);

        OapForm oapForm = oapFormService.readByformid(oapformid);
        if (aocformid == 0) {
            aocformid = -1;
        }
        if (oapformid == 0) {
            oapformid = -1;
        }
        List list50 = designCoordinatorMultiAttachService.readBydelmultiid(oapformid);
        List list40 = designCoordinatorMultiAttachService.readBydelmultiid1(aocformid);
        CrcForm crcForm = crcFormService.readByoapIds(oapformid);
        KickOffForm kickOffForm = kickOffFormService.readByaocIds(aocformid);

        int flag = 0; // Default to 0
        List<IteamDetailsAttachments> list5 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc1(id);// 1 Contract

        for (IteamDetailsAttachments ab : list5) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 1) {
                flag = 1;
                List Contract1 = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Contract1", Contract1);

                break; // Exit loop as soon as we find a 1
            }
        }
        List<IteamDetailsAttachments> list7 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc2(id);//4 GoodsContract

        for (IteamDetailsAttachments ab : list7) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 4) {
                flag = 4;
                List GoodsContract4 = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("GoodsContract4", GoodsContract4);

                break; // Exit loop as soon as we find a 1
            }
        }
        List<IteamDetailsAttachments> list0 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readBydeleteAll(id); //0 goods

        for (IteamDetailsAttachments ab : list0) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 0) {
                flag = 0;
                List Goods = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Goods", Goods);
                break; // Exit loop as soon as we find a 1
            }
        }

        List<IteamDetailsAttachments> list4 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readBydeleteAll1(id); //3 Service

        for (IteamDetailsAttachments ab : list4) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 3) {
                flag = 3;
                List Service = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Service", Service);
                break; // Exit loop as soon as we find a 1
            }
        }
        mv.getModelMap().put("oapformid", oapformid);
        mv.getModelMap().put("aocformid", aocformid);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("list50", list50);
        mv.getModelMap().put("list40", list40);

        mv.getModelMap().put("crcForm", crcForm);
        mv.getModelMap().put("kickOffForm", kickOffForm);
        mv.getModelMap().put("list5", list5);
        mv.getModelMap().put("list7", list7);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("flag", flag);
        mv.getModelMap().put("list2", oapForm);
        mv.getModelMap().put("list3", aocForm);
        mv.getModelMap().put("list10", list10);

        mv.getModelMap().put("list6", deliverableMulti);
        mv.getModelMap().put("designassign", designassign);

        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/DesigncordinatorApprovedView");
        return mv;
    }

    public ModelAndView DesigncordinatorRecycleView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        int oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();
        if (aocformid == 0) {
            aocformid = -1;
        }
        if (oapformid == 0) {
            oapformid = -1;
        }
        List list5 = designCoordinatorMultiAttachService.readBydelmultiid(oapformid);
        List list4 = designCoordinatorMultiAttachService.readBydelmultiid1(aocformid);

        CrcForm crcForm = crcFormService.readByoapIds(oapformid);

        KickOffForm kickOffForm = kickOffFormService.readByaocIds(aocformid);
        String designassign = deliverableMulti.getDesignAssign();

        OapForm oapForm = oapFormService.readByformid(oapformid);
        int flag = 0; // Default to 0
        AocForm aocForm = aocFormService.readByformid(aocformid);
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(oapformid + "");
// Ensure the list is properly typed
        List<IteamDetailsAttachments> list = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc(id);

        for (IteamDetailsAttachments item : list) {
            // Check the flagStatus of each item
            if (item.getFlagStatus() == 3) {
                flag = 3; // Set flag to 3 if flagStatus is 3
                break; // Exit loop if flag is already set to 3
            } else if (item.getFlagStatus() == 0) {
                flag = 0; // Set flag to 0 if flagStatus is 0
            }
        }

// '
        List<IteamDetailsAttachments> list1 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc1(id);

        for (IteamDetailsAttachments ab : list1) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 1) {
                flag = 1;
                break; // Exit loop as soon as we find a 1
            }
        }

        List list16 = userRightsService.readByDesignManager();
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("oapformid", oapformid);
        mv.getModelMap().put("aocformid", aocformid);
        mv.getModelMap().put("list16", list16);
        mv.getModelMap().put("list5", list5);
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("flag", flag);
        mv.getModelMap().put("crcForm", crcForm);
        mv.getModelMap().put("kickOffForm", kickOffForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("designassign", designassign);
        mv.getModelMap().put("deliverableMulti", deliverableMulti);

        mv.getModelMap().put("oapForm", oapForm);
        mv.getModelMap().put("aocForm", aocForm);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/DesigncordinatorRecycleView");
        return mv;
    }

    public ModelAndView delivmultiDocxdownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String fileName = request.getParameter("fileName");
        String id1 = request.getParameter("id1");
        String oap = request.getParameter("id6");
        String aoc = request.getParameter("id7");
        int aoc1 = (aoc != null && !aoc.isEmpty()) ? Integer.parseInt(aoc) : 1;

        if (aoc1 == -1) {
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP"
                    + File.separator + id1 + File.separator + fileName;
            request.setAttribute("filePath", fileLocationURL);
            DownloadFile downloadFile = new DownloadFile();
            downloadFile.doDownload(request, response);
        } else {
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc"
                    + File.separator + id1 + File.separator + fileName;
            request.setAttribute("filePath", fileLocationURL);
            DownloadFile downloadFile = new DownloadFile();
            downloadFile.doDownload(request, response);
        }

        return mv;
    }

    public ModelAndView DesigncoordiDocumentdelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");
        designCoordinatorMultiAttachService.delete(Integer.parseInt(id1));

        request.setAttribute("successMessage",
                " One or more data deleted successfully");

        mv.getModelMap().put("id", id);

        mv.setViewName("forward:oapForm.htm?act=DesigncordinatorRecycleView&id=" + id);

        return mv;
    }

    public ModelAndView DesigncoordiDocumentdelete1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv = Designcordinator(request, response);
        return mv;
    }

    public ModelAndView DesigncordinatorRecycleEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        String approvalName = request.getParameter("approvalName");

        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        int oapid = deliverableMulti.getOapId();
        int aocid = deliverableMulti.getAocId();

        if (aocid == 0) {
            deliverableMulti.setDesignAssign(approvalName);
            deliverableMulti.setFlagStatus(4);
            deliverableMulti.setDeliverableCreatedDate(today);
            deliverableMultiService.update(deliverableMulti);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("OAP Design CoOrdinator Edit");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Design CoOrdinator Edited");
            oapLogMaster.setComments("");
            oapLogMaster.setOapId(oapid);
            oapLogMasterService.create(oapLogMaster);
            OapForm oapForm = oapFormService.readById(oapid);
            String documentno = oapForm.getDocumentNo();

            String userid = deliverableMulti.getDesignAssign();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(45);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Design Coordinator OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            // multi attachment
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP"
                    + File.separator + oapid;
            File f1 = new File(path);
            boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

            List<MultipartFile> files1 = multipartRequest.getFiles("attach");
            String[] description = request.getParameterValues("descriptions");
            int a = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "OAP"
                                + File.separator + oapid + File.separator;

                        File directory = new File(fileLocationURL);
                        if (!directory.exists()) {
                            directory.mkdirs(); // Create the directory if it doesn't exist
                        }

                        File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        try {
                            file1.transferTo(destinationFile1); // Ensure proper exception handling
                        } catch (Exception e) {
                            e.printStackTrace(); // Handle the error or log it
                        }

                        DesignCoordinatorMultiAttach designCoordinatorMultiAttach = new DesignCoordinatorMultiAttach();
                        designCoordinatorMultiAttach.setAttachement(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        designCoordinatorMultiAttach.setDescription(description[a]);
                        designCoordinatorMultiAttach.setDeliverableMultiId((Integer.parseInt(id)));
                        designCoordinatorMultiAttach.setOapId(oapid);
                        designCoordinatorMultiAttach.setAocId(aocid);
                        designCoordinatorMultiAttachService.create(designCoordinatorMultiAttach);

                        a++;
                    }
                }

            }
        } else {
            deliverableMulti.setDesignAssign(approvalName);
            deliverableMulti.setFlagStatus(4);
            deliverableMulti.setDeliverableCreatedDate(today);
            deliverableMultiService.update(deliverableMulti);

            AocForm aocForm = aocFormService.readById(aocid);
            String documentno1 = aocForm.getDocumentNo();
            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Design CoOrdinator Edit");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments("");
            aocLogMaster.setStatus("AOC Design CoOrdinator Edited");
            aocLogMaster.setAocId(aocid);
            aocLogMasterService.create(aocLogMaster);

            String userid = deliverableMulti.getDesignAssign();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(66);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Design Coordinator AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc"
                    + File.separator + aocid;
            File f1 = new File(path);
            boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

            List<MultipartFile> files1 = multipartRequest.getFiles("attach");
            String[] description = request.getParameterValues("descriptions");
            int a = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "Aoc"
                                + File.separator + aocid + File.separator;

                        File directory = new File(fileLocationURL);
                        if (!directory.exists()) {
                            directory.mkdirs(); // Create the directory if it doesn't exist
                        }

                        File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        try {
                            file1.transferTo(destinationFile1); // Ensure proper exception handling
                        } catch (Exception e) {
                            e.printStackTrace(); // Handle the error or log it
                        }

                        DesignCoordinatorMultiAttach designCoordinatorMultiAttach = new DesignCoordinatorMultiAttach();
                        designCoordinatorMultiAttach.setAttachement(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        designCoordinatorMultiAttach.setDescription(description[a]);
                        designCoordinatorMultiAttach.setDeliverableMultiId((Integer.parseInt(id)));
                        designCoordinatorMultiAttach.setOapId(oapid);
                        designCoordinatorMultiAttach.setAocId(aocid);
                        designCoordinatorMultiAttachService.create(designCoordinatorMultiAttach);

                        a++;
                    }
                }

            }
        }
        session.setAttribute("successMessage", "OAP Form Design Co-Ordinator Edited OR Recycled successfully");
        mv.setViewName("redirect:oapForm.htm?act=Designcordinator");

        return mv;
    }

    public ModelAndView DesigncordinatorRejectView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        Deliverable deliverable = deliverableService.readByoapid(id);
        int deliverableid = deliverable.getId();
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        int oapid = oapForm.getId();
        DesignCoordinatorMultiAttach designCoordinatorMultiAttach = designCoordinatorMultiAttachService.readBydelmultiids(oapid);
        int delivablemultiid = designCoordinatorMultiAttach.getDeliverableMultiId();

        List list5 = designCoordinatorMultiAttachService.readBydelmultiid(oapid);
        CrcForm crcForm = crcFormService.readByoapId(id);

        List list11 = deliverableMultiService.readByDeliveryId(deliverableid);
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);
        List list0 = deliverableMultiService.readByOapid(id);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("delivablemultiid", delivablemultiid);
        mv.getModelMap().put("list5", list5);
//	mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("list11", list11);
        mv.getModelMap().put("crcForm", crcForm);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("oapForm", oapForm);
        mv.getModelMap().put("list10", deliverable);
        mv.setViewName("Oap/DesigncordinatorRejectView");
        return mv;
    }

    public ModelAndView Designcordinatorview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        int oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(oapformid + "");
        OapForm oapForm = oapFormService.readByformid(oapformid);
        AocForm aocForm = aocFormService.readByformid(aocformid);

        CrcForm crcForm = crcFormService.readByoapIds(oapformid);

        KickOffForm kickOffForm = kickOffFormService.readByaocIds(aocformid);
        List aocSurveyAttch = aocSurveyAttachmentService.readByaocId(aocformid + "");

        mv.getModelMap().put("aocSurveyAttch", aocSurveyAttch);
        List list16 = userRightsService.readByDesignManager();
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("oapForm", oapForm);
        mv.getModelMap().put("kickOffForm", kickOffForm);
        mv.getModelMap().put("crcForm", crcForm);
        mv.getModelMap().put("aocForm", aocForm);
        mv.getModelMap().put("deliverableMulti", deliverableMulti);

        mv.getModelMap().put("list16", list16);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/Designcordinatorview");
        return mv;
    }

    public ModelAndView Designcordinatorviewpopup(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String co = request.getParameter("count");
        int count = 1; // Default to 1 if `co` is null

        try {
            if (co != null && !co.isEmpty()) {
                count = Integer.parseInt(co);
            } else {
                count = 1; // If `co` is null or empty, default to 1
            }
        } catch (NumberFormatException e) {
            count = 1; // If parsing fails, default to 1
        }

        int setValue = 0; // Default value

        if (("10".equals(type))) {
            setValue = 4;
        } else if ("Service".equals(type)) {
            setValue = 3;
        } else if ("Contract".equals(type)) {
            setValue = 1;
        } else if ("Goods".equals(type)) {
            setValue = 0;
        }

        List list1 = iteamDetailsAttachmentsService.readBystatus2(setValue, id);

        if (co == null) {
            count = 1;
        } else {
            count = list1.size(); // Assign list size when `co` is not null
        }

        mv.getModelMap().put("itemDetailsGoodsnService", list1);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("type", type);
        mv.setViewName("Oap/AjaxModelOapIteamDatailsAttachment");
        return mv;
    }

    public ModelAndView Designcordinatorviewpopuprecycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        String type = request.getParameter("type");
        int setValue = 0; // Default value

        if ("Service".equals(type)) {
            setValue = 3;
        } else if ("Contract".equals(type)) {
            setValue = 1;
        } else if ("Goods".equals(type)) {
            setValue = 0;
        } else if ("Contract_Goods".equals(type)) {
            setValue = 4;
        }

        List list1 = iteamDetailsAttachmentsService.readBystatus2(setValue, id);

        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("type", type);

        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/Designcordinatorviewpopuprecycle");
        return mv;
    }

    public ModelAndView Designcordinatorviewpopuprecyclesubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        if ("Service".equals(type)) {
            List list77 = iteamDetailsAttachmentsService.readBydeleteAll1(id);
            for (Object o : list77) {

                IteamDetailsAttachments iteamDetailsAttachments = (IteamDetailsAttachments) o;
                int id3 = iteamDetailsAttachments.getId();
                iteamDetailsAttachmentsService.delete(id3);

            }
            String service_file = request.getParameter("service_file");
            if (service_file == null) {
                service_file = "";
            }

            String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("service_file");

            service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
            //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //MultipartFile multipartFile = multipartRequest.getFile("service_file");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                System.out.println("The given file is");
                int j = 0;

                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    if (j >= 7) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String remark = "";
                        String budget_amount = "";
                        int i = 0;
                        int k = 0;
                        //while (cellIterator.hasNext())
                        for (int i1 = 1; i1 <= 8; i1++) {
                            i++;
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
                                    item_desc = cell.getStringCellValue();
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

                            }
                            if (i == 9) {

                            }

                        }
                        if (k == 1) {
                            break;
                        }
                        //insert data

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                            IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                            iteamDetailsAttachments.setSno(srNo);
                            iteamDetailsAttachments.setIteamCode(item_code);
                            iteamDetailsAttachments.setIteamDescription(item_desc);
                            iteamDetailsAttachments.setPurpose(purpose);
                            iteamDetailsAttachments.setMake(long_text);
                            iteamDetailsAttachments.setUom(uom);
                            iteamDetailsAttachments.setQty(qty);
                            iteamDetailsAttachments.setFlagStatus(3);
                            iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id));

                            iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if ("Contract".equals(type)) {
            List list77 = iteamDetailsAttachmentsService.readByPRItemDesc1(id);
            for (Object o : list77) {

                IteamDetailsAttachments iteamDetailsAttachments = (IteamDetailsAttachments) o;
                int id4 = iteamDetailsAttachments.getId();
                iteamDetailsAttachmentsService.delete(id4);

            }
            String service_file = request.getParameter("service_file");
            if (service_file == null) {
                service_file = "";
            }

            String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("service_file");

            service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
            //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //MultipartFile multipartFile = multipartRequest.getFile("service_file");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                System.out.println("The given file is");
                int j = 0;

                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    if (j >= 7) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String remark = "";
                        String budget_amount = "";
                        int i = 0;
                        int k = 0;
                        //while (cellIterator.hasNext())
                        for (int i1 = 1; i1 <= 8; i1++) {
                            i++;
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
                                    item_desc = cell.getStringCellValue();
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

                            }
                            if (i == 9) {

                            }

                        }
                        if (k == 1) {
                            break;
                        }
                        //insert data

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                            IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                            iteamDetailsAttachments.setSno(srNo);
                            iteamDetailsAttachments.setIteamCode(item_code);
                            iteamDetailsAttachments.setIteamDescription(item_desc);
                            iteamDetailsAttachments.setPurpose(purpose);
                            iteamDetailsAttachments.setMake(long_text);
                            iteamDetailsAttachments.setUom(uom);
                            iteamDetailsAttachments.setQty(qty);
                            iteamDetailsAttachments.setFlagStatus(1);
                            iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id));

                            iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if ("Contract_Goods".equals(type)) {
            List list77 = iteamDetailsAttachmentsService.readByPRItemDesc2(id);
            for (Object o : list77) {

                IteamDetailsAttachments iteamDetailsAttachments = (IteamDetailsAttachments) o;
                int id5 = iteamDetailsAttachments.getId();
                iteamDetailsAttachmentsService.delete(id5);

            }
            String service_file = request.getParameter("service_file");
            if (service_file == null) {
                service_file = "";
            }

            String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("service_file");

            service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
            //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //MultipartFile multipartFile = multipartRequest.getFile("service_file");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                System.out.println("The given file is");
                int j = 0;

                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    if (j >= 7) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String remark = "";
                        String budget_amount = "";
                        int i = 0;
                        int k = 0;
                        //while (cellIterator.hasNext())
                        for (int i1 = 1; i1 <= 8; i1++) {
                            i++;
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
                                    item_desc = cell.getStringCellValue();
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

                            }
                            if (i == 9) {

                            }

                        }
                        if (k == 1) {
                            break;
                        }
                        //insert data

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                            IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                            iteamDetailsAttachments.setSno(srNo);
                            iteamDetailsAttachments.setIteamCode(item_code);
                            iteamDetailsAttachments.setIteamDescription(item_desc);
                            iteamDetailsAttachments.setPurpose(purpose);
                            iteamDetailsAttachments.setMake(long_text);
                            iteamDetailsAttachments.setUom(uom);
                            iteamDetailsAttachments.setQty(qty);
                            iteamDetailsAttachments.setFlagStatus(4);
                            iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id));

                            iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("Goods".equals(type)) {
            List list77 = iteamDetailsAttachmentsService.readBydeleteAll(id);
            for (Object o : list77) {

                IteamDetailsAttachments iteamDetailsAttachments = (IteamDetailsAttachments) o;
                int id7 = iteamDetailsAttachments.getId();
                iteamDetailsAttachmentsService.delete(id7);

            }
            String service_file = request.getParameter("service_file");
            if (service_file == null) {
                service_file = "";
            }

            String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("service_file");

            service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
            //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //MultipartFile multipartFile = multipartRequest.getFile("service_file");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                System.out.println("The given file is");
                int j = 0;

                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    if (j >= 7) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String remark = "";
                        String budget_amount = "";
                        int i = 0;
                        int k = 0;
                        //while (cellIterator.hasNext())
                        for (int i1 = 1; i1 <= 8; i1++) {
                            i++;
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
                                    item_desc = cell.getStringCellValue();
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

                            }
                            if (i == 9) {

                            }

                        }
                        if (k == 1) {
                            break;
                        }
                        //insert data

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                            IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                            iteamDetailsAttachments.setSno(srNo);
                            iteamDetailsAttachments.setIteamCode(item_code);
                            iteamDetailsAttachments.setIteamDescription(item_desc);
                            iteamDetailsAttachments.setPurpose(purpose);
                            iteamDetailsAttachments.setMake(long_text);
                            iteamDetailsAttachments.setUom(uom);
                            iteamDetailsAttachments.setQty(qty);
                            iteamDetailsAttachments.setFlagStatus(0);
                            iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id));

                            iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

// Insert into file details
        request.setAttribute("successMessage", " File Upload successfully");

        mv.getModelMap().put("id", id);

        mv = Designcordinatorviewpopuprecycle(request, response);
        return mv;
    }

    public ModelAndView Designcordinatorviewpopupsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String type = request.getParameter("type");

        if ("Service".equals(type)) {
            String service_file = request.getParameter("service_file");
            if (service_file == null) {
                service_file = "";
            }
            iteamDetailsAttachmentsService.deleteByDeliMultiAndFlag(id, 3);
            String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("service_file");

            service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
            //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //MultipartFile multipartFile = multipartRequest.getFile("service_file");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                System.out.println("The given file is");
                int j = 0;

                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    if (j >= 7) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String account_category = "";
                        String account_value = "";
                        String product_type = "";
                        String product_group = "";
                        String tax_code = "";
                        String price = "";
                        String delivery_date = "";
                        String start_date = "";
                        String end_date = "";
                        String remark = "";
                        String budget_amount = "";
                        int i = 0;
                        int k = 0;
                        //while (cellIterator.hasNext())
                        for (int i1 = 1; i1 <= 16; i1++) {
                            i++;
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
                                    item_desc = cell.getStringCellValue();
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
                                    account_category = cell.getNumericCellValue() + "";
                                    if (account_category.equals("0.0")) {
                                        account_category = "";
                                    }
                                } catch (Exception e1) {
                                    account_category = cell.getStringCellValue();
                                }
                            }
                            if (i == 9) {
                                try {
                                    account_value = cell.getNumericCellValue() + "";
                                    if (account_value.equals("0.0")) {
                                        account_value = "";
                                    }
                                } catch (Exception e1) {
                                    account_value = cell.getStringCellValue();
                                }
                            }
                            if (i == 10) {
                                try {
                                    product_type = cell.getNumericCellValue() + "";
                                    if (product_type.equals("0.0")) {
                                        product_type = "";
                                    }
                                } catch (Exception e1) {
                                    product_type = cell.getStringCellValue();
                                }
                            }
                            if (i == 11) {
                                try {
                                    product_group = cell.getNumericCellValue() + "";
                                    if (product_group.equals("0.0")) {
                                        product_group = "";
                                    }
                                } catch (Exception e1) {
                                    product_group = cell.getStringCellValue();
                                }
                            }
                            if (i == 12) {
                                try {
                                    tax_code = cell.getNumericCellValue() + "";
                                    if (tax_code.equals("0.0")) {
                                        tax_code = "";
                                    }
                                } catch (Exception e1) {
                                    tax_code = cell.getStringCellValue();
                                }
                            }
                            if (i == 13) {
                                try {
                                    price = cell.getNumericCellValue() + "";
                                    if (price.equals("0.0")) {
                                        price = "";
                                    }
                                } catch (Exception e1) {
                                    price = cell.getStringCellValue();
                                }
                            }
                            if (i == 14) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    delivery_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    delivery_date = cell.getStringCellValue();
                                }
                            }
                            if (i == 15) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    start_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    start_date = cell.getStringCellValue();
                                }
                            }
                            if (i == 16) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    end_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    end_date = cell.getStringCellValue();
                                }
                            }

                        }
                        if (k == 1) {
                            break;
                        }
                        //insert data

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                            IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                            iteamDetailsAttachments.setSno(srNo);
                            iteamDetailsAttachments.setIteamCode(item_code);
                            iteamDetailsAttachments.setIteamDescription(item_desc);
                            iteamDetailsAttachments.setPurpose(purpose);
                            iteamDetailsAttachments.setMake(long_text);
                            iteamDetailsAttachments.setUom(uom);
                            iteamDetailsAttachments.setQty(qty);
                            iteamDetailsAttachments.setAccountCategory(account_category);
                            iteamDetailsAttachments.setAccountValue(account_value);
                            iteamDetailsAttachments.setProductType(product_type);
                            iteamDetailsAttachments.setProductGroup(product_group);
                            iteamDetailsAttachments.setTaxCode(tax_code);
                            iteamDetailsAttachments.setPrice(price);
                            iteamDetailsAttachments.setDeliveryDate(delivery_date);
                            iteamDetailsAttachments.setStartDate(start_date);
                            iteamDetailsAttachments.setEndDate(end_date);
                            iteamDetailsAttachments.setFlagStatus(3);
                            iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id));

                            iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if ("Contract".equals(type)) {
            String service_file = request.getParameter("service_file");
            if (service_file == null) {
                service_file = "";
            }
            iteamDetailsAttachmentsService.deleteByDeliMultiAndFlag(id, 1);
            String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("service_file");

            service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
            //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //MultipartFile multipartFile = multipartRequest.getFile("service_file");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                System.out.println("The given file is");
                int j = 0;

                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    if (j >= 7) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String account_category = "";
                        String account_value = "";
                        String product_type = "";
                        String product_group = "";
                        String tax_code = "";
                        String price = "";
                        String delivery_date = "";
                        String start_date = "";
                        String end_date = "";
                        String remark = "";
                        String budget_amount = "";
                        int i = 0;
                        int k = 0;
                        //while (cellIterator.hasNext())
                        for (int i1 = 1; i1 <= 16; i1++) {
                            i++;
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
                                    item_desc = cell.getStringCellValue();
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
                                    account_category = cell.getNumericCellValue() + "";
                                    if (account_category.equals("0.0")) {
                                        account_category = "";
                                    }
                                } catch (Exception e1) {
                                    account_category = cell.getStringCellValue();
                                }
                            }
                            if (i == 9) {
                                try {
                                    account_value = cell.getNumericCellValue() + "";
                                    if (account_value.equals("0.0")) {
                                        account_value = "";
                                    }
                                } catch (Exception e1) {
                                    account_value = cell.getStringCellValue();
                                }
                            }
                            if (i == 10) {
                                try {
                                    product_type = cell.getNumericCellValue() + "";
                                    if (product_type.equals("0.0")) {
                                        product_type = "";
                                    }
                                } catch (Exception e1) {
                                    product_type = cell.getStringCellValue();
                                }
                            }
                            if (i == 11) {
                                try {
                                    product_group = cell.getNumericCellValue() + "";
                                    if (product_group.equals("0.0")) {
                                        product_group = "";
                                    }
                                } catch (Exception e1) {
                                    product_group = cell.getStringCellValue();
                                }
                            }
                            if (i == 12) {
                                try {
                                    tax_code = cell.getNumericCellValue() + "";
                                    if (tax_code.equals("0.0")) {
                                        tax_code = "";
                                    }
                                } catch (Exception e1) {
                                    tax_code = cell.getStringCellValue();
                                }
                            }
                            if (i == 13) {
                                try {
                                    price = cell.getNumericCellValue() + "";
                                    if (price.equals("0.0")) {
                                        price = "";
                                    }
                                } catch (Exception e1) {
                                    price = cell.getStringCellValue();
                                }
                            }
                            if (i == 14) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    delivery_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    delivery_date = cell.getStringCellValue();
                                }
                            }
                            if (i == 15) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    start_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    start_date = cell.getStringCellValue();
                                }
                            }
                            if (i == 16) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    end_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    end_date = cell.getStringCellValue();
                                }
                            }

                        }
                        if (k == 1) {
                            break;
                        }
                        //insert data

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                            IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                            iteamDetailsAttachments.setSno(srNo);
                            iteamDetailsAttachments.setIteamCode(item_code);
                            iteamDetailsAttachments.setIteamDescription(item_desc);
                            iteamDetailsAttachments.setPurpose(purpose);
                            iteamDetailsAttachments.setMake(long_text);
                            iteamDetailsAttachments.setUom(uom);
                            iteamDetailsAttachments.setQty(qty);
                            iteamDetailsAttachments.setAccountCategory(account_category);
                            iteamDetailsAttachments.setAccountValue(account_value);
                            iteamDetailsAttachments.setProductType(product_type);
                            iteamDetailsAttachments.setProductGroup(product_group);
                            iteamDetailsAttachments.setTaxCode(tax_code);
                            iteamDetailsAttachments.setPrice(price);
                            iteamDetailsAttachments.setDeliveryDate(delivery_date);
                            iteamDetailsAttachments.setStartDate(start_date);
                            iteamDetailsAttachments.setEndDate(end_date);
                            iteamDetailsAttachments.setFlagStatus(1);
                            iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id));

                            iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if ("10".equals(type)) {

            String service_file = request.getParameter("service_file");
            if (service_file == null) {
                service_file = "";
            }
            iteamDetailsAttachmentsService.deleteByDeliMultiAndFlag(id, 4);
            String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("service_file");

            service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
            //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //MultipartFile multipartFile = multipartRequest.getFile("service_file");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                System.out.println("The given file is");
                int j = 0;

                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    if (j >= 7) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String account_category = "";
                        String account_value = "";
                        String product_type = "";
                        String product_group = "";
                        String tax_code = "";
                        String price = "";
                        String delivery_date = "";
                        String start_date = "";
                        String end_date = "";
                        String remark = "";
                        String budget_amount = "";
                        int i = 0;
                        int k = 0;
                        //while (cellIterator.hasNext())
                        for (int i1 = 1; i1 <= 16; i1++) {
                            i++;
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
                                    item_desc = cell.getStringCellValue();
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
                                    account_category = cell.getNumericCellValue() + "";
                                    if (account_category.equals("0.0")) {
                                        account_category = "";
                                    }
                                } catch (Exception e1) {
                                    account_category = cell.getStringCellValue();
                                }
                            }
                            if (i == 9) {
                                try {
                                    account_value = cell.getNumericCellValue() + "";
                                    if (account_value.equals("0.0")) {
                                        account_value = "";
                                    }
                                } catch (Exception e1) {
                                    account_value = cell.getStringCellValue();
                                }
                            }
                            if (i == 10) {
                                try {
                                    product_type = cell.getNumericCellValue() + "";
                                    if (product_type.equals("0.0")) {
                                        product_type = "";
                                    }
                                } catch (Exception e1) {
                                    product_type = cell.getStringCellValue();
                                }
                            }
                            if (i == 11) {
                                try {
                                    product_group = cell.getNumericCellValue() + "";
                                    if (product_group.equals("0.0")) {
                                        product_group = "";
                                    }
                                } catch (Exception e1) {
                                    product_group = cell.getStringCellValue();
                                }
                            }
                            if (i == 12) {
                                try {
                                    tax_code = cell.getNumericCellValue() + "";
                                    if (tax_code.equals("0.0")) {
                                        tax_code = "";
                                    }
                                } catch (Exception e1) {
                                    tax_code = cell.getStringCellValue();
                                }
                            }
                            if (i == 13) {
                                try {
                                    price = cell.getNumericCellValue() + "";
                                    if (price.equals("0.0")) {
                                        price = "";
                                    }
                                } catch (Exception e1) {
                                    price = cell.getStringCellValue();
                                }
                            }
                            if (i == 14) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    delivery_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    delivery_date = cell.getStringCellValue();
                                }
                            }
                            if (i == 15) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    start_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    start_date = cell.getStringCellValue();
                                }
                            }
                            if (i == 16) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    end_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    end_date = cell.getStringCellValue();
                                }
                            }

                        }
                        if (k == 1) {
                            break;
                        }
                        //insert data

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                            IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                            iteamDetailsAttachments.setSno(srNo);
                            iteamDetailsAttachments.setIteamCode(item_code);
                            iteamDetailsAttachments.setIteamDescription(item_desc);
                            iteamDetailsAttachments.setPurpose(purpose);
                            iteamDetailsAttachments.setMake(long_text);
                            iteamDetailsAttachments.setUom(uom);
                            iteamDetailsAttachments.setQty(qty);
                            iteamDetailsAttachments.setAccountCategory(account_category);
                            iteamDetailsAttachments.setAccountValue(account_value);
                            iteamDetailsAttachments.setProductType(product_type);
                            iteamDetailsAttachments.setProductGroup(product_group);
                            iteamDetailsAttachments.setTaxCode(tax_code);
                            iteamDetailsAttachments.setPrice(price);
                            iteamDetailsAttachments.setDeliveryDate(delivery_date);
                            iteamDetailsAttachments.setStartDate(start_date);
                            iteamDetailsAttachments.setEndDate(end_date);
                            iteamDetailsAttachments.setFlagStatus(4);
                            iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id));

                            iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("Goods".equals(type)) {
            String service_file = request.getParameter("service_file");
            if (service_file == null) {
                service_file = "";
            }
            iteamDetailsAttachmentsService.deleteByDeliMultiAndFlag(id, 0);
            String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("service_file");

            service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
            //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //MultipartFile multipartFile = multipartRequest.getFile("service_file");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {

                File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                System.out.println("The given file is");
                int j = 0;

                while (itr.hasNext()) {
                    j++;
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    if (j >= 7) {
                        String srNo = "";
                        String item_code = "";
                        String item_desc = "";
                        String purpose = "";
                        String long_text = "";
                        String uom = "";
                        String qty = "";
                        String account_category = "";
                        String account_value = "";
                        String product_type = "";
                        String product_group = "";
                        String tax_code = "";
                        String price = "";
                        String delivery_date = "";
                        String start_date = "";
                        String end_date = "";
                        String remark = "";
                        String budget_amount = "";
                        int i = 0;
                        int k = 0;
                        //while (cellIterator.hasNext())
                        for (int i1 = 1; i1 <= 16; i1++) {
                            i++;
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
                                    item_desc = cell.getStringCellValue();
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
                                    account_category = cell.getNumericCellValue() + "";
                                    if (account_category.equals("0.0")) {
                                        account_category = "";
                                    }
                                } catch (Exception e1) {
                                    account_category = cell.getStringCellValue();
                                }
                            }
                            if (i == 9) {
                                try {
                                    account_value = cell.getNumericCellValue() + "";
                                    if (account_value.equals("0.0")) {
                                        account_value = "";
                                    }
                                } catch (Exception e1) {
                                    account_value = cell.getStringCellValue();
                                }
                            }
                            if (i == 10) {
                                try {
                                    product_type = cell.getNumericCellValue() + "";
                                    if (product_type.equals("0.0")) {
                                        product_type = "";
                                    }
                                } catch (Exception e1) {
                                    product_type = cell.getStringCellValue();
                                }
                            }
                            if (i == 11) {
                                try {
                                    product_group = cell.getNumericCellValue() + "";
                                    if (product_group.equals("0.0")) {
                                        product_group = "";
                                    }
                                } catch (Exception e1) {
                                    product_group = cell.getStringCellValue();
                                }
                            }
                            if (i == 12) {
                                try {
                                    tax_code = cell.getNumericCellValue() + "";
                                    if (tax_code.equals("0.0")) {
                                        tax_code = "";
                                    }
                                } catch (Exception e1) {
                                    tax_code = cell.getStringCellValue();
                                }
                            }
                            if (i == 13) {
                                try {
                                    price = cell.getNumericCellValue() + "";
                                    if (price.equals("0.0")) {
                                        price = "";
                                    }
                                } catch (Exception e1) {
                                    price = cell.getStringCellValue();
                                }
                            }
                            if (i == 14) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    delivery_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    delivery_date = cell.getStringCellValue();
                                }
                            }
                            if (i == 15) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    start_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    start_date = cell.getStringCellValue();
                                }
                            }
                            if (i == 16) {
                                try {
                                    Date timeLine = cell.getDateCellValue();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    end_date = formatter.format(timeLine);
                                } catch (Exception e1) {
                                    end_date = cell.getStringCellValue();
                                }
                            }

                        }
                        if (k == 1) {
                            break;
                        }
                        //insert data

                        Double qty1 = 0.0;
                        try {
                            qty1 = Double.parseDouble(qty);
                        } catch (Exception e11) {
                        }

                        if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                            IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                            iteamDetailsAttachments.setSno(srNo);
                            iteamDetailsAttachments.setIteamCode(item_code);
                            iteamDetailsAttachments.setIteamDescription(item_desc);
                            iteamDetailsAttachments.setPurpose(purpose);
                            iteamDetailsAttachments.setMake(long_text);
                            iteamDetailsAttachments.setUom(uom);
                            iteamDetailsAttachments.setQty(qty);
                            iteamDetailsAttachments.setAccountCategory(account_category);
                            iteamDetailsAttachments.setAccountValue(account_value);
                            iteamDetailsAttachments.setProductType(product_type);
                            iteamDetailsAttachments.setProductGroup(product_group);
                            iteamDetailsAttachments.setTaxCode(tax_code);
                            iteamDetailsAttachments.setPrice(price);
                            iteamDetailsAttachments.setDeliveryDate(delivery_date);
                            iteamDetailsAttachments.setStartDate(start_date);
                            iteamDetailsAttachments.setEndDate(end_date);
                            iteamDetailsAttachments.setFlagStatus(0);
                            iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id));

                            iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                        }
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int setValue = 0; // Default value

        if ("10".equals(type)) {
            setValue = 4;
        } else if ("Service".equals(type)) {
            setValue = 3;
        } else if ("Contract".equals(type)) {
            setValue = 1;
        } else if ("Goods".equals(type)) {
            setValue = 0;
        }

        List list1 = iteamDetailsAttachmentsService.readBystatus2(setValue, id);
        int count = list1.size();

        // Insert into file details
//        if (count > 0) {
//            request.setAttribute("successMessage", " File Upload successfully");
//        } else {
//            request.setAttribute("failureMessage", " File Not Upload ");
//        }
        if (count > 0) {
            mv.addObject("message", " File Upload successfully");
            mv.addObject("status", "success");
        } else {
            mv.addObject("message", " File Not Upload");
            mv.addObject("status", "error");
        }

        mv.getModelMap().put("count", count);

        mv.getModelMap().put("itemDetailsGoodsnService", list1);
        mv.getModelMap().put("type", type);
        mv.getModelMap().put("id", id);
//        mv = Designcordinatorviewpopup(request, response);
        mv.setViewName("Oap/AjaxModelOapIteamDatailsAttachment");

        return mv;
    }

    public ModelAndView AgaxOapIteamDatailsAttachments(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("q");
        String status = request.getParameter("sts");

//	List list = iteamDetailsAttachmentsService.readByPRItemDesc(id);
        List list1 = iteamDetailsAttachmentsService.readBystatus(status, id);
        int countt = list1.size();
        mv.getModelMap().put("status", status);
//	mv.getModelMap().put("list", list);
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("countt", countt);
        mv.getModelMap().put("id", id);

        mv.setViewName("Oap/AgaxOapIteamDatailsAttachments");
        return mv;
    }

    public ModelAndView AgaxOapIteamDatailsAttachmentscreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("q");

        String status = request.getParameter("sts");
        String status1 = request.getParameter("type");

        if ("Contract_Goods".equals(status1)) {
            status = "4"; // Assign "4" to status when condition is true
        } else if ("Service".equals(status1)) {
            status = "3";
        }

//	List list = iteamDetailsAttachmentsService.readByPRItemDesc2(id);
        List list1 = iteamDetailsAttachmentsService.readBystatus(status, id);
        int countt = list1.size(); // Assign list size when `co` is not null

        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("countt", countt);

        mv.setViewName("Oap/AgaxOapIteamDatailsAttachmentscreate");
        return mv;
    }

    public ModelAndView deleteDesigncordinatorviewpopup(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String type = request.getParameter("type");

        String ids = request.getParameter("Ids");
        String[] checkId = ids.split(",");

        for (int i = 0; i < checkId.length; i++) {
            String check_value = checkId[i];
            iteamDetailsAttachmentsService.delete(Integer.parseInt(check_value));
        }
        mv.setViewName("forward:/oapForm.htm?act=Designcordinatorviewpopup&id&type=" + id + type);
        return mv;
    }

    public ModelAndView Designcordinatorviewpopup1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id1 = request.getParameter("id1");
        String co = request.getParameter("count");
        int count = 1; // Default to 1 if `co` is null
        try {
            if (co != null && !co.isEmpty()) {
                count = Integer.parseInt(co);
            } else {
                count = 1; // If `co` is null or empty, default to 1
            }
        } catch (NumberFormatException e) {
            count = 1; // If parsing fails, default to 1
        }

        List list = iteamDetailsAttachmentsService.readByPRItemDesc1(id1);
        if (co == null) {
            count = 1;
        } else {
            count = list.size(); // Assign list size when `co` is not null
        }
        mv.getModelMap().put("itemDetailsContract", list);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("id", id1);
        mv.setViewName("Oap/AjaxModelOapIteamDatailsAttachmentContract");
        return mv;
    }

    public ModelAndView Designcordinatorviewpopup1recycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id1 = request.getParameter("id");
        String type = request.getParameter("type");
        int setValue = 0; // Default value

        if ("Contract".equals(type)) {
            setValue = 1;
        }
//	List list = iteamDetailsAttachmentsService.readByPRItemDesc1(id1);

        List list = iteamDetailsAttachmentsService.readBystatus2(setValue, id1);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("type", type);

        mv.getModelMap().put("id", id1);
        mv.setViewName("Oap/Designcordinatorviewpopup1recycle");
        return mv;
    }

    public ModelAndView Designcordinatorviewpopup1recyclesubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id1 = request.getParameter("id1");

        List list77 = iteamDetailsAttachmentsService.readByPRItemDesc1(id1);
        for (Object o : list77) {

            IteamDetailsAttachments iteamDetailsAttachments = (IteamDetailsAttachments) o;
            int id3 = iteamDetailsAttachments.getId();
            iteamDetailsAttachmentsService.delete(id3);

        }

        String service_file = request.getParameter("service_file");
        if (service_file == null) {
            service_file = "";
        }

        String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile multipartFile = multipartRequest.getFile("service_file");

        service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
        //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //MultipartFile multipartFile = multipartRequest.getFile("service_file");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            System.out.println("The given file is");
            int j = 0;

            while (itr.hasNext()) {
                j++;
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                if (j >= 7) {
                    String srNo = "";
                    String item_code = "";
                    String item_desc = "";
                    String purpose = "";
                    String long_text = "";
                    String uom = "";
                    String qty = "";
                    String remark = "";
                    String budget_amount = "";
                    int i = 0;
                    int k = 0;
                    //while (cellIterator.hasNext())
                    for (int i1 = 1; i1 <= 8; i1++) {
                        i++;
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
                                item_desc = cell.getStringCellValue();
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

                        }
                        if (i == 9) {

                        }

                    }
                    if (k == 1) {
                        break;
                    }
                    //insert data

                    Double qty1 = 0.0;
                    try {
                        qty1 = Double.parseDouble(qty);
                    } catch (Exception e11) {
                    }

                    if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                        IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                        iteamDetailsAttachments.setSno(srNo);
                        iteamDetailsAttachments.setIteamCode(item_code);
                        iteamDetailsAttachments.setIteamDescription(item_desc);
                        iteamDetailsAttachments.setPurpose(purpose);
                        iteamDetailsAttachments.setMake(long_text);
                        iteamDetailsAttachments.setUom(uom);
                        iteamDetailsAttachments.setQty(qty);
                        iteamDetailsAttachments.setFlagStatus(1);
                        iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id1));

                        iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                    }
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

// Insert into file details
        request.setAttribute("successMessage", " File Upload successfully");

        mv.getModelMap().put("id", id1);
        mv.setViewName("Oap/Designcordinatorviewpopup1recycle");
        return mv;
    }

    public ModelAndView Designcordinatorviewpopupsubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id1 = request.getParameter("id1");

        String service_file = request.getParameter("service_file1");
        if (service_file == null) {
            service_file = "";
        }
        iteamDetailsAttachmentsService.deleteByDeliMultiAndFlag(id1, 1);
        String service_file1 = service_file.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile multipartFile = multipartRequest.getFile("service_file1");

        service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

//        List fileDetail1 = fileDetailService.readByRefNo(ref_no, service_file1);
        //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //MultipartFile multipartFile = multipartRequest.getFile("service_file");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP" + File.separator;
                File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                service_file = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/OAP/" + service_file);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            System.out.println("The given file is");
            int j = 0;

            while (itr.hasNext()) {
                j++;
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                if (j >= 7) {
                    String srNo = "";
                    String item_code = "";
                    String item_desc = "";
                    String purpose = "";
                    String long_text = "";
                    String uom = "";
                    String qty = "";
                    String account_category = "";
                    String account_value = "";
                    String product_type = "";
                    String product_group = "";
                    String tax_code = "";
                    String price = "";
                    String delivery_date = "";
                    String start_date = "";
                    String end_date = "";
                    String remark = "";
                    String budget_amount = "";
                    int i = 0;
                    int k = 0;
                    //while (cellIterator.hasNext())
                    for (int i1 = 1; i1 <= 16; i1++) {
                        i++;
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
                                item_desc = cell.getStringCellValue();
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
                                account_category = cell.getNumericCellValue() + "";
                                if (account_category.equals("0.0")) {
                                    account_category = "";
                                }
                            } catch (Exception e1) {
                                account_category = cell.getStringCellValue();
                            }
                        }
                        if (i == 9) {
                            try {
                                account_value = cell.getNumericCellValue() + "";
                                if (account_value.equals("0.0")) {
                                    account_value = "";
                                }
                            } catch (Exception e1) {
                                account_value = cell.getStringCellValue();
                            }
                        }
                        if (i == 10) {
                            try {
                                product_type = cell.getNumericCellValue() + "";
                                if (product_type.equals("0.0")) {
                                    product_type = "";
                                }
                            } catch (Exception e1) {
                                product_type = cell.getStringCellValue();
                            }
                        }
                        if (i == 11) {
                            try {
                                product_group = cell.getNumericCellValue() + "";
                                if (product_group.equals("0.0")) {
                                    product_group = "";
                                }
                            } catch (Exception e1) {
                                product_group = cell.getStringCellValue();
                            }
                        }
                        if (i == 12) {
                            try {
                                tax_code = cell.getNumericCellValue() + "";
                                if (tax_code.equals("0.0")) {
                                    tax_code = "";
                                }
                            } catch (Exception e1) {
                                tax_code = cell.getStringCellValue();
                            }
                        }
                        if (i == 13) {
                            try {
                                price = cell.getNumericCellValue() + "";
                                if (price.equals("0.0")) {
                                    price = "";
                                }
                            } catch (Exception e1) {
                                price = cell.getStringCellValue();
                            }
                        }
                        if (i == 14) {
                            try {
                                Date timeLine = cell.getDateCellValue();
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                delivery_date = formatter.format(timeLine);
                            } catch (Exception e1) {
                                delivery_date = cell.getStringCellValue();
                            }
                        }
                        if (i == 15) {
                            try {
                                Date timeLine = cell.getDateCellValue();
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                start_date = formatter.format(timeLine);
                            } catch (Exception e1) {
                                start_date = cell.getStringCellValue();
                            }
                        }
                        if (i == 16) {
                            try {
                                Date timeLine = cell.getDateCellValue();
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                end_date = formatter.format(timeLine);
                            } catch (Exception e1) {
                                end_date = cell.getStringCellValue();
                            }
                        }

                    }
                    if (k == 1) {
                        break;
                    }
                    //insert data

                    Double qty1 = 0.0;
                    try {
                        qty1 = Double.parseDouble(qty);
                    } catch (Exception e11) {
                    }

                    if (qty1 > 0) {
//			List prItem = iteamDetailsAttachmentsService.readByPRItemDesc(id);
//			if (prItem.size() == 0) {
                        IteamDetailsAttachments iteamDetailsAttachments = new IteamDetailsAttachments();

                        iteamDetailsAttachments.setSno(srNo);
                        iteamDetailsAttachments.setIteamCode(item_code);
                        iteamDetailsAttachments.setIteamDescription(item_desc);
                        iteamDetailsAttachments.setPurpose(purpose);
                        iteamDetailsAttachments.setMake(long_text);
                        iteamDetailsAttachments.setUom(uom);
                        iteamDetailsAttachments.setQty(qty);
                        iteamDetailsAttachments.setAccountCategory(account_category);
                        iteamDetailsAttachments.setAccountValue(account_value);
                        iteamDetailsAttachments.setProductType(product_type);
                        iteamDetailsAttachments.setProductGroup(product_group);
                        iteamDetailsAttachments.setTaxCode(tax_code);
                        iteamDetailsAttachments.setPrice(price);
                        iteamDetailsAttachments.setDeliveryDate(delivery_date);
                        iteamDetailsAttachments.setStartDate(start_date);
                        iteamDetailsAttachments.setEndDate(end_date);
                        iteamDetailsAttachments.setFlagStatus(1);
                        iteamDetailsAttachments.setDeliverableMultiId(Integer.parseInt(id1));

                        iteamDetailsAttachmentsService.create(iteamDetailsAttachments);
//			}
                    }
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List list = iteamDetailsAttachmentsService.readByPRItemDesc1(id1);
        int count = list.size();

        // Insert into file details
//        if (count > 0) {
//            request.setAttribute("successMessage", " File Upload successfully");
//        } else {
//
//            request.setAttribute("failureMessage", " File Not Upload ");
//
//        }
// Insert into file details
//	request.setAttribute("successMessage", " File Upload successfully");
        if (count > 0) {
            mv.addObject("message", " File Upload successfully");
            mv.addObject("status", "success");
        } else {
            mv.addObject("message", " File Not Upload");
            mv.addObject("status", "error");
        }

        mv.getModelMap().put("id1", id1);
        mv.getModelMap().put("itemDetailsContract", list);
        mv.setViewName("Oap/AjaxModelOapIteamDatailsAttachmentContract");
        return mv;
    }

    public ModelAndView AgaxOapIteamDatailsAttachments1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id1 = request.getParameter("q");

        List list = iteamDetailsAttachmentsService.readByPRItemDesc1(id1);
        int countt = list.size(); // Assign list size when `co` is not null

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("id1", id1);
        mv.getModelMap().put("countt", countt);

        mv.setViewName("Oap/AgaxOapIteamDatailsContract");
        return mv;
    }

    public ModelAndView deleteDesigncordinatorviewpopup1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id1 = request.getParameter("id1");

        String ids = request.getParameter("Ids");
        String[] checkId = ids.split(",");

        for (int i = 0; i < checkId.length; i++) {
            String check_value = checkId[i];

            iteamDetailsAttachmentsService.delete(Integer.parseInt(check_value));

        }
        mv.setViewName("forward:oapForm.htm?act=Designcordinatorviewpopup1&id1=" + id1);
//	mv.setViewName("Oap/Designcordinatorviewpopup");
        return mv;
    }

    public ModelAndView DesigncordinatorviewSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username = user1.getLoginName();

        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        String delicrtedBy = deliverableMulti.getCreatedBy();

        int id1 = deliverableMulti.getOapId();
        int id2 = deliverableMulti.getAocId();

        int DeliFlag = deliverableMulti.getFlagStatus();

//	int aocid = deliverableMulti.getAocId();
//	int oapid = deliverableMulti.getOapId();
        OapForm oapForm = oapFormService.readByformid(id1);
        String OapAsignperson = oapForm.getAssignedName();
        String Oapcreator = oapForm.getUserId();

        CrcForm crcForm = crcFormService.readByoapId(id1 + "");
        int crcid = crcForm.getId();
        String crcusername = crcForm.getUserid();
        String documentno = oapForm.getDocumentNo();
        AocForm aocForm = aocFormService.readByformid(id2);
        KickOffForm kickOffForm = kickOffFormService.readByaocId(id2 + "");
        int komid = kickOffForm.getId();
        String komusername = kickOffForm.getUserId();
        String documentno1 = aocForm.getDocumentNo();
        String aoccreator = aocForm.getUserId();

        if (id2 == 0 && DeliFlag == 0) {
            String approvalName = request.getParameter("approvalName");
            deliverableMulti.setDesignAssign(approvalName);
            deliverableMulti.setDeliverableCreatedDate(today);
            deliverableMulti.setFlagStatus(4);
            oapForm.setPartiallyApproveFlag(12);
            oapFormService.update(oapForm);
            deliverableMultiService.update(deliverableMulti);
            String userid = deliverableMulti.getDesignAssign();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(44);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Deliverable Design Coordinator OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            //Design Engineer View Created sample file data
            EmployeeMaster employeeMaster6 = employeeMasterService.readUser(username);
            String mail_to6 = employeeMaster6.getEmailId();

            EmailTemplate emailTemplate6 = emailTemplateService.readById(117);
            String mail_from6 = "";

            String subject6 = emailTemplate6.getSubject();
            String msg6 = emailTemplate6.getBodytext();
            String crc_form6 = "Design Engineer View are created";

            msg6 = msg6.replaceAll("\\{Oap_form\\}", crc_form6);
            msg6 = msg6.replaceAll("\\{documentno\\}", documentno);
            msg6 = msg6.replaceAll("\\{username\\}", username);
            msg6 = msg6.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s6 = new SendMail();
            s6.sendMail(mail_from6, mail_to6, subject6, msg6);
// Design Deliverable OAP

            EmployeeMaster employeeMaster10 = employeeMasterService.readUser(delicrtedBy);
            String mail_to10 = employeeMaster10.getEmailId();

            EmailTemplate emailTemplate10 = emailTemplateService.readById(118);
            String mail_from10 = "";

            String subject10 = emailTemplate10.getSubject();
            String msg10 = emailTemplate10.getBodytext();
            String crc_form10 = "Design Engineer View are create";

            msg10 = msg10.replaceAll("\\{Oap_form\\}", crc_form10);
            msg10 = msg10.replaceAll("\\{documentno\\}", documentno);
            msg10 = msg10.replaceAll("\\{username\\}", username);
            msg10 = msg10.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s10 = new SendMail();
            s10.sendMail(mail_from10, mail_to10, subject10, msg10);
//crc approval persons crcid
            CrcFormApprovalUser crcFormApprovalUser1 = new CrcFormApprovalUser();
            List crcapprovalusers = crcFormApprovalUserService.readyByCrcId(crcid);
            for (Object pdf1 : crcapprovalusers) {
                crcFormApprovalUser1 = (CrcFormApprovalUser) pdf1;
                String usernames = crcFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(119);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Design Engineer View are create";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
//crcform Created
            EmployeeMaster employeeMaster0 = employeeMasterService.readUser(crcusername);
            String mail_to0 = employeeMaster0.getEmailId();

            EmailTemplate emailTemplate0 = emailTemplateService.readById(120);
            String mail_from0 = "";

            String subject0 = emailTemplate0.getSubject();
            String msg0 = emailTemplate0.getBodytext();
            String crc_form0 = "Design Engineer View are created";

            msg0 = msg0.replaceAll("\\{Oap_form\\}", crc_form0);
            msg0 = msg0.replaceAll("\\{documentno\\}", documentno);
            msg0 = msg0.replaceAll("\\{username\\}", username);
            msg0 = msg0.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s0 = new SendMail();
            s0.sendMail(mail_from0, mail_to0, subject0, msg0);
//EH Assiged
            EmployeeMaster employeeMaster3 = employeeMasterService.readUser(OapAsignperson);
            String mail_to3 = employeeMaster3.getEmailId();

            EmailTemplate emailTemplate3 = emailTemplateService.readById(121);
            String mail_from3 = "";

            String subject3 = emailTemplate3.getSubject();
            String msg3 = emailTemplate3.getBodytext();
            String crc_form3 = "Design Engineer View are created";

            msg3 = msg3.replaceAll("\\{Oap_form\\}", crc_form3);
            msg3 = msg3.replaceAll("\\{documentno\\}", documentno);
            msg3 = msg3.replaceAll("\\{username\\}", username);
            msg3 = msg3.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s3 = new SendMail();
            s3.sendMail(mail_from3, mail_to3, subject3, msg3);

            // oap Approval persons
            OapFormApprovalUser oapFormApprovalUser1 = new OapFormApprovalUser();

//        int id8 = Integer.parseInt(id);
            List userid1 = oapFormApprovalUserService.readByoapid(id1);
            for (Object pdf1 : userid1) {
                oapFormApprovalUser1 = (OapFormApprovalUser) pdf1;
                String usernames = oapFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(122);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Design Engineer View are created";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            // oapform creater
            EmployeeMaster employeeMaster11 = employeeMasterService.readUser(Oapcreator);
            String mail_to11 = employeeMaster11.getEmailId();

            EmailTemplate emailTemplate11 = emailTemplateService.readById(123);
            String mail_from11 = "";

            String subject11 = emailTemplate11.getSubject();
            String msg11 = emailTemplate11.getBodytext();
            String crc_form11 = "Design Engineer View are created";

            msg11 = msg11.replaceAll("\\{Oap_form\\}", crc_form11);
            msg11 = msg11.replaceAll("\\{documentno\\}", documentno);
            msg11 = msg11.replaceAll("\\{username\\}", username);
            msg11 = msg11.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s11 = new SendMail();
            s11.sendMail(mail_from11, mail_to11, subject11, msg11);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("OAP Design CoOrdinator Create");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Design CoOrdinator Created");
            oapLogMaster.setComments("");
            oapLogMaster.setOapId(id1);
            oapLogMasterService.create(oapLogMaster);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            // multi attachment
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP"
                    + File.separator + id1;
            File f1 = new File(path);
            boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

            List<MultipartFile> files1 = multipartRequest.getFiles("attach");
            String[] description = request.getParameterValues("descriptions");
            int a = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "OAP"
                                + File.separator + id1 + File.separator;

                        File directory = new File(fileLocationURL);
                        if (!directory.exists()) {
                            directory.mkdirs(); // Create the directory if it doesn't exist
                        }

                        File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        try {
                            file1.transferTo(destinationFile1); // Ensure proper exception handling
                        } catch (Exception e) {
                            e.printStackTrace(); // Handle the error or log it
                        }
//
//			OapMultiAttachment oapMultiAttachment = new OapMultiAttachment();
//
//			oapMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", ""));
////			oapMultiAttachment.setDescription(description[a]);
////			oapMultiAttachment.setOapForm(oapForm1);
//
//			oapMultiAttachmentService.create(oapMultiAttachment);
                        DesignCoordinatorMultiAttach designCoordinatorMultiAttach = new DesignCoordinatorMultiAttach();
                        designCoordinatorMultiAttach.setAttachement(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        designCoordinatorMultiAttach.setDescription(description[a]);
                        designCoordinatorMultiAttach.setDeliverableMultiId((Integer.parseInt(id)));
                        designCoordinatorMultiAttach.setOapId(id1);
                        designCoordinatorMultiAttach.setAocId(id2);
                        designCoordinatorMultiAttachService.create(designCoordinatorMultiAttach);

                        a++;
                    }
                }

            }
            mv.getModelMap().put("id", id);

            session1.setAttribute("successMessage", " OAP Form Design Engineer Created successfully");
            mv.setViewName("redirect:oapForm.htm?act=Designcordinator");
        } else if (id2 == 0 && DeliFlag == 0) {
            session1.setAttribute("failureMessage", " OapForm Design Engineer Already Created Successfully");

        }

//        ========================================================
//        AOC Delieverbale
//        ========================================================
        if (id1 == 0 && DeliFlag == 0) {
            String approvalName = request.getParameter("approvalName");
            deliverableMulti.setDesignAssign(approvalName);
            deliverableMulti.setDeliverableCreatedDate(today);
            deliverableMulti.setFlagStatus(4);
            aocForm.setFlagStatus(12);
            aocFormService.update(aocForm);
            deliverableMultiService.update(deliverableMulti);

            String userid = deliverableMulti.getDesignAssign();
            EmployeeMaster employeeMaster = employeeMasterService.readUser(userid);
            String mail_to1 = employeeMaster.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(65);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Deliverable Design Coordinator AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to1, subject, msg);

            //Design Engineer View Created sample file data
            EmployeeMaster employeeMaster6 = employeeMasterService.readUser(username);
            String mail_to6 = employeeMaster6.getEmailId();

            EmailTemplate emailTemplate6 = emailTemplateService.readById(169);
            String mail_from6 = "";

            String subject6 = emailTemplate6.getSubject();
            String msg6 = emailTemplate6.getBodytext();
            String crc_form6 = "AOC Design Engineer View are created";

            msg6 = msg6.replaceAll("\\{Oap_form\\}", crc_form6);
            msg6 = msg6.replaceAll("\\{documentno\\}", documentno1);
            msg6 = msg6.replaceAll("\\{username\\}", username);
            msg6 = msg6.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s6 = new SendMail();
            s6.sendMail(mail_from6, mail_to6, subject6, msg6);
// Design Deliverable Aoc

            EmployeeMaster employeeMaster10 = employeeMasterService.readUser(delicrtedBy);
            String mail_to10 = employeeMaster10.getEmailId();

            EmailTemplate emailTemplate10 = emailTemplateService.readById(170);
            String mail_from10 = "";

            String subject10 = emailTemplate10.getSubject();
            String msg10 = emailTemplate10.getBodytext();
            String crc_form10 = "AOC Design Engineer View are create";

            msg10 = msg10.replaceAll("\\{Oap_form\\}", crc_form10);
            msg10 = msg10.replaceAll("\\{documentno\\}", documentno1);
            msg10 = msg10.replaceAll("\\{username\\}", username);
            msg10 = msg10.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s10 = new SendMail();
            s10.sendMail(mail_from10, mail_to10, subject10, msg10);
//kom approval persons 
            KickOffFormApprovalUser kickOffFormApprovalUser = new KickOffFormApprovalUser();
            List komapprovalusers = kickOffFormApprovalUserService.readBykomid(komid);
            for (Object pdf1 : komapprovalusers) {
                kickOffFormApprovalUser = (KickOffFormApprovalUser) pdf1;
                String usernames = kickOffFormApprovalUser.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(171);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "AOC Design Engineer View are create";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno1);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
// KOM Created
            EmployeeMaster employeeMaster0 = employeeMasterService.readUser(komusername);
            String mail_to0 = employeeMaster0.getEmailId();

            EmailTemplate emailTemplate0 = emailTemplateService.readById(172);
            String mail_from0 = "";

            String subject0 = emailTemplate0.getSubject();
            String msg0 = emailTemplate0.getBodytext();
            String crc_form0 = "AOC Design Engineer View are create";

            msg0 = msg0.replaceAll("\\{Oap_form\\}", crc_form0);
            msg0 = msg0.replaceAll("\\{documentno\\}", documentno1);
            msg0 = msg0.replaceAll("\\{username\\}", username);
            msg0 = msg0.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s0 = new SendMail();
            s0.sendMail(mail_from0, mail_to0, subject0, msg0);

            // AOC Approval persons
            AocFormApprovalUser aocFormApprovalUser1 = new AocFormApprovalUser();
            List userid1 = aocFormApprovalUserService.readByaocId(id2);
            for (Object pdf1 : userid1) {
                aocFormApprovalUser1 = (AocFormApprovalUser) pdf1;
                String usernames = aocFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(173);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "AOC Design Engineer View are create";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno1);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            // Aocform creater
            EmployeeMaster employeeMaster11 = employeeMasterService.readUser(aoccreator);
            String mail_to11 = employeeMaster11.getEmailId();

            EmailTemplate emailTemplate11 = emailTemplateService.readById(174);
            String mail_from11 = "";

            String subject11 = emailTemplate11.getSubject();
            String msg11 = emailTemplate11.getBodytext();
            String crc_form11 = "AOC Design Engineer View are create";

            msg11 = msg11.replaceAll("\\{Oap_form\\}", crc_form11);
            msg11 = msg11.replaceAll("\\{documentno\\}", documentno1);
            msg11 = msg11.replaceAll("\\{username\\}", username);
            msg11 = msg11.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s11 = new SendMail();
            s11.sendMail(mail_from11, mail_to11, subject11, msg11);

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Design CoOrdinator Create");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments("");
            aocLogMaster.setStatus("AOC Design CoOrdinator Created");
            aocLogMaster.setAocId(id2);
            aocLogMasterService.create(aocLogMaster);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc"
                    + File.separator + id2;
            File f1 = new File(path);
            boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

            List<MultipartFile> files1 = multipartRequest.getFiles("attach");
            String[] description = request.getParameterValues("descriptions");
            int a = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "Aoc"
                                + File.separator + id2 + File.separator;

                        File directory = new File(fileLocationURL);
                        if (!directory.exists()) {
                            directory.mkdirs(); // Create the directory if it doesn't exist
                        }

                        File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        try {
                            file1.transferTo(destinationFile1); // Ensure proper exception handling
                        } catch (Exception e) {
                            e.printStackTrace(); // Handle the error or log it
                        }

                        DesignCoordinatorMultiAttach designCoordinatorMultiAttach = new DesignCoordinatorMultiAttach();
                        designCoordinatorMultiAttach.setAttachement(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        designCoordinatorMultiAttach.setDescription(description[a]);
                        designCoordinatorMultiAttach.setDeliverableMultiId((Integer.parseInt(id)));
                        designCoordinatorMultiAttach.setOapId(id1);
                        designCoordinatorMultiAttach.setAocId(id2);
                        designCoordinatorMultiAttachService.create(designCoordinatorMultiAttach);

                        a++;
                    }
                }

            }
            mv.getModelMap().put("id", id);
            session1.setAttribute("successMessage", " AOCForm Design Engineer Created successfully");
        } else if (id1 == 0 && DeliFlag == 0) {
            session1.setAttribute("failureMessage", "Design Engineer Already Created Successfully");
        }
        mv.setViewName("redirect:oapForm.htm?act=Designcordinator");

        return mv;
    }

    public ModelAndView DesigncoordinatorApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

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

        mv.setViewName("Oap/DesigncoordinatorApproval");
        return mv;
    }

    public ModelAndView DesigncoordinatorApprovalView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String oapid = request.getParameter("id1");
        String aocid = request.getParameter("id2");

        int flag = 0; // Default to 0

        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        int deliverableId = deliverableMulti.getDeliverableId(); // Fixed variable name
        int oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();
        if (aocformid == 0) {
            aocformid = -1;
        }
        if (oapformid == 0) {
            oapformid = -1;
        }
        List list50 = designCoordinatorMultiAttachService.readBydelmultiid(oapformid);
        List list40 = designCoordinatorMultiAttachService.readBydelmultiid1(aocformid);
        CrcForm crcForm = crcFormService.readByoapIds(oapformid);
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(oapformid + "");
        KickOffForm kickOffForm = kickOffFormService.readByaocIds(aocformid);

        List aocSurveyAttch = aocSurveyAttachmentService.readByaocId(aocformid + "");

        mv.getModelMap().put("aocSurveyAttch", aocSurveyAttch);
        mv.getModelMap().put("crcForm", crcForm);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("kickOffForm", kickOffForm);
        AocForm aocForm = aocFormService.readById(Integer.parseInt(aocid));
        OapForm oapForm = oapFormService.readById(Integer.parseInt(oapid));
        List list = iteamDetailsAttachmentsService.readBydeliverymultid(id);

        List<IteamDetailsAttachments> list2 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc1(id);// 1 Contract

        for (IteamDetailsAttachments ab : list2) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 1) {
                flag = 1;
                List Contract1 = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Contract1", Contract1);

                break; // Exit loop as soon as we find a 1
            }
        }
        List<IteamDetailsAttachments> list1 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc2(id);//4 GoodsContract

        for (IteamDetailsAttachments ab : list1) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 4) {
                flag = 4;
                List GoodsContract4 = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("GoodsContract4", GoodsContract4);

                break; // Exit loop as soon as we find a 1
            }
        }
        List<IteamDetailsAttachments> list3 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readBydeleteAll(id); //0 goods

        for (IteamDetailsAttachments ab : list3) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 0) {
                flag = 0;
                List Goods = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Goods", Goods);
                break; // Exit loop as soon as we find a 1
            }
        }

        List<IteamDetailsAttachments> list4 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readBydeleteAll1(id); //3 Service

        for (IteamDetailsAttachments ab : list4) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 3) {
                flag = 3;
                List Service = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Service", Service);
                break; // Exit loop as soon as we find a 1
            }
        }
        mv.getModelMap().put("list40", list40);
        mv.getModelMap().put("list50", list50);

        mv.getModelMap().put("oapformid", oapformid);
        mv.getModelMap().put("aocformid", aocformid);

        mv.getModelMap().put("aocForm", aocForm);
        mv.getModelMap().put("oapForm", oapForm);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("flag", flag);
        mv.getModelMap().put("list3", list3);
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("oapid", oapid);
        mv.getModelMap().put("aocid", aocid);
        mv.setViewName("Oap/DesigncoordinatorApprovalView");
        return mv;
    }

    public ModelAndView DesigncoordinatorApprovalViewsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String id = request.getParameter("id");
        String oapid = request.getParameter("id1");

        String aocid = request.getParameter("id2");
        String comment = request.getParameter("comment");

        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        int DeliFlag = deliverableMulti.getFlagStatus();

        if (oapid.equals("0") && DeliFlag == 4) {

            deliverableMulti.setDeliverableApprovedBy(username);
            deliverableMulti.setDeliverableApprovedDate(today);
            deliverableMulti.setFlagStatus(1);
            deliverableMultiService.update(deliverableMulti);

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(Integer.parseInt(aocid));
            designCordinatorComments.setOapId(0);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(1);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("Design CoOrdinator Approval");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("Design CoOrdinator Approved");
            aocLogMaster.setAocId(Integer.parseInt(aocid));
            aocLogMasterService.create(aocLogMaster);

            AocForm aocForm = aocFormService.readById(Integer.parseInt(aocid));
            KickOffForm kickOffForm = kickOffFormService.readByaocId(aocid);
            int komid = kickOffForm.getId();
            String komusername = kickOffForm.getUserId();
            String documentno1 = aocForm.getDocumentNo();
            String aoccreator = aocForm.getUserId();
            String userid = designCordinatorComments.getUserId();

            String Designcordinator = deliverableMulti.getDesignCoordinator();
            String delicrtedBy = deliverableMulti.getCreatedBy();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(67);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Deliverable AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            //Design Engieer View page submit sample file
            EmployeeMaster employeeMaster0 = employeeMasterService.readUser(Designcordinator);
            String mail_to0 = employeeMaster0.getEmailId();

            EmailTemplate emailTemplate0 = emailTemplateService.readById(175);
            String mail_from0 = "";

            String subject0 = emailTemplate0.getSubject();
            String msg0 = emailTemplate0.getBodytext();
            String crc_form0 = " AOC Design Co-ordinator Approved";

            msg0 = msg0.replaceAll("\\{Oap_form\\}", crc_form0);
            msg0 = msg0.replaceAll("\\{documentno\\}", documentno1);
            msg0 = msg0.replaceAll("\\{username\\}", username);
            msg0 = msg0.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s0 = new SendMail();
            s0.sendMail(mail_from0, mail_to0, subject0, msg0);

            // Design Deliverable AOC
            EmployeeMaster employeeMaster10 = employeeMasterService.readUser(delicrtedBy);
            String mail_to10 = employeeMaster10.getEmailId();

            EmailTemplate emailTemplate10 = emailTemplateService.readById(176);
            String mail_from10 = "";

            String subject10 = emailTemplate10.getSubject();
            String msg10 = emailTemplate10.getBodytext();
            String crc_form10 = " AOC Design Co-ordinator Approved";

            msg10 = msg10.replaceAll("\\{Oap_form\\}", crc_form10);
            msg10 = msg10.replaceAll("\\{documentno\\}", documentno1);
            msg10 = msg10.replaceAll("\\{username\\}", username);
            msg10 = msg10.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s10 = new SendMail();
            s10.sendMail(mail_from10, mail_to10, subject10, msg10);

            //KOM Approavals persons
            KickOffFormApprovalUser kickOffFormApprovalUser = new KickOffFormApprovalUser();
            List komapprovalusers = kickOffFormApprovalUserService.readBykomid(komid);
            for (Object pdf1 : komapprovalusers) {
                kickOffFormApprovalUser = (KickOffFormApprovalUser) pdf1;
                String usernames = kickOffFormApprovalUser.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(177);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "AOC Design Co-ordinator Approved ";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno1);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            //komform Created
            EmployeeMaster employeeMaster3 = employeeMasterService.readUser(komusername);
            String mail_to3 = employeeMaster3.getEmailId();

            EmailTemplate emailTemplate3 = emailTemplateService.readById(178);
            String mail_from3 = "";

            String subject3 = emailTemplate3.getSubject();
            String msg3 = emailTemplate3.getBodytext();
            String crc_form3 = "AOC Design Co-ordinator Approved";

            msg3 = msg3.replaceAll("\\{Oap_form\\}", crc_form3);
            msg3 = msg3.replaceAll("\\{documentno\\}", documentno1);
            msg3 = msg3.replaceAll("\\{username\\}", username);
            msg3 = msg3.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s3 = new SendMail();
            s3.sendMail(mail_from3, mail_to3, subject3, msg3);

            //AOC Approval Persons
            AocFormApprovalUser aocFormApprovalUser1 = new AocFormApprovalUser();
            int aocid1 = Integer.parseInt(aocid);
            List userid2 = aocFormApprovalUserService.readByaocId(aocid1);
            for (Object pdf1 : userid2) {
                aocFormApprovalUser1 = (AocFormApprovalUser) pdf1;
                String usernames = aocFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(179);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "AOC Design Co-ordinator Approved";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno1);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            // aoc form creater
            EmployeeMaster employeeMaster18 = employeeMasterService.readUser(aoccreator);
            String mail_to18 = employeeMaster18.getEmailId();

            EmailTemplate emailTemplate18 = emailTemplateService.readById(180);
            String mail_from18 = "";

            String subject18 = emailTemplate18.getSubject();
            String msg18 = emailTemplate18.getBodytext();
            String crc_form18 = "AOC Design Co-ordinator Approved";

            msg18 = msg18.replaceAll("\\{Oap_form\\}", crc_form18);
            msg18 = msg18.replaceAll("\\{documentno\\}", documentno1);
            msg18 = msg18.replaceAll("\\{username\\}", username);
            msg18 = msg18.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s18 = new SendMail();
            s18.sendMail(mail_from18, mail_to18, subject18, msg18);

            session.setAttribute("successMessage", "Design Co-ordinator  Approved Successfully");

        }
// =============================================================        
//        OAP Process
// =============================================================        

        if (aocid.equals("0") && DeliFlag == 4) {
            deliverableMulti.setDeliverableApprovedBy(username);
            deliverableMulti.setDeliverableApprovedDate(today);
            deliverableMulti.setFlagStatus(1);
            deliverableMultiService.update(deliverableMulti);

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(0);
            designCordinatorComments.setOapId(Integer.parseInt(oapid));
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(1);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("Design CoOrdinator Approval");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Design CoOrdinator Approved");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(Integer.parseInt(oapid));
            oapLogMasterService.create(oapLogMaster);

            OapForm oapForm = oapFormService.readById(Integer.parseInt(oapid));
            String OapAsignperson = oapForm.getAssignedName();
            String Oapcreator = oapForm.getUserId();
            CrcForm crcForm = crcFormService.readByoapId(oapid);
            int crcid = crcForm.getId();
            String crcusername = crcForm.getUserid();
            String documentno = oapForm.getDocumentNo();
            String userid = designCordinatorComments.getUserId();
            String Designcordinator = deliverableMulti.getDesignCoordinator();
            String delicrtedBy = deliverableMulti.getCreatedBy();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(48);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Deliverable OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            //Design Engieer View page submit
            EmployeeMaster employeeMaster0 = employeeMasterService.readUser(Designcordinator);
            String mail_to0 = employeeMaster0.getEmailId();

            EmailTemplate emailTemplate0 = emailTemplateService.readById(124);
            String mail_from0 = "";

            String subject0 = emailTemplate0.getSubject();
            String msg0 = emailTemplate0.getBodytext();
            String crc_form0 = "Design Co-ordinator Approved";

            msg0 = msg0.replaceAll("\\{Oap_form\\}", crc_form0);
            msg0 = msg0.replaceAll("\\{documentno\\}", documentno);
            msg0 = msg0.replaceAll("\\{username\\}", username);
            msg0 = msg0.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s0 = new SendMail();
            s0.sendMail(mail_from0, mail_to0, subject0, msg0);

            // Design Deliverable OAP
            EmployeeMaster employeeMaster10 = employeeMasterService.readUser(delicrtedBy);
            String mail_to10 = employeeMaster10.getEmailId();

            EmailTemplate emailTemplate10 = emailTemplateService.readById(125);
            String mail_from10 = "";

            String subject10 = emailTemplate10.getSubject();
            String msg10 = emailTemplate10.getBodytext();
            String crc_form10 = "Design Co-ordinator Approved";

            msg10 = msg10.replaceAll("\\{Oap_form\\}", crc_form10);
            msg10 = msg10.replaceAll("\\{documentno\\}", documentno);
            msg10 = msg10.replaceAll("\\{username\\}", username);
            msg10 = msg10.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s10 = new SendMail();
            s10.sendMail(mail_from10, mail_to10, subject10, msg10);

            //crc approval persons crcid
            CrcFormApprovalUser crcFormApprovalUser1 = new CrcFormApprovalUser();
            List crcapprovalusers = crcFormApprovalUserService.readyByCrcId(crcid);
            for (Object pdf1 : crcapprovalusers) {
                crcFormApprovalUser1 = (CrcFormApprovalUser) pdf1;
                String usernames = crcFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(126);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Design Co-ordinator Approved";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            //crcform Created
            EmployeeMaster employeeMaster3 = employeeMasterService.readUser(crcusername);
            String mail_to3 = employeeMaster3.getEmailId();

            EmailTemplate emailTemplate3 = emailTemplateService.readById(127);
            String mail_from3 = "";

            String subject3 = emailTemplate3.getSubject();
            String msg3 = emailTemplate3.getBodytext();
            String crc_form3 = "Design Co-ordinator Approved";

            msg3 = msg3.replaceAll("\\{Oap_form\\}", crc_form3);
            msg3 = msg3.replaceAll("\\{documentno\\}", documentno);
            msg3 = msg3.replaceAll("\\{username\\}", username);
            msg3 = msg3.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s3 = new SendMail();
            s3.sendMail(mail_from3, mail_to3, subject3, msg3);
            //EH Assiged
            EmployeeMaster employeeMaster11 = employeeMasterService.readUser(OapAsignperson);
            String mail_to11 = employeeMaster11.getEmailId();

            EmailTemplate emailTemplate11 = emailTemplateService.readById(128);
            String mail_from11 = "";

            String subject11 = emailTemplate11.getSubject();
            String msg11 = emailTemplate11.getBodytext();
            String crc_form11 = "Design Co-ordinator Approved";

            msg11 = msg11.replaceAll("\\{Oap_form\\}", crc_form11);
            msg11 = msg11.replaceAll("\\{documentno\\}", documentno);
            msg11 = msg11.replaceAll("\\{username\\}", username);
            msg11 = msg11.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s11 = new SendMail();
            s11.sendMail(mail_from11, mail_to11, subject11, msg11);

            // oap Approval persons
            OapFormApprovalUser oapFormApprovalUser1 = new OapFormApprovalUser();

            int id8 = Integer.parseInt(oapid);
            List userid1 = oapFormApprovalUserService.readByoapid(id8);
            for (Object pdf1 : userid1) {
                oapFormApprovalUser1 = (OapFormApprovalUser) pdf1;
                String usernames = oapFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(129);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Design Co-ordinator Approved";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            // oapform creater
            EmployeeMaster employeeMaster18 = employeeMasterService.readUser(Oapcreator);
            String mail_to18 = employeeMaster18.getEmailId();

            EmailTemplate emailTemplate18 = emailTemplateService.readById(130);
            String mail_from18 = "";

            String subject18 = emailTemplate18.getSubject();
            String msg18 = emailTemplate18.getBodytext();
            String crc_form18 = "Design Co-ordinator Approved";

            msg18 = msg18.replaceAll("\\{Oap_form\\}", crc_form18);
            msg18 = msg18.replaceAll("\\{documentno\\}", documentno);
            msg18 = msg18.replaceAll("\\{username\\}", username);
            msg18 = msg18.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s18 = new SendMail();
            s18.sendMail(mail_from18, mail_to18, subject18, msg18);

            session.setAttribute("successMessage", "Design Co-ordinator  Approved Successfully");

        }

        int a = 0;
        if (oapid.equals("0")) {
            List list67 = deliverableMultiService.readByAocId(aocid);
            for (Object o : list67) {
                DeliverableMulti deliverableMulti1 = (DeliverableMulti) o;
                int status = deliverableMulti1.getFlagStatus();
                if (status == 1 || status == 2) {
                    a = 1;
                } else {
                    a = 0;
                }
            }
            if (a == 1) {
                KickOffForm kickOffForm = kickOffFormService.readByaocId(aocid);
                kickOffForm.setFlagStatus(4);
                kickOffFormService.update(kickOffForm);

            }

        }

        if (aocid.equals("0")) {
            List list66 = deliverableMultiService.readByOapid(oapid);
            for (Object o : list66) {
                DeliverableMulti deliverableMulti1 = (DeliverableMulti) o;
                int status = deliverableMulti1.getFlagStatus();
                if (status == 1 || status == 2) {
                    a = 1;
                } else {
                    a = 0;
                }
            }
            if (a == 1) {
                CrcForm crcForm = crcFormService.readByoapId(oapid);
                crcFormService.update(crcForm);

            }

        }

        if (DeliFlag == 1) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Approved Successfully");

        } else if (DeliFlag == 2) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Reworked Successfully");

        } else if (DeliFlag == 3) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Rejected Successfully");

        }

        mv.setViewName("redirect:oapForm.htm?act=DesigncoordinatorApproval");

        return mv;
    }

    public ModelAndView DesigncoordinatorReworkViewsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));

        int Oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();
        int DeliFlag = deliverableMulti.getFlagStatus();

        if (Oapformid == 0 && DeliFlag == 4) {

            deliverableMulti.setFlagStatus(2);
            deliverableMultiService.update(deliverableMulti);

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(aocformid);
            designCordinatorComments.setOapId(0);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(2);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Design CoOrdinator ReCycle");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("AOC Design CoOrdinator ReCycled");
            aocLogMaster.setAocId(aocformid);
            aocLogMasterService.create(aocLogMaster);

            String userid = designCordinatorComments.getUserId();
            AocForm aocForm = aocFormService.readById(aocformid);
            String documentno1 = aocForm.getDocumentNo();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(68);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "DesignCordinator AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", "Design Co-ordinator  Reworked Successfully");

        }
// =============================================================        
//        OAP Process
// =============================================================        

        if (aocformid == 0 && DeliFlag == 4) {

            deliverableMulti.setFlagStatus(2);
            deliverableMultiService.update(deliverableMulti);

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(0);
            designCordinatorComments.setOapId(Oapformid);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(2);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("OAP Design CoOrdinator ReCycle");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("OAP Design CoOrdinator ReCycled");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(Oapformid);
            oapLogMasterService.create(oapLogMaster);

            String userid = designCordinatorComments.getUserId();
            OapForm oapForm = oapFormService.readById(Oapformid);
            String documentno = oapForm.getDocumentNo();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(46);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "DesignCordinator OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", "Design Co-ordinator  Reworked Successfully");

        }

        if (DeliFlag == 1) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Approved Manager Successfully");

        } else if (DeliFlag == 2) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Reworked Manager Successfully");

        } else if (DeliFlag == 3) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Rejected Manager Successfully");

        }

        mv.setViewName("redirect:oapForm.htm?act=DesigncoordinatorApproval");

        return mv;
    }

    public ModelAndView DesigncoordReworkProjectMangsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));

        int Oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();
        int DeliFlag = deliverableMulti.getFlagStatus();

        if (Oapformid == 0 && DeliFlag == 1) {

            deliverableMulti.setFlagStatus(2);
            deliverableMultiService.update(deliverableMulti);

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(aocformid);
            designCordinatorComments.setOapId(0);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(2);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Design CoOrdinator ReCycle");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("AOC Design CoOrdinator ReCycled");
            aocLogMaster.setAocId(aocformid);
            aocLogMasterService.create(aocLogMaster);

            String userid = designCordinatorComments.getUserId();
            AocForm aocForm = aocFormService.readById(aocformid);
            String documentno1 = aocForm.getDocumentNo();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(68);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "DesignCordinator AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", "Design Co-ordinator  Reworked Successfully");
        }
// =============================================================        
//        OAP Process
// =============================================================        

        if (aocformid == 0 && DeliFlag == 1) {

            deliverableMulti.setFlagStatus(2);
            deliverableMultiService.update(deliverableMulti);

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(0);
            designCordinatorComments.setOapId(Oapformid);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(2);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("OAP Design CoOrdinator ReCycle");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("OAP Design CoOrdinator ReCycled");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(Oapformid);
            oapLogMasterService.create(oapLogMaster);

            String userid = designCordinatorComments.getUserId();
            OapForm oapForm = oapFormService.readById(Oapformid);
            String documentno = oapForm.getDocumentNo();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(46);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "DesignCordinator OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", "Design Co-ordinator  Reworked Successfully");

        }

        if (DeliFlag == 5) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Approved Manager Successfully");

        } else if (DeliFlag == 2) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Reworked Manager Successfully");

        } else if (DeliFlag == 3) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Rejected Manager Successfully");

        }

        mv.setViewName("redirect:oapForm.htm?act=oapprojectmanagerApprovemulti");

        return mv;
    }

    public ModelAndView DesigncoordinatorRejectViewsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
        String delivableid = request.getParameter("id7");
        String comment = request.getParameter("comment");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        int Oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();

        int DeliFlag = deliverableMulti.getFlagStatus();

        if (Oapformid == 0 && DeliFlag == 4) {

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(aocformid);
            designCordinatorComments.setOapId(0);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(3);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Design CoOrdinator Reject");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("AOC Design CoOrdinator Rejected");
            aocLogMaster.setAocId(aocformid);
            aocLogMasterService.create(aocLogMaster);

            AocForm aocForm = aocFormService.readById(aocformid);
            String documentno1 = aocForm.getDocumentNo();

            String userid = designCordinatorComments.getUserId();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(69);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Design Co-ordinator AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", "Design Co-ordinator  Rejected Successfully");

        }

        if (aocformid == 0 && DeliFlag == 4) {
            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(0);
            designCordinatorComments.setOapId(Oapformid);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(3);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("OAP Design CoOrdinator Reject");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("OAP Design CoOrdinator Rejected");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(Oapformid);
            oapLogMasterService.create(oapLogMaster);

            OapForm oapForm1 = oapFormService.readById(Oapformid);
            String documentno = oapForm1.getDocumentNo();
            String userid = designCordinatorComments.getUserId();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(47);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Design Co-ordinator OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", "Design Co-ordinator  Rejected Successfully");

        }

        if (aocformid == 0 && DeliFlag == 4) {
            deliverableMulti.setFlagStatus(3);
            deliverableMultiService.update(deliverableMulti); // Uncommented to ensure update

            List list = deliverableMultiService.readByoapid(Oapformid);
            boolean flagUpdated = false; // Introduced a boolean for better logic clarity

            for (Object o : list) {
                Object[] objArray = (Object[]) o;  // Cast to Object array
                DeliverableMulti deliverableMulti1 = (DeliverableMulti) objArray[0]; // Extract the first element

                if (deliverableMulti1.getFlagStatus() == 3) {
                    flagUpdated = true;
                    break; // Exit loop early if condition is met
                }
            }

            if (flagUpdated) {
                OapForm oapForm = oapFormService.readByformid(Oapformid);
                oapForm.setFlagStatus(13);
                oapFormService.update(oapForm); // Uncommented to ensure update
            }

        }
        if (Oapformid == 0 && DeliFlag == 4) {
            deliverableMulti.setFlagStatus(3);
            deliverableMultiService.update(deliverableMulti);

            List list1 = deliverableMultiService.readByaocId(aocformid);
            boolean flagUpdated = false;

            for (Object o : list1) {
                DeliverableMulti deliverableMulti1 = (DeliverableMulti) o;
                if (deliverableMulti1.getFlagStatus() == 3) {
                    flagUpdated = true;
                    break; // Exit loop early if condition is met
                }
            }
            if (flagUpdated) {
                AocForm aocForm = aocFormService.readByformid(aocformid);
                aocForm.setFlagStatus(13);
                aocFormService.update(aocForm);
            }

        }
        if (DeliFlag == 5) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Approved Manager Successfully");

        } else if (DeliFlag == 2) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Reworked Manager Successfully");

        } else if (DeliFlag == 3) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Rejected Manager Successfully");

        }
        mv.setViewName("redirect:oapForm.htm?act=DesigncoordinatorApproval");

        return mv;
    }

    public ModelAndView DesigncoordRejectProjectMangsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
        String delivableid = request.getParameter("id7");
        String comment = request.getParameter("comment");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        int Oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();

        int DeliFlag = deliverableMulti.getFlagStatus();

        if (Oapformid == 0 && DeliFlag == 1) {

            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(aocformid);
            designCordinatorComments.setOapId(0);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(3);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Design CoOrdinator Reject");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("AOC Design CoOrdinator Rejected");
            aocLogMaster.setAocId(aocformid);
            aocLogMasterService.create(aocLogMaster);

            AocForm aocForm = aocFormService.readById(aocformid);
            String documentno1 = aocForm.getDocumentNo();

            String userid = designCordinatorComments.getUserId();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(69);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Aoc_form_Deliverable\\}", "Design Co-ordinator AOC Fom");
            msg = msg.replaceAll("\\{Aoc_form\\}", "AOC Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", "Design Co-ordinator  Rejected Successfully");

        }

        if (aocformid == 0 && DeliFlag == 1) {
            DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
            designCordinatorComments.setComments(comment);
            designCordinatorComments.setAocId(0);
            designCordinatorComments.setOapId(Oapformid);
            designCordinatorComments.setDeliverableId(Integer.parseInt(id));
            designCordinatorComments.setUserId(username);
            designCordinatorComments.setFlagStatus(3);
            designCordinatorComments.setDateTime(currentDateTime5);
            designCordinatorCommentsService.create(designCordinatorComments);

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("OAP Design CoOrdinator Reject");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("OAP Design CoOrdinator Rejected");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(Oapformid);
            oapLogMasterService.create(oapLogMaster);

            OapForm oapForm1 = oapFormService.readById(Oapformid);
            String documentno = oapForm1.getDocumentNo();
            String userid = designCordinatorComments.getUserId();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(47);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{Oap_form_Deliverable\\}", "Design Co-ordinator OAP Fom");
            msg = msg.replaceAll("\\{Oap_form\\}", "OAP Form");
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            session.setAttribute("successMessage", "Design Co-ordinator  Rejected Successfully");

        }

        if (aocformid == 0 && DeliFlag == 4) {
            deliverableMulti.setFlagStatus(3);
            deliverableMultiService.update(deliverableMulti); // Uncommented to ensure update

            List list = deliverableMultiService.readByoapid(Oapformid);
            boolean flagUpdated = false; // Introduced a boolean for better logic clarity

            for (Object o : list) {
                Object[] objArray = (Object[]) o;  // Cast to Object array
                DeliverableMulti deliverableMulti1 = (DeliverableMulti) objArray[0]; // Extract the first element

                if (deliverableMulti1.getFlagStatus() == 3) {
                    flagUpdated = true;
                    break; // Exit loop early if condition is met
                }
            }

            if (flagUpdated) {
                OapForm oapForm = oapFormService.readByformid(Oapformid);
                oapForm.setFlagStatus(13);
                oapFormService.update(oapForm); // Uncommented to ensure update
            }

        }
        if (Oapformid == 0) {
            deliverableMulti.setFlagStatus(3);
            deliverableMultiService.update(deliverableMulti);

            List list1 = deliverableMultiService.readByaocId(aocformid);
            boolean flagUpdated = false;

            for (Object o : list1) {
                DeliverableMulti deliverableMulti1 = (DeliverableMulti) o;
                if (deliverableMulti1.getFlagStatus() == 3) {
                    flagUpdated = true;
                    break; // Exit loop early if condition is met
                }
            }
            if (flagUpdated) {
                AocForm aocForm = aocFormService.readByformid(aocformid);
                aocForm.setFlagStatus(13);
                aocFormService.update(aocForm);
            }

        }
        if (DeliFlag == 1) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Approved Manager Successfully");

        } else if (DeliFlag == 2) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Reworked Manager Successfully");

        } else if (DeliFlag == 3) {
            session.setAttribute("failureMessage", "Design Co-ordinator Already Rejected Manager Successfully");

        }
        mv.setViewName("redirect:oapForm.htm?act=oapprojectmanagerApprovemulti");

        return mv;
    }

    public ModelAndView DesigncordinatorPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));
        List list10 = designCordinatorCommentsService.readybydelivid(id);

        int oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();
        if (aocformid == 0) {
            aocformid = -1;
        }
        if (oapformid == 0) {
            oapformid = -1;
        }
        List list50 = designCoordinatorMultiAttachService.readBydelmultiid(oapformid);
        List list40 = designCoordinatorMultiAttachService.readBydelmultiid1(aocformid);

        String designassign = deliverableMulti.getDesignAssign();
        AocForm aocForm = aocFormService.readByformid(aocformid);
        CrcForm crcForm = crcFormService.readByoapIds(oapformid);
        KickOffForm kickOffForm = kickOffFormService.readByaocIds(aocformid);

        OapForm oapForm = oapFormService.readByformid(oapformid);
        int flag = 0; // Default to 0
        List<IteamDetailsAttachments> list5 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc1(id);// 1 Contract

        for (IteamDetailsAttachments ab : list5) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 1) {
                flag = 1;
                List Contract1 = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Contract1", Contract1);

                break; // Exit loop as soon as we find a 1
            }
        }
        List<IteamDetailsAttachments> list7 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readByPRItemDesc2(id);//4 GoodsContract

        for (IteamDetailsAttachments ab : list7) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 4) {
                flag = 4;
                List GoodsContract4 = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("GoodsContract4", GoodsContract4);

                break; // Exit loop as soon as we find a 1
            }
        }
        List<IteamDetailsAttachments> list0 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readBydeleteAll(id); //0 goods

        for (IteamDetailsAttachments ab : list0) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 0) {
                flag = 0;
                List Goods = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Goods", Goods);
                break; // Exit loop as soon as we find a 1
            }
        }

        List<IteamDetailsAttachments> list4 = (List<IteamDetailsAttachments>) iteamDetailsAttachmentsService.readBydeleteAll1(id); //3 Service

        for (IteamDetailsAttachments ab : list4) {
            int flagStatus = ab.getFlagStatus();
            if (flagStatus == 3) {
                flag = 3;
                List Service = iteamDetailsAttachmentsService.readBystatus2(flag, id);
                mv.getModelMap().put("Service", Service);
                break; // Exit loop as soon as we find a 1
            }
        }
        mv.getModelMap().put("list50", list50);
        mv.getModelMap().put("list40", list40);
        mv.getModelMap().put("oapformid", oapformid);
        mv.getModelMap().put("aocformid", aocformid);

        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("kickOffForm", kickOffForm);

        mv.getModelMap().put("list5", list5);
        mv.getModelMap().put("list7", list7);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("crcForm", crcForm);

//	mv.getModelMap().put("flag", flag);
        mv.getModelMap().put("list2", oapForm);
        mv.getModelMap().put("list3", aocForm);

        mv.getModelMap().put("list6", deliverableMulti);
        mv.getModelMap().put("designassign", designassign);

        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/DesigncordinatorPrint");
        return mv;
    }

    public ModelAndView DeliverablePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        Deliverable deliverable = deliverableService.readByoapid(id);
        int deliverableid = deliverable.getId();
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        int oapformid = oapForm.getId();
        CrcForm crcForm = crcFormService.readByoapId(id);
        List list5 = designCoordinatorMultiAttachService.readBydelmultiid(oapformid);

        List list11 = deliverableMultiService.readByDeliveryId(deliverableid);
        List list0 = deliverableMultiService.readByOapid(id);
        mv.getModelMap().put("list5", list5);

        mv.getModelMap().put("list11", list11);
        mv.getModelMap().put("crcForm", crcForm);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("oapForm", oapForm);
        mv.getModelMap().put("list10", deliverable);
        //Aoc Details
//	Deliverable deliverable1 = deliverableService.readByAOcid(id);
//	int deliverableid1 = deliverable1.getId();
//	AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
//	List list12 = deliverableMultiService.readByDeliveryId(deliverableid1);
//	List list1 = deliverableMultiService.readByAocId(id);
//	mv.getModelMap().put("deliverable1", deliverable1);
//	mv.getModelMap().put("deliverableid1", deliverableid1);
//	mv.getModelMap().put("aocForm", aocForm);
//	mv.getModelMap().put("list12", list12);
//	mv.getModelMap().put("list1", list1);

        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/DeliverablePrint");
        return mv;
    }

    public ModelAndView DeliverablePrint1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        Deliverable deliverable1 = deliverableService.readByAOcid(id);
        int deliverableid1 = deliverable1.getId();
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        int aocid = aocForm.getId();
        DesignCoordinatorMultiAttach designCoordinatorMultiAttach = designCoordinatorMultiAttachService.readBydelmultiidsaoc(aocid);
        int delivablemultiid = designCoordinatorMultiAttach.getDeliverableMultiId();
        List list5 = designCoordinatorMultiAttachService.readBydelmultiid1(aocid);

        KickOffForm kickOffForm = kickOffFormService.readByaocId(id);

        List list12 = deliverableMultiService.readByDeliveryId(deliverableid1);
        List list1 = deliverableMultiService.readByAocId(id);
        mv.getModelMap().put("deliverable1", deliverable1);
        mv.getModelMap().put("deliverableid1", deliverableid1);
        mv.getModelMap().put("aocForm", aocForm);
        mv.getModelMap().put("kickOffForm", kickOffForm);
        mv.getModelMap().put("delivablemultiid", delivablemultiid);
        mv.getModelMap().put("list5", list5);
        mv.getModelMap().put("list12", list12);
        mv.getModelMap().put("list1", list1);

        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/DeliverablePrint1");
        return mv;
    }

    public ModelAndView NetworkTeam(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        UserRights userRights = userRightsService.readByUser(username);
//        List list = oapFormService.readbyflagStatus();
//        List list1 = aocFormService.flagStatus();

//	List list = oapFormService.approvalStatus(username);
//	List list1 = aocFormService.approvalStatus1(username);
//        mv.getModelMap().put("list", list);
//        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("userRights", userRights);
        mv.setViewName("Oap/NetworkTeam");
        return mv;
    }

    public ModelAndView FinanceTeam(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
//        List list = oapFormService.readbyflagStatus();
//        List list1 = aocFormService.flagStatus();

//	List list = oapFormService.approvalStatus(username);
//	List list1 = aocFormService.approvalStatus1(username);
//        mv.getModelMap().put("list", list);
        mv.getModelMap().put("userRights", userRights);
//        mv.getModelMap().put("list1", list1);

        mv.setViewName("Oap/FinanceTeam");
        return mv;
    }

    public ModelAndView oapseachReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String username = user.getLoginName();

//        List list5 = oapFormService.readByUser(username);
//
//        mv.getModelMap().put("list5", list5);
        mv.setViewName("Oap/oapseachReport");
        return mv;
    }

    public ModelAndView oapseachListReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String username = user.getLoginName();
//
//        String oapdocumentNumber = request.getParameter("oapdocumentNumber");
//        String projectName = request.getParameter("projectName");
//
//        String open_from_date = request.getParameter("open_from_date");
//        String open_to_date = request.getParameter("open_to_date");
//
//        List list = oapFormService.readsearch(oapdocumentNumber, open_from_date, open_to_date, username, projectName);
//        List list1 = oapFormService.readsearch8(oapdocumentNumber, open_from_date, open_to_date, projectName);
//
//        mv.getModelMap().put("list", list);
//        mv.getModelMap().put("list1", list1);
        mv.setViewName("Oap/oapseachReport");
        return mv;
    }

    public ModelAndView aocseachReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String username = user.getLoginName();
//        List list5 = aocFormService.readByUser(username);
//
//        mv.getModelMap().put("list5", list5);
        mv.setViewName("Oap/aocseachReport");
        return mv;
    }

    public ModelAndView aocseachListReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String username = user.getLoginName();
//        String aocdocumentNumber = request.getParameter("aocdocumentNumber");
//        String projectName = request.getParameter("projectName");
//
//        String open_from_date = request.getParameter("open_from_date").replace("-", "/");
//        String open_to_date = request.getParameter("open_to_date").replace("-", "/");
//
//        List list1 = aocFormService.readsearch(aocdocumentNumber, open_from_date, open_to_date, username, projectName);
//        List list2 = aocFormService.readsearch8(aocdocumentNumber, open_from_date, open_to_date, projectName);
//
//        mv.getModelMap().put("list1", list1);
//        mv.getModelMap().put("list2", list2);
        mv.setViewName("Oap/aocseachReport");
        return mv;
    }
//  Based on rights

    public ModelAndView oapRightsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("Oap/oapRightsReport");
        return mv;
    }

    public ModelAndView oapReportList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

//        String oapdocumentNumber = request.getParameter("oapdocumentNumber");
//        String projectName = request.getParameter("projectName");
        String open_from_date = request.getParameter("open_from_date");
        String open_to_date = request.getParameter("open_to_date");
//
//        List list = oapFormService.readoapReportList(oapdocumentNumber, open_from_date, open_to_date, projectName); //both
//
//        List list1 = oapFormService.readoapReportList8(oapdocumentNumber, open_from_date, open_to_date, projectName);//oap
//
//        mv.getModelMap().put("list1", list1);
//        mv.getModelMap().put("list", list);
        mv.getModelMap().put("open_from_date", open_from_date);
//        mv.getModelMap().put("oapdocumentNumber", oapdocumentNumber);
        mv.getModelMap().put("open_to_date", open_to_date);
        mv.setViewName("Oap/oapRightsReport");
        return mv;
    }

    public ModelAndView oapReportexcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String oapdocumentNumber = request.getParameter("document");

        String open_from_date = request.getParameter("fromdate");
        String open_to_date = request.getParameter("todate");

        List list = oapFormService.readByoapexcelReport(oapdocumentNumber, open_from_date, open_to_date); //both

        List list1 = oapFormService.readByoapexcelReport1(oapdocumentNumber, open_from_date, open_to_date);//oap

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

        Row itemHeaderRow = sheet.createRow(rownum++);
        itemHeaderRow.setHeightInPoints(40);
        String[] itemHeaders = {"Document No", "Pcs Name", "Project Name", "OAP Release (From Date)", "OAP Release (To Date)", "Time Period (Days)", "No Of Charger", "No of Charge Charge Points", "Overall station capacity(kW)",
            "Department", "Date", "OAP Status", "CRC Status"};

        for (int i = 0; i < itemHeaders.length; i++) {
            sheet.setColumnWidth(i, 11000);
            Cell cell = itemHeaderRow.createCell(i);
            cell.setCellValue(itemHeaders[i]);
            cell.setCellStyle(styleBold);
        }

        for (Object o : list1) {

            OapForm oap = (OapForm) o;

            Row itemRow = sheet.createRow(rownum++);

            itemRow.createCell(0).setCellValue(oap.getDocumentNo());
            itemRow.createCell(1).setCellValue(oap.getProjectName());
            itemRow.createCell(2).setCellValue(oap.getPcsName());

            itemRow.createCell(3).setCellValue(oap.getTimeLineFromDate());
            itemRow.createCell(4).setCellValue(oap.getTimeLineToDate());
            itemRow.createCell(5).setCellValue(oap.getChargingRatePerUnit());
            itemRow.createCell(6).setCellValue(oap.getNoOfCharger());
            itemRow.createCell(7).setCellValue(oap.getNoOfChargePoints());
            itemRow.createCell(8).setCellValue(oap.getOverallStationCapacityKw());
            itemRow.createCell(9).setCellValue(oap.getDepartment());
            itemRow.createCell(10).setCellValue(oap.getCreatedDate());
//            itemRow.createCell(11).setCellValue(oap.getFlagStatus());
            Integer flag = (Integer) (oap.getFlagStatus());
            String status;

            switch (flag) {
                case 1:
                    status = "Pending to Approve";
                    break;
                case 2:
                    status = "Recycle";
                    break;
                case 3:
                    status = "Rejected";
                    break;
                case 4:
                    status = "Approved";
                    break;
                case 5:
                    status = "Rejected CRC";
                    break;
                case 6:
                    status = "Approved";
                    break;
                case 7:
                    status = "Approved";
                    break;
                case 8:
                    status = "Project Manager cancel";
                    break;
                case 9:
                    status = "Project Manager Rejected";
                    break;
                case 10:
                    status = "Project Manager Close";
                    break;
                case 11:
                    status = "Approved";
                    break;
                case 12:
                    status = "Approved";
                    break;
                case 13:
                    status = "Approved";
                    break;
                case 100:
                    status = "Deleted";
                    break;
                case 14:
                    status = "Reverse Edit";
                    break;

                default:
                    status = "Unknown";
                    break;
            }

            itemRow.createCell(11).setCellValue(status);

            CrcForm crcForm = crcFormService.readByoapId(oap.getId() + "");
            if (crcForm.getId() != 0) {
//                itemRow.createCell(12).setCellValue(crcForm.getFlagStatus());
                Integer flags = (Integer) (crcForm.getFlagStatus());

                String Status;

                switch (flags) {
                    case 0:
                        Status = "Pending to Approved";
                        break;
                    case 1:
                        Status = "Approved";
                        break;
                    case 2:
                        Status = "Partially Approved";
                        break;
                    case 3:
                        Status = "Rejected";
                        break;
                    case 4:
                        Status = "Approved";
                        break;
                    case 800:
                        Status = "Partially Approved";
                        break;

                    default:
                        Status = "Unknown";
                        break;
                }

                itemRow.createCell(12).setCellValue(Status);

            } else {
                itemRow.createCell(12).setCellValue("");
            }

        }

        String appPath = request.getServletContext().getRealPath("");
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + "oapreportexcel.xlsx";

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
        return mv;
    }

    public ModelAndView aocRightsReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("Oap/aocRightsReport");
        return mv;
    }

    public ModelAndView aocReportList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        String aocdocumentNumber = request.getParameter("aocdocumentNumber");
//        String projectName = request.getParameter("projectName");

        String open_from_date = request.getParameter("open_from_date").replace("-", "/");
        String open_to_date = request.getParameter("open_to_date").replace("-", "/");
//
//        List list1 = aocFormService.readaocReportList(aocdocumentNumber, open_from_date, open_to_date, projectName);//both
//        List list2 = aocFormService.readaocReportList8(aocdocumentNumber, open_from_date, open_to_date, projectName);//aoc
//
//        mv.getModelMap().put("list1", list1);
//        mv.getModelMap().put("list2", list2);
//        mv.getModelMap().put("aocdocumentNumber", aocdocumentNumber);
        mv.getModelMap().put("open_from_date", open_from_date);
        mv.getModelMap().put("open_to_date", open_to_date);
        mv.setViewName("Oap/aocRightsReport");
        return mv;
    }

    public ModelAndView aocReportexcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String aocdocumentNumber = request.getParameter("document");

        String open_from_date = request.getParameter("fromdate");
        String open_to_date = request.getParameter("todate");

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

        Row itemHeaderRow = sheet.createRow(rownum++);
        itemHeaderRow.setHeightInPoints(40);
        String[] itemHeaders = {"Document No", "Hub Depo Name", "Project Name", "AOC Release (From Date)", "AOC Release (To Date)", "Time Period (Days)", "No Of Charger", "No of Charge Charge Points", "Overall station capacity(kW)",
            "CreatedBy", "Designation", "Created Date", "AOC Status", "KOM Status"};

        for (int i = 0; i < itemHeaders.length; i++) {
            sheet.setColumnWidth(i, 11000);
            Cell cell = itemHeaderRow.createCell(i);
            cell.setCellValue(itemHeaders[i]);
            cell.setCellStyle(styleBold);
        }

        List list2 = aocFormService.readaocExcelReportList8(aocdocumentNumber, open_from_date, open_to_date);

        for (Object o : list2) {

            AocForm aoc = (AocForm) o;

            Row itemRow = sheet.createRow(rownum++);

            itemRow.createCell(0).setCellValue(aoc.getDocumentNo());
            itemRow.createCell(1).setCellValue(aoc.getHubDepoName());
            itemRow.createCell(2).setCellValue(aoc.getClientProjectName());
            itemRow.createCell(3).setCellValue(aoc.getZeroDate());
            itemRow.createCell(4).setCellValue(aoc.getCompletionDate());
            itemRow.createCell(5).setCellValue(aoc.getChargingRatePerUnit());
            itemRow.createCell(6).setCellValue(aoc.getNoOfCharger());
            itemRow.createCell(7).setCellValue(aoc.getNoOfChargePoints());
            itemRow.createCell(8).setCellValue(aoc.getOverallStationCapacityKw());
            itemRow.createCell(9).setCellValue(aoc.getUserId());
            itemRow.createCell(10).setCellValue(aoc.getDesignation());
            itemRow.createCell(11).setCellValue(aoc.getCreatedDate());
            Integer flag = (Integer) (aoc.getFlagStatus());
            String status;

            switch (flag) {
                case 0:
                    status = "Save As Draft";
                    break;
                case 1:
                    status = "Pending to Approve";
                    break;
                case 2:
                    status = "Recycle";
                    break;
                case 3:
                    status = "Rejected";
                    break;
                case 4:
                    status = "Approved";
                    break;
                case 5:
                    status = "";
                    break;
                case 6:
                    status = "Approved";
                    break;
                case 7:
                    status = "Approved";
                    break;
                case 8:
                    status = "Project Manager cancel";
                    break;
                case 9:
                    status = "Project Manager Rejected";
                    break;
                case 10:
                    status = "Project Manager Close";
                    break;
                case 11:
                    status = "Approved";
                    break;
                case 12:
                    status = "Approved";
                    break;
                case 13:
                    status = "Approved";
                    break;
                case 100:
                    status = "Deleted";
                    break;
                default:
                    status = "Unknown";
                    break;
            }

            itemRow.createCell(12).setCellValue(status);

            KickOffForm kickOffForm = kickOffFormService.readByaocId(aoc.getId() + "");
            if (kickOffForm.getId() != 0) {
                Integer flags = (Integer) (kickOffForm.getFlagStatus());

                String Status;

                switch (flags) {
                    case 0:
                        Status = "Pending to Approved";
                        break;
                    case 1:
                        Status = "Approved";
                        break;
                    case 2:
                        Status = "Recycle";
                        break;
                    case 3:
                        Status = "Rejected";
                        break;
                    case 4:
                        Status = "Approved";
                        break;

                    default:
                        Status = "Unknown";
                        break;
                }

                itemRow.createCell(13).setCellValue(Status);

            } else {
                itemRow.createCell(13).setCellValue("");
            }

        }

        String appPath = request.getServletContext().getRealPath("");
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + "aocreportexcel.xlsx";

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
        return mv;
    }

    public ModelAndView delimultiDocxdownloadzip(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id1 = request.getParameter("id1");
        List prd = designCoordinatorMultiAttachService.readBydelimultiid(id1);
        int size = prd.size();

        String[] fileNames = new String[prd.size()];
        String pRD = "";
        int id = 0;
        int id2 = 0;
        int a = 0;
        for (Object o : prd) {
            DesignCoordinatorMultiAttach pRDoc = (DesignCoordinatorMultiAttach) o;
            id = pRDoc.getOapId();
            id2 = pRDoc.getAocId();
            fileNames[a] = pRDoc.getAttachement();

            a++;
        }
        // Initialize zip output stream
        response.setContentType("application/zip");
        if (id == 0) {
            response.setHeader("Content-Disposition", "attachment;filename=aoc_files.zip");
        }
        if (id2 == 0) {
            response.setHeader("Content-Disposition", "attachment;filename=oap_files.zip");
        }

        try (ZipOutputStream zos = new ZipOutputStream(response.getOutputStream())) {
            for (String fileEntry : fileNames) {

                // Locate the file on disk
                String fileLocation = "";
                if (id == 0) {
                    fileLocation = getServletContext().getRealPath("/") + File.separator + "StorageYard"
                            + File.separator + "Aoc" + File.separator + id2 + File.separator + fileEntry;
                }
                if (id2 == 0) {
                    fileLocation = getServletContext().getRealPath("/") + File.separator + "StorageYard"
                            + File.separator + "OAP" + File.separator + id + File.separator + fileEntry;
                }

                File file = new File(fileLocation);
                if (file.exists()) {
                    // Add file to zip
                    try (FileInputStream fis = new FileInputStream(file)) {
                        ZipEntry zipEntry = new ZipEntry(fileEntry);

                        // Handle duplicate files gracefully
                        try {
                            zos.putNextEntry(zipEntry);

                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = fis.read(buffer)) > 0) {
                                zos.write(buffer, 0, length);
                            }

                            zos.closeEntry();
                        } catch (IOException duplicateFileException) {
                            // Skip duplicate file and continue processing
                            System.err.println("Skipping duplicate file: " + fileEntry);
                        }
                    } catch (IOException fileReadException) {
                        // Log error and continue processing
                        System.err.println("Error reading file: " + fileEntry);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        mv.getModelMap().put("prdSize", size);
        return mv;
    }

    public ModelAndView oapexcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
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

        Row itemHeaderRow = sheet.createRow(rownum++);
        itemHeaderRow.setHeightInPoints(40);
        String[] itemHeaders = {"Enterprise Project ID*", "Description*", "Project Profile*", "Project Start Date*", "Project Finish Date*", "Actual Start Date", "Actual Finish Date", "Project Manager ID (Business Partner)",
            "Cost Center*", "Profit Center*", "Functional Area", "Company Code", "Plant", "Location", "Priority", "Processing Status", "Project Type", "Budget Availability Control Profile", "Availability Control Indicator", "Availability Control Indicator",
            "Joint Venture Name", "Recovery Indicator", "Equity Type", "Object Type", "JIB/JIBE Class", "JIB/JIBE Subclass A", "Project Currency", "Fund", "Grant", "Grant", "Indicator: Grant with Fix Assignment", "Indicator: Func. Area has Fix Assgmt",
            "Sponsored Program", "Tax Jurisdiction Code", "Functional Location", "Investment Profile", "Indicator: Billing Element", "Blocking Indicator - Time Recording", "Blocking Indicator - Concur Expense", "Blocking Indicator - Activity Allocation",
            "Blocking Indicator - Other Expense Pstng", "Blocking Indicator - Purchasing", "Indicator: Assign to Multiple SO Items", "Business Partner ID", "Electricity Meter Consumer No2", "Electricity Meter Consumer No3", "Electricity Meter Consumer No1",
            "Discom", "Highway", "No. of Charge Points", "No. of Charger", "Overall Station Capacity (KW)", "City", "Country", "State", "Station AC Capacity (KW)", "Station DC Capacity (KW)", "Station Name", "Station Type", "Tenant"};

        for (int i = 0; i < itemHeaders.length; i++) {
            sheet.setColumnWidth(i, 11000);
            Cell cell = itemHeaderRow.createCell(i);
            cell.setCellValue(itemHeaders[i]);
            cell.setCellStyle(styleBold);
        }
        String EnterpriseProjectID = oapForm.getDocumentNo();
        String Description = oapForm.getClientDetails();
        String ProjectProfile = oapForm.getProjectProfile();
        String ProjectStartDate = oapForm.getTimeLineFromDate();
        String ProjectFinishDate = oapForm.getTimeLineToDate();
        String ActualStartDate = "";
        String ActualFinishDate = "";
        String ProjectManagerID = "";
        String CostCenter = "";
        String ProfitCenter = oapForm.getProjectCenter();
        String FunctionalArea = "";
        String CompanyCode = oapForm.getCompanyCode();
        String Plant = oapForm.getPlant();
        String Location = "";
        String Priority = "";
        String ProcessingStatus = "";
        String ProjectType = oapForm.getProjectType();
        String BudgetAvailabilityControlProfile = "";
        String AvailabilityControlIndicator1 = "";
        String AvailabilityControlIndicator2 = "";
        String JointVentureName = "";
        String RecoveryIndicator = "";
        String EquityType = "";
        String ObjectType = "";
        String JIBJIBEClass = "";
        String JIBJIBESubclassA = "";
        String ProjectCurrency = oapForm.getProjectCurrency();
        String Fund = "";
        String Grant1 = "";
        String Grant2 = "";
        String GrantWithFixAssignment = "";
        String FuncAreaHasFixAssignment = "";
        String SponsoredProgram = "";
        String TaxJurisdictionCode = "";
        String FunctionalLocation = "";
        String InvestmentProfile = oapForm.getInverstmentProfile();
        String BillingElementIndicator = "";
        String BlockingIndicatorTimeRecording = "";
        String BlockingIndicatorConcurExpense = "";
        String BlockingIndicatorActivityAllocation = "";
        String BlockingIndicatorOtherExpensePstng = "";
        String BlockingIndicatorPurchasing = "";
        String AssignToMultipleSOItems = "";
        String BusinessPartnerID = "";
        String ElectricityMeterConsumerNo1 = "";
        String ElectricityMeterConsumerNo2 = "";
        String ElectricityMeterConsumerNo3 = "";
        String Discom = oapForm.getDiscom();
        String Highway = oapForm.getPcsCityHighway();
        String NoOfChargePoints = oapForm.getNoOfChargePoints();
        String NoOfCharger = oapForm.getNoOfCharger();
        String OverallStationCapacityKW = oapForm.getOverallStationCapacityKw();
        String City = oapForm.getCity();
        String Country = oapForm.getCountry();
        String State = oapForm.getState();
        String StationACCapacityKW = oapForm.getStationAcCapacityKw();
        String StationDCCapacityKW = oapForm.getStationDcCapacityKw();
        String StationName = oapForm.getStationName();
        String StationType = oapForm.getStationName();
        String Tenant = oapForm.getTenant();

        Row itemRow = sheet.createRow(rownum++);

        itemRow.createCell(0).setCellValue(EnterpriseProjectID);
        itemRow.createCell(1).setCellValue(Description);
        itemRow.createCell(2).setCellValue(ProjectProfile);
        itemRow.createCell(3).setCellValue(ProjectStartDate);
        itemRow.createCell(4).setCellValue(ProjectFinishDate);
        itemRow.createCell(5).setCellValue(ActualStartDate);
        itemRow.createCell(6).setCellValue(ActualFinishDate);
        itemRow.createCell(7).setCellValue(ProjectManagerID);
        itemRow.createCell(8).setCellValue(CostCenter);
        itemRow.createCell(9).setCellValue(ProfitCenter);
        itemRow.createCell(10).setCellValue(FunctionalArea);
        itemRow.createCell(11).setCellValue(CompanyCode);
        itemRow.createCell(12).setCellValue(Plant);
        itemRow.createCell(13).setCellValue(Location);
        itemRow.createCell(14).setCellValue(Priority);
        itemRow.createCell(15).setCellValue(ProcessingStatus);
        itemRow.createCell(16).setCellValue(ProjectType);
        itemRow.createCell(17).setCellValue(BudgetAvailabilityControlProfile);
        itemRow.createCell(18).setCellValue(AvailabilityControlIndicator1);
        itemRow.createCell(19).setCellValue(AvailabilityControlIndicator2);
        itemRow.createCell(20).setCellValue(JointVentureName);
        itemRow.createCell(21).setCellValue(RecoveryIndicator);
        itemRow.createCell(22).setCellValue(EquityType);
        itemRow.createCell(23).setCellValue(ObjectType);
        itemRow.createCell(24).setCellValue(JIBJIBEClass);
        itemRow.createCell(25).setCellValue(JIBJIBESubclassA);
        itemRow.createCell(26).setCellValue(ProjectCurrency);
        itemRow.createCell(27).setCellValue(Fund);
        itemRow.createCell(28).setCellValue(Grant1);
        itemRow.createCell(29).setCellValue(Grant2);
        itemRow.createCell(30).setCellValue(GrantWithFixAssignment);
        itemRow.createCell(31).setCellValue(FuncAreaHasFixAssignment);
        itemRow.createCell(32).setCellValue(SponsoredProgram);
        itemRow.createCell(33).setCellValue(TaxJurisdictionCode);
        itemRow.createCell(34).setCellValue(FunctionalLocation);
        itemRow.createCell(35).setCellValue(InvestmentProfile);
        itemRow.createCell(36).setCellValue(BillingElementIndicator);
        itemRow.createCell(37).setCellValue(BlockingIndicatorTimeRecording);
        itemRow.createCell(38).setCellValue(BlockingIndicatorConcurExpense);
        itemRow.createCell(39).setCellValue(BlockingIndicatorActivityAllocation);
        itemRow.createCell(40).setCellValue(BlockingIndicatorOtherExpensePstng);
        itemRow.createCell(41).setCellValue(BlockingIndicatorPurchasing);
        itemRow.createCell(42).setCellValue(AssignToMultipleSOItems);
        itemRow.createCell(43).setCellValue(BusinessPartnerID);
        itemRow.createCell(44).setCellValue(ElectricityMeterConsumerNo1);
        itemRow.createCell(45).setCellValue(ElectricityMeterConsumerNo2);
        itemRow.createCell(46).setCellValue(ElectricityMeterConsumerNo3);
        itemRow.createCell(47).setCellValue(Discom);
        itemRow.createCell(48).setCellValue(Highway);
        itemRow.createCell(49).setCellValue(NoOfChargePoints);
        itemRow.createCell(50).setCellValue(NoOfCharger);
        itemRow.createCell(51).setCellValue(OverallStationCapacityKW);
        itemRow.createCell(52).setCellValue(City);
        itemRow.createCell(53).setCellValue(Country);
        itemRow.createCell(54).setCellValue(State);
        itemRow.createCell(55).setCellValue(StationACCapacityKW);
        itemRow.createCell(56).setCellValue(StationDCCapacityKW);
        itemRow.createCell(57).setCellValue(StationName);
        itemRow.createCell(58).setCellValue(StationType);
        itemRow.createCell(59).setCellValue(Tenant);

        String appPath = request.getServletContext().getRealPath("");
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + "oapexcel.xlsx";

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
        return mv;
    }

    public ModelAndView oapHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        List list = oapFormHistoryService.readByoapid(id);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("id", id);

        mv.setViewName("Oap/oapHistory");
        return mv;
    }

    public ModelAndView oapHistoryView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        OapFormHistory oapFormHistory = oapFormHistoryService.readById(Integer.parseInt(id));

        List oapsurattahistory = oapSurveyAttachmentHistoryService.readByoaphistryid(id);

        int oaphistoryid = oapFormHistory.getId();
        int oapid = oapFormHistory.getOapId();

        OapForm oapForm = oapFormService.readById(oapid);
        String connectiontype1 = oapForm.getConnectionType();
        String discom1 = oapForm.getDiscom();
        int id1 = oapForm.getId();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom1));
        String discom = discomMaster.getDiscomType();

        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectiontype1));
        String connectiontype = connectionType1.getConnectionType();

        List list33 = oapMultiAttachmentHistoryService.readByMulti(oaphistoryid);

        List chargeInst = chargerInstallationDetailsHistoryService.readByoapId(oapid);
        mv.getModelMap().put("chargeInst", chargeInst);

        if (chargeInst.isEmpty()) {
            List chargeInstMain = chargerInstallationDetailsService.readByoapId(oapid + "");
            mv.getModelMap().put("chargeInstMain", chargeInstMain);
        }

        mv.getModelMap().put("id1", id1);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("connectiontype", connectiontype);
        mv.getModelMap().put("discom", discom);
        mv.getModelMap().put("list55", oapFormHistory);
        mv.getModelMap().put("oapsurattahistory", oapsurattahistory);
        mv.setViewName("Oap/oapHistoryView");
        return mv;
    }

    public ModelAndView crcHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        List list = crcFormHistoryService.readBylasttimestatus(id);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("id", id);

        mv.setViewName("Oap/crcHistory");
        return mv;
    }

    public ModelAndView crcHistoryview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        CrcFormHistory crcFormHistory = crcFormHistoryService.readById(Integer.parseInt(id));
        int crcid = crcFormHistory.getCrcId();
        CrcForm crcForm = crcFormService.readById(crcid);
        String pcsname = crcForm.getPcsName();
        String oapNumber = crcForm.getOapNumber();
        mv.getModelMap().put("pcsname", pcsname);
        mv.getModelMap().put("oapNumber", oapNumber);
        mv.getModelMap().put("list", crcFormHistory);
        mv.setViewName("Oap/crcHistoryview");
        return mv;
    }

    public ModelAndView oaphistoryAttachment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");

        List list0 = oapMultiAttachmentHistoryService.readByMulti1(id);
        int size1 = list0.size();
        String[] fileNames = new String[list0.size()]; // Ensure correct array size
        int a = 0;
        List allAttachments = new ArrayList();
        allAttachments.addAll(list0);
        for (Object o : allAttachments) {
            if (o instanceof OapMultiAttachmentHistory) {
                OapMultiAttachmentHistory pRDoc = (OapMultiAttachmentHistory) o; // Direct cast without array
                fileNames[a] = pRDoc.getAttachment();
                a++;
            }
        }
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment;filename=OAPHistoryFILE.zip");

        try (ZipOutputStream zos = new ZipOutputStream(response.getOutputStream())) {
            for (String fileEntry : fileNames) {

                // Locate the file on disk
                String fileLocation = getServletContext().getRealPath("/") + File.separator + "StorageYard"
                        + File.separator + "OAP" + File.separator + id1 + File.separator + fileEntry;

                File file = new File(fileLocation);
                if (file.exists()) {
                    // Add file to zip
                    try (FileInputStream fis = new FileInputStream(file)) {
                        ZipEntry zipEntry = new ZipEntry(fileEntry);

                        // Check if the file already exists in ZIP, handle duplicate case
                        try {
                            zos.putNextEntry(zipEntry);

                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = fis.read(buffer)) > 0) {
                                zos.write(buffer, 0, length);
                            }

                            zos.closeEntry();
                        } catch (IOException duplicateFileException) {
                            // Skip the duplicate entry and continue processing
                            System.err.println("Skipping duplicate file: " + fileEntry);
                        }
                    } catch (IOException fileReadException) {
                        // Log the file read error and continue processing other files
                        System.err.println("Error reading file: " + fileEntry);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        mv.getModelMap().put("list0", list0);
        mv = oapHistoryView(request, response);

        return mv;
    }

    public ModelAndView AllFormsView4(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        CrcForm crcForm = crcFormService.readById(Integer.parseInt(id));

        CrcFormApproval crcFormApproval = crcFormApprovalService.readBycrcid(id);

        int crcformid = crcFormApproval.getId();

        List list0 = crcFormApprovalCommentService.readBycrcformid(crcformid);
        List oaplogmaster = oapLogMasterService.readBycrcid(id);
        mv.getModelMap().put("oaplogmaster", oaplogmaster);

        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list", crcForm);

        mv.setViewName("Oap/AllFormsView4");
        return mv;

    }

    public ModelAndView Sitesurvey(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();
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
        mv.setViewName("Oap/Sitesurvey");
        return mv;

    }

    public ModelAndView Sitesurveyopen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String surveyid = request.getParameter("id");
//        List surveyCategory = surveyCategoryMasterService.read();
//        List surveySuCategory = surveySubCategoryMasterService.read();
        SiteSurvey siteSurvey = siteSurveyService.readById(Integer.parseInt(surveyid));
//        mv.getModelMap().put("surveyCategory", surveyCategory);
//        mv.getModelMap().put("surveySuCategory", surveySuCategory);
        mv.getModelMap().put("siteSurvey", siteSurvey);
        mv.getModelMap().put("surveyid", surveyid);
        mv.setViewName("Oap/Sitesurveyopen");
        return mv;

    }

    public ModelAndView Sitesurveyedit(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        String id = request.getParameter("id");
        SiteSurvey siteSurvey = siteSurveyService.readById(Integer.parseInt(id));
        List SurveyAttach = siteSurveyAttachmentService.readBysiteSurveyId(id);

        mv.getModelMap().put("SurveyAttach", SurveyAttach);
        mv.getModelMap().put("siteSurvey", siteSurvey);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/Sitesurveyedit");
        return mv;

    }

    public ModelAndView SitesurveyeditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String id = request.getParameter("id");

        String sitename = request.getParameter("sitename");
        String siteaddress = request.getParameter("siteaddress");
        String description = request.getParameter("description");
        String srtdate = request.getParameter("Fromdate6");
        String endate = request.getParameter("Fromdate7");
//        String type = request.getParameter("type");
//        String vendor = request.getParameter("vendor");
        String location = request.getParameter("location");
        String typeofcharge = request.getParameter("typeofcharge");
        String noofchargers = request.getParameter("noofchargers");
        String google = request.getParameter("google");
        String nameofLocationPartner = request.getParameter("nameofLocationPartner");
        String mobileNoLocationPartner = request.getParameter("mobileNoLocationPartner");

        SiteSurvey siteSurvey = siteSurveyService.readById(Integer.parseInt(id));
        siteSurvey.setSiteName(sitename);
        siteSurvey.setSiteAddress(siteaddress);
        siteSurvey.setDescription(description);
        siteSurvey.setStartDate(srtdate);
        siteSurvey.setEndDate(endate);
//        siteSurvey.setFormFillType(type);
//        siteSurvey.setVendor(vendor);
        siteSurvey.setCreatedBy(username1);
        siteSurvey.setLocation(location);
        siteSurvey.setTypeOfCharge(typeofcharge);
        siteSurvey.setNoOfCharges(noofchargers);
        siteSurvey.setGoogleCoordinates(google);
        siteSurvey.setNameofLocationPartner(nameofLocationPartner);
        siteSurvey.setMobileNoLocationPartner(mobileNoLocationPartner);
        siteSurveyService.update(siteSurvey);

        int surveyid = siteSurvey.getId();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + surveyid;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] descriptions = request.getParameterValues("descriptions");
        int a = 0;
        if (files1 != null && !files1.isEmpty() && descriptions != null && descriptions.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP"
                            + File.separator + surveyid + File.separator;

                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs(); // Create the directory if it doesn't exist
                    }

                    File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    try {
                        file1.transferTo(destinationFile1); // Ensure proper exception handling
                    } catch (Exception e) {
                        e.printStackTrace(); // Handle the error or log it
                    }

                    SiteSurveyAttachment siteSurveyAttachment = new SiteSurveyAttachment();

                    siteSurveyAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    siteSurveyAttachment.setDescription(descriptions[a]);
                    siteSurveyAttachment.setSiteSurveyId(surveyid);

                    siteSurveyAttachmentService.create(siteSurveyAttachment);
                    a++;
                }
            }

        }
        mv.getModelMap().put("surveyid", surveyid);
        session1.setAttribute("successMessage", "Survey Edited successfully");

        mv.setViewName("redirect:oapForm.htm?act=Sitesurvey");
        return mv;

    }

    public ModelAndView Sitesurveydelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {

            int siteSurveyId = Integer.parseInt(checkedValues);

            List surveyAttach = siteSurveyAttachmentService.readBysiteSurveyId(siteSurveyId + "");

            for (Object s : surveyAttach) {
                SiteSurveyAttachment siteSurveyAttachment1 = (SiteSurveyAttachment) s;
                int attachmentId = siteSurveyAttachment1.getId();
                siteSurveyAttachmentService.delete(attachmentId);
            }

            siteSurveyService.delete(siteSurveyId);
        }

        request.setAttribute("successMessage",
                " One or more data deleted successfully");

        session1.setAttribute("successMessage", " Survey Deleted successfully");

        mv.setViewName("redirect:oapForm.htm?act=Sitesurvey");
        return mv;

    }

    public ModelAndView Sitesurveydelete1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String id = request.getParameter("id");

        List surveyAttach = siteSurveyAttachmentService.readBysiteSurveyId(id + "");

        for (Object s : surveyAttach) {
            SiteSurveyAttachment siteSurveyAttachment1 = (SiteSurveyAttachment) s;
            int id5 = siteSurveyAttachment1.getId();
            siteSurveyAttachmentService.delete(id5);
        }
        siteSurveyService.delete(Integer.parseInt(id));

        request.setAttribute("successMessage",
                " One or more data deleted successfully");

        session1.setAttribute("successMessage", " Survey Deleted successfully");

        mv.setViewName("redirect:oapForm.htm?act=Sitesurvey");
        return mv;

    }

    public ModelAndView sitesurveyClose(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String id = request.getParameter("id");
        String remark = request.getParameter("remark");

        SiteSurvey siteSurvey = siteSurveyService.readById(Integer.parseInt(id));

        siteSurvey.setRemark(remark);
        siteSurvey.setFlagStatus(100);
        siteSurveyService.update(siteSurvey);

        session1.setAttribute("successMessage", " Survey Closed successfully");

        mv.setViewName("redirect:oapForm.htm?act=Sitesurvey");
        return mv;

    }

    public ModelAndView surveydownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String fileName = request.getParameter("fileName");
        String id2 = request.getParameter("id2");
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + id2 + File.separator + fileName;

        request.setAttribute("filePath", fileLocationURL);
        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        return mv;

    }

    public ModelAndView Sitesurveyeditdocdelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String Surveyattachmentid = request.getParameter("id4");
        String siteSurveyId = request.getParameter("id3");

        siteSurveyAttachmentService.delete(Integer.parseInt(Surveyattachmentid));

        mv.getModelMap().put("Surveyattachmentid", Surveyattachmentid);
        mv.getModelMap().put("siteSurveyId", siteSurveyId);

        mv.setViewName("redirect:oapForm.htm?act=Sitesurveyedit&id=" + siteSurveyId);

        return mv;

    }

    public ModelAndView Sitesurveypage(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Oap/Sitesurveypage");
        return mv;

    }

    public ModelAndView Sitesurveypagesubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String sitename = request.getParameter("sitename");
        String siteaddress = request.getParameter("siteaddress");
        String description = request.getParameter("description");
        String srtdate = request.getParameter("Fromdate6");
        String endate = request.getParameter("Fromdate7");
        String location = request.getParameter("location");
        String typeofcharge = request.getParameter("typeofcharge");
        String noofchargers = request.getParameter("noofchargers");
        String google = request.getParameter("google");
        String nameofLocationPartner = request.getParameter("nameofLocationPartner");
        String mobileNoLocationPartner = request.getParameter("mobileNoLocationPartner");

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateTime = currentDateTime.format(formatter);
        Date date5 = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yy");
        String sysdate = sdf4.format(date5);
        Date date55 = new java.util.Date();
        SimpleDateFormat sdf5 = new SimpleDateFormat("MM");
        String sysdate1 = sdf5.format(date55);
        int month_frt = Integer.parseInt(sysdate1);
        int year_frt = Integer.parseInt(sysdate);

        SurveyDocumentNo surveyDocumentNo = surveyDocumentNoService.readByDocumentNo();

        String meetingno = "0";
        meetingno = surveyDocumentNo.getDocumentNo();
        if (meetingno == null) {
            meetingno = "0";
        }

        int ten_no_int = 0;

        ten_no_int = Integer.parseInt(meetingno);

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

        String refNo = final_ten_no;
//	refNo = "OAP" + "-" + refNo;

        String f_year = refNo.substring(0, 2);
        String f_no = refNo.substring(2, 7);

        int f_y1 = Integer.parseInt(f_year);
        f_y1++;

        refNo = "" + f_year + "" + f_y1 + "-" + f_no;

        SiteSurvey siteSurvey = new SiteSurvey();

        siteSurvey.setSiteName(sitename);
        siteSurvey.setSiteAddress(siteaddress);
        siteSurvey.setDescription(description);
        siteSurvey.setStartDate(srtdate);
        siteSurvey.setEndDate(endate);

        siteSurvey.setCreatedBy(username1);
        siteSurvey.setFlagStatus(0);
        siteSurvey.setSurveyDocumentNo(refNo);
        siteSurvey.setLocation(location);
        siteSurvey.setTypeOfCharge(typeofcharge);
        siteSurvey.setNoOfCharges(noofchargers);
        siteSurvey.setGoogleCoordinates(google);
        siteSurvey.setNameofLocationPartner(nameofLocationPartner);
        siteSurvey.setMobileNoLocationPartner(mobileNoLocationPartner);

        if (!siteSurveyService.isExist(siteSurvey)) {
            siteSurveyService.create(siteSurvey);
            SurveyDocumentNo surveyDocumentNo1 = new SurveyDocumentNo();
            surveyDocumentNo1.setDocumentNo(final_ten_no);

            surveyDocumentNoService.create(surveyDocumentNo1);

            int surveyid = siteSurvey.getId();

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP"
                    + File.separator + surveyid;
            File f1 = new File(path);
            boolean bool = f1.mkdirs();

            List<MultipartFile> files1 = multipartRequest.getFiles("attach");
            String[] descriptions = request.getParameterValues("descriptions");
            int a = 0;
            if (files1 != null && !files1.isEmpty() && descriptions != null && descriptions.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "OAP"
                                + File.separator + surveyid + File.separator;

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

                        SiteSurveyAttachment siteSurveyAttachment = new SiteSurveyAttachment();

                        siteSurveyAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        siteSurveyAttachment.setDescription(descriptions[a]);
                        siteSurveyAttachment.setSiteSurveyId(surveyid);

                        siteSurveyAttachmentService.create(siteSurveyAttachment);
                        a++;
                    }
                }

            }
            mv.getModelMap().put("surveyid", surveyid);
            session1.setAttribute("successMessage", "Site Survey  Created Successfully");
            mv.setViewName("redirect:oapForm.htm?act=Sitesurvey");

        } else {

            session1.setAttribute("failureMessage", "Site Survey  Already Exist. Please Enter Site Survey ");
            mv.setViewName("redirect:oapForm.htm?act=Sitesurveypage");
        }
        return mv;

    }

    public ModelAndView vendorSiteSurveyList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        if (session1 != null) {
            String successMessage = (String) session1.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session1.removeAttribute("successMessage"); // clean up after showing
            }
        }

        List vendorSiteList = siteSurveyService.readByVendor(username1);
        mv.getModelMap().put("vendorSiteList", vendorSiteList);
        mv.setViewName("Oap/VendorSiteSurveyList");
        return mv;

    }

    public ModelAndView Sitesurveyopenvendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String surveyid = request.getParameter("id");
//        List surveyCategory = surveyCategoryMasterService.read();
//        List surveySuCategory = surveySubCategoryMasterService.read();
        SiteSurvey siteSurvey = siteSurveyService.readById(Integer.parseInt(surveyid));
//        mv.getModelMap().put("surveyCategory", surveyCategory);
//        mv.getModelMap().put("surveySuCategory", surveySuCategory);
        mv.getModelMap().put("siteSurvey", siteSurvey);
        mv.getModelMap().put("surveyid", surveyid);
        mv.setViewName("Oap/Sitesurveyopenvendor");
        return mv;

    }

//    public ModelAndView vendorSitesurveyopensubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//
//        HttpSession session1 = request.getSession(false);
//        UserMaster user1 = (UserMaster) session1.getAttribute("user");
//        String username1 = user1.getLoginName();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String today = dateFormat.format(new Date());
//        String surveyid = request.getParameter("surveyid");
//        String sitedate1 = request.getParameter("sitedate1");
//        String Namesurveyperson = request.getParameter("Namesurveyperson");
//        String Sitename = request.getParameter("Sitename");
//
//        String siteremark = request.getParameter("siteremark");
//        String siteremark1 = request.getParameter("siteremark1");
//        String Conclusion1 = request.getParameter("Conclusion1");
//        String Conclusion2 = request.getParameter("Conclusion2");
//
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formattedDateTime = currentDateTime.format(formatter);
//        Date date5 = new java.util.Date();
//        SimpleDateFormat sdf4 = new SimpleDateFormat("yy");
//        String sysdate = sdf4.format(date5);
//        Date date55 = new java.util.Date();
//        SimpleDateFormat sdf5 = new SimpleDateFormat("MM");
//        String sysdate1 = sdf5.format(date55);
//        int month_frt = Integer.parseInt(sysdate1);
//        int year_frt = Integer.parseInt(sysdate);
//
//        SurveyDocumentNo surveyDocumentNo = surveyDocumentNoService.readByDocumentNo();
//
//        String meetingno = "0";
//        meetingno = surveyDocumentNo.getDocumentNo();
//        if (meetingno == null) {
//            meetingno = "0";
//        }
//
//        int ten_no_int = 0;
//
//        ten_no_int = Integer.parseInt(meetingno);
//
//        long ten_no_final = 0;
//
//        String final_ten_no = "";
//        ten_no_int++;
//        String text = String.format("%07d", ten_no_int);
//        String mini = text.substring(0, 2);
//        String sub_text = "";
//        if (month_frt <= 3) {
//            int bbb = year_frt - 1;
//            sysdate = Integer.toString(bbb);
//            if (mini.equals(sysdate)) {
//                final_ten_no = text;
//
//            } else {
//                int bbbb = year_frt - 1;
//                sysdate = Integer.toString(bbbb);
//                sub_text = text.substring(2);
//                final_ten_no = sysdate + sub_text;
//            }
//        } else {
//            if (mini.equals(sysdate)) {
//                final_ten_no = text;
//            } else {
//                sub_text = text.substring(2);
//                final_ten_no = sysdate + "00001";
//            }
//        }
//
//        String refNo = final_ten_no;
////	refNo = "OAP" + "-" + refNo;
//
//        String f_year = refNo.substring(0, 2);
//        String f_no = refNo.substring(2, 7);
//
//        int f_y1 = Integer.parseInt(f_year);
//        f_y1++;
//
//        refNo = "" + f_year + "" + f_y1 + "-" + f_no;
//
//        SurveyMaster surveyMaster = new SurveyMaster();
//
//        surveyMaster.setDocumentNo(refNo);
//        surveyMaster.setDocumentRevisionNo("R0");
//        surveyMaster.setCreatedBy(username1);
//        surveyMaster.setSiteVisitDate(sitedate1);
//        surveyMaster.setSiteName(Sitename);
//        surveyMaster.setNameOfPersonWhoCreatedSiteSurvey(Namesurveyperson);
//        surveyMaster.setCreatedDate(today);
//        surveyMaster.setSiteVisitRemarks(siteremark);
//        surveyMaster.setSiteVisitDetails(siteremark1);
//        surveyMaster.setSiteConformationByChargezone(Conclusion1);
//        surveyMaster.setSiteConformationByChargezoneYesNo(Conclusion2);
//        surveyMaster.setSurveyType("0");
//        surveyMaster.setFlagStatus(0);
//        surveyMaster.setDocumentNo(refNo);
//        surveyMaster.setSiteSurveyId(Integer.parseInt(surveyid));
//        surveyMasterService.create(surveyMaster);
//
//        SurveyDocumentNo surveyDocumentNo1 = new SurveyDocumentNo();
//        surveyDocumentNo1.setDocumentNo(final_ten_no);
//        surveyDocumentNoService.create(surveyDocumentNo1);
//        int surveyId = surveyMaster.getId();
//        String[] description = request.getParameterValues("description");
//        String[] remarks = request.getParameterValues("remarks");
//        List list = surveyCategoryMasterService.read();
//        int a = 0;
//        for (Object o : list) {
//            SurveyCategoryMaster surveyCategory = (SurveyCategoryMaster) o;
//            int surveyCategoryId = surveyCategory.getId();
//            String surveyCategoryname = surveyCategory.getCategoryName();
//            List list1 = surveySubCategoryMasterService.readByCateId(surveyCategoryId);
//            for (Object o1 : list1) {
//                SurveySubCategoryMaster subCategoryMaster = (SurveySubCategoryMaster) o1;
//                String subCategoryName = subCategoryMaster.getSubCategoryName();
//                String guidelines = subCategoryMaster.getGuidelines();
//                SiteSurveyCategoryDetails siteSurveyCategoryDetails = new SiteSurveyCategoryDetails();
//                siteSurveyCategoryDetails.setCategoryName(surveyCategoryname);
//                siteSurveyCategoryDetails.setSubCategory(subCategoryName);
//                siteSurveyCategoryDetails.setGuidelines(guidelines);
//                siteSurveyCategoryDetails.setRemarks(remarks[a]);
//                siteSurveyCategoryDetails.setDiscription(description[a]);
//                siteSurveyCategoryDetails.setSurveyMasterId(surveyId);
//                siteSurveyCategoryDetailsService.create(siteSurveyCategoryDetails);
//
//                a++;
//            }
//        }
//        String[] pointsToBeNoted = request.getParameterValues("roll");
//        String[] description1 = request.getParameterValues("email");
//        String[] remarks1 = request.getParameterValues("cellno");
//        String[] guidlines = request.getParameterValues("guidlines");
//        int b = 0;
//        for (String s : pointsToBeNoted) {
//            DocumentForNewElectricityConnection connection = new DocumentForNewElectricityConnection();
//            connection.setPointToBeNoted(pointsToBeNoted[b]);
//            connection.setDescription(description1[b]);
//            connection.setRemarks(remarks1[b]);
//            connection.setGuidelines(guidlines[b]);
//            connection.setSurveyMasterId(surveyId);
//            documentForNewElectricityConnectionService.create(connection);
//            b++;
//        }
//        session1.setAttribute("successMessage", " Survey Created successfully");
//        mv.getModelMap().put("surveyId", surveyId);
//        mv.setViewName("redirect:oapForm.htm?act=vendorSiteSurveyList");
//compulsaryFlag1
//        return mv;
//
//    }
    public ModelAndView oapStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        List oaplogmaster = oapLogMasterService.readByOapId(id);

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        mv.getModelMap().put("oapForm", oapForm);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("oaplogmaster", oaplogmaster);
//        List oapApproval = oapFormApprovalService.readByOapId(Integer.parseInt(id));
//        CrcForm crcformcreate = crcFormService.readByoapId(id);
//
////       List crcApproval = crcFormApprovalService.readByCrcId(Integer.parseInt(id));
//        mv.getModelMap().put("crcformcreate", crcformcreate);

//        mv.getModelMap().put("oapApproval", oapApproval);
        mv.setViewName("Oap/oapStatus");
        return mv;

    }

    public ModelAndView aocStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        List aoclogmaster = aocLogMasterService.readByAocId(id);

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        mv.getModelMap().put("aocForm", aocForm);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("aoclogmaster", aoclogmaster);

        mv.setViewName("Oap/aocStatus");
        return mv;

    }

    public ModelAndView SiteSurveyCreateDeliverable(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        mv.getModelMap().put("oapForm", oapForm);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/SiteSurveyCreateDeliverable");
        return mv;

    }

    public ModelAndView SiteSurveyCreateDeliverablesubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String id = request.getParameter("id");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");

        int b = 0;

        for (String s : surveyNo) {
            if (s != null && !s.isEmpty()) {
                OapSurveyAttachment oapSurveyAttachment1 = new OapSurveyAttachment();
                oapSurveyAttachment1.setSurveyNo(surveyNo[b]);
                oapSurveyAttachment1.setOapId(Integer.parseInt(id));
                oapSurveyAttachment1.setProjectRepresentative(projectRepresentative[b]);
                oapSurveyAttachmentService.create(oapSurveyAttachment1);

                b++;
            }
        }
        oapForm.setSurveyRadio(1);
        oapFormService.update(oapForm);

        mv.getModelMap().put("id", id);

        session.setAttribute("successMessage", " Site survey created successfully");
        mv.setViewName("redirect:oapForm.htm?act=DesignTeam");
        return mv;

    }

    public ModelAndView SiteSurveyCreateDeliverableAoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        mv.getModelMap().put("aocForm", aocForm);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/SiteSurveyCreateDeliverableAoc");
        return mv;

    }

    public ModelAndView SiteSurveyCreateDeliverableAocsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");
        int b = 0;

        for (String s : surveyNo) {
            if (s != null && !s.isEmpty()) {
                AocSurveyAttachment aocSurveyAttachment1 = new AocSurveyAttachment();
                aocSurveyAttachment1.setSurveyNo(surveyNo[b]);
                aocSurveyAttachment1.setAocId(Integer.parseInt(id));
                aocSurveyAttachment1.setProjectRepresentative(projectRepresentative[b]);
                aocSurveyAttachmentService.create(aocSurveyAttachment1);

                b++;
            }
        }

        aocForm.setSurveyRadio(1);
        aocFormService.update(aocForm);
        mv.getModelMap().put("id", id);

        session.setAttribute("successMessage", " Site survey created successfully");
        mv.setViewName("redirect:oapForm.htm?act=DesignTeam");

        return mv;

    }

    public ModelAndView AllDeliverableViewOap(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        List DelivableCreate = deliverableMultiService.readByOapid(id);
        int size = DelivableCreate.size();

        List list23 = userRightsService.readByDesignCoordinator();
        mv.getModelMap().put("list23", list23);
        mv.getModelMap().put("DelivableCreate", DelivableCreate);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("size", size);
        mv.getModelMap().put("oapForm", oapForm);
        mv.setViewName("Oap/AllDeliverableViewOap");
        return mv;

    }

    public ModelAndView AllDeliverableViewAoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        List DelivableCreate = deliverableMultiService.readByAocId(id);
        int size = DelivableCreate.size();
        List list23 = userRightsService.readByDesignCoordinator();
        mv.getModelMap().put("list23", list23);
        mv.getModelMap().put("DelivableCreate", DelivableCreate);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("size", size);
        mv.getModelMap().put("aocForm", aocForm);
        mv.setViewName("Oap/AllDeliverableViewAoc");
        return mv;

    }

    public ModelAndView DesignManagerClose(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));

//	List list = deliverableMultiService.readBy
        int oapformid = deliverableMulti.getOapId();
        int aocformid = deliverableMulti.getAocId();
        List list10 = designCordinatorCommentsService.readybydelivid(id);

        String designassign = deliverableMulti.getDesignAssign();
        AocForm aocForm = aocFormService.readByformid(aocformid);

        OapForm oapForm = oapFormService.readByformid(oapformid);
        if (aocformid == 0) {
            aocformid = -1;
        }
        if (oapformid == 0) {
            oapformid = -1;
        }
        List list50 = designCoordinatorMultiAttachService.readBydelmultiid(oapformid);
        List list40 = designCoordinatorMultiAttachService.readBydelmultiid1(aocformid);
        CrcForm crcForm = crcFormService.readByoapIds(oapformid);
        KickOffForm kickOffForm = kickOffFormService.readByaocIds(aocformid);

        mv.getModelMap().put("oapformid", oapformid);
        mv.getModelMap().put("aocformid", aocformid);
        mv.getModelMap().put("list50", list50);
        mv.getModelMap().put("list40", list40);

        mv.getModelMap().put("crcForm", crcForm);
        mv.getModelMap().put("kickOffForm", kickOffForm);

        mv.getModelMap().put("list2", oapForm);
        mv.getModelMap().put("list3", aocForm);
        mv.getModelMap().put("list10", list10);

        mv.getModelMap().put("list6", deliverableMulti);
        mv.getModelMap().put("designassign", designassign);

        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/DesignManagerClose");
        return mv;

    }

    public ModelAndView AllDeliverableViewOapAttchment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        String descriptions[] = request.getParameterValues("descriptions");
        String[] Designco = request.getParameterValues("attach");
        try {

            for (int i = 0; i < descriptions.length; i++) {
                DeliverableMulti deliverableMulti = new DeliverableMulti();
                if (descriptions[i] == "") {

                } else {
                    deliverableMulti.setDescription(descriptions[i]);
                    deliverableMulti.setDesignCoordinator(Designco[i]);
                    deliverableMulti.setOapId(Integer.parseInt(id));
                    deliverableMulti.setDeliverableId(0);
                    deliverableMulti.setFlagStatus(0);
                    deliverableMultiService.create(deliverableMulti);
                }
            }

        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        mv = DesignTeam(request, response);
        return mv;

    }

    public ModelAndView AllDeliverableViewAocAttchment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        String descriptions[] = request.getParameterValues("descriptions");
        String[] Designco = request.getParameterValues("attach");
        try {

            for (int i = 0; i < descriptions.length; i++) {
                DeliverableMulti deliverableMulti = new DeliverableMulti();
                if (descriptions[i] == "") {

                } else {
                    deliverableMulti.setDescription(descriptions[i]);
                    deliverableMulti.setDesignCoordinator(Designco[i]);
                    deliverableMulti.setAocId(Integer.parseInt(id));
                    deliverableMulti.setFlagStatus(0);
                    deliverableMultiService.create(deliverableMulti);
                }
            }

        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        mv = DesignTeam(request, response);
        return mv;

    }

    public ModelAndView AllDeliverablepopupsubmitOap(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String today = dateFormat.format(new Date());

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String comment = request.getParameter("com");
        String fromdateTime = request.getParameter("fromdateTime");
        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));

        deliverableMulti.setFlagStatus(6);
        deliverableMultiService.update(deliverableMulti);

        DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
        designCordinatorComments.setComments(comment);
        designCordinatorComments.setAocId(0);
        designCordinatorComments.setOapId(Integer.parseInt(id));
        designCordinatorComments.setDeliverableId(Integer.parseInt(id1));
        designCordinatorComments.setUserId(username);
        designCordinatorComments.setDateTime(fromdateTime);

        designCordinatorComments.setFlagStatus(6);

        designCordinatorCommentsService.create(designCordinatorComments);

        mv.setViewName("forward:oapForm.htm?act=AllDeliverableViewOap&id=" + id1);
        return mv;

    }

    public ModelAndView AllDeliverablepopupsubmitAoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String comment = request.getParameter("com");
        String fromdateTime = request.getParameter("fromdateTime");
        DeliverableMulti deliverableMulti = deliverableMultiService.readById(Integer.parseInt(id));

        deliverableMulti.setFlagStatus(6);
        deliverableMultiService.update(deliverableMulti);

        DesignCordinatorComments designCordinatorComments = new DesignCordinatorComments();
        designCordinatorComments.setComments(comment);
        designCordinatorComments.setAocId(Integer.parseInt(id1));
        designCordinatorComments.setOapId(0);
        designCordinatorComments.setDeliverableId(Integer.parseInt(id));
        designCordinatorComments.setUserId(username);
        designCordinatorComments.setDateTime(fromdateTime);

        designCordinatorComments.setFlagStatus(6);

        designCordinatorCommentsService.create(designCordinatorComments);

        mv.setViewName("forward:oapForm.htm?act=AllDeliverableViewAoc&id=" + id1);
        return mv;

    }

    public ModelAndView oapFormDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username1 = user1.getLoginName();

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        int mainflag = oapForm.getFlagStatus();

        if (mainflag == 0) {
            oapForm.setFlagStatus(100);
            oapFormService.update(oapForm);
            session.setAttribute("successMessage", " OapFormSaveASDraftDeleted successfully");
            mv.setViewName("redirect:oapForm.htm?act=SaveAsDraftList");
        } else {
            oapForm.setFlagStatus(100);
            oapFormService.update(oapForm);
            session.setAttribute("successMessage", " OapFormDeleted successfully");
            mv.setViewName("redirect:oapForm.htm?act=oapFormAppovalList");

        }

        return mv;

    }

    public ModelAndView oapSaveAsDraft(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username1 = user1.getLoginName();

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
//	String documentNo = request.getParameter("documentNo");
        String pcsName = request.getParameter("pcsName");
        String date = request.getParameter("date");
        String documentRevisonNo = request.getParameter("documentRevisonNo");
        String projectName = request.getParameter("projectName");
        String city_highway = request.getParameter("city/highway");
        String pcsAddress = request.getParameter("pcsAddress");
        String pcsType1 = request.getParameter("pcsType1");
        if (pcsType1 == null) {
            pcsType1 = "0";
        } else {
            pcsType1 = "1";
        }

        String pcsType2 = request.getParameter("pcsType2");
        if (pcsType2 == null) {
            pcsType2 = "0";
        } else {
            pcsType2 = "1";
        }
        String pcsType3 = request.getParameter("pcsType3");
        if (pcsType3 == null) {
            pcsType3 = "0";
        } else {
            pcsType3 = "1";
        }
        String pcstypeother = request.getParameter("pcstypeother");
        if (pcstypeother == null) {
            pcstypeother = "";
        }
        String pcsModel = request.getParameter("pcsModel");
        if (pcsModel == null) {
            pcsModel = "0";
        } else {
            pcsModel = "1";
        }
        String pcsMode2 = request.getParameter("pcsMode2");
        if (pcsMode2 == null) {
            pcsMode2 = "0";
        } else {
            pcsMode2 = "1";
        }
        String pcsMode3 = request.getParameter("pcsMode3");
        if (pcsMode3 == null) {
            pcsMode3 = "0";
        } else {
            pcsMode3 = "1";
        }
        String pcsMode4 = request.getParameter("pcsMode4");
        if (pcsMode4 == null) {
            pcsMode4 = "0";
        } else {
            pcsMode4 = "1";
        }
        String pcsModelother = request.getParameter("pcsModelother");
        if (pcsModelother == null) {
            pcsModelother = "";
        }
        String pcscoordinates = request.getParameter("pcscoordinates");
        String mobileNo = request.getParameter("mobileNo");
        String email = request.getParameter("email");
        String alternatemobileNo = request.getParameter("alternatemobileNo");
        String clientDetails = request.getParameter("clientDetails");
        String clientRequiremts = request.getParameter("clientRequiremts");
        String clientscope = request.getParameter("clientscope");

        String salesName = request.getParameter("salesName");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String date1 = request.getParameter("date1");
//	String signature1 = request.getParameter("signature1");

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateTime = currentDateTime.format(formatter);
        Date date5 = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yy");
        String sysdate = sdf4.format(date5);
        Date date55 = new java.util.Date();
        SimpleDateFormat sdf5 = new SimpleDateFormat("MM");
        String sysdate1 = sdf5.format(date55);
        int month_frt = Integer.parseInt(sysdate1);
        int year_frt = Integer.parseInt(sysdate);

        DocumentMasterId documentMasterId = documentMasterIdService.readByDocumentNo();

        String meetingno = "0";
        meetingno = documentMasterId.getDocumentId();
        if (meetingno == null) {
            meetingno = "0";
        }

        int ten_no_int = 0;

        ten_no_int = Integer.parseInt(meetingno);

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

        String refNo = final_ten_no;
//	refNo = "OAP" + "-" + refNo;

        String f_year = refNo.substring(0, 2);
        String f_no = refNo.substring(2, 7);

        int f_y1 = Integer.parseInt(f_year);
        f_y1++;

        refNo = "OAP" + "-" + f_year + "" + f_y1 + "-" + f_no;

        String country = request.getParameter("country");
        String state5 = request.getParameter("state");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String houseno = request.getParameter("houseno");

        String chargeInstall1 = request.getParameter("chargeInstall1");
        if (chargeInstall1 == null) {
            chargeInstall1 = "0";
        } else {
            chargeInstall1 = "1";
        }
        String chargeInstall1qua = request.getParameter("chargeInstall1qua");
        if (chargeInstall1qua == null) {
            chargeInstall1qua = "";
        }
        String chargeInstall2 = request.getParameter("chargeInstall2");
        if (chargeInstall2 == null) {
            chargeInstall2 = "0";
        } else {
            chargeInstall2 = "1";
        }
        String chargeInstall2qua = request.getParameter("chargeInstall2qua");
        if (chargeInstall2qua == null) {
            chargeInstall2qua = "";
        }
        String chargeInstall3 = request.getParameter("chargeInstall3");
        if (chargeInstall3 == null) {
            chargeInstall3 = "0";
        } else {
            chargeInstall3 = "1";
        }
        String chargeInstall3qua = request.getParameter("chargeInstall3qua");
        if (chargeInstall3qua == null) {
            chargeInstall3qua = "";
        }
        String chargeInstall4 = request.getParameter("chargeInstall4");
        if (chargeInstall4 == null) {
            chargeInstall4 = "0";
        } else {
            chargeInstall4 = "1";
        }
        String chargeInstall4qua = request.getParameter("chargeInstall4qua");
        if (chargeInstall4qua == null) {
            chargeInstall4qua = "";
        }
        String chargeInstall5 = request.getParameter("chargeInstall5");
        if (chargeInstall5 == null) {
            chargeInstall5 = "0";
        } else {
            chargeInstall5 = "1";
        }
        String chargeInstall5qua = request.getParameter("chargeInstall5qua");
        if (chargeInstall5qua == null) {
            chargeInstall5qua = "";
        }
        String chargeInstall6 = request.getParameter("chargeInstall6");
        if (chargeInstall6 == null) {
            chargeInstall6 = "0";
        } else {
            chargeInstall6 = "1";
        }
        String chargeInstall6qua = request.getParameter("chargeInstall6qua");
        if (chargeInstall6qua == null) {
            chargeInstall6qua = "";
        }
        String chargeInstall7 = request.getParameter("chargeInstall7");
        if (chargeInstall7 == null) {
            chargeInstall7 = "0";
        } else {
            chargeInstall7 = "1";
        }
        String chargeInstall7qua = request.getParameter("chargeInstall7qua");
        if (chargeInstall7qua == null) {
            chargeInstall7qua = "";
        }
        String guns = request.getParameter("guns");
        String others = request.getParameter("others");

        String Fromdate = request.getParameter("Fromdate");
        String Todate = request.getParameter("Todate");
        String budgetallocated = request.getParameter("budgetallocated");
        String othersDetails = request.getParameter("othersDetails");

        String ProjectProfile = request.getParameter("ProjectProfile");
        String profitcenter = request.getParameter("profitcenter");
        String CompanyCode = request.getParameter("CompanyCode");
        String Plant = request.getParameter("Plant");
        String ProjectType = request.getParameter("ProjectType");
        String ProjectCurrency = request.getParameter("ProjectCurrency");
        String InvestmentProfile = request.getParameter("InvestmentProfile");
        String Discom = request.getParameter("Discom");
        String ChargePoints = request.getParameter("ChargePoints");
        String NoOfCharger = request.getParameter("NoOfCharger");
        String overallstations = request.getParameter("overallstations");
        String stationAc = request.getParameter("stationAc");
        String stationDc = request.getParameter("stationDc");
        String stationname = request.getParameter("stationname");
        String stationtype = request.getParameter("stationtype");
        String tenant = request.getParameter("tenant");
        String connectiontype = request.getParameter("connectiontype");
        String approvalName = request.getParameter("approvalName");
        String chargingrate = request.getParameter("chargingrate");
        OapMaster oapMaster = new OapMaster();
        if (approvalName != null && !approvalName.trim().isEmpty()) {
            oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
        } else {
            oapMaster = new OapMaster();
        }

        String sitesurvey = request.getParameter("sitesurvey");
        String Survey = request.getParameter("Survey");
        if ("siteSurveynotcreated".equals(Survey)) {
            Survey = "0";
        } else if ("siteSurveycreated".equals(Survey)) {
            Survey = "1";
        } else {
            Survey = "2";
        }

        String projectTimelineCategory = request.getParameter("projectTimelineCategory");
        String totalKwRating = request.getParameter("totalKwRating");
        String specificDateFromClient = request.getParameter("specificDateFromClient");
        if (specificDateFromClient == null) {
            specificDateFromClient = "";
        }
        String totalChargerCapacity = request.getParameter("totalChargerCapacity");
        String chargerStationAccessType = request.getParameter("chargerStationAccessType");
        String auxiliaryLoadOfStation = request.getParameter("auxiliaryLoadOfStation");
        if (auxiliaryLoadOfStation == null) {
            auxiliaryLoadOfStation = "";
        }
        String chargingRetePerUnit = request.getParameter("chargingRetePerUnit");
        String noOfEvsToBeChanged = request.getParameter("noOfEvsToBeChanged");
        String chargeInstall8qua = request.getParameter("chargeInstall8qua");
        if (chargeInstall8qua == null) {
            chargeInstall8qua = "";
        }

        String chargeInstall8 = request.getParameter("chargeInstall8");
        if (chargeInstall8 == null) {
            chargeInstall8 = "0";
        } else {
            chargeInstall8 = "1";
        }
        String chargeInstall9qua = request.getParameter("chargeInstall9qua");
        if (chargeInstall9qua == null) {
            chargeInstall9qua = "";
        }
        String chargeInstall9 = request.getParameter("chargeInstall9");
        if (chargeInstall9 == null) {
            chargeInstall9 = "0";
        } else {
            chargeInstall9 = "1";
        }

        String anchoreCustomer = request.getParameter("anchoreCustomer");
        String canopyVarient = request.getParameter("canopyVarient");
        if (canopyVarient == null) {
            canopyVarient = "";
        }
        String scopeofChargeZone = request.getParameter("scopeofChargeZone");
        String totalMW = request.getParameter("totalMW");

        OapForm oapForm = new OapForm();

        oapForm.setDocumentNo(refNo);
        oapForm.setPcsName(pcsName);
        oapForm.setDate(date);
        oapForm.setDocumentRevisionNo("R0");
        oapForm.setProjectName(projectName);
        oapForm.setPcsCityHighway(city_highway);
        oapForm.setPcsAddress(pcsAddress);
        oapForm.setPcsTypeCity(pcsType1);
        oapForm.setPcsTypeHighway(pcsType2);
        oapForm.setPcsTypeOtherCheck(pcsType3);
        oapForm.setPcsTypeOther(pcstypeother);
        oapForm.setPcsModelDoco(pcsModel);
        oapForm.setPcsModelCoco(pcsMode2);
        oapForm.setPcsModelDodo(pcsMode3);
        oapForm.setPcsModelOtherCheck(pcsMode4);
        oapForm.setPcsModelOther(pcsModelother);
        oapForm.setPcsCoordinates(pcscoordinates);
        oapForm.setMobileNo(mobileNo);
        oapForm.setEmail(email);
        oapForm.setAlternateMobileNo(alternatemobileNo);
        oapForm.setClientDetails(clientDetails);
        oapForm.setSpecificRequriementsClients(clientRequiremts);
        oapForm.setClientScope(clientscope);
        oapForm.setSalesLeadName(salesName);
        oapForm.setDepartment(department);
        oapForm.setDesignation(designation);
        oapForm.setSalesDate(date1);
        oapForm.setSignature("notrequired");

        oapForm.setKwAc77(chargeInstall1);
        oapForm.setKwAcQuatity77(chargeInstall1qua);
        oapForm.setKwDc15(chargeInstall2);
        oapForm.setKwDcQuatity15(chargeInstall2qua);
        oapForm.setKwDc30(chargeInstall3);
        oapForm.setKwDcQuatity30(chargeInstall3qua);
        oapForm.setKwDc60(chargeInstall4);
        oapForm.setKwDcQuatity60(chargeInstall4qua);
        oapForm.setKwDc120(chargeInstall5);
        oapForm.setKwDcQuatity120(chargeInstall5qua);

        oapForm.setKwDc180(chargeInstall6);
        oapForm.setKwDcQuatity180(chargeInstall6qua);
        oapForm.setKw240(chargeInstall7);
        oapForm.setKwQuatity240(chargeInstall7qua);

        oapForm.setNoOfGuns(guns);
        oapForm.setOthers(others);
        oapForm.setTimeLineFromDate(Fromdate);
        oapForm.setTimeLineToDate(Todate);
        oapForm.setProjectBudgetAllocated(budgetallocated);
        oapForm.setOthersDetails(othersDetails);

        oapForm.setOapMaster(oapMaster);
        oapForm.setCreatedDate(Fromdate);
        oapForm.setUserId(username1);
        oapForm.setCreatedDate(today);
        oapForm.setFlagStatus(0);
        oapForm.setAssignedName("");

        oapForm.setState(state5);
        oapForm.setCountry(country);
        oapForm.setCity(city);
        oapForm.setDistrict(district);
        oapForm.setHouseNo(houseno);
        oapForm.setProjectCoordinater("");
        oapForm.setComment("");
        oapForm.setProjectProfile(ProjectProfile);
        oapForm.setProjectCenter(profitcenter);
        oapForm.setCompanyCode(CompanyCode);
        oapForm.setPlant(Plant);
        oapForm.setProjectType(ProjectType);
        oapForm.setProjectCurrency(ProjectCurrency);
        oapForm.setInverstmentProfile(InvestmentProfile);
        oapForm.setDiscom(Discom);
        oapForm.setNoOfChargePoints(ChargePoints);
        oapForm.setNoOfCharger(NoOfCharger);
        oapForm.setOverallStationCapacityKw(overallstations);
        oapForm.setStationAcCapacityKw(stationAc);
        oapForm.setStationDcCapacityKw(stationDc);
        oapForm.setStationName(stationname);
        oapForm.setStationType(stationtype);
        oapForm.setTenant(tenant);
        oapForm.setConnectionType(connectiontype);
        oapForm.setChargingRatePerUnit(chargingrate);
        oapForm.setSiteSurvey(sitesurvey);
        oapForm.setApprovedBy("");
        oapForm.setApprovedDate("");
        oapForm.setCrcAssignedBy("");
        oapForm.setCrcAssignedDate("");
        oapForm.setCrcCreatedDate("");
        oapForm.setCrcApprovedBy("");
        oapForm.setCrcApprovedDate("");
        oapForm.setSurveyRadio(Integer.parseInt(Survey));
        documentMasterId.setDocumentId(final_ten_no);

        oapForm.setProjectTimelineCategory(projectTimelineCategory);
        oapForm.setTotalKwRating(totalKwRating);
        oapForm.setSpecificDateFromClient(specificDateFromClient);
        oapForm.setTotalChargerCapacity(totalChargerCapacity);
        oapForm.setChargerStationAccessType(chargerStationAccessType);
        oapForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
        oapForm.setChargingRetePerUnit(chargingRetePerUnit);
        oapForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
        oapForm.setKw360(chargeInstall8);
        oapForm.setKwQuatity360(chargeInstall8qua);
        oapForm.setKw720(chargeInstall9);
        oapForm.setKwQuatity720(chargeInstall9qua);
        oapForm.setAnchoreCustomer(anchoreCustomer);
        oapForm.setCanopyVarient(canopyVarient);
        oapForm.setScopeOfchargeZone(scopeofChargeZone);
        oapForm.setTotalMegaWatt(totalMW);

        oapFormService.create(oapForm);
        documentMasterIdService.create(documentMasterId);
        int id = oapForm.getId();

        String[] chargerType = request.getParameterValues("chargerType");
        String[] charger = request.getParameterValues("charger");
        String[] chargerOther = request.getParameterValues("chargerOther");
        String[] chargerCapacityKW = request.getParameterValues("chargerCapacityKW");
        String[] chargermodel = request.getParameterValues("chargermodel");
        String[] connectorType = request.getParameterValues("connectorType");
        String[] connectorOther = request.getParameterValues("connectorOther");
        String[] noofconnectors = request.getParameterValues("noofconnectors");
        String[] noofchargers = request.getParameterValues("noofchargers");
        String[] chargingrateperunit = request.getParameterValues("chargingrateperunit");

        for (int ct = 0; ct < chargerType.length; ct++) {
            String c = chargerType[ct];

            if (c != null && !c.isEmpty()) {
                ChargerInstallationDetails cid = new ChargerInstallationDetails();

                cid.setOapId(id);
                cid.setChargerType(chargerType[ct]);
                cid.setCharger(charger[ct]);
                cid.setChargerOther(chargerOther[ct]);
                cid.setChargerCapacityKW(chargerCapacityKW[ct]);
                cid.setChargermodel(chargermodel[ct]);
                cid.setConnectorType(connectorType[ct]);
                cid.setConnectorTypeOther(connectorOther[ct]);
                cid.setNoofconnectors(noofconnectors[ct]);
                cid.setNoofchargers(noofchargers[ct]);
                cid.setChargingrateperunit(chargingrateperunit[ct]);

                chargerInstallationDetailsService.create(cid);

            }
        }

        OapForm oapForm1 = oapFormService.readById(id);

//        Agreement/LOA
        String pcsDelivery1 = request.getParameter("pcsDelivery1");
        if (pcsDelivery1 == null) {
            pcsDelivery1 = "0";
        } else {
            pcsDelivery1 = "1";
        }
        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile attachment1File = multipartRequest1.getFile("attachment1File");

        String attachment1FileName = "";
        if (attachment1File != null && !attachment1File.isEmpty()) {
            attachment1FileName = attachment1File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm1.getId() + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment1FileName);
            attachment1File.transferTo(destinationFile);
        }

//         Ownership Document
        String pcsDelivery2 = request.getParameter("pcsDelivery2");
        if (pcsDelivery2 == null) {
            pcsDelivery2 = "0";
        } else {
            pcsDelivery2 = "1";
        }
        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile attachment2File = multipartRequest2.getFile("attachment2File");
        String attachment2FileName = "";
        if (attachment2File != null && !attachment2File.isEmpty()) {
            attachment2FileName = attachment2File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm1.getId() + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment2FileName);
            attachment2File.transferTo(destinationFile);
        }
//Preliminary Site Survey
        String pcsDelivery3 = request.getParameter("pcsDelivery3");
        if (pcsDelivery3 == null) {
            pcsDelivery3 = "0";
        } else {
            pcsDelivery3 = "1";
        }
        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile attachment3File = multipartRequest3.getFile("attachment3File");
        String attachment3FileName = "";
        if (attachment3File != null && !attachment3File.isEmpty()) {
            attachment3FileName = attachment3File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm1.getId() + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment3FileName);
            attachment3File.transferTo(destinationFile);
        }
//Consent Letter/NOC
        String pcsDelivery4 = request.getParameter("pcsDelivery4");
        if (pcsDelivery4 == null) {
            pcsDelivery4 = "0";
        } else {
            pcsDelivery4 = "1";
        }
        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile attachment4File = multipartRequest4.getFile("attachment4File");
        String attachment4FileName = "";
        if (attachment4File != null && !attachment4File.isEmpty()) {
            attachment4FileName = attachment4File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + oapForm1.getId() + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment4FileName);
            attachment4File.transferTo(destinationFile);
        }

        oapForm1.setAgreementLoa(pcsDelivery1);
        oapForm1.setOwnerShipDocument(pcsDelivery2);
        oapForm1.setPreliminarySiteSurvey(pcsDelivery3);
        oapForm1.setConsentLetterNoc(pcsDelivery4);
        oapForm1.setAggrementAttach(attachment1FileName);
        oapForm1.setOwnershipAttach(attachment2FileName);
        oapForm1.setPreliminaryAttach(attachment3FileName);
        oapForm1.setConsentAttach(attachment4FileName);

        oapFormService.update(oapForm1);

        String documentno = oapForm.getDocumentNo();
        String mainusername = oapForm.getUserId();
        String mailcreteddate = oapForm.getCreatedDate();

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");
        int b = 0;

        for (String s : surveyNo) {
            if (s != null && !s.isEmpty()) {
                OapSurveyAttachment oapSurveyAttachment = new OapSurveyAttachment();
                oapSurveyAttachment.setSurveyNo(surveyNo[b]);
                oapSurveyAttachment.setOapId(id);
                oapSurveyAttachment.setProjectRepresentative(projectRepresentative[b]);
                oapSurveyAttachmentService.create(oapSurveyAttachment);

                b++;
            }
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

// Get all uploaded files
        List<MultipartFile> files = multipartRequest.getFiles("attchment");
        String[] id1 = request.getParameterValues("id");
        String[] descriptions = request.getParameterValues("descriptiones");
        int i = 0;
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP"
                            + File.separator + id + File.separator;

                    // Create the directory if it doesn't exist
                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    DocumentName documentName = documentNameService.readById(Integer.parseInt(id1[i]));

                    // Save the file
                    File destinationFile = new File(fileLocationURL + file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    file.transferTo(destinationFile);

                    // Create the attachment object and save it
                    OapDocumentAttachment oapDocumentAttachment = new OapDocumentAttachment();
                    oapDocumentAttachment.setAttachment(file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    oapDocumentAttachment.setOapForm(oapForm1);
                    oapDocumentAttachment.setDescription(descriptions[i]);

                    oapDocumentAttachment.setDocumentName(documentName);

                    oapDocumentAttachmentService.create(oapDocumentAttachment);
                    i++;
                }
            }
        }

        // multi attachment
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + id;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP"
                            + File.separator + id + File.separator;

                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs(); // Create the directory if it doesn't exist
                    }

                    File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    try {
                        file1.transferTo(destinationFile1); // Ensure proper exception handling
                    } catch (Exception e) {
                        e.printStackTrace(); // Handle the error or log it
                    }

                    OapMultiAttachment oapMultiAttachment = new OapMultiAttachment();

                    oapMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    oapMultiAttachment.setDescription(description[a]);
                    oapMultiAttachment.setOapForm(oapForm1);

                    oapMultiAttachmentService.create(oapMultiAttachment);
                    a++;
                }
            }

        }

        // approval name drop down relted code
        List approval_list = oapMasterUserService.readByIdToList(approvalName);
        HttpSession session1 = request.getSession(false);
        UserMaster user = (UserMaster) session1.getAttribute("user");
        String username = user.getLoginName();
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        OapFormApproval oapFormApproval = new OapFormApproval();
        oapFormApproval.setOapForm(oapForm1);
        oapFormApproval.setTotalApproval(approval_list.size() + "");
        oapFormApproval.setApprovalStatus("0");
        oapFormApproval.setApprovalRemark("add");
        oapFormApproval.setUserId(employeeCode);
        oapFormApproval.setCurrentApproval("1");
        oapFormApprovalService.create(oapFormApproval);

        int approveId = oapFormApproval.getId();
        OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

        int j = 0;

        for (Object o : approval_list) {
            j++;
            OapMasterUser oap1 = (OapMasterUser) o;
            OapFormApprovalUser oap = new OapFormApprovalUser();
            oap.setOapFormApproval(approveId);
            oap.setOapForm(id);
            oap.setUserId(oap1.getUserId());
            oap.setLevel("1");
            oap.setApprovalStatus("0");
            oapFormApprovalUserService.create(oap);

        }
        OapLogMaster oapLogMaster = new OapLogMaster();
        oapLogMaster.setActivity("OAP Created");
        oapLogMaster.setActivityBy(username1);
        oapLogMaster.setDate(currentDateTime5);
        oapLogMaster.setComments("");
        oapLogMaster.setStatus("Created");
        oapLogMaster.setOapId(id);
        oapLogMasterService.create(oapLogMaster);

        session.setAttribute("successMessage", " OAPForm SaveAsDraft Done successfully");
        mv.setViewName("redirect:oapForm.htm?act=oapFormAppovalList");
        return mv;

    }

    public ModelAndView SaveAsDraftList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username = user1.getLoginName();

        if (session1 != null) {
            String successMessage = (String) session1.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session1.removeAttribute("successMessage"); // clean up after showing
            }
        }
        List list = oapFormService.readByflagstatuszero(username);

        mv.getModelMap().put("list", list);

        mv.setViewName("Oap/SaveAsDraftList");
        return mv;

    }

    public ModelAndView SaveAsDraftView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));
        List oapSurveyAttch = oapSurveyAttachmentService.readByoapId(id);
        int size = oapSurveyAttch.size();
        String plant = oapForm.getPlant();
        String Tenant = oapForm.getTenant();
        String StationType = oapForm.getStationType();
        String Currency = oapForm.getProjectCurrency();
        String ProjectType = oapForm.getProjectType();
        String Ivestmentprofile = oapForm.getInverstmentProfile();
        String ProjectCenter = oapForm.getProjectCenter();
        String CompanyCode = oapForm.getCompanyCode();
        String ProjectProfile = oapForm.getProjectProfile();
        String Discom = oapForm.getDiscom();
        String projectname = oapForm.getProjectName();
        String connectiontype = oapForm.getConnectionType();
        String name = oapForm.getAnchoreCustomer();
        String names = oapForm.getCanopyVarient();

        String state = oapForm.getState();
        mv.getModelMap().put("projectname", projectname);

        mv.getModelMap().put("Discom", Discom);
        mv.getModelMap().put("ProjectProfile", ProjectProfile);
        mv.getModelMap().put("CompanyCode", CompanyCode);
        mv.getModelMap().put("ProjectCenter", ProjectCenter);
        mv.getModelMap().put("Ivestmentprofile", Ivestmentprofile);
        mv.getModelMap().put("ProjectType", ProjectType);
        mv.getModelMap().put("Currency", Currency);
        mv.getModelMap().put("StationType", StationType);
        mv.getModelMap().put("Tenant", Tenant);
        mv.getModelMap().put("plant", plant);
        mv.getModelMap().put("connectiontype", connectiontype);
        mv.getModelMap().put("name", name);
        mv.getModelMap().put("names", names);
        int oapmasterId = 0;
        OapMaster oapMaster = oapForm.getOapMaster();
        if (oapMaster != null && !oapMaster.equals("")) {
            oapmasterId = oapForm.getOapMaster().getId();
        }
        List list = oapDocumentAttachmentService.readByattach(id);
        List list33 = oapMultiAttachmentService.readByMulti(id);
        List list10 = oapMasterService.read();
        List list0 = tenantService.read();
        List list2 = stationTypeService.read();
        List list3 = currencyMasterService.read();
        List list4 = projectTypeService.read();
        List list6 = investmentProfileService.read();
        List list7 = profitCenterService.read();
        List list8 = plantMastersService.read();
        List list9 = companyMasterService.read();
        List list11 = projectProfileService.read();
        List list12 = discomMasterService.readByStateName(state);
        List list13 = projectNameMasterService.read();
        List list17 = chargerTypeService.read();
        List list18 = chargerMasterService.read();
        List list19 = connectorTypeService.read();

        List chargeInst = chargerInstallationDetailsService.readByoapId(id);

        int chargeInstcount = chargeInst.size();

        String discom = oapForm.getDiscom();
        DiscomMaster discomMaster = new DiscomMaster();
        if (discom != null && !discom.equals("")) {
            discomMaster = discomMasterService.readById(Integer.parseInt(discom));
            String Discom1 = discomMaster.getDiscomType();
            mv.getModelMap().put("Discom1", Discom1);
        }

        String connectionType = oapForm.getConnectionType();
        ConnectionType connectionType1 = new ConnectionType();
        if (connectionType != null && !connectionType.equals("")) {
            connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
            String connection = connectionType1.getConnectionType();

            mv.getModelMap().put("connection", connection);
        }

        List list14 = connectionTypeService.read();

        List list15 = anchorCustomerService.read();
        List list16 = canopyVarientService.read();

        request.setAttribute("list0", list0);
        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);
        request.setAttribute("list4", list4);
        request.setAttribute("list6", list6);
        request.setAttribute("list7", list7);
        request.setAttribute("list8", list8);
        request.setAttribute("list9", list9);
        request.setAttribute("list11", list11);
        request.setAttribute("list12", list12);
        mv.getModelMap().put("oapForm", oapForm);
        request.setAttribute("list13", list13);
        request.setAttribute("list14", list14);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("oapmasterId", oapmasterId);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("oapSurveyAttch", oapSurveyAttch);
        mv.getModelMap().put("size", size);
        mv.getModelMap().put("discom", discom);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list15", list15);
        mv.getModelMap().put("list16", list16);
        mv.getModelMap().put("list17", list17);
        mv.getModelMap().put("list18", list18);
        mv.getModelMap().put("list19", list19);
        mv.getModelMap().put("chargeInst", chargeInst);
        mv.getModelMap().put("chargeInstcount", chargeInstcount);
        mv.setViewName("Oap/SaveAsDraftView");
        return mv;

    }

    public ModelAndView SaveAsDraftViewSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username1 = user1.getLoginName();
        String id = request.getParameter("id");

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        String documentNo = request.getParameter("documentNo");
        String pcsName = request.getParameter("pcsName");
        String date = request.getParameter("date");
        String documentRevisonNo = request.getParameter("documentRevisonNo");
        String projectName = request.getParameter("projectName");
        String city_highway = request.getParameter("city/highway");
        String pcsAddress = request.getParameter("pcsAddress");
        String pcsType1 = request.getParameter("pcsType1");
        if (pcsType1 == null) {
            pcsType1 = "0";
        } else {
            pcsType1 = "1";
        }
        String pcsType2 = request.getParameter("pcsType2");
        if (pcsType2 == null) {
            pcsType2 = "0";
        } else {
            pcsType2 = "1";
        }
        String pcsType3 = request.getParameter("pcsType3");
        if (pcsType3 == null) {
            pcsType3 = "0";
        } else {
            pcsType3 = "1";
        }
        String pcstypeother = request.getParameter("pcstypeother");
        if (pcstypeother == null) {
            pcstypeother = "";
        }
        String pcsModel = request.getParameter("pcsModel");
        if (pcsModel == null) {
            pcsModel = "0";
        } else {
            pcsModel = "1";
        }
        String pcsMode2 = request.getParameter("pcsMode2");
        if (pcsMode2 == null) {
            pcsMode2 = "0";
        } else {
            pcsMode2 = "1";
        }
        String pcsMode3 = request.getParameter("pcsMode3");
        if (pcsMode3 == null) {
            pcsMode3 = "0";
        } else {
            pcsMode3 = "1";
        }
        String pcsMode5 = request.getParameter("pcsMode5");
        if (pcsMode5 == null) {
            pcsMode5 = "0";
        } else {
            pcsMode5 = "1";
        }
        String pcsMode4 = request.getParameter("pcsMode4");
        if (pcsMode4 == null) {
            pcsMode4 = "0";
        } else {
            pcsMode4 = "1";
        }
        String pcsModelother = request.getParameter("pcsModelother");
        if (pcsModelother == null) {
            pcsModelother = "";
        }
        String pcscoordinates = request.getParameter("pcscoordinates");
        String mobileNo = request.getParameter("mobileNo");
        String email = request.getParameter("email");
        String alternatemobileNo = request.getParameter("alternatemobileNo");
        String clientDetails = request.getParameter("clientDetails");
        String clientRequiremts = request.getParameter("clientRequiremts");
        String scope = request.getParameter("scope");
        String salesName = request.getParameter("salesName");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String date1 = request.getParameter("date1");
        String signature1 = request.getParameter("signature1");

        String pcsDelivery1 = request.getParameter("pcsDelivery1");
        if (pcsDelivery1 == null) {
            pcsDelivery1 = "0";
        }

        String attachment1File1 = request.getParameter("attachment1File1");

        if (pcsDelivery1.equals("0")) {
            attachment1File1 = "";
        }

        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile attachment1File = multipartRequest1.getFile("attachment1File");

        String attachment1FileName = "";
        if (attachment1File != null && !attachment1File.isEmpty()) {
            attachment1FileName = attachment1File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + id + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment1FileName);
            attachment1File.transferTo(destinationFile);
        }
        if (attachment1FileName.equals("") || attachment1FileName == "") {
            attachment1FileName = attachment1File1;
        }

        String pcsDelivery2 = request.getParameter("pcsDelivery2");
        if (pcsDelivery2 == null) {
            pcsDelivery2 = "0";
        }
        String attachment2File2 = request.getParameter("attachment2File2");

        if (pcsDelivery2.equals("0")) {
            attachment2File2 = "";
        }

        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile attachment2File = multipartRequest2.getFile("attachment2File");
        String attachment2FileName = "";
        if (attachment2File != null && !attachment2File.isEmpty()) {
            attachment2FileName = attachment2File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + id + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment2FileName);
            attachment2File.transferTo(destinationFile);
        }
        if (attachment2FileName.equals("") || attachment2FileName == "") {
            attachment2FileName = attachment2File2;
        }

        String pcsDelivery3 = request.getParameter("pcsDelivery3");
        if (pcsDelivery3 == null) {
            pcsDelivery3 = "0";
        }
        String attachment3File3 = request.getParameter("attachment3File3");

        if (pcsDelivery3.equals("0")) {
            attachment3File3 = "";
        }

        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile attachment3File = multipartRequest3.getFile("attachment3File");
        String attachment3FileName = "";
        if (attachment3File != null && !attachment3File.isEmpty()) {
            attachment3FileName = attachment3File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + id + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment3FileName);
            attachment3File.transferTo(destinationFile);
        }
        if (attachment3FileName.equals("") || attachment3FileName == "") {
            attachment3FileName = attachment3File3;
        }

        String pcsDelivery4 = request.getParameter("pcsDelivery4");
        if (pcsDelivery4 == null) {
            pcsDelivery4 = "0";
        }
        String attachment4File4 = request.getParameter("attachment4File4");

        if (pcsDelivery4.equals("0")) {
            attachment4File4 = "";
        }

        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile attachment4File = multipartRequest4.getFile("attachment4File");
        String attachment4FileName = "";
        if (attachment4File != null && !attachment4File.isEmpty()) {
            attachment4FileName = attachment4File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + id + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment4FileName);
            attachment4File.transferTo(destinationFile);
        }
        if (attachment4FileName.equals("") || attachment4FileName == "") {
            attachment4FileName = attachment4File4;
        }

        String chargeInstall1 = request.getParameter("chargeInstall1");
        if (chargeInstall1 == null) {
            chargeInstall1 = "0";
        } else {
            chargeInstall1 = "1";
        }
        String chargeInstall1qua = request.getParameter("chargeInstall1qua");
        if (chargeInstall1qua == null) {
            chargeInstall1qua = "";
        }
        String chargeInstall2 = request.getParameter("chargeInstall2");
        if (chargeInstall2 == null) {
            chargeInstall2 = "0";
        } else {
            chargeInstall2 = "1";
        }
        String chargeInstall2qua = request.getParameter("chargeInstall2qua");
        if (chargeInstall2qua == null) {
            chargeInstall2qua = "";
        }
        String chargeInstall3 = request.getParameter("chargeInstall3");
        if (chargeInstall3 == null) {
            chargeInstall3 = "0";
        } else {
            chargeInstall3 = "1";
        }
        String chargeInstall3qua = request.getParameter("chargeInstall3qua");
        if (chargeInstall3qua == null) {
            chargeInstall3qua = "";
        }
        String chargeInstall4 = request.getParameter("chargeInstall4");
        if (chargeInstall4 == null) {
            chargeInstall4 = "0";
        } else {
            chargeInstall4 = "1";
        }
        String chargeInstall4qua = request.getParameter("chargeInstall4qua");
        if (chargeInstall4qua == null) {
            chargeInstall4qua = "";
        }
        String chargeInstall5 = request.getParameter("chargeInstall5");
        if (chargeInstall5 == null) {
            chargeInstall5 = "0";
        } else {
            chargeInstall5 = "1";
        }
        String chargeInstall5qua = request.getParameter("chargeInstall5qua");
        if (chargeInstall5qua == null) {
            chargeInstall5qua = "";
        }
        String chargeInstall6 = request.getParameter("chargeInstall6");
        if (chargeInstall6 == null) {
            chargeInstall6 = "0";
        } else {
            chargeInstall6 = "1";
        }
        String chargeInstall6qua = request.getParameter("chargeInstall6qua");
        if (chargeInstall6qua == null) {
            chargeInstall6qua = "";
        }
        String chargeInstall7 = request.getParameter("chargeInstall7");
        if (chargeInstall7 == null) {
            chargeInstall7 = "0";
        } else {
            chargeInstall7 = "1";
        }
        String chargeInstall7qua = request.getParameter("chargeInstall7qua");
        if (chargeInstall7qua == null) {
            chargeInstall7qua = "";
        }

        String guns = request.getParameter("guns");
        String others = request.getParameter("others");
        String Fromdate = request.getParameter("Fromdate");
        String Todate = request.getParameter("Todate");
        String budgetallocated = request.getParameter("budgetallocated");
        String othersDetails = request.getParameter("othersDetails");
        String approvalName = request.getParameter("approvalName");

        String country = request.getParameter("country");
        String state5 = request.getParameter("state");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String houseno = request.getParameter("houseno");
        String ProjectProfile = request.getParameter("ProjectProfile");
        String profitcenter = request.getParameter("profitcenter");
        String CompanyCode = request.getParameter("CompanyCode");
        String Plant = request.getParameter("plant");
        String ProjectType = request.getParameter("ProjectType");
        String ProjectCurrency = request.getParameter("ProjectCurrency");
        String InvestmentProfile = request.getParameter("InvestmentProfile");
        String Discom = request.getParameter("Discom");
        String ChargePoints = request.getParameter("ChargePoints");
        String NoOfCharger = request.getParameter("NoOfCharger");
        String overallstations = request.getParameter("overallstations");
        String stationAc = request.getParameter("stationAc");
        String stationDc = request.getParameter("stationDc");
        String stationname = request.getParameter("stationname");
        String stationtype = request.getParameter("stationtype");
        String tenant = request.getParameter("tenant");
        String chargingrate = request.getParameter("chargingrate");
        String connectiontype = request.getParameter("connectiontype");
        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
        String sitesurvey = request.getParameter("sitesurvey");
        String Survey = request.getParameter("Survey");
        if ("siteSurveynotcreated".equals(Survey)) {
            Survey = "0";
        } else {
            Survey = "1";
        }

        String projectTimelineCategory = request.getParameter("projectTimelineCategory");
        String totalKwRating = request.getParameter("totalKwRating");
        String specificDateFromClient = request.getParameter("specificDateFromClient");
        if (specificDateFromClient == null) {
            specificDateFromClient = "";
        }
        String totalChargerCapacity = request.getParameter("totalChargerCapacity");
        String chargerStationAccessType = request.getParameter("chargerStationAccessType");
        String auxiliaryLoadOfStation = request.getParameter("auxiliaryLoadOfStation");
        if (auxiliaryLoadOfStation == null) {
            auxiliaryLoadOfStation = "";
        }
        String chargingRetePerUnit = request.getParameter("chargingRetePerUnit");
        String noOfEvsToBeChanged = request.getParameter("noOfEvsToBeChanged");
        String chargeInstall8qua = request.getParameter("chargeInstall8qua");
        if (chargeInstall8qua == null) {
            chargeInstall8qua = "";
        }

        String chargeInstall8 = request.getParameter("chargeInstall8");
        if (chargeInstall8 == null) {
            chargeInstall8 = "0";
        } else {
            chargeInstall8 = "1";
        }
        String chargeInstall9qua = request.getParameter("chargeInstall9qua");
        if (chargeInstall9qua == null) {
            chargeInstall9qua = "";
        }
        String chargeInstall9 = request.getParameter("chargeInstall9");
        if (chargeInstall9 == null) {
            chargeInstall9 = "0";
        } else {
            chargeInstall9 = "1";
        }

        String anchoreCustomer = request.getParameter("anchoreCustomer");
        String canopyVarient = request.getParameter("canopyVarient");
        if (canopyVarient == null) {
            canopyVarient = "";
        }
        String scopeofChargeZone = request.getParameter("scopeofChargeZone");
        String totalMW = request.getParameter("totalMW");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id));

        oapForm.setDocumentNo(documentNo);
        oapForm.setPcsName(pcsName);
        oapForm.setDate(date);
        oapForm.setProjectName(projectName);
        oapForm.setPcsCityHighway(city_highway);
        oapForm.setPcsAddress(pcsAddress);
        oapForm.setPcsTypeCity(pcsType1);
        oapForm.setPcsTypeHighway(pcsType2);
        oapForm.setPcsTypeOtherCheck(pcsType3);
        oapForm.setPcsTypeOther(pcstypeother);
        oapForm.setPcsModelDoco(pcsModel);
        oapForm.setPcsModelCoco(pcsMode2);
        oapForm.setPcsModelDodo(pcsMode3);
        oapForm.setPcsModelSaas(pcsMode5);
        oapForm.setPcsModelOtherCheck(pcsMode4);
        oapForm.setPcsModelOther(pcsModelother);
        oapForm.setPcsCoordinates(pcscoordinates);
        oapForm.setMobileNo(mobileNo);
        oapForm.setEmail(email);
        oapForm.setAlternateMobileNo(alternatemobileNo);
        oapForm.setClientDetails(clientDetails);
        oapForm.setSpecificRequriementsClients(clientRequiremts);
        oapForm.setClientScope(scope);
        oapForm.setSalesLeadName(salesName);
        oapForm.setDepartment(department);
        oapForm.setDesignation(designation);
        oapForm.setSalesDate(date1);
        oapForm.setSignature("");
        oapForm.setAgreementLoa(pcsDelivery1);
        oapForm.setOwnerShipDocument(pcsDelivery2);
        oapForm.setPreliminarySiteSurvey(pcsDelivery3);
        oapForm.setConsentLetterNoc(pcsDelivery4);
        oapForm.setKwAc77(chargeInstall1);
        oapForm.setKwAcQuatity77(chargeInstall1qua);
        oapForm.setKwDc15(chargeInstall2);
        oapForm.setKwDcQuatity15(chargeInstall2qua);
        oapForm.setKwDc30(chargeInstall3);
        oapForm.setKwDcQuatity30(chargeInstall3qua);
        oapForm.setKwDc60(chargeInstall4);
        oapForm.setKwDcQuatity60(chargeInstall4qua);
        oapForm.setKwDc120(chargeInstall5);
        oapForm.setKwDcQuatity120(chargeInstall5qua);
        oapForm.setKwDc180(chargeInstall6);
        oapForm.setKwDcQuatity180(chargeInstall6qua);
        oapForm.setKw240(chargeInstall7);
        oapForm.setKwQuatity240(chargeInstall7qua);
        oapForm.setNoOfGuns(guns);
        oapForm.setOthers(others);
        oapForm.setTimeLineFromDate(Fromdate);
        oapForm.setTimeLineToDate(Todate);
        oapForm.setProjectBudgetAllocated(budgetallocated);
        oapForm.setOthersDetails(othersDetails);
        oapForm.setOapMaster(oapMaster);
        oapForm.setCreatedDate(Fromdate);
        oapForm.setUserId(username1);
        oapForm.setCreatedDate(today);
        oapForm.setFlagStatus(1);
        oapForm.setAggrementAttach(attachment1FileName);
        oapForm.setOwnershipAttach(attachment2FileName);
        oapForm.setPreliminaryAttach(attachment3FileName);
        oapForm.setConsentAttach(attachment4FileName);
        oapForm.setState(state5);
        oapForm.setCountry(country);
        oapForm.setCity(city);
        oapForm.setDistrict(district);
        oapForm.setHouseNo(houseno);
        oapForm.setProjectProfile(ProjectProfile);
        oapForm.setProjectCenter(profitcenter);
        oapForm.setCompanyCode(CompanyCode);
        oapForm.setPlant(Plant);
        oapForm.setProjectType(ProjectType);
        oapForm.setProjectCurrency(ProjectCurrency);
        oapForm.setInverstmentProfile(InvestmentProfile);
        oapForm.setDiscom(Discom);
        oapForm.setNoOfChargePoints(ChargePoints);
        oapForm.setNoOfCharger(NoOfCharger);
        oapForm.setOverallStationCapacityKw(overallstations);
        oapForm.setStationAcCapacityKw(stationAc);
        oapForm.setStationDcCapacityKw(stationDc);
        oapForm.setStationName(stationname);
        oapForm.setStationType(stationtype);
        oapForm.setTenant(tenant);
        oapForm.setChargingRatePerUnit(chargingrate);
        oapForm.setSiteSurvey(sitesurvey);
        oapForm.setSurveyRadio(Integer.parseInt(Survey));
        oapForm.setConnectionType(connectiontype);
        oapForm.setProjectTimelineCategory(projectTimelineCategory);
        oapForm.setTotalKwRating(totalKwRating);
        oapForm.setSpecificDateFromClient(specificDateFromClient);
        oapForm.setTotalChargerCapacity(totalChargerCapacity);
        oapForm.setChargerStationAccessType(chargerStationAccessType);
        oapForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
        oapForm.setChargingRetePerUnit(chargingRetePerUnit);
        oapForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
        oapForm.setKw360(chargeInstall8);
        oapForm.setKwQuatity360(chargeInstall8qua);
        oapForm.setKw720(chargeInstall9);
        oapForm.setKwQuatity720(chargeInstall9qua);
        oapForm.setAnchoreCustomer(anchoreCustomer);
        oapForm.setCanopyVarient(canopyVarient);
        oapForm.setScopeOfchargeZone(scopeofChargeZone);
        oapForm.setTotalMegaWatt(totalMW);
        oapFormService.update(oapForm);
        int id1 = oapForm.getId();

        String[] chargerType = request.getParameterValues("chargerType");
        String[] charger = request.getParameterValues("charger");
        String[] chargerOther = request.getParameterValues("chargerOther");
        String[] chargerCapacityKW = request.getParameterValues("chargerCapacityKW");
        String[] chargermodel = request.getParameterValues("chargermodel");
        String[] connectorType = request.getParameterValues("connectorType");
        String[] connectorOther = request.getParameterValues("connectorOther");
        String[] noofconnectors = request.getParameterValues("noofconnectors");
        String[] noofchargers = request.getParameterValues("noofchargers");
        String[] chargingrateperunit = request.getParameterValues("chargingrateperunit");

        for (int ct = 0; ct < chargerType.length; ct++) {
            String c = chargerType[ct];

            if (c != null && !c.isEmpty()) {
                ChargerInstallationDetails cid = new ChargerInstallationDetails();

                cid.setOapId(id1);
                cid.setChargerType(chargerType[ct]);
                cid.setCharger(charger[ct]);
                cid.setChargerOther(chargerOther[ct]);
                cid.setChargerCapacityKW(chargerCapacityKW[ct]);
                cid.setChargermodel(chargermodel[ct]);
                cid.setConnectorType(connectorType[ct]);
                cid.setConnectorTypeOther(connectorOther[ct]);
                cid.setNoofconnectors(noofconnectors[ct]);
                cid.setNoofchargers(noofchargers[ct]);
                cid.setChargingrateperunit(chargingrateperunit[ct]);

                chargerInstallationDetailsService.create(cid);

            }
        }

        OapForm oapForm1 = oapFormService.readById(id1);

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");
        int z = 0;
        int id8 = 0;
        for (String s : surveyNo) {
            if (s != null && !s.isEmpty()) {
                OapSurveyAttachment oapSurveyAttachment = new OapSurveyAttachment();
                oapSurveyAttachment.setSurveyNo(surveyNo[z]);
                oapSurveyAttachment.setProjectRepresentative(projectRepresentative[z]);
                oapSurveyAttachment.setOapId(id1);
                oapSurveyAttachmentService.create(oapSurveyAttachment);

                z++;
                id8 = oapSurveyAttachment.getId();
            }
        }

        oapDocumentAttachmentService.deleteByid(id);
//     List oapdocument = oapDocumentAttachmentService.readByattach(id);
//
//        for (Object o : oapdocument) {
//
//            OapDocumentAttachment oapDocumentAttachment = (OapDocumentAttachment) o;
//            int id3 = oapDocumentAttachment.getId();
//            oapDocumentAttachmentService.delete(id3);
//        }
        MultipartHttpServletRequest multipartRequest5 = (MultipartHttpServletRequest) request;

// Get all uploaded files
        List<MultipartFile> files = multipartRequest5.getFiles("attchment");
        String[] document1 = request.getParameterValues("document1");
        String[] id2 = request.getParameterValues("idd");
        String[] descriptions = request.getParameterValues("descriptiones");
        String[] descriptiones1 = request.getParameterValues("descriptiones1");

        int p = 0;

        for (MultipartFile file : files) {
            OapDocumentAttachment oapDocumentAttachment = new OapDocumentAttachment();
            String attachmentFileName = "";

            if (file != null && !file.isEmpty()) {

                attachmentFileName = file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                oapDocumentAttachment.setAttachment(
                        attachmentFileName.replaceAll(" ", "")
                        .replaceAll("&", "")
                        .replaceAll("\\+", "")
                );

                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP"
                        + File.separator + id + File.separator;

                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File destinationFile = new File(fileLocationURL + attachmentFileName);
                file.transferTo(destinationFile);
            }

            if (attachmentFileName.equals("") && document1 != null && p < document1.length && document1[p] != null) {
                attachmentFileName = document1[p];
            }

            oapDocumentAttachment.setAttachment(attachmentFileName);

            DocumentName documentName = null;
            if (id2 != null && p < id2.length && id2[p] != null) {
                documentName = documentNameService.readById(Integer.parseInt(id2[p]));
            }

            oapDocumentAttachment.setOapForm(oapForm1);

            if (descriptions != null && p < descriptions.length && descriptions[p] != null && !descriptions[p].equals("")) {
                oapDocumentAttachment.setDescription(descriptions[p]);
            } else if (descriptiones1 != null && p < descriptiones1.length && descriptiones1[p] != null) {
                oapDocumentAttachment.setDescription(descriptiones1[p]);
            }

            oapDocumentAttachment.setDocumentName(documentName);

            oapDocumentAttachmentService.create(oapDocumentAttachment);
            p++;
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        // multi attachment
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + id1;
        File f1 = new File(path);
        boolean bool = f1.mkdirs();

        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        int id4 = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP"
                            + File.separator + id1 + File.separator;

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

                    OapMultiAttachment oapMultiAttachment = new OapMultiAttachment();

                    oapMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    oapMultiAttachment.setDescription(description[a]);
                    oapMultiAttachment.setOapForm(oapForm1);
                    oapMultiAttachmentService.create(oapMultiAttachment);
                    a++;
                    id4 = oapMultiAttachment.getId();
                }
            }

        }

        OapFormApproval oapFormApproval5 = oapFormApprovalService.readByDeltecodes(id);

        int formid = oapFormApproval5.getId();
        List list44 = oapFormApprovalUserService.readByDleteCode(formid);

        for (Object o : list44) {
            OapFormApprovalUser oapFormApprovalUser = (OapFormApprovalUser) o;
            int id3 = oapFormApprovalUser.getId();
            oapFormApprovalUserService.delete(id3);
        }

        oapFormApprovalService.delete(formid);

        // approval name drop down relted code
        List approval_list = oapMasterUserService.readByIdToList(approvalName);
        HttpSession session1 = request.getSession(false);
        UserMaster user = (UserMaster) session1.getAttribute("user");
        String username = user.getLoginName();
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        OapFormApproval oapFormApproval = new OapFormApproval();
        oapFormApproval.setOapForm(oapForm1);
        oapFormApproval.setTotalApproval(approval_list.size() + "");
        oapFormApproval.setApprovalStatus("0");
        oapFormApproval.setApprovalRemark("add");
        oapFormApproval.setUserId(employeeCode);
        oapFormApproval.setCurrentApproval("1");
        oapFormApprovalService.create(oapFormApproval);

        int approveId = oapFormApproval.getId();
        OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

        int j = 0;

        for (Object o : approval_list) {
            j++;
            OapMasterUser oap1 = (OapMasterUser) o;
            OapFormApprovalUser oap = new OapFormApprovalUser();
            oap.setOapFormApproval(approveId);
            oap.setOapForm(id1);
            oap.setUserId(oap1.getUserId());
            oap.setLevel("1");
            oap.setApprovalStatus("0");
            oapFormApprovalUserService.create(oap);

        }

        mv.getModelMap().put("id", id);
        session.setAttribute("successMessage", " OAP Form SaveAsDraft Submited successfully");
        mv.setViewName("redirect:oapForm.htm?act=oapFormAppovalList");
        return mv;

    }

    public ModelAndView oapSaveAsDraft1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username1 = user1.getLoginName();
        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String id1 = request.getParameter("id");
        String today = dateFormat.format(new Date());

//	String documentNo = request.getParameter("documentNo");
        String pcsName = request.getParameter("pcsName");
        String date = request.getParameter("date");
        String documentRevisonNo = request.getParameter("documentRevisonNo");
        String projectName = request.getParameter("projectName");
        String city_highway = request.getParameter("city/highway");
        String pcsAddress = request.getParameter("pcsAddress");
        String pcsType1 = request.getParameter("pcsType1");
        if (pcsType1 == null) {
            pcsType1 = "0";
        } else {
            pcsType1 = "1";
        }

        String pcsType2 = request.getParameter("pcsType2");
        if (pcsType2 == null) {
            pcsType2 = "0";
        } else {
            pcsType2 = "1";
        }
        String pcsType3 = request.getParameter("pcsType3");
        if (pcsType3 == null) {
            pcsType3 = "0";
        } else {
            pcsType3 = "1";
        }
        String pcstypeother = request.getParameter("pcstypeother");
        if (pcstypeother == null) {
            pcstypeother = "";
        }
        String pcsModel = request.getParameter("pcsModel");
        if (pcsModel == null) {
            pcsModel = "0";
        } else {
            pcsModel = "1";
        }
        String pcsMode2 = request.getParameter("pcsMode2");
        if (pcsMode2 == null) {
            pcsMode2 = "0";
        } else {
            pcsMode2 = "1";
        }
        String pcsMode3 = request.getParameter("pcsMode3");
        if (pcsMode3 == null) {
            pcsMode3 = "0";
        } else {
            pcsMode3 = "1";
        }
        String pcsMode5 = request.getParameter("pcsMode5");
        if (pcsMode5 == null) {
            pcsMode5 = "0";
        } else {
            pcsMode5 = "1";
        }
        String pcsMode4 = request.getParameter("pcsMode4");
        if (pcsMode4 == null) {
            pcsMode4 = "0";
        } else {
            pcsMode4 = "1";
        }
        String pcsModelother = request.getParameter("pcsModelother");
        if (pcsModelother == null) {
            pcsModelother = "";
        }
        String pcscoordinates = request.getParameter("pcscoordinates");
        String mobileNo = request.getParameter("mobileNo");
        String email = request.getParameter("email");
        String alternatemobileNo = request.getParameter("alternatemobileNo");
        String clientDetails = request.getParameter("clientDetails");
        String clientRequiremts = request.getParameter("clientRequiremts");
        String clientscope = request.getParameter("scope");

        String salesName = request.getParameter("salesName");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String date1 = request.getParameter("date1");
//	String signature1 = request.getParameter("signature1");

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateTime = currentDateTime.format(formatter);
        Date date5 = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yy");
        String sysdate = sdf4.format(date5);
        Date date55 = new java.util.Date();
        SimpleDateFormat sdf5 = new SimpleDateFormat("MM");
        String sysdate1 = sdf5.format(date55);
        int month_frt = Integer.parseInt(sysdate1);
        int year_frt = Integer.parseInt(sysdate);

        DocumentMasterId documentMasterId = documentMasterIdService.readByDocumentNo();

        String meetingno = "0";
        meetingno = documentMasterId.getDocumentId();
        if (meetingno == null) {
            meetingno = "0";
        }

        int ten_no_int = 0;

        ten_no_int = Integer.parseInt(meetingno);

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

        String refNo = final_ten_no;
//	refNo = "OAP" + "-" + refNo;

        String f_year = refNo.substring(0, 2);
        String f_no = refNo.substring(2, 7);

        int f_y1 = Integer.parseInt(f_year);
        f_y1++;

        refNo = "OAP" + "-" + f_year + "" + f_y1 + "-" + f_no;

        String country = request.getParameter("country");
        String state5 = request.getParameter("state");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String houseno = request.getParameter("houseno");

        String pcsDelivery1 = request.getParameter("pcsDelivery1");
        if (pcsDelivery1 == null) {
            pcsDelivery1 = "0";
        }

        String attachment1File1 = request.getParameter("attachment1File1");

        if (pcsDelivery1.equals("0")) {
            attachment1File1 = "";
        }

        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile attachment1File = multipartRequest1.getFile("attachment1File");

        String attachment1FileName = "";
        if (attachment1File != null && !attachment1File.isEmpty()) {
            attachment1FileName = attachment1File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + id1 + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment1FileName);
            attachment1File.transferTo(destinationFile);
        }
        if (attachment1FileName.equals("") || attachment1FileName == "") {
            attachment1FileName = attachment1File1;
        }

        String pcsDelivery2 = request.getParameter("pcsDelivery2");
        if (pcsDelivery2 == null) {
            pcsDelivery2 = "0";
        }
        String attachment2File2 = request.getParameter("attachment2File2");

        if (pcsDelivery2.equals("0")) {
            attachment2File2 = "";
        }

        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile attachment2File = multipartRequest2.getFile("attachment2File");
        String attachment2FileName = "";
        if (attachment2File != null && !attachment2File.isEmpty()) {
            attachment2FileName = attachment2File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + id1 + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment2FileName);
            attachment2File.transferTo(destinationFile);
        }
        if (attachment2FileName.equals("") || attachment2FileName == "") {
            attachment2FileName = attachment2File2;
        }

        String pcsDelivery3 = request.getParameter("pcsDelivery3");
        if (pcsDelivery3 == null) {
            pcsDelivery3 = "0";
        }
        String attachment3File3 = request.getParameter("attachment3File3");

        if (pcsDelivery3.equals("0")) {
            attachment3File3 = "";
        }

        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile attachment3File = multipartRequest3.getFile("attachment3File");
        String attachment3FileName = "";
        if (attachment3File != null && !attachment3File.isEmpty()) {
            attachment3FileName = attachment3File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + id1 + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment3FileName);
            attachment3File.transferTo(destinationFile);
        }
        if (attachment3FileName.equals("") || attachment3FileName == "") {
            attachment3FileName = attachment3File3;
        }

        String pcsDelivery4 = request.getParameter("pcsDelivery4");
        if (pcsDelivery4 == null) {
            pcsDelivery4 = "0";
        }
        String attachment4File4 = request.getParameter("attachment4File4");

        if (pcsDelivery4.equals("0")) {
            attachment4File4 = "";
        }

        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile attachment4File = multipartRequest4.getFile("attachment4File");
        String attachment4FileName = "";
        if (attachment4File != null && !attachment4File.isEmpty()) {
            attachment4FileName = attachment4File.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + id1 + File.separator;

            // Create the directory if it doesn't exist
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file
            File destinationFile = new File(fileLocationURL + attachment4FileName);
            attachment4File.transferTo(destinationFile);
        }
        if (attachment4FileName.equals("") || attachment4FileName == "") {
            attachment4FileName = attachment4File4;
        }

        String chargeInstall1 = request.getParameter("chargeInstall1");
        if (chargeInstall1 == null) {
            chargeInstall1 = "0";
        } else {
            chargeInstall1 = "1";
        }
        String chargeInstall1qua = request.getParameter("chargeInstall1qua");
        if (chargeInstall1qua == null) {
            chargeInstall1qua = "";
        }
        String chargeInstall2 = request.getParameter("chargeInstall2");
        if (chargeInstall2 == null) {
            chargeInstall2 = "0";
        } else {
            chargeInstall2 = "1";
        }
        String chargeInstall2qua = request.getParameter("chargeInstall2qua");
        if (chargeInstall2qua == null) {
            chargeInstall2qua = "";
        }
        String chargeInstall3 = request.getParameter("chargeInstall3");
        if (chargeInstall3 == null) {
            chargeInstall3 = "0";
        } else {
            chargeInstall3 = "1";
        }
        String chargeInstall3qua = request.getParameter("chargeInstall3qua");
        if (chargeInstall3qua == null) {
            chargeInstall3qua = "";
        }
        String chargeInstall4 = request.getParameter("chargeInstall4");
        if (chargeInstall4 == null) {
            chargeInstall4 = "0";
        } else {
            chargeInstall4 = "1";
        }
        String chargeInstall4qua = request.getParameter("chargeInstall4qua");
        if (chargeInstall4qua == null) {
            chargeInstall4qua = "";
        }
        String chargeInstall5 = request.getParameter("chargeInstall5");
        if (chargeInstall5 == null) {
            chargeInstall5 = "0";
        } else {
            chargeInstall5 = "1";
        }
        String chargeInstall5qua = request.getParameter("chargeInstall5qua");
        if (chargeInstall5qua == null) {
            chargeInstall5qua = "";
        }
        String chargeInstall6 = request.getParameter("chargeInstall6");
        if (chargeInstall6 == null) {
            chargeInstall6 = "0";
        } else {
            chargeInstall6 = "1";
        }
        String chargeInstall6qua = request.getParameter("chargeInstall6qua");
        if (chargeInstall6qua == null) {
            chargeInstall6qua = "";
        }
        String chargeInstall7 = request.getParameter("chargeInstall7");
        if (chargeInstall7 == null) {
            chargeInstall7 = "0";
        } else {
            chargeInstall7 = "1";
        }
        String chargeInstall7qua = request.getParameter("chargeInstall7qua");
        if (chargeInstall7qua == null) {
            chargeInstall7qua = "";
        }
        String guns = request.getParameter("guns");
        String others = request.getParameter("others");

        String Fromdate = request.getParameter("Fromdate");
        String Todate = request.getParameter("Todate");
        String budgetallocated = request.getParameter("budgetallocated");
        String othersDetails = request.getParameter("othersDetails");

        String ProjectProfile = request.getParameter("ProjectProfile");
        String profitcenter = request.getParameter("profitcenter");
        String CompanyCode = request.getParameter("CompanyCode");
        String Plant = request.getParameter("plant");
        String ProjectType = request.getParameter("ProjectType");
        String ProjectCurrency = request.getParameter("ProjectCurrency");
        String InvestmentProfile = request.getParameter("InvestmentProfile");
        String Discom = request.getParameter("Discom");
        String ChargePoints = request.getParameter("ChargePoints");
        String NoOfCharger = request.getParameter("NoOfCharger");
        String overallstations = request.getParameter("overallstations");
        String stationAc = request.getParameter("stationAc");
        String stationDc = request.getParameter("stationDc");
        String stationname = request.getParameter("stationname");
        String stationtype = request.getParameter("stationtype");
        String tenant = request.getParameter("tenant");
        String connectiontype = request.getParameter("connectiontype");
        String approvalName = request.getParameter("approvalName");
        String chargingrate = request.getParameter("chargingrate");
        OapMaster oapMaster = null;
        if (approvalName != null && !approvalName.trim().isEmpty()) {
            oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
        }
        String sitesurvey = request.getParameter("sitesurvey");
        String Survey = request.getParameter("Survey");
        if ("siteSurveynotcreated".equals(Survey)) {
            Survey = "0";
        } else if ("siteSurveycreated".equals(Survey)) {
            Survey = "1";
        } else {
            Survey = "2";
        }

        String projectTimelineCategory = request.getParameter("projectTimelineCategory");
        String totalKwRating = request.getParameter("totalKwRating");
        String specificDateFromClient = request.getParameter("specificDateFromClient");
        if (specificDateFromClient == null) {
            specificDateFromClient = "";
        }
        String totalChargerCapacity = request.getParameter("totalChargerCapacity");
        String chargerStationAccessType = request.getParameter("chargerStationAccessType");
        String auxiliaryLoadOfStation = request.getParameter("auxiliaryLoadOfStation");
        if (auxiliaryLoadOfStation == null) {
            auxiliaryLoadOfStation = "";
        }
        String chargingRetePerUnit = request.getParameter("chargingRetePerUnit");
        String noOfEvsToBeChanged = request.getParameter("noOfEvsToBeChanged");
        String chargeInstall8qua = request.getParameter("chargeInstall8qua");
        if (chargeInstall8qua == null) {
            chargeInstall8qua = "";
        }

        String chargeInstall8 = request.getParameter("chargeInstall8");
        if (chargeInstall8 == null) {
            chargeInstall8 = "0";
        } else {
            chargeInstall8 = "1";
        }
        String chargeInstall9qua = request.getParameter("chargeInstall9qua");
        if (chargeInstall9qua == null) {
            chargeInstall9qua = "";
        }
        String chargeInstall9 = request.getParameter("chargeInstall9");
        if (chargeInstall9 == null) {
            chargeInstall9 = "0";
        } else {
            chargeInstall9 = "1";
        }

        String anchoreCustomer = request.getParameter("anchoreCustomer");
        String canopyVarient = request.getParameter("canopyVarient");
        if (canopyVarient == null) {
            canopyVarient = "";
        }
        String scopeofChargeZone = request.getParameter("scopeofChargeZone");
        String totalMW = request.getParameter("totalMW");

        OapForm oapForm = oapFormService.readById(Integer.parseInt(id1));

        //    oapForm.setDocumentNo(refNo);
        oapForm.setPcsName(pcsName);
        oapForm.setDate(date);
        oapForm.setDocumentRevisionNo("R0");
        oapForm.setProjectName(projectName);
        oapForm.setPcsCityHighway(city_highway);
        oapForm.setPcsAddress(pcsAddress);
        oapForm.setPcsTypeCity(pcsType1);
        oapForm.setPcsTypeHighway(pcsType2);
        oapForm.setPcsTypeOtherCheck(pcsType3);
        oapForm.setPcsTypeOther(pcstypeother);
        oapForm.setPcsModelDoco(pcsModel);
        oapForm.setPcsModelCoco(pcsMode2);
        oapForm.setPcsModelDodo(pcsMode3);
        oapForm.setPcsModelSaas(pcsMode5);
        oapForm.setPcsModelOtherCheck(pcsMode4);
        oapForm.setPcsModelOther(pcsModelother);
        oapForm.setPcsCoordinates(pcscoordinates);
        oapForm.setMobileNo(mobileNo);
        oapForm.setEmail(email);
        oapForm.setAlternateMobileNo(alternatemobileNo);
        oapForm.setClientDetails(clientDetails);
        oapForm.setSpecificRequriementsClients(clientRequiremts);
        oapForm.setClientScope(clientscope);
        oapForm.setSalesLeadName(salesName);
        oapForm.setDepartment(department);
        oapForm.setDesignation(designation);
        oapForm.setSalesDate(date1);
        oapForm.setSignature("notrequired");
        oapForm.setAgreementLoa(pcsDelivery1);
        oapForm.setOwnerShipDocument(pcsDelivery2);
        oapForm.setPreliminarySiteSurvey(pcsDelivery3);
        oapForm.setConsentLetterNoc(pcsDelivery4);
        oapForm.setKwAc77(chargeInstall1);
        oapForm.setKwAcQuatity77(chargeInstall1qua);
        oapForm.setKwDc15(chargeInstall2);
        oapForm.setKwDcQuatity15(chargeInstall2qua);
        oapForm.setKwDc30(chargeInstall3);
        oapForm.setKwDcQuatity30(chargeInstall3qua);
        oapForm.setKwDc60(chargeInstall4);
        oapForm.setKwDcQuatity60(chargeInstall4qua);
        oapForm.setKwDc120(chargeInstall5);
        oapForm.setKwDcQuatity120(chargeInstall5qua);

        oapForm.setKwDc180(chargeInstall6);
        oapForm.setKwDcQuatity180(chargeInstall6qua);
        oapForm.setKw240(chargeInstall7);
        oapForm.setKwQuatity240(chargeInstall7qua);

        oapForm.setNoOfGuns(guns);
        oapForm.setOthers(others);
        oapForm.setTimeLineFromDate(Fromdate);
        oapForm.setTimeLineToDate(Todate);
        oapForm.setProjectBudgetAllocated(budgetallocated);
        oapForm.setOthersDetails(othersDetails);

        oapForm.setOapMaster(oapMaster);
        oapForm.setCreatedDate(Fromdate);
        oapForm.setUserId(username1);
        oapForm.setCreatedDate(today);
        oapForm.setFlagStatus(0);
        oapForm.setAssignedName("");
        oapForm.setAggrementAttach(attachment1FileName);
        oapForm.setOwnershipAttach(attachment2FileName);
        oapForm.setPreliminaryAttach(attachment3FileName);
        oapForm.setConsentAttach(attachment4FileName);
        oapForm.setState(state5);
        oapForm.setCountry(country);
        oapForm.setCity(city);
        oapForm.setDistrict(district);
        oapForm.setHouseNo(houseno);
        oapForm.setProjectProfile(ProjectProfile);
        oapForm.setProjectCenter(profitcenter);
        oapForm.setCompanyCode(CompanyCode);
        oapForm.setPlant(Plant);
        oapForm.setProjectType(ProjectType);
        oapForm.setProjectCurrency(ProjectCurrency);
        oapForm.setInverstmentProfile(InvestmentProfile);
        oapForm.setDiscom(Discom);
        oapForm.setNoOfChargePoints(ChargePoints);
        oapForm.setNoOfCharger(NoOfCharger);
        oapForm.setOverallStationCapacityKw(overallstations);
        oapForm.setStationAcCapacityKw(stationAc);
        oapForm.setStationDcCapacityKw(stationDc);
        oapForm.setStationName(stationname);
        oapForm.setStationType(stationtype);
        oapForm.setTenant(tenant);
        oapForm.setConnectionType(connectiontype);
        oapForm.setChargingRatePerUnit(chargingrate);
        oapForm.setSiteSurvey(sitesurvey);
        oapForm.setSurveyRadio(Integer.parseInt(Survey));
        documentMasterId.setDocumentId(final_ten_no);
        oapForm.setProjectTimelineCategory(projectTimelineCategory);
        oapForm.setTotalKwRating(totalKwRating);
        oapForm.setSpecificDateFromClient(specificDateFromClient);
        oapForm.setTotalChargerCapacity(totalChargerCapacity);
        oapForm.setChargerStationAccessType(chargerStationAccessType);
        oapForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
        oapForm.setChargingRetePerUnit(chargingRetePerUnit);
        oapForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
        oapForm.setKw360(chargeInstall8);
        oapForm.setKwQuatity360(chargeInstall8qua);
        oapForm.setKw720(chargeInstall9);
        oapForm.setKwQuatity720(chargeInstall9qua);
        oapForm.setAnchoreCustomer(anchoreCustomer);
        oapForm.setCanopyVarient(canopyVarient);
        oapForm.setScopeOfchargeZone(scopeofChargeZone);
        oapForm.setTotalMegaWatt(totalMW);
        oapFormService.update(oapForm);
        //    documentMasterIdService.update(documentMasterId);
        int id = oapForm.getId();

        String[] chargerType = request.getParameterValues("chargerType");
        String[] charger = request.getParameterValues("charger");
        String[] chargerOther = request.getParameterValues("chargerOther");
        String[] chargerCapacityKW = request.getParameterValues("chargerCapacityKW");
        String[] chargermodel = request.getParameterValues("chargermodel");
        String[] connectorType = request.getParameterValues("connectorType");
        String[] connectorOther = request.getParameterValues("connectorOther");
        String[] noofconnectors = request.getParameterValues("noofconnectors");
        String[] noofchargers = request.getParameterValues("noofchargers");
        String[] chargingrateperunit = request.getParameterValues("chargingrateperunit");

        for (int ct = 0; ct < chargerType.length; ct++) {
            String c = chargerType[ct];

            if (c != null && !c.isEmpty()) {
                ChargerInstallationDetails cid = new ChargerInstallationDetails();

                cid.setOapId(id);
                cid.setChargerType(chargerType[ct]);
                cid.setCharger(charger[ct]);
                cid.setChargerOther(chargerOther[ct]);
                cid.setChargerCapacityKW(chargerCapacityKW[ct]);
                cid.setChargermodel(chargermodel[ct]);
                cid.setConnectorType(connectorType[ct]);
                cid.setConnectorTypeOther(connectorOther[ct]);
                cid.setNoofconnectors(noofconnectors[ct]);
                cid.setNoofchargers(noofchargers[ct]);
                cid.setChargingrateperunit(chargingrateperunit[ct]);

                chargerInstallationDetailsService.create(cid);

            }
        }

        OapForm oapForm1 = oapFormService.readById(id);

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");
        int b = 0;

        for (String s : surveyNo) {
            if (s != null && !s.isEmpty()) {
                OapSurveyAttachment oapSurveyAttachment = new OapSurveyAttachment();
                oapSurveyAttachment.setSurveyNo(surveyNo[b]);
                oapSurveyAttachment.setProjectRepresentative(projectRepresentative[b]);
                oapSurveyAttachment.setOapId(id);
                oapSurveyAttachmentService.create(oapSurveyAttachment);

                b++;
            }
        }

        oapDocumentAttachmentService.deleteByid(id + "");

        MultipartHttpServletRequest multipartRequest5 = (MultipartHttpServletRequest) request;

// Get all uploaded files
        List<MultipartFile> files = multipartRequest5.getFiles("attchment");
        String[] document1 = request.getParameterValues("document1");
        String[] id2 = request.getParameterValues("idd");
        String[] descriptions = request.getParameterValues("descriptiones");
        String[] descriptiones1 = request.getParameterValues("descriptiones1");

        int p = 0;

        for (MultipartFile file : files) {
            OapDocumentAttachment oapDocumentAttachment = new OapDocumentAttachment();
            String attachmentFileName = "";
            if (file != null && !file.isEmpty()) {

                attachmentFileName = file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                oapDocumentAttachment.setAttachment(attachmentFileName.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "OAP"
                        + File.separator + id + File.separator;
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File destinationFile = new File(fileLocationURL + attachmentFileName);
                file.transferTo(destinationFile);

            }
            if (attachmentFileName != null
                    && attachmentFileName.isEmpty()
                    && document1 != null
                    && p < document1.length
                    && document1[p] != null) {

                attachmentFileName = document1[p];
            }
            oapDocumentAttachment.setAttachment(attachmentFileName);

            DocumentName documentName = documentNameService.readById(Integer.parseInt(id2[p]));

            oapDocumentAttachment.setOapForm(oapForm1);
            if (p < descriptions.length && descriptions[p] != null && !descriptions[p].equals("")) {
                oapDocumentAttachment.setDescription(descriptions[p]);
            }

            if (descriptions[p] == null || descriptions[p].trim().equals("")) {
                oapDocumentAttachment.setDescription("");

            }
            oapDocumentAttachment.setDocumentName(documentName);

            oapDocumentAttachmentService.create(oapDocumentAttachment);
            p++;
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        // multi attachment
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "OAP"
                + File.separator + id;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        int id4 = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "OAP"
                            + File.separator + id + File.separator;

                    File directory = new File(fileLocationURL);
                    if (!directory.exists()) {
                        directory.mkdirs(); // Create the directory if it doesn't exist
                    }

                    File destinationFile1 = new File(fileLocationURL + file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    try {
                        file1.transferTo(destinationFile1); // Ensure proper exception handling
                    } catch (Exception e) {
                        e.printStackTrace(); // Handle the error or log it
                    }

                    OapMultiAttachment oapMultiAttachment = new OapMultiAttachment();

                    oapMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    oapMultiAttachment.setDescription(description[a]);
                    oapMultiAttachment.setOapForm(oapForm1);
                    oapMultiAttachmentService.create(oapMultiAttachment);
                    a++;
                    id4 = oapMultiAttachment.getId();
                }
            }

        }

        OapFormApproval oapFormApproval5 = oapFormApprovalService.readByDeltecodes(id + "");

        int formid = oapFormApproval5.getId();
        List list44 = oapFormApprovalUserService.readByDleteCode(formid);

        for (Object o : list44) {
            OapFormApprovalUser oapFormApprovalUser = (OapFormApprovalUser) o;
            int id3 = oapFormApprovalUser.getId();
            oapFormApprovalUserService.delete(id3);

        }

        oapFormApprovalService.delete(formid);

        // approval name drop down relted code
        List approval_list = oapMasterUserService.readByIdToList(approvalName);
        HttpSession session1 = request.getSession(false);
        UserMaster user = (UserMaster) session1.getAttribute("user");
        String username = user.getLoginName();
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        OapFormApproval oapFormApproval = new OapFormApproval();
        oapFormApproval.setOapForm(oapForm1);
        oapFormApproval.setTotalApproval(approval_list.size() + "");
        oapFormApproval.setApprovalStatus("0");
        oapFormApproval.setApprovalRemark("add");
        oapFormApproval.setUserId(employeeCode);
        oapFormApproval.setCurrentApproval("1");
        oapFormApprovalService.create(oapFormApproval);

        int approveId = oapFormApproval.getId();
        OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

        int j = 0;

        for (Object o : approval_list) {
            j++;
            OapMasterUser oap1 = (OapMasterUser) o;
            OapFormApprovalUser oap = new OapFormApprovalUser();
            oap.setOapFormApproval(approveId);
            oap.setOapForm(id);
            oap.setUserId(oap1.getUserId());
            oap.setLevel("1");
            oap.setApprovalStatus("0");
            oapFormApprovalUserService.create(oap);

        }

        session.setAttribute("successMessage", " OAPForm SaveAsDraft Done successfully");
        mv.setViewName("redirect:oapForm.htm?act=oapFormAppovalList");
        return mv;

    }

    public ModelAndView BomSheet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        List deliverableMulti = deliverableMultiService.readByOapid(id);

        List<IteamDetailsAttachments> allAttachments = new ArrayList<>();

        for (Object item : deliverableMulti) {

            DeliverableMulti deliverable = (DeliverableMulti) item;

            int multiId = deliverable.getId();

            List<IteamDetailsAttachments> attachments = iteamDetailsAttachmentsService.readBydeliverymultid(multiId + "");

            if (attachments != null) {
                allAttachments.addAll(attachments);
            }
        }

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
        Row itemHeaderRow = sheet.createRow(rownum++);
        itemHeaderRow.setHeightInPoints(40);
        String[] itemHeaders = {"SrNo", "Iteam Code", "Iteam Description", "Purpose", "Make", "Uom", "Qty"};

        sheet.setColumnWidth(0, 2048);

        for (int i = 0; i < itemHeaders.length; i++) {
            if (i != 0) {
                sheet.setColumnWidth(i, 11000);
            }
            Cell cell = itemHeaderRow.createCell(i);
            cell.setCellValue(itemHeaders[i]);
            cell.setCellStyle(styleBold);
        }

        // Header row already created above
        int rowNum = 1; // Start from row 1 (since header is at 0)

        for (int i = 0; i < allAttachments.size(); i++) {
            IteamDetailsAttachments attachment = allAttachments.get(i);

            Row row = sheet.createRow(rowNum++); // Create a new row for each attachment

            Cell cell0 = row.createCell(0);
            cell0.setCellValue(attachment.getSno()); // SrNo starts from 1

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(attachment.getIteamCode());

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(attachment.getIteamDescription());
            sheet.autoSizeColumn(2);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(attachment.getPurpose());

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(attachment.getMake());

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(attachment.getUom());

            Cell cell6 = row.createCell(6);
            cell6.setCellValue(attachment.getQty());
        }

        String appPath = request.getServletContext().getRealPath("");
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + "bomexcel.xlsx";

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

        return mv;
    }

    public ModelAndView BomSheet1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        List deliverableMulti = deliverableMultiService.readByAocId(id);

        List<IteamDetailsAttachments> allAttachments = new ArrayList<>();

        for (Object item : deliverableMulti) {

            DeliverableMulti deliverable = (DeliverableMulti) item;

            int multiId = deliverable.getId();

            List<IteamDetailsAttachments> attachments = iteamDetailsAttachmentsService.readBydeliverymultid(multiId + "");

            if (attachments != null) {
                allAttachments.addAll(attachments);
            }
        }

        int rownum = 0;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("FIRST SHEET");

        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true);
        XSSFCellStyle styleBold = workbook.createCellStyle();
        styleBold.setFont(boldFont);
        styleBold.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        styleBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleBold.setBorderTop(BorderStyle.THIN);
        styleBold.setBorderBottom(BorderStyle.THIN);
        styleBold.setBorderLeft(BorderStyle.THIN);
        styleBold.setBorderRight(BorderStyle.THIN);
        styleBold.setAlignment(HorizontalAlignment.CENTER);
        styleBold.setVerticalAlignment(VerticalAlignment.CENTER);
        Row itemHeaderRow = sheet.createRow(rownum++);
        itemHeaderRow.setHeightInPoints(40);
        String[] itemHeaders = {"SrNo", "Iteam Code", "Iteam Description", "Purpose", "Make", "Uom", "Qty"};

        sheet.setColumnWidth(0, 2048);

        for (int i = 0; i < itemHeaders.length; i++) {
            if (i != 0) {
                sheet.setColumnWidth(i, 11000);
            }
            Cell cell = itemHeaderRow.createCell(i);
            cell.setCellValue(itemHeaders[i]);
            cell.setCellStyle(styleBold);
        }

        // Header row already created above
        int rowNum = 1; // Start from row 1 (since header is at 0)

        for (int i = 0; i < allAttachments.size(); i++) {
            IteamDetailsAttachments attachment = allAttachments.get(i);

            Row row = sheet.createRow(rowNum++); // Create a new row for each attachment

            Cell cell0 = row.createCell(0);
            cell0.setCellValue(attachment.getSno()); // SrNo starts from 1

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(attachment.getIteamCode());

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(attachment.getIteamDescription());

// After all rows (including this one) are created
            sheet.autoSizeColumn(2);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(attachment.getPurpose());

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(attachment.getMake());

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(attachment.getUom());

            Cell cell6 = row.createCell(6);
            cell6.setCellValue(attachment.getQty());
        }

        String appPath = request.getServletContext().getRealPath("");
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + "bomexcel.xlsx";

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

        return mv;
    }

    public ModelAndView oapTracker(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("Oap/oapTracker");
        return mv;
    }

    public ModelAndView deliverableView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username = user1.getLoginName();

        List list1 = kickOffFormService.readDeliverableList(username);
        mv.getModelMap().put("list1", list1);
        mv.setViewName("Oap/DeliverableView");
        return mv;
    }

    public ModelAndView siteSurveyView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        SiteSurvey siteSurvey = siteSurveyService.readBySurveyNo(id);

        if (siteSurvey.getId() != 0) {
            List SurveyAttach = siteSurveyAttachmentService.readBysiteSurveyId(siteSurvey.getId() + "");

            mv.getModelMap().put("SurveyAttach", SurveyAttach);
            mv.getModelMap().put("siteSurvey", siteSurvey);
            mv.getModelMap().put("id", id);
        } else {
            request.setAttribute("failureMessage", " Survey No not Found");
        }

        mv.setViewName("Oap/SiteSurveyView");
        return mv;
    }

    public ModelAndView siteSurveyViewClose(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        SiteSurvey siteSurvey = siteSurveyService.readById(Integer.parseInt(id));
        List SurveyAttach = siteSurveyAttachmentService.readBysiteSurveyId(siteSurvey.getId() + "");
        mv.getModelMap().put("SurveyAttach", SurveyAttach);
        mv.getModelMap().put("siteSurvey", siteSurvey);
        mv.getModelMap().put("id", id);

        mv.setViewName("Oap/SiteSurveyView");
        return mv;
    }

    public ModelAndView SiteSurveyReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("Oap/SiteSurveyReport");
        return mv;
    }

    public ModelAndView SiteSurveyListReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String siteSurveyNumber = request.getParameter("SiteSurveyNumber");

        String open_from_date = request.getParameter("open_from_date");
        String open_to_date = request.getParameter("open_to_date");

        List list = siteSurveyService.readSiteSurveySearch(siteSurveyNumber, open_from_date, open_to_date);
        mv.getModelMap().put("list", list);
        mv.setViewName("Oap/SiteSurveyReport");
        return mv;
    }

    public ModelAndView SiteSurveyDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        SiteSurvey siteSurvey = siteSurveyService.readById(Integer.parseInt(id));
        if (siteSurvey.getId() != 0) {
            List SurveyAttach = siteSurveyAttachmentService.readBysiteSurveyId(siteSurvey.getId() + "");

            mv.getModelMap().put("SurveyAttach", SurveyAttach);
            mv.getModelMap().put("siteSurvey", siteSurvey);
            mv.getModelMap().put("id", id);
        } else {
            request.setAttribute("failureMessage", " Survey No not Found");
        }

        mv.setViewName("Oap/SiteSurveyDetails");
        return mv;
    }

    public ModelAndView CrcFormRecycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String CrcFormApprovalUser = request.getParameter("id");
//        String oapFormId = request.getParameter("oapFormId");
        String crcFormId = request.getParameter("crcFormId");

        String comment = request.getParameter("comment");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        CrcForm crcForm = crcFormService.readById(Integer.parseInt(crcFormId));

        int oapFormId = crcForm.getOapForm().getId();
        CrcFormApproval crcFormApproval = crcFormApprovalService.readBycrcFormid(Integer.parseInt(crcFormId));

        CrcFormApprovalUser crcFormApprovalUser = crcFormApprovalUserService.appvals(username, crcFormId);

        int approveId = crcFormApprovalUser.getCrcFormApproval();
        CrcFormApprovalComment crcFormApprovalComment = crcFormApprovalCommentService.readByApproveId(approveId);

        String approvalStatus = crcFormApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {

            crcFormApproval.setCurrentApproval("0");
            crcFormApprovalUser.setApprovalStatus("8");
            crcFormApprovalComment.setApprovalStatus("8");//recycle
            crcForm.setFlagStatus(10);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            crcFormApprovalComment.setUserId(employeeCode);
            crcFormApprovalComment.setCrcFormApproval(crcFormApproval);
            crcFormApprovalComment.setApprovalComment(comment);
            crcFormApprovalComment.setApprovalStatus("8");

            crcFormApprovalCommentService.create(crcFormApprovalComment);

            crcFormApprovalService.update(crcFormApproval);
            crcFormApprovalUserService.update(crcFormApprovalUser);
            crcFormService.update(crcForm);

            java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String currentDateTime5 = formatter5.format(new java.util.Date());

            OapLogMaster oapLogMaster = new OapLogMaster();
            oapLogMaster.setActivity("CRC Approval");
            oapLogMaster.setActivityBy(username);
            oapLogMaster.setDate(currentDateTime5);
            oapLogMaster.setStatus("Recycled");
            oapLogMaster.setComments(comment);
            oapLogMaster.setOapId(oapFormId);
            oapLogMaster.setCrcId(Integer.parseInt(crcFormId));
            oapLogMasterService.create(oapLogMaster);

            session.setAttribute("successMessage", " CRC Rework Done successfully");

        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Approved Successfully");

        } else if ("8".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Rejected Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "CRC Already Partially Approved Successfully");
        } else {
            session.setAttribute("failureMessage", "The CRC approval has already progressed to the next stage");
        }
        mv.setViewName("redirect:oapForm.htm?act=CrcFormApprovalUser");

        return mv;
    }

    public ModelAndView oapAndAocDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String btn = request.getParameter("btn");

        if (btn == null || btn == "") {
            btn = "0";
        }

        String Fromdate = request.getParameter("Fromdate");
        String Todate = request.getParameter("Todate");

        Fromdate = (Fromdate == null) ? "" : Fromdate.replace("-", "/");
        Todate = (Todate == null) ? "" : Todate.replace("-", "/");

        String Filter = request.getParameter("Filter");

        int totalOap = 0;
        int approvedOap = 0;
        int pendingOap = 0;
        int rejctedOap = 0;
        int unfieldCRC = 0;
        int totalCrc = 0;
        int approvedCrc = 0;
        int pendingCrc = 0;
        int revisionCrc = 0;
        int totalDesignCoorOap = 0;
        int approvedDesignCoorOap = 0;
        int totalProMangerOap = 0;
        int partiallyApprovedCrc = 0;
        int rejectedCrc = 0;

        int totalAoc = 0;
        int approvedAoc = 0;
        int pendingAoc = 0;
        int rejectedAoc = 0;
        int unfieldKOM = 0;
        int totalKom = 0;
        int pendingKom = 0;
        int approvedKom = 0;
        int totalDesignCoorAoc = 0;
        int approvedDesignCoorAoc = 0;
        int totalProMangerAoc = 0;
        int rejectedKom = 0;

        if (btn.equals("1")) {
            String formattedDate = "";
            String formattedStartDate = "";

            try {
                if (Filter.equals("last-month")) {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    LocalDateTime startDate = myDateObj.minusDays(30);

                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    formattedDate = myDateObj.format(myFormatObj);
                    formattedStartDate = startDate.format(myFormatObj);
                }
                if (Filter.equals("last-week")) {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    LocalDateTime startDate = myDateObj.minusDays(7);

                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    formattedDate = myDateObj.format(myFormatObj);
                    formattedStartDate = startDate.format(myFormatObj);
                }
                if (Filter.equals("last-year")) {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    LocalDateTime startDate = myDateObj.minusDays(365);

                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    formattedDate = myDateObj.format(myFormatObj);
                    formattedStartDate = startDate.format(myFormatObj);
                }
                if (Filter.equals("last-6-month")) {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    LocalDateTime startDate = myDateObj.minusDays(183);

                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    formattedDate = myDateObj.format(myFormatObj);
                    formattedStartDate = startDate.format(myFormatObj);
                }
            } catch (Exception e) {

            }

            mv.getModelMap().put("Fromdate", Fromdate);
            mv.getModelMap().put("Todate", Todate);
            mv.getModelMap().put("Filter", Filter);

            //Total OAP
            totalOap = oapFormService.readByAllOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

            //Approved OAP 4
            approvedOap = oapFormService.readByFlagFourDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

            //total CRC
            totalCrc = crcFormService.countAllCrc();

            //Approved CRC 4
            approvedCrc = crcFormService.readByFlagFour();

            //Partially Approved CRC 2
            partiallyApprovedCrc = crcFormService.readByFlagTwo();

            //Rejected CRC 3
            rejectedCrc = crcFormService.readByFlagThree();

//            //total DesignCoorOAP
//            totalDesignCoorOap = deliverableMultiService.countAllDesignCoorOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//
//            //Approved DesignCoorOAP 1
//            approvedDesignCoorOap = deliverableMultiService.readByFlagOneOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//
//            //total projectOAP
//            totalProMangerOap = oapFormService.countAllProjectOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//total AOC
            totalAoc = aocFormService.countAllAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

            //Approved AOC 4
            approvedAoc = aocFormService.readByFlagFourDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

            //total KOM 
            totalKom = kickOffFormService.countAllKom();

            //Approved KOM 1
            approvedKom = kickOffFormService.readByFlagone();

            //Rejected KOM 3
            rejectedKom = kickOffFormService.readByFlagThree();

//            //total DesignCoorAOC
//            totalDesignCoorAoc = deliverableMultiService.countAllDesignCoorAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//
//            //Approved DesignCoorAOC
//            approvedDesignCoorAoc = deliverableMultiService.readByFlagOneAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//
//            //total projectAOC
//            totalProMangerAoc = aocFormService.countAllProjectAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
            //month wise OAP Data
            List monthWiseList1 = oapFormService.readByMontOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

            String oapmonthName1 = "";
            String oapnumberOfValue1 = "";

            String oapmonthName2 = "";
            String oapnumberOfValue2 = "";

            String oapmonthName3 = "";
            String oapnumberOfValue3 = "";

            String oapmonthName4 = "";
            String oapnumberOfValue4 = "";

            String oapmonthName5 = "";
            String oapnumberOfValue5 = "";

            String oapmonthName6 = "";
            String oapnumberOfValue6 = "";

            String oapmonthName7 = "";
            String oapnumberOfValue7 = "";

            String oapmonthName8 = "";
            String oapnumberOfValue8 = "";

            String oapmonthName9 = "";
            String oapnumberOfValue9 = "";

            String oapmonthName10 = "";
            String oapnumberOfValue10 = "";

            String oapmonthName11 = "";
            String oapnumberOfValue11 = "";

            String oapmonthName12 = "";
            String oapnumberOfValue12 = "";

            int i3 = 0;

            for (Object empId2 : monthWiseList1) {
                i3++;

                Object[] obj = (Object[]) empId2;
                if (i3 == 1) {
                    oapnumberOfValue1 = "" + obj[0];
                    oapmonthName1 = "" + obj[1];
                }
                if (i3 == 2) {
                    oapnumberOfValue2 = "" + obj[0];
                    oapmonthName2 = "" + obj[1];
                }
                if (i3 == 3) {
                    oapnumberOfValue3 = "" + obj[0];
                    oapmonthName3 = "" + obj[1];
                }
                if (i3 == 4) {
                    oapnumberOfValue4 = "" + obj[0];
                    oapmonthName4 = "" + obj[1];
                }
                if (i3 == 5) {
                    oapnumberOfValue5 = "" + obj[0];
                    oapmonthName5 = "" + obj[1];
                }

                if (i3 == 6) {
                    oapnumberOfValue6 = "" + obj[0];
                    oapmonthName6 = "" + obj[1];
                }
                if (i3 == 7) {
                    oapnumberOfValue7 = "" + obj[0];
                    oapmonthName7 = "" + obj[1];
                }
                if (i3 == 8) {
                    oapnumberOfValue8 = "" + obj[0];
                    oapmonthName8 = "" + obj[1];
                }
                if (i3 == 9) {
                    oapnumberOfValue9 = "" + obj[0];
                    oapmonthName9 = "" + obj[1];
                }
                if (i3 == 10) {
                    oapnumberOfValue10 = "" + obj[0];
                    oapmonthName10 = "" + obj[1];
                }
                if (i3 == 11) {
                    oapnumberOfValue11 = "" + obj[0];
                    oapmonthName11 = "" + obj[1];
                }
                if (i3 == 12) {
                    oapnumberOfValue12 = "" + obj[0];
                    oapmonthName12 = "" + obj[1];
                    break;
                }
            }

            mv.getModelMap().put("oapmonthName1", oapmonthName1);
            mv.getModelMap().put("oapnumberOfValue1", oapnumberOfValue1);
            mv.getModelMap().put("oapmonthName2", oapmonthName2);
            mv.getModelMap().put("oapnumberOfValue2", oapnumberOfValue2);
            mv.getModelMap().put("oapmonthName3", oapmonthName3);
            mv.getModelMap().put("oapnumberOfValue3", oapnumberOfValue3);
            mv.getModelMap().put("oapmonthName4", oapmonthName4);
            mv.getModelMap().put("oapnumberOfValue4", oapnumberOfValue4);
            mv.getModelMap().put("oapmonthName5", oapmonthName5);
            mv.getModelMap().put("oapnumberOfValue5", oapnumberOfValue5);
            mv.getModelMap().put("oapmonthName6", oapmonthName6);
            mv.getModelMap().put("oapnumberOfValue6", oapnumberOfValue6);
            mv.getModelMap().put("oapmonthName7", oapmonthName7);
            mv.getModelMap().put("oapnumberOfValue7", oapnumberOfValue7);
            mv.getModelMap().put("oapmonthName8", oapmonthName8);
            mv.getModelMap().put("oapnumberOfValue8", oapnumberOfValue8);
            mv.getModelMap().put("oapmonthName9", oapmonthName9);
            mv.getModelMap().put("oapnumberOfValue9", oapnumberOfValue9);
            mv.getModelMap().put("oapmonthName10", oapmonthName10);
            mv.getModelMap().put("oapnumberOfValue10", oapnumberOfValue10);
            mv.getModelMap().put("oapmonthName11", oapmonthName11);
            mv.getModelMap().put("oapnumberOfValue11", oapnumberOfValue11);
            mv.getModelMap().put("oapmonthName12", oapmonthName12);
            mv.getModelMap().put("oapnumberOfValue12", oapnumberOfValue12);

            // Month Wise AOC Data
            List monthWiseList = aocFormService.readByMonthAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

            String aocmonthName1 = "";
            String aocnumberOfValue1 = "";

            String aocmonthName2 = "";
            String aocnumberOfValue2 = "";

            String aocmonthName3 = "";
            String aocnumberOfValue3 = "";

            String aocmonthName4 = "";
            String aocnumberOfValue4 = "";

            String aocmonthName5 = "";
            String aocnumberOfValue5 = "";

            String aocmonthName6 = "";
            String aocnumberOfValue6 = "";

            String aocmonthName7 = "";
            String aocnumberOfValue7 = "";

            String aocmonthName8 = "";
            String aocnumberOfValue8 = "";

            String aocmonthName9 = "";
            String aocnumberOfValue9 = "";

            String aocmonthName10 = "";
            String aocnumberOfValue10 = "";

            String aocmonthName11 = "";
            String aocnumberOfValue11 = "";

            String aocmonthName12 = "";
            String aocnumberOfValue12 = "";

            int i2 = 0;

            for (Object empId1 : monthWiseList) {
                i2++;

                Object[] obj = (Object[]) empId1;
                if (i2 == 1) {
                    aocnumberOfValue1 = "" + obj[0];
                    aocmonthName1 = "" + obj[1];
                }
                if (i2 == 2) {
                    aocnumberOfValue2 = "" + obj[0];
                    aocmonthName2 = "" + obj[1];
                }
                if (i2 == 3) {
                    aocnumberOfValue3 = "" + obj[0];
                    aocmonthName3 = "" + obj[1];
                }
                if (i2 == 4) {
                    aocnumberOfValue4 = "" + obj[0];
                    aocmonthName4 = "" + obj[1];
                }
                if (i2 == 5) {
                    aocnumberOfValue5 = "" + obj[0];
                    aocmonthName5 = "" + obj[1];
                }

                if (i2 == 6) {
                    aocnumberOfValue6 = "" + obj[0];
                    aocmonthName6 = "" + obj[1];
                }
                if (i2 == 7) {
                    aocnumberOfValue7 = "" + obj[0];
                    aocmonthName7 = "" + obj[1];
                }
                if (i2 == 8) {
                    aocnumberOfValue8 = "" + obj[0];
                    aocmonthName8 = "" + obj[1];
                }
                if (i2 == 9) {
                    aocnumberOfValue9 = "" + obj[0];
                    aocmonthName9 = "" + obj[1];
                }
                if (i2 == 10) {
                    aocnumberOfValue10 = "" + obj[0];
                    aocmonthName10 = "" + obj[1];
                }
                if (i2 == 11) {
                    aocnumberOfValue11 = "" + obj[0];
                    aocmonthName11 = "" + obj[1];
                }
                if (i2 == 12) {
                    aocnumberOfValue12 = "" + obj[0];
                    aocmonthName12 = "" + obj[1];
                    break;
                }

            }

            mv.getModelMap().put("aocmonthName1", aocmonthName1);
            mv.getModelMap().put("aocnumberOfValue1", aocnumberOfValue1);
            mv.getModelMap().put("aocmonthName2", aocmonthName2);
            mv.getModelMap().put("aocnumberOfValue2", aocnumberOfValue2);
            mv.getModelMap().put("aocmonthName3", aocmonthName3);
            mv.getModelMap().put("aocnumberOfValue3", aocnumberOfValue3);
            mv.getModelMap().put("aocmonthName4", aocmonthName4);
            mv.getModelMap().put("aocnumberOfValue4", aocnumberOfValue4);
            mv.getModelMap().put("aocmonthName5", aocmonthName5);
            mv.getModelMap().put("aocnumberOfValue5", aocnumberOfValue5);
            mv.getModelMap().put("aocmonthName6", aocmonthName6);
            mv.getModelMap().put("aocnumberOfValue6", aocnumberOfValue6);
            mv.getModelMap().put("aocmonthName7", aocmonthName7);
            mv.getModelMap().put("aocnumberOfValue7", aocnumberOfValue7);
            mv.getModelMap().put("aocmonthName8", aocmonthName8);
            mv.getModelMap().put("aocnumberOfValue8", aocnumberOfValue8);
            mv.getModelMap().put("aocmonthName9", aocmonthName9);
            mv.getModelMap().put("aocnumberOfValue9", aocnumberOfValue9);
            mv.getModelMap().put("aocmonthName10", aocmonthName10);
            mv.getModelMap().put("aocnumberOfValue10", aocnumberOfValue10);
            mv.getModelMap().put("aocmonthName11", aocmonthName11);
            mv.getModelMap().put("aocnumberOfValue11", aocnumberOfValue11);
            mv.getModelMap().put("aocmonthName12", aocmonthName12);
            mv.getModelMap().put("aocnumberOfValue12", aocnumberOfValue12);

        } else {
            // without filteration
            //total OAP
            totalOap = oapFormService.countAllOap();  // totalOapCount

            //Approved OAP 4
            approvedOap = oapFormService.readByFlagFour();  // approvedOapCount

            //Pending OAP 1
            pendingOap = oapFormService.readBypendingOap();  // pendingOapCount

            //rejctedOap OAP 
            rejctedOap = oapFormService.readByrejctedOap();  // rejctedOapCount

            //rejctedOap OAP 
            unfieldCRC = oapFormService.readByunfieldCRC();  // unfieldCRCCount

            //total CRC 
            totalCrc = crcFormService.countAllCrc();  // totalCrcCount

            //Approved CRC 1
            approvedCrc = crcFormService.readByFlagFour();  // approvedCrcCount

            //Pending CRC 1,4
            pendingCrc = crcFormService.readBypendingCrc();  // pendingCrcCount

            //RevisionCrc
            revisionCrc = crcFormService.readByrevisionCrc(); // revisionCrcCount

            //Partially Approved CRC 2
            partiallyApprovedCrc = crcFormService.readByFlagTwo(); // partiallyApprovedCrcCount

            //Rejected CRC 3
            rejectedCrc = crcFormService.readByFlagThree(); // rejectedCrcCount

//            //total DesignCoorOAP
//            totalDesignCoorOap = deliverableMultiService.countAllDesignCoorOap();
//
//            //Approved DesignCoorOAP 1
//            approvedDesignCoorOap = deliverableMultiService.readByFlagOneOap();
//
//            //total projectOAP
//            totalProMangerOap = oapFormService.countAllProjectOap();
            //total AOC
            totalAoc = aocFormService.countAllAoc();

            //Approved AOC 4
            approvedAoc = aocFormService.readByFlagFour();

            //pending AOC 
            pendingAoc = aocFormService.readBypendingAoc();

            //rejcted AOC 
            rejectedAoc = aocFormService.readByrejectedAoc();

//unfield KOM 
            unfieldKOM = aocFormService.readByunfieldKOM();

            //total KOM 
            totalKom = kickOffFormService.countAllKom();

            //Approved KOM 1
            approvedKom = kickOffFormService.readByFlagone();

            //Pending KOM 
            pendingKom = kickOffFormService.readByPendingKOM();

            //Rejected KOM 3
            rejectedKom = kickOffFormService.readByFlagThree();

//            //total DesignCoorAOC
//            totalDesignCoorAoc = deliverableMultiService.countAllDesignCoorAoc();
//
//            //Approved DesignCoorAOC
//            approvedDesignCoorAoc = deliverableMultiService.readByFlagOneAoc();
//
//            //total projectAOC
//            totalProMangerAoc = aocFormService.countAllProjectAoc();
//====================================================================================================
//            Monthe Wise OAP Data
//====================================================================================================      
            Calendar caled = Calendar.getInstance();
            caled.add(Calendar.MONTH, -11);  // NOT -12 (explained below)
            caled.set(Calendar.DAY_OF_MONTH, 1); // start of month

            Date fromDate8 = caled.getTime();
            String from_date = new SimpleDateFormat("dd/MM/yyyy").format(fromDate8);

            List monthWiseList1 = oapFormService.readByMontOap(from_date);

            String oapmonthName1 = "";
            String oapnumberOfValue1 = "";
            String oapTotalMWOfValue1 = "";

            String oapmonthName2 = "";
            String oapnumberOfValue2 = "";
            String oapTotalMWOfValue2 = "";

            String oapmonthName3 = "";
            String oapnumberOfValue3 = "";
            String oapTotalMWOfValue3 = "";

            String oapmonthName4 = "";
            String oapnumberOfValue4 = "";
            String oapTotalMWOfValue4 = "";

            String oapmonthName5 = "";
            String oapnumberOfValue5 = "";
            String oapTotalMWOfValue5 = "";

            String oapmonthName6 = "";
            String oapnumberOfValue6 = "";
            String oapTotalMWOfValue6 = "";

            String oapmonthName7 = "";
            String oapnumberOfValue7 = "";
            String oapTotalMWOfValue7 = "";

            String oapmonthName8 = "";
            String oapnumberOfValue8 = "";
            String oapTotalMWOfValue8 = "";

            String oapmonthName9 = "";
            String oapnumberOfValue9 = "";
            String oapTotalMWOfValue9 = "";

            String oapmonthName10 = "";
            String oapnumberOfValue10 = "";
            String oapTotalMWOfValue10 = "";

            String oapmonthName11 = "";
            String oapnumberOfValue11 = "";
            String oapTotalMWOfValue11 = "";

            String oapmonthName12 = "";
            String oapnumberOfValue12 = "";
            String oapTotalMWOfValue12 = "";

            int i3 = 0;

            for (Object empId2 : monthWiseList1) {
                i3++;

                Object[] obj = (Object[]) empId2;
                if (i3 == 1) {
                    oapnumberOfValue1 = "" + obj[0];
                    oapmonthName1 = "" + obj[1];
                    oapTotalMWOfValue1 = "" + obj[2];

                }
                if (i3 == 2) {
                    oapnumberOfValue2 = "" + obj[0];
                    oapmonthName2 = "" + obj[1];
                    oapTotalMWOfValue2 = "" + obj[2];
                }
                if (i3 == 3) {
                    oapnumberOfValue3 = "" + obj[0];
                    oapmonthName3 = "" + obj[1];
                    oapTotalMWOfValue3 = "" + obj[2];
                }
                if (i3 == 4) {
                    oapnumberOfValue4 = "" + obj[0];
                    oapmonthName4 = "" + obj[1];
                    oapTotalMWOfValue4 = "" + obj[2];
                }
                if (i3 == 5) {
                    oapnumberOfValue5 = "" + obj[0];
                    oapmonthName5 = "" + obj[1];
                    oapTotalMWOfValue5 = "" + obj[2];
                }

                if (i3 == 6) {
                    oapnumberOfValue6 = "" + obj[0];
                    oapmonthName6 = "" + obj[1];
                    oapTotalMWOfValue6 = "" + obj[2];
                }
                if (i3 == 7) {
                    oapnumberOfValue7 = "" + obj[0];
                    oapmonthName7 = "" + obj[1];
                    oapTotalMWOfValue7 = "" + obj[2];
                }
                if (i3 == 8) {
                    oapnumberOfValue8 = "" + obj[0];
                    oapmonthName8 = "" + obj[1];
                    oapTotalMWOfValue8 = "" + obj[2];
                }
                if (i3 == 9) {
                    oapnumberOfValue9 = "" + obj[0];
                    oapmonthName9 = "" + obj[1];
                    oapTotalMWOfValue9 = "" + obj[2];
                }
                if (i3 == 10) {
                    oapnumberOfValue10 = "" + obj[0];
                    oapmonthName10 = "" + obj[1];
                    oapTotalMWOfValue10 = "" + obj[2];
                }
                if (i3 == 11) {
                    oapnumberOfValue11 = "" + obj[0];
                    oapmonthName11 = "" + obj[1];
                    oapTotalMWOfValue11 = "" + obj[2];
                }
                if (i3 == 12) {
                    oapnumberOfValue12 = "" + obj[0];
                    oapmonthName12 = "" + obj[1];
                    oapTotalMWOfValue12 = "" + obj[2];
                    break;
                }
            }

            mv.getModelMap().put("oapmonthName1", oapmonthName1);
            mv.getModelMap().put("oapnumberOfValue1", oapnumberOfValue1);
            mv.getModelMap().put("oapTotalMWOfValue1", oapTotalMWOfValue1);
            mv.getModelMap().put("oapmonthName2", oapmonthName2);
            mv.getModelMap().put("oapnumberOfValue2", oapnumberOfValue2);
            mv.getModelMap().put("oapTotalMWOfValue2", oapTotalMWOfValue2);
            mv.getModelMap().put("oapmonthName3", oapmonthName3);
            mv.getModelMap().put("oapnumberOfValue3", oapnumberOfValue3);
            mv.getModelMap().put("oapTotalMWOfValue3", oapTotalMWOfValue3);
            mv.getModelMap().put("oapmonthName4", oapmonthName4);
            mv.getModelMap().put("oapnumberOfValue4", oapnumberOfValue4);
            mv.getModelMap().put("oapTotalMWOfValue4", oapTotalMWOfValue4);
            mv.getModelMap().put("oapmonthName5", oapmonthName5);
            mv.getModelMap().put("oapnumberOfValue5", oapnumberOfValue5);
            mv.getModelMap().put("oapTotalMWOfValue5", oapTotalMWOfValue5);
            mv.getModelMap().put("oapmonthName6", oapmonthName6);
            mv.getModelMap().put("oapnumberOfValue6", oapnumberOfValue6);
            mv.getModelMap().put("oapTotalMWOfValue6", oapTotalMWOfValue6);
            mv.getModelMap().put("oapmonthName7", oapmonthName7);
            mv.getModelMap().put("oapnumberOfValue7", oapnumberOfValue7);
            mv.getModelMap().put("oapTotalMWOfValue7", oapTotalMWOfValue7);
            mv.getModelMap().put("oapmonthName8", oapmonthName8);
            mv.getModelMap().put("oapnumberOfValue8", oapnumberOfValue8);
            mv.getModelMap().put("oapTotalMWOfValue8", oapTotalMWOfValue8);
            mv.getModelMap().put("oapmonthName9", oapmonthName9);
            mv.getModelMap().put("oapnumberOfValue9", oapnumberOfValue9);
            mv.getModelMap().put("oapTotalMWOfValue9", oapTotalMWOfValue9);
            mv.getModelMap().put("oapmonthName10", oapmonthName10);
            mv.getModelMap().put("oapnumberOfValue10", oapnumberOfValue10);
            mv.getModelMap().put("oapTotalMWOfValue10", oapTotalMWOfValue10);
            mv.getModelMap().put("oapmonthName11", oapmonthName11);
            mv.getModelMap().put("oapnumberOfValue11", oapnumberOfValue11);
            mv.getModelMap().put("oapTotalMWOfValue11", oapTotalMWOfValue11);
            mv.getModelMap().put("oapmonthName12", oapmonthName12);
            mv.getModelMap().put("oapnumberOfValue12", oapnumberOfValue12);
            mv.getModelMap().put("oapTotalMWOfValue12", oapTotalMWOfValue12);

//====================================================================================================
//            Month Wise AOC Data
//==================================================================================================== 
            List monthWiseList = aocFormService.readByMonthAoc(from_date);

            String aocmonthName1 = "";
            String aocnumberOfValue1 = "";
            String aocTotalMWOfValue1 = "";

            String aocmonthName2 = "";
            String aocnumberOfValue2 = "";
            String aocTotalMWOfValue2 = "";

            String aocmonthName3 = "";
            String aocnumberOfValue3 = "";
            String aocTotalMWOfValue3 = "";

            String aocmonthName4 = "";
            String aocnumberOfValue4 = "";
            String aocTotalMWOfValue4 = "";

            String aocmonthName5 = "";
            String aocnumberOfValue5 = "";
            String aocTotalMWOfValue5 = "";

            String aocmonthName6 = "";
            String aocnumberOfValue6 = "";
            String aocTotalMWOfValue6 = "";

            String aocmonthName7 = "";
            String aocnumberOfValue7 = "";
            String aocTotalMWOfValue7 = "";

            String aocmonthName8 = "";
            String aocnumberOfValue8 = "";
            String aocTotalMWOfValue8 = "";

            String aocmonthName9 = "";
            String aocnumberOfValue9 = "";
            String aocTotalMWOfValue9 = "";

            String aocmonthName10 = "";
            String aocnumberOfValue10 = "";
            String aocTotalMWOfValue10 = "";

            String aocmonthName11 = "";
            String aocnumberOfValue11 = "";
            String aocTotalMWOfValue11 = "";

            String aocmonthName12 = "";
            String aocnumberOfValue12 = "";
            String aocTotalMWOfValue12 = "";
            int i2 = 0;

            for (Object empId1 : monthWiseList) {
                i2++;

                Object[] obj = (Object[]) empId1;
                if (i2 == 1) {
                    aocnumberOfValue1 = "" + obj[0];
                    aocmonthName1 = "" + obj[1];
                    aocTotalMWOfValue1 = "" + obj[2];

                }
                if (i2 == 2) {
                    aocnumberOfValue2 = "" + obj[0];
                    aocmonthName2 = "" + obj[1];
                    aocTotalMWOfValue2 = "" + obj[2];
                }
                if (i2 == 3) {
                    aocnumberOfValue3 = "" + obj[0];
                    aocmonthName3 = "" + obj[1];
                    aocTotalMWOfValue3 = "" + obj[2];
                }
                if (i2 == 4) {
                    aocnumberOfValue4 = "" + obj[0];
                    aocmonthName4 = "" + obj[1];
                    aocTotalMWOfValue4 = "" + obj[2];
                }
                if (i2 == 5) {
                    aocnumberOfValue5 = "" + obj[0];
                    aocmonthName5 = "" + obj[1];
                    aocTotalMWOfValue5 = "" + obj[2];
                }

                if (i2 == 6) {
                    aocnumberOfValue6 = "" + obj[0];
                    aocmonthName6 = "" + obj[1];
                    aocTotalMWOfValue6 = "" + obj[2];
                }
                if (i2 == 7) {
                    aocnumberOfValue7 = "" + obj[0];
                    aocmonthName7 = "" + obj[1];
                    aocTotalMWOfValue7 = "" + obj[2];
                }
                if (i2 == 8) {
                    aocnumberOfValue8 = "" + obj[0];
                    aocmonthName8 = "" + obj[1];
                    aocTotalMWOfValue8 = "" + obj[2];
                }
                if (i2 == 9) {
                    aocnumberOfValue9 = "" + obj[0];
                    aocmonthName9 = "" + obj[1];
                    aocTotalMWOfValue9 = "" + obj[2];
                }
                if (i2 == 10) {
                    aocnumberOfValue10 = "" + obj[0];
                    aocmonthName10 = "" + obj[1];
                    aocTotalMWOfValue10 = "" + obj[2];

                }
                if (i2 == 11) {
                    aocnumberOfValue11 = "" + obj[0];
                    aocmonthName11 = "" + obj[1];
                    aocTotalMWOfValue11 = "" + obj[2];
                }
                if (i2 == 12) {
                    aocnumberOfValue12 = "" + obj[0];
                    aocmonthName12 = "" + obj[1];
                    aocTotalMWOfValue12 = "" + obj[2];
                    break;
                }

            }

            mv.getModelMap().put("aocmonthName1", aocmonthName1);
            mv.getModelMap().put("aocnumberOfValue1", aocnumberOfValue1);
            mv.getModelMap().put("aocTotalMWOfValue1", aocTotalMWOfValue1);
            mv.getModelMap().put("aocmonthName2", aocmonthName2);
            mv.getModelMap().put("aocnumberOfValue2", aocnumberOfValue2);
            mv.getModelMap().put("aocTotalMWOfValue2", aocTotalMWOfValue2);
            mv.getModelMap().put("aocmonthName3", aocmonthName3);
            mv.getModelMap().put("aocnumberOfValue3", aocnumberOfValue3);
            mv.getModelMap().put("aocTotalMWOfValue3", aocTotalMWOfValue3);
            mv.getModelMap().put("aocmonthName4", aocmonthName4);
            mv.getModelMap().put("aocnumberOfValue4", aocnumberOfValue4);
            mv.getModelMap().put("aocTotalMWOfValue4", aocTotalMWOfValue4);
            mv.getModelMap().put("aocmonthName5", aocmonthName5);
            mv.getModelMap().put("aocnumberOfValue5", aocnumberOfValue5);
            mv.getModelMap().put("aocTotalMWOfValue5", aocTotalMWOfValue5);
            mv.getModelMap().put("aocmonthName6", aocmonthName6);
            mv.getModelMap().put("aocnumberOfValue6", aocnumberOfValue6);
            mv.getModelMap().put("aocTotalMWOfValue6", aocTotalMWOfValue6);
            mv.getModelMap().put("aocmonthName7", aocmonthName7);
            mv.getModelMap().put("aocnumberOfValue7", aocnumberOfValue7);
            mv.getModelMap().put("aocTotalMWOfValue7", aocTotalMWOfValue7);
            mv.getModelMap().put("aocmonthName8", aocmonthName8);
            mv.getModelMap().put("aocnumberOfValue8", aocnumberOfValue8);
            mv.getModelMap().put("aocTotalMWOfValue8", aocTotalMWOfValue8);
            mv.getModelMap().put("aocmonthName9", aocmonthName9);
            mv.getModelMap().put("aocnumberOfValue9", aocnumberOfValue9);
            mv.getModelMap().put("aocTotalMWOfValue9", aocTotalMWOfValue9);
            mv.getModelMap().put("aocmonthName10", aocmonthName10);
            mv.getModelMap().put("aocnumberOfValue10", aocnumberOfValue10);
            mv.getModelMap().put("aocTotalMWOfValue10", aocTotalMWOfValue10);
            mv.getModelMap().put("aocmonthName11", aocmonthName11);
            mv.getModelMap().put("aocnumberOfValue11", aocnumberOfValue11);
            mv.getModelMap().put("aocmonthName12", aocmonthName12);
            mv.getModelMap().put("aocnumberOfValue12", aocnumberOfValue12);
            mv.getModelMap().put("aocTotalMWOfValue12", aocTotalMWOfValue12);

//====================================================================================================
//            Designation-Wise Tracking Project Coordinator OAP&AOC
//==================================================================================================== 
            List contwise = oapFormService.readByProjectCoordinator();

            String firstElement1_1 = "", firstElement1_2 = "", firstElement1_3 = "", firstElement1_4 = "", firstElement1_5 = "", firstElement1_6 = "";
            String secondElement1_1 = "", secondElement1_2 = "", secondElement1_3 = "", secondElement1_4 = "", secondElement1_5 = "", secondElement1_6 = "";
            String thirdElement1_1 = "", thirdElement1_2 = "", thirdElement1_3 = "", thirdElement1_4 = "", thirdElement1_5 = "", thirdElement1_6 = "";
            String fourthElement1_1 = "", fourthElement1_2 = "", fourthElement1_3 = "", fourthElement1_4 = "", fourthElement1_5 = "", fourthElement1_6 = "";
            String fifthElement1_1 = "", fifthElement1_2 = "", fifthElement1_3 = "", fifthElement1_4 = "", fifthElement1_5 = "", fifthElement1_6 = "";
            String sixthElement1_1 = "", sixthElement1_2 = "", sixthElement1_3 = "", sixthElement1_4 = "", sixthElement1_5 = "", sixthElement1_6 = "";
            String seventhElement1_1 = "", seventhElement1_2 = "", seventhElement1_3 = "", seventhElement1_4 = "", seventhElement1_5 = "", seventhElement1_6 = "";
            String eighthElement1_1 = "", eighthElement1_2 = "", eighthElement1_3 = "", eighthElement1_4 = "", eighthElement1_5 = "", eighthElement1_6 = "";
            String ninthElement1_1 = "", ninthElement1_2 = "", ninthElement1_3 = "", ninthElement1_4 = "", ninthElement1_5 = "", ninthElement1_6 = "";
            String tenthElement1_1 = "", tenthElement1_2 = "", tenthElement1_3 = "", tenthElement1_4 = "", tenthElement1_5 = "", tenthElement1_6 = "";

            int count = 0;

            for (Object o1 : contwise) {
                Object[] o11 = (Object[]) o1;

                if (o11.length > 4) {  // Make sure we have all 5 columns
                    String elementValue1 = o11[0] != null ? o11[0].toString() : "";
                    String elementValue2 = o11[1] != null ? o11[1].toString() : "0";
                    String elementValue3 = o11[2] != null ? o11[2].toString() : "0";
                    String elementValue4 = o11[3] != null ? o11[3].toString() : "0";
                    String elementValue5 = o11[4] != null ? o11[4].toString() : "0";
                    String elementValue6 = o11[5] != null ? o11[5].toString() : "0";

                    if (count == 0) {
                        firstElement1_1 = elementValue1;
                        firstElement1_2 = elementValue2;
                        firstElement1_3 = elementValue3;
                        firstElement1_4 = elementValue4;
                        firstElement1_5 = elementValue5;
                        firstElement1_6 = elementValue6;

                    } else if (count == 1) {
                        secondElement1_1 = elementValue1;
                        secondElement1_2 = elementValue2;
                        secondElement1_3 = elementValue3;
                        secondElement1_4 = elementValue4;
                        secondElement1_5 = elementValue5;
                        secondElement1_6 = elementValue6;

                    } else if (count == 2) {
                        thirdElement1_1 = elementValue1;
                        thirdElement1_2 = elementValue2;
                        thirdElement1_3 = elementValue3;
                        thirdElement1_4 = elementValue4;
                        thirdElement1_5 = elementValue5;
                        thirdElement1_6 = elementValue6;

                    } else if (count == 3) {
                        fourthElement1_1 = elementValue1;
                        fourthElement1_2 = elementValue2;
                        fourthElement1_3 = elementValue3;
                        fourthElement1_4 = elementValue4;
                        fourthElement1_5 = elementValue5;
                        fourthElement1_6 = elementValue6;

                    } else if (count == 4) {
                        fifthElement1_1 = elementValue1;
                        fifthElement1_2 = elementValue2;
                        fifthElement1_3 = elementValue3;
                        fifthElement1_4 = elementValue4;
                        fifthElement1_5 = elementValue5;
                        fifthElement1_6 = elementValue6;

                    } else if (count == 5) {
                        sixthElement1_1 = elementValue1;
                        sixthElement1_2 = elementValue2;
                        sixthElement1_3 = elementValue3;
                        sixthElement1_4 = elementValue4;
                        sixthElement1_5 = elementValue5;
                        sixthElement1_6 = elementValue6;

                    } else if (count == 6) {
                        seventhElement1_1 = elementValue1;
                        seventhElement1_2 = elementValue2;
                        seventhElement1_3 = elementValue3;
                        seventhElement1_4 = elementValue4;
                        seventhElement1_5 = elementValue5;
                        seventhElement1_6 = elementValue6;

                    } else if (count == 7) {
                        eighthElement1_1 = elementValue1;
                        eighthElement1_2 = elementValue2;
                        eighthElement1_3 = elementValue3;
                        eighthElement1_4 = elementValue4;
                        eighthElement1_5 = elementValue5;
                        eighthElement1_6 = elementValue6;

                    } else if (count == 8) {
                        ninthElement1_1 = elementValue1;
                        ninthElement1_2 = elementValue2;
                        ninthElement1_3 = elementValue3;
                        ninthElement1_4 = elementValue4;
                        ninthElement1_5 = elementValue5;
                        ninthElement1_6 = elementValue6;

                    } else if (count == 9) {
                        tenthElement1_1 = elementValue1;
                        tenthElement1_2 = elementValue2;
                        tenthElement1_3 = elementValue3;
                        tenthElement1_4 = elementValue4;
                        tenthElement1_5 = elementValue5;
                        tenthElement1_6 = elementValue6;
                        break;

                    }
                }
                count++;
                System.out.println("Processing row: " + count);
            }
            // Pass everything to the model map
            mv.getModelMap().put("firstElement1_1", firstElement1_1);
            mv.getModelMap().put("firstElement1_2", firstElement1_2);
            mv.getModelMap().put("firstElement1_3", firstElement1_3);
            mv.getModelMap().put("firstElement1_4", firstElement1_4);
            mv.getModelMap().put("firstElement1_5", firstElement1_5);
            mv.getModelMap().put("firstElement1_6", firstElement1_6);

            mv.getModelMap().put("secondElement1_1", secondElement1_1);
            mv.getModelMap().put("secondElement1_2", secondElement1_2);
            mv.getModelMap().put("secondElement1_3", secondElement1_3);
            mv.getModelMap().put("secondElement1_4", secondElement1_4);
            mv.getModelMap().put("secondElement1_5", secondElement1_5);
            mv.getModelMap().put("secondElement1_6", secondElement1_6);

            mv.getModelMap().put("thirdElement1_1", thirdElement1_1);
            mv.getModelMap().put("thirdElement1_2", thirdElement1_2);
            mv.getModelMap().put("thirdElement1_3", thirdElement1_3);
            mv.getModelMap().put("thirdElement1_4", thirdElement1_4);
            mv.getModelMap().put("thirdElement1_5", thirdElement1_5);
            mv.getModelMap().put("thirdElement1_6", thirdElement1_6);

            mv.getModelMap().put("fourthElement1_1", fourthElement1_1);
            mv.getModelMap().put("fourthElement1_2", fourthElement1_2);
            mv.getModelMap().put("fourthElement1_3", fourthElement1_3);
            mv.getModelMap().put("fourthElement1_4", fourthElement1_4);
            mv.getModelMap().put("fourthElement1_5", fourthElement1_5);
            mv.getModelMap().put("fourthElement1_6", fourthElement1_6);

            mv.getModelMap().put("fifthElement1_1", fifthElement1_1);
            mv.getModelMap().put("fifthElement1_2", fifthElement1_2);
            mv.getModelMap().put("fifthElement1_3", fifthElement1_3);
            mv.getModelMap().put("fifthElement1_4", fifthElement1_4);
            mv.getModelMap().put("fifthElement1_5", fifthElement1_5);
            mv.getModelMap().put("fifthElement1_6", fifthElement1_6);

            mv.getModelMap().put("sixthElement1_1", sixthElement1_1);
            mv.getModelMap().put("sixthElement1_2", sixthElement1_2);
            mv.getModelMap().put("sixthElement1_3", sixthElement1_3);
            mv.getModelMap().put("sixthElement1_4", sixthElement1_4);
            mv.getModelMap().put("sixthElement1_5", sixthElement1_5);
            mv.getModelMap().put("sixthElement1_6", sixthElement1_6);

            mv.getModelMap().put("seventhElement1_1", seventhElement1_1);
            mv.getModelMap().put("seventhElement1_2", seventhElement1_2);
            mv.getModelMap().put("seventhElement1_3", seventhElement1_3);
            mv.getModelMap().put("seventhElement1_4", seventhElement1_4);
            mv.getModelMap().put("seventhElement1_5", seventhElement1_5);
            mv.getModelMap().put("seventhElement1_6", seventhElement1_6);

            mv.getModelMap().put("eighthElement1_1", eighthElement1_1);
            mv.getModelMap().put("eighthElement1_2", eighthElement1_2);
            mv.getModelMap().put("eighthElement1_3", eighthElement1_3);
            mv.getModelMap().put("eighthElement1_4", eighthElement1_4);
            mv.getModelMap().put("eighthElement1_5", eighthElement1_5);
            mv.getModelMap().put("eighthElement1_6", eighthElement1_6);

            mv.getModelMap().put("ninthElement1_1", ninthElement1_1);
            mv.getModelMap().put("ninthElement1_2", ninthElement1_2);
            mv.getModelMap().put("ninthElement1_3", ninthElement1_3);
            mv.getModelMap().put("ninthElement1_4", ninthElement1_4);
            mv.getModelMap().put("ninthElement1_5", ninthElement1_5);
            mv.getModelMap().put("ninthElement1_6", ninthElement1_6);

            mv.getModelMap().put("tenthElement1_1", tenthElement1_1);
            mv.getModelMap().put("tenthElement1_2", tenthElement1_2);
            mv.getModelMap().put("tenthElement1_3", tenthElement1_3);
            mv.getModelMap().put("tenthElement1_4", tenthElement1_4);
            mv.getModelMap().put("tenthElement1_5", tenthElement1_5);
            mv.getModelMap().put("tenthElement1_6", tenthElement1_6);

//====================================================================================================
//            Designation-Wise Tracking Project Manger OAP&AOC
//==================================================================================================== 
            List contwise1 = oapFormService.readByProjectManger();

            String firstElement1_10 = "", firstElement1_20 = "", firstElement1_30 = "", firstElement1_40 = "";
            String secondElement1_10 = "", secondElement1_20 = "", secondElement1_30 = "", secondElement1_40 = "";
            String thirdElement1_10 = "", thirdElement1_20 = "", thirdElement1_30 = "", thirdElement1_40 = "";
            String fourthElement1_10 = "", fourthElement1_20 = "", fourthElement1_30 = "", fourthElement1_40 = "";
            String fifthElement1_10 = "", fifthElement1_20 = "", fifthElement1_30 = "", fifthElement1_40 = "";
            String sixthElement1_10 = "", sixthElement1_20 = "", sixthElement1_30 = "", sixthElement1_40 = "";
            String seventhElement1_10 = "", seventhElement1_20 = "", seventhElement1_30 = "", seventhElement1_40 = "";
            String eighthElement1_10 = "", eighthElement1_20 = "", eighthElement1_30 = "", eighthElement1_40 = "";
            String ninthElement1_10 = "", ninthElement1_20 = "", ninthElement1_30 = "", ninthElement1_40 = "";
            String tenthElement1_10 = "", tenthElement1_20 = "", tenthElement1_30 = "", tenthElement1_40 = "";

            int counts = 0;

            for (Object o1 : contwise1) {
                Object[] o11 = (Object[]) o1;

                if (o11.length > 3) {  // Make sure we have all 4 columns
                    String elementValue10 = o11[0] != null ? o11[0].toString() : "";
                    String elementValue20 = o11[1] != null ? o11[1].toString() : "0";
                    String elementValue30 = o11[2] != null ? o11[2].toString() : "0";
                    String elementValue40 = o11[3] != null ? o11[3].toString() : "0";

                    if (counts == 0) {
                        firstElement1_10 = elementValue10;
                        firstElement1_20 = elementValue20;
                        firstElement1_30 = elementValue30;
                        firstElement1_40 = elementValue40;

                    } else if (counts == 1) {
                        secondElement1_10 = elementValue10;
                        secondElement1_20 = elementValue20;
                        secondElement1_30 = elementValue30;
                        secondElement1_40 = elementValue40;

                    } else if (counts == 2) {
                        thirdElement1_10 = elementValue10;
                        thirdElement1_20 = elementValue20;
                        thirdElement1_30 = elementValue30;
                        thirdElement1_40 = elementValue40;

                    } else if (counts == 3) {
                        fourthElement1_10 = elementValue10;
                        fourthElement1_20 = elementValue20;
                        fourthElement1_30 = elementValue30;
                        fourthElement1_40 = elementValue40;

                    } else if (counts == 4) {
                        fifthElement1_10 = elementValue10;
                        fifthElement1_20 = elementValue20;
                        fifthElement1_30 = elementValue30;
                        fifthElement1_40 = elementValue40;

                    } else if (counts == 5) {
                        sixthElement1_10 = elementValue10;
                        sixthElement1_20 = elementValue20;
                        sixthElement1_30 = elementValue30;
                        sixthElement1_40 = elementValue40;

                    } else if (counts == 6) {
                        seventhElement1_10 = elementValue10;
                        seventhElement1_20 = elementValue20;
                        seventhElement1_30 = elementValue30;
                        seventhElement1_40 = elementValue40;

                    } else if (counts == 7) {
                        eighthElement1_10 = elementValue10;
                        eighthElement1_20 = elementValue20;
                        eighthElement1_30 = elementValue30;
                        eighthElement1_40 = elementValue40;

                    } else if (counts == 8) {
                        ninthElement1_10 = elementValue10;
                        ninthElement1_20 = elementValue20;
                        ninthElement1_30 = elementValue30;
                        ninthElement1_40 = elementValue40;

                    } else if (counts == 9) {
                        tenthElement1_10 = elementValue10;
                        tenthElement1_20 = elementValue20;
                        tenthElement1_30 = elementValue30;
                        tenthElement1_40 = elementValue40;
                        break;

                    }
                }
                counts++;
                System.out.println("Processing row: " + counts);
            }

            // Pass everything to the model map
            mv.getModelMap().put("firstElement1_10", firstElement1_10);
            mv.getModelMap().put("firstElement1_20", firstElement1_20);
            mv.getModelMap().put("firstElement1_30", firstElement1_30);
            mv.getModelMap().put("firstElement1_40", firstElement1_40);

            mv.getModelMap().put("secondElement1_10", secondElement1_10);
            mv.getModelMap().put("secondElement1_20", secondElement1_20);
            mv.getModelMap().put("secondElement1_30", secondElement1_30);
            mv.getModelMap().put("secondElement1_40", secondElement1_40);

            mv.getModelMap().put("thirdElement1_10", thirdElement1_10);
            mv.getModelMap().put("thirdElement1_20", thirdElement1_20);
            mv.getModelMap().put("thirdElement1_30", thirdElement1_30);
            mv.getModelMap().put("thirdElement1_40", thirdElement1_40);

            mv.getModelMap().put("fourthElement1_10", fourthElement1_10);
            mv.getModelMap().put("fourthElement1_20", fourthElement1_20);
            mv.getModelMap().put("fourthElement1_30", fourthElement1_30);
            mv.getModelMap().put("fourthElement1_40", fourthElement1_40);

            mv.getModelMap().put("fifthElement1_10", fifthElement1_10);
            mv.getModelMap().put("fifthElement1_20", fifthElement1_20);
            mv.getModelMap().put("fifthElement1_30", fifthElement1_30);
            mv.getModelMap().put("fifthElement1_40", fifthElement1_40);

            mv.getModelMap().put("sixthElement1_10", sixthElement1_10);
            mv.getModelMap().put("sixthElement1_20", sixthElement1_20);
            mv.getModelMap().put("sixthElement1_30", sixthElement1_30);
            mv.getModelMap().put("sixthElement1_40", sixthElement1_40);

            mv.getModelMap().put("seventhElement1_10", seventhElement1_10);
            mv.getModelMap().put("seventhElement1_20", seventhElement1_20);
            mv.getModelMap().put("seventhElement1_30", seventhElement1_30);
            mv.getModelMap().put("seventhElement1_40", seventhElement1_40);

            mv.getModelMap().put("eighthElement1_10", eighthElement1_10);
            mv.getModelMap().put("eighthElement1_20", eighthElement1_20);
            mv.getModelMap().put("eighthElement1_30", eighthElement1_30);
            mv.getModelMap().put("eighthElement1_40", eighthElement1_40);

            mv.getModelMap().put("ninthElement1_10", ninthElement1_10);
            mv.getModelMap().put("ninthElement1_20", ninthElement1_20);
            mv.getModelMap().put("ninthElement1_30", ninthElement1_30);
            mv.getModelMap().put("ninthElement1_40", ninthElement1_40);

            mv.getModelMap().put("tenthElement1_10", tenthElement1_10);
            mv.getModelMap().put("tenthElement1_20", tenthElement1_20);
            mv.getModelMap().put("tenthElement1_30", tenthElement1_30);
            mv.getModelMap().put("tenthElement1_40", tenthElement1_40);

//====================================================================================================
//            Month-wise analytics OAP
//====================================================================================================  
            Calendar cals = Calendar.getInstance();
            cals.add(Calendar.MONTH, -11);  // NOT -12 (explained below)
            cals.set(Calendar.DAY_OF_MONTH, 1); // start of month

            Date fromDate = cals.getTime();
            String from_date5 = new SimpleDateFormat("dd/MM/yyyy").format(fromDate);

            List Monthwiseanalytics = oapFormService.readByMonthWiseAnalytics(from_date5);

            String[] noOfChargermonthNames = new String[12];
            String[] noOfChargernumberOfValues = new String[12];

            int index = 0;

            for (Object item : Monthwiseanalytics) {

                if (index >= 12) {
                    break;
                }

                Object[] obj = (Object[]) item;

                if (obj == null || obj.length < 6) {
                    continue;
                }

                noOfChargernumberOfValues[index] = String.valueOf(obj[1]);
                noOfChargermonthNames[index] = String.valueOf(obj[5]);

                int s = index + 1;

                String names = "noOfChargermonthNames" + s;
                String values = "noOfChargernumberOfValue" + s;

                mv.getModelMap().put(names, noOfChargermonthNames[index]);
                mv.getModelMap().put(values, noOfChargernumberOfValues[index]);
                index++;
            }

//            totalChargerCapacity
            String[] totalChargerCapacitymonthNames = new String[12];
            String[] totalChargerCapacitynumberOfValues = new String[12];

            int indextotal = 0;

            for (Object item : Monthwiseanalytics) {

                if (indextotal >= 12) {
                    break;
                }

                Object[] obj = (Object[]) item;

                if (obj == null || obj.length < 6) {
                    continue;
                }

                totalChargerCapacitynumberOfValues[indextotal] = String.valueOf(obj[2]);
                totalChargerCapacitymonthNames[indextotal] = String.valueOf(obj[5]);

                int s = indextotal + 1;

                String names = "totalChargerCapacitymonthNames" + s;
                String values = "totalChargerCapacitynumberOfValue" + s;

                mv.getModelMap().put(names, totalChargerCapacitymonthNames[indextotal]);
                mv.getModelMap().put(values, totalChargerCapacitynumberOfValues[indextotal]);
                indextotal++;

            }

//            totalKwRating
            String[] totalKwRatingmonthNames = new String[12];
            String[] totalKwRatingnumberOfValues = new String[12];

            int indextotalKW = 0;

            for (Object item : Monthwiseanalytics) {

                if (indextotalKW >= 12) {
                    break;
                }

                Object[] obj = (Object[]) item;

                if (obj == null || obj.length < 6) {
                    continue;
                }

                totalKwRatingnumberOfValues[indextotalKW] = String.valueOf(obj[3]);
                totalKwRatingmonthNames[indextotalKW] = String.valueOf(obj[5]);

                int s = indextotalKW + 1;

                String names = "totalKwRatingmonthNames" + s;
                String values = "totalKwRatingnumberOfValue" + s;

                mv.getModelMap().put(names, totalKwRatingmonthNames[indextotalKW]);
                mv.getModelMap().put(values, totalKwRatingnumberOfValues[indextotalKW]);
                indextotalKW++;

            }
//====================================================================================================
//            AOC MonthWiseAnalytics
//==================================================================================================== 

            List Monthwiseanalytics1 = aocFormService.readByMonthWiseAnalytics(from_date5);

            String[] aocanalyticsmonthNames = new String[12];
            String[] aocanalyticsnumberOfValues = new String[12];

            int indexs = 0;

            for (Object item : Monthwiseanalytics1) {

                if (indexs >= 12) {
                    break;
                }

                Object[] obj = (Object[]) item;

                if (obj == null || obj.length < 6) {
                    continue;
                }

                aocanalyticsnumberOfValues[indexs] = String.valueOf(obj[1]);
                aocanalyticsmonthNames[indexs] = String.valueOf(obj[5]);

                int s = indexs + 1;

                String names = "aocanalyticsmonthNames" + s;
                String values = "aocanalyticsnumberOfValue" + s;

                mv.getModelMap().put(names, aocanalyticsmonthNames[indexs]);
                mv.getModelMap().put(values, aocanalyticsnumberOfValues[indexs]);
                indexs++;
            }

            //            totalChargerCapacity
            String[] aoctotalChargerCapacitymonthNames = new String[12];
            String[] aoctotalChargerCapacitynumberOfValues = new String[12];

            int aocindextotal = 0;

            for (Object item : Monthwiseanalytics1) {

                if (aocindextotal >= 12) {
                    break;
                }

                Object[] obj = (Object[]) item;

                if (obj == null || obj.length < 6) {
                    continue;
                }

                aoctotalChargerCapacitynumberOfValues[aocindextotal] = String.valueOf(obj[2]);
                aoctotalChargerCapacitymonthNames[aocindextotal] = String.valueOf(obj[5]);

                int s = aocindextotal + 1;

                String names = "aoctotalChargerCapacitymonthNames" + s;
                String values = "aoctotalChargerCapacitynumberOfValue" + s;

                mv.getModelMap().put(names, aoctotalChargerCapacitymonthNames[aocindextotal]);
                mv.getModelMap().put(values, aoctotalChargerCapacitynumberOfValues[aocindextotal]);
                aocindextotal++;

            }

//            totalKwRating
            String[] aoctotalKwRatingmonthNames = new String[12];
            String[] aoctotalKwRatingnumberOfValues = new String[12];

            int aocindextotalKW = 0;

            for (Object item : Monthwiseanalytics1) {

                if (aocindextotalKW >= 12) {
                    break;
                }

                Object[] obj = (Object[]) item;

                if (obj == null || obj.length < 6) {
                    continue;
                }

                aoctotalKwRatingnumberOfValues[aocindextotalKW] = String.valueOf(obj[3]);
                aoctotalKwRatingmonthNames[aocindextotalKW] = String.valueOf(obj[5]);

                int s = aocindextotalKW + 1;

                String names = "aoctotalKwRatingmonthNames" + s;
                String values = "aoctotalKwRatingnumberOfValue" + s;

                mv.getModelMap().put(names, aoctotalKwRatingmonthNames[aocindextotalKW]);
                mv.getModelMap().put(values, aoctotalKwRatingnumberOfValues[aocindextotalKW]);
                aocindextotalKW++;

            }

//====================================================================================================
//            Equator Bifurcation OAP Ethan Wise
//====================================================================================================  
            List EthanBurification = oapFormService.readByMonthWiseEthanBurification(from_date5);

            Map<String, Map<YearMonth, Integer>> customerMonthMap = new HashMap<>();
            Set<YearMonth> monthSet = new TreeSet<>();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);

            for (Object obj : EthanBurification) {
                Object[] row = (Object[]) obj;

                String customer = row[0].toString();
                int count100 = ((Number) row[1]).intValue();
                String monthStr = row[2].toString();

                YearMonth ym = YearMonth.parse(monthStr, formatter);

                monthSet.add(ym);

                customerMonthMap
                        .computeIfAbsent(customer, k -> new HashMap<>())
                        .put(ym, count100);
            }

            List<String> labels = monthSet.stream()
                    .map(m -> m.format(formatter))
                    .collect(Collectors.toList());

            List<Map<String, Object>> datasets = new ArrayList<>();

            for (String customer : customerMonthMap.keySet()) {

                Map<YearMonth, Integer> monthData = customerMonthMap.get(customer);
                List<Integer> data = new ArrayList<>();

                for (YearMonth m : monthSet) {
                    data.add(monthData.getOrDefault(m, 0));
                }

                Map<String, Object> ds = new HashMap<>();
                ds.put("label", customer);
                ds.put("data", data);

                datasets.add(ds);
            }

            Map<String, Object> chartMap = new HashMap<>();
            chartMap.put("labels", labels);
            chartMap.put("datasets", datasets);

            String json = new Gson().toJson(chartMap);
            request.setAttribute("chartData", json);

//====================================================================================================
//           Equator Bifurcation OAP Equator Wise
//====================================================================================================     
            List EquatorBurification = oapFormService.readByMonthWiseEquaBurification(from_date5);

            Map<String, Map<YearMonth, Integer>> customerEquaMonthMap = new HashMap<>();
            Set<YearMonth> monthSetEqua = new TreeSet<>();

            DateTimeFormatter formatterEqua = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);

            for (Object obj : EquatorBurification) {
                Object[] row = (Object[]) obj;

                String customer = row[0].toString();
                int count100 = ((Number) row[1]).intValue();
                String monthStr = row[2].toString();

                YearMonth ym = YearMonth.parse(monthStr, formatterEqua);

                monthSetEqua.add(ym);

                customerEquaMonthMap
                        .computeIfAbsent(customer, k -> new HashMap<>())
                        .put(ym, count100);
            }

            /* FIX 1: monthSet -> monthSetEqua */
            List<String> labelsEqua = monthSetEqua.stream()
                    .map(m -> m.format(formatterEqua))
                    .collect(Collectors.toList());

            List<Map<String, Object>> datasetsEqua = new ArrayList<>();

            for (String customer : customerEquaMonthMap.keySet()) {

                Map<YearMonth, Integer> monthData = customerEquaMonthMap.get(customer);
                List<Integer> data = new ArrayList<>();

                /* FIX 2: monthSet -> monthSetEqua */
                for (YearMonth m : monthSetEqua) {
                    data.add(monthData.getOrDefault(m, 0));
                }

                Map<String, Object> ds = new HashMap<>();
                ds.put("label", customer);
                ds.put("data", data);

                datasetsEqua.add(ds);
            }

            Map<String, Object> chartMapEqua = new HashMap<>();
            chartMapEqua.put("labels", labelsEqua);
            chartMapEqua.put("datasets", datasetsEqua);

            /* FIX 3: chartMap -> chartMapEqua */
            String jsonEqua = new Gson().toJson(chartMapEqua);

            request.setAttribute("chartDataEqua", jsonEqua);

            mv.getModelMap().put("EquatorBurification", EquatorBurification);

//====================================================================================================
//           Equator Bifurcation OAP Hub Wise
//====================================================================================================     
            List HubBurification = oapFormService.readByMonthWiseHubBurification(from_date5);

            Map<String, Map<YearMonth, Integer>> customerHubMonthMap = new HashMap<>();
            Set<YearMonth> monthSetHub = new TreeSet<>();

            DateTimeFormatter formatterHub = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);

            for (Object obj : HubBurification) {
                Object[] row = (Object[]) obj;

                String customer = row[0].toString();
                int count100 = ((Number) row[1]).intValue();
                String monthStr = row[2].toString();

                YearMonth ym = YearMonth.parse(monthStr, formatterHub);

                monthSetHub.add(ym);

                customerHubMonthMap
                        .computeIfAbsent(customer, k -> new HashMap<>())
                        .put(ym, count100);
            }

            List<String> labelsHub = monthSetHub.stream()
                    .map(m -> m.format(formatterHub))
                    .collect(Collectors.toList());

            List<Map<String, Object>> datasetsHub = new ArrayList<>();

            for (String customer : customerHubMonthMap.keySet()) {

                Map<YearMonth, Integer> monthData = customerHubMonthMap.get(customer);
                List<Integer> data = new ArrayList<>();

                for (YearMonth m : monthSetHub) {
                    data.add(monthData.getOrDefault(m, 0));
                }

                Map<String, Object> ds = new HashMap<>();
                ds.put("label", customer);
                ds.put("data", data);

                datasetsHub.add(ds);
            }

            Map<String, Object> chartMapHub = new HashMap<>();
            chartMapHub.put("labels", labelsHub);
            chartMapHub.put("datasets", datasetsHub);

            String jsonHub = new Gson().toJson(chartMapHub);

            request.setAttribute("chartDataHub", jsonHub);

            mv.getModelMap().put("HubBurification", HubBurification);
//====================================================================================================
//           Co Capex OEM Bifurcation OAP  Wise
//====================================================================================================     
            List CapexBurification = oapFormService.readByMonthWiseCapexBurification(from_date5);

            Map<String, Map<YearMonth, Integer>> customerCapexMonthMap = new HashMap<>();
            Set<YearMonth> monthSetCapex = new TreeSet<>();

            DateTimeFormatter formatterCapex = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);

            for (Object obj : CapexBurification) {
                Object[] row = (Object[]) obj;

                String customer = row[0].toString();
                int count100 = ((Number) row[1]).intValue();
                String monthStr = row[2].toString();

                YearMonth ym = YearMonth.parse(monthStr, formatterCapex);

                monthSetCapex.add(ym);

                customerCapexMonthMap
                        .computeIfAbsent(customer, k -> new HashMap<>())
                        .put(ym, count100);
            }

            List<String> labelsCapex = monthSetCapex.stream()
                    .map(m -> m.format(formatterCapex))
                    .collect(Collectors.toList());

            List<Map<String, Object>> datasetsCapex = new ArrayList<>();

            for (String customer : customerCapexMonthMap.keySet()) {

                Map<YearMonth, Integer> monthData = customerCapexMonthMap.get(customer);
                List<Integer> data = new ArrayList<>();

                for (YearMonth m : monthSetCapex) {
                    data.add(monthData.getOrDefault(m, 0));
                }

                Map<String, Object> ds = new HashMap<>();
                ds.put("label", customer);
                ds.put("data", data);

                datasetsCapex.add(ds);
            }

            Map<String, Object> chartMapCapex = new HashMap<>();
            chartMapCapex.put("labels", labelsCapex);
            chartMapCapex.put("datasets", datasetsCapex);

            String jsonCapex = new Gson().toJson(chartMapCapex);

            request.setAttribute("chartDataCapex", jsonCapex);
            mv.getModelMap().put("CapexBurification", CapexBurification);

//====================================================================================================
//            Equator Bifurcation AOC Ethan Wise
//====================================================================================================  
            List EthanBurificationAoc = aocFormService.readByMonthWiseEthanBurificationAoc(from_date5);

            Map<String, Map<YearMonth, Integer>> customerEthanMonthMap = new HashMap<>();
            Set<YearMonth> monthSetEthan = new TreeSet<>();

            DateTimeFormatter formatterEthan = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);

            for (Object obj : EthanBurificationAoc) {
                Object[] row = (Object[]) obj;

                String customer = row[0].toString();
                int count100 = ((Number) row[1]).intValue();
                String monthStr = row[2].toString();

                YearMonth ym = YearMonth.parse(monthStr, formatterEthan);

                monthSetEthan.add(ym);

                customerEthanMonthMap
                        .computeIfAbsent(customer, k -> new HashMap<>())
                        .put(ym, count100);
            }

            List<String> labelsEthan = monthSetEthan.stream()
                    .map(m -> m.format(formatterEthan))
                    .collect(Collectors.toList());

            List<Map<String, Object>> datasetsEthan = new ArrayList<>();

            for (String customer : customerEthanMonthMap.keySet()) {

                Map<YearMonth, Integer> monthData = customerEthanMonthMap.get(customer);
                List<Integer> data = new ArrayList<>();

                for (YearMonth m : monthSetEthan) {
                    data.add(monthData.getOrDefault(m, 0));
                }

                Map<String, Object> ds = new HashMap<>();
                ds.put("label", customer);
                ds.put("data", data);

                datasetsEthan.add(ds);
            }

            Map<String, Object> chartMapEthan = new HashMap<>();
            chartMapEthan.put("labels", labelsEthan);
            chartMapEthan.put("datasets", datasetsEthan);

            String jsonEthan = new Gson().toJson(chartMapEthan);

            request.setAttribute("chartDataEthan", jsonEthan);

//====================================================================================================
//           Equator Bifurcation AOC Equator Wise
//====================================================================================================     
            List EquatorBurificationAoc = aocFormService.readByMonthWiseEquaBurificationAoc(from_date5);
            Map<String, Map<YearMonth, Integer>> customerEquaAocMonthMap = new HashMap<>();
            Set<YearMonth> monthSetEquaAoc = new TreeSet<>();

            DateTimeFormatter formatterEquaAoc = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);

            for (Object obj : EquatorBurificationAoc) {
                Object[] row = (Object[]) obj;

                String customer = row[0].toString();
                int count100 = ((Number) row[1]).intValue();
                String monthStr = row[2].toString();

                YearMonth ym = YearMonth.parse(monthStr, formatterEquaAoc);

                monthSetEquaAoc.add(ym);

                customerEquaAocMonthMap
                        .computeIfAbsent(customer, k -> new HashMap<>())
                        .put(ym, count100);
            }

            List<String> labelsEquaAoc = monthSetEquaAoc.stream()
                    .map(m -> m.format(formatterEquaAoc))
                    .collect(Collectors.toList());

            List<Map<String, Object>> datasetsEquaAoc = new ArrayList<>();

            for (String customer : customerEquaAocMonthMap.keySet()) {

                Map<YearMonth, Integer> monthData = customerEquaAocMonthMap.get(customer);
                List<Integer> data = new ArrayList<>();

                for (YearMonth m : monthSetEquaAoc) {
                    data.add(monthData.getOrDefault(m, 0));
                }

                Map<String, Object> ds = new HashMap<>();
                ds.put("label", customer);
                ds.put("data", data);

                datasetsEquaAoc.add(ds);
            }

            Map<String, Object> chartMapEquaAoc = new HashMap<>();
            chartMapEquaAoc.put("labels", labelsEquaAoc);
            chartMapEquaAoc.put("datasets", datasetsEquaAoc);

            String jsonEquaAoc = new Gson().toJson(chartMapEquaAoc);

            request.setAttribute("chartDataEquaAoc", jsonEquaAoc);

//====================================================================================================
//           Equator Bifurcation AOC Hub Wise
//====================================================================================================     
            List HubBurificationAoc = aocFormService.readByMonthWiseHubBurificationAoc(from_date5);

            Map<String, Map<YearMonth, Integer>> customerHubAocMonthMap = new HashMap<>();
            Set<YearMonth> monthSetHubAoc = new TreeSet<>();

            DateTimeFormatter formatterHubAoc = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);

            for (Object obj : HubBurificationAoc) {
                Object[] row = (Object[]) obj;

                String customer = row[0].toString();
                int count100 = ((Number) row[1]).intValue();
                String monthStr = row[2].toString();

                YearMonth ym = YearMonth.parse(monthStr, formatterHubAoc);

                monthSetHubAoc.add(ym);

                customerHubAocMonthMap
                        .computeIfAbsent(customer, k -> new HashMap<>())
                        .put(ym, count100);
            }

            List<String> labelsHubAoc = monthSetHubAoc.stream()
                    .map(m -> m.format(formatterHubAoc))
                    .collect(Collectors.toList());

            List<Map<String, Object>> datasetsHubAoc = new ArrayList<>();

            for (String customer : customerHubAocMonthMap.keySet()) {

                Map<YearMonth, Integer> monthData = customerHubAocMonthMap.get(customer);
                List<Integer> data = new ArrayList<>();

                for (YearMonth m : monthSetHubAoc) {
                    data.add(monthData.getOrDefault(m, 0));
                }

                Map<String, Object> ds = new HashMap<>();
                ds.put("label", customer);
                ds.put("data", data);

                datasetsHubAoc.add(ds);
            }

            Map<String, Object> chartMapHubAoc = new HashMap<>();
            chartMapHubAoc.put("labels", labelsHubAoc);
            chartMapHubAoc.put("datasets", datasetsHubAoc);

            String jsonHubAoc = new Gson().toJson(chartMapHubAoc);

            request.setAttribute("chartDataHubAoc", jsonHubAoc);
//====================================================================================================
//           Co Capex OEM Bifurcation AOC  Wise
//====================================================================================================     
            List CapexBurificationAoc = aocFormService.readByMonthWiseCapexBurificationAoc(from_date5);

            Map<String, Map<YearMonth, Integer>> customerCapexAocMonthMap = new HashMap<>();
            Set<YearMonth> monthSetCapexAoc = new TreeSet<>();

            DateTimeFormatter formatterCapexAoc = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);

            for (Object obj : CapexBurificationAoc) {
                Object[] row = (Object[]) obj;

                String customer = row[0].toString();
                int count100 = ((Number) row[1]).intValue();
                String monthStr = row[2].toString();

                YearMonth ym = YearMonth.parse(monthStr, formatterCapexAoc);

                monthSetCapexAoc.add(ym);

                customerCapexAocMonthMap
                        .computeIfAbsent(customer, k -> new HashMap<>())
                        .put(ym, count100);
            }

            List<String> labelsCapexAoc = monthSetCapexAoc.stream()
                    .map(m -> m.format(formatterCapexAoc))
                    .collect(Collectors.toList());

            List<Map<String, Object>> datasetsCapexAoc = new ArrayList<>();

            for (String customer : customerCapexAocMonthMap.keySet()) {

                Map<YearMonth, Integer> monthData = customerCapexAocMonthMap.get(customer);
                List<Integer> data = new ArrayList<>();

                for (YearMonth m : monthSetCapexAoc) {
                    data.add(monthData.getOrDefault(m, 0));
                }

                Map<String, Object> ds = new HashMap<>();
                ds.put("label", customer);
                ds.put("data", data);

                datasetsCapexAoc.add(ds);
            }

            Map<String, Object> chartMapCapexAoc = new HashMap<>();
            chartMapCapexAoc.put("labels", labelsCapexAoc);
            chartMapCapexAoc.put("datasets", datasetsCapexAoc);

            String jsonCapexAoc = new Gson().toJson(chartMapCapexAoc);

            request.setAttribute("chartDataCapexAoc", jsonCapexAoc);

        }

        // All count
        mv.getModelMap().put("totalOap", totalOap);
        mv.getModelMap().put("approvedOap", approvedOap);
        mv.getModelMap().put("pendingOap", pendingOap);
        mv.getModelMap().put("rejctedOap", rejctedOap);
        mv.getModelMap().put("unfieldCRC", unfieldCRC);
        mv.getModelMap().put("totalCrc", totalCrc);
        mv.getModelMap().put("approvedCrc", approvedCrc);
        mv.getModelMap().put("pendingCrc", pendingCrc);
        mv.getModelMap().put("revisionCrc", revisionCrc);
        mv.getModelMap().put("partiallyApprovedCrc", partiallyApprovedCrc);
        mv.getModelMap().put("rejectedCrc", rejectedCrc);
        mv.getModelMap().put("totalDesignCoorOap", totalDesignCoorOap);
        mv.getModelMap().put("approvedDesignCoorOap", approvedDesignCoorOap);
        mv.getModelMap().put("totalProMangerOap", totalProMangerOap);
        mv.getModelMap().put("totalAoc", totalAoc);
        mv.getModelMap().put("pendingKom", pendingKom);
        mv.getModelMap().put("approvedAoc", approvedAoc);
        mv.getModelMap().put("pendingAoc", pendingAoc);
        mv.getModelMap().put("rejectedAoc", rejectedAoc);
        mv.getModelMap().put("unfieldKOM", unfieldKOM);
        mv.getModelMap().put("totalKom", totalKom);
        mv.getModelMap().put("approvedKom", approvedKom);
        mv.getModelMap().put("totalDesignCoorAoc", totalDesignCoorAoc);
        mv.getModelMap().put("approvedDesignCoorAoc", approvedDesignCoorAoc);
        mv.getModelMap().put("totalProMangerAoc", totalProMangerAoc);
        mv.getModelMap().put("rejectedKom", rejectedKom);

        mv.setViewName("Oap/oapAndAocDashboard");
        return mv;
    }

    public ModelAndView monthWiseGraphOapDeatils(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }
        String startDatee = "";
        String endDatee = "";
//        String MonthName0 = request.getParameter("label");
        String MonthName1 = request.getParameter("label");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
        String MonthName = yearMonth.format(outputFormatter);

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {

        }

//        String EndDate = endDatee;
//        String StartDate = startDatee;
//
//        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
//        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
//        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";
//
//        if (Filter.equals("--select--")) {
//            Filter = "";
//        }
//
//        try {
//            if (Filter.equals("last-month")) {
//                LocalDateTime myDateObj = LocalDateTime.now();
//                LocalDateTime startDate = myDateObj.minusDays(30);
//
//                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//                formattedDate = myDateObj.format(myFormatObj);
//                formattedStartDate = startDate.format(myFormatObj);
//            }
//            if (Filter.equals("last-week")) {
//                LocalDateTime myDateObj = LocalDateTime.now();
//                LocalDateTime startDate = myDateObj.minusDays(7);
//
//                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//                formattedDate = myDateObj.format(myFormatObj);
//                formattedStartDate = startDate.format(myFormatObj);
//            }
//            if (Filter.equals("last-year")) {
//                LocalDateTime myDateObj = LocalDateTime.now();
//                LocalDateTime startDate = myDateObj.minusDays(365);
//
//                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//                formattedDate = myDateObj.format(myFormatObj);
//                formattedStartDate = startDate.format(myFormatObj);
//            }
//            if (Filter.equals("last-6-month")) {
//                LocalDateTime myDateObj = LocalDateTime.now();
//                LocalDateTime startDate = myDateObj.minusDays(183);
//
//                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//                formattedDate = myDateObj.format(myFormatObj);
//                formattedStartDate = startDate.format(myFormatObj);
//            }
//        } catch (Exception e) {
//
//        }
//
//        List monthWiseList1 = oapFormService.monthWiseListOapGraphUser(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
//
//        mv.getModelMap().put("list", monthWiseList1);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("MonthName0", MonthName1);
        mv.setViewName("Oap/monthWiseGraphOapDeatils");
        return mv;
    }

    public ModelAndView monthWiseGraphAocDeatils(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }
        String startDatee = "";
        String endDatee = "";
//        String MonthName0 = request.getParameter("label");
        String MonthName1 = request.getParameter("label");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
        String MonthName = yearMonth.format(outputFormatter);

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {

        }
//        String EndDate = endDatee;
//        String StartDate = startDatee;
//
//        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
//        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
//        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";
//
//        if (Filter.equals("--select--")) {
//            Filter = "";
//        }
//
//        try {
//            if (Filter.equals("last-month")) {
//                LocalDateTime myDateObj = LocalDateTime.now();
//                LocalDateTime startDate = myDateObj.minusDays(30);
//
//                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//                formattedDate = myDateObj.format(myFormatObj);
//                formattedStartDate = startDate.format(myFormatObj);
//            }
//            if (Filter.equals("last-week")) {
//                LocalDateTime myDateObj = LocalDateTime.now();
//                LocalDateTime startDate = myDateObj.minusDays(7);
//
//                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//                formattedDate = myDateObj.format(myFormatObj);
//                formattedStartDate = startDate.format(myFormatObj);
//            }
//            if (Filter.equals("last-year")) {
//                LocalDateTime myDateObj = LocalDateTime.now();
//                LocalDateTime startDate = myDateObj.minusDays(365);
//
//                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//                formattedDate = myDateObj.format(myFormatObj);
//                formattedStartDate = startDate.format(myFormatObj);
//            }
//            if (Filter.equals("last-6-month")) {
//                LocalDateTime myDateObj = LocalDateTime.now();
//                LocalDateTime startDate = myDateObj.minusDays(183);
//
//                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//                formattedDate = myDateObj.format(myFormatObj);
//                formattedStartDate = startDate.format(myFormatObj);
//            }
//        } catch (Exception e) {
//
//        }
//
//        List monthWiseList1 = aocFormService.monthWiseListAocGraphUser(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
//
//        mv.getModelMap().put("list", monthWiseList1);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("MonthName0", MonthName1);

        mv.setViewName("Oap/monthWiseGraphAocDeatils");

        return mv;
    }

    public ModelAndView totalOapDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/totalOapDashboad");
        return mv;
    }

    public ModelAndView approvedOapDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/approvedOapDashboad");
        return mv;
    }

    public ModelAndView pendingOapDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/pendingOapDashboad");
        return mv;
    }

    public ModelAndView rejectedOapDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/rejectedOapDashboad");
        return mv;
    }

    public ModelAndView unfieldCRCDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/unfieldCRCDashboad");
        return mv;
    }

    public ModelAndView totalCrcDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/totalCrcDashboad");
        return mv;
    }

    public ModelAndView approvedCrcDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/approvedCrcDashboad");
        return mv;
    }

    public ModelAndView pendingCrcDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/pendingCrcDashboad");
        return mv;
    }

    public ModelAndView revisionCrcDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/revisionCrcDashboad");
        return mv;
    }

    public ModelAndView partiallyApprovedCrcDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/partiallyApprovedCrcDashboad");
        return mv;
    }

    public ModelAndView rejectedCrcDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/rejectedCrcDashboad");
        return mv;
    }

    public ModelAndView totalAocDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/totalAocDashboad");
        return mv;
    }

    public ModelAndView approvedAocDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/approvedAocDashboad");
        return mv;
    }

    public ModelAndView pendingAocDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/pendingAocDashboad");
        return mv;
    }

    public ModelAndView rejectedAocDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/rejectedAocDashboad");
        return mv;
    }

    public ModelAndView unfieldKOMDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/unfieldKOMDashboad");
        return mv;
    }

    public ModelAndView totalKomDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/totalKomDashboad");
        return mv;
    }

    public ModelAndView approvedKomDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/approvedKomDashboad");
        return mv;
    }

    public ModelAndView pendingKomDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/pendingKomDashboad");
        return mv;
    }

    public ModelAndView rejectedKomDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/rejectedKomDashboad");
        return mv;
    }

    public ModelAndView projectcordTotal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");

//        List contwiseCRC = oapFormService.readByprojectCoordinatorGraphUser(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//        List contwise1KOM = oapFormService.readByprojectCoordinatorGraphUser1(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//        int Totalcount = contwiseCRC.size() + contwise1KOM.size();
//        mv.getModelMap().put("list", contwiseCRC);
//        mv.getModelMap().put("list1", contwise1KOM);
//        mv.getModelMap().put("Totalcount", Totalcount);
        mv.getModelMap().put("ContactPerson", ContactPerson);
        mv.getModelMap().put("Value", Value);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

        mv.setViewName("Oap/projectcordTotal");
        return mv;
    }

    public ModelAndView projectcordPendingCRC(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
//        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");

//        List contwiseOap = oapFormService.readByprojectCoorGraphUserPendingCRC(ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//        mv.getModelMap().put("list", contwiseOap);
        mv.getModelMap().put("ContactPerson", ContactPerson);

        mv.setViewName("Oap/projectcordPendingCRC");
        return mv;
    }

    public ModelAndView projectcordPendingKOM(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
//        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");

        List contwiseOap = aocFormService.readByprojectCoorGraphUserPendingKOM(ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        mv.getModelMap().put("list", contwiseOap);
        mv.getModelMap().put("ContactPerson", ContactPerson);

        mv.setViewName("Oap/projectcordPendingKOM");
        return mv;
    }

    public ModelAndView projectManagerTotal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");

//        List contwiseCRC = oapFormService.readByProjectManagerTotalGraphUser(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//        List contwise1KOM = oapFormService.readByProjectManagerTotalGraphUser1(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//        int Totalcount = contwiseCRC.size() + contwise1KOM.size();
//        mv.getModelMap().put("list", contwiseCRC);
//        mv.getModelMap().put("list1", contwise1KOM);
//        mv.getModelMap().put("Totalcount", Totalcount);
        mv.getModelMap().put("ContactPerson", ContactPerson);
        mv.getModelMap().put("Value", Value);

        mv.setViewName("Oap/projectManagerTotal");
        return mv;
    }

    public ModelAndView clickNoOfChargerDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }
        String startDatee = "";
        String endDatee = "";
//        String MonthName0 = request.getParameter("label");
        String MonthName1 = request.getParameter("label");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
        String MonthName = yearMonth.format(outputFormatter);

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {

        }
        String EndDate = endDatee;
        String StartDate = startDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

//        List monthsWiseList1 = oapFormService.noOfChargerDetailsOap(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
//        mv.getModelMap().put("list", monthsWiseList1);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("Filter", Filter);

        mv.getModelMap().put("MonthName0", MonthName1);
        mv.setViewName("Oap/clickNoOfChargerDetails");
        return mv;
    }

    public ModelAndView clicktotalChargerCapacityDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }
        String startDatee = "";
        String endDatee = "";
//        String MonthName0 = request.getParameter("label");
        String MonthName1 = request.getParameter("label");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
        String MonthName = yearMonth.format(outputFormatter);

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {

        }
        String EndDate = endDatee;
        String StartDate = startDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

//        List monthsWiseList1 = oapFormService.totalChargerCapacityDetailsOap(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
//
//        mv.getModelMap().put("list", monthsWiseList1);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("Filter", Filter);

        mv.getModelMap().put("MonthName0", MonthName1);
        mv.setViewName("Oap/clicktotalChargerCapacityDetails");
        return mv;
    }

    public ModelAndView clicktotalKwRatingDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }
        String startDatee = "";
        String endDatee = "";
//        String MonthName0 = request.getParameter("label");
        String MonthName1 = request.getParameter("label");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
        String MonthName = yearMonth.format(outputFormatter);

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {

        }
        String EndDate = endDatee;
        String StartDate = startDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

//        List monthsWiseList1 = oapFormService.totalKwRatingDetailsOap(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
//        mv.getModelMap().put("list", monthsWiseList1);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("Filter", Filter);

        mv.getModelMap().put("MonthName0", MonthName1);
        mv.setViewName("Oap/clicktotalKwRatingDetails");
        return mv;
    }

    public ModelAndView clickaocNoOfChargerDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }
        String startDatee = "";
        String endDatee = "";
//        String MonthName0 = request.getParameter("label");
        String MonthName1 = request.getParameter("label");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
        String MonthName = yearMonth.format(outputFormatter);

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {

        }
        String EndDate = endDatee;
        String StartDate = startDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

//        List monthsWiseList1 = aocFormService.noOfChargerDetailsAoc(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
//
//        mv.getModelMap().put("list", monthsWiseList1);
        mv.getModelMap().put("MonthName", MonthName);

        mv.getModelMap().put("MonthName0", MonthName1);
        mv.getModelMap().put("Filter", Filter);

        mv.setViewName("Oap/clickaocNoOfChargerDetails");
        return mv;
    }

    public ModelAndView clickaoctotalChargerCapacityDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }
        String startDatee = "";
        String endDatee = "";
//        String MonthName0 = request.getParameter("label");
        String MonthName1 = request.getParameter("label");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
        String MonthName = yearMonth.format(outputFormatter);

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {

        }
        String EndDate = endDatee;
        String StartDate = startDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

//        List monthsWiseList1 = aocFormService.totalChargerCapacityDetailsAoc(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
//
//        mv.getModelMap().put("list", monthsWiseList1);
        mv.getModelMap().put("MonthName", MonthName);

        mv.getModelMap().put("MonthName0", MonthName1);
        mv.setViewName("Oap/clickaoctotalChargerCapacityDetails");
        return mv;
    }

    public ModelAndView clickaoctotalKwRatingDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }
        String startDatee = "";
        String endDatee = "";
        String MonthName1 = request.getParameter("label");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
        String MonthName = yearMonth.format(outputFormatter);

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {

        }
        String EndDate = endDatee;
        String StartDate = startDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

//        List monthsWiseList1 = aocFormService.totalKwRatingDetailsAoc(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
//
//        mv.getModelMap().put("list", monthsWiseList1);
        mv.getModelMap().put("MonthName", MonthName);

        mv.getModelMap().put("MonthName0", MonthName1);
        mv.setViewName("Oap/clickaoctotalKwRatingDetails");
        return mv;
    }

}

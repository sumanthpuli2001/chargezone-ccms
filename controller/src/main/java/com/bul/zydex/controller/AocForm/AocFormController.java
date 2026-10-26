/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.AocForm;

import com.bul.zydex.model.AocForm;
import com.bul.zydex.model.AocFormApproval;
import com.bul.zydex.model.AocFormApprovalComment;
import com.bul.zydex.model.AocFormApprovalUser;
import com.bul.zydex.model.AocFormAttachment;
import com.bul.zydex.model.AocFormHistory;
import com.bul.zydex.model.AocFormMultiAttachment;
import com.bul.zydex.model.AocFormMultiAttachmentHistory;
import com.bul.zydex.model.AocLogMaster;
import com.bul.zydex.model.AocSurveyAttachment;
import com.bul.zydex.model.AocSurveyAttachmentHistory;
import com.bul.zydex.model.ConnectionType;
import com.bul.zydex.model.DiscomMaster;
import com.bul.zydex.model.DocumentMastersId;
import com.bul.zydex.model.DocumentName;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.KickOffAttendences;
import com.bul.zydex.model.KickOffForm;
import com.bul.zydex.model.KickOffFormApproval;
import com.bul.zydex.model.KickOffFormApprovalComment;
import com.bul.zydex.model.KickOffFormApprovalUser;
import com.bul.zydex.model.OapForm;
import com.bul.zydex.model.OapFormApproval;
import com.bul.zydex.model.OapMaster;
import com.bul.zydex.model.OapMasterUser;
import com.bul.zydex.model.PRMaster;
import com.bul.zydex.model.PRNoTemp;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.util.DownloadFile;
import com.bul.zydex.util.SendMail;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sumanth
 */
public class AocFormController extends AocFormAbstract {

    public ModelAndView aocForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

//	List list88 = documentNameService.read();
        List list10 = oapMasterService.read();
//	List list1 = documentNameService.readAll();
        List list0 = tenantService.read();
        List list2 = stationTypeService.read();
        List list3 = currencyMasterService.read();
        List list4 = projectTypeService.read();
        List list6 = investmentProfileService.read();
        List list7 = profitCenterService.read();
        List list8 = plantMastersService.read();
        List list9 = companyMasterService.read();
        List list11 = projectProfileService.read();
        List list13 = connectionTypeService.read();
        List list14 = projectNameMasterService.read();
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
        request.setAttribute("list13", list13);
        request.setAttribute("list14", list14);
//	request.setAttribute("list88", list88);
        request.setAttribute("list10", list10);
//	request.setAttribute("list1", list1);
        mv.getModelMap().put("list15", list15);
        mv.getModelMap().put("list16", list16);

        mv.setViewName("Oap/AocForm");
        return mv;
    }

    public ModelAndView aocFormSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

//        String documentNo = request.getParameter("documentNo");
        String depoName = request.getParameter("depoName");
        String b2b = request.getParameter("b2b");
        String b2b2c = request.getParameter("b2b2c");
        String projectName = request.getParameter("projectName");
        String b2c = request.getParameter("b2c");
        String depoAddress = request.getParameter("depoAddress");
        String googleCoordinates = request.getParameter("googleCoordinates");
        String car = request.getParameter("car");
        if (car == null) {
            car = "0";
        } else {
            car = "1";
        }
        String bus = request.getParameter("bus");
        if (bus == null) {
            bus = "0";
        } else {
            bus = "1";
        }
        String truck = request.getParameter("truck");
        if (truck == null) {
            truck = "0";
        } else {
            truck = "1";
        }
        String others = request.getParameter("others");
        String pcs = request.getParameter("pcs");

        String capex = request.getParameter("capex");
        if (capex == null) {
            capex = "0";
        } else {
            capex = "1";
        }
        String opex = request.getParameter("opex");
        if (opex == null) {
            opex = "0";
        } else {
            opex = "1";
        }
        String coordinates = request.getParameter("coordinates");
        String firstName = request.getParameter("firstName");
//	String middleName = request.getParameter("middleName");
//	String lastName = request.getParameter("lastName");
        String mobileNo = request.getParameter("mobileNo");
        String altNo = request.getParameter("altNo");
        String email = request.getParameter("email");
        String reqClients = request.getParameter("reqClients");
        String scopework = request.getParameter("scopework");
        String scope = request.getParameter("scope");

        String operations = request.getParameter("operations");
        String operationsSign = request.getParameter("operationsSign");
        String maintenance = request.getParameter("maintenance");
        String maintenancesign = request.getParameter("maintenancesign");
        String Fromdate6 = request.getParameter("Fromdate6");
        String Fromdate7 = request.getParameter("Fromdate7");
        String inr = request.getParameter("inr");
        String comments = request.getParameter("comments");
        String Fromdate8 = request.getParameter("Fromdate8");
        String revisionNo = request.getParameter("revisionNo");
        String Fromdate9 = request.getParameter("Fromdate9");
        String reviewed = request.getParameter("reviewed");
        String designation = request.getParameter("designation");
        String signatureDate = request.getParameter("signatureDate");
        String approvalName = request.getParameter("approvalName");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String houseno = request.getParameter("houseno");
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
        String chargingrate = request.getParameter("chargingrate");

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
        DocumentMastersId documentMastersId = documentMastersIdService.readByDocumentNo();

        String meetingno = "0";
        meetingno = documentMastersId.getDocumentId();
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
        String f_year = refNo.substring(0, 2);
        String f_no = refNo.substring(2, 7);

        int f_y1 = Integer.parseInt(f_year);
        f_y1++;

        refNo = "AOC" + "-" + f_year + "" + f_y1 + "-" + f_no;
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
        String additionOfNewChargerCapacity = request.getParameter("additionOfNewChargerCapacity");
        String anchoreCustomer = request.getParameter("anchoreCustomer");
        String canopyVarient = request.getParameter("canopyVarient");
        if (canopyVarient == null) {
            canopyVarient = "";
        }
        String scopeofChargeZone = request.getParameter("scopeofChargeZone");
        String totalMW = request.getParameter("totalMW");

        AocForm aocForm = new AocForm();

        aocForm.setDocumentNo(refNo);
        aocForm.setHubDepoName(depoName);
        aocForm.setBb2(b2b);
        aocForm.setBbc22(b2b2c);
        aocForm.setClientProjectName(projectName);
        aocForm.setBc2(b2c);
        aocForm.setHubDepoAddress(depoAddress);
        aocForm.setGoogleCoordinates(googleCoordinates);
        aocForm.setPcTypeCar(car);
        aocForm.setPcTypeBus(bus);
        aocForm.setPcTypeTruckLmv(truck);
        aocForm.setOther(others);
        aocForm.setPcsType("");
        aocForm.setFinacialModelCapex(capex);
        aocForm.setFinacialModelOpex(opex);
        aocForm.setCoOrdinates(coordinates);
        aocForm.setFirstName(firstName);
        aocForm.setMiddleName("");
        aocForm.setLastName("");
        aocForm.setMobileNo(mobileNo);
        aocForm.setAlternateMobileNo(altNo);
        aocForm.setEmail(email);
        aocForm.setSpecificReqClients(reqClients);
        aocForm.setChargeScope(scopework);
        aocForm.setClientScope(scope);

        aocForm.setOperations(operations);
        aocForm.setOperationsSign(operationsSign);
        aocForm.setMaintenance(maintenance);
        aocForm.setMaintenanceSign(maintenancesign);
        aocForm.setZeroDate(Fromdate6);
        aocForm.setCompletionDate(Fromdate7);
        aocForm.setProjectBudgetAllocated(inr);
        aocForm.setAuthorityComments(comments);
        aocForm.setOrderEffcectiveDate(Fromdate8);
        aocForm.setNewRevisionNo(revisionNo);
        aocForm.setBudjectAllocationDate(Fromdate9);
        aocForm.setReviewedBy(reviewed);
        aocForm.setDesignation(designation);
        aocForm.setSignatureDate("");
        aocForm.setOapMaster(oapMaster);
        aocForm.setCreatedDate(today);
        aocForm.setUserId(username1);
        aocForm.setFlagStatus(1);
        aocForm.setAssignedName("");
        aocForm.setState(state);
        aocForm.setCountry(country);
        aocForm.setCity(city);
        aocForm.setDistrict(district);
        aocForm.setHouseNo(houseno);
        aocForm.setProjectProfile(ProjectProfile);
        aocForm.setProjectCenter(profitcenter);
        aocForm.setCompanyCode(CompanyCode);
        aocForm.setPlant(Plant);
        aocForm.setProjectType(ProjectType);
        aocForm.setProjectCurrency(ProjectCurrency);
        aocForm.setInverstmentProfile(InvestmentProfile);
        aocForm.setDiscom(Discom);
        aocForm.setNoOfChargePoints(ChargePoints);
        aocForm.setNoOfCharger(NoOfCharger);
        aocForm.setOverallStationCapacityKw(overallstations);
        aocForm.setStationAcCapacityKw(stationAc);
        aocForm.setStationDcCapacityKw(stationDc);
        aocForm.setStationName(stationname);
        aocForm.setStationType(stationtype);
        aocForm.setTenant(tenant);
        aocForm.setConnectionType(connectiontype);
        documentMastersId.setDocumentId(final_ten_no);
        aocForm.setChargingRatePerUnit(chargingrate);
        aocForm.setSiteSurvey(sitesurvey);
        aocForm.setSurveyRadio(Integer.parseInt(Survey));
        aocForm.setProjectTimelineCategory(projectTimelineCategory);
        aocForm.setTotalKwRating(totalKwRating);
        aocForm.setSpecificDateFromClient(specificDateFromClient);
        aocForm.setTotalChargerCapacity(totalChargerCapacity);
        aocForm.setChargerStationAccessType(chargerStationAccessType);
        aocForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
        aocForm.setChargingRetePerUnit(chargingRetePerUnit);
        aocForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
        aocForm.setAdditionOfNewChargerCapacity(additionOfNewChargerCapacity);
        aocForm.setAnchoreCustomer(anchoreCustomer);
        aocForm.setCanopyVarient(canopyVarient);
        aocForm.setScopeOfchargeZone(scopeofChargeZone);
        aocForm.setTotalMegaWatt(totalMW);

        aocFormService.create(aocForm);
        documentMastersIdService.create(documentMastersId);

        int id = aocForm.getId();
        AocForm aocForm1 = aocFormService.readById(id);

        String assumption = request.getParameter("assumption");
        if (assumption == null) {
            assumption = "0";
        } else {
            assumption = "1";
        }
        String assumptionRefNo = request.getParameter("assumptionRefNo");
        if (assumptionRefNo == null) {
            assumptionRefNo = "";
        }

        String Fromdate1 = request.getParameter("Fromdate1");
        if (Fromdate1 == null) {
            Fromdate1 = "";
        }

        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile file0 = multipartRequest1.getFile("file1");
        String file0FileName = "";
        if (file0 != null && !file0.isEmpty()) {
            file0FileName = file0.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + aocForm1.getId() + File.separator;

            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file0FileName);
            file0.transferTo(destinationFile);
        }

        String boq = request.getParameter("boq");
        if (boq == null) {
            boq = "0";
        } else {
            boq = "1";
        }
        String boqRefNo = request.getParameter("boqRefNo");
        if (boqRefNo == null) {
            boqRefNo = "";
        }

        String Fromdate2 = request.getParameter("Fromdate2");
        if (Fromdate2 == null) {
            Fromdate2 = "";
        }

        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile file2 = multipartRequest2.getFile("file2");
        String file2FileName = "";
        if (file2 != null && !file2.isEmpty()) {
            file2FileName = file2.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + aocForm1.getId() + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file2FileName);
            file2.transferTo(destinationFile);

        }

        String lao = request.getParameter("lao");
        if (lao == null) {
            lao = "0";
        } else {
            lao = "1";
        }
        String laoRefNo = request.getParameter("laoRefNo");
        if (laoRefNo == null) {
            laoRefNo = "";
        }

        String Fromdate3 = request.getParameter("Fromdate3");
        if (Fromdate3 == null) {
            Fromdate3 = "";
        }

        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile file3 = multipartRequest3.getFile("file3");
        String file3FileName = "";
        if (file3 != null && !file3.isEmpty()) {
            file3FileName = file3.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + aocForm1.getId() + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file3FileName);
            file3.transferTo(destinationFile);
        }

        String agremment = request.getParameter("agremment");
        if (agremment == null) {
            agremment = "0";
        } else {
            agremment = "1";
        }
        String agremmentRefNo = request.getParameter("agremmentRefNo");
        if (agremmentRefNo == null) {
            agremmentRefNo = "";
        }
        String Fromdate4 = request.getParameter("Fromdate4");
        if (Fromdate4 == null) {
            Fromdate4 = "";
        }

        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile file4 = multipartRequest4.getFile("file4");
        String file4FileName = "";
        if (file4 != null && !file4.isEmpty()) {
            file4FileName = file4.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + aocForm1.getId() + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file4FileName);
            file4.transferTo(destinationFile);
        }

        String drawings = request.getParameter("drawings");
        if (drawings == null) {
            drawings = "0";
        } else {
            drawings = "1";
        }
        String drawingsRefNo = request.getParameter("drawingsRefNo");
        if (drawingsRefNo == null) {
            drawingsRefNo = "";
        }
        String Fromdate5 = request.getParameter("Fromdate5");
        if (Fromdate5 == null) {
            Fromdate5 = "";
        }

        MultipartHttpServletRequest multipartRequest5 = (MultipartHttpServletRequest) request;
        MultipartFile file5 = multipartRequest5.getFile("file5");
        String file5FileName = "";
        if (file5 != null && !file5.isEmpty()) {
            file5FileName = file5.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + aocForm1.getId() + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file5FileName);
            file5.transferTo(destinationFile);
        }

        aocForm1.setAssumptionSheet(assumption);
        aocForm1.setAssumptionRefNo(assumptionRefNo);
        aocForm1.setAssumptionDate(Fromdate1);
        aocForm1.setEstimatedBoq(boq);
        aocForm1.setEstimatedRefNo(boqRefNo);
        aocForm1.setEstimatedDate(Fromdate2);
        aocForm1.setLoaLoi(lao);
        aocForm1.setLoaLoiRefNo(laoRefNo);
        aocForm1.setLoaLoiDate(Fromdate3);
        aocForm1.setAgreement(agremment);
        aocForm1.setAgreementRefNo(agremmentRefNo);
        aocForm1.setAgreementDate(Fromdate4);
        aocForm1.setLayoutDrawings(drawings);
        aocForm1.setLayoutRefNo(drawingsRefNo);
        aocForm1.setLayoutDate(Fromdate5);
        aocForm1.setAssumptionAttach(file0FileName);
        aocForm1.setEstimatedAttach(file2FileName);
        aocForm1.setLoaAttach(file3FileName);
        aocForm1.setAgreementAttach(file4FileName);
        aocForm1.setLayoutAttach(file5FileName);

        aocFormService.update(aocForm1);

        String documentno = aocForm.getDocumentNo();
        String mailcreteddate = aocForm.getCreatedDate();
        String mainusername = aocForm.getUserId();

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");

        int mailCount = 0;
        String surveyno = null;

        for (int i = 0; i < surveyNo.length; i++) {
            String s = surveyNo[i];

            if (s != null && !s.isEmpty()) {
                AocSurveyAttachment aocSurveyAttachment = new AocSurveyAttachment();
                aocSurveyAttachment.setSurveyNo(surveyNo[i]);
                aocSurveyAttachment.setProjectRepresentative(projectRepresentative[i]);
                aocSurveyAttachment.setAocId(id);
                aocSurveyAttachmentService.create(aocSurveyAttachment);

                surveyno = aocSurveyAttachment.getSurveyNo();

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
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Aoc"
                + File.separator + id;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

// Get all uploaded files
        List<MultipartFile> files = multipartRequest.getFiles("attchment");
        String[] id1 = request.getParameterValues("id");
        String[] descriptions = request.getParameterValues("descriptiones");
        int i = 0;
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Aoc"
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
                    AocFormAttachment aocFormAttachment = new AocFormAttachment();
//		    aocFormAttachment.setDocumentName(id1);
                    aocFormAttachment.setAttachment(file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    aocFormAttachment.setAocForm(aocForm1);
                    aocFormAttachment.setDescription(descriptions[i]);
                    aocFormAttachment.setDocumentName(documentName);
                    AocFormAttachmentService.create(aocFormAttachment);
                    i++;
                }
            }
        }
//multi attachment
        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Aoc"
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

                    AocFormMultiAttachment aocFormMultiAttachment = new AocFormMultiAttachment();

                    aocFormMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    aocFormMultiAttachment.setDescription(description[a]);
                    aocFormMultiAttachment.setAocForm(aocForm1);

                    aocFormMultiAttachmentService.create(aocFormMultiAttachment);

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

        AocFormApproval aocFormApproval = new AocFormApproval();

        aocFormApproval.setAocForm(aocForm1);
        aocFormApproval.setTotalApproval(approval_list.size() + "");
        aocFormApproval.setApprovalStatus("0");
        aocFormApproval.setApprovalRemark("add");
        aocFormApproval.setUserId(employeeCode);
        aocFormApproval.setCurrentApproval("1");
        aocFormApprovalService.create(aocFormApproval);

        int approveId = aocFormApproval.getId();
        OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

        StringBuilder builder = new StringBuilder();

        int j = 0;
        for (Object o : approval_list) {
            j++;
            OapMasterUser oap1 = (OapMasterUser) o;
            AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();
            aocFormApprovalUser.setAocFormApproval(approveId);
            aocFormApprovalUser.setAocForm(id);
            builder.append(oap1.getUserId()).append(", ");
            aocFormApprovalUser.setUserId(oap1.getUserId());

            aocFormApprovalUser.setLevel("1");
            aocFormApprovalUser.setApprovalStatus("0");
            aocFormApprovalUserService.create(aocFormApprovalUser);
            String userid = aocFormApprovalUser.getUserId();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(50);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Aoc_form = "AOC Form";

            msg = msg.replaceAll("\\{Aoc_form\\}", Aoc_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", mainusername);
            msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);
//	    msg = msg.replaceAll("\\{vendor_code\\}", checkedValues);
//	    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
//	    msg = msg.replaceAll("\\{department\\}", department);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

        }
        AocLogMaster aocLogMaster = new AocLogMaster();
        aocLogMaster.setActivity("AOC Created");
        aocLogMaster.setActivityBy(username1);
        aocLogMaster.setDate(currentDateTime5);
        aocLogMaster.setComments("");
        aocLogMaster.setStatus("Created");
        aocLogMaster.setAocId(id);
        aocLogMasterService.create(aocLogMaster);

        String userid = aocForm.getUserId();
        EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
        String mail_to = employeeMaster2.getEmailId();

        EmailTemplate emailTemplate = emailTemplateService.readById(150);
        String mail_from = "";

        String subject = emailTemplate.getSubject();
        String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
        String Oap_form = "AOC Form";

        if (builder.length() > 0) {
            builder.setLength(builder.length() - 2); // remove last ", "
        }

        msg = msg.replaceAll("\\{Oap_form\\}", Oap_form);
        msg = msg.replaceAll("\\{documentno\\}", documentno);
        msg = msg.replaceAll("\\{username\\}", mainusername);
        msg = msg.replaceAll("\\{approvalName\\}", builder.toString());
        msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

        SendMail s = new SendMail();
        s.sendMail(mail_from, mail_to, subject, msg);

        session.setAttribute("successMessage", "AOC Created successfully");
        mv.setViewName("redirect:aocForm.htm?act=aocFormAppovalList");

        return mv;
    }

    public ModelAndView AocApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Oap/AocApproval");
        return mv;
    }

    public ModelAndView AocApprovalView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String aocFormId = request.getParameter("aocFormId");

        String aocFormattach = request.getParameter("aocFormattach");
        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(aocFormId);

        AocForm list55 = aocFormService.readById(Integer.parseInt(aocFormId));
        String discom = list55.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = list55.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();

        List list = AocFormAttachmentService.readByattach(aocFormattach);
        String aocFormmulti = request.getParameter("aocFormmulti");
        List list33 = aocFormMultiAttachmentService.readByMulti(aocFormmulti);

        AocFormApproval aocFormApproval = aocFormApprovalService.readById(Integer.parseInt(id));
        List aocApproval1 = aocFormApprovalService.readByIds(id);
//        int aocid = Integer.parseInt(aocFormId);
        List aocuserapprovals = aocFormApprovalUserService.readByaocId(aocFormId);
        List comments = aocFormApprovalCommentService.readByIds(aocFormId);
        List Activitymile = aocLogMasterService.readByAocId(aocFormId);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("aocFormId", aocFormId);
        mv.getModelMap().put("list10", aocuserapprovals);
        mv.getModelMap().put("oaplogmaster", Activitymile);
        mv.getModelMap().put("list11", comments);
        mv.getModelMap().put("list55", list55);
        mv.getModelMap().put("list8", aocFormApproval);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list1", aocApproval1);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);

        mv.setViewName("Oap/AocApprovalView");
        return mv;
    }

    public ModelAndView AocApproveButton(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        AocFormApproval aocFormApproval = aocFormApprovalService.readById(Integer.parseInt(id));
        AocFormApprovalUser aocApprovalUser = aocFormApprovalUserService.readByIdAndUsername(id, username);

        String approvalStatus = aocApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {
            int aocFormid = aocFormApproval.getId();
            int aocformid = aocFormApproval.getAocForm().getId();
            AocForm aocForm = aocFormService.readById(aocformid);
            int aocformId = aocForm.getId();
            String aocCreatedBy = aocForm.getUserId();

//	AocFormApprovalUser aocFormApprovalUser = aocFormApprovalUserService.appval(username);
            AocFormApprovalUser aocFormApprovalUser = aocFormApprovalUserService.appvals(username, id);
            int approvalid = aocFormApproval.getId();

            AocFormApprovalComment aocFormApprovalComment1 = aocFormApprovalCommentService.readByApprovalId(approvalid);

            String totalApproval = aocFormApproval.getTotalApproval();

            String ca = aocFormApproval.getCurrentApproval();
            aocFormApproval.setApprovalStatus("1");

            aocFormApproval.setCurrentApproval("1");
            aocFormApprovalUser.setApprovalStatus("1");
            aocFormApprovalComment1.setApprovalStatus("1");
            aocFormApproval.setCurrentApproval("1");
            aocFormApprovalService.update(aocFormApproval);
            aocFormApprovalUserService.update(aocFormApprovalUser);

            List allUserList = aocFormApprovalUserService.readByDleteCode(approvalid);
            String flag = "0";
            for (Object o : allUserList) {
                AocFormApprovalUser aocFormApprovalUser1 = (AocFormApprovalUser) o;
                String approvalstatus = aocFormApprovalUser1.getApprovalStatus();
                if (approvalstatus.equals("1")) {
                    flag = "1";
                } else {
                    flag = "0";
                    break;
                }

            }
            if (flag.equals("1")) {
                aocForm.setFlagStatus(4);
                aocFormApproval.setApprovalStatus("1");
            }

            String level = aocFormApprovalUser.getLevel();

//        AocFormApprovalUser aocFormApprovalUser1 = aocFormApprovalUserService.readLevel(level, aocFormid);
//        String secondApproval = aocFormApprovalUser1.getUserId();
//
//        EmployeeMaster employeeMaster1 = employeeMasterService.readUser(secondApproval);
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            aocFormApprovalComment1.setApprovalComment(comment);
            aocFormApprovalComment1.setUserId(username);
            aocFormApprovalComment1.setAocFormApproval(aocFormid);
            aocFormApprovalComment1.setApprovalStatus("1");
            aocFormApprovalComment1.setAocForm(aocformid);

            aocFormApprovalCommentService.create(aocFormApprovalComment1);

            aocFormService.update(aocForm);

//	String userid = aocForm.getUserId();
            String documentno = aocForm.getDocumentNo();
//	String mailcreteddate = aocForm.getCreatedDate();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(54);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Aoc_form = "AOC Form";

            msg = msg.replaceAll("\\{Aoc_form\\}", Aoc_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", username);
//	msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);
//	    msg = msg.replaceAll("\\{vendor_code\\}", checkedValues);
//	    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
//	    msg = msg.replaceAll("\\{department\\}", department);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Approval");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("Approved");
            aocLogMaster.setAocId(aocformid);
            aocLogMasterService.create(aocLogMaster);

            List list5 = aocFormApprovalUserService.readByaocId(aocformId);
            AocFormApprovalUser formApprovalUser = new AocFormApprovalUser();

            for (Object pdf1 : list5) {

                formApprovalUser = (AocFormApprovalUser) pdf1;

                if (!formApprovalUser.getUserId().equals(username)) {

                    String userid2 = formApprovalUser.getUserId();
                    EmployeeMaster employeeMaster5 = employeeMasterService.readUser(userid2);
                    String sending_user = employeeMaster5.getName();

                    if (employeeMaster5 != null && employeeMaster5.getEmailId() != null && !employeeMaster5.getEmailId().isEmpty()) {

                        String mail_to5 = employeeMaster5.getEmailId();

                        EmailTemplate emailTemplate1 = emailTemplateService.readById(151);
                        String mail_from5 = "";

                        String subject5 = emailTemplate1.getSubject();
                        String msg5 = emailTemplate1.getBodytext();

                        String Oap_form5 = "Approval Person AOC Form Approved";

                        msg5 = msg5.replaceAll("\\{sending_user\\}", sending_user);
                        msg5 = msg5.replaceAll("\\{Oap_form\\}", Oap_form5);
                        msg5 = msg5.replaceAll("\\{documentno\\}", documentno);
                        msg5 = msg5.replaceAll("\\{aocCreatedBy\\}", aocCreatedBy);
                        msg5 = msg5.replaceAll("\\{approvedby\\}", username);
                        msg5 = msg5.replaceAll("\\{Approveddate\\}", currentDateTime5);

                        SendMail s1 = new SendMail();
                        s1.sendMail(mail_from5, mail_to5, subject5, msg5);

                    }

                }

            }

            List list6 = aocFormApprovalUserService.readByApprovalStatus(aocformId + "");

            if (list6.size() == 0) {

                List EHrights = userRightsService.readByexecutiveHead();
                UserRights userRights = new UserRights();

                for (Object pdf2 : EHrights) {
                    userRights = (UserRights) pdf2;
                    int EH = userRights.getExecutiveHead();
                    String usrenameEh = userRights.getUsername();
                    if (EH == 1) {

                        EmployeeMaster employeeMaster7 = employeeMasterService.readUser(usrenameEh);
                        String name = employeeMaster7.getName();
                        String mail_to7 = employeeMaster7.getEmailId();

                        EmailTemplate emailTemplate7 = emailTemplateService.readById(152);
                        String mail_from7 = "";

                        String subject7 = emailTemplate7.getSubject();
                        String msg7 = emailTemplate7.getBodytext();

                        String Aoc_form7 = "All Approval are Completed";

                        msg7 = msg7.replaceAll("\\{Aoc_form\\}", Aoc_form7);
                        msg7 = msg7.replaceAll("\\{documentno\\}", documentno);
                        msg7 = msg7.replaceAll("\\{username\\}", name);
//                  msg7 = msg7.replaceAll("\\{username\\}", mainusername);
                        msg7 = msg7.replaceAll("\\{finalapproveddate\\}", currentDateTime5);

                        SendMail s7 = new SendMail();
                        s7.sendMail(mail_from7, mail_to7, subject7, msg7);
                    }
                }

            }
            session.setAttribute("successMessage", "AOC Approval Approved successfully");
        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "AOC Approval Already Approved Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "AOC Approval Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "AOC Approval Already Rejected Successfully");
        } else {
            session.setAttribute("failureMessage", "The AOC approval has already progressed to the next stage");
        }
        mv.setViewName("redirect:aocForm.htm?act=AocApproval");

        return mv;
    }

    public ModelAndView aocFormAppovalList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage"); // clean up after showing
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }

        }

        List list = aocFormService.readByUser(username);
        mv.getModelMap().put("list", list);

        mv.setViewName("Oap/aocFormAppovalList");
        return mv;
    }

    public ModelAndView aocFormAprovalMatrixView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        String aocFormattach = request.getParameter("aocFormattach");
        String aocFormmulti = request.getParameter("aocFormmulti");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        List aoclogmaster = aocLogMasterService.readByAocId(id);

        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(id);

        String discom = aocForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = aocForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();

        int id1 = aocForm.getId();

        List list = AocFormAttachmentService.readByattach(id);
        List list33 = aocFormMultiAttachmentService.readByMulti(id);

        AocFormApproval aocFormApproval = aocFormApprovalService.readByDeltecodes(id);
        int approveid = aocFormApproval.getId();

        List list0 = aocFormApprovalUserService.readByApprovalStatus(id);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", aocForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);
        mv.getModelMap().put("aoclogmaster", aoclogmaster);

        mv.setViewName("Oap/aocFormAprovalMatrixView");
        return mv;
    }

    public ModelAndView aocFormEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

//	String aocFormattach = request.getParameter("aocFormattach");
//	String aocFormmulti = request.getParameter("aocFormmulti");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        String discom = aocForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = aocForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

        String Tenant = aocForm.getTenant();
        String StationType = aocForm.getStationType();
        String Currency = aocForm.getProjectCurrency();
        String ProjectType = aocForm.getProjectType();
        String Ivestmentprofile = aocForm.getInverstmentProfile();
        String ProjectCenter = aocForm.getProjectCenter();
        String CompanyCode = aocForm.getCompanyCode();
        String plant = aocForm.getPlant();
        String ProjectProfile = aocForm.getProjectProfile();
        String Discom = aocForm.getDiscom();
        mv.getModelMap().put("Discom", Discom);
        mv.getModelMap().put("ProjectProfile", ProjectProfile);
        mv.getModelMap().put("CompanyCode", CompanyCode);
        mv.getModelMap().put("plant", plant);

        mv.getModelMap().put("ProjectCenter", ProjectCenter);
        mv.getModelMap().put("Ivestmentprofile", Ivestmentprofile);
        mv.getModelMap().put("ProjectType", ProjectType);
        mv.getModelMap().put("Currency", Currency);
        mv.getModelMap().put("StationType", StationType);
        mv.getModelMap().put("Tenant", Tenant);

        int aocmasterId = aocForm.getOapMaster().getId();
        List list = AocFormAttachmentService.readByattach(id);
        List list33 = aocFormMultiAttachmentService.readByMulti(id);
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
        mv.getModelMap().put("aocForm", aocForm);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("aocmasterId", aocmasterId);
        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/aocFormAppovalListEdit");
        return mv;
    }

    public ModelAndView aocFormdocuDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id1 = request.getParameter("id1");
        String id = request.getParameter("id");
        AocFormAttachmentService.delete(Integer.parseInt(id1));
        request.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv.getModelMap().put("id1", id1);
        mv.getModelMap().put("id", id);
//	mv = aocFormEdit(request, response);
        mv.setViewName("forward:aocForm.htm?act=aocFormRecycleEdit&id=" + id);
        return mv;
    }

    public ModelAndView aocFormdocuDelete1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id1 = request.getParameter("id1");
        String id = request.getParameter("id");
        aocFormMultiAttachmentService.delete(Integer.parseInt(id1));
        request.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv.getModelMap().put("id1", id1);
        mv.getModelMap().put("id", id);
//	mv = aocFormEdit(request, response);
         AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        if (aocForm.getFlagStatus() == 2) {
            mv.setViewName("forward:aocForm.htm?act=aocFormRecycleEdit&id=" + id);
        } else {
            mv.setViewName("forward:aocForm.htm?act=AocSaveAsDraftView&id=" + id);
        }

        return mv;
    }

    public ModelAndView aocFormEditsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        String documentNo = request.getParameter("documentNo");
        String depoName = request.getParameter("depoName");
        String b2b = request.getParameter("b2b");
        String b2b2c = request.getParameter("b2b2c");
        String b2c = request.getParameter("b2c");
        String projectName = request.getParameter("projectName");
        String depoAddress = request.getParameter("depoAddress");
        String googleCoordinates = request.getParameter("googleCoordinates");
        String car = request.getParameter("car");
        if (car == null) {
            car = "0";
        } else {
            car = "1";
        }
        String bus = request.getParameter("bus");
        if (bus == null) {
            bus = "0";
        } else {
            bus = "1";
        }
        String truck = request.getParameter("truck");
        if (truck == null) {
            truck = "0";
        } else {
            truck = "1";
        }
        String others = request.getParameter("others");
        String pcs = request.getParameter("pcs");
        String capex = request.getParameter("capex");
        if (capex == null) {
            capex = "0";
        } else {
            capex = "1";
        }
        String opex = request.getParameter("opex");
        if (opex == null) {
            opex = "0";
        } else {
            opex = "1";
        }
        String coordinates = request.getParameter("coordinates");
        String firstName = request.getParameter("firstName");
//	String middleName = request.getParameter("middleName");
//	String lastName = request.getParameter("lastName");
        String mobileNo = request.getParameter("mobileNo");
        String altNo = request.getParameter("altNo");
        String email = request.getParameter("email");
        String reqClients = request.getParameter("reqClients");
        String scopework = request.getParameter("scopework");
        String scope = request.getParameter("scope");
        String assumption = request.getParameter("assumption");
        if (assumption == null) {
            assumption = "0";
        } else {
            assumption = "1";
        }
        String assumptionRefNo = request.getParameter("assumptionRefNo");
        if (assumptionRefNo == null) {
            assumptionRefNo = "";
        }
        String Fromdate1 = request.getParameter("Fromdate1");
        if (Fromdate1 == null) {
            Fromdate1 = "";
        }
        String file11 = request.getParameter("file11");
        if (assumption.equals("0")) {
            file11 = "";
        }
        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile file0 = multipartRequest1.getFile("file1");
        String file0FileName = "";
        if (file0 != null && !file0.isEmpty()) {
            file0FileName = file0.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file0FileName);
            file0.transferTo(destinationFile);
        }
        if (file0FileName.equals("") || file0FileName == "") {
            file0FileName = file11;
        }

        String boq = request.getParameter("boq");
        if (boq == null) {
            boq = "0";
        } else {
            boq = "1";
        }
        String boqRefNo = request.getParameter("boqRefNo");
        if (boqRefNo == null) {
            boqRefNo = "";
        }
        String Fromdate2 = request.getParameter("Fromdate2");
        if (Fromdate2 == null) {
            Fromdate2 = "";
        }
        String file12 = request.getParameter("file12");
        if (boq.equals("0")) {
            file12 = "";
        }
        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile file2 = multipartRequest2.getFile("file2");
        String file2FileName = "";
        if (file2 != null && !file2.isEmpty()) {
            file2FileName = file2.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file2FileName);
            file2.transferTo(destinationFile);

        }
        if (file2FileName.equals("") || file2FileName == "") {
            file2FileName = file12;
        }

        String lao = request.getParameter("lao");
        if (lao == null) {
            lao = "0";
        } else {
            lao = "1";
        }
        String laoRefNo = request.getParameter("laoRefNo");
        if (laoRefNo == null) {
            laoRefNo = "";
        }
        String Fromdate3 = request.getParameter("Fromdate3");
        if (Fromdate3 == null) {
            Fromdate3 = "";
        }
        String file13 = request.getParameter("file13");
        if (lao.equals("0")) {
            file13 = "";
        }
        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile file3 = multipartRequest3.getFile("file3");
        String file3FileName = "";
        if (file3 != null && !file3.isEmpty()) {
            file3FileName = file3.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file3FileName);
            file3.transferTo(destinationFile);
        }
        if (file3FileName.equals("") || file3FileName == "") {
            file3FileName = file13;
        }
        String agremment = request.getParameter("agremment");
        if (agremment == null) {
            agremment = "0";
        } else {
            agremment = "1";
        }
        String agremmentRefNo = request.getParameter("agremmentRefNo");
        if (agremmentRefNo == null) {
            agremmentRefNo = "";
        }
        String Fromdate4 = request.getParameter("Fromdate4");
        if (Fromdate4 == null) {
            Fromdate4 = "";
        }
        String file14 = request.getParameter("file14");
        if (agremment.equals("0")) {
            file14 = "";
        }
        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile file4 = multipartRequest4.getFile("file4");
        String file4FileName = "";
        if (file4 != null && !file4.isEmpty()) {
            file4FileName = file4.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file4FileName);
            file4.transferTo(destinationFile);
        }
        if (file4FileName.equals("") || file4FileName == "") {
            file4FileName = file14;
        }
        String drawings = request.getParameter("drawings");
        if (drawings == null) {
            drawings = "0";
        } else {
            drawings = "1";
        }
        String drawingsRefNo = request.getParameter("drawingsRefNo");
        if (drawingsRefNo == null) {
            drawingsRefNo = "";
        }
        String Fromdate5 = request.getParameter("Fromdate5");
        if (Fromdate5 == null) {
            Fromdate5 = "";
        }
        String file15 = request.getParameter("file15");
        if (drawings.equals("0")) {
            file15 = "";
        }
        MultipartHttpServletRequest multipartRequest5 = (MultipartHttpServletRequest) request;
        MultipartFile file5 = multipartRequest5.getFile("file5");
        String file5FileName = "";
        if (file5 != null && !file5.isEmpty()) {
            file5FileName = file5.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file5FileName);
            file5.transferTo(destinationFile);
        }
        if (file5FileName.equals("") || file5FileName == "") {
            file5FileName = file15;
        }
        String operations = request.getParameter("operations");
        String operationsSign = request.getParameter("operationsSign");
        String maintenance = request.getParameter("maintenance");
        String maintenancesign = request.getParameter("maintenancesign");
        String Fromdate6 = request.getParameter("Fromdate6");
        String Fromdate7 = request.getParameter("Fromdate7");
        String inr = request.getParameter("inr");
        String comments = request.getParameter("comments");
        String Fromdate8 = request.getParameter("Fromdate8");
        String revisionNo = request.getParameter("revisionNo");
        String Fromdate9 = request.getParameter("Fromdate9");
        String reviewed = request.getParameter("reviewed");
        String designation = request.getParameter("designation");
        String signatureDate = request.getParameter("signatureDate");
//	String country = request.getParameter("country");
//	String state = request.getParameter("state");
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
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        aocForm.setDocumentNo(documentNo);
        aocForm.setHubDepoName(depoName);
        aocForm.setBb2(b2b);
        aocForm.setBbc22(b2b2c);
        aocForm.setBc2(b2c);
        aocForm.setClientProjectName(projectName);
        aocForm.setHubDepoAddress(depoAddress);
        aocForm.setGoogleCoordinates(googleCoordinates);
        aocForm.setPcTypeCar(car);
        aocForm.setPcTypeBus(bus);
        aocForm.setPcTypeTruckLmv(truck);
        aocForm.setOther(others);
        aocForm.setPcsType("");
        aocForm.setFinacialModelCapex(capex);
        aocForm.setFinacialModelOpex(opex);
        aocForm.setCoOrdinates(coordinates);
        aocForm.setFirstName(firstName);
        aocForm.setMiddleName("");
        aocForm.setLastName("");
        aocForm.setMobileNo(mobileNo);
        aocForm.setAlternateMobileNo(altNo);
        aocForm.setEmail(email);
        aocForm.setSpecificReqClients(reqClients);
        aocForm.setChargeScope(scopework);
        aocForm.setClientScope(scope);
        aocForm.setAssumptionSheet(assumption);
        aocForm.setAssumptionRefNo(assumptionRefNo);
        aocForm.setAssumptionDate(Fromdate1);
        aocForm.setEstimatedBoq(boq);
        aocForm.setEstimatedRefNo(boqRefNo);
        aocForm.setEstimatedDate(Fromdate2);
        aocForm.setLoaLoi(lao);
        aocForm.setLoaLoiRefNo(laoRefNo);
        aocForm.setLoaLoiDate(Fromdate3);
        aocForm.setAgreement(agremment);
        aocForm.setAgreementRefNo(agremmentRefNo);
        aocForm.setAgreementDate(Fromdate4);
        aocForm.setLayoutDrawings(drawings);
        aocForm.setLayoutRefNo(drawingsRefNo);
        aocForm.setLayoutDate(Fromdate5);
        aocForm.setOperations(operations);
        aocForm.setOperationsSign(operationsSign);
        aocForm.setMaintenance(maintenance);
        aocForm.setMaintenanceSign(maintenancesign);
        aocForm.setZeroDate(Fromdate6);
        aocForm.setCompletionDate(Fromdate7);
        aocForm.setProjectBudgetAllocated(inr);
        aocForm.setAuthorityComments(comments);
        aocForm.setOrderEffcectiveDate(Fromdate8);
        aocForm.setNewRevisionNo(revisionNo);
        aocForm.setBudjectAllocationDate(Fromdate9);
        aocForm.setReviewedBy(reviewed);
        aocForm.setDesignation(designation);
        aocForm.setSignatureDate("");
//	aocForm.setOapMaster(oapMaster);
        aocForm.setCreatedDate(today);
        aocForm.setUserId(username1);
        aocForm.setFlagStatus(1);
//	aocForm.setCountry(country);
//	aocForm.setState(state);
        aocForm.setCity(city);
        aocForm.setDistrict(district);
        aocForm.setHouseNo(houseno);
        aocForm.setAssumptionAttach(file0FileName);
        aocForm.setEstimatedAttach(file2FileName);
        aocForm.setLoaAttach(file3FileName);
        aocForm.setAgreementAttach(file4FileName);
        aocForm.setLayoutAttach(file5FileName);
        aocForm.setProjectProfile(ProjectProfile);
        aocForm.setProjectCenter(profitcenter);
        aocForm.setCompanyCode(CompanyCode);
        aocForm.setPlant(Plant);
        aocForm.setProjectType(ProjectType);
        aocForm.setProjectCurrency(ProjectCurrency);
        aocForm.setInverstmentProfile(InvestmentProfile);
//	aocForm.setDiscom(Discom);
        aocForm.setNoOfChargePoints(ChargePoints);
        aocForm.setNoOfCharger(NoOfCharger);
        aocForm.setOverallStationCapacityKw(overallstations);
        aocForm.setStationAcCapacityKw(stationAc);
        aocForm.setStationDcCapacityKw(stationDc);
        aocForm.setStationName(stationname);
        aocForm.setStationType(stationtype);
        aocForm.setTenant(tenant);
        aocForm.setChargingRatePerUnit(chargingrate);

        aocFormService.update(aocForm);
        int id1 = aocForm.getId();

        AocForm aocForm1 = aocFormService.readById(id1);

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Aoc"
                + File.separator + id1;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created
        //multi attachment
        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Aoc"
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

                    AocFormMultiAttachment aocFormMultiAttachment = new AocFormMultiAttachment();

                    aocFormMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    aocFormMultiAttachment.setDescription(description[a]);
                    aocFormMultiAttachment.setAocForm(aocForm1);

                    aocFormMultiAttachmentService.create(aocFormMultiAttachment);

                    a++;
                }
            }

        }

        String userid = aocForm.getUserId();
        String documentno = aocForm.getDocumentNo();
        String mailcreteddate = aocForm.getCreatedDate();
        EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
        String mail_to = employeeMaster2.getEmailId();

        EmailTemplate emailTemplate = emailTemplateService.readById(51);
        String mail_from = "";

        String subject = emailTemplate.getSubject();
        String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
        String Aoc_form = "AOC Form";

        msg = msg.replaceAll("\\{Aoc_form\\}", Aoc_form);
        msg = msg.replaceAll("\\{documentno\\}", documentno);
        msg = msg.replaceAll("\\{username\\}", userid);
        msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);
//	    msg = msg.replaceAll("\\{vendor_code\\}", checkedValues);
//	    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
//	    msg = msg.replaceAll("\\{department\\}", department);

        SendMail s = new SendMail();
        s.sendMail(mail_from, mail_to, subject, msg);

//	AocFormApproval aocFormApproval5 = aocFormApprovalService.readByDeltecodes(id);
//
//	int formid = aocFormApproval5.getId();
//
//	List list44 = aocFormApprovalUserService.readByDleteCode(formid);
//	for (Object o : list44) {
//	    AocFormApprovalUser oacAocFormApprovalUser = (AocFormApprovalUser) o;
//	    int id3 = oacAocFormApprovalUser.getId();
//	    aocFormApprovalUserService.delete(id3);
//	}
//
//	aocFormApprovalService.delete(formid);
//
//// approval name drop down relted code
//	List approval_list = oapMasterUserService.readByIdToList(approvalName);
//	HttpSession session = request.getSession(false);
//	UserMaster user = (UserMaster) session.getAttribute("user");
//	String username = user.getLoginName();
//	EmployeeMaster employeeMaster = employeeMasterService.read(username);
//	String employeeCode = employeeMaster.getEmployeeCode();
//
//	AocFormApproval aocFormApproval = new AocFormApproval();
//
//	aocFormApproval.setAocForm(aocForm1);
//	aocFormApproval.setTotalApproval(approval_list.size() + "");
//	aocFormApproval.setApprovalStatus("0");
//	aocFormApproval.setApprovalRemark("add");
//	aocFormApproval.setUserId(employeeCode);
//	aocFormApproval.setCurrentApproval("1");
//	aocFormApprovalService.create(aocFormApproval);
//
//	int approveId = aocFormApproval.getId();
//	OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);
//
//	int j = 0;
//	for (Object o : approval_list) {
//	    j++;
//	    OapMasterUser oap1 = (OapMasterUser) o;
//	    AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();
//	    aocFormApprovalUser.setAocFormApproval(approveId);
//	    aocFormApprovalUser.setAocForm(id1);
//	    aocFormApprovalUser.setUserId(oap1.getUserId());
//	    aocFormApprovalUser.setLevel(j + "");
//	    aocFormApprovalUser.setApprovalStatus("0");
//	    aocFormApprovalUserService.create(aocFormApprovalUser);
//
//	}
        mv = aocFormAppovalList(request, response);
        return mv;
    }

    public ModelAndView aocFormRecycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        AocFormApproval aocFormApproval = aocFormApprovalService.readById(Integer.parseInt(id));

        int aocformid = aocFormApproval.getAocForm().getId();
        AocForm aocForm = aocFormService.readById(aocformid);
        String documentno = aocForm.getDocumentNo();

//        AocFormApprovalUser aocFormApprovalUser = aocFormApprovalUserService.appval(username);
        AocFormApprovalUser aocFormApprovalUser = aocFormApprovalUserService.appvals(username, id);

        AocFormApprovalUser aocApprovalUser = aocFormApprovalUserService.readByIdAndUsername(id, username);

        String approvalStatus = aocApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {
            int approveId = aocFormApproval.getId();
            AocFormApprovalComment aocFormApprovalComment = aocFormApprovalCommentService.readByApprovalId(approveId);

            aocFormApproval.setApprovalStatus("2");
            aocFormApproval.setCurrentApproval("1");
            aocFormApprovalUser.setApprovalStatus("2");
            aocFormApprovalComment.setApprovalStatus("2");
            aocForm.setFlagStatus(2);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            aocFormApprovalComment.setUserId(employeeCode);
            aocFormApprovalComment.setAocFormApproval(approveId);
            aocFormApprovalComment.setApprovalComment(comment);
            aocFormApprovalComment.setAocForm(aocformid);

            aocFormApprovalCommentService.create(aocFormApprovalComment);

            String userid = aocFormApprovalComment.getUserId();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();
            EmailTemplate emailTemplate = emailTemplateService.readById(52);
            String mail_from = "";
            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            String Aoc_form = "AOC Form";

            msg = msg.replaceAll("\\{Aoc_form\\}", Aoc_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", userid);
//	msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);
            aocFormApprovalService.update(aocFormApproval);
            aocFormApprovalUserService.update(aocFormApprovalUser);
            aocFormService.update(aocForm);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Recyle");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("Recycled");
            aocLogMaster.setAocId(aocformid);
            aocLogMasterService.create(aocLogMaster);

            session.setAttribute("successMessage", "AOC Approval Rework successfully");
        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "AOC Approval Already Approved Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "AOC Approval Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "AOC Approval Already Rejected Successfully");
        } else {
            session.setAttribute("failureMessage", "The AOC approval has already progressed to the next stage");
        }
        mv.setViewName("redirect:aocForm.htm?act=AocApproval");

        return mv;
    }

    public ModelAndView aocRecycleView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        List aoclogmaster = aocLogMasterService.readByAocId(id);

        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(id);
        String aocFormattach = request.getParameter("aocFormattach");
        List list = AocFormAttachmentService.readByattach(aocFormattach);
        String aocFormmulti = request.getParameter("aocFormmulti");
        List list33 = aocFormMultiAttachmentService.readByMulti(aocFormmulti);

        AocFormApproval aocFormApproval = aocFormApprovalService.readByDeltecodes(id);
        int approveid = aocFormApproval.getId();

        List list0 = aocFormApprovalCommentService.readByIds(id);

        String discom = aocForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = aocForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", aocForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);
        mv.getModelMap().put("aoclogmaster", aoclogmaster);

        mv.setViewName("Oap/AocRecycleView");
        return mv;
    }

    public ModelAndView AocReject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        AocFormApproval aocFormApproval = aocFormApprovalService.readById(Integer.parseInt(id));

        int aocFormid = aocFormApproval.getAocForm().getId();
        AocForm aocForm = aocFormService.readById(aocFormid);

//        AocFormApprovalUser aocFormApprovalUser = aocFormApprovalUserService.appval(username);
        AocFormApprovalUser aocFormApprovalUser = aocFormApprovalUserService.appvals(username, id);

        int approveId = aocFormApproval.getId();
        AocFormApprovalComment aocFormApprovalComment = aocFormApprovalCommentService.readByApprovalId(approveId);

        String approvalStatus1 = aocFormApproval.getApprovalStatus();

        AocFormApprovalUser aocApprovalUser = aocFormApprovalUserService.readByIdAndUsername(id, username);

        String approvalStatus = aocApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {

            aocFormApproval.setApprovalStatus("3");
            aocFormApprovalUser.setApprovalStatus("3");
            aocFormApprovalComment.setApprovalStatus("3");
            aocForm.setFlagStatus(3);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            aocFormApprovalComment.setUserId(employeeCode);
            aocFormApprovalComment.setAocFormApproval(approveId);
            aocFormApprovalComment.setApprovalComment(comment);
            aocFormApprovalComment.setAocForm(aocFormid);

            aocFormApprovalCommentService.create(aocFormApprovalComment);

            aocFormService.update(aocForm);
            aocFormApprovalService.update(aocFormApproval);
            aocFormApprovalUserService.update(aocFormApprovalUser);

            String documentno = aocForm.getDocumentNo();
//	String mailcreteddate = aocForm.getCreatedDate();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(username);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(55);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Aoc_form = "AOC Form";

            msg = msg.replaceAll("\\{Aoc_form\\}", Aoc_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", username);
//	msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);
//	    msg = msg.replaceAll("\\{vendor_code\\}", checkedValues);
//	    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
//	    msg = msg.replaceAll("\\{department\\}", department);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Reject");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("Rejected");
            aocLogMaster.setAocId(aocFormid);
            aocLogMasterService.create(aocLogMaster);
            session.setAttribute("successMessage", "AocApproval Rejected Completed successfully");
        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "AocApproval Already Approved Successfully");

        } else if ("2".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "AocApproval Already Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", "AocApproval Already Rejected Successfully");
        } else {
            session.setAttribute("failureMessage", "The AOC approval has already progressed to the next stage");
        }
        mv.setViewName("redirect:aocForm.htm?act=AocApproval");

        return mv;
    }

    public ModelAndView AocDocxdownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String fileName = request.getParameter("fileName");
        String id1 = request.getParameter("id1");

        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Aoc"
                + File.separator + id1 + File.separator + fileName;

        request.setAttribute("filePath", fileLocationURL);
        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
        return mv;

    }

    public ModelAndView rejectview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        String aocFormattach = request.getParameter("aocFormattach");
        String aocFormmulti = request.getParameter("aocFormmulti");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(id);
        List aoclogmaster = aocLogMasterService.readByAocId(id);

        String discom = aocForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = aocForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);
        int id1 = aocForm.getId();

        List list = AocFormAttachmentService.readByattach(aocFormattach);
        List list33 = aocFormMultiAttachmentService.readByMulti(aocFormmulti);

        AocFormApproval aocFormApproval = aocFormApprovalService.readByDeltecodes(id);
        int approveid = aocFormApproval.getId();

        List list0 = aocFormApprovalCommentService.readByIds(id);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", aocForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);
        mv.getModelMap().put("aoclogmaster", aoclogmaster);

        mv.setViewName("Oap/AocRejectView");
        return mv;
    }

    public ModelAndView aocKickOffForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Oap/aocKickOffForm");
        return mv;
    }

    public ModelAndView aocKickOffFormAssign(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        AocForm aocForm1 = aocFormService.readById(Integer.parseInt(id));
        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(id);
        String discom = aocForm1.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = aocForm1.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);
        List list = AocFormAttachmentService.readByattach(id);
        List list33 = aocFormMultiAttachmentService.readByMulti(id);

        List list99 = employeeMasterService.read();

        AocFormApproval aocFormApproval = aocFormApprovalService.readByDeltecodes(id);
        int approveid = aocFormApproval.getId();

        List list0 = aocFormApprovalCommentService.readByIds(id);

        List list31 = userRightsService.readByCreated1();

        List list30 = userRightsService.readByprojectManager();

        mv.getModelMap().put("aocForm1", aocForm1);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list30", list30);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list99", list99);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list31", list31);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);
        mv.setViewName("Oap/aocKickOffFormAssign");
        return mv;
    }

    public ModelAndView aocKickOffFormAssignUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());
        String id = request.getParameter("id");

        String employee_code = request.getParameter("employee_code");
        String projectcoordinator = request.getParameter("projectcoordinator");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        if ("".equals(aocForm.getAssignedName())) {

            int aocFormId = aocForm.getId();
            String aocCreaterName = aocForm.getUserId();
            aocForm.setAssignedName(employee_code);
            aocForm.setProjectCoordinater(projectcoordinator);

            aocFormService.update(aocForm);

            String documentno = aocForm.getDocumentNo();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(employee_code);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(57);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Aoc_form = "AOC Form";

            msg = msg.replaceAll("\\{Aoc_form\\}", Aoc_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno);
            msg = msg.replaceAll("\\{username\\}", employee_code);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

            EmployeeMaster employeeMaster = employeeMasterService.readUser(projectcoordinator);
            String mail_to1 = employeeMaster.getEmailId();

            EmailTemplate emailTemplate1 = emailTemplateService.readById(58);
            String mail_from1 = "";

            String subject1 = emailTemplate1.getSubject();
            String msg1 = emailTemplate1.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Aoc_form1 = "AOC Form";

            msg = msg.replaceAll("\\{Aoc_form\\}", Aoc_form1);
            msg1 = msg1.replaceAll("\\{documentno\\}", documentno);
            msg1 = msg1.replaceAll("\\{username\\}", projectcoordinator);

            SendMail s1 = new SendMail();
            s1.sendMail(mail_from1, mail_to1, subject1, msg1);

            mv.getModelMap().put("id", id);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Asign");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments("");
            aocLogMaster.setStatus("Assigned");
            aocLogMaster.setAocId(Integer.parseInt(id));
            aocLogMasterService.create(aocLogMaster);
            request.setAttribute("successMessage",
                    "Information: Assign  To Employee successfully");

            // mail to the assigner ( whose session is )
            EmployeeMaster employeeMaster5 = employeeMasterService.readUser(username);

            String mail_to5 = employeeMaster5.getEmailId();

            EmailTemplate emailTemplate2 = emailTemplateService.readById(153);
            String mail_from5 = "";

            String subject5 = emailTemplate1.getSubject();
            String msg5 = emailTemplate1.getBodytext();

            String Aoc_form5 = "You have Assigned the Aoc Form";

            msg5 = msg5.replaceAll("\\{Aoc_form\\}", Aoc_form5);
            msg5 = msg5.replaceAll("\\{documentno\\}", documentno);
            msg5 = msg5.replaceAll("\\{username\\}", username);
            msg5 = msg5.replaceAll("\\{Approveddate\\}", currentDateTime5);

            SendMail s2 = new SendMail();
            s2.sendMail(mail_from5, mail_to5, subject5, msg5);

            AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();

            List list5 = aocFormApprovalUserService.readByaocId(aocFormId);

            for (Object listUser : list5) {

                aocFormApprovalUser = (AocFormApprovalUser) listUser;

                String approvalUserName = aocFormApprovalUser.getUserId();
                EmployeeMaster employeeMaster6 = employeeMasterService.readUser(approvalUserName);
                String approvalUserName1 = employeeMaster6.getName();
                if (employeeMaster6 != null && employeeMaster6.getEmailId() != null && !employeeMaster6.getEmailId().isEmpty()) {

                    String mail_to6 = employeeMaster6.getEmailId();

                    EmailTemplate emailTemplate3 = emailTemplateService.readById(154);
                    String mail_from6 = "";

                    String subject6 = emailTemplate3.getSubject();
                    String msg6 = emailTemplate3.getBodytext();

                    String Aoc_form6 = "AOC Form has been assigned by the Executive Head";

                    msg6 = msg6.replaceAll("\\{Aoc_form\\}", Aoc_form6);
                    msg6 = msg6.replaceAll("\\{assigned_by\\}", username);
                    msg6 = msg6.replaceAll("\\{documentno\\}", documentno);
                    msg6 = msg6.replaceAll("\\{username\\}", approvalUserName1);
                    msg6 = msg6.replaceAll("\\{Approveddate\\}", currentDateTime5);

                    SendMail s3 = new SendMail();
                    s3.sendMail(mail_from6, mail_to6, subject6, msg6);
                }

            }

            EmployeeMaster employeeMaster6 = employeeMasterService.readUser(aocCreaterName);
            String approvalUserName1 = employeeMaster6.getName();
            String mail_to6 = employeeMaster6.getEmailId();

            EmailTemplate emailTemplate3 = emailTemplateService.readById(155);
            String mail_from6 = "";

            String subject6 = emailTemplate3.getSubject();
            String msg7 = emailTemplate3.getBodytext();

            String Aoc_form6 = "AOC Form has been assigned by the Executive Head";

            msg7 = msg7.replaceAll("\\{Oap_form\\}", Aoc_form6);
            msg7 = msg7.replaceAll("\\{documentno\\}", documentno);
            msg7 = msg7.replaceAll("\\{assigned_by\\}", username);
            msg7 = msg7.replaceAll("\\{username\\}", approvalUserName1);
            msg7 = msg7.replaceAll("\\{Approveddate\\}", currentDateTime5);

            SendMail s3 = new SendMail();
            s3.sendMail(mail_from6, mail_to6, subject6, msg7);

            session.setAttribute("successMessage", "AOC successfully Assigned To Project Co-ordinator and Project Manager");
        } else {
            session.setAttribute("failureMessage", "Already AOC successfully Assigned To Project Co-ordinator and Project Manager");
        }
        mv.setViewName("redirect:aocForm.htm?act=aocKickOffForm");

        return mv;
    }

    public ModelAndView kickoffFormApproveList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Oap/kickoffFormApproveList");
        return mv;
    }

    public ModelAndView kickoffForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("aocId");

        List list10 = oapMasterService.read();

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        String projectmanager = aocForm.getProjectCoordinater();

        mv.getModelMap().put("projectmanager", projectmanager);
        String documentId = aocForm.getDocumentNo();
        if (documentId != null) {
            documentId = documentId.replaceFirst("AOC", "KOM");
        }
        mv.getModelMap().put("documentid", documentId);

        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("id", id);

        mv.setViewName("Oap/KickoffForm");
        return mv;
    }

    public ModelAndView kickoffFormsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        String aocId = request.getParameter("aocId");

        KickOffForm kickOffForms = kickOffFormService.readByaocId(aocId);

        if (kickOffForms.getDocumentNo() == null || kickOffForms.getDocumentNo().trim().isEmpty()) {

            String documentno = request.getParameter("documentno");
            String hub = request.getParameter("hub");
            String fromdateTime = request.getParameter("fromdateTime");
            String projectName = request.getParameter("projectName");
            String minutesprepared = request.getParameter("minutesprepared");
            String design = request.getParameter("design");
            if (design == null) {
                design = "0";
            } else {
                design = "1";
            }
            String boq = request.getParameter("boq");
            if (boq == null) {
                boq = "0";
            } else {
                boq = "1";
            }
            String loa = request.getParameter("loa");
            if (loa == null) {
                loa = "0";
            } else {
                loa = "1";
            }
            String agreement = request.getParameter("agreement");
            if (agreement == null) {
                agreement = "0";
            } else {
                agreement = "1";
            }
            String approved = request.getParameter("approved");
            if (approved == null) {
                approved = "0";
            } else {
                approved = "1";
            }

            String agendas = request.getParameter("agendas");
            String issues = request.getParameter("issues");
            String decisions = request.getParameter("decisions");
            String plan = request.getParameter("plan");
            if (plan == null) {
                plan = "0";
            } else {
                plan = "1";
            }
            String projectBudget = request.getParameter("projectBudget");
            if (projectBudget == null) {
                projectBudget = "0";
            } else {
                projectBudget = "1";
            }
            String projectTimeline = request.getParameter("projectTimeline");
            if (projectTimeline == null) {
                projectTimeline = "0";
            } else {
                projectTimeline = "1";
            }
            String comment = request.getParameter("comment");
            String designs = request.getParameter("designs");
            String approvedlayout = request.getParameter("approvedlayout");
            String boqno = request.getParameter("boqno");
            String Fromdate = request.getParameter("Fromdate");
            String reviewercomment = request.getParameter("reviewercomment");
            String newrevisonno = request.getParameter("newrevisonno");
            String preparedby = request.getParameter("preparedby");
            String designation = request.getParameter("designation");
//	String signaturedate = request.getParameter("signaturedate");
            String approvalName = request.getParameter("approvalName");
//        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
            AocForm aocForm = aocFormService.readById(Integer.parseInt(aocId));
            int id1 = aocForm.getId();
            KickOffForm kickOffForm = new KickOffForm();

            kickOffForm.setHubLocation(hub);
            kickOffForm.setDateTime(fromdateTime);
            kickOffForm.setProjectName(projectName);
            kickOffForm.setMinutues(minutesprepared);
            kickOffForm.setDesignBasic(design);
            kickOffForm.setBoq(boq);
            kickOffForm.setLaoLoi(loa);
            kickOffForm.setAgreement(agreement);
            kickOffForm.setApprovedLayout(approved);
            kickOffForm.setAgendas(agendas);
            kickOffForm.setIssues(issues);
            kickOffForm.setDecisions(decisions);
            kickOffForm.setPlanLayout(plan);
            kickOffForm.setProjectBudget(projectBudget);
            kickOffForm.setProjectTimeLine(projectTimeline);
            kickOffForm.setComments(comment);
            kickOffForm.setDesignBasicReport(designs);
            kickOffForm.setApprovedLayoutDrawings(approvedlayout);
            kickOffForm.setBoqNo(boqno);
            kickOffForm.setDeliverableReleaseDate(Fromdate);
            kickOffForm.setReviewsComments(reviewercomment);
            kickOffForm.setNewRevisonNo(newrevisonno);
            kickOffForm.setPreparedBy(preparedby);
            kickOffForm.setDesignation(designation);
            kickOffForm.setSignatureDate("");
//        kickOffForm.setOapMaster(oapMaster);
            kickOffForm.setFlagStatus(0);
            kickOffForm.setAocForm(aocForm);
            kickOffForm.setUserId(username1);
            kickOffForm.setDocumentNo(documentno);

            kickOffFormService.create(kickOffForm);

            int id = kickOffForm.getId();
            String mainusername = kickOffForm.getUserId();
            String documentno1 = kickOffForm.getDocumentNo();
            KickOffForm kickOffForm1 = kickOffFormService.readById(id);

            aocForm.setFlagStatus(6);
            aocFormService.update(aocForm);
            int aocid = aocForm.getId();
            String AoccreatedBy = aocForm.getUserId();
            String name[] = request.getParameterValues("name");
            String roll[] = request.getParameterValues("roll");
            String email[] = request.getParameterValues("email");
            String cellno[] = request.getParameterValues("cellno");

            try {

                for (int i = 0; i < name.length; i++) {

                    KickOffAttendences kickOffAttendences = new KickOffAttendences();
                    kickOffAttendences.setName(name[i]);
                    kickOffAttendences.setRollInProject(roll[i]);
                    kickOffAttendences.setEmail(email[i]);
                    kickOffAttendences.setCellNo(cellno[i]);
                    kickOffAttendences.setKickoffFormId(id);
                    kickOffAttendencesService.create(kickOffAttendences);

                }
            } catch (Exception e) {
                // Properly log the exception for debugging purposes
                e.printStackTrace();
                // Optionally, rethrow the exception or handle it as needed
            }

            // approval name drop down relted code
            List approval_list = oapMasterUserService.readByIdToList(approvalName);
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            KickOffFormApproval kickOffFormApproval = new KickOffFormApproval();
            kickOffFormApproval.setKickOffForm(kickOffForm1);
            kickOffFormApproval.setTotalApproval("1");
            kickOffFormApproval.setApprovalStatus("0");
            kickOffFormApproval.setApprovalRemark("add");
            kickOffFormApproval.setUserId(employeeCode);
            kickOffFormApproval.setCurrentApproval("1");
            kickOffFormApprovalService.create(kickOffFormApproval);

            int approveId = kickOffFormApproval.getId();
            KickOffFormApproval kickOffFormApproval1 = kickOffFormApprovalService.readById(approveId);
//        int j = 0;
//        for (Object o : approval_list) {
//            j++;
//            OapMasterUser oap1 = (OapMasterUser) o;
            KickOffFormApprovalUser kickOffFormApprovalUser = new KickOffFormApprovalUser();
            kickOffFormApprovalUser.setKickOffFormApproval(approveId);
            kickOffFormApprovalUser.setKickOffForm(id);
            kickOffFormApprovalUser.setUserId(approvalName);
            kickOffFormApprovalUser.setLevel("1");
            kickOffFormApprovalUser.setApprovalStatus("0");
            kickOffFormApprovalUserService.create(kickOffFormApprovalUser);

            String userid = kickOffFormApprovalUser.getUserId();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(59);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Kom_form = "KOM Form";

            msg = msg.replaceAll("\\{Kom_form\\}", Kom_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", mainusername);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

//        }
            // kom created person
            EmployeeMaster employeeMaster1 = employeeMasterService.readUser(username1);
            String mail_to1 = employeeMaster1.getEmailId();

            EmailTemplate emailTemplate1 = emailTemplateService.readById(156);
            String mail_from1 = "";

            String subject1 = emailTemplate1.getSubject();
            String msg1 = emailTemplate1.getBodytext();
            String kom_form1 = "Kom Created ";

            msg1 = msg1.replaceAll("\\{Oap_form\\}", kom_form1);
            msg1 = msg1.replaceAll("\\{documentno\\}", documentno);
            msg1 = msg1.replaceAll("\\{username\\}", username1);
            msg1 = msg1.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s1 = new SendMail();
            s1.sendMail(mail_from1, mail_to1, subject1, msg1);
//AOC Approvals
            AocFormApprovalUser aocFormApprovalUser1 = new AocFormApprovalUser();

//        int id8 = Integer.parseInt(id);
            List userid1 = aocFormApprovalUserService.readByaocId(aocid);
            for (Object pdf1 : userid1) {
                aocFormApprovalUser1 = (AocFormApprovalUser) pdf1;
                String usernames = aocFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(157);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "KOM Created";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }

            //aoc Cretaed person
            EmployeeMaster employeeMaster11 = employeeMasterService.readUser(AoccreatedBy);
            String mail_to11 = employeeMaster11.getEmailId();

            EmailTemplate emailTemplate11 = emailTemplateService.readById(158);
            String mail_from11 = "";

            String subject11 = emailTemplate11.getSubject();
            String msg11 = emailTemplate11.getBodytext();
            String crc_form11 = "KOM Created";

            msg11 = msg11.replaceAll("\\{Oap_form\\}", crc_form11);
            msg11 = msg11.replaceAll("\\{documentno\\}", documentno);
            msg11 = msg11.replaceAll("\\{username\\}", username);
            msg11 = msg11.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s11 = new SendMail();
            s11.sendMail(mail_from11, mail_to11, subject11, msg11);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("KOM Create");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments("");
            aocLogMaster.setStatus("Created");
            aocLogMaster.setAocId(id1);
            aocLogMaster.setKomId(id);
            aocLogMasterService.create(aocLogMaster);

            session1.setAttribute("successMessage", "Kickoff Form  Created successfully");
        } else {
            session1.setAttribute("failureMessage", "Already Kickoff Form Created successfully");
        }
        mv.setViewName("redirect:aocForm.htm?act=kickoffFormApproveList");

        return mv;
    }

    public ModelAndView KickOffFormApprovalUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Oap/KickOffFormApprovalUser");
        return mv;
    }

    public ModelAndView KickOffApprovalUserView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String kickoffFormId = request.getParameter("kickoffFormId");

        KickOffFormApproval kickOffFormApproval = kickOffFormApprovalService.readById(Integer.parseInt(id));

        List kickoffApproval1 = kickOffFormApprovalService.readids(id);

        KickOffForm list55 = kickOffFormService.readById(Integer.parseInt(kickoffFormId));

        List list44 = kickOffAttendencesService.readByid(kickoffFormId);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", list55);
        mv.getModelMap().put("list1", kickoffApproval1);
        mv.getModelMap().put("list8", kickOffFormApproval);
        mv.getModelMap().put("list44", list44);
        mv.getModelMap().put("kickoffFormId", kickoffFormId);
        mv.setViewName("Oap/KickOffApprovalUserView");
        return mv;
    }

    public ModelAndView KickOffFormApprovalUserApprove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        KickOffFormApproval kickOffFormApproval = kickOffFormApprovalService.readById(Integer.parseInt(id));

        int kickOffFormid = kickOffFormApproval.getKickOffForm().getId();

        KickOffForm kickOffForm = kickOffFormService.readById(kickOffFormid);

        String komcreated = kickOffForm.getUserId();

        int aocFormid = kickOffForm.getAocForm().getId();

        AocForm aocForm = aocFormService.readByformid(aocFormid);
        String documentno = aocForm.getDocumentNo();
        String AocAsignperson = aocForm.getAssignedName();
        String Aoccreater = aocForm.getUserId();

        int kickOffFormid1 = kickOffFormApproval.getId();

        int approvalid = kickOffFormApproval.getId();

        KickOffFormApprovalComment kickOffFormApprovalComment1 = kickOffFormApprovalCommentService.readByApproveId(approvalid);

        String totalApproval = kickOffFormApproval.getTotalApproval();

        String ca = kickOffFormApproval.getCurrentApproval();

        KickOffFormApprovalUser kickOffFormApprovalUser = kickOffFormApprovalUserService.appvals(username, kickOffFormid);

        String approvalStatus = kickOffFormApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {
            kickOffFormApproval.setApprovalStatus("1");
            kickOffFormApprovalUser.setApprovalStatus("1");
            kickOffFormApprovalComment1.setApprovalStatus("1");
            kickOffForm.setFlagStatus(1);
            aocForm.setFlagStatus(7);

//        if (totalApproval.equals(ca)) {
//        } else {
//            String level = kickOffFormApprovalUser.getLevel();
//            int a = Integer.parseInt(level);
//            a++;
//            kickOffFormApproval.setCurrentApproval(level);
//            kickOffFormApprovalUser.setApprovalStatus("1");
//            kickOffFormApprovalComment1.setApprovalStatus("1");
//            kickOffFormApproval.setCurrentApproval("2");
//        }
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            kickOffFormApprovalComment1.setApprovalComment(comment);
            kickOffFormApprovalComment1.setUserId(username);
            kickOffFormApprovalComment1.setKickOffFormApproval(kickOffFormApproval);
            kickOffFormApprovalComment1.setApprovalStatus("1");
            kickOffFormApprovalCommentService.create(kickOffFormApprovalComment1);

            kickOffFormApprovalService.update(kickOffFormApproval);
            kickOffFormApprovalUserService.update(kickOffFormApprovalUser);
            kickOffFormService.update(kickOffForm);
            aocFormService.update(aocForm);

            String userid = kickOffFormApprovalComment1.getUserId();
            String documentno1 = kickOffForm.getDocumentNo();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(62);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", njokmpl,;.['xrdtfcvlocation.toUpperCase());
            String Kom_form = "KOM Form";

            msg = msg.replaceAll("\\{Kom_form\\}", Kom_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);
            //kom Created person
            EmployeeMaster employeeMaster1 = employeeMasterService.readUser(komcreated);
            String mail_to1 = employeeMaster1.getEmailId();

            EmailTemplate emailTemplate1 = emailTemplateService.readById(159);
            String mail_from1 = "";

            String subject1 = emailTemplate1.getSubject();
            String msg1 = emailTemplate1.getBodytext();
            String kom_form1 = "Kom Approval Person Approved ";

            msg1 = msg1.replaceAll("\\{Oap_form\\}", kom_form1);
            msg1 = msg1.replaceAll("\\{documentno\\}", documentno);
            msg1 = msg1.replaceAll("\\{username\\}", username);
            msg1 = msg1.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s1 = new SendMail();
            s1.sendMail(mail_from1, mail_to1, subject1, msg1);
            //EH AOC
            EmployeeMaster employeeMaster3 = employeeMasterService.readUser(AocAsignperson);
            String mail_to3 = employeeMaster3.getEmailId();

            EmailTemplate emailTemplate3 = emailTemplateService.readById(160);
            String mail_from3 = "";

            String subject3 = emailTemplate3.getSubject();
            String msg3 = emailTemplate3.getBodytext();
            String crc_form3 = "Kom Approval Person Approved";

            msg3 = msg3.replaceAll("\\{Oap_form\\}", crc_form3);
            msg3 = msg3.replaceAll("\\{documentno\\}", documentno);
            msg3 = msg3.replaceAll("\\{username\\}", username);
            msg3 = msg3.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s3 = new SendMail();
            s3.sendMail(mail_from3, mail_to3, subject3, msg3);

            // AOC Approval persons
            AocFormApprovalUser aocFormApprovalUser1 = new AocFormApprovalUser();

//        int id8 = Integer.parseInt(id);
            List userid1 = aocFormApprovalUserService.readByaocId(aocFormid);
            for (Object pdf1 : userid1) {
                aocFormApprovalUser1 = (AocFormApprovalUser) pdf1;
                String usernames = aocFormApprovalUser1.getUserId();
                EmployeeMaster employeeMaster8 = employeeMasterService.readUser(usernames);
                String mail_to8 = employeeMaster8.getEmailId();

                EmailTemplate emailTemplate8 = emailTemplateService.readById(161);
                String mail_from8 = "";

                String subject8 = emailTemplate8.getSubject();
                String msg8 = emailTemplate8.getBodytext();
                String crc_form8 = "Kom Approval Person Approved";

                msg8 = msg8.replaceAll("\\{Oap_form\\}", crc_form8);
                msg8 = msg8.replaceAll("\\{documentno\\}", documentno);
                msg8 = msg8.replaceAll("\\{username\\}", username);
                msg8 = msg8.replaceAll("\\{createddate\\}", currentDateTime5);

                SendMail s8 = new SendMail();
                s8.sendMail(mail_from8, mail_to8, subject8, msg8);

            }
            // aoc Created Person
            EmployeeMaster employeeMaster11 = employeeMasterService.readUser(Aoccreater);
            String mail_to11 = employeeMaster11.getEmailId();

            EmailTemplate emailTemplate11 = emailTemplateService.readById(162);
            String mail_from11 = "";

            String subject11 = emailTemplate11.getSubject();
            String msg11 = emailTemplate11.getBodytext();
            String crc_form11 = "Kom Approval Person Approved";

            msg11 = msg11.replaceAll("\\{Oap_form\\}", crc_form11);
            msg11 = msg11.replaceAll("\\{documentno\\}", documentno);
            msg11 = msg11.replaceAll("\\{username\\}", username);
            msg11 = msg11.replaceAll("\\{createddate\\}", currentDateTime5);

            SendMail s11 = new SendMail();
            s11.sendMail(mail_from11, mail_to11, subject11, msg11);

            // design manager send  mail
            List ApprovalStatus = kickOffFormApprovalUserService.readByApprovestatus(kickOffFormid + "");

            if (ApprovalStatus.size() == 0) {
                List designrights = userRightsService.readByDesignManager();

                for (Object pdf2 : designrights) {
//                String username1 = pdf2.toString();  // if it's a string or simple object

                    Object[] row = (Object[]) pdf2;
                    String username1 = (String) row[1];
                    EmployeeMaster employeeMaster7 = employeeMasterService.readUser(username1);
                    String mail_to7 = employeeMaster7.getEmailId();

                    EmailTemplate emailTemplate7 = emailTemplateService.readById(163);
                    String mail_from7 = "";

                    String subject7 = emailTemplate7.getSubject();
                    String msg7 = emailTemplate7.getBodytext();

                    String crc_form7 = "All KOM Form Approvals ";

                    msg7 = msg7.replaceAll("\\{Oap_form\\}", crc_form7);
                    msg7 = msg7.replaceAll("\\{documentno\\}", documentno);
//                msg7 = msg7.replaceAll("\\{finalapproveddate\\}", currentDateTime5);

                    SendMail s7 = new SendMail();
                    s7.sendMail(mail_from7, mail_to7, subject7, msg7);
                }
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("KOM Approval");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("Approved");
            aocLogMaster.setAocId(aocFormid);
            aocLogMaster.setKomId(kickOffFormid);
            aocLogMasterService.create(aocLogMaster);

            session.setAttribute("successMessage", " KOM Approved Done successfully");

        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", " Already KOM Approved Successfully");

        } else if ("8".equals(approvalStatus)) {
            session.setAttribute("failureMessage", " Already KOM Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", " Already KOM Rejected Successfully");
        } else {
            session.setAttribute("failureMessage", " The KOM approval has already progressed to the next stage");
        }

        mv.setViewName("redirect:aocForm.htm?act=KickOffFormApprovalUser");

        return mv;
    }

    public ModelAndView KickOffFormList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Oap/KickOffFormList");
        return mv;
    }

    public ModelAndView KickOffFormApprovalMatrixview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        KickOffForm kickOffForm = kickOffFormService.readById(Integer.parseInt(id));

        List list44 = kickOffAttendencesService.readByids(id);

        KickOffFormApproval kickOffFormApproval = kickOffFormApprovalService.readBykickapprid(id);

        int approvalid = kickOffFormApproval.getId();

        List list0 = kickOffFormApprovalUserService.readByApprovestatus(id);

        List aoclogmaster = aocLogMasterService.readByKomid(id);
        mv.getModelMap().put("aoclogmaster", aoclogmaster);

        mv.getModelMap().put("list55", kickOffForm);
        mv.getModelMap().put("list44", list44);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("id", id);

        mv.setViewName("Oap/KickOffFormApprovalMatrixview");
        return mv;
    }

    public ModelAndView KickOffFormListview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        KickOffForm kickOffForm = kickOffFormService.readById(Integer.parseInt(id));

        List list44 = kickOffAttendencesService.readByids(id);

        KickOffFormApproval kickOffFormApproval = kickOffFormApprovalService.readBykickapprid(id);

        int approvalid = kickOffFormApproval.getId();

        List list0 = kickOffFormApprovalCommentService.readByapproveId(approvalid);

        List aoclogmaster = aocLogMasterService.readByKomid(id);
        mv.getModelMap().put("aoclogmaster", aoclogmaster);

        mv.getModelMap().put("list55", kickOffForm);
        mv.getModelMap().put("list44", list44);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/KickOffFormListview");
        return mv;
    }

    public ModelAndView KickOffListEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        KickOffForm kickOffForm = kickOffFormService.readById(Integer.parseInt(id));

//        int oapmasterId = kickOffForm.getOapMaster().getId();
        int aocformid = kickOffForm.getAocForm().getId();

        AocForm aocform = aocFormService.readByformid(aocformid);

        String projectmanager = aocform.getProjectCoordinater();
        mv.getModelMap().put("projectmanager", projectmanager);

        List list10 = oapMasterService.read();

        List list44 = kickOffAttendencesService.readByids(id);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("kickOffForm", kickOffForm);
//        mv.getModelMap().put("oapmasterId", oapmasterId);
        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("list44", list44);
        mv.getModelMap().put("aocformid", aocformid);
        mv.setViewName("Oap/KickOffListEdit");
        return mv;
    }

    public ModelAndView KickOffattdencesdelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");
        kickOffAttendencesService.delete(Integer.parseInt(id));

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("id1", id1);
        mv.setViewName("forward:aocForm.htm?act=KickOffListEdit&id=" + id1);
        return mv;
    }

    public ModelAndView KickOffEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String id = request.getParameter("id");
        KickOffForm kickOffForm = kickOffFormService.readById(Integer.parseInt(id));

        int flagStatus = kickOffForm.getFlagStatus();

        if (flagStatus == 2) {
            String aocId = request.getParameter("aocId");
            String hub = request.getParameter("hub");
            String fromdateTime = request.getParameter("fromdateTime");
            String projectName = request.getParameter("projectName");
            String minutesprepared = request.getParameter("minutesprepared");
            String design = request.getParameter("design");
            if (design == null) {
                design = "0";
            } else {
                design = "1";
            }
            String boq = request.getParameter("boq");
            if (boq == null) {
                boq = "0";
            } else {
                boq = "1";
            }
            String loa = request.getParameter("loa");
            if (loa == null) {
                loa = "0";
            } else {
                loa = "1";
            }
            String agreement = request.getParameter("agreement");
            if (agreement == null) {
                agreement = "0";
            } else {
                agreement = "1";
            }
            String approved = request.getParameter("approved");
            if (approved == null) {
                approved = "0";
            } else {
                approved = "1";
            }

            String agendas = request.getParameter("agendas");
            String issues = request.getParameter("issues");
            String decisions = request.getParameter("decisions");
            String plan = request.getParameter("plan");
            if (plan == null) {
                plan = "0";
            } else {
                plan = "1";
            }
            String projectBudget = request.getParameter("projectBudget");
            if (projectBudget == null) {
                projectBudget = "0";
            } else {
                projectBudget = "1";
            }
            String projectTimeline = request.getParameter("projectTimeline");
            if (projectTimeline == null) {
                projectTimeline = "0";
            } else {
                projectTimeline = "1";
            }
            String comment = request.getParameter("comment");
            String designs = request.getParameter("designs");
            String approvedlayout = request.getParameter("approvedlayout");
            String boqno = request.getParameter("boqno");
            String Fromdate = request.getParameter("Fromdate");
            String reviewercomment = request.getParameter("reviewercomment");
            String newrevisonno = request.getParameter("newrevisonno");
            String preparedby = request.getParameter("preparedby");
            String designation = request.getParameter("designation");
//	String signaturedate = request.getParameter("signaturedate");
            String approvalName = request.getParameter("approvalName");
//        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
            AocForm aocForm = aocFormService.readById(Integer.parseInt(aocId));

//	KickOffForm kickOffForm = new KickOffForm();
            kickOffForm.setHubLocation(hub);
            kickOffForm.setDateTime(fromdateTime);
            kickOffForm.setProjectName(projectName);
            kickOffForm.setMinutues(minutesprepared);
            kickOffForm.setDesignBasic(design);
            kickOffForm.setBoq(boq);
            kickOffForm.setLaoLoi(loa);
            kickOffForm.setAgreement(agreement);
            kickOffForm.setApprovedLayout(approved);
            kickOffForm.setAgendas(agendas);
            kickOffForm.setIssues(issues);
            kickOffForm.setDecisions(decisions);
            kickOffForm.setPlanLayout(plan);
            kickOffForm.setProjectBudget(projectBudget);
            kickOffForm.setProjectTimeLine(projectTimeline);
            kickOffForm.setComments(comment);
            kickOffForm.setDesignBasicReport(designs);
            kickOffForm.setApprovedLayoutDrawings(approvedlayout);
            kickOffForm.setBoqNo(boqno);
            kickOffForm.setDeliverableReleaseDate(Fromdate);
            kickOffForm.setReviewsComments(reviewercomment);
            kickOffForm.setNewRevisonNo(newrevisonno);
            kickOffForm.setPreparedBy(preparedby);
            kickOffForm.setDesignation(designation);
            kickOffForm.setSignatureDate("");
//        kickOffForm.setOapMaster(oapMaster);
            kickOffForm.setFlagStatus(0);
            kickOffForm.setAocForm(aocForm);
            kickOffForm.setUserId(username1);

            kickOffFormService.update(kickOffForm);

            int id1 = kickOffForm.getId();
            String documentno1 = kickOffForm.getDocumentNo();
            String mainusername = kickOffForm.getUserId();

            KickOffForm kickOffForm1 = kickOffFormService.readById(id1);

            String name[] = request.getParameterValues("name");
            String roll[] = request.getParameterValues("roll");
            String email[] = request.getParameterValues("email");
            String cellno[] = request.getParameterValues("cellno");

            try {
                for (int i = 0; i < name.length; i++) {

                    KickOffAttendences kickOffAttendences = new KickOffAttendences();
                    if (name[i] == "") {

                    } else {
                        kickOffAttendences.setName(name[i]);
                        kickOffAttendences.setRollInProject(roll[i]);
                        kickOffAttendences.setEmail(email[i]);
                        kickOffAttendences.setCellNo(cellno[i]);
                        kickOffAttendences.setKickoffFormId(id1);
                        kickOffAttendencesService.create(kickOffAttendences);
                    }
                }
            } catch (Exception e) {
                // Properly log the exception for debugging purposes
                e.printStackTrace();
                // Optionally, rethrow the exception or handle it as needed
            }

//		CrcFormApproval crcFormApproval5 = crcFormApprovalService.readByDeltecodes(id);
            KickOffFormApproval kickOffFormApproval5 = kickOffFormApprovalService.readByDeltecodes(id);

            int formid = kickOffFormApproval5.getId();

            List list44 = kickOffFormApprovalUserService.readByDleteCode(formid);

            for (Object o : list44) {
                KickOffFormApprovalUser kickOffFormApprovalUser = (KickOffFormApprovalUser) o;

                int id3 = kickOffFormApprovalUser.getId();
                kickOffFormApprovalUserService.delete(id3);
            }

            List list55 = kickOffFormApprovalCommentService.readByapproveId(formid);
            for (Object o : list55) {
                KickOffFormApprovalComment kickOffFormApprovalComment = (KickOffFormApprovalComment) o;

                int id3 = kickOffFormApprovalComment.getId();
                kickOffFormApprovalCommentService.delete(id3);
            }

            kickOffFormApprovalService.delete(formid);

// approval name drop down relted code
            List approval_list = oapMasterUserService.readByIdToList(approvalName);
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            KickOffFormApproval kickOffFormApproval = new KickOffFormApproval();

            kickOffFormApproval.setKickOffForm(kickOffForm1);

            kickOffFormApproval.setTotalApproval("1");
            kickOffFormApproval.setApprovalStatus("0");
            kickOffFormApproval.setApprovalRemark("add");
            kickOffFormApproval.setUserId(employeeCode);
            kickOffFormApproval.setCurrentApproval("1");
            kickOffFormApprovalService.create(kickOffFormApproval);

            int approveId = kickOffFormApproval.getId();
            KickOffFormApproval kickOffFormApproval1 = kickOffFormApprovalService.readById(approveId);
//        int j = 0;
//        for (Object o : approval_list) {
//            j++;
//            OapMasterUser oap1 = (OapMasterUser) o;
            KickOffFormApprovalUser kickOffFormApprovalUser = new KickOffFormApprovalUser();
            kickOffFormApprovalUser.setKickOffFormApproval(approveId);
            kickOffFormApprovalUser.setKickOffForm(id1);
            kickOffFormApprovalUser.setUserId(approvalName);
            kickOffFormApprovalUser.setLevel("1");
            kickOffFormApprovalUser.setApprovalStatus("0");
            kickOffFormApprovalUserService.create(kickOffFormApprovalUser);

            String userid = kickOffFormApprovalUser.getUserId();
            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(60);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
            String Kom_form = "KOM Form";

            msg = msg.replaceAll("\\{Kom_form\\}", Kom_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", mainusername);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

//        }
            java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String currentDateTime5 = formatter5.format(new java.util.Date());
            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("KOM Approval");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setStatus("Recycled Edited");
            aocLogMaster.setComments("");
            aocLogMaster.setAocId(Integer.parseInt(aocId));
            aocLogMaster.setKomId(id1);
            aocLogMasterService.create(aocLogMaster);

            session.setAttribute("successMessage", "KOM Edited  successfully");

        } else if (flagStatus == 0) {
            session1.setAttribute("failureMessage", "KOM Already Edited  Successfully");
        } else {
            session1.setAttribute("failureMessage", "The KOM approval has already progressed to the next stage");
        }

        mv.setViewName("redirect:aocForm.htm?act=KickOffFormList");

        return mv;
    }

    public ModelAndView KickOffFormReject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        String comment = request.getParameter("comment");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        KickOffFormApproval kickOffFormApproval = kickOffFormApprovalService.readById(Integer.parseInt(id));

        int kickoffformid = kickOffFormApproval.getKickOffForm().getId();

        KickOffForm kickOffForm = kickOffFormService.readById(kickoffformid);
        int aocFormid = kickOffForm.getAocForm().getId();
        int id1 = kickOffForm.getAocForm().getId();

        String documentno1 = kickOffForm.getDocumentNo();

        AocForm aocForm = aocFormService.readByformid(id1);

        int approveId = kickOffFormApproval.getId();

        KickOffFormApprovalComment kickOffFormApprovalComment = kickOffFormApprovalCommentService.readByApproveId(approveId);

//        String approvalStatus = kickOffFormApproval.getApprovalStatus();
        KickOffFormApprovalUser kickOffFormApprovalUser = kickOffFormApprovalUserService.appvals(username, kickoffformid);

        String approvalStatus = kickOffFormApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {

            kickOffFormApproval.setApprovalStatus("3");
            kickOffFormApprovalUser.setApprovalStatus("3");
            kickOffFormApprovalComment.setApprovalStatus("3");

            kickOffForm.setFlagStatus(3);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            kickOffFormApprovalComment.setUserId(employeeCode);
            kickOffFormApprovalComment.setKickOffFormApproval(kickOffFormApproval);
            kickOffFormApprovalComment.setApprovalComment(comment);
            kickOffFormApprovalCommentService.create(kickOffFormApprovalComment);

            kickOffFormApprovalService.update(kickOffFormApproval);
            kickOffFormApprovalUserService.update(kickOffFormApprovalUser);
            kickOffFormService.update(kickOffForm);
            String userid = kickOffFormApprovalComment.getUserId();

            EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
            String mail_to = employeeMaster2.getEmailId();

            EmailTemplate emailTemplate = emailTemplateService.readById(61);
            String mail_from = "";

            String subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", njokmpl,;.['xrdtfcvlocation.toUpperCase());
            String Kom_form = "KOM Form";

            msg = msg.replaceAll("\\{Kom_form\\}", Kom_form);
            msg = msg.replaceAll("\\{documentno\\}", documentno1);
            msg = msg.replaceAll("\\{username\\}", userid);
//	    msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);
//	    msg = msg.replaceAll("\\{vendor_code\\}", checkedValues);
//	    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
//	    msg = msg.replaceAll("\\{department\\}", department);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String today = dateFormat.format(new Date());

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("KOM Reject");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("KOM Rejected");
            aocLogMaster.setAocId(aocFormid);
            aocLogMaster.setKomId(kickoffformid);
            aocLogMasterService.create(aocLogMaster);

            session.setAttribute("successMessage", "Information: KOM Rejected successfully");

        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", " Already KOM Approved Successfully");

        } else if ("8".equals(approvalStatus)) {
            session.setAttribute("failureMessage", " Already KOM Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", " Already KOM Rejected Successfully");
        } else {
            session.setAttribute("failureMessage", "The KOM approval has already progressed to the next stage");
        }

        mv.setViewName("redirect:aocForm.htm?act=KickOffFormApprovalUser");

        return mv;
    }

    public ModelAndView CreatePrFromAoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        KickOffForm kickOffForm = kickOffFormService.readById(Integer.parseInt(id));
        int aocformid = kickOffForm.getAocForm().getId();

        List list = deliverableMultiService.readByaocId(aocformid);
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
        mv.getModelMap().put("aocformid", aocformid);
        mv.getModelMap().put("kickOffForm", kickOffForm);
        mv.setViewName("Oap/CreatePrFromAoc");

        return mv;
    }

    public ModelAndView aocFormRecycleEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

//	String aocFormattach = request.getParameter("aocFormattach");
//	String aocFormmulti = request.getParameter("aocFormmulti");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(id);
        int size = aocsurveyattach.size();
        String discom = aocForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String projectname = aocForm.getClientProjectName();
        String name = aocForm.getAnchoreCustomer();
        String names = aocForm.getCanopyVarient();
        String connectionType = aocForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

        int aocmasterId = aocForm.getOapMaster().getId();
        List list = AocFormAttachmentService.readByattach(id);
        List list33 = aocFormMultiAttachmentService.readByMulti(id);
        List list10 = oapMasterService.read();

        String Tenant = aocForm.getTenant();
        String StationType = aocForm.getStationType();
        String Currency = aocForm.getProjectCurrency();
        String ProjectType = aocForm.getProjectType();
        String Ivestmentprofile = aocForm.getInverstmentProfile();
        String ProjectCenter = aocForm.getProjectCenter();
        String CompanyCode = aocForm.getCompanyCode();
        String ProjectProfile = aocForm.getProjectProfile();
        String Discom = aocForm.getDiscom();
        String plant = aocForm.getPlant();
        mv.getModelMap().put("plant", plant);
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
        request.setAttribute("list13", list13);
        mv.getModelMap().put("aocForm", aocForm);

        mv.getModelMap().put("list15", list15);
        mv.getModelMap().put("list16", list16);
        mv.getModelMap().put("name", name);
        mv.getModelMap().put("names", names);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("aocmasterId", aocmasterId);
        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);
        request.setAttribute("size", size);
        mv.setViewName("Oap/aocFormRecycleEdit");
        return mv;
    }

    public ModelAndView aocFormRecycleEditsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());
        java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateTime5 = formatter5.format(new java.util.Date());

        AocForm aocFormRecycle = aocFormService.readById(Integer.parseInt(id));

        int FlagStatus = aocFormRecycle.getFlagStatus();

        if (FlagStatus == 2) {

            String documentNo = request.getParameter("documentNo");
            String depoName = request.getParameter("depoName");
            String b2b = request.getParameter("b2b");
            String b2b2c = request.getParameter("b2b2c");
            String b2c = request.getParameter("b2c");
            String projectName = request.getParameter("projectName");
            String depoAddress = request.getParameter("depoAddress");
            String googleCoordinates = request.getParameter("googleCoordinates");
            String car = request.getParameter("car");
            if (car == null) {
                car = "0";
            } else {
                car = "1";
            }
            String bus = request.getParameter("bus");
            if (bus == null) {
                bus = "0";
            } else {
                bus = "1";
            }
            String truck = request.getParameter("truck");
            if (truck == null) {
                truck = "0";
            } else {
                truck = "1";
            }
            String others = request.getParameter("others");
            String pcs = request.getParameter("pcs");
            String capex = request.getParameter("capex");
            if (capex == null) {
                capex = "0";
            } else {
                capex = "1";
            }
            String opex = request.getParameter("opex");
            if (opex == null) {
                opex = "0";
            } else {
                opex = "1";
            }
            String coordinates = request.getParameter("coordinates");
            String firstName = request.getParameter("firstName");
//	String middleName = request.getParameter("middleName");
//	String lastName = request.getParameter("lastName");
            String mobileNo = request.getParameter("mobileNo");
            String altNo = request.getParameter("altNo");
            String email = request.getParameter("email");
            String reqClients = request.getParameter("reqClients");
            String scopework = request.getParameter("scopework");
            String scope = request.getParameter("scope");
            String assumption = request.getParameter("assumption");
            if (assumption == null) {
                assumption = "0";
            } else {
                assumption = "1";
            }
            String assumptionRefNo = request.getParameter("assumptionRefNo");
            if (assumptionRefNo == null) {
                assumptionRefNo = "";
            }
            String Fromdate1 = request.getParameter("Fromdate1");
            if (Fromdate1 == null) {
                Fromdate1 = "";
            }
            String file11 = request.getParameter("file11");
            if (assumption.equals("0")) {
                file11 = "";
            }
            MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
            MultipartFile file0 = multipartRequest1.getFile("file1");
            String file0FileName = "";
            if (file0 != null && !file0.isEmpty()) {
                file0FileName = file0.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                // Save the file
                File destinationFile = new File(fileLocationURL + file0FileName);
                file0.transferTo(destinationFile);
            }
            if (file0FileName.equals("") || file0FileName == "") {
                file0FileName = file11;
            }

            String boq = request.getParameter("boq");
            if (boq == null) {
                boq = "0";
            } else {
                boq = "1";
            }
            String boqRefNo = request.getParameter("boqRefNo");
            if (boqRefNo == null) {
                boqRefNo = "";
            }
            String Fromdate2 = request.getParameter("Fromdate2");
            if (Fromdate2 == null) {
                Fromdate2 = "";
            }
            String file12 = request.getParameter("file12");
            if (boq.equals("0")) {
                file12 = "";
            }
            MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
            MultipartFile file2 = multipartRequest2.getFile("file2");
            String file2FileName = "";
            if (file2 != null && !file2.isEmpty()) {
                file2FileName = file2.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                // Save the file
                File destinationFile = new File(fileLocationURL + file2FileName);
                file2.transferTo(destinationFile);

            }
            if (file2FileName.equals("") || file2FileName == "") {
                file2FileName = file12;
            }

            String lao = request.getParameter("lao");
            if (lao == null) {
                lao = "0";
            } else {
                lao = "1";
            }
            String laoRefNo = request.getParameter("laoRefNo");
            if (laoRefNo == null) {
                laoRefNo = "";
            }
            String Fromdate3 = request.getParameter("Fromdate3");
            if (Fromdate3 == null) {
                Fromdate3 = "";
            }
            String file13 = request.getParameter("file13");
            if (lao.equals("0")) {
                file13 = "";
            }
            MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
            MultipartFile file3 = multipartRequest3.getFile("file3");
            String file3FileName = "";
            if (file3 != null && !file3.isEmpty()) {
                file3FileName = file3.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                // Save the file
                File destinationFile = new File(fileLocationURL + file3FileName);
                file3.transferTo(destinationFile);
            }
            if (file3FileName.equals("") || file3FileName == "") {
                file3FileName = file13;
            }
            String agremment = request.getParameter("agremment");
            if (agremment == null) {
                agremment = "0";
            } else {
                agremment = "1";
            }
            String agremmentRefNo = request.getParameter("agremmentRefNo");
            if (agremmentRefNo == null) {
                agremmentRefNo = "";
            }
            String Fromdate4 = request.getParameter("Fromdate4");
            if (Fromdate4 == null) {
                Fromdate4 = "";
            }
            String file14 = request.getParameter("file14");
            if (agremment.equals("0")) {
                file14 = "";
            }
            MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
            MultipartFile file4 = multipartRequest4.getFile("file4");
            String file4FileName = "";
            if (file4 != null && !file4.isEmpty()) {
                file4FileName = file4.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                // Save the file
                File destinationFile = new File(fileLocationURL + file4FileName);
                file4.transferTo(destinationFile);
            }
            if (file4FileName.equals("") || file4FileName == "") {
                file4FileName = file14;
            }
            String drawings = request.getParameter("drawings");
            if (drawings == null) {
                drawings = "0";
            } else {
                drawings = "1";
            }
            String drawingsRefNo = request.getParameter("drawingsRefNo");
            if (drawingsRefNo == null) {
                drawingsRefNo = "";
            }
            String Fromdate5 = request.getParameter("Fromdate5");
            if (Fromdate5 == null) {
                Fromdate5 = "";
            }
            String file15 = request.getParameter("file15");
            if (drawings.equals("0")) {
                file15 = "";
            }
            MultipartHttpServletRequest multipartRequest5 = (MultipartHttpServletRequest) request;
            MultipartFile file5 = multipartRequest5.getFile("file5");
            String file5FileName = "";
            if (file5 != null && !file5.isEmpty()) {
                file5FileName = file5.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                // Save the file
                File destinationFile = new File(fileLocationURL + file5FileName);
                file5.transferTo(destinationFile);
            }
            if (file5FileName.equals("") || file5FileName == "") {
                file5FileName = file15;
            }
            String operations = request.getParameter("operations");
            String operationsSign = request.getParameter("operationsSign");
            String maintenance = request.getParameter("maintenance");
            String maintenancesign = request.getParameter("maintenancesign");
            String Fromdate6 = request.getParameter("Fromdate6");
            String Fromdate7 = request.getParameter("Fromdate7");
            String inr = request.getParameter("inr");
            String comments = request.getParameter("comments");
            String Fromdate8 = request.getParameter("Fromdate8");
            String revisionNo = request.getParameter("revisionNo");
            String Fromdate9 = request.getParameter("Fromdate9");
            String reviewed = request.getParameter("reviewed");
            String designation = request.getParameter("designation");
            String signatureDate = request.getParameter("signatureDate");
            String approvalName = request.getParameter("approvalName");
            String country = request.getParameter("country");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String houseno = request.getParameter("houseno");

            String ProjectProfile = request.getParameter("ProjectProfile");
            String conn = request.getParameter("conn");
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
//        String additionOfNewChargerCapacity = request.getParameter("additionOfNewChargerCapacity");
            String anchoreCustomer = request.getParameter("anchoreCustomer");
            String canopyVarient = request.getParameter("canopyVarient");
            if (canopyVarient == null) {
                canopyVarient = "";
            }
            String scopeofChargeZone = request.getParameter("scopeofChargeZone");
            String totalMW = request.getParameter("totalMW");

            AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

            aocForm.setDocumentNo(documentNo);
            aocForm.setHubDepoName(depoName);
            aocForm.setBb2(b2b);
            aocForm.setBbc22(b2b2c);
            aocForm.setBc2(b2c);
            aocForm.setClientProjectName(projectName);
            aocForm.setHubDepoAddress(depoAddress);
            aocForm.setGoogleCoordinates(googleCoordinates);
            aocForm.setPcTypeCar(car);
            aocForm.setPcTypeBus(bus);
            aocForm.setPcTypeTruckLmv(truck);
            aocForm.setOther(others);
            aocForm.setPcsType("");
            aocForm.setFinacialModelCapex(capex);
            aocForm.setFinacialModelOpex(opex);
            aocForm.setCoOrdinates(coordinates);
            aocForm.setFirstName(firstName);
            aocForm.setMiddleName("");
            aocForm.setLastName("");
            aocForm.setMobileNo(mobileNo);
            aocForm.setAlternateMobileNo(altNo);
            aocForm.setEmail(email);
            aocForm.setSpecificReqClients(reqClients);
            aocForm.setChargeScope(scopework);
            aocForm.setClientScope(scope);
            aocForm.setAssumptionSheet(assumption);
            aocForm.setAssumptionRefNo(assumptionRefNo);
            aocForm.setAssumptionDate(Fromdate1);
            aocForm.setEstimatedBoq(boq);
            aocForm.setEstimatedRefNo(boqRefNo);
            aocForm.setEstimatedDate(Fromdate2);
            aocForm.setLoaLoi(lao);
            aocForm.setLoaLoiRefNo(laoRefNo);
            aocForm.setLoaLoiDate(Fromdate3);
            aocForm.setAgreement(agremment);
            aocForm.setAgreementRefNo(agremmentRefNo);
            aocForm.setAgreementDate(Fromdate4);
            aocForm.setLayoutDrawings(drawings);
            aocForm.setLayoutRefNo(drawingsRefNo);
            aocForm.setLayoutDate(Fromdate5);
            aocForm.setOperations(operations);
            aocForm.setOperationsSign(operationsSign);
            aocForm.setMaintenance(maintenance);
            aocForm.setMaintenanceSign(maintenancesign);
            aocForm.setZeroDate(Fromdate6);
            aocForm.setCompletionDate(Fromdate7);
            aocForm.setProjectBudgetAllocated(inr);
            aocForm.setAuthorityComments(comments);
            aocForm.setOrderEffcectiveDate(Fromdate8);
            aocForm.setNewRevisionNo(revisionNo);
            aocForm.setBudjectAllocationDate(Fromdate9);
            aocForm.setReviewedBy(reviewed);
            aocForm.setDesignation(designation);
            aocForm.setSignatureDate("");
//	aocForm.setOapMaster(oapMaster);
            aocForm.setCreatedDate(today);
            aocForm.setUserId(username1);
            aocForm.setFlagStatus(1);
//	aocForm.setCountry(country);
//	aocForm.setState(state);
            aocForm.setCity(city);
            aocForm.setDistrict(district);
            aocForm.setHouseNo(houseno);
            aocForm.setAssumptionAttach(file0FileName);
            aocForm.setEstimatedAttach(file2FileName);
            aocForm.setLoaAttach(file3FileName);
            aocForm.setAgreementAttach(file4FileName);
            aocForm.setLayoutAttach(file5FileName);
            aocForm.setProjectProfile(ProjectProfile);
            aocForm.setProjectCenter(profitcenter);
            aocForm.setCompanyCode(CompanyCode);
            aocForm.setPlant(Plant);
            aocForm.setProjectType(ProjectType);
            aocForm.setProjectCurrency(ProjectCurrency);
            aocForm.setInverstmentProfile(InvestmentProfile);
//	aocForm.setDiscom(Discom);
            aocForm.setNoOfChargePoints(ChargePoints);
            aocForm.setNoOfCharger(NoOfCharger);
            aocForm.setOverallStationCapacityKw(overallstations);
            aocForm.setStationAcCapacityKw(stationAc);
            aocForm.setStationDcCapacityKw(stationDc);
            aocForm.setStationName(stationname);
            aocForm.setStationType(stationtype);
            aocForm.setTenant(tenant);
            aocForm.setChargingRatePerUnit(chargingrate);
            aocForm.setSiteSurvey(sitesurvey);
            aocForm.setSurveyRadio(Integer.parseInt(Survey));
            aocForm.setProjectTimelineCategory(projectTimelineCategory);
            aocForm.setTotalKwRating(totalKwRating);
            aocForm.setSpecificDateFromClient(specificDateFromClient);
            aocForm.setTotalChargerCapacity(totalChargerCapacity);
            aocForm.setChargerStationAccessType(chargerStationAccessType);
            aocForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
            aocForm.setChargingRetePerUnit(chargingRetePerUnit);
            aocForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
            aocForm.setAnchoreCustomer(anchoreCustomer);
            aocForm.setCanopyVarient(canopyVarient);
            aocForm.setScopeOfchargeZone(scopeofChargeZone);
            aocForm.setTotalMegaWatt(totalMW);
            aocFormService.update(aocForm);
            int id1 = aocForm.getId();

            AocForm aocForm1 = aocFormService.readById(id1);

            String[] surveyNo = request.getParameterValues("surveyNo");
            String[] projectRepresentative = request.getParameterValues("projectRepresentative");
            int z = 0;
            int id8 = 0;
            for (String s : surveyNo) {
                if (s != null && !s.isEmpty()) {
                    AocSurveyAttachment aocSurveyAttachment = new AocSurveyAttachment();
                    aocSurveyAttachment.setSurveyNo(surveyNo[z]);
                    aocSurveyAttachment.setProjectRepresentative(projectRepresentative[z]);
                    aocSurveyAttachment.setAocId(id1);
                    aocSurveyAttachmentService.create(aocSurveyAttachment);

                    z++;
                    id8 = aocSurveyAttachment.getId();
                }
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc"
                    + File.separator + id1;
            File f1 = new File(path);
            boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created
            //multi attachment
            List<MultipartFile> files1 = multipartRequest.getFiles("attach");
            String[] description = request.getParameterValues("descriptions");
            int a = 0;
            int id4 = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "Aoc"
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

                        AocFormMultiAttachment aocFormMultiAttachment = new AocFormMultiAttachment();

                        aocFormMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        aocFormMultiAttachment.setDescription(description[a]);
                        aocFormMultiAttachment.setAocForm(aocForm1);

                        aocFormMultiAttachmentService.create(aocFormMultiAttachment);
                        id4 = aocFormMultiAttachment.getId();
                        a++;
                    }
                }

            }

            AocFormApproval aocFormApproval5 = aocFormApprovalService.readByDeltecodes(id);

            int formid = aocFormApproval5.getId();

            List list44 = aocFormApprovalUserService.readByDleteCode(formid);
            for (Object o : list44) {
                AocFormApprovalUser oacAocFormApprovalUser = (AocFormApprovalUser) o;
                int id3 = oacAocFormApprovalUser.getId();
                aocFormApprovalUserService.delete(id3);
            }

            aocFormApprovalService.delete(formid);

// approval name drop down relted code
            List approval_list = oapMasterUserService.readByIdToList(approvalName);
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();
            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            AocFormApproval aocFormApproval = new AocFormApproval();

            aocFormApproval.setAocForm(aocForm1);
            aocFormApproval.setTotalApproval(approval_list.size() + "");
            aocFormApproval.setApprovalStatus("0");
            aocFormApproval.setApprovalRemark("add");
            aocFormApproval.setUserId(employeeCode);
            aocFormApproval.setCurrentApproval("1");
            aocFormApprovalService.create(aocFormApproval);

            int approveId = aocFormApproval.getId();
            OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

            int j = 0;
            for (Object o : approval_list) {
                j++;
                OapMasterUser oap1 = (OapMasterUser) o;
                AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();
                aocFormApprovalUser.setAocFormApproval(approveId);
                aocFormApprovalUser.setAocForm(id1);
                aocFormApprovalUser.setUserId(oap1.getUserId());
                aocFormApprovalUser.setLevel("1");
                aocFormApprovalUser.setApprovalStatus("0");
                aocFormApprovalUserService.create(aocFormApprovalUser);

                String documentno = aocForm.getDocumentNo();
                String mainusername = aocForm.getUserId();
                String userid = aocFormApprovalUser.getUserId();
                String mailcreteddate = aocForm.getCreatedDate();
                EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
                String mail_to = employeeMaster2.getEmailId();

                EmailTemplate emailTemplate = emailTemplateService.readById(53);
                String mail_from = "";

                String subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
                String Aoc_form = "AOC Form";

                msg = msg.replaceAll("\\{Aoc_form\\}", Aoc_form);
                msg = msg.replaceAll("\\{documentno\\}", documentno);
                msg = msg.replaceAll("\\{username\\}", mainusername);
                msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);
//	    msg = msg.replaceAll("\\{vendor_code\\}", checkedValues);
//	    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
//	    msg = msg.replaceAll("\\{department\\}", department);

                SendMail s = new SendMail();
                s.sendMail(mail_from, mail_to, subject, msg);

            }
            //reverse edit
            AocFormHistory aocFormHistory = new AocFormHistory();
            String currentDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

            aocFormHistory.setDocumentNo(documentNo);
            aocFormHistory.setHubDepoName(depoName);
            aocFormHistory.setBb2(b2b);
            aocFormHistory.setBbc22(b2b2c);
            aocFormHistory.setBc2(b2c);
            aocFormHistory.setClientProjectName(projectName);
            aocFormHistory.setHubDepoAddress(depoAddress);
            aocFormHistory.setGoogleCoordinates(googleCoordinates);
            aocFormHistory.setPcTypeCar(car);
            aocFormHistory.setPcTypeBus(bus);
            aocFormHistory.setPcTypeTruckLmv(truck);
            aocFormHistory.setOther(others);
            aocFormHistory.setPcsType("");
            aocFormHistory.setFinacialModelCapex(capex);
            aocFormHistory.setFinacialModelOpex(opex);
            aocFormHistory.setCoOrdinates(coordinates);
            aocFormHistory.setFirstName(firstName);
            aocFormHistory.setMiddleName("");
            aocFormHistory.setLastName("");
            aocFormHistory.setMobileNo(mobileNo);
            aocFormHistory.setAlternateMobileNo(altNo);
            aocFormHistory.setEmail(email);
            aocFormHistory.setSpecificReqClients(reqClients);
            aocFormHistory.setChargeScope(scopework);
            aocFormHistory.setClientScope(scope);
            aocFormHistory.setAssumptionSheet(assumption);
            aocFormHistory.setAssumptionRefNo(assumptionRefNo);
            aocFormHistory.setAssumptionDate(Fromdate1);
            aocFormHistory.setEstimatedBoq(boq);
            aocFormHistory.setEstimatedRefNo(boqRefNo);
            aocFormHistory.setEstimatedDate(Fromdate2);
            aocFormHistory.setLoaLoi(lao);
            aocFormHistory.setLoaLoiRefNo(laoRefNo);
            aocFormHistory.setLoaLoiDate(Fromdate3);
            aocFormHistory.setAgreement(agremment);
            aocFormHistory.setAgreementRefNo(agremmentRefNo);
            aocFormHistory.setAgreementDate(Fromdate4);
            aocFormHistory.setLayoutDrawings(drawings);
            aocFormHistory.setLayoutRefNo(drawingsRefNo);
            aocFormHistory.setLayoutDate(Fromdate5);
            aocFormHistory.setOperations(operations);
            aocFormHistory.setOperationsSign(operationsSign);
            aocFormHistory.setMaintenance(maintenance);
            aocFormHistory.setMaintenanceSign(maintenancesign);
            aocFormHistory.setZeroDate(Fromdate6);
            aocFormHistory.setCompletionDate(Fromdate7);
            aocFormHistory.setProjectBudgetAllocated(inr);
            aocFormHistory.setAuthorityComments(comments);
            aocFormHistory.setOrderEffcectiveDate(Fromdate8);
            aocFormHistory.setNewRevisionNo(revisionNo);
            aocFormHistory.setBudjectAllocationDate(Fromdate9);
            aocFormHistory.setReviewedBy(reviewed);
            aocFormHistory.setDesignation(designation);
            aocFormHistory.setSignatureDate("");
//	aocFormHistory.setOapMaster(oapMaster);
            aocFormHistory.setCreatedDate(today);
            aocFormHistory.setUserId(username1);
            aocFormHistory.setFlagStatus(1);
            aocFormHistory.setCountry(country);
            aocFormHistory.setState(state);
            aocFormHistory.setCity(city);
            aocFormHistory.setDistrict(district);
            aocFormHistory.setHouseNo(houseno);
            aocFormHistory.setAssumptionAttach(file0FileName);
            aocFormHistory.setEstimatedAttach(file2FileName);
            aocFormHistory.setLoaAttach(file3FileName);
            aocFormHistory.setAgreementAttach(file4FileName);
            aocFormHistory.setLayoutAttach(file5FileName);
            aocFormHistory.setProjectProfile(ProjectProfile);
            aocFormHistory.setProjectCenter(profitcenter);
            aocFormHistory.setCompanyCode(CompanyCode);
            aocFormHistory.setPlant(Plant);
            aocFormHistory.setProjectType(ProjectType);
            aocFormHistory.setProjectCurrency(ProjectCurrency);
            aocFormHistory.setInverstmentProfile(InvestmentProfile);
//	aocFormHistory.setDiscom(Discom);
            aocFormHistory.setNoOfChargePoints(ChargePoints);
            aocFormHistory.setNoOfCharger(NoOfCharger);
            aocFormHistory.setOverallStationCapacityKw(overallstations);
            aocFormHistory.setStationAcCapacityKw(stationAc);
            aocFormHistory.setStationDcCapacityKw(stationDc);
            aocFormHistory.setStationName(stationname);
            aocFormHistory.setStationType(stationtype);
            aocFormHistory.setTenant(tenant);
            aocFormHistory.setChargingRatePerUnit(chargingrate);
            aocFormHistory.setDateTime(currentDateTime);
            aocFormHistory.setAocId(id1);
            aocFormHistory.setSiteSurvey(sitesurvey);
            aocFormHistory.setAssignedName("");
            aocFormHistory.setProjectCoordinater("");
            aocFormHistory.setComment("");
            aocFormHistory.setDiscom(Discom);
            aocFormHistory.setConnectionType(conn);
            aocFormHistory.setSurveyRadio(Integer.parseInt(Survey));

            aocFormHistory.setProjectTimelineCategory(projectTimelineCategory);
            aocFormHistory.setTotalKwRating(totalKwRating);
            aocFormHistory.setSpecificDateFromClient(specificDateFromClient);
            aocFormHistory.setTotalChargerCapacity(totalChargerCapacity);
            aocFormHistory.setChargerStationAccessType(chargerStationAccessType);
            aocFormHistory.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
            aocFormHistory.setChargingRetePerUnit(chargingRetePerUnit);
            aocFormHistory.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
//        aocFormHistory.setAdditionOfNewChargerCapacity(additionOfNewChargerCapacity);
            aocFormHistory.setAnchoreCustomer(anchoreCustomer);
            aocFormHistory.setCanopyVarient(canopyVarient);
            aocFormHistory.setScopeOfchargeZone(scopeofChargeZone);
            aocFormHistory.setTotalMegaWatt(totalMW);

            List lastHistory1 = aocFormHistoryService.readBylasttimestatus(id1); // Implement this method in service
            int size = lastHistory1.size();

            String newHistory = "R" + size;
            aocFormHistory.setHistory(newHistory);

            aocFormHistoryService.create(aocFormHistory);
            String history = aocFormHistory.getHistory();
            int id3 = aocFormHistory.getId();
            int b = 0;
            if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
                for (MultipartFile file1 : files1) {
                    if (!file1.isEmpty()) {
                        AocFormMultiAttachmentHistory aocFormMultiAttachmentHistory = new AocFormMultiAttachmentHistory();

                        aocFormMultiAttachmentHistory.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        aocFormMultiAttachmentHistory.setDescription(description[b]);
                        aocFormMultiAttachmentHistory.setAocForm(id1);
                        aocFormMultiAttachmentHistory.setHistory(history);
                        aocFormMultiAttachmentHistory.setAocHistoryId(id3);
                        aocFormMultiAttachmentHistory.setAocMultiId(id4);
                        aocFormMultiAttachmentHistoryService.create(aocFormMultiAttachmentHistory);

                        a++;
                    }
                }
            }

            int x = 0;
            for (String s : surveyNo) {
                if (s != null && !s.isEmpty()) {
                    AocSurveyAttachmentHistory aocSurveyAttachmentHistory = new AocSurveyAttachmentHistory();
                    aocSurveyAttachmentHistory.setSurveyNo(surveyNo[x]);
                    aocSurveyAttachmentHistory.setAocId(id1);
                    aocSurveyAttachmentHistory.setDateTime(currentDateTime);
                    aocSurveyAttachmentHistory.setHistory(history);
                    aocSurveyAttachmentHistory.setAocFormHistoryId(id3);
                    aocSurveyAttachmentHistory.setAocSurveyAttachmentId(id8);
                    aocSurveyAttachmentHistoryService.create(aocSurveyAttachmentHistory);

                    z++;

                }
            }

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("AOC Recycle Edit");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments("");
            aocLogMaster.setStatus("Recycle Edited");
            aocLogMaster.setAocId(id1);
            aocLogMasterService.create(aocLogMaster);

            session.setAttribute("successMessage", "AOC Form Recycled Successfully Completed");
        } else if (FlagStatus == 1) {
            session1.setAttribute("failureMessage", "AOC Form Already Recycled Successfully");
        } else {
            session1.setAttribute("failureMessage", "The AOC approval has already progressed to the next stage");
        }

        mv.setViewName("redirect:aocForm.htm?act=aocFormAppovalList");

        return mv;
    }

    public ModelAndView aocSurveyDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String aocSurveyid = request.getParameter("id1");

        aocSurveyAttachmentService.delete(Integer.parseInt(aocSurveyid));
        mv.getModelMap().put("oapSurveyid", aocSurveyid);
        mv.getModelMap().put("id", id);
        mv.setViewName("forward:aocForm.htm?act=aocFormRecycleEdit&id=" + id);
        return mv;
    }

    public ModelAndView aocFormApprovedEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

//	String aocFormattach = request.getParameter("aocFormattach");
//	String aocFormmulti = request.getParameter("aocFormmulti");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        String discom = aocForm.getDiscom();
        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom));
        String Discom1 = discomMaster.getDiscomType();
        String connectionType = aocForm.getConnectionType();
        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

        int aocmasterId = aocForm.getOapMaster().getId();
        List list = AocFormAttachmentService.readByattach(id);
        List list33 = aocFormMultiAttachmentService.readByMulti(id);
        List list10 = oapMasterService.read();

        String Tenant = aocForm.getTenant();
        String StationType = aocForm.getStationType();
        String Currency = aocForm.getProjectCurrency();
        String ProjectType = aocForm.getProjectType();
        String Ivestmentprofile = aocForm.getInverstmentProfile();
        String ProjectCenter = aocForm.getProjectCenter();
        String CompanyCode = aocForm.getCompanyCode();
        String ProjectProfile = aocForm.getProjectProfile();
        String Discom = aocForm.getDiscom();
        String plant = aocForm.getPlant();
        mv.getModelMap().put("plant", plant);
        mv.getModelMap().put("Discom", Discom);
        mv.getModelMap().put("ProjectProfile", ProjectProfile);
        mv.getModelMap().put("CompanyCode", CompanyCode);
        mv.getModelMap().put("ProjectCenter", ProjectCenter);
        mv.getModelMap().put("Ivestmentprofile", Ivestmentprofile);
        mv.getModelMap().put("ProjectType", ProjectType);
        mv.getModelMap().put("Currency", Currency);
        mv.getModelMap().put("StationType", StationType);
        mv.getModelMap().put("Tenant", Tenant);
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
        mv.getModelMap().put("aocForm", aocForm);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("aocmasterId", aocmasterId);
        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/aocFormApprovedEdit");
        return mv;
    }

    public ModelAndView aocFormEditApprovedsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        String documentNo = request.getParameter("documentNo");
        String depoName = request.getParameter("depoName");
        String b2b = request.getParameter("b2b");
        String b2b2c = request.getParameter("b2b2c");
        String b2c = request.getParameter("b2c");
        String projectName = request.getParameter("projectName");
        String depoAddress = request.getParameter("depoAddress");
        String googleCoordinates = request.getParameter("googleCoordinates");
        String car = request.getParameter("car");
        if (car == null) {
            car = "0";
        } else {
            car = "1";
        }
        String bus = request.getParameter("bus");
        if (bus == null) {
            bus = "0";
        } else {
            bus = "1";
        }
        String truck = request.getParameter("truck");
        if (truck == null) {
            truck = "0";
        } else {
            truck = "1";
        }
        String others = request.getParameter("others");
        String pcs = request.getParameter("pcs");
        String capex = request.getParameter("capex");
        if (capex == null) {
            capex = "0";
        } else {
            capex = "1";
        }
        String opex = request.getParameter("opex");
        if (opex == null) {
            opex = "0";
        } else {
            opex = "1";
        }
        String coordinates = request.getParameter("coordinates");
        String firstName = request.getParameter("firstName");
//	String middleName = request.getParameter("middleName");
//	String lastName = request.getParameter("lastName");
        String mobileNo = request.getParameter("mobileNo");
        String altNo = request.getParameter("altNo");
        String email = request.getParameter("email");
        String reqClients = request.getParameter("reqClients");
        String scopework = request.getParameter("scopework");
        String scope = request.getParameter("scope");
        String assumption = request.getParameter("assumption");
        if (assumption == null) {
            assumption = "0";
        } else {
            assumption = "1";
        }
        String assumptionRefNo = request.getParameter("assumptionRefNo");
        if (assumptionRefNo == null) {
            assumptionRefNo = "";
        }
        String Fromdate1 = request.getParameter("Fromdate1");
        if (Fromdate1 == null) {
            Fromdate1 = "";
        }
        String file11 = request.getParameter("file11");
        if (assumption.equals("0")) {
            file11 = "";
        }
        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile file0 = multipartRequest1.getFile("file1");
        String file0FileName = "";
        if (file0 != null && !file0.isEmpty()) {
            file0FileName = file0.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file0FileName);
            file0.transferTo(destinationFile);
        }
        if (file0FileName.equals("") || file0FileName == "") {
            file0FileName = file11;
        }

        String boq = request.getParameter("boq");
        if (boq == null) {
            boq = "0";
        } else {
            boq = "1";
        }
        String boqRefNo = request.getParameter("boqRefNo");
        if (boqRefNo == null) {
            boqRefNo = "";
        }
        String Fromdate2 = request.getParameter("Fromdate2");
        if (Fromdate2 == null) {
            Fromdate2 = "";
        }
        String file12 = request.getParameter("file12");
        if (boq.equals("0")) {
            file12 = "";
        }
        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile file2 = multipartRequest2.getFile("file2");
        String file2FileName = "";
        if (file2 != null && !file2.isEmpty()) {
            file2FileName = file2.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file2FileName);
            file2.transferTo(destinationFile);

        }
        if (file2FileName.equals("") || file2FileName == "") {
            file2FileName = file12;
        }

        String lao = request.getParameter("lao");
        if (lao == null) {
            lao = "0";
        } else {
            lao = "1";
        }
        String laoRefNo = request.getParameter("laoRefNo");
        if (laoRefNo == null) {
            laoRefNo = "";
        }
        String Fromdate3 = request.getParameter("Fromdate3");
        if (Fromdate3 == null) {
            Fromdate3 = "";
        }
        String file13 = request.getParameter("file13");
        if (lao.equals("0")) {
            file13 = "";
        }
        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile file3 = multipartRequest3.getFile("file3");
        String file3FileName = "";
        if (file3 != null && !file3.isEmpty()) {
            file3FileName = file3.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file3FileName);
            file3.transferTo(destinationFile);
        }
        if (file3FileName.equals("") || file3FileName == "") {
            file3FileName = file13;
        }
        String agremment = request.getParameter("agremment");
        if (agremment == null) {
            agremment = "0";
        } else {
            agremment = "1";
        }
        String agremmentRefNo = request.getParameter("agremmentRefNo");
        if (agremmentRefNo == null) {
            agremmentRefNo = "";
        }
        String Fromdate4 = request.getParameter("Fromdate4");
        if (Fromdate4 == null) {
            Fromdate4 = "";
        }
        String file14 = request.getParameter("file14");
        if (agremment.equals("0")) {
            file14 = "";
        }
        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile file4 = multipartRequest4.getFile("file4");
        String file4FileName = "";
        if (file4 != null && !file4.isEmpty()) {
            file4FileName = file4.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file4FileName);
            file4.transferTo(destinationFile);
        }
        if (file4FileName.equals("") || file4FileName == "") {
            file4FileName = file14;
        }
        String drawings = request.getParameter("drawings");
        if (drawings == null) {
            drawings = "0";
        } else {
            drawings = "1";
        }
        String drawingsRefNo = request.getParameter("drawingsRefNo");
        if (drawingsRefNo == null) {
            drawingsRefNo = "";
        }
        String Fromdate5 = request.getParameter("Fromdate5");
        if (Fromdate5 == null) {
            Fromdate5 = "";
        }
        String file15 = request.getParameter("file15");
        if (drawings.equals("0")) {
            file15 = "";
        }
        MultipartHttpServletRequest multipartRequest5 = (MultipartHttpServletRequest) request;
        MultipartFile file5 = multipartRequest5.getFile("file5");
        String file5FileName = "";
        if (file5 != null && !file5.isEmpty()) {
            file5FileName = file5.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file5FileName);
            file5.transferTo(destinationFile);
        }
        if (file5FileName.equals("") || file5FileName == "") {
            file5FileName = file15;
        }
        String operations = request.getParameter("operations");
        String operationsSign = request.getParameter("operationsSign");
        String maintenance = request.getParameter("maintenance");
        String maintenancesign = request.getParameter("maintenancesign");
        String Fromdate6 = request.getParameter("Fromdate6");
        String Fromdate7 = request.getParameter("Fromdate7");
        String inr = request.getParameter("inr");
        String comments = request.getParameter("comments");
        String Fromdate8 = request.getParameter("Fromdate8");
        String revisionNo = request.getParameter("revisionNo");
        String Fromdate9 = request.getParameter("Fromdate9");
        String reviewed = request.getParameter("reviewed");
        String designation = request.getParameter("designation");
        String signatureDate = request.getParameter("signatureDate");
//	String country = request.getParameter("country");
//	String state = request.getParameter("state");
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
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        aocForm.setDocumentNo(documentNo);
        aocForm.setHubDepoName(depoName);
        aocForm.setBb2(b2b);
        aocForm.setBbc22(b2b2c);
        aocForm.setBc2(b2c);
        aocForm.setClientProjectName(projectName);
        aocForm.setHubDepoAddress(depoAddress);
        aocForm.setGoogleCoordinates(googleCoordinates);
        aocForm.setPcTypeCar(car);
        aocForm.setPcTypeBus(bus);
        aocForm.setPcTypeTruckLmv(truck);
        aocForm.setOther(others);
        aocForm.setPcsType("");
        aocForm.setFinacialModelCapex(capex);
        aocForm.setFinacialModelOpex(opex);
        aocForm.setCoOrdinates(coordinates);
        aocForm.setFirstName(firstName);
        aocForm.setMiddleName("");
        aocForm.setLastName("");
        aocForm.setMobileNo(mobileNo);
        aocForm.setAlternateMobileNo(altNo);
        aocForm.setEmail(email);
        aocForm.setSpecificReqClients(reqClients);
        aocForm.setChargeScope(scopework);
        aocForm.setClientScope(scope);
        aocForm.setAssumptionSheet(assumption);
        aocForm.setAssumptionRefNo(assumptionRefNo);
        aocForm.setAssumptionDate(Fromdate1);
        aocForm.setEstimatedBoq(boq);
        aocForm.setEstimatedRefNo(boqRefNo);
        aocForm.setEstimatedDate(Fromdate2);
        aocForm.setLoaLoi(lao);
        aocForm.setLoaLoiRefNo(laoRefNo);
        aocForm.setLoaLoiDate(Fromdate3);
        aocForm.setAgreement(agremment);
        aocForm.setAgreementRefNo(agremmentRefNo);
        aocForm.setAgreementDate(Fromdate4);
        aocForm.setLayoutDrawings(drawings);
        aocForm.setLayoutRefNo(drawingsRefNo);
        aocForm.setLayoutDate(Fromdate5);
        aocForm.setOperations(operations);
        aocForm.setOperationsSign(operationsSign);
        aocForm.setMaintenance(maintenance);
        aocForm.setMaintenanceSign(maintenancesign);
        aocForm.setZeroDate(Fromdate6);
        aocForm.setCompletionDate(Fromdate7);
        aocForm.setProjectBudgetAllocated(inr);
        aocForm.setAuthorityComments(comments);
        aocForm.setOrderEffcectiveDate(Fromdate8);
        aocForm.setNewRevisionNo(revisionNo);
        aocForm.setBudjectAllocationDate(Fromdate9);
        aocForm.setReviewedBy(reviewed);
        aocForm.setDesignation(designation);
        aocForm.setSignatureDate("");
        aocForm.setCreatedDate(today);
        aocForm.setUserId(username1);
//	aocForm.setCountry(country);
//	aocForm.setState(state);
        aocForm.setCity(city);
        aocForm.setDistrict(district);
        aocForm.setHouseNo(houseno);
        aocForm.setAssumptionAttach(file0FileName);
        aocForm.setEstimatedAttach(file2FileName);
        aocForm.setLoaAttach(file3FileName);
        aocForm.setAgreementAttach(file4FileName);
        aocForm.setLayoutAttach(file5FileName);
        aocForm.setProjectProfile(ProjectProfile);
        aocForm.setProjectCenter(profitcenter);
        aocForm.setCompanyCode(CompanyCode);
        aocForm.setPlant(Plant);
        aocForm.setProjectType(ProjectType);
        aocForm.setProjectCurrency(ProjectCurrency);
        aocForm.setInverstmentProfile(InvestmentProfile);
//	aocForm.setDiscom(Discom);
        aocForm.setNoOfChargePoints(ChargePoints);
        aocForm.setNoOfCharger(NoOfCharger);
        aocForm.setOverallStationCapacityKw(overallstations);
        aocForm.setStationAcCapacityKw(stationAc);
        aocForm.setStationDcCapacityKw(stationDc);
        aocForm.setStationName(stationname);
        aocForm.setStationType(stationtype);
        aocForm.setTenant(tenant);
        aocForm.setChargingRatePerUnit(chargingrate);
        aocFormService.update(aocForm);
        int id1 = aocForm.getId();

        AocForm aocForm1 = aocFormService.readById(id1);

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Aoc"
                + File.separator + id1;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created
        //multi attachment
        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Aoc"
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

                    AocFormMultiAttachment aocFormMultiAttachment = new AocFormMultiAttachment();

                    aocFormMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    aocFormMultiAttachment.setDescription(description[a]);
                    aocFormMultiAttachment.setAocForm(aocForm1);

                    aocFormMultiAttachmentService.create(aocFormMultiAttachment);

                    a++;
                }
            }

        }

        String userid = aocForm.getUserId();

        String documentno = aocForm.getDocumentNo();
        String mailcreteddate = aocForm.getCreatedDate();
        EmployeeMaster employeeMaster2 = employeeMasterService.readUser(userid);
        String mail_to = employeeMaster2.getEmailId();

        EmailTemplate emailTemplate = emailTemplateService.readById(56);
        String mail_from = "";

        String subject = emailTemplate.getSubject();
        String msg = emailTemplate.getBodytext();
//	    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
        String Aoc_form = "AOC Form";

        msg = msg.replaceAll("\\{Aoc_form\\}", Aoc_form);
        msg = msg.replaceAll("\\{documentno\\}", documentno);
        msg = msg.replaceAll("\\{username\\}", userid);
        msg = msg.replaceAll("\\{createddate\\}", mailcreteddate);
//	    msg = msg.replaceAll("\\{vendor_code\\}", checkedValues);
//	    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
//	    msg = msg.replaceAll("\\{department\\}", department);

        SendMail s = new SendMail();
        s.sendMail(mail_from, mail_to, subject, msg);

        mv = aocFormAppovalList(request, response);
        return mv;
    }

    public ModelAndView aocPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

//	String aocFormattach = request.getParameter("aocFormattach");
//	String aocFormmulti = request.getParameter("aocFormmulti");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(id);
        int id1 = aocForm.getId();

        List list = AocFormAttachmentService.readByattach(id);
        List list33 = aocFormMultiAttachmentService.readByMulti(id);

        AocFormApproval aocFormApproval = aocFormApprovalService.readByDeltecodes(id);
        int approveid = aocFormApproval.getId();

        List list0 = aocFormApprovalCommentService.readByIds(id);
        String discomType = "";
        String connectionTypeName = "";

        String discom = aocForm.getDiscom();
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

        String connectionType = aocForm.getConnectionType();
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
        mv.getModelMap().put("list55", aocForm);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);
        mv.setViewName("Oap/aocPrint");
        return mv;
    }

    public ModelAndView kickoffPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        KickOffForm kickOffForm = kickOffFormService.readById(Integer.parseInt(id));

        List list44 = kickOffAttendencesService.readByids(id);

        KickOffFormApproval kickOffFormApproval = kickOffFormApprovalService.readBykickapprid(id);

        int approvalid = kickOffFormApproval.getId();

        List list0 = kickOffFormApprovalCommentService.readByapproveId(approvalid);

        mv.getModelMap().put("list55", kickOffForm);
        mv.getModelMap().put("list44", list44);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("id", id);
        mv.setViewName("Oap/kickoffPrint");
        return mv;
    }

    public ModelAndView AllFormsView2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        List aoclogmaster = aocLogMasterService.readByAocId(id);
        mv.getModelMap().put("aoclogmaster", aoclogmaster);
        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(id);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);

        String discomType = "";
        String connectionTypeName = "";

        String discom = aocForm.getDiscom();
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

        String connectionType = aocForm.getConnectionType();
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

        int id1 = aocForm.getId();
        String aocFormattach = request.getParameter("aocFormattach");
        String aocFormmulti = request.getParameter("aocFormmulti");

        List list66 = AocFormAttachmentService.readByattach(id);
        List list33 = aocFormMultiAttachmentService.readByMulti(id);

        AocFormApproval aocFormApproval = aocFormApprovalService.readByDeltecodes(id);

        int approvalid = aocFormApproval.getId();
        List list0 = aocFormApprovalCommentService.readByIds(id);

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("list55", aocForm);
        mv.getModelMap().put("list", list66);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("list0", list0);
        mv.setViewName("Oap/AllFormsView2");
        return mv;

    }

    public ModelAndView AllFormsView3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        KickOffForm kickOffForm = kickOffFormService.readByaocId(id);
        int id1 = kickOffForm.getId();
        KickOffFormApproval kickOffFormApproval = kickOffFormApprovalService.readBykickid(id1);
        int approvalid = kickOffFormApproval.getId();
//	List list44 = kickOffAttendencesService.readByids(id);
        List list44 = kickOffAttendencesService.readBykickOffFormid(id1);
        List list0 = kickOffFormApprovalCommentService.readByapproveId(approvalid);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("list55", kickOffForm);
        mv.getModelMap().put("list44", list44);

        mv.setViewName("Oap/AllFormsView3");
        return mv;

    }

    public ModelAndView aocCheckBoxAttach(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String fileName = request.getParameter("fileNames");

        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Aoc"
                + File.separator + fileName;
        request.setAttribute("filePath", fileLocationURL);
        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);;
        return mv;
    }

    public ModelAndView aocDocxdownloadzip(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id1 = request.getParameter("id1");

        List prd = AocFormAttachmentService.readByattachzip(id1);
        int size = prd.size();
        List prd1 = aocFormMultiAttachmentService.readByattachzip(id1);
        String[] fileNames = new String[prd.size() + prd1.size()]; // Ensure enough space
        int a = 0;
        List allAttachments = new ArrayList();
        allAttachments.addAll(prd);
        allAttachments.addAll(prd1);

        for (Object o : allAttachments) {
            if (o instanceof Object[]) {
                Object[] objArray = (Object[]) o;  // Cast to Object[]
                if (objArray[0] instanceof AocFormAttachment) {
                    AocFormAttachment pRDoc = (AocFormAttachment) objArray[0];
                    fileNames[a] = pRDoc.getAttachment();
                }
            } else if (o instanceof AocFormMultiAttachment) {
                AocFormMultiAttachment pRDoc = (AocFormMultiAttachment) o; // Direct cast without array
                fileNames[a] = pRDoc.getAttachment();
            }
            a++;
        }

        // Initialize zip output stream
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment;filename=AOCFILE.zip");

        try (ZipOutputStream zos = new ZipOutputStream(response.getOutputStream())) {
            for (String fileEntry : fileNames) {

                // Locate the file on disk
                String fileLocation = getServletContext().getRealPath("/") + File.separator + "StorageYard"
                        + File.separator + "Aoc" + File.separator + id1 + File.separator + fileEntry;

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

    public ModelAndView aocexcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

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
        String EnterpriseProjectID = aocForm.getDocumentNo();
        String Description = aocForm.getChargeScope();
        String ProjectProfile = aocForm.getProjectProfile();
        String ProjectStartDate = aocForm.getZeroDate();
        String ProjectFinishDate = aocForm.getCompletionDate();
        String ActualStartDate = "";
        String ActualFinishDate = "";
        String ProjectManagerID = "";
        String CostCenter = "";
        String ProfitCenter = aocForm.getProjectCenter();
        String FunctionalArea = "";
        String CompanyCode = aocForm.getCompanyCode();
        String Plant = aocForm.getPlant();
        String Location = "";
        String Priority = "";
        String ProcessingStatus = "";
        String ProjectType = aocForm.getProjectType();
        String BudgetAvailabilityControlProfile = "";
        String AvailabilityControlIndicator1 = "";
        String AvailabilityControlIndicator2 = "";
        String JointVentureName = "";
        String RecoveryIndicator = "";
        String EquityType = "";
        String ObjectType = "";
        String JIBJIBEClass = "";
        String JIBJIBESubclassA = "";
        String ProjectCurrency = aocForm.getProjectCurrency();
        String Fund = "";
        String Grant1 = "";
        String Grant2 = "";
        String GrantWithFixAssignment = "";
        String FuncAreaHasFixAssignment = "";
        String SponsoredProgram = "";
        String TaxJurisdictionCode = "";
        String FunctionalLocation = "";
        String InvestmentProfile = aocForm.getInverstmentProfile();
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
        String Discom = aocForm.getDiscom();
        String Highway = "";
        String NoOfChargePoints = aocForm.getNoOfChargePoints();
        String NoOfCharger = aocForm.getNoOfCharger();
        String OverallStationCapacityKW = aocForm.getOverallStationCapacityKw();
        String City = aocForm.getCity();
        String Country = aocForm.getCountry();
        String State = aocForm.getState();
        String StationACCapacityKW = aocForm.getStationAcCapacityKw();
        String StationDCCapacityKW = aocForm.getStationDcCapacityKw();
        String StationName = aocForm.getStationName();
        String StationType = aocForm.getStationName();
        String Tenant = aocForm.getTenant();
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
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + "aocexcel.xlsx";

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

    public ModelAndView aocHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        List list = aocFormHistoryService.readByaocid(id);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("id", id);

        mv.setViewName("Oap/aocHistory");
        return mv;
    }

    public ModelAndView aocHistoryview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        AocFormHistory aocFormHistory = aocFormHistoryService.readById(Integer.parseInt(id));
        int oaphistoryid = aocFormHistory.getId();
        List aocsurveyattachthistory = aocSurveyAttachmentHistoryService.readByaocHistroyid(oaphistoryid);

        int id1 = aocFormHistory.getAocId();
        AocForm aocForm = aocFormService.readById(id1);
        String state = aocForm.getState();
        String country = aocForm.getCountry();

        List list33 = aocFormMultiAttachmentHistoryService.readByMulti(oaphistoryid);

        String connectiontype1 = aocForm.getConnectionType();
        String discom1 = aocForm.getDiscom();

        DiscomMaster discomMaster = discomMasterService.readById(Integer.parseInt(discom1));
        String discom = discomMaster.getDiscomType();

        ConnectionType connectionType1 = connectionTypeService.readById(Integer.parseInt(connectiontype1));
        String connectiontype = connectionType1.getConnectionType();

        mv.getModelMap().put("discom", discom);
        mv.getModelMap().put("connectiontype", connectiontype);
        mv.getModelMap().put("state", state);
        mv.getModelMap().put("country", country);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("id1", id1);
        mv.getModelMap().put("list55", aocFormHistory);
        mv.getModelMap().put("aocsurveyattachthistory", aocsurveyattachthistory);
        mv.setViewName("Oap/aocHistoryview");
        return mv;
    }

    public ModelAndView aochistoryAttachment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");

        List list0 = aocFormMultiAttachmentHistoryService.readByMulti1(id);
        int size1 = list0.size();
        String[] fileNames = new String[list0.size()]; // Ensure correct array size
        int a = 0;
        List allAttachments = new ArrayList();
        allAttachments.addAll(list0);
        for (Object o : allAttachments) {
            if (o instanceof AocFormMultiAttachmentHistory) {
                AocFormMultiAttachmentHistory pRDoc = (AocFormMultiAttachmentHistory) o; // Direct cast without array
                fileNames[a] = pRDoc.getAttachment();
                a++;
            }
        }
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment;filename=AOCHistoryFILE.zip");

        try (ZipOutputStream zos = new ZipOutputStream(response.getOutputStream())) {
            for (String fileEntry : fileNames) {

                // Locate the file on disk
                String fileLocation = getServletContext().getRealPath("/") + File.separator + "StorageYard"
                        + File.separator + "Aoc" + File.separator + id1 + File.separator + fileEntry;

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
        mv = aocHistoryview(request, response);

        return mv;
    }

    public ModelAndView AllFormsView5(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        KickOffForm kickOffForm = kickOffFormService.readById(Integer.parseInt(id));

        List list44 = kickOffAttendencesService.readByids(id);

        KickOffFormApproval kickOffFormApproval = kickOffFormApprovalService.readBykickapprid(id);

        int approvalid = kickOffFormApproval.getId();

        List list0 = kickOffFormApprovalCommentService.readByapproveId(approvalid);

        List aoclogmaster = aocLogMasterService.readByKomid(id);
        mv.getModelMap().put("aoclogmaster", aoclogmaster);

        mv.getModelMap().put("list55", kickOffForm);
        mv.getModelMap().put("list44", list44);
        mv.getModelMap().put("list0", list0);
        mv.getModelMap().put("id", id);

        mv.setViewName("Oap/AllFormsView5");
        return mv;

    }

    public ModelAndView aocFormDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username1 = user1.getLoginName();

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        aocForm.setFlagStatus(100);
        aocFormService.update(aocForm);

        session.setAttribute("successMessage", "Information: AocFormDeleted successfully");
        mv.setViewName("redirect:aocForm.htm?act=aocFormAppovalList");
        return mv;

    }

    public ModelAndView AocSaveAsDraft(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username1 = user1.getLoginName();

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        String documentNo = request.getParameter("documentNo");
        String depoName = request.getParameter("depoName");
        String b2b = request.getParameter("b2b");
        String b2b2c = request.getParameter("b2b2c");
        String projectName = request.getParameter("projectName");
        String b2c = request.getParameter("b2c");
        String depoAddress = request.getParameter("depoAddress");
        String googleCoordinates = request.getParameter("googleCoordinates");
        String car = request.getParameter("car");
        if (car == null) {
            car = "0";
        } else {
            car = "1";
        }
        String bus = request.getParameter("bus");
        if (bus == null) {
            bus = "0";
        } else {
            bus = "1";
        }
        String truck = request.getParameter("truck");
        if (truck == null) {
            truck = "0";
        } else {
            truck = "1";
        }
        String others = request.getParameter("others");
        String pcs = request.getParameter("pcs");

        String capex = request.getParameter("capex");
        if (capex == null) {
            capex = "0";
        } else {
            capex = "1";
        }
        String opex = request.getParameter("opex");
        if (opex == null) {
            opex = "0";
        } else {
            opex = "1";
        }
        String coordinates = request.getParameter("coordinates");
        String firstName = request.getParameter("firstName");
//	String middleName = request.getParameter("middleName");
//	String lastName = request.getParameter("lastName");
        String mobileNo = request.getParameter("mobileNo");
        String altNo = request.getParameter("altNo");
        String email = request.getParameter("email");
        String reqClients = request.getParameter("reqClients");
        String scopework = request.getParameter("scopework");
        String scope = request.getParameter("scope");
        String operations = request.getParameter("operations");
        String operationsSign = request.getParameter("operationsSign");
        String maintenance = request.getParameter("maintenance");
        String maintenancesign = request.getParameter("maintenancesign");
        String Fromdate6 = request.getParameter("Fromdate6");
        String Fromdate7 = request.getParameter("Fromdate7");
        String inr = request.getParameter("inr");
        String comments = request.getParameter("comments");
        String Fromdate8 = request.getParameter("Fromdate8");
        String revisionNo = request.getParameter("revisionNo");
        String Fromdate9 = request.getParameter("Fromdate9");
        String reviewed = request.getParameter("reviewed");
        String designation = request.getParameter("designation");
        String signatureDate = request.getParameter("signatureDate");

        String country = request.getParameter("country");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String houseno = request.getParameter("houseno");
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
        String chargingrate = request.getParameter("chargingrate");

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
        DocumentMastersId documentMastersId = documentMastersIdService.readByDocumentNo();

        String meetingno = "0";
        meetingno = documentMastersId.getDocumentId();
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
        String f_year = refNo.substring(0, 2);
        String f_no = refNo.substring(2, 7);

        int f_y1 = Integer.parseInt(f_year);
        f_y1++;

        refNo = "AOC" + "-" + f_year + "" + f_y1 + "-" + f_no;

        String approvalName = request.getParameter("approvalName");
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
        String totalChargerCapacity = request.getParameter("totalChargerCapacity");
        String chargerStationAccessType = request.getParameter("chargerStationAccessType");
        String auxiliaryLoadOfStation = request.getParameter("auxiliaryLoadOfStation");
        if (auxiliaryLoadOfStation == null) {
            auxiliaryLoadOfStation = "";
        }
        String chargingRetePerUnit = request.getParameter("chargingRetePerUnit");
        String noOfEvsToBeChanged = request.getParameter("noOfEvsToBeChanged");
        String additionOfNewChargerCapacity = request.getParameter("additionOfNewChargerCapacity");
        String anchoreCustomer = request.getParameter("anchoreCustomer");
        String canopyVarient = request.getParameter("canopyVarient");
        if (canopyVarient == null) {
            canopyVarient = "";
        }
        String scopeofChargeZone = request.getParameter("scopeofChargeZone");
        String totalMW = request.getParameter("totalMW");

        AocForm aocForm = new AocForm();

        aocForm.setProjectTimelineCategory(projectTimelineCategory);
        aocForm.setTotalKwRating(totalKwRating);
        aocForm.setSpecificDateFromClient(specificDateFromClient);
        aocForm.setTotalChargerCapacity(totalChargerCapacity);
        aocForm.setChargerStationAccessType(chargerStationAccessType);
        aocForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
        aocForm.setChargingRetePerUnit(chargingRetePerUnit);
        aocForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
        aocForm.setAdditionOfNewChargerCapacity(additionOfNewChargerCapacity);

        aocForm.setDocumentNo(refNo);
        aocForm.setHubDepoName(depoName);
        aocForm.setBb2(b2b);
        aocForm.setBbc22(b2b2c);
        aocForm.setClientProjectName(projectName);
        aocForm.setBc2(b2c);
        aocForm.setHubDepoAddress(depoAddress);
        aocForm.setGoogleCoordinates(googleCoordinates);
        aocForm.setPcTypeCar(car);
        aocForm.setPcTypeBus(bus);
        aocForm.setPcTypeTruckLmv(truck);
        aocForm.setOther(others);
        aocForm.setPcsType("");
        aocForm.setFinacialModelCapex(capex);
        aocForm.setFinacialModelOpex(opex);
        aocForm.setCoOrdinates(coordinates);
        aocForm.setFirstName(firstName);
        aocForm.setMiddleName("");
        aocForm.setLastName("");
        aocForm.setMobileNo(mobileNo);
        aocForm.setAlternateMobileNo(altNo);
        aocForm.setEmail(email);
        aocForm.setSpecificReqClients(reqClients);
        aocForm.setChargeScope(scopework);
        aocForm.setClientScope(scope);
        aocForm.setOperations(operations);
        aocForm.setOperationsSign(operationsSign);
        aocForm.setMaintenance(maintenance);
        aocForm.setMaintenanceSign(maintenancesign);
        aocForm.setZeroDate(Fromdate6);
        aocForm.setCompletionDate(Fromdate7);
        aocForm.setProjectBudgetAllocated(inr);
        aocForm.setAuthorityComments(comments);
        aocForm.setOrderEffcectiveDate(Fromdate8);
        aocForm.setNewRevisionNo(revisionNo);
        aocForm.setBudjectAllocationDate(Fromdate9);
        aocForm.setReviewedBy(reviewed);
        aocForm.setDesignation(designation);
        aocForm.setSignatureDate("");
        aocForm.setOapMaster(oapMaster);
        aocForm.setCreatedDate(today);
        aocForm.setUserId(username1);
        aocForm.setFlagStatus(0);
        aocForm.setAssignedName("");
        aocForm.setState(state);
        aocForm.setCountry(country);
        aocForm.setCity(city);
        aocForm.setDistrict(district);
        aocForm.setHouseNo(houseno);
        aocForm.setProjectProfile(ProjectProfile);
        aocForm.setProjectCenter(profitcenter);
        aocForm.setCompanyCode(CompanyCode);
        aocForm.setPlant(Plant);
        aocForm.setProjectType(ProjectType);
        aocForm.setProjectCurrency(ProjectCurrency);
        aocForm.setInverstmentProfile(InvestmentProfile);
        aocForm.setDiscom(Discom);
        aocForm.setNoOfChargePoints(ChargePoints);
        aocForm.setNoOfCharger(NoOfCharger);
        aocForm.setOverallStationCapacityKw(overallstations);
        aocForm.setStationAcCapacityKw(stationAc);
        aocForm.setStationDcCapacityKw(stationDc);
        aocForm.setStationName(stationname);
        aocForm.setStationType(stationtype);
        aocForm.setTenant(tenant);
        aocForm.setConnectionType(connectiontype);
        documentMastersId.setDocumentId(final_ten_no);
        aocForm.setChargingRatePerUnit(chargingrate);
        aocForm.setSiteSurvey(sitesurvey);
        aocForm.setSurveyRadio(Integer.parseInt(Survey));
        aocForm.setAnchoreCustomer(anchoreCustomer);
        aocForm.setCanopyVarient(canopyVarient);
        aocForm.setScopeOfchargeZone(scopeofChargeZone);
        aocForm.setTotalMegaWatt(totalMW);

        aocFormService.create(aocForm);
        documentMastersIdService.create(documentMastersId);

        int id = aocForm.getId();

        AocForm aocForm1 = aocFormService.readById(id);

        String assumption = request.getParameter("assumption");
        if (assumption == null) {
            assumption = "0";
        } else {
            assumption = "1";
        }
        String assumptionRefNo = request.getParameter("assumptionRefNo");
        if (assumptionRefNo == null) {
            assumptionRefNo = "";
        }

        String Fromdate1 = request.getParameter("Fromdate1");
        if (Fromdate1 == null) {
            Fromdate1 = "";
        }

        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile file0 = multipartRequest1.getFile("file1");
        String file0FileName = "";
        if (file0 != null && !file0.isEmpty()) {
            file0FileName = file0.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file0FileName);
            file0.transferTo(destinationFile);
        }

        String boq = request.getParameter("boq");
        if (boq == null) {
            boq = "0";
        } else {
            boq = "1";
        }
        String boqRefNo = request.getParameter("boqRefNo");
        if (boqRefNo == null) {
            boqRefNo = "";
        }

        String Fromdate2 = request.getParameter("Fromdate2");
        if (Fromdate2 == null) {
            Fromdate2 = "";
        }

        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile file2 = multipartRequest2.getFile("file2");
        String file2FileName = "";
        if (file2 != null && !file2.isEmpty()) {
            file2FileName = file2.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file2FileName);
            file2.transferTo(destinationFile);

        }

        String lao = request.getParameter("lao");
        if (lao == null) {
            lao = "0";
        } else {
            lao = "1";
        }
        String laoRefNo = request.getParameter("laoRefNo");
        if (laoRefNo == null) {
            laoRefNo = "";
        }

        String Fromdate3 = request.getParameter("Fromdate3");
        if (Fromdate3 == null) {
            Fromdate3 = "";
        }

        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile file3 = multipartRequest3.getFile("file3");
        String file3FileName = "";
        if (file3 != null && !file3.isEmpty()) {
            file3FileName = file3.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file3FileName);
            file3.transferTo(destinationFile);
        }

        String agremment = request.getParameter("agremment");
        if (agremment == null) {
            agremment = "0";
        } else {
            agremment = "1";
        }
        String agremmentRefNo = request.getParameter("agremmentRefNo");
        if (agremmentRefNo == null) {
            agremmentRefNo = "";
        }
        String Fromdate4 = request.getParameter("Fromdate4");
        if (Fromdate4 == null) {
            Fromdate4 = "";
        }

        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile file4 = multipartRequest4.getFile("file4");
        String file4FileName = "";
        if (file4 != null && !file4.isEmpty()) {
            file4FileName = file4.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file4FileName);
            file4.transferTo(destinationFile);
        }

        String drawings = request.getParameter("drawings");
        if (drawings == null) {
            drawings = "0";
        } else {
            drawings = "1";
        }
        String drawingsRefNo = request.getParameter("drawingsRefNo");
        if (drawingsRefNo == null) {
            drawingsRefNo = "";
        }
        String Fromdate5 = request.getParameter("Fromdate5");
        if (Fromdate5 == null) {
            Fromdate5 = "";
        }

        MultipartHttpServletRequest multipartRequest5 = (MultipartHttpServletRequest) request;
        MultipartFile file5 = multipartRequest5.getFile("file5");
        String file5FileName = "";
        if (file5 != null && !file5.isEmpty()) {
            file5FileName = file5.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file5FileName);
            file5.transferTo(destinationFile);
        }

        aocForm1.setAssumptionSheet(assumption);
        aocForm1.setAssumptionRefNo(assumptionRefNo);
        aocForm1.setAssumptionDate(Fromdate1);
        aocForm1.setEstimatedBoq(boq);
        aocForm1.setEstimatedRefNo(boqRefNo);
        aocForm1.setEstimatedDate(Fromdate2);
        aocForm1.setLoaLoi(lao);
        aocForm1.setLoaLoiRefNo(laoRefNo);
        aocForm1.setLoaLoiDate(Fromdate3);
        aocForm1.setAgreement(agremment);
        aocForm1.setAgreementRefNo(agremmentRefNo);
        aocForm1.setAgreementDate(Fromdate4);
        aocForm1.setLayoutDrawings(drawings);
        aocForm1.setLayoutRefNo(drawingsRefNo);
        aocForm1.setLayoutDate(Fromdate5);
        aocForm1.setAssumptionAttach(file0FileName);
        aocForm1.setEstimatedAttach(file2FileName);
        aocForm1.setLoaAttach(file3FileName);
        aocForm1.setAgreementAttach(file4FileName);
        aocForm1.setLayoutAttach(file5FileName);

        aocFormService.update(aocForm1);

        String documentno = aocForm.getDocumentNo();
        String mailcreteddate = aocForm.getCreatedDate();
        String mainusername = aocForm.getUserId();

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");
        int b = 0;

        for (String s : surveyNo) {
            if (s != null && !s.isEmpty()) {
                AocSurveyAttachment aocSurveyAttachment = new AocSurveyAttachment();
                aocSurveyAttachment.setSurveyNo(surveyNo[b]);
                aocSurveyAttachment.setAocId(id);
                aocSurveyAttachment.setProjectRepresentative(projectRepresentative[b]);
                aocSurveyAttachmentService.create(aocSurveyAttachment);

                b++;
            }
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Aoc"
                + File.separator + id;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created

// Get all uploaded files
        List<MultipartFile> files = multipartRequest.getFiles("attchment");
        String[] id1 = request.getParameterValues("id");
        String[] descriptions = request.getParameterValues("descriptiones");
        int i = 0;
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Aoc"
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
                    AocFormAttachment aocFormAttachment = new AocFormAttachment();
//		    aocFormAttachment.setDocumentName(id1);
                    aocFormAttachment.setAttachment(file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    aocFormAttachment.setAocForm(aocForm1);
                    aocFormAttachment.setDescription(descriptions[i]);
                    aocFormAttachment.setDocumentName(documentName);
                    AocFormAttachmentService.create(aocFormAttachment);
                    i++;
                }
            }
        }
//multi attachment
        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Aoc"
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

                    AocFormMultiAttachment aocFormMultiAttachment = new AocFormMultiAttachment();

                    aocFormMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    aocFormMultiAttachment.setDescription(description[a]);
                    aocFormMultiAttachment.setAocForm(aocForm1);

                    aocFormMultiAttachmentService.create(aocFormMultiAttachment);

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

        AocFormApproval aocFormApproval = new AocFormApproval();

        aocFormApproval.setAocForm(aocForm1);
        aocFormApproval.setTotalApproval(approval_list.size() + "");
        aocFormApproval.setApprovalStatus("0");
        aocFormApproval.setApprovalRemark("add");
        aocFormApproval.setUserId(employeeCode);
        aocFormApproval.setCurrentApproval("1");
        aocFormApprovalService.create(aocFormApproval);

        int approveId = aocFormApproval.getId();
        OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

        int j = 0;
        for (Object o : approval_list) {
            j++;
            OapMasterUser oap1 = (OapMasterUser) o;
            AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();
            aocFormApprovalUser.setAocFormApproval(approveId);
            aocFormApprovalUser.setAocForm(id);
            aocFormApprovalUser.setUserId(oap1.getUserId());
            aocFormApprovalUser.setLevel("1");
            aocFormApprovalUser.setApprovalStatus("0");
            aocFormApprovalUserService.create(aocFormApprovalUser);

        }

        session.setAttribute("successMessage", " AOCForm SaveAsDraft Submited successfully");
        mv.setViewName("redirect:aocForm.htm?act=aocFormAppovalList");
        return mv;

    }

    public ModelAndView AocSaveAsDraftList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        List list = aocFormService.readByflagstatuszero(username);

        mv.getModelMap().put("list", list);

        mv.setViewName("Oap/AocSaveAsDraftList");
        return mv;

    }

    public ModelAndView AocSaveAsDraftView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

//	String aocFormattach = request.getParameter("aocFormattach");
//	String aocFormmulti = request.getParameter("aocFormmulti");
        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));
        List aocsurveyattach = aocSurveyAttachmentService.readByaocId(id);

        int size = aocsurveyattach.size();
        String connectionType = aocForm.getConnectionType();
        ConnectionType connectionType1 = new ConnectionType();
        if (!connectionType.equals("") && connectionType != "") {
            connectionType1 = connectionTypeService.readById(Integer.parseInt(connectionType));
            String connection = connectionType1.getConnectionType();

            mv.getModelMap().put("connection", connection);
        }
        String discom = aocForm.getDiscom();
        DiscomMaster discomMaster = new DiscomMaster();

        try {
            if (discom != null && !discom.trim().isEmpty() && !"null".equalsIgnoreCase(discom)) {
                discomMaster = discomMasterService.readById(Integer.parseInt(discom));
                String Discom1 = discomMaster.getDiscomType();
                mv.getModelMap().put("Discom1", Discom1);
            }
        } catch (Exception e) {

        }
        String Discom1 = discomMaster.getDiscomType();
        String projectname = aocForm.getClientProjectName();

        String connection = connectionType1.getConnectionType();
        mv.getModelMap().put("Discom1", Discom1);
        mv.getModelMap().put("connection", connection);

//        int aocmasterId = aocForm.getOapMaster().getId();
        int aocmasterId = 0;
        OapMaster oapMaster = aocForm.getOapMaster();
        if (oapMaster != null) {
            aocmasterId = aocForm.getOapMaster().getId();
        }

        List list = AocFormAttachmentService.readByattach(id);
        List list33 = aocFormMultiAttachmentService.readByMulti(id);
        List list10 = oapMasterService.read();

        String Tenant = aocForm.getTenant();
        String StationType = aocForm.getStationType();
        String Currency = aocForm.getProjectCurrency();
        String ProjectType = aocForm.getProjectType();
        String Ivestmentprofile = aocForm.getInverstmentProfile();
        String ProjectCenter = aocForm.getProjectCenter();
        String CompanyCode = aocForm.getCompanyCode();
        String ProjectProfile = aocForm.getProjectProfile();
        String Discom = aocForm.getDiscom();
        String plant = aocForm.getPlant();
        String state = aocForm.getState();
        String connectiontype = aocForm.getConnectionType();
        String name = aocForm.getAnchoreCustomer();
        String names = aocForm.getCanopyVarient();
        mv.getModelMap().put("plant", plant);
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
        mv.getModelMap().put("connectiontype", connectiontype);
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
        request.setAttribute("list13", list13);
        mv.getModelMap().put("aocForm", aocForm);
        mv.getModelMap().put("list14", list14);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list33", list33);
        mv.getModelMap().put("aocmasterId", aocmasterId);
        mv.getModelMap().put("list10", list10);
        mv.getModelMap().put("state", state);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("aocsurveyattach", aocsurveyattach);
        request.setAttribute("size", size);
        mv.getModelMap().put("list15", list15);
        mv.getModelMap().put("list16", list16);
        mv.getModelMap().put("name", name);
        mv.getModelMap().put("names", names);
        mv.setViewName("Oap/AocSaveAsDraftView");
        return mv;

    }

    public ModelAndView AocSaveAsDraftViewSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username1 = user1.getLoginName();

        String id = request.getParameter("id");

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        String documentNo = request.getParameter("documentNo");
        String depoName = request.getParameter("depoName");
        String b2b = request.getParameter("b2b");
        String b2b2c = request.getParameter("b2b2c");
        String b2c = request.getParameter("b2c");
        String projectName = request.getParameter("projectName");
        String depoAddress = request.getParameter("depoAddress");
        String googleCoordinates = request.getParameter("googleCoordinates");
        String car = request.getParameter("car");
        if (car == null) {
            car = "0";
        } else {
            car = "1";
        }
        String bus = request.getParameter("bus");
        if (bus == null) {
            bus = "0";
        } else {
            bus = "1";
        }
        String truck = request.getParameter("truck");
        if (truck == null) {
            truck = "0";
        } else {
            truck = "1";
        }
        String others = request.getParameter("others");
        String pcs = request.getParameter("pcs");
        String capex = request.getParameter("capex");
        if (capex == null) {
            capex = "0";
        } else {
            capex = "1";
        }
        String opex = request.getParameter("opex");
        if (opex == null) {
            opex = "0";
        } else {
            opex = "1";
        }
        String coordinates = request.getParameter("coordinates");
        String firstName = request.getParameter("firstName");
//	String middleName = request.getParameter("middleName");
//	String lastName = request.getParameter("lastName");
        String mobileNo = request.getParameter("mobileNo");
        String altNo = request.getParameter("altNo");
        String email = request.getParameter("email");
        String reqClients = request.getParameter("reqClients");
        String scopework = request.getParameter("scopework");
        String scope = request.getParameter("scope");
        String assumption = request.getParameter("assumption");
        if (assumption == null) {
            assumption = "0";
        } else {
            assumption = "1";
        }
        String assumptionRefNo = request.getParameter("assumptionRefNo");
        if (assumptionRefNo == null) {
            assumptionRefNo = "";
        }
        String Fromdate1 = request.getParameter("Fromdate1");
        if (Fromdate1 == null) {
            Fromdate1 = "";
        }
        String file11 = request.getParameter("file11");
        if (assumption.equals("0")) {
            file11 = "";
        }
        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile file0 = multipartRequest1.getFile("file1");
        String file0FileName = "";
        if (file0 != null && !file0.isEmpty()) {
            file0FileName = file0.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file0FileName);
            file0.transferTo(destinationFile);
        }
        if (file0FileName.equals("") || file0FileName == "") {
            file0FileName = file11;
        }

        String boq = request.getParameter("boq");
        if (boq == null) {
            boq = "0";
        } else {
            boq = "1";
        }
        String boqRefNo = request.getParameter("boqRefNo");
        if (boqRefNo == null) {
            boqRefNo = "";
        }
        String Fromdate2 = request.getParameter("Fromdate2");
        if (Fromdate2 == null) {
            Fromdate2 = "";
        }
        String file12 = request.getParameter("file12");
        if (boq.equals("0")) {
            file12 = "";
        }
        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile file2 = multipartRequest2.getFile("file2");
        String file2FileName = "";
        if (file2 != null && !file2.isEmpty()) {
            file2FileName = file2.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file2FileName);
            file2.transferTo(destinationFile);

        }
        if (file2FileName.equals("") || file2FileName == "") {
            file2FileName = file12;
        }

        String lao = request.getParameter("lao");
        if (lao == null) {
            lao = "0";
        } else {
            lao = "1";
        }
        String laoRefNo = request.getParameter("laoRefNo");
        if (laoRefNo == null) {
            laoRefNo = "";
        }
        String Fromdate3 = request.getParameter("Fromdate3");
        if (Fromdate3 == null) {
            Fromdate3 = "";
        }
        String file13 = request.getParameter("file13");
        if (lao.equals("0")) {
            file13 = "";
        }
        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile file3 = multipartRequest3.getFile("file3");
        String file3FileName = "";
        if (file3 != null && !file3.isEmpty()) {
            file3FileName = file3.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file3FileName);
            file3.transferTo(destinationFile);
        }
        if (file3FileName.equals("") || file3FileName == "") {
            file3FileName = file13;
        }
        String agremment = request.getParameter("agremment");
        if (agremment == null) {
            agremment = "0";
        } else {
            agremment = "1";
        }
        String agremmentRefNo = request.getParameter("agremmentRefNo");
        if (agremmentRefNo == null) {
            agremmentRefNo = "";
        }
        String Fromdate4 = request.getParameter("Fromdate4");
        if (Fromdate4 == null) {
            Fromdate4 = "";
        }
        String file14 = request.getParameter("file14");
        if (agremment.equals("0")) {
            file14 = "";
        }
        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile file4 = multipartRequest4.getFile("file4");
        String file4FileName = "";
        if (file4 != null && !file4.isEmpty()) {
            file4FileName = file4.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file4FileName);
            file4.transferTo(destinationFile);
        }
        if (file4FileName.equals("") || file4FileName == "") {
            file4FileName = file14;
        }
        String drawings = request.getParameter("drawings");
        if (drawings == null) {
            drawings = "0";
        } else {
            drawings = "1";
        }
        String drawingsRefNo = request.getParameter("drawingsRefNo");
        if (drawingsRefNo == null) {
            drawingsRefNo = "";
        }
        String Fromdate5 = request.getParameter("Fromdate5");
        if (Fromdate5 == null) {
            Fromdate5 = "";
        }
        String file15 = request.getParameter("file15");
        if (drawings.equals("0")) {
            file15 = "";
        }
        MultipartHttpServletRequest multipartRequest5 = (MultipartHttpServletRequest) request;
        MultipartFile file5 = multipartRequest5.getFile("file5");
        String file5FileName = "";
        if (file5 != null && !file5.isEmpty()) {
            file5FileName = file5.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file5FileName);
            file5.transferTo(destinationFile);
        }
        if (file5FileName.equals("") || file5FileName == "") {
            file5FileName = file15;
        }
        String operations = request.getParameter("operations");
        String operationsSign = request.getParameter("operationsSign");
        String maintenance = request.getParameter("maintenance");
        String maintenancesign = request.getParameter("maintenancesign");
        String Fromdate6 = request.getParameter("Fromdate6");
        String Fromdate7 = request.getParameter("Fromdate7");
        String inr = request.getParameter("inr");
        String comments = request.getParameter("comments");
        String Fromdate8 = request.getParameter("Fromdate8");
        String revisionNo = request.getParameter("revisionNo");
        String Fromdate9 = request.getParameter("Fromdate9");
        String reviewed = request.getParameter("reviewed");
        String designation = request.getParameter("designation");
        String signatureDate = request.getParameter("signatureDate");
        String approvalName = request.getParameter("approvalName");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
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
        String totalChargerCapacity = request.getParameter("totalChargerCapacity");
        String chargerStationAccessType = request.getParameter("chargerStationAccessType");
        String auxiliaryLoadOfStation = request.getParameter("auxiliaryLoadOfStation");
        if (auxiliaryLoadOfStation == null) {
            auxiliaryLoadOfStation = "";
        }
        String chargingRetePerUnit = request.getParameter("chargingRetePerUnit");
        String noOfEvsToBeChanged = request.getParameter("noOfEvsToBeChanged");
        String additionOfNewChargerCapacity = request.getParameter("additionOfNewChargerCapacity");
        String anchoreCustomer = request.getParameter("anchoreCustomer");
        String canopyVarient = request.getParameter("canopyVarient");
        if (canopyVarient == null) {
            canopyVarient = "";
        }
        String scopeofChargeZone = request.getParameter("scopeofChargeZone");
        String totalMW = request.getParameter("totalMW");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        aocForm.setDocumentNo(documentNo);
        aocForm.setHubDepoName(depoName);
        aocForm.setBb2(b2b);
        aocForm.setBbc22(b2b2c);
        aocForm.setBc2(b2c);
        aocForm.setClientProjectName(projectName);
        aocForm.setHubDepoAddress(depoAddress);
        aocForm.setGoogleCoordinates(googleCoordinates);
        aocForm.setPcTypeCar(car);
        aocForm.setPcTypeBus(bus);
        aocForm.setPcTypeTruckLmv(truck);
        aocForm.setOther(others);
        aocForm.setPcsType("");
        aocForm.setFinacialModelCapex(capex);
        aocForm.setFinacialModelOpex(opex);
        aocForm.setCoOrdinates(coordinates);
        aocForm.setFirstName(firstName);
        aocForm.setMiddleName("");
        aocForm.setLastName("");
        aocForm.setMobileNo(mobileNo);
        aocForm.setAlternateMobileNo(altNo);
        aocForm.setEmail(email);
        aocForm.setSpecificReqClients(reqClients);
        aocForm.setChargeScope(scopework);
        aocForm.setClientScope(scope);
        aocForm.setAssumptionSheet(assumption);
        aocForm.setAssumptionRefNo(assumptionRefNo);
        aocForm.setAssumptionDate(Fromdate1);
        aocForm.setEstimatedBoq(boq);
        aocForm.setEstimatedRefNo(boqRefNo);
        aocForm.setEstimatedDate(Fromdate2);
        aocForm.setLoaLoi(lao);
        aocForm.setLoaLoiRefNo(laoRefNo);
        aocForm.setLoaLoiDate(Fromdate3);
        aocForm.setAgreement(agremment);
        aocForm.setAgreementRefNo(agremmentRefNo);
        aocForm.setAgreementDate(Fromdate4);
        aocForm.setLayoutDrawings(drawings);
        aocForm.setLayoutRefNo(drawingsRefNo);
        aocForm.setLayoutDate(Fromdate5);
        aocForm.setOperations(operations);
        aocForm.setOperationsSign(operationsSign);
        aocForm.setMaintenance(maintenance);
        aocForm.setMaintenanceSign(maintenancesign);
        aocForm.setZeroDate(Fromdate6);
        aocForm.setCompletionDate(Fromdate7);
        aocForm.setProjectBudgetAllocated(inr);
        aocForm.setAuthorityComments(comments);
        aocForm.setOrderEffcectiveDate(Fromdate8);
        aocForm.setNewRevisionNo(revisionNo);
        aocForm.setBudjectAllocationDate(Fromdate9);
        aocForm.setReviewedBy(reviewed);
        aocForm.setDesignation(designation);
        aocForm.setSignatureDate("");
        aocForm.setOapMaster(oapMaster);
        aocForm.setCreatedDate(today);
        aocForm.setUserId(username1);
        aocForm.setFlagStatus(1);
        aocForm.setCountry(country);
        aocForm.setState(state);
        aocForm.setCity(city);
        aocForm.setDistrict(district);
        aocForm.setHouseNo(houseno);
        aocForm.setAssumptionAttach(file0FileName);
        aocForm.setEstimatedAttach(file2FileName);
        aocForm.setLoaAttach(file3FileName);
        aocForm.setAgreementAttach(file4FileName);
        aocForm.setLayoutAttach(file5FileName);
        aocForm.setProjectProfile(ProjectProfile);
        aocForm.setProjectCenter(profitcenter);
        aocForm.setCompanyCode(CompanyCode);
        aocForm.setPlant(Plant);
        aocForm.setProjectType(ProjectType);
        aocForm.setProjectCurrency(ProjectCurrency);
        aocForm.setInverstmentProfile(InvestmentProfile);
        aocForm.setDiscom(Discom);
        aocForm.setNoOfChargePoints(ChargePoints);
        aocForm.setNoOfCharger(NoOfCharger);
        aocForm.setOverallStationCapacityKw(overallstations);
        aocForm.setStationAcCapacityKw(stationAc);
        aocForm.setStationDcCapacityKw(stationDc);
        aocForm.setStationName(stationname);
        aocForm.setStationType(stationtype);
        aocForm.setTenant(tenant);
        aocForm.setFlagStatus(1);
        aocForm.setChargingRatePerUnit(chargingrate);
        aocForm.setSiteSurvey(sitesurvey);
        aocForm.setSurveyRadio(Integer.parseInt(Survey));
        aocForm.setConnectionType(connectiontype);
        aocForm.setProjectTimelineCategory(projectTimelineCategory);
        aocForm.setTotalKwRating(totalKwRating);
        aocForm.setSpecificDateFromClient(specificDateFromClient);
        aocForm.setTotalChargerCapacity(totalChargerCapacity);
        aocForm.setChargerStationAccessType(chargerStationAccessType);
        aocForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
        aocForm.setChargingRetePerUnit(chargingRetePerUnit);
        aocForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
        aocForm.setAdditionOfNewChargerCapacity(additionOfNewChargerCapacity);
        aocForm.setAnchoreCustomer(anchoreCustomer);
        aocForm.setCanopyVarient(canopyVarient);
        aocForm.setScopeOfchargeZone(scopeofChargeZone);
        aocForm.setTotalMegaWatt(totalMW);
        aocFormService.update(aocForm);
        int id1 = aocForm.getId();

        AocForm aocForm1 = aocFormService.readById(id1);

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");

        int z = 0;
        int id8 = 0;
        for (String s : surveyNo) {
            if (s != null && !s.isEmpty()) {
                AocSurveyAttachment aocSurveyAttachment = new AocSurveyAttachment();
                aocSurveyAttachment.setSurveyNo(surveyNo[z]);
                aocSurveyAttachment.setProjectRepresentative(projectRepresentative[z]);
                aocSurveyAttachment.setAocId(id1);
                aocSurveyAttachmentService.create(aocSurveyAttachment);

                z++;
                id8 = aocSurveyAttachment.getId();
            }
        }

        AocFormAttachmentService.deleteByid(id1);

        //connectiuon type attcahment  
        MultipartHttpServletRequest multipartRequest8 = (MultipartHttpServletRequest) request;

// Get all uploaded files
        List<MultipartFile> files = multipartRequest8.getFiles("attchment");
        String[] document1 = request.getParameterValues("document1");
        String[] id2 = request.getParameterValues("idd");
        String[] descriptions = request.getParameterValues("descriptiones");
        String[] descriptiones1 = request.getParameterValues("descriptiones1");

        int p = 0;

        for (MultipartFile file : files) {
            AocFormAttachment aocFormAttachment = new AocFormAttachment();
            String attachmentFileName = "";
            if (file != null && !file.isEmpty()) {
                attachmentFileName = file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                aocFormAttachment.setAttachment(attachmentFileName.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Aoc"
                        + File.separator + id1 + File.separator;
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File destinationFile = new File(fileLocationURL + attachmentFileName);
                file.transferTo(destinationFile);

            }
            if (attachmentFileName.equals("") && document1 != null && p < document1.length) {

                attachmentFileName = document1[p];
            }

            aocFormAttachment.setAttachment(attachmentFileName);
            DocumentName documentName = documentNameService.readById(Integer.parseInt(id2[p]));

            aocFormAttachment.setAocForm(aocForm1);
            if (p < descriptions.length && descriptions[p] != null && !descriptions[p].equals("")) {
                aocFormAttachment.setDescription(descriptions[p]);
            }

            if (descriptions[p] == null) {
                aocFormAttachment.setDescription(descriptiones1[p]);

            }
            aocFormAttachment.setDocumentName(documentName);

            AocFormAttachmentService.create(aocFormAttachment);
            p++;
        }

        //multi attachment
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Aoc"
                + File.separator + id1;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created
        //multi attachment
        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        int id4 = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Aoc"
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

                    AocFormMultiAttachment aocFormMultiAttachment = new AocFormMultiAttachment();

                    aocFormMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    aocFormMultiAttachment.setDescription(description[a]);
                    aocFormMultiAttachment.setAocForm(aocForm1);

                    aocFormMultiAttachmentService.create(aocFormMultiAttachment);
                    id4 = aocFormMultiAttachment.getId();
                    a++;
                }
            }

        }

        AocFormApproval aocFormApproval5 = aocFormApprovalService.readByDeltecodes(id);

        int formid = aocFormApproval5.getId();

        List list44 = aocFormApprovalUserService.readByDleteCode(formid);
        for (Object o : list44) {
            AocFormApprovalUser oacAocFormApprovalUser = (AocFormApprovalUser) o;
            int id3 = oacAocFormApprovalUser.getId();
            aocFormApprovalUserService.delete(id3);
        }

        aocFormApprovalService.delete(formid);

// approval name drop down relted code
        List approval_list = oapMasterUserService.readByIdToList(approvalName);
        HttpSession session1 = request.getSession(false);
        UserMaster user = (UserMaster) session1.getAttribute("user");
        String username = user.getLoginName();
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        AocFormApproval aocFormApproval = new AocFormApproval();

        aocFormApproval.setAocForm(aocForm1);
        aocFormApproval.setTotalApproval(approval_list.size() + "");
        aocFormApproval.setApprovalStatus("0");
        aocFormApproval.setApprovalRemark("add");
        aocFormApproval.setUserId(employeeCode);
        aocFormApproval.setCurrentApproval("1");
        aocFormApprovalService.create(aocFormApproval);

        int approveId = aocFormApproval.getId();
        OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

        int j = 0;
        for (Object o : approval_list) {
            j++;
            OapMasterUser oap1 = (OapMasterUser) o;
            AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();
            aocFormApprovalUser.setAocFormApproval(approveId);
            aocFormApprovalUser.setAocForm(id1);
            aocFormApprovalUser.setUserId(oap1.getUserId());
            aocFormApprovalUser.setLevel("1");
            aocFormApprovalUser.setApprovalStatus("0");
            aocFormApprovalUserService.create(aocFormApprovalUser);

        }

        mv.getModelMap().put("id", id);
        session.setAttribute("successMessage", " AocForm SaveAsDraft Submited successfully");
        mv.setViewName("redirect:aocForm.htm?act=aocFormAppovalList");
        return mv;

    }

    public ModelAndView AocSaveAsDraft1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username1 = user1.getLoginName();
        String id = request.getParameter("id");

        EmployeeMaster employeeMaster1 = employeeMasterService.read(username1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String today = dateFormat.format(new Date());

        String documentNo = request.getParameter("documentNo");
        String depoName = request.getParameter("depoName");
        String b2b = request.getParameter("b2b");
        String b2b2c = request.getParameter("b2b2c");
        String b2c = request.getParameter("b2c");
        String projectName = request.getParameter("projectName");
        String depoAddress = request.getParameter("depoAddress");
        String googleCoordinates = request.getParameter("googleCoordinates");
        String car = request.getParameter("car");
        if (car == null) {
            car = "0";
        } else {
            car = "1";
        }
        String bus = request.getParameter("bus");
        if (bus == null) {
            bus = "0";
        } else {
            bus = "1";
        }
        String truck = request.getParameter("truck");
        if (truck == null) {
            truck = "0";
        } else {
            truck = "1";
        }
        String others = request.getParameter("others");
        String pcs = request.getParameter("pcs");
        String capex = request.getParameter("capex");
        if (capex == null) {
            capex = "0";
        } else {
            capex = "1";
        }
        String opex = request.getParameter("opex");
        if (opex == null) {
            opex = "0";
        } else {
            opex = "1";
        }
        String coordinates = request.getParameter("coordinates");
        String firstName = request.getParameter("firstName");
//	String middleName = request.getParameter("middleName");
//	String lastName = request.getParameter("lastName");
        String mobileNo = request.getParameter("mobileNo");
        String altNo = request.getParameter("altNo");
        String email = request.getParameter("email");
        String reqClients = request.getParameter("reqClients");
        String scopework = request.getParameter("scopework");
        String scope = request.getParameter("scope");
        String assumption = request.getParameter("assumption");
        if (assumption == null) {
            assumption = "0";
        } else {
            assumption = "1";
        }
        String assumptionRefNo = request.getParameter("assumptionRefNo");
        if (assumptionRefNo == null) {
            assumptionRefNo = "";
        }
        String Fromdate1 = request.getParameter("Fromdate1");
        if (Fromdate1 == null) {
            Fromdate1 = "";
        }
        String file11 = request.getParameter("file11");
        if (assumption.equals("0")) {
            file11 = "";
        }
        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile file0 = multipartRequest1.getFile("file1");
        String file0FileName = "";
        if (file0 != null && !file0.isEmpty()) {
            file0FileName = file0.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file0FileName);
            file0.transferTo(destinationFile);
        }
        if (file0FileName.equals("") || file0FileName == "") {
            file0FileName = file11;
        }

        String boq = request.getParameter("boq");
        if (boq == null) {
            boq = "0";
        } else {
            boq = "1";
        }
        String boqRefNo = request.getParameter("boqRefNo");
        if (boqRefNo == null) {
            boqRefNo = "";
        }
        String Fromdate2 = request.getParameter("Fromdate2");
        if (Fromdate2 == null) {
            Fromdate2 = "";
        }
        String file12 = request.getParameter("file12");
        if (boq.equals("0")) {
            file12 = "";
        }
        MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
        MultipartFile file2 = multipartRequest2.getFile("file2");
        String file2FileName = "";
        if (file2 != null && !file2.isEmpty()) {
            file2FileName = file2.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file2FileName);
            file2.transferTo(destinationFile);

        }
        if (file2FileName.equals("") || file2FileName == "") {
            file2FileName = file12;
        }

        String lao = request.getParameter("lao");
        if (lao == null) {
            lao = "0";
        } else {
            lao = "1";
        }
        String laoRefNo = request.getParameter("laoRefNo");
        if (laoRefNo == null) {
            laoRefNo = "";
        }
        String Fromdate3 = request.getParameter("Fromdate3");
        if (Fromdate3 == null) {
            Fromdate3 = "";
        }
        String file13 = request.getParameter("file13");
        if (lao.equals("0")) {
            file13 = "";
        }
        MultipartHttpServletRequest multipartRequest3 = (MultipartHttpServletRequest) request;
        MultipartFile file3 = multipartRequest3.getFile("file3");
        String file3FileName = "";
        if (file3 != null && !file3.isEmpty()) {
            file3FileName = file3.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file3FileName);
            file3.transferTo(destinationFile);
        }
        if (file3FileName.equals("") || file3FileName == "") {
            file3FileName = file13;
        }
        String agremment = request.getParameter("agremment");
        if (agremment == null) {
            agremment = "0";
        } else {
            agremment = "1";
        }
        String agremmentRefNo = request.getParameter("agremmentRefNo");
        if (agremmentRefNo == null) {
            agremmentRefNo = "";
        }
        String Fromdate4 = request.getParameter("Fromdate4");
        if (Fromdate4 == null) {
            Fromdate4 = "";
        }
        String file14 = request.getParameter("file14");
        if (agremment.equals("0")) {
            file14 = "";
        }
        MultipartHttpServletRequest multipartRequest4 = (MultipartHttpServletRequest) request;
        MultipartFile file4 = multipartRequest4.getFile("file4");
        String file4FileName = "";
        if (file4 != null && !file4.isEmpty()) {
            file4FileName = file4.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file4FileName);
            file4.transferTo(destinationFile);
        }
        if (file4FileName.equals("") || file4FileName == "") {
            file4FileName = file14;
        }
        String drawings = request.getParameter("drawings");
        if (drawings == null) {
            drawings = "0";
        } else {
            drawings = "1";
        }
        String drawingsRefNo = request.getParameter("drawingsRefNo");
        if (drawingsRefNo == null) {
            drawingsRefNo = "";
        }
        String Fromdate5 = request.getParameter("Fromdate5");
        if (Fromdate5 == null) {
            Fromdate5 = "";
        }
        String file15 = request.getParameter("file15");
        if (drawings.equals("0")) {
            file15 = "";
        }
        MultipartHttpServletRequest multipartRequest5 = (MultipartHttpServletRequest) request;
        MultipartFile file5 = multipartRequest5.getFile("file5");
        String file5FileName = "";
        if (file5 != null && !file5.isEmpty()) {
            file5FileName = file5.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + id + File.separator;
            File directory = new File(fileLocationURL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Save the file
            File destinationFile = new File(fileLocationURL + file5FileName);
            file5.transferTo(destinationFile);
        }
        if (file5FileName.equals("") || file5FileName == "") {
            file5FileName = file15;
        }
        String operations = request.getParameter("operations");
        String operationsSign = request.getParameter("operationsSign");
        String maintenance = request.getParameter("maintenance");
        String maintenancesign = request.getParameter("maintenancesign");
        String Fromdate6 = request.getParameter("Fromdate6");
        String Fromdate7 = request.getParameter("Fromdate7");
        String inr = request.getParameter("inr");
        String comments = request.getParameter("comments");
        String Fromdate8 = request.getParameter("Fromdate8");
        String revisionNo = request.getParameter("revisionNo");
        String Fromdate9 = request.getParameter("Fromdate9");
        String reviewed = request.getParameter("reviewed");
        String designation = request.getParameter("designation");
        String signatureDate = request.getParameter("signatureDate");
        String approvalName = request.getParameter("approvalName");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
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
//        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(approvalName));
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
        String additionOfNewChargerCapacity = request.getParameter("additionOfNewChargerCapacity");
        String anchoreCustomer = request.getParameter("anchoreCustomer");
        String canopyVarient = request.getParameter("canopyVarient");
        if (canopyVarient == null) {
            canopyVarient = "";
        }
        String scopeofChargeZone = request.getParameter("scopeofChargeZone");
        String totalMW = request.getParameter("totalMW");

        AocForm aocForm = aocFormService.readById(Integer.parseInt(id));

        aocForm.setDocumentNo(documentNo);
        aocForm.setHubDepoName(depoName);
        aocForm.setBb2(b2b);
        aocForm.setBbc22(b2b2c);
        aocForm.setBc2(b2c);
        aocForm.setClientProjectName(projectName);
        aocForm.setHubDepoAddress(depoAddress);
        aocForm.setGoogleCoordinates(googleCoordinates);
        aocForm.setPcTypeCar(car);
        aocForm.setPcTypeBus(bus);
        aocForm.setPcTypeTruckLmv(truck);
        aocForm.setOther(others);
        aocForm.setPcsType("");
        aocForm.setFinacialModelCapex(capex);
        aocForm.setFinacialModelOpex(opex);
        aocForm.setCoOrdinates(coordinates);
        aocForm.setFirstName(firstName);
        aocForm.setMiddleName("");
        aocForm.setLastName("");
        aocForm.setMobileNo(mobileNo);
        aocForm.setAlternateMobileNo(altNo);
        aocForm.setEmail(email);
        aocForm.setSpecificReqClients(reqClients);
        aocForm.setChargeScope(scopework);
        aocForm.setClientScope(scope);
        aocForm.setAssumptionSheet(assumption);
        aocForm.setAssumptionRefNo(assumptionRefNo);
        aocForm.setAssumptionDate(Fromdate1);
        aocForm.setEstimatedBoq(boq);
        aocForm.setEstimatedRefNo(boqRefNo);
        aocForm.setEstimatedDate(Fromdate2);
        aocForm.setLoaLoi(lao);
        aocForm.setLoaLoiRefNo(laoRefNo);
        aocForm.setLoaLoiDate(Fromdate3);
        aocForm.setAgreement(agremment);
        aocForm.setAgreementRefNo(agremmentRefNo);
        aocForm.setAgreementDate(Fromdate4);
        aocForm.setLayoutDrawings(drawings);
        aocForm.setLayoutRefNo(drawingsRefNo);
        aocForm.setLayoutDate(Fromdate5);
        aocForm.setOperations(operations);
        aocForm.setOperationsSign(operationsSign);
        aocForm.setMaintenance(maintenance);
        aocForm.setMaintenanceSign(maintenancesign);
        aocForm.setZeroDate(Fromdate6);
        aocForm.setCompletionDate(Fromdate7);
        aocForm.setProjectBudgetAllocated(inr);
        aocForm.setAuthorityComments(comments);
        aocForm.setOrderEffcectiveDate(Fromdate8);
        aocForm.setNewRevisionNo(revisionNo);
        aocForm.setBudjectAllocationDate(Fromdate9);
        aocForm.setReviewedBy(reviewed);
        aocForm.setDesignation(designation);
        aocForm.setSignatureDate("");
        aocForm.setOapMaster(oapMaster);
        aocForm.setCreatedDate(today);
        aocForm.setUserId(username1);
        aocForm.setFlagStatus(0);
        aocForm.setCountry(country);
        aocForm.setState(state);
        aocForm.setCity(city);
        aocForm.setDistrict(district);
        aocForm.setHouseNo(houseno);
        aocForm.setAssumptionAttach(file0FileName);
        aocForm.setEstimatedAttach(file2FileName);
        aocForm.setLoaAttach(file3FileName);
        aocForm.setAgreementAttach(file4FileName);
        aocForm.setLayoutAttach(file5FileName);
        aocForm.setProjectProfile(ProjectProfile);
        aocForm.setProjectCenter(profitcenter);
        aocForm.setCompanyCode(CompanyCode);
        aocForm.setPlant(Plant);
        aocForm.setProjectType(ProjectType);
        aocForm.setProjectCurrency(ProjectCurrency);
        aocForm.setInverstmentProfile(InvestmentProfile);
        aocForm.setDiscom(Discom);
        aocForm.setNoOfChargePoints(ChargePoints);
        aocForm.setNoOfCharger(NoOfCharger);
        aocForm.setOverallStationCapacityKw(overallstations);
        aocForm.setStationAcCapacityKw(stationAc);
        aocForm.setStationDcCapacityKw(stationDc);
        aocForm.setStationName(stationname);
        aocForm.setStationType(stationtype);
        aocForm.setTenant(tenant);
        aocForm.setFlagStatus(0);
        aocForm.setChargingRatePerUnit(chargingrate);
        aocForm.setSiteSurvey(sitesurvey);
        aocForm.setSurveyRadio(Integer.parseInt(Survey));
        aocForm.setConnectionType(connectiontype);
        aocForm.setProjectTimelineCategory(projectTimelineCategory);
        aocForm.setTotalKwRating(totalKwRating);
        aocForm.setSpecificDateFromClient(specificDateFromClient);
        aocForm.setTotalChargerCapacity(totalChargerCapacity);
        aocForm.setChargerStationAccessType(chargerStationAccessType);
        aocForm.setAuxiliaryLoadOfStation(auxiliaryLoadOfStation);
        aocForm.setChargingRetePerUnit(chargingRetePerUnit);
        aocForm.setNoOfEvsToBeChanged(noOfEvsToBeChanged);
        aocForm.setAdditionOfNewChargerCapacity(additionOfNewChargerCapacity);
        aocForm.setAnchoreCustomer(anchoreCustomer);
        aocForm.setCanopyVarient(canopyVarient);
        aocForm.setScopeOfchargeZone(scopeofChargeZone);
        aocForm.setTotalMegaWatt(totalMW);
        aocFormService.update(aocForm);
        int id1 = aocForm.getId();

        AocForm aocForm1 = aocFormService.readById(id1);

        String[] surveyNo = request.getParameterValues("surveyNo");
        String[] projectRepresentative = request.getParameterValues("projectRepresentative");

        int z = 0;
        int id8 = 0;
        for (String s : surveyNo) {
            if (s != null && !s.isEmpty()) {
                AocSurveyAttachment aocSurveyAttachment = new AocSurveyAttachment();
                aocSurveyAttachment.setSurveyNo(surveyNo[z]);
                aocSurveyAttachment.setProjectRepresentative(projectRepresentative[z]);
                aocSurveyAttachment.setAocId(id1);
                aocSurveyAttachmentService.create(aocSurveyAttachment);

                z++;
                id8 = aocSurveyAttachment.getId();
            }
        }

        AocFormAttachmentService.deleteByid(id1);

        //connectiuon type attcahment  
        MultipartHttpServletRequest multipartRequest8 = (MultipartHttpServletRequest) request;

// Get all uploaded files
        List<MultipartFile> files = multipartRequest8.getFiles("attchment");
        String[] document1 = request.getParameterValues("document1");
        String[] id2 = request.getParameterValues("idd");
        String[] descriptions = request.getParameterValues("descriptiones");
        String[] descriptiones1 = request.getParameterValues("descriptiones1");

        int p = 0;

        for (MultipartFile file : files) {
            AocFormAttachment aocFormAttachment = new AocFormAttachment();
            String attachmentFileName = "";
            if (file != null && !file.isEmpty()) {
                attachmentFileName = file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                aocFormAttachment.setAttachment(attachmentFileName.replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Aoc"
                        + File.separator + id1 + File.separator;
                File directory = new File(fileLocationURL);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File destinationFile = new File(fileLocationURL + attachmentFileName);
                file.transferTo(destinationFile);

            }
//            if (attachmentFileName.equals("") && document1 != null && p < document1.length) {
//                attachmentFileName = document1[p];
//
//            }
            if (attachmentFileName != null
                    && attachmentFileName.isEmpty()
                    && document1 != null
                    && p < document1.length
                    && document1[p] != null) {

                attachmentFileName = document1[p];
            }

            aocFormAttachment.setAttachment(attachmentFileName);

            DocumentName documentName = documentNameService.readById(Integer.parseInt(id2[p]));

            aocFormAttachment.setAocForm(aocForm1);
            if (p < descriptions.length && descriptions[p] != null && !descriptions[p].equals("")) {
                aocFormAttachment.setDescription(descriptions[p]);
            }

//            if (descriptions[p] == null) {
//                aocFormAttachment.setDescription(descriptiones1[p]);
//
//            }
            if (descriptions[p] == null || descriptions[p].trim().equals("")) {
                aocFormAttachment.setDescription("");

            }

            aocFormAttachment.setDocumentName(documentName);

            AocFormAttachmentService.create(aocFormAttachment);
            p++;
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Aoc"
                + File.separator + id1;
        File f1 = new File(path);
        boolean bool = f1.mkdirs(); // Use mkdirs to ensure the full path is created
        //multi attachment
        List<MultipartFile> files1 = multipartRequest.getFiles("attach");
        String[] description = request.getParameterValues("descriptions");
        int a = 0;
        int id4 = 0;
        if (files1 != null && !files1.isEmpty() && description != null && description.length >= files1.size()) {
            for (MultipartFile file1 : files1) {
                if (!file1.isEmpty()) {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Aoc"
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

                    AocFormMultiAttachment aocFormMultiAttachment = new AocFormMultiAttachment();

                    aocFormMultiAttachment.setAttachment(file1.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    aocFormMultiAttachment.setDescription(description[a]);
                    aocFormMultiAttachment.setAocForm(aocForm1);

                    aocFormMultiAttachmentService.create(aocFormMultiAttachment);
                    id4 = aocFormMultiAttachment.getId();
                    a++;
                }
            }

        }

        AocFormApproval aocFormApproval5 = aocFormApprovalService.readByDeltecodes(id);

        int formid = aocFormApproval5.getId();

        List list44 = aocFormApprovalUserService.readByDleteCode(formid);
        for (Object o : list44) {
            AocFormApprovalUser oacAocFormApprovalUser = (AocFormApprovalUser) o;
            int id3 = oacAocFormApprovalUser.getId();
            aocFormApprovalUserService.delete(id3);
        }

        aocFormApprovalService.delete(formid);

// approval name drop down relted code
        List approval_list = oapMasterUserService.readByIdToList(approvalName);
        HttpSession session1 = request.getSession(false);
        UserMaster user = (UserMaster) session1.getAttribute("user");
        String username = user.getLoginName();
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        AocFormApproval aocFormApproval = new AocFormApproval();

        aocFormApproval.setAocForm(aocForm1);
        aocFormApproval.setTotalApproval(approval_list.size() + "");
        aocFormApproval.setApprovalStatus("0");
        aocFormApproval.setApprovalRemark("add");
        aocFormApproval.setUserId(employeeCode);
        aocFormApproval.setCurrentApproval("1");
        aocFormApprovalService.create(aocFormApproval);

        int approveId = aocFormApproval.getId();
        OapFormApproval oapFormApproval1 = oapFormApprovalService.readById(approveId);

        int j = 0;
        for (Object o : approval_list) {
            j++;
            OapMasterUser oap1 = (OapMasterUser) o;
            AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();
            aocFormApprovalUser.setAocFormApproval(approveId);
            aocFormApprovalUser.setAocForm(id1);
            aocFormApprovalUser.setUserId(oap1.getUserId());
            aocFormApprovalUser.setLevel("1");
            aocFormApprovalUser.setApprovalStatus("0");
            aocFormApprovalUserService.create(aocFormApprovalUser);

        }

        mv.getModelMap().put("id", id);
        session.setAttribute("successMessage", "Information: AocForm SaveAsDraft Submited successfully");
        mv.setViewName("redirect:aocForm.htm?act=aocFormAppovalList");
        return mv;
    }

    public ModelAndView aocTracker(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("Oap/aocTracker");
        return mv;
    }

    public ModelAndView KickOffFormRecycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String KickOffApproval = request.getParameter("id");
        String kickoffFormId = request.getParameter("kickoffFormId");

        String comment = request.getParameter("comment");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        KickOffForm kickOffForm = kickOffFormService.readById(Integer.parseInt(kickoffFormId));
        int aocid = kickOffForm.getAocForm().getId();

        KickOffFormApproval kickOffFormApproval = kickOffFormApprovalService.readBykickid(Integer.parseInt(kickoffFormId));

        KickOffFormApprovalUser kickOffFormApprovalUser = kickOffFormApprovalUserService.appvals(username, Integer.parseInt(kickoffFormId));

        int approveId = kickOffFormApprovalUser.getKickOffFormApproval();

        KickOffFormApprovalComment kickOffFormApprovalComment = kickOffFormApprovalCommentService.readByApproveId(approveId);

        String approvalStatus = kickOffFormApprovalUser.getApprovalStatus();

        if ("0".equals(approvalStatus)) {

            kickOffFormApproval.setCurrentApproval("0");
            kickOffFormApprovalUser.setApprovalStatus("8");
            kickOffFormApprovalComment.setApprovalStatus("8");//recycle
            kickOffForm.setFlagStatus(2);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            String employeeCode = employeeMaster.getEmployeeCode();

            kickOffFormApprovalComment.setUserId(employeeCode);
            kickOffFormApprovalComment.setKickOffFormApproval(kickOffFormApproval);
            kickOffFormApprovalComment.setApprovalComment(comment);
            kickOffFormApprovalComment.setApprovalStatus("8");
            kickOffFormApprovalCommentService.create(kickOffFormApprovalComment);

            kickOffFormApprovalService.update(kickOffFormApproval);
            kickOffFormApprovalUserService.update(kickOffFormApprovalUser);
            kickOffFormService.update(kickOffForm);

            java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String currentDateTime5 = formatter5.format(new java.util.Date());

            AocLogMaster aocLogMaster = new AocLogMaster();
            aocLogMaster.setActivity("KOM Approval");
            aocLogMaster.setActivityBy(username);
            aocLogMaster.setDate(currentDateTime5);
            aocLogMaster.setComments(comment);
            aocLogMaster.setStatus("Recycle");
            aocLogMaster.setAocId(aocid);
            aocLogMaster.setKomId(Integer.parseInt(kickoffFormId));
            aocLogMasterService.create(aocLogMaster);

            session.setAttribute("successMessage", " KOM Rework Done successfully");

        } else if ("1".equals(approvalStatus)) {
            session.setAttribute("failureMessage", " Already KOM Approved Successfully");

        } else if ("8".equals(approvalStatus)) {
            session.setAttribute("failureMessage", " Already KOM Rework Successfully");

        } else if ("3".equals(approvalStatus)) {
            session.setAttribute("failureMessage", " Already KOM Rejected Successfully");
        } else {
            session.setAttribute("failureMessage", "The KOM approval has already progressed to the next stage");
        }

        mv.setViewName("redirect:aocForm.htm?act=KickOffFormApprovalUser");

        return mv;
    }

//    public ModelAndView KickOffFormRecycleEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        String id = request.getParameter("id");
//         String aocid = request.getParameter("aocid");       
//         mv.getModelMap().put("aocid", aocid);
//        mv.getModelMap().put("id", id);
//         mv.setViewName("Oap/KickOffFormRecycleEdit");
//        return mv;
//    }
    public ModelAndView bifurcationOAPEthanWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String month = request.getParameter("month");
        String count = request.getParameter("count");
        String label = request.getParameter("label");
        String color = request.getParameter("color");

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
        String MonthName1 = request.getParameter("month");
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

        List bifurcationOAPEthanWise = oapFormService.oapEthanWiseClick(StartDate, EndDate, Filter, formattedDate, formattedStartDate, label, count, MonthName1);

        mv.getModelMap().put("OAPEthanWise", bifurcationOAPEthanWise);

        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("label", label);
        mv.getModelMap().put("color", color);

        mv.setViewName("Oap/bifurcationOAPEthanWise");
        return mv;
    }

    public ModelAndView bifurcationOAPEquatorWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String month = request.getParameter("month");
        String count = request.getParameter("count");
        String label = request.getParameter("label");
        String color = request.getParameter("color");

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
        String MonthName1 = request.getParameter("month");
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

//        List bifurcationOAPEthanWise = oapFormService.oapEquatorWiseClick(StartDate, EndDate, Filter, formattedDate, formattedStartDate, label, count,MonthName1);
//
//        mv.getModelMap().put("OAPEthanWise", bifurcationOAPEthanWise);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("label", label);
        mv.getModelMap().put("color", color);

        mv.setViewName("Oap/bifurcationOAPEquatorWise");
        return mv;
    }

    public ModelAndView bifurcationOAPHubWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String month = request.getParameter("month");
        String count = request.getParameter("count");
        String label = request.getParameter("label");
        String color = request.getParameter("color");

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
        String MonthName1 = request.getParameter("month");
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

//        List bifurcationOAPEthanWise = oapFormService.oapHubWiseClick(StartDate, EndDate, Filter, formattedDate, formattedStartDate, label, count,MonthName1);
//
//        mv.getModelMap().put("OAPEthanWise", bifurcationOAPEthanWise);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("label", label);
        mv.getModelMap().put("color", color);

        mv.setViewName("Oap/bifurcationOAPHubWise");
        return mv;
    }

    public ModelAndView bifurcationOAPCapexWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String month = request.getParameter("month");
        String count = request.getParameter("count");
        String label = request.getParameter("label");
        String color = request.getParameter("color");

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
        String MonthName1 = request.getParameter("month");
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

//        List bifurcationOAPEthanWise = oapFormService.oapCapexWiseClick(StartDate, EndDate, Filter, formattedDate, formattedStartDate, label, count,MonthName1);
//
//        mv.getModelMap().put("OAPEthanWise", bifurcationOAPEthanWise);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("label", label);
        mv.getModelMap().put("color", color);

        mv.setViewName("Oap/bifurcationOAPCapexWise");
        return mv;
    }

    public ModelAndView bifurcationAOCEthanWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String month = request.getParameter("month");
        String count = request.getParameter("count");
        String label = request.getParameter("label");
        String color = request.getParameter("color");

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
        String MonthName1 = request.getParameter("month");
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

//        List bifurcationOAPEthanWise = aocFormService.AOCEthanWiseClick(StartDate, EndDate, Filter, formattedDate, formattedStartDate, label, count,MonthName1);
//
//        mv.getModelMap().put("OAPEthanWise", bifurcationOAPEthanWise);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("label", label);
        mv.getModelMap().put("color", color);

        mv.setViewName("Oap/bifurcationAOCEthanWise");
        return mv;
    }

    public ModelAndView bifurcationAOCEquatorWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String month = request.getParameter("month");
        String count = request.getParameter("count");
        String label = request.getParameter("label");
        String color = request.getParameter("color");

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
        String MonthName1 = request.getParameter("month");
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

//        List bifurcationOAPEthanWise = aocFormService.AOCEquatorWiseClick(StartDate, EndDate, Filter, formattedDate, formattedStartDate, label, count,MonthName1);
//
//        mv.getModelMap().put("OAPEthanWise", bifurcationOAPEthanWise);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("label", label);
        mv.getModelMap().put("color", color);

        mv.setViewName("Oap/bifurcationAOCEquatorWise");
        return mv;
    }

    public ModelAndView bifurcationAOCHubWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String month = request.getParameter("month");
        String count = request.getParameter("count");
        String label = request.getParameter("label");
        String color = request.getParameter("color");

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
        String MonthName1 = request.getParameter("month");
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

//        List bifurcationOAPEthanWise = aocFormService.AOCEquatorWiseClick(StartDate, EndDate, Filter, formattedDate, formattedStartDate, label, count,MonthName1);
//
//        mv.getModelMap().put("OAPEthanWise", bifurcationOAPHubWise);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("label", label);
        mv.getModelMap().put("color", color);

        mv.setViewName("Oap/bifurcationAOCHubWise");
        return mv;
    }

    public ModelAndView bifurcationAOCCapexWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String month = request.getParameter("month");
        String count = request.getParameter("count");
        String label = request.getParameter("label");
        String color = request.getParameter("color");

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
        String MonthName1 = request.getParameter("month");
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

//        List bifurcationOAPEthanWise = aocFormService.AOCCapexWiseClick(StartDate, EndDate, Filter, formattedDate, formattedStartDate, label, count,MonthName1);
//
//        mv.getModelMap().put("OAPEthanWise", bifurcationOAPHubWise);
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("count", count);
        mv.getModelMap().put("label", label);
        mv.getModelMap().put("color", color);

        mv.setViewName("Oap/bifurcationAOCCapexWise");
        return mv;
    }

    public ModelAndView ChargerInstallationdelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ChargerInstaid = request.getParameter("id");
        String opaformId = request.getParameter("id1");
        OapForm oapForm = oapFormService.readById(Integer.parseInt(opaformId + ""));
        int flagStatus = oapForm.getFlagStatus();

        chargerInstallationDetailsService.delete(Integer.parseInt(ChargerInstaid));

        mv.getModelMap().put("ChargerInstaid", ChargerInstaid);
        mv.getModelMap().put("opaformId", opaformId);
        if (flagStatus == 14 || flagStatus == 2) {
            mv.setViewName("forward:oapForm.htm?act=oaprecycleEdit&id=" + opaformId);
        } else {
            mv.setViewName("forward:oapForm.htm?act=SaveAsDraftView&id=" + opaformId);
        }

        return mv;
    }

}

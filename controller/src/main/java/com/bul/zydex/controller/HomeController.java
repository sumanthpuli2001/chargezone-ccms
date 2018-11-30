/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.CorporateVideo;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeInformation;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.ThoughtMaster;
import com.bul.zydex.model.UserMaster;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
public class HomeController extends HomeAbstract {

    public ModelAndView openHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        Calendar cal6 = Calendar.getInstance();
        cal6.add(Calendar.DAY_OF_MONTH, -8);
        Date dateSet = cal6.getTime();

        DepartmentMaster departmentMaster = new DepartmentMaster();
        LevelMaster levelMaster = new LevelMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LocationMaster locationMaster = new LocationMaster();
//        employeeMaster.setUserMaster(user);

//        List<?> employeeList = employeeMasterService.readByUserName(employeeMaster);
//        if (!employeeList.isEmpty()) {
//            employeeMaster1 = (EmployeeMaster) employeeList.get(0);
//            departmentMaster = departmentMasterService.readById(employeeMaster1.getDepartmentMaster().getId());
//            employeeMaster1.setDepartmentMaster(departmentMaster);
//            levelMaster = levelMasterService.readById(employeeMaster1.getLevelMaster().getId());
//            employeeMaster1.setLevelMaster(levelMaster);
//            designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
//            employeeMaster1.setDesignationMaster(designationMaster);
//            locationMaster = locationMasterService.readById(employeeMaster1.getLocationMaster().getId());
//            employeeMaster1.setLocationMaster(locationMaster);
//
//        }
//        selectEmployee(request, response);
//        selectedEmployeeFor360Feedback(request, employeeMaster1);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String lastOldDate = sdf.format(dateSet);
        String CurrentDate = sdf.format(d);
        List<?> galleryList = galleryService.readgalleryDetail();
        List<?> RRList = rAndRService.readrandrDetail();
        List<EmployeeMaster> TodaysBirthdays = (List<EmployeeMaster>) employeeMasterService.readEmployeeByBirthday(CurrentDate);
        List<List<?>> BirthdayList = new ArrayList<>();
        //////////////////today birthdays image/////////////
        for (EmployeeMaster em : TodaysBirthdays) {

            List data = new ArrayList<>();
            String userName = em.getEmployeeId();
            String profilePicturePath = "";
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserProfile"
                    + File.separator + userName + File.separator;
            File profilePicture = new File(fileLocationURL);
            if (profilePicture.exists() && profilePicture.listFiles().length > 0) {
                File[] file = profilePicture.listFiles();
                profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + file[0].getName();
            } else {
                profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
            }
            data.add(em.getId());
            data.add(em.getEmployeeName());
            data.add(profilePicturePath);
            BirthdayList.add(data);
        }

        ThoughtMaster thoughtMaster = thoughtMasterService.readByCurrentDate(CurrentDate);
        List<EmployeeMaster> newJoiningList = (List<EmployeeMaster>) employeeMasterService.newJoiningEmployee(lastOldDate);

        List<List<?>> newjoineeList = new ArrayList<>();
        //////////////////New Joinee image/////////////
        for (EmployeeMaster em1 : newJoiningList) {

            List data = new ArrayList<>();
            String userName = em1.getEmployeeId();
            String profilePicturePath = "";
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserProfile"
                    + File.separator + userName + File.separator;
            File profilePicture = new File(fileLocationURL);
            if (profilePicture.exists() && profilePicture.listFiles().length > 0) {
                File[] file = profilePicture.listFiles();
                profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + file[0].getName();
            } else {
                profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
            }
            data.add(em1.getId());
            data.add(em1.getEmployeeName());
            data.add(profilePicturePath);
            newjoineeList.add(data);
        }

        List<CorporateVideo> l1 = (List<CorporateVideo>) corporateVideoService.readCorporateVideoDetail();
        request.setAttribute("videoList", l1);
        request.setAttribute("galleryList", galleryList);
        request.setAttribute("RRList", RRList);
        request.setAttribute("thoughtMaster", thoughtMaster);
        request.setAttribute("newJoiningList", newjoineeList);
        request.setAttribute("TodaysBirthdays", BirthdayList);
        mv.getModelMap().put("employeeMaster", employeeMaster1);
        mv.setViewName("Common/Home");
        return mv;
    }

//    public ModelAndView searchEmployeeDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        EmployeeMaster employeeMaster1 = new EmployeeMaster();
//        Calendar cal6 = Calendar.getInstance();
//        cal6.add(Calendar.DAY_OF_MONTH, -8);
//        Date dateSet = cal6.getTime();
//
//        DepartmentMaster departmentMaster = new DepartmentMaster();
//        LevelMaster levelMaster = new LevelMaster();
//        DesignationMaster designationMaster = new DesignationMaster();
//        LocationMaster locationMaster = new LocationMaster();
////        employeeMaster.setUserMaster(user);
//
////        List<?> employeeList = employeeMasterService.readByUserName(employeeMaster);
////        if (!employeeList.isEmpty()) {
////            employeeMaster1 = (EmployeeMaster) employeeList.get(0);
////            departmentMaster = departmentMasterService.readById(employeeMaster1.getDepartmentMaster().getId());
////            employeeMaster1.setDepartmentMaster(departmentMaster);
////            levelMaster = levelMasterService.readById(employeeMaster1.getLevelMaster().getId());
////            employeeMaster1.setLevelMaster(levelMaster);
////            designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
////            employeeMaster1.setDesignationMaster(designationMaster);
////            locationMaster = locationMasterService.readById(employeeMaster1.getLocationMaster().getId());
////            employeeMaster1.setLocationMaster(locationMaster);
////
////        }
//        selectEmployee(request, response);
////        selectedEmployeeFor360Feedback(request, employeeMaster1);
//
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        String lastOldDate = sdf.format(dateSet);
//        String CurrentDate = sdf.format(d);
//        List<?> galleryList = galleryService.read();
//        List<?> RRList = rAndRService.read();
//
//        ThoughtMaster thoughtMaster = thoughtMasterService.readByCurrentDate(CurrentDate);
//        List<?> newJoiningList = employeeMasterService.newJoiningEmployee(lastOldDate);
//
//        List<CorporateVideo> l1 = (List<CorporateVideo>) corporateVideoService.readCorporateVideoDetail();
//        request.setAttribute("videoList", l1);
//        request.setAttribute("galleryList", galleryList);
//        request.setAttribute("RRList", RRList);
//        request.setAttribute("thoughtMaster", thoughtMaster);
//        request.setAttribute("newJoiningList", newJoiningList);
//        request.setAttribute("TodaysBirthdays", BirthdayList);
//        mv.getModelMap().put("employeeMaster", employeeMaster1);
//        mv.setViewName("Common/Home");
//        return mv;
//    }
    public ModelAndView opanGallery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> galleryList = galleryService.readgalleryDetail();
        request.setAttribute("galleryList", galleryList);
        mv.setViewName("Common/Gallery");
        return mv;
    }

    public ModelAndView opanRR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> RRList = rAndRService.readrandrDetail();
        request.setAttribute("RRList", RRList);
        mv.setViewName("Common/RewardAndRecognition");
        return mv;
    }

    public ModelAndView kaizen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> kaizenlist = kaizenMasterService.readKaizenList();
        int inc = kaizenlist.size();
        int inc1 = inc + 1;
        request.setAttribute("randomNumber", inc1);
        mv.setViewName("Kaizen/Kaizen");
        return mv;
//        int index = 0;
//        int srNo = (index + 1);
//        Random random=new Random();   
//        int randomNumber=random.nextInt(10000000);
    }

    public ModelAndView report(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Common/reports");
        return mv;
    }

    public ModelAndView form5(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LocalDate date = LocalDate.now();
        int month1 = date.getMonthValue();
        int year = 0;
        String month = "";
        month = String.valueOf(month1 - 1);
        if (0 < (month1 - 1) && (month1 - 1) < 10) {
            month = "0" + month;
            year = date.getYear();
        }
        if ((month1 - 1) == 0) {
            month = "12";
            year = date.getYear() - 1;
        }
        List<?> list = employeeMasterService.readEmpLastMnth(("" + month), year);
        mv.getModelMap().put("list", list);
        mv.setViewName("Payroll/Form5");
        return mv;
    }

    public ModelAndView form10(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("Payroll/Form10");
        return mv;
    }

    public ModelAndView newJoineDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empid = request.getParameter("id");
        EmployeeMaster empDetail = employeeMasterService.readById(Integer.parseInt(empid));
        DepartmentMaster department = departmentMasterService.readById(empDetail.getDepartmentMaster().getId());
        DesignationMaster designation = designationMasterService.readById(empDetail.getDesignationMaster().getId());
//          String dName= department.getDepartmentName();
        List data = new ArrayList<>();
        String userName = empDetail.getEmployeeId();
        String profilePicturePath = "";
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userName + File.separator;
        File profilePicture = new File(fileLocationURL);
        if (profilePicture.exists() && profilePicture.listFiles().length > 0) {
            File[] file = profilePicture.listFiles();
            profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + file[0].getName();
        } else {
            profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
        }
        request.setAttribute("empDetail", empDetail);
        request.setAttribute("department", department);
        request.setAttribute("designation", designation);
        request.setAttribute("profilePicturePath", profilePicturePath);
        mv.setViewName("Common/JoineeDetail");
        return mv;
    }

    
    public ModelAndView redirectToAllReports(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HomeController homeController = new HomeController();
        ModelAndView mv = new ModelAndView();
        selectEmployee(request, response);
//        Map<Integer, List<Object>> empMap = new HashMap();
//        List<String> headerList = new ArrayList<String>();
//         List<?> policyMasterList = policyMasterService.read();
//        for (Object o1 : policyMasterList) {
//            PolicyMaster policyMaster = (PolicyMaster) o1;
//            headerList.add(policyMaster.getPolicyName());
//        }
//         request.setAttribute("headerList123", headerList);
        mv.setViewName("Common/EmployeeBySearchCriteria");
        mv.getModelMap().put("homeController", homeController);
        return mv;
    }

    public void setSearchCriteriaData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HomeController homeController = new HomeController();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        String category = request.getParameter("category");
        
        if (category.isEmpty() && category.equals("")) {
            request.setAttribute("faliureMessage",
                    "Error : Select Category to get Result.");
        } 
        else if (category.equals("employee")) {
            DepartmentMaster departmentMaster = new DepartmentMaster();
            DesignationMaster designationMaster = new DesignationMaster();
            LocationMaster locationMaster = new LocationMaster();
            List<?> depttList = departmentMasterService.read();
            Map<Integer, String> dm = new HashMap<>();
            for (Object o : depttList) {
                departmentMaster = (DepartmentMaster) o;
                dm.put(departmentMaster.getId(), departmentMaster.getDepartmentName());
            }
            List<?> desigList = designationMasterService.read();
            Map<Integer, String> dn = new HashMap<>();
            for (Object o : desigList) {
                designationMaster = (DesignationMaster) o;
                dn.put(designationMaster.getId(), designationMaster.getDesignationName());
            }
            List<?> locationList = locationMasterService.read();
            Map<Integer, String> zm = new HashMap<>();
            for (Object o : locationList) {
                locationMaster = (LocationMaster) o;
                zm.put(locationMaster.getId(), locationMaster.getLocation());
            }
            
            Gson gson = new Gson();
            JsonElement jElement = gson.toJsonTree(dn);
            JSONObject jObject = new JSONObject();
            jObject.put("designationKey", dn);
            jObject.put("departmentKey", dm);
            jObject.put("locationKey", zm);
            PrintWriter out = response.getWriter();
            out.println(jObject.toString());
        }
    }
    
    public void onSearchClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
//        ModelAndView mv = new ModelAndView();
        
//        HomeController homeController = new HomeController();
        EmployeeInformation employeeInformation = new EmployeeInformation();
        
        List<String> headerList = new ArrayList<String>();
        String employeeId = request.getParameter("employeeId");
        if(null != employeeId){
            employeeInformation.setEmployeeId(Boolean.TRUE);
            headerList.add("Employee Code");
        }
        
        String employeeName = request.getParameter("employeeName");
        if(null != employeeName){
            employeeInformation.setEmployeeName(Boolean.TRUE);
            headerList.add("Employee Name");
        }
        
        String dateOfJoining = request.getParameter("dateOfJoining");
        if(null != dateOfJoining){
            employeeInformation.setDateOfJoining(Boolean.TRUE);
            headerList.add("Joining Date");
        }
        
        String role = request.getParameter("role");
        if(null != role){
            employeeInformation.setRole(Boolean.TRUE);
            headerList.add("Role");
        }
        
        String company = request.getParameter("company");
        if(null != company){
            employeeInformation.setCompany(Boolean.TRUE);
            headerList.add("Company");
        }
        
        String emailAddress = request.getParameter("emailAddress");
        if(null != emailAddress){
            employeeInformation.setEmailAddress(Boolean.TRUE);
            headerList.add("Email Address");
        }
        
        String contactNo1 = request.getParameter("contactNo1");
        if(null != contactNo1){
            employeeInformation.setContactNo1(Boolean.TRUE);
            headerList.add("Contact No1");
        }
        
        String contactNo2 = request.getParameter("contactNo2");
        if(null != contactNo2){
            employeeInformation.setContactNo2(Boolean.TRUE);
            headerList.add("Contact No2");
        }
        
        String fatherName = request.getParameter("fatherName");
        if(null != fatherName){
            employeeInformation.setFatherName(Boolean.TRUE);
            headerList.add("Father Name");
        }
        
        String motherName = request.getParameter("motherName");
        if(null != motherName){
            employeeInformation.setMotherName(Boolean.TRUE);
            headerList.add("Mother Name");
        }
        
        String dateOfBirth = request.getParameter("dateOfBirth");
        if(null != dateOfBirth){
            employeeInformation.setDateOfBirth(Boolean.TRUE);
            headerList.add("DOB");
        }
        
        String gender = request.getParameter("gender");
        if(null != gender){
            employeeInformation.setGender(Boolean.TRUE);
            headerList.add("Gender");
        }
        
        String bloodGroups = request.getParameter("bloodGroups");
        if(null != bloodGroups){
            employeeInformation.setBloodGroups(Boolean.TRUE);
            headerList.add("Blood Group");
        }
        
        String maritalStatus = request.getParameter("maritalStatus");
        if(null != maritalStatus){
            employeeInformation.setMaritalStatus(Boolean.TRUE);
            headerList.add("Marital Status");
        }
        
        String spouseName = request.getParameter("spouseName");
        if(null != spouseName){
            employeeInformation.setSpouseName(Boolean.TRUE);
            headerList.add("Spous/Husband Name");
        }
        
        String emergencyContactPerson = request.getParameter("emergencyContactPerson");
        if(null != emergencyContactPerson){
            employeeInformation.setEmergencyContactPerson(Boolean.TRUE);
            headerList.add("Emergency Contact Person");
        }
        
        String emergencyContactNo = request.getParameter("emergencyContactNo");
        if(null != emergencyContactNo){
            employeeInformation.setEmergencyContactNo(Boolean.TRUE);
            headerList.add("Emergency Contact No");
        }
        
        String panCard = request.getParameter("panCard");
        if(null != panCard){
            employeeInformation.setPanCard(Boolean.TRUE);
            headerList.add("Pan Card");
        }
        
        String adharCard = request.getParameter("adharCard");
        if(null != adharCard){
            employeeInformation.setAdharCard(Boolean.TRUE);
            headerList.add("Adhar Card");
        }
                
        String passportNo = request.getParameter("passportNo");
        if(null != passportNo){
            employeeInformation.setPassportNo(Boolean.TRUE);
            headerList.add("Passport No");
        }
        
        String passportIssueDate = request.getParameter("passportIssueDate");
        if(null != passportIssueDate){
            employeeInformation.setPassportIssueDate(Boolean.TRUE);
            headerList.add("Passport Issue Date");
        }
       
        String passportExpiryDate = request.getParameter("passportExpiryDate");
        if(null != passportExpiryDate){
            employeeInformation.setPassportExpiryDate(Boolean.TRUE);
            headerList.add("Passport Expiry Date");
        }
        
        String employeeType = request.getParameter("employeeType");
        if(null != employeeType){
            employeeInformation.setEmployeeType(Boolean.TRUE);
            headerList.add("Employee Type");
        }
        
        String officeEmailId = request.getParameter("officeEmailId");
        if(null != officeEmailId){
            employeeInformation.setOfficeEmailId(Boolean.TRUE);
            headerList.add("Office Email Id");
        }
        
         String experienceYearOnDoj = request.getParameter("experienceYearOnDoj");
        if(null != experienceYearOnDoj){
            employeeInformation.setExperienceYearOnDoj(Boolean.TRUE);
            headerList.add("Experience Year On Joining");
        }
        
        String experienceMonthOnDoj = request.getParameter("experienceMonthOnDoj");
        if(null != experienceMonthOnDoj){
            employeeInformation.setExperienceMonthOnDoj(Boolean.TRUE);
            headerList.add("Experience Month On Joining");
        }
        
        String permanentAddress = request.getParameter("permanentAddress");
        if(null != permanentAddress){
            employeeInformation.setPermanentAddress(Boolean.TRUE);
            headerList.add("Permanent Address");
        }
        
        String presentAddress = request.getParameter("presentAddress");
        if(null != presentAddress){
            employeeInformation.setPresentAddress(Boolean.TRUE);
            headerList.add("Present Address");
        }
        
        //-- marital status other will be checked below from here if needed--
         
        
        String bankName = request.getParameter("bankName");
        if(null != bankName){
            employeeInformation.setBankName(Boolean.TRUE);
            headerList.add("Bank Name");
        }
        
        String bankAccountNo = request.getParameter("bankAccountNo");
        if(null != bankAccountNo){
            employeeInformation.setBankAccountNo(Boolean.TRUE);
            headerList.add("Bank A/c No");
        }
        
        String bankIfscCode = request.getParameter("bankIfscCode");
        if(null != bankIfscCode){
            employeeInformation.setBankIfscCode(Boolean.TRUE);
            headerList.add("Bank IFSC");
        }    
        
        String zydexLocation = request.getParameter("zydexLocation");
        if(null != zydexLocation){
            employeeInformation.setZydexLocation(Boolean.TRUE);
            headerList.add("Location");
        }
        
        String workLocation = request.getParameter("workLocation");
        if(null != workLocation){
            employeeInformation.setWorkLocation(Boolean.TRUE);
            headerList.add("Work Location");
        }        
                
        String level = request.getParameter("level");
        if(null != level){
            employeeInformation.setLevel(Boolean.TRUE);
            headerList.add("Level");
        }
        
        String department = request.getParameter("department");
        if(null != department){
            employeeInformation.setDepartment(Boolean.TRUE);
            headerList.add("Department");
        }
       
        String designation = request.getParameter("designation");
        if(null != designation){
            employeeInformation.setDesignation(Boolean.TRUE);
            headerList.add("Designation");
        }
        
        String reportingManager = request.getParameter("reportingManager");
        if(null != reportingManager){
            employeeInformation.setReportingManager(Boolean.TRUE);
            headerList.add("Reporting Manager");
        }
        
        String highestEducationDetails = request.getParameter("highestEducationDetails");
        if(null != highestEducationDetails){
            employeeInformation.setHighestEducationDetails(Boolean.TRUE);
            headerList.add("Highest Education");
        }
               
        String cityOfEmployee = request.getParameter("cityOfEmployee");
        if(null != cityOfEmployee){
            employeeInformation.setCityOfEmployee(Boolean.TRUE);
            headerList.add("Employee City");
        }
        
        
        String child1 = request.getParameter("child1");
        if(null != child1){
            employeeInformation.setChild1(Boolean.TRUE);
            headerList.add("Child Name");
        }
        
        String child2 = request.getParameter("child2");
        if(null != child2){
            employeeInformation.setChild2(Boolean.TRUE);
            headerList.add("Child Name 2");
        }
        
        String dateOfBirthOfEmpFather = request.getParameter("dateOfBirthOfEmpFather");
        if(null != dateOfBirthOfEmpFather){
            employeeInformation.setDateOfBirthOfEmpFather(Boolean.TRUE);
            headerList.add("DOB of Father");
        }
        
        String dateOfBirthOfEmpMother = request.getParameter("dateOfBirthOfEmpMother");
        if(null != dateOfBirthOfEmpMother){
            employeeInformation.setDateOfBirthOfEmpMother(Boolean.TRUE);
            headerList.add("DOB of Mother");
        }
        
        String dateOfBirthOfEmpSpous = request.getParameter("dateOfBirthOfEmpSpous");
        if(null != dateOfBirthOfEmpSpous){
            employeeInformation.setDateOfBirthOfEmpSpous(Boolean.TRUE);
            headerList.add("DOB of Spous/Husband");
        }
        
        String dateOfBirthOfEmpChilld1 = request.getParameter("dateOfBirthOfEmpChilld1");
        if(null != dateOfBirthOfEmpChilld1){
            employeeInformation.setDateOfBirthOfEmpChilld1(Boolean.TRUE);
            headerList.add("DOB of Child1");
        }
        
        String dateOfBirthOfEmpChilld2 = request.getParameter("dateOfBirthOfEmpChilld2");
        if(null != dateOfBirthOfEmpChilld2){
            employeeInformation.setDateOfBirthOfEmpChild2(Boolean.TRUE);
            headerList.add("DOB of Child2");
        }
        
        String dateOfTransferOfEntity = request.getParameter("dateOfTransferOfEntity");
        if(null != dateOfTransferOfEntity){
            employeeInformation.setDateOfTransferOfEntity(Boolean.TRUE);
            headerList.add("Date Of Transfer Entity");
        }
        
        String dateOfLeaving = request.getParameter("dateOfLeaving");
        if(null != dateOfLeaving){
            employeeInformation.setDateOfLeaving(Boolean.TRUE);
            headerList.add("Date Of Leaving");
        }
        String basic = request.getParameter("basicSalary");
        if(null != basic){
            employeeInformation.setBasicSalary(Boolean.TRUE);
            headerList.add("Basic Salary");
        }
//        String allowance = request.getParameter("allowance");
//        if(null != allowance){
//            employeeInformation.setAllowance(Boolean.TRUE);
//            headerList.add(allowance);
//        }
//        String ctc = request.getParameter("ctc");
//        if(null != ctc){
//            employeeInformation.setCtc(Boolean.TRUE);
//            headerList.add(ctc);
//        }
        
        //input criteria from here
        String employeeCode = request.getParameter("employeeCode");
        if(employeeCode != null && !employeeCode.equals("")){
            employeeInformation.setEmployeeCode(employeeCode);
        }

        String employeeMasterName = request.getParameter("employeeMasterId");
        if(employeeMasterName != null && !employeeMasterName.equals("")){
            employeeInformation.setEmployeeMasterName(employeeMasterName);
        }
        
        String joiningStartDate = request.getParameter("joiningStartDate");
        String joiningEndDate = request.getParameter("joiningEndDate");
        if((null != joiningStartDate && !joiningStartDate.equals("")) && (null != joiningEndDate && !joiningEndDate.equals(""))){
            employeeInformation.setDojStartDate(joiningStartDate);
            employeeInformation.setDojEndDate(joiningEndDate);
        }
        
        String exitStartDate = request.getParameter("exitStartDate");
        String exitEndDate = request.getParameter("exitEndDate");
        if((exitStartDate != null && !exitStartDate.equals("")) && (null != exitEndDate && !exitEndDate.equals(""))){
            employeeInformation.setDolStartDate(exitStartDate);
            employeeInformation.setDolEndDate(exitEndDate);
        }
        
        String locationDropDown = request.getParameter("locationDropDown");
        if(locationDropDown != null && !locationDropDown.equals("")){
            employeeInformation.setWorkLocationId(locationDropDown);
        }
        
        String departmentDropDown = request.getParameter("departmentDropDown");
        if(departmentDropDown != null && !departmentDropDown.equals("")){
            employeeInformation.setDepartmentId(departmentDropDown);
        }
        
        String designationDropDown = request.getParameter("designationDropDown");
        if(designationDropDown != null && !designationDropDown.equals("")){
            employeeInformation.setDesignationId(designationDropDown);
        }
        
        
        List<?> employeeList = employeeMasterService.getEmployeeDetails(employeeInformation);
        
        JSONObject jObject = new JSONObject();
        jObject.put("employeeList", employeeList);
        jObject.put("headerList", headerList);
        PrintWriter out = response.getWriter();
        out.println(jObject.toString());

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import static com.bul.zydex.controller.UserMasterAbstract.HOME_PAGE;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.ProbationToConfirmation;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.util.CallingCounter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
public class UserMasterController extends UserMasterAbstract {

    public ModelAndView userDashboard(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        setRightsAndDataLists(request, session, user);
//        if (null != user.getEmployeeMasters()) {
//            addUserPersonals(request, user);
//            addUserRight(request, user);
//        }
//        All Other Code Is Transfered To Method:"setRightsAndDataLists(request, session, user)"
//        For Provide Rights On NavBar.jsp And Use On Both(Hr And User) DashBoard And Add Rights Data On Session.
        mv.setViewName("forward:leaveEmployeeDetail.htm?act=userDashboard");
        return mv;
    }

//This method is created for forwarding to dashboard based on rights(e.g...user,hr....etc..).
    public ModelAndView goToDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rightsAndDataListsCallingCounter = "";
        Integer setCallingCounterOfSessionAttributes = 0;//this counter will check method is called first time or second time.
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        CallingCounter callingCounter = new CallingCounter(setCallingCounterOfSessionAttributes);//setting that it is first time.
        if (session.getAttribute("timesGoToDashboardCalled") == null) {
            if (null != user.getEmployeeMasters()) {
                addUserPersonals(request, user);
                addUserRight(request, user);
                addemployeeExit(request, user);
                showUserImage(request, session, user);//this method adds userprofile image on dashbord.
            }
            callingCounter.increment();
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " is first time visited!");
            session.setAttribute("timesGoToDashboardCalled", callingCounter.getCounter());
            rightsAndDataListsCallingCounter = "firstTime";
        } else {

            callingCounter.increment();
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " is" + callingCounter.getCounter() + " times visited!");
            session.setAttribute("timesGoToDashboardCalled", callingCounter.getCounter());
        }
//        rightsAndDataListsCallingCounter = callingCounter.getCounter();//number of times request for dashboard.
        setRightsAndDataLists(request, session, user, rightsAndDataListsCallingCounter);
        UserRightMaster userRightMaster = (UserRightMaster) session.getAttribute("userRight");
        if (userRightMaster.isHr()) {
            mv = hrDashboard(request, response);
        }
        if (!userRightMaster.isHr()) {
            mv = userDashboard(request, response);
        }
        return mv;
    }

    public ModelAndView userDashboardShow(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        //this request is gets modified because in empChart method in EmployeeMaster Controller modifies it and
        // at user dashboard we requires reporting manager name but not id so we sets employeeName again here.
        HttpSession session = request.getSession(false);
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getAttribute("employeeMaster");
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        int id = employeeMaster1.getLevelMaster().getId();
        LevelMaster levelMaster = new LevelMaster();
        levelMaster = levelMasterService.readById(id);
        try {
            EmployeeMaster employeeMaster2 = employeeMasterService.readById(Integer.parseInt("" + employeeMaster1.getReportingManagerLevel1()));
            employeeMaster.setReportingManagerLevel1(employeeMaster2.getEmployeeName());

        } catch (NullPointerException ne) {
        } catch (NumberFormatException nfe) {
        }
        session.setAttribute("level", levelMaster.getLevel());
        mv.setViewName(HOME_PAGE);
        return mv;
    }

//This Method forwards request on different methods for fetch data and
//    Display various charts on HrDashboard and Name is given same "hrDashboard" as
//    request frowarded on ecah page provided.
    public ModelAndView hrDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster userMaster = new UserMaster();
        userMaster = (UserMaster) request.getSession().getAttribute("user");
        mv.setViewName("forward:departmentMaster.htm?act=hrDashboard");
        return mv;
    }

//after traversing all forwarding request finally hr dashboard will be shown.
    public ModelAndView hrDashboardShow(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(HOME_PAGE_2);
        return mv;
    }

//setting different List and rights for all Dashboards
    private void setRightsAndDataLists(HttpServletRequest request, HttpSession session, UserMaster user, final String rightsAndDataListsCallingCounter) throws Exception {

//        Integer setCallingCounterOfSessionAttributes = 0;//this counter will check method is called first time or second time.
        int id = 0;

//        addemployeeExit(request, user);
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        employeeMaster2.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster2);
        if (!empId.isEmpty()) {
            employeeMaster2 = (EmployeeMaster) empId.get(0);
            id = employeeMaster2.getId();
        }
        int exitcount = 0;
        List<?> finalList = new ArrayList<Object>();
        List<?> noDueList = new ArrayList<Object>();
        List<?> resigApprovalList = new ArrayList<Object>();
//        List<List<?>> finalList = new ArrayList<>();
        List<?> list = appraisal360Service.readEmployeeAppraisalFeedback(id);
        int appraisalcount = list.size();
//        int i = appraisal360Service.countEmployeeAppraisalFeedback(id);
        
        List<?> list1 = exitInterviewMasterService.readByEmployeeId(id);
        if (!list1.isEmpty()) {
            String dateOfSubmit = "";
            for (Object o : list1) {
                Object[] o1 = (Object[]) o;
                String abc = "" + o1[0];
                String abc1 = "" + o1[1];
                String abc2 = "" + o1[2];
                dateOfSubmit = "" + o1[3];
                int tabId = Integer.parseInt("" + o1[4]);
                finalList = exitInterviewMasterService.readExitApprovalList(id, tabId);
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                Date date = sdf.parse(dateOfSubmit);
//                Date today = Calendar.getInstance().getTime();
//                Calendar c = Calendar.getInstance();
//                c.setTime(date); // Now use today date.
//                c.add(Calendar.DATE, 15);
//                Date output = c.getTime();

//                if (output.after(today)) {
//                    System.out.println("Date1 is after Date2");
//                    exitList = exitInterviewMasterService.readExitApprovalList(id, tabId);
//                }
//
//                if (output.before(today)) {
//                    System.out.println("Date1 is before Date2");
//                    exitList = exitInterviewMasterService.readExitApproval2List(id, tabId);
//                }
//
//                if (output.equals(today)) {
//                    System.out.println("Date1 is equal Date2");
//                    exitList = exitInterviewMasterService.readExitApprovalList(id, tabId);
//                }
//                if (exitList.size() > 0) {
//                    finalList.add(exitList);
//                }
            }
        }
        exitcount = finalList.size();
        List<?> hrList = userRightMasterService.readHRList();
        for (Object o : hrList) {
            Object[] sample = (Object[]) o;
            int hrId = Integer.parseInt("" + sample[0]);
            if (hrId == id) {
                noDueList = noDueMasterService.readNoDueApprovalList();
//                resigApprovalList = resignationMasterService.readApprovalList();
            }
        }

        List<?> returnNoDueList = noDueMasterService.readNoDueReturnList(id);
        List<?> returnExitList = exitInterviewMasterService.readExitReturnList(id);

        List<?> resignationlist = resignationMasterService.readByEmpID(id);

        List<?> existingResignationlist = resignationMasterService.readExistingList(id);
        List<?> existingExitlist = exitInterviewMasterService.readExistingEmp(id);
        List<?> existingnoduelist = noDueMasterService.readExistingemployee(id);

        List<?> resignationManagerlist = resignationMasterService.readmanager1(id);
        List<?> reportingManagerList = employeeMasterService.readForAprove(id);
        List<?> reportingManager4List = employeeMasterService.readEmployeeForParticularManager(id);
        List<?> probationEmployee = probationToConfirmationService.readloginEmployeeData(id);
        List<?> FunctionalheadList = employeeMasterService.readfunctionalhead(id);
        if(FunctionalheadList.isEmpty()){
            FunctionalheadList =  employeeMasterService.readLevel1AndLevel5FunctionheadByEmployeeMasterId(id);
        }
        List<?> probationtypeList = employeeMasterService.readForEmployeeType(id);
        List<Object> finalprobationList = new ArrayList<>();
        if (!probationtypeList.isEmpty()) {
            for (Object o : probationtypeList) {
                  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
                 String today = sdf.format(new Date());
                        Date tDate = sdf.parse(today);
                EmployeeMaster employeeMaster3 = new EmployeeMaster();
                employeeMaster3 = (EmployeeMaster) o;
                  String employeeId = employeeMaster3.getId().toString();
                ProbationToConfirmation ptc1 = new ProbationToConfirmation();
                ptc1.setEmployeeMasterByEmployeeMasterId(employeeMaster3);
                List<?> listrepeat = probationToConfirmationService.readForRepeatedId(ptc1);
                if (!listrepeat.isEmpty()) {
                      ProbationToConfirmation ptc2 = new ProbationToConfirmation();
                       ptc2 = (ProbationToConfirmation) listrepeat.get(0);
                       String assessmentToDatestring = ptc2.getAssessmentToDate();
                       
                        Date assessmentToDate = sdf.parse(assessmentToDatestring);
                        Calendar c = Calendar.getInstance();
                        c.setTime(assessmentToDate);
                        c.add(Calendar.MONTH, -1);
                        Date datebefore1 = c.getTime();
                        if (DateUtils.isSameDay(tDate, datebefore1) || tDate.after(datebefore1)) {
                    List<?> probationList = employeeMasterService.readForProbation(employeeMaster3);

                    if (!probationList.isEmpty() || probationList.size() > 0) {
                        finalprobationList.add(probationList);
                    }
                }
                }else{
                 
                String dojstring = employeeMaster3.getDateOfJoining();
                Date dojdate=null;
                try{
                 dojdate = sdf.parse(dojstring);
                 } catch(Exception e){
                 dojdate = sdf1.parse(dojstring);
                }
                Calendar c = Calendar.getInstance();
                c.setTime(dojdate);
//                c.add(Calendar.DATE, 165);
                c.add(Calendar.MONTH, 5);
                Date dateAfter5month = c.getTime();
                String checkdateString = sdf.format(dateAfter5month);
                if (DateUtils.isSameDay(tDate, dateAfter5month) || tDate.after(dateAfter5month)) {
                    List<?> probationList = employeeMasterService.readForProbation(employeeMaster3);

                    if (!probationList.isEmpty() || probationList.size() > 0) {
                        finalprobationList.add(probationList);
                    }
                }
                
            }
        }
        }

        HttpSession session1 = request.getSession(false);
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session1.getAttribute("employeeInfo");
        

//        HttpSession session = request.getSession();
//        session.setAttribute("FunctionalheadList", FunctionalheadList);
//        session.setAttribute("finalprobationList", finalprobationList);
//        session.setAttribute("reportingManagerList", reportingManagerList);
        boolean managerFlag = true;
        if (!employeeMaster1.getReportingManagerLevel1().equals("") && employeeMaster1.getReportingManagerLevel1() != null) {
            managerFlag = true;
        } else {
            managerFlag = false;
        }
        session1.setAttribute("checkReportingManager", managerFlag);
        request.setAttribute("noDueList", noDueList);
        request.setAttribute("finalList", finalList);
        request.setAttribute("exitcount", exitcount);
        request.setAttribute("appraisalcount", appraisalcount);
        request.setAttribute("returnExitList", returnExitList);
        request.setAttribute("returnNoDueList", returnNoDueList);
        request.setAttribute("resignationlist", resignationlist);
        request.setAttribute("resigApprovalList", resigApprovalList);
        request.setAttribute("resignationManagerlist", resignationManagerlist);
        request.setAttribute("existinglist", existingResignationlist);
        request.setAttribute("existingExitlist", existingExitlist);
        request.setAttribute("existingnoduelist", existingnoduelist);
        request.setAttribute("list", list);

//        Now Set Data For Rights Management On Session.
//        CallingCounter callingCounter = new CallingCounter(setCallingCounterOfSessionAttributes);//setting that it is first time.
        if ("firstTime".equals(rightsAndDataListsCallingCounter)) {
//Because String is immutable and every time on goToDashboard rightsAndDataListsCallingCounter will be set to empty or null byDefault.
            session.setAttribute("isReportingManagerDataExist", !reportingManagerList.isEmpty());
            session.setAttribute("isManagertilllevel4DataExist", !reportingManager4List.isEmpty());
            session.setAttribute("isFinalprobationDataExist", !finalprobationList.isEmpty());
            session.setAttribute("isFunctionalheadDataExist", !FunctionalheadList.isEmpty());
            session.setAttribute("isResignationManagerDataExist", !resignationManagerlist.isEmpty());
            session.setAttribute("isExistingResignationDataExist", !existingResignationlist.isEmpty());
            session.setAttribute("isExistingExitDataExist", !existingExitlist.isEmpty());
            session.setAttribute("isExistingNoDueDataExist", !existingnoduelist.isEmpty());
            session.setAttribute("isProbationEmployee", !probationEmployee.isEmpty());
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.CurrencyMaster;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.MailMaster;
import com.bul.zydex.model.SmsMaster;
import com.bul.zydex.model.UserActivityLog;
import com.bul.zydex.model.UserLoginLog;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.CurrencyMasterService;
import com.bul.zydex.service.EmailAddMasterService;
import com.bul.zydex.service.EmailTemplateService;
import com.bul.zydex.service.MailMasterService;
import com.bul.zydex.service.SmsMasterService;
import com.bul.zydex.service.UserActivityLogService;
import com.bul.zydex.service.UserLoginLogService;
import com.bul.zydex.service.UserMasterService;
import com.bul.zydex.service.emp.DepartmentMasterService;
import com.bul.zydex.service.emp.DesignationMasterService;
import com.bul.zydex.service.emp.EmployeeMasterService;
import com.bul.zydex.service.zydexLocation.ZydexLocationMasterService;
import com.bul.zydex.util.SendMail;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


/**
 *
 * @author Administrator
 */
public abstract class CustomAbstract extends MultiActionController {

    private UserActivityLogService<UserActivityLog> userActivityLogService;
    private UserLoginLogService<UserLoginLog> userLoginLogService;
    protected UserMasterService<UserMaster> userMasterService;
    protected EmployeeMasterService<EmployeeMaster> employeeMasterService;
    protected DepartmentMasterService<DepartmentMaster> departmentMasterService;
    protected DesignationMasterService<DesignationMaster> designationMasterService;
    protected MailMasterService<MailMaster> mailMasterService;
    protected SmsMasterService<SmsMaster> smsMasterService;
    protected CurrencyMasterService<CurrencyMaster> currencyMasterService;
    protected DateFormat dateFormat = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm");
    protected  ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService;
     protected EmailTemplateService<EmailTemplate> emailTemplateService;
    protected SendMail sendMail;
    protected  EmailAddMasterService<EmailAddMaster> emailAddMasterService;

    public EmailTemplateService<EmailTemplate> getEmailTemplateService() {
        return emailTemplateService; 
    }

    public void setEmailTemplateService(EmailTemplateService<EmailTemplate> emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }

    public SendMail getSendMail() {
        return sendMail;
    }

    public void setSendMail(SendMail sendMail) {
        this.sendMail = sendMail;
    }
    

    public ZydexLocationMasterService<ZydexLocationMaster> getZydexLocationMasterService() {
        return zydexLocationMasterService;
    }

    public void setZydexLocationMasterService(ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService) {
        this.zydexLocationMasterService = zydexLocationMasterService;
    }
    

    public UserActivityLogService<UserActivityLog> getUserActivityLogService() {
        return userActivityLogService;
    }

    public void setUserActivityLogService(UserActivityLogService<UserActivityLog> userActivityLogService) {
        this.userActivityLogService = userActivityLogService;
    }

    public UserLoginLogService<UserLoginLog> getUserLoginLogService() {
        return userLoginLogService;
    }

    public void setUserLoginLogService(UserLoginLogService<UserLoginLog> userLoginLogService) {
        this.userLoginLogService = userLoginLogService;
    }

    public UserMasterService<UserMaster> getUserMasterService() {
        return userMasterService;
    }

    public void setUserMasterService(UserMasterService<UserMaster> userMasterService) {
        this.userMasterService = userMasterService;
    }

    public EmployeeMasterService<EmployeeMaster> getEmployeeMasterService() {
        return employeeMasterService;
    }

    public void setEmployeeMasterService(EmployeeMasterService<EmployeeMaster> employeeMasterService) {
        this.employeeMasterService = employeeMasterService;
    }

    public SimpleDateFormat getSimpleDateFormatObject(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public DepartmentMasterService<DepartmentMaster> getDepartmentMasterService() {
        return departmentMasterService;
    }

    public void setDepartmentMasterService(DepartmentMasterService<DepartmentMaster> departmentMasterService) {
        this.departmentMasterService = departmentMasterService;
    }

    public DesignationMasterService<DesignationMaster> getDesignationMasterService() {
        return designationMasterService;
    }

    public void setDesignationMasterService(DesignationMasterService<DesignationMaster> designationMasterService) {
        this.designationMasterService = designationMasterService;
    }

    public MailMasterService<MailMaster> getMailMasterService() {
        return mailMasterService;
    }

    public void setMailMasterService(MailMasterService<MailMaster> mailMasterService) {
        this.mailMasterService = mailMasterService;
    }

    public SmsMasterService<SmsMaster> getSmsMasterService() {
        return smsMasterService;
    }

    public void setSmsMasterService(SmsMasterService<SmsMaster> smsMasterService) {
        this.smsMasterService = smsMasterService;
    }

    public CurrencyMasterService<CurrencyMaster> getCurrencyMasterService() {
        return currencyMasterService;
    }

    public void setCurrencyMasterService(CurrencyMasterService<CurrencyMaster> currencyMasterService) {
        this.currencyMasterService = currencyMasterService;
    }


    @Override
    protected void bind(HttpServletRequest request, Object command)
            throws Exception {
        ServletRequestDataBinder binder = createBinder(request, command);
        binder.bind(request);
    }

    protected void log(HttpServletRequest request, String action, String disc) {

        UserActivityLog userActivityLog = new UserActivityLog();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");

        userActivityLog.setUserMaster(user);
        userActivityLog.setIpAddress(request.getRemoteAddr());
        userActivityLog.setDateTime(new SimpleDateFormat("MM/dd/yyyy HH:mm")
                .format(new Date()));
        userActivityLog.setActionType(action);
        userActivityLog.setActionDescription(disc);

        userActivityLogService.create(userActivityLog);
        switch (action) {
            case "Login": {
                UserLoginLog userLoginLog = new UserLoginLog();
                userLoginLog.setUserActivityLogByStart(userActivityLog);
                userLoginLogService.create(userLoginLog);
                session.setAttribute("userLoginLogId", userLoginLog.getId());
                session.setAttribute("userLoginLogStart",
                        userActivityLog.getDateTime());
                break;
            }
            case "Logout": {
                UserLoginLog userLoginLog = userLoginLogService
                        .readById((Integer) session.getAttribute("userLoginLogId"));
                userLoginLog.setUserActivityLogByEnd(userActivityLog);
                userLoginLogService.update(userLoginLog);
                session.setAttribute("userLoginLogEnd",
                        userActivityLog.getDateTime());
                break;
            }
        }

    }

    public void selectEmployee(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = employeeMasterService.readForAliveEmployeesNew();
        String tempStr = "[";
        Object[] arrayOfObject;

        EmployeeMaster employeeMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3]+ "\"}";
//                    + "  /" + arrayOfObject[4]
//                    + "  /" + arrayOfObject[5] 

        }
        tempStr += "]";

        request.setAttribute("list", tempStr);
    }

    protected void departmentList(HttpServletRequest request) {
        DepartmentMaster departmentMaster = new DepartmentMaster();
        List<?> depttList = departmentMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : depttList) {
            departmentMaster = (DepartmentMaster) o;
            dm.put(departmentMaster.getId(), departmentMaster.getDepartmentName());
        }

        request.setAttribute("deptMap", dm);
    }
    protected void zydexLocationList(HttpServletRequest request) {
        ZydexLocationMaster zydexLocationMaster=new ZydexLocationMaster();
        List<?> zydexLocationList = zydexLocationMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : zydexLocationList) {
            zydexLocationMaster = (ZydexLocationMaster) o;
            dm.put(zydexLocationMaster.getId(), zydexLocationMaster.getZydexLocation());
        }

        request.setAttribute("deptMap", dm);
    }

    protected void designationList(HttpServletRequest request) {
        DesignationMaster designationMaster = new DesignationMaster();
        List<?> desigList = designationMasterService.read();
        Map<Integer, String> dn = new HashMap<>();
        for (Object o : desigList) {
            designationMaster = (DesignationMaster) o;
            dn.put(designationMaster.getId(), designationMaster.getDesignationName());
        }

        request.setAttribute("desigList", dn);
    }

    public void selectEmployee1(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = employeeMasterService.readEmployeeSearch();
        String tempStr = "[";
        Object[] arrayOfObject;

        EmployeeMaster employeeMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
             tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3]+ "\"}";
//            tempStr += "{id: \"" + arrayOfObject[0]
//                    + "\", name: \"" + arrayOfObject[0]
//                    + "  /" + arrayOfObject[1]
//                    + "  /" + arrayOfObject[2] + "\"}";
        }
        tempStr += "]";

        request.setAttribute("list", tempStr);
    }

    protected void readcurrencyList(HttpServletRequest request) {
        CurrencyMaster currencyMaster = new CurrencyMaster();
        List<?> currencyList = currencyMasterService.read();
        Map<Integer, String> currencyMap = new HashMap<>();
        for (Object o : currencyList) {
            currencyMaster = (CurrencyMaster) o;
            currencyMap.put(currencyMaster.getId(), currencyMaster.getCurrencyName() + "(" + currencyMaster.getCurrencyCode() + ")");
        }

        request.setAttribute("currencyMap", currencyMap);
    }
      
public void selectedEmployeeFor360Feedback(HttpServletRequest request,
            EmployeeMaster employeeMaster) throws Exception {
        String tempStr = "";
        tempStr += "[";
        if (null != employeeMaster.getId()&& !employeeMaster.getId().equals("")) {
            
            EmployeeMaster employeeMaster1;
            List<Object> list1 = new ArrayList<Object>();
            employeeMaster = employeeMasterService.readById(employeeMaster.getId());
            int dept_Id = employeeMaster.getDepartmentMaster().getId();
            DepartmentMaster departmentMaster = new DepartmentMaster();
            departmentMaster = departmentMasterService.readById(dept_Id);
            employeeMaster.setDepartmentMaster(departmentMaster);
            list1.add(employeeMaster);
            boolean flag = false;

            if (null != list1 && !list1.isEmpty()) {
                EmployeeMaster arrayOfObject = (EmployeeMaster) list1.get(0);
                if (flag) {
                    tempStr += ", ";
                }
                flag = true;
                tempStr += "{id: \"" + arrayOfObject.getId()
                    + "\", name: \"" + arrayOfObject.getId()
                    + "  /" + arrayOfObject.getEmployeeName()
                    + "  /" + arrayOfObject.getDepartmentMaster().getDepartmentName() + "\"}";
            }
        }
        tempStr += "]";
        request.setAttribute("preList", tempStr);
    }

public void selectedEmployeeFor360Feedback1(HttpServletRequest request,
            List<Object> list) throws Exception {
    EmployeeMaster employeeMaster5 = new EmployeeMaster();
      String tempStr = "[";
                    for(Object o: list){
                        employeeMaster5 = (EmployeeMaster)o;
                        employeeMaster5 = employeeMasterService.readById(employeeMaster5.getId());
                        DepartmentMaster departmentMaster = new DepartmentMaster();
                        departmentMaster= departmentMasterService.readById(employeeMaster5.getDepartmentMaster().getId());
                        employeeMaster5.setDepartmentMaster(departmentMaster);
                           boolean flag = false;
                          if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + employeeMaster5.getId()
                    + "\", name: \"" + employeeMaster5.getId()
                    + "  /" + employeeMaster5.getEmployeeName()
                    + "  /" + employeeMaster5.getDepartmentMaster().getDepartmentName() + "\"}";
        }
        tempStr += "]";
         request.setAttribute("preList1", tempStr);
    
}

 public void selectEmployeeForLuna(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = employeeMasterService.readEmployeeForPlant();
        String tempStr = "[";
        Object[] arrayOfObject;

        EmployeeMaster employeeMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            if(arrayOfObject[3].equals("Luna Plant")){
            flag = true;
             tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3]+ "\"}";   
            }else{
                flag = false;  
            }
        }
        tempStr += "]";

        request.setAttribute("lunaList", tempStr);
    }
 
  public void selectEmployeeForGavasat(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       List<?> list = employeeMasterService.readEmployeeForPlant();
        String tempStr = "[";
        Object[] arrayOfObject;

        EmployeeMaster employeeMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            if(arrayOfObject[3].equals("Gavasad Plant")){
            flag = true;
             tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3]+ "\"}";   
            }else{
                flag = false;  
            }
        }
        tempStr += "]";

        request.setAttribute("gavasatList", tempStr);
    }

    public EmailAddMasterService<EmailAddMaster> getEmailAddMasterService() {
        return emailAddMasterService;
    }

    public void setEmailAddMasterService(EmailAddMasterService<EmailAddMaster> emailAddMasterService) {
        this.emailAddMasterService = emailAddMasterService;
    }

}

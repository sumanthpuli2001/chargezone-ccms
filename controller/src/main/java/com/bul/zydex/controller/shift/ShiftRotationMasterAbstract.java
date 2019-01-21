/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.AttendanceRegularizationMaster;
import com.bul.zydex.model.ClientDetailsMaster;
import com.bul.zydex.model.CoffRegularization;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.OTRegularization;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.RotationMaster;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRegularization;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.TempShiftAssignMaster;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.WoffRegularization;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.attendanceRegularization.AttendanceRegularizationMasterService;
import com.bul.zydex.service.attendanceRegularization.ClientDetailsMasterService;
import com.bul.zydex.service.attendanceRegularization.OTRegularizationService;
import com.bul.zydex.service.attendanceRegularization.TimeAttandanceFlaxibleMasterService;
import com.bul.zydex.service.holiday.HolidayMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveEmployeeDetailService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.overTime.OverTimeMasterService;
import com.bul.zydex.service.shift.CoffRegularizationService;
import com.bul.zydex.service.shift.EmployeeDatetimeDataService;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
import com.bul.zydex.service.shift.RotationMasterService;
import com.bul.zydex.service.shift.ShiftGenerateMonthlyScheduleService;
import com.bul.zydex.service.shift.ShiftMasterService;
import com.bul.zydex.service.shift.ShiftRegularizationService;
import com.bul.zydex.service.shift.ShiftRotationInfoService;
import com.bul.zydex.service.shift.ShiftRotationMasterService;
import com.bul.zydex.service.shift.TemporaryShiftAssignService;
import com.bul.zydex.service.shift.WoffRegularizationService;
import com.bul.zydex.service.travel.TravelRequestMasterService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class ShiftRotationMasterAbstract extends CustomAbstract {

    protected ShiftRotationMasterService<ShiftRotationMaster> shiftRotationMasterService;
    protected Validator shiftRotationMasterValidator;
    protected ShiftMasterService<ShiftMaster> shiftMasterService;
    protected RotationMasterService<RotationMaster> rotationMasterService;
    protected ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService;
    protected ShiftRotationInfoService<ShiftRotationInfo> shiftRotationInfoService;
    protected EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService;
    protected EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService;
    protected TemporaryShiftAssignService<TempShiftAssignMaster> temporaryShiftAssignService;
    protected OverTimeMasterService<OverTimeMaster> overTimeMasterService;
    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;
    protected LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected LeaveEmployeeDetailService<LeaveEmployeeDetail> leaveEmployeeDetailService;
    protected HolidayMasterService<HolidayMaster> holidayMasterService;
    protected AttendanceRegularizationMasterService<AttendanceRegularization> attendanceRegularizationMasterService;
    protected TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService;
    protected TimeAttandanceFlaxibleMasterService<TimeAttandanceFlaxibleMaster> timeAttandanceFlaxibleMasterService;
    protected ShiftRegularizationService<ShiftRegularization> shiftRegularizationService;
    protected Validator shiftRegularizationValidator;
    protected WoffRegularizationService<WoffRegularization> woffRegularizationService;
    protected CoffRegularizationService<CoffRegularization> coffRegularizationService;
    protected OTRegularizationService<OTRegularization> oTRegularizationService;
    protected ClientDetailsMasterService<ClientDetailsMaster> clientDetailsMasterService;
     protected Validator coffRegularizationValidator;
     protected Validator otRegularizationValidator;

    public TimeAttandanceFlaxibleMasterService<TimeAttandanceFlaxibleMaster> getTimeAttandanceFlaxibleMasterService() {
        return timeAttandanceFlaxibleMasterService;
    }

    public void setTimeAttandanceFlaxibleMasterService(TimeAttandanceFlaxibleMasterService<TimeAttandanceFlaxibleMaster> timeAttandanceFlaxibleMasterService) {
        this.timeAttandanceFlaxibleMasterService = timeAttandanceFlaxibleMasterService;
    }

    public TravelRequestMasterService<TravelRequestMaster> getTravelRequestMasterService() {
        return travelRequestMasterService;
    }

    public void setTravelRequestMasterService(TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService) {
        this.travelRequestMasterService = travelRequestMasterService;
    }

    public AttendanceRegularizationMasterService<AttendanceRegularization> getAttendanceRegularizationMasterService() {
        return attendanceRegularizationMasterService;
    }

    public void setAttendanceRegularizationMasterService(AttendanceRegularizationMasterService<AttendanceRegularization> attendanceRegularizationMasterService) {
        this.attendanceRegularizationMasterService = attendanceRegularizationMasterService;
    }

    public HolidayMasterService<HolidayMaster> getHolidayMasterService() {
        return holidayMasterService;
    }

    public void setHolidayMasterService(HolidayMasterService<HolidayMaster> holidayMasterService) {
        this.holidayMasterService = holidayMasterService;
    }

    public LeaveEmployeeDetailService<LeaveEmployeeDetail> getLeaveEmployeeDetailService() {
        return leaveEmployeeDetailService;
    }

    public void setLeaveEmployeeDetailService(LeaveEmployeeDetailService<LeaveEmployeeDetail> leaveEmployeeDetailService) {
        this.leaveEmployeeDetailService = leaveEmployeeDetailService;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public LeaveTypeMasterService<LeaveTypeMaster> getLeaveTypeMasterService() {
        return leaveTypeMasterService;
    }

    public void setLeaveTypeMasterService(LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService) {
        this.leaveTypeMasterService = leaveTypeMasterService;
    }

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

    public OverTimeMasterService<OverTimeMaster> getOverTimeMasterService() {
        return overTimeMasterService;
    }

    public void setOverTimeMasterService(OverTimeMasterService<OverTimeMaster> overTimeMasterService) {
        this.overTimeMasterService = overTimeMasterService;
    }

    public TemporaryShiftAssignService<TempShiftAssignMaster> getTemporaryShiftAssignService() {
        return temporaryShiftAssignService;
    }

    public void setTemporaryShiftAssignService(TemporaryShiftAssignService<TempShiftAssignMaster> temporaryShiftAssignService) {
        this.temporaryShiftAssignService = temporaryShiftAssignService;
    }

    public EmployeeDatetimeDataService<EmployeeDatetimeData> getEmployeeDatetimeDataService() {
        return employeeDatetimeDataService;
    }

    public void setEmployeeDatetimeDataService(EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService) {
        this.employeeDatetimeDataService = employeeDatetimeDataService;
    }

    public EmployeeShiftDataService<EmployeeShiftData> getEmployeeShiftDataService() {
        return employeeShiftDataService;
    }

    public void setEmployeeShiftDataService(EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService) {
        this.employeeShiftDataService = employeeShiftDataService;
    }

    public ShiftRotationMasterService<ShiftRotationMaster> getShiftRotationMasterService() {
        return shiftRotationMasterService;
    }

    public void setShiftRotationMasterService(ShiftRotationMasterService<ShiftRotationMaster> shiftRotationMasterService) {
        this.shiftRotationMasterService = shiftRotationMasterService;
    }

    public Validator getShiftRotationMasterValidator() {
        return shiftRotationMasterValidator;
    }

    public void setShiftRotationMasterValidator(Validator shiftRotationMasterValidator) {
        this.shiftRotationMasterValidator = shiftRotationMasterValidator;
    }

    public ShiftMasterService<ShiftMaster> getShiftMasterService() {
        return shiftMasterService;
    }

    public void setShiftMasterService(ShiftMasterService<ShiftMaster> shiftMasterService) {
        this.shiftMasterService = shiftMasterService;
    }

    public RotationMasterService<RotationMaster> getRotationMasterService() {
        return rotationMasterService;
    }

    public void setRotationMasterService(RotationMasterService<RotationMaster> rotationMasterService) {
        this.rotationMasterService = rotationMasterService;
    }

    public ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> getShiftGenerateMonthlyScheduleService() {
        return shiftGenerateMonthlyScheduleService;
    }

    public void setShiftGenerateMonthlyScheduleService(ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService) {
        this.shiftGenerateMonthlyScheduleService = shiftGenerateMonthlyScheduleService;
    }

    public ShiftRotationInfoService<ShiftRotationInfo> getShiftRotationInfoService() {
        return shiftRotationInfoService;
    }

    public void setShiftRotationInfoService(ShiftRotationInfoService<ShiftRotationInfo> shiftRotationInfoService) {
        this.shiftRotationInfoService = shiftRotationInfoService;
    }

    public Validator getCoffRegularizationValidator() {
        return coffRegularizationValidator;
    }

    public void setCoffRegularizationValidator(Validator coffRegularizationValidator) {
        this.coffRegularizationValidator = coffRegularizationValidator;
    }

    public OTRegularizationService<OTRegularization> getoTRegularizationService() {
        return oTRegularizationService;
    }

    public void setoTRegularizationService(OTRegularizationService<OTRegularization> oTRegularizationService) {
        this.oTRegularizationService = oTRegularizationService;
    }

    public ClientDetailsMasterService<ClientDetailsMaster> getClientDetailsMasterService() {
        return clientDetailsMasterService;
    }

    public void setClientDetailsMasterService(ClientDetailsMasterService<ClientDetailsMaster> clientDetailsMasterService) {
        this.clientDetailsMasterService = clientDetailsMasterService;
    }
    
    
    

    protected void readShiftName(HttpServletRequest request) {
        List<?> list = shiftMasterService.read();
        ShiftMaster shiftMaster = new ShiftMaster();
        Map<Integer, String> shiftMap = new HashMap();
        for (Object o : list) {
            shiftMaster = (ShiftMaster) o;
            shiftMap.put(shiftMaster.getId(), shiftMaster.getShiftName());
        }
        request.setAttribute("shiftMap", shiftMap);
    }

    protected void shiftAjaxmap(HttpServletRequest request, String rotationId) {
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        RotationMaster rotationMaster = new RotationMaster();
//        shiftRotationMaster.setId(Integer.parseInt(rotationId));
//        rotationMaster.setShiftRotationMaster(shiftRotationMaster);
        Map<Integer, String> shiftMap = new HashMap();
        List<?> list = null;
        if (!"".equals(rotationId)) {

            int rotationId1 = Integer.parseInt(rotationId);
            list = rotationMasterService.readForShift(rotationId1);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object next[] = (Object[]) it.next();
                int shiftId = (int) next[0];
                String shiftName = (String) next[1];
                shiftMap.put(shiftId, shiftName);
            }
        }

        request.setAttribute("shiftAjaxMap", shiftMap);
    }

//    public void selectEmployee(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        List<?> list = employeeMasterService.read();
//        String tempStr = "[";
//        boolean flag = false;
//        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
//           EmployeeMaster employeeMaster1=(EmployeeMaster) it.next();
//
//            if (flag) {
//                tempStr += ", ";
//            }
//            flag = true;
//            tempStr += "{id: \"" + employeeMaster1.getId()
//                    + "\", name: \"" + employeeMaster1.getEmployeeId()
//                    + "  /" + employeeMaster1.getEmployeeName()
//                    + "\"}";
//
//        }
//        tempStr += "]";
//
//        request.setAttribute("list", tempStr);
//    }
    public void selectZydexLocation(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> zydexLocationList = zydexLocationMasterService.read();
        String tempStr = "[";
        boolean flag = false;
        for (Iterator<? extends Object> it = zydexLocationList.iterator(); it.hasNext();) {
            ZydexLocationMaster zydexLocationMaster = (ZydexLocationMaster) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + zydexLocationMaster.getId()
                    + "\", name: \"" + zydexLocationMaster.getZydexLocation()
                    + "\"}";

        }
        tempStr += "]";

        request.setAttribute("zydexLocationList", tempStr);
    }

    public void selectLevel(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> levelList = levelMasterService.read();
        String tempStr = "[";
        boolean flag = false;
        for (Iterator<? extends Object> it = levelList.iterator(); it.hasNext();) {
            LevelMaster levelMaster = (LevelMaster) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + levelMaster.getId()
                    + "\", name: \"" + levelMaster.getLevel()
                    + "\"}";

        }
        tempStr += "]";

        request.setAttribute("levelList", tempStr);
    }

    public void department(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> deptList = departmentMasterService.read();
        String tempStr = "[";
        boolean flag = false;
        for (Iterator<? extends Object> it = deptList.iterator(); it.hasNext();) {
            DepartmentMaster departmentMaster = (DepartmentMaster) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + departmentMaster.getId()
                    + "\", name: \"" + departmentMaster.getDepartmentName()
                    + "\"}";

        }
        tempStr += "]";

        request.setAttribute("departmentList", tempStr);
    }

    protected void shiftRotaionList(HttpServletRequest request) {
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        List<?> shift = shiftRotationMasterService.read();

        Map<Integer, String> rotationMap = new HashMap<>();
        for (Object o : shift) {
            shiftRotationMaster = (ShiftRotationMaster) o;
            rotationMap.put(shiftRotationMaster.getId(), shiftRotationMaster.getTitle());
        }
        request.setAttribute("rotationMap", rotationMap);
    }

    protected void shiftList(HttpServletRequest request) {
        ShiftMaster shiftMaster = new ShiftMaster();
        List<?> shift = shiftMasterService.read();

        Map<Integer, String> shift1 = new HashMap<>();
        for (Object o : shift) {
            shiftMaster = (ShiftMaster) o;
            shift1.put(shiftMaster.getId(), shiftMaster.getShiftName());
        }
        request.setAttribute("shift", shift1);
    }

    public ShiftRegularizationService<ShiftRegularization> getShiftRegularizationService() {
        return shiftRegularizationService;
    }

    public void setShiftRegularizationService(ShiftRegularizationService<ShiftRegularization> shiftRegularizationService) {
        this.shiftRegularizationService = shiftRegularizationService;
    }

    public Validator getShiftRegularizationValidator() {
        return shiftRegularizationValidator;
    }

    public void setShiftRegularizationValidator(Validator shiftRegularizationValidator) {
        this.shiftRegularizationValidator = shiftRegularizationValidator;
    }

    public WoffRegularizationService<WoffRegularization> getWoffRegularizationService() {
        return woffRegularizationService;
    }

    public void setWoffRegularizationService(WoffRegularizationService<WoffRegularization> woffRegularizationService) {
        this.woffRegularizationService = woffRegularizationService;
    }

    public CoffRegularizationService<CoffRegularization> getCoffRegularizationService() {
        return coffRegularizationService;
    }

    public void setCoffRegularizationService(CoffRegularizationService<CoffRegularization> coffRegularizationService) {
        this.coffRegularizationService = coffRegularizationService;
    }
    

   
    

    public void mailSendArApply(HttpServletRequest request) throws Exception {

        try {
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmailTemplate emailTemplate1 = new EmailTemplate();
            // id =7 for approve leave request...
            emailTemplate1 = emailTemplateService.readById(14);
            int empID = employeeMasterModel.getId();
            employeeMaster2 = employeeMasterService.readById(empID);

            String name = "Attendance";
            EmailAddMaster emailAddMaster = new EmailAddMaster();
            emailAddMaster.setModuleName(name);
            emailAddMaster.setDepartmentMaster(employeeMaster2.getDepartmentMaster());
            List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
            if (!emailSendList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
            List<?> allDeptmailList = emailAddMasterService.readAllDept(name);
            if (!allDeptmailList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) allDeptmailList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
     protected void clientList(HttpServletRequest request) {
        ClientDetailsMaster clientDetailsMaster = new ClientDetailsMaster();
        List<?> clientDetailsMaster1 = clientDetailsMasterService.read();

        Map<Integer, String> location1 = new HashMap<>();
        for (Object o : clientDetailsMaster1) {
            clientDetailsMaster = (ClientDetailsMaster) o;
            location1.put(clientDetailsMaster.getId(), clientDetailsMaster.getClientName());
        }
        request.setAttribute("clientMaster", location1);
    }

    public Validator getOtRegularizationValidator() {
        return otRegularizationValidator;
    }

    public void setOtRegularizationValidator(Validator otRegularizationValidator) {
        this.otRegularizationValidator = otRegularizationValidator;
    }
     

}

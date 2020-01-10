/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.model.ExpenseOtherType;
import com.bul.zydex.model.ExpenseTravelType;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.ItServiceRequest;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.RelocationOrOtherExpense;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.TravelApproverHistory;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.attendanceRegularization.AttendanceRegularizationMasterService;
import com.bul.zydex.service.emprequest.HrServiceRequestService;
import com.bul.zydex.service.emprequest.ItServiceRequestService;
import com.bul.zydex.service.expense.ExpenseMasterService;
import com.bul.zydex.service.expenseOtherType.ExpenseOtherTypeService;
import com.bul.zydex.service.expenseTravelType.ExpenseTravelTypeService;
import com.bul.zydex.service.holiday.HolidayMasterService;
import com.bul.zydex.service.leave.COffLeaveMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveEmployeeDetailService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.otherExpense.RelocationOrOtherExpenseService;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
import com.bul.zydex.service.shift.ShiftGenerateMonthlyScheduleService;
import com.bul.zydex.service.travel.TravelApproverHistoryService;
import com.bul.zydex.service.travel.TravelRequestMasterService;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public abstract class WebServiceAbstract extends CustomAbstract {

    protected UserRightMasterService<UserRightMaster> userRightMasterService;
    protected LeaveEmployeeDetailService<LeaveEmployeeDetail> leaveEmployeeDetailService;
    protected LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService;
    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;
    protected HolidayMasterService<HolidayMaster> holidayMasterService;
    protected COffLeaveMasterService<COffLeaveMaster> cOffLeaveMasterService;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService;
    protected ExpenseMasterService<ExpenseMaster> expenseMasterService;
    protected ItServiceRequestService<ItServiceRequest> itServiceRequestService;
    protected HrServiceRequestService<HrServiceRequest> hrServiceRequestService;
    protected EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService;
    protected AttendanceRegularizationMasterService<AttendanceRegularization> attendanceRegularizationMasterService;
    protected ExpenseTravelTypeService<ExpenseTravelType> expenseTravelTypeService;
    protected RelocationOrOtherExpenseService<RelocationOrOtherExpense> relocationOrOtherExpenseService;
    protected ExpenseOtherTypeService<ExpenseOtherType> expenseOtherTypeService;
    protected ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService;
    protected Validator leaveEmployeeDetailValidator;
    
    public Validator getLeaveEmployeeDetailValidator() {
        return leaveEmployeeDetailValidator;
    }

    public void setLeaveEmployeeDetailValidator(Validator leaveEmployeeDetailValidator) {
        this.leaveEmployeeDetailValidator = leaveEmployeeDetailValidator;
    }
    
    public ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> getShiftGenerateMonthlyScheduleService() {
        return shiftGenerateMonthlyScheduleService;
    }

    public void setShiftGenerateMonthlyScheduleService(ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService) {
        this.shiftGenerateMonthlyScheduleService = shiftGenerateMonthlyScheduleService;
    }
    
    public ExpenseOtherTypeService<ExpenseOtherType> getExpenseOtherTypeService() {
        return expenseOtherTypeService;
    }

    public void setExpenseOtherTypeService(ExpenseOtherTypeService<ExpenseOtherType> expenseOtherTypeService) {
        this.expenseOtherTypeService = expenseOtherTypeService;
    }

    public TravelApproverHistoryService<TravelApproverHistory> getTravelApproverHistoryService() {
        return travelApproverHistoryService;
    }

    public void setTravelApproverHistoryService(TravelApproverHistoryService<TravelApproverHistory> travelApproverHistoryService) {
        this.travelApproverHistoryService = travelApproverHistoryService;
    }
    protected TravelApproverHistoryService<TravelApproverHistory> travelApproverHistoryService;

    public RelocationOrOtherExpenseService<RelocationOrOtherExpense> getRelocationOrOtherExpenseService() {
        return relocationOrOtherExpenseService;
    }

    public void setRelocationOrOtherExpenseService(RelocationOrOtherExpenseService<RelocationOrOtherExpense> relocationOrOtherExpenseService) {
        this.relocationOrOtherExpenseService = relocationOrOtherExpenseService;
    }

    public AttendanceRegularizationMasterService<AttendanceRegularization> getAttendanceRegularizationMasterService() {
        return attendanceRegularizationMasterService;
    }

    public void setAttendanceRegularizationMasterService(AttendanceRegularizationMasterService<AttendanceRegularization> attendanceRegularizationMasterService) {
        this.attendanceRegularizationMasterService = attendanceRegularizationMasterService;
    }

    public ExpenseTravelTypeService<ExpenseTravelType> getExpenseTravelTypeService() {
        return expenseTravelTypeService;
    }

    public void setExpenseTravelTypeService(ExpenseTravelTypeService<ExpenseTravelType> expenseTravelTypeService) {
        this.expenseTravelTypeService = expenseTravelTypeService;
    }

    public EmployeeShiftDataService<EmployeeShiftData> getEmployeeShiftDataService() {
        return employeeShiftDataService;
    }

    public void setEmployeeShiftDataService(EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService) {
        this.employeeShiftDataService = employeeShiftDataService;
    }

    public ItServiceRequestService<ItServiceRequest> getItServiceRequestService() {
        return itServiceRequestService;
    }

    public void setItServiceRequestService(ItServiceRequestService<ItServiceRequest> itServiceRequestService) {
        this.itServiceRequestService = itServiceRequestService;
    }

    public HrServiceRequestService<HrServiceRequest> getHrServiceRequestService() {
        return hrServiceRequestService;
    }

    public void setHrServiceRequestService(HrServiceRequestService<HrServiceRequest> hrServiceRequestService) {
        this.hrServiceRequestService = hrServiceRequestService;
    }

    public TravelRequestMasterService<TravelRequestMaster> getTravelRequestMasterService() {
        return travelRequestMasterService;
    }

    public void setTravelRequestMasterService(TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService) {
        this.travelRequestMasterService = travelRequestMasterService;
    }

    public ExpenseMasterService<ExpenseMaster> getExpenseMasterService() {
        return expenseMasterService;
    }

    public void setExpenseMasterService(ExpenseMasterService<ExpenseMaster> expenseMasterService) {
        this.expenseMasterService = expenseMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public COffLeaveMasterService<COffLeaveMaster> getcOffLeaveMasterService() {
        return cOffLeaveMasterService;
    }

    public void setcOffLeaveMasterService(COffLeaveMasterService<COffLeaveMaster> cOffLeaveMasterService) {
        this.cOffLeaveMasterService = cOffLeaveMasterService;
    }

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public LeaveEmployeeDetailService<LeaveEmployeeDetail> getLeaveEmployeeDetailService() {
        return leaveEmployeeDetailService;
    }

    public void setLeaveEmployeeDetailService(LeaveEmployeeDetailService<LeaveEmployeeDetail> leaveEmployeeDetailService) {
        this.leaveEmployeeDetailService = leaveEmployeeDetailService;
    }

    public LeaveTypeMasterService<LeaveTypeMaster> getLeaveTypeMasterService() {
        return leaveTypeMasterService;
    }

    public void setLeaveTypeMasterService(LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService) {
        this.leaveTypeMasterService = leaveTypeMasterService;
    }

    public HolidayMasterService<HolidayMaster> getHolidayMasterService() {
        return holidayMasterService;
    }

    public void setHolidayMasterService(HolidayMasterService<HolidayMaster> holidayMasterService) {
        this.holidayMasterService = holidayMasterService;
    }

    public JSONObject doPost(HttpServletRequest request)
            throws ServletException, IOException, JSONException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            /*report an error*/ }
        JSONObject jsonObject = new JSONObject(jb.toString());

        return jsonObject;

    }

    protected void readleaveType(HttpServletRequest request) {
        List list = leaveTypeMasterService.read();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        Map<Integer, String> leaveTypemap = new HashMap();
        for (Object o : list) {
            leaveTypeMaster = (LeaveTypeMaster) o;
            leaveTypemap.put(leaveTypeMaster.getId(), leaveTypeMaster.getLeaveType());
        }
        request.setAttribute("leaveTypemap11", leaveTypemap);
    }

    public void selectEmployeeForParticularManager(HttpServletRequest request,
            HttpServletResponse response, int id) throws Exception {

        List<?> list = employeeMasterService.readEmployeeForParticularManager(id);
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
                    + "  /" + arrayOfObject[3]
                    + "  /" + arrayOfObject[4]
                    + "  /" + arrayOfObject[5] + "\"}";

        }
        tempStr += "]";

        request.setAttribute("list", tempStr);
    }

    protected void addleaveType(HttpServletRequest request) {
        List list = leaveTypeMasterService.read();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");

        EmployeeMaster employeeSession = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        zydexLocationMaster = zydexLocationMasterService.readById(employeeSession.getZydexLocationMaster().getId());

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        employeeMaster.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        Map<Integer, String> leaveTypemap = new HashMap();
        for (Object o : list) {
            leaveTypeMaster = (LeaveTypeMaster) o;
            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
//          if((zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D")) && leaveTypeMaster.getLeaveType().equals("Short Leave")){
//              
//          }else{

            List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
            if (!balanceList.isEmpty()) {
                employeeLeaveBalance = (EmployeeLeaveBalance) balanceList.get(0);
            }
            try {
                if (null != employeeMaster.getGender() && employeeMaster.getGender() && leaveTypeMaster.getLeaveType().equals("Paternity Leave")) {

                } else if (!employeeMaster.getGender() && leaveTypeMaster.getLeaveType().equals("Maternity Leave")) {

                } else if (employeeMaster.getGender() && leaveTypeMaster.getLeaveType().equals("Maternity Leave")) {
                    leaveTypemap.put(leaveTypeMaster.getId(), leaveTypeMaster.getLeaveType() + "(As Per Maternity Act)");

                } else if (!employeeMaster.getGender() && leaveTypeMaster.getLeaveType().equals("Paternity Leave") && employeeMaster.getMaritalStatus().equals("UnMarried")) {

                } else if (leaveTypeMaster.getId().intValue() == employeeLeaveBalance.getLeaveTypeMaster().getId().intValue() && !balanceList.isEmpty()) {
                    leaveTypemap.put(leaveTypeMaster.getId(), leaveTypeMaster.getLeaveType() + "(" + employeeLeaveBalance.getNoOfLeaveRemain() + ")");
                } else {
                    leaveTypemap.put(leaveTypeMaster.getId(), leaveTypeMaster.getLeaveType() + "(" + 0 + ")");
                }
            } catch (Exception e) {

            }
//          }

        }
        request.setAttribute("leaveTypemap", leaveTypemap);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emp;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.Company;
import com.bul.zydex.model.CompetencyEvaluationMaster;
import com.bul.zydex.model.CtcAllowance;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeCtcDetail;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.HoursBasis;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PayrollPfCheck;
import com.bul.zydex.model.PayrollPtCheck;
import com.bul.zydex.model.PmpFormStatusMaster;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.RotationMaster;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.ApplayJobUserMaster.ApplayJobUserMasterService;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.EmployeePolicyDetail.EmployeePolicyDetailService;
import com.bul.zydex.service.Payroll.PayrollPfCheckService;
import com.bul.zydex.service.Payroll.PayrollPtCheckService;
import com.bul.zydex.service.PmpFormStatusMaster.PmpFormStatusMasterService;
import com.bul.zydex.service.Recruitment.CandidateJobApplicationService;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.appraisalPerformance.CompetencyEvaluationMasterService;
import com.bul.zydex.service.company.CompanyMasterService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.emp.EmployeeTypeService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.policy.CtcAllowanceService;
import com.bul.zydex.service.policy.EmployeeCtcDetailService;
import com.bul.zydex.service.policy.PolicyMasterService;
import com.bul.zydex.service.shift.HoursBasisService;
import com.bul.zydex.service.shift.RotationMasterService;
import com.bul.zydex.service.shift.ShiftGenerateMonthlyScheduleService;
import com.bul.zydex.service.shift.ShiftMasterService;
import com.bul.zydex.service.shift.ShiftRotationInfoService;
import com.bul.zydex.service.shift.ShiftRotationMasterService;
import com.bul.zydex.service.zydexLocation.ZydexLocationMasterService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public abstract class EmployeeMasterAbstract extends CustomAbstract {

    protected Validator employeeMasterValidator;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected ShiftMasterService<ShiftMaster> shiftMasterService;
    protected HoursBasisService<HoursBasis> hoursBasisService;
    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;
    protected LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;
    protected ShiftRotationMasterService<ShiftRotationMaster> shiftRotationMasterService;
    protected ShiftRotationInfoService<ShiftRotationInfo> shiftRotationInfoService;
    protected ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService;
    protected RotationMasterService<RotationMaster> rotationMasterService;
    protected ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService;
    protected CompetencyEvaluationMasterService<CompetencyEvaluationMaster> competencyEvaluationMasterService;
    protected PmpFormStatusMasterService<PmpFormStatusMaster> pmpFormStatusMasterService;
    protected EmployeeTypeService<EmployeeTypeMaster> employeeTypeService;
    protected EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService;
    protected CompanyMasterService<Company> companyMasterService;
    protected PolicyMasterService<PolicyMaster> policyMasterService;
    protected EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService;
    protected PayrollPfCheckService<PayrollPfCheck> payrollPfCheckService;
    protected PayrollPtCheckService<PayrollPtCheck> payrollPtCheckService;
    protected CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService;
    protected CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService;
    protected CtcAllowanceService<CtcAllowance> ctcAllowanceService;
    protected EmployeeCtcDetailService<EmployeeCtcDetail> employeeCtcDetailService;
    protected ApplayJobUserMasterService<ApplayJobUserMaster> applayJobUserMasterService;

    public CompetencyEvaluationMasterService<CompetencyEvaluationMaster> getCompetencyEvaluationMasterService() {
        return competencyEvaluationMasterService;
    }

    public void setCompetencyEvaluationMasterService(CompetencyEvaluationMasterService<CompetencyEvaluationMaster> competencyEvaluationMasterService) {
        this.competencyEvaluationMasterService = competencyEvaluationMasterService;
    }

    public ZydexLocationMasterService<ZydexLocationMaster> getZydexLocationMasterService() {
        return zydexLocationMasterService;
    }

    public void setZydexLocationMasterService(ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService) {
        this.zydexLocationMasterService = zydexLocationMasterService;
    }

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public Validator getEmployeeMasterValidator() {
        return employeeMasterValidator;
    }

    public void setEmployeeMasterValidator(Validator employeeMasterValidator) {
        this.employeeMasterValidator = employeeMasterValidator;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public ShiftMasterService<ShiftMaster> getShiftMasterService() {
        return shiftMasterService;
    }

    public void setShiftMasterService(ShiftMasterService<ShiftMaster> shiftMasterService) {
        this.shiftMasterService = shiftMasterService;
    }

    public HoursBasisService<HoursBasis> getHoursBasisService() {
        return hoursBasisService;
    }

    public void setHoursBasisService(HoursBasisService<HoursBasis> hoursBasisService) {
        this.hoursBasisService = hoursBasisService;
    }

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

    public LeaveTypeMasterService<LeaveTypeMaster> getLeaveTypeMasterService() {
        return leaveTypeMasterService;
    }

    public void setLeaveTypeMasterService(LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService) {
        this.leaveTypeMasterService = leaveTypeMasterService;
    }

    public ShiftRotationMasterService<ShiftRotationMaster> getShiftRotationMasterService() {
        return shiftRotationMasterService;
    }

    public void setShiftRotationMasterService(ShiftRotationMasterService<ShiftRotationMaster> shiftRotationMasterService) {
        this.shiftRotationMasterService = shiftRotationMasterService;
    }

    public ShiftRotationInfoService<ShiftRotationInfo> getShiftRotationInfoService() {
        return shiftRotationInfoService;
    }

    public void setShiftRotationInfoService(ShiftRotationInfoService<ShiftRotationInfo> shiftRotationInfoService) {
        this.shiftRotationInfoService = shiftRotationInfoService;
    }

    public ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> getShiftGenerateMonthlyScheduleService() {
        return shiftGenerateMonthlyScheduleService;
    }

    public void setShiftGenerateMonthlyScheduleService(ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService) {
        this.shiftGenerateMonthlyScheduleService = shiftGenerateMonthlyScheduleService;
    }

    public RotationMasterService<RotationMaster> getRotationMasterService() {
        return rotationMasterService;
    }

    public void setRotationMasterService(RotationMasterService<RotationMaster> rotationMasterService) {
        this.rotationMasterService = rotationMasterService;
    }

    public PayrollPfCheckService<PayrollPfCheck> getPayrollPfCheckService() {
        return payrollPfCheckService;
    }

    public void setPayrollPfCheckService(PayrollPfCheckService<PayrollPfCheck> payrollPfCheckService) {
        this.payrollPfCheckService = payrollPfCheckService;
    }

    public PayrollPtCheckService<PayrollPtCheck> getPayrollPtCheckService() {
        return payrollPtCheckService;
    }

    public void setPayrollPtCheckService(PayrollPtCheckService<PayrollPtCheck> payrollPtCheckService) {
        this.payrollPtCheckService = payrollPtCheckService;
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

    protected void levelList(HttpServletRequest request) {
        LevelMaster levelMaster = new LevelMaster();
        List<?> level = levelMasterService.read();
        Map<Integer, String> level1 = new HashMap<>();
        for (Object o : level) {
            levelMaster = (LevelMaster) o;
            level1.put(levelMaster.getId(), levelMaster.getLevel());
        }

        request.setAttribute("level", level1);
    }

    protected void locationList(HttpServletRequest request) {
        LocationMaster locationMaster = new LocationMaster();
        List<?> location = locationMasterService.read();

        Map<Integer, String> location1 = new HashMap<>();
        for (Object o : location) {
            locationMaster = (LocationMaster) o;
            location1.put(locationMaster.getId(), locationMaster.getLocation());
        }
        request.setAttribute("location", location1);
    }

    protected void setZydexLocationList(HttpServletRequest request) {
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        List<?> zydexLocationList = zydexLocationMasterService.read();

        Map<Integer, String> zydexLocationMap = new HashMap<>();
        for (Object o : zydexLocationList) {
            zydexLocationMaster = (ZydexLocationMaster) o;
            zydexLocationMap.put(zydexLocationMaster.getId(), zydexLocationMaster.getZydexLocation());
        }
        request.setAttribute("zydexLocationMap", zydexLocationMap);
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

    protected void hoursBasisList(HttpServletRequest request) {
        HoursBasis hoursBasis = new HoursBasis();
        List<?> hours = hoursBasisService.read();

        Map<Integer, String> hours1 = new HashMap<>();
        for (Object o : hours) {
            hoursBasis = (HoursBasis) o;
            hours1.put(hoursBasis.getId(), hoursBasis.getTitle());
        }
        request.setAttribute("hours", hours1);
    }

    public void selectedEmployeeLevel(HttpServletRequest request,
            EmployeeMaster employeeMaster) throws Exception {
        String tempStr = "";
        tempStr += "[";
        if (null != employeeMaster.getReportingManagerLevel1() && !employeeMaster.getReportingManagerLevel1().equals("")) {
            EmployeeMaster employeeMaster1;
            //int empId=employeeMaster.getId();
            //List<?> list1 = employeeMasterService.readByEmployeeLevelId();
            List<?> list1 = employeeMasterService.readByEmployeeLevelId(employeeMaster);
            employeeMaster = new EmployeeMaster();
            boolean flag = false;
            //for (Object o : list1.get(0)) {
            //employeeMaster1 = (EmployeeMaster) o;
            //employeeMaster.setReportingManagerLevel1(employeeMaster1.getId().toString());
            // List<?> list2 = employeeMasterService.readByEmployeeLevelId(employeeMaster);
            if (null != list1 && !list1.isEmpty()) {
//                employeeMaster = (EmployeeMaster) list1.get(0);
                Object[] arrayOfObject = (Object[]) list1.get(0);
                if (flag) {
                    tempStr += ", ";
                }
                flag = true;
                tempStr += "{id: \"" + arrayOfObject[0]
                        + "\", name: \"" + arrayOfObject[1] + "/"
                        + arrayOfObject[2] + "/"
                        + arrayOfObject[3] + "/"
                        + arrayOfObject[4] + "/"
                        + arrayOfObject[5] + "\"}";

            }
        }
        tempStr += "]";
        request
                .setAttribute("preList1", tempStr);
    }

    public void selectedEmployeeLevel1(HttpServletRequest request,
            EmployeeMaster employeeMaster) throws Exception {
        String tempStr = "";
        tempStr += "[";
        if (null != employeeMaster.getReportingManagerLevel1() && !"".equals(employeeMaster.getReportingManagerLevel1())) {
            EmployeeMaster employeeMaster1;
            //int empId=employeeMaster.getId();
            //List<?> list1 = employeeMasterService.readByEmployeeLevelId();
            List<?> list1 = employeeMasterService.readByEmployeeReportingManagerId(employeeMaster);
//            List<?> list1 = employeeMasterService.readByEmployeeLevel1Id(employeeMaster);
            employeeMaster = new EmployeeMaster();
            boolean flag = false;
            //for (Object o : list1.get(0)) {
            //employeeMaster1 = (EmployeeMaster) o;
            //employeeMaster.setReportingManagerLevel1(employeeMaster1.getId().toString());
            // List<?> list2 = employeeMasterService.readByEmployeeLevelId(employeeMaster);
            if (null != list1 && !list1.isEmpty()) {
//                employeeMaster = (EmployeeMaster) list1.get(0);
                Object[] arrayOfObject = (Object[]) list1.get(0);
                if (flag) {
                    tempStr += ", ";
                }
                flag = true;
                tempStr += "{id: \"" + arrayOfObject[0]
                        + "\", name: \"" + arrayOfObject[1]
                        + "  /" + arrayOfObject[2]
                        + "  /" + arrayOfObject[3] + "\"}";
//                       + "  /" + arrayOfObject[4] 
//                       + "  /" + arrayOfObject[5] 

            }
        }
        tempStr += "]";
//this "preList" is used in EditUserProfile.jsp for show Reporting Manager and 
//Some String Split Operation is On jsp is done for showing it to read only mode for employee Side.
        request.setAttribute("preList", tempStr);
    }

    public void selectedEmployeeLevel2(HttpServletRequest request,
            EmployeeMaster employeeMaster) throws Exception {
        String tempStr = "";
        tempStr += "[";
        if (null != employeeMaster.getReportingManagerLevel2() && !employeeMaster.getReportingManagerLevel2().equals("")) {
            EmployeeMaster employeeMaster1;
            List<?> list1 = employeeMasterService.readByEmployeeLevel2Id(employeeMaster);
            employeeMaster = new EmployeeMaster();
            boolean flag = false;

            if (null != list1 && !list1.isEmpty()) {
                Object[] arrayOfObject = (Object[]) list1.get(0);
                if (flag) {
                    tempStr += ", ";
                }
                flag = true;
                tempStr += "{id: \"" + arrayOfObject[0]
                        + "\", name: \"" + arrayOfObject[1] + "/"
                        + arrayOfObject[2] + "/"
                        + arrayOfObject[3] + "/"
                        + arrayOfObject[4] + "/"
                        + arrayOfObject[5] + "\"}";
            }
        }
        tempStr += "]";
        request.setAttribute("preList2", tempStr);
    }

    public void selectedEmployeeLevel3(HttpServletRequest request,
            EmployeeMaster employeeMaster) throws Exception {
        String tempStr = "";
        tempStr += "[";
        if (null != employeeMaster.getReportingManagerLevel3() && !employeeMaster.getReportingManagerLevel3().equals("")) {
            EmployeeMaster employeeMaster1;
            List<?> list1 = employeeMasterService.readByEmployeeLevel3Id(employeeMaster);
            employeeMaster = new EmployeeMaster();
            boolean flag = false;

            if (null != list1 && !list1.isEmpty()) {
                Object[] arrayOfObject = (Object[]) list1.get(0);
                if (flag) {
                    tempStr += ", ";
                }
                flag = true;
                tempStr += "{id: \"" + arrayOfObject[0]
                        + "\", name: \"" + arrayOfObject[1] + "/"
                        + arrayOfObject[2] + "/"
                        + arrayOfObject[3] + "/"
                        + arrayOfObject[4] + "/"
                        + arrayOfObject[5] + "\"}";
            }
        }
        tempStr += "]";
        request.setAttribute("preList3", tempStr);
    }

    public void selectedEmployeeLevel4(HttpServletRequest request,
            EmployeeMaster employeeMaster) throws Exception {
        String tempStr = "";
        tempStr += "[";
        if (null != employeeMaster.getReportingManagerLevel4() && !employeeMaster.getReportingManagerLevel4().equals("")) {
            EmployeeMaster employeeMaster1;
            List<?> list1 = employeeMasterService.readByEmployeeLevel4Id(employeeMaster);
            employeeMaster = new EmployeeMaster();
            boolean flag = false;

            if (null != list1 && !list1.isEmpty()) {
                Object[] arrayOfObject = (Object[]) list1.get(0);
                if (flag) {
                    tempStr += ", ";
                }
                flag = true;
                tempStr += "{id: \"" + arrayOfObject[0]
                        + "\", name: \"" + arrayOfObject[1] + "/"
                        + arrayOfObject[2] + "/"
                        + arrayOfObject[3] + "/"
                        + arrayOfObject[4] + "/"
                        + arrayOfObject[5] + "\"}";
            }
        }
        tempStr += "]";
        request.setAttribute("preList4", tempStr);
    }

    public void selectedEmployeeLevel5(HttpServletRequest request,
            EmployeeMaster employeeMaster) throws Exception {
        String tempStr = "";
        tempStr += "[";
        if (null != employeeMaster.getReportingManagerLevel5() && !employeeMaster.getReportingManagerLevel5().equals("")) {
            EmployeeMaster employeeMaster1;
            List<?> list1 = employeeMasterService.readByEmployeeLevel5Id(employeeMaster);
            employeeMaster = new EmployeeMaster();
            boolean flag = false;

            if (null != list1 && !list1.isEmpty()) {
                Object[] arrayOfObject = (Object[]) list1.get(0);
                if (flag) {
                    tempStr += ", ";
                }
                flag = true;
                tempStr += "{id: \"" + arrayOfObject[0]
                        + "\", name: \"" + arrayOfObject[1] + "/"
                        + arrayOfObject[2] + "/"
                        + arrayOfObject[3] + "/"
                        + arrayOfObject[4] + "/"
                        + arrayOfObject[5] + "\"}";
            }
        }
        tempStr += "]";
        request.setAttribute("preList5", tempStr);
    }

    public void selectedEmployeeLevel6(HttpServletRequest request,
            EmployeeMaster employeeMaster) throws Exception {
        String tempStr = "";
        tempStr += "[";
        if (null != employeeMaster.getReportingManagerLevel6() && !employeeMaster.getReportingManagerLevel6().equals("")) {
            EmployeeMaster employeeMaster1;
            List<?> list1 = employeeMasterService.readByEmployeeLevel6Id(employeeMaster);
            employeeMaster = new EmployeeMaster();
            boolean flag = false;

            if (null != list1 && !list1.isEmpty()) {
                Object[] arrayOfObject = (Object[]) list1.get(0);
                if (flag) {
                    tempStr += ", ";
                }
                flag = true;
                tempStr += "{id: \"" + arrayOfObject[0]
                        + "\", name: \"" + arrayOfObject[1] + "/"
                        + arrayOfObject[2] + "/"
                        + arrayOfObject[3] + "/"
                        + arrayOfObject[4] + "/"
                        + arrayOfObject[5] + "\"}";
            }
        }
        tempStr += "]";
        request.setAttribute("preList6", tempStr);
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

    //read user name by user Id for read imagefile name  
    protected String readUserName(HttpServletRequest request) {

        return userMasterService.readById(Integer.parseInt(request.getParameter("userid"))).getUserName();
    }

    protected void setDefaultUserRights(HttpServletRequest request, EmployeeMaster employeeMaster) {
        final boolean EMPLOYEE_RIGHT = true;
        UserRightMaster userRightMaster = new UserRightMaster();
        UserRightMaster userRightMaster1 = null;
        String userId = "";
        if (employeeMaster.getUserMaster() != null) {
            userId = userId + String.valueOf(employeeMaster.getUserMaster().getId());
        }
        List<?> list = userRightMasterService.readByUserId(userId);
        if (!list.isEmpty()) {
//             userRightMaster1 = new UserRightMaster();
            userRightMaster1 = (UserRightMaster) list.get(0);
            userRightMaster.setId(userRightMaster1.getId());
            userRightMasterService.update(userRightMaster);
        } else {
            userRightMaster.setEmployee(EMPLOYEE_RIGHT);
            userRightMaster.setUserMaster(employeeMaster.getUserMaster());
            //all other values are set as default in database.
            userRightMasterService.create(userRightMaster);
        }

    }

    protected void competencyList(HttpServletRequest request) {
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        List<?> competencyList = competencyEvaluationMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : competencyList) {
            competencyEvaluationMaster = (CompetencyEvaluationMaster) o;
            dm.put(competencyEvaluationMaster.getId(), competencyEvaluationMaster.getTitle());
        }

        request.setAttribute("competencyMap", dm);
    }

    public PmpFormStatusMasterService<PmpFormStatusMaster> getPmpFormStatusMasterService() {
        return pmpFormStatusMasterService;
    }

    public void setPmpFormStatusMasterService(PmpFormStatusMasterService<PmpFormStatusMaster> pmpFormStatusMasterService) {
        this.pmpFormStatusMasterService = pmpFormStatusMasterService;
    }

    public EmployeeTypeService<EmployeeTypeMaster> getEmployeeTypeService() {
        return employeeTypeService;
    }

    public void setEmployeeTypeService(EmployeeTypeService<EmployeeTypeMaster> employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    public EmployeeSubTypeService<EmployeeSubType> getEmployeeSubTypeService() {
        return employeeSubTypeService;
    }

    public void setEmployeeSubTypeService(EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService) {
        this.employeeSubTypeService = employeeSubTypeService;
    }

    public CompanyMasterService<Company> getCompanyMasterService() {
        return companyMasterService;
    }

    public void setCompanyMasterService(CompanyMasterService<Company> companyMasterService) {
        this.companyMasterService = companyMasterService;
    }

    public PolicyMasterService<PolicyMaster> getPolicyMasterService() {
        return policyMasterService;
    }

    public void setPolicyMasterService(PolicyMasterService<PolicyMaster> policyMasterService) {
        this.policyMasterService = policyMasterService;
    }

    public EmployeePolicyDetailService<EmployeePolicyDetail> getEmployeePolicyDetailService() {
        return employeePolicyDetailService;
    }

    public void setEmployeePolicyDetailService(EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService) {
        this.employeePolicyDetailService = employeePolicyDetailService;
    }

    public CandidateJobApplicationService<CandidateJobApplication> getCandidateJobApplicationService() {
        return candidateJobApplicationService;
    }

    public void setCandidateJobApplicationService(CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService) {
        this.candidateJobApplicationService = candidateJobApplicationService;
    }

    public CandidateJobApplyService<CandidateApplyJob> getCandidateJobApplyService() {
        return candidateJobApplyService;
    }

    public void setCandidateJobApplyService(CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService) {
        this.candidateJobApplyService = candidateJobApplyService;
    }

    public CtcAllowanceService<CtcAllowance> getCtcAllowanceService() {
        return ctcAllowanceService;
    }

    public void setCtcAllowanceService(CtcAllowanceService<CtcAllowance> ctcAllowanceService) {
        this.ctcAllowanceService = ctcAllowanceService;
    }

    public EmployeeCtcDetailService<EmployeeCtcDetail> getEmployeeCtcDetailService() {
        return employeeCtcDetailService;
    }

    public void setEmployeeCtcDetailService(EmployeeCtcDetailService<EmployeeCtcDetail> employeeCtcDetailService) {
        this.employeeCtcDetailService = employeeCtcDetailService;
    }

    public ApplayJobUserMasterService<ApplayJobUserMaster> getApplayJobUserMasterService() {
        return applayJobUserMasterService;
    }

    public void setApplayJobUserMasterService(ApplayJobUserMasterService<ApplayJobUserMaster> applayJobUserMasterService) {
        this.applayJobUserMasterService = applayJobUserMasterService;
    }
    
    

    protected void EmployeeTypeList(HttpServletRequest request) {
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        List<?> EmployeeTypeList = employeeTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : EmployeeTypeList) {
            employeeTypeMaster = (EmployeeTypeMaster) obj;
            map.put(employeeTypeMaster.getId(), employeeTypeMaster.getTypeOfEmployee());
        }
        request.setAttribute("EmployeeTypeList", map);
    }

    protected void EmployeeSubTypeList(HttpServletRequest request) {
        List<?> EmployeeSubTypeList = employeeSubTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : EmployeeSubTypeList) {
            EmployeeSubType employeeSubType = (EmployeeSubType) obj;
            map.put(employeeSubType.getId(), employeeSubType.getSubType());
        }
        request.setAttribute("EmployeeSubTypeList", map);
    }

    protected void EmpTypeAjaxmap(HttpServletRequest request, String empId) {
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        RotationMaster rotationMaster = new RotationMaster();
//        shiftRotationMaster.setId(Integer.parseInt(rotationId));
//        rotationMaster.setShiftRotationMaster(shiftRotationMaster);
        Map<Integer, String> shiftMap = new HashMap();
        List<?> list = null;
        if (!"".equals(empId)) {

            int rotationId1 = Integer.parseInt(empId);
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

    protected void companyList(HttpServletRequest request) {
        Company companyMaster = new Company();
        List<?> companyList = companyMasterService.read();

        Map<Integer, String> company = new HashMap<>();
        for (Object o : companyList) {
            companyMaster = (Company) o;
            company.put(companyMaster.getCompanyId(), companyMaster.getCompanyName());
        }
        request.setAttribute("company", company);
    }

    protected void policyList(HttpServletRequest request) {
        PolicyMaster policyMaster = new PolicyMaster();
        List<?> policyList = policyMasterService.read();

        Map<Integer, String> policy = new HashMap<>();
        for (Object o : policyList) {
            policyMaster = (PolicyMaster) o;
            policy.put(policyMaster.getId(), policyMaster.getPolicyName());
        }
        request.setAttribute("policy", policy);
    }

    protected void ctcList(HttpServletRequest request) {
        CtcAllowance ctcAllowance = new CtcAllowance();
        List<?> ctcList = ctcAllowanceService.read();

        Map<Integer, String> ctc = new HashMap<>();
        for (Object o : ctcList) {
            ctcAllowance = (CtcAllowance) o;
            ctc.put(ctcAllowance.getId(), ctcAllowance.getCtcName());
        }
        request.setAttribute("ctc", ctc);
    }

}

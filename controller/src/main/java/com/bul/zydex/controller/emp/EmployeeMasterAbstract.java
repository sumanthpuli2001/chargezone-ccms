/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emp;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.HoursBasis;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.RotationMaster;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.shift.HoursBasisService;
import com.bul.zydex.service.shift.RotationMasterService;
import com.bul.zydex.service.shift.ShiftGenerateMonthlyScheduleService;
import com.bul.zydex.service.shift.ShiftMasterService;
import com.bul.zydex.service.shift.ShiftRotationInfoService;
import com.bul.zydex.service.shift.ShiftRotationMasterService;
import com.bul.zydex.service.zydexLocation.ZydexLocationMasterService;
import java.util.HashMap;
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
        request.setAttribute("preList1", tempStr);
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

}

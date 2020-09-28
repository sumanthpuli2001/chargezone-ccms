/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.ApprenticesMaster;
import com.bul.zydex.model.ContractorMaster;
import com.bul.zydex.model.CouponMaster;
import com.bul.zydex.model.DeviceDetails;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.PunchedDataMaster;
import com.bul.zydex.model.RechargeInfoMaster;
import com.bul.zydex.model.RechargeMaster;
import com.bul.zydex.model.ReportMaster;
import com.bul.zydex.model.RightMaster;
import com.bul.zydex.model.SpecialCouponMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.Apprentices.ApprenticesService;
import com.bul.zydex.service.Contractor.ContractorService;
import com.bul.zydex.service.Coupon.CouponService;
import com.bul.zydex.service.Device.DeviceService;
import com.bul.zydex.service.Employee.EmployeeMasterService;
import com.bul.zydex.service.Log.LogService;
import com.bul.zydex.service.PunchedData.PunchedDataService;
import com.bul.zydex.service.Recharge.RechargeService;
import com.bul.zydex.service.RechargeInfo.RechargeInfoService;
import com.bul.zydex.service.Report.ReportService;
import com.bul.zydex.service.Right.RightService;
import com.bul.zydex.service.SpecialCoupon.SpecialCouponService;
import com.bul.zydex.service.UserMasterService;
import com.bul.zydex.util.SendMail;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Header;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Administrator
 */
public abstract class CustomAbstract extends MultiActionController {

    protected UserMasterService<UserMaster> userMasterService;
    protected EmployeeMasterService<EmployeeMaster> employeeMasterService;
    protected ContractorService<ContractorMaster> contractorService;
    protected ApprenticesService<ApprenticesMaster> apprenticesService;
    protected DeviceService<DeviceDetails> deviceService;
    protected CouponService<CouponMaster> couponService;
    protected RechargeService<RechargeMaster> rechargeService;
    protected SpecialCouponService<SpecialCouponMaster> specialCouponService;
    protected PunchedDataService<PunchedDataMaster> punchedDataService;
    protected RightService<RightMaster> rightService;
    protected RechargeInfoService<RechargeInfoMaster> rechargeInfoService;
    protected LogService<LogsMaster> logService;
    protected ReportService<ReportMaster> reportService;

    protected Header header;
    protected SendMail sendMail;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat timeFOrmat = new SimpleDateFormat("HH:mm:ss");

    public static String myIp;

    public SendMail getSendMail() {
        return sendMail;
    }

    public void setSendMail(SendMail sendMail) {
        this.sendMail = sendMail;
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

    public ContractorService<ContractorMaster> getContractorService() {
        return contractorService;
    }

    public void setContractorService(ContractorService<ContractorMaster> contractorService) {
        this.contractorService = contractorService;
    }

    public ApprenticesService<ApprenticesMaster> getApprenticesService() {
        return apprenticesService;
    }

    public void setApprenticesService(ApprenticesService<ApprenticesMaster> apprenticesService) {
        this.apprenticesService = apprenticesService;
    }

    public DeviceService<DeviceDetails> getDeviceService() {
        return deviceService;
    }

    public void setDeviceService(DeviceService<DeviceDetails> deviceService) {
        this.deviceService = deviceService;
    }

    public CouponService<CouponMaster> getCouponService() {
        return couponService;
    }

    public void setCouponService(CouponService<CouponMaster> couponService) {
        this.couponService = couponService;
    }

    public RechargeService<RechargeMaster> getRechargeService() {
        return rechargeService;
    }

    public void setRechargeService(RechargeService<RechargeMaster> rechargeService) {
        this.rechargeService = rechargeService;
    }

    public SpecialCouponService<SpecialCouponMaster> getSpecialCouponService() {
        return specialCouponService;
    }

    public void setSpecialCouponService(SpecialCouponService<SpecialCouponMaster> specialCouponService) {
        this.specialCouponService = specialCouponService;
    }

    public PunchedDataService<PunchedDataMaster> getPunchedDataService() {
        return punchedDataService;
    }

    public void setPunchedDataService(PunchedDataService<PunchedDataMaster> punchedDataService) {
        this.punchedDataService = punchedDataService;
    }

    public RightService<RightMaster> getRightService() {
        return rightService;
    }

    public void setRightService(RightService<RightMaster> rightService) {
        this.rightService = rightService;
    }

    public RechargeInfoService<RechargeInfoMaster> getRechargeInfoService() {
        return rechargeInfoService;
    }

    public void setRechargeInfoService(RechargeInfoService<RechargeInfoMaster> rechargeInfoService) {
        this.rechargeInfoService = rechargeInfoService;
    }

    public LogService<LogsMaster> getLogService() {
        return logService;
    }

    public void setLogService(LogService<LogsMaster> logService) {
        this.logService = logService;
    }

    public ReportService<ReportMaster> getReportService() {
        return reportService;
    }

    public void setReportService(ReportService<ReportMaster> reportService) {
        this.reportService = reportService;
    }

    @Override
    protected void bind(HttpServletRequest request, Object command)
            throws Exception {
        ServletRequestDataBinder binder = createBinder(request, command);
        binder.bind(request);
    }
    public static String encpass;

    public String encription(String pass) {

        try {
            MessageDigest algorithm = null;

            for (int loop = 0; loop < 10; loop++) {
                if (loop % 3 == 0) {
                    algorithm = MessageDigest.getInstance("SHA");
                } else {
                    algorithm = MessageDigest.getInstance("md5");
                }
                algorithm.reset();
                byte[] defaultBytes = pass.getBytes();
                algorithm.update(defaultBytes);
                byte messageDigest[] = algorithm.digest();

                StringBuffer hexString = new StringBuffer();
                for (int ij = 0; ij < messageDigest.length; ij++) {
                    hexString.append(Integer.toHexString(0xFF & messageDigest[ij]));
                }
                String foo = messageDigest.toString();
                pass = hexString.toString();
                encpass = pass;

            }

        }///END OF TRY
        catch (NoSuchAlgorithmException nsae) {
            System.out.println("ERROR!");
        }

        return encpass;
    }

    public void readCoupon(HttpServletRequest request, HttpServletResponse response) {
        List list = couponService.read();
        HashSet<String> couponType = new HashSet<>();
        Map<Integer, String> map = new HashMap<>();
        for (Object o : list) {
            CouponMaster cm = (CouponMaster) o;
            couponType.add(cm.getCouponType());
            map.put(cm.getSrNo(), cm.getCouponType());
        }
        request.setAttribute("couponType", couponType);
        request.setAttribute("couponMap", map);
    }

    public void readDesignation(HttpServletRequest request, HttpServletResponse response) {
        List list = employeeMasterService.read();
        HashSet<String> designationType = new HashSet<>();
        for (Object o : list) {
            EmployeeMaster em = (EmployeeMaster) o;
            designationType.add(em.getDesignation());
        }
        request.setAttribute("designationType", designationType);
    }

    public void readRights(HttpServletRequest request, HttpServletResponse response) {
        List list = rightService.read();
        HashSet<String> rightsType = new HashSet<>();
        for (Object o : list) {
            RightMaster cm = (RightMaster) o;
            rightsType.add(cm.getRightName());
        }
        request.setAttribute("rightsType", rightsType);
    }

    public void deviceNameIpRead(HttpServletRequest request) {
        List list = deviceService.read();
        Map<Integer, String> deviceList = new HashMap<>();
        for (Object o : list) {
            DeviceDetails dd = (DeviceDetails) o;
            deviceList.put(dd.getId(), dd.getDeviceDescription() + " - " + dd.getDeviceIP());
        }
        request.setAttribute("deviceList", deviceList);
    }

}

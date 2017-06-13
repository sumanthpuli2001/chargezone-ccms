/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.DeviceMaster;
import com.bul.zydex.model.DeviceMasterNotification;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.service.DeviceMasterNotificationService;
import com.bul.zydex.service.DeviceMasterService;
import com.bul.zydex.service.shift.EmployeeDatetimeDataService;
import org.springframework.validation.Validator;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class DeviceMasterAbstract extends CustomAbstract {

    protected DeviceMasterService<DeviceMaster> deviceMasterService;
    protected EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService;
    protected DeviceMasterNotificationService<DeviceMasterNotification> deviceMasterNotificationService;
    protected Validator deviceMasterValidator;

    public DeviceMasterService<DeviceMaster> getDeviceMasterService() {
        return deviceMasterService;
    }

    public void setDeviceMasterService(DeviceMasterService<DeviceMaster> deviceMasterService) {
        this.deviceMasterService = deviceMasterService;
    }

    public Validator getDeviceMasterValidator() {
        return deviceMasterValidator;
    }

    public void setDeviceMasterValidator(Validator deviceMasterValidator) {
        this.deviceMasterValidator = deviceMasterValidator;
    }

    public EmployeeDatetimeDataService<EmployeeDatetimeData> getEmployeeDatetimeDataService() {
        return employeeDatetimeDataService;
    }

    public void setEmployeeDatetimeDataService(EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService) {
        this.employeeDatetimeDataService = employeeDatetimeDataService;
    }

    public DeviceMasterNotificationService<DeviceMasterNotification> getDeviceMasterNotificationService() {
        return deviceMasterNotificationService;
    }

    public void setDeviceMasterNotificationService(DeviceMasterNotificationService<DeviceMasterNotification> deviceMasterNotificationService) {
        this.deviceMasterNotificationService = deviceMasterNotificationService;
    }

}

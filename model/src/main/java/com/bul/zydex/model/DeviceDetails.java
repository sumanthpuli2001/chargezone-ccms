/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman Bahukhandi
 */
public class DeviceDetails {

    private int id;
    private String deviceId;
    private String deviceIP;
    private String deviceDescription;
    private String workDisp;

    public DeviceDetails() {
    }

    public DeviceDetails(int id, String deviceId, String deviceIP, String deviceDescription, String workDisp) {
        this.id = id;
        this.deviceId = deviceId;
        this.deviceIP = deviceIP;
        this.deviceDescription = deviceDescription;
        this.workDisp = workDisp;
    }

    public int getId() {
        return id;
    }

    public DeviceDetails setId(int id) {
        this.id = id;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public DeviceDetails setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getDeviceIP() {
        return deviceIP;
    }

    public DeviceDetails setDeviceIP(String deviceIP) {
        this.deviceIP = deviceIP;
        return this;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public DeviceDetails setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
        return this;
    }

    public String getWorkDisp() {
        return workDisp;
    }

    public DeviceDetails setWorkDisp(String workDisp) {
        this.workDisp = workDisp;
        return this;
    }

}

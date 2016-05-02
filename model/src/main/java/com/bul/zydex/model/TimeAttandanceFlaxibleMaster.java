/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Dhaval
 */
public class TimeAttandanceFlaxibleMaster implements java.io.Serializable {

    private Integer id;
    private ZydexLocationMaster zydexLocationMaster;
    private String earlyFlexibleTime;
    private String lateFlexibleTime;

    public TimeAttandanceFlaxibleMaster() {
    }

    public TimeAttandanceFlaxibleMaster(ZydexLocationMaster zydexLocationMaster) {
        this.zydexLocationMaster = zydexLocationMaster;
    }

    public TimeAttandanceFlaxibleMaster(ZydexLocationMaster zydexLocationMaster, String earlyFlexibleTime, String lateFlexibleTime) {
        this.zydexLocationMaster = zydexLocationMaster;
        this.earlyFlexibleTime = earlyFlexibleTime;
        this.lateFlexibleTime = lateFlexibleTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZydexLocationMaster getZydexLocationMaster() {
        return zydexLocationMaster;
    }

    public void setZydexLocationMaster(ZydexLocationMaster zydexLocationMaster) {
        this.zydexLocationMaster = zydexLocationMaster;
    }

    public String getEarlyFlexibleTime() {
        return earlyFlexibleTime;
    }

    public void setEarlyFlexibleTime(String earlyFlexibleTime) {
        this.earlyFlexibleTime = earlyFlexibleTime;
    }

    public String getLateFlexibleTime() {
        return lateFlexibleTime;
    }

    public void setLateFlexibleTime(String lateFlexibleTime) {
        this.lateFlexibleTime = lateFlexibleTime;
    }
    
}

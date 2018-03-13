/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Hussain
 */
public class ClassifiedBox implements java.io.Serializable {

    private Integer id;
    private String advertisementName;
    private String description;
    private Integer createBy;
    private String createDate;
    private String updateDate;
    private Integer updateBy;
    private int status;

    public ClassifiedBox() {

    }

    public ClassifiedBox(Integer id, String advertisementName, String description, Integer createBy, String createDate, String updateDate, Integer updateBy, int status) {
        this.id = id;
        this.advertisementName = advertisementName;
        this.description = description;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdvertisementName() {
        return advertisementName;
    }

    public void setAdvertisementName(String advertisementName) {
        this.advertisementName = advertisementName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

   

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

   

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}

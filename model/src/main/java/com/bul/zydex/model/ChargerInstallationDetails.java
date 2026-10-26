/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Sumanth
 */
public class ChargerInstallationDetails {

    private int id;
    private int oapId;
    private String chargerType;
    private String charger;
    private String chargerCapacityKW;
    private String chargermodel;
    private String connectorType;
    private String noofconnectors;
    private String noofchargers;
    private String chargingrateperunit;
    private String chargerOther;
    private String connectorTypeOther;

    public ChargerInstallationDetails() {
    }

    public ChargerInstallationDetails(int id, int oapId, String chargerType, String charger, String chargerCapacityKW, String chargermodel, String connectorType, String noofconnectors, String noofchargers, String chargingrateperunit, String chargerOther, String connectorTypeOther) {
        this.id = id;
        this.oapId = oapId;
        this.chargerType = chargerType;
        this.charger = charger;
        this.chargerCapacityKW = chargerCapacityKW;
        this.chargermodel = chargermodel;
        this.connectorType = connectorType;
        this.noofconnectors = noofconnectors;
        this.noofchargers = noofchargers;
        this.chargingrateperunit = chargingrateperunit;
        this.chargerOther = chargerOther;
        this.connectorTypeOther = connectorTypeOther;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOapId() {
        return oapId;
    }

    public void setOapId(int oapId) {
        this.oapId = oapId;
    }

    public String getChargerType() {
        return chargerType;
    }

    public void setChargerType(String chargerType) {
        this.chargerType = chargerType;
    }

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger;
    }

    public String getChargerCapacityKW() {
        return chargerCapacityKW;
    }

    public void setChargerCapacityKW(String chargerCapacityKW) {
        this.chargerCapacityKW = chargerCapacityKW;
    }

    public String getChargermodel() {
        return chargermodel;
    }

    public void setChargermodel(String chargermodel) {
        this.chargermodel = chargermodel;
    }

    public String getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(String connectorType) {
        this.connectorType = connectorType;
    }

    public String getNoofconnectors() {
        return noofconnectors;
    }

    public void setNoofconnectors(String noofconnectors) {
        this.noofconnectors = noofconnectors;
    }

    public String getNoofchargers() {
        return noofchargers;
    }

    public void setNoofchargers(String noofchargers) {
        this.noofchargers = noofchargers;
    }

    public String getChargingrateperunit() {
        return chargingrateperunit;
    }

    public void setChargingrateperunit(String chargingrateperunit) {
        this.chargingrateperunit = chargingrateperunit;
    }

    public String getChargerOther() {
        return chargerOther;
    }

    public void setChargerOther(String chargerOther) {
        this.chargerOther = chargerOther;
    }

    public String getConnectorTypeOther() {
        return connectorTypeOther;
    }

    public void setConnectorTypeOther(String connectorTypeOther) {
        this.connectorTypeOther = connectorTypeOther;
    }

}

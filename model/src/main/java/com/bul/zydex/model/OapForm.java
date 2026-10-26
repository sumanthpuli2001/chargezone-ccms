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
public class OapForm {

    private int id;
    private String documentNo;
    private String pcsName;
    private String date;
    private String documentRevisionNo;
    private String projectName;
    private String pcsCityHighway;
    private String pcsAddress;
    private String pcsTypeCity;
    private String pcsTypeHighway;
    private String pcsModelDoco;
    private String pcsModelCoco;
    private String pcsModelDodo;
    private String pcsCoordinates;
    private String mobileNo;
    private String email;
    private String alternateMobileNo;
    private String clientDetails;
    private String specificRequriementsClients;
    private String salesLeadName;
    private String department;
    private String designation;
    private String salesDate;
    private String signature;
    private String agreementLoa;
    private String ownerShipDocument;
    private String preliminarySiteSurvey;
    private String consentLetterNoc;
    private String noOfGuns;
    private String timeLineFromDate;
    private String timeLineToDate;
    private String projectBudgetAllocated;
    private String kwAc77;
    private String kwDc15;
    private String kwDc30;
    private String kwDc60;
    private String kwDc120;
    private String kwDc180;
    private String kw240;
    private OapMaster oapMaster;
    private String userId;
    private String createdDate;
    private int flagStatus;
    private String assignedName;
    private String pcsTypeOther;
    private String pcsModelOther;
    private String clientScope;
    private String kwAcQuatity77;
    private String kwDcQuatity15;
    private String kwDcQuatity30;
    private String kwDcQuatity60;
    private String kwDcQuatity120;
    private String kwDcQuatity180;
    private String kwQuatity240;

    private String others;
    private String othersDetails;
    private String pcsTypeOtherCheck;
    private String pcsModelOtherCheck;

    private String aggrementAttach;
    private String ownershipAttach;
    private String preliminaryAttach;
    private String consentAttach;
    private String country;
    private String state;
    private String city;
    private String district;
    private String houseNo;
    private String projectCoordinater;
    private String comment;

    private String projectProfile;
    private String projectCenter;
    private String companyCode;
    private String plant;
    private String projectType;
    private String projectCurrency;
    private String inverstmentProfile;
    private String discom;
    private String noOfChargePoints;
    private String noOfCharger;
    private String overallStationCapacityKw;
    private String stationAcCapacityKw;
    private String stationDcCapacityKw;
    private String stationName;
    private String stationType;
    private String tenant;
    private String connectionType;
    private String chargingRatePerUnit;
    private String siteSurvey;
    private int surveyRadio;
    private int partiallyApproveFlag;
    private String approvedBy;
    private String approvedDate;
    private String crcAssignedBy;
    private String crcAssignedDate;
    private String crcCreatedDate;
    private String crcApprovedBy;
    private String crcApprovedDate;

    private String projectTimelineCategory;
    private String totalKwRating;
    private String totalChargerCapacity;
    private String chargerStationAccessType;
    private String auxiliaryLoadOfStation;
    private String chargingRetePerUnit;
    private String noOfEvsToBeChanged;
    private String additionOfNewChargerCapacity;
    private String specificDateFromClient;
    private String kwQuatity360;
    private String kwQuatity720;
    private String kw360;
    private String kw720;
    private String anchoreCustomer;
    private String canopyVarient;
    private String scopeOfchargeZone;
    private String totalMegaWatt;
    
    private String pcsModelSaas;
    
    
    
    public OapForm() {
    }

    public OapForm(int id, String documentNo, String pcsName, String date, String documentRevisionNo, String projectName, String pcsCityHighway, String pcsAddress, String pcsTypeCity, String pcsTypeHighway, String pcsModelDoco, String pcsModelCoco, String pcsModelDodo, String pcsCoordinates, String mobileNo, String email, String alternateMobileNo, String clientDetails, String specificRequriementsClients, String salesLeadName, String department, String designation, String salesDate, String signature, String agreementLoa, String ownerShipDocument, String preliminarySiteSurvey, String consentLetterNoc, String noOfGuns, String timeLineFromDate, String timeLineToDate, String projectBudgetAllocated, String kwAc77, String kwDc15, String kwDc30, String kwDc60, String kwDc120, String kwDc180, String kw240, OapMaster oapMaster, String userId, String createdDate, int flagStatus, String assignedName, String pcsTypeOther, String pcsModelOther, String clientScope, String kwAcQuatity77, String kwDcQuatity15, String kwDcQuatity30, String kwDcQuatity60, String kwDcQuatity120, String kwDcQuatity180, String kwQuatity240, String others, String othersDetails, String pcsTypeOtherCheck, String pcsModelOtherCheck, String aggrementAttach, String ownershipAttach, String preliminaryAttach, String consentAttach, String country, String state, String city, String district, String houseNo, String projectCoordinater, String comment, String projectProfile, String projectCenter, String companyCode, String plant, String projectType, String projectCurrency, String inverstmentProfile, String discom, String noOfChargePoints, String noOfCharger, String overallStationCapacityKw, String stationAcCapacityKw, String stationDcCapacityKw, String stationName, String stationType, String tenant, String connectionType, String chargingRatePerUnit, String siteSurvey, int surveyRadio, int partiallyApproveFlag, String approvedBy, String approvedDate, String crcAssignedBy, String crcAssignedDate, String crcCreatedDate, String crcApprovedBy, String crcApprovedDate) {
        this.id = id;
        this.documentNo = documentNo;
        this.pcsName = pcsName;
        this.date = date;
        this.documentRevisionNo = documentRevisionNo;
        this.projectName = projectName;
        this.pcsCityHighway = pcsCityHighway;
        this.pcsAddress = pcsAddress;
        this.pcsTypeCity = pcsTypeCity;
        this.pcsTypeHighway = pcsTypeHighway;
        this.pcsModelDoco = pcsModelDoco;
        this.pcsModelCoco = pcsModelCoco;
        this.pcsModelDodo = pcsModelDodo;
        this.pcsCoordinates = pcsCoordinates;
        this.mobileNo = mobileNo;
        this.email = email;
        this.alternateMobileNo = alternateMobileNo;
        this.clientDetails = clientDetails;
        this.specificRequriementsClients = specificRequriementsClients;
        this.salesLeadName = salesLeadName;
        this.department = department;
        this.designation = designation;
        this.salesDate = salesDate;
        this.signature = signature;
        this.agreementLoa = agreementLoa;
        this.ownerShipDocument = ownerShipDocument;
        this.preliminarySiteSurvey = preliminarySiteSurvey;
        this.consentLetterNoc = consentLetterNoc;
        this.noOfGuns = noOfGuns;
        this.timeLineFromDate = timeLineFromDate;
        this.timeLineToDate = timeLineToDate;
        this.projectBudgetAllocated = projectBudgetAllocated;
        this.kwAc77 = kwAc77;
        this.kwDc15 = kwDc15;
        this.kwDc30 = kwDc30;
        this.kwDc60 = kwDc60;
        this.kwDc120 = kwDc120;
        this.kwDc180 = kwDc180;
        this.kw240 = kw240;
        this.oapMaster = oapMaster;
        this.userId = userId;
        this.createdDate = createdDate;
        this.flagStatus = flagStatus;
        this.assignedName = assignedName;
        this.pcsTypeOther = pcsTypeOther;
        this.pcsModelOther = pcsModelOther;
        this.clientScope = clientScope;
        this.kwAcQuatity77 = kwAcQuatity77;
        this.kwDcQuatity15 = kwDcQuatity15;
        this.kwDcQuatity30 = kwDcQuatity30;
        this.kwDcQuatity60 = kwDcQuatity60;
        this.kwDcQuatity120 = kwDcQuatity120;
        this.kwDcQuatity180 = kwDcQuatity180;
        this.kwQuatity240 = kwQuatity240;
        this.others = others;
        this.othersDetails = othersDetails;
        this.pcsTypeOtherCheck = pcsTypeOtherCheck;
        this.pcsModelOtherCheck = pcsModelOtherCheck;
        this.aggrementAttach = aggrementAttach;
        this.ownershipAttach = ownershipAttach;
        this.preliminaryAttach = preliminaryAttach;
        this.consentAttach = consentAttach;
        this.country = country;
        this.state = state;
        this.city = city;
        this.district = district;
        this.houseNo = houseNo;
        this.projectCoordinater = projectCoordinater;
        this.comment = comment;
        this.projectProfile = projectProfile;
        this.projectCenter = projectCenter;
        this.companyCode = companyCode;
        this.plant = plant;
        this.projectType = projectType;
        this.projectCurrency = projectCurrency;
        this.inverstmentProfile = inverstmentProfile;
        this.discom = discom;
        this.noOfChargePoints = noOfChargePoints;
        this.noOfCharger = noOfCharger;
        this.overallStationCapacityKw = overallStationCapacityKw;
        this.stationAcCapacityKw = stationAcCapacityKw;
        this.stationDcCapacityKw = stationDcCapacityKw;
        this.stationName = stationName;
        this.stationType = stationType;
        this.tenant = tenant;
        this.connectionType = connectionType;
        this.chargingRatePerUnit = chargingRatePerUnit;
        this.siteSurvey = siteSurvey;
        this.surveyRadio = surveyRadio;
        this.partiallyApproveFlag = partiallyApproveFlag;
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
        this.crcAssignedBy = crcAssignedBy;
        this.crcAssignedDate = crcAssignedDate;
        this.crcCreatedDate = crcCreatedDate;
        this.crcApprovedBy = crcApprovedBy;
        this.crcApprovedDate = crcApprovedDate;
    }

    public OapForm(String projectTimelineCategory, String totalKwRating, String totalChargerCapacity, String chargerStationAccessType, String auxiliaryLoadOfStation, String chargingRetePerUnit, String noOfEvsToBeChanged, String additionOfNewChargerCapacity, String specificDateFromClient, String kwQuatity360, String kwQuatity720, String kw360, String kw720, String anchoreCustomer, String canopyVarient, String scopeOfchargeZone, String totalMegaWatt, String pcsModelSaas) {
        this.projectTimelineCategory = projectTimelineCategory;
        this.totalKwRating = totalKwRating;
        this.totalChargerCapacity = totalChargerCapacity;
        this.chargerStationAccessType = chargerStationAccessType;
        this.auxiliaryLoadOfStation = auxiliaryLoadOfStation;
        this.chargingRetePerUnit = chargingRetePerUnit;
        this.noOfEvsToBeChanged = noOfEvsToBeChanged;
        this.additionOfNewChargerCapacity = additionOfNewChargerCapacity;
        this.specificDateFromClient = specificDateFromClient;
        this.kwQuatity360 = kwQuatity360;
        this.kwQuatity720 = kwQuatity720;
        this.kw360 = kw360;
        this.kw720 = kw720;
        this.anchoreCustomer = anchoreCustomer;
        this.canopyVarient = canopyVarient;
        this.scopeOfchargeZone = scopeOfchargeZone;
        this.totalMegaWatt = totalMegaWatt;
        this.pcsModelSaas = pcsModelSaas;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getPcsName() {
        return pcsName;
    }

    public void setPcsName(String pcsName) {
        this.pcsName = pcsName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDocumentRevisionNo() {
        return documentRevisionNo;
    }

    public void setDocumentRevisionNo(String documentRevisionNo) {
        this.documentRevisionNo = documentRevisionNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPcsCityHighway() {
        return pcsCityHighway;
    }

    public void setPcsCityHighway(String pcsCityHighway) {
        this.pcsCityHighway = pcsCityHighway;
    }

    public String getPcsAddress() {
        return pcsAddress;
    }

    public void setPcsAddress(String pcsAddress) {
        this.pcsAddress = pcsAddress;
    }

    public String getPcsTypeCity() {
        return pcsTypeCity;
    }

    public void setPcsTypeCity(String pcsTypeCity) {
        this.pcsTypeCity = pcsTypeCity;
    }

    public String getPcsTypeHighway() {
        return pcsTypeHighway;
    }

    public void setPcsTypeHighway(String pcsTypeHighway) {
        this.pcsTypeHighway = pcsTypeHighway;
    }

    public String getPcsModelDoco() {
        return pcsModelDoco;
    }

    public void setPcsModelDoco(String pcsModelDoco) {
        this.pcsModelDoco = pcsModelDoco;
    }

    public String getPcsModelCoco() {
        return pcsModelCoco;
    }

    public void setPcsModelCoco(String pcsModelCoco) {
        this.pcsModelCoco = pcsModelCoco;
    }

    public String getPcsModelDodo() {
        return pcsModelDodo;
    }

    public void setPcsModelDodo(String pcsModelDodo) {
        this.pcsModelDodo = pcsModelDodo;
    }

    public String getPcsCoordinates() {
        return pcsCoordinates;
    }

    public void setPcsCoordinates(String pcsCoordinates) {
        this.pcsCoordinates = pcsCoordinates;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlternateMobileNo() {
        return alternateMobileNo;
    }

    public void setAlternateMobileNo(String alternateMobileNo) {
        this.alternateMobileNo = alternateMobileNo;
    }

    public String getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(String clientDetails) {
        this.clientDetails = clientDetails;
    }

    public String getSpecificRequriementsClients() {
        return specificRequriementsClients;
    }

    public void setSpecificRequriementsClients(String specificRequriementsClients) {
        this.specificRequriementsClients = specificRequriementsClients;
    }

    public String getSalesLeadName() {
        return salesLeadName;
    }

    public void setSalesLeadName(String salesLeadName) {
        this.salesLeadName = salesLeadName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAgreementLoa() {
        return agreementLoa;
    }

    public void setAgreementLoa(String agreementLoa) {
        this.agreementLoa = agreementLoa;
    }

    public String getOwnerShipDocument() {
        return ownerShipDocument;
    }

    public void setOwnerShipDocument(String ownerShipDocument) {
        this.ownerShipDocument = ownerShipDocument;
    }

    public String getPreliminarySiteSurvey() {
        return preliminarySiteSurvey;
    }

    public void setPreliminarySiteSurvey(String preliminarySiteSurvey) {
        this.preliminarySiteSurvey = preliminarySiteSurvey;
    }

    public String getConsentLetterNoc() {
        return consentLetterNoc;
    }

    public void setConsentLetterNoc(String consentLetterNoc) {
        this.consentLetterNoc = consentLetterNoc;
    }

    public String getNoOfGuns() {
        return noOfGuns;
    }

    public void setNoOfGuns(String noOfGuns) {
        this.noOfGuns = noOfGuns;
    }

    public String getTimeLineFromDate() {
        return timeLineFromDate;
    }

    public void setTimeLineFromDate(String timeLineFromDate) {
        this.timeLineFromDate = timeLineFromDate;
    }

    public String getTimeLineToDate() {
        return timeLineToDate;
    }

    public void setTimeLineToDate(String timeLineToDate) {
        this.timeLineToDate = timeLineToDate;
    }

    public String getProjectBudgetAllocated() {
        return projectBudgetAllocated;
    }

    public void setProjectBudgetAllocated(String projectBudgetAllocated) {
        this.projectBudgetAllocated = projectBudgetAllocated;
    }

    public String getKwAc77() {
        return kwAc77;
    }

    public void setKwAc77(String kwAc77) {
        this.kwAc77 = kwAc77;
    }

    public String getKwDc15() {
        return kwDc15;
    }

    public void setKwDc15(String kwDc15) {
        this.kwDc15 = kwDc15;
    }

    public String getKwDc30() {
        return kwDc30;
    }

    public void setKwDc30(String kwDc30) {
        this.kwDc30 = kwDc30;
    }

    public String getKwDc60() {
        return kwDc60;
    }

    public void setKwDc60(String kwDc60) {
        this.kwDc60 = kwDc60;
    }

    public String getKwDc120() {
        return kwDc120;
    }

    public void setKwDc120(String kwDc120) {
        this.kwDc120 = kwDc120;
    }

    public String getKwDc180() {
        return kwDc180;
    }

    public void setKwDc180(String kwDc180) {
        this.kwDc180 = kwDc180;
    }

    public String getKw240() {
        return kw240;
    }

    public void setKw240(String kw240) {
        this.kw240 = kw240;
    }

    public OapMaster getOapMaster() {
        return oapMaster;
    }

    public void setOapMaster(OapMaster oapMaster) {
        this.oapMaster = oapMaster;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(int flagStatus) {
        this.flagStatus = flagStatus;
    }

    public String getAssignedName() {
        return assignedName;
    }

    public void setAssignedName(String assignedName) {
        this.assignedName = assignedName;
    }

    public String getPcsTypeOther() {
        return pcsTypeOther;
    }

    public void setPcsTypeOther(String pcsTypeOther) {
        this.pcsTypeOther = pcsTypeOther;
    }

    public String getPcsModelOther() {
        return pcsModelOther;
    }

    public void setPcsModelOther(String pcsModelOther) {
        this.pcsModelOther = pcsModelOther;
    }

    public String getClientScope() {
        return clientScope;
    }

    public void setClientScope(String clientScope) {
        this.clientScope = clientScope;
    }

    public String getKwAcQuatity77() {
        return kwAcQuatity77;
    }

    public void setKwAcQuatity77(String kwAcQuatity77) {
        this.kwAcQuatity77 = kwAcQuatity77;
    }

    public String getKwDcQuatity15() {
        return kwDcQuatity15;
    }

    public void setKwDcQuatity15(String kwDcQuatity15) {
        this.kwDcQuatity15 = kwDcQuatity15;
    }

    public String getKwDcQuatity30() {
        return kwDcQuatity30;
    }

    public void setKwDcQuatity30(String kwDcQuatity30) {
        this.kwDcQuatity30 = kwDcQuatity30;
    }

    public String getKwDcQuatity60() {
        return kwDcQuatity60;
    }

    public void setKwDcQuatity60(String kwDcQuatity60) {
        this.kwDcQuatity60 = kwDcQuatity60;
    }

    public String getKwDcQuatity120() {
        return kwDcQuatity120;
    }

    public void setKwDcQuatity120(String kwDcQuatity120) {
        this.kwDcQuatity120 = kwDcQuatity120;
    }

    public String getKwDcQuatity180() {
        return kwDcQuatity180;
    }

    public void setKwDcQuatity180(String kwDcQuatity180) {
        this.kwDcQuatity180 = kwDcQuatity180;
    }

    public String getKwQuatity240() {
        return kwQuatity240;
    }

    public void setKwQuatity240(String kwQuatity240) {
        this.kwQuatity240 = kwQuatity240;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getOthersDetails() {
        return othersDetails;
    }

    public void setOthersDetails(String othersDetails) {
        this.othersDetails = othersDetails;
    }

    public String getPcsTypeOtherCheck() {
        return pcsTypeOtherCheck;
    }

    public void setPcsTypeOtherCheck(String pcsTypeOtherCheck) {
        this.pcsTypeOtherCheck = pcsTypeOtherCheck;
    }

    public String getPcsModelOtherCheck() {
        return pcsModelOtherCheck;
    }

    public void setPcsModelOtherCheck(String pcsModelOtherCheck) {
        this.pcsModelOtherCheck = pcsModelOtherCheck;
    }

    public String getAggrementAttach() {
        return aggrementAttach;
    }

    public void setAggrementAttach(String aggrementAttach) {
        this.aggrementAttach = aggrementAttach;
    }

    public String getOwnershipAttach() {
        return ownershipAttach;
    }

    public void setOwnershipAttach(String ownershipAttach) {
        this.ownershipAttach = ownershipAttach;
    }

    public String getPreliminaryAttach() {
        return preliminaryAttach;
    }

    public void setPreliminaryAttach(String preliminaryAttach) {
        this.preliminaryAttach = preliminaryAttach;
    }

    public String getConsentAttach() {
        return consentAttach;
    }

    public void setConsentAttach(String consentAttach) {
        this.consentAttach = consentAttach;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getProjectCoordinater() {
        return projectCoordinater;
    }

    public void setProjectCoordinater(String projectCoordinater) {
        this.projectCoordinater = projectCoordinater;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProjectProfile() {
        return projectProfile;
    }

    public void setProjectProfile(String projectProfile) {
        this.projectProfile = projectProfile;
    }

    public String getProjectCenter() {
        return projectCenter;
    }

    public void setProjectCenter(String projectCenter) {
        this.projectCenter = projectCenter;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectCurrency() {
        return projectCurrency;
    }

    public void setProjectCurrency(String projectCurrency) {
        this.projectCurrency = projectCurrency;
    }

    public String getInverstmentProfile() {
        return inverstmentProfile;
    }

    public void setInverstmentProfile(String inverstmentProfile) {
        this.inverstmentProfile = inverstmentProfile;
    }

    public String getDiscom() {
        return discom;
    }

    public void setDiscom(String discom) {
        this.discom = discom;
    }

    public String getNoOfChargePoints() {
        return noOfChargePoints;
    }

    public void setNoOfChargePoints(String noOfChargePoints) {
        this.noOfChargePoints = noOfChargePoints;
    }

    public String getNoOfCharger() {
        return noOfCharger;
    }

    public void setNoOfCharger(String noOfCharger) {
        this.noOfCharger = noOfCharger;
    }

    public String getOverallStationCapacityKw() {
        return overallStationCapacityKw;
    }

    public void setOverallStationCapacityKw(String overallStationCapacityKw) {
        this.overallStationCapacityKw = overallStationCapacityKw;
    }

    public String getStationAcCapacityKw() {
        return stationAcCapacityKw;
    }

    public void setStationAcCapacityKw(String stationAcCapacityKw) {
        this.stationAcCapacityKw = stationAcCapacityKw;
    }

    public String getStationDcCapacityKw() {
        return stationDcCapacityKw;
    }

    public void setStationDcCapacityKw(String stationDcCapacityKw) {
        this.stationDcCapacityKw = stationDcCapacityKw;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getChargingRatePerUnit() {
        return chargingRatePerUnit;
    }

    public void setChargingRatePerUnit(String chargingRatePerUnit) {
        this.chargingRatePerUnit = chargingRatePerUnit;
    }

    public String getSiteSurvey() {
        return siteSurvey;
    }

    public void setSiteSurvey(String siteSurvey) {
        this.siteSurvey = siteSurvey;
    }

    public int getSurveyRadio() {
        return surveyRadio;
    }

    public void setSurveyRadio(int surveyRadio) {
        this.surveyRadio = surveyRadio;
    }

    public int getPartiallyApproveFlag() {
        return partiallyApproveFlag;
    }

    public void setPartiallyApproveFlag(int partiallyApproveFlag) {
        this.partiallyApproveFlag = partiallyApproveFlag;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getCrcAssignedBy() {
        return crcAssignedBy;
    }

    public void setCrcAssignedBy(String crcAssignedBy) {
        this.crcAssignedBy = crcAssignedBy;
    }

    public String getCrcAssignedDate() {
        return crcAssignedDate;
    }

    public void setCrcAssignedDate(String crcAssignedDate) {
        this.crcAssignedDate = crcAssignedDate;
    }

    public String getCrcCreatedDate() {
        return crcCreatedDate;
    }

    public void setCrcCreatedDate(String crcCreatedDate) {
        this.crcCreatedDate = crcCreatedDate;
    }

    public String getCrcApprovedBy() {
        return crcApprovedBy;
    }

    public void setCrcApprovedBy(String crcApprovedBy) {
        this.crcApprovedBy = crcApprovedBy;
    }

    public String getCrcApprovedDate() {
        return crcApprovedDate;
    }

    public void setCrcApprovedDate(String crcApprovedDate) {
        this.crcApprovedDate = crcApprovedDate;
    }

    public String getProjectTimelineCategory() {
        return projectTimelineCategory;
    }

    public void setProjectTimelineCategory(String projectTimelineCategory) {
        this.projectTimelineCategory = projectTimelineCategory;
    }

    public String getTotalKwRating() {
        return totalKwRating;
    }

    public void setTotalKwRating(String totalKwRating) {
        this.totalKwRating = totalKwRating;
    }

    public String getTotalChargerCapacity() {
        return totalChargerCapacity;
    }

    public void setTotalChargerCapacity(String totalChargerCapacity) {
        this.totalChargerCapacity = totalChargerCapacity;
    }

    public String getChargerStationAccessType() {
        return chargerStationAccessType;
    }

    public void setChargerStationAccessType(String chargerStationAccessType) {
        this.chargerStationAccessType = chargerStationAccessType;
    }

    public String getAuxiliaryLoadOfStation() {
        return auxiliaryLoadOfStation;
    }

    public void setAuxiliaryLoadOfStation(String auxiliaryLoadOfStation) {
        this.auxiliaryLoadOfStation = auxiliaryLoadOfStation;
    }

    public String getChargingRetePerUnit() {
        return chargingRetePerUnit;
    }

    public void setChargingRetePerUnit(String chargingRetePerUnit) {
        this.chargingRetePerUnit = chargingRetePerUnit;
    }

    public String getNoOfEvsToBeChanged() {
        return noOfEvsToBeChanged;
    }

    public void setNoOfEvsToBeChanged(String noOfEvsToBeChanged) {
        this.noOfEvsToBeChanged = noOfEvsToBeChanged;
    }

    public String getAdditionOfNewChargerCapacity() {
        return additionOfNewChargerCapacity;
    }

    public void setAdditionOfNewChargerCapacity(String additionOfNewChargerCapacity) {
        this.additionOfNewChargerCapacity = additionOfNewChargerCapacity;
    }

    public String getSpecificDateFromClient() {
        return specificDateFromClient;
    }

    public void setSpecificDateFromClient(String specificDateFromClient) {
        this.specificDateFromClient = specificDateFromClient;
    }

    public String getKwQuatity360() {
        return kwQuatity360;
    }

    public void setKwQuatity360(String kwQuatity360) {
        this.kwQuatity360 = kwQuatity360;
    }

    public String getKwQuatity720() {
        return kwQuatity720;
    }

    public void setKwQuatity720(String kwQuatity720) {
        this.kwQuatity720 = kwQuatity720;
    }

    public String getKw360() {
        return kw360;
    }

    public void setKw360(String kw360) {
        this.kw360 = kw360;
    }

    public String getKw720() {
        return kw720;
    }

    public void setKw720(String kw720) {
        this.kw720 = kw720;
    }

    public String getAnchoreCustomer() {
        return anchoreCustomer;
    }

    public void setAnchoreCustomer(String anchoreCustomer) {
        this.anchoreCustomer = anchoreCustomer;
    }

    public String getCanopyVarient() {
        return canopyVarient;
    }

    public void setCanopyVarient(String canopyVarient) {
        this.canopyVarient = canopyVarient;
    }

    public String getScopeOfchargeZone() {
        return scopeOfchargeZone;
    }

    public void setScopeOfchargeZone(String scopeOfchargeZone) {
        this.scopeOfchargeZone = scopeOfchargeZone;
    }

    public String getTotalMegaWatt() {
        return totalMegaWatt;
    }

    public void setTotalMegaWatt(String totalMegaWatt) {
        this.totalMegaWatt = totalMegaWatt;
    }

    public String getPcsModelSaas() {
        return pcsModelSaas;
    }

    public void setPcsModelSaas(String pcsModelSaas) {
        this.pcsModelSaas = pcsModelSaas;
    }

}

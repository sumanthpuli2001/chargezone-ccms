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
public class AocForm {

    private int id;
    private String documentNo;
    private String hubDepoName;
    private String bb2;
    private String bbc22;
    private String hubDepoAddress;
    private String clientProjectName;
    private String googleCoordinates;
    private String pcTypeCar;
    private String pcTypeBus;
    private String pcTypeTruckLmv;
    private String other;
    private String finacialModelCapex;
    private String finacialModelOpex;
    private String coOrdinates;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNo;
    private String alternateMobileNo;
    private String email;
    private String specificReqClients;
    private String assumptionSheet;
    private String assumptionRefNo;
    private String assumptionDate;
    private String estimatedBoq;
    private String estimatedRefNo;
    private String estimatedDate;
    private String loaLoi;
    private String loaLoiRefNo;
    private String loaLoiDate;
    private String agreement;
    private String agreementRefNo;
    private String agreementDate;
    private String layoutDrawings;
    private String layoutRefNo;
    private String layoutDate;
    private String operations;
    private String operationsSign;
    private String maintenance;
    private String maintenanceSign;
    private String zeroDate;
    private String completionDate;
    private String projectBudgetAllocated;
    private String authorityComments;
    private String orderEffcectiveDate;
    private String newRevisionNo;
    private String budjectAllocationDate;
    private String reviewedBy;
    private String designation;
    private String signatureDate;
    private OapMaster oapMaster;
    private String userId;
    private String createdDate;
    private int flagStatus;
    private String assignedName;
    private String bc2;
    private String pcsType;
    private String chargeScope;
    private String clientScope;

    private String assumptionAttach;
    private String estimatedAttach;
    private String loaAttach;
    private String agreementAttach;
    private String layoutAttach;
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
    private String approvedBy;
    private String approvedDate;
    private String kickOffAssignBy;
    private String kickOffAsignDate;
    private String kickOffFormCreatedDate;
    private String kickOffFormApprovedBy;
    private String kickOffFormApprovedDate;

    private String projectTimelineCategory;
    private String totalKwRating;
    private String totalChargerCapacity;
    private String chargerStationAccessType;
    private String auxiliaryLoadOfStation;
    private String chargingRetePerUnit;
    private String noOfEvsToBeChanged;
    private String additionOfNewChargerCapacity;
    private String specificDateFromClient;
    private String anchoreCustomer;
    private String canopyVarient;
    private String scopeOfchargeZone;
    private String totalMegaWatt;

    public AocForm() {
    }

    public AocForm(int id, String documentNo, String hubDepoName, String bb2, String bbc22, String hubDepoAddress, String clientProjectName, String googleCoordinates, String pcTypeCar, String pcTypeBus, String pcTypeTruckLmv, String other, String finacialModelCapex, String finacialModelOpex, String coOrdinates, String firstName, String middleName, String lastName, String mobileNo, String alternateMobileNo, String email, String specificReqClients, String assumptionSheet, String assumptionRefNo, String assumptionDate, String estimatedBoq, String estimatedRefNo, String estimatedDate, String loaLoi, String loaLoiRefNo, String loaLoiDate, String agreement, String agreementRefNo, String agreementDate, String layoutDrawings, String layoutRefNo, String layoutDate, String operations, String operationsSign, String maintenance, String maintenanceSign, String zeroDate, String completionDate, String projectBudgetAllocated, String authorityComments, String orderEffcectiveDate, String newRevisionNo, String budjectAllocationDate, String reviewedBy, String designation, String signatureDate, OapMaster oapMaster, String userId, String createdDate, int flagStatus, String assignedName, String bc2, String pcsType, String chargeScope, String clientScope, String assumptionAttach, String estimatedAttach, String loaAttach, String agreementAttach, String layoutAttach, String country, String state, String city, String district, String houseNo, String projectCoordinater, String comment, String projectProfile, String projectCenter, String companyCode, String plant, String projectType, String projectCurrency, String inverstmentProfile, String discom, String noOfChargePoints, String noOfCharger, String overallStationCapacityKw, String stationAcCapacityKw, String stationDcCapacityKw, String stationName, String stationType, String tenant, String connectionType, String chargingRatePerUnit, String siteSurvey, int surveyRadio, String approvedBy, String approvedDate, String kickOffAssignBy, String kickOffAsignDate, String kickOffFormCreatedDate, String kickOffFormApprovedBy, String kickOffFormApprovedDate) {
        this.id = id;
        this.documentNo = documentNo;
        this.hubDepoName = hubDepoName;
        this.bb2 = bb2;
        this.bbc22 = bbc22;
        this.hubDepoAddress = hubDepoAddress;
        this.clientProjectName = clientProjectName;
        this.googleCoordinates = googleCoordinates;
        this.pcTypeCar = pcTypeCar;
        this.pcTypeBus = pcTypeBus;
        this.pcTypeTruckLmv = pcTypeTruckLmv;
        this.other = other;
        this.finacialModelCapex = finacialModelCapex;
        this.finacialModelOpex = finacialModelOpex;
        this.coOrdinates = coOrdinates;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.alternateMobileNo = alternateMobileNo;
        this.email = email;
        this.specificReqClients = specificReqClients;
        this.assumptionSheet = assumptionSheet;
        this.assumptionRefNo = assumptionRefNo;
        this.assumptionDate = assumptionDate;
        this.estimatedBoq = estimatedBoq;
        this.estimatedRefNo = estimatedRefNo;
        this.estimatedDate = estimatedDate;
        this.loaLoi = loaLoi;
        this.loaLoiRefNo = loaLoiRefNo;
        this.loaLoiDate = loaLoiDate;
        this.agreement = agreement;
        this.agreementRefNo = agreementRefNo;
        this.agreementDate = agreementDate;
        this.layoutDrawings = layoutDrawings;
        this.layoutRefNo = layoutRefNo;
        this.layoutDate = layoutDate;
        this.operations = operations;
        this.operationsSign = operationsSign;
        this.maintenance = maintenance;
        this.maintenanceSign = maintenanceSign;
        this.zeroDate = zeroDate;
        this.completionDate = completionDate;
        this.projectBudgetAllocated = projectBudgetAllocated;
        this.authorityComments = authorityComments;
        this.orderEffcectiveDate = orderEffcectiveDate;
        this.newRevisionNo = newRevisionNo;
        this.budjectAllocationDate = budjectAllocationDate;
        this.reviewedBy = reviewedBy;
        this.designation = designation;
        this.signatureDate = signatureDate;
        this.oapMaster = oapMaster;
        this.userId = userId;
        this.createdDate = createdDate;
        this.flagStatus = flagStatus;
        this.assignedName = assignedName;
        this.bc2 = bc2;
        this.pcsType = pcsType;
        this.chargeScope = chargeScope;
        this.clientScope = clientScope;
        this.assumptionAttach = assumptionAttach;
        this.estimatedAttach = estimatedAttach;
        this.loaAttach = loaAttach;
        this.agreementAttach = agreementAttach;
        this.layoutAttach = layoutAttach;
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
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
        this.kickOffAssignBy = kickOffAssignBy;
        this.kickOffAsignDate = kickOffAsignDate;
        this.kickOffFormCreatedDate = kickOffFormCreatedDate;
        this.kickOffFormApprovedBy = kickOffFormApprovedBy;
        this.kickOffFormApprovedDate = kickOffFormApprovedDate;
    }

    public AocForm(String projectTimelineCategory, String totalKwRating, String totalChargerCapacity, String chargerStationAccessType, String auxiliaryLoadOfStation, String chargingRetePerUnit, String noOfEvsToBeChanged, String additionOfNewChargerCapacity, String specificDateFromClient, String anchoreCustomer, String canopyVarient, String scopeOfchargeZone, String totalMegaWatt) {
        this.projectTimelineCategory = projectTimelineCategory;
        this.totalKwRating = totalKwRating;
        this.totalChargerCapacity = totalChargerCapacity;
        this.chargerStationAccessType = chargerStationAccessType;
        this.auxiliaryLoadOfStation = auxiliaryLoadOfStation;
        this.chargingRetePerUnit = chargingRetePerUnit;
        this.noOfEvsToBeChanged = noOfEvsToBeChanged;
        this.additionOfNewChargerCapacity = additionOfNewChargerCapacity;
        this.specificDateFromClient = specificDateFromClient;
        this.anchoreCustomer = anchoreCustomer;
        this.canopyVarient = canopyVarient;
        this.scopeOfchargeZone = scopeOfchargeZone;
        this.totalMegaWatt = totalMegaWatt;
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

    public String getHubDepoName() {
        return hubDepoName;
    }

    public void setHubDepoName(String hubDepoName) {
        this.hubDepoName = hubDepoName;
    }

    public String getBb2() {
        return bb2;
    }

    public void setBb2(String bb2) {
        this.bb2 = bb2;
    }

    public String getBbc22() {
        return bbc22;
    }

    public void setBbc22(String bbc22) {
        this.bbc22 = bbc22;
    }

    public String getHubDepoAddress() {
        return hubDepoAddress;
    }

    public void setHubDepoAddress(String hubDepoAddress) {
        this.hubDepoAddress = hubDepoAddress;
    }

    public String getClientProjectName() {
        return clientProjectName;
    }

    public void setClientProjectName(String clientProjectName) {
        this.clientProjectName = clientProjectName;
    }

    public String getGoogleCoordinates() {
        return googleCoordinates;
    }

    public void setGoogleCoordinates(String googleCoordinates) {
        this.googleCoordinates = googleCoordinates;
    }

    public String getPcTypeCar() {
        return pcTypeCar;
    }

    public void setPcTypeCar(String pcTypeCar) {
        this.pcTypeCar = pcTypeCar;
    }

    public String getPcTypeBus() {
        return pcTypeBus;
    }

    public void setPcTypeBus(String pcTypeBus) {
        this.pcTypeBus = pcTypeBus;
    }

    public String getPcTypeTruckLmv() {
        return pcTypeTruckLmv;
    }

    public void setPcTypeTruckLmv(String pcTypeTruckLmv) {
        this.pcTypeTruckLmv = pcTypeTruckLmv;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getFinacialModelCapex() {
        return finacialModelCapex;
    }

    public void setFinacialModelCapex(String finacialModelCapex) {
        this.finacialModelCapex = finacialModelCapex;
    }

    public String getFinacialModelOpex() {
        return finacialModelOpex;
    }

    public void setFinacialModelOpex(String finacialModelOpex) {
        this.finacialModelOpex = finacialModelOpex;
    }

    public String getCoOrdinates() {
        return coOrdinates;
    }

    public void setCoOrdinates(String coOrdinates) {
        this.coOrdinates = coOrdinates;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAlternateMobileNo() {
        return alternateMobileNo;
    }

    public void setAlternateMobileNo(String alternateMobileNo) {
        this.alternateMobileNo = alternateMobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecificReqClients() {
        return specificReqClients;
    }

    public void setSpecificReqClients(String specificReqClients) {
        this.specificReqClients = specificReqClients;
    }

    public String getAssumptionSheet() {
        return assumptionSheet;
    }

    public void setAssumptionSheet(String assumptionSheet) {
        this.assumptionSheet = assumptionSheet;
    }

    public String getAssumptionRefNo() {
        return assumptionRefNo;
    }

    public void setAssumptionRefNo(String assumptionRefNo) {
        this.assumptionRefNo = assumptionRefNo;
    }

    public String getAssumptionDate() {
        return assumptionDate;
    }

    public void setAssumptionDate(String assumptionDate) {
        this.assumptionDate = assumptionDate;
    }

    public String getEstimatedBoq() {
        return estimatedBoq;
    }

    public void setEstimatedBoq(String estimatedBoq) {
        this.estimatedBoq = estimatedBoq;
    }

    public String getEstimatedRefNo() {
        return estimatedRefNo;
    }

    public void setEstimatedRefNo(String estimatedRefNo) {
        this.estimatedRefNo = estimatedRefNo;
    }

    public String getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(String estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public String getLoaLoi() {
        return loaLoi;
    }

    public void setLoaLoi(String loaLoi) {
        this.loaLoi = loaLoi;
    }

    public String getLoaLoiRefNo() {
        return loaLoiRefNo;
    }

    public void setLoaLoiRefNo(String loaLoiRefNo) {
        this.loaLoiRefNo = loaLoiRefNo;
    }

    public String getLoaLoiDate() {
        return loaLoiDate;
    }

    public void setLoaLoiDate(String loaLoiDate) {
        this.loaLoiDate = loaLoiDate;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getAgreementRefNo() {
        return agreementRefNo;
    }

    public void setAgreementRefNo(String agreementRefNo) {
        this.agreementRefNo = agreementRefNo;
    }

    public String getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(String agreementDate) {
        this.agreementDate = agreementDate;
    }

    public String getLayoutDrawings() {
        return layoutDrawings;
    }

    public void setLayoutDrawings(String layoutDrawings) {
        this.layoutDrawings = layoutDrawings;
    }

    public String getLayoutRefNo() {
        return layoutRefNo;
    }

    public void setLayoutRefNo(String layoutRefNo) {
        this.layoutRefNo = layoutRefNo;
    }

    public String getLayoutDate() {
        return layoutDate;
    }

    public void setLayoutDate(String layoutDate) {
        this.layoutDate = layoutDate;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getOperationsSign() {
        return operationsSign;
    }

    public void setOperationsSign(String operationsSign) {
        this.operationsSign = operationsSign;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public String getMaintenanceSign() {
        return maintenanceSign;
    }

    public void setMaintenanceSign(String maintenanceSign) {
        this.maintenanceSign = maintenanceSign;
    }

    public String getZeroDate() {
        return zeroDate;
    }

    public void setZeroDate(String zeroDate) {
        this.zeroDate = zeroDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getProjectBudgetAllocated() {
        return projectBudgetAllocated;
    }

    public void setProjectBudgetAllocated(String projectBudgetAllocated) {
        this.projectBudgetAllocated = projectBudgetAllocated;
    }

    public String getAuthorityComments() {
        return authorityComments;
    }

    public void setAuthorityComments(String authorityComments) {
        this.authorityComments = authorityComments;
    }

    public String getOrderEffcectiveDate() {
        return orderEffcectiveDate;
    }

    public void setOrderEffcectiveDate(String orderEffcectiveDate) {
        this.orderEffcectiveDate = orderEffcectiveDate;
    }

    public String getNewRevisionNo() {
        return newRevisionNo;
    }

    public void setNewRevisionNo(String newRevisionNo) {
        this.newRevisionNo = newRevisionNo;
    }

    public String getBudjectAllocationDate() {
        return budjectAllocationDate;
    }

    public void setBudjectAllocationDate(String budjectAllocationDate) {
        this.budjectAllocationDate = budjectAllocationDate;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(String signatureDate) {
        this.signatureDate = signatureDate;
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

    public String getBc2() {
        return bc2;
    }

    public void setBc2(String bc2) {
        this.bc2 = bc2;
    }

    public String getPcsType() {
        return pcsType;
    }

    public void setPcsType(String pcsType) {
        this.pcsType = pcsType;
    }

    public String getChargeScope() {
        return chargeScope;
    }

    public void setChargeScope(String chargeScope) {
        this.chargeScope = chargeScope;
    }

    public String getClientScope() {
        return clientScope;
    }

    public void setClientScope(String clientScope) {
        this.clientScope = clientScope;
    }

    public String getAssumptionAttach() {
        return assumptionAttach;
    }

    public void setAssumptionAttach(String assumptionAttach) {
        this.assumptionAttach = assumptionAttach;
    }

    public String getEstimatedAttach() {
        return estimatedAttach;
    }

    public void setEstimatedAttach(String estimatedAttach) {
        this.estimatedAttach = estimatedAttach;
    }

    public String getLoaAttach() {
        return loaAttach;
    }

    public void setLoaAttach(String loaAttach) {
        this.loaAttach = loaAttach;
    }

    public String getAgreementAttach() {
        return agreementAttach;
    }

    public void setAgreementAttach(String agreementAttach) {
        this.agreementAttach = agreementAttach;
    }

    public String getLayoutAttach() {
        return layoutAttach;
    }

    public void setLayoutAttach(String layoutAttach) {
        this.layoutAttach = layoutAttach;
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

    public String getKickOffAssignBy() {
        return kickOffAssignBy;
    }

    public void setKickOffAssignBy(String kickOffAssignBy) {
        this.kickOffAssignBy = kickOffAssignBy;
    }

    public String getKickOffAsignDate() {
        return kickOffAsignDate;
    }

    public void setKickOffAsignDate(String kickOffAsignDate) {
        this.kickOffAsignDate = kickOffAsignDate;
    }

    public String getKickOffFormCreatedDate() {
        return kickOffFormCreatedDate;
    }

    public void setKickOffFormCreatedDate(String kickOffFormCreatedDate) {
        this.kickOffFormCreatedDate = kickOffFormCreatedDate;
    }

    public String getKickOffFormApprovedBy() {
        return kickOffFormApprovedBy;
    }

    public void setKickOffFormApprovedBy(String kickOffFormApprovedBy) {
        this.kickOffFormApprovedBy = kickOffFormApprovedBy;
    }

    public String getKickOffFormApprovedDate() {
        return kickOffFormApprovedDate;
    }

    public void setKickOffFormApprovedDate(String kickOffFormApprovedDate) {
        this.kickOffFormApprovedDate = kickOffFormApprovedDate;
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

}

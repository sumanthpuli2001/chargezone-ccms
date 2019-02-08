package com.bul.zydex.model;

public class EmployeeMasterExtension implements java.io.Serializable {

    private int id;
    private String presentAddress2;
    private String presentCity;
    private String presentState;
    private String presentPostalCode;
    private String presentCountry;
    private String permanentAddress2;
    private String permanentCity;
    private String permanentState;
    private String permanentPostalCode;
    private String permanentCountry;
    private String religion;
    private String disclosedHealthConcerns;
    private String languagesKnown;
    private String hobbies;
    private Boolean childOneGender;
    private Boolean childTwoGender;
    private String flyDocsEmailId;
    private String emergencyContactAddress;
    private String RelationShip;
    private String otherImpInfo;
    private String nationality;
    private String firstName;
    private String middleName;
    private String lastName;
    private String countryOfIssue;
    private String visaIssueCountry;
    private String visaIssueDate;
    private String visaValidTillDate;
    private String drivingLicenceType;
    private String electionCard;
    private String pfNoFlydocs;
    private String withdrawalDate;
    private String nameOfPreviousCompany;
    private String previousCompanyLocation;
    private EmployeeMaster employeeMaster;
    private Boolean nameStatus;
    private Boolean spouseGender;
    private String documentIdNo;
    private String subteamTransferDate;
    private String officialContactNumber;

    public EmployeeMasterExtension() {
    }

   

    public EmployeeMasterExtension(String presentAddress2, String presentCity, String presentState, String presentPostalCode, String presentCountry, String permanentAddress2, String permanentCity, String permanentState, String permanentPostalCode, String permanentCountry, String religion, String disclosedHealthConcerns, String languagesKnown, String hobbies, Boolean childOneGender, Boolean childTwoGender, String flyDocsEmailId, String emergencyContactAddress, String RelationShip, String otherImpInfo, String nationality, String firstName, String middleName, String lastName, String countryOfIssue, String visaIssueCountry, String visaIssueDate, String visaValidTillDate, String drivingLicenceType, String electionCard, String pfNoFlydocs, String withdrawalDate, String nameOfPreviousCompany, String previousCompanyLocation, EmployeeMaster employeeMaster,Boolean nameStatus, Boolean spouseGender,String documentIdNo,String subteamTransferDate,String officialContactNumber) {
        this.presentAddress2 = presentAddress2;
        this.presentCity = presentCity;
        this.presentState = presentState;
        this.presentPostalCode = presentPostalCode;
        this.presentCountry = presentCountry;
        this.permanentAddress2 = permanentAddress2;
        this.permanentCity = permanentCity;
        this.permanentState = permanentState;
        this.permanentPostalCode = permanentPostalCode;
        this.permanentCountry = permanentCountry;
        this.religion = religion;
        this.disclosedHealthConcerns = disclosedHealthConcerns;
        this.languagesKnown = languagesKnown;
        this.hobbies = hobbies;
        this.childOneGender = childOneGender;
        this.childTwoGender = childTwoGender;
        this.flyDocsEmailId = flyDocsEmailId;
        this.emergencyContactAddress = emergencyContactAddress;
        this.RelationShip = RelationShip;
        this.otherImpInfo = otherImpInfo;
        this.nationality = nationality;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.countryOfIssue = countryOfIssue;
        this.visaIssueCountry = visaIssueCountry;
        this.visaIssueDate = visaIssueDate;
        this.visaValidTillDate = visaValidTillDate;
        this.drivingLicenceType = drivingLicenceType;
        this.electionCard = electionCard;
        this.pfNoFlydocs = pfNoFlydocs;
        this.withdrawalDate = withdrawalDate;
        this.nameOfPreviousCompany = nameOfPreviousCompany;
        this.previousCompanyLocation = previousCompanyLocation;
        this.employeeMaster = employeeMaster;
        this.nameStatus = nameStatus;
        this.spouseGender = spouseGender;
        this.documentIdNo = documentIdNo;
        this.subteamTransferDate = subteamTransferDate;
        this.officialContactNumber =officialContactNumber;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPresentAddress2() {
        return presentAddress2;
    }

    public void setPresentAddress2(String presentAddress2) {
        this.presentAddress2 = presentAddress2;
    }

    public String getPresentCity() {
        return presentCity;
    }

    public void setPresentCity(String presentCity) {
        this.presentCity = presentCity;
    }

    public String getPresentState() {
        return presentState;
    }

    public void setPresentState(String presentState) {
        this.presentState = presentState;
    }

    public String getPresentPostalCode() {
        return presentPostalCode;
    }

    public void setPresentPostalCode(String presentPostalCode) {
        this.presentPostalCode = presentPostalCode;
    }

    public String getPresentCountry() {
        return presentCountry;
    }

    public void setPresentCountry(String presentCountry) {
        this.presentCountry = presentCountry;
    }

    public String getPermanentAddress2() {
        return permanentAddress2;
    }

    public void setPermanentAddress2(String permanentAddress2) {
        this.permanentAddress2 = permanentAddress2;
    }

    public String getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = permanentCity;
    }

    public String getPermanentState() {
        return permanentState;
    }

    public void setPermanentState(String permanentState) {
        this.permanentState = permanentState;
    }

    public String getPermanentPostalCode() {
        return permanentPostalCode;
    }

    public void setPermanentPostalCode(String permanentPostalCode) {
        this.permanentPostalCode = permanentPostalCode;
    }

    public String getPermanentCountry() {
        return permanentCountry;
    }

    public void setPermanentCountry(String permanentCountry) {
        this.permanentCountry = permanentCountry;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getDisclosedHealthConcerns() {
        return disclosedHealthConcerns;
    }

    public void setDisclosedHealthConcerns(String disclosedHealthConcerns) {
        this.disclosedHealthConcerns = disclosedHealthConcerns;
    }

    public String getLanguagesKnown() {
        return languagesKnown;
    }

    public void setLanguagesKnown(String languagesKnown) {
        this.languagesKnown = languagesKnown;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Boolean getChildOneGender() {
        return childOneGender;
    }

    public void setChildOneGender(Boolean childOneGender) {
        this.childOneGender = childOneGender;
    }

    public Boolean getChildTwoGender() {
        return childTwoGender;
    }

    public void setChildTwoGender(Boolean childTwoGender) {
        this.childTwoGender = childTwoGender;
    }

    public String getFlyDocsEmailId() {
        return flyDocsEmailId;
    }

    public void setFlyDocsEmailId(String flyDocsEmailId) {
        this.flyDocsEmailId = flyDocsEmailId;
    }

    public String getEmergencyContactAddress() {
        return emergencyContactAddress;
    }

    public void setEmergencyContactAddress(String emergencyContactAddress) {
        this.emergencyContactAddress = emergencyContactAddress;
    }

    public String getRelationShip() {
        return RelationShip;
    }

    public void setRelationShip(String RelationShip) {
        this.RelationShip = RelationShip;
    }

    public String getOtherImpInfo() {
        return otherImpInfo;
    }

    public void setOtherImpInfo(String otherImpInfo) {
        this.otherImpInfo = otherImpInfo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public String getVisaIssueCountry() {
        return visaIssueCountry;
    }

    public void setVisaIssueCountry(String visaIssueCountry) {
        this.visaIssueCountry = visaIssueCountry;
    }

    public String getVisaIssueDate() {
        return visaIssueDate;
    }

    public void setVisaIssueDate(String visaIssueDate) {
        this.visaIssueDate = visaIssueDate;
    }

    public String getVisaValidTillDate() {
        return visaValidTillDate;
    }

    public void setVisaValidTillDate(String visaValidTillDate) {
        this.visaValidTillDate = visaValidTillDate;
    }

    public String getDrivingLicenceType() {
        return drivingLicenceType;
    }

    public void setDrivingLicenceType(String drivingLicenceType) {
        this.drivingLicenceType = drivingLicenceType;
    }

    public String getElectionCard() {
        return electionCard;
    }

    public void setElectionCard(String electionCard) {
        this.electionCard = electionCard;
    }

    public String getPfNoFlydocs() {
        return pfNoFlydocs;
    }

    public void setPfNoFlydocs(String pfNoFlydocs) {
        this.pfNoFlydocs = pfNoFlydocs;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getNameOfPreviousCompany() {
        return nameOfPreviousCompany;
    }

    public void setNameOfPreviousCompany(String nameOfPreviousCompany) {
        this.nameOfPreviousCompany = nameOfPreviousCompany;
    }

    public String getPreviousCompanyLocation() {
        return previousCompanyLocation;
    }

    public void setPreviousCompanyLocation(String previousCompanyLocation) {
        this.previousCompanyLocation = previousCompanyLocation;
    }
    
    
    

    public EmployeeMaster getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }

    public Boolean getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(Boolean nameStatus) {
        this.nameStatus = nameStatus;
    }

    public Boolean getSpouseGender() {
        return spouseGender;
    }

    public void setSpouseGender(Boolean SpouseGender) {
        this.spouseGender = SpouseGender;
    }

    public String getDocumentIdNo() {
        return documentIdNo;
    }

    public void setDocumentIdNo(String documentIdNo) {
        this.documentIdNo = documentIdNo;
    }

    public String getSubteamTransferDate() {
        return subteamTransferDate;
    }

    public void setSubteamTransferDate(String subteamTransferDate) {
        this.subteamTransferDate = subteamTransferDate;
    }

    public String getOfficialContactNumber() {
        return officialContactNumber;
    }

    public void setOfficialContactNumber(String officialContactNumber) {
        this.officialContactNumber = officialContactNumber;
    }

    
}

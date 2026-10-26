/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Administrator
 */
public class VendorSelfDeclaration {

    private int id;
    private int vendorInformationId;
    private String desDecOne;
    private int desDecOneFlag;
    private String desDecTwo;
    private int desDecTwoFlag;

    private String altLocalAddress;
    private String altLocalAddress1;
    private String altLocalAddress2;
    private String altCity;
    private String altDistrict;
    private String altState;
    private String altCountry;
    private String altPostalCode;
    private String altTelephone;
    private String altEmail;
    private String altWebsite;

    private String infName;
    private String infDesignatoin;
    private String infContactNo;
    private String infEmail;
    private String infDob;
    private String infNationality;
    private String infPostalAddress;
    private String infCity;
    private String infState;
    private String infCountry;
    private String infPostalCode;

    private String thirdName;
    private String thirdEmail;
    private String thirdTelephone;
    private String thirdCountry;

    private String thirdNameTwo;
    private String thirdEmailTwo;
    private String thirdTelephoneTwo;
    private String thirdCountryTwo;

    private String litigationHistoryDes;
    private int litigationHistoryDesFlag;

    private String politicalContributionDes;
    private int politicalContributionDesFlag;

    private String conflictInsterestDes;
    private int conflictInsterestDesFlag;

    private String executiveJudicialDes;
    private int executiveJudicialDesFlag;

    private String politicallyExposedDesOne;
    private int politicallyExposedDesOneFlag;

    private String politicallyExposedDesTwo;
    private int politicallyExposedDesTwoFlag;

    private String politicallyExposedDesThree;
    private int politicallyExposedDesThreeFlag;

    private String natureServicesOne;
    private int natureServicesOneFlag;

    private String natureServicesTwo;
    private int natureServicesTwoFlag;

    private String ndaOne;
    private int ndaOneFlag;

    private String ndaTwo;
    private int ndaTwoFlag;

    public VendorSelfDeclaration() {
    }

    public VendorSelfDeclaration(int id, int vendorInformationId, String desDecOne, int desDecOneFlag, String desDecTwo, int desDecTwoFlag, String altLocalAddress, String altLocalAddress1, String altLocalAddress2, String altCity, String altDistrict, String altState, String altCountry, String altPostalCode, String altTelephone, String altEmail, String altWebsite, String infName, String infDesignatoin, String infContactNo, String infEmail, String infDob, String infNationality, String infPostalAddress, String infCity, String infState, String infCountry, String infPostalCode, String thirdName, String thirdEmail, String thirdTelephone, String thirdCountry, String thirdNameTwo, String thirdEmailTwo, String thirdTelephoneTwo, String thirdCountryTwo, String litigationHistoryDes, int litigationHistoryDesFlag, String politicalContributionDes, int politicalContributionDesFlag, String conflictInsterestDes, int conflictInsterestDesFlag, String executiveJudicialDes, int executiveJudicialDesFlag, String politicallyExposedDesOne, int politicallyExposedDesOneFlag, String politicallyExposedDesTwo, int politicallyExposedDesTwoFlag, String politicallyExposedDesThree, int politicallyExposedDesThreeFlag, String natureServicesOne, int natureServicesOneFlag, String natureServicesTwo, int natureServicesTwoFlag, String ndaOne, int ndaOneFlag, String ndaTwo, int ndaTwoFlag) {
        this.id = id;
        this.vendorInformationId = vendorInformationId;
        this.desDecOne = desDecOne;
        this.desDecOneFlag = desDecOneFlag;
        this.desDecTwo = desDecTwo;
        this.desDecTwoFlag = desDecTwoFlag;
        this.altLocalAddress = altLocalAddress;
        this.altLocalAddress1 = altLocalAddress1;
        this.altLocalAddress2 = altLocalAddress2;
        this.altCity = altCity;
        this.altDistrict = altDistrict;
        this.altState = altState;
        this.altCountry = altCountry;
        this.altPostalCode = altPostalCode;
        this.altTelephone = altTelephone;
        this.altEmail = altEmail;
        this.altWebsite = altWebsite;
        this.infName = infName;
        this.infDesignatoin = infDesignatoin;
        this.infContactNo = infContactNo;
        this.infEmail = infEmail;
        this.infDob = infDob;
        this.infNationality = infNationality;
        this.infPostalAddress = infPostalAddress;
        this.infCity = infCity;
        this.infState = infState;
        this.infCountry = infCountry;
        this.infPostalCode = infPostalCode;
        this.thirdName = thirdName;
        this.thirdEmail = thirdEmail;
        this.thirdTelephone = thirdTelephone;
        this.thirdCountry = thirdCountry;
        this.thirdNameTwo = thirdNameTwo;
        this.thirdEmailTwo = thirdEmailTwo;
        this.thirdTelephoneTwo = thirdTelephoneTwo;
        this.thirdCountryTwo = thirdCountryTwo;
        this.litigationHistoryDes = litigationHistoryDes;
        this.litigationHistoryDesFlag = litigationHistoryDesFlag;
        this.politicalContributionDes = politicalContributionDes;
        this.politicalContributionDesFlag = politicalContributionDesFlag;
        this.conflictInsterestDes = conflictInsterestDes;
        this.conflictInsterestDesFlag = conflictInsterestDesFlag;
        this.executiveJudicialDes = executiveJudicialDes;
        this.executiveJudicialDesFlag = executiveJudicialDesFlag;
        this.politicallyExposedDesOne = politicallyExposedDesOne;
        this.politicallyExposedDesOneFlag = politicallyExposedDesOneFlag;
        this.politicallyExposedDesTwo = politicallyExposedDesTwo;
        this.politicallyExposedDesTwoFlag = politicallyExposedDesTwoFlag;
        this.politicallyExposedDesThree = politicallyExposedDesThree;
        this.politicallyExposedDesThreeFlag = politicallyExposedDesThreeFlag;
        this.natureServicesOne = natureServicesOne;
        this.natureServicesOneFlag = natureServicesOneFlag;
        this.natureServicesTwo = natureServicesTwo;
        this.natureServicesTwoFlag = natureServicesTwoFlag;
        this.ndaOne = ndaOne;
        this.ndaOneFlag = ndaOneFlag;
        this.ndaTwo = ndaTwo;
        this.ndaTwoFlag = ndaTwoFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorInformationId() {
        return vendorInformationId;
    }

    public void setVendorInformationId(int vendorInformationId) {
        this.vendorInformationId = vendorInformationId;
    }

    public String getDesDecOne() {
        return desDecOne;
    }

    public void setDesDecOne(String desDecOne) {
        this.desDecOne = desDecOne;
    }

    public int getDesDecOneFlag() {
        return desDecOneFlag;
    }

    public void setDesDecOneFlag(int desDecOneFlag) {
        this.desDecOneFlag = desDecOneFlag;
    }

    public String getDesDecTwo() {
        return desDecTwo;
    }

    public void setDesDecTwo(String desDecTwo) {
        this.desDecTwo = desDecTwo;
    }

    public int getDesDecTwoFlag() {
        return desDecTwoFlag;
    }

    public void setDesDecTwoFlag(int desDecTwoFlag) {
        this.desDecTwoFlag = desDecTwoFlag;
    }

    public String getAltLocalAddress() {
        return altLocalAddress;
    }

    public void setAltLocalAddress(String altLocalAddress) {
        this.altLocalAddress = altLocalAddress;
    }

    public String getAltLocalAddress1() {
        return altLocalAddress1;
    }

    public void setAltLocalAddress1(String altLocalAddress1) {
        this.altLocalAddress1 = altLocalAddress1;
    }

    public String getAltLocalAddress2() {
        return altLocalAddress2;
    }

    public void setAltLocalAddress2(String altLocalAddress2) {
        this.altLocalAddress2 = altLocalAddress2;
    }

    public String getAltDistrict() {
        return altDistrict;
    }

    public void setAltDistrict(String altDistrict) {
        this.altDistrict = altDistrict;
    }

    public String getAltCity() {
        return altCity;
    }

    public void setAltCity(String altCity) {
        this.altCity = altCity;
    }

    public String getAltState() {
        return altState;
    }

    public void setAltState(String altState) {
        this.altState = altState;
    }

    public String getAltCountry() {
        return altCountry;
    }

    public void setAltCountry(String altCountry) {
        this.altCountry = altCountry;
    }

    public String getAltPostalCode() {
        return altPostalCode;
    }

    public void setAltPostalCode(String altPostalCode) {
        this.altPostalCode = altPostalCode;
    }

    public String getAltTelephone() {
        return altTelephone;
    }

    public void setAltTelephone(String altTelephone) {
        this.altTelephone = altTelephone;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public String getAltWebsite() {
        return altWebsite;
    }

    public void setAltWebsite(String altWebsite) {
        this.altWebsite = altWebsite;
    }

    public String getInfName() {
        return infName;
    }

    public void setInfName(String infName) {
        this.infName = infName;
    }

    public String getInfDesignatoin() {
        return infDesignatoin;
    }

    public void setInfDesignatoin(String infDesignatoin) {
        this.infDesignatoin = infDesignatoin;
    }

    public String getInfContactNo() {
        return infContactNo;
    }

    public void setInfContactNo(String infContactNo) {
        this.infContactNo = infContactNo;
    }

    public String getInfEmail() {
        return infEmail;
    }

    public void setInfEmail(String infEmail) {
        this.infEmail = infEmail;
    }

    public String getInfDob() {
        return infDob;
    }

    public void setInfDob(String infDob) {
        this.infDob = infDob;
    }

    public String getInfNationality() {
        return infNationality;
    }

    public void setInfNationality(String infNationality) {
        this.infNationality = infNationality;
    }

    public String getInfPostalAddress() {
        return infPostalAddress;
    }

    public void setInfPostalAddress(String infPostalAddress) {
        this.infPostalAddress = infPostalAddress;
    }

    public String getInfCity() {
        return infCity;
    }

    public void setInfCity(String infCity) {
        this.infCity = infCity;
    }

    public String getInfState() {
        return infState;
    }

    public void setInfState(String infState) {
        this.infState = infState;
    }

    public String getInfCountry() {
        return infCountry;
    }

    public void setInfCountry(String infCountry) {
        this.infCountry = infCountry;
    }

    public String getInfPostalCode() {
        return infPostalCode;
    }

    public void setInfPostalCode(String infPostalCode) {
        this.infPostalCode = infPostalCode;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getThirdEmail() {
        return thirdEmail;
    }

    public void setThirdEmail(String thirdEmail) {
        this.thirdEmail = thirdEmail;
    }

    public String getThirdTelephone() {
        return thirdTelephone;
    }

    public void setThirdTelephone(String thirdTelephone) {
        this.thirdTelephone = thirdTelephone;
    }

    public String getThirdCountry() {
        return thirdCountry;
    }

    public void setThirdCountry(String thirdCountry) {
        this.thirdCountry = thirdCountry;
    }

    public String getThirdNameTwo() {
        return thirdNameTwo;
    }

    public void setThirdNameTwo(String thirdNameTwo) {
        this.thirdNameTwo = thirdNameTwo;
    }

    public String getThirdEmailTwo() {
        return thirdEmailTwo;
    }

    public void setThirdEmailTwo(String thirdEmailTwo) {
        this.thirdEmailTwo = thirdEmailTwo;
    }

    public String getThirdTelephoneTwo() {
        return thirdTelephoneTwo;
    }

    public void setThirdTelephoneTwo(String thirdTelephoneTwo) {
        this.thirdTelephoneTwo = thirdTelephoneTwo;
    }

    public String getThirdCountryTwo() {
        return thirdCountryTwo;
    }

    public void setThirdCountryTwo(String thirdCountryTwo) {
        this.thirdCountryTwo = thirdCountryTwo;
    }

    public String getLitigationHistoryDes() {
        return litigationHistoryDes;
    }

    public void setLitigationHistoryDes(String litigationHistoryDes) {
        this.litigationHistoryDes = litigationHistoryDes;
    }

    public int getLitigationHistoryDesFlag() {
        return litigationHistoryDesFlag;
    }

    public void setLitigationHistoryDesFlag(int litigationHistoryDesFlag) {
        this.litigationHistoryDesFlag = litigationHistoryDesFlag;
    }

    public String getPoliticalContributionDes() {
        return politicalContributionDes;
    }

    public void setPoliticalContributionDes(String politicalContributionDes) {
        this.politicalContributionDes = politicalContributionDes;
    }

    public int getPoliticalContributionDesFlag() {
        return politicalContributionDesFlag;
    }

    public void setPoliticalContributionDesFlag(int politicalContributionDesFlag) {
        this.politicalContributionDesFlag = politicalContributionDesFlag;
    }

    public String getConflictInsterestDes() {
        return conflictInsterestDes;
    }

    public void setConflictInsterestDes(String conflictInsterestDes) {
        this.conflictInsterestDes = conflictInsterestDes;
    }

    public int getConflictInsterestDesFlag() {
        return conflictInsterestDesFlag;
    }

    public void setConflictInsterestDesFlag(int conflictInsterestDesFlag) {
        this.conflictInsterestDesFlag = conflictInsterestDesFlag;
    }

    public String getExecutiveJudicialDes() {
        return executiveJudicialDes;
    }

    public void setExecutiveJudicialDes(String executiveJudicialDes) {
        this.executiveJudicialDes = executiveJudicialDes;
    }

    public int getExecutiveJudicialDesFlag() {
        return executiveJudicialDesFlag;
    }

    public void setExecutiveJudicialDesFlag(int executiveJudicialDesFlag) {
        this.executiveJudicialDesFlag = executiveJudicialDesFlag;
    }

    public String getPoliticallyExposedDesOne() {
        return politicallyExposedDesOne;
    }

    public void setPoliticallyExposedDesOne(String politicallyExposedDesOne) {
        this.politicallyExposedDesOne = politicallyExposedDesOne;
    }

    public int getPoliticallyExposedDesOneFlag() {
        return politicallyExposedDesOneFlag;
    }

    public void setPoliticallyExposedDesOneFlag(int politicallyExposedDesOneFlag) {
        this.politicallyExposedDesOneFlag = politicallyExposedDesOneFlag;
    }

    public String getPoliticallyExposedDesTwo() {
        return politicallyExposedDesTwo;
    }

    public void setPoliticallyExposedDesTwo(String politicallyExposedDesTwo) {
        this.politicallyExposedDesTwo = politicallyExposedDesTwo;
    }

    public int getPoliticallyExposedDesTwoFlag() {
        return politicallyExposedDesTwoFlag;
    }

    public void setPoliticallyExposedDesTwoFlag(int politicallyExposedDesTwoFlag) {
        this.politicallyExposedDesTwoFlag = politicallyExposedDesTwoFlag;
    }

    public String getPoliticallyExposedDesThree() {
        return politicallyExposedDesThree;
    }

    public void setPoliticallyExposedDesThree(String politicallyExposedDesThree) {
        this.politicallyExposedDesThree = politicallyExposedDesThree;
    }

    public int getPoliticallyExposedDesThreeFlag() {
        return politicallyExposedDesThreeFlag;
    }

    public void setPoliticallyExposedDesThreeFlag(int politicallyExposedDesThreeFlag) {
        this.politicallyExposedDesThreeFlag = politicallyExposedDesThreeFlag;
    }

    public String getNatureServicesOne() {
        return natureServicesOne;
    }

    public void setNatureServicesOne(String natureServicesOne) {
        this.natureServicesOne = natureServicesOne;
    }

    public int getNatureServicesOneFlag() {
        return natureServicesOneFlag;
    }

    public void setNatureServicesOneFlag(int natureServicesOneFlag) {
        this.natureServicesOneFlag = natureServicesOneFlag;
    }

    public String getNatureServicesTwo() {
        return natureServicesTwo;
    }

    public void setNatureServicesTwo(String natureServicesTwo) {
        this.natureServicesTwo = natureServicesTwo;
    }

    public int getNatureServicesTwoFlag() {
        return natureServicesTwoFlag;
    }

    public void setNatureServicesTwoFlag(int natureServicesTwoFlag) {
        this.natureServicesTwoFlag = natureServicesTwoFlag;
    }

    public String getNdaOne() {
        return ndaOne;
    }

    public void setNdaOne(String ndaOne) {
        this.ndaOne = ndaOne;
    }

    public int getNdaOneFlag() {
        return ndaOneFlag;
    }

    public void setNdaOneFlag(int ndaOneFlag) {
        this.ndaOneFlag = ndaOneFlag;
    }

    public String getNdaTwo() {
        return ndaTwo;
    }

    public void setNdaTwo(String ndaTwo) {
        this.ndaTwo = ndaTwo;
    }

    public int getNdaTwoFlag() {
        return ndaTwoFlag;
    }

    public void setNdaTwoFlag(int ndaTwoFlag) {
        this.ndaTwoFlag = ndaTwoFlag;
    }

}

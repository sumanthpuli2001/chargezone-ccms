/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorInformation;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorInformationDao<T> extends GenericsDAO<T> {

    public VendorInformation readEmailId(String email);

    public VendorInformation readID(int id);

    public List readEmail(String email);

    public List readId(int id);

    public void updateterms(String vendorEmailId, String termsFile);

    public void updatepolicy(String vendorEmailId, String policyFile1, String policyFile2);

    public void updateone(String email, String typeOfConcern, String officeAddressLine1, String officeAddressLine2, String officeAddressLine3, String officeCity, String officeDistrict, String officeState, String officePin, String officeCountry, String officeTelephone, String officeMobile, String officeFax, String officeEmail, String officeWebsite, String officeWeeklyHoliday, String officeContactPersonName, String officeContactDesignation, String officeContactMobile, String officeContactEmail, String workAddressLine1, String workAddressLine2, String workAddressLine3, String workCity, String workState, String workPin, String workCountry, String workTelephone, String workMobile, String workFax, String workEmail, String workWebsite, String workWeeklyHoliday, String workContactPersonName, String workContactDesignation, String workContactMobile, String workContactEmail, String good, String service, String contract, String traders, String establishment, String sales_name, String sales_job, String sales_phone, String technical_name, String technical_job, String technical_phone, String quality_name, String quality_job, String quality_phone, String panNo, String panFile, String gstinNo, String gstinFile, String cst_no, String cst_file, String vat_pin, String vat_file, String ecc_no, String ecc_file, String service_tax, String service_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String serviceType, String update, String secoundMobile, String cancelcheck, String saleEmail, String technicalContactEmail, String qualityEmail, String pfNo, String cicNo, String pfAttachment, String cicAttachment, String finical1, String finical2, String finical3, String finicalAttachment1, String finicalAttachment2, String finicalAttachment3, String finicalAmount1, String finicalAmount2, String finicalAmount3, String groupDetailsName, String bpGroup);

    public void updatetwo(String vendorEmailId, String productService, String panNo, String panFile, String gstinNo, String gstinFile, String typeOfGst, String productWiseCapacity, String developmentCapabilities, String machineryTechnology, String materialHandling, String firstYear, String firstYearFile, String secondYear, String secondYearFile, String thirdYear, String thirdYearFile, String balanceSheet, String balanceSheetFile, String msmeCertificate, String msmeCertificateFile, String cst_no, String cst_file, String vat_pin, String vat_file, String ecc_no, String ecc_file, String service_tax, String service_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String chequeFile);

    public void updatethree(String vendorEmailId, String majorCustomers, String customerRatings, String workCompletionCertificates, String totalStaff, String skilledWorkers, String unskilledWorkers, String sexRatio, String suspensionOfWork, String organizationOfQa, String environment, String sustainability, String fairLabourStandardFile, String businessContinuity);

    public void updatefour(String vendorEmailId, String inspectionFacilities, String inspectionProcedure, String changeManagementProcess, String sustainabilityInitiativesFile, String carbonFootprint, String irReportFile, String circularEconomyFile, String greenProductFile, String greenCompanyFile, String lifeCycleAnalysisFile, String awareAboutSafety, String incidentsDuringWork, String incidentsDetails, String additionalInformation, String informationFurnishedByFile, String chequeFile, String customerRemark);

    public void updatefinal(String vendorEmailId, String vendorFile, String policyFile, String termsFile);

    public void approveone(String id, String codeOfSupplier, String typeOfSupplier, String workingOfSupplier, String accountingGroup, String incoTerm, String materialGroup, String materialSubGroup);

    public void approvetwo(String id);

    public void changeStatus(String id, int status1);

    public List readNewVendor();

    public List readApproveOneVendor();

    public List readApproveTwoVendor();

    public List readActiveVendor();

    public List readAllVendor();

    public List searchVendor(String startDate, String endDate, String companyname, String emailid);

    public void updatefive(String vendorEmailId, String manufacturer, String dealer, String traders, String materialSupply, String dealingServices, String esicNo, String capabilities1, String specificProducts, String qualityManagement, String qualityIso, String qualityApi, String qualityIs, String qualityOthers, String environmentManagement, String indianChemical);

    public List readyByElectric();

    public List readByuser(String name);

    public List readByuser1(String name);

    public List readByHrVendor(String name);

    public List readBySafteyVendor(String name);

    public List readByItVendor(String name);

    public void changeFinicalStatus(String id, int status);

    public void updateone1(String vendorEmailId, String typeOfConcern, String officeAddressLine1, String officeAddressLine2, String officeAddressLine3, String officeCity, String officeState, String officePin, String officeCountry, String officeTelephone, String officeMobile, String officeFax, String officeEmail, String officeWebsite, String officeWeeklyHoliday, String officeContactPersonName, String officeContactDesignation, String officeContactMobile, String officeContactEmail, String workAddressLine1, String workAddressLine2, String workAddressLine3, String workCity, String workState, String workPin, String workCountry, String workTelephone, String workMobile, String workFax, String workEmail, String workWebsite, String workWeeklyHoliday, String workContactPersonName, String workContactDesignation, String workContactMobile, String workContactEmail, String good, String service, String contract, String traders, String establishment, String sales_name, String sales_job, String sales_phone, String technical_name, String technical_job, String technical_phone, String quality_name, String quality_job, String quality_phone, String panNo, String panFile, String gstinNo, String gstinFile, String cst_no, String cst_file, String vat_pin, String vat_file, String ecc_no, String ecc_file, String service_tax, String service_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String serviceType, String update, String secoundMobile, String cancelcheck, String saleEmail, String technicalContactEmail, String qualityEmail, String pfNo, String cicNo, String pfAttachment, String cicAttachment, String finical1, String finical2, String finical3, String finicalAttachment1, String finicalAttachment2, String finicalAttachment3, String finicalAmount1, String finicalAmount2, String finicalAmount3, String groupDetailsName, String bpGroup);

    public List readApproveOneVendors(String user11);

    public List readForAuditor(String name);

    public List readForProcurementHead(String name);

    public int readBySapCode(String sapCode);

    public List readByRecycleVendor();

    public int readActiveVendorCount();

    public int inprogressVendorCount();

    public int rejectedVendorCount();

    public List getActiveVendorPagination(int start, int length, String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter, String orderColumn, String orderDir);

    public int getActiveVendorCount();

    public int getFilteredActiveVendorCount(String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter);

    public List getAllVendorPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getAllVendorCount();

    public int getFilteredAllVendorCount(String searchValue);

    public int invitedVendorCount(String userName);

    public int invitedVendorCountForAllVendorRight();

    public List readInvitedVendor(String userName);

    public List invitedVendorForAllVendorRight();

    public List getInvitedVendorPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir);

    public int getInvitedVendorCount(String userName);

    public int getFilteredInvitedVendorCount(String userName, String searchValue);

    public List readInprogressVendor();

    public List getInprogressVendorPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir);

    public int getInprogressVendorCount(String userName);

    public int getFilteredInprogressVendorCount(String userName, String searchValue);

    public List readRejectVendor();

    public List getRejectVendorPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir);

    public int getRejectVendorCount(String userName);

    public int getFilteredRejectVendorCount(String userName, String searchValue);

    public List getBlockVendorPagination(int start, int length, String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter, String orderColumn, String orderDir);

    public int getBlockVendorCount();

    public int getFilteredBlockVendorCount(String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter);

    public int vendorBlockCount();

    public List readBystatus500();

    public List getComplianceOfficerPagination(int start, int length, String orderColumn, String orderDir, String searchValue);

    public int getAllComplianceOfficerCount();

    public int getFilteredComplianceOfficerCount(String searchValue);

}

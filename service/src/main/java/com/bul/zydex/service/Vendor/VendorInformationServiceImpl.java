/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorInformationDao;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorInformationServiceImpl<T> extends GenericsServiceImpl<T> implements VendorInformationService<T> {

    private VendorInformationDao<T> vendorInformationDao;

    public VendorInformationDao<T> getVendorInformationDao() {
        return vendorInformationDao;
    }

    public void setVendorInformationDao(VendorInformationDao<T> vendorInformationDao) {
        this.vendorInformationDao = vendorInformationDao;
        setGenericsDAO(vendorInformationDao);
    }

    @Override
    public VendorInformation readEmailId(String email) {
        return vendorInformationDao.readEmailId(email);
    }

    @Override
    public VendorInformation readID(int id) {
        return vendorInformationDao.readID(id);
    }

    @Override
    public List readEmail(String email) {
        return vendorInformationDao.readEmail(email);
    }

    @Override
    public List readId(int id) {
        return vendorInformationDao.readId(id);
    }

    @Override
    public void updateterms(String vendorEmailId, String termsFile) {
        vendorInformationDao.updateterms(vendorEmailId, termsFile);
    }

    @Override
    public void updatepolicy(String vendorEmailId, String policyFile1, String policyFile2) {
        vendorInformationDao.updatepolicy(vendorEmailId, policyFile1, policyFile2);
    }

    @Override
    public void updateone(String email, String typeOfConcern, String officeAddress1, String officeAddress2, String officeAddress3, String officeCity, String officeDistrict, String officeState, String officePin, String officeCountry, String officeTelephone, String officeMobile, String officeFax, String officeEmail, String officeWebsite, String officeWeeklyHoliday, String officeContactPersonName, String officeContactDesignation, String officeContactMobile, String officeContactEmail, String workAddressLine1, String workAddressLine2, String workAddressLine3, String workCity, String workState, String workPin, String workCountry, String workTelephone, String workMobile, String workFax, String workEmail, String workWebsite, String workWeeklyHoliday, String workContactPersonName, String workContactDesignation, String workContactMobile, String workContactEmail, String good, String service, String contract, String traders, String establishment, String sales_name, String sales_job, String sales_phone, String technical_name, String technical_job, String technical_phone, String quality_name, String quality_job, String quality_phone, String panNo, String panFile, String gstinNo, String gstinFile, String cst_no, String cst_file, String vat_pin, String vat_file, String ecc_no, String ecc_file, String service_tax, String service_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String serviceType, String update, String secoundMobile, String cancelcheck, String saleEmail, String technicalContactEmail, String qualityEmail, String pfNo, String cicNo, String pfAttachment, String cicAttachment, String finical1, String finical2, String finical3, String finicalAttachment1, String finicalAttachment2, String finicalAttachment3, String finicalAmount1, String finicalAmount2, String finicalAmount3, String groupDetailsName, String bpGroup) {
        vendorInformationDao.updateone(email, typeOfConcern, officeAddress1, officeAddress2, officeAddress3, officeCity, officeDistrict, officeState, officePin, officeCountry, officeTelephone, officeMobile, officeFax, officeEmail, officeWebsite, officeWeeklyHoliday, officeContactPersonName, officeContactDesignation, officeContactMobile, officeContactEmail, workAddressLine1, workAddressLine2, workAddressLine3, workCity, workState, workPin, workCountry, workTelephone, workMobile, workFax, workEmail, workWebsite, workWeeklyHoliday, workContactPersonName, workContactDesignation, workContactMobile, workContactEmail, good, service, contract, traders, establishment, sales_name, sales_job, sales_phone, technical_name, technical_job, technical_phone, quality_name, quality_job, quality_phone, panNo, panFile, gstinNo, gstinFile, cst_no, cst_file, vat_pin, vat_file, ecc_no, ecc_file, service_tax, service_file, accountNumber, bankName, branch, ifscCode, swiftCode, serviceType, update, secoundMobile, cancelcheck, saleEmail, technicalContactEmail, qualityEmail, pfNo, cicNo, pfAttachment, cicAttachment, finical1, finical2, finical3, finicalAttachment1, finicalAttachment2, finicalAttachment3, finicalAmount1, finicalAmount2, finicalAmount3, groupDetailsName, bpGroup);
    }

    @Override
    public void updatetwo(String vendorEmailId, String productService, String panNo, String panFile, String gstinNo, String gstinFile, String typeOfGst, String productWiseCapacity, String developmentCapabilities, String machineryTechnology, String materialHandling, String firstYear, String firstYearFile, String secondYear, String secondYearFile, String thirdYear, String thirdYearFile, String balanceSheet, String balanceSheetFile, String msmeCertificate, String msmeCertificateFile, String cst_no, String cst_file, String vat_pin, String vat_file, String ecc_no, String ecc_file, String service_tax, String service_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String chequeFile) {
        vendorInformationDao.updatetwo(vendorEmailId, productService, panNo, panFile, gstinNo, gstinFile, typeOfGst, productWiseCapacity, developmentCapabilities, machineryTechnology, materialHandling, firstYear, firstYearFile, secondYear, secondYearFile, thirdYear, thirdYearFile, balanceSheet, balanceSheetFile, msmeCertificate, msmeCertificateFile, cst_no, cst_file, vat_pin, vat_file, ecc_no, ecc_file, service_tax, service_file, accountNumber, bankName, branch, ifscCode, swiftCode, chequeFile);
    }

    @Override
    public void updatethree(String vendorEmailId, String majorCustomers, String customerRatings, String workCompletionCertificates, String totalStaff, String skilledWorkers, String unskilledWorkers, String sexRatio, String suspensionOfWork, String organizationOfQa, String environment, String sustainability, String fairLabourStandardFile, String businessContinuity) {
        vendorInformationDao.updatethree(vendorEmailId, majorCustomers, customerRatings, workCompletionCertificates, totalStaff, skilledWorkers, unskilledWorkers, sexRatio, suspensionOfWork, organizationOfQa, environment, sustainability, fairLabourStandardFile, businessContinuity);
    }

    @Override
    public void updatefour(String vendorEmailId, String inspectionFacilities, String inspectionProcedure, String changeManagementProcess, String sustainabilityInitiativesFile, String carbonFootprint, String irReportFile, String circularEconomyFile, String greenProductFile, String greenCompanyFile, String lifeCycleAnalysisFile, String awareAboutSafety, String incidentsDuringWork, String incidentsDetails, String additionalInformation, String informationFurnishedByFile, String chequeFile, String customerRemark) {
        vendorInformationDao.updatefour(vendorEmailId, inspectionFacilities, inspectionProcedure, changeManagementProcess, sustainabilityInitiativesFile, carbonFootprint, irReportFile, circularEconomyFile, greenProductFile, greenCompanyFile, lifeCycleAnalysisFile, awareAboutSafety, incidentsDuringWork, incidentsDetails, additionalInformation, informationFurnishedByFile, chequeFile, customerRemark);
    }

    @Override
    public void approveone(String id, String codeOfSupplier, String typeOfSupplier, String workingOfSupplier, String accountingGroup, String incoTerm, String materialGroup, String materialSubGroup) {
        vendorInformationDao.approveone(id, codeOfSupplier, typeOfSupplier, workingOfSupplier, accountingGroup, incoTerm, materialGroup, materialSubGroup);
    }

    @Override
    public void approvetwo(String id) {
        vendorInformationDao.approvetwo(id);
    }

    @Override
    public void changeStatus(String id, int status1) {
        vendorInformationDao.changeStatus(id, status1);
    }

    @Override
    public void updatefinal(String vendorEmailId, String vendorFile, String policyFile, String termsFile) {
        vendorInformationDao.updatefinal(vendorEmailId, vendorFile, policyFile, termsFile);
    }

    @Override
    public List readNewVendor() {
        return vendorInformationDao.readNewVendor();
    }

    @Override
    public List readApproveOneVendor() {
        return vendorInformationDao.readApproveOneVendor();
    }

    @Override
    public List readApproveTwoVendor() {
        return vendorInformationDao.readApproveTwoVendor();
    }

    @Override
    public List readActiveVendor() {
        return vendorInformationDao.readActiveVendor();
    }

    @Override
    public List readAllVendor() {
        return vendorInformationDao.readAllVendor();
    }

    @Override
    public List searchVendor(String startDate, String endDate, String companyname, String emailid) {
        return vendorInformationDao.searchVendor(startDate, endDate, companyname, emailid);
    }

    @Override
    public void updatefive(String vendorEmailId, String manufacturer, String dealer, String traders, String materialSupply, String dealingServices, String esicNo, String capabilities1, String specificProducts, String qualityManagement, String qualityIso, String qualityApi, String qualityIs, String qualityOthers, String environmentManagement, String indianChemical) {
        vendorInformationDao.updatefive(vendorEmailId, manufacturer, dealer, traders, materialSupply, dealingServices, esicNo, capabilities1, specificProducts, qualityManagement, qualityIso, qualityApi, qualityIs, qualityOthers, environmentManagement, indianChemical);
    }

    @Override
    public List readyByElectric() {
        return vendorInformationDao.readyByElectric();

    }

    @Override
    public List readByuser(String name) {
        return vendorInformationDao.readByuser(name);
    }

    @Override
    public List readByuser1(String name) {
        return vendorInformationDao.readByuser1(name);
    }

    @Override
    public List readByHrVendor(String name) {
        return vendorInformationDao.readByHrVendor(name);
    }

    @Override
    public List readBySafteyVendor(String name) {
        return vendorInformationDao.readBySafteyVendor(name);
    }

    @Override
    public List readByItVendor(String name) {
        return vendorInformationDao.readByItVendor(name);
    }

    @Override
    public void changeFinicalStatus(String id, int status) {
        vendorInformationDao.changeFinicalStatus(id, status);

    }

    @Override
    public void updateone1(String vendorEmailId, String typeOfConcern, String officeAddressLine1, String officeAddressLine2, String officeAddressLine3, String officeCity, String officeState, String officePin, String officeCountry, String officeTelephone, String officeMobile, String officeFax, String officeEmail, String officeWebsite, String officeWeeklyHoliday, String officeContactPersonName, String officeContactDesignation, String officeContactMobile, String officeContactEmail, String workAddressLine1, String workAddressLine2, String workAddressLine3, String workCity, String workState, String workPin, String workCountry, String workTelephone, String workMobile, String workFax, String workEmail, String workWebsite, String workWeeklyHoliday, String workContactPersonName, String workContactDesignation, String workContactMobile, String workContactEmail, String good, String service, String contract, String traders, String establishment, String sales_name, String sales_job, String sales_phone, String technical_name, String technical_job, String technical_phone, String quality_name, String quality_job, String quality_phone, String panNo, String panFile, String gstinNo, String gstinFile, String cst_no, String cst_file, String vat_pin, String vat_file, String ecc_no, String ecc_file, String service_tax, String service_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String serviceType, String update, String secoundMobile, String cancelcheck, String saleEmail, String technicalContactEmail, String qualityEmail, String pfNo, String cicNo, String pfAttachment, String cicAttachment, String finical1, String finical2, String finical3, String finicalAttachment1, String finicalAttachment2, String finicalAttachment3, String finicalAmount1, String finicalAmount2, String finicalAmount3, String groupDetailsName, String bpGroup) {
        vendorInformationDao.updateone1(vendorEmailId, typeOfConcern, officeAddressLine1, officeAddressLine2, officeAddressLine3, officeCity, officeState, officePin, officeCountry, officeTelephone, officeMobile, officeFax, officeEmail, officeWebsite, officeWeeklyHoliday, officeContactPersonName, officeContactDesignation, officeContactMobile, officeContactEmail, workAddressLine1, workAddressLine2, workAddressLine3, workCity, workState, workPin, workCountry, workTelephone, workMobile, workFax, workEmail, workWebsite, workWeeklyHoliday, workContactPersonName, workContactDesignation, workContactMobile, workContactEmail, good, service, contract, traders, establishment, sales_name, sales_job, sales_phone, technical_name, technical_job, technical_phone, quality_name, quality_job, quality_phone, panNo, panFile, gstinNo, gstinFile, cst_no, cst_file, vat_pin, vat_file, ecc_no, ecc_file, service_tax, service_file, accountNumber, bankName, branch, ifscCode, swiftCode, serviceType, update, secoundMobile, cancelcheck, saleEmail, technicalContactEmail, qualityEmail, pfNo, cicNo, pfAttachment, cicAttachment, finical1, finical2, finical3, finicalAttachment1, finicalAttachment2, finicalAttachment3, finicalAmount1, finicalAmount2, finicalAmount3, groupDetailsName, bpGroup);

    }

    @Override
    public List readApproveOneVendors(String user11) {
        return vendorInformationDao.readApproveOneVendors(user11);
    }

    @Override
    public List readForAuditor(String name) {
        return vendorInformationDao.readForAuditor(name);
    }

    @Override
    public List readForProcurementHead(String name) {
        return vendorInformationDao.readForProcurementHead(name);
    }

    @Override
    public int readBySapCode(String sapCode) {
        return vendorInformationDao.readBySapCode(sapCode);
    }

    @Override
    public List readByRecycleVendor() {
        return vendorInformationDao.readByRecycleVendor();
    }

    @Override
    public int readActiveVendorCount() {
        return vendorInformationDao.readActiveVendorCount();
    }

    @Override
    public int inprogressVendorCount() {
        return vendorInformationDao.inprogressVendorCount();
    }

    @Override
    public int rejectedVendorCount() {
        return vendorInformationDao.rejectedVendorCount();
    }

    @Override
    public List getActiveVendorPagination(int start, int length, String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter, String orderColumn, String orderDir) {
        return vendorInformationDao.getActiveVendorPagination(start, length, searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter, orderColumn, orderDir);
    }

    @Override
    public int getActiveVendorCount() {
        return vendorInformationDao.getActiveVendorCount();
    }

    @Override
    public int getFilteredActiveVendorCount(String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter) {
        return vendorInformationDao.getFilteredActiveVendorCount(searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter);
    }

    @Override
    public List getAllVendorPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return vendorInformationDao.getAllVendorPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getAllVendorCount() {
        return vendorInformationDao.getAllVendorCount();
    }

    @Override
    public int getFilteredAllVendorCount(String searchValue) {
        return vendorInformationDao.getFilteredAllVendorCount(searchValue);
    }

    @Override
    public int invitedVendorCount(String userName) {
        return vendorInformationDao.invitedVendorCount(userName);
    }

    @Override
    public int invitedVendorCountForAllVendorRight() {
        return vendorInformationDao.invitedVendorCountForAllVendorRight();
    }

    @Override
    public List readInvitedVendor(String userName) {
        return vendorInformationDao.readInvitedVendor(userName);
    }

    @Override
    public List invitedVendorForAllVendorRight() {
        return vendorInformationDao.invitedVendorForAllVendorRight();
    }

    @Override
    public List getInvitedVendorPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {
        return vendorInformationDao.getInvitedVendorPagination(start, length, userName, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getInvitedVendorCount(String userName) {
        return vendorInformationDao.getInvitedVendorCount(userName);
    }

    @Override
    public int getFilteredInvitedVendorCount(String userName, String searchValue) {
        return vendorInformationDao.getFilteredInvitedVendorCount(userName, searchValue);
    }

    @Override
    public List readInprogressVendor() {
        return vendorInformationDao.readInprogressVendor();
    }

    @Override
    public List getInprogressVendorPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {
        return vendorInformationDao.getInprogressVendorPagination(start, length, userName, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getInprogressVendorCount(String userName) {
        return vendorInformationDao.getInprogressVendorCount(userName);
    }

    @Override
    public int getFilteredInprogressVendorCount(String userName, String searchValue) {
        return vendorInformationDao.getFilteredInprogressVendorCount(userName, searchValue);
    }

    @Override
    public List readRejectVendor() {
        return vendorInformationDao.readRejectVendor();
    }

    @Override
    public List getRejectVendorPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {
        return vendorInformationDao.getRejectVendorPagination(start, length, userName, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getRejectVendorCount(String userName) {
        return vendorInformationDao.getRejectVendorCount(userName);
    }

    @Override
    public int getFilteredRejectVendorCount(String userName, String searchValue) {
        return vendorInformationDao.getFilteredRejectVendorCount(userName, searchValue);
    }

    @Override
    public List getBlockVendorPagination(int start, int length, String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter, String orderColumn, String orderDir) {
        return vendorInformationDao.getBlockVendorPagination(start, length, searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter, orderColumn, orderDir);
    }

    @Override
    public int getBlockVendorCount() {
        return vendorInformationDao.getBlockVendorCount();
    }

    @Override
    public int getFilteredBlockVendorCount(String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter) {
        return vendorInformationDao.getFilteredBlockVendorCount(searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter);
    }

    @Override
    public int vendorBlockCount() {
        return vendorInformationDao.vendorBlockCount();
    }

    @Override
    public List readBystatus500() {
        return vendorInformationDao.readBystatus500();
    }

    @Override
    public List getComplianceOfficerPagination(int start, int length, String orderColumn, String orderDir, String searchValue) {
        return vendorInformationDao.getComplianceOfficerPagination(start, length, orderColumn, orderDir, searchValue);
    }

    @Override
    public int getAllComplianceOfficerCount() {
        return vendorInformationDao.getAllComplianceOfficerCount();
    }

    @Override
    public int getFilteredComplianceOfficerCount(String searchValue) {
        return vendorInformationDao.getFilteredComplianceOfficerCount(searchValue);
    }
}

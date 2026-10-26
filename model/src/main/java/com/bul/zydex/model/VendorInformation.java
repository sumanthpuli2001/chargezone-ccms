/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class VendorInformation implements java.io.Serializable {

    private int id;
    private int vendorInvitationId;
    private String vendorEmailId;
    private String companyName;
    private String contactName;
    private String policyAccept;
    private String policyAccept2;
    private String termsConditionAccept;
    private String termsConditionFile;
    private String typeOfConcern;
    private String officeAddressLine1;
    private String officeAddressLine2;
    private String officeAddressLine3;
    private String officeCity;
    private String officeDistrict;
    private String officeState;
    private String officePin;
    private String officeCountry;
    private String officeTelephone;
    private String officeMobile;
    private String officeFax;
    private String officeEmail;
    private String officeWebsite;
    private String officeWeeklyHoliday;
    private String officeContactPersonName;
    private String officeContactDesignation;
    private String officeContactMobile;
    private String officeContactEmail;
    private String workAddressLine1;
    private String workAddressLine2;
    private String workAddressLine3;
    private String workCity;
    private String workState;
    private String workPin;
    private String workCountry;
    private String workTelephone;
    private String workMobile;
    private String workFax;
    private String workEmail;
    private String workWebsite;
    private String workWeeklyHoliday;
    private String workContactPersonName;
    private String workContactDesignation;
    private String workContactMobile;
    private String workContactEmail;
    private String productService;
    private String typeOfGst;
    private String productWiseCapacity;
    private String developmentCapabilities;
    private String machineryTechnology;
    private String materialHandling;
    private String firstYear;
    private String firstYearFile;
    private String secondYear;
    private String secondYearFile;
    private String thirdYear;
    private String thirdYearFile;
    private String balanceSheet;
    private String balanceSheetFile;
    private String msmeCertificate;
    private String msmeCertificateFile;
    private String majorCustomers;
    private String customerRatings;
    private String workCompletionCertificates;
    private String totalStaff;
    private String skilledWorkers;
    private String unskilledWorkers;
    private String sexRatio;
    private String suspensionOfWork;
    private String organizationOfQa;
    private String environment;
    private String sustainability;
    private String fairLabourStandardFile;
    private String inspectionFacilities;
    private String inspectionProcedure;
    private String changeManagementProcess;
    private String sustainabilityInitiativesFile;
    private String carbonFootprint;
    private String irReportFile;
    private String circularEconomyFile;
    private String greenProductFile;
    private String greenCompanyFile;
    private String lifeCycleAnalysisFile;
    private String awareAboutSafety;
    private String incidentsDuringWork;
    private String incidentsDetails;
    private String additionalInformation;
    private String informationFurnishedByFile;
    private int status1;
    private String approvalOne;
    private String approvalTwo;
    private String vendorFile;
    private String codeOfSupplier;
    private String typeOfSupplier;
    private String workingOfSupplier;
    private String accountingGroup;
    private String incoTerm;
    private String materialGroup;
    private String materialSubGroup;
    private String policyFile;
    private String chequeFile;
    private String approveDate;
    private String approvalThree;
    private String businessContinuity;

    private String good;
    private String service;
    private String contract;
    private String general_traders;
    private String establishment;

    private String sales_name;
    private String sales_job;
    private String sales_phone;
    private String technical_name;
    private String technical_job;

    private String technical_phone;
    private String quality_name;
    private String quality_job;
    private String quality_phone;

    private String cst_no;
    private String cst_file;
    private String vat_pin;
    private String vat_file;

    private String accountNumber;
    private String bankName;
    private String branch;
    private String ifscCode;
    private String swiftCode;

    private String manufacturer;
    private String dealer;
    private String traders;
    private String materialSupply;
    private String dealingServices;
    private String capabilities1;
    private String specificProducts;

    private String qualityManagement;
    private String qualityIso;
    private String qualityApi;
    private String qualityIs;
    private String qualityOthers;
    private String environmentManagement;
    private String indianChemical;
    private String customerRemark;

    private String policy1File;
    private String policy2File;
    private String electricalService;
    private String secoundMobile;
    private String technicalApproval;
    private String finacialApproval;
    private Integer finacialFlag;
    private Integer technicalFlag;
    private String hrApproval;
    private String safetyApproval;
    private String itApproval;
    private Integer hrApprovalFlag;
    private Integer safteyApprovalFlag;
    private Integer itApprovalFlag;
    private String saleEmail;
    private String technicalContactEmail;
    private String qualityEmail;

    private String finical1;
    private String finical2;
    private String finical3;
    private String finicalAmount1;
    private String finicalAmount2;
    private String finicalAmount3;

    private String vendorTypes;
    private String groupCategory;
    private String groupSubCategory;

    private String bpGroup;
    private String email1;
    private String email2;
    private String email3;
    private String buyerCompany;
    private String purchasingGroup;
    private String currency;
    private String groupCalculation;
    private String termOfPayment;
    private String recAccountNo;
    private String bankKey;
    private String accountNo;
    private String taxDetails;
    private String taxNumber;
    private String searchTerm1;
    private String withoutHoldingTaxType;
    private String withoutHoldingTaxCode;
    private String managerialPersonDetails;
    private String managerialPersonEmail;
    private String managerialPersonJob;
    private String managerialPersonPhone;
    private String managerialPersonDetails2;
    private String managerialPersonEmail2;
    private String managerialPersonJob2;
    private String managerialPersonPhone2;
    private String riskCategory;
    private String gstRemark;
    private String vendorInviteSource;

    private String cicNo;
    private String cicAttachment;

    private String auditorName;
    private int auditorFlag;

    private String auditorAttachment;
    private String auditorRemark;

    private String ndaPolicyFile;
    private String ndaPolicyAccept;

    private String companyProof;
    private String riskBand;
    private String specialComment;
    private String specialAttachment;
    private String sapCode;

    private String gstinNo;
    private String gstinFile;
    private String gstStatus;
    private String gstStatuss;
    private String gstRemarkk;
    private String gstResponse;

    private String panNo;
    private String panFile;
    private String panStatus;
    private String panStatuss;
    private String panRemarkk;
    private String panResponse;

    private String service_tax;
    private String service_file;
    private String msmeStatus;
    private String msmeStatuss;
    private String msmeRemarkk;
    private String msmeResponse;

    private String esicNo;
    private String esicFile;
    private String esicStatus;
    private String esicStatuss;
    private String esicRem;
    private String esicRes;

    private String pfNo;
    private String pfAttachment;
    private String epfoStatus;
    private String epfoStatuss;
    private String epfoRemarkk;
    private String epfoResponse;

    private String ecc_no;
    private String ecc_file;
    private String eccStatus;
    private String eccStatuss;
    private String eccRemarkk;
    private String eccResponse;

    private String cancelCheck;
    private String cancelChequeStatuss;
    private String cancelChequeRemarkk;
    private String cancelChequeResponse;

    private String finicalAttachment1;
    private String fin1Statuss;
    private String fin1Remarkk;
    private String fin1Response;

    private String finicalAttachment2;
    private String fin2Statuss;
    private String fin2Remarkk;
    private String fin2Response;

    private String finicalAttachment3;
    private String fin3Statuss;
    private String fin3Remarkk;
    private String fin3Response;

    private String countryCodeoffTele;
    private String countryCodeNewMobiles;
    private String countryCodeVendorContact;
    private String countryCodeVendorContact1;
    private String countryCodeVendorContact2;
    private String companyProof2;

    private String vendorActivatedDate;
    
    private String vendorCommentForBuyer;
    private String buyerCommentForApproval;
    private String vendorFinancialUpdateComment;

    public VendorInformation() {
    }

    public VendorInformation(int id, int vendorInvitationId, String vendorEmailId, String companyName, String contactName, String policyAccept, String policyAccept2, String termsConditionAccept, String termsConditionFile, String typeOfConcern, String officeAddressLine1, String officeAddressLine2, String officeAddressLine3, String officeCity, String officeDistrict, String officeState, String officePin, String officeCountry, String officeTelephone, String officeMobile, String officeFax, String officeEmail, String officeWebsite, String officeWeeklyHoliday, String officeContactPersonName, String officeContactDesignation, String officeContactMobile, String officeContactEmail, String workAddressLine1, String workAddressLine2, String workAddressLine3, String workCity, String workState, String workPin, String workCountry, String workTelephone, String workMobile, String workFax, String workEmail, String workWebsite, String workWeeklyHoliday, String workContactPersonName, String workContactDesignation, String workContactMobile, String workContactEmail, String productService, String typeOfGst, String productWiseCapacity, String developmentCapabilities, String machineryTechnology, String materialHandling, String firstYear, String firstYearFile, String secondYear, String secondYearFile, String thirdYear, String thirdYearFile, String balanceSheet, String balanceSheetFile, String msmeCertificate, String msmeCertificateFile, String majorCustomers, String customerRatings, String workCompletionCertificates, String totalStaff, String skilledWorkers, String unskilledWorkers, String sexRatio, String suspensionOfWork, String organizationOfQa, String environment, String sustainability, String fairLabourStandardFile, String inspectionFacilities, String inspectionProcedure, String changeManagementProcess, String sustainabilityInitiativesFile, String carbonFootprint, String irReportFile, String circularEconomyFile, String greenProductFile, String greenCompanyFile, String lifeCycleAnalysisFile, String awareAboutSafety, String incidentsDuringWork, String incidentsDetails, String additionalInformation, String informationFurnishedByFile, int status1, String approvalOne, String approvalTwo, String vendorFile, String codeOfSupplier, String typeOfSupplier, String workingOfSupplier, String accountingGroup, String incoTerm, String materialGroup, String materialSubGroup, String policyFile, String chequeFile, String approveDate, String approvalThree, String businessContinuity, String good, String service, String contract, String general_traders, String establishment, String sales_name, String sales_job, String sales_phone, String technical_name, String technical_job, String technical_phone, String quality_name, String quality_job, String quality_phone, String cst_no, String cst_file, String vat_pin, String vat_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String manufacturer, String dealer, String traders, String materialSupply, String dealingServices, String capabilities1, String specificProducts, String qualityManagement, String qualityIso, String qualityApi, String qualityIs, String qualityOthers, String environmentManagement, String indianChemical, String customerRemark, String policy1File, String policy2File, String electricalService, String secoundMobile, String cancelCheck, String technicalApproval, String finacialApproval, Integer finacialFlag, Integer technicalFlag, String hrApproval, String safetyApproval, String itApproval, Integer hrApprovalFlag, Integer safteyApprovalFlag, Integer itApprovalFlag, String saleEmail, String technicalContactEmail, String qualityEmail, String finical1, String finical2, String finical3, String finicalAttachment1, String finicalAttachment2, String finicalAttachment3, String finicalAmount1, String finicalAmount2, String finicalAmount3, String vendorTypes, String groupCategory, String groupSubCategory, String bpGroup, String email1, String email2, String email3, String buyerCompany, String purchasingGroup, String currency, String groupCalculation, String termOfPayment, String recAccountNo, String bankKey, String accountNo, String taxDetails, String taxNumber, String searchTerm1, String withoutHoldingTaxType, String withoutHoldingTaxCode, String managerialPersonDetails, String managerialPersonEmail, String managerialPersonJob, String managerialPersonPhone, String managerialPersonDetails2, String managerialPersonEmail2, String managerialPersonJob2, String managerialPersonPhone2, String riskCategory, String gstRemark, String vendorInviteSource, String cicNo, String cicAttachment, String auditorName, int auditorFlag, String auditorAttachment, String auditorRemark, String ndaPolicyFile, String ndaPolicyAccept, String companyProof, String riskBand, String specialComment, String specialAttachment, String sapCode) {
        this.id = id;
        this.vendorInvitationId = vendorInvitationId;
        this.vendorEmailId = vendorEmailId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.policyAccept = policyAccept;
        this.policyAccept2 = policyAccept2;
        this.termsConditionAccept = termsConditionAccept;
        this.termsConditionFile = termsConditionFile;
        this.typeOfConcern = typeOfConcern;
        this.officeAddressLine1 = officeAddressLine1;
        this.officeAddressLine2 = officeAddressLine2;
        this.officeAddressLine3 = officeAddressLine3;
        this.officeCity = officeCity;
        this.officeDistrict = officeDistrict;
        this.officeState = officeState;
        this.officePin = officePin;
        this.officeCountry = officeCountry;
        this.officeTelephone = officeTelephone;
        this.officeMobile = officeMobile;
        this.officeFax = officeFax;
        this.officeEmail = officeEmail;
        this.officeWebsite = officeWebsite;
        this.officeWeeklyHoliday = officeWeeklyHoliday;
        this.officeContactPersonName = officeContactPersonName;
        this.officeContactDesignation = officeContactDesignation;
        this.officeContactMobile = officeContactMobile;
        this.officeContactEmail = officeContactEmail;
        this.workAddressLine1 = workAddressLine1;
        this.workAddressLine2 = workAddressLine2;
        this.workAddressLine3 = workAddressLine3;
        this.workCity = workCity;
        this.workState = workState;
        this.workPin = workPin;
        this.workCountry = workCountry;
        this.workTelephone = workTelephone;
        this.workMobile = workMobile;
        this.workFax = workFax;
        this.workEmail = workEmail;
        this.workWebsite = workWebsite;
        this.workWeeklyHoliday = workWeeklyHoliday;
        this.workContactPersonName = workContactPersonName;
        this.workContactDesignation = workContactDesignation;
        this.workContactMobile = workContactMobile;
        this.workContactEmail = workContactEmail;
        this.productService = productService;
        this.typeOfGst = typeOfGst;
        this.productWiseCapacity = productWiseCapacity;
        this.developmentCapabilities = developmentCapabilities;
        this.machineryTechnology = machineryTechnology;
        this.materialHandling = materialHandling;
        this.firstYear = firstYear;
        this.firstYearFile = firstYearFile;
        this.secondYear = secondYear;
        this.secondYearFile = secondYearFile;
        this.thirdYear = thirdYear;
        this.thirdYearFile = thirdYearFile;
        this.balanceSheet = balanceSheet;
        this.balanceSheetFile = balanceSheetFile;
        this.msmeCertificate = msmeCertificate;
        this.msmeCertificateFile = msmeCertificateFile;
        this.majorCustomers = majorCustomers;
        this.customerRatings = customerRatings;
        this.workCompletionCertificates = workCompletionCertificates;
        this.totalStaff = totalStaff;
        this.skilledWorkers = skilledWorkers;
        this.unskilledWorkers = unskilledWorkers;
        this.sexRatio = sexRatio;
        this.suspensionOfWork = suspensionOfWork;
        this.organizationOfQa = organizationOfQa;
        this.environment = environment;
        this.sustainability = sustainability;
        this.fairLabourStandardFile = fairLabourStandardFile;
        this.inspectionFacilities = inspectionFacilities;
        this.inspectionProcedure = inspectionProcedure;
        this.changeManagementProcess = changeManagementProcess;
        this.sustainabilityInitiativesFile = sustainabilityInitiativesFile;
        this.carbonFootprint = carbonFootprint;
        this.irReportFile = irReportFile;
        this.circularEconomyFile = circularEconomyFile;
        this.greenProductFile = greenProductFile;
        this.greenCompanyFile = greenCompanyFile;
        this.lifeCycleAnalysisFile = lifeCycleAnalysisFile;
        this.awareAboutSafety = awareAboutSafety;
        this.incidentsDuringWork = incidentsDuringWork;
        this.incidentsDetails = incidentsDetails;
        this.additionalInformation = additionalInformation;
        this.informationFurnishedByFile = informationFurnishedByFile;
        this.status1 = status1;
        this.approvalOne = approvalOne;
        this.approvalTwo = approvalTwo;
        this.vendorFile = vendorFile;
        this.codeOfSupplier = codeOfSupplier;
        this.typeOfSupplier = typeOfSupplier;
        this.workingOfSupplier = workingOfSupplier;
        this.accountingGroup = accountingGroup;
        this.incoTerm = incoTerm;
        this.materialGroup = materialGroup;
        this.materialSubGroup = materialSubGroup;
        this.policyFile = policyFile;
        this.chequeFile = chequeFile;
        this.approveDate = approveDate;
        this.approvalThree = approvalThree;
        this.businessContinuity = businessContinuity;
        this.good = good;
        this.service = service;
        this.contract = contract;
        this.general_traders = general_traders;
        this.establishment = establishment;
        this.sales_name = sales_name;
        this.sales_job = sales_job;
        this.sales_phone = sales_phone;
        this.technical_name = technical_name;
        this.technical_job = technical_job;
        this.technical_phone = technical_phone;
        this.quality_name = quality_name;
        this.quality_job = quality_job;
        this.quality_phone = quality_phone;
        this.cst_no = cst_no;
        this.cst_file = cst_file;
        this.vat_pin = vat_pin;
        this.vat_file = vat_file;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.branch = branch;
        this.ifscCode = ifscCode;
        this.swiftCode = swiftCode;
        this.manufacturer = manufacturer;
        this.dealer = dealer;
        this.traders = traders;
        this.materialSupply = materialSupply;
        this.dealingServices = dealingServices;
        this.capabilities1 = capabilities1;
        this.specificProducts = specificProducts;
        this.qualityManagement = qualityManagement;
        this.qualityIso = qualityIso;
        this.qualityApi = qualityApi;
        this.qualityIs = qualityIs;
        this.qualityOthers = qualityOthers;
        this.environmentManagement = environmentManagement;
        this.indianChemical = indianChemical;
        this.customerRemark = customerRemark;
        this.policy1File = policy1File;
        this.policy2File = policy2File;
        this.electricalService = electricalService;
        this.secoundMobile = secoundMobile;
        this.cancelCheck = cancelCheck;
        this.technicalApproval = technicalApproval;
        this.finacialApproval = finacialApproval;
        this.finacialFlag = finacialFlag;
        this.technicalFlag = technicalFlag;
        this.hrApproval = hrApproval;
        this.safetyApproval = safetyApproval;
        this.itApproval = itApproval;
        this.hrApprovalFlag = hrApprovalFlag;
        this.safteyApprovalFlag = safteyApprovalFlag;
        this.itApprovalFlag = itApprovalFlag;
        this.saleEmail = saleEmail;
        this.technicalContactEmail = technicalContactEmail;
        this.qualityEmail = qualityEmail;
        this.finical1 = finical1;
        this.finical2 = finical2;
        this.finical3 = finical3;
        this.finicalAttachment1 = finicalAttachment1;
        this.finicalAttachment2 = finicalAttachment2;
        this.finicalAttachment3 = finicalAttachment3;
        this.finicalAmount1 = finicalAmount1;
        this.finicalAmount2 = finicalAmount2;
        this.finicalAmount3 = finicalAmount3;
        this.vendorTypes = vendorTypes;
        this.groupCategory = groupCategory;
        this.groupSubCategory = groupSubCategory;
        this.bpGroup = bpGroup;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.buyerCompany = buyerCompany;
        this.purchasingGroup = purchasingGroup;
        this.currency = currency;
        this.groupCalculation = groupCalculation;
        this.termOfPayment = termOfPayment;
        this.recAccountNo = recAccountNo;
        this.bankKey = bankKey;
        this.accountNo = accountNo;
        this.taxDetails = taxDetails;
        this.taxNumber = taxNumber;
        this.searchTerm1 = searchTerm1;
        this.withoutHoldingTaxType = withoutHoldingTaxType;
        this.withoutHoldingTaxCode = withoutHoldingTaxCode;
        this.managerialPersonDetails = managerialPersonDetails;
        this.managerialPersonEmail = managerialPersonEmail;
        this.managerialPersonJob = managerialPersonJob;
        this.managerialPersonPhone = managerialPersonPhone;
        this.managerialPersonDetails2 = managerialPersonDetails2;
        this.managerialPersonEmail2 = managerialPersonEmail2;
        this.managerialPersonJob2 = managerialPersonJob2;
        this.managerialPersonPhone2 = managerialPersonPhone2;
        this.riskCategory = riskCategory;
        this.gstRemark = gstRemark;
        this.vendorInviteSource = vendorInviteSource;
        this.cicNo = cicNo;
        this.cicAttachment = cicAttachment;
        this.auditorName = auditorName;
        this.auditorFlag = auditorFlag;
        this.auditorAttachment = auditorAttachment;
        this.auditorRemark = auditorRemark;
        this.ndaPolicyFile = ndaPolicyFile;
        this.ndaPolicyAccept = ndaPolicyAccept;
        this.companyProof = companyProof;
        this.riskBand = riskBand;
        this.specialComment = specialComment;
        this.specialAttachment = specialAttachment;
        this.sapCode = sapCode;
    }

    public VendorInformation(String gstinNo, String gstinFile, String gstStatus, String gstStatuss, String gstRemarkk, String gstResponse, String panNo, String panFile, String panStatus, String panStatuss, String panRemarkk, String panResponse, String service_tax, String service_file, String msmeStatus, String msmeStatuss, String msmeRemarkk, String msmeResponse, String esicNo, String esicFile, String esicStatus, String esicStatuss, String esicRem, String esicRes, String pfNo, String pfAttachment, String epfoStatus, String epfoStatuss, String epfoRemarkk, String epfoResponse, String ecc_no, String ecc_file, String eccStatus, String eccStatuss, String eccRemarkk, String eccResponse, String cancelChequeStatuss, String cancelChequeRemarkk, String cancelChequeResponse, String fin1Statuss, String fin1Remarkk, String fin1Response, String fin2Statuss, String fin2Remarkk, String fin2Response, String fin3Statuss, String fin3Remarkk, String fin3Response) {
        this.gstinNo = gstinNo;
        this.gstinFile = gstinFile;
        this.gstStatus = gstStatus;
        this.gstStatuss = gstStatuss;
        this.gstRemarkk = gstRemarkk;
        this.gstResponse = gstResponse;
        this.panNo = panNo;
        this.panFile = panFile;
        this.panStatus = panStatus;
        this.panStatuss = panStatuss;
        this.panRemarkk = panRemarkk;
        this.panResponse = panResponse;
        this.service_tax = service_tax;
        this.service_file = service_file;
        this.msmeStatus = msmeStatus;
        this.msmeStatuss = msmeStatuss;
        this.msmeRemarkk = msmeRemarkk;
        this.msmeResponse = msmeResponse;
        this.esicNo = esicNo;
        this.esicFile = esicFile;
        this.esicStatus = esicStatus;
        this.esicStatuss = esicStatuss;
        this.esicRem = esicRem;
        this.esicRes = esicRes;
        this.pfNo = pfNo;
        this.pfAttachment = pfAttachment;
        this.epfoStatus = epfoStatus;
        this.epfoStatuss = epfoStatuss;
        this.epfoRemarkk = epfoRemarkk;
        this.epfoResponse = epfoResponse;
        this.ecc_no = ecc_no;
        this.ecc_file = ecc_file;
        this.eccStatus = eccStatus;
        this.eccStatuss = eccStatuss;
        this.eccRemarkk = eccRemarkk;
        this.eccResponse = eccResponse;
        this.cancelChequeStatuss = cancelChequeStatuss;
        this.cancelChequeRemarkk = cancelChequeRemarkk;
        this.cancelChequeResponse = cancelChequeResponse;
        this.fin1Statuss = fin1Statuss;
        this.fin1Remarkk = fin1Remarkk;
        this.fin1Response = fin1Response;
        this.fin2Statuss = fin2Statuss;
        this.fin2Remarkk = fin2Remarkk;
        this.fin2Response = fin2Response;
        this.fin3Statuss = fin3Statuss;
        this.fin3Remarkk = fin3Remarkk;
        this.fin3Response = fin3Response;
    }

    public VendorInformation(String countryCodeoffTele, String countryCodeNewMobiles, String countryCodeVendorContact, String countryCodeVendorContact1, String countryCodeVendorContact2, String companyProof2, String vendorActivatedDate, String vendorCommentForBuyer,String buyerCommentForApproval,String vendorFinancialUpdateComment) {
        this.countryCodeoffTele = countryCodeoffTele;
        this.countryCodeNewMobiles = countryCodeNewMobiles;
        this.countryCodeVendorContact = countryCodeVendorContact;
        this.countryCodeVendorContact1 = countryCodeVendorContact1;
        this.countryCodeVendorContact2 = countryCodeVendorContact2;
        this.companyProof2 = companyProof2;
        this.vendorActivatedDate = vendorActivatedDate;
        this.vendorCommentForBuyer = vendorCommentForBuyer;
        this.buyerCommentForApproval = buyerCommentForApproval;
        this.vendorFinancialUpdateComment = vendorFinancialUpdateComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorInvitationId() {
        return vendorInvitationId;
    }

    public void setVendorInvitationId(int vendorInvitationId) {
        this.vendorInvitationId = vendorInvitationId;
    }

    public String getVendorEmailId() {
        return vendorEmailId;
    }

    public void setVendorEmailId(String vendorEmailId) {
        this.vendorEmailId = vendorEmailId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPolicyAccept() {
        return policyAccept;
    }

    public void setPolicyAccept(String policyAccept) {
        this.policyAccept = policyAccept;
    }

    public String getPolicyAccept2() {
        return policyAccept2;
    }

    public void setPolicyAccept2(String policyAccept2) {
        this.policyAccept2 = policyAccept2;
    }

    public String getTermsConditionAccept() {
        return termsConditionAccept;
    }

    public void setTermsConditionAccept(String termsConditionAccept) {
        this.termsConditionAccept = termsConditionAccept;
    }

    public String getTermsConditionFile() {
        return termsConditionFile;
    }

    public void setTermsConditionFile(String termsConditionFile) {
        this.termsConditionFile = termsConditionFile;
    }

    public String getTypeOfConcern() {
        return typeOfConcern;
    }

    public void setTypeOfConcern(String typeOfConcern) {
        this.typeOfConcern = typeOfConcern;
    }

    public String getOfficeAddressLine1() {
        return officeAddressLine1;
    }

    public void setOfficeAddressLine1(String officeAddressLine1) {
        this.officeAddressLine1 = officeAddressLine1;
    }

    public String getOfficeAddressLine2() {
        return officeAddressLine2;
    }

    public void setOfficeAddressLine2(String officeAddressLine2) {
        this.officeAddressLine2 = officeAddressLine2;
    }

    public String getOfficeAddressLine3() {
        return officeAddressLine3;
    }

    public void setOfficeAddressLine3(String officeAddressLine3) {
        this.officeAddressLine3 = officeAddressLine3;
    }

    public String getOfficeCity() {
        return officeCity;
    }

    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }

    public String getOfficeDistrict() {
        return officeDistrict;
    }

    public void setOfficeDistrict(String officeDistrict) {
        this.officeDistrict = officeDistrict;
    }

    public String getOfficeState() {
        return officeState;
    }

    public void setOfficeState(String officeState) {
        this.officeState = officeState;
    }

    public String getOfficePin() {
        return officePin;
    }

    public void setOfficePin(String officePin) {
        this.officePin = officePin;
    }

    public String getOfficeCountry() {
        return officeCountry;
    }

    public void setOfficeCountry(String officeCountry) {
        this.officeCountry = officeCountry;
    }

    public String getOfficeTelephone() {
        return officeTelephone;
    }

    public void setOfficeTelephone(String officeTelephone) {
        this.officeTelephone = officeTelephone;
    }

    public String getOfficeMobile() {
        return officeMobile;
    }

    public void setOfficeMobile(String officeMobile) {
        this.officeMobile = officeMobile;
    }

    public String getOfficeFax() {
        return officeFax;
    }

    public void setOfficeFax(String officeFax) {
        this.officeFax = officeFax;
    }

    public String getOfficeEmail() {
        return officeEmail;
    }

    public void setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
    }

    public String getOfficeWebsite() {
        return officeWebsite;
    }

    public void setOfficeWebsite(String officeWebsite) {
        this.officeWebsite = officeWebsite;
    }

    public String getOfficeWeeklyHoliday() {
        return officeWeeklyHoliday;
    }

    public void setOfficeWeeklyHoliday(String officeWeeklyHoliday) {
        this.officeWeeklyHoliday = officeWeeklyHoliday;
    }

    public String getOfficeContactPersonName() {
        return officeContactPersonName;
    }

    public void setOfficeContactPersonName(String officeContactPersonName) {
        this.officeContactPersonName = officeContactPersonName;
    }

    public String getOfficeContactDesignation() {
        return officeContactDesignation;
    }

    public void setOfficeContactDesignation(String officeContactDesignation) {
        this.officeContactDesignation = officeContactDesignation;
    }

    public String getOfficeContactMobile() {
        return officeContactMobile;
    }

    public void setOfficeContactMobile(String officeContactMobile) {
        this.officeContactMobile = officeContactMobile;
    }

    public String getOfficeContactEmail() {
        return officeContactEmail;
    }

    public void setOfficeContactEmail(String officeContactEmail) {
        this.officeContactEmail = officeContactEmail;
    }

    public String getWorkAddressLine1() {
        return workAddressLine1;
    }

    public void setWorkAddressLine1(String workAddressLine1) {
        this.workAddressLine1 = workAddressLine1;
    }

    public String getWorkAddressLine2() {
        return workAddressLine2;
    }

    public void setWorkAddressLine2(String workAddressLine2) {
        this.workAddressLine2 = workAddressLine2;
    }

    public String getWorkAddressLine3() {
        return workAddressLine3;
    }

    public void setWorkAddressLine3(String workAddressLine3) {
        this.workAddressLine3 = workAddressLine3;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkPin() {
        return workPin;
    }

    public void setWorkPin(String workPin) {
        this.workPin = workPin;
    }

    public String getWorkCountry() {
        return workCountry;
    }

    public void setWorkCountry(String workCountry) {
        this.workCountry = workCountry;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }

    public void setWorkTelephone(String workTelephone) {
        this.workTelephone = workTelephone;
    }

    public String getWorkMobile() {
        return workMobile;
    }

    public void setWorkMobile(String workMobile) {
        this.workMobile = workMobile;
    }

    public String getWorkFax() {
        return workFax;
    }

    public void setWorkFax(String workFax) {
        this.workFax = workFax;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getWorkWebsite() {
        return workWebsite;
    }

    public void setWorkWebsite(String workWebsite) {
        this.workWebsite = workWebsite;
    }

    public String getWorkWeeklyHoliday() {
        return workWeeklyHoliday;
    }

    public void setWorkWeeklyHoliday(String workWeeklyHoliday) {
        this.workWeeklyHoliday = workWeeklyHoliday;
    }

    public String getWorkContactPersonName() {
        return workContactPersonName;
    }

    public void setWorkContactPersonName(String workContactPersonName) {
        this.workContactPersonName = workContactPersonName;
    }

    public String getWorkContactDesignation() {
        return workContactDesignation;
    }

    public void setWorkContactDesignation(String workContactDesignation) {
        this.workContactDesignation = workContactDesignation;
    }

    public String getWorkContactMobile() {
        return workContactMobile;
    }

    public void setWorkContactMobile(String workContactMobile) {
        this.workContactMobile = workContactMobile;
    }

    public String getWorkContactEmail() {
        return workContactEmail;
    }

    public void setWorkContactEmail(String workContactEmail) {
        this.workContactEmail = workContactEmail;
    }

    public String getProductService() {
        return productService;
    }

    public void setProductService(String productService) {
        this.productService = productService;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPanFile() {
        return panFile;
    }

    public void setPanFile(String panFile) {
        this.panFile = panFile;
    }

    public String getGstinNo() {
        return gstinNo;
    }

    public void setGstinNo(String gstinNo) {
        this.gstinNo = gstinNo;
    }

    public String getGstinFile() {
        return gstinFile;
    }

    public void setGstinFile(String gstinFile) {
        this.gstinFile = gstinFile;
    }

    public String getTypeOfGst() {
        return typeOfGst;
    }

    public void setTypeOfGst(String typeOfGst) {
        this.typeOfGst = typeOfGst;
    }

    public String getProductWiseCapacity() {
        return productWiseCapacity;
    }

    public void setProductWiseCapacity(String productWiseCapacity) {
        this.productWiseCapacity = productWiseCapacity;
    }

    public String getDevelopmentCapabilities() {
        return developmentCapabilities;
    }

    public void setDevelopmentCapabilities(String developmentCapabilities) {
        this.developmentCapabilities = developmentCapabilities;
    }

    public String getMachineryTechnology() {
        return machineryTechnology;
    }

    public void setMachineryTechnology(String machineryTechnology) {
        this.machineryTechnology = machineryTechnology;
    }

    public String getMaterialHandling() {
        return materialHandling;
    }

    public void setMaterialHandling(String materialHandling) {
        this.materialHandling = materialHandling;
    }

    public String getFirstYear() {
        return firstYear;
    }

    public void setFirstYear(String firstYear) {
        this.firstYear = firstYear;
    }

    public String getFirstYearFile() {
        return firstYearFile;
    }

    public void setFirstYearFile(String firstYearFile) {
        this.firstYearFile = firstYearFile;
    }

    public String getSecondYear() {
        return secondYear;
    }

    public void setSecondYear(String secondYear) {
        this.secondYear = secondYear;
    }

    public String getSecondYearFile() {
        return secondYearFile;
    }

    public void setSecondYearFile(String secondYearFile) {
        this.secondYearFile = secondYearFile;
    }

    public String getThirdYear() {
        return thirdYear;
    }

    public void setThirdYear(String thirdYear) {
        this.thirdYear = thirdYear;
    }

    public String getThirdYearFile() {
        return thirdYearFile;
    }

    public void setThirdYearFile(String thirdYearFile) {
        this.thirdYearFile = thirdYearFile;
    }

    public String getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(String balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public String getBalanceSheetFile() {
        return balanceSheetFile;
    }

    public void setBalanceSheetFile(String balanceSheetFile) {
        this.balanceSheetFile = balanceSheetFile;
    }

    public String getMsmeCertificate() {
        return msmeCertificate;
    }

    public void setMsmeCertificate(String msmeCertificate) {
        this.msmeCertificate = msmeCertificate;
    }

    public String getMsmeCertificateFile() {
        return msmeCertificateFile;
    }

    public void setMsmeCertificateFile(String msmeCertificateFile) {
        this.msmeCertificateFile = msmeCertificateFile;
    }

    public String getMajorCustomers() {
        return majorCustomers;
    }

    public void setMajorCustomers(String majorCustomers) {
        this.majorCustomers = majorCustomers;
    }

    public String getCustomerRatings() {
        return customerRatings;
    }

    public void setCustomerRatings(String customerRatings) {
        this.customerRatings = customerRatings;
    }

    public String getWorkCompletionCertificates() {
        return workCompletionCertificates;
    }

    public void setWorkCompletionCertificates(String workCompletionCertificates) {
        this.workCompletionCertificates = workCompletionCertificates;
    }

    public String getTotalStaff() {
        return totalStaff;
    }

    public void setTotalStaff(String totalStaff) {
        this.totalStaff = totalStaff;
    }

    public String getSkilledWorkers() {
        return skilledWorkers;
    }

    public void setSkilledWorkers(String skilledWorkers) {
        this.skilledWorkers = skilledWorkers;
    }

    public String getUnskilledWorkers() {
        return unskilledWorkers;
    }

    public void setUnskilledWorkers(String unskilledWorkers) {
        this.unskilledWorkers = unskilledWorkers;
    }

    public String getSexRatio() {
        return sexRatio;
    }

    public void setSexRatio(String sexRatio) {
        this.sexRatio = sexRatio;
    }

    public String getSuspensionOfWork() {
        return suspensionOfWork;
    }

    public void setSuspensionOfWork(String suspensionOfWork) {
        this.suspensionOfWork = suspensionOfWork;
    }

    public String getOrganizationOfQa() {
        return organizationOfQa;
    }

    public void setOrganizationOfQa(String organizationOfQa) {
        this.organizationOfQa = organizationOfQa;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getSustainability() {
        return sustainability;
    }

    public void setSustainability(String sustainability) {
        this.sustainability = sustainability;
    }

    public String getFairLabourStandardFile() {
        return fairLabourStandardFile;
    }

    public void setFairLabourStandardFile(String fairLabourStandardFile) {
        this.fairLabourStandardFile = fairLabourStandardFile;
    }

    public String getInspectionFacilities() {
        return inspectionFacilities;
    }

    public void setInspectionFacilities(String inspectionFacilities) {
        this.inspectionFacilities = inspectionFacilities;
    }

    public String getInspectionProcedure() {
        return inspectionProcedure;
    }

    public void setInspectionProcedure(String inspectionProcedure) {
        this.inspectionProcedure = inspectionProcedure;
    }

    public String getChangeManagementProcess() {
        return changeManagementProcess;
    }

    public void setChangeManagementProcess(String changeManagementProcess) {
        this.changeManagementProcess = changeManagementProcess;
    }

    public String getSustainabilityInitiativesFile() {
        return sustainabilityInitiativesFile;
    }

    public void setSustainabilityInitiativesFile(String sustainabilityInitiativesFile) {
        this.sustainabilityInitiativesFile = sustainabilityInitiativesFile;
    }

    public String getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(String carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }

    public String getIrReportFile() {
        return irReportFile;
    }

    public void setIrReportFile(String irReportFile) {
        this.irReportFile = irReportFile;
    }

    public String getCircularEconomyFile() {
        return circularEconomyFile;
    }

    public void setCircularEconomyFile(String circularEconomyFile) {
        this.circularEconomyFile = circularEconomyFile;
    }

    public String getGreenProductFile() {
        return greenProductFile;
    }

    public void setGreenProductFile(String greenProductFile) {
        this.greenProductFile = greenProductFile;
    }

    public String getGreenCompanyFile() {
        return greenCompanyFile;
    }

    public void setGreenCompanyFile(String greenCompanyFile) {
        this.greenCompanyFile = greenCompanyFile;
    }

    public String getLifeCycleAnalysisFile() {
        return lifeCycleAnalysisFile;
    }

    public void setLifeCycleAnalysisFile(String lifeCycleAnalysisFile) {
        this.lifeCycleAnalysisFile = lifeCycleAnalysisFile;
    }

    public String getAwareAboutSafety() {
        return awareAboutSafety;
    }

    public void setAwareAboutSafety(String awareAboutSafety) {
        this.awareAboutSafety = awareAboutSafety;
    }

    public String getIncidentsDuringWork() {
        return incidentsDuringWork;
    }

    public void setIncidentsDuringWork(String incidentsDuringWork) {
        this.incidentsDuringWork = incidentsDuringWork;
    }

    public String getIncidentsDetails() {
        return incidentsDetails;
    }

    public void setIncidentsDetails(String incidentsDetails) {
        this.incidentsDetails = incidentsDetails;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getInformationFurnishedByFile() {
        return informationFurnishedByFile;
    }

    public void setInformationFurnishedByFile(String informationFurnishedByFile) {
        this.informationFurnishedByFile = informationFurnishedByFile;
    }

    public int getStatus1() {
        return status1;
    }

    public void setStatus1(int status1) {
        this.status1 = status1;
    }

    public String getApprovalOne() {
        return approvalOne;
    }

    public void setApprovalOne(String approvalOne) {
        this.approvalOne = approvalOne;
    }

    public String getApprovalTwo() {
        return approvalTwo;
    }

    public void setApprovalTwo(String approvalTwo) {
        this.approvalTwo = approvalTwo;
    }

    public String getVendorFile() {
        return vendorFile;
    }

    public void setVendorFile(String vendorFile) {
        this.vendorFile = vendorFile;
    }

    public String getCodeOfSupplier() {
        return codeOfSupplier;
    }

    public void setCodeOfSupplier(String codeOfSupplier) {
        this.codeOfSupplier = codeOfSupplier;
    }

    public String getTypeOfSupplier() {
        return typeOfSupplier;
    }

    public void setTypeOfSupplier(String typeOfSupplier) {
        this.typeOfSupplier = typeOfSupplier;
    }

    public String getWorkingOfSupplier() {
        return workingOfSupplier;
    }

    public void setWorkingOfSupplier(String workingOfSupplier) {
        this.workingOfSupplier = workingOfSupplier;
    }

    public String getAccountingGroup() {
        return accountingGroup;
    }

    public void setAccountingGroup(String accountingGroup) {
        this.accountingGroup = accountingGroup;
    }

    public String getIncoTerm() {
        return incoTerm;
    }

    public void setIncoTerm(String incoTerm) {
        this.incoTerm = incoTerm;
    }

    public String getMaterialGroup() {
        return materialGroup;
    }

    public void setMaterialGroup(String materialGroup) {
        this.materialGroup = materialGroup;
    }

    public String getMaterialSubGroup() {
        return materialSubGroup;
    }

    public void setMaterialSubGroup(String materialSubGroup) {
        this.materialSubGroup = materialSubGroup;
    }

    public String getPolicyFile() {
        return policyFile;
    }

    public void setPolicyFile(String policyFile) {
        this.policyFile = policyFile;
    }

    public String getChequeFile() {
        return chequeFile;
    }

    public void setChequeFile(String chequeFile) {
        this.chequeFile = chequeFile;
    }

    public String getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(String approveDate) {
        this.approveDate = approveDate;
    }

    public String getApprovalThree() {
        return approvalThree;
    }

    public void setApprovalThree(String approvalThree) {
        this.approvalThree = approvalThree;
    }

    public String getBusinessContinuity() {
        return businessContinuity;
    }

    public void setBusinessContinuity(String businessContinuity) {
        this.businessContinuity = businessContinuity;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getGeneral_traders() {
        return general_traders;
    }

    public void setGeneral_traders(String general_traders) {
        this.general_traders = general_traders;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public String getSales_name() {
        return sales_name;
    }

    public void setSales_name(String sales_name) {
        this.sales_name = sales_name;
    }

    public String getSales_job() {
        return sales_job;
    }

    public void setSales_job(String sales_job) {
        this.sales_job = sales_job;
    }

    public String getSales_phone() {
        return sales_phone;
    }

    public void setSales_phone(String sales_phone) {
        this.sales_phone = sales_phone;
    }

    public String getTechnical_name() {
        return technical_name;
    }

    public void setTechnical_name(String technical_name) {
        this.technical_name = technical_name;
    }

    public String getTechnical_job() {
        return technical_job;
    }

    public void setTechnical_job(String technical_job) {
        this.technical_job = technical_job;
    }

    public String getTechnical_phone() {
        return technical_phone;
    }

    public void setTechnical_phone(String technical_phone) {
        this.technical_phone = technical_phone;
    }

    public String getQuality_name() {
        return quality_name;
    }

    public void setQuality_name(String quality_name) {
        this.quality_name = quality_name;
    }

    public String getQuality_job() {
        return quality_job;
    }

    public void setQuality_job(String quality_job) {
        this.quality_job = quality_job;
    }

    public String getQuality_phone() {
        return quality_phone;
    }

    public void setQuality_phone(String quality_phone) {
        this.quality_phone = quality_phone;
    }

    public String getCst_no() {
        return cst_no;
    }

    public void setCst_no(String cst_no) {
        this.cst_no = cst_no;
    }

    public String getCst_file() {
        return cst_file;
    }

    public void setCst_file(String cst_file) {
        this.cst_file = cst_file;
    }

    public String getVat_pin() {
        return vat_pin;
    }

    public void setVat_pin(String vat_pin) {
        this.vat_pin = vat_pin;
    }

    public String getVat_file() {
        return vat_file;
    }

    public void setVat_file(String vat_file) {
        this.vat_file = vat_file;
    }

    public String getEcc_no() {
        return ecc_no;
    }

    public void setEcc_no(String ecc_no) {
        this.ecc_no = ecc_no;
    }

    public String getEcc_file() {
        return ecc_file;
    }

    public void setEcc_file(String ecc_file) {
        this.ecc_file = ecc_file;
    }

    public String getService_tax() {
        return service_tax;
    }

    public void setService_tax(String service_tax) {
        this.service_tax = service_tax;
    }

    public String getService_file() {
        return service_file;
    }

    public void setService_file(String service_file) {
        this.service_file = service_file;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getTraders() {
        return traders;
    }

    public void setTraders(String traders) {
        this.traders = traders;
    }

    public String getMaterialSupply() {
        return materialSupply;
    }

    public void setMaterialSupply(String materialSupply) {
        this.materialSupply = materialSupply;
    }

    public String getDealingServices() {
        return dealingServices;
    }

    public void setDealingServices(String dealingServices) {
        this.dealingServices = dealingServices;
    }

    public String getEsicNo() {
        return esicNo;
    }

    public void setEsicNo(String esicNo) {
        this.esicNo = esicNo;
    }

    public String getCapabilities1() {
        return capabilities1;
    }

    public void setCapabilities1(String capabilities1) {
        this.capabilities1 = capabilities1;
    }

    public String getSpecificProducts() {
        return specificProducts;
    }

    public void setSpecificProducts(String specificProducts) {
        this.specificProducts = specificProducts;
    }

    public String getQualityManagement() {
        return qualityManagement;
    }

    public void setQualityManagement(String qualityManagement) {
        this.qualityManagement = qualityManagement;
    }

    public String getQualityIso() {
        return qualityIso;
    }

    public void setQualityIso(String qualityIso) {
        this.qualityIso = qualityIso;
    }

    public String getQualityApi() {
        return qualityApi;
    }

    public void setQualityApi(String qualityApi) {
        this.qualityApi = qualityApi;
    }

    public String getQualityIs() {
        return qualityIs;
    }

    public void setQualityIs(String qualityIs) {
        this.qualityIs = qualityIs;
    }

    public String getQualityOthers() {
        return qualityOthers;
    }

    public void setQualityOthers(String qualityOthers) {
        this.qualityOthers = qualityOthers;
    }

    public String getEnvironmentManagement() {
        return environmentManagement;
    }

    public void setEnvironmentManagement(String environmentManagement) {
        this.environmentManagement = environmentManagement;
    }

    public String getIndianChemical() {
        return indianChemical;
    }

    public void setIndianChemical(String indianChemical) {
        this.indianChemical = indianChemical;
    }

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    public String getPolicy1File() {
        return policy1File;
    }

    public void setPolicy1File(String policy1File) {
        this.policy1File = policy1File;
    }

    public String getPolicy2File() {
        return policy2File;
    }

    public void setPolicy2File(String policy2File) {
        this.policy2File = policy2File;
    }

    public String getElectricalService() {
        return electricalService;
    }

    public void setElectricalService(String electricalService) {
        this.electricalService = electricalService;
    }

    public String getSecoundMobile() {
        return secoundMobile;
    }

    public void setSecoundMobile(String secoundMobile) {
        this.secoundMobile = secoundMobile;
    }

    public String getCancelCheck() {
        return cancelCheck;
    }

    public void setCancelCheck(String cancelCheck) {
        this.cancelCheck = cancelCheck;
    }

    public String getTechnicalApproval() {
        return technicalApproval;
    }

    public void setTechnicalApproval(String technicalApproval) {
        this.technicalApproval = technicalApproval;
    }

    public String getFinacialApproval() {
        return finacialApproval;
    }

    public void setFinacialApproval(String finacialApproval) {
        this.finacialApproval = finacialApproval;
    }

    public Integer getFinacialFlag() {
        return finacialFlag;
    }

    public void setFinacialFlag(Integer finacialFlag) {
        this.finacialFlag = finacialFlag;
    }

    public Integer getTechnicalFlag() {
        return technicalFlag;
    }

    public void setTechnicalFlag(Integer technicalFlag) {
        this.technicalFlag = technicalFlag;
    }

    public String getHrApproval() {
        return hrApproval;
    }

    public void setHrApproval(String hrApproval) {
        this.hrApproval = hrApproval;
    }

    public String getSafetyApproval() {
        return safetyApproval;
    }

    public void setSafetyApproval(String safetyApproval) {
        this.safetyApproval = safetyApproval;
    }

    public String getItApproval() {
        return itApproval;
    }

    public void setItApproval(String itApproval) {
        this.itApproval = itApproval;
    }

    public Integer getHrApprovalFlag() {
        return hrApprovalFlag;
    }

    public void setHrApprovalFlag(Integer hrApprovalFlag) {
        this.hrApprovalFlag = hrApprovalFlag;
    }

    public Integer getSafteyApprovalFlag() {
        return safteyApprovalFlag;
    }

    public void setSafteyApprovalFlag(Integer safteyApprovalFlag) {
        this.safteyApprovalFlag = safteyApprovalFlag;
    }

    public Integer getItApprovalFlag() {
        return itApprovalFlag;
    }

    public void setItApprovalFlag(Integer itApprovalFlag) {
        this.itApprovalFlag = itApprovalFlag;
    }

    public String getSaleEmail() {
        return saleEmail;
    }

    public void setSaleEmail(String saleEmail) {
        this.saleEmail = saleEmail;
    }

    public String getTechnicalContactEmail() {
        return technicalContactEmail;
    }

    public void setTechnicalContactEmail(String technicalContactEmail) {
        this.technicalContactEmail = technicalContactEmail;
    }

    public String getQualityEmail() {
        return qualityEmail;
    }

    public void setQualityEmail(String qualityEmail) {
        this.qualityEmail = qualityEmail;
    }

    public String getPfNo() {
        return pfNo;
    }

    public void setPfNo(String pfNo) {
        this.pfNo = pfNo;
    }

    public String getCicNo() {
        return cicNo;
    }

    public void setCicNo(String cicNo) {
        this.cicNo = cicNo;
    }

    public String getPfAttachment() {
        return pfAttachment;
    }

    public void setPfAttachment(String pfAttachment) {
        this.pfAttachment = pfAttachment;
    }

    public String getCicAttachment() {
        return cicAttachment;
    }

    public void setCicAttachment(String cicAttachment) {
        this.cicAttachment = cicAttachment;
    }

    public String getFinical1() {
        return finical1;
    }

    public void setFinical1(String finical1) {
        this.finical1 = finical1;
    }

    public String getFinical2() {
        return finical2;
    }

    public void setFinical2(String finical2) {
        this.finical2 = finical2;
    }

    public String getFinical3() {
        return finical3;
    }

    public void setFinical3(String finical3) {
        this.finical3 = finical3;
    }

    public String getFinicalAttachment1() {
        return finicalAttachment1;
    }

    public void setFinicalAttachment1(String finicalAttachment1) {
        this.finicalAttachment1 = finicalAttachment1;
    }

    public String getFinicalAttachment2() {
        return finicalAttachment2;
    }

    public void setFinicalAttachment2(String finicalAttachment2) {
        this.finicalAttachment2 = finicalAttachment2;
    }

    public String getFinicalAttachment3() {
        return finicalAttachment3;
    }

    public void setFinicalAttachment3(String finicalAttachment3) {
        this.finicalAttachment3 = finicalAttachment3;
    }

    public String getFinicalAmount1() {
        return finicalAmount1;
    }

    public void setFinicalAmount1(String finicalAmount1) {
        this.finicalAmount1 = finicalAmount1;
    }

    public String getFinicalAmount2() {
        return finicalAmount2;
    }

    public void setFinicalAmount2(String finicalAmount2) {
        this.finicalAmount2 = finicalAmount2;
    }

    public String getFinicalAmount3() {
        return finicalAmount3;
    }

    public void setFinicalAmount3(String finicalAmount3) {
        this.finicalAmount3 = finicalAmount3;
    }

    public String getVendorTypes() {
        return vendorTypes;
    }

    public void setVendorTypes(String vendorTypes) {
        this.vendorTypes = vendorTypes;
    }

    public String getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(String groupCategory) {
        this.groupCategory = groupCategory;
    }

    public String getGroupSubCategory() {
        return groupSubCategory;
    }

    public void setGroupSubCategory(String groupSubCategory) {
        this.groupSubCategory = groupSubCategory;
    }

    public String getBpGroup() {
        return bpGroup;
    }

    public void setBpGroup(String bpGroup) {
        this.bpGroup = bpGroup;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getGstRemark() {
        return gstRemark;
    }

    public void setGstRemark(String gstRemark) {
        this.gstRemark = gstRemark;
    }

    public String getBuyerCompany() {
        return buyerCompany;
    }

    public void setBuyerCompany(String buyerCompany) {
        this.buyerCompany = buyerCompany;
    }

    public String getPurchasingGroup() {
        return purchasingGroup;
    }

    public void setPurchasingGroup(String purchasingGroup) {
        this.purchasingGroup = purchasingGroup;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGroupCalculation() {
        return groupCalculation;
    }

    public void setGroupCalculation(String groupCalculation) {
        this.groupCalculation = groupCalculation;
    }

    public String getTermOfPayment() {
        return termOfPayment;
    }

    public void setTermOfPayment(String termOfPayment) {
        this.termOfPayment = termOfPayment;
    }

    public String getRecAccountNo() {
        return recAccountNo;
    }

    public void setRecAccountNo(String recAccountNo) {
        this.recAccountNo = recAccountNo;
    }

    public String getBankKey() {
        return bankKey;
    }

    public void setBankKey(String bankKey) {
        this.bankKey = bankKey;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTaxDetails() {
        return taxDetails;
    }

    public void setTaxDetails(String taxDetails) {
        this.taxDetails = taxDetails;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getSearchTerm1() {
        return searchTerm1;
    }

    public void setSearchTerm1(String searchTerm1) {
        this.searchTerm1 = searchTerm1;
    }

    public String getWithoutHoldingTaxType() {
        return withoutHoldingTaxType;
    }

    public void setWithoutHoldingTaxType(String withoutHoldingTaxType) {
        this.withoutHoldingTaxType = withoutHoldingTaxType;
    }

    public String getWithoutHoldingTaxCode() {
        return withoutHoldingTaxCode;
    }

    public void setWithoutHoldingTaxCode(String withoutHoldingTaxCode) {
        this.withoutHoldingTaxCode = withoutHoldingTaxCode;
    }

    public String getManagerialPersonDetails() {
        return managerialPersonDetails;
    }

    public void setManagerialPersonDetails(String managerialPersonDetails) {
        this.managerialPersonDetails = managerialPersonDetails;
    }

    public String getManagerialPersonEmail() {
        return managerialPersonEmail;
    }

    public void setManagerialPersonEmail(String managerialPersonEmail) {
        this.managerialPersonEmail = managerialPersonEmail;
    }

    public String getManagerialPersonJob() {
        return managerialPersonJob;
    }

    public void setManagerialPersonJob(String managerialPersonJob) {
        this.managerialPersonJob = managerialPersonJob;
    }

    public String getManagerialPersonPhone() {
        return managerialPersonPhone;
    }

    public void setManagerialPersonPhone(String managerialPersonPhone) {
        this.managerialPersonPhone = managerialPersonPhone;
    }

    public String getManagerialPersonDetails2() {
        return managerialPersonDetails2;
    }

    public void setManagerialPersonDetails2(String managerialPersonDetails2) {
        this.managerialPersonDetails2 = managerialPersonDetails2;
    }

    public String getManagerialPersonEmail2() {
        return managerialPersonEmail2;
    }

    public void setManagerialPersonEmail2(String managerialPersonEmail2) {
        this.managerialPersonEmail2 = managerialPersonEmail2;
    }

    public String getManagerialPersonJob2() {
        return managerialPersonJob2;
    }

    public void setManagerialPersonJob2(String managerialPersonJob2) {
        this.managerialPersonJob2 = managerialPersonJob2;
    }

    public String getManagerialPersonPhone2() {
        return managerialPersonPhone2;
    }

    public void setManagerialPersonPhone2(String managerialPersonPhone2) {
        this.managerialPersonPhone2 = managerialPersonPhone2;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getVendorInviteSource() {
        return vendorInviteSource;
    }

    public void setVendorInviteSource(String vendorInviteSource) {
        this.vendorInviteSource = vendorInviteSource;
    }

    public String getMsmeResponse() {
        return msmeResponse;
    }

    public void setMsmeResponse(String msmeResponse) {
        this.msmeResponse = msmeResponse;
    }

    public String getEpfoResponse() {
        return epfoResponse;
    }

    public void setEpfoResponse(String epfoResponse) {
        this.epfoResponse = epfoResponse;
    }

    public String getGstStatuss() {
        return gstStatuss;
    }

    public void setGstStatuss(String gstStatuss) {
        this.gstStatuss = gstStatuss;
    }

    public String getGstRemarkk() {
        return gstRemarkk;
    }

    public void setGstRemarkk(String gstRemarkk) {
        this.gstRemarkk = gstRemarkk;
    }

    public String getPanStatuss() {
        return panStatuss;
    }

    public void setPanStatuss(String panStatuss) {
        this.panStatuss = panStatuss;
    }

    public String getPanRemarkk() {
        return panRemarkk;
    }

    public void setPanRemarkk(String panRemarkk) {
        this.panRemarkk = panRemarkk;
    }

    public String getMsmeStatuss() {
        return msmeStatuss;
    }

    public void setMsmeStatuss(String msmeStatuss) {
        this.msmeStatuss = msmeStatuss;
    }

    public String getMsmeRemarkk() {
        return msmeRemarkk;
    }

    public void setMsmeRemarkk(String msmeRemarkk) {
        this.msmeRemarkk = msmeRemarkk;
    }

    public String getEpfoStatuss() {
        return epfoStatuss;
    }

    public void setEpfoStatuss(String epfoStatuss) {
        this.epfoStatuss = epfoStatuss;
    }

    public String getEpfoRemarkk() {
        return epfoRemarkk;
    }

    public void setEpfoRemarkk(String epfoRemarkk) {
        this.epfoRemarkk = epfoRemarkk;
    }

    public String getCancelChequeStatuss() {
        return cancelChequeStatuss;
    }

    public void setCancelChequeStatuss(String cancelChequeStatuss) {
        this.cancelChequeStatuss = cancelChequeStatuss;
    }

    public String getCancelChequeRemarkk() {
        return cancelChequeRemarkk;
    }

    public void setCancelChequeRemarkk(String cancelChequeRemarkk) {
        this.cancelChequeRemarkk = cancelChequeRemarkk;
    }

    public String getFin1Statuss() {
        return fin1Statuss;
    }

    public void setFin1Statuss(String fin1Statuss) {
        this.fin1Statuss = fin1Statuss;
    }

    public String getFin1Remarkk() {
        return fin1Remarkk;
    }

    public void setFin1Remarkk(String fin1Remarkk) {
        this.fin1Remarkk = fin1Remarkk;
    }

    public String getFin2Statuss() {
        return fin2Statuss;
    }

    public void setFin2Statuss(String fin2Statuss) {
        this.fin2Statuss = fin2Statuss;
    }

    public String getFin2Remarkk() {
        return fin2Remarkk;
    }

    public void setFin2Remarkk(String fin2Remarkk) {
        this.fin2Remarkk = fin2Remarkk;
    }

    public String getFin3Statuss() {
        return fin3Statuss;
    }

    public void setFin3Statuss(String fin3Statuss) {
        this.fin3Statuss = fin3Statuss;
    }

    public String getFin3Remarkk() {
        return fin3Remarkk;
    }

    public void setFin3Remarkk(String fin3Remarkk) {
        this.fin3Remarkk = fin3Remarkk;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public int getAuditorFlag() {
        return auditorFlag;
    }

    public void setAuditorFlag(int auditorFlag) {
        this.auditorFlag = auditorFlag;
    }

    public String getAuditorAttachment() {
        return auditorAttachment;
    }

    public void setAuditorAttachment(String auditorAttachment) {
        this.auditorAttachment = auditorAttachment;
    }

    public String getAuditorRemark() {
        return auditorRemark;
    }

    public void setAuditorRemark(String auditorRemark) {
        this.auditorRemark = auditorRemark;
    }

    public String getNdaPolicyFile() {
        return ndaPolicyFile;
    }

    public void setNdaPolicyFile(String ndaPolicyFile) {
        this.ndaPolicyFile = ndaPolicyFile;
    }

    public String getNdaPolicyAccept() {
        return ndaPolicyAccept;
    }

    public void setNdaPolicyAccept(String ndaPolicyAccept) {
        this.ndaPolicyAccept = ndaPolicyAccept;
    }

    public String getCompanyProof() {
        return companyProof;
    }

    public void setCompanyProof(String companyProof) {
        this.companyProof = companyProof;
    }

    public String getRiskBand() {
        return riskBand;
    }

    public void setRiskBand(String riskBand) {
        this.riskBand = riskBand;
    }

    public String getSpecialComment() {
        return specialComment;
    }

    public void setSpecialComment(String specialComment) {
        this.specialComment = specialComment;
    }

    public String getSpecialAttachment() {
        return specialAttachment;
    }

    public void setSpecialAttachment(String specialAttachment) {
        this.specialAttachment = specialAttachment;
    }

    public String getSapCode() {
        return sapCode;
    }

    public void setSapCode(String sapCode) {
        this.sapCode = sapCode;
    }

    public String getEsicFile() {
        return esicFile;
    }

    public void setEsicFile(String esicFile) {
        this.esicFile = esicFile;
    }

    public String getEsicStatus() {
        return esicStatus;
    }

    public void setEsicStatus(String esicStatus) {
        this.esicStatus = esicStatus;
    }

    public String getEsicStatuss() {
        return esicStatuss;
    }

    public void setEsicStatuss(String esicStatuss) {
        this.esicStatuss = esicStatuss;
    }

    public String getEsicRem() {
        return esicRem;
    }

    public void setEsicRem(String esicRem) {
        this.esicRem = esicRem;
    }

    public String getEsicRes() {
        return esicRes;
    }

    public void setEsicRes(String esicRes) {
        this.esicRes = esicRes;
    }

    public String getGstStatus() {
        return gstStatus;
    }

    public void setGstStatus(String gstStatus) {
        this.gstStatus = gstStatus;
    }

    public String getGstResponse() {
        return gstResponse;
    }

    public void setGstResponse(String gstResponse) {
        this.gstResponse = gstResponse;
    }

    public String getPanStatus() {
        return panStatus;
    }

    public void setPanStatus(String panStatus) {
        this.panStatus = panStatus;
    }

    public String getPanResponse() {
        return panResponse;
    }

    public void setPanResponse(String panResponse) {
        this.panResponse = panResponse;
    }

    public String getMsmeStatus() {
        return msmeStatus;
    }

    public void setMsmeStatus(String msmeStatus) {
        this.msmeStatus = msmeStatus;
    }

    public String getEpfoStatus() {
        return epfoStatus;
    }

    public void setEpfoStatus(String epfoStatus) {
        this.epfoStatus = epfoStatus;
    }

    public String getEccStatus() {
        return eccStatus;
    }

    public void setEccStatus(String eccStatus) {
        this.eccStatus = eccStatus;
    }

    public String getEccStatuss() {
        return eccStatuss;
    }

    public void setEccStatuss(String eccStatuss) {
        this.eccStatuss = eccStatuss;
    }

    public String getEccRemarkk() {
        return eccRemarkk;
    }

    public void setEccRemarkk(String eccRemarkk) {
        this.eccRemarkk = eccRemarkk;
    }

    public String getEccResponse() {
        return eccResponse;
    }

    public void setEccResponse(String eccResponse) {
        this.eccResponse = eccResponse;
    }

    public String getCancelChequeResponse() {
        return cancelChequeResponse;
    }

    public void setCancelChequeResponse(String cancelChequeResponse) {
        this.cancelChequeResponse = cancelChequeResponse;
    }

    public String getFin1Response() {
        return fin1Response;
    }

    public void setFin1Response(String fin1Response) {
        this.fin1Response = fin1Response;
    }

    public String getFin2Response() {
        return fin2Response;
    }

    public void setFin2Response(String fin2Response) {
        this.fin2Response = fin2Response;
    }

    public String getFin3Response() {
        return fin3Response;
    }

    public void setFin3Response(String fin3Response) {
        this.fin3Response = fin3Response;
    }

    public String getCountryCodeoffTele() {
        return countryCodeoffTele;
    }

    public void setCountryCodeoffTele(String countryCodeoffTele) {
        this.countryCodeoffTele = countryCodeoffTele;
    }

    public String getCountryCodeNewMobiles() {
        return countryCodeNewMobiles;
    }

    public void setCountryCodeNewMobiles(String countryCodeNewMobiles) {
        this.countryCodeNewMobiles = countryCodeNewMobiles;
    }

    public String getCountryCodeVendorContact() {
        return countryCodeVendorContact;
    }

    public void setCountryCodeVendorContact(String countryCodeVendorContact) {
        this.countryCodeVendorContact = countryCodeVendorContact;
    }

    public String getCountryCodeVendorContact1() {
        return countryCodeVendorContact1;
    }

    public void setCountryCodeVendorContact1(String countryCodeVendorContact1) {
        this.countryCodeVendorContact1 = countryCodeVendorContact1;
    }

    public String getCountryCodeVendorContact2() {
        return countryCodeVendorContact2;
    }

    public void setCountryCodeVendorContact2(String countryCodeVendorContact2) {
        this.countryCodeVendorContact2 = countryCodeVendorContact2;
    }

    public String getCompanyProof2() {
        return companyProof2;
    }

    public void setCompanyProof2(String companyProof2) {
        this.companyProof2 = companyProof2;
    }

    public String getVendorActivatedDate() {
        return vendorActivatedDate;
    }

    public void setVendorActivatedDate(String vendorActivatedDate) {
        this.vendorActivatedDate = vendorActivatedDate;
    }

    public String getVendorCommentForBuyer() {
        return vendorCommentForBuyer;
    }

    public void setVendorCommentForBuyer(String vendorCommentForBuyer) {
        this.vendorCommentForBuyer = vendorCommentForBuyer;
    }

    public String getBuyerCommentForApproval() {
        return buyerCommentForApproval;
    }

    public void setBuyerCommentForApproval(String buyerCommentForApproval) {
        this.buyerCommentForApproval = buyerCommentForApproval;
    }

    public String getVendorFinancialUpdateComment() {
        return vendorFinancialUpdateComment;
    }

    public void setVendorFinancialUpdateComment(String vendorFinancialUpdateComment) {
        this.vendorFinancialUpdateComment = vendorFinancialUpdateComment;
    }

}

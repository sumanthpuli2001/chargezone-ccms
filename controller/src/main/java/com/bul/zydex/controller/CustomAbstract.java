/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.AnchorCustomer;
import com.bul.zydex.model.AocForm;
import com.bul.zydex.model.AocFormApproval;
import com.bul.zydex.model.AocFormApprovalComment;
import com.bul.zydex.model.AocFormApprovalUser;
import com.bul.zydex.model.AocFormAttachment;
import com.bul.zydex.model.AocFormHistory;
import com.bul.zydex.model.AocFormMultiAttachment;
import com.bul.zydex.model.AocFormMultiAttachmentHistory;
import com.bul.zydex.model.AocLogMaster;
import com.bul.zydex.model.AocSurveyAttachment;
import com.bul.zydex.model.AocSurveyAttachmentHistory;
import com.bul.zydex.model.ApprenticesMaster;
import com.bul.zydex.model.ContractorMaster;
import com.bul.zydex.model.CouponMaster;
import com.bul.zydex.model.DeviceDetails;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.PunchedDataMaster;
import com.bul.zydex.model.RechargeInfoMaster;
import com.bul.zydex.model.RechargeMaster;
import com.bul.zydex.model.ReportMaster;
import com.bul.zydex.model.RightMaster;
import com.bul.zydex.model.SpecialCouponMaster;
import com.bul.zydex.model.SqlDataConnect;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.ApprovalSetting;
import com.bul.zydex.model.VendorInvitation;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.model.VendorBusinessCertificate;
import com.bul.zydex.model.VendorQualityCertificate;
import com.bul.zydex.model.VendorClearanceCertificate;
import com.bul.zydex.model.VendorApproval;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.SapDeliSch;
import com.bul.zydex.model.SapItemLongTxt;
import com.bul.zydex.model.SapPurchaseItemTxt;
import com.bul.zydex.model.SapTenderItem;
import com.bul.zydex.model.SapTenderMaster;
import com.bul.zydex.model.SapVendorEmail;
import com.bul.zydex.model.SapVendorMaster;
import com.bul.zydex.model.SapVendorTelephone;
import com.bul.zydex.model.TenderAdditionalDoc;
import com.bul.zydex.model.TenderGeneralDoc;
import com.bul.zydex.model.TenderTechnicalDoc;
import com.bul.zydex.model.TenderPreQualification;
import com.bul.zydex.model.TenderTechnical;
import com.bul.zydex.model.TenderVendorDoc;
import com.bul.zydex.model.TenderItemMaster;
import com.bul.zydex.model.TenderItemAttachment;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.model.VendorPreBidAttachment;
import com.bul.zydex.model.VendorPreBid;
import com.bul.zydex.model.VendorAttachment;
import com.bul.zydex.model.VendorEmd;
import com.bul.zydex.model.VendorFee;
import com.bul.zydex.model.VendorTechnicalBid;
import com.bul.zydex.model.VendorTechnicalBidAttachment;
import com.bul.zydex.model.VendorTechnicalBidTech;
import com.bul.zydex.model.VendorTechnicalBidTechAttachment;
import com.bul.zydex.model.VendorTechnicalBidTerms;
import com.bul.zydex.model.VendorTechnicalBidTermsAttachment;
import com.bul.zydex.model.VendorTenderBid;
import com.bul.zydex.model.VendorTenderBidItem;
import com.bul.zydex.model.AuthTenderMaster;
import com.bul.zydex.model.AuthTenderAdditionalDoc;
import com.bul.zydex.model.AuthTenderGeneralDoc;
import com.bul.zydex.model.AuthTenderTechnicalDoc;
import com.bul.zydex.model.AuthTenderPreQualification;
import com.bul.zydex.model.AuthTenderTechnical;
import com.bul.zydex.model.AuthTenderVendorDoc;
import com.bul.zydex.model.AuthTenderItemMaster;
import com.bul.zydex.model.AuthTenderItemAttachment;
import com.bul.zydex.model.AuthTenderVendor;
import com.bul.zydex.model.TenderRegret;
import com.bul.zydex.model.TenderNoTemp;
import com.bul.zydex.model.TenderNo;
import com.bul.zydex.model.FileDetail;
import com.bul.zydex.model.ServiceDetail1;
import com.bul.zydex.model.ServiceDetail2;
import com.bul.zydex.model.ServiceDetail3;
import com.bul.zydex.model.ServiceDetail4;
import com.bul.zydex.model.ServiceDetail5;
import com.bul.zydex.model.ServiceDetail6;
import com.bul.zydex.model.ServiceVendorTenderBid;
import com.bul.zydex.model.ServiceVendorTenderBidItem;
import com.bul.zydex.model.ServiceVendorTenderBidItem2;
import com.bul.zydex.model.ServiceVendorTenderBidItem3;
import com.bul.zydex.model.ServiceVendorTenderBidItem4;
import com.bul.zydex.model.ServiceVendorTenderBidItem6;
import com.bul.zydex.model.TenderSendEmail;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.LiveTender;
import com.bul.zydex.model.VendorInfo;
import com.bul.zydex.model.TenderFollowup;
import com.bul.zydex.model.CommMaster;
import com.bul.zydex.model.CommMasterAttachment;
import com.bul.zydex.model.ServiceRights;
import com.bul.zydex.model.AuctionMaster;
import com.bul.zydex.model.AuctionItemMaster;
import com.bul.zydex.model.AuctionVendor;
import com.bul.zydex.model.AuctionAttachment;
import com.bul.zydex.model.AuctionNoTemp;
import com.bul.zydex.model.AuctionNo;
import com.bul.zydex.model.AuctionVendorBid;
import com.bul.zydex.model.AuctionVendorBidHistory;
import com.bul.zydex.model.SapConnection;
import com.bul.zydex.model.SmtpDetails;
import com.bul.zydex.model.CommitteeApprovalSetting;
import com.bul.zydex.model.CommitteeApprovalUser;
import com.bul.zydex.model.AuctionItemVendor;
import com.bul.zydex.model.AuctionItemVendorBid;
import com.bul.zydex.model.AuctionItemVendorBidHistory;
import com.bul.zydex.model.VendorCustomerRefrence;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.ReviseVendorTenderBid;
import com.bul.zydex.model.ReviseVendorTenderBidItem;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PlantMaster;
import com.bul.zydex.model.TenderApprovalSetting;
import com.bul.zydex.model.TenderApprovalUser;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.model.TenderPriceApprovalUser;
import com.bul.zydex.model.CompanyLocation;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.AuctionPriceApproval;
import com.bul.zydex.model.AuctionPriceApprovalComment;
import com.bul.zydex.model.AuctionPriceApprovalUser;
import com.bul.zydex.model.AuditorMaster;
import com.bul.zydex.model.BpGroup;
import com.bul.zydex.model.CanopyVarient;
import com.bul.zydex.model.ChargerInstallationDetails;
import com.bul.zydex.model.ChargerInstallationDetailsHistory;
import com.bul.zydex.model.ChargerMaster;
import com.bul.zydex.model.ChargerType;
import com.bul.zydex.model.ClosePr;
import com.bul.zydex.model.ClosePrMultiAttach;
import com.bul.zydex.model.CompanyMaster;
import com.bul.zydex.model.ConnectionType;
import com.bul.zydex.model.ConnectorType;
import com.bul.zydex.model.CountryCode;
import com.bul.zydex.model.CrcForm;
import com.bul.zydex.model.CrcFormApproval;
import com.bul.zydex.model.CrcFormApprovalComment;
import com.bul.zydex.model.CrcFormApprovalUser;
import com.bul.zydex.model.CrcFormHistory;
import com.bul.zydex.model.CurrencyMaster;
import com.bul.zydex.model.DeclarationLetter;
import com.bul.zydex.model.Deliverable;
import com.bul.zydex.model.DeliverableMulti;
import com.bul.zydex.model.DesignCoordinatorMultiAttach;
import com.bul.zydex.model.DesignCordinatorComments;
import com.bul.zydex.model.DiscomMaster;
import com.bul.zydex.model.DocumentForNewElectricityConnection;
import com.bul.zydex.model.DocumentMasterId;
import com.bul.zydex.model.DocumentMastersId;
import com.bul.zydex.model.DocumentName;
import com.bul.zydex.model.DocumentType;
import com.bul.zydex.model.EhMail;
import com.bul.zydex.model.ElectricalContractor;
import com.bul.zydex.model.GroupCategory;
import com.bul.zydex.model.GroupForCalculation;
import com.bul.zydex.model.GroupMaster;
import com.bul.zydex.model.GroupSubCategory;
import com.bul.zydex.model.InvestmentProfile;
import com.bul.zydex.model.InvoiceAttachment;
import com.bul.zydex.model.InvoiceMaster;
import com.bul.zydex.model.IteamDetailsAttachments;
import com.bul.zydex.model.KickOffAttendences;
import com.bul.zydex.model.KickOffAttendencesHistory;
import com.bul.zydex.model.KickOffForm;
import com.bul.zydex.model.KickOffFormApproval;
import com.bul.zydex.model.KickOffFormApprovalComment;
import com.bul.zydex.model.KickOffFormApprovalUser;
import com.bul.zydex.model.KickOffFormHistory;
import com.bul.zydex.model.LastWorkExpDeatils;
import com.bul.zydex.model.LocationMasters;
import com.bul.zydex.model.ManagerialPerson;
import com.bul.zydex.model.ReviseVendorTechnicalBid;
import com.bul.zydex.model.TechnicalTenderPriceApproval;
import com.bul.zydex.model.TechnicalTenderPriceApprovalComment;
import com.bul.zydex.model.TechnicalTenderPriceApprovalUser;
import com.bul.zydex.model.MaterialGroupMaster;
import com.bul.zydex.model.MaterialMaster;
import com.bul.zydex.model.MaterialTypeMaster;
import com.bul.zydex.model.MultipleAddress;
import com.bul.zydex.model.OapDocumentAttachment;
import com.bul.zydex.model.OapForm;
import com.bul.zydex.model.OapFormApproval;
import com.bul.zydex.model.OapFormApprovalComment;
import com.bul.zydex.model.OapFormApprovalUser;
import com.bul.zydex.model.OapFormHistory;
import com.bul.zydex.model.OapLogMaster;
import com.bul.zydex.model.OapMaster;
import com.bul.zydex.model.OapMasterUser;
import com.bul.zydex.model.OapMultiAttachment;
import com.bul.zydex.model.OapMultiAttachmentHistory;
import com.bul.zydex.model.OapSurveyAttachment;
import com.bul.zydex.model.OapSurveyAttachmentHistory;
import com.bul.zydex.model.OmsMaster;
import com.bul.zydex.model.PRItemMaster;
import com.bul.zydex.model.PRMaster;
import com.bul.zydex.model.PRNo;
import com.bul.zydex.model.PRNoTemp;
import com.bul.zydex.model.PRPriceApproval;
import com.bul.zydex.model.PRPriceApprovalComment;
import com.bul.zydex.model.PRPriceApprovalUser;
import com.bul.zydex.model.PRVendor;
import com.bul.zydex.model.PRDoc;
import com.bul.zydex.model.PRClassification;
import com.bul.zydex.model.PRBusinessType;
import com.bul.zydex.model.PRProjectType;
import com.bul.zydex.model.TermsCondition;
import com.bul.zydex.model.TermsConditionParameter;
import com.bul.zydex.model.PRApprovalComment;
import com.bul.zydex.model.PlantMasters;
import com.bul.zydex.model.PoDetails;
import com.bul.zydex.model.ProductGroupMaster;
import com.bul.zydex.model.ProductTypeMaster;
import com.bul.zydex.model.ProfitCenter;
import com.bul.zydex.model.ProjectNameMaster;
import com.bul.zydex.model.ProjectProfile;
import com.bul.zydex.model.ProjectType;
import com.bul.zydex.model.PurchasingOrganisation;
import com.bul.zydex.model.Riskcategory;
import com.bul.zydex.model.SiteSurvey;
import com.bul.zydex.model.SiteSurveyAttachment;
import com.bul.zydex.model.SiteSurveyCategoryDetails;
import com.bul.zydex.model.StationType;
import com.bul.zydex.model.SurveyDocumentNo;
import com.bul.zydex.model.TaxCategory;
import com.bul.zydex.model.TechnicalMultiAttachment;
import com.bul.zydex.model.Tenant;
import com.bul.zydex.model.ValuationClassMaster;
import com.bul.zydex.model.VendorApprovalSetting;
import com.bul.zydex.model.VendorApprovalUser;
import com.bul.zydex.model.VendorBlockList;
import com.bul.zydex.model.VendorBuyerApproval;
import com.bul.zydex.model.VendorCompanyDetails;
import com.bul.zydex.model.VendorCriteriaDetailsHistory;
import com.bul.zydex.model.VendorCriteriaMaster;
import com.bul.zydex.model.VendorCriteriaMasterDetails;
import com.bul.zydex.model.VendorCriteriaMasterHistory;
import com.bul.zydex.model.VendorDepartmentApproval;
import com.bul.zydex.model.VendorFinancialApprovalDetails;
import com.bul.zydex.model.VendorFinancialDetailsHistory;
import com.bul.zydex.model.VendorHrCriteria;
import com.bul.zydex.model.VendorHrCriteriaComment;
import com.bul.zydex.model.VendorInvitationCategory;
import com.bul.zydex.model.VendorInviteSource;
import com.bul.zydex.model.VendorItCriteriaComment;
import com.bul.zydex.model.VendorPercentage;
import com.bul.zydex.model.VendorRecycleMailScheduler;
import com.bul.zydex.model.VendorRequestApproval;
import com.bul.zydex.model.VendorRequestApprovalComment;
import com.bul.zydex.model.VendorRequestApprovalUser;
import com.bul.zydex.model.VendorRequestDetails;
import com.bul.zydex.model.VendorRequestedInvitationCategory;
import com.bul.zydex.model.VendorSafetyCriteria;
import com.bul.zydex.model.VendorSafetyCriteriaComment;
import com.bul.zydex.model.VendorSelfDeclaration;
import com.bul.zydex.model.VendorTechnicalCriteria;
import com.bul.zydex.model.VendorTermsCondition;
import com.bul.zydex.model.VendorTermsConditionPriceBid;
import com.bul.zydex.service.AnchorCustomer.AnchorCustomerService;
import com.bul.zydex.service.AocForm.AocFormService;
import com.bul.zydex.service.AocFormApproval.AocFormApprovalService;
import com.bul.zydex.service.AocFormApprovalComment.AocFormApprovalCommentService;
import com.bul.zydex.service.AocFormApprovalUser.AocFormApprovalUserService;
import com.bul.zydex.service.AocFormAttachment.AocFormAttachmentService;
import com.bul.zydex.service.AocFormHistory.AocFormHistoryService;
import com.bul.zydex.service.AocFormMultiAttachment.AocFormMultiAttachmentService;
import com.bul.zydex.service.AocFormMultiAttachmentHistory.AocFormMultiAttachmentHistoryService;
import com.bul.zydex.service.AocLogMaster.AocLogMasterService;
import com.bul.zydex.service.AocSurveyAttachment.AocSurveyAttachmentService;
import com.bul.zydex.service.AocSurveyAttachmentHistory.AocSurveyAttachmentHistoryService;
import com.bul.zydex.service.Apprentices.ApprenticesService;
import com.bul.zydex.service.Contractor.ContractorService;
import com.bul.zydex.service.Coupon.CouponService;
import com.bul.zydex.service.Device.DeviceService;
import com.bul.zydex.service.Employee.EmployeeMasterService;
import com.bul.zydex.service.Log.LogService;
import com.bul.zydex.service.PunchedData.PunchedDataService;
import com.bul.zydex.service.Recharge.RechargeService;
import com.bul.zydex.service.RechargeInfo.RechargeInfoService;
import com.bul.zydex.service.Report.ReportService;
import com.bul.zydex.service.Right.RightService;
import com.bul.zydex.service.SpecialCoupon.SpecialCouponService;
import com.bul.zydex.service.SqlDataConnect.SqlDataConnectService;
import com.bul.zydex.service.UserMasterService;
import com.bul.zydex.service.Approval.ApprovalSettingService;
import com.bul.zydex.service.Vendor.VendorInvitationService;
import com.bul.zydex.service.Vendor.VendorInformationService;
import com.bul.zydex.service.Vendor.VendorBusinessCertificateService;
import com.bul.zydex.service.Vendor.VendorQualityCertificateService;
import com.bul.zydex.service.Vendor.VendorClearanceCertificateService;
import com.bul.zydex.service.Vendor.VendorApprovalService;
import com.bul.zydex.service.Right.UserRightsService;
import com.bul.zydex.service.Vendor.VendorMasterService;
import com.bul.zydex.service.Tender.TenderMasterService;
import com.bul.zydex.service.Sap.SapDeliSchService;
import com.bul.zydex.service.Sap.SapItemLongTxtService;
import com.bul.zydex.service.Sap.SapPurchaseItemTxtService;
import com.bul.zydex.service.Sap.SapTenderItemService;
import com.bul.zydex.service.Sap.SapTenderMasterService;
import com.bul.zydex.service.Sap.SapVendorEmailService;
import com.bul.zydex.service.Sap.SapVendorMasterService;
import com.bul.zydex.service.Sap.SapVendorTelephoneService;
import com.bul.zydex.service.Tender.TenderAdditionalDocService;
import com.bul.zydex.service.Tender.TenderGeneralDocService;
import com.bul.zydex.service.Tender.TenderTechnicalDocService;
import com.bul.zydex.service.Tender.TenderPreQualificationService;
import com.bul.zydex.service.Tender.TenderTechnicalService;
import com.bul.zydex.service.Tender.TenderVendorDocService;
import com.bul.zydex.service.Tender.TenderItemMasterService;
import com.bul.zydex.service.Tender.TenderItemAttachmentService;
import com.bul.zydex.service.Tender.TenderVendorService;
import com.bul.zydex.service.Vendor.VendorPreBidAttachmentService;
import com.bul.zydex.service.Vendor.VendorPreBidService;
import com.bul.zydex.service.Vendor.VendorAttachmentService;
import com.bul.zydex.service.Vendor.VendorEmdService;
import com.bul.zydex.service.Vendor.VendorFeeService;
import com.bul.zydex.service.Vendor.VendorTechnicalBidService;
import com.bul.zydex.service.Vendor.VendorTechnicalBidAttachmentService;
import com.bul.zydex.service.Vendor.VendorTechnicalBidTechService;
import com.bul.zydex.service.Vendor.VendorTechnicalBidTermsService;
import com.bul.zydex.service.Vendor.VendorTechnicalBidTechAttachmentService;
import com.bul.zydex.service.Vendor.VendorTechnicalBidTermsAttachmentService;
import com.bul.zydex.service.Vendor.VendorTenderBidService;
import com.bul.zydex.service.Vendor.VendorTenderBidItemService;
import com.bul.zydex.service.Tender.AuthTenderMasterService;
import com.bul.zydex.service.Tender.AuthTenderAdditionalDocService;
import com.bul.zydex.service.Tender.AuthTenderGeneralDocService;
import com.bul.zydex.service.Tender.AuthTenderTechnicalDocService;
import com.bul.zydex.service.Tender.AuthTenderPreQualificationService;
import com.bul.zydex.service.Tender.AuthTenderTechnicalService;
import com.bul.zydex.service.Tender.AuthTenderVendorDocService;
import com.bul.zydex.service.Tender.AuthTenderItemMasterService;
import com.bul.zydex.service.Tender.AuthTenderItemAttachmentService;
import com.bul.zydex.service.Tender.AuthTenderVendorService;
import com.bul.zydex.service.Tender.TenderRegretService;
import com.bul.zydex.service.Tender.TenderNoTempService;
import com.bul.zydex.service.Tender.TenderNoService;
import com.bul.zydex.service.Tender.FileDetailService;
import com.bul.zydex.service.Tender.ServiceDetail1Service;
import com.bul.zydex.service.Tender.ServiceDetail2Service;
import com.bul.zydex.service.Tender.ServiceDetail3Service;
import com.bul.zydex.service.Tender.ServiceDetail4Service;
import com.bul.zydex.service.Tender.ServiceDetail5Service;
import com.bul.zydex.service.Tender.ServiceDetail6Service;
import com.bul.zydex.service.Tender.ServiceVendorTenderBidService;
import com.bul.zydex.service.Tender.ServiceVendorTenderBidItemService;
import com.bul.zydex.service.Tender.ServiceVendorTenderBidItem2Service;
import com.bul.zydex.service.Tender.ServiceVendorTenderBidItem3Service;
import com.bul.zydex.service.Tender.ServiceVendorTenderBidItem4Service;
import com.bul.zydex.service.Tender.ServiceVendorTenderBidItem6Service;
import com.bul.zydex.service.Tender.TenderSendEmailService;
import com.bul.zydex.service.Tender.EmailTemplateService;
import com.bul.zydex.service.Tender.LiveTenderService;
import com.bul.zydex.service.Vendor.VendorInfoService;
import com.bul.zydex.service.Tender.TenderFollowupService;
import com.bul.zydex.service.Vendor.CommMasterService;
import com.bul.zydex.service.Vendor.CommMasterAttachmentService;
import com.bul.zydex.service.Tender.ServiceRightsService;
import com.bul.zydex.service.Auction.AuctionMasterService;
import com.bul.zydex.service.Auction.AuctionItemMasterService;
import com.bul.zydex.service.Auction.AuctionVendorService;
import com.bul.zydex.service.Auction.AuctionAttachmentService;
import com.bul.zydex.service.Auction.AuctionNoTempService;
import com.bul.zydex.service.Auction.AuctionNoService;
import com.bul.zydex.service.Auction.AuctionVendorBidService;
import com.bul.zydex.service.Auction.AuctionVendorBidHistoryService;
import com.bul.zydex.service.Tender.CommitteeApprovalSettingService;
import com.bul.zydex.service.Tender.CommitteeApprovalUserService;
import com.bul.zydex.service.Vendor.VendorCustomerRefrenceService;
import com.bul.zydex.service.Auction.AuctionItemVendorService;
import com.bul.zydex.service.Auction.AuctionItemVendorBidService;
import com.bul.zydex.service.Auction.AuctionItemVendorBidHistoryService;
import com.bul.zydex.service.SapConnection.SapConnectionService;
import com.bul.zydex.service.SmtpDetails.SmtpDetailsService;

import com.bul.zydex.service.Tender.TenderCommitteeService;
import com.bul.zydex.service.Vendor.ReviseVendorTenderBidService;
import com.bul.zydex.service.Vendor.ReviseVendorTenderBidItemService;
import com.bul.zydex.service.Invoice.LocationMasterService;
import com.bul.zydex.service.Invoice.PlantMasterService;
import com.bul.zydex.service.Tender.TenderApprovalSettingService;
import com.bul.zydex.service.Tender.TenderApprovalUserService;
import com.bul.zydex.service.Tender.TenderPriceApprovalCommentService;
import com.bul.zydex.service.Tender.TenderPriceApprovalService;
import com.bul.zydex.service.Tender.TenderPriceApprovalUserService;
import com.bul.zydex.service.Employee.CompanyLocationService;
import com.bul.zydex.service.Employee.DepartmentMasterService;
import com.bul.zydex.service.Employee.DesignationMasterService;
import com.bul.zydex.service.Auction.AuctionPriceApprovalCommentService;
import com.bul.zydex.service.Auction.AuctionPriceApprovalService;
import com.bul.zydex.service.Auction.AuctionPriceApprovalUserService;
import com.bul.zydex.service.AuditorMaster.AuditorMasterService;
import com.bul.zydex.service.BpGroup.BpGroupService;
import com.bul.zydex.service.CanopyVarient.CanopyVarientService;
import com.bul.zydex.service.ChargerInstallationDetails.ChargerInstallationDetailsService;
import com.bul.zydex.service.ChargerInstallationDetailsHistory.ChargerInstallationDetailsHistoryService;
import com.bul.zydex.service.ChargerMaster.ChargerMasterService;
import com.bul.zydex.service.ChargerType.ChargerTypeService;
import com.bul.zydex.service.ClosePr.ClosePrService;
import com.bul.zydex.service.ClosePrMultiAttach.ClosePrMultiAttachService;
import com.bul.zydex.service.CompanyMaster.CompanyMasterService;
import com.bul.zydex.service.ConnectionType.ConnectionTypeService;
import com.bul.zydex.service.ConnectorType.ConnectorTypeService;
import com.bul.zydex.service.CountryCode.CountryCodeService;
import com.bul.zydex.service.CrcForm.CrcFormService;
import com.bul.zydex.service.CrcFormApproval.CrcFormApprovalService;
import com.bul.zydex.service.CrcFormApprovalComment.CrcFormApprovalCommentService;
import com.bul.zydex.service.CrcFormApprovalUser.CrcFormApprovalUserService;
import com.bul.zydex.service.CrcFormHistory.CrcFormHistoryService;
import com.bul.zydex.service.DeclarationLetter.DeclarationLetterService;
import com.bul.zydex.service.Deliverable.DeliverableService;
import com.bul.zydex.service.DeliverableMulti.DeliverableMultiService;
import com.bul.zydex.service.DesignCoordinatorMultiAttach.DesignCoordinatorMultiAttachService;
import com.bul.zydex.service.DesignCordinatorComments.DesignCordinatorCommentsService;
import com.bul.zydex.service.DiscomMaster.DiscomMasterService;
import com.bul.zydex.service.DocumentForNewElectricityConnection.DocumentForNewElectricityConnectionService;
import com.bul.zydex.service.DocumentMasterId.DocumentMasterIdService;
import com.bul.zydex.service.DocumentMastersId.DocumentMastersIdService;
import com.bul.zydex.service.DocumentName.DocumentNameService;
import com.bul.zydex.service.Ehmail.EhMailService;
import com.bul.zydex.service.ElectricalContractor.ElectricalContractorService;
import com.bul.zydex.service.GroupForCalculation.GroupForCalculationService;
import com.bul.zydex.service.InvestmentProfile.InvestmentProfileService;
import com.bul.zydex.service.Invoice.DocumentTypeService;
import com.bul.zydex.service.Invoice.InvoiceAttachmentService;
import com.bul.zydex.service.Invoice.InvoiceMasterService;
import com.bul.zydex.service.IteamDetailsAttachments.IteamDetailsAttachmentsService;
import com.bul.zydex.service.KickOffAttendences.KickOffAttendencesService;
import com.bul.zydex.service.KickOffAttendencesHistory.KickOffAttendencesHistoryService;
import com.bul.zydex.service.KickOffForm.KickOffFormService;
import com.bul.zydex.service.KickOffFormApproval.KickOffFormApprovalService;
import com.bul.zydex.service.KickOffFormApprovalComment.KickOffFormApprovalCommentService;
import com.bul.zydex.service.KickOffFormApprovalUser.KickOffFormApprovalUserService;
import com.bul.zydex.service.KickOffFormHistory.KickOffFormHistoryService;
import com.bul.zydex.service.LastWorkExpDeatils.LastWorkExpDeatilsService;
import com.bul.zydex.service.LocationMasters.LocationMastersService;
import com.bul.zydex.service.ManagerialPerson.ManagerialPersonService;
import com.bul.zydex.service.Tender.TechnicalTenderPriceApprovalCommentService;
import com.bul.zydex.service.Tender.TechnicalTenderPriceApprovalService;
import com.bul.zydex.service.Tender.TechnicalTenderPriceApprovalUserService;
import com.bul.zydex.service.Vendor.ReviseVendorTechnicalBidService;
import com.bul.zydex.service.MaterialGroupMaster.MaterialGroupMasterService;
import com.bul.zydex.service.MaterialMaster.MaterialMasterService;
import com.bul.zydex.service.MaterialTypeMaster.MaterialTypeMasterService;
import com.bul.zydex.service.OapDocumentAttachment.OapDocumentAttachmentService;
import com.bul.zydex.service.OapForm.OapFormService;
import com.bul.zydex.service.OapFormApproval.OapFormApprovalService;
import com.bul.zydex.service.OapFormApprovalComment.OapFormApprovalCommentService;
import com.bul.zydex.service.OapFormApprovalUser.OapFormApprovalUserService;
import com.bul.zydex.service.OapFormHistory.OapFormHistoryService;
import com.bul.zydex.service.OapLogMaster.OapLogMasterService;
import com.bul.zydex.service.OapMaster.OapMasterService;
import com.bul.zydex.service.OapMasterUser.OapMasterUserService;
import com.bul.zydex.service.OapMultiAttachment.OapMultiAttachmentService;
import com.bul.zydex.service.OapMultiAttachmentHistory.OapMultiAttachmentHistoryService;
import com.bul.zydex.service.OapSurveyAttachment.OapSurveyAttachmentService;
import com.bul.zydex.service.OapSurveyAttachmentHistory.OapSurveyAttachmentHistoryService;
import com.bul.zydex.service.OmsMaster.OmsMasterService;
import com.bul.zydex.service.PR.MultipleAddressService;
import com.bul.zydex.service.PR.PRItemMasterService;
import com.bul.zydex.service.PR.PRMasterService;
import com.bul.zydex.service.PR.PRNoService;
import com.bul.zydex.service.PR.PRNoTempService;
import com.bul.zydex.service.PR.PRPriceApprovalCommentService;
import com.bul.zydex.service.PR.PRPriceApprovalService;
import com.bul.zydex.service.PR.PRPriceApprovalUserService;
import com.bul.zydex.service.PR.PRVendorService;
import com.bul.zydex.service.PR.PRDocService;
import com.bul.zydex.service.PR.PRClassificationService;
import com.bul.zydex.service.PR.PRBusinessTypeService;
import com.bul.zydex.service.PR.PRProjectTypeService;
import com.bul.zydex.service.TermsConditon.TermsConditionParameterService;
import com.bul.zydex.service.TermsConditon.TermsConditionService;
import com.bul.zydex.service.TermsConditon.VendorTermsConditionService;
import com.bul.zydex.service.PR.PRApprovalCommentService;
import com.bul.zydex.service.PlantMasters.PlantMastersService;
import com.bul.zydex.service.PoDetails.PoDetailsService;
import com.bul.zydex.service.ProductGroupMaster.ProductGroupMasterService;
import com.bul.zydex.service.ProductTypeMaster.ProductTypeMasterService;
import com.bul.zydex.service.ProfitCenter.ProfitCenterService;
import com.bul.zydex.service.ProjectNameMaster.ProjectNameMasterService;
import com.bul.zydex.service.ProjectProfile.ProjectProfileService;
import com.bul.zydex.service.ProjectType.ProjectTypeService;
import com.bul.zydex.service.PurchasingOrganisation.PurchasingOrganisationService;
import com.bul.zydex.service.RiskCategory.RiskCategoryService;
import com.bul.zydex.service.SiteSurvey.SiteSurveyService;
import com.bul.zydex.service.SiteSurveyAttachment.SiteSurveyAttachmentService;
import com.bul.zydex.service.SiteSurveyCategoryDetails.SiteSurveyCategoryDetailsService;
import com.bul.zydex.service.StationType.StationTypeService;
//import com.bul.zydex.service.SurveyMaster.SurveyCategoryMasterService;
import com.bul.zydex.service.SurveyMaster.SurveyDocumentNoService;
//import com.bul.zydex.service.SurveyMaster.SurveyMasterService;
//import com.bul.zydex.service.SurveyMaster.SurveySubCategoryMasterService;
import com.bul.zydex.service.TaxCategory.TaxCategoryService;
import com.bul.zydex.service.Tenant.TenantService;
import com.bul.zydex.service.Tender.CurrencyMasterService;
import com.bul.zydex.service.Tender.TechnicalMultiAttachmentService;
import com.bul.zydex.service.TermsConditon.VendorTermsConditionPriceBidService;
import com.bul.zydex.service.ValuationClassMaster.ValuationClassMasterService;
import com.bul.zydex.service.Vendor.GroupCategoryService;
import com.bul.zydex.service.Vendor.GroupMasterService;
import com.bul.zydex.service.Vendor.GroupSubCategoryService;
import com.bul.zydex.service.Vendor.VendorApprovalSettingService;
import com.bul.zydex.service.Vendor.VendorApprovalUserService;
import com.bul.zydex.service.Vendor.VendorCompanyDetailsService;
import com.bul.zydex.service.Vendor.VendorHrCriteriaCommentService;
import com.bul.zydex.service.Vendor.VendorHrCriteriaService;
import com.bul.zydex.service.Vendor.VendorInvitationCategoryService;
import com.bul.zydex.service.Vendor.VendorItCriteriaCommentService;
import com.bul.zydex.service.Vendor.VendorRequestApprovalCommentService;
import com.bul.zydex.service.Vendor.VendorRequestApprovalService;
import com.bul.zydex.service.Vendor.VendorRequestApprovalUserService;
import com.bul.zydex.service.Vendor.VendorRequestDetailsService;
import com.bul.zydex.service.Vendor.VendorRequestedInvitationCategoryService;
import com.bul.zydex.service.Vendor.VendorSafetyCriteriaCommentService;
import com.bul.zydex.service.Vendor.VendorSafetyCriteriaService;
import com.bul.zydex.service.Vendor.VendorTechnicalCriteriaService;
import com.bul.zydex.service.VendorBlockList.VendorBlockListService;
import com.bul.zydex.service.VendorBuyerApproval.VendorBuyerApprovalService;
import com.bul.zydex.service.VendorCriteriaMaster.VendorCriteriaDetailsHistoryService;
import com.bul.zydex.service.VendorCriteriaMaster.VendorCriteriaMasterDetailsService;
import com.bul.zydex.service.VendorCriteriaMaster.VendorCriteriaMasterHistoryService;
import com.bul.zydex.service.VendorCriteriaMaster.VendorCriteriaMasterService;
import com.bul.zydex.service.VendorDepartmentApproval.VendorDepartmentApprovalService;
import com.bul.zydex.service.VendorFinancialApprovalDetails.VendorFinancialApprovalDetailsService;
import com.bul.zydex.service.VendorFinancialDetailsHistory.VendorFinancialDetailsHistoryService;
import com.bul.zydex.service.VendorInviteSource.VendorInviteSourceService;
import com.bul.zydex.service.VendorPercentage.VendorPercentageService;
import com.bul.zydex.service.VendorRecycleMailScheduler.VendorRecycleMailSchedulerService;
import com.bul.zydex.service.VendorSelfDeclaration.VendorSelfDeclarationService;
import com.bul.zydex.util.SendMail;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Header;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Administrator
 */
public abstract class CustomAbstract extends MultiActionController {

    protected UserMasterService<UserMaster> userMasterService;
    protected EmployeeMasterService<EmployeeMaster> employeeMasterService;
    protected ContractorService<ContractorMaster> contractorService;
    protected ApprenticesService<ApprenticesMaster> apprenticesService;
    protected DeviceService<DeviceDetails> deviceService;
    protected CouponService<CouponMaster> couponService;
    protected RechargeService<RechargeMaster> rechargeService;
    protected SpecialCouponService<SpecialCouponMaster> specialCouponService;
    protected PunchedDataService<PunchedDataMaster> punchedDataService;
    protected RightService<RightMaster> rightService;
    protected RechargeInfoService<RechargeInfoMaster> rechargeInfoService;
    protected LogService<LogsMaster> logService;
    protected ReportService<ReportMaster> reportService;
    protected SqlDataConnectService<SqlDataConnect> sqlDataConnectService;
    protected ApprovalSettingService<ApprovalSetting> approvalSettingService;
    protected VendorInvitationService<VendorInvitation> vendorInvitationService;
    protected VendorInformationService<VendorInformation> vendorInformationService;
    protected VendorBusinessCertificateService<VendorBusinessCertificate> vendorBusinessCertificateService;
    protected VendorQualityCertificateService<VendorQualityCertificate> vendorQualityCertificateService;
    protected VendorClearanceCertificateService<VendorClearanceCertificate> vendorClearanceCertificateService;
    protected VendorApprovalService<VendorApproval> vendorApprovalService;
    protected VendorMasterService<VendorMaster> vendorMasterService;
    protected UserRightsService<UserRights> userRightsService;
    protected TenderMasterService<TenderMaster> tenderMasterService;
    protected SapDeliSchService<SapDeliSch> sapDeliSchService;
    protected SapItemLongTxtService<SapItemLongTxt> sapItemLongTxtService;
    protected SapPurchaseItemTxtService<SapPurchaseItemTxt> sapPurchaseItemTxtService;
    protected SapTenderItemService<SapTenderItem> sapTenderItemService;
    protected SapTenderMasterService<SapTenderMaster> sapTenderMasterService;
    protected SapVendorEmailService<SapVendorEmail> sapVendorEmailService;
    protected SapVendorTelephoneService<SapVendorTelephone> sapVendorTelephoneService;
    protected SapVendorMasterService<SapVendorMaster> sapVendorMasterService;
    protected TenderGeneralDocService<TenderGeneralDoc> tenderGeneralDocService;
    protected TenderAdditionalDocService<TenderAdditionalDoc> tenderAdditionalDocService;
    protected TenderTechnicalDocService<TenderTechnicalDoc> tenderTechnicalDocService;
    protected TenderPreQualificationService<TenderPreQualification> tenderPreQualificationService;
    protected TenderTechnicalService<TenderTechnical> tenderTechnicalService;
    protected TenderVendorDocService<TenderVendorDoc> tenderVendorDocService;
    protected TenderItemMasterService<TenderItemMaster> tenderItemMasterService;
    protected TenderItemAttachmentService<TenderItemAttachment> tenderItemAttachmentService;
    protected TenderVendorService<TenderVendor> tenderVendorService;
    protected VendorPreBidAttachmentService<VendorPreBidAttachment> vendorPreBidAttachmentService;
    protected VendorPreBidService<VendorPreBid> vendorPreBidService;
    protected VendorAttachmentService<VendorAttachment> vendorAttachmentService;
    protected VendorEmdService<VendorEmd> vendorEmdService;
    protected VendorFeeService<VendorFee> vendorFeeService;
    protected VendorTechnicalBidService<VendorTechnicalBid> vendorTechnicalBidService;
    protected VendorTechnicalBidAttachmentService<VendorTechnicalBidAttachment> vendorTechnicalBidAttachmentService;
    protected VendorTechnicalBidTechService<VendorTechnicalBidTech> vendorTechnicalBidTechService;
    protected VendorTechnicalBidTermsService<VendorTechnicalBidTerms> vendorTechnicalBidTermsService;
    protected VendorTechnicalBidTechAttachmentService<VendorTechnicalBidTechAttachment> vendorTechnicalBidTechAttachmentService;
    protected VendorTechnicalBidTermsAttachmentService<VendorTechnicalBidTermsAttachment> vendorTechnicalBidTermsAttachmentService;
    protected VendorTenderBidService<VendorTenderBid> vendorTenderBidService;
    protected VendorTenderBidItemService<VendorTenderBidItem> vendorTenderBidItemService;
    protected AuthTenderMasterService<AuthTenderMaster> authTenderMasterService;
    protected AuthTenderGeneralDocService<AuthTenderGeneralDoc> authTenderGeneralDocService;
    protected AuthTenderAdditionalDocService<AuthTenderAdditionalDoc> authTenderAdditionalDocService;
    protected AuthTenderTechnicalDocService<AuthTenderTechnicalDoc> authTenderTechnicalDocService;
    protected AuthTenderPreQualificationService<AuthTenderPreQualification> authTenderPreQualificationService;
    protected AuthTenderTechnicalService<AuthTenderTechnical> authTenderTechnicalService;
    protected AuthTenderVendorDocService<AuthTenderVendorDoc> authTenderVendorDocService;
    protected AuthTenderItemMasterService<AuthTenderItemMaster> authTenderItemMasterService;
    protected AuthTenderItemAttachmentService<AuthTenderItemAttachment> authTenderItemAttachmentService;
    protected AuthTenderVendorService<AuthTenderVendor> authTenderVendorService;
    protected TenderRegretService<TenderRegret> tenderRegretService;
    protected TenderNoTempService<TenderNoTemp> tenderNoTempService;
    protected TenderNoService<TenderNo> tenderNoService;
    protected FileDetailService<FileDetail> fileDetailService;
    protected ServiceDetail1Service<ServiceDetail1> serviceDetail1Service;
    protected ServiceDetail2Service<ServiceDetail2> serviceDetail2Service;
    protected ServiceDetail3Service<ServiceDetail3> serviceDetail3Service;
    protected ServiceDetail4Service<ServiceDetail4> serviceDetail4Service;
    protected ServiceDetail5Service<ServiceDetail5> serviceDetail5Service;
    protected ServiceDetail6Service<ServiceDetail6> serviceDetail6Service;
    protected ServiceVendorTenderBidService<ServiceVendorTenderBid> serviceVendorTenderBidService;
    protected ServiceVendorTenderBidItemService<ServiceVendorTenderBidItem> serviceVendorTenderBidItemService;
    protected ServiceVendorTenderBidItem2Service<ServiceVendorTenderBidItem2> serviceVendorTenderBidItem2Service;
    protected ServiceVendorTenderBidItem3Service<ServiceVendorTenderBidItem3> serviceVendorTenderBidItem3Service;
    protected ServiceVendorTenderBidItem4Service<ServiceVendorTenderBidItem4> serviceVendorTenderBidItem4Service;
    protected ServiceVendorTenderBidItem6Service<ServiceVendorTenderBidItem6> serviceVendorTenderBidItem6Service;
    protected TenderSendEmailService<TenderSendEmail> tenderSendEmailService;
    protected EmailTemplateService<EmailTemplate> emailTemplateService;
    protected LiveTenderService<LiveTender> liveTenderService;
    protected VendorInfoService<VendorInfo> vendorInfoService;
    protected TenderFollowupService<TenderFollowup> tenderFollowupService;
    protected CommMasterService<CommMaster> commMasterService;
    protected CommMasterAttachmentService<CommMasterAttachment> commMasterAttachmentService;
    protected ServiceRightsService<ServiceRights> serviceRightsService;
    protected AuctionMasterService<AuctionMaster> auctionMasterService;
    protected AuctionItemMasterService<AuctionItemMaster> auctionItemMasterService;
    protected AuctionVendorService<AuctionVendor> auctionVendorService;
    protected AuctionAttachmentService<AuctionAttachment> auctionAttachmentService;
    protected AuctionNoTempService<AuctionNoTemp> auctionNoTempService;
    protected AuctionNoService<AuctionNo> auctionNoService;
    protected AuctionVendorBidService<AuctionVendorBid> auctionVendorBidService;
    protected AuctionVendorBidHistoryService<AuctionVendorBidHistory> auctionVendorBidHistoryService;

    protected AuctionItemVendorService<AuctionItemVendor> auctionItemVendorService;
    protected AuctionItemVendorBidService<AuctionItemVendorBid> auctionItemVendorBidService;
    protected AuctionItemVendorBidHistoryService<AuctionItemVendorBidHistory> auctionItemVendorBidHistoryService;

    protected TenderCommitteeService<TenderCommittee> tenderCommitteeService;
    protected ReviseVendorTenderBidService<ReviseVendorTenderBid> reviseVendorTenderBidService;
    protected ReviseVendorTenderBidItemService<ReviseVendorTenderBidItem> reviseVendorTenderBidItemService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected PlantMasterService<PlantMaster> plantMasterService;
    protected SapConnectionService<SapConnection> sapConnectionService;
    protected SmtpDetailsService<SmtpDetails> smtpDetailsService;

    protected TenderPriceApprovalService<TenderPriceApproval> tenderPriceApprovalService;
    protected TenderPriceApprovalUserService<TenderPriceApprovalUser> tenderPriceApprovalUserService;
    protected TenderPriceApprovalCommentService<TenderPriceApprovalComment> tenderPriceApprovalCommentService;
    protected TenderApprovalSettingService<TenderApprovalSetting> tenderApprovalSettingService;
    protected TenderApprovalUserService<TenderApprovalUser> tenderApprovalUserService;
    protected CommitteeApprovalSettingService<CommitteeApprovalSetting> committeeApprovalSettingService;
    protected CommitteeApprovalUserService<CommitteeApprovalUser> committeeApprovalUserService;

    protected CompanyLocationService<CompanyLocation> companyLocationService;
    protected DepartmentMasterService<DepartmentMaster> departmentMasterService;
    protected DesignationMasterService<DesignationMaster> designationMasterService;

    protected AuctionPriceApprovalService<AuctionPriceApproval> auctionPriceApprovalService;
    protected AuctionPriceApprovalUserService<AuctionPriceApprovalUser> auctionPriceApprovalUserService;
    protected AuctionPriceApprovalCommentService<AuctionPriceApprovalComment> auctionPriceApprovalCommentService;
    protected ReviseVendorTechnicalBidService<ReviseVendorTechnicalBid> reviseVendorTechnicalBidService;
    protected VendorCustomerRefrenceService<VendorCustomerRefrence> vendorCustomerRefrenceService;

    protected TechnicalTenderPriceApprovalService<TechnicalTenderPriceApproval> technicalTenderPriceApprovalService;
    protected TechnicalTenderPriceApprovalUserService<TechnicalTenderPriceApprovalUser> technicalTenderPriceApprovalUserService;
    protected TechnicalTenderPriceApprovalCommentService<TechnicalTenderPriceApprovalComment> technicalTenderPriceApprovalCommentService;

    protected MaterialGroupMasterService<MaterialGroupMaster> materialGroupMasterService;
    protected MaterialTypeMasterService<MaterialTypeMaster> materialTypeMasterService;
    protected MaterialMasterService<MaterialMaster> materialMasterService;
    protected PRNoService<PRNo> prNoService;
    protected PRNoTempService<PRNoTemp> prNoTempService;
    protected PRVendorService<PRVendor> prVendorService;
    protected PRItemMasterService<PRItemMaster> prItemMasterService;
    protected PRPriceApprovalService<PRPriceApproval> prPriceApprovalService;
    protected PRPriceApprovalCommentService<PRPriceApprovalComment> prPriceApprovalCommentService;
    protected PRPriceApprovalUserService<PRPriceApprovalUser> prPriceApprovalUserService;
    protected PRMasterService<PRMaster> prMasterService;
    protected PRDocService<PRDoc> prDocService;
    protected PRClassificationService<PRClassification> prClassificationService;
    protected PRBusinessTypeService<PRBusinessType> prBusinessTypeService;
    protected PRProjectTypeService<PRProjectType> prProjectTypeService;
    protected TermsConditionService<TermsCondition> termsConditionService;
    protected TermsConditionParameterService<TermsConditionParameter> termsConditionParameterService;
    protected VendorTermsConditionService<VendorTermsCondition> vendorTermsConditionService;
    protected VendorTermsConditionPriceBidService<VendorTermsConditionPriceBid> vendorTermsConditionPriceBidService;
    protected MultipleAddressService<MultipleAddress> multipleAddressService;
    protected PRApprovalCommentService<PRApprovalComment> prApprovalCommentService;
    protected ElectricalContractorService<ElectricalContractor> electricalContractorService;
    protected GroupMasterService<GroupMaster> groupMasterService;
    protected GroupCategoryService<GroupCategory> groupCategoryService;
    protected GroupSubCategoryService<GroupSubCategory> groupSubCategoryService;
    protected VendorTechnicalCriteriaService<VendorTechnicalCriteria> vendorTechnicalCriteriaService;
    protected VendorHrCriteriaService<VendorHrCriteria> vendorHrCriteriaService;
    protected VendorSafetyCriteriaService<VendorSafetyCriteria> vendorSafetyCriteriaService;
    protected ProductTypeMasterService<ProductTypeMaster> productTypeMasterService;
    protected ValuationClassMasterService<ValuationClassMaster> valuationClassMasterService;
    protected ProductGroupMasterService<ProductGroupMaster> productGroupMasterService;
    protected CompanyMasterService<CompanyMaster> companyMasterService;
    protected PurchasingOrganisationService<PurchasingOrganisation> purchasingOrganisationService;
    protected PlantMastersService<PlantMasters> plantMastersService;
    protected LocationMastersService<LocationMasters> locationMastersService;
    protected VendorInvitationCategoryService<VendorInvitationCategory> vendorInvitationCategoryService;
    protected VendorSafetyCriteriaCommentService<VendorSafetyCriteriaComment> vendorSafetyCriteriaCommentService;
    protected VendorHrCriteriaCommentService<VendorHrCriteriaComment> vendorHrCriteriaCommentService;
    protected BpGroupService<BpGroup> bpGroupService;
    protected VendorPercentageService<VendorPercentage> vendorPercentageService;
    protected VendorDepartmentApprovalService<VendorDepartmentApproval> vendorDepartmentApprovalService;
    protected VendorApprovalSettingService<VendorApprovalSetting> vendorApprovalSettingService;
    protected VendorApprovalUserService<VendorApprovalUser> vendorApprovalUserService;
    protected VendorRequestDetailsService<VendorRequestDetails> vendorRequestDetailsService;
    protected VendorRequestApprovalService<VendorRequestApproval> vendorRequestApprovalService;
    protected VendorRequestApprovalUserService<VendorRequestApprovalUser> vendorRequestApprovalUserService;
    protected VendorRequestApprovalCommentService<VendorRequestApprovalComment> vendorRequestApprovalCommentService;
    protected TaxCategoryService<TaxCategory> taxCategoryService;
    protected GroupForCalculationService<GroupForCalculation> groupForCalculationService;
    protected VendorRequestedInvitationCategoryService<VendorRequestedInvitationCategory> vendorRequestedInvitationCategoryService;
    protected ProfitCenterService<ProfitCenter> profitCenterService;
    protected ProjectTypeService<ProjectType> projectTypeService;
    protected CurrencyMasterService<CurrencyMaster> currencyMasterService;
    protected StationTypeService<StationType> stationTypeService;
    protected TenantService<Tenant> tenantService;
    protected InvestmentProfileService<InvestmentProfile> investmentProfileService;
    protected ProjectProfileService<ProjectProfile> projectProfileService;
    protected DiscomMasterService<DiscomMaster> discomMasterService;
    protected ConnectionTypeService<ConnectionType> connectionTypeService;
    protected OapMasterService<OapMaster> oapMasterService;
    protected OapMasterUserService<OapMasterUser> oapMasterUserService;
    protected DocumentNameService<DocumentName> documentNameService;
    protected ProjectNameMasterService<ProjectNameMaster> projectNameMasterService;

    protected OapFormService<OapForm> oapFormService;
    protected OapDocumentAttachmentService<OapDocumentAttachment> oapDocumentAttachmentService;
    protected OapMultiAttachmentService<OapMultiAttachment> oapMultiAttachmentService;
    protected OapFormApprovalService<OapFormApproval> oapFormApprovalService;
    protected OapFormApprovalCommentService<OapFormApprovalComment> oapFormApprovalCommentService;
    protected OapFormApprovalUserService<OapFormApprovalUser> oapFormApprovalUserService;
    protected AocFormService<AocForm> aocFormService;
    protected AocFormAttachmentService<AocFormAttachment> AocFormAttachmentService;
    protected AocFormMultiAttachmentService<AocFormMultiAttachment> aocFormMultiAttachmentService;
    protected AocFormApprovalService<AocFormApproval> aocFormApprovalService;
    protected AocFormApprovalUserService<AocFormApprovalUser> aocFormApprovalUserService;
    protected AocFormApprovalCommentService<AocFormApprovalComment> aocFormApprovalCommentService;
    protected CrcFormService<CrcForm> crcFormService;
    protected CrcFormApprovalService<CrcFormApproval> crcFormApprovalService;
    protected CrcFormApprovalUserService<CrcFormApprovalUser> crcFormApprovalUserService;
    protected CrcFormApprovalCommentService<CrcFormApprovalComment> crcFormApprovalCommentService;
    protected KickOffAttendencesService<KickOffAttendences> kickOffAttendencesService;
    protected KickOffFormApprovalService<KickOffFormApproval> kickOffFormApprovalService;
    protected KickOffFormApprovalUserService<KickOffFormApprovalUser> kickOffFormApprovalUserService;
    protected KickOffFormApprovalCommentService<KickOffFormApprovalComment> kickOffFormApprovalCommentService;
    protected KickOffFormService<KickOffForm> kickOffFormService;
    protected DocumentMasterIdService<DocumentMasterId> documentMasterIdService;
    protected DocumentMastersIdService<DocumentMastersId> documentMastersIdService;
    protected DeliverableService<Deliverable> deliverableService;
    protected DeliverableMultiService<DeliverableMulti> deliverableMultiService;
    protected IteamDetailsAttachmentsService<IteamDetailsAttachments> iteamDetailsAttachmentsService;
    protected DesignCoordinatorMultiAttachService<DesignCoordinatorMultiAttach> designCoordinatorMultiAttachService;
    protected DesignCordinatorCommentsService<DesignCordinatorComments> designCordinatorCommentsService;

    protected AocFormHistoryService<AocFormHistory> aocFormHistoryService;
    protected CrcFormHistoryService<CrcFormHistory> crcFormHistoryService;
    protected KickOffFormHistoryService<KickOffFormHistory> kickOffFormHistoryService;
    protected OapFormHistoryService<OapFormHistory> oapFormHistoryService;
    protected AocFormMultiAttachmentHistoryService<AocFormMultiAttachmentHistory> aocFormMultiAttachmentHistoryService;
    protected OapMultiAttachmentHistoryService<OapMultiAttachmentHistory> oapMultiAttachmentHistoryService;
    protected KickOffAttendencesHistoryService<KickOffAttendencesHistory> kickOffAttendencesHistoryService;
    protected SiteSurveyCategoryDetailsService<SiteSurveyCategoryDetails> siteSurveyCategoryDetailsService;
//    protected SurveyMasterService<SurveyMaster> surveyMasterService;
//    protected SurveyCategoryMasterService<SurveyCategoryMaster> surveyCategoryMasterService;
//    protected SurveySubCategoryMasterService<SurveySubCategoryMaster> surveySubCategoryMasterService;
    protected SurveyDocumentNoService<SurveyDocumentNo> surveyDocumentNoService;
    protected DocumentForNewElectricityConnectionService<DocumentForNewElectricityConnection> documentForNewElectricityConnectionService;
    protected SiteSurveyService<SiteSurvey> siteSurveyService;
    protected OapLogMasterService<OapLogMaster> oapLogMasterService;
    protected AocLogMasterService<AocLogMaster> aocLogMasterService;
    protected SiteSurveyAttachmentService<SiteSurveyAttachment> siteSurveyAttachmentService;
    protected OapSurveyAttachmentService<OapSurveyAttachment> oapSurveyAttachmentService;
    protected OapSurveyAttachmentHistoryService<OapSurveyAttachmentHistory> oapSurveyAttachmentHistoryService;
    protected AocSurveyAttachmentService<AocSurveyAttachment> aocSurveyAttachmentService;
    protected AocSurveyAttachmentHistoryService<AocSurveyAttachmentHistory> aocSurveyAttachmentHistoryService;
    protected PoDetailsService<PoDetails> poDetailsService;
    protected RiskCategoryService<Riskcategory> RiskCategoryService;
    protected VendorInviteSourceService<VendorInviteSource> VendorInviteSourceService;
    protected AuditorMasterService<AuditorMaster> auditorMasterService;
    protected DeclarationLetterService<DeclarationLetter> declarationLetterService;
    protected ClosePrService<ClosePr> closePrService;
    protected VendorSelfDeclarationService<VendorSelfDeclaration> vendorSelfDeclarationService;

    protected TechnicalMultiAttachmentService<TechnicalMultiAttachment> technicalMultiAttachmentService;

    protected VendorCriteriaMasterService<VendorCriteriaMaster> vendorCriteriaMasterService;
    protected VendorCriteriaMasterDetailsService<VendorCriteriaMasterDetails> vendorCriteriaMasterDetailsService;
    protected VendorCriteriaMasterHistoryService<VendorCriteriaMasterHistory> vendorCriteriaMasterHistoryService;
    protected VendorCriteriaDetailsHistoryService<VendorCriteriaDetailsHistory> vendorCriteriaDetailsHistoryService;

    protected CountryCodeService<CountryCode> countryCodeService;

    protected ManagerialPersonService<ManagerialPerson> managerialPersonService;
    protected VendorItCriteriaCommentService<VendorItCriteriaComment> vendorItCriteriaCommentService;
    protected LastWorkExpDeatilsService<LastWorkExpDeatils> lastWorkExpDeatilsService;

    protected VendorBuyerApprovalService<VendorBuyerApproval> vendorBuyerApprovalService;

    protected VendorRecycleMailSchedulerService<VendorRecycleMailScheduler> vendorRecycleMailSchedulerService;

    protected ClosePrMultiAttachService<ClosePrMultiAttach> closePrMultiAttachService;

    protected AnchorCustomerService<AnchorCustomer> anchorCustomerService;

    protected CanopyVarientService<CanopyVarient> canopyVarientService;

    protected ChargerInstallationDetailsService<ChargerInstallationDetails> chargerInstallationDetailsService;

    protected ChargerTypeService<ChargerType> chargerTypeService;

    protected ChargerMasterService<ChargerMaster> chargerMasterService;

    protected ConnectorTypeService<ConnectorType> connectorTypeService;

    protected ChargerInstallationDetailsHistoryService<ChargerInstallationDetailsHistory> chargerInstallationDetailsHistoryService;

    protected EhMailService<EhMail> ehMailService;

    protected VendorBlockListService<VendorBlockList> vendorBlockListService;

    protected VendorFinancialApprovalDetailsService<VendorFinancialApprovalDetails> vendorFinancialApprovalDetailsService;

    protected VendorFinancialDetailsHistoryService<VendorFinancialDetailsHistory> vendorFinancialDetailsHistoryService;

    protected OmsMasterService<OmsMaster> omsMasterService;

    protected InvoiceMasterService<InvoiceMaster> invoiceMasterService;
    protected InvoiceAttachmentService<InvoiceAttachment> invoiceAttachmentService;
    protected DocumentTypeService<DocumentType> documentTypeService;

    public DocumentTypeService<DocumentType> getDocumentTypeService() {
        return documentTypeService;
    }

    public void setDocumentTypeService(DocumentTypeService<DocumentType> documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    public InvoiceAttachmentService<InvoiceAttachment> getInvoiceAttachmentService() {
        return invoiceAttachmentService;
    }

    public void setInvoiceAttachmentService(InvoiceAttachmentService<InvoiceAttachment> invoiceAttachmentService) {
        this.invoiceAttachmentService = invoiceAttachmentService;
    }

    public InvoiceMasterService<InvoiceMaster> getInvoiceMasterService() {
        return invoiceMasterService;
    }

    public void setInvoiceMasterService(InvoiceMasterService<InvoiceMaster> invoiceMasterService) {
        this.invoiceMasterService = invoiceMasterService;
    }

    public OmsMasterService<OmsMaster> getOmsMasterService() {
        return omsMasterService;
    }

    public void setOmsMasterService(OmsMasterService<OmsMaster> omsMasterService) {
        this.omsMasterService = omsMasterService;
    }

    public VendorFinancialDetailsHistoryService<VendorFinancialDetailsHistory> getVendorFinancialDetailsHistoryService() {
        return vendorFinancialDetailsHistoryService;
    }

    public void setVendorFinancialDetailsHistoryService(VendorFinancialDetailsHistoryService<VendorFinancialDetailsHistory> vendorFinancialDetailsHistoryService) {
        this.vendorFinancialDetailsHistoryService = vendorFinancialDetailsHistoryService;
    }

    public VendorFinancialApprovalDetailsService<VendorFinancialApprovalDetails> getVendorFinancialApprovalDetailsService() {
        return vendorFinancialApprovalDetailsService;
    }

    public void setVendorFinancialApprovalDetailsService(VendorFinancialApprovalDetailsService<VendorFinancialApprovalDetails> vendorFinancialApprovalDetailsService) {
        this.vendorFinancialApprovalDetailsService = vendorFinancialApprovalDetailsService;
    }

    public VendorBlockListService<VendorBlockList> getVendorBlockListService() {
        return vendorBlockListService;
    }

    public void setVendorBlockListService(VendorBlockListService<VendorBlockList> vendorBlockListService) {
        this.vendorBlockListService = vendorBlockListService;
    }

    public EhMailService<EhMail> getEhMailService() {
        return ehMailService;
    }

    public void setEhMailService(EhMailService<EhMail> ehMailService) {
        this.ehMailService = ehMailService;
    }

    public ChargerInstallationDetailsService<ChargerInstallationDetails> getChargerInstallationDetailsService() {
        return chargerInstallationDetailsService;
    }

    public void setChargerInstallationDetailsService(ChargerInstallationDetailsService<ChargerInstallationDetails> chargerInstallationDetailsService) {
        this.chargerInstallationDetailsService = chargerInstallationDetailsService;
    }

    public ChargerTypeService<ChargerType> getChargerTypeService() {
        return chargerTypeService;
    }

    public void setChargerTypeService(ChargerTypeService<ChargerType> chargerTypeService) {
        this.chargerTypeService = chargerTypeService;
    }

    public ChargerMasterService<ChargerMaster> getChargerMasterService() {
        return chargerMasterService;
    }

    public void setChargerMasterService(ChargerMasterService<ChargerMaster> chargerMasterService) {
        this.chargerMasterService = chargerMasterService;
    }

    public ConnectorTypeService<ConnectorType> getConnectorTypeService() {
        return connectorTypeService;
    }

    public void setConnectorTypeService(ConnectorTypeService<ConnectorType> connectorTypeService) {
        this.connectorTypeService = connectorTypeService;
    }

    public ChargerInstallationDetailsHistoryService<ChargerInstallationDetailsHistory> getChargerInstallationDetailsHistoryService() {
        return chargerInstallationDetailsHistoryService;
    }

    public void setChargerInstallationDetailsHistoryService(ChargerInstallationDetailsHistoryService<ChargerInstallationDetailsHistory> chargerInstallationDetailsHistoryService) {
        this.chargerInstallationDetailsHistoryService = chargerInstallationDetailsHistoryService;
    }

    public CanopyVarientService<CanopyVarient> getCanopyVarientService() {
        return canopyVarientService;
    }

    public void setCanopyVarientService(CanopyVarientService<CanopyVarient> canopyVarientService) {
        this.canopyVarientService = canopyVarientService;
    }

    public AnchorCustomerService<AnchorCustomer> getAnchorCustomerService() {
        return anchorCustomerService;
    }

    public void setAnchorCustomerService(AnchorCustomerService<AnchorCustomer> anchorCustomerService) {
        this.anchorCustomerService = anchorCustomerService;
    }

    public ClosePrMultiAttachService<ClosePrMultiAttach> getClosePrMultiAttachService() {
        return closePrMultiAttachService;
    }

    public void setClosePrMultiAttachService(ClosePrMultiAttachService<ClosePrMultiAttach> closePrMultiAttachService) {
        this.closePrMultiAttachService = closePrMultiAttachService;
    }

    public VendorRecycleMailSchedulerService<VendorRecycleMailScheduler> getVendorRecycleMailSchedulerService() {
        return vendorRecycleMailSchedulerService;
    }

    public void setVendorRecycleMailSchedulerService(VendorRecycleMailSchedulerService<VendorRecycleMailScheduler> vendorRecycleMailSchedulerService) {
        this.vendorRecycleMailSchedulerService = vendorRecycleMailSchedulerService;
    }

    public VendorBuyerApprovalService<VendorBuyerApproval> getVendorBuyerApprovalService() {
        return vendorBuyerApprovalService;
    }

    public void setVendorBuyerApprovalService(VendorBuyerApprovalService<VendorBuyerApproval> vendorBuyerApprovalService) {
        this.vendorBuyerApprovalService = vendorBuyerApprovalService;
    }

    public CountryCodeService<CountryCode> getCountryCodeService() {
        return countryCodeService;
    }

    public void setCountryCodeService(CountryCodeService<CountryCode> countryCodeService) {
        this.countryCodeService = countryCodeService;
    }

    public ManagerialPersonService<ManagerialPerson> getManagerialPersonService() {
        return managerialPersonService;
    }

    public void setManagerialPersonService(ManagerialPersonService<ManagerialPerson> managerialPersonService) {
        this.managerialPersonService = managerialPersonService;
    }

    public VendorItCriteriaCommentService<VendorItCriteriaComment> getVendorItCriteriaCommentService() {
        return vendorItCriteriaCommentService;
    }

    public void setVendorItCriteriaCommentService(VendorItCriteriaCommentService<VendorItCriteriaComment> vendorItCriteriaCommentService) {
        this.vendorItCriteriaCommentService = vendorItCriteriaCommentService;
    }

    public LastWorkExpDeatilsService<LastWorkExpDeatils> getLastWorkExpDeatilsService() {
        return lastWorkExpDeatilsService;
    }

    public void setLastWorkExpDeatilsService(LastWorkExpDeatilsService<LastWorkExpDeatils> lastWorkExpDeatilsService) {
        this.lastWorkExpDeatilsService = lastWorkExpDeatilsService;
    }

    public VendorCriteriaMasterService<VendorCriteriaMaster> getVendorCriteriaMasterService() {
        return vendorCriteriaMasterService;
    }

    public void setVendorCriteriaMasterService(VendorCriteriaMasterService<VendorCriteriaMaster> vendorCriteriaMasterService) {
        this.vendorCriteriaMasterService = vendorCriteriaMasterService;
    }

    public VendorCriteriaMasterDetailsService<VendorCriteriaMasterDetails> getVendorCriteriaMasterDetailsService() {
        return vendorCriteriaMasterDetailsService;
    }

    public void setVendorCriteriaMasterDetailsService(VendorCriteriaMasterDetailsService<VendorCriteriaMasterDetails> vendorCriteriaMasterDetailsService) {
        this.vendorCriteriaMasterDetailsService = vendorCriteriaMasterDetailsService;
    }

    public VendorCriteriaMasterHistoryService<VendorCriteriaMasterHistory> getVendorCriteriaMasterHistoryService() {
        return vendorCriteriaMasterHistoryService;
    }

    public void setVendorCriteriaMasterHistoryService(VendorCriteriaMasterHistoryService<VendorCriteriaMasterHistory> vendorCriteriaMasterHistoryService) {
        this.vendorCriteriaMasterHistoryService = vendorCriteriaMasterHistoryService;
    }

    public VendorCriteriaDetailsHistoryService<VendorCriteriaDetailsHistory> getVendorCriteriaDetailsHistoryService() {
        return vendorCriteriaDetailsHistoryService;
    }

    public void setVendorCriteriaDetailsHistoryService(VendorCriteriaDetailsHistoryService<VendorCriteriaDetailsHistory> vendorCriteriaDetailsHistoryService) {
        this.vendorCriteriaDetailsHistoryService = vendorCriteriaDetailsHistoryService;
    }

    public TechnicalMultiAttachmentService<TechnicalMultiAttachment> getTechnicalMultiAttachmentService() {
        return technicalMultiAttachmentService;
    }

    public void setTechnicalMultiAttachmentService(TechnicalMultiAttachmentService<TechnicalMultiAttachment> technicalMultiAttachmentService) {
        this.technicalMultiAttachmentService = technicalMultiAttachmentService;
    }

    public ClosePrService<ClosePr> getClosePrService() {
        return closePrService;
    }

    public void setClosePrService(ClosePrService<ClosePr> closePrService) {
        this.closePrService = closePrService;
    }

    public VendorSelfDeclarationService<VendorSelfDeclaration> getVendorSelfDeclarationService() {
        return vendorSelfDeclarationService;
    }

    public void setVendorSelfDeclarationService(VendorSelfDeclarationService<VendorSelfDeclaration> vendorSelfDeclarationService) {
        this.vendorSelfDeclarationService = vendorSelfDeclarationService;
    }

    public VendorTermsConditionPriceBidService<VendorTermsConditionPriceBid> getVendorTermsConditionPriceBidService() {
        return vendorTermsConditionPriceBidService;
    }

    public void setVendorTermsConditionPriceBidService(VendorTermsConditionPriceBidService<VendorTermsConditionPriceBid> vendorTermsConditionPriceBidService) {
        this.vendorTermsConditionPriceBidService = vendorTermsConditionPriceBidService;
    }

    public AuditorMasterService<AuditorMaster> getAuditorMasterService() {
        return auditorMasterService;
    }

    public void setAuditorMasterService(AuditorMasterService<AuditorMaster> auditorMasterService) {
        this.auditorMasterService = auditorMasterService;
    }

    public DeclarationLetterService<DeclarationLetter> getDeclarationLetterService() {
        return declarationLetterService;
    }

    public void setDeclarationLetterService(DeclarationLetterService<DeclarationLetter> DeclarationLetterService) {
        this.declarationLetterService = DeclarationLetterService;
    }

    protected VendorCompanyDetailsService<VendorCompanyDetails> vendorCompanyDetailsService;

    public VendorCompanyDetailsService<VendorCompanyDetails> getVendorCompanyDetailsService() {
        return vendorCompanyDetailsService;
    }

    public void setVendorCompanyDetailsService(VendorCompanyDetailsService<VendorCompanyDetails> VendorCompanyDetailsService) {
        this.vendorCompanyDetailsService = VendorCompanyDetailsService;
    }

    public SiteSurveyCategoryDetailsService<SiteSurveyCategoryDetails> getSiteSurveyCategoryDetailsService() {
        return siteSurveyCategoryDetailsService;
    }

    public void setSiteSurveyCategoryDetailsService(SiteSurveyCategoryDetailsService<SiteSurveyCategoryDetails> siteSurveyCategoryDetailsService) {
        this.siteSurveyCategoryDetailsService = siteSurveyCategoryDetailsService;
    }

    public SurveyDocumentNoService<SurveyDocumentNo> getSurveyDocumentNoService() {
        return surveyDocumentNoService;
    }

    public void setSurveyDocumentNoService(SurveyDocumentNoService<SurveyDocumentNo> surveyDocumentNoService) {
        this.surveyDocumentNoService = surveyDocumentNoService;
    }

    public DocumentForNewElectricityConnectionService<DocumentForNewElectricityConnection> getDocumentForNewElectricityConnectionService() {
        return documentForNewElectricityConnectionService;
    }

    public void setDocumentForNewElectricityConnectionService(DocumentForNewElectricityConnectionService<DocumentForNewElectricityConnection> documentForNewElectricityConnectionService) {
        this.documentForNewElectricityConnectionService = documentForNewElectricityConnectionService;
    }

    public SiteSurveyService<SiteSurvey> getSiteSurveyService() {
        return siteSurveyService;
    }

    public void setSiteSurveyService(SiteSurveyService<SiteSurvey> siteSurveyService) {
        this.siteSurveyService = siteSurveyService;
    }

    public OapLogMasterService<OapLogMaster> getOapLogMasterService() {
        return oapLogMasterService;
    }

    public void setOapLogMasterService(OapLogMasterService<OapLogMaster> oapLogMasterService) {
        this.oapLogMasterService = oapLogMasterService;
    }

    public AocLogMasterService<AocLogMaster> getAocLogMasterService() {
        return aocLogMasterService;
    }

    public void setAocLogMasterService(AocLogMasterService<AocLogMaster> aocLogMasterService) {
        this.aocLogMasterService = aocLogMasterService;
    }

    public SiteSurveyAttachmentService<SiteSurveyAttachment> getSiteSurveyAttachmentService() {
        return siteSurveyAttachmentService;
    }

    public void setSiteSurveyAttachmentService(SiteSurveyAttachmentService<SiteSurveyAttachment> siteSurveyAttachmentService) {
        this.siteSurveyAttachmentService = siteSurveyAttachmentService;
    }

    public OapSurveyAttachmentService<OapSurveyAttachment> getOapSurveyAttachmentService() {
        return oapSurveyAttachmentService;
    }

    public void setOapSurveyAttachmentService(OapSurveyAttachmentService<OapSurveyAttachment> oapSurveyAttachmentService) {
        this.oapSurveyAttachmentService = oapSurveyAttachmentService;
    }

    public OapSurveyAttachmentHistoryService<OapSurveyAttachmentHistory> getOapSurveyAttachmentHistoryService() {
        return oapSurveyAttachmentHistoryService;
    }

    public void setOapSurveyAttachmentHistoryService(OapSurveyAttachmentHistoryService<OapSurveyAttachmentHistory> oapSurveyAttachmentHistoryService) {
        this.oapSurveyAttachmentHistoryService = oapSurveyAttachmentHistoryService;
    }

    public AocSurveyAttachmentService<AocSurveyAttachment> getAocSurveyAttachmentService() {
        return aocSurveyAttachmentService;
    }

    public void setAocSurveyAttachmentService(AocSurveyAttachmentService<AocSurveyAttachment> aocSurveyAttachmentService) {
        this.aocSurveyAttachmentService = aocSurveyAttachmentService;
    }

    public AocSurveyAttachmentHistoryService<AocSurveyAttachmentHistory> getAocSurveyAttachmentHistoryService() {
        return aocSurveyAttachmentHistoryService;
    }

    public void setAocSurveyAttachmentHistoryService(AocSurveyAttachmentHistoryService<AocSurveyAttachmentHistory> aocSurveyAttachmentHistoryService) {
        this.aocSurveyAttachmentHistoryService = aocSurveyAttachmentHistoryService;
    }

    public RiskCategoryService<Riskcategory> getRiskCategoryService() {
        return RiskCategoryService;
    }

    public void setRiskCategoryService(RiskCategoryService<Riskcategory> RiskCategoryService) {
        this.RiskCategoryService = RiskCategoryService;
    }

    public VendorInviteSourceService<VendorInviteSource> getVendorInviteSourceService() {
        return VendorInviteSourceService;
    }

    public void setVendorInviteSourceService(VendorInviteSourceService<VendorInviteSource> VendorInviteSourceService) {
        this.VendorInviteSourceService = VendorInviteSourceService;
    }

    public PoDetailsService<PoDetails> getPoDetailsService() {
        return poDetailsService;
    }

    public void setPoDetailsService(PoDetailsService<PoDetails> poDetailsService) {
        this.poDetailsService = poDetailsService;
    }

    public VendorDepartmentApprovalService<VendorDepartmentApproval> getVendorDepartmentApprovalService() {
        return vendorDepartmentApprovalService;
    }

    public void setVendorDepartmentApprovalService(VendorDepartmentApprovalService<VendorDepartmentApproval> vendorDepartmentApprovalService) {
        this.vendorDepartmentApprovalService = vendorDepartmentApprovalService;
    }

    public VendorApprovalSettingService<VendorApprovalSetting> getVendorApprovalSettingService() {
        return vendorApprovalSettingService;
    }

    public void setVendorApprovalSettingService(VendorApprovalSettingService<VendorApprovalSetting> vendorApprovalSettingService) {
        this.vendorApprovalSettingService = vendorApprovalSettingService;
    }

    public VendorApprovalUserService<VendorApprovalUser> getVendorApprovalUserService() {
        return vendorApprovalUserService;
    }

    public void setVendorApprovalUserService(VendorApprovalUserService<VendorApprovalUser> vendorApprovalUserService) {
        this.vendorApprovalUserService = vendorApprovalUserService;
    }

    public VendorRequestDetailsService<VendorRequestDetails> getVendorRequestDetailsService() {
        return vendorRequestDetailsService;
    }

    public void setVendorRequestDetailsService(VendorRequestDetailsService<VendorRequestDetails> vendorRequestDetailsService) {
        this.vendorRequestDetailsService = vendorRequestDetailsService;
    }

    public VendorRequestApprovalService<VendorRequestApproval> getVendorRequestApprovalService() {
        return vendorRequestApprovalService;
    }

    public void setVendorRequestApprovalService(VendorRequestApprovalService<VendorRequestApproval> vendorRequestApprovalService) {
        this.vendorRequestApprovalService = vendorRequestApprovalService;
    }

    public VendorRequestApprovalUserService<VendorRequestApprovalUser> getVendorRequestApprovalUserService() {
        return vendorRequestApprovalUserService;
    }

    public void setVendorRequestApprovalUserService(VendorRequestApprovalUserService<VendorRequestApprovalUser> vendorRequestApprovalUserService) {
        this.vendorRequestApprovalUserService = vendorRequestApprovalUserService;
    }

    public VendorRequestApprovalCommentService<VendorRequestApprovalComment> getVendorRequestApprovalCommentService() {
        return vendorRequestApprovalCommentService;
    }

    public void setVendorRequestApprovalCommentService(VendorRequestApprovalCommentService<VendorRequestApprovalComment> vendorRequestApprovalCommentService) {
        this.vendorRequestApprovalCommentService = vendorRequestApprovalCommentService;
    }

    public TaxCategoryService<TaxCategory> getTaxCategoryService() {
        return taxCategoryService;
    }

    public void setTaxCategoryService(TaxCategoryService<TaxCategory> taxCategoryService) {
        this.taxCategoryService = taxCategoryService;
    }

    public GroupForCalculationService<GroupForCalculation> getGroupForCalculationService() {
        return groupForCalculationService;
    }

    public void setGroupForCalculationService(GroupForCalculationService<GroupForCalculation> groupForCalculationService) {
        this.groupForCalculationService = groupForCalculationService;
    }

    public VendorRequestedInvitationCategoryService<VendorRequestedInvitationCategory> getVendorRequestedInvitationCategoryService() {
        return vendorRequestedInvitationCategoryService;
    }

    public void setVendorRequestedInvitationCategoryService(VendorRequestedInvitationCategoryService<VendorRequestedInvitationCategory> vendorRequestedInvitationCategoryService) {
        this.vendorRequestedInvitationCategoryService = vendorRequestedInvitationCategoryService;
    }

    public DeliverableService<Deliverable> getDeliverableService() {
        return deliverableService;
    }

    public void setDeliverableService(DeliverableService<Deliverable> deliverableService) {
        this.deliverableService = deliverableService;
    }

    public OapFormService<OapForm> getOapFormService() {
        return oapFormService;
    }

    public void setOapFormService(OapFormService<OapForm> oapFormService) {
        this.oapFormService = oapFormService;
    }

    public OapDocumentAttachmentService<OapDocumentAttachment> getOapDocumentAttachmentService() {
        return oapDocumentAttachmentService;
    }

    public void setOapDocumentAttachmentService(OapDocumentAttachmentService<OapDocumentAttachment> oapDocumentAttachmentService) {
        this.oapDocumentAttachmentService = oapDocumentAttachmentService;
    }

    public OapMultiAttachmentService<OapMultiAttachment> getOapMultiAttachmentService() {
        return oapMultiAttachmentService;
    }

    public void setOapMultiAttachmentService(OapMultiAttachmentService<OapMultiAttachment> oapMultiAttachmentService) {
        this.oapMultiAttachmentService = oapMultiAttachmentService;
    }

    public OapFormApprovalService<OapFormApproval> getOapFormApprovalService() {
        return oapFormApprovalService;
    }

    public void setOapFormApprovalService(OapFormApprovalService<OapFormApproval> oapFormApprovalService) {
        this.oapFormApprovalService = oapFormApprovalService;
    }

    public OapFormApprovalCommentService<OapFormApprovalComment> getOapFormApprovalCommentService() {
        return oapFormApprovalCommentService;
    }

    public void setOapFormApprovalCommentService(OapFormApprovalCommentService<OapFormApprovalComment> oapFormApprovalCommentService) {
        this.oapFormApprovalCommentService = oapFormApprovalCommentService;
    }

    public OapFormApprovalUserService<OapFormApprovalUser> getOapFormApprovalUserService() {
        return oapFormApprovalUserService;
    }

    public void setOapFormApprovalUserService(OapFormApprovalUserService<OapFormApprovalUser> oapFormApprovalUserService) {
        this.oapFormApprovalUserService = oapFormApprovalUserService;
    }

    public AocFormService<AocForm> getAocFormService() {
        return aocFormService;
    }

    public void setAocFormService(AocFormService<AocForm> aocFormService) {
        this.aocFormService = aocFormService;
    }

    public AocFormAttachmentService<AocFormAttachment> getAocFormAttachmentService() {
        return AocFormAttachmentService;
    }

    public void setAocFormAttachmentService(AocFormAttachmentService<AocFormAttachment> AocFormAttachmentService) {
        this.AocFormAttachmentService = AocFormAttachmentService;
    }

    public AocFormMultiAttachmentService<AocFormMultiAttachment> getAocFormMultiAttachmentService() {
        return aocFormMultiAttachmentService;
    }

    public void setAocFormMultiAttachmentService(AocFormMultiAttachmentService<AocFormMultiAttachment> aocFormMultiAttachmentService) {
        this.aocFormMultiAttachmentService = aocFormMultiAttachmentService;
    }

    public AocFormApprovalService<AocFormApproval> getAocFormApprovalService() {
        return aocFormApprovalService;
    }

    public void setAocFormApprovalService(AocFormApprovalService<AocFormApproval> aocFormApprovalService) {
        this.aocFormApprovalService = aocFormApprovalService;
    }

    public AocFormApprovalUserService<AocFormApprovalUser> getAocFormApprovalUserService() {
        return aocFormApprovalUserService;
    }

    public void setAocFormApprovalUserService(AocFormApprovalUserService<AocFormApprovalUser> aocFormApprovalUserService) {
        this.aocFormApprovalUserService = aocFormApprovalUserService;
    }

    public AocFormApprovalCommentService<AocFormApprovalComment> getAocFormApprovalCommentService() {
        return aocFormApprovalCommentService;
    }

    public void setAocFormApprovalCommentService(AocFormApprovalCommentService<AocFormApprovalComment> aocFormApprovalCommentService) {
        this.aocFormApprovalCommentService = aocFormApprovalCommentService;
    }

    public CrcFormService<CrcForm> getCrcFormService() {
        return crcFormService;
    }

    public void setCrcFormService(CrcFormService<CrcForm> crcFormService) {
        this.crcFormService = crcFormService;
    }

    public CrcFormApprovalService<CrcFormApproval> getCrcFormApprovalService() {
        return crcFormApprovalService;
    }

    public void setCrcFormApprovalService(CrcFormApprovalService<CrcFormApproval> crcFormApprovalService) {
        this.crcFormApprovalService = crcFormApprovalService;
    }

    public CrcFormApprovalUserService<CrcFormApprovalUser> getCrcFormApprovalUserService() {
        return crcFormApprovalUserService;
    }

    public void setCrcFormApprovalUserService(CrcFormApprovalUserService<CrcFormApprovalUser> crcFormApprovalUserService) {
        this.crcFormApprovalUserService = crcFormApprovalUserService;
    }

    public CrcFormApprovalCommentService<CrcFormApprovalComment> getCrcFormApprovalCommentService() {
        return crcFormApprovalCommentService;
    }

    public void setCrcFormApprovalCommentService(CrcFormApprovalCommentService<CrcFormApprovalComment> crcFormApprovalCommentService) {
        this.crcFormApprovalCommentService = crcFormApprovalCommentService;
    }

    public KickOffAttendencesService<KickOffAttendences> getKickOffAttendencesService() {
        return kickOffAttendencesService;
    }

    public void setKickOffAttendencesService(KickOffAttendencesService<KickOffAttendences> kickOffAttendencesService) {
        this.kickOffAttendencesService = kickOffAttendencesService;
    }

    public KickOffFormApprovalService<KickOffFormApproval> getKickOffFormApprovalService() {
        return kickOffFormApprovalService;
    }

    public void setKickOffFormApprovalService(KickOffFormApprovalService<KickOffFormApproval> kickOffFormApprovalService) {
        this.kickOffFormApprovalService = kickOffFormApprovalService;
    }

    public KickOffFormApprovalUserService<KickOffFormApprovalUser> getKickOffFormApprovalUserService() {
        return kickOffFormApprovalUserService;
    }

    public void setKickOffFormApprovalUserService(KickOffFormApprovalUserService<KickOffFormApprovalUser> kickOffFormApprovalUserService) {
        this.kickOffFormApprovalUserService = kickOffFormApprovalUserService;
    }

    public KickOffFormApprovalCommentService<KickOffFormApprovalComment> getKickOffFormApprovalCommentService() {
        return kickOffFormApprovalCommentService;
    }

    public void setKickOffFormApprovalCommentService(KickOffFormApprovalCommentService<KickOffFormApprovalComment> kickOffFormApprovalCommentService) {
        this.kickOffFormApprovalCommentService = kickOffFormApprovalCommentService;
    }

    public KickOffFormService<KickOffForm> getKickOffFormService() {
        return kickOffFormService;
    }

    public void setKickOffFormService(KickOffFormService<KickOffForm> kickOffFormService) {
        this.kickOffFormService = kickOffFormService;
    }

    public DocumentMasterIdService<DocumentMasterId> getDocumentMasterIdService() {
        return documentMasterIdService;
    }

    public void setDocumentMasterIdService(DocumentMasterIdService<DocumentMasterId> documentMasterIdService) {
        this.documentMasterIdService = documentMasterIdService;
    }

    public DocumentMastersIdService<DocumentMastersId> getDocumentMastersIdService() {
        return documentMastersIdService;
    }

    public void setDocumentMastersIdService(DocumentMastersIdService<DocumentMastersId> documentMastersIdService) {
        this.documentMastersIdService = documentMastersIdService;
    }

    public DeliverableMultiService<DeliverableMulti> getDeliverableMultiService() {
        return deliverableMultiService;
    }

    public void setDeliverableMultiService(DeliverableMultiService<DeliverableMulti> deliverableMultiService) {
        this.deliverableMultiService = deliverableMultiService;
    }

    public IteamDetailsAttachmentsService<IteamDetailsAttachments> getIteamDetailsAttachmentsService() {
        return iteamDetailsAttachmentsService;
    }

    public void setIteamDetailsAttachmentsService(IteamDetailsAttachmentsService<IteamDetailsAttachments> iteamDetailsAttachmentsService) {
        this.iteamDetailsAttachmentsService = iteamDetailsAttachmentsService;
    }

    public DesignCoordinatorMultiAttachService<DesignCoordinatorMultiAttach> getDesignCoordinatorMultiAttachService() {
        return designCoordinatorMultiAttachService;
    }

    public void setDesignCoordinatorMultiAttachService(DesignCoordinatorMultiAttachService<DesignCoordinatorMultiAttach> designCoordinatorMultiAttachService) {
        this.designCoordinatorMultiAttachService = designCoordinatorMultiAttachService;
    }

    public DesignCordinatorCommentsService<DesignCordinatorComments> getDesignCordinatorCommentsService() {
        return designCordinatorCommentsService;
    }

    public void setDesignCordinatorCommentsService(DesignCordinatorCommentsService<DesignCordinatorComments> designCordinatorCommentsService) {
        this.designCordinatorCommentsService = designCordinatorCommentsService;
    }

    public AocFormHistoryService<AocFormHistory> getAocFormHistoryService() {
        return aocFormHistoryService;
    }

    public void setAocFormHistoryService(AocFormHistoryService<AocFormHistory> aocFormHistoryService) {
        this.aocFormHistoryService = aocFormHistoryService;
    }

    public CrcFormHistoryService<CrcFormHistory> getCrcFormHistoryService() {
        return crcFormHistoryService;
    }

    public void setCrcFormHistoryService(CrcFormHistoryService<CrcFormHistory> crcFormHistoryService) {
        this.crcFormHistoryService = crcFormHistoryService;
    }

    public KickOffFormHistoryService<KickOffFormHistory> getKickOffFormHistoryService() {
        return kickOffFormHistoryService;
    }

    public void setKickOffFormHistoryService(KickOffFormHistoryService<KickOffFormHistory> kickOffFormHistoryService) {
        this.kickOffFormHistoryService = kickOffFormHistoryService;
    }

    public OapFormHistoryService<OapFormHistory> getOapFormHistoryService() {
        return oapFormHistoryService;
    }

    public void setOapFormHistoryService(OapFormHistoryService<OapFormHistory> oapFormHistoryService) {
        this.oapFormHistoryService = oapFormHistoryService;
    }

    public AocFormMultiAttachmentHistoryService<AocFormMultiAttachmentHistory> getAocFormMultiAttachmentHistoryService() {
        return aocFormMultiAttachmentHistoryService;
    }

    public void setAocFormMultiAttachmentHistoryService(AocFormMultiAttachmentHistoryService<AocFormMultiAttachmentHistory> aocFormMultiAttachmentHistoryService) {
        this.aocFormMultiAttachmentHistoryService = aocFormMultiAttachmentHistoryService;
    }

    public OapMultiAttachmentHistoryService<OapMultiAttachmentHistory> getOapMultiAttachmentHistoryService() {
        return oapMultiAttachmentHistoryService;
    }

    public void setOapMultiAttachmentHistoryService(OapMultiAttachmentHistoryService<OapMultiAttachmentHistory> oapMultiAttachmentHistoryService) {
        this.oapMultiAttachmentHistoryService = oapMultiAttachmentHistoryService;
    }

    public KickOffAttendencesHistoryService<KickOffAttendencesHistory> getKickOffAttendencesHistoryService() {
        return kickOffAttendencesHistoryService;
    }

    public void setKickOffAttendencesHistoryService(KickOffAttendencesHistoryService<KickOffAttendencesHistory> kickOffAttendencesHistoryService) {
        this.kickOffAttendencesHistoryService = kickOffAttendencesHistoryService;
    }

    public ProjectNameMasterService<ProjectNameMaster> getProjectNameMasterService() {
        return projectNameMasterService;
    }

    public void setProjectNameMasterService(ProjectNameMasterService<ProjectNameMaster> projectNameMasterService) {
        this.projectNameMasterService = projectNameMasterService;
    }

    public ProfitCenterService<ProfitCenter> getProfitCenterService() {
        return profitCenterService;
    }

    public void setProfitCenterService(ProfitCenterService<ProfitCenter> profitCenterService) {
        this.profitCenterService = profitCenterService;
    }

    public ProjectTypeService<ProjectType> getProjectTypeService() {
        return projectTypeService;
    }

    public void setProjectTypeService(ProjectTypeService<ProjectType> projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    public CurrencyMasterService<CurrencyMaster> getCurrencyMasterService() {
        return currencyMasterService;
    }

    public void setCurrencyMasterService(CurrencyMasterService<CurrencyMaster> currencyMasterService) {
        this.currencyMasterService = currencyMasterService;
    }

    public StationTypeService<StationType> getStationTypeService() {
        return stationTypeService;
    }

    public void setStationTypeService(StationTypeService<StationType> stationTypeService) {
        this.stationTypeService = stationTypeService;
    }

    public TenantService<Tenant> getTenantService() {
        return tenantService;
    }

    public void setTenantService(TenantService<Tenant> tenantService) {
        this.tenantService = tenantService;
    }

    public InvestmentProfileService<InvestmentProfile> getInvestmentProfileService() {
        return investmentProfileService;
    }

    public void setInvestmentProfileService(InvestmentProfileService<InvestmentProfile> investmentProfileService) {
        this.investmentProfileService = investmentProfileService;
    }

    public ProjectProfileService<ProjectProfile> getProjectProfileService() {
        return projectProfileService;
    }

    public void setProjectProfileService(ProjectProfileService<ProjectProfile> projectProfileService) {
        this.projectProfileService = projectProfileService;
    }

    public DiscomMasterService<DiscomMaster> getDiscomMasterService() {
        return discomMasterService;
    }

    public void setDiscomMasterService(DiscomMasterService<DiscomMaster> discomMasterService) {
        this.discomMasterService = discomMasterService;
    }

    public ConnectionTypeService<ConnectionType> getConnectionTypeService() {
        return connectionTypeService;
    }

    public void setConnectionTypeService(ConnectionTypeService<ConnectionType> connectionTypeService) {
        this.connectionTypeService = connectionTypeService;
    }

    public OapMasterService<OapMaster> getOapMasterService() {
        return oapMasterService;
    }

    public void setOapMasterService(OapMasterService<OapMaster> oapMasterService) {
        this.oapMasterService = oapMasterService;
    }

    public OapMasterUserService<OapMasterUser> getOapMasterUserService() {
        return oapMasterUserService;
    }

    public void setOapMasterUserService(OapMasterUserService<OapMasterUser> oapMasterUserService) {
        this.oapMasterUserService = oapMasterUserService;
    }

    public DocumentNameService<DocumentName> getDocumentNameService() {
        return documentNameService;
    }

    public void setDocumentNameService(DocumentNameService<DocumentName> documentNameService) {
        this.documentNameService = documentNameService;
    }

    public VendorPercentageService<VendorPercentage> getVendorPercentageService() {
        return vendorPercentageService;
    }

    public void setVendorPercentageService(VendorPercentageService<VendorPercentage> vendorPercentageService) {
        this.vendorPercentageService = vendorPercentageService;
    }

    public BpGroupService<BpGroup> getBpGroupService() {
        return bpGroupService;
    }

    public void setBpGroupService(BpGroupService<BpGroup> bpGroupService) {
        this.bpGroupService = bpGroupService;
    }

    public VendorInvitationCategoryService<VendorInvitationCategory> getVendorInvitationCategoryService() {
        return vendorInvitationCategoryService;
    }

    public void setVendorInvitationCategoryService(VendorInvitationCategoryService<VendorInvitationCategory> vendorInvitationCategoryService) {
        this.vendorInvitationCategoryService = vendorInvitationCategoryService;
    }

    public VendorSafetyCriteriaCommentService<VendorSafetyCriteriaComment> getVendorSafetyCriteriaCommentService() {
        return vendorSafetyCriteriaCommentService;
    }

    public void setVendorSafetyCriteriaCommentService(VendorSafetyCriteriaCommentService<VendorSafetyCriteriaComment> vendorSafetyCriteriaCommentService) {
        this.vendorSafetyCriteriaCommentService = vendorSafetyCriteriaCommentService;
    }

    public VendorHrCriteriaCommentService<VendorHrCriteriaComment> getVendorHrCriteriaCommentService() {
        return vendorHrCriteriaCommentService;
    }

    public void setVendorHrCriteriaCommentService(VendorHrCriteriaCommentService<VendorHrCriteriaComment> vendorHrCriteriaCommentService) {
        this.vendorHrCriteriaCommentService = vendorHrCriteriaCommentService;
    }

    public CompanyMasterService<CompanyMaster> getCompanyMasterService() {
        return companyMasterService;
    }

    public void setCompanyMasterService(CompanyMasterService<CompanyMaster> companyMasterService) {
        this.companyMasterService = companyMasterService;
    }

    public PurchasingOrganisationService<PurchasingOrganisation> getPurchasingOrganisationService() {
        return purchasingOrganisationService;
    }

    public void setPurchasingOrganisationService(PurchasingOrganisationService<PurchasingOrganisation> purchasingOrganisationService) {
        this.purchasingOrganisationService = purchasingOrganisationService;
    }

    public PlantMastersService<PlantMasters> getPlantMastersService() {
        return plantMastersService;
    }

    public void setPlantMastersService(PlantMastersService<PlantMasters> plantMastersService) {
        this.plantMastersService = plantMastersService;
    }

    public LocationMastersService<LocationMasters> getLocationMastersService() {
        return locationMastersService;
    }

    public void setLocationMastersService(LocationMastersService<LocationMasters> locationMastersService) {
        this.locationMastersService = locationMastersService;
    }

    public ProductGroupMasterService<ProductGroupMaster> getProductGroupMasterService() {
        return productGroupMasterService;
    }

    public void setProductGroupMasterService(ProductGroupMasterService<ProductGroupMaster> productGroupMasterService) {
        this.productGroupMasterService = productGroupMasterService;
    }

    public ValuationClassMasterService<ValuationClassMaster> getValuationClassMasterService() {
        return valuationClassMasterService;
    }

    public void setValuationClassMasterService(ValuationClassMasterService<ValuationClassMaster> valuationClassMasterService) {
        this.valuationClassMasterService = valuationClassMasterService;
    }

    public ProductTypeMasterService<ProductTypeMaster> getProductTypeMasterService() {
        return productTypeMasterService;
    }

    public void setProductTypeMasterService(ProductTypeMasterService<ProductTypeMaster> productTypeMasterService) {
        this.productTypeMasterService = productTypeMasterService;
    }

    public VendorHrCriteriaService<VendorHrCriteria> getVendorHrCriteriaService() {
        return vendorHrCriteriaService;
    }

    public void setVendorHrCriteriaService(VendorHrCriteriaService<VendorHrCriteria> vendorHrCriteriaService) {
        this.vendorHrCriteriaService = vendorHrCriteriaService;
    }

    public VendorSafetyCriteriaService<VendorSafetyCriteria> getVendorSafetyCriteriaService() {
        return vendorSafetyCriteriaService;
    }

    public void setVendorSafetyCriteriaService(VendorSafetyCriteriaService<VendorSafetyCriteria> vendorSafetyCriteriaService) {
        this.vendorSafetyCriteriaService = vendorSafetyCriteriaService;
    }

    public GroupSubCategoryService<GroupSubCategory> getGroupSubCategoryService() {
        return groupSubCategoryService;
    }

    public void setGroupSubCategoryService(GroupSubCategoryService<GroupSubCategory> groupSubCategoryService) {
        this.groupSubCategoryService = groupSubCategoryService;
    }

    public VendorTechnicalCriteriaService<VendorTechnicalCriteria> getVendorTechnicalCriteriaService() {
        return vendorTechnicalCriteriaService;
    }

    public void setVendorTechnicalCriteriaService(VendorTechnicalCriteriaService<VendorTechnicalCriteria> vendorTechnicalCriteriaService) {
        this.vendorTechnicalCriteriaService = vendorTechnicalCriteriaService;
    }

    public GroupMasterService<GroupMaster> getGroupMasterService() {
        return groupMasterService;
    }

    public void setGroupMasterService(GroupMasterService<GroupMaster> groupMasterService) {
        this.groupMasterService = groupMasterService;
    }

    public GroupCategoryService<GroupCategory> getGroupCategoryService() {
        return groupCategoryService;
    }

    public void setGroupCategoryService(GroupCategoryService<GroupCategory> groupCategoryService) {
        this.groupCategoryService = groupCategoryService;
    }

    public ElectricalContractorService<ElectricalContractor> getElectricalContractorService() {
        return electricalContractorService;
    }

    public void setElectricalContractorService(ElectricalContractorService<ElectricalContractor> electricalContractorService) {
        this.electricalContractorService = electricalContractorService;
    }

    protected Header header;
    protected SendMail sendMail;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat timeFOrmat = new SimpleDateFormat("HH:mm:ss");

    public static String myIp;

    public MultipleAddressService<MultipleAddress> getMultipleAddressService() {
        return multipleAddressService;
    }

    public void setMultipleAddressService(MultipleAddressService<MultipleAddress> multipleAddressService) {
        this.multipleAddressService = multipleAddressService;
    }

    public TermsConditionService<TermsCondition> getTermsConditionService() {
        return termsConditionService;
    }

    public void setTermsConditionService(TermsConditionService<TermsCondition> termsConditionService) {
        this.termsConditionService = termsConditionService;
    }

    public TermsConditionParameterService<TermsConditionParameter> getTermsConditionParameterService() {
        return termsConditionParameterService;
    }

    public void setTermsConditionParameterService(TermsConditionParameterService<TermsConditionParameter> termsConditionParameterService) {
        this.termsConditionParameterService = termsConditionParameterService;
    }

    public VendorTermsConditionService<VendorTermsCondition> getVendorTermsConditionService() {
        return vendorTermsConditionService;
    }

    public void setVendorTermsConditionService(VendorTermsConditionService<VendorTermsCondition> vendorTermsConditionService) {
        this.vendorTermsConditionService = vendorTermsConditionService;
    }

    public TechnicalTenderPriceApprovalService<TechnicalTenderPriceApproval> getTechnicalTenderPriceApprovalService() {
        return technicalTenderPriceApprovalService;
    }

    public void setTechnicalTenderPriceApprovalService(TechnicalTenderPriceApprovalService<TechnicalTenderPriceApproval> technicalTenderPriceApprovalService) {
        this.technicalTenderPriceApprovalService = technicalTenderPriceApprovalService;
    }

    public TechnicalTenderPriceApprovalUserService<TechnicalTenderPriceApprovalUser> getTechnicalTenderPriceApprovalUserService() {
        return technicalTenderPriceApprovalUserService;
    }

    public void setTechnicalTenderPriceApprovalUserService(TechnicalTenderPriceApprovalUserService<TechnicalTenderPriceApprovalUser> technicalTenderPriceApprovalUserService) {
        this.technicalTenderPriceApprovalUserService = technicalTenderPriceApprovalUserService;
    }

    public TechnicalTenderPriceApprovalCommentService<TechnicalTenderPriceApprovalComment> getTechnicalTenderPriceApprovalCommentService() {
        return technicalTenderPriceApprovalCommentService;
    }

    public void setTechnicalTenderPriceApprovalCommentService(TechnicalTenderPriceApprovalCommentService<TechnicalTenderPriceApprovalComment> technicalTenderPriceApprovalCommentService) {
        this.technicalTenderPriceApprovalCommentService = technicalTenderPriceApprovalCommentService;
    }

    public SendMail getSendMail() {
        return sendMail;
    }

    public void setSendMail(SendMail sendMail) {
        this.sendMail = sendMail;
    }

    public UserMasterService<UserMaster> getUserMasterService() {
        return userMasterService;
    }

    public void setUserMasterService(UserMasterService<UserMaster> userMasterService) {
        this.userMasterService = userMasterService;
    }

    public EmployeeMasterService<EmployeeMaster> getEmployeeMasterService() {
        return employeeMasterService;
    }

    public void setEmployeeMasterService(EmployeeMasterService<EmployeeMaster> employeeMasterService) {
        this.employeeMasterService = employeeMasterService;
    }

    public ContractorService<ContractorMaster> getContractorService() {
        return contractorService;
    }

    public void setContractorService(ContractorService<ContractorMaster> contractorService) {
        this.contractorService = contractorService;
    }

    public ApprenticesService<ApprenticesMaster> getApprenticesService() {
        return apprenticesService;
    }

    public void setApprenticesService(ApprenticesService<ApprenticesMaster> apprenticesService) {
        this.apprenticesService = apprenticesService;
    }

    public DeviceService<DeviceDetails> getDeviceService() {
        return deviceService;
    }

    public void setDeviceService(DeviceService<DeviceDetails> deviceService) {
        this.deviceService = deviceService;
    }

    public CouponService<CouponMaster> getCouponService() {
        return couponService;
    }

    public void setCouponService(CouponService<CouponMaster> couponService) {
        this.couponService = couponService;
    }

    public RechargeService<RechargeMaster> getRechargeService() {
        return rechargeService;
    }

    public void setRechargeService(RechargeService<RechargeMaster> rechargeService) {
        this.rechargeService = rechargeService;
    }

    public SpecialCouponService<SpecialCouponMaster> getSpecialCouponService() {
        return specialCouponService;
    }

    public void setSpecialCouponService(SpecialCouponService<SpecialCouponMaster> specialCouponService) {
        this.specialCouponService = specialCouponService;
    }

    public PunchedDataService<PunchedDataMaster> getPunchedDataService() {
        return punchedDataService;
    }

    public void setPunchedDataService(PunchedDataService<PunchedDataMaster> punchedDataService) {
        this.punchedDataService = punchedDataService;
    }

    public RightService<RightMaster> getRightService() {
        return rightService;
    }

    public void setRightService(RightService<RightMaster> rightService) {
        this.rightService = rightService;
    }

    public RechargeInfoService<RechargeInfoMaster> getRechargeInfoService() {
        return rechargeInfoService;
    }

    public void setRechargeInfoService(RechargeInfoService<RechargeInfoMaster> rechargeInfoService) {
        this.rechargeInfoService = rechargeInfoService;
    }

    public LogService<LogsMaster> getLogService() {
        return logService;
    }

    public void setLogService(LogService<LogsMaster> logService) {
        this.logService = logService;
    }

    public ReportService<ReportMaster> getReportService() {
        return reportService;
    }

    public void setReportService(ReportService<ReportMaster> reportService) {
        this.reportService = reportService;
    }

    public SqlDataConnectService<SqlDataConnect> getSqlDataConnectService() {
        return sqlDataConnectService;
    }

    public void setSqlDataConnectService(SqlDataConnectService<SqlDataConnect> sqlDataConnectService) {
        this.sqlDataConnectService = sqlDataConnectService;
    }

    public ApprovalSettingService<ApprovalSetting> getApprovalSettingService() {
        return approvalSettingService;
    }

    public void setApprovalSettingService(ApprovalSettingService<ApprovalSetting> approvalSettingService) {
        this.approvalSettingService = approvalSettingService;
    }

    public VendorInvitationService<VendorInvitation> getVendorInvitationService() {
        return vendorInvitationService;
    }

    public void setVendorInvitationService(VendorInvitationService<VendorInvitation> vendorInvitationService) {
        this.vendorInvitationService = vendorInvitationService;
    }

    public VendorInformationService<VendorInformation> getVendorInformationService() {
        return vendorInformationService;
    }

    public void setVendorInformationService(VendorInformationService<VendorInformation> vendorInformationService) {
        this.vendorInformationService = vendorInformationService;
    }

    public VendorBusinessCertificateService<VendorBusinessCertificate> getVendorBusinessCertificateService() {
        return vendorBusinessCertificateService;
    }

    public void setVendorBusinessCertificateService(VendorBusinessCertificateService<VendorBusinessCertificate> vendorBusinessCertificateService) {
        this.vendorBusinessCertificateService = vendorBusinessCertificateService;
    }

    public VendorQualityCertificateService<VendorQualityCertificate> getVendorQualityCertificateService() {
        return vendorQualityCertificateService;
    }

    public void setVendorQualityCertificateService(VendorQualityCertificateService<VendorQualityCertificate> vendorQualityCertificateService) {
        this.vendorQualityCertificateService = vendorQualityCertificateService;
    }

    public VendorClearanceCertificateService<VendorClearanceCertificate> getVendorClearanceCertificateService() {
        return vendorClearanceCertificateService;
    }

    public void setVendorClearanceCertificateService(VendorClearanceCertificateService<VendorClearanceCertificate> vendorClearanceCertificateService) {
        this.vendorClearanceCertificateService = vendorClearanceCertificateService;
    }

    public VendorApprovalService<VendorApproval> getVendorApprovalService() {
        return vendorApprovalService;
    }

    public void setVendorApprovalService(VendorApprovalService<VendorApproval> vendorApprovalService) {
        this.vendorApprovalService = vendorApprovalService;
    }

    public VendorMasterService<VendorMaster> getVendorMasterService() {
        return vendorMasterService;
    }

    public void setVendorMasterService(VendorMasterService<VendorMaster> vendorMasterService) {
        this.vendorMasterService = vendorMasterService;
    }

    public UserRightsService<UserRights> getUserRightsService() {
        return userRightsService;
    }

    public void setUserRightsService(UserRightsService<UserRights> userRightsService) {
        this.userRightsService = userRightsService;
    }

    public TenderMasterService<TenderMaster> getTenderMasterService() {
        return tenderMasterService;
    }

    public void setTenderMasterService(TenderMasterService<TenderMaster> tenderMasterService) {
        this.tenderMasterService = tenderMasterService;
    }

    public SapDeliSchService<SapDeliSch> getSapDeliSchService() {
        return sapDeliSchService;
    }

    public void setSapDeliSchService(SapDeliSchService<SapDeliSch> sapDeliSchService) {
        this.sapDeliSchService = sapDeliSchService;
    }

    public SapItemLongTxtService<SapItemLongTxt> getSapItemLongTxtService() {
        return sapItemLongTxtService;
    }

    public void setSapItemLongTxtService(SapItemLongTxtService<SapItemLongTxt> sapItemLongTxtService) {
        this.sapItemLongTxtService = sapItemLongTxtService;
    }

    public SapPurchaseItemTxtService<SapPurchaseItemTxt> getSapPurchaseItemTxtService() {
        return sapPurchaseItemTxtService;
    }

    public void setSapPurchaseItemTxtService(SapPurchaseItemTxtService<SapPurchaseItemTxt> sapPurchaseItemTxtService) {
        this.sapPurchaseItemTxtService = sapPurchaseItemTxtService;
    }

    public SapTenderItemService<SapTenderItem> getSapTenderItemService() {
        return sapTenderItemService;
    }

    public void setSapTenderItemService(SapTenderItemService<SapTenderItem> sapTenderItemService) {
        this.sapTenderItemService = sapTenderItemService;
    }

    public SapTenderMasterService<SapTenderMaster> getSapTenderMasterService() {
        return sapTenderMasterService;
    }

    public void setSapTenderMasterService(SapTenderMasterService<SapTenderMaster> sapTenderMasterService) {
        this.sapTenderMasterService = sapTenderMasterService;
    }

    public SapVendorEmailService<SapVendorEmail> getSapVendorEmailService() {
        return sapVendorEmailService;
    }

    public void setSapVendorEmailService(SapVendorEmailService<SapVendorEmail> sapVendorEmailService) {
        this.sapVendorEmailService = sapVendorEmailService;
    }

    public SapVendorTelephoneService<SapVendorTelephone> getSapVendorTelephoneService() {
        return sapVendorTelephoneService;
    }

    public void setSapVendorTelephoneService(SapVendorTelephoneService<SapVendorTelephone> sapVendorTelephoneService) {
        this.sapVendorTelephoneService = sapVendorTelephoneService;
    }

    public SapVendorMasterService<SapVendorMaster> getSapVendorMasterService() {
        return sapVendorMasterService;
    }

    public void setSapVendorMasterService(SapVendorMasterService<SapVendorMaster> sapVendorMasterService) {
        this.sapVendorMasterService = sapVendorMasterService;
    }

    public TenderGeneralDocService<TenderGeneralDoc> getTenderGeneralDocService() {
        return tenderGeneralDocService;
    }

    public void setTenderGeneralDocService(TenderGeneralDocService<TenderGeneralDoc> tenderGeneralDocService) {
        this.tenderGeneralDocService = tenderGeneralDocService;
    }

    public TenderAdditionalDocService<TenderAdditionalDoc> getTenderAdditionalDocService() {
        return tenderAdditionalDocService;
    }

    public void setTenderAdditionalDocService(TenderAdditionalDocService<TenderAdditionalDoc> tenderAdditionalDocService) {
        this.tenderAdditionalDocService = tenderAdditionalDocService;
    }

    public TenderTechnicalDocService<TenderTechnicalDoc> getTenderTechnicalDocService() {
        return tenderTechnicalDocService;
    }

    public void setTenderTechnicalDocService(TenderTechnicalDocService<TenderTechnicalDoc> tenderTechnicalDocService) {
        this.tenderTechnicalDocService = tenderTechnicalDocService;
    }

    public TenderPreQualificationService<TenderPreQualification> getTenderPreQualificationService() {
        return tenderPreQualificationService;
    }

    public void setTenderPreQualificationService(TenderPreQualificationService<TenderPreQualification> tenderPreQualificationService) {
        this.tenderPreQualificationService = tenderPreQualificationService;
    }

    public TenderTechnicalService<TenderTechnical> getTenderTechnicalService() {
        return tenderTechnicalService;
    }

    public void setTenderTechnicalService(TenderTechnicalService<TenderTechnical> tenderTechnicalService) {
        this.tenderTechnicalService = tenderTechnicalService;
    }

    public TenderVendorDocService<TenderVendorDoc> getTenderVendorDocService() {
        return tenderVendorDocService;
    }

    public void setTenderVendorDocService(TenderVendorDocService<TenderVendorDoc> tenderVendorDocService) {
        this.tenderVendorDocService = tenderVendorDocService;
    }

    public TenderItemMasterService<TenderItemMaster> getTenderItemMasterService() {
        return tenderItemMasterService;
    }

    public void setTenderItemMasterService(TenderItemMasterService<TenderItemMaster> tenderItemMasterService) {
        this.tenderItemMasterService = tenderItemMasterService;
    }

    public TenderItemAttachmentService<TenderItemAttachment> getTenderItemAttachmentService() {
        return tenderItemAttachmentService;
    }

    public void setTenderItemAttachmentService(TenderItemAttachmentService<TenderItemAttachment> tenderItemAttachmentService) {
        this.tenderItemAttachmentService = tenderItemAttachmentService;
    }

    public TenderVendorService<TenderVendor> getTenderVendorService() {
        return tenderVendorService;
    }

    public void setTenderVendorService(TenderVendorService<TenderVendor> tenderVendorService) {
        this.tenderVendorService = tenderVendorService;
    }

    public VendorPreBidAttachmentService<VendorPreBidAttachment> getVendorPreBidAttachmentService() {
        return vendorPreBidAttachmentService;
    }

    public void setVendorPreBidAttachmentService(VendorPreBidAttachmentService<VendorPreBidAttachment> vendorPreBidAttachmentService) {
        this.vendorPreBidAttachmentService = vendorPreBidAttachmentService;
    }

    public VendorPreBidService<VendorPreBid> getVendorPreBidService() {
        return vendorPreBidService;
    }

    public void setVendorPreBidService(VendorPreBidService<VendorPreBid> vendorPreBidService) {
        this.vendorPreBidService = vendorPreBidService;
    }

    public VendorAttachmentService<VendorAttachment> getVendorAttachmentService() {
        return vendorAttachmentService;
    }

    public void setVendorAttachmentService(VendorAttachmentService<VendorAttachment> vendorAttachmentService) {
        this.vendorAttachmentService = vendorAttachmentService;
    }

    public VendorEmdService<VendorEmd> getVendorEmdService() {
        return vendorEmdService;
    }

    public void setVendorEmdService(VendorEmdService<VendorEmd> vendorEmdService) {
        this.vendorEmdService = vendorEmdService;
    }

    public VendorFeeService<VendorFee> getVendorFeeService() {
        return vendorFeeService;
    }

    public void setVendorFeeService(VendorFeeService<VendorFee> vendorFeeService) {
        this.vendorFeeService = vendorFeeService;
    }

    public VendorTechnicalBidService<VendorTechnicalBid> getVendorTechnicalBidService() {
        return vendorTechnicalBidService;
    }

    public void setVendorTechnicalBidService(VendorTechnicalBidService<VendorTechnicalBid> vendorTechnicalBidService) {
        this.vendorTechnicalBidService = vendorTechnicalBidService;
    }

    public VendorTechnicalBidAttachmentService<VendorTechnicalBidAttachment> getVendorTechnicalBidAttachmentService() {
        return vendorTechnicalBidAttachmentService;
    }

    public void setVendorTechnicalBidAttachmentService(VendorTechnicalBidAttachmentService<VendorTechnicalBidAttachment> vendorTechnicalBidAttachmentService) {
        this.vendorTechnicalBidAttachmentService = vendorTechnicalBidAttachmentService;
    }

    public VendorTechnicalBidTechService<VendorTechnicalBidTech> getVendorTechnicalBidTechService() {
        return vendorTechnicalBidTechService;
    }

    public void setVendorTechnicalBidTechService(VendorTechnicalBidTechService<VendorTechnicalBidTech> vendorTechnicalBidTechService) {
        this.vendorTechnicalBidTechService = vendorTechnicalBidTechService;
    }

    public VendorTechnicalBidTermsService<VendorTechnicalBidTerms> getVendorTechnicalBidTermsService() {
        return vendorTechnicalBidTermsService;
    }

    public void setVendorTechnicalBidTermsService(VendorTechnicalBidTermsService<VendorTechnicalBidTerms> vendorTechnicalBidTermsService) {
        this.vendorTechnicalBidTermsService = vendorTechnicalBidTermsService;
    }

    public VendorTechnicalBidTechAttachmentService<VendorTechnicalBidTechAttachment> getVendorTechnicalBidTechAttachmentService() {
        return vendorTechnicalBidTechAttachmentService;
    }

    public void setVendorTechnicalBidTechAttachmentService(VendorTechnicalBidTechAttachmentService<VendorTechnicalBidTechAttachment> vendorTechnicalBidTechAttachmentService) {
        this.vendorTechnicalBidTechAttachmentService = vendorTechnicalBidTechAttachmentService;
    }

    public VendorTechnicalBidTermsAttachmentService<VendorTechnicalBidTermsAttachment> getVendorTechnicalBidTermsAttachmentService() {
        return vendorTechnicalBidTermsAttachmentService;
    }

    public void setVendorTechnicalBidTermsAttachmentService(VendorTechnicalBidTermsAttachmentService<VendorTechnicalBidTermsAttachment> vendorTechnicalBidTermsAttachmentService) {
        this.vendorTechnicalBidTermsAttachmentService = vendorTechnicalBidTermsAttachmentService;
    }

    public VendorTenderBidService<VendorTenderBid> getVendorTenderBidService() {
        return vendorTenderBidService;
    }

    public void setVendorTenderBidService(VendorTenderBidService<VendorTenderBid> vendorTenderBidService) {
        this.vendorTenderBidService = vendorTenderBidService;
    }

    public VendorTenderBidItemService<VendorTenderBidItem> getVendorTenderBidItemService() {
        return vendorTenderBidItemService;
    }

    public void setVendorTenderBidItemService(VendorTenderBidItemService<VendorTenderBidItem> vendorTenderBidItemService) {
        this.vendorTenderBidItemService = vendorTenderBidItemService;
    }

    public AuthTenderMasterService<AuthTenderMaster> getAuthTenderMasterService() {
        return authTenderMasterService;
    }

    public void setAuthTenderMasterService(AuthTenderMasterService<AuthTenderMaster> authTenderMasterService) {
        this.authTenderMasterService = authTenderMasterService;
    }

    public AuthTenderGeneralDocService<AuthTenderGeneralDoc> getAuthTenderGeneralDocService() {
        return authTenderGeneralDocService;
    }

    public void setAuthTenderGeneralDocService(AuthTenderGeneralDocService<AuthTenderGeneralDoc> authTenderGeneralDocService) {
        this.authTenderGeneralDocService = authTenderGeneralDocService;
    }

    public AuthTenderAdditionalDocService<AuthTenderAdditionalDoc> getAuthTenderAdditionalDocService() {
        return authTenderAdditionalDocService;
    }

    public void setAuthTenderAdditionalDocService(AuthTenderAdditionalDocService<AuthTenderAdditionalDoc> authTenderAdditionalDocService) {
        this.authTenderAdditionalDocService = authTenderAdditionalDocService;
    }

    public AuthTenderTechnicalDocService<AuthTenderTechnicalDoc> getAuthTenderTechnicalDocService() {
        return authTenderTechnicalDocService;
    }

    public void setAuthTenderTechnicalDocService(AuthTenderTechnicalDocService<AuthTenderTechnicalDoc> authTenderTechnicalDocService) {
        this.authTenderTechnicalDocService = authTenderTechnicalDocService;
    }

    public AuthTenderPreQualificationService<AuthTenderPreQualification> getAuthTenderPreQualificationService() {
        return authTenderPreQualificationService;
    }

    public void setAuthTenderPreQualificationService(AuthTenderPreQualificationService<AuthTenderPreQualification> authTenderPreQualificationService) {
        this.authTenderPreQualificationService = authTenderPreQualificationService;
    }

    public AuthTenderTechnicalService<AuthTenderTechnical> getAuthTenderTechnicalService() {
        return authTenderTechnicalService;
    }

    public void setAuthTenderTechnicalService(AuthTenderTechnicalService<AuthTenderTechnical> authTenderTechnicalService) {
        this.authTenderTechnicalService = authTenderTechnicalService;
    }

    public AuthTenderVendorDocService<AuthTenderVendorDoc> getAuthTenderVendorDocService() {
        return authTenderVendorDocService;
    }

    public void setAuthTenderVendorDocService(AuthTenderVendorDocService<AuthTenderVendorDoc> authTenderVendorDocService) {
        this.authTenderVendorDocService = authTenderVendorDocService;
    }

    public AuthTenderItemMasterService<AuthTenderItemMaster> getAuthTenderItemMasterService() {
        return authTenderItemMasterService;
    }

    public void setAuthTenderItemMasterService(AuthTenderItemMasterService<AuthTenderItemMaster> authTenderItemMasterService) {
        this.authTenderItemMasterService = authTenderItemMasterService;
    }

    public AuthTenderItemAttachmentService<AuthTenderItemAttachment> getAuthTenderItemAttachmentService() {
        return authTenderItemAttachmentService;
    }

    public void setAuthTenderItemAttachmentService(AuthTenderItemAttachmentService<AuthTenderItemAttachment> authTenderItemAttachmentService) {
        this.authTenderItemAttachmentService = authTenderItemAttachmentService;
    }

    public AuthTenderVendorService<AuthTenderVendor> getAuthTenderVendorService() {
        return authTenderVendorService;
    }

    public void setAuthTenderVendorService(AuthTenderVendorService<AuthTenderVendor> authTenderVendorService) {
        this.authTenderVendorService = authTenderVendorService;
    }

    public TenderRegretService<TenderRegret> getTenderRegretService() {
        return tenderRegretService;
    }

    public void setTenderRegretService(TenderRegretService<TenderRegret> tenderRegretService) {
        this.tenderRegretService = tenderRegretService;
    }

    public TenderNoTempService<TenderNoTemp> getTenderNoTempService() {
        return tenderNoTempService;
    }

    public void setTenderNoTempService(TenderNoTempService<TenderNoTemp> tenderNoTempService) {
        this.tenderNoTempService = tenderNoTempService;
    }

    public TenderNoService<TenderNo> getTenderNoService() {
        return tenderNoService;
    }

    public void setTenderNoService(TenderNoService<TenderNo> tenderNoService) {
        this.tenderNoService = tenderNoService;
    }

    public FileDetailService<FileDetail> getFileDetailService() {
        return fileDetailService;
    }

    public void setFileDetailService(FileDetailService<FileDetail> fileDetailService) {
        this.fileDetailService = fileDetailService;
    }

    public ServiceDetail1Service<ServiceDetail1> getServiceDetail1Service() {
        return serviceDetail1Service;
    }

    public void setServiceDetail1Service(ServiceDetail1Service<ServiceDetail1> serviceDetail1Service) {
        this.serviceDetail1Service = serviceDetail1Service;
    }

    public ServiceDetail2Service<ServiceDetail2> getServiceDetail2Service() {
        return serviceDetail2Service;
    }

    public void setServiceDetail2Service(ServiceDetail2Service<ServiceDetail2> serviceDetail2Service) {
        this.serviceDetail2Service = serviceDetail2Service;
    }

    public ServiceDetail3Service<ServiceDetail3> getServiceDetail3Service() {
        return serviceDetail3Service;
    }

    public void setServiceDetail3Service(ServiceDetail3Service<ServiceDetail3> serviceDetail3Service) {
        this.serviceDetail3Service = serviceDetail3Service;
    }

    public ServiceDetail4Service<ServiceDetail4> getServiceDetail4Service() {
        return serviceDetail4Service;
    }

    public void setServiceDetail4Service(ServiceDetail4Service<ServiceDetail4> serviceDetail4Service) {
        this.serviceDetail4Service = serviceDetail4Service;
    }

    public ServiceDetail5Service<ServiceDetail5> getServiceDetail5Service() {
        return serviceDetail5Service;
    }

    public void setServiceDetail5Service(ServiceDetail5Service<ServiceDetail5> serviceDetail5Service) {
        this.serviceDetail5Service = serviceDetail5Service;
    }

    public ServiceDetail6Service<ServiceDetail6> getServiceDetail6Service() {
        return serviceDetail6Service;
    }

    public void setServiceDetail6Service(ServiceDetail6Service<ServiceDetail6> serviceDetail6Service) {
        this.serviceDetail6Service = serviceDetail6Service;
    }

    public ServiceVendorTenderBidService<ServiceVendorTenderBid> getServiceVendorTenderBidService() {
        return serviceVendorTenderBidService;
    }

    public void setServiceVendorTenderBidService(ServiceVendorTenderBidService<ServiceVendorTenderBid> serviceVendorTenderBidService) {
        this.serviceVendorTenderBidService = serviceVendorTenderBidService;
    }

    public ServiceVendorTenderBidItemService<ServiceVendorTenderBidItem> getServiceVendorTenderBidItemService() {
        return serviceVendorTenderBidItemService;
    }

    public void setServiceVendorTenderBidItemService(ServiceVendorTenderBidItemService<ServiceVendorTenderBidItem> serviceVendorTenderBidItemService) {
        this.serviceVendorTenderBidItemService = serviceVendorTenderBidItemService;
    }

    public ServiceVendorTenderBidItem2Service<ServiceVendorTenderBidItem2> getServiceVendorTenderBidItem2Service() {
        return serviceVendorTenderBidItem2Service;
    }

    public void setServiceVendorTenderBidItem2Service(ServiceVendorTenderBidItem2Service<ServiceVendorTenderBidItem2> serviceVendorTenderBidItem2Service) {
        this.serviceVendorTenderBidItem2Service = serviceVendorTenderBidItem2Service;
    }

    public ServiceVendorTenderBidItem3Service<ServiceVendorTenderBidItem3> getServiceVendorTenderBidItem3Service() {
        return serviceVendorTenderBidItem3Service;
    }

    public void setServiceVendorTenderBidItem3Service(ServiceVendorTenderBidItem3Service<ServiceVendorTenderBidItem3> serviceVendorTenderBidItem3Service) {
        this.serviceVendorTenderBidItem3Service = serviceVendorTenderBidItem3Service;
    }

    public ServiceVendorTenderBidItem4Service<ServiceVendorTenderBidItem4> getServiceVendorTenderBidItem4Service() {
        return serviceVendorTenderBidItem4Service;
    }

    public void setServiceVendorTenderBidItem4Service(ServiceVendorTenderBidItem4Service<ServiceVendorTenderBidItem4> serviceVendorTenderBidItem4Service) {
        this.serviceVendorTenderBidItem4Service = serviceVendorTenderBidItem4Service;
    }

    public ServiceVendorTenderBidItem6Service<ServiceVendorTenderBidItem6> getServiceVendorTenderBidItem6Service() {
        return serviceVendorTenderBidItem6Service;
    }

    public void setServiceVendorTenderBidItem6Service(ServiceVendorTenderBidItem6Service<ServiceVendorTenderBidItem6> serviceVendorTenderBidItem6Service) {
        this.serviceVendorTenderBidItem6Service = serviceVendorTenderBidItem6Service;
    }

    public TenderSendEmailService<TenderSendEmail> getTenderSendEmailService() {
        return tenderSendEmailService;
    }

    public void setTenderSendEmailService(TenderSendEmailService<TenderSendEmail> tenderSendEmailService) {
        this.tenderSendEmailService = tenderSendEmailService;
    }

    public EmailTemplateService<EmailTemplate> getEmailTemplateService() {
        return emailTemplateService;
    }

    public void setEmailTemplateService(EmailTemplateService<EmailTemplate> emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }

    public LiveTenderService<LiveTender> getLiveTenderService() {
        return liveTenderService;
    }

    public void setLiveTenderService(LiveTenderService<LiveTender> liveTenderService) {
        this.liveTenderService = liveTenderService;
    }

    public VendorInfoService<VendorInfo> getVendorInfoService() {
        return vendorInfoService;
    }

    public void setVendorInfoService(VendorInfoService<VendorInfo> vendorInfoService) {
        this.vendorInfoService = vendorInfoService;
    }

    public TenderFollowupService<TenderFollowup> getTenderFollowupService() {
        return tenderFollowupService;
    }

    public void setTenderFollowupService(TenderFollowupService<TenderFollowup> tenderFollowupService) {
        this.tenderFollowupService = tenderFollowupService;
    }

    public CommMasterService<CommMaster> getCommMasterService() {
        return commMasterService;
    }

    public void setCommMasterService(CommMasterService<CommMaster> commMasterService) {
        this.commMasterService = commMasterService;
    }

    public CommMasterAttachmentService<CommMasterAttachment> getCommMasterAttachmentService() {
        return commMasterAttachmentService;
    }

    public void setCommMasterAttachmentService(CommMasterAttachmentService<CommMasterAttachment> commMasterAttachmentService) {
        this.commMasterAttachmentService = commMasterAttachmentService;
    }

    public ServiceRightsService<ServiceRights> getServiceRightsService() {
        return serviceRightsService;
    }

    public void setServiceRightsService(ServiceRightsService<ServiceRights> serviceRightsService) {
        this.serviceRightsService = serviceRightsService;
    }

    public AuctionMasterService<AuctionMaster> getAuctionMasterService() {
        return auctionMasterService;
    }

    public void setAuctionMasterService(AuctionMasterService<AuctionMaster> auctionMasterService) {
        this.auctionMasterService = auctionMasterService;
    }

    public AuctionItemMasterService<AuctionItemMaster> getAuctionItemMasterService() {
        return auctionItemMasterService;
    }

    public void setAuctionItemMasterService(AuctionItemMasterService<AuctionItemMaster> auctionItemMasterService) {
        this.auctionItemMasterService = auctionItemMasterService;
    }

    public AuctionVendorService<AuctionVendor> getAuctionVendorService() {
        return auctionVendorService;
    }

    public void setAuctionVendorService(AuctionVendorService<AuctionVendor> auctionVendorService) {
        this.auctionVendorService = auctionVendorService;
    }

    public AuctionItemVendorService<AuctionItemVendor> getAuctionItemVendorService() {
        return auctionItemVendorService;
    }

    ///--AuctionItemVendor--///
    public void setAuctionItemVendorService(AuctionItemVendorService<AuctionItemVendor> auctionItemVendorService) {
        this.auctionItemVendorService = auctionItemVendorService;
    }

    public AuctionItemVendorBidService<AuctionItemVendorBid> getAuctionItemVendorBidService() {
        return auctionItemVendorBidService;
    }

    public void setAuctionItemVendorBidService(AuctionItemVendorBidService<AuctionItemVendorBid> auctionItemVendorBidService) {
        this.auctionItemVendorBidService = auctionItemVendorBidService;
    }

    public AuctionItemVendorBidHistoryService<AuctionItemVendorBidHistory> getAuctionItemVendorBidHistoryService() {
        return auctionItemVendorBidHistoryService;
    }

    public void setAuctionItemVendorBidHistoryService(AuctionItemVendorBidHistoryService<AuctionItemVendorBidHistory> auctionItemVendorBidHistoryService) {
        this.auctionItemVendorBidHistoryService = auctionItemVendorBidHistoryService;
    }

    public AuctionAttachmentService<AuctionAttachment> getAuctionAttachmentService() {
        return auctionAttachmentService;
    }

    public void setAuctionAttachmentService(AuctionAttachmentService<AuctionAttachment> auctionAttachmentService) {
        this.auctionAttachmentService = auctionAttachmentService;
    }

    public AuctionNoTempService<AuctionNoTemp> getAuctionNoTempService() {
        return auctionNoTempService;
    }

    public void setAuctionNoTempService(AuctionNoTempService<AuctionNoTemp> auctionNoTempService) {
        this.auctionNoTempService = auctionNoTempService;
    }

    public AuctionNoService<AuctionNo> getAuctionNoService() {
        return auctionNoService;
    }

    public void setAuctionNoService(AuctionNoService<AuctionNo> auctionNoService) {
        this.auctionNoService = auctionNoService;
    }

    public AuctionVendorBidService<AuctionVendorBid> getAuctionVendorBidService() {
        return auctionVendorBidService;
    }

    public void setAuctionVendorBidService(AuctionVendorBidService<AuctionVendorBid> auctionVendorBidService) {
        this.auctionVendorBidService = auctionVendorBidService;
    }

    public AuctionVendorBidHistoryService<AuctionVendorBidHistory> getAuctionVendorBidHistoryService() {
        return auctionVendorBidHistoryService;
    }

    public void setAuctionVendorBidHistoryService(AuctionVendorBidHistoryService<AuctionVendorBidHistory> auctionVendorBidHistoryService) {
        this.auctionVendorBidHistoryService = auctionVendorBidHistoryService;
    }

    public TenderCommitteeService<TenderCommittee> getTenderCommitteeService() {
        return tenderCommitteeService;
    }

    public void setTenderCommitteeService(TenderCommitteeService<TenderCommittee> tenderCommitteeService) {
        this.tenderCommitteeService = tenderCommitteeService;
    }

    public ReviseVendorTenderBidService<ReviseVendorTenderBid> getReviseVendorTenderBidService() {
        return reviseVendorTenderBidService;
    }

    public void setReviseVendorTenderBidService(ReviseVendorTenderBidService<ReviseVendorTenderBid> reviseVendorTenderBidService) {
        this.reviseVendorTenderBidService = reviseVendorTenderBidService;
    }

    public ReviseVendorTenderBidItemService<ReviseVendorTenderBidItem> getReviseVendorTenderBidItemService() {
        return reviseVendorTenderBidItemService;
    }

    public void setReviseVendorTenderBidItemService(ReviseVendorTenderBidItemService<ReviseVendorTenderBidItem> reviseVendorTenderBidItemService) {
        this.reviseVendorTenderBidItemService = reviseVendorTenderBidItemService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public PlantMasterService<PlantMaster> getPlantMasterService() {
        return plantMasterService;
    }

    public void setPlantMasterService(PlantMasterService<PlantMaster> plantMasterService) {
        this.plantMasterService = plantMasterService;
    }

    public SapConnectionService<SapConnection> getSapConnectionService() {
        return sapConnectionService;
    }

    public void setSapConnectionService(SapConnectionService<SapConnection> sapConnectionService) {
        this.sapConnectionService = sapConnectionService;
    }

    public SmtpDetailsService<SmtpDetails> getSmtpDetailsService() {
        return smtpDetailsService;
    }

    public void setSmtpDetailsService(SmtpDetailsService<SmtpDetails> smtpDetailsService) {
        this.smtpDetailsService = smtpDetailsService;
    }

    public TenderPriceApprovalService<TenderPriceApproval> getTenderPriceApprovalService() {
        return tenderPriceApprovalService;
    }

    public void setTenderPriceApprovalService(TenderPriceApprovalService<TenderPriceApproval> tenderPriceApprovalService) {
        this.tenderPriceApprovalService = tenderPriceApprovalService;
    }

    public TenderPriceApprovalUserService<TenderPriceApprovalUser> getTenderPriceApprovalUserService() {
        return tenderPriceApprovalUserService;
    }

    public void setTenderPriceApprovalUserService(TenderPriceApprovalUserService<TenderPriceApprovalUser> tenderPriceApprovalUserService) {
        this.tenderPriceApprovalUserService = tenderPriceApprovalUserService;
    }

    public TenderPriceApprovalCommentService<TenderPriceApprovalComment> getTenderPriceApprovalCommentService() {
        return tenderPriceApprovalCommentService;
    }

    public void setTenderPriceApprovalCommentService(TenderPriceApprovalCommentService<TenderPriceApprovalComment> tenderPriceApprovalCommentService) {
        this.tenderPriceApprovalCommentService = tenderPriceApprovalCommentService;
    }

    public TenderApprovalSettingService<TenderApprovalSetting> getTenderApprovalSettingService() {
        return tenderApprovalSettingService;
    }

    public void setTenderApprovalSettingService(TenderApprovalSettingService<TenderApprovalSetting> tenderApprovalSettingService) {
        this.tenderApprovalSettingService = tenderApprovalSettingService;
    }

    public TenderApprovalUserService<TenderApprovalUser> getTenderApprovalUserService() {
        return tenderApprovalUserService;
    }

    public void setTenderApprovalUserService(TenderApprovalUserService<TenderApprovalUser> tenderApprovalUserService) {
        this.tenderApprovalUserService = tenderApprovalUserService;
    }

    public CommitteeApprovalSettingService<CommitteeApprovalSetting> getCommitteeApprovalSettingService() {
        return committeeApprovalSettingService;
    }

    public void setCommitteeApprovalSettingService(CommitteeApprovalSettingService<CommitteeApprovalSetting> committeeApprovalSettingService) {
        this.committeeApprovalSettingService = committeeApprovalSettingService;
    }

    public CommitteeApprovalUserService<CommitteeApprovalUser> getCommitteeApprovalUserService() {
        return committeeApprovalUserService;
    }

    public void setCommitteeApprovalUserService(CommitteeApprovalUserService<CommitteeApprovalUser> committeeApprovalUserService) {
        this.committeeApprovalUserService = committeeApprovalUserService;
    }

    public CompanyLocationService<CompanyLocation> getCompanyLocationService() {
        return companyLocationService;
    }

    public void setCompanyLocationService(CompanyLocationService<CompanyLocation> companyLocationService) {
        this.companyLocationService = companyLocationService;
    }

    public DepartmentMasterService<DepartmentMaster> getDepartmentMasterService() {
        return departmentMasterService;
    }

    public void setDepartmentMasterService(DepartmentMasterService<DepartmentMaster> departmentMasterService) {
        this.departmentMasterService = departmentMasterService;
    }

    public DesignationMasterService<DesignationMaster> getDesignationMasterService() {
        return designationMasterService;
    }

    public void setDesignationMasterService(DesignationMasterService<DesignationMaster> designationMasterService) {
        this.designationMasterService = designationMasterService;
    }

    public AuctionPriceApprovalCommentService<AuctionPriceApprovalComment> getAuctionPriceApprovalCommentService() {
        return auctionPriceApprovalCommentService;
    }

    public void setAuctionPriceApprovalCommentService(AuctionPriceApprovalCommentService<AuctionPriceApprovalComment> auctionPriceApprovalCommentService) {
        this.auctionPriceApprovalCommentService = auctionPriceApprovalCommentService;
    }

    public AuctionPriceApprovalService<AuctionPriceApproval> getAuctionPriceApprovalService() {
        return auctionPriceApprovalService;
    }

    public void setAuctionPriceApprovalService(AuctionPriceApprovalService<AuctionPriceApproval> auctionPriceApprovalService) {
        this.auctionPriceApprovalService = auctionPriceApprovalService;
    }

    public AuctionPriceApprovalUserService<AuctionPriceApprovalUser> getAuctionPriceApprovalUserService() {
        return auctionPriceApprovalUserService;
    }

    public void setAuctionPriceApprovalUserService(AuctionPriceApprovalUserService<AuctionPriceApprovalUser> auctionPriceApprovalUserService) {
        this.auctionPriceApprovalUserService = auctionPriceApprovalUserService;
    }

    public ReviseVendorTechnicalBidService<ReviseVendorTechnicalBid> getReviseVendorTechnicalBidService() {
        return reviseVendorTechnicalBidService;
    }

    public void setReviseVendorTechnicalBidService(ReviseVendorTechnicalBidService<ReviseVendorTechnicalBid> reviseVendorTechnicalBidService) {
        this.reviseVendorTechnicalBidService = reviseVendorTechnicalBidService;
    }

    public VendorCustomerRefrenceService<VendorCustomerRefrence> getVendorCustomerRefrenceService() {
        return vendorCustomerRefrenceService;
    }

    public void setVendorCustomerRefrenceService(VendorCustomerRefrenceService<VendorCustomerRefrence> vendorCustomerRefrenceService) {
        this.vendorCustomerRefrenceService = vendorCustomerRefrenceService;
    }

    public MaterialTypeMasterService<MaterialTypeMaster> getMaterialTypeMasterService() {
        return materialTypeMasterService;
    }

    public void setMaterialTypeMasterService(MaterialTypeMasterService<MaterialTypeMaster> materialTypeMasterService) {
        this.materialTypeMasterService = materialTypeMasterService;
    }

    public MaterialGroupMasterService<MaterialGroupMaster> getMaterialGroupMasterService() {
        return materialGroupMasterService;
    }

    public void setMaterialGroupMasterService(MaterialGroupMasterService<MaterialGroupMaster> materialGroupMasterService) {
        this.materialGroupMasterService = materialGroupMasterService;
    }

    public MaterialMasterService<MaterialMaster> getMaterialMasterService() {
        return materialMasterService;
    }

    public void setMaterialMasterService(MaterialMasterService<MaterialMaster> materialMasterService) {
        this.materialMasterService = materialMasterService;
    }

    public PRNoService<PRNo> getPrNoService() {
        return prNoService;
    }

    public void setPrNoService(PRNoService<PRNo> prNoService) {
        this.prNoService = prNoService;
    }

    public PRNoTempService<PRNoTemp> getPrNoTempService() {
        return prNoTempService;
    }

    public void setPrNoTempService(PRNoTempService<PRNoTemp> prNoTempService) {
        this.prNoTempService = prNoTempService;
    }

    public PRVendorService<PRVendor> getPrVendorService() {
        return prVendorService;
    }

    public void setPrVendorService(PRVendorService<PRVendor> prVendorService) {
        this.prVendorService = prVendorService;
    }

    public PRItemMasterService<PRItemMaster> getPrItemMasterService() {
        return prItemMasterService;
    }

    public void setPrItemMasterService(PRItemMasterService<PRItemMaster> prItemMasterService) {
        this.prItemMasterService = prItemMasterService;
    }

    public PRPriceApprovalService<PRPriceApproval> getPrPriceApprovalService() {
        return prPriceApprovalService;
    }

    public void setPrPriceApprovalService(PRPriceApprovalService<PRPriceApproval> prPriceApprovalService) {
        this.prPriceApprovalService = prPriceApprovalService;
    }

    public PRPriceApprovalCommentService<PRPriceApprovalComment> getPrPriceApprovalCommentService() {
        return prPriceApprovalCommentService;
    }

    public void setPrPriceApprovalCommentService(PRPriceApprovalCommentService<PRPriceApprovalComment> prPriceApprovalCommentService) {
        this.prPriceApprovalCommentService = prPriceApprovalCommentService;
    }

    public PRPriceApprovalUserService<PRPriceApprovalUser> getPrPriceApprovalUserService() {
        return prPriceApprovalUserService;
    }

    public void setPrPriceApprovalUserService(PRPriceApprovalUserService<PRPriceApprovalUser> prPriceApprovalUserService) {
        this.prPriceApprovalUserService = prPriceApprovalUserService;
    }

    public PRMasterService<PRMaster> getPrMasterService() {
        return prMasterService;
    }

    public void setPrMasterService(PRMasterService<PRMaster> prMasterService) {
        this.prMasterService = prMasterService;
    }

    public PRDocService<PRDoc> getPrDocService() {
        return prDocService;
    }

    public void setPrDocService(PRDocService<PRDoc> prDocService) {
        this.prDocService = prDocService;
    }

    public PRClassificationService<PRClassification> getPrClassificationService() {
        return prClassificationService;
    }

    public void setPrClassificationService(PRClassificationService<PRClassification> prClassificationService) {
        this.prClassificationService = prClassificationService;
    }

    public PRBusinessTypeService<PRBusinessType> getPrBusinessTypeService() {
        return prBusinessTypeService;
    }

    public void setPrBusinessTypeService(PRBusinessTypeService<PRBusinessType> prBusinessTypeService) {
        this.prBusinessTypeService = prBusinessTypeService;
    }

    public PRProjectTypeService<PRProjectType> getPrProjectTypeService() {
        return prProjectTypeService;
    }

    public void setPrProjectTypeService(PRProjectTypeService<PRProjectType> prProjectTypeService) {
        this.prProjectTypeService = prProjectTypeService;
    }

    public PRApprovalCommentService<PRApprovalComment> getPrApprovalCommentService() {
        return prApprovalCommentService;
    }

    public void setPrApprovalCommentService(PRApprovalCommentService<PRApprovalComment> prApprovalCommentService) {
        this.prApprovalCommentService = prApprovalCommentService;
    }

    @Override
    protected void bind(HttpServletRequest request, Object command)
            throws Exception {
        ServletRequestDataBinder binder = createBinder(request, command);
        binder.bind(request);
    }
    public static String encpass;

    public String encription(String pass) {

        try {
            MessageDigest algorithm = null;

            for (int loop = 0; loop < 10; loop++) {
                if (loop % 3 == 0) {
                    algorithm = MessageDigest.getInstance("SHA");
                } else {
                    algorithm = MessageDigest.getInstance("md5");
                }
                algorithm.reset();
                byte[] defaultBytes = pass.getBytes();
                algorithm.update(defaultBytes);
                byte messageDigest[] = algorithm.digest();

                StringBuffer hexString = new StringBuffer();
                for (int ij = 0; ij < messageDigest.length; ij++) {
                    hexString.append(Integer.toHexString(0xFF & messageDigest[ij]));
                }
                String foo = messageDigest.toString();
                pass = hexString.toString();
                encpass = pass;

            }

        }///END OF TRY
        catch (NoSuchAlgorithmException nsae) {
            System.out.println("ERROR!");
        }

        return encpass;
    }

    public void readCoupon(HttpServletRequest request, HttpServletResponse response) {
        List list = couponService.read();
        HashSet<String> couponType = new HashSet<>();
        Map<Integer, String> map = new HashMap<>();
        for (Object o : list) {
            CouponMaster cm = (CouponMaster) o;
            couponType.add(cm.getCouponType());
            map.put(cm.getSrNo(), cm.getCouponType());
        }
        request.setAttribute("couponType", couponType);
        request.setAttribute("couponMap", map);
    }

    public void readDesignation(HttpServletRequest request, HttpServletResponse response) {
        List list = employeeMasterService.read();
        HashSet<String> designationType = new HashSet<>();
        for (Object o : list) {
            EmployeeMaster em = (EmployeeMaster) o;
            designationType.add(em.getDesignation());
        }
        request.setAttribute("designationType", designationType);
    }

    public void readRights(HttpServletRequest request, HttpServletResponse response) {
        List list = rightService.read();
        HashSet<String> rightsType = new HashSet<>();
        for (Object o : list) {
            RightMaster cm = (RightMaster) o;
            rightsType.add(cm.getRightName());
        }
        request.setAttribute("rightsType", rightsType);
    }

    public void deviceNameIpRead(HttpServletRequest request) {
        List list = deviceService.read();
        Map<Integer, String> deviceList = new HashMap<>();
        for (Object o : list) {
            DeviceDetails dd = (DeviceDetails) o;
            deviceList.put(dd.getId(), dd.getDeviceDescription() + " - " + dd.getDeviceIP());
        }
        request.setAttribute("deviceList", deviceList);
    }

    public void readEmployee(HttpServletRequest request, HttpServletResponse response) {
        List list = employeeMasterService.read();
        HashSet<String> employee = new HashSet<>();
        for (Object o : list) {
            EmployeeMaster em = (EmployeeMaster) o;
            employee.add(em.getEmployeeCode());
        }
        request.setAttribute("employee", employee);
    }

    public boolean isValidSubmission(VendorInformation v, VendorSelfDeclaration vs) {

        boolean validSubmission
                = notEmpty(v.getCompanyName())
                && notEmpty(v.getPolicy1File())
                && notEmpty(v.getNdaPolicyFile())
                && notEmpty(v.getEstablishment())
                && notEmpty(v.getTypeOfConcern())
                && notEmpty(v.getCompanyProof())
                && notEmpty(v.getOfficeAddressLine1())
                && notEmpty(v.getOfficeAddressLine2())
                && notEmpty(v.getOfficePin())
                && notEmpty(v.getOfficeCity())
                && notEmpty(v.getOfficeDistrict())
                && notEmpty(v.getOfficeState())
                && notEmpty(v.getOfficeCountry())
                && notEmpty(v.getOfficeTelephone())
                && notEmpty(v.getOfficeEmail())
                && notEmpty(v.getSales_name())
                && notEmpty(v.getSales_job())
                && notEmpty(v.getSales_phone())
                && notEmpty(v.getSaleEmail())
                && notEmpty(v.getTechnical_name())
                && notEmpty(v.getTechnical_job())
                && notEmpty(v.getTechnical_phone())
                && notEmpty(v.getTechnicalContactEmail())
                && notEmpty(v.getQuality_name())
                && notEmpty(v.getQuality_job())
                && notEmpty(v.getQuality_phone())
                && notEmpty(v.getQualityEmail())
                && notEmpty(v.getGstinNo())
                && notEmpty(v.getGstinFile())
                && notEmpty(v.getPanNo())
                && notEmpty(v.getPanFile())
                && notEmpty(v.getAccountNumber())
                && notEmpty(v.getBankName())
                && notEmpty(v.getBranch())
                && notEmpty(v.getIfscCode())
                && notEmpty(v.getCancelCheck())
                && notEmpty(v.getFinical1())
                && notEmpty(v.getFinicalAmount1())
                && notEmpty(v.getFinicalAttachment1())
                && notEmpty(v.getFinical2())
                && notEmpty(v.getFinicalAmount2())
                && notEmpty(v.getFinicalAttachment2())
                && notEmpty(v.getFinical3())
                && notEmpty(v.getFinicalAmount3())
                && notEmpty(v.getFinicalAttachment3())
                && notEmpty(v.getService_file())
                && notEmpty(v.getEsicFile())
                && notEmpty(v.getPfAttachment())
                && notEmpty(vs.getAltLocalAddress())
                && notEmpty(vs.getAltLocalAddress1())
                && notEmpty(vs.getAltPostalCode())
                && notEmpty(vs.getAltCity())
                && notEmpty(vs.getAltDistrict())
                && notEmpty(vs.getAltCountry())
                && notEmpty(vs.getAltState())
                && notEmpty(vs.getAltTelephone())
                && notEmpty(vs.getAltEmail())
                && vs.getDesDecOneFlag() != 2
                && vs.getDesDecTwoFlag() != 2
                && vs.getLitigationHistoryDesFlag() != 2
                && vs.getPoliticalContributionDesFlag() != 2
                && vs.getConflictInsterestDesFlag() != 2
                && vs.getExecutiveJudicialDesFlag() != 2
                && vs.getPoliticallyExposedDesOneFlag() != 2
                && vs.getPoliticallyExposedDesTwoFlag() != 2
                && vs.getPoliticallyExposedDesThreeFlag() != 2
                && vs.getNatureServicesOneFlag() != 2
                && vs.getNatureServicesTwoFlag() != 2
                && vs.getNdaOneFlag() != 2
                && vs.getNdaTwoFlag() != 2;
        System.out.println("Validation Result : " + validSubmission);
        return validSubmission;
    }

    private boolean notEmpty(String value) {
        System.out.println(value);
        return value != null && !value.trim().isEmpty();
    }

}

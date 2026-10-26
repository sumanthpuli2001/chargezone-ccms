/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.model.VendorInvitation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class VendorInformationDaoImpl<T> extends GenericsDAOImpl<T> implements VendorInformationDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorInformation.class;
    }

    @Override
    public void updateterms(String vendorEmailId, String termsFile) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.termsConditionFile='" + termsFile + "', a.policyAccept='1', a.termsConditionAccept='1', "
                + " a.status1=0 "
                + " WHERE a.vendorEmailId = '" + vendorEmailId + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void updatepolicy(String vendorEmailId, String policyFile1, String policyFile2) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.policy1File='" + policyFile1 + "',a.policy2File='" + policyFile2 + "', a.policyAccept='1', a.termsConditionAccept='1', "
                + " a.status1=0 "
                + " WHERE a.vendorEmailId = '" + vendorEmailId + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void updateone(String email, String typeOfConcern, String officeAddressLine1, String officeAddressLine2, String officeAddressLine3, String officeCity, String officeDistrict, String officeState, String officePin, String officeCountry, String officeTelephone, String officeMobile, String officeFax, String officeEmail, String officeWebsite, String officeWeeklyHoliday, String officeContactPersonName, String officeContactDesignation, String officeContactMobile, String officeContactEmail, String workAddressLine1, String workAddressLine2, String workAddressLine3, String workCity, String workState, String workPin, String workCountry, String workTelephone, String workMobile, String workFax, String workEmail, String workWebsite, String workWeeklyHoliday, String workContactPersonName, String workContactDesignation, String workContactMobile, String workContactEmail, String good, String service, String contract, String traders, String establishment, String sales_name, String sales_job, String sales_phone, String technical_name, String technical_job, String technical_phone, String quality_name, String quality_job, String quality_phone, String panNo, String panFile, String gstinNo, String gstinFile, String cst_no, String cst_file, String vat_pin, String vat_file, String ecc_no, String ecc_file, String service_tax, String service_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String serviceType, String update, String secoundMobile, String cancelcheck, String saleEmail, String technicalContactEmail, String qualityEmail, String pfNo, String cicNo, String pfAttachment, String cicAttachment, String finical1, String finical2, String finical3, String finicalAttachment1, String finicalAttachment2, String finicalAttachment3, String finicalAmount1, String finicalAmount2, String finicalAmount3, String groupDetailsName, String bpGroup) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.typeOfConcern='" + typeOfConcern + "', a.officeAddressLine1='" + officeAddressLine1 + "', a.officeAddressLine2='" + officeAddressLine2 + "', a.officeAddressLine3='" + officeAddressLine3 + "', "
                + "   a.officePin='" + officePin + "', a.secoundMobile='" + secoundMobile + "',  a.cancelCheck='" + cancelcheck + "', "
                + "  a.officeTelephone='" + officeTelephone + "', a.officeMobile='" + officeMobile + "', a.officeEmail='" + officeEmail + "', "
                + " a.officeFax='" + officeFax + "',  a.officeWebsite='" + officeWebsite + "', a.pfNo='" + pfNo + "', a.cicNo='" + cicNo + "', a.pfAttachment='" + pfAttachment + "', a.cicAttachment='" + cicAttachment + "', a.finical1='" + finical1 + "', a.finical2='" + finical2 + "', a.finical3='" + finical3 + "', a.finicalAttachment1='" + finicalAttachment1 + "', a.finicalAttachment2='" + finicalAttachment2 + "', a.finicalAttachment3='" + finicalAttachment3 + "', a.finicalAmount1='" + finicalAmount1 + "',  a.finicalAmount2='" + finicalAmount2 + "',  a.finicalAmount3='" + finicalAmount3 + "', a.vendorTypes='" + groupDetailsName + "', a.bpGroup='" + bpGroup + "',"
                + " a.good='" + good + "', a.service='" + service + "', a.contract='" + contract + "',a.general_traders='" + traders + "',a.establishment='" + establishment + "',"
                + " a.sales_name='" + sales_name + "',a.sales_job='" + sales_job + "', a.sales_phone='" + sales_phone + "', a.technical_name='" + technical_name + "', a.technical_job='" + technical_job + "',"
                + " a.technical_phone='" + technical_phone + "', a.quality_name='" + quality_name + "', a.quality_job='" + quality_job + "', a.quality_phone='" + quality_phone + "',"
                + " a.panNo='" + panNo + "', a.panFile='" + panFile + "',a.gstinNo='" + gstinNo + "',a.gstinFile='" + gstinFile + "',a.cst_no='" + cst_no + "', a.cst_file='" + cst_file + "', a.vat_pin='" + vat_pin + "', a.vat_file='" + vat_file + "', a.officeCountry='" + officeCountry + "', a.officeState='" + officeState + "', a.officeCity='" + officeCity + "', a.officeDistrict='" + officeDistrict + "', a.saleEmail='" + saleEmail + "',a.technicalContactEmail='" + technicalContactEmail + "', a.qualityEmail='" + qualityEmail + "', "
                + " a.ecc_no='" + ecc_no + "', a.ecc_file='" + ecc_file + "', a.service_tax='" + service_tax + "', a.service_file='" + service_file + "',"
                + " a.accountNumber='" + accountNumber + "', a.bankName='" + bankName + "', a.branch='" + branch + "', a.ifscCode='" + ifscCode + "', a.swiftCode='" + swiftCode + "', a.electricalService='" + serviceType + "',a.itApprovalFlag=0, a.finacialFlag=0, a.technicalFlag=0, a.hrApprovalFlag=0, a.safteyApprovalFlag= 0 "
                + "WHERE a.vendorEmailId = '" + email + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void updatetwo(String email, String productService, String panNo, String panFile, String gstinNo, String gstinFile, String typeOfGst, String productWiseCapacity, String developmentCapabilities, String machineryTechnology, String materialHandling, String firstYear, String firstYearFile, String secondYear, String secondYearFile, String thirdYear, String thirdYearFile, String balanceSheet, String balanceSheetFile, String msmeCertificate, String msmeCertificateFile, String cst_no, String cst_file, String vat_pin, String vat_file, String ecc_no, String ecc_file, String service_tax, String service_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String chequeFile) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.productService='" + productService + "', a.panNo='" + panNo + "', a.panFile='" + panFile + "', a.gstinNo='" + gstinNo + "', "
                + " a.gstinFile='" + gstinFile + "', a.typeOfGst='" + typeOfGst + "', a.productWiseCapacity='" + productWiseCapacity + "', "
                + " a.developmentCapabilities='" + developmentCapabilities + "', a.machineryTechnology='" + machineryTechnology + "', "
                + " a.materialHandling='" + materialHandling + "', a.firstYear='" + firstYear + "', a.firstYearFile='" + firstYearFile + "', "
                + " a.secondYear='" + secondYear + "', a.secondYearFile='" + secondYearFile + "', a.thirdYear='" + thirdYear + "', "
                + " a.thirdYearFile='" + thirdYearFile + "', a.balanceSheet='" + balanceSheet + "', a.balanceSheetFile='" + balanceSheetFile + "', "
                + " a.msmeCertificate='" + msmeCertificate + "', a.msmeCertificateFile='" + msmeCertificateFile + "' ,"
                + "a.cst_no='" + cst_no + "', a.cst_file='" + cst_file + "', a.vat_pin='" + vat_pin + "', a.vat_file='" + vat_file + "',"
                + " a.ecc_no='" + ecc_no + "', a.ecc_file='" + ecc_file + "', a.service_tax='" + service_tax + "', a.service_file='" + service_file + "',"
                + " a.accountNumber='" + accountNumber + "', a.bankName='" + bankName + "', a.branch='" + branch + "', a.ifscCode='" + ifscCode + "', a.swiftCode='" + swiftCode + "',  a.chequeFile='" + chequeFile + "'"
                + " WHERE a.vendorEmailId = '" + email + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void updatethree(String vendorEmailId, String majorCustomers, String customerRatings, String workCompletionCertificates, String totalStaff, String skilledWorkers, String unskilledWorkers, String sexRatio, String suspensionOfWork, String organizationOfQa, String environment, String sustainability, String fairLabourStandardFile, String businessContinuity) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.majorCustomers='" + majorCustomers + "', a.customerRatings='" + customerRatings + "', a.workCompletionCertificates='" + workCompletionCertificates + "', "
                + " a.totalStaff='" + totalStaff + "', a.skilledWorkers='" + skilledWorkers + "', a.unskilledWorkers='" + unskilledWorkers + "', "
                + " a.sexRatio='" + sexRatio + "', a.suspensionOfWork='" + suspensionOfWork + "', "
                + " a.organizationOfQa='" + organizationOfQa + "', a.environment='" + environment + "', a.sustainability='" + sustainability + "', "
                + " a.fairLabourStandardFile='" + fairLabourStandardFile + "', a.businessContinuity='" + businessContinuity + "' "
                + " WHERE a.vendorEmailId = '" + vendorEmailId + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void updatefour(String vendorEmailId, String inspectionFacilities, String inspectionProcedure, String changeManagementProcess, String sustainabilityInitiativesFile, String carbonFootprint, String irReportFile, String circularEconomyFile, String greenProductFile, String greenCompanyFile, String lifeCycleAnalysisFile, String awareAboutSafety, String incidentsDuringWork, String incidentsDetails, String additionalInformation, String informationFurnishedByFile, String chequeFile, String customerRemark) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.inspectionFacilities='" + inspectionFacilities + "', a.inspectionProcedure='" + inspectionProcedure + "', a.changeManagementProcess='" + changeManagementProcess + "', "
                + " a.sustainabilityInitiativesFile='" + sustainabilityInitiativesFile + "', a.carbonFootprint='" + carbonFootprint + "', a.irReportFile='" + irReportFile + "', "
                + " a.circularEconomyFile='" + circularEconomyFile + "', a.greenProductFile='" + greenProductFile + "', a.chequeFile='" + chequeFile + "',a.customerRemark='" + customerRemark + "', "
                + " a.greenCompanyFile='" + greenCompanyFile + "', a.lifeCycleAnalysisFile='" + lifeCycleAnalysisFile + "', a.awareAboutSafety='" + awareAboutSafety + "', "
                + " a.incidentsDuringWork='" + incidentsDuringWork + "', a.incidentsDetails='" + incidentsDetails + "', a.additionalInformation='" + additionalInformation + "', "
                + " a.informationFurnishedByFile='" + informationFurnishedByFile + "' "
                + " WHERE a.vendorEmailId = '" + vendorEmailId + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void approveone(String id, String codeOfSupplier, String typeOfSupplier, String workingOfSupplier, String accountingGroup, String incoTerm, String materialGroup, String materialSubGroup) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.codeOfSupplier='" + codeOfSupplier + "', a.typeOfSupplier='" + typeOfSupplier + "', a.workingOfSupplier='" + workingOfSupplier + "', "
                + " a.accountingGroup='" + accountingGroup + "', a.incoTerm='" + incoTerm + "', a.materialGroup='" + materialGroup + "',"
                + " a.materialSubGroup='" + materialSubGroup + "', a.status1=2 "
                + " WHERE a.id = " + id + "";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void approvetwo(String id) {

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);

        String query = "";
        query += " update VendorInformation a"
                + " set a.status1=3, a.approveDate='" + formattedDate + "' "
                + " WHERE a.id = " + id + "";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void changeStatus(String id, int status1) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.status1=" + status1 + " "
                + " WHERE a.id = " + id + "";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public VendorInformation readEmailId(String email) {

        VendorInformation vendorInformation = new VendorInformation();
        String query = "";
        query += " FROM VendorInformation a"
                + " WHERE a.vendorEmailId = '" + email + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorInformation = (VendorInformation) list.get(0);
        }
        return vendorInformation;

    }

    @Override
    public VendorInformation readID(int id) {

        VendorInformation vendorInformation = new VendorInformation();
        String query = "";
        query += " FROM VendorInformation a"
                + " WHERE a.id = '" + id + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorInformation = (VendorInformation) list.get(0);
        }
        return vendorInformation;

    }

    @Override
    public List readEmail(String email) {
        String query = "";
        query += " FROM VendorInformation a"
                + " WHERE a.vendorEmailId = '" + email + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readId(int id) {
        String query = "";
        query += " FROM VendorInformation a"
                + " WHERE a.id = '" + id + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updatefinal(String vendorEmailId, String vendorFile, String policyFile, String termsFile) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.vendorFile = '" + vendorFile + "', "
                + " a.policyFile = '" + policyFile + "', "
                + " a.termsConditionFile = '" + termsFile + "', "
                + " a.status1=1 "
                + " WHERE a.vendorEmailId = '" + vendorEmailId + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List readApproveOneVendor() {
        String query = "";
        query += " FROM VendorInformation a"
                + " WHERE a.status1 != 0 ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readApproveTwoVendor() {
        String query = "";
        query += " FROM VendorInformation a"
                + " WHERE a.status1=2";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List searchVendor(String startDate, String endDate, String companyname, String emailid) {
        String query = "";
        query += " FROM VendorInformation a"
                + " WHERE a.vendorEmailId like '" + emailid + "%' and  a.companyName like '" + companyname + "%' and a.status1=3";

//        String query = " Select distinct a.name,a.code ,a.id"
//                + " from ReportMaster a "
//                + " where a.id='" + type + "'"
//                + " where a.code='" + empcode + "'"
//                + " and (STR_TO_DATE(a.tdate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))"
//                + " " + Condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updatefive(String vendorEmailId, String manufacturer, String dealer, String traders, String materialSupply, String dealingServices, String esicNo, String capabilities1, String specificProducts, String qualityManagement, String qualityIso, String qualityApi, String qualityIs, String qualityOthers, String environmentManagement, String indianChemical) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.manufacturer='" + manufacturer + "', a.dealer='" + dealer + "', a.traders='" + traders + "', a.materialSupply='" + materialSupply + "', "
                + " a.dealingServices='" + dealingServices + "', a.esicNo='" + esicNo + "', a.capabilities1='" + capabilities1 + "', "
                + " a.specificProducts='" + specificProducts + "', a.qualityManagement='" + qualityManagement + "', a.qualityIso='" + qualityIso + "',"
                + " a.qualityApi='" + qualityApi + "', a.qualityIs='" + qualityIs + "', a.qualityOthers='" + qualityOthers + "', a.environmentManagement='" + environmentManagement + "',"
                + " a.indianChemical='" + indianChemical + "'"
                + " WHERE a.vendorEmailId = '" + vendorEmailId + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readyByElectric() {
        String query = "";
        query += " FROM VendorInformation a"
                + " WHERE a.electricalService='electrical'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByuser(String name) {

        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.status1,a.approvalOne,a.finacialApproval,a.finacialFlag "
                + "FROM VendorInformation a"
                + " WHERE (a.status1=" + 2
                + " or a.status1 =" + 1
                + " or a.status1 =" + 3
                + " or a.status1=" + 500
                + " or a.status1=" + 10
                + " )And a.finacialApproval = '" + name + "'"
                + " order by a.id desc ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByuser1(String name) {

        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.status1,a.approvalOne,a.technicalApproval,a.technicalFlag "
                + " FROM VendorInformation a"
                + " WHERE (a.status1=" + 2
                + " or a.status1 =" + 1
                + " or a.status1 =" + 500
                + " or a.status1 =" + 3
                + " or a.status1=" + 10
                + " )And a.technicalApproval = '" + name + "' "
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByHrVendor(String name) {
        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.status1,a.approvalOne,a.hrApproval,a.hrApprovalFlag "
                + "FROM VendorInformation a"
                + " WHERE (a.status1=" + 2
                + " or a.status1 =" + 1
                + " or a.status1 =" + 3
                + " or a.status1=" + 500
                + " or a.status1=" + 10
                + " )And a.hrApproval = '" + name + "' "
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readBySafteyVendor(String name) {
        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.status1,a.approvalOne,a.safetyApproval,a.safteyApprovalFlag "
                + " FROM VendorInformation a"
                + " WHERE (a.status1=" + 2
                + " or a.status1 =" + 1
                + " or a.status1 =" + 3
                + " or a.status1 =" + 500
                + " or a.status1=" + 10
                + " )And a.safetyApproval = '" + name + "' "
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByItVendor(String name) {
        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.status1,a.approvalOne,a.itApproval,a.itApprovalFlag "
                + "FROM VendorInformation a"
                + " WHERE (a.status1=" + 2
                + " or a.status1 =" + 1
                + " or a.status1 =" + 3
                + " or a.status1=" + 500
                + " or a.status1=" + 10
                + " )And a.itApproval = '" + name + "' "
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public void changeFinicalStatus(String id, int status) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.finacialFlag=" + status + " "
                + " WHERE a.id = " + id + "";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateone1(String vendorEmailId, String typeOfConcern, String officeAddressLine1, String officeAddressLine2, String officeAddressLine3, String officeCity, String officeState, String officePin, String officeCountry, String officeTelephone, String officeMobile, String officeFax, String officeEmail, String officeWebsite, String officeWeeklyHoliday, String officeContactPersonName, String officeContactDesignation, String officeContactMobile, String officeContactEmail, String workAddressLine1, String workAddressLine2, String workAddressLine3, String workCity, String workState, String workPin, String workCountry, String workTelephone, String workMobile, String workFax, String workEmail, String workWebsite, String workWeeklyHoliday, String workContactPersonName, String workContactDesignation, String workContactMobile, String workContactEmail, String good, String service, String contract, String traders, String establishment, String sales_name, String sales_job, String sales_phone, String technical_name, String technical_job, String technical_phone, String quality_name, String quality_job, String quality_phone, String panNo, String panFile, String gstinNo, String gstinFile, String cst_no, String cst_file, String vat_pin, String vat_file, String ecc_no, String ecc_file, String service_tax, String service_file, String accountNumber, String bankName, String branch, String ifscCode, String swiftCode, String serviceType, String update, String secoundMobile, String cancelcheck, String saleEmail, String technicalContactEmail, String qualityEmail, String pfNo, String cicNo, String pfAttachment, String cicAttachment, String finical1, String finical2, String finical3, String finicalAttachment1, String finicalAttachment2, String finicalAttachment3, String finicalAmount1, String finicalAmount2, String finicalAmount3, String groupDetailsName, String bpGroup) {
        String query = "";
        query += " update VendorInformation a"
                + " set a.typeOfConcern='" + typeOfConcern + "', a.officeAddressLine1='" + officeAddressLine1 + "', a.officeAddressLine2='" + officeAddressLine2 + "', a.officeAddressLine3='" + officeAddressLine3 + "', "
                + "   a.officePin='" + officePin + "', a.secoundMobile='" + secoundMobile + "',  a.cancelCheck='" + cancelcheck + "', "
                + "  a.officeTelephone='" + officeTelephone + "', a.officeMobile='" + officeMobile + "', "
                + " a.officeFax='" + officeFax + "',  a.officeWebsite='" + officeWebsite + "', a.pfNo='" + pfNo + "', a.cicNo='" + cicNo + "', a.pfAttachment='" + pfAttachment + "', a.cicAttachment='" + cicAttachment + "', a.finical1='" + finical1 + "', a.finical2='" + finical2 + "', a.finical3='" + finical3 + "', a.finicalAttachment1='" + finicalAttachment1 + "', a.finicalAttachment2='" + finicalAttachment2 + "', a.finicalAttachment3='" + finicalAttachment3 + "', a.finicalAmount1='" + finicalAmount1 + "',  a.finicalAmount2='" + finicalAmount2 + "',  a.finicalAmount3='" + finicalAmount3 + "', a.vendorTypes='" + groupDetailsName + "', a.bpGroup='" + bpGroup + "',"
                + " a.good='" + good + "', a.service='" + service + "', a.contract='" + contract + "',a.general_traders='" + traders + "',a.establishment='" + establishment + "',"
                + " a.sales_name='" + sales_name + "',a.sales_job='" + sales_job + "', a.sales_phone='" + sales_phone + "', a.technical_name='" + technical_name + "', a.technical_job='" + technical_job + "',"
                + " a.technical_phone='" + technical_phone + "', a.quality_name='" + quality_name + "', a.quality_job='" + quality_job + "', a.quality_phone='" + quality_phone + "',"
                + " a.panNo='" + panNo + "', a.panFile='" + panFile + "',a.gstinNo='" + gstinNo + "',a.gstinFile='" + gstinFile + "',a.cst_no='" + cst_no + "', a.cst_file='" + cst_file + "', a.vat_pin='" + vat_pin + "', a.vat_file='" + vat_file + "', a.officeCountry='" + officeCountry + "', a.officeState='" + officeState + "', a.officeCity='" + officeCity + "', a.saleEmail='" + saleEmail + "',a.technicalContactEmail='" + technicalContactEmail + "', a.qualityEmail='" + qualityEmail + "', "
                + " a.ecc_no='" + ecc_no + "', a.ecc_file='" + ecc_file + "', a.service_tax='" + service_tax + "', a.service_file='" + service_file + "',"
                + " a.accountNumber='" + accountNumber + "', a.bankName='" + bankName + "', a.branch='" + branch + "', a.ifscCode='" + ifscCode + "', a.swiftCode='" + swiftCode + "', a.electricalService='" + serviceType + "'"
                + "WHERE a.vendorEmailId = '" + vendorEmailId + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readApproveOneVendors(String user11) {
        String query = "";
        query += " SELECT a.id,a.companyName,a.vendorEmailId,a.status1,a.approvalOne,a.finacialFlag,a.vendorCommentForBuyer "
                + " FROM VendorInformation a"
                + " WHERE a.status1 not in (0) "
                + " and a.approvalOne= '" + user11 + "'"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readForAuditor(String name) {

        String query = "";
        query += " FROM VendorInformation a"
                + " WHERE a.status1 in (1,2,3,4,10,100,101)"
                + " And a.auditorName = '" + name + "' "
                + " order by a.id desc";
//                + " and a.safteyApprovalFlag=" +0;
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readForProcurementHead(String name) {

        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.status1,a.approvalOne"
                + " FROM VendorInformation a"
                + " WHERE a.status1 in (101,102,7,5,10,500,501,502)"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public int readBySapCode(String sapCode) {

        String query = "";
        query += "SELECT a FROM VendorInformation a "
                + "WHERE a.sapCode = '" + sapCode + "'";
        List list = getHibernateTemplate().find(query);

        return list.size();
    }

    @Override
    public List readByRecycleVendor() {
        String query = "";
        query += "FROM VendorInformation a "
                + " WHERE a.status1!=10";
        return getHibernateTemplate().find(query);
    }

    @Override
    public int readActiveVendorCount() {

        String query = "";
        query += "select COUNT(a.id) from VendorInformation a "
                + "WHERE a.status1 = 10";
        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int inprogressVendorCount() {

        String query = "";
        query += "select COUNT(a.id) from VendorInformation a "
                + "WHERE a.status1 = 0";
        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int rejectedVendorCount() {

        String query = "";
        query += "select COUNT(a.id) from VendorInformation a "
                + "WHERE a.status1 In (6,7,501)";
        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public List readActiveVendor() {
        String query = "";
        query += "select a.id,a.vendorEmailId,a.sapCode,a.finacialApproval,a.companyName,a.countryCodeoffTele,a.officeTelephone,a.vendorTypes,a.groupCategory,a.groupSubCategory,b.altCountry,b.altState,b.altCity,a.gstinNo,a.panNo,a.riskCategory,a.vendorInviteSource,a.approvalOne,a.vendorActivatedDate"
                + " FROM VendorInformation a,VendorSelfDeclaration b"
                + " WHERE a.status1=10 "
                + "And a.id = b.vendorInformationId "
                + " order by a.id desc ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getActiveVendorPagination(int start, int length, String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        String hql = "select a.id,a.vendorEmailId,a.sapCode,a.finacialApproval,a.companyName, "
                + " a.countryCodeoffTele,a.officeTelephone,a.vendorTypes,a.groupCategory,a.groupSubCategory, "
                + " b.altCountry,b.altState,b.altCity,a.gstinNo,a.panNo,a.riskCategory,a.vendorInviteSource, "
                + " a.approvalOne,a.vendorActivatedDate, a.vendorInvitationId "
                + " FROM VendorInformation a,VendorSelfDeclaration b "
                + " WHERE a.status1 = 10 "
                + " AND a.id = b.vendorInformationId ";

        if (vendorEmailIdFilter != null && !vendorEmailIdFilter.equals("")) {
            hql += " AND lower(a.vendorEmailId) LIKE :vendorEmailId ";
        }

        if (sapCodeFilter != null && !sapCodeFilter.equals("")) {
            hql += " AND lower(a.sapCode) LIKE :sapCode ";
        }

        if (companyNameFilter != null && !companyNameFilter.equals("")) {
            hql += " AND lower(a.companyName) LIKE :companyName ";
        }

        if (contactNoFilter != null && !contactNoFilter.equals("")) {
            hql += " AND lower(a.officeTelephone) LIKE :officeTelephone ";
        }

        if (groupNameFilter != null && !groupNameFilter.equals("")) {
            hql += " AND lower(a.vendorTypes) LIKE :vendorTypes ";
        }

        if (groupCategoryFilter != null && !groupCategoryFilter.equals("")) {
            hql += " AND lower(a.groupCategory) LIKE :groupCategory ";
        }

        if (groupSubCategoryFilter != null && !groupSubCategoryFilter.equals("")) {
            hql += " AND lower(a.groupSubCategory) LIKE :groupSubCategory ";
        }

        if (countryFilter != null && !countryFilter.equals("")) {
            hql += " AND lower(b.altCountry) LIKE :altCountry ";
        }

        if (stateFilter != null && !stateFilter.equals("")) {
            hql += " AND lower(b.altState) LIKE :altState ";
        }

        if (cityFilter != null && !cityFilter.equals("")) {
            hql += " AND lower(b.altCity) LIKE :altCity ";
        }

        if (gstNoFilter != null && !gstNoFilter.equals("")) {
            hql += " AND lower(a.gstinNo) LIKE :gstinNo ";
        }

        if (panNoFilter != null && !panNoFilter.equals("")) {
            hql += " AND lower(a.panNo) LIKE :panNo ";
        }

        if (riskCategoryFilter != null && !riskCategoryFilter.equals("")) {
            hql += " AND lower(a.riskCategory) LIKE :riskCategory ";
        }

        if (vendorInviteSourceFilter != null && !vendorInviteSourceFilter.equals("")) {
            hql += " AND lower(a.vendorInviteSource) LIKE :vendorInviteSource ";
        }

        if (invitedByFilter != null && !invitedByFilter.equals("")) {
            hql += " AND lower(a.approvalOne) LIKE :approvalOne ";
        }

        if (activatedDateFilter != null && !activatedDateFilter.equals("")) {
            hql += " AND lower(a.vendorActivatedDate) LIKE :vendorActivatedDate ";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(a.vendorEmailId) LIKE :searchValue "
                    + " OR lower(a.sapCode) LIKE :searchValue "
                    + " OR lower(a.companyName) LIKE :searchValue "
                    + " OR lower(a.countryCodeoffTele) LIKE :searchValue "
                    + " OR lower(a.officeTelephone) LIKE :searchValue "
                    + " OR lower(a.vendorTypes) LIKE :searchValue "
                    + " OR lower(a.groupCategory) LIKE :searchValue "
                    + " OR lower(a.groupSubCategory) LIKE :searchValue "
                    + " OR lower(b.altCountry) LIKE :searchValue "
                    + " OR lower(b.altState) LIKE :searchValue "
                    + " OR lower(b.altCity) LIKE :searchValue "
                    + " OR lower(a.gstinNo) LIKE :searchValue "
                    + " OR lower(a.panNo) LIKE :searchValue "
                    + " OR lower(a.riskCategory) LIKE :searchValue "
                    + " OR lower(a.vendorInviteSource) LIKE :searchValue "
                    + " OR lower(a.approvalOne) LIKE :searchValue "
                    + " OR lower(a.vendorActivatedDate) LIKE :searchValue "
                    + ")";
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
            orderDir = "desc";
        }

        hql += " ORDER BY " + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (vendorEmailIdFilter != null && !vendorEmailIdFilter.equals("")) {
            query.setParameter("vendorEmailId", "%" + vendorEmailIdFilter.toLowerCase() + "%");
        }

        if (sapCodeFilter != null && !sapCodeFilter.equals("")) {
            query.setParameter("sapCode", "%" + sapCodeFilter.toLowerCase() + "%");
        }

        if (companyNameFilter != null && !companyNameFilter.equals("")) {
            query.setParameter("companyName", "%" + companyNameFilter.toLowerCase() + "%");
        }

        if (contactNoFilter != null && !contactNoFilter.equals("")) {
            query.setParameter("officeTelephone", "%" + contactNoFilter.toLowerCase() + "%");
        }

        if (groupNameFilter != null && !groupNameFilter.equals("")) {
            query.setParameter("vendorTypes", "%" + groupNameFilter.toLowerCase() + "%");
        }

        if (groupCategoryFilter != null && !groupCategoryFilter.equals("")) {
            query.setParameter("groupCategory", "%" + groupCategoryFilter.toLowerCase() + "%");
        }

        if (groupSubCategoryFilter != null && !groupSubCategoryFilter.equals("")) {
            query.setParameter("groupSubCategory", "%" + groupSubCategoryFilter.toLowerCase() + "%");
        }

        if (countryFilter != null && !countryFilter.equals("")) {
            query.setParameter("altCountry", "%" + countryFilter.toLowerCase() + "%");
        }

        if (stateFilter != null && !stateFilter.equals("")) {
            query.setParameter("altState", "%" + stateFilter.toLowerCase() + "%");
        }

        if (cityFilter != null && !cityFilter.equals("")) {
            query.setParameter("altCity", "%" + cityFilter.toLowerCase() + "%");
        }

        if (gstNoFilter != null && !gstNoFilter.equals("")) {
            query.setParameter("gstinNo", "%" + gstNoFilter.toLowerCase() + "%");
        }

        if (panNoFilter != null && !panNoFilter.equals("")) {
            query.setParameter("panNo", "%" + panNoFilter.toLowerCase() + "%");
        }

        if (riskCategoryFilter != null && !riskCategoryFilter.equals("")) {
            query.setParameter("riskCategory", "%" + riskCategoryFilter.toLowerCase() + "%");
        }

        if (vendorInviteSourceFilter != null && !vendorInviteSourceFilter.equals("")) {
            query.setParameter("vendorInviteSource", "%" + vendorInviteSourceFilter.toLowerCase() + "%");
        }

        if (invitedByFilter != null && !invitedByFilter.equals("")) {
            query.setParameter("approvalOne", "%" + invitedByFilter.toLowerCase() + "%");
        }

        if (activatedDateFilter != null && !activatedDateFilter.equals("")) {
            query.setParameter("vendorActivatedDate", "%" + activatedDateFilter.toLowerCase() + "%");
        }

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int getActiveVendorCount() {
        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + "FROM VendorInformation a "
                    + "WHERE a.status1 = 10 ";

            Query query = session.createQuery(hql);

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();
    }

    @Override
    public int getFilteredActiveVendorCount(String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter) {

        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + " FROM VendorInformation a, VendorSelfDeclaration b "
                    + " WHERE a.status1 = 10 "
                    + " AND a.id = b.vendorInformationId ";

            if (vendorEmailIdFilter != null && !vendorEmailIdFilter.equals("")) {
                hql += " AND lower(a.vendorEmailId) LIKE :vendorEmailId ";
            }

            if (sapCodeFilter != null && !sapCodeFilter.equals("")) {
                hql += " AND lower(a.sapCode) LIKE :sapCode ";
            }

            if (companyNameFilter != null && !companyNameFilter.equals("")) {
                hql += " AND lower(a.companyName) LIKE :companyName ";
            }

            if (contactNoFilter != null && !contactNoFilter.equals("")) {
                hql += " AND lower(a.officeTelephone) LIKE :officeTelephone ";
            }

            if (groupNameFilter != null && !groupNameFilter.equals("")) {
                hql += " AND lower(a.vendorTypes) LIKE :vendorTypes ";
            }

            if (groupCategoryFilter != null && !groupCategoryFilter.equals("")) {
                hql += " AND lower(a.groupCategory) LIKE :groupCategory ";
            }

            if (groupSubCategoryFilter != null && !groupSubCategoryFilter.equals("")) {
                hql += " AND lower(a.groupSubCategory) LIKE :groupSubCategory ";
            }

            if (countryFilter != null && !countryFilter.equals("")) {
                hql += " AND lower(b.altCountry) LIKE :altCountry ";
            }

            if (stateFilter != null && !stateFilter.equals("")) {
                hql += " AND lower(b.altState) LIKE :altState ";
            }

            if (cityFilter != null && !cityFilter.equals("")) {
                hql += " AND lower(b.altCity) LIKE :altCity ";
            }

            if (gstNoFilter != null && !gstNoFilter.equals("")) {
                hql += " AND lower(a.gstinNo) LIKE :gstinNo ";
            }

            if (panNoFilter != null && !panNoFilter.equals("")) {
                hql += " AND lower(a.panNo) LIKE :panNo ";
            }

            if (riskCategoryFilter != null && !riskCategoryFilter.equals("")) {
                hql += " AND lower(a.riskCategory) LIKE :riskCategory ";
            }

            if (vendorInviteSourceFilter != null && !vendorInviteSourceFilter.equals("")) {
                hql += " AND lower(a.vendorInviteSource) LIKE :vendorInviteSource ";
            }

            if (invitedByFilter != null && !invitedByFilter.equals("")) {
                hql += " AND lower(a.approvalOne) LIKE :approvalOne ";
            }

            if (activatedDateFilter != null && !activatedDateFilter.equals("")) {
                hql += " AND lower(a.vendorActivatedDate) LIKE :vendorActivatedDate ";
            }

            if (searchValue != null && !searchValue.equals("")) {

                hql += " AND ("
                        + " lower(a.vendorEmailId) LIKE :searchValue "
                        + " OR lower(a.sapCode) LIKE :searchValue "
                        + " OR lower(a.companyName) LIKE :searchValue "
                        + " OR lower(a.countryCodeoffTele) LIKE :searchValue "
                        + " OR lower(a.officeTelephone) LIKE :searchValue "
                        + " OR lower(a.vendorTypes) LIKE :searchValue "
                        + " OR lower(a.groupCategory) LIKE :searchValue "
                        + " OR lower(a.groupSubCategory) LIKE :searchValue "
                        + " OR lower(b.altCountry) LIKE :searchValue "
                        + " OR lower(b.altState) LIKE :searchValue "
                        + " OR lower(b.altCity) LIKE :searchValue "
                        + " OR lower(a.gstinNo) LIKE :searchValue "
                        + " OR lower(a.panNo) LIKE :searchValue "
                        + " OR lower(a.riskCategory) LIKE :searchValue "
                        + " OR lower(a.vendorInviteSource) LIKE :searchValue "
                        + " OR lower(a.approvalOne) LIKE :searchValue "
                        + " OR lower(a.vendorActivatedDate) LIKE :searchValue "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (vendorEmailIdFilter != null && !vendorEmailIdFilter.equals("")) {
                query.setParameter("vendorEmailId", "%" + vendorEmailIdFilter.toLowerCase() + "%");
            }

            if (sapCodeFilter != null && !sapCodeFilter.equals("")) {
                query.setParameter("sapCode", "%" + sapCodeFilter.toLowerCase() + "%");
            }

            if (companyNameFilter != null && !companyNameFilter.equals("")) {
                query.setParameter("companyName", "%" + companyNameFilter.toLowerCase() + "%");
            }

            if (contactNoFilter != null && !contactNoFilter.equals("")) {
                query.setParameter("officeTelephone", "%" + contactNoFilter.toLowerCase() + "%");
            }

            if (groupNameFilter != null && !groupNameFilter.equals("")) {
                query.setParameter("vendorTypes", "%" + groupNameFilter.toLowerCase() + "%");
            }

            if (groupCategoryFilter != null && !groupCategoryFilter.equals("")) {
                query.setParameter("groupCategory", "%" + groupCategoryFilter.toLowerCase() + "%");
            }

            if (groupSubCategoryFilter != null && !groupSubCategoryFilter.equals("")) {
                query.setParameter("groupSubCategory", "%" + groupSubCategoryFilter.toLowerCase() + "%");
            }

            if (countryFilter != null && !countryFilter.equals("")) {
                query.setParameter("altCountry", "%" + countryFilter.toLowerCase() + "%");
            }

            if (stateFilter != null && !stateFilter.equals("")) {
                query.setParameter("altState", "%" + stateFilter.toLowerCase() + "%");
            }

            if (cityFilter != null && !cityFilter.equals("")) {
                query.setParameter("altCity", "%" + cityFilter.toLowerCase() + "%");
            }

            if (gstNoFilter != null && !gstNoFilter.equals("")) {
                query.setParameter("gstinNo", "%" + gstNoFilter.toLowerCase() + "%");
            }

            if (panNoFilter != null && !panNoFilter.equals("")) {
                query.setParameter("panNo", "%" + panNoFilter.toLowerCase() + "%");
            }

            if (riskCategoryFilter != null && !riskCategoryFilter.equals("")) {
                query.setParameter("riskCategory", "%" + riskCategoryFilter.toLowerCase() + "%");
            }

            if (vendorInviteSourceFilter != null && !vendorInviteSourceFilter.equals("")) {
                query.setParameter("vendorInviteSource", "%" + vendorInviteSourceFilter.toLowerCase() + "%");
            }

            if (invitedByFilter != null && !invitedByFilter.equals("")) {
                query.setParameter("approvalOne", "%" + invitedByFilter.toLowerCase() + "%");
            }

            if (activatedDateFilter != null && !activatedDateFilter.equals("")) {
                query.setParameter("vendorActivatedDate", "%" + activatedDateFilter.toLowerCase() + "%");
            }

            if (searchValue != null && !searchValue.equals("")) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();
    }

    @Override
    public List readAllVendor() {
        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.countryCodeoffTele,a.officeTelephone,a.status1,a.auditorName,a.approvalOne,"
                + "a.finacialApproval,a.finacialFlag,"
                + "a.technicalApproval,a.technicalFlag, "
                + "a.hrApproval,a.hrApprovalFlag, "
                + "a.safetyApproval,a.safteyApprovalFlag, "
                + "a.itApproval,a.itApprovalFlag,a.vendorInvitationId"
                + " FROM VendorInformation a"
                + " where 1=1";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readNewVendor() {
        String query = "";
        query += "SELECT "
                + "a.id,"
                + "a.companyName,"
                + "a.vendorEmailId,"
                + "a.vendorContactNo,"
                + "a.invitedBy "
                + "FROM VendorInvitation a "
                + "WHERE NOT EXISTS ( "
                + "SELECT 1 FROM VendorInformation b "
                + "WHERE b.vendorEmailId = a.vendorEmailId"
                + ")";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List getAllVendorPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT * FROM ( ");

            sql.append(" SELECT ");
            sql.append("     vi.id, ");
            sql.append("     vi.company_name AS companyName, ");
            sql.append("     vi.vendor_email_id AS vendorEmailId, ");
            sql.append("     vi.country_code_off_tele AS countryCodeoffTele, ");
            sql.append("     vi.office_telephone AS officeTelephone, ");
            sql.append("     vi.status1, ");
            sql.append("     vi.auditor_name AS auditorName, ");
            sql.append("     vi.approval_one AS approvalOne, ");
            sql.append("     vi.finacial_approval AS finacialApproval, ");
            sql.append("     vi.finacial_flag AS finacialFlag, ");
            sql.append("     vi.techincal_approval AS technicalApproval, ");
            sql.append("     vi.techincal_flag AS technicalFlag, ");
            sql.append("     vi.hr_approval AS hrApproval, ");
            sql.append("     vi.hr_approval_flag AS hrApprovalFlag, ");
            sql.append("     vi.saftey_approval AS safetyApproval, ");
            sql.append("     vi.safety_approval_flag AS safteyApprovalFlag, ");
            sql.append("     vi.it_approval AS itApproval, ");
            sql.append("     vi.it_approval_flag AS itApprovalFlag, ");
            sql.append("     vi.vendor_invitation_id AS vendorInvitationId, ");
            sql.append("     'REGISTERED' AS vendorType ");
            sql.append(" FROM vendor_information vi ");

            sql.append(" UNION ALL ");

            sql.append(" SELECT ");
            sql.append("     inv.id, ");
            sql.append("     inv.company_name AS companyName, ");
            sql.append("     inv.vendor_email_id AS vendorEmailId, ");
            sql.append("     '' AS countryCodeoffTele, ");
            sql.append("     inv.vendor_contact_no AS officeTelephone, ");
            sql.append("     '' AS status1, ");
            sql.append("     '' AS auditorName, ");
            sql.append("     '' AS approvalOne, ");
            sql.append("     '' AS finacialApproval, ");
            sql.append("     '' AS finacialFlag, ");
            sql.append("     '' AS technicalApproval, ");
            sql.append("     '' AS technicalFlag, ");
            sql.append("     '' AS hrApproval, ");
            sql.append("     '' AS hrApprovalFlag, ");
            sql.append("     '' AS safetyApproval, ");
            sql.append("     '' AS safteyApprovalFlag, ");
            sql.append("     '' AS itApproval, ");
            sql.append("     '' AS itApprovalFlag, ");
            sql.append("     inv.id AS vendorInvitationId, ");
            sql.append("     'INVITED' AS vendorType ");
            sql.append(" FROM vendor_invitation inv ");
            sql.append(" WHERE NOT EXISTS ( ");
            sql.append("     SELECT 1 ");
            sql.append("     FROM vendor_information vi ");
            sql.append("     WHERE vi.vendor_email_id = inv.vendor_email_id ");
            sql.append(" ) ");

            sql.append(" ) vendorData ");

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                sql.append(" WHERE ( ");
                sql.append(" LOWER(companyName) LIKE :search ");
                sql.append(" OR LOWER(vendorEmailId) LIKE :search ");
                sql.append(" OR LOWER(officeTelephone) LIKE :search ");
                sql.append(" OR LOWER(vendorType) LIKE :search ");
                sql.append(" ) ");
            }

            sql.append(" ORDER BY ").append(orderColumn).append(" ");

            if ("desc".equalsIgnoreCase(orderDir)) {
                sql.append(" DESC ");
            } else {
                sql.append(" ASC ");
            }

            Query query = session.createSQLQuery(sql.toString());

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase().trim() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            return query.list();

        } finally {
            session.close();
        }
    }

    @Override
    public int getAllVendorCount() {
        Session session = getSessionFactory().openSession();

        try {

            String sql
                    = " SELECT COUNT(*) FROM ( "
                    + " SELECT id "
                    + " FROM vendor_information "
                    + " UNION ALL "
                    + " SELECT inv.id "
                    + " FROM vendor_invitation inv "
                    + " WHERE NOT EXISTS ( "
                    + "     SELECT 1 "
                    + "     FROM vendor_information vi "
                    + "     WHERE vi.vendor_email_id = inv.vendor_email_id "
                    + " ) "
                    + " ) t ";

            Object result = session.createSQLQuery(sql).uniqueResult();

            return ((Number) result).intValue();

        } finally {
            session.close();
        }
    }

    @Override
    public int getFilteredAllVendorCount(String searchValue) {
        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT COUNT(*) FROM ( ");

            sql.append(" SELECT ");
            sql.append(" company_name AS companyName, ");
            sql.append(" vendor_email_id AS vendorEmailId, ");
            sql.append(" office_telephone AS officeTelephone ");
            sql.append(" FROM vendor_information ");

            sql.append(" UNION ALL ");

            sql.append(" SELECT ");
            sql.append(" company_name AS companyName, ");
            sql.append(" vendor_email_id AS vendorEmailId, ");
            sql.append(" vendor_contact_no AS officeTelephone ");
            sql.append(" FROM vendor_invitation inv ");
            sql.append(" WHERE NOT EXISTS ( ");
            sql.append("     SELECT 1 ");
            sql.append("     FROM vendor_information vi ");
            sql.append("     WHERE vi.vendor_email_id = inv.vendor_email_id ");
            sql.append(" ) ");

            sql.append(" ) x ");

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                sql.append(" WHERE ");
                sql.append(" LOWER(companyName) LIKE :search ");
                sql.append(" OR LOWER(vendorEmailId) LIKE :search ");
                sql.append(" OR LOWER(officeTelephone) LIKE :search ");
            }

            Query query = session.createSQLQuery(sql.toString());

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search",
                        "%" + searchValue.toLowerCase().trim() + "%");
            }

            Object result = query.uniqueResult();

            return ((Number) result).intValue();

        } finally {
            session.close();
        }
    }

    @Override
    public int invitedVendorCount(String userName) {

        String query = "";
        query += "select COUNT(a.id) from VendorInvitation a"
                + " WHERE a.invitedBy = '" + userName + "'";
        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int invitedVendorCountForAllVendorRight() {

        String query = "";
        query += "select COUNT(a.id) from VendorInvitation a"
                + " WHERE 1 = 1";
        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public List readInvitedVendor(String userName) {
        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.invitedBy,a.invitedDateTime"
                + " FROM VendorInvitation a "
                + "WHERE a.invitedBy = '" + userName + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List invitedVendorForAllVendorRight() {
        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.invitedBy,a.invitedDateTime"
                + " FROM VendorInvitation a "
                + "WHERE 1 = 1";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getInvitedVendorPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();

        String hql = "SELECT a.id, a.companyName, a.vendorEmailId, a.invitedBy, a.invitedDateTime"
                + " FROM VendorInvitation a "
                + "WHERE 1 = 1";

        if (userName != null && !userName.equals("")) {
            hql += " AND a.invitedBy = :userName ";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(a.vendorEmailId) LIKE :searchValue "
                    + " OR lower(a.companyName) LIKE :searchValue "
                    + " OR lower(a.invitedBy) LIKE :searchValue "
                    + " OR lower(a.invitedDateTime) LIKE :searchValue "
                    + ")";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        if (userName != null && !userName.equals("")) {
            query.setParameter("userName", userName);
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int getInvitedVendorCount(String userName) {
        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id)"
                + " FROM VendorInvitation a "
                + "WHERE 1 = 1";

        if (userName != null && !userName.equals("")) {
            hql += " AND a.invitedBy = :userName ";
        }

        Query query = session.createQuery(hql);

        if (userName != null && !userName.equals("")) {
            query.setParameter("userName", userName);
        }

        Long count = (Long) query.uniqueResult();
        return count.intValue();
    }

    @Override
    public int getFilteredInvitedVendorCount(String userName, String searchValue) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id)"
                + " FROM VendorInvitation a "
                + "WHERE 1 = 1";

        if (userName != null && !userName.equals("")) {
            hql += " AND a.invitedBy = :userName ";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(a.vendorEmailId) LIKE :searchValue "
                    + " OR lower(a.companyName) LIKE :searchValue "
                    + " OR lower(a.invitedBy) LIKE :searchValue "
                    + " OR lower(a.invitedDateTime) LIKE :searchValue "
                    + ")";
        }

        Query query = session.createQuery(hql);

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        if (userName != null && !userName.equals("")) {
            query.setParameter("userName", userName);
        }

        Long count = (Long) query.uniqueResult();
        return count.intValue();

    }

    @Override
    public List readInprogressVendor() {
        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId"
                + " FROM VendorInformation a"
                + " WHERE a.status1=0";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getInprogressVendorPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT a.id, a.companyName, a.vendorEmailId"
                + " FROM VendorInformation a"
                + " WHERE a.status1 = 0";

        if (userName != null && !userName.equals("")) {
            hql += " AND a.approvalOne = :userName ";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(a.vendorEmailId) LIKE :searchValue "
                    + " OR lower(a.companyName) LIKE :searchValue "
                    + ")";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        if (userName != null && !userName.equals("")) {
            query.setParameter("userName", userName);
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int getInprogressVendorCount(String userName) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id)"
                + " FROM VendorInformation a"
                + " WHERE a.status1 = 0";

        if (userName != null && !userName.equals("")) {
            hql += " AND a.approvalOne = :userName ";
        }

        Query query = session.createQuery(hql);

        if (userName != null && !userName.equals("")) {
            query.setParameter("userName", userName);
        }

        Long count = (Long) query.uniqueResult();
        return count.intValue();

    }

    @Override
    public int getFilteredInprogressVendorCount(String userName, String searchValue) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id)"
                + " FROM VendorInformation a"
                + " WHERE a.status1 = 0";

        if (userName != null && !userName.equals("")) {
            hql += " AND a.approvalOne = :userName ";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(a.vendorEmailId) LIKE :searchValue "
                    + " OR lower(a.companyName) LIKE :searchValue "
                    + ")";
        }

        Query query = session.createQuery(hql);

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        if (userName != null && !userName.equals("")) {
            query.setParameter("userName", userName);
        }

        Long count = (Long) query.uniqueResult();
        return count.intValue();

    }

    @Override
    public List readRejectVendor() {
        String query = "";
        query += " select a.id,a.companyName,a.vendorEmailId,a.status1 "
                + " FROM VendorInformation a"
                + " WHERE a.status1 in (6,7,501)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getRejectVendorPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        String hql = " select a.id, a.companyName, a.vendorEmailId, a.status1 "
                + " FROM VendorInformation a"
                + " WHERE a.status1 in (6,7,501)";

        if (userName != null && !userName.equals("")) {
            hql += " AND a.approvalOne = :userName ";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(a.vendorEmailId) LIKE :searchValue "
                    + " OR lower(a.companyName) LIKE :searchValue "
                    + " OR lower(a.status1) LIKE :searchValue "
                    + ")";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        if (userName != null && !userName.equals("")) {
            query.setParameter("userName", userName);
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int getRejectVendorCount(String userName) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id)"
                + " FROM VendorInformation a"
                + " WHERE a.status1 in (6,7,501)";

        if (userName != null && !userName.equals("")) {
            hql += " AND a.approvalOne = :userName ";
        }

        Query query = session.createQuery(hql);

        if (userName != null && !userName.equals("")) {
            query.setParameter("userName", userName);
        }

        Long count = (Long) query.uniqueResult();
        return count.intValue();

    }

    @Override
    public int getFilteredRejectVendorCount(String userName, String searchValue) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id)"
                + " FROM VendorInformation a"
                + " WHERE a.status1 in (6,7,501)";

        if (userName != null && !userName.equals("")) {
            hql += " AND a.approvalOne = :userName ";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(a.vendorEmailId) LIKE :searchValue "
                    + " OR lower(a.companyName) LIKE :searchValue "
                    + " OR lower(a.status1) LIKE :searchValue "
                    + ")";
        }

        Query query = session.createQuery(hql);

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        if (userName != null && !userName.equals("")) {
            query.setParameter("userName", userName);
        }

        Long count = (Long) query.uniqueResult();
        return count.intValue();

    }

    @Override
    public List getBlockVendorPagination(int start, int length, String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        String hql = "select a.id,a.vendorEmailId,a.sapCode,a.finacialApproval,a.companyName, "
                + " a.countryCodeoffTele,a.officeTelephone,a.vendorTypes,a.groupCategory, "
                + " a.groupSubCategory,b.altCountry,b.altState,b.altCity,a.gstinNo,a.panNo, "
                + " a.riskCategory,a.vendorInviteSource,a.approvalOne,a.vendorActivatedDate, a.vendorInvitationId "
                + " FROM VendorInformation a,VendorSelfDeclaration b "
                + " WHERE a.status1 = 700 "
                + " AND a.id = b.vendorInformationId ";

        if (vendorEmailIdFilter != null && !vendorEmailIdFilter.equals("")) {
            hql += " AND lower(a.vendorEmailId) LIKE :vendorEmailId ";
        }

        if (sapCodeFilter != null && !sapCodeFilter.equals("")) {
            hql += " AND lower(a.sapCode) LIKE :sapCode ";
        }

        if (companyNameFilter != null && !companyNameFilter.equals("")) {
            hql += " AND lower(a.companyName) LIKE :companyName ";
        }

        if (contactNoFilter != null && !contactNoFilter.equals("")) {
            hql += " AND lower(a.officeTelephone) LIKE :officeTelephone ";
        }

        if (groupNameFilter != null && !groupNameFilter.equals("")) {
            hql += " AND lower(a.vendorTypes) LIKE :vendorTypes ";
        }

        if (groupCategoryFilter != null && !groupCategoryFilter.equals("")) {
            hql += " AND lower(a.groupCategory) LIKE :groupCategory ";
        }

        if (groupSubCategoryFilter != null && !groupSubCategoryFilter.equals("")) {
            hql += " AND lower(a.groupSubCategory) LIKE :groupSubCategory ";
        }

        if (countryFilter != null && !countryFilter.equals("")) {
            hql += " AND lower(b.altCountry) LIKE :altCountry ";
        }

        if (stateFilter != null && !stateFilter.equals("")) {
            hql += " AND lower(b.altState) LIKE :altState ";
        }

        if (cityFilter != null && !cityFilter.equals("")) {
            hql += " AND lower(b.altCity) LIKE :altCity ";
        }

        if (gstNoFilter != null && !gstNoFilter.equals("")) {
            hql += " AND lower(a.gstinNo) LIKE :gstinNo ";
        }

        if (panNoFilter != null && !panNoFilter.equals("")) {
            hql += " AND lower(a.panNo) LIKE :panNo ";
        }

        if (riskCategoryFilter != null && !riskCategoryFilter.equals("")) {
            hql += " AND lower(a.riskCategory) LIKE :riskCategory ";
        }

        if (vendorInviteSourceFilter != null && !vendorInviteSourceFilter.equals("")) {
            hql += " AND lower(a.vendorInviteSource) LIKE :vendorInviteSource ";
        }

        if (invitedByFilter != null && !invitedByFilter.equals("")) {
            hql += " AND lower(a.approvalOne) LIKE :approvalOne ";
        }

        if (activatedDateFilter != null && !activatedDateFilter.equals("")) {
            hql += " AND lower(a.vendorActivatedDate) LIKE :vendorActivatedDate ";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(a.vendorEmailId) LIKE :searchValue "
                    + " OR lower(a.sapCode) LIKE :searchValue "
                    + " OR lower(a.companyName) LIKE :searchValue "
                    + " OR lower(a.countryCodeoffTele) LIKE :searchValue "
                    + " OR lower(a.officeTelephone) LIKE :searchValue "
                    + " OR lower(a.vendorTypes) LIKE :searchValue "
                    + " OR lower(a.groupCategory) LIKE :searchValue "
                    + " OR lower(a.groupSubCategory) LIKE :searchValue "
                    + " OR lower(b.altCountry) LIKE :searchValue "
                    + " OR lower(b.altState) LIKE :searchValue "
                    + " OR lower(b.altCity) LIKE :searchValue "
                    + " OR lower(a.gstinNo) LIKE :searchValue "
                    + " OR lower(a.panNo) LIKE :searchValue "
                    + " OR lower(a.riskCategory) LIKE :searchValue "
                    + " OR lower(a.vendorInviteSource) LIKE :searchValue "
                    + " OR lower(a.approvalOne) LIKE :searchValue "
                    + " OR lower(a.vendorActivatedDate) LIKE :searchValue "
                    + ")";
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
            orderDir = "desc";
        }

        hql += " ORDER BY " + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (vendorEmailIdFilter != null && !vendorEmailIdFilter.equals("")) {
            query.setParameter("vendorEmailId", "%" + vendorEmailIdFilter.toLowerCase() + "%");
        }

        if (sapCodeFilter != null && !sapCodeFilter.equals("")) {
            query.setParameter("sapCode", "%" + sapCodeFilter.toLowerCase() + "%");
        }

        if (companyNameFilter != null && !companyNameFilter.equals("")) {
            query.setParameter("companyName", "%" + companyNameFilter.toLowerCase() + "%");
        }

        if (contactNoFilter != null && !contactNoFilter.equals("")) {
            query.setParameter("officeTelephone", "%" + contactNoFilter.toLowerCase() + "%");
        }

        if (groupNameFilter != null && !groupNameFilter.equals("")) {
            query.setParameter("vendorTypes", "%" + groupNameFilter.toLowerCase() + "%");
        }

        if (groupCategoryFilter != null && !groupCategoryFilter.equals("")) {
            query.setParameter("groupCategory", "%" + groupCategoryFilter.toLowerCase() + "%");
        }

        if (groupSubCategoryFilter != null && !groupSubCategoryFilter.equals("")) {
            query.setParameter("groupSubCategory", "%" + groupSubCategoryFilter.toLowerCase() + "%");
        }

        if (countryFilter != null && !countryFilter.equals("")) {
            query.setParameter("altCountry", "%" + countryFilter.toLowerCase() + "%");
        }

        if (stateFilter != null && !stateFilter.equals("")) {
            query.setParameter("altState", "%" + stateFilter.toLowerCase() + "%");
        }

        if (cityFilter != null && !cityFilter.equals("")) {
            query.setParameter("altCity", "%" + cityFilter.toLowerCase() + "%");
        }

        if (gstNoFilter != null && !gstNoFilter.equals("")) {
            query.setParameter("gstinNo", "%" + gstNoFilter.toLowerCase() + "%");
        }

        if (panNoFilter != null && !panNoFilter.equals("")) {
            query.setParameter("panNo", "%" + panNoFilter.toLowerCase() + "%");
        }

        if (riskCategoryFilter != null && !riskCategoryFilter.equals("")) {
            query.setParameter("riskCategory", "%" + riskCategoryFilter.toLowerCase() + "%");
        }

        if (vendorInviteSourceFilter != null && !vendorInviteSourceFilter.equals("")) {
            query.setParameter("vendorInviteSource", "%" + vendorInviteSourceFilter.toLowerCase() + "%");
        }

        if (invitedByFilter != null && !invitedByFilter.equals("")) {
            query.setParameter("approvalOne", "%" + invitedByFilter.toLowerCase() + "%");
        }

        if (activatedDateFilter != null && !activatedDateFilter.equals("")) {
            query.setParameter("vendorActivatedDate", "%" + activatedDateFilter.toLowerCase() + "%");
        }

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();

    }

    @Override
    public int getBlockVendorCount() {
        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + "FROM VendorInformation a "
                    + "WHERE a.status1 = 700 ";

            Query query = session.createQuery(hql);

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();
    }

    @Override
    public int getFilteredBlockVendorCount(String searchValue, String sapCodeFilter, String companyNameFilter, String vendorEmailIdFilter, String contactNoFilter, String groupNameFilter, String groupCategoryFilter, String groupSubCategoryFilter, String countryFilter, String stateFilter, String cityFilter, String gstNoFilter, String panNoFilter, String riskCategoryFilter, String vendorInviteSourceFilter, String invitedByFilter, String activatedDateFilter) {
        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + " FROM VendorInformation a, VendorSelfDeclaration b "
                    + " WHERE a.status1 = 700 "
                    + " AND a.id = b.vendorInformationId ";

            if (vendorEmailIdFilter != null && !vendorEmailIdFilter.equals("")) {
                hql += " AND lower(a.vendorEmailId) LIKE :vendorEmailId ";
            }

            if (sapCodeFilter != null && !sapCodeFilter.equals("")) {
                hql += " AND lower(a.sapCode) LIKE :sapCode ";
            }

            if (companyNameFilter != null && !companyNameFilter.equals("")) {
                hql += " AND lower(a.companyName) LIKE :companyName ";
            }

            if (contactNoFilter != null && !contactNoFilter.equals("")) {
                hql += " AND lower(a.officeTelephone) LIKE :officeTelephone ";
            }

            if (groupNameFilter != null && !groupNameFilter.equals("")) {
                hql += " AND lower(a.vendorTypes) LIKE :vendorTypes ";
            }

            if (groupCategoryFilter != null && !groupCategoryFilter.equals("")) {
                hql += " AND lower(a.groupCategory) LIKE :groupCategory ";
            }

            if (groupSubCategoryFilter != null && !groupSubCategoryFilter.equals("")) {
                hql += " AND lower(a.groupSubCategory) LIKE :groupSubCategory ";
            }

            if (countryFilter != null && !countryFilter.equals("")) {
                hql += " AND lower(b.altCountry) LIKE :altCountry ";
            }

            if (stateFilter != null && !stateFilter.equals("")) {
                hql += " AND lower(b.altState) LIKE :altState ";
            }

            if (cityFilter != null && !cityFilter.equals("")) {
                hql += " AND lower(b.altCity) LIKE :altCity ";
            }

            if (gstNoFilter != null && !gstNoFilter.equals("")) {
                hql += " AND lower(a.gstinNo) LIKE :gstinNo ";
            }

            if (panNoFilter != null && !panNoFilter.equals("")) {
                hql += " AND lower(a.panNo) LIKE :panNo ";
            }

            if (riskCategoryFilter != null && !riskCategoryFilter.equals("")) {
                hql += " AND lower(a.riskCategory) LIKE :riskCategory ";
            }

            if (vendorInviteSourceFilter != null && !vendorInviteSourceFilter.equals("")) {
                hql += " AND lower(a.vendorInviteSource) LIKE :vendorInviteSource ";
            }

            if (invitedByFilter != null && !invitedByFilter.equals("")) {
                hql += " AND lower(a.approvalOne) LIKE :approvalOne ";
            }

            if (activatedDateFilter != null && !activatedDateFilter.equals("")) {
                hql += " AND lower(a.vendorActivatedDate) LIKE :vendorActivatedDate ";
            }

            if (searchValue != null && !searchValue.equals("")) {

                hql += " AND ("
                        + " lower(a.vendorEmailId) LIKE :searchValue "
                        + " OR lower(a.sapCode) LIKE :searchValue "
                        + " OR lower(a.companyName) LIKE :searchValue "
                        + " OR lower(a.countryCodeoffTele) LIKE :searchValue "
                        + " OR lower(a.officeTelephone) LIKE :searchValue "
                        + " OR lower(a.vendorTypes) LIKE :searchValue "
                        + " OR lower(a.groupCategory) LIKE :searchValue "
                        + " OR lower(a.groupSubCategory) LIKE :searchValue "
                        + " OR lower(b.altCountry) LIKE :searchValue "
                        + " OR lower(b.altState) LIKE :searchValue "
                        + " OR lower(b.altCity) LIKE :searchValue "
                        + " OR lower(a.gstinNo) LIKE :searchValue "
                        + " OR lower(a.panNo) LIKE :searchValue "
                        + " OR lower(a.riskCategory) LIKE :searchValue "
                        + " OR lower(a.vendorInviteSource) LIKE :searchValue "
                        + " OR lower(a.approvalOne) LIKE :searchValue "
                        + " OR lower(a.vendorActivatedDate) LIKE :searchValue "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (vendorEmailIdFilter != null && !vendorEmailIdFilter.equals("")) {
                query.setParameter("vendorEmailId", "%" + vendorEmailIdFilter.toLowerCase() + "%");
            }

            if (sapCodeFilter != null && !sapCodeFilter.equals("")) {
                query.setParameter("sapCode", "%" + sapCodeFilter.toLowerCase() + "%");
            }

            if (companyNameFilter != null && !companyNameFilter.equals("")) {
                query.setParameter("companyName", "%" + companyNameFilter.toLowerCase() + "%");
            }

            if (contactNoFilter != null && !contactNoFilter.equals("")) {
                query.setParameter("officeTelephone", "%" + contactNoFilter.toLowerCase() + "%");
            }

            if (groupNameFilter != null && !groupNameFilter.equals("")) {
                query.setParameter("vendorTypes", "%" + groupNameFilter.toLowerCase() + "%");
            }

            if (groupCategoryFilter != null && !groupCategoryFilter.equals("")) {
                query.setParameter("groupCategory", "%" + groupCategoryFilter.toLowerCase() + "%");
            }

            if (groupSubCategoryFilter != null && !groupSubCategoryFilter.equals("")) {
                query.setParameter("groupSubCategory", "%" + groupSubCategoryFilter.toLowerCase() + "%");
            }

            if (countryFilter != null && !countryFilter.equals("")) {
                query.setParameter("altCountry", "%" + countryFilter.toLowerCase() + "%");
            }

            if (stateFilter != null && !stateFilter.equals("")) {
                query.setParameter("altState", "%" + stateFilter.toLowerCase() + "%");
            }

            if (cityFilter != null && !cityFilter.equals("")) {
                query.setParameter("altCity", "%" + cityFilter.toLowerCase() + "%");
            }

            if (gstNoFilter != null && !gstNoFilter.equals("")) {
                query.setParameter("gstinNo", "%" + gstNoFilter.toLowerCase() + "%");
            }

            if (panNoFilter != null && !panNoFilter.equals("")) {
                query.setParameter("panNo", "%" + panNoFilter.toLowerCase() + "%");
            }

            if (riskCategoryFilter != null && !riskCategoryFilter.equals("")) {
                query.setParameter("riskCategory", "%" + riskCategoryFilter.toLowerCase() + "%");
            }

            if (vendorInviteSourceFilter != null && !vendorInviteSourceFilter.equals("")) {
                query.setParameter("vendorInviteSource", "%" + vendorInviteSourceFilter.toLowerCase() + "%");
            }

            if (invitedByFilter != null && !invitedByFilter.equals("")) {
                query.setParameter("approvalOne", "%" + invitedByFilter.toLowerCase() + "%");
            }

            if (activatedDateFilter != null && !activatedDateFilter.equals("")) {
                query.setParameter("vendorActivatedDate", "%" + activatedDateFilter.toLowerCase() + "%");
            }

            if (searchValue != null && !searchValue.equals("")) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();

    }

    @Override
    public int vendorBlockCount() {
        String query = "";
        query += "select COUNT(a.id) from VendorInformation a "
                + "WHERE a.status1 In (700)";
        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public List readBystatus500() {
        String query = "";
        query += "SELECT a.id,a.companyName,a.vendorEmailId,a.status1,a.approvalOne "
                + "FROM VendorInformation a"
                + " WHERE a.status1 IN (500,501,502,10)"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List getComplianceOfficerPagination(int start, int length, String orderColumn, String orderDir, String searchValue) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            String hql = "SELECT a.id, a.companyName, a.vendorEmailId, a.status1, a.approvalOne "
                    + " FROM VendorInformation a "
                    + " WHERE a.status1 IN (500,501,502,10) ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                hql += " AND ("
                        + " lower(a.vendorEmailId) LIKE :searchValue "
                        + " OR lower(a.companyName) LIKE :searchValue "
                        + "OR (a.status1 = 500  AND lower('pending') LIKE :searchValue) "
                        + "OR (a.status1 = 502  AND lower('Recycle') LIKE :searchValue) "
                        + "OR (a.status1 = 501  AND lower('Reject') LIKE :searchValue) "
                        + "OR (a.status1 = 10  AND lower('Active Vender')  LIKE :searchValue) "
                        + ") ";

            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getAllComplianceOfficerCount() {
        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + " FROM VendorInformation a "
                    + " WHERE a.status1 IN (500,501,502,10) ";

            Query query = session.createQuery(hql);

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();
    }

    @Override
    public int getFilteredComplianceOfficerCount(String searchValue) {
        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + " FROM VendorInformation a "
                    + " WHERE a.status1 IN (500,501,502,10) ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                hql += " AND ("
                        + " lower(a.vendorEmailId) LIKE :searchValue "
                        + " OR lower(a.companyName) LIKE :searchValue "
                        + "OR (a.status1 = 500  AND lower('pending') LIKE :searchValue) "
                        + "OR (a.status1 = 502  AND lower('Recycle') LIKE :searchValue) "
                        + "OR (a.status1 = 501  AND lower('Reject') LIKE :searchValue) "
                        + "OR (a.status1 = 10  AND lower('Active Vender')  LIKE :searchValue) "
                        + ") ";

            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.equals("")) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();
    }
}

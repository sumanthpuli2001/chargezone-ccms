/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderMasterDao;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderMasterServiceImpl<T> extends GenericsServiceImpl<T> implements TenderMasterService<T> {

    private TenderMasterDao<T> tenderMasterDao;

    public TenderMasterDao<T> getTenderMasterDao() {
        return tenderMasterDao;
    }

    public void setTenderMasterDao(TenderMasterDao<T> tenderMasterDao) {
        this.tenderMasterDao = tenderMasterDao;
        setGenericsDAO(tenderMasterDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return tenderMasterDao.readByRefNo(refNo);
    }

    @Override
    public List vendorLiveTender(String username) {
        return tenderMasterDao.vendorLiveTender(username);
    }

    @Override
    public TenderMaster readByVendorRefNo(String refNo, String username) {
        return tenderMasterDao.readByVendorRefNo(refNo, username);
    }

    @Override
    public List unauthorizeTender(String username, String location, String department) {
        return tenderMasterDao.unauthorizeTender(username, location, department);
    }

    @Override
    public void authorizeTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        tenderMasterDao.authorizeTender(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public void recycleTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        tenderMasterDao.recycleTender(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public void rejectTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        tenderMasterDao.rejectTender(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public void updateTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        tenderMasterDao.updateTender(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public List recycleTenderList(String username, String location, String department) {
        return tenderMasterDao.recycleTenderList(username, location, department);
    }

    @Override
    public List rejectTenderList(String username, String location, String department) {
        return tenderMasterDao.rejectTenderList(username, location, department);
    }

    @Override
    public void recycleTenderSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        tenderMasterDao.recycleTenderSubmit(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public List liveTenderList(String username, String location, String department) {
        return tenderMasterDao.liveTenderList(username, location, department);
    }

    @Override
    public List liveTenderList1(String username, String location, String department) {
        return tenderMasterDao.liveTenderList1(username, location, department);
    }

    @Override
    public void authTender(String refNo) {
        tenderMasterDao.authTender(refNo);
    }

    @Override
    public void updateTenderData(String refNo, String title1, String category_id1, String value1, String emd1, String doc_cost1, String type1, String contact_person1, String location1, String announce_date1, String collection_lastdate1, String submit_lastdate1, String work_desc1, String tender_remark1, String tender_admin1, String tender_admin_contact_number1, String tender_authorize_person1, String tender_authorize_contact_no1, int authorize_flag1, String tender_authorize_user_name1, int re_autho_flag1, int is_in_autho_table1, int vendor_flag1, int item_flag1, int email_flag1, String authorize_date1, int return_flag1, int delete_flag1, int tender_phase1, int open_bid_flag1, String department1, String pr_no1) {
        tenderMasterDao.updateTenderData(refNo, title1, category_id1, value1, emd1, doc_cost1, type1, contact_person1, location1, announce_date1, collection_lastdate1, submit_lastdate1, work_desc1, tender_remark1, tender_admin1, tender_admin_contact_number1, tender_authorize_person1, tender_authorize_contact_no1, authorize_flag1, tender_authorize_user_name1, re_autho_flag1, is_in_autho_table1, vendor_flag1, item_flag1, email_flag1, authorize_date1, return_flag1, delete_flag1, tender_phase1, open_bid_flag1, department1, pr_no1);
    }

    @Override
    public TenderMaster readRefNo(String refNo) {
        return tenderMasterDao.readRefNo(refNo);
    }

    @Override
    public List pastTenderList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        return tenderMasterDao.pastTenderList(location, department, tender_no, tender_title, open_from_date, open_to_date, close_from_date, close_to_date);
    }

    @Override
    public List vendorOpenTender() {
        return tenderMasterDao.vendorOpenTender();
    }

    @Override
    public List allLiveTender() {
        return tenderMasterDao.allLiveTender();
    }

    @Override
    public void updateEmailFlag(String refNo) {
        tenderMasterDao.updateEmailFlag(refNo);
    }

    @Override
    public void updateAuthEmailFlag(String refNo) {
        tenderMasterDao.updateAuthEmailFlag(refNo);
    }

    @Override
    public List unauthorizeEmailTender(String username, String location, String department) {
        return tenderMasterDao.unauthorizeEmailTender(username, location, department);
    }

    @Override
    public List liveTenderAuthorizerList(String username, String location, String department) {
        return tenderMasterDao.liveTenderAuthorizerList(username, location, department);
    }

    @Override
    public List liveTenderAuthorizerList1(String username, String location, String department) {
        return tenderMasterDao.liveTenderAuthorizerList1(username, location, department);
    }

    @Override
    public List readOpenLiveTender() {
        return tenderMasterDao.readOpenLiveTender();
    }

    @Override
    public List allLiveParticipateTender(String username) {
        return tenderMasterDao.allLiveParticipateTender(username);
    }

    @Override
    public void updateDate(String refNo, String submitLastdate) {
        tenderMasterDao.updateDate(refNo, submitLastdate);
    }

    @Override
    public void updateBidOpenFlag(String refNo) {
        tenderMasterDao.updateBidOpenFlag(refNo);
    }

    @Override
    public void updateCloseTender(String tender_no, String remark) {
        tenderMasterDao.updateCloseTender(tender_no, remark);
    }

    @Override
    public List liveTenderUnautorizeList(String username, String location, String department) {
        return tenderMasterDao.liveTenderUnautorizeList(username, location, department);
    }

    @Override
    public List receiveBIdList1() {
        return tenderMasterDao.receiveBIdList1();
    }

    @Override
    public List vendorReviseTenderList(String username) {
        return tenderMasterDao.vendorReviseTenderList(username);
    }

    @Override
    public void updateCondition(String refNo, String deliveryLocation, String deliveryPeriod, String termsOfPayment, String validityPeriod, String modeOfTransport, String incoTerms, String insurance, String freight) {
        tenderMasterDao.updateCondition(refNo, deliveryLocation, deliveryPeriod, termsOfPayment, validityPeriod, modeOfTransport, incoTerms, insurance, freight);
    }

    @Override
    public List holdTenderList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        return tenderMasterDao.holdTenderList(location, department, tender_no, tender_title, open_from_date, open_to_date, close_from_date, close_to_date);
    }

    @Override
    public List finalTenderList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        return tenderMasterDao.finalTenderList(location, department, tender_no, tender_title, open_from_date, open_to_date, close_from_date, close_to_date);
    }

    @Override
    public List behalfOfRefNo(String refNo, String date1) {
        return tenderMasterDao.behalfOfRefNo(refNo, date1);
    }

    @Override
    public List auditTenderList() {
        return tenderMasterDao.auditTenderList();
    }

    @Override
    public List receiveAdminBIdList(String username, String location, String department) {
        return tenderMasterDao.receiveAdminBIdList(username, location, department);
    }

    @Override
    public List getUserList() {
        return tenderMasterDao.getUserList();
    }

    @Override
    public List vendorLiveTender1(String username) {
        return tenderMasterDao.vendorLiveTender1(username);
    }

    @Override
    public List liveTenderAuthorizerList3(String username, String location, String department) {
        return tenderMasterDao.liveTenderAuthorizerList3(username, location, department);
    }

    @Override
    public List liveTenderAuthorizerList4(String username, String location, String department) {
        return tenderMasterDao.liveTenderAuthorizerList4(username, location, department);
    }

    @Override
    public List liveTenderList3(String username, String location, String department) {
        return tenderMasterDao.liveTenderList3(username, location, department);
    }

    @Override
    public List liveTenderList4(String username, String location, String department) {
        return tenderMasterDao.liveTenderList4(username, location, department);
    }

    @Override
    public List vendorTechnicalReviseTenderList(String username) {
        return tenderMasterDao.vendorTechnicalReviseTenderList(username);
    }

    @Override
    public List vendorTechnicalList(String username) {
        return tenderMasterDao.vendorTechnicalReviseTenderList(username);
    }

    @Override
    public List receiveBidBuyer(String username) {
        return tenderMasterDao.receiveBidBuyer(username);
    }

    @Override
    public TenderMaster readByPRNo(String pr_no) {
        return tenderMasterDao.readByPRNo(pr_no);
    }

    @Override
    public List readByMonth(String from_date) {
        return tenderMasterDao.readByMonth(from_date);

    }

    @Override
    public int readyByopenfalg() {
        return tenderMasterDao.readyByopenfalg();

    }

    @Override
    public List readNextTwoDayTender(String todaydate, String submitLastdate) {
        return tenderMasterDao.readNextTwoDayTender(todaydate, submitLastdate);
    }

    @Override
    public int readByDate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readByDate(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

    }

    @Override
    public int readByDate2(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readByDate2(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readByDate1(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readByDate1(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

    }

    @Override
    public int readByflagzero() {
        return tenderMasterDao.readByflagzero();
    }

    @Override
    public List readBycontactper() {
        return tenderMasterDao.readBycontactper();
    }

    @Override
    public int countAllPr() {
        return tenderMasterDao.countAllPr();
    }

    @Override
    public int countAllPrFilterUser(String username) {
        return tenderMasterDao.countAllPrFilterUser(username);
    }

    @Override
    public int readyByopenfalgFilterUser(String username) {
        return tenderMasterDao.readyByopenfalgFilterUser(username);
    }

    @Override
    public int readByflagzeroFilterUser(String username) {
        return tenderMasterDao.readByflagzeroFilterUser(username);
    }

    @Override
    public List readByMonthFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readByMonthFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

    }

    @Override
    public List readBycontactperFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readBycontactperFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int countAllPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.countAllPrFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readyByopenfalgFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readyByopenfalgFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readByflagzeroFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readByflagzeroFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List readBycontactperFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readBycontactperFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List readByMonthFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readByMonthFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalTender(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.totalTender(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalTenderClosed(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.totalTenderClosed(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalLiveTender(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.totalLiveTender(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List readBycontactperGraphUser(String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readBycontactperGraphUser(ContactPerson, Value, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List readByMonthGraphUser(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readByMonthGraphUser(username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List readPrRegister() {
        return tenderMasterDao.readPrRegister();
    }

    @Override
    public List readPrRegisterUnCommon() {
        return tenderMasterDao.readPrRegisterUnCommon();
    }

    @Override
    public List totalTenderClosedByForce(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.totalTenderClosedByForce(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readytenderclosedByForce(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readytenderclosedByForce(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readyBydeleteFlag() {
        return tenderMasterDao.readyBydeleteFlag();
    }

    @Override
    public int readBydeleteFlagFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.readBydeleteFlagFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getPastTenderPagination(int start, int length, String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date, String orderColumn, String orderDir) {
        return tenderMasterDao.getPastTenderPagination(start, length, searchValue, tender_no, tender_title, open_from_date, open_to_date, close_from_date, close_to_date, orderColumn, orderDir);
    }

    @Override
    public int getTotalPastTenderCount() {
        return tenderMasterDao.getTotalPastTenderCount();
    }

    @Override
    public int getFilteredPastTenderCount(String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        return tenderMasterDao.getFilteredPastTenderCount(searchValue, tender_no, tender_title, open_from_date, open_to_date, close_from_date, close_to_date);
    }

    @Override
    public List getFinalTenderPagination(int start, int length, String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date, String orderColumn, String orderDir) {
        return tenderMasterDao.getFinalTenderPagination(start, length, searchValue, tender_no, tender_title, open_from_date, open_to_date, close_from_date, close_to_date, orderColumn, orderDir);
    }

    @Override
    public int getTotalFinalTenderCount() {
        return tenderMasterDao.getTotalFinalTenderCount();
    }

    @Override
    public int getFilteredFinalTenderCount(String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        return tenderMasterDao.getFilteredFinalTenderCount(searchValue, tender_no, tender_title, open_from_date, open_to_date, close_from_date, close_to_date);
    }

    @Override
    public List receiveTechBIdList(String username, String location, String department) {
        return tenderMasterDao.receiveTechBIdList(username, location, department);
    }

    @Override
    public List getReceiveTechBidListPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {
        return tenderMasterDao.getReceiveTechBidListPagination(start, length, userName, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getReceiveTechBidListCount(String userName) {
        return tenderMasterDao.getReceiveTechBidListCount(userName);
    }

    @Override
    public int getFilteredReceiveTechBidListCount(String userName, String searchValue) {
        return tenderMasterDao.getFilteredReceiveTechBidListCount(userName, searchValue);
    }

    @Override
    public List getReceiveBidBuyerPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {
        return tenderMasterDao.getReceiveBidBuyerPagination(start, length, userName, searchValue, orderColumn, orderDir);

    }

    @Override
    public int getReceiveBidBuyerCount(String userName) {
        return tenderMasterDao.getReceiveBidBuyerCount(userName);
    }

    @Override
    public int getFilteredReceiveBidBuyerCount(String searchValue, String userName) {
        return tenderMasterDao.getFilteredReceiveBidBuyerCount(searchValue, userName);
    }

    @Override
    public List receiveBIdList(String username, String location, String department) {
        return tenderMasterDao.receiveBIdList(username, location, department);
    }

    @Override
    public List getReceiveCommercialBidPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {
        return tenderMasterDao.getReceiveCommercialBidPagination(start, length, userName, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getReceiveCommercialBidCount(String userName) {
        return tenderMasterDao.getReceiveCommercialBidCount(userName);

    }

    @Override
    public int getFilteredReceiveCommercialBidCount(String userName, String searchValue) {
        return tenderMasterDao.getFilteredReceiveCommercialBidCount(userName, searchValue);
    }

    @Override
    public List pastTenderTechnicalList(String location, String username, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        return tenderMasterDao.pastTenderTechnicalList(location, username, tender_no, tender_title, open_from_date, open_to_date, close_from_date, close_to_date);
    }

    @Override
    public List getPastTenderTechnicalPagination(int start, int length, String userName, String searchValue, String tenderNo, String tenderTitle, String openFromDate, String openToDate, String closeFromDate, String closeToDate, String orderColumn, String orderDir) {
        return tenderMasterDao.getPastTenderTechnicalPagination(start, length, userName, searchValue, tenderNo, tenderTitle, openFromDate, openToDate, closeFromDate, closeToDate, orderColumn, orderDir);
    }

    @Override
    public int getPastTenderTechnicalCount(String userName) {
        return tenderMasterDao.getPastTenderTechnicalCount(userName);
    }

    @Override
    public int getFilteredPastTenderTechnicalCount(String userName, String searchValue, String tenderNo, String tenderTitle, String openFromDate, String openToDate, String closeFromDate, String closeToDate) {
        return tenderMasterDao.getFilteredPastTenderTechnicalCount(userName, searchValue, tenderNo, tenderTitle, openFromDate, openToDate, closeFromDate, closeToDate);
    }

    @Override
    public List tenderReportList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        return tenderMasterDao.tenderReportList(location, department, tender_no, tender_title, open_from_date, open_to_date, close_from_date, close_to_date);
    }

    public List tenderReportPaginationList(String location, String department, String tenderNo, String projectName, String open_from_date, String open_to_date, String close_from_date, String close_to_date, int start, int length, String searchValue, String orderColumn, String orderDir) {
        return tenderMasterDao.tenderReportPaginationList(location, department, tenderNo, projectName, open_from_date, open_to_date, close_from_date, close_to_date, start, length, searchValue, orderColumn, orderDir);
    }

    public int tenderReportCount(String location, String department) {
        return tenderMasterDao.tenderReportCount(location, department);
    }

    public int tenderReportFilteredCount(String location, String department, String tenderNo, String projectName, String open_from_date, String open_to_date, String close_from_date, String close_to_date, String searchValue) {
        return tenderMasterDao.tenderReportFilteredCount(location, department, tenderNo, projectName, open_from_date, open_to_date, close_from_date, close_to_date, searchValue);
    }

    @Override
    public List behalfOfDate(String date) {
        return tenderMasterDao.behalfOfDate(date);
    }

    @Override
    public List tenderDailyReportPaginationList(int start, int length, String searchValue, String openFromDate, String orderColumn, String orderDir) {
        return tenderMasterDao.tenderDailyReportPaginationList(start, length, searchValue, openFromDate, orderColumn, orderDir);
    }

    @Override
    public int tenderDailyReportCount(String openFromDate) {
        return tenderMasterDao.tenderDailyReportCount(openFromDate);
    }

    @Override
    public int tenderDailyReportFilteredCount(String openFromDate, String searchValue) {
        return tenderMasterDao.tenderDailyReportFilteredCount(openFromDate, searchValue);
    }

    @Override
    public List gettenderCreatedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.gettenderCreatedPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int gettenderCreatedCount() {
        return tenderMasterDao.gettenderCreatedCount();
    }

    @Override
    public int getFilteredtenderCreatedCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getFilteredtenderCreatedCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getliveTenderPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getliveTenderPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getliveTenderCount() {
        return tenderMasterDao.getliveTenderCount();
    }

    @Override
    public int getFilteredliveTenderCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getFilteredliveTenderCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List gettenderClosedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.gettenderClosedPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int gettenderClosedCount() {
        return tenderMasterDao.gettenderClosedCount();
    }

    @Override
    public int getFilteredtenderClosedCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getFilteredtenderClosedCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List gettotalTenderClosedByForcePagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.gettotalTenderClosedByForcePagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int gettotalTenderClosedByForceCount() {
        return tenderMasterDao.gettotalTenderClosedByForceCount();
    }

    @Override
    public int getFilteredtotalTenderClosedByForceCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getFilteredtotalTenderClosedByForceCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getmonthWiseTenderListPrGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getmonthWiseTenderListPrGraphUserPagination(start, length, searchValue, orderColumn, orderDir, username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getmonthWiseTenderListPrGraphUserCount(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getmonthWiseTenderListPrGraphUserCount(username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getFilteredmonthWiseTenderListPrGraphUserCount(String searchValue, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getFilteredmonthWiseTenderListPrGraphUserCount(searchValue, username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getContactperGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getContactperGraphUserPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

    }

    @Override
    public int getContactperGraphUserCount(String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getContactperGraphUserCount(ContactPerson, Value, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getFilteredContactperGraphUserCount(String searchValue, String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return tenderMasterDao.getFilteredContactperGraphUserCount(searchValue, ContactPerson, Value, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

}

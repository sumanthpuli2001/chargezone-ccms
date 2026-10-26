/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TenderMasterService<T> extends GenericsService<T> {

    public List readByRefNo(String refNo);

    public List vendorLiveTender(String username);

    public TenderMaster readByVendorRefNo(String refNo, String username);

    public List unauthorizeTender(String username, String location, String department);

    public void authorizeTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public void recycleTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public void rejectTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public void updateTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public List recycleTenderList(String username, String location, String department);

    public List rejectTenderList(String username, String location, String department);

    public void recycleTenderSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public List liveTenderList(String username, String location, String department);

    public void authTender(String refNo);

    public void updateTenderData(String refNo, String title1, String category_id1, String value1, String emd1, String doc_cost1, String type1, String contact_person1, String location1, String announce_date1, String collection_lastdate1, String submit_lastdate1, String work_desc1, String tender_remark1, String tender_admin1, String tender_admin_contact_number1, String tender_authorize_person1, String tender_authorize_contact_no1, int authorize_flag1, String tender_authorize_user_name1, int re_autho_flag1, int _in_autho_table1, int vendor_flag1, int item_flag1, int email_flag1, String authorize_date1, int return_flag1, int delete_flag1, int tender_phase1, int open_bid_flag1, String department1, String pr_no1);

    public TenderMaster readRefNo(String refNo);

    public List pastTenderList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date);

    public List vendorOpenTender();

    public List allLiveTender();

    public void updateEmailFlag(String refNo);

    public void updateAuthEmailFlag(String refNo);

    public List unauthorizeEmailTender(String username, String location, String department);

    public List liveTenderAuthorizerList(String username, String location, String department);

    public List readOpenLiveTender();

    public List allLiveParticipateTender(String username);

    public void updateDate(String refNo, String submitLastdate);

    public List liveTenderList1(String username, String location, String department);

    public List liveTenderAuthorizerList1(String username, String location, String department);

    public void updateBidOpenFlag(String refNo);

    public void updateCloseTender(String tender_no, String remark);

    public List liveTenderUnautorizeList(String username, String location, String department);

    public List receiveBIdList1();

    public List vendorReviseTenderList(String username);

    public void updateCondition(String refNo, String deliveryLocation, String deliveryPeriod, String termsOfPayment, String validityPeriod, String modeOfTransport, String incoTerms, String insurance, String freight);

    public List holdTenderList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date);

    public List finalTenderList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date);

    public List behalfOfRefNo(String refNo, String date1);

    public List auditTenderList();

    public List receiveAdminBIdList(String username, String location, String department);

    public List getUserList();

    public List vendorLiveTender1(String username);

    public List liveTenderAuthorizerList3(String username, String location, String department);

    public List liveTenderAuthorizerList4(String username, String location, String department);

    public List liveTenderList3(String username, String location, String department);

    public List liveTenderList4(String username, String location, String department);

    public List vendorTechnicalReviseTenderList(String username);

    public List vendorTechnicalList(String username);

    public List receiveBidBuyer(String username);

    public TenderMaster readByPRNo(String pr_no);

    public List readByMonth(String from_date);

    public int readyByopenfalg();

    public List readNextTwoDayTender(String todaydate, String submitLastdate);

    public int readByDate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByDate2(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByDate1(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByflagzero();

    public List readBycontactper();

    public int countAllPr();

    public int countAllPrFilterUser(String username);

    public int readyByopenfalgFilterUser(String username);

    public int readByflagzeroFilterUser(String username);

    public List readByMonthFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readBycontactperFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int countAllPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readyByopenfalgFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByflagzeroFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readBycontactperFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readBycontactperGraphUser(String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readByMonthFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readByMonthGraphUser(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalTender(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalTenderClosed(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalLiveTender(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readPrRegister();

    public List readPrRegisterUnCommon();

    public int readyBydeleteFlag();

    public int readytenderclosedByForce(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalTenderClosedByForce(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readBydeleteFlagFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getPastTenderPagination(int start, int length, String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date, String orderColumn, String orderDir);

    public int getTotalPastTenderCount();

    public int getFilteredPastTenderCount(String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date);

    public List getFinalTenderPagination(int start, int length, String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date, String orderColumn, String orderDir);

    public int getTotalFinalTenderCount();

    public int getFilteredFinalTenderCount(String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date);

    public List receiveTechBIdList(String username, String location, String department);

    public List getReceiveTechBidListPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir);

    public int getReceiveTechBidListCount(String userName);

    public int getFilteredReceiveTechBidListCount(String userName, String searchValue);

    public List getReceiveBidBuyerPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir);

    public int getReceiveBidBuyerCount(String userName);

    public int getFilteredReceiveBidBuyerCount(String searchValue, String userName);

    public List receiveBIdList(String username, String location, String department);

    public List getReceiveCommercialBidPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir);

    public int getReceiveCommercialBidCount(String userName);

    public int getFilteredReceiveCommercialBidCount(String userName, String searchValue);

    public List pastTenderTechnicalList(String location, String username, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date);

    public List getPastTenderTechnicalPagination(int start, int length, String userName, String searchValue, String tenderNo, String tenderTitle, String openFromDate, String openToDate, String closeFromDate, String closeToDate, String orderColumn, String orderDir);

    public int getPastTenderTechnicalCount(String userName);

    public int getFilteredPastTenderTechnicalCount(String userName, String searchValue, String tenderNo, String tenderTitle, String openFromDate, String openToDate, String closeFromDate, String closeToDate);

    public List tenderReportList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date);

    public List tenderReportPaginationList(String location, String department, String tenderNo, String projectName, String open_from_date, String open_to_date, String close_from_date, String close_to_date, int start, int length, String searchValue, String orderColumn, String orderDir);

    public int tenderReportCount(String location, String department);

    public int tenderReportFilteredCount(String location, String department, String tenderNo, String projectName, String open_from_date, String open_to_date, String close_from_date, String close_to_date, String searchValue);

    public List behalfOfDate(String date);

    public List tenderDailyReportPaginationList(int start, int length, String searchValue, String openFromDate, String orderColumn, String orderDir);

    public int tenderDailyReportCount(String openFromDate);

    public int tenderDailyReportFilteredCount(String openFromDate, String searchValue);

    public List gettenderCreatedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int gettenderCreatedCount();

    public int getFilteredtenderCreatedCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getliveTenderPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getliveTenderCount();

    public int getFilteredliveTenderCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List gettenderClosedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int gettenderClosedCount();

    public int getFilteredtenderClosedCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List gettotalTenderClosedByForcePagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int gettotalTenderClosedByForceCount();

    public int getFilteredtotalTenderClosedByForceCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getmonthWiseTenderListPrGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getmonthWiseTenderListPrGraphUserCount(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getFilteredmonthWiseTenderListPrGraphUserCount(String searchValue, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getContactperGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getContactperGraphUserCount(String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getFilteredContactperGraphUserCount(String searchValue, String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

}

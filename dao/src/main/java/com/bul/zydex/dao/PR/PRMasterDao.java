/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRMaster;
import com.bul.zydex.model.TenderMaster;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PRMasterDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo);

    public List pendingPRList();

    public PRMaster readByPrNo(String pr_no);

    public List readByemployee(String employee_name);

    public List readLog(String prNumber, String open_from_date, String open_to_date, String department, String projectName);

    public List readLogOnlyPrMaster(String prNumber, String open_from_date, String open_to_date, String department, String projectName);

    public List pendingPRList1(String username);

    public List pendingPRList2();

    public List pendingPRListDashboard();

    public List prRecycleList(String username);

    public List pendingPRListDashboad();

    public List approvedPRListDashboad();

    public List groupByProjectName();

    public List readByMonthpr(String from_date1);

    public int readByDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByDateformate1(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByDateformate2(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readByDateformate3(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByDateformate4(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByDateformate5(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByDateformate6(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readyByflagzero();

    public int readByflagonesix();

    public int readByprtenderFlagone();

    public int readByprtenderFlagzero();

    public int readbyflagone();

    public int countAllPr();

    public int countRejectedPr();

    public int readByflagonesixFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int countRejectedPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByprtenderFlagoneFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readByprtenderFlagzeroFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readbyflagoneFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int countAllPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int readyByflagzeroFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List monthWiseListPrFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int countRejectedPrFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List monthWiseListPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List monthWiseListPrGraphUser(String username, String Startdate, String Enddate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readBycontactperFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalPrUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalUnderApproval(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalLivePr(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalRejectedPr(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalAssignToBuyer(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalPendingToAssign(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List totalPendingToFloat(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readPrRegister(String userName, String Fromdate, String Todate);

    public List readPrRegisterUnCommon(String userName, String Fromdate, String Todate);

    public List readOnlyPr(String userName, String Fromdate, String Todate);

    public List readByTenderCreater();

    public List readPrAdmin();

    public List readPrRegisterForAll();

    public List readPrRegisterUnCommonForAll();

    public List readOnlyPrForAll();

    public int readOnlyPrForAll(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int totalClosePrCount();

    public List closePrWithFilter(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List readByClosePr(String prNumber, String open_from_date, String open_to_date, String department);

    public List getPRPagination(int start, int length, String searchValue, String prNumber, String projectName, String department, String fromDate, String toDate, String orderColumn, String orderDir);

    public int getTotalPRCount();

    public int getFilteredPRCount(String searchValue, String prNumber, String projectName, String department, String fromDate, String toDate);

    public List getListPRPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir, String statusFilter);

    public int getTotalListPRCount(String username);

    public int getFilteredListPRCount(String username, String searchValue);

    public List getClosePrListPagination(int start, int length, String searchValue, String prNumber, String open_from_date, String open_to_date, String department, String orderByField, String orderDir);

    public int getTotalClosePRCount();

    public int getFilteredClosePRCount(String searchValue, String prNumber, String open_from_date, String open_to_date, String department);

    public List getPRRegisterPagination(int start, int length, String searchValue, String Fromdate, String Todate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode, String orderColumn, String orderDir);

    public int getPRRegisterCount(String fromDate, String toDate);

    public int getFilteredPRRegisterCount(String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode);

    public Object[] getTotalPRAndPOValue(String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode);

    public int getPRRegisterExcelCount(String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode);

    public List getPRRegisterExcelData(int i, int totalData, String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode, String orderColumn, String orderDir);

      public List gettotalPrUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getMonthWiseGraphCount();

    public int getFilteredMonthWiseGraphCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getunderApprovalPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getunderApprovalCount();

    public int getFilteredunderApprovalCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getrejectedPrPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getrejectedPrCount();

    public int getFilteredrejectedPrCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getlivePrPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getlivePrCount();

    public int getFilteredlivePrCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List gettenderPendingToFloatPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int gettenderPendingToFloatCount();

    public int getFilteredtenderPendingToFloatCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getPendingToAssignPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getPendingToAssignFloatCount();

    public int getFilteredPendingToAssignCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getAssginedToBuyerPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getAssginedToBuyerCount();

    public int getFilteredAssginedToBuyerCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getClosedPrPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getClosedPrCount();

    public int getFilteredClosedPrCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public List getmonthWiseListPrGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getmonthWiseListPrGraphUserCount(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department);

    public int getFilteredmonthWiseListPrGraphUserCount(String searchValue, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department);

    
    
}

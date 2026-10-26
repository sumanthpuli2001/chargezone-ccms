/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRMasterDao;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.dao.Tender.TenderMasterDao;
import com.bul.zydex.model.PRMaster;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class PRMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PRMasterService<T> {

    private PRMasterDao<T> prMasterDao;

    public PRMasterDao<T> getPrMasterDao() {
        return prMasterDao;
    }

    public void setPrMasterDao(PRMasterDao<T> prMasterDao) {
        this.prMasterDao = prMasterDao;
        setGenericsDAO(prMasterDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return prMasterDao.readByRefNo(refNo);
    }

    @Override
    public List pendingPRList() {
        return prMasterDao.pendingPRList();
    }

    @Override
    public PRMaster readByPrNo(String pr_no) {
        return prMasterDao.readByPrNo(pr_no);
    }

    @Override
    public List readByemployee(String employee_name) {
        return prMasterDao.readByemployee(employee_name);
    }

    @Override
    public List readLog(String prNumber, String open_from_date, String open_to_date, String department, String projectName) {
        return prMasterDao.readLog(prNumber, open_from_date, open_to_date, department, projectName);
    }

    @Override
    public List readLogOnlyPrMaster(String prNumber, String open_from_date, String open_to_date, String department, String projectName) {
        return prMasterDao.readLogOnlyPrMaster(prNumber, open_from_date, open_to_date, department, projectName);
    }

    @Override
    public List pendingPRList1(String username) {
        return prMasterDao.pendingPRList1(username);
    }

    @Override
    public List pendingPRList2() {
        return prMasterDao.pendingPRList2();
    }

    @Override
    public List pendingPRListDashboard() {
        return prMasterDao.pendingPRListDashboard();
    }

    @Override
    public List prRecycleList(String username) {
        return prMasterDao.prRecycleList(username);
    }

    @Override
    public List pendingPRListDashboad() {
        return prMasterDao.pendingPRListDashboad();

    }

    @Override
    public List approvedPRListDashboad() {
        return prMasterDao.approvedPRListDashboad();

    }

    @Override
    public List groupByProjectName() {
        return prMasterDao.groupByProjectName();

    }

    @Override
    public List readByMonthpr(String from_date1) {
        return prMasterDao.readByMonthpr(from_date1);

    }

    @Override
    public int readByDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readByDateformate1(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByDateformate1(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

    }

    @Override
    public int readByDateformate2(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByDateformate2(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List readByDateformate3(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByDateformate3(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readByDateformate4(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByDateformate4(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readByDateformate5(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByDateformate5(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readByDateformate6(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByDateformate6(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readyByflagzero() {
        return prMasterDao.readyByflagzero();

    }

    @Override
    public int readByflagonesix() {
        return prMasterDao.readByflagonesix();
    }

    @Override
    public int readByprtenderFlagone() {
        return prMasterDao.readByprtenderFlagone();

    }

    @Override
    public int readByprtenderFlagzero() {
        return prMasterDao.readByprtenderFlagzero();

    }

    @Override
    public int readbyflagone() {
        return prMasterDao.readbyflagone();

    }

    @Override
    public int countAllPr() {
        return prMasterDao.countAllPr();
    }

    @Override
    public int countRejectedPr() {
        return prMasterDao.countRejectedPr();
    }

    @Override
    public int readByflagonesixFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByflagonesixFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int countRejectedPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.countRejectedPrFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readByprtenderFlagoneFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByprtenderFlagoneFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readByprtenderFlagzeroFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readByprtenderFlagzeroFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readbyflagoneFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readbyflagoneFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int countAllPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.countAllPrFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int readyByflagzeroFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readyByflagzeroFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List monthWiseListPrFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.monthWiseListPrFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

    }

    @Override
    public int countRejectedPrFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.countRejectedPrFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List monthWiseListPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.monthWiseListPrFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List monthWiseListPrGraphUser(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.monthWiseListPrGraphUser(username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List readBycontactperFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readBycontactperFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalPrUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.totalPrUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalUnderApproval(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.totalUnderApproval(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalLivePr(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.totalLivePr(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalRejectedPr(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.totalRejectedPr(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalAssignToBuyer(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.totalAssignToBuyer(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalPendingToAssign(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.totalPendingToAssign(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List totalPendingToFloat(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.totalPendingToFloat(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List readPrRegister(String userName, String Fromdate, String Todate) {
        return prMasterDao.readPrRegister(userName, Fromdate, Todate);

    }

    @Override
    public List readPrRegisterUnCommon(String userName, String Fromdate, String Todate) {
        return prMasterDao.readPrRegisterUnCommon(userName, Fromdate, Todate);
    }

    @Override
    public List readOnlyPr(String userName, String Fromdate, String Todate) {
        return prMasterDao.readOnlyPr(userName, Fromdate, Todate);
    }

    @Override
    public List readByTenderCreater() {
        return prMasterDao.readByTenderCreater();
    }

    @Override
    public List readPrAdmin() {
        return prMasterDao.readPrAdmin();
    }

    @Override
    public List readPrRegisterForAll() {
        return prMasterDao.readPrRegisterForAll();
    }

    @Override
    public List readPrRegisterUnCommonForAll() {
        return prMasterDao.readPrRegisterUnCommonForAll();
    }

    @Override
    public List readOnlyPrForAll() {
        return prMasterDao.readOnlyPrForAll();
    }

    @Override
    public int totalClosePr(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.readOnlyPrForAll(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int totalClosePrCount() {
        return prMasterDao.totalClosePrCount();
    }

    @Override
    public List closePrWithFilter(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.closePrWithFilter(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List readByClosePr(String prNumber, String open_from_date, String open_to_date, String department) {
        return prMasterDao.readByClosePr(prNumber, open_from_date, open_to_date, department);
    }

    @Override
    public List getPRPagination(int start, int length, String searchValue, String prNumber, String projectName, String department, String fromDate, String toDate, String orderColumn, String orderDir) {
        return prMasterDao.getPRPagination(start, length, searchValue, prNumber, projectName, department, fromDate, toDate, orderColumn, orderDir);
    }

    @Override
    public int getTotalPRCount() {
        return prMasterDao.getTotalPRCount();
    }

    @Override
    public int getFilteredPRCount(String searchValue, String prNumber, String projectName, String department, String fromDate, String toDate) {
        return prMasterDao.getFilteredPRCount(searchValue, prNumber, projectName, department, fromDate, toDate);
    }

    @Override
    public List getListPRPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir, String statusFilter) {
        return prMasterDao.getListPRPagination(start, length, searchValue, username, orderColumn, orderDir, statusFilter);
    }

    @Override
    public int getTotalListPRCount(String username) {
        return prMasterDao.getTotalListPRCount(username);
    }

    @Override
    public int getFilteredListPRCount(String username, String searchValue) {
        return prMasterDao.getFilteredListPRCount(username, searchValue);
    }

    @Override
    public List getClosePrListPagination(int start, int length, String searchValue, String prNumber, String fromDate, String toDate, String department, String orderByField, String orderDir) {
        return prMasterDao.getClosePrListPagination(start, length, searchValue, prNumber, fromDate, toDate, department, orderByField, orderDir);
    }

    @Override
    public int getTotalClosePRCount() {
        return prMasterDao.getTotalClosePRCount();
    }

    @Override
    public int getFilteredClosePRCount(String searchValue, String prNumber, String fromDate, String toDate, String department) {
        return prMasterDao.getFilteredClosePRCount(searchValue, prNumber, fromDate, toDate, department);
    }

    @Override
    public List getPRRegisterPagination(int start, int length, String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode, String orderColumn, String orderDir) {
        return prMasterDao.getPRRegisterPagination(start, length, searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode, orderColumn, orderDir);
    }

    @Override
    public int getPRRegisterCount(String fromDate, String toDate) {
        return prMasterDao.getPRRegisterCount(fromDate, toDate);
    }

    @Override
    public int getFilteredPRRegisterCount(String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode) {
        return prMasterDao.getFilteredPRRegisterCount(searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode);
    }

    @Override
    public Object[] getTotalPRAndPOValue(String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode) {
        return prMasterDao.getTotalPRAndPOValue(searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode);
    }

    @Override
    public int getPRRegisterExcelCount(String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode){
        return prMasterDao.getPRRegisterExcelCount(searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode);
    }

    @Override
    public List getPRRegisterExcelData(int i, int totalData, String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode, String orderColumn, String orderDir){
        return prMasterDao.getPRRegisterExcelData(0, totalData, searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode, orderColumn, orderDir);
    }
@Override
    public List gettotalPrUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        return prMasterDao.gettotalPrUserPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

    }

    @Override
    public int getMonthWiseGraphCount() {
        return prMasterDao.getMonthWiseGraphCount();
    }

    @Override
    public int getFilteredMonthWiseGraphCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getFilteredMonthWiseGraphCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getunderApprovalPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getunderApprovalPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getunderApprovalCount() {
        return prMasterDao.getunderApprovalCount();
    }

    @Override
    public int getFilteredunderApprovalCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getFilteredunderApprovalCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getrejectedPrPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getrejectedPrPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getrejectedPrCount() {
        return prMasterDao.getrejectedPrCount();
    }

    @Override
    public int getFilteredrejectedPrCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getFilteredrejectedPrCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getlivePrPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getlivePrPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getlivePrCount() {
        return prMasterDao.getlivePrCount();
    }

    @Override
    public int getFilteredlivePrCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getFilteredlivePrCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List gettenderPendingToFloatPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.gettenderPendingToFloatPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int gettenderPendingToFloatCount() {
        return prMasterDao.gettenderPendingToFloatCount();
    }

    @Override
    public int getFilteredtenderPendingToFloatCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getFilteredtenderPendingToFloatCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getPendingToAssignPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getPendingToAssignPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getPendingToAssignFloatCount() {
        return prMasterDao.getPendingToAssignFloatCount();
    }

    @Override
    public int getFilteredPendingToAssignCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getFilteredPendingToAssignCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getAssginedToBuyerPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getAssginedToBuyerPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getAssginedToBuyerCount() {
        return prMasterDao.getAssginedToBuyerCount();
    }

    @Override
    public int getFilteredAssginedToBuyerCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getFilteredAssginedToBuyerCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getClosedPrPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getClosedPrPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getClosedPrCount() {
        return prMasterDao.getClosedPrCount();
    }

    @Override
    public int getFilteredClosedPrCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getFilteredClosedPrCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public List getmonthWiseListPrGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        return prMasterDao.getmonthWiseListPrGraphUserPagination(start, length, searchValue, orderColumn, orderDir, username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);

    }

    @Override
    public int getmonthWiseListPrGraphUserCount(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getmonthWiseListPrGraphUserCount(username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);
    }

    @Override
    public int getFilteredmonthWiseListPrGraphUserCount(String searchValue, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        return prMasterDao.getFilteredmonthWiseListPrGraphUserCount(searchValue, username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);
    }

    
    
}

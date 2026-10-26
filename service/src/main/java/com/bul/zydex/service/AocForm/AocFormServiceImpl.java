/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocForm;

import com.bul.zydex.dao.AocForm.AocFormDao;
import com.bul.zydex.model.AocForm;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocFormServiceImpl<T> extends GenericsServiceImpl<T> implements AocFormService<T> {

    private AocFormDao<T> aocFormDao;

    public AocFormDao<T> getAocFormDao() {
        return aocFormDao;
    }

    public void setAocFormDao(AocFormDao<T> aocFormDao) {
        this.aocFormDao = aocFormDao;
        setGenericsDAO(aocFormDao);
    }

    @Override
    public List readByUser(String username) {
        return aocFormDao.readByUser(username);
    }

    @Override
    public List approvedList(String username) {

        return aocFormDao.approvedList(username);

    }

    @Override
    public List assignedName(String username) {
        return aocFormDao.assignedName(username);
    }

    @Override
    public AocForm readByformid(int id1) {
        return aocFormDao.readByformid(id1);
    }

    @Override
    public List approvalStatus1(String username) {
        return aocFormDao.approvalStatus1(username);
    }

    @Override
    public List projectmanger(String username) {
        return aocFormDao.projectmanger(username);
    }

    @Override
    public List readByIds(String aocid) {
        return aocFormDao.readByIds(aocid);
    }

    @Override
    public List readsearch(String aocdocumentNumber, String open_from_date, String open_to_date, String username, String projectName) {
        return aocFormDao.readsearch(aocdocumentNumber, open_from_date, open_to_date, username, projectName);

    }

    @Override
    public List readaocReportList(String aocdocumentNumber, String open_from_date, String open_to_date, String projectName) {
        return aocFormDao.readaocReportList(aocdocumentNumber, open_from_date, open_to_date, projectName);
    }

    @Override
    public List flagStatus() {
        return aocFormDao.flagStatus();
    }

    @Override
    public List rights(int executive) {
        return aocFormDao.rights(executive);

    }

    @Override
    public List readByUserproject(String username) {
        return aocFormDao.readByUserproject(username);

    }

    @Override
    public List readByflagstatuszero(String username) {
        return aocFormDao.readByflagstatuszero(username);
    }

    @Override
    public List readAocForms(String Fromdate, String Todate) {
        return aocFormDao.readAocForms(Fromdate, Todate);
    }

    @Override
    public List readDeliverbleForms(String Fromdate, String Todate) {
        return aocFormDao.readDeliverbleForms(Fromdate, Todate);
    }

    @Override
    public List readsearch8(String aocdocumentNumber, String open_from_date, String open_to_date, String projectName) {
        return aocFormDao.readsearch8(aocdocumentNumber, open_from_date, open_to_date, projectName);

    }

    @Override
    public List readaocReportList8(String aocdocumentNumber, String open_from_date, String open_to_date, String projectName) {
        return aocFormDao.readaocReportList8(aocdocumentNumber, open_from_date, open_to_date, projectName);

    }

    @Override
    public List readaocExcelReportList(String aocdocumentNumber, String open_from_date, String open_to_date) {
        return aocFormDao.readaocExcelReportList(aocdocumentNumber, open_from_date, open_to_date);
    }

    @Override
    public List readaocExcelReportList8(String aocdocumentNumber, String open_from_date, String open_to_date) {
        return aocFormDao.readaocExcelReportList8(aocdocumentNumber, open_from_date, open_to_date);

    }

    @Override
    public int countAllProjectAoc() {
        return aocFormDao.countAllProjectAoc();
    }

    @Override
    public List readByMonthAoc(String from_date) {
        return aocFormDao.readByMonthAoc(from_date);
    }

    @Override
    public List readByPendingDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readByPendingDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int countAllProjectAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.countAllProjectAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByMonthAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readByMonthAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public List monthWiseListAocGraphUser(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.monthWiseListAocGraphUser(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List countAllAocDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.countAllAocDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByFlagFourDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readByFlagFourDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public List readByMonthWiseAnalytics(String from_date5) {
        return aocFormDao.readByMonthWiseAnalytics(from_date5);
    }

    @Override
    public List noOfChargerDetailsAoc(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.noOfChargerDetailsOap(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List totalChargerCapacityDetailsAoc(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.totalChargerCapacityDetailsAoc(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List totalKwRatingDetailsAoc(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.totalKwRatingDetailsAoc(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByMonthWiseEthanBurificationAoc(String from_date5) {
        return aocFormDao.readByMonthWiseEthanBurificationAoc(from_date5);
    }

    @Override
    public List readByMonthWiseEquaBurificationAoc(String from_date5) {
        return aocFormDao.readByMonthWiseEquaBurificationAoc(from_date5);
    }

    @Override
    public List readByMonthWiseHubBurificationAoc(String from_date5) {
        return aocFormDao.readByMonthWiseHubBurificationAoc(from_date5);
    }

    @Override
    public List readByMonthWiseCapexBurificationAoc(String from_date5) {
        return aocFormDao.readByMonthWiseCapexBurificationAoc(from_date5);
    }

    @Override
    public List readByrejectedAocDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readByrejectedAocDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByunfieldKOMDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readByunfieldKOMDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByprojectCoorGraphUserPendingKOM(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readByprojectCoorGraphUserPendingKOM(ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getAocCretedUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return aocFormDao.getAocCretedUserPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalAocCretedUserCount(String username) {

        return aocFormDao.getTotalAocCretedUserCount(username);

    }

    @Override
    public int getFilteredAocCretedUserCount(String username, String searchValue) {

        return aocFormDao.getFilteredAocCretedUserCount(username, searchValue);

    }

    @Override
    public List getAOCExectiveHeadPagination(int start, int length, String searchValue, int executive, String orderColumn, String orderDir) {
        return aocFormDao.getAOCExectiveHeadPagination(start, length, searchValue, executive, orderColumn, orderDir);

    }

    @Override
    public int getTotalAOCExectiveHeadCount(int executive) {
        return aocFormDao.getTotalAOCExectiveHeadCount(executive);

    }

    @Override
    public int getFilteredAOCExectiveHeadCount(int executive, String searchValue) {

        return aocFormDao.getFilteredAOCExectiveHeadCount(executive, searchValue);

    }

    @Override
    public List getassignedNamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        return aocFormDao.getassignedNamePagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalassignedNameCount(String username) {
        return aocFormDao.getTotalassignedNameCount(username);

    }

    @Override
    public int getFilteredassignedNameCount(String username, String searchValue) {
        return aocFormDao.getFilteredassignedNameCount(username, searchValue);

    }

    @Override
    public List getAocDesignTeamPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return aocFormDao.getAocDesignTeamPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalAocDesignTeamCount(String username) {
        return aocFormDao.getTotalAocDesignTeamCount(username);
    }

    @Override
    public int getFilteredAocDesignTeamCount(String username, String searchValue) {
        return aocFormDao.getFilteredAocDesignTeamCount(username, searchValue);
    }

    @Override
    public List getAocProjectmanagerPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return aocFormDao.getAocProjectmanagerPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalAocProjectmanagerCount(String username) {
        return aocFormDao.getTotalAocProjectmanagerCount(username);
    }

    @Override
    public int getFilteredAocProjectmanagerCount(String username, String searchValue) {

        return aocFormDao.getFilteredAocProjectmanagerCount(username, searchValue);
    }

    @Override
    public List getUserprojectPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return aocFormDao.getUserprojectPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalUserprojectCount(String username) {
        return aocFormDao.getTotalUserprojectCount(username);
    }

    @Override
    public int getFilteredUserprojectCount(String username, String searchValue) {
        return aocFormDao.getFilteredUserprojectCount(username, searchValue);
    }

    @Override
    public List getAocNetworkTeamPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return aocFormDao.getAocNetworkTeamPagination(start, length, searchValue, orderColumn, orderDir);

    }

    @Override
    public int getTotalAocNetworkTeamCount() {
        return aocFormDao.getTotalAocNetworkTeamCount();
    }

    @Override
    public int getFilteredAocNetworkTeamCount(String searchValue) {
        return aocFormDao.getFilteredAocNetworkTeamCount(searchValue);
    }

    @Override
    public List getAocReportPagination(int start, int length, String searchValue, String aocdocumentNumber, String projectName, String fromDate, String toDate, String orderColumn, String orderDir) {
        return aocFormDao.getAocReportPagination(start, length, searchValue, aocdocumentNumber, projectName, fromDate, toDate, orderColumn, orderDir);

    }

    @Override
    public int getTotalAocReportCount() {
        return aocFormDao.getTotalAocReportCount();
    }

    @Override
    public int getFilteredAocReportCount(String searchValue, String aocdocumentNumber, String projectName, String fromDate, String toDate) {
        return aocFormDao.getFilteredAocReportCount(searchValue, aocdocumentNumber, projectName, fromDate, toDate);
    }

    @Override
    public List getMonthWiseGraphAOCPagination(int start, int length, String searchValue, String StartDate, String EndDate, String orderColumn, String orderDir) {
        return aocFormDao.getMonthWiseGraphAOCPagination(start, length, searchValue, StartDate, EndDate, orderColumn, orderDir);
    }

    @Override
    public int getMonthWiseGraphAOCCount(String StartDate, String EndDate) {
        return aocFormDao.getMonthWiseGraphAOCCount(StartDate, EndDate);
    }

    @Override
    public int getFilteredMonthWiseGraphAOCCount(String search, String StartDate, String EndDate) {
        return aocFormDao.getFilteredMonthWiseGraphAOCCount(search, StartDate, EndDate);
    }

    @Override
    public List getProjectCoorGraphUserPendingKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        return aocFormDao.getProjectCoorGraphUserPendingKOMPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getProjectCoorGraphUserPendingKOMCount(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getProjectCoorGraphUserPendingKOMCount(ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getProjectCoorGraphUserPendingKOMCount(String searchValue, String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getProjectCoorGraphUserPendingKOMCount(searchValue, ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getProjectManagerTotalGraphUser1Pagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        return aocFormDao.getProjectManagerTotalGraphUser1Pagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getProjectManagerTotalGraphUser1Count(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getProjectManagerTotalGraphUser1Count(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getProjectManagerTotalGraphUser1Count(String searchValue, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getProjectManagerTotalGraphUser1Count(searchValue, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getAocNoOfChargerDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        return aocFormDao.getAocNoOfChargerDetailsOapPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getAocNoOfChargerDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getAocNoOfChargerDetailsOapCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredAocNoOfChargerDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getFilteredAocNoOfChargerDetailsOapCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getAocTotalChargerCapacityPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getAocTotalChargerCapacityPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getAocTotalChargerCapacityCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getAocTotalChargerCapacityCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredAocTotalChargerCapacityCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getFilteredAocTotalChargerCapacityCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getAocTotalKwRatingPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getAocTotalKwRatingPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getAocTotalKwRatingCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getAocTotalKwRatingCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredAocTotalKwRatingCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getFilteredAocTotalKwRatingCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int countAllAoc() {
        return aocFormDao.countAllAoc();
    }

    @Override
    public int countAllAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.countAllAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getTotalAocPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getTotalAocPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalAocCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getTotalAocCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredTotalAocCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getFilteredTotalAocCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByFlagFour() {
        return aocFormDao.readByFlagFour();
    }

    @Override
    public int readByFlagFourDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readByFlagFourDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getTotalApprovedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getTotalApprovedPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalApprovedAocCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getTotalApprovedAocCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredTotalApprovedAocCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getFilteredTotalApprovedAocCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readBypendingAoc() {
        return aocFormDao.readBypendingAoc();
    }

    @Override
    public int readBypendingAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readBypendingAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getTotalPendingAOCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getTotalPendingAOCPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalPendingAOCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getTotalPendingAOCCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredTotalPendingAOCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getFilteredTotalPendingAOCCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByrejectedAoc() {
        return aocFormDao.readByrejectedAoc();
    }

    @Override
    public int readByrejectedAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readByrejectedAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getRejectedAOCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getRejectedAOCPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getRejectedAOCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getRejectedAOCCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredRejectedAOCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getFilteredRejectedAOCCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByunfieldKOM() {
        return aocFormDao.readByunfieldKOM();
    }

    @Override
    public int readByunfieldKOMDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.readByunfieldKOMDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getUnfieldKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getUnfieldKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getUnfieldKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getUnfieldKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredUnfieldKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return aocFormDao.getFilteredUnfieldKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

}

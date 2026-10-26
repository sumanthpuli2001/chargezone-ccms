/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapForm;

import com.bul.zydex.dao.OapForm.OapFormDao;
import com.bul.zydex.model.OapForm;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapFormServiceImpl<T> extends GenericsServiceImpl<T> implements OapFormService<T> {

    private OapFormDao<T> oapFormDao;

    public OapFormDao<T> getOapFormDao() {
        return oapFormDao;
    }

    public void setOapFormDao(OapFormDao<T> oapFormDao) {
        this.oapFormDao = oapFormDao;
        setGenericsDAO(oapFormDao);
    }

    @Override
    public List readByIds(String id) {
        return oapFormDao.readByIds(id);

    }

    @Override
    public List readByUser(String username) {
        return oapFormDao.readByUser(username);
    }

    @Override
    public List approvedList(String username) {
        return oapFormDao.approvedList(username);
    }

    @Override
    public List assignedName(String username) {
        return oapFormDao.assignedName(username);
    }

    @Override
    public List readByusername(String username) {
        return oapFormDao.readByusername(username);

    }

    @Override
    public OapForm readByformid(int id1) {
        return oapFormDao.readByformid(id1);
    }

    @Override
    public List approvalStatus(String username) {
        return oapFormDao.approvalStatus(username);
    }

    @Override
    public OapForm ApprovalStatus() {
        return oapFormDao.ApprovalStatus();
    }

    @Override
    public List projectmanger(String username) {
        return oapFormDao.projectmanger(username);
    }

    @Override
    public List readsearch(String oapdocumentNumber, String open_from_date, String open_to_date, String username, String projectName) {
        return oapFormDao.readsearch(oapdocumentNumber, open_from_date, open_to_date, username, projectName);
    }

    @Override
    public List readoapReportList(String oapdocumentNumber, String open_from_date, String open_to_date, String projectName) {
        return oapFormDao.readoapReportList(oapdocumentNumber, open_from_date, open_to_date, projectName);
    }

    @Override
    public List readbyflagStatus() {
        return oapFormDao.readbyflagStatus();

    }

    @Override
    public List rights(int executive) {
        return oapFormDao.rights(executive);

    }

    @Override
    public List readByUserproject(String username) {
        return oapFormDao.readByUserproject(username);

    }

    @Override
    public List readalldeliview(String username) {

        return oapFormDao.readalldeliview(username);

    }

    @Override
    public List readByflagstatuszero(String username) {
        return oapFormDao.readByflagstatuszero(username);
    }

    @Override
    public List readOapForms(String Fromdate, String Todate) {
        return oapFormDao.readOapForms(Fromdate, Todate);
    }

    @Override
    public List readDeliverbleForms(String Fromdate, String Todate) {
        return oapFormDao.readDeliverbleForms(Fromdate, Todate);
    }

    @Override
    public List readsearch8(String oapdocumentNumber, String open_from_date, String open_to_date, String projectName) {
        return oapFormDao.readsearch8(oapdocumentNumber, open_from_date, open_to_date, projectName);

    }

    @Override
    public List readoapReportList8(String oapdocumentNumber, String open_from_date, String open_to_date, String projectName) {
        return oapFormDao.readoapReportList8(oapdocumentNumber, open_from_date, open_to_date, projectName);
    }

    @Override
    public List readByoapexcelReport(String oapdocumentNumber, String open_from_date, String open_to_date) {
        return oapFormDao.readByoapexcelReport(oapdocumentNumber, open_from_date, open_to_date);
    }

    @Override
    public List readByoapexcelReport1(String oapdocumentNumber, String open_from_date, String open_to_date) {
        return oapFormDao.readByoapexcelReport1(oapdocumentNumber, open_from_date, open_to_date);

    }

    @Override
    public List crcpartiallyapprove(String username) {
        return oapFormDao.crcpartiallyapprove(username);

    }

    @Override
    public int countAllProjectOap() {
        return oapFormDao.countAllProjectOap();

    }

    @Override
    public List readByMontOap(String from_date1) {
        return oapFormDao.readByMontOap(from_date1);

    }

    @Override
    public List readBypendingOapDashboadDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readBypendingOapDashboadDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int countAllProjectOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.countAllProjectOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByMontOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByMontOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List monthWiseListOapGraphUser(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        return oapFormDao.monthWiseListOapGraphUser(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public List readByAllOapDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByAllOapDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByFlagFourDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByFlagFourDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByProjectCoordinator() {
        return oapFormDao.readByProjectCoordinator();

    }

    @Override
    public List readByProjectManger() {
        return oapFormDao.readByProjectManger();
    }

    @Override
    public List readByprojectCoordinatorGraphUser(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByprojectCoordinatorGraphUser(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public List readByprojectCoordinatorGraphUser1(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByprojectCoordinatorGraphUser1(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByProjectManagerTotalGraphUser(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByProjectManagerTotalGraphUser(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByprojectCoorGraphUserPendingCRC(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByprojectCoorGraphUserPendingCRC(ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public List readByProjectManagerTotalGraphUser1(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByProjectManagerTotalGraphUser1(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByMonthWiseAnalytics(String from_date5) {

        return oapFormDao.readByMonthWiseAnalytics(from_date5);

    }

    @Override
    public List noOfChargerDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.noOfChargerDetailsOap(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public List totalChargerCapacityDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.totalChargerCapacityDetailsOap(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public List totalKwRatingDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        return oapFormDao.totalKwRatingDetailsOap(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public List readByMonthWiseEthanBurification(String from_date5) {
        return oapFormDao.readByMonthWiseEthanBurification(from_date5);
    }

    @Override
    public List readByMonthWiseEquaBurification(String from_date5) {
        return oapFormDao.readByMonthWiseEquaBurification(from_date5);
    }

    @Override
    public List readByMonthWiseHubBurification(String from_date5) {
        return oapFormDao.readByMonthWiseHubBurification(from_date5);
    }

    @Override
    public List readByMonthWiseCapexBurification(String from_date5) {
        return oapFormDao.readByMonthWiseCapexBurification(from_date5);
    }

    @Override
    public OapForm readByprojCoordAndDeliFalgOne(String ProjectCodinator, int id) {
        return oapFormDao.readByprojCoordAndDeliFalgOne(ProjectCodinator, id);

    }

    @Override
    public List oapEthanWiseClick(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String label, String count, String MonthName1) {
        return oapFormDao.oapEthanWiseClick(StartDate, EndDate, Filter, formattedDate, formattedStartDate, label, count, MonthName1);
    }

    @Override
    public List readByrejectedOapDashboadDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByrejectedOapDashboadDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByunfieldCRCDashboadDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByunfieldCRCDashboadDateformateDashBoard(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getOapCretedUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return oapFormDao.getOapCretedUserPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalOapCretedUserCount(String username) {

        return oapFormDao.getTotalOapCretedUserCount(username);

    }

    @Override
    public int getFilteredOapCretedUserCount(String username, String searchValue) {
        return oapFormDao.getFilteredOapCretedUserCount(username, searchValue);

    }

    @Override
    public List getOAPExectiveHeadPagination(int start, int length, String searchValue, int executive, String orderColumn, String orderDir) {
        return oapFormDao.getOAPExectiveHeadPagination(start, length, searchValue, executive, orderColumn, orderDir);

    }

    @Override
    public int getTotalOAPExectiveHeadCount(int executive) {
        return oapFormDao.getTotalOAPExectiveHeadCount(executive);

    }

    @Override
    public int getFilteredOAPExectiveHeadCount(int executive, String searchValue) {

        return oapFormDao.getFilteredOAPExectiveHeadCount(executive, searchValue);

    }

    @Override
    public List getassignedNamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return oapFormDao.getassignedNamePagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalassignedNameCount(String username) {

        return oapFormDao.getTotalassignedNameCount(username);

    }

    @Override
    public int getFilteredassignedNameCount(String username, String searchValue) {

        return oapFormDao.getFilteredassignedNameCount(username, searchValue);

    }

    @Override
    public List getCrcPartiallyApprovePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        return oapFormDao.getCrcPartiallyApprovePagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalCrcPartiallyApproveCount(String username) {
        return oapFormDao.getTotalCrcPartiallyApproveCount(username);
    }

    @Override
    public int getFilteredCrcPartiallyApproveCount(String username, String searchValue) {
        return oapFormDao.getFilteredCrcPartiallyApproveCount(username, searchValue);
    }

    @Override
    public List getOapDesignTeamPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        return oapFormDao.getOapDesignTeamPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalOapDesignTeamCount(String username) {
        return oapFormDao.getTotalOapDesignTeamCount(username);

    }

    @Override
    public int getFilteredOapDesignTeamCount(String username, String searchValue) {
        return oapFormDao.getFilteredOapDesignTeamCount(username, searchValue);

    }

    @Override
    public List getOapProjectmanagerPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return oapFormDao.getOapProjectmanagerPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalOapProjectmanagerCount(String username) {
        return oapFormDao.getTotalOapProjectmanagerCount(username);
    }

    @Override
    public int getFilteredOapProjectmanagerCount(String username, String searchValue) {
        return oapFormDao.getFilteredOapProjectmanagerCount(username, searchValue);
    }

    @Override
    public List getUserprojectPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return oapFormDao.getUserprojectPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalUserprojectCount(String username) {
        return oapFormDao.getTotalUserprojectCount(username);
    }

    @Override
    public int getFilteredUserprojectCount(String username, String searchValue) {
        return oapFormDao.getFilteredUserprojectCount(username, searchValue);
    }

    @Override
    public List getNetworkTeamPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return oapFormDao.getNetworkTeamPagination(start, length, searchValue, orderColumn, orderDir);

    }

    @Override
    public int getTotalNetworkTeamCount() {
        return oapFormDao.getTotalNetworkTeamCount();
    }

    @Override
    public int getFilteredNetworkTeamCount(String searchValue) {
        return oapFormDao.getFilteredNetworkTeamCount(searchValue);
    }

    @Override
    public List getOapReportPagination(int start, int length, String searchValue, String oapdocumentNumber, String projectName, String fromDate, String toDate, String orderColumn, String orderDir) {
        return oapFormDao.getOapReportPagination(start, length, searchValue, oapdocumentNumber, projectName, fromDate, toDate, orderColumn, orderDir);
    }

    @Override
    public int getTotalOapReportCount() {
        return oapFormDao.getTotalOapReportCount();
    }

    @Override
    public int getFilteredOapReportCount(String searchValue, String oapdocumentNumber, String projectName, String fromDate, String toDate) {
        return oapFormDao.getFilteredOapReportCount(searchValue, oapdocumentNumber, projectName, fromDate, toDate);
    }

    @Override
    public List getMonthWiseGraphPagination(int start, int length, String searchValue, String StartDate, String EndDate, String orderColumn, String orderDir) {
        return oapFormDao.getMonthWiseGraphPagination(start, length, searchValue, StartDate, EndDate, orderColumn, orderDir);
    }

    @Override
    public int getMonthWiseGraphCount(String StartDate, String EndDate) {
        return oapFormDao.getMonthWiseGraphCount(StartDate, EndDate);
    }

    @Override
    public int getFilteredMonthWiseGraphCount(String search, String StartDate, String EndDate) {
        return oapFormDao.getFilteredMonthWiseGraphCount(search, StartDate, EndDate);
    }

    @Override
    public List getProjectCoordinatorGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        return oapFormDao.getProjectCoordinatorGraphUserPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getProjectCoordinatorGraphUserCount(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getProjectCoordinatorGraphUserCount(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getProjectCoordinatorGraphUserCount(String searchValue, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getProjectCoordinatorGraphUserCount(searchValue, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getProjectCoordinatorGraphUser1Pagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getProjectCoordinatorGraphUser1Pagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getProjectCoordinatorGraphUser1Count(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getProjectCoordinatorGraphUser1Count(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getProjectCoordinatorGraphUser1Count(String searchValue, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getProjectCoordinatorGraphUser1Count(searchValue, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getProjectCoorGraphUserPendingCRCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        return oapFormDao.getProjectCoorGraphUserPendingCRCPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getProjectCoorGraphUserPendingCRCCount(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getProjectCoorGraphUserPendingCRCCount(ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getProjectCoorGraphUserPendingCRCCount(String searchValue, String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getProjectCoorGraphUserPendingCRCCount(searchValue, ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getProjectManagerTotalGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        return oapFormDao.getProjectManagerTotalGraphUserPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getProjectManagerTotalGraphUserCount(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getProjectManagerTotalGraphUserCount(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getProjectManagerTotalGraphUserCount(String searchValue, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getProjectManagerTotalGraphUserCount(searchValue, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getNoOfChargerDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        return oapFormDao.getNoOfChargerDetailsOapPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getNoOfChargerDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getNoOfChargerDetailsOapCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredNoOfChargerDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getFilteredNoOfChargerDetailsOapCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getTotalChargerCapacityDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getTotalChargerCapacityDetailsOapPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getTotalChargerCapacityDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getTotalChargerCapacityDetailsOapCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredTotalChargerCapacityDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getFilteredTotalChargerCapacityDetailsOapCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getTotalKwRatingDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        return oapFormDao.getTotalKwRatingDetailsOapPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int getTotalKwRatingDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getTotalKwRatingDetailsOapCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredTotalKwRatingDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getFilteredTotalKwRatingDetailsOapCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int countAllOap() {
        return oapFormDao.countAllOap();

    }

    @Override
    public int readByAllOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByAllOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getOapPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalOapCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getTotalOapCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredOapCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getFilteredOapCount(search, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByFlagFour() {
        return oapFormDao.readByFlagFour();

    }

    @Override
    public int readByFlagFourDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByFlagFourDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getApprovedOapDashboadPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getApprovedOapDashboadPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalApprovedOapDashboadCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getTotalApprovedOapDashboadCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredApprovedOapDashboadCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getFilteredApprovedOapDashboadCount(search, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readBypendingOap() {
        return oapFormDao.readBypendingOap();
    }

    @Override
    public int readBypendingOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readBypendingOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getPendingOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getPendingOapPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalPendingOapDashboadCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getTotalPendingOapDashboadCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredPendingOapDashboadCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getFilteredPendingOapDashboadCount(search, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByrejctedOap() {
        return oapFormDao.readByrejctedOap();
    }

    @Override
    public int readByrejctedOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByrejctedOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getRejectedOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getRejectedOapPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalRejectedOapDashboadCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getTotalRejectedOapDashboadCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredRejectedOapDashboadCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getFilteredRejectedOapDashboadCount(search, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByunfieldCRC() {
        return oapFormDao.readByunfieldCRC();
    }

    @Override
    public int readByunfieldCRCDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.readByunfieldCRCDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getUnfilledCrcPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getUnfilledCrcPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalUnfilledCrcCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getTotalUnfilledCrcCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredUnfilledCrcCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return oapFormDao.getFilteredUnfilledCrcCount(search, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

}

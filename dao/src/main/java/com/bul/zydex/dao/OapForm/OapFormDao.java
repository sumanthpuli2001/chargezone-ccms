/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapForm;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.OapForm;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface OapFormDao<T> extends GenericsDAO<T> {

    public List readByIds(String id);

    public List readByUser(String username);

    public List approvedList(String username);

    public List assignedName(String username);

    public List readByusername(String username);

    public OapForm readByformid(int id1);

    public List approvalStatus(String username);

    public OapForm ApprovalStatus();

    public List projectmanger(String username);

    public List readsearch(String oapdocumentNumber, String open_from_date, String open_to_date, String username, String projectName);

    public List readoapReportList(String oapdocumentNumber, String open_from_date, String open_to_date, String projectName);

    public List readbyflagStatus();

    public List rights(int executive);

    public List readByUserproject(String username);

    public List readalldeliview(String username);

    public List readByflagstatuszero(String username);

    public List readOapForms(String Fromdate, String Todate);

    public List readDeliverbleForms(String Fromdate, String Todate);

    public List readsearch8(String oapdocumentNumber, String open_from_date, String open_to_date, String projectName);

    public List readoapReportList8(String oapdocumentNumber, String open_from_date, String open_to_date, String projectName);

    public List readByoapexcelReport(String oapdocumentNumber, String open_from_date, String open_to_date);

    public List readByoapexcelReport1(String oapdocumentNumber, String open_from_date, String open_to_date);

    public List crcpartiallyapprove(String username);

    public int countAllProjectOap();

    public List readByMontOap(String from_date1);

    public int countAllProjectOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByMontOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List monthWiseListOapGraphUser(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List readByAllOapDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByFlagFourDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByProjectCoordinator();

    public List readByProjectManger();

    public List readByprojectCoordinatorGraphUser(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByprojectCoordinatorGraphUser1(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByProjectManagerTotalGraphUser(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByProjectManagerTotalGraphUser1(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByMonthWiseAnalytics(String from_date5);

    public List noOfChargerDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List totalChargerCapacityDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List totalKwRatingDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List readBypendingOapDashboadDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByprojectCoorGraphUserPendingCRC(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByMonthWiseEthanBurification(String from_date5);

    public List readByMonthWiseEquaBurification(String from_date5);

    public List readByMonthWiseHubBurification(String from_date5);

    public List readByMonthWiseCapexBurification(String from_date5);

    public OapForm readByprojCoordAndDeliFalgOne(String ProjectCodinator, int id);

    public List oapEthanWiseClick(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String label, String count, String MonthName1);

    public List readByrejectedOapDashboadDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByunfieldCRCDashboadDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getOapCretedUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalOapCretedUserCount(String username);

    public int getFilteredOapCretedUserCount(String username, String searchValue);

    public List getOAPExectiveHeadPagination(int start, int length, String searchValue, int executive, String orderColumn, String orderDir);

    public int getTotalOAPExectiveHeadCount(int executive);

    public int getFilteredOAPExectiveHeadCount(int executive, String searchValue);

    public List getassignedNamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalassignedNameCount(String username);

    public int getFilteredassignedNameCount(String username, String searchValue);

    public List getCrcPartiallyApprovePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalCrcPartiallyApproveCount(String username);

    public int getFilteredCrcPartiallyApproveCount(String username, String searchValue);

    public List getOapDesignTeamPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalOapDesignTeamCount(String username);

    public int getFilteredOapDesignTeamCount(String username, String searchValue);

    public List getOapProjectmanagerPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalOapProjectmanagerCount(String username);

    public int getFilteredOapProjectmanagerCount(String username, String searchValue);

    public List getUserprojectPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalUserprojectCount(String username);

    public int getFilteredUserprojectCount(String username, String searchValue);

    public List getNetworkTeamPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalNetworkTeamCount();

    public int getFilteredNetworkTeamCount(String searchValue);

    public List getOapReportPagination(int start, int length, String searchValue, String oapdocumentNumber, String projectName, String fromDate, String toDate, String orderColumn, String orderDir);

    public int getTotalOapReportCount();

    public int getFilteredOapReportCount(String searchValue, String oapdocumentNumber, String projectName, String fromDate, String toDate);

    public List getMonthWiseGraphPagination(int start, int length, String searchValue, String StartDate, String EndDate, String orderColumn, String orderDir);

    public int getMonthWiseGraphCount(String StartDate, String EndDate);

    public int getFilteredMonthWiseGraphCount(String search, String StartDate, String EndDate);

    public List getProjectCoordinatorGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectCoordinatorGraphUserCount(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectCoordinatorGraphUserCount(String searchValue, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getProjectCoordinatorGraphUser1Pagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectCoordinatorGraphUser1Count(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectCoordinatorGraphUser1Count(String searchValue, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getProjectCoorGraphUserPendingCRCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectCoorGraphUserPendingCRCCount(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectCoorGraphUserPendingCRCCount(String searchValue, String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getProjectManagerTotalGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectManagerTotalGraphUserCount(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectManagerTotalGraphUserCount(String searchValue, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getNoOfChargerDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getNoOfChargerDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredNoOfChargerDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List getTotalChargerCapacityDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalChargerCapacityDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredTotalChargerCapacityDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List getTotalKwRatingDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalKwRatingDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredTotalKwRatingDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int countAllOap();

    public int readByAllOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalOapCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredOapCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByFlagFour();

    public int readByFlagFourDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getApprovedOapDashboadPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalApprovedOapDashboadCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredApprovedOapDashboadCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readBypendingOap();

    public int readBypendingOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getPendingOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalPendingOapDashboadCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredPendingOapDashboadCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByrejctedOap();

    public int readByrejctedOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getRejectedOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalRejectedOapDashboadCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredRejectedOapDashboadCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByunfieldCRC();

    public int readByunfieldCRCDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getUnfilledCrcPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalUnfilledCrcCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredUnfilledCrcCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocForm;

import com.bul.zydex.model.AocForm;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface AocFormService<T> extends GenericsService<T> {

    public List readByUser(String username);

    public List approvedList(String username);

    public List assignedName(String username);

    public AocForm readByformid(int id1);

    public List approvalStatus1(String username);

    public List projectmanger(String username);

    public List readByIds(String aocid);

    public List readsearch(String aocdocumentNumber, String open_from_date, String open_to_date, String username, String projectName);

    public List readaocReportList(String aocdocumentNumber, String open_from_date, String open_to_date, String projectName);

    public List flagStatus();

    public List rights(int executive);

    public List readByUserproject(String username);

    public List readByflagstatuszero(String username);

    public List readAocForms(String Fromdate, String Todate);

    public List readDeliverbleForms(String Fromdate, String Todate);

    public List readsearch8(String aocdocumentNumber, String open_from_date, String open_to_date, String projectName);

    public List readaocReportList8(String aocdocumentNumber, String open_from_date, String open_to_date, String projectName);

    public List readaocExcelReportList(String aocdocumentNumber, String open_from_date, String open_to_date);

    public List readaocExcelReportList8(String aocdocumentNumber, String open_from_date, String open_to_date);

    public int countAllProjectAoc();

    public List readByMonthAoc(String from_date);

    public int countAllProjectAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByMonthAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List monthWiseListAocGraphUser(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List countAllAocDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByFlagFourDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByMonthWiseAnalytics(String from_date5);

    public List noOfChargerDetailsAoc(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List totalChargerCapacityDetailsAoc(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List totalKwRatingDetailsAoc(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List readByPendingDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByMonthWiseEthanBurificationAoc(String from_date5);

    public List readByMonthWiseEquaBurificationAoc(String from_date5);

    public List readByMonthWiseHubBurificationAoc(String from_date5);

    public List readByMonthWiseCapexBurificationAoc(String from_date5);

    public List readByrejectedAocDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByunfieldKOMDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByprojectCoorGraphUserPendingKOM(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getAocCretedUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalAocCretedUserCount(String username);

    public int getFilteredAocCretedUserCount(String username, String searchValue);

    public List getAOCExectiveHeadPagination(int start, int length, String searchValue, int executive, String orderColumn, String orderDir);

    public int getTotalAOCExectiveHeadCount(int executive);

    public int getFilteredAOCExectiveHeadCount(int executive, String searchValue);

    public List getassignedNamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalassignedNameCount(String username);

    public int getFilteredassignedNameCount(String username, String searchValue);

    public List getAocDesignTeamPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalAocDesignTeamCount(String username);

    public int getFilteredAocDesignTeamCount(String username, String searchValue);

    public List getAocProjectmanagerPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalAocProjectmanagerCount(String username);

    public int getFilteredAocProjectmanagerCount(String username, String searchValue);

    public List getUserprojectPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalUserprojectCount(String username);

    public int getFilteredUserprojectCount(String username, String searchValue);

    public List getAocNetworkTeamPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalAocNetworkTeamCount();

    public int getFilteredAocNetworkTeamCount(String searchValue);

    public List getAocReportPagination(int start, int length, String searchValue, String aocdocumentNumber, String projectName, String fromDate, String toDate, String orderColumn, String orderDir);

    public int getTotalAocReportCount();

    public int getFilteredAocReportCount(String searchValue, String aocdocumentNumber, String projectName, String fromDate, String toDate);

    public List getMonthWiseGraphAOCPagination(int start, int length, String searchValue, String StartDate, String EndDate, String orderColumn, String orderDir);

    public int getMonthWiseGraphAOCCount(String StartDate, String EndDate);

    public int getFilteredMonthWiseGraphAOCCount(String searchValue, String StartDate, String EndDate);

    public List getProjectCoorGraphUserPendingKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectCoorGraphUserPendingKOMCount(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectCoorGraphUserPendingKOMCount(String searchValue, String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getProjectManagerTotalGraphUser1Pagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectManagerTotalGraphUser1Count(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getProjectManagerTotalGraphUser1Count(String searchValue, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getAocNoOfChargerDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getAocNoOfChargerDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredAocNoOfChargerDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List getAocTotalChargerCapacityPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getAocTotalChargerCapacityCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredAocTotalChargerCapacityCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public List getAocTotalKwRatingPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getAocTotalKwRatingCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredAocTotalKwRatingCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate);

    public int countAllAoc();

    public int countAllAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getTotalAocPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalAocCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredTotalAocCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByFlagFour();

    public int readByFlagFourDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getTotalApprovedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalApprovedAocCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredTotalApprovedAocCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readBypendingAoc();

    public int readBypendingAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getTotalPendingAOCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalPendingAOCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredTotalPendingAOCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByrejectedAoc();

    public int readByrejectedAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getRejectedAOCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getRejectedAOCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredRejectedAOCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByunfieldKOM();

    public int readByunfieldKOMDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getUnfieldKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getUnfieldKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredUnfieldKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);
}

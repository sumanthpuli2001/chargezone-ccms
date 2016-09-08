/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.travel;

import com.bul.zydex.dao.GenericsDAO;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface TravelRequestMasterDAO<T> extends GenericsDAO<T> {

    public List<?> readTotalRequest(T object);

    public List<?> requestDetail(T object);

    public List<?> readFromManager(int object);

    public List<?> readFromAdmin(T object);

    public List<?> readFromApprover1(int object);

    public List<?> readFromApprover2(int object);

    public List<?> readOwnRequest(T object);

    public List<?> readAllTravelRequest(T object);

    public List<?> readPendingTravelRequest(T object);

    public List<?> readApproverPendingTravelRequest(T object);

    public List<?> readApprover2PendingTravelRequest(T object);

    public List<?> readTravelRequestByReportingLevel1(T object, String reportingManagerLevel1_id) throws ParseException;

    public List<?> readTravelRequestByReportingLevel2(String reportingManagerLevel2_id) throws ParseException;

    public List<?> readTravelRequestByReportingLevel3(String reportingManagerLevel3_id) throws ParseException;

    public List<?> readTravelRequestByReportingLevel4(String reportingManagerLevel4_id) throws ParseException;

    public List<?> readAllTravelRequestAdmin(T object, String maangerId);

    public List<?> readTravelEmployeePastRequest(T object);

    public List<?> readlastapprove(int TabId, String loginId);

    public List<?> readForCEO(T object);

    public List<?> readForRequestResult1(T object);

    public List<?> readExpensePendingList(T object);

    public List<?> searchTravelApproveOfEmployeeByCurrentMonthWise(T object);

    public List<?> searchTravelApproveOfEmployeeByPreviousMonthWise(T object);

    public List<?> readApprovedTravelRequest();

    public List<?> readTravelRequestForEscalation();

    public List<?> readForRequestResultForDashboard(T object);

}

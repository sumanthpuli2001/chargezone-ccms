/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.travel;

import com.bul.zydex.dao.travel.TravelRequestMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class TravelRequestMasterServiceImpl<T> extends GenericsServiceImpl<T> implements TravelRequestMasterService<T> {

    protected TravelRequestMasterDAO<T> travelRequestMasterDAO;

    public TravelRequestMasterDAO<T> getTravelRequestMasterDAO() {
        return travelRequestMasterDAO;
    }

    public void setTravelRequestMasterDAO(TravelRequestMasterDAO<T> travelRequestMasterDAO) {
        this.travelRequestMasterDAO = travelRequestMasterDAO;
        setGenericsDAO(travelRequestMasterDAO);
    }

    @Override
    public List<?> readTotalRequest(T object) {
        return travelRequestMasterDAO.readTotalRequest(object);
    }

    @Override
    public List<?> requestDetail(T object) {
        return travelRequestMasterDAO.requestDetail(object);
    }

    @Override
    public List<?> readFromManager(int object) {
        return travelRequestMasterDAO.readFromManager(object);
    }

    @Override
    public List<?> readFromAdmin(T object) {
        return travelRequestMasterDAO.readFromAdmin(object);
    }

    @Override
    public List<?> readFromApprover1(int object) {
        return travelRequestMasterDAO.readFromApprover1(object);
    }

    @Override
    public List<?> readFromApprover2(int object) {
        return travelRequestMasterDAO.readFromApprover2(object);
    }

    @Override
    public List<?> readOwnRequest(T object) {
        return travelRequestMasterDAO.readOwnRequest(object);
    }

    @Override
    public List<?> readAllTravelRequest(T object) {
        return travelRequestMasterDAO.readAllTravelRequest(object);
    }

    @Override
    public List<?> readPendingTravelRequest(T object) {
        return travelRequestMasterDAO.readPendingTravelRequest(object);
    }

    @Override
    public List<?> readApproverPendingTravelRequest(T object) {
        return travelRequestMasterDAO.readApproverPendingTravelRequest(object);
    }

    @Override
    public List<?> readApprover2PendingTravelRequest(T object) {
        return travelRequestMasterDAO.readApprover2PendingTravelRequest(object);
    }

    @Override
    public List<?> readTravelRequestByReportingLevel1(T object, String reportingManagerLevel1_id) throws ParseException {
        return travelRequestMasterDAO.readTravelRequestByReportingLevel1(object, reportingManagerLevel1_id);
    }

    @Override
    public List<?> readTravelRequestByReportingLevel2(String reportingManagerLevel2_id) throws ParseException {
        return travelRequestMasterDAO.readTravelRequestByReportingLevel2(reportingManagerLevel2_id);
    }

    @Override
    public List<?> readTravelRequestByReportingLevel3(String reportingManagerLevel3_id) throws ParseException {
        return travelRequestMasterDAO.readTravelRequestByReportingLevel3(reportingManagerLevel3_id);
    }

    @Override
    public List<?> readTravelRequestByReportingLevel4(String reportingManagerLevel4_id) throws ParseException {
        return travelRequestMasterDAO.readTravelRequestByReportingLevel4(reportingManagerLevel4_id);
    }

    @Override
    public List<?> readAllTravelRequestAdmin(T object, String maangerId) {
        return travelRequestMasterDAO.readAllTravelRequestAdmin(object, maangerId);
    }

    @Override
    public List<?> readTravelEmployeePastRequest(T object) {
        return travelRequestMasterDAO.readTravelEmployeePastRequest(object);
    }

    @Override
    public List<?> readlastapprove(int TabId, String loginId) {
        return travelRequestMasterDAO.readlastapprove(TabId, loginId);
    }

    @Override
    public List<?> readForCEO(T object) {
        return travelRequestMasterDAO.readForCEO(object);
    }

    @Override
    public List<?> readForRequestResult1(T object) {
        return travelRequestMasterDAO.readForRequestResult1(object);
    }

    @Override
    public List<?> readExpensePendingList(T object) {
        return travelRequestMasterDAO.readExpensePendingList(object);
    }

    @Override
    public List<?> searchTravelApproveOfEmployeeByCurrentMonthWise(T object) {
        return travelRequestMasterDAO.searchTravelApproveOfEmployeeByCurrentMonthWise(object);
    }

    @Override
    public List<?> searchTravelApproveOfEmployeeByPreviousMonthWise(T object) {
        return travelRequestMasterDAO.searchTravelApproveOfEmployeeByPreviousMonthWise(object);
    }

    @Override
    public List<?> readApprovedTravelRequest() {
        return travelRequestMasterDAO.readApprovedTravelRequest();
    }

    @Override
    public List<?> readTravelRequestForEscalation() {
        return travelRequestMasterDAO.readTravelRequestForEscalation();
    }

    @Override
    public List<?> readForRequestResultForDashboard(T object) {
        return travelRequestMasterDAO.readForRequestResultForDashboard(object);
    }

    @Override
    public List<?> readListForApprover(T object, int id) {
        return travelRequestMasterDAO.readListForApprover(object, id);
    }

}

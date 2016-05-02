package com.bul.zydex.service.expense;

import com.bul.zydex.dao.expense.ExpenseMasterDAO;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import com.bul.zydex.service.expense.ExpenseMasterService;
import java.text.ParseException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dhruv
 */
public class ExpenseMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ExpenseMasterService<T> {

    private ExpenseMasterDAO<T> expenseMasterDAO;

    public ExpenseMasterDAO<T> getExpenseMasterDAO() {
        return expenseMasterDAO;
    }

    public void setExpenseMasterDAO(ExpenseMasterDAO<T> expenseMasterDAO) {
        this.expenseMasterDAO = expenseMasterDAO;
        setGenericsDAO(expenseMasterDAO);
    }

    @Override
    public List<?> readByEmpId(T object) {
        return expenseMasterDAO.readByEmpId(object);
    }

    @Override
    public List<?> readByApproverId(T object) {
        return expenseMasterDAO.readByApproverId(object);
    }

    @Override
    public List<?> readByApprover1List(int appId, int tabId) {
        return expenseMasterDAO.readByApprover1List(appId, tabId);
    }

    @Override
    public List<?> readByApprover2List(int appId, int tabId) {
        return expenseMasterDAO.readByApprover2List(appId, tabId);
    }

    @Override
    public List<?> readByExpensePendingRequest(T object) {
        return expenseMasterDAO.readByExpensePendingRequest(object);
    }

    @Override
    public List<?> readByExpenseApproverPendingRequest(T object) {
        return expenseMasterDAO.readByExpenseApproverPendingRequest(object);
    }

    @Override
    public List<?> readByExpenseApprover2PendingRequest(T object) {
        return expenseMasterDAO.readByExpenseApprover2PendingRequest(object);
    }

    @Override
    public List<?> readTravelExpenseReportList() {
        return expenseMasterDAO.readTravelExpenseReportList();
    }

    @Override
    public List<?> readExpenseReportListForAdmin() {
        return expenseMasterDAO.readExpenseReportListForAdmin();
    }

    @Override
    public List<?> readExpenseRequestListForAdmin(T object) {
        return expenseMasterDAO.readExpenseRequestListForAdmin(object);
    }

    @Override
    public List<?> readExpenseRequestByReportingLevel1(T object, String object1) throws ParseException {
        return expenseMasterDAO.readExpenseRequestByReportingLevel1(object, object1);
    }

    @Override
    public List<?> readExpenseRequestByReportingLevel2(T object, String object1) throws ParseException {
        return expenseMasterDAO.readExpenseRequestByReportingLevel2(object, object1);
    }

    @Override
    public List<?> readExpenseRequestByReportingLevel3(T object, String object1) throws ParseException {
        return expenseMasterDAO.readExpenseRequestByReportingLevel3(object, object1);
    }

    @Override
    public List<?> readExpenseRequestByReportingLevel4(T object, String object1) throws ParseException {
        return expenseMasterDAO.readExpenseRequestByReportingLevel4(object, object1);
    }

    @Override
    public List<?> searchExpenseReportByEmployee(T object) {
        return expenseMasterDAO.searchExpenseReportByEmployee(object);
    }

    @Override
    public List<?> readExpenseRequestListOfSubordinates(T object, String reportingLevel_Id) {
        return expenseMasterDAO.readExpenseRequestListOfSubordinates(object, reportingLevel_Id);
    }

}

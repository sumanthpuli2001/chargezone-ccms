/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.expense;

import com.bul.zydex.service.GenericsService;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author dhruv
 */
public interface ExpenseMasterService<T> extends GenericsService<T> {

    public List<?> readByEmpId(T object);

    public List<?> readByApproverId(T object);

    public List<?> readByApprover1List(int appId, int tabId);

    public List<?> readByApprover2List(int appId, int tabId);

    public List<?> readTravelExpenseReportList();

    public List<?> readByExpensePendingRequest(T object);

    public List<?> readByExpenseApproverPendingRequest(T object);

    public List<?> readByExpenseApprover2PendingRequest(T object);

    public List<?> readExpenseReportListForAdmin();

    public List<?> readExpenseRequestListForAdmin(T object);

    public List<?> readExpenseRequestByReportingLevel1(T object, String object1) throws ParseException;

    public List<?> readExpenseRequestByReportingLevel2(T object, String object1) throws ParseException;

    public List<?> readExpenseRequestByReportingLevel3(T object, String object1) throws ParseException;

    public List<?> readExpenseRequestByReportingLevel4(T object, String object1) throws ParseException;

    public List<?> searchExpenseReportByEmployee(T object);

    public List<?> readExpenseRequestListOfSubordinates(T object, String reportingLevel_Id);

}

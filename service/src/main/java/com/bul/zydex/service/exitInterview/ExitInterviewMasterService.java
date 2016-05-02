/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.exitInterview;

import com.bul.zydex.service.GenericsService;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author dhruv
 */
public interface ExitInterviewMasterService<T> extends GenericsService<T> {

    public List<?> readExitApprovalList(int appId, int tabId);

    public List<?> readExitApproval2List(int appId, int tabId);

    public List<?> readExitReturnList(int empId);

    public List<?> readByEmployeeId(int empId);

    public List<?> readExitStatusList(T object);
    
    public List<?> readApprovedList(int empId);
    
    public List<?> readApproveList(T object);
    
    public List<?> readforHR(T object);
     
    public List<?> readExistingEmp(int empId);
     
    public List<?> reademp(T object);
     
     public List<?> readEmpIdFromTabId(int id); 
      public List<?> readlist() ;

}

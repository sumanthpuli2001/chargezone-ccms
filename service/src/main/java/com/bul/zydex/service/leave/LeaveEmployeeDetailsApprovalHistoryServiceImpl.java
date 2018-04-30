/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.leave;

import com.bul.zydex.dao.leave.LeaveEmployeeDetailDAO;
import com.bul.zydex.dao.leave.LeaveEmployeeDetailsApprovalHistoryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LeaveEmployeeDetailsApprovalHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements LeaveEmployeeDetailsApprovalHistoryService<T> {

    protected LeaveEmployeeDetailsApprovalHistoryDAO<T> leaveEmployeeDetailsApprovalHistoryDAO;

    public LeaveEmployeeDetailsApprovalHistoryDAO<T> getLeaveEmployeeDetailsApprovalHistoryDAO() {
        return leaveEmployeeDetailsApprovalHistoryDAO;
    }

    public void setLeaveEmployeeDetailsApprovalHistoryDAO(LeaveEmployeeDetailsApprovalHistoryDAO<T> leaveEmployeeDetailsApprovalHistoryDAO) {
        this.leaveEmployeeDetailsApprovalHistoryDAO = leaveEmployeeDetailsApprovalHistoryDAO;
        setGenericsDAO(leaveEmployeeDetailsApprovalHistoryDAO);
    }

    @Override
    public List<?> getByLeaveEmpDetailId(int leaveEmpId) {
        return leaveEmployeeDetailsApprovalHistoryDAO.getByLeaveEmpDetailId(leaveEmpId);
    }

  
    
    

}

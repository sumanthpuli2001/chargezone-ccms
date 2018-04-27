/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.leave;

import com.bul.zydex.dao.leave.LeaveTypeMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class LeaveTypeMasterServiceImpl<T> extends GenericsServiceImpl<T> implements LeaveTypeMasterService<T> {

    protected LeaveTypeMasterDAO<T> leaveTypeMasterDAO;

    public LeaveTypeMasterDAO<T> getLeaveTypeMasterDAO() {
        return leaveTypeMasterDAO;
    }

    public void setLeaveTypeMasterDAO(LeaveTypeMasterDAO<T> leaveTypeMasterDAO) {
        this.leaveTypeMasterDAO = leaveTypeMasterDAO;
        setGenericsDAO(leaveTypeMasterDAO);
    }

    @Override
    public List<?> readCarriedForwardLeave() {
        return leaveTypeMasterDAO.readCarriedForwardLeave();
    }
    @Override
   public List<?> readLeaveType(String type) {
        return leaveTypeMasterDAO.readLeaveType(type);
    }

    @Override
    public List<?> readLeaveTypeEditRegistration(String type) {
       return leaveTypeMasterDAO.readLeaveTypeEditRegistration(type);
    }
}

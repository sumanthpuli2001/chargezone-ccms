/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface EmployeeLeaveBalanceDAO<T> extends GenericsDAO<T> {

    public List<?> readByEmpId(T object);

    public List<?> readleaveWiseBalance(T object);

    public List<?> readByleaveTypeId(T object);

    public List<?> readByEmpIdAndLeaveTypeId(int empId, int levtyId);

    public List<?> readEmpId(int empId);

    public List<?> readByLeave(Integer empId, int leaveId);

    public boolean readByEmpeIdAndLeaveTypeId(int empid, int leaveid);
    
    public List<?> readByEmpId1(Integer id, Float empNoOfDays,Integer leaveType);
    
     public List<?> readleavebalance(int empid);
}

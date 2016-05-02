/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.leave;

import com.bul.zydex.dao.leave.LeaveEncashmentDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class LeaveEncashmentServiceImpl<T> extends GenericsServiceImpl<T> implements LeaveEncashmentService<T> {

    protected LeaveEncashmentDAO<T> leaveEncashmentDAO;

    public LeaveEncashmentDAO<T> getLeaveEncashmentDAO() {
        return leaveEncashmentDAO;
    }

    public void setLeaveEncashmentDAO(LeaveEncashmentDAO<T> leaveEncashmentDAO) {
        this.leaveEncashmentDAO = leaveEncashmentDAO;
        setGenericsDAO(leaveEncashmentDAO);
    }

    @Override
    public List<?> readByEmpId(T object) {
        return leaveEncashmentDAO.readByEmpId(object);
    }

    @Override
    public List<?> readByEmpNLeaveId(T object) {
        return leaveEncashmentDAO.readByEmpNLeaveId(object);
    }

    @Override
    public List<?> readAll() {
        return leaveEncashmentDAO.readAll();
    }

    @Override
    public List<?> readStatusByHr(T object) {
        return leaveEncashmentDAO.readStatusByHr(object);
    }
}

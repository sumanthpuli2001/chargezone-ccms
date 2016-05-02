/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.leave;

import com.bul.zydex.dao.leave.COffLeaveRequestDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class COffLeaveRequestServiceImpl<T> extends GenericsServiceImpl<T> implements COffLeaveRequestService<T> {

    protected COffLeaveRequestDAO<T> cOffLeaveRequestDAO;

    public COffLeaveRequestDAO<T> getcOffLeaveRequestDAO() {
        return cOffLeaveRequestDAO;
    }

    public void setcOffLeaveRequestDAO(COffLeaveRequestDAO<T> cOffLeaveRequestDAO) {
        this.cOffLeaveRequestDAO = cOffLeaveRequestDAO;
        setGenericsDAO(cOffLeaveRequestDAO);
    }

    @Override
    public List<?> userWiseCoffList(int id) {
        return cOffLeaveRequestDAO.userWiseCoffList(id);
    }

    @Override
    public List<?> approverWiseCoffList(int id) {
        return cOffLeaveRequestDAO.approverWiseCoffList(id);
    }

    @Override
    public List<?> userPendingRequest(int id) {
        return cOffLeaveRequestDAO.userPendingRequest(id);
    }

    @Override
    public List<?> approverWiseCoffPendingList(int id) {
        return cOffLeaveRequestDAO.approverWiseCoffPendingList(id);
    }

}

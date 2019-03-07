/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OnCall;

import com.bul.zydex.dao.OnCall.OnCallDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class OnCallServiceImpl<T> extends GenericsServiceImpl<T> implements OnCallService<T>{
    
    private OnCallDAO<T> onCallDAO; 

    public OnCallDAO<T> getOnCallDAO() {
        return onCallDAO;
    }

    public void setOnCallDAO(OnCallDAO<T> onCallDAO) {
        this.onCallDAO = onCallDAO;
        setGenericsDAO(onCallDAO);
    }

    @Override
    public List<?> userWiseOnCallList(int id) {
        return onCallDAO.userWiseOnCallList(id);
    }

    @Override
    public List<?> userReportingManager(int id) {
        return onCallDAO.userReportingManager(id);
    }

    @Override
    public List<?> approvalmanagerWiseOnCallList(int id) {
        return onCallDAO.approvalmanagerWiseOnCallList(id);
    }

    @Override
    public List<?> readOnCallRequestDateAndIdWise(String startdate, Integer id) {
        return onCallDAO.approvalmanagerWiseOnCallList(startdate,id);
    }
    
    
}

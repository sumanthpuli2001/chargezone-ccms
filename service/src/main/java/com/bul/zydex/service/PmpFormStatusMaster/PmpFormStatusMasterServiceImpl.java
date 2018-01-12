/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PmpFormStatusMaster;

import com.bul.zydex.dao.PmpFormStatusMaster.PmpFormStatusMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author BlackBull
 */
public class PmpFormStatusMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PmpFormStatusMasterService<T> {
     protected PmpFormStatusMasterDAO<T> pmpFormStatusMasterDAO;

    public PmpFormStatusMasterDAO<T> getPmpFormStatusMasterDAO() {
        return pmpFormStatusMasterDAO;
    }

    public void setPmpFormStatusMasterDAO(PmpFormStatusMasterDAO<T> pmpFormStatusMasterDAO) {
        this.pmpFormStatusMasterDAO = pmpFormStatusMasterDAO;
       setGenericsDAO(pmpFormStatusMasterDAO);
    }

    @Override
    public List<?> readByPmpformstatusStatus(String employeeId) {
         return pmpFormStatusMasterDAO.readByPmpformstatusStatus(employeeId);
    }

    @Override
    public List<?> delete1(String employeeId) {
         return pmpFormStatusMasterDAO.delete1(employeeId);
    }
    
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectManagement;

import com.bul.zydex.dao.ProjectManagement.PriorityMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class PriorityMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PriorityMasterService<T>{
    
    private PriorityMasterDAO<T> priorityMasterDAO;

    public PriorityMasterDAO<T> getPriorityMasterDAO() {
        return priorityMasterDAO;
    }

    public void setPriorityMasterDAO(PriorityMasterDAO<T> priorityMasterDAO) {
        this.priorityMasterDAO = priorityMasterDAO;
        setGenericsDAO(priorityMasterDAO);
    }

    @Override
    public List<?> readPriorityMaster() {
        return priorityMasterDAO.readPriorityMaster();
    }

    @Override
    public List<?> deletePrioretyMaster(String prioretyId) {
        return priorityMasterDAO.deletePrioretyMaster(prioretyId);
    }
    
    
}

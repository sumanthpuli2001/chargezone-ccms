/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectManagement;

import com.bul.zydex.dao.ProjectManagement.StateMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class StateMasterServiceImpl<T> extends GenericsServiceImpl<T> implements StateMasterService<T>{
    private StateMasterDAO <T> stateMasterDAO;

    public StateMasterDAO<T> getStateMasterDAO() {
        return stateMasterDAO;
    }

    public void setStateMasterDAO(StateMasterDAO<T> stateMasterDAO) {
        this.stateMasterDAO = stateMasterDAO;
        setGenericsDAO(stateMasterDAO);
    }

    @Override
    public List<?> readStateMaster() {
        return stateMasterDAO.readStateMaster();
    }
    
    
    
}

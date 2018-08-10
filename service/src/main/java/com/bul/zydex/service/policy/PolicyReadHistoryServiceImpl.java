/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.policy;

import com.bul.zydex.dao.policy.PolicyReadHistoryDAO;
import com.bul.zydex.model.PolicyReadHistory;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class PolicyReadHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements PolicyReadHistoryService<T>{

    private PolicyReadHistoryDAO<T> policyReadHistoryDAO;

    public PolicyReadHistoryDAO<T> getPolicyReadHistoryDAO() {
        return policyReadHistoryDAO;
    }

    public void setPolicyReadHistoryDAO(PolicyReadHistoryDAO<T> policyReadHistoryDAO) {
        this.policyReadHistoryDAO = policyReadHistoryDAO;
        setGenericsDAO(policyReadHistoryDAO);
    }

    @Override
    public PolicyReadHistory readByPolicyId(int id) {
        return policyReadHistoryDAO.readByPolicyId(id);
    }

    @Override
    public List<?> readPolicyId(int id) {
        return policyReadHistoryDAO.readPolicyId(id);
    }

    @Override
    public PolicyReadHistory policyReadCheck(String readerName) {
         return policyReadHistoryDAO.policyReadCheck(readerName);
    }

    @Override
    public PolicyReadHistory policyReadCheckId(int id, String readerName) {
        return policyReadHistoryDAO.policyReadCheckId(id, readerName);
    }
    
    
    
}

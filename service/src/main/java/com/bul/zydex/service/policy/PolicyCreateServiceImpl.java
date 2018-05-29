/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.policy;

import com.bul.zydex.dao.policy.PolicyCreateDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class PolicyCreateServiceImpl<T> extends GenericsServiceImpl<T> implements PolicyCreateService<T>{
    
    private PolicyCreateDAO<T> policyCreateDAO;

    public PolicyCreateDAO<T> getPolicyCreateDAO() {
        return policyCreateDAO;
    }

    public void setPolicyCreateDAO(PolicyCreateDAO<T> policyCreateDAO) {
        this.policyCreateDAO = policyCreateDAO;
        setGenericsDAO(policyCreateDAO);
    }

    @Override
    public List<?> readpolicyCreate() {
        return policyCreateDAO.readpolicyCreate();
    }

    @Override
    public List<?> deletepolicy(String id) {
        return policyCreateDAO.deletepolicy(id);
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.policy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.dao.policy.PolicyDropDownDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Rishi
 */
public class PolicyDropDownServiceImpl<T> extends GenericsServiceImpl<T> implements PolicyDropDownService<T>{
    
    private PolicyDropDownDAO<T> policyDropDownDAO;

    public PolicyDropDownDAO<T> getPolicyDropDownDAO() {
        return policyDropDownDAO;
    }

    public void setPolicyDropDownDAO(PolicyDropDownDAO<T> policyDropDownDAO) {
        this.policyDropDownDAO = policyDropDownDAO;
        setGenericsDAO(policyDropDownDAO);
    }
    
    
    
    

}

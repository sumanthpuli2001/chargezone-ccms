/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.policy;

import com.bul.zydex.dao.policy.PolicyMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author dhruv
 */
public class PolicyMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PolicyMasterService<T> {

    private PolicyMasterDAO<T> policyMasterDAO;

    public PolicyMasterDAO<T> getPolicyMasterDAO() {
        return policyMasterDAO;
    }

    public void setPolicyMasterDAO(PolicyMasterDAO<T> policyMasterDAO) {
        this.policyMasterDAO = policyMasterDAO;
        setGenericsDAO(policyMasterDAO);
    }

    @Override
    public boolean isExist(T object) {
        return policyMasterDAO.isExist(object);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PolicyReadHistory;
import java.util.List;

/**
 *
 * @author Dell-1
 */
public interface PolicyReadHistoryDAO<T> extends GenericsDAO<T>{
    
    public PolicyReadHistory readByPolicyId(int id);
    
    public List<?> readPolicyId(int id);
    
    public PolicyReadHistory policyReadCheck(String readerName);
    
}

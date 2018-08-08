/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.policy;

import com.bul.zydex.model.PolicyReadHistory;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Dell-1
 */
public interface PolicyReadHistoryService<T> extends GenericsService<T> {

    public PolicyReadHistory readByPolicyId(int id);

    public PolicyReadHistory policyReadCheck(String readerName);

    public List<?> readPolicyId(int id);

}

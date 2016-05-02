/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.travel;

import com.bul.zydex.dao.travel.PolicyDeviationForAirDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PolicyDeviationForAirServiceImpl<T> extends GenericsServiceImpl<T> implements PolicyDeviationForAirService<T> {

    protected PolicyDeviationForAirDAO<T> policyDeviationForAirDAO;

    public PolicyDeviationForAirDAO<T> getPolicyDeviationForAirDAO() {
        return policyDeviationForAirDAO;
    }

    public void setPolicyDeviationForAirDAO(PolicyDeviationForAirDAO<T> policyDeviationForAirDAO) {
        this.policyDeviationForAirDAO = policyDeviationForAirDAO;
        setGenericsDAO(policyDeviationForAirDAO);
    }

    @Override
    public List<?> readDetail(T object) {
        return policyDeviationForAirDAO.readDetail(object);
    }

    @Override
    public List<?> readlevelWise(String object) {
        return policyDeviationForAirDAO.readlevelWise(object);
    }
}

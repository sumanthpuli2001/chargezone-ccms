/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.resignation;

import com.bul.zydex.dao.resignation.FullAndFinalSettlementDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class FullAndFinalSettlementServiceImpl<T> extends GenericsServiceImpl<T> implements FullAndFinalSettlementService<T>{
    
    private FullAndFinalSettlementDAO<T> fullAndFinalSettlementDAO;

    public FullAndFinalSettlementDAO<T> getFullAndFinalSettlementDAO() {
        return fullAndFinalSettlementDAO;
    }

    public void setFullAndFinalSettlementDAO(FullAndFinalSettlementDAO<T> fullAndFinalSettlementDAO) {
        this.fullAndFinalSettlementDAO = fullAndFinalSettlementDAO;
        setGenericsDAO(fullAndFinalSettlementDAO);
    }

    @Override
    public List<?> readFAndFData() {
        return fullAndFinalSettlementDAO.readFAndFData();
    }
    
    

}

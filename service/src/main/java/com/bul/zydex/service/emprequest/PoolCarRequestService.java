/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emprequest;

import com.bul.zydex.model.PoolCarRequest;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vinita
 */
public interface PoolCarRequestService<T> extends GenericsService<T> {

//    public List<?> readByUserMasterId(T object);
    public List<?> readByrequesteeId(T object);

    public List<?> readByapproverId(T object);

    public List<?> readByEmpId(T object);

    public List<?> readSearchRequest(T object);

    public List<?> readSearchEmpRequest(T object);

    public boolean isExist(T object);

    public List<?> readByPoolCarPendingRequest(T object);

    public List<?> readByApproverWisePoolCarPendingRequest(T object);
    
    public List<?> readEmpIdFromTabId(int id);
    
    public int countByPoolCarPendingRequest(T object);
    
    public int countByApproverWisePoolCarPendingRequest(T object);


}

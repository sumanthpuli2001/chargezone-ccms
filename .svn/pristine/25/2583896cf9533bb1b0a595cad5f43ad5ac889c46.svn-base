/*
 * 
 * Author Vinita
 */
package com.bul.zydex.service.emprequest;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vinita
 */
public interface GatePassService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public List<?> readByEmpId(T object);

    public List<?> readByrequesteeId(T object);

    public List<?> readByapproverId(T object);

    public List<?> readforReturn(T object);

    public List<?> readSearchEmpRequest(T object);

    public List<?> readSearchRequest(T object);
    
    public List<?> readByGatePassPendingRequest(T object);
    
    public List<?> readByGatePassApproverPendingRequest(T object);
    
    public List<?> readEmpIdFromTabId(int id);
}

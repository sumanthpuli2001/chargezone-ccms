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
public interface CafeteriaRequestService<T> extends GenericsService<T> {

    public List<?> readByEmpId(T object);

    public List<?> readByrequesteeId(T object);

    public List<?> readByapproverId(T object);

    public List<?> readSearchEmpRequest(T object);

    public List<?> readSearchRequest(T object);

    public List<?> readByCafeTeriaPendingRequest(T object);

    public List<?> readByCafeTeriaApproverPendingRequest(T object);

    public List<?> readEmpIdFromTabId(int id);

    public int countByCafeTeriaPendingRequest(T object);
    
    public int countByCafeTeriaApproverPendingRequest(T object);
}

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
public interface HrServiceRequestService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public List<?> readByEmpId(T object);

    public List<?> readByrequesteeId(T object);

    public List<?> readSearchEmpRequest(T object);

    public List<?> readSearchRequest(T object);

    public List<?> readHrServicePendingRequest(T object);

    public List<?> readHrServiceApproverPendingRequest(T object);

    public int countHrServicePendingRequest(T object);

    public int countHrServiceApproverPendingRequest(T object);

}

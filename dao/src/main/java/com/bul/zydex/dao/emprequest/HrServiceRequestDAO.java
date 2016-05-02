 /*
 * 
 * Author Vinita
 */
package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Vinita
 */
public interface HrServiceRequestDAO<T> extends GenericsDAO<T> {

    public boolean isExist(T object);

    public List<?> readByEmpId(T object);

    public List<?> readByrequesteeId(T object);

    public List<?> readSearchEmpRequest(T object);

    public List<?> readSearchRequest(T object);

    public List<?> readHrServicePendingRequest(T object);

    public List<?> readHrServiceApproverPendingRequest(T object);

}

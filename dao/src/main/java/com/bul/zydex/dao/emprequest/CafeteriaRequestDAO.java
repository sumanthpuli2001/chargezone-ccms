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
public interface CafeteriaRequestDAO<T> extends GenericsDAO<T> {

    public List<?> readByEmpId(T object);

    public List<?> readByrequesteeId(T object);

    public List<?> readByapproverId(T object);

    public List<?> readSearchEmpRequest(T object);

    public List<?> readSearchRequest(T object);

    public List<?> readByCafeTeriaPendingRequest(T object);

    public List<?> readByCafeTeriaApproverPendingRequest(T object);
    
    public List<?> readEmpIdFromTabId(int id);

}

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.nodue;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author dhruv
 */
public interface NoDueMasterDAO<T> extends GenericsDAO<T> {

    public List<?> readNoDueApprovalList();

    public List<?> readApprovedList(int id);

    public List<?> readNoDueReturnList(int id);

    public List<?> readNoDueStatusList(T object);
    
    public List<?> readExistingemployee(int id);
 
    public List<?> readforemp(T object);
  
    public List<?> readSearchRequest(T object);
   
    public List<?> readEmpIdFromTabId(int id);
    
    public List<?> getNoDueByEmpId(final int empId);
    
}

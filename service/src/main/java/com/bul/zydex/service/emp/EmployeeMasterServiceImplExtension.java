
package com.bul.zydex.service.emp;

import com.bul.zydex.dao.emp.EmployeeMasterDAO;
import com.bul.zydex.dao.emp.EmployeeMasterExtensionDAO;
import com.bul.zydex.model.EmployeeAdvanceSearch;
import com.bul.zydex.model.EmployeeInformation;
import com.bul.zydex.model.EmployeeMasterExtension;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

public class EmployeeMasterServiceImplExtension<T> extends GenericsServiceImpl<T>
        implements EmployeeMasterServiceExtension<T>
{

    private EmployeeMasterExtensionDAO<T> employeeMasterExtensionDAO;

    public EmployeeMasterExtensionDAO<T> getEmployeeMasterExtensionDAO() {
        return employeeMasterExtensionDAO;
    }

    public void setEmployeeMasterExtensionDAO(EmployeeMasterExtensionDAO<T> employeeMasterExtensionDAO) {
        this.employeeMasterExtensionDAO = employeeMasterExtensionDAO;
        setGenericsDAO(employeeMasterExtensionDAO);
    }

    @Override
    public List<?> readByemployeeId(Integer id) {
         return employeeMasterExtensionDAO.readByemployeeId(id);
    }

    @Override
    public void deleteByemployeeId(int id) {
        employeeMasterExtensionDAO.deleteByemployeeId(id);
    }

   
  
}

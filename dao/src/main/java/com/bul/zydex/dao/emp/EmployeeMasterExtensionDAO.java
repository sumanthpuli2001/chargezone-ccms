
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

public interface EmployeeMasterExtensionDAO<T> extends GenericsDAO<T>
{
     public List<?> readByemployeeId(Integer id);

    public void deleteByemployeeId(int id);

//    public List<?> readByemployeeIdForExcel(Integer id);
}

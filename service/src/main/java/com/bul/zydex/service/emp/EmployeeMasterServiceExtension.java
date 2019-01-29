package com.bul.zydex.service.emp;


import com.bul.zydex.model.EmployeeMasterExtension;
import com.bul.zydex.service.GenericsService;
import java.util.List;


public interface EmployeeMasterServiceExtension<T> extends GenericsService<T>
{

    public List<?> readByemployeeId(Integer id);

    public void deleteByemployeeId(int id);

//   public List<?> readByemployeeIdForExcel(Integer id);

    
   
}

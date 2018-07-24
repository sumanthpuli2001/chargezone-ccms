/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.PayrollESIC;

import com.bul.zydex.dao.PayrollESIC.ESICMasterDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class ESICMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ESICMasterService<T>{
    
     private ESICMasterDAO<T> eSICMasterDAO;

    public ESICMasterDAO<T> geteSICMasterDAO() {
        return eSICMasterDAO;
    }

    public void seteSICMasterDAO(ESICMasterDAO<T> eSICMasterDAO) {
        this.eSICMasterDAO = eSICMasterDAO;
        setGenericsDAO(eSICMasterDAO);
    }

    @Override
    public boolean isExist(T object) {
         return eSICMasterDAO.isExist(object);
    }

    @Override
    public List<?> readEsic() {
        return eSICMasterDAO.readEsic();
    }

    @Override
    public List<?> esicChalanSearch(EmployeeMaster object) {
         return eSICMasterDAO.esicChalanSearch(object);
    }

    @Override
    public List<?> esicChalanemCount(EmployeeMaster object) {
          return eSICMasterDAO.esicChalanemCount(object);
    }
     
     

}

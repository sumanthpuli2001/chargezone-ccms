 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.empreferral;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Irfan
 */
public interface EmployeeReferralDAO<T> extends GenericsDAO<T> {

    public boolean isExist(T object);

    public List<?> readEmpForReferral(T object);

    public int updateEmployeeReferralById(final T object);
    
    public List<?> getReportingManagerOfEmpRefAdmin();
    
    public List<?> checkPositionReferd(final T object);
    
     public List<?> finalApproveByHrHead();
     
      public List<?> finalApproveList(T object);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollPfCheck;
import java.util.List;

/**
 *
 * @author Nishant
 */
public class PayrollPfCheckDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollPfCheckDAO<T>{

    @Override
    protected Class getDomainClass() {
      return PayrollPfCheck.class;
    }

    @Override
    public boolean readForPfCheck(int empTypeId, int empSubTypeId) {
     
       String query=""
                + " From PayrollPfCheck a"
                + " where a.employeeTypeMaster.id="+empTypeId
                + " and a.employeeSubType.id="+empSubTypeId
                + " and a.pfCheck=1";
        
       List<?> list = getHibernateTemplate().find(query);
       boolean ptFlag = false;
       if(!list.isEmpty()){
           ptFlag= true;
       }
     return ptFlag;   
    }

    @Override
    public boolean isExistPF(int empTypeId, int empSubTypeId) {
      boolean flag = false;
        String query = ""
                + " From PayrollPfCheck a"
                + " where a.employeeTypeMaster.id=" + empTypeId
                + " and a.employeeSubType.id=" + empSubTypeId;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public int getPFId(int empTypeId, int empSubTypeId) {
      int pfId = 0;
        String query = "Select a.id"
                + " From PayrollPfCheck a"
                + " where a.employeeTypeMaster.id=" + empTypeId
                + " and a.employeeSubType.id=" + empSubTypeId;

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            pfId = (int) list.get(0);
        }
        return pfId;
    }

    @Override
    public Boolean getPFCheckValue(int empTypeId, int empSubTypeId) {
       Boolean boolPF = false;
        String query = "Select a.pfCheck"
                + " From PayrollPfCheck a"
                + " where a.employeeTypeMaster.id=" + empTypeId
                + " and a.employeeSubType.id=" + empSubTypeId;

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            boolPF = (Boolean) list.get(0);
        }
        return boolPF;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollPtCheck;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollPtCheckDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollPtCheckDAO<T>{

    @Override
    protected Class getDomainClass() {
         return PayrollPtCheck.class;
    }

    @Override
    public boolean readForPTCheck(int empTypeId, int empSubTypeId) {
       String query=""
                + " From PayrollPtCheck a"
                + " where a.employeeTypeMaster.id="+empTypeId
                + " and a.employeeSubType.id="+empSubTypeId
                + " and a.ptCheck=1";
        
       List<?> list = getHibernateTemplate().find(query);
       boolean ptFlag = false;
       if(!list.isEmpty()){
           ptFlag= true;
       }
     return ptFlag;   
    }

    @Override
    public boolean isExistPT(int empTypeId, int empSubTypeId) {
    String query = ""
                + " From PayrollPtCheck a"
                + " where a.employeeTypeMaster.id=" + empTypeId
                + " and a.employeeSubType.id=" + empSubTypeId;

        List<?> list = getHibernateTemplate().find(query);
        boolean flag = false;
        if (!list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public int getPTId(int empTypeId, int empSubTypeId) {
        int ptId = 0;
        String query = "Select a.id"
                + " From PayrollPtCheck a"
                + " where a.employeeTypeMaster.id=" + empTypeId
                + " and a.employeeSubType.id=" + empSubTypeId;

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            ptId = (int) list.get(0);
        }
        return ptId;
    }

    @Override
    public Boolean getPTCheckValue(int empTypeId, int empSubTypeId) {
        Boolean boolPT = false;
        String query = "Select a.ptCheck"
                + " From PayrollPtCheck a"
                + " where a.employeeTypeMaster.id=" + empTypeId
                + " and a.employeeSubType.id=" + empSubTypeId;

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            boolPT = (Boolean) list.get(0);
        }
        return boolPT;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.PayrollESIC;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ESICMaster;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class ESICMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ESICMasterDAO<T>{

    @Override
    protected Class getDomainClass() {
        return ESICMaster.class;
    }

    @Override
    public boolean isExist(T object) {
           boolean flag = false;
        ESICMaster eSICMaster = (ESICMaster) object;
        List list = getHibernateTemplate().find("from ESICMaster where bankName='" + eSICMaster.getBankName() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<?> readEsic() {
        String query = "";
        query = " Select a.id,a.bankName,a.companyName,a.address,a.employeeCodeNo "
                + " FROM ESICMaster a ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> esicChalanSearch(EmployeeMaster object) {
            String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }

        query += " Select c.employeeId, c.employeeName,b.grossTotal,a.empContrubtion,a.compContrubtion,c.esicNo,b.month,b.year"
                + " From PayrollEsicDeduction a"
                + " left join a.employeeSalaryProcess b"
                + " left join b.employeeMaster c"
                + " where 1=1 " + condition;

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> esicChalanemCount(EmployeeMaster object) {
                   String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }

        query += " Select count(b.employeeMaster.id)"
                + " From PayrollEsicDeduction a"
                + " left join a.employeeSalaryProcess b"
                + " left join b.employeeMaster c"
                + " where 1=1 " + condition;

        return getHibernateTemplate().find(query);

    }

}

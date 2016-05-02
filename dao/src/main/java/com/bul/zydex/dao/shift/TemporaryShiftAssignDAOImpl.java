/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TempShiftAssignMaster;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class TemporaryShiftAssignDAOImpl<T> extends GenericsDAOImpl<T> implements TemporaryShiftAssignDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TempShiftAssignMaster.class;
    }

    @Override
    public List<?> temporaryShiftAssignResult() {
        String query = "";

        query += " SELECT b.employeeName,c.shiftName,a.startDate,a.endDate,a.id"
                + " FROM TempShiftAssignMaster a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.shiftMaster c";

        return getHibernateTemplate().find(query);
    }

    @Override
    public T temporaryShiftAssignResultByDaysWise(T object) {
        TempShiftAssignMaster tempShiftAssignMaster = (TempShiftAssignMaster)object;
        Date date = new Date();
        Format formatter = new SimpleDateFormat("dd/MM/YYYY");
        String s = formatter.format(date);
        String query = "";
        query += " FROM TempShiftAssignMaster a"
                + " Where (STR_TO_DATE('" + s + "','%d/%m/%Y') BETWEEN STR_TO_DATE(a.startDate,'%d/%m/%Y') AND STR_TO_DATE(a.endDate,'%d/%m/%Y'))"
                + " AND a.employeeMaster.id=" + tempShiftAssignMaster.getEmployeeMaster().getId();
        List<?> list = getHibernateTemplate().find(query);
        if(!list.isEmpty()){
          tempShiftAssignMaster = (TempShiftAssignMaster) list.get(0);
        }else{
            tempShiftAssignMaster=null;
        }
        return (T) tempShiftAssignMaster;
    }

}

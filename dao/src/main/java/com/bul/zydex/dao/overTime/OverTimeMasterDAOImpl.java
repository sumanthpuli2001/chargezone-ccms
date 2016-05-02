/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.overTime;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OverTimeMaster;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class OverTimeMasterDAOImpl<T> extends GenericsDAOImpl<T> implements OverTimeMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return OverTimeMaster.class;
    }

    @Override
    public List<?> overTimeComparision(int id,String overTimeDate) {
        String query = "";
        query += " SELECT a.time"
                + " FROM OverTimeMaster a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN b.userMaster c"
                + " Where c.id="+id 
                + " and STR_TO_DATE(a.date,'%d/%m/%Y')=STR_TO_DATE('"+overTimeDate+"','%d/%m/%Y')";

        return getHibernateTemplate().find(query);  
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.log;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LogsMaster;
import java.util.List;

/**
 *
 * @author aman.bahukhandi
 */
public class LogDaoImpl<T> extends GenericsDAOImpl<T> implements LogDao<T> {

    @Override
    protected Class getDomainClass() {
        return LogsMaster.class;
    }

    @Override
    public List readLogs(String dFrom, String eFrom) {

        String query = "";
        query = " select a "
                + " from LogsMaster a "
                + " where (STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))"
                + " order by a.srNoValue desc";

        return getHibernateTemplate().find(query);
    }

}

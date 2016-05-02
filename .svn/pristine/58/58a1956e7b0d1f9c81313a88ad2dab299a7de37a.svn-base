/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.attendanceRegularization;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class TimeAttandanceFlaxibleMasterDAOImpl<T> extends GenericsDAOImpl<T> implements TimeAttandanceFlaxibleMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TimeAttandanceFlaxibleMaster.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = (TimeAttandanceFlaxibleMaster) object;
        List list = getHibernateTemplate().find("from TimeAttandanceFlaxibleMaster a where a.zydexLocationMaster=" + timeAttandanceFlaxibleMaster.getZydexLocationMaster().getId());
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<?> readFlexibleTimeList() {

        String query = "";
        query += " Select a.id, b.zydexLocation, a.earlyFlexibleTime, a.lateFlexibleTime"
                + " From TimeAttandanceFlaxibleMaster a "
                + " left join a.zydexLocationMaster b";
        return getHibernateTemplate().find(query);
    }
}

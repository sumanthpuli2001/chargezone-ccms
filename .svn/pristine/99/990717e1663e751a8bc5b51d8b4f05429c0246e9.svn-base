/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.COffLeaveRequest;
import java.util.List;

/**
 *
 * @author Dhaval Patel <dhaval217@gmail.com>
 */
public class COffLeaveMasterDAOImpl<T> extends GenericsDAOImpl<T> implements COffLeaveMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return COffLeaveMaster.class;
    }
    
        @Override
    public boolean isExist(T object) {
        COffLeaveMaster cOffLeaveMaster = (COffLeaveMaster) object;
        boolean flag = true;
        String query = "";

        query += " FROM COffLeaveMaster a"
                + " WHERE a.zydexLocationMaster.id = " + cOffLeaveMaster.getZydexLocationMaster().getId();

        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            flag = false;
        }
        return flag;
    }

    @Override
    public List<?> readByDept(T object) {
         COffLeaveMaster cOffLeaveMaster = (COffLeaveMaster) object;
        String query = "";

        query += " FROM COffLeaveMaster a"
                + " WHERE a.zydexLocationMaster.id = " +cOffLeaveMaster.getZydexLocationMaster().getId();

        return getHibernateTemplate().find(query);
    }

}

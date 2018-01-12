/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Position;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PositionReferMaster;
import java.util.List;

/**
 *
 * @author Irfan
 */
public class PositionReferMasterDAOImpl<T> extends GenericsDAOImpl<T> implements PositionReferMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PositionReferMaster.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        PositionReferMaster positionReferMaster = (PositionReferMaster) object;
        List<?> list = getHibernateTemplate().find("from PositionReferMaster  where positionName ='" + positionReferMaster.getPositionName() + "' AND positionCode ='" + positionReferMaster.getPositionCode() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<?> readPositionData() {
        String Query = "from PositionReferMaster  where status =0";
        return getHibernateTemplate().find(Query);
    }

}

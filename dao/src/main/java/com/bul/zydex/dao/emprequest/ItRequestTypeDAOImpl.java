/*
 * 
 * Author Vinita
 */

package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ItRequestType;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class ItRequestTypeDAOImpl<T> extends GenericsDAOImpl<T> implements ItRequestTypeDAO<T>{

    @Override
    protected Class getDomainClass() {
        return ItRequestType.class;
    }

    @Override
       public boolean isExist(T object) {
      ItRequestType itRequestType =(ItRequestType) object;
        String query = "";

        query += ""
                + " FROM ItRequestType a"
                + " WHERE a.text = '" + itRequestType.getText() + "'";

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;

    }
}

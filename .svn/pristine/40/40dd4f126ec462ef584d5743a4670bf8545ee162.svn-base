
package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.QueryType;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class QueryTypeDAOImpl<T> extends GenericsDAOImpl<T> implements QueryTypeDAO<T>{

    @Override
    protected Class getDomainClass() {
        return QueryType.class;
    }

    @Override
      public boolean isExist(T object) {
         QueryType queryType = (QueryType) object;
        String query = "";

        query += ""
                + " FROM QueryType a"
                + " WHERE a.text = '" + queryType.getText() + "'";

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;

    }
    
}

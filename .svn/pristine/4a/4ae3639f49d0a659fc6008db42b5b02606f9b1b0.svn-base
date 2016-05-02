/*
 * 
 * Author Vinita
 */

package com.bul.zydex.service.emprequest;

import com.bul.zydex.dao.emprequest.QueryTypeDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Vinita
 */
public class QueryTypeServiceImpl<T> extends GenericsServiceImpl<T> implements QueryTypeService<T>{
    
    private QueryTypeDAO queryTypeDAO;

    public QueryTypeDAO getQueryTypeDAO() {
        return queryTypeDAO;
    }

    public void setQueryTypeDAO(QueryTypeDAO queryTypeDAO) {
        this.queryTypeDAO = queryTypeDAO;
        setGenericsDAO(queryTypeDAO);
    }

    @Override
    public boolean isExist(T object) {
        return queryTypeDAO.isExist(object);
    }
    
    

}

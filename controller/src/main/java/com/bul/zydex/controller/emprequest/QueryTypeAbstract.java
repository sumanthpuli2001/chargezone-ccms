/*
 * 
 * Author Vinita
 */

package com.bul.zydex.controller.emprequest;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.QueryType;
import com.bul.zydex.service.emprequest.QueryTypeService;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public abstract class QueryTypeAbstract extends CustomAbstract{
    
    public QueryTypeService<QueryType> queryTypeService;
    public Validator queryTypeValidator;

    public QueryTypeService<QueryType> getQueryTypeService() {
        return queryTypeService;
    }

    public void setQueryTypeService(QueryTypeService<QueryType> queryTypeService) {
        this.queryTypeService = queryTypeService;
    }

    public Validator getQueryTypeValidator() {
        return queryTypeValidator;
    }

    public void setQueryTypeValidator(Validator queryTypeValidator) {
        this.queryTypeValidator = queryTypeValidator;
    }


    
}

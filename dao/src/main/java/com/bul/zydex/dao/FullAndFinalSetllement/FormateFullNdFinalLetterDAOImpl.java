/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.FullAndFinalSetllement;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.FormateFullNdFinalLetter;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class FormateFullNdFinalLetterDAOImpl<T> extends GenericsDAOImpl<T> implements FormateFullNdFinalLetterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return FormateFullNdFinalLetter.class;
    }

    @Override
    public List<?> fetchFnFDate() {
        
        String query = "SELECT a"
                + " FROM FormateFullNdFinalLetter a";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}

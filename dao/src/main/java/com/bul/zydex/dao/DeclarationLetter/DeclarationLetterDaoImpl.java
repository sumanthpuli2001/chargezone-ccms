/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DeclarationLetter;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DeclarationLetter;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Admin
 */
public class DeclarationLetterDaoImpl<T> extends GenericsDAOImpl<T> implements DeclarationLetterDao<T> {
    
     @Override
    protected Class getDomainClass() {
        return DeclarationLetter.class;
    }
    @Override
     public DeclarationLetter getSingle() {
        String hql = "FROM DeclarationLetter";
        Query query = getSession().createQuery(hql);
        query.setMaxResults(1);
        List result = query.list();
        return result.isEmpty() ? null : (DeclarationLetter) result.get(0);
    }
}

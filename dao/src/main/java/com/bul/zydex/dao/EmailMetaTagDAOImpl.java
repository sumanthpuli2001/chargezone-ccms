/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.EmailMetaTag;

/**
 *
 * @author Aman
 */
public class EmailMetaTagDAOImpl<T> extends GenericsDAOImpl<T> implements EmailMetaTagDAO<T>{

    @Override
    protected Class getDomainClass() {
        return EmailMetaTag.class;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmailTemplate;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class EmailTemplateDaoImpl<T> extends GenericsDAOImpl<T> implements EmailTemplateDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return EmailTemplate.class;
    }
}

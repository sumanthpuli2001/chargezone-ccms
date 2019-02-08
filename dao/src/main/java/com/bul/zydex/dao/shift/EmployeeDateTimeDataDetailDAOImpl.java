/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeDateTimeDataDetail;

/**
 *
 * @author Teja
 */
public class EmployeeDateTimeDataDetailDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeDateTimeDataDetailDAO<T> 
{

    @Override
    protected Class getDomainClass() {
        return EmployeeDateTimeDataDetail.class;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.CurrencyMaster;
import com.bul.zydex.model.TravelRequestMaster;
import java.util.List;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 *
 * @author AJAY
 */
public class CurrencyMasterDAOImpl<T> extends GenericsDAOImpl<T> implements CurrencyMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CurrencyMaster.class;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.mobileapp;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeePunchForMobileApp;

/**
 *
 * @author admin
 */
public class EmployeePunchForMobileAppDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeePunchForMobileAppDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeePunchForMobileApp.class;
    }

}

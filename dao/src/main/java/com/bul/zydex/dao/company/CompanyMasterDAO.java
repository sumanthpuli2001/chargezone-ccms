/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.company;

import com.bul.zydex.dao.GenericsDAO;

/**
 *
 * @author OptiPlex
 */
public interface CompanyMasterDAO<T> extends GenericsDAO<T> {

    public boolean isExist(T object);
}

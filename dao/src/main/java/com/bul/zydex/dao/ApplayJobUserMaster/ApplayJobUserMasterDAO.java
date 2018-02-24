/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ApplayJobUserMaster;

import com.bul.zydex.dao.GenericsDAO;

/**
 *
 * @author Vikas
 */
public interface ApplayJobUserMasterDAO<T> extends GenericsDAO<T>{
    
    public boolean isExist(T object);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;


import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRClassification;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public interface PRClassificationDao<T> extends GenericsDAO<T> {

    public List readByGroup();
    
}

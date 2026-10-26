/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;


/**
 *
 * @author admin
 */
public interface MultipleAddressDao<T> extends GenericsDAO<T> {

    public List readByPrNumber(String prNo);

   
    
}

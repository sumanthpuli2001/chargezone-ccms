/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.TermsCondition;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface VendorTermsConditionDao<T> extends GenericsDAO<T> {

    public List readByRef(String ref, String username);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRDoc;
import java.util.List;

/**
 *
 * @author Bulwark-5
 */
public interface PRDocDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String ref_no);

    public void updatePRNo(String refNo1, String refNo);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRNo;
import com.bul.zydex.model.TenderNo;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PRNoDao<T> extends GenericsDAO<T> {

    public PRNo readByPrNo();

   
 
    
}

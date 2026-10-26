/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRNoTemp;
import com.bul.zydex.model.TenderNo;
import com.bul.zydex.model.TenderNoTemp;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PRNoTempDao<T> extends GenericsDAO<T> {

    public PRNoTemp readLastRecord();

    public PRNoTemp readByPRNo();

   

   
    
}

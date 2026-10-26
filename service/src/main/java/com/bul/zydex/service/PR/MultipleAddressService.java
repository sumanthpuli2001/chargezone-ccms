/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.model.PRMaster;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;


/**
 *
 * @author admin
 */
public interface MultipleAddressService<T> extends GenericsService<T> {

    public List readByPrNumber(String prNo);

 

    

   
    
}

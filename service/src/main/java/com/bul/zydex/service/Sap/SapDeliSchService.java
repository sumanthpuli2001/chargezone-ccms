/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Sap;

import com.bul.zydex.model.SapDeliSch;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface SapDeliSchService<T> extends GenericsService<T> {

    public List readData(String refNo, String pur_no, String item_no);

    public void deleteRefNo(String item_code);
    
}

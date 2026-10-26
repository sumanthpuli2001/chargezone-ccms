/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.LastWorkExpDeatils;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface LastWorkExpDeatilsService<T> extends GenericsService<T> {

    public List readByVendorinvitId(int i10);
    
    public List readByAllData(String vInfoId, String compName, String contPerson, String mobNo, String emaile, String designatione, String storedFileName);

    public List readByFileNameData(int lwId, String vInfoId, String storedFileName);

}

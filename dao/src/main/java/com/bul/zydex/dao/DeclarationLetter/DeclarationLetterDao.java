/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DeclarationLetter;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.DeclarationLetter;

/**
 *
 * @author Admin
 */
public interface DeclarationLetterDao<T> extends GenericsDAO<T> {

    public DeclarationLetter getSingle();
    
}

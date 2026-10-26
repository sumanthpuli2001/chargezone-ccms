/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DeclarationLetter;

import com.bul.zydex.model.DeclarationLetter;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Admin
 */
public interface DeclarationLetterService<T> extends GenericsService<T> {

    public DeclarationLetter getSingle();
    
}

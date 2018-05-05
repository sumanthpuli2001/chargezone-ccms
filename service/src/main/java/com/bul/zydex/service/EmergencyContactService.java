/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.model.EmergencyContact;

/**
 *
 * @author DELL3
 */
public interface EmergencyContactService<T> extends GenericsService<T> {

    public EmergencyContact readEmergencyContact();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.EmergencyContact;

/**
 *
 * @author DELL3
 */
public interface EmergencyContactDAO<T> extends GenericsDAO<T> {

    public EmergencyContact readEmergencyContact();
    
}

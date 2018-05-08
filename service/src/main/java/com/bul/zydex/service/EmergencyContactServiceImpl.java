/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.EmergencyContactDAO;
import com.bul.zydex.model.EmergencyContact;

/**
 *
 * @author DELL3
 */
public class EmergencyContactServiceImpl<T> extends GenericsServiceImpl<T> implements EmergencyContactService<T> {
    
    protected EmergencyContactDAO<T> emergencyContactDAO;

    public EmergencyContactDAO<T> getEmergencyContactDAO() {
        return emergencyContactDAO;
    }

    public void setEmergencyContactDAO(EmergencyContactDAO<T> emergencyContactDAO) {
        this.emergencyContactDAO = emergencyContactDAO;
        setGenericsDAO(emergencyContactDAO);
    }

    @Override
    public EmergencyContact readEmergencyContact() {
        return emergencyContactDAO.readEmergencyContact();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.EmergencyContact;
import com.bul.zydex.service.EmergencyContactService;

/**
 *
 * @author DELL3O
 */
public class EmergencyContactAbstract extends CustomAbstract {
    
    protected EmergencyContactService<EmergencyContact> emergencyContactService;

    public EmergencyContactService<EmergencyContact> getEmergencyContactService() {
        return emergencyContactService;
    }

    public void setEmergencyContactService(EmergencyContactService<EmergencyContact> emergencyContactService) {
        this.emergencyContactService = emergencyContactService;
    }
    
}

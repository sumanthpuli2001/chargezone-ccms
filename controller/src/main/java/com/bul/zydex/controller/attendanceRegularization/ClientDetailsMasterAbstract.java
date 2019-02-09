/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.attendanceRegularization;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ClientDetailsMaster;
import com.bul.zydex.service.attendanceRegularization.ClientDetailsMasterService;

/**
 *
 * @author Teja
 */
public class ClientDetailsMasterAbstract extends CustomAbstract
{
    protected ClientDetailsMasterService<ClientDetailsMaster> clientDetailsMasterService;

    public ClientDetailsMasterService<ClientDetailsMaster> getClientDetailsMasterService() {
        return clientDetailsMasterService;
    }

    public void setClientDetailsMasterService(ClientDetailsMasterService<ClientDetailsMaster> clientDetailsMasterService) {
        this.clientDetailsMasterService = clientDetailsMasterService;
    }
     
}

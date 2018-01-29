/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.OddPunch;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.service.shift.EmployeeDatetimeDataService;

/**
 *
 * @author Dell-1
 */
public class OddPunchAbstract extends CustomAbstract {

    protected EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService;

    public EmployeeDatetimeDataService<EmployeeDatetimeData> getEmployeeDatetimeDataService() {
        return employeeDatetimeDataService;
    }

    public void setEmployeeDatetimeDataService(EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService) {
        this.employeeDatetimeDataService = employeeDatetimeDataService;
    }

}

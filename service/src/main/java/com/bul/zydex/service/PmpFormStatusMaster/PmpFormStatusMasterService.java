/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PmpFormStatusMaster;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author BlackBull
 */
public interface PmpFormStatusMasterService<T> extends GenericsService<T> {

    public List<?> readByPmpformstatusStatus(String employeeId);

    public List<?> delete1(String employeeId);
}

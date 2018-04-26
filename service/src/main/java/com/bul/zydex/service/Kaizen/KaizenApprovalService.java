/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Kaizen;

import com.bul.zydex.model.KaizenApproval;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Aman
 */
public interface KaizenApprovalService<T> extends GenericsService<T>{

    public KaizenApproval readByIdAndEmp(int id, int empId);
    
}

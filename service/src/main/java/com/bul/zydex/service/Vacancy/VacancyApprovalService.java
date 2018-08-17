/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vacancy;

import com.bul.zydex.model.VacancyApproval;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Dell-1
 */
public interface VacancyApprovalService<T> extends GenericsService<T>{
    
    public VacancyApproval readEmpIdAndVaId(int empid, int id);
    
}

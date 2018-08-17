/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vacancy;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VacancyApproval;

/**
 *
 * @author Dell-1
 */
public interface VacancyApprovalDAO<T> extends GenericsDAO<T>{
    
    public VacancyApproval readEmpIdAndVaId(int empid, int id);
    
}
